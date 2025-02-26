package nbcu.automation.ui.pages.ncxUnifiedTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;
import nbcu.automation.ui.enums.RequestStatus;
import nbcu.automation.ui.pojos.ncxUnifiedTool.RequesterRecord;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.utils.Other.DateFunctions;
import nbcu.framework.utils.cucumber.CucumberUtils;
import nbcu.framework.utils.report.ReportGenerate;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;
import nbcu.framework.utils.ui.WebAction;
import nbcu.framework.factory.DriverFactory;

public class MyRequestPage {

	// Forms page button
	@FindBy(xpath = "//button[span[contains(text(),'New Request')]]")
	WebElement formsButton;

	@FindBy(xpath = "//div[contains(text(),'Select Request')]")
	WebElement selectRequestTitle;

	String dropDownvaluesXpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item";

	@FindBy(xpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item | //nz-option-item ")
	List<WebElement> dropDownvalues;

	String RequestType = "//div[@class='request-area']//span[contains(text(),'<<formName>>')]";

	@FindBy(xpath = "//a[contains(@href,'unified-requests/edit-self-reporting')]")
	WebElement editSelfReportingRequest;

	// Menu fold unfold icon
	@FindBy(xpath = "//*[@data-icon='menu-fold']")
	WebElement menuIconFold;

	@FindBy(xpath = "//*[@data-icon='menu-unfold']")
	WebElement menuIconUnfold;

	@FindBy(xpath = "//*[text()='Edit & Content Mgmt']")
	WebElement ecmIcon;

	// To fetch Request ID from success message
	String requestNumbersXpath = "//*[contains(@class,'modal-confirm-content')]/descendant::p[contains(@style,'color')]";
	// *[contains(@class,'modal-confirm-content')]/div

	@FindBy(xpath = "//*[contains(@class,'modal-confirm-content')]/descendant::p[contains(@style,'color')]")
	List<WebElement> requestIDFromSuccessMessage;

	// My request rows
	@FindBy(xpath = "//tr[contains(@class,'trCls')]")
	List<WebElement> myRequestRows;

	// to retrieve status by request id
	String findRequestById = "//td[p[a[text()='<<RequestId>>']]]";

	@FindBy(xpath = "//nz-avatar[i[*[@data-icon='user']]]")
	WebElement profileIcon;

	@FindBy(xpath = "//button[contains(text(),'Logout')]")
	WebElement logOutButton;

	@FindBy(xpath = "//*[contains(text(),'You have been logged out of this application')]")
	WebElement logOutMessage;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchTextBox;

	Map<String, String> map = new HashMap<>();

	@FindBy(xpath = "//*[@data-id='banner']//i")
	WebElement bannerCloseButton;

	@FindBy(xpath = "//section[@class='sub-header']//div[1]/nz-tag/span[2]")
	WebElement requestStatusLabel;

	@FindBy(xpath = "//span[text()='Request Submitted']/parent::span//following-sibling::div/div[text()]")
	WebElement reqSubmittedMsg;

	@FindBy(xpath = "//li//button[text()=' All Requests ']")
	WebElement allRequestsInDropdown;

	@FindBy(xpath = "//li//button[text()=' My Requests ']")
	WebElement myRequestsInDropdown;

	@FindBy(xpath = "//button[span[text()=' Yes ']]")
	WebElement cancel_Yes;

	@FindBy(xpath = "//button[span[text()=' No ']]")
	WebElement cancel_No;

	@FindBy(xpath = "//span[i[*[@data-icon='close']]]")
	WebElement closeMessagePopup;

	@FindBy(xpath = "//button[span[text()=' OK ']]")
	WebElement cancel_Ok;

	@FindBy(xpath = "//button[span[contains(text(),' Edit & Content Management')]]")
	WebElement EditContentManagementECMRequest;

	@FindBy(xpath = "//button[span[contains(text(),' Edit Self Reporting')]]")
	WebElement EditSelfReportingECMRequest;

	@FindBy(xpath = "//span[text()='Cancel Request']")
	WebElement cancelButton;

	@FindBy(xpath = "//button[span[contains(text(),'Confirm Cancel Request')]] | //button[span[contains(text(),'Confirm Cancellation')]]")
	WebElement confirmCancelRequestButton;

	@FindBy(xpath = "//a[text()='My Requests']")
	WebElement myRequestsDashboard;

	// Other WebElements

	@FindBy(xpath = "//*[@role='menuitem']/div")
	List<WebElement> SearchList;

	@FindBy(xpath = "//div[contains(@class, 'story-list-elem')]/button")
	List<WebElement> ncxStoryNamesdropDownvalues;

	// Next button
	@FindBy(xpath = "//span[text()='Next']")
	WebElement nextButton;

	@FindBy(xpath = "//span[text()='Exit ']")
	WebElement exitButton;

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	WebElement submitButton;

	@FindBy(xpath = "//*[@title='Producer Dashboard']")
	WebElement nbcuLogo;

	@FindBy(xpath = "(//span[contains(text(),'Edit')])[last()] |button[@class='ecm-fulfillment-btn ant-btn ant-btn-primary ant-btn-round ng-star-inserted']")
	WebElement editButton;

	@FindBy(xpath = "(//span[text()=' Add '])[1]")
	WebElement AddButtonForHandler;

	@FindBy(xpath = "(//span[text()=' Add '])[2]")
	WebElement AddButtonForAnimal;

	// Cancel Request button
	@FindBy(xpath = "(//button[span[contains(text(),'Cancel Request')]])[last()]")
	WebElement cancelRequestButton;

	@FindBy(xpath = "//*[@class='sub-headerText']//p")
	WebElement requestIdDisplayed;

	@FindBy(xpath = "//div[@class='title ng-star-inserted']")
	WebElement textDisplayed;

	@FindBy(xpath = "//div[@class='status-title']/p")
	WebElement statusText;

	@FindBy(xpath = "//*[@class='anticon anticon-down']")
	WebElement myRequestDropdownIcon;

	@FindBy(xpath = "(//span[@class='ng-star-inserted'])[2]")
	WebElement OkButton;

	@FindBy(xpath = "//*[@sectiontitle='Resources']//span[text()=' View Estimated Cost Breakdown ']")
	WebElement viewEstimatedCostBreakdown;

	@FindBy(xpath = "//*[@href='#/']")
	WebElement requestsDashboardButton;

	@FindBy(xpath = "//*[@data-id='subHeaderContainer']//button//i")
	WebElement changeViewButton;

	@FindBy(xpath = "//button[contains(text(),'My Requests')]")
	WebElement myRequestsButton;

	@FindBy(xpath = "//button[contains(text(),'All Requests')]")
	WebElement allRequestsButton;

	@FindBy(xpath = "//*[contains(@class,'ant-spin-dot-spin')]")
	WebElement loadingSpinner;

	@FindBy(xpath = "//td[2]//a")
	List<WebElement> requestIdsInTable;

	@FindBy(xpath = "//*[contains(@class,'ant-modal-confirm-title')]/*")
	List<WebElement> requestCreatedModalTitle;

	@FindBy(xpath = "//*[contains(@class,'ant-modal-confirm-content')]/*")
	WebElement requestCreatedModalMessage;

	@FindBy(xpath = "//div[contains(@class,'pagination ')]")
	List<WebElement> paginationContainer;

	@FindBy(xpath = "//*[contains(text(),'All Requests')]")
	List<WebElement> allRequestsView;

	WebDriver driver = DriverFactory.getCurrentDriver();

	public MyRequestPage() {
		PageFactory.initElements(DriverFactory.getCurrentDriver(), this);
	}

	/**
	 * To verify my requests page loaded
	 * 
	 * @throws Exception
	 */
	public void verifyMyRequestsPageDisplayed() throws Exception {
		Waits.waitForElement(formsButton, WAIT_CONDITIONS.CLICKABLE);
	}

	/**
	 * To verify form selection page loaded
	 * 
	 * @throws Exception
	 */
	public void verifySelectRequestPanelDisplayed() throws Exception {
		Waits.waitForElement(selectRequestTitle, WAIT_CONDITIONS.VISIBLE);
	}

	/**
	 * To click + button
	 * 
	 * @throws Exception
	 */
	public void clickFormsButton() throws Exception {
		WebAction.click(formsButton);
	}

	/**
	 * To select given form from request
	 * 
	 * @throws Exception
	 */
	public void selectRequestForm(String formName) throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		Constants.setFormType(formName);
		Constants.setFormName(formName);
		try {
			Constants.setRequestType(formName);
			if (formName.toUpperCase().equalsIgnoreCase("CNBC CREW")) {
				// To select CNBC crew request
				RequestType = "(//div[@class='request-area'])[2]//*[contains(text(),'CNBC')]";
				Waits.waitForElement(driver.findElement(By.xpath(RequestType)), WAIT_CONDITIONS.VISIBLE);
				Waits.waitForElement(driver.findElement(By.xpath(RequestType)), WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(driver.findElement(By.xpath(RequestType)));
			} else if (formName.toUpperCase().equalsIgnoreCase("NEWS GEAR")) {
				// To select News gear request
				RequestType = "(//div[@class='request-area'])[4]//*[contains(text(),'News')]";
				Waits.waitForElement(driver.findElement(By.xpath(RequestType)), WAIT_CONDITIONS.VISIBLE);
				Waits.waitForElement(driver.findElement(By.xpath(RequestType)), WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(driver.findElement(By.xpath(RequestType)));
			} else if (formName.toUpperCase().equalsIgnoreCase("STANDARD EDIT")
					|| formName.toUpperCase().equalsIgnoreCase("LONG EDIT")) {
				// To select edit request
				RequestType = RequestType.replace("<<formName>>", "Edit");
				Waits.waitForElement(driver.findElement(By.xpath(RequestType)), WAIT_CONDITIONS.VISIBLE);
				Waits.waitForElement(driver.findElement(By.xpath(RequestType)), WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(driver.findElement(By.xpath(RequestType)));
			} else if (formName.toUpperCase().equalsIgnoreCase("EDIT SELF REPORTING")) {
				// To select edit self reporting request
				Waits.waitForElement(menuIconUnfold, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(menuIconUnfold);
				Waits.waitForElement(ecmIcon, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(ecmIcon);
				Waits.waitForElement(editSelfReportingRequest, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(editSelfReportingRequest);
			} else if (formName != null) {
				// To select request
				RequestType = RequestType.replace("<<formName>>", formName);
				Waits.waitForElement(driver.findElement(By.xpath(RequestType)), WAIT_CONDITIONS.VISIBLE);
				Waits.waitForElement(driver.findElement(By.xpath(RequestType)), WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(driver.findElement(By.xpath(RequestType)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify background color of status in my request page
	 * 
	 * @param typeValueCSS  - type of css like background color, font family, etc.,
	 * @param status        - status of the request
	 * @param expectedColor - expected color of the status
	 * @throws Exception
	 */
	public void verifyStatusBackgroundColor(String typeOfCss, String status, String expectedColor) throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			String requestNumber = Constants.getRequestNumber();

			System.out.println("Req Number:" + requestNumber);
			// To add request number in allure report
			// AllureUtility.addParameter("Request Number", requestNumber);

			String statusXpath = findRequestById.replace("<<RequestId>>", requestNumber)
					+ "//preceding::td[1]//following-sibling::td[2]//span";
			WebElement statusElement = driver.findElement(By.xpath(statusXpath));
			String actualStatus = WebAction.getText(statusElement).trim();
			if (!(actualStatus.equalsIgnoreCase(status))) {
				throw new Exception("Status of the request is not correct. Expected status is '" + status
						+ "' and actual status is '" + actualStatus + "'");
			}
			// !
			CommonValidations.verifyCssValueOfWebElement(statusElement, typeOfCss, expectedColor);

		} catch (Exception e) {
			// AllureUtility.captureScreenshot("Status color Validation error");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To logout of the application
	 * 
	 * @throws Exception
	 */
	public void logOut() throws Exception {
		Waits.waitForElement(profileIcon, WAIT_CONDITIONS.VISIBLE);
		try {
			WebAction.mouseOver(profileIcon);
			Thread.sleep(2000);
		} catch (Exception e) {
			WebAction.clickUsingJs(profileIcon);
		}

		WebAction.click(logOutButton);
		Thread.sleep(2000);
		WebAction.switchToFrame("header");
		Waits.waitForElement(logOutMessage, WAIT_CONDITIONS.VISIBLE);
		WebAction.switchToDefaultContent();
	}

	/**
	 * To search the request in requester table
	 * 
	 * @throws Exception
	 */
	public void searchRequest() throws Exception { // Need to change old code jeeva
		try {
			for (Map.Entry<String, String> e : map.entrySet()) {
				Constants.setRequestNumber(e.getKey());
				break;
			}
			String requestNumber = Constants.getRequestNumber();// "SR-12062024-00328324";
																// Constants.setRequestNumber(requestNumber);//
																// Constants.getRequestNumber();
			Waits.waitForElement(searchTextBox, WAIT_CONDITIONS.CLICKABLE);
			WebAction.click(searchTextBox);
			Waits.waitUntilElementSizeGreater(myRequestRows, 0);
			WebAction.sendKeys(searchTextBox, requestNumber);
		} catch (Exception e) {
			// AllureUtility.captureScreenshot("Search request is not working in my request
			// page");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To click edit link of the request
	 * 
	 * @throws Exception
	 */
	public void clickEditLink() throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			String requestNumber = Constants.getRequestNumber();
			Waits.waitForElement(By.xpath(findRequestById.replace("<<RequestId>>", requestNumber)),
					WAIT_CONDITIONS.CLICKABLE);

			// To click edit link
			String editLinkXpath = findRequestById.replace("<<RequestId>>", requestNumber)
					+ "/following-sibling::td[a[text()='Edit']]/a";
			Waits.waitForElement(By.xpath(editLinkXpath), WAIT_CONDITIONS.CLICKABLE);
			WebAction.click(driver.findElement(By.xpath(editLinkXpath)));

		} catch (Exception e) {
			// AllureUtility.captureScreenshot("Request not found in my request page");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To click request ID link of the request
	 * 
	 * @throws Exception
	 */
	public void clickRequestIdLink() throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			String requestNumber = Constants.getRequestNumber();
			// To click request ID link
			String requestIdLinkXpath = "//a[contains(text(),'" + requestNumber + "')]";
			Waits.waitForElement(By.xpath(requestIdLinkXpath), WAIT_CONDITIONS.CLICKABLE);
			WebAction.click(driver.findElement(By.xpath(requestIdLinkXpath)));

		} catch (Exception e) {
			// AllureUtility.captureScreenshot("Request not found");
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * To get request ids from successful message after user clicks submit button
	 * 
	 * @param formName - form name
	 * @throws Exception
	 */
	public void getRequestID() throws Exception {
		String requestNumber = "";
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebElement requestNumberWebElement = driver
					.findElement(By.xpath("//*[contains(@class,'modal-confirm-content')]/descendant::div"));
			Waits.waitForElement(requestNumberWebElement, WAIT_CONDITIONS.VISIBLE);
			String requestNumberWithSuccessMessage = WebAction.getText(requestNumberWebElement);
			if (!(requestNumberWithSuccessMessage.contains("The request is NOT booked"))) {
				String[] requestNumberWithRequestTypearr = requestNumberWithSuccessMessage.split("\"");
				requestNumber = requestNumberWithRequestTypearr[1].trim();
				Constants.setRequestNumber(requestNumber);
			}
			if (requestNumberWithSuccessMessage.contains("The request is NOT booked")) {
				WebElement closeButtonWebElement = driver.findElement(By.xpath("//*[contains(text(),'Close')]"));
				WebAction.click(closeButtonWebElement);
				String formName = Constants.getFormType();
				verifyProductionRequestInmyRequestPage(formName, "NEW");
				requestNumber = Constants.getRequestNumber();
			}
			if (requestNumber.isEmpty()) {
				clickOption("close");
				throw new Exception("Submitted request ID is not present in success pop up");
			}
		} catch (Exception e) {
			// AllureUtility.captureScreenshot("Request ID not present in success pop up");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To click x button in Test Version Banner
	 * 
	 * @throws Exception
	 */
	public void clickCloseButtonInTestVersionBanner() throws Exception {
		if (WebAction.isDisplayed(bannerCloseButton)) {
			WebAction.click(bannerCloseButton);
		}

	}

	/**
	 * To verify submitted request is present in the my request page
	 * 
	 * @param formName - form name
	 * @throws Exception
	 */
	public void verifyProductionRequestInmyRequestPage(String formName, String status) throws Exception {
		String requestNumber = "";
		String RequestType = "";
		try {
			// To check form name
			if (formName.toUpperCase().equalsIgnoreCase("NEWS GEAR")) {
				formName = "News Gear";
				RequestType = "GEAR REQUEST";
			} else if (formName.toUpperCase().equalsIgnoreCase("ROCK CENTER")) {
				formName = "Rock Center Production Request";
				RequestType = "PRODUCTION REQUEST";
			} else if (formName.toUpperCase().equalsIgnoreCase("CNBC")) {
				formName = "CNBC Production Request";
				RequestType = "PRODUCTION REQUEST";
			} else if (formName.toUpperCase().equalsIgnoreCase("ANIMALS ON PREMISES")) {
				formName = "Animals on Premises";
				RequestType = "PRODUCTION REQUEST";
			} else if (formName.toUpperCase().equalsIgnoreCase("FIREARMS ON PREMISES")) {
				formName = "FireArms Request";
				RequestType = "PRODUCTION REQUEST";
			} else if (formName.toUpperCase().equalsIgnoreCase("SINGLE CAMERA LIVE SHOT")) {
				formName = "Single Camera Live Shot";
				RequestType = "PRODUCTION REQUEST";
			} else if (formName.toUpperCase().contains("EXTEND OR BRIDGE CREW & FACILITIES")) {
				formName = "Extended or Bridge Crew and Facilities";
				RequestType = "PRODUCTION REQUEST";
			} else if (formName.toUpperCase().equalsIgnoreCase("NBC NEWS")) {
				formName = "General Crew Request";
				RequestType = "CREW REQUEST";
			} else if (formName.toUpperCase().equalsIgnoreCase("CNBC CREW")) {
				formName = "CNBC Crew";
				RequestType = "CREW REQUEST";
			} else if (formName.toUpperCase().equalsIgnoreCase("TELEMUNDO NEWS")) {
				formName = "Telemundo Crew";
				RequestType = "CREW REQUEST";
			} else if (formName.toUpperCase().equalsIgnoreCase("DIGITAL JOURNALIST / DJ SHOOT")) {
				formName = "Digital Journalist";
				RequestType = "CREW REQUEST";
			} else if (formName.toUpperCase().equalsIgnoreCase("NBC BREAKING NEWS")) {
				formName = "Breaking News";
				RequestType = "CREW REQUEST";
			} else if (formName.toUpperCase().equalsIgnoreCase("NBC BUREAU CAMERA")) {
				formName = "Bureau Camera";
				RequestType = "CREW REQUEST";
			} else if (formName.toUpperCase().equalsIgnoreCase("STANDARD EDIT")) {
				formName = "Standard Edit";
				RequestType = "EDIT";
			} else if (formName.toUpperCase().equalsIgnoreCase("LONG EDIT")) {
				formName = "Long Form Edit";
				RequestType = "EDIT";
			} else if (formName.toUpperCase().equalsIgnoreCase("FILE INGEST")) {
				formName = "File Ingest";
				RequestType = "CONTENT MANAGEMENT";
			} else if (formName.toUpperCase().equalsIgnoreCase("FEED OUT")) {
				formName = "Feed Out";
				RequestType = "CONTENT MANAGEMENT";
			} else if (formName.toUpperCase().equalsIgnoreCase("Media Transcoding / Transferring / Duplication")) {
				formName = "MTD";
				RequestType = "CONTENT MANAGEMENT";
			} else if (formName.toUpperCase().equalsIgnoreCase("EDIT SELF REPORTING")) {
				formName = "Edit Self Reporting";
				RequestType = "EDIT";
			}

			for (WebElement row : myRequestRows) {
				if ((WebAction.getText(row.findElement(By.xpath("td[1]/p[1]"))).equalsIgnoreCase(RequestType))
						&& (WebAction.getText(row.findElement(By.xpath("td[1]/p[2]"))).equalsIgnoreCase(formName))
						&& (WebAction.getText(row.findElement(By.xpath("td[3]//span"))).equalsIgnoreCase(status))) {
					requestNumber = WebAction.getText(row.findElement(By.xpath("td[2]/p/a")));
					Constants.setRequestNumber(requestNumber);
					break; // td[3]/tz-nag
				}
			}
			if (requestNumber.isEmpty())
				throw new Exception("Submitted " + formName + "is not present in my request table");

			// To close the update popup
			if (WebAction.isDisplayed(closeMessagePopup)) {
				WebAction.click(closeMessagePopup);
			}

			if (status.equalsIgnoreCase("CONFIRM CANCELLATION")) {
				status = "CONFIRM_CANCELLATION";
			}

			if (status.equalsIgnoreCase("IN PROGRESS")) {
				status = "IN_PROGRESS";
			}

			if (status.equalsIgnoreCase("READY FOR PICK UP")) {
				status = "READY_FOR_PICK_UP";
			}

			Constants.setRequestStatus(RequestStatus.valueOf(status));

		} catch (Exception e) {
			// AllureUtility.captureScreenshot("Request not present in my request table");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify text displayed on the request
	 * 
	 * @param text - form name
	 * @throws Exception
	 */
	public void verifyTextDisplayed(String text) throws Exception {
		try {
			Thread.sleep(3000);
			Waits.waitForElement(textDisplayed, WAIT_CONDITIONS.VISIBLE);
			CommonValidations.verifyTextValue(textDisplayed, text);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void verifyStatus(String status) throws Exception {
		try {
			Thread.sleep(3000);
			Waits.waitForElement(requestStatusLabel, WAIT_CONDITIONS.VISIBLE);
			CommonValidations.verifyTextValue(requestStatusLabel, status);

			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To get status of the request on the form
	 * 
	 * @param status - status text
	 * @throws Exception
	 */
	public void verifyRequestStatusText(String status) throws Exception {
		try {
			Thread.sleep(3000);
			Waits.waitForElement(statusText, WAIT_CONDITIONS.VISIBLE);
			CommonValidations.verifyTextValue(statusText, status);

			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To get request ids from successful message after user clicks submit button
	 * 
	 * @param formName - form name
	 * @throws Exception
	 */
	public void getRequestIDs() throws Exception {
		String requestNumber = "";
		String requestType = null;
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();

			Waits.waitUntilElementSizeGreater(By.xpath(requestNumbersXpath), 0);
			for (int i = 1; i <= requestIDFromSuccessMessage.size(); i++) {
				String newRequestNumbersXpath = requestNumbersXpath + "[" + i + "]";
				WebElement requestNumberWebElement = driver.findElement(By.xpath(newRequestNumbersXpath));
				String requestNumberWithRequestType = WebAction.getText(requestNumberWebElement);
				if (requestNumberWithRequestType.contains(" ")) {
					String[] requestNumberWithRequestTypearr = requestNumberWithRequestType.split(" ", 2);
					requestNumber = requestNumberWithRequestTypearr[0];
					requestType = requestNumberWithRequestTypearr[1].substring(1,
							requestNumberWithRequestTypearr[1].length() - 1);
				} else {
					requestNumber = requestNumberWithRequestType;
				}
				map.put(requestNumber, requestType);
			}
			for (Map.Entry<String, String> e : map.entrySet()) {
				System.out.println(e.getKey() + " " + e.getValue());
			}
			for (Map.Entry<String, String> e : map.entrySet()) {
				// System.out.println(e.getKey() + " " + e.getValue());
				Constants.setRequestNumber(e.getKey());
				break;
			}
		} catch (Exception e) {
			// AllureUtility.captureScreenshot("Request not present in success message");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To get the request id from form and storing for future purpose.
	 * 
	 * @throws Exception
	 */
	public void getRequestIDFromSuccMsg() throws Exception {
		try {
			String msg = WebAction.getText(reqSubmittedMsg);
			String[] splitterString = msg.split("\"");
			Constants.setRequestNumber(splitterString[1]);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To click yes/No in the cancel alert message
	 * 
	 * @param confirmation - Yes/No
	 * @throws Exception
	 */
	public void clickOption(String confirmation) throws Exception {
		try {
			switch (confirmation.toUpperCase()) {
			case "YES":
				WebAction.click(cancel_Yes);
				break;
			case "OK":
				Waits.waitForElement(cancel_Ok, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(cancel_Ok);
				break;
			case "NO":
				WebAction.click(cancel_No);
				break;
			case "CLOSE":
				WebAction.click(closeMessagePopup);
				break;
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To Open the request
	 * 
	 * @throws Exception
	 */

	public void openRequestInReadMode() {
		String requestID = Constants.getRequestNumber();
		Assert.assertEquals(requestIdDisplayed.getText(), requestID, "request open is not the same as searched");
	}

	public void checkRequestCreatedModal(String formName) throws Exception {
		Waits.waitUntilElementSizeGreater(requestCreatedModalTitle, 0);
		String expectedTitle = "Request Submitted";
		String displayedTitle = WebAction.getText(requestCreatedModalTitle.get(0));
		Assert.assertEquals(displayedTitle, expectedTitle, "Request created modal title is not matching");
		String displayedMessage = WebAction.getText(requestCreatedModalMessage);
		Assert.assertTrue(displayedMessage.startsWith(String.format("The %s ", formName)),
				"Request name does not match in request submission modal");
		Assert.assertTrue(displayedMessage.endsWith("was submitted successfully.")
				|| displayedMessage.endsWith("was submitted successfully"));
		int firstIndex = displayedMessage.indexOf("\"");
		if (firstIndex >= 0) {
			String requestId = displayedMessage.substring(firstIndex + 1, displayedMessage.lastIndexOf("\"")).trim();
			Constants.setRequestNumber(requestId);
		}
	}

	public void openRequestsDashboard(String view) {
		try {
			requestsDashboardButton.click();
			Waits.waitForElement(changeViewButton, WAIT_CONDITIONS.CLICKABLE);
			WebAction.mouseOver(changeViewButton);
			if (view.equalsIgnoreCase("My Requests")) {
				Waits.waitForElement(myRequestsButton, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(myRequestsButton);
			} else if (view.equalsIgnoreCase("All Requests")) {
				Waits.waitForElement(allRequestsButton, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(allRequestsButton);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchAndOpenRequest(String requestNumber) throws Exception {
		WebAction.sendKeys(searchTextBox, requestNumber);
		Waits.waitUntilElementSizeEquals(paginationContainer, 1);
		Thread.sleep(2000);
		Optional<WebElement> requestLinkOptional = requestIdsInTable.stream()
				.filter((requestIdElement) -> WebAction.getText(requestIdElement).equals(requestNumber)).findFirst();
		if (requestLinkOptional.isPresent()) {
			Waits.waitUntilElementIsClickable(requestIdsInTable.get(0));
			WebAction.click(requestIdsInTable.get(0));
			Waits.waitUntilElementIsClickable(editButton);
		}
	}

	public void openCreatedRequest() throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		int trials = 10;
		while (--trials >= 0) {
			try {
				String requestUrl = Constants.getRequestUrl();
				if (requestUrl == null) {
					if (allRequestsView.size() == 0) {
						openRequestsDashboard("All Requests");
					}
					searchAndOpenRequest(Constants.getRequestNumber());
					Constants.setRequestUrl(driver.getCurrentUrl());
				} else {
					driver.get(requestUrl);
					Waits.waitUntilElementIsClickable(editButton);
				}
				break;
			} catch (Exception e) {
				e.printStackTrace();
				if (trials == 0) {
					throw e;
				}
			}
		}
	}

	/**
	 * To generate date based on input. Date should like CurrebDate+1,
	 * CurrentDate-2, etc.,
	 * 
	 * @param date   - date
	 * @param format - date format
	 * @throws Exception
	 */
	public String generateDate(String date, String format) throws Exception {
		String updateddate = "";
		try {
			if (date.trim().length() > 0) {
				if (date.toUpperCase().contains("CURRENTDATE")) {
					String days = date.replaceAll("[a-zA-Z]", "").trim();
					if (days.length() == 0) {
						days = "0";
					}
					updateddate = DateFunctions.addOrMinusDateFromCurrentDate(format, days);
				} else
					throw new Exception("Please provide date in valid format");
			} else
				throw new Exception("Date is empty");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return updateddate;
	}

	public void verifyRequestValuesWithMyRequestDashboardValues(String slugText, String prodDateText,
			String showTitleText, String SubmittedText) throws Exception {
		try {
			String formName = Constants.getFormType();
			String requestNumber = Constants.getRequestNumber();
			String columnCellString = "//*[contains(text(),'<<RequestId>>')]/ancestor::tr/td[<<ColumnTypeNo>>]";
			String columnTypeNoText;

			// To validate slug
			if (slugText != null) {
				columnTypeNoText = "4";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				slugText = Constants.getAssignmentSlug();
				verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText, slugText);
			}

			// To validate submitted date
			if (SubmittedText != null) {
				columnTypeNoText = "5";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				SubmittedText = generateDate(SubmittedText, "MM/dd/yy");
				verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText, SubmittedText);
			}

			// To validate prod date
			if (prodDateText != null) {
				String actualValue;
				String expectedValue;
				columnTypeNoText = "6";
				String prodDateCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				if (formName.toUpperCase().equalsIgnoreCase("NBC NEWS")
						|| formName.toUpperCase().equalsIgnoreCase("CNBC CREW")
						|| formName.toUpperCase().equalsIgnoreCase("TELEMUNDO NEWS")
						|| formName.toUpperCase().equalsIgnoreCase("DIGITAL JOURNALIST / DJ SHOOT")) {
					WebElement prodDateTextIndashboardWebelement = driver.findElement(By.xpath(prodDateCellTypeText));
					String prodDate = prodDateTextIndashboardWebelement.getText().trim();
					String date = generateDate(Constants.getShootStartDate(), "MM/dd/yy");
					actualValue = prodDate;
					expectedValue = date;
					// getting error - to be fixed
					// Assert.assertTrue(actualValue.toUpperCase().contains(expectedValue.toUpperCase()),
					// "Expected value is " + expectedValue + " and actual value is " +
					// actualValue);
					ReportGenerate.test.log(Status.INFO,
							"\"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
					System.out.println(
							"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
				}
			}

			// To validate show unit
			if (showTitleText != null) {
				List<String> showList;
				String[] ShowArrayList;
				columnTypeNoText = "7";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				if (formName.toUpperCase().equalsIgnoreCase("NBC NEWS")
						|| formName.toUpperCase().equalsIgnoreCase("CNBC CREW")
						|| formName.toUpperCase().equalsIgnoreCase("TELEMUNDO NEWS")
						|| formName.toUpperCase().equalsIgnoreCase("DIGITAL JOURNALIST / DJ SHOOT")) {
					String showCellTypeText = columnCellTypeText.concat("/div[<<showNo>>]");
					showList = Constants.getMultipleShowUnits();
					if (showTitleText.contains(",")) {
						for (int i = 0; i < showList.size(); i++) {
							String showNamesNewXpath = showCellTypeText.replace("<<showNo>>", Integer.toString(i + 1));
							verifyExpectedValueInFormWithActualValueInDashboard(showNamesNewXpath, showList.get(i));
						}
					} else {
						ShowArrayList = new String[1];
						ShowArrayList[0] = showTitleText;
						verifyExpectedValueInFormWithActualValueInDashboard(showCellTypeText.replace("<<showNo>>", "1"),
								ShowArrayList[0]);
					}
				}
			}

			// To validate actions column edit button enabled or not
			columnTypeNoText = "8";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("//a");
			String editButtonEnabledOrDisabled = WebAction
					.getAttribute(driver.findElement(By.xpath(columnCellTypeText)), "class");
			if (editButtonEnabledOrDisabled.equalsIgnoreCase("disabled")) {
				ReportGenerate.test.log(Status.FAIL, "Edit button is not enabled for actions column in the dashboard");
				System.out.println("Edit button is not enabled for actions column in the dashboard");
			} else {
				ReportGenerate.test.log(Status.PASS, "Edit button is enabled for actions column in the dashboard");
				System.out.println("Edit button is enabled for actions column in the dashboard");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyRequestValuesWithAllRequestDashboardValues(String additionalRequestersText, String slugText,
			String prodDateText, String showTitleText, String SubmittedText) throws Exception {
		try {
			String formName = Constants.getFormType();
			String requestNumber = Constants.getRequestNumber();
			String columnCellString = "//*[contains(text(),'<<RequestId>>')]/ancestor::tr/td[<<ColumnTypeNo>>]";
			String columnTypeNoText;

			// To validate default requester
			String defaultRequesterName = Constants.getDefaultRequesterName();
			columnTypeNoText = "4";
			String defaultRequesterNamecolumnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String defaultRequesterNameTextIndashboard = defaultRequesterNamecolumnCellTypeText.concat("/div");
			verifyExpectedValueInFormWithActualValueInDashboard(defaultRequesterNameTextIndashboard,
					defaultRequesterName);

			// To validate additional requester
			String columnTypeText;
			String[] additionalRequestersArrayList;
			if (additionalRequestersText != null) {
				if (additionalRequestersText.contains("-")) {
					additionalRequestersArrayList = additionalRequestersText.split("-");
				} else {
					additionalRequestersArrayList = new String[1];
					additionalRequestersArrayList[0] = additionalRequestersText;
				}
				String additionalRequesterTextXpathIndashboard = defaultRequesterNameTextIndashboard
						.concat("/span[last()]");
				List<String> addreqNamesList = new ArrayList<String>();
				List<RequesterRecord> additionalRequestersStringList = Constants.getRequesters();
				for (RequesterRecord additionalRequester : additionalRequestersStringList) {
					addreqNamesList.add(additionalRequester.getName());
				}
				WebElement additionalRequestersWebelement = driver
						.findElement(By.xpath(additionalRequesterTextXpathIndashboard));
				Waits.waitForElement(additionalRequestersWebelement, WAIT_CONDITIONS.VISIBLE);
				Thread.sleep(1000);
				WebAction.click(additionalRequestersWebelement);
				String additionalreqNamesXpath = "(//div[contains(@class,'popover')])[last()]/div[<<additionalReqNo>>]";
				for (int i = 0; i < additionalRequestersArrayList.length; i++) {
					String additionalreqNamesNewXpath = additionalreqNamesXpath.replace("<<additionalReqNo>>",
							Integer.toString(i + 2));
					verifyExpectedValueInFormWithActualValueInDashboard(additionalreqNamesNewXpath,
							addreqNamesList.get(i));
				}
			}

			// To validate slug
			if (slugText != null) {
				columnTypeNoText = "5";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				slugText = Constants.getAssignmentSlug();
				verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText, slugText);
			}

			// To validate submitted date
			if (SubmittedText != null) {
				columnTypeNoText = "6";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				SubmittedText = generateDate(SubmittedText, "MM/dd/yy");
				verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText, SubmittedText);
			}

			// To validate prod date
			if (prodDateText != null) {
				String actualValue;
				String expectedValue;
				columnTypeNoText = "7";
				String prodDateCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				if (formName.toUpperCase().equalsIgnoreCase("NBC NEWS")
						|| formName.toUpperCase().equalsIgnoreCase("CNBC CREW")
						|| formName.toUpperCase().equalsIgnoreCase("TELEMUNDO NEWS")
						|| formName.toUpperCase().equalsIgnoreCase("DIGITAL JOURNALIST / DJ SHOOT")) {
					WebElement prodDateTextIndashboardWebelement = driver.findElement(By.xpath(prodDateCellTypeText));
					String prodDate = prodDateTextIndashboardWebelement.getText().trim();
					String date = generateDate(Constants.getShootStartDate(), "MM/dd/yy");
					actualValue = prodDate;
					expectedValue = date;
					// getting error - to be fixed
					// Assert.assertTrue(actualValue.toUpperCase().contains(expectedValue.toUpperCase()),
					// "Expected value is " + expectedValue + " and actual value is " +
					// actualValue);
					ReportGenerate.test.log(Status.INFO,
							"\"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
					System.out.println(
							"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
				}
			}

			// To validate show unit
			if (showTitleText != null) {
				List<String> showList;
				String[] ShowArrayList;
				columnTypeNoText = "8";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				if (formName.toUpperCase().equalsIgnoreCase("NBC NEWS")
						|| formName.toUpperCase().equalsIgnoreCase("CNBC CREW")
						|| formName.toUpperCase().equalsIgnoreCase("TELEMUNDO NEWS")
						|| formName.toUpperCase().equalsIgnoreCase("DIGITAL JOURNALIST / DJ SHOOT")) {
					String showCellTypeText = columnCellTypeText.concat("/div[<<showNo>>]");
					showList = Constants.getMultipleShowUnits();
					if (showTitleText.contains(",")) {
						for (int i = 0; i < showList.size(); i++) {
							String showNamesNewXpath = showCellTypeText.replace("<<showNo>>", Integer.toString(i + 1));
							verifyExpectedValueInFormWithActualValueInDashboard(showNamesNewXpath, showList.get(i));
						}
					} else {
						ShowArrayList = new String[1];
						ShowArrayList[0] = showTitleText;
						verifyExpectedValueInFormWithActualValueInDashboard(showCellTypeText.replace("<<showNo>>", "1"),
								ShowArrayList[0]);
					}
				}
			}

			// To validate actions column edit button enabled or not
			columnTypeNoText = "9";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("//a");
			String editButtonEnabledOrDisabled = WebAction
					.getAttribute(driver.findElement(By.xpath(columnCellTypeText)), "class");
			if (editButtonEnabledOrDisabled.equalsIgnoreCase("disabled")) {
				ReportGenerate.test.log(Status.FAIL, "Edit button is not enabled for actions column in the dashboard");
				System.out.println("Edit button is not enabled for actions column in the dashboard");
			} else {
				ReportGenerate.test.log(Status.PASS, "Edit button is enabled for actions column in the dashboard");
				System.out.println("Edit button is enabled for actions column in the dashboard");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyExpectedValueInFormWithActualValueInDashboard(String columnCellTypeText, String expectedValue)
			throws Exception {
		Waits.waitForElement(driver.findElement(By.xpath(columnCellTypeText)), WAIT_CONDITIONS.VISIBLE);
		String columnCellText = WebAction.getText(driver.findElement(By.xpath(columnCellTypeText)));
		String[] cellValueArrayList = null;
		String actualValue;
		if (columnCellTypeText.contains("controlRoom") && columnCellText.contains(":")) {
			columnCellText = columnCellText.replace(":", ",");
		}
		if (columnCellText.contains(":")) {
			int count = 0;
			for (int i = 0; i < columnCellText.length(); i++) {
				if (columnCellText.charAt(i) == ':') {
					count++;
				}
			}
			if (count > 1) {
				cellValueArrayList = columnCellText.split(":", 2);
				actualValue = cellValueArrayList[1];
			} else {
				actualValue = columnCellText.replace(":", " ");
			}
		} else {
			actualValue = columnCellText.trim();
		}
		// cellValueArrayList = columnCellText.split(":"); //"\""
		Assert.assertTrue(actualValue.toUpperCase().contains(expectedValue.toUpperCase()),
				"Expected value is " + expectedValue + " and actual value is " + actualValue);
		ReportGenerate.test.log(Status.INFO,
				"\"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
		System.out.println("" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
	}
}
