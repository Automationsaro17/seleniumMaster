
package nbcu.automation.ui.pages.ncxUnifiedTool;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;
import nbcu.automation.ui.pojos.ncxUnifiedTool.RequesterRecord;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.factory.DriverFactory;
import nbcu.framework.utils.Other.DateFunctions;
import nbcu.framework.utils.cucumber.CucumberUtils;
import nbcu.framework.utils.report.ReportGenerate;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;
import nbcu.framework.utils.ui.WebAction;

public class EditSelfReportingRequestFormPage {

	String showTitleString = "(//input[@placeholder='Show Unit or Project Name'])[<<showUnitNo>>]";

	String budgetCodeTitleString = "(//input[@placeholder='Search Budget Code'])[<<budgetCodeNo>>]";

	@FindBy(xpath = "//*[text()=' Show Unit ']")
	WebElement showTitleAddButton;

	@FindBy(xpath = "//*[@role='menuitem']/div")
	List<WebElement> SearchList;

	String dropDownvaluesXpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item";

	@FindBy(xpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item | //nz-option-item ")
	List<WebElement> dropDownvalues;

	@FindBy(xpath = "//*[@forminputname='airDate']//input")
	WebElement airDate;

	@FindBy(xpath = "//*[@formcontrolname='airDateTBD']//input")
	WebElement airDateTBDCheckBox;

	@FindBy(xpath = "//*[@forminputname='editStartDate']//input")
	WebElement editDate;

	String whoIsEditingType = "//*[@forminputname='producerOrEditor']//span[contains(text(),'<<whoIsEditing>>')]";

	@FindBy(xpath = "//*[@forminputname='locationofEdit']//input")
	WebElement locationofEdit;

	String ediusOrAvid = "//*[@forminputname='ediusOrAvid']//label[@label-value='<<ediusOrAvidName>>']";

	@FindBy(xpath = "//*[@forminputname='editStartDate']//input")
	WebElement editStartDate;

	@FindBy(xpath = "//*[@formcontrolname='craftTimeFlexible']//input")
	WebElement editTimeNeededFlexible;

	@FindBy(xpath = "//*[contains(text(),'Type of Edit')]/parent::button")
	WebElement typeOfEditAddButton;

	String typeOfEdit = "(//*[@placeholder='Select Type of Edits']//input)[<<typeOfEditNo>>]";

	String typeOfEditQuantity = "(//*[@label='Quantity']//input)[<<typeOfEditQuantityNo>>]";

	@FindBy(xpath = "//input[@placeholder='Enter Other']")
	WebElement typeOfEditXpathOtherInputBox;

	@FindBy(xpath = "//*[@forminputname='sfComments']//textarea")
	WebElement commentTextArea;

	@FindBy(xpath = "//*[@label='Room']//input")
	public WebElement editorSearchRoomTextbox;

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	MyRequestPage myRequestPage = new MyRequestPage();

	WebDriver driver = DriverFactory.getCurrentDriver();

	public EditSelfReportingRequestFormPage() {
		PageFactory.initElements(DriverFactory.getCurrentDriver(), this);
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
			if (date.trim() != null) {
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

	public int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
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
					.findElement(By.xpath("//*[contains(@class,'modal-confirm-content')]/descendant::p[2]"));
			Waits.waitForElement(requestNumberWebElement, WAIT_CONDITIONS.VISIBLE);
			requestNumber = WebAction.getText(requestNumberWebElement).trim();
			System.out.println(requestNumber);
			Constants.setRequestNumber(requestNumber);
			ReportGenerate.test.log(Status.INFO,
					"User submitted the request successfully and the request ID - " + requestNumber);
			if (requestNumber.isEmpty())
				throw new Exception("Submitted request ID is not present in success pop up");
		} catch (Exception e) {
			// AllureUtility.captureScreenshot("Request ID not present in success pop up");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To fill Air date & Time in general details section
	 * 
	 * @param commentText - slug for this form
	 * @throws Exception
	 */
	public void addAirDateTimeInfoInESR(String airDateText, String editDateText) throws Exception {

		try {
			// To fill air Date
			if (airDateText != null && !(airDateText.equalsIgnoreCase("TBD"))) {
				Constants.setAirDate(generateDate(airDateText, "M/d/yyyy"));
				WebAction.click(airDate);
				WebAction.sendKeys(airDate, generateDate(airDateText, "MM-dd-yyyy"));
				WebAction.keyPress(airDate, "Enter");
				ReportGenerate.test.log(Status.INFO, "User selects the air date as " + airDateText);
			}
			if (airDateText.equalsIgnoreCase("TBD")) {
				WebAction.clickUsingJs(airDateTBDCheckBox);
				Constants.setAirDate("TBD");
			}

			// To fill edit date
			if (editDateText != null) {
				WebAction.click(editDate);
				WebAction.sendKeys(editDate, generateDate(editDateText, "MM-dd-yyyy"));
				WebAction.keyPress(editDate, "Enter");
				ReportGenerate.test.log(Status.INFO, "User selects the edit date as " + editDateText);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To fill edit Type
	 * 
	 * @throws Exception
	 */
	public void selectWhoIsEditing(String whoIsEditingText) throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			if (whoIsEditingText != null) {
				String selectWhoIsEditingButtonXpath = whoIsEditingType.replace("<<whoIsEditing>>", whoIsEditingText);
				WebAction.click(driver.findElement(By.xpath(selectWhoIsEditingButtonXpath)));
				Constants.setWhoIsEditing(whoIsEditingText);
				ReportGenerate.test.log(Status.INFO, "User selects " + whoIsEditingText + " as Who Is Editing option");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillCommentInEditSelfReporting(String commentText) throws Exception {
		try {
			WebAction.scrollIntoView(locationofEdit);
			if (commentText != null) {
				Waits.waitForElement(commentTextArea, WAIT_CONDITIONS.CLICKABLE);
				WebAction.sendKeys(commentTextArea, commentText);
				ReportGenerate.test.log(Status.INFO, "User enters " + commentText + " as in comments section");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillLocationInfoInESR(String locationText, String roomText) throws Exception {
		try {
			// To select location
			if (locationText != null) {
				boolean valuePresent = false;
				WebAction.click(locationofEdit);
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(locationText)) {
						WebAction.click(ele);
						valuePresent = true;
						ReportGenerate.test.log(Status.INFO,
								"User selects " + locationText + " as Location Of Edit option");
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception("'" + locationText + "' value is not present in the location drop down");
			}
			Thread.sleep(1000);
			if (roomText != null) {
				boolean valuePresent = false;
				WebAction.click(editorSearchRoomTextbox);
				WebAction.sendKeys(editorSearchRoomTextbox, roomText);
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(roomText)) {
						WebAction.click(ele);
						ReportGenerate.test.log(Status.INFO, "User selects " + roomText + " as Room option");
						valuePresent = true;
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception("'" + roomText + "' value is not present in the room drop down");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void actualEnteredIntoStormAndDivision() throws Exception {
		producerDashboardGeneralPage.clickButton("My Request Dashboard Page");
		myRequestPage.clickRequestIdLink();
		try {
			// actual entered into storm
			String enteredIntoStormXpath = "//*[@class='stormInfo']//i";
			WebElement enteredIntoStormWebElement = driver.findElement(By.xpath(enteredIntoStormXpath));
			Waits.waitForElement(enteredIntoStormWebElement, WAIT_CONDITIONS.VISIBLE);
			String enteredIntoStorm = enteredIntoStormWebElement.getAttribute("nztype");
			Constants.setEnteredIntoStorm(enteredIntoStorm);

			// actual division
			String divisionXpath = "//*[@sectiontitle='General Details']//p[contains(@class,'division-text')]";
			WebElement divisionWebElement = driver.findElement(By.xpath(divisionXpath));
			Waits.waitForElement(divisionWebElement, WAIT_CONDITIONS.VISIBLE);
			String division = divisionWebElement.getText();
			Constants.setDivision(division);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyEditSelfReportingRequestValuesWithEditSelfReportingDashboardValues(String ShowUnitText,
			String airDateText, String WhoIsEditingText, String SubmittedText) throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			String columnCellString = "//*[contains(text(),'<<RequestId>>')]/ancestor::tr/td[<<ColumnTypeNo>>]";
			String columnTypeNoText;

			// To validate entered into storm Cell column
			if (Constants.getEnteredIntoStorm() != null) {
				columnTypeNoText = "2";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/span//*[local-name()='svg']");
				String actualEnteredIntoStormColumn = WebAction
						.getAttribute(driver.findElement(By.xpath(columnCellTypeText)), "data-icon");
				String expectedEnteredIntoStormColumn[] = Constants.getEnteredIntoStorm().split("-");
				Assert.assertTrue(actualEnteredIntoStormColumn.contains(expectedEnteredIntoStormColumn[0]),
						"Expected entered into storm icon is " + expectedEnteredIntoStormColumn[0]
								+ " and actual entered into storm icon is " + actualEnteredIntoStormColumn);
				ReportGenerate.test.log(Status.INFO, expectedEnteredIntoStormColumn[0]
						+ " icon is displying for entered into storm column in the dashboard");

			}
			// To validate show unit
			if (ShowUnitText != null) {
				columnTypeNoText = "3";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String showCellTypeText = columnCellTypeText.concat("/span/span");
				List<String> showList = Constants.getMultipleShowUnits();
				if (showList.get(0).length() > 32) {
					WebElement showArrayListWebelement = driver.findElement(By.xpath(showCellTypeText));
					Waits.waitForElement(showArrayListWebelement, WAIT_CONDITIONS.VISIBLE);
					Thread.sleep(1000);
					WebAction.click(showArrayListWebelement);
					String showNamesXpath = "((//div[contains(@class,'tooltip')])[last()]//li)[1]";
					showCellTypeText = showNamesXpath;
				}
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(showCellTypeText,
						showList.get(0));
			}

			// To validate division
			if (Constants.getDivision() != null) {
				columnTypeNoText = "4";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String expectedDivision = Constants.getDivision();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						expectedDivision);
			}

			// To validate submitter
			columnTypeNoText = "5";
			String defaultRequesterNamecolumnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/span/span/a");
			String defaultSubmitterName = Constants.getDefaultRequesterName();
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
					defaultRequesterNamecolumnCellTypeText, defaultSubmitterName);

			// To validate air date
			if (airDateText != null) {
				columnTypeNoText = "6";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String date = Constants.getAirtDate();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						date);
			}

			// To validate who is editing
			if (WhoIsEditingText != null) {
				columnTypeNoText = "7";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String whoIsEditing = Constants.getWhoIsEditing();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						whoIsEditing);
			}

			// To validate type of edit and quantity
			String columnCellTypeText;
			int totalQuantityCount = 0;
			List<String> typeofEditsColumnNoList = new ArrayList<String>();
			List<String> typeofEditsList = Constants.getTypeofEdits();
			List<String> typeofEditsQuantityList = Constants.getTypeofEditsQuantity();
			for (String typeofEdits : typeofEditsList) {
				switch (typeofEdits.toUpperCase()) {
				case "PACKAGE":
					columnTypeNoText = "8";
					break;
				case "PROMO":
					columnTypeNoText = "9";
					break;
				case "OPEN/TEASES":
					columnTypeNoText = "10";
					break;
				case "VOS/SOTS":
					columnTypeNoText = "11";
					break;
				case "PODCAST":
					columnTypeNoText = "12";
					break;
				case "DIGITAL/WEB":
					columnTypeNoText = "13";
					break;
				case "FIXES":
					columnTypeNoText = "14";
					break;
				case "SHOW BUILD":
					columnTypeNoText = "15";
					break;
				case "SHOW UPDATE":
					columnTypeNoText = "16";
					break;
				case "OTHER":
					columnTypeNoText = "17";
					break;
				}
				typeofEditsColumnNoList.add(columnTypeNoText);
			}
			for (int i = 0; i < typeofEditsList.size(); i++) {
				columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", typeofEditsColumnNoList.get(i));
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						typeofEditsQuantityList.get(i));
				totalQuantityCount = totalQuantityCount + Integer.parseInt(typeofEditsQuantityList.get(i));
			}

			// To validate total type of edit quantity
			String totalQuantityCountText = Integer.toString(totalQuantityCount);
			columnTypeNoText = "18";
			String totalQuantityTypeOfEditColumnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
					totalQuantityTypeOfEditColumnCellTypeText, totalQuantityCountText);

			// To validate submitted date
			if (SubmittedText != null) {
				columnTypeNoText = "19";
				String submittedColumnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/div[1]");
				String expecteddate = generateDate(SubmittedText, "MM/dd/yyyy");
				String actualSubmittedColumn = WebAction
						.getText(driver.findElement(By.xpath(submittedColumnCellTypeText)));
				String actualSubmittedColumnText[];
				if (actualSubmittedColumn.contains(" ")) {
					actualSubmittedColumnText = actualSubmittedColumn.split(" ");
				} else {
					actualSubmittedColumnText = new String[1];
					actualSubmittedColumnText[0] = actualSubmittedColumn;
				}
				Assert.assertTrue(actualSubmittedColumnText[0].contains(expecteddate), "Expected submitted date is "
						+ expecteddate + " and actual submitted date is " + actualSubmittedColumnText[0]);
				ReportGenerate.test.log(Status.INFO,
						expecteddate + " date is displying for submitted column in the dashboard");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}