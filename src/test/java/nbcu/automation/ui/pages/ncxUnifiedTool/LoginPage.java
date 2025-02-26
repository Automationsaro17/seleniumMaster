package nbcu.automation.ui.pages.ncxUnifiedTool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;
import nbcu.framework.utils.ui.WebAction;
import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;
import nbcu.automation.ui.enums.UserRole;
import nbcu.framework.factory.DriverFactory;
import nbcu.framework.utils.encryption.PasswordEncryption;
import nbcu.framework.utils.propertyfilereader.ConfigFileReader;
import nbcu.framework.utils.report.ReportGenerate;

public class LoginPage {

	@FindBy(id = "username")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "submitBtn")
	WebElement submitButton;

	public LoginPage() {
		PageFactory.initElements(DriverFactory.getCurrentDriver(), this);
	}

	/**
	 * To open enterprise search application
	 * 
	 * @throws Exception
	 */
	public void navigateApplication() throws Exception {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			driver.navigate().to(ConfigFileReader.getProperty("prodreq-app-url"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To open enterprise search application
	 * 
	 * @throws Exception
	 */
	public void openApplication() throws Exception {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			driver.get(ConfigFileReader.getProperty("prodreq-app-url"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			ReportGenerate.test.log(Status.INFO, "User opened producer dashboard application");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify sign in page is displayed
	 * 
	 * @throws Exception
	 */
	public void verifySignInPageDisplayed() throws Exception {
		Waits.waitForElement(userName, WAIT_CONDITIONS.VISIBLE);
	}

	/**
	 * To login into application
	 * 
	 * @throws Exception
	 */
	public void loginIntoApplication(String role) throws Exception {
		String userNameText = "", passwordText = "",displayName="";

		try {
			switch (role.toUpperCase()) {
			case "PRODUCER":
				userNameText = ConfigFileReader.getProperty("producer-username");
				passwordText = ConfigFileReader.getProperty("producer-password");
				displayName  = ConfigFileReader.getProperty("producer-name");
				Constants.setUserRole(UserRole.PRODUCER);
				break;
			case "FULFILLER":
				userNameText = ConfigFileReader.getProperty("ncx-fulfiller-username");
				passwordText = ConfigFileReader.getProperty("ncx-fulfiller-password");
				displayName  = ConfigFileReader.getProperty("fulfiller-name");
				Constants.setUserRole(UserRole.FULFILLER);
				break;
			case "ADMIN":
				userNameText = ConfigFileReader.getProperty("ncx-admin-username");
				passwordText = ConfigFileReader.getProperty("ncx-admin-password");
				Constants.setUserRole(UserRole.ADMIN);
				break;

			}
			WebAction.clear(userName);
			WebAction.sendKeys(userName, userNameText);
			String descryptedPassword = PasswordEncryption.decrypt(passwordText);
			WebAction.clear(password);
			WebAction.sendKeys(password, descryptedPassword);
			WebAction.click(submitButton);
			Constants.setLoggedInUsersDisplayName(displayName);
			Thread.sleep(1000);
			ReportGenerate.test.log(Status.INFO,
					role + " logged in producer dashboard application with " + userNameText + " userID");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
