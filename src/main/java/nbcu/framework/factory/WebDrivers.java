package nbcu.framework.factory;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import nbcu.framework.utils.propertyfilereader.ConfigFileReader;
import nbcu.framework.utils.report.ReportGenerate;

public class WebDrivers {

	/**
	 * To get the current thread web driver
	 * 
	 * @return - current thread web driver
	 * @throws Exception
	 */
	public static WebDriver getNewDriver() throws Exception {
		WebDriver webDriver = null;
		if (ConfigFileReader.getProperty("IsRemote").equalsIgnoreCase("Yes"))
			webDriver = initializeRemoteWebDriver(ConfigFileReader.getProperty("Browser-Type"));
		else
			webDriver = initializeWebDriver(ConfigFileReader.getProperty("Browser-Type"));
		return webDriver;
	}

	/**
	 * This method to initialize web browser driver in local machine
	 *
	 * @param browserName - Name of the browser
	 * @return - WebDriver
	 */
	public static WebDriver initializeWebDriver(String browserName) {
		WebDriver driver = null;
		try {
			switch (browserName.toUpperCase().trim()) {

			case "CHROME_HEADLESS":
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				driver = new ChromeDriver(options);
				break;
			case "CHROME":
//				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
//						+ "\\src\\test\\resources\\drivers\\chromedriver-win64\\chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
//				chromeOptions.setBinary("C:\\Users\\206711859\\Downloads\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
				driver = new ChromeDriver(chromeOptions);
				driver.manage().window().maximize();
				break;
			case "FIREFOX":
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(firefoxOptions);
				break;
			case "IE":
				InternetExplorerOptions ieOptions = new InternetExplorerOptions();
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver(ieOptions);
				break;
			case "EDGE":
				EdgeOptions edgeOptions = new EdgeOptions();
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(edgeOptions);
				break;
			case "SAFARI":
				SafariOptions safariOptions = new SafariOptions();
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver(safariOptions);
				break;
			default:
				Assert.assertTrue(false, "Given browser name is not valid-" + browserName);
				break;
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			ReportGenerate.test.log(Status.INFO,
					"System opened producer dashboard application in " + browserName + " browser");
		} catch (Exception e) {
			System.out.println("Local driver initialize issue");
			e.printStackTrace();
		}
		return driver;
	}

	/**
	 * This method to initialize web browser driver in remote machine
	 *
	 * @param browserName - Name of the browser
	 * @return - WebDriver
	 */
	public static WebDriver initializeRemoteWebDriver(String browserName) {
		WebDriver driver = null;
		DesiredCapabilities capabilities = null;
		try {
			switch (browserName.toUpperCase()) {
			case "CHROME":
				capabilities = new DesiredCapabilities();
				capabilities.setCapability("browser", browserName);
				break;
			case "FIREFOX":
//				capabilities = DesiredCapabilities.firefox();
				capabilities = new DesiredCapabilities();
				capabilities.setCapability("browser", browserName);
				break;
			case "IE":
//				capabilities = DesiredCapabilities.internetExplorer();
//				capabilities.setBrowserName(BrowserType.IE);
				capabilities = new DesiredCapabilities();
				capabilities.setCapability("browser", browserName);
				break;
			case "EDGE":
//				capabilities = DesiredCapabilities.edge();
//				capabilities.setBrowserName(BrowserType.EDGE);
				capabilities = new DesiredCapabilities();
				capabilities.setCapability("browser", browserName);
				break;
			default:
				Assert.assertTrue(false, "Given browser name is not valid-" + browserName);
				break;
			}
			driver = new RemoteWebDriver(new URL(ConfigFileReader.getProperty("Selenium-Host")), capabilities);
			driver.manage().window().maximize();
			ReportGenerate.test.log(Status.INFO,
					"System opened producer dashboard application in " + browserName + " browser");
		} catch (Exception e) {
			System.out.println("Remote driver initialize issue");
			e.printStackTrace();
		}

		return driver;
	}
}
