package nbcu.framework.runner;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.Status;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import nbcu.framework.utils.encryption.PasswordEncryption;
import nbcu.framework.utils.propertyfilereader.ConfigFileReader;
import nbcu.framework.utils.report.ReportGenerate;


@CucumberOptions(features = { "src/test/resources/features" }, glue = { "nbcu.automation.ui.stepdefs",
		"nbcu.framework.hooks","nbcu.automation.hooks" }, tags = "@E2EF", plugin = { "pretty", 
				"json:target/cucumber-reports/Cucumber.json",
				
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true, publish = false)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
	public static String NCXJWT_TOKEN = null;

	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@BeforeTest
	public void initializeReport() throws Exception {
		ReportGenerate.getReportObject();
		if(ConfigFileReader.getProperty("Application-Type").equalsIgnoreCase("API")) {
		getJwtToken();
		}
	}

	@AfterTest
	public void reportFinish() {
		ReportGenerate.test.log(Status.INFO, "************ END ***********");
		ReportGenerate.extent.flush();
	}

	public void getJwtToken() throws Exception {
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless=new");
		WebDriver driver = new ChromeDriver(options);
		driver.get(ConfigFileReader.getProperty("prodreq-app-url"));
		String userNameText = ConfigFileReader.getProperty("producer-username");
		String passwordText = ConfigFileReader.getProperty("producer-password");
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userNameText);
		String descryptedPassword = PasswordEncryption.decrypt(passwordText);
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(descryptedPassword);
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		Thread.sleep(2000);
		WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
		LocalStorage localStorage = webStorage.getLocalStorage();
		NCXJWT_TOKEN = localStorage.getItem("ncxjwttoken");
		System.out.println("NCX JWT Token  ==> " + NCXJWT_TOKEN);
		driver.close();
		driver.quit();
	}

	// @AfterSuite(alwaysRun = true)
	public void afterSuite() throws Exception {
		ReportGenerate.generateExtentReportLocal();
		EmailAttachment attachment = new EmailAttachment();

		attachment.setPath(System.getProperty("user.dir") + "\\Reports\\Spark.html");

		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription(" Test Execution Report");
		attachment.setName("Report.html");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("tfayd.com.ost");
		email.setSSLOnConnect(true);
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("jeevanandham.r@nbcuni.com", "XX"));
		email.addTo("jeevanandham.r@nbcuni.com", "Test");
		email.setFrom("jeevanandham.r@nbcuni.com", "Me");
		email.setSubject("Automation Test Execution Report");
		email.setMsg("Automation Test Execution Report");
		email.attach(attachment);

		email.send();
	}

}
