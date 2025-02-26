package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import nbcu.automation.ui.pages.ncxUnifiedTool.LoginPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.MyRequestPage;
import nbcu.framework.factory.DriverFactory;
import nbcu.framework.utils.report.ReportGenerate;

public class LoginPageSteps {
	public static String NCXJWT_TOKEN = null;
	LoginPage loginPage = new LoginPage();
	MyRequestPage myRequestPage = new MyRequestPage();

	@Given("user opens producer dashboard application")
	public void openProdReqApp() throws Exception {
		loginPage.openApplication();
	}

	@Given("user navigate producer dashboard application")
	public void navigateProdReqApp() throws Exception {
		loginPage.navigateApplication();
	}

	@SuppressWarnings("deprecation")
	@Given("user logins with {string} role")
	public void loginIntoProdReqApp(String role) throws Exception {
		loginPage.loginIntoApplication(role);
	}

	@Given("user gets ncxjwttoken")
	public void loginIntoProdReqAppAndGetToken() throws Exception {

		loginPage.openApplication();
		loginPage.loginIntoApplication("PRODUCER");
		Thread.sleep(2000);
		WebStorage webStorage = (WebStorage) new Augmenter().augment(DriverFactory.getCurrentDriver());
		LocalStorage localStorage = webStorage.getLocalStorage();
		NCXJWT_TOKEN = localStorage.getItem("ncxjwttoken");
		System.out.println("NCX JWT Token  ==> " + NCXJWT_TOKEN);

	}

}
