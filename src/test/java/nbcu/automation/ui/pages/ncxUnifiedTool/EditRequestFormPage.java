
package nbcu.automation.ui.pages.ncxUnifiedTool;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
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
import nbcu.automation.ui.pojos.ncxUnifiedTool.TalentRecord;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.factory.DriverFactory;
import nbcu.framework.utils.Other.DateFunctions;
import nbcu.framework.utils.cucumber.CucumberUtils;
import nbcu.framework.utils.report.ReportGenerate;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;
import nbcu.framework.utils.ui.WebAction;

public class EditRequestFormPage {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	WebDriver driver = DriverFactory.getCurrentDriver();

	String editType = "//*[@forminputname='editType']//span[contains(text(),'<<editTypeName>>')]";

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

	@FindBy(xpath = "//*[@forminputname='airTime']//input")
	WebElement airTime;

	@FindBy(xpath = "//*[@formcontrolname='airTimeFlexible']//input")
	WebElement airTimeFlexibleCheckBox;

	@FindBy(xpath = "//*[@forminputname='dateOfFirstScreening']//input")
	WebElement dateOfFirstScreening;

	@FindBy(xpath = "//*[@forminputname='pieceVersions']//input")
	WebElement lengthOfShowPieceNoOfActs;

	@FindBy(xpath = "//*[@forminputname='pieceHours']//input")
	WebElement lengthOfShowPieceHours;

	@FindBy(xpath = "//*[@forminputname='pieceMinutes']//input")
	WebElement lengthOfShowPieceMinutes;

	@FindBy(xpath = "//*[@forminputname='pieceSeconds']//input")
	WebElement lengthOfShowPieceSeconds;

	@FindBy(xpath = "//*[@forminputname='locationofEdit']//input")
	WebElement locationofEdit;

	String ediusOrAvid = "//*[@forminputname='ediusOrAvid']//label[@label-value='<<ediusOrAvidName>>']";

	@FindBy(xpath = "//*[@forminputname='editStartDate']//input")
	WebElement editStartDate;

	@FindBy(xpath = "//*[@forminputname='requestedEditSection']//input")
	WebElement reqStartTime;

	@FindBy(xpath = "//*[@forminputname='numberOfEditors']//input")
	WebElement noOfEditors;

	@FindBy(xpath = "//*[@forminputname='craftEditWeeks']//input")
	WebElement editTimeNeededWeeks;

	@FindBy(xpath = "//*[@forminputname='craftEditDays']//input")
	WebElement editTimeNeededDays;

	@FindBy(xpath = "//*[@forminputname='craftEditHours']//input")
	WebElement editTimeNeededHours;

	@FindBy(xpath = "//*[@forminputname='craftEditMinutes']//input")
	WebElement editTimeNeededMinutes;

	@FindBy(xpath = "//*[@formcontrolname='craftTimeFlexible']//input")
	WebElement editTimeNeededFlexible;

	@FindBy(xpath = "//*[contains(text(),'Type of Edit')]/parent::button | //*[contains(text(),'Type')]/parent::button")
	WebElement typeOfEditAddButton;

	String typeOfEdit = "(//*[@placeholder='Select Type of Edits']//input)[<<typeOfEditNo>>]";

	String typeOfEditQuantity = "(//*[@label='Quantity']//input)[<<typeOfEditQuantityNo>>]";

	@FindBy(xpath = "//input[@placeholder='Enter Other' or @placeholder='Other type of edit']")
	WebElement typeOfEditXpathOtherInputBox;

	@FindBy(xpath = "//*[@forminputname='pieceVersions']//input")
	WebElement howManyVersions;

	String additionalRequirements = "//*[@forminputname='addionalRequirement']//span[text()='<<AdditionalRequirementsName>>']/ancestor::div[1]//input[@type='checkbox']";

	@FindBy(xpath = "//*[@forminputname='arOtherText']//input")
	WebElement additionalRequirementsOtherText;

	String finalDelivery = "//*[@forminputname='finalDelivery']//span[text()='<<finalDeliveryName>>']/ancestor::div[1]//input[@type='checkbox']";

	@FindBy(xpath = "//*[@forminputname='fdOtherText']//input")
	WebElement finalDeliveryOtherText;

	String sourceMaterial = "//*[@forminputname='sourceMaterial']//span[text()='<<SourceMaterialName>>']/ancestor::div[1]//input[@type='checkbox']";

	@FindBy(xpath = "//*[@forminputname='sourceMaterialOther']//input")
	WebElement sourceMaterialOtherText;

	@FindBy(xpath = "//label[contains(text(),'Crash Edit Needed')]/ancestor::div[2]//input[@type='checkbox']")
	WebElement isCrashEdit_Yes;

	@FindBy(xpath = "//*[@forminputname='lfComments' or @forminputname='craftEditComments']//textarea")
	WebElement commentTextArea;

	@FindBy(xpath = "//*[contains(text(),'Req same as Assistant Producer')]//ancestor::div[2]//input[@type='checkbox']")
	WebElement asstProducerSameasRequestor_Options;

	@FindBy(xpath = "//*[@label='Assistant Producer']//input")
	WebElement asstProducerSameAsRequestInputBox;

	@FindBy(xpath = "//*[contains(text(),'Additional Recipient')]")
	WebElement addRecipientButton;

	String additionalRecipientsInputBox = "(//*[@placeholder='Enter Recipient Email' or @placeholder='Enter Additional Reciptant']//input)[<<additionalRecipientsInputBoxNo>>]";

	@FindBy(xpath = "//*[@forminputname='fIStatus' or @forminputname='feedOutStatus' or @forminputname='erRequestStatus' or @forminputname='fulFillerStatus']//input")
	WebElement requestStatusDropDown;

	@FindBy(xpath = "//label[contains(text(),'FULFILLMENT COMMENTS')]//ancestor::div[1]//span[contains(text(),'ADD')]")
	WebElement fulfillmentCommentAddButton;

	@FindBy(xpath = "//label[contains(text(),'FULFILLMENT COMMENTS')]//ancestor::div[1]//textarea")
	WebElement fulfillmentCommentTextArea;

	@FindBy(xpath = "//*[@label='Editor Information']//input[@placeholder='Search for Editor']")
	public WebElement editorNameTextbox;

	@FindBy(xpath = "//*[@label='Editor Information']//parent::div//*[@forminputname='phoneNumber']//input")
	public WebElement editorPhoneNumberTextbox;

	@FindBy(xpath = "//*[@label='Room']//input")
	public WebElement editorSearchRoomTextbox;

	@FindBy(xpath = "//*[@formcontrolname='sessionAssignedFromDateToDate']//input[@placeholder='Start date']")
	WebElement sessionEditorStartDate;

	@FindBy(xpath = "//*[@formcontrolname='sessionAssignedFromDateToDate']//input[@placeholder='End date']")
	WebElement sessionEditorEndDate;

	@FindBy(xpath = "//*[@forminputname='sessionAssignedFromTime']//input[@placeholder='Select time']")
	WebElement sessionEditorStartTime;

	@FindBy(xpath = "//*[@forminputname='sessionAssignedToTime']//input[@placeholder='Select time']")
	WebElement sessionEditorEndTime;

	@FindBy(xpath = "//label[@formcontrolname='differentRoom']//input")
	public WebElement editorDifferentRoomCheckbox;

	@FindBy(xpath = "//label[@formcontrolname='differentRoom']//ancestor::div[3]//*[@label='Room']//input")
	public WebElement editorDifferentSearchRoomTextbox;

	@FindBy(xpath = "//label[contains(text(),'EDITOR CONTROLS')]//ancestor::div[1]//span[contains(text(),'Editor')]")
	public WebElement addEditorButton;

	public EditRequestFormPage() {
		PageFactory.initElements(DriverFactory.getCurrentDriver(), this);
	}

	/**
	 * To fill edit Type
	 * 
	 * @throws Exception
	 */
	public void selectEditType(String editTypeText) throws Exception {
		try {
			String selectEditTypeButtonXpath = "";
			switch (editTypeText.toUpperCase()) {
			case "STANDARD":
				selectEditTypeButtonXpath = editType.replace("<<editTypeName>>", "Standard");
				break;
			case "LONG FORM":
				selectEditTypeButtonXpath = editType.replace("<<editTypeName>>", "Long");
				break;
			}
			WebAction.click(driver.findElement(By.xpath(selectEditTypeButtonXpath)));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addShowInfoInECM(String showTitleText, String budgetCodeText) throws Exception {
		try {
			if (!(Constants.getFormType().equalsIgnoreCase("Edit Self Reporting"))) {
				WebAction.scrollIntoView(producerDashboardGeneralPage.talentSection);
			}

			if (Constants.getFormType().equalsIgnoreCase("Edit Self Reporting")) {
				// actual default requester name
				String submitterXpath = "//*[@sectiontitle='General Details']//*[contains(text(),' Submitter ')]/following-sibling::div";
				WebElement submitterWebElement = driver.findElement(By.xpath(submitterXpath));
				Waits.waitForElement(submitterWebElement, WAIT_CONDITIONS.VISIBLE);
				String submitter = submitterWebElement.getText();
				Constants.setDefaultRequesterName(submitter);
			}

			// To select show unit or budget code
			String showTitleTextArrayList[] = null;
			String budgetCodeTextArrayList[] = null;
			List<String> showNameStringList = new ArrayList<>();
			List<String> budgetCodeNameStringList = new ArrayList<>();
			String showName;
			String budgetCodeName;
			String showTitleXpath;
			WebElement showTitle;
			String budgetCodeTitleXpath;
			WebElement budgetCode;
			int showTitleArrayLength = 0;
			if (showTitleText != null) {
				if (showTitleText.contains(",")) {
					showTitleTextArrayList = showTitleText.split(",");
				} else {
					showTitleTextArrayList = new String[1];
					showTitleTextArrayList[0] = showTitleText;
				}
				showTitleArrayLength = showTitleTextArrayList.length;
				for (int i = 0; i < showTitleTextArrayList.length; i++) {
					showTitleXpath = showTitleString.replace("<<showUnitNo>>", Integer.toString(i + 1));
					showTitle = driver.findElement(By.xpath(showTitleXpath));
					budgetCodeTitleXpath = budgetCodeTitleString.replace("<<budgetCodeNo>>", Integer.toString(i + 1));
					budgetCode = driver.findElement(By.xpath(budgetCodeTitleXpath));
					Waits.waitForElement(showTitle, WAIT_CONDITIONS.CLICKABLE);
					WebAction.sendKeys(showTitle, showTitleTextArrayList[i].trim());
					Waits.waitUntilElementSizeGreater(SearchList, 0);
					Thread.sleep(1000);
					WebAction.click(SearchList.get(0));
					ReportGenerate.test.log(Status.INFO,
							"User enters show unit as " + showTitleTextArrayList[i].trim() + " in form");
					Thread.sleep(1000);
					showName = WebAction.getAttribute(showTitle, "value").trim();
					showNameStringList.add(showName);
					Constants.setMultipleShowUnits(showNameStringList);
					budgetCodeName = WebAction.getAttribute(budgetCode, "value").trim();
					budgetCodeNameStringList.add(budgetCodeName);
					Constants.setMultipleBudgetCodes(budgetCodeNameStringList);
					if (i < (showTitleTextArrayList.length - 1)) {
						Waits.waitForElement(showTitleAddButton, WAIT_CONDITIONS.CLICKABLE);
						WebAction.click(showTitleAddButton);
					}
				}
			}
			if (budgetCodeText != null) {
				if (budgetCodeText.contains(",")) {
					budgetCodeTextArrayList = budgetCodeText.split(",");
				} else {
					budgetCodeTextArrayList = new String[1];
					budgetCodeTextArrayList[0] = budgetCodeText;
				}
				if (showTitleText != null) {
					Waits.waitForElement(showTitleAddButton, WAIT_CONDITIONS.CLICKABLE);
					WebAction.click(showTitleAddButton);
				}
				for (int i = showTitleArrayLength; i < (showTitleArrayLength + budgetCodeTextArrayList.length); i++) {

					budgetCodeTitleXpath = budgetCodeTitleString.replace("<<budgetCodeNo>>", Integer.toString(i + 1));
					budgetCode = driver.findElement(By.xpath(budgetCodeTitleXpath));
					showTitleXpath = showTitleString.replace("<<showUnitNo>>", Integer.toString(i + 1));
					showTitle = driver.findElement(By.xpath(showTitleXpath));
					Waits.waitForElement(budgetCode, WAIT_CONDITIONS.CLICKABLE);
					WebAction.sendKeys(budgetCode, budgetCodeTextArrayList[i - showTitleArrayLength].trim());
					Waits.waitUntilElementSizeGreater(SearchList, 0);
					Thread.sleep(1000);
					WebAction.click(SearchList.get(0));
					ReportGenerate.test.log(Status.INFO, "User enters budget code as "
							+ budgetCodeTextArrayList[i - showTitleArrayLength].trim() + " in form");
					Thread.sleep(1000);
					budgetCodeName = WebAction.getAttribute(budgetCode, "value").trim();
					budgetCodeNameStringList.add(budgetCodeName);
					Constants.setMultipleBudgetCodes(budgetCodeNameStringList);
					showName = WebAction.getAttribute(showTitle, "value").trim();
					showNameStringList.add(showName);
					Constants.setMultipleShowUnits(showNameStringList);
					if (i < (showTitleArrayLength + budgetCodeTextArrayList.length - 1)) {
						Waits.waitForElement(showTitleAddButton, WAIT_CONDITIONS.CLICKABLE);
						WebAction.click(showTitleAddButton);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
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

	/**
	 * To generate time based on input. Time should like CurrentTime+1,
	 * CurrentTime-2, etc.,
	 * 
	 * @param time   - time
	 * @param format - time format
	 * @return
	 * @throws Exception
	 */
	public String generateTime(String time, String format) throws Exception {
		String updatedTime = "";
		try {
			if (time.trim() != null) {
				if (time.toUpperCase().contains("CURRENTTIME")) {
					String hours = time.replaceAll("[a-zA-Z]", "").trim();
					if (hours.length() == 0) {
						hours = "0";
					}
					updatedTime = DateFunctions.addOrMinusTimeFromCurrentTime(format, hours);
				} else
					updatedTime = time;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return updatedTime;
	}

	public int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	/**
	 * To fill Air date & Time in general details section
	 * 
	 * @param commentText - slug for this form
	 * @throws Exception
	 */

	public void addAirDateTimeInfo(String airDateText, String airTimeText) throws Exception {

		try {
			// WebAction.scrollIntoView(airDate);
			// To fill air Date
			if (airDateText != null && !(airDateText.equalsIgnoreCase("TBD"))) {
				Constants.setAirDate(generateDate(airDateText, "M/d/yyyy"));
				WebAction.click(airDate);
				WebAction.sendKeys(airDate, generateDate(airDateText, "MM/dd/yyyy"));
				WebAction.keyPress(airDate, "Enter");
				ReportGenerate.test.log(Status.INFO, "User selects the air date as " + airDateText);
				Constants.setShootStartDate(generateDate(airDateText, "M/d/yyyy"));
			}
			if (airDateText.equalsIgnoreCase("TBD")) {
				WebAction.clickUsingJs(airDateTBDCheckBox);
				ReportGenerate.test.log(Status.INFO, "User selects To Be Determined option for air date");
				Constants.setAirDate("TBD");
				Constants.setShootStartDate("TBD");
			}

			// To fill air time
			if (airTimeText != null && !(airTimeText.equalsIgnoreCase("FLEXIBLE"))) {
				Constants.setAirTime(generateTime(airTimeText, "h:mm a"));
				WebAction.click(airTime);
				WebAction.sendKeys(airTime, generateTime(airTimeText, "hh:mm a"));
				ReportGenerate.test.log(Status.INFO, "User selects the air time as " + airTimeText);
			}
			if (airTimeText.equalsIgnoreCase("FLEXIBLE")) {
				WebAction.clickUsingJs(airTimeFlexibleCheckBox);
				ReportGenerate.test.log(Status.INFO, "User selects Flexible option for air time");
				Constants.setAirTime("FLEXIBLE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void fillDateofFirstScreening(String dateofFirstScreeningText) throws Exception {
		// To fill date of First Screening
		if (dateofFirstScreeningText != null) {
			WebAction.click(dateOfFirstScreening);
			WebAction.sendKeys(dateOfFirstScreening, generateDate(dateofFirstScreeningText, "MM/dd/yyyy"));
			WebAction.keyPress(dateOfFirstScreening, "Enter");
		}
	}

	public void filllengthOfShowInfoNoOfActs(String lengthOfShowNoOfActsText) throws Exception {
		// To fill length of show
		if (lengthOfShowNoOfActsText != null) {
			WebAction.sendKeys(lengthOfShowPieceNoOfActs, lengthOfShowNoOfActsText);
		}
	}

	public void filllengthOfShowInfoHours(String lengthOfShowHoursText) throws Exception {
		// To fill length of show
		if (lengthOfShowHoursText != null) {
			WebAction.sendKeys(lengthOfShowPieceHours, lengthOfShowHoursText);
		}
	}

	public void filllengthOfShowInfoMinutes(String lengthOfShowMinutesText) throws Exception {
		// To fill length of show
		if (lengthOfShowMinutesText != null) {
			WebAction.sendKeys(lengthOfShowPieceMinutes, lengthOfShowMinutesText);
		}
	}

	public void filllengthOfShowInfoSeconds(String lengthOfShowSecondsText) throws Exception {
		// To fill length of show
		if (lengthOfShowSecondsText != null) {
			WebAction.sendKeys(lengthOfShowPieceSeconds, lengthOfShowSecondsText);
		}
	}

	public void fillLocationOfEdit(String locationText) throws Exception {
		try {
			// WebAction.scrollIntoView(locationofEdit);
			// To select location
			if (locationText != null) {
				boolean valuePresent = false;
				Constants.setLocations(locationText);
				WebAction.click(locationofEdit);
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(locationText)) {
						WebAction.click(ele);
						valuePresent = true;
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception("'" + locationText + "' value is not present in the location drop down");
			}
			Thread.sleep(2000);
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
	public void selectediusOrAvid(String ediusOrAvidText) throws Exception {
		try {
			String ediusOrAvidButtonXpath = "";
			switch (ediusOrAvidText.toUpperCase()) {
			case "EDIUS":
				ediusOrAvidButtonXpath = ediusOrAvid.replace("<<ediusOrAvidName>>", "Edius");
				break;
			case "AVID":
				ediusOrAvidButtonXpath = ediusOrAvid.replace("<<ediusOrAvidName>>", "Avid");
				break;
			}
			WebAction.click(driver.findElement(By.xpath(ediusOrAvidButtonXpath)));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillEditStartDate(String editStartDateText) throws Exception {
		// To fill edit Start Date
		if (editStartDateText != null) {
			Constants.setEditStartDate(generateDate(editStartDateText, "MM/dd/yyyy"));
			WebAction.click(editStartDate);
			WebAction.sendKeys(editStartDate, generateDate(editStartDateText, "MM/dd/yyyy"));
			WebAction.keyPress(editStartDate, "Enter");
		}
	}

	public void fillReqStartTime(String reqStartTimeText) throws Exception {
		// To fill req start time
		if (reqStartTimeText != null) {
			WebAction.click(reqStartTime);
			WebAction.sendKeys(reqStartTime, generateTime(reqStartTimeText, "hh:mm:ss"));
		}
	}

	public void fillNoOfEditors(String noOfEditorsText) throws Exception {

		// To fill no of editors
		if (noOfEditorsText != null) {
			WebAction.sendKeys(noOfEditors, noOfEditorsText);
		}
	}

	public void fillEditTimeNeededInfoInStandard(String editTimeNeededDaysText, String editTimeNeededHoursText,
			String editTimeNeededMinutesText) throws Exception {
		try {
			// To fill edit Time Needed
			if (editTimeNeededDaysText != null || editTimeNeededHoursText != null
					|| editTimeNeededMinutesText != null) {
				WebAction.sendKeys(editTimeNeededDays, editTimeNeededDaysText);
				WebAction.sendKeys(editTimeNeededHours, editTimeNeededHoursText);
				WebAction.sendKeys(editTimeNeededMinutes, editTimeNeededMinutesText);
			} else {
				WebAction.clickUsingJs(editTimeNeededFlexible);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillEditTimeNeededInfoInLong(String editTimeNeededWeeksText, String editTimeNeededDaysText,
			String editTimeNeededHoursText) throws Exception {
		try {
			// To fill edit Time Needed
			if (editTimeNeededWeeksText != null || editTimeNeededDaysText != null || editTimeNeededHoursText != null) {
				WebAction.sendKeys(editTimeNeededWeeks, editTimeNeededWeeksText);
				WebAction.sendKeys(editTimeNeededDays, editTimeNeededDaysText);
				WebAction.sendKeys(editTimeNeededHours, editTimeNeededHoursText);
			} else {
				WebAction.clickUsingJs(editTimeNeededFlexible);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillTypeOfEditDetails(String typeOfEditText, String typeOfEditQuantityText) throws Exception {
		try {
			// To select Type Of Edit
			String[] typeOfEditTextArrayList;
			String[] typeOfEditQuantityTextArrayList;
			List<String> typeOfEditNameStringList = new ArrayList<>();
			List<String> typeOfEditQuantityNameStringList = new ArrayList<>();
			if (typeOfEditText != null) {
				if (typeOfEditText.contains(",")) {
					typeOfEditTextArrayList = typeOfEditText.split(",");
				} else {
					typeOfEditTextArrayList = new String[1];
					typeOfEditTextArrayList[0] = typeOfEditText;
				}
				int j = 1;
				for (int i = 0; i < typeOfEditTextArrayList.length; i++) {
					String typeOfEditXpath = typeOfEdit.replace("<<typeOfEditNo>>", Integer.toString(i + 1));
					WebElement typeOfEditWebElement = driver.findElement(By.xpath(typeOfEditXpath));
					Waits.waitForElement(typeOfEditWebElement, WAIT_CONDITIONS.CLICKABLE);

					String typeOfEditQuantityXpath = typeOfEditQuantity.replace("<<typeOfEditQuantityNo>>",
							Integer.toString(i + 1));
					WebElement typeOfEditQuantityWebElement = driver.findElement(By.xpath(typeOfEditQuantityXpath));
					Waits.waitForElement(typeOfEditQuantityWebElement, WAIT_CONDITIONS.CLICKABLE);

					WebAction.click(typeOfEditWebElement);
					Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
					for (WebElement ele : dropDownvalues) {
						if (typeOfEditTextArrayList[i].trim().toUpperCase().contains("OTHER")
								&& WebAction.getAttribute(ele, "title").equalsIgnoreCase("Other")) {
							WebAction.click(ele);
							typeOfEditNameStringList.add(typeOfEditTextArrayList[i]);
							Constants.setTypeofEdits(typeOfEditNameStringList);
							if (typeOfEditQuantityText != null) {
								if (typeOfEditText.contains(",")) {
									typeOfEditQuantityTextArrayList = typeOfEditQuantityText.split(",");
								} else {
									typeOfEditQuantityTextArrayList = new String[1];
									typeOfEditQuantityTextArrayList[0] = typeOfEditQuantityText;
								}
								WebAction.sendKeys(typeOfEditQuantityWebElement, "\u0008");
								WebAction.sendKeys(typeOfEditQuantityWebElement, typeOfEditQuantityTextArrayList[i]);
								typeOfEditQuantityNameStringList.add(typeOfEditQuantityTextArrayList[i]);
								Constants.setTypeofEditsQuantity(typeOfEditQuantityNameStringList);
							}
							WebAction.sendKeys(typeOfEditXpathOtherInputBox, typeOfEditTextArrayList[i]);
							break;
						}
						if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(typeOfEditTextArrayList[i].trim())) {
							WebAction.click(ele);
							typeOfEditNameStringList.add(typeOfEditTextArrayList[i]);
							Constants.setTypeofEdits(typeOfEditNameStringList);
							if (typeOfEditQuantityText != null) {
								if (typeOfEditText.contains(",")) {
									typeOfEditQuantityTextArrayList = typeOfEditQuantityText.split(",");
								} else {
									typeOfEditQuantityTextArrayList = new String[1];
									typeOfEditQuantityTextArrayList[0] = typeOfEditQuantityText;
								}
								WebAction.sendKeys(typeOfEditQuantityWebElement, "\u0008");
								WebAction.sendKeys(typeOfEditQuantityWebElement, typeOfEditQuantityTextArrayList[i]);
								typeOfEditQuantityNameStringList.add(typeOfEditQuantityTextArrayList[i]);
								Constants.setTypeofEditsQuantity(typeOfEditQuantityNameStringList);
							}
							break;
						}
					}
					Thread.sleep(1000);
					if (j <= typeOfEditTextArrayList.length - 1
							&& typeOfEditAddButton.getAttribute("class").contains("ant-btn-dashed")) {
						Waits.waitForElement(typeOfEditAddButton, WAIT_CONDITIONS.CLICKABLE);
						WebAction.click(typeOfEditAddButton);
						j++;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To fill How Many Versions? section
	 * 
	 * @param How Many Versions?
	 * @throws Exception
	 */
	public void fillHowManyVersions(String HowManyVersionsText) throws Exception {
		try {
			// To enter How Many Versions
			if (HowManyVersionsText != null) {
				WebAction.sendKeys(howManyVersions, HowManyVersionsText);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To fill Additional Requirements
	 * 
	 * @throws Exception
	 */
	public void fillAdditionalRequirementsDetails(String additionalRequirementsText) throws Exception {
		try {
			// To select final Delivery
			if (additionalRequirementsText != null) {
				String[] additionalRequirementsTextArrayList = additionalRequirementsText.split(",");
				for (int i = 0; i < additionalRequirementsTextArrayList.length; i++) {
					String additionalRequirementsXpath = additionalRequirements
							.replace("<<AdditionalRequirementsName>>", additionalRequirementsTextArrayList[i]);
					try {
						WebAction.clickUsingJs(driver.findElement(By.xpath(additionalRequirementsXpath)));
					} catch (Exception e) {
						WebAction.sendKeys(additionalRequirementsOtherText, additionalRequirementsTextArrayList[i]);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To fill Is this a Crash Edit section
	 * 
	 * @param Is this a Crash Edit?
	 * @throws Exception
	 */
	public void fillIsthisaCrashEditDetails(String isthisaCrashEditText) throws Exception {
		// To select Is this a Crash Edit?
		if (isthisaCrashEditText != null && isthisaCrashEditText.equalsIgnoreCase("Yes"))
			WebAction.clickUsingJs(isCrashEdit_Yes);
		Constants.setCrashEditNeeded(isthisaCrashEditText);
	}

	/**
	 * To fill final delivery
	 * 
	 * @throws Exception
	 */
	public void fillFinalDeliveryDetails(String finalDeliveryText) throws Exception {
		try {
			// To select final Delivery
			if (finalDeliveryText != null) {
				String[] finalDeliveryTextArrayList = finalDeliveryText.split(",");
				for (int i = 0; i < finalDeliveryTextArrayList.length; i++) {
					String finalDeliveryXpath = finalDelivery.replace("<<finalDeliveryName>>",
							finalDeliveryTextArrayList[i]);
					try {
						WebAction.clickUsingJs(driver.findElement(By.xpath(finalDeliveryXpath)));
					} catch (Exception e) {
						WebAction.sendKeys(finalDeliveryOtherText, finalDeliveryTextArrayList[i]);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillsourceMaterialDetails(String sourceMaterialText) throws Exception {
		try {
			// To select source Material
			if (sourceMaterialText != null) {
				String[] sourceMaterialTextArrayList = sourceMaterialText.split(",");
				for (int i = 0; i < sourceMaterialTextArrayList.length; i++) {
					String sourceMaterialXpath = sourceMaterial.replace("<<SourceMaterialName>>",
							sourceMaterialTextArrayList[i]);
					try {
						WebAction.clickUsingJs(driver.findElement(By.xpath(sourceMaterialXpath)));
					} catch (Exception e) {
						WebAction.sendKeys(sourceMaterialOtherText, sourceMaterialTextArrayList[i]);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillCommentInEdit(String commentText) throws Exception {
		try {
			if (commentText != null) {
				Waits.waitForElement(commentTextArea, WAIT_CONDITIONS.CLICKABLE);
				WebAction.sendKeys(commentTextArea, commentText);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To fill Request Status details in Request Info section
	 * 
	 * @param commentText - division for this form
	 * @throws Exception
	 */
	public void fillRequestStatus(String requestStatusText) throws Exception {
		try {
			WebAction.scrollIntoView(requestStatusDropDown);
			// To fill Request Status
			if (requestStatusText != null) {
				boolean valuePresent = false;
				Thread.sleep(1000);
				// Waits.waitForElement(requestStatusDropDown, WAIT_CONDITIONS.CLICKABLE);
				WebAction.clickUsingJs(requestStatusDropDown);
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					System.out.println("title " + WebAction.getAttribute(ele, "title"));
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(requestStatusText)) {
						Waits.waitForElement(ele, WAIT_CONDITIONS.CLICKABLE);
						WebAction.click(ele);
						valuePresent = true;
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception(
							"'" + requestStatusText + "' status is not present in the request Status drop down");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillFulfillmentComment(String fulfillmentCommentText) throws Exception {
		try {
			if (fulfillmentCommentText != null) {
				WebAction.click(fulfillmentCommentAddButton);
				Waits.waitForElement(fulfillmentCommentTextArea, WAIT_CONDITIONS.CLICKABLE);
				WebAction.sendKeys(fulfillmentCommentTextArea, fulfillmentCommentText);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillEditorControlsSection(String EditorName, String EditorPhoneNumber, String roomText,
			String sessionAssignedFromDateText, String sessionAssignedToDateText, String sessionAssignedToTimeText,
			String sessionAssignedFromTimeText, String differentRoomText) throws Exception {
		if (EditorName != null) {
			WebAction.click(addEditorButton);
			try {
				if (EditorName != null) {
					Waits.waitForElement(editorNameTextbox, WAIT_CONDITIONS.CLICKABLE);
					WebAction.sendKeys(editorNameTextbox, EditorName);
					Thread.sleep(1000);
					Waits.waitUntilElementSizeGreater(SearchList, 0);
					Thread.sleep(1000);
					WebAction.click(SearchList.get(0));
				}
				if (EditorPhoneNumber != null) {
					Waits.waitForElement(editorPhoneNumberTextbox, WAIT_CONDITIONS.CLICKABLE);
					WebAction.sendKeys(editorPhoneNumberTextbox, EditorPhoneNumber);

				}
				if (roomText != null) {
					Waits.waitForElement(editorSearchRoomTextbox, WAIT_CONDITIONS.CLICKABLE);
					WebAction.sendKeys(editorSearchRoomTextbox, roomText);
					Thread.sleep(1000);
					Waits.waitUntilElementSizeGreater(SearchList, 0);
					Thread.sleep(1000);
					WebAction.click(SearchList.get(0));
				}
				selectEditorDate(sessionAssignedFromDateText, sessionAssignedToDateText);
				selectEditorEndTime(sessionAssignedToTimeText);
				selectEditorStartTime(sessionAssignedFromTimeText);
				if (differentRoomText != null) {
					WebAction.clickUsingJs(editorDifferentRoomCheckbox);
					Waits.waitForElement(editorDifferentSearchRoomTextbox, WAIT_CONDITIONS.CLICKABLE);
					WebAction.sendKeys(editorDifferentSearchRoomTextbox, differentRoomText);
					Thread.sleep(1000);
					Waits.waitUntilElementSizeGreater(SearchList, 0);
					Thread.sleep(1000);
					WebAction.click(SearchList.get(0));
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	public void selectEditorDate(String sessionAssignedFromDateText, String sessionAssignedToDateText)
			throws Exception, InterruptedException {
		if (sessionAssignedFromDateText != null && sessionAssignedToDateText != null) {
			WebAction.click(sessionEditorStartDate);
			WebAction.sendKeys(sessionEditorStartDate, generateDate(sessionAssignedFromDateText, "MM/dd/yyyy"));
			WebAction.keyPress(sessionEditorStartDate, "Enter");
			Thread.sleep(2000);
			WebAction.sendKeys(sessionEditorEndDate, generateDate(sessionAssignedToDateText, "MM/dd/yyyy"));
			WebAction.keyPress(sessionEditorEndDate, "Enter");
		}
	}

	public void selectEditorEndTime(String sessionAssignedToTimeText) throws Exception {
		// To fill end Time
		if (sessionAssignedToTimeText != null) {
			WebAction.click(sessionEditorEndTime);
			WebAction.sendKeys(sessionEditorEndTime, generateTime(sessionAssignedToTimeText, "hh:mm a"));
			WebAction.keyPress(sessionEditorEndTime, "Enter");
		}
	}

	public void selectEditorStartTime(String sessionAssignedFromTimeText) throws Exception {
		// To fill start Time
		if (sessionAssignedFromTimeText != null) {
			WebAction.click(sessionEditorStartTime);
			WebAction.sendKeys(sessionEditorStartTime, generateTime(sessionAssignedFromTimeText, "hh:mm a"));
			WebAction.keyPress(sessionEditorStartTime, "Enter");
		}
	}

	public void fillAsstProducerInfoSection(String isAsstProducerSameasRequestorValue) throws Exception {
		try {
			if (isAsstProducerSameasRequestorValue != null) {
				// To select 'Asst Producer / Field Contact Same as Requester? ' value
				if (isAsstProducerSameasRequestorValue.toUpperCase().equalsIgnoreCase("YES")) {
					WebAction.clickUsingJs(asstProducerSameasRequestor_Options);
				} else {
					WebAction.sendKeys(asstProducerSameAsRequestInputBox, isAsstProducerSameasRequestorValue);
					Thread.sleep(500);
					WebAction.sendKeys_WithoutClear(asstProducerSameAsRequestInputBox, " ");
					Waits.waitUntilElementSizeGreater(SearchList, 0);
					Thread.sleep(1000);
					WebAction.click(SearchList.get(0));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To fill Additional Recipients
	 * 
	 * @param Additional Recipients for this form
	 * @throws Exception
	 */
	public void fillAdditionalRecipients(String additionalRecipientsText) throws Exception {
		try {
			// To enter Additional Recipients
			int j = 0;
			if (additionalRecipientsText != null) {
				Waits.waitForElement(addRecipientButton, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(addRecipientButton);
				String[] additionalRecipientsTextArrayList = additionalRecipientsText.split(",");
				for (int k = 0; k < additionalRecipientsTextArrayList.length; k++) {
					String additionalRecipientsTextXpath = additionalRecipientsInputBox
							.replace("<<additionalRecipientsInputBoxNo>>", Integer.toString(k + 1));
					WebElement additionalRecipientsTextWebElement = driver
							.findElement(By.xpath(additionalRecipientsTextXpath));
					WebAction.sendKeys(additionalRecipientsTextWebElement, additionalRecipientsTextArrayList[k]);
					j++;
					if (j < additionalRecipientsTextArrayList.length) {
						Waits.waitForElement(addRecipientButton, WAIT_CONDITIONS.CLICKABLE);
						WebAction.click(addRecipientButton);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyEditRequestValuesWithEditDashboardValues(String SlugText, String ShowUnitText,
			String divisionText, String locationText, String editStartDateText, String airDateText, String airTimeText,
			String additionalRequestersText, String ProducerText, String SrProducerText, String SubmittedText)
			throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			String columnCellString = "//*[contains(text(),'<<RequestId>>')]/ancestor::tr/td[<<ColumnTypeNo>>]";
			String columnTypeNoText;

			// To validate slug
			if (SlugText != null) {
				columnTypeNoText = "2";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String slugText = Constants.getAssignmentSlug();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						slugText);
			}

			// To validate show unit
			if (ShowUnitText != null) {
				columnTypeNoText = "3";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String showCellTypeText = columnCellTypeText.concat("/span/span");
				List<String> showList = Constants.getMultipleShowUnits();
				String[] ShowArrayList;
				if (ShowUnitText.contains(",")) {
					WebElement showArrayListWebelement = driver.findElement(By.xpath(showCellTypeText.concat("/span")));
					Waits.waitForElement(showArrayListWebelement, WAIT_CONDITIONS.VISIBLE);
					Thread.sleep(1000);
					WebAction.click(showArrayListWebelement);
					String showNamesXpath = "((//div[contains(@class,'tooltip')])[last()]//li)[<<showNo>>]";
					for (int i = 0; i < showList.size(); i++) {
						String showNamesNewXpath = showNamesXpath.replace("<<showNo>>", Integer.toString(i + 1));
						producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
								showNamesNewXpath, showList.get(i));
					}
				} else {
					ShowArrayList = new String[1];
					ShowArrayList[0] = ShowUnitText;
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(showCellTypeText,
							ShowArrayList[0]);
				}
				WebAction.click(producerDashboardGeneralPage.ecmDashboardTitleHeader);

				// To validate budget code
				columnTypeNoText = "4";
				String budgetCodecolumnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String budgetCodeCellTypeText = budgetCodecolumnCellTypeText.concat("/span/span");
				List<String> budgetCodeList = Constants.getMultipleBudgetCodes();
				if (budgetCodeList.size() > 1) {
					WebElement budgetCodeArrayListWebelement = driver
							.findElement(By.xpath(budgetCodeCellTypeText.concat("/span")));
					Waits.waitForElement(budgetCodeArrayListWebelement, WAIT_CONDITIONS.VISIBLE);
					Thread.sleep(1000);
					WebAction.mouseOverClick(budgetCodeArrayListWebelement);
					String budgetCodeNamesXpath = "((//div[contains(@class,'tooltip')])[last()]//li)[<<budgetCodeNo>>]";
					for (int i = 0; i < budgetCodeList.size(); i++) {
						String budgetCodeNameNewXpath = budgetCodeNamesXpath.replace("<<budgetCodeNo>>",
								Integer.toString(i + 1));
						producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
								budgetCodeNameNewXpath, budgetCodeList.get(i));
					}
				} else {
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
							budgetCodeCellTypeText, budgetCodeList.get(0));
				}
				WebAction.click(producerDashboardGeneralPage.ecmDashboardTitleHeader);
			}

			// To validate division
			if (divisionText != null) {
				columnTypeNoText = "5";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String expectedDivision = Constants.getDivision();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						expectedDivision);
			}

			// To validate location
			if (locationText != null) {
				columnTypeNoText = "6";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String expectedLocation = Constants.getLocations();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						expectedLocation);
			}

			// To validate edit start date
			if (editStartDateText != null) {
				columnTypeNoText = "7";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				//String date = generateDate(Constants.getEditStartDate(), "MM/dd/yy");
				
				DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
				DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("M/d/yyyy"); 
				LocalDate dateFormat = LocalDate.parse(Constants.getEditStartDate(), inputFormatter); 
				String date = dateFormat.format(outputFormatter);
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						date);
			}

			// To validate air date
			if (airDateText != null) {
				columnTypeNoText = "8";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String date = Constants.getAirtDate();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						date);
			}

			// To validate air time
			if (airTimeText != null) {
				columnTypeNoText = "9";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String columnCellText = WebAction.getText(driver.findElement(By.xpath(columnCellTypeText)));
				String actualTime = columnCellText.trim();
				String expectedTime = Constants.getAirTime();
				Assert.assertTrue(actualTime.toUpperCase().contains(expectedTime.toUpperCase()),
						"Expected value is " + expectedTime + " and actual value is " + actualTime);
				ReportGenerate.test.log(Status.INFO,
						"\"" + expectedTime + "\"" + " Present in the form is also displaying in dashboard");
				System.out.println("" + expectedTime + "\"" + " Present in the form is also displaying in dashboard");
			}

			// To validate default requester
			columnTypeNoText = "10";
			String defaultRequesterNamecolumnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String defaultRequesterName = Constants.getDefaultRequesterName();
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
					defaultRequesterNamecolumnCellTypeText, defaultRequesterName);

			// To validate additional requester
			String[] additionalRequestersArrayList;
			if (additionalRequestersText != null) {
				if (additionalRequestersText.contains("-")) {
					additionalRequestersArrayList = additionalRequestersText.split("-");
				} else {
					additionalRequestersArrayList = additionalRequestersText.split(" ");
				}
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/span/span/span/span");
				List<String> addreqNamesList = new ArrayList<String>();
				List<RequesterRecord> additionalRequestersStringList = Constants.getRequesters();
				for (RequesterRecord additionalRequester : additionalRequestersStringList) {

					addreqNamesList.add(additionalRequester.getName());
				}
				WebElement additionalRequestersWebelement = driver.findElement(By.xpath(columnCellTypeText));
				Waits.waitForElement(additionalRequestersWebelement, WAIT_CONDITIONS.VISIBLE);
				Thread.sleep(1000);
				WebAction.click(additionalRequestersWebelement);
				String additionalreqNamesXpath = "((//div[contains(@class,'tooltip')])[last()]//li/a)[<<additionalReqNo>>]";
				for (int i = 0; i < additionalRequestersArrayList.length; i++) {
					String additionalreqNamesNewXpath = additionalreqNamesXpath.replace("<<additionalReqNo>>",
							Integer.toString(i + 2));
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
							additionalreqNamesNewXpath, addreqNamesList.get(i));
				}
			}

			// To validate Producer
			if (ProducerText != null) {
				columnTypeNoText = "11";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String Producer = Constants.getProducerName();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						Producer);
			}

			// To validate Sr Producer
			if (SrProducerText != null) {
				columnTypeNoText = "12";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String SrProducer = Constants.getSeniorProducerName();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						SrProducer);
			}

			// To validate crush Cell column
			columnTypeNoText = "13";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/span//*[local-name()='svg']");
			String actualCrushColumn = WebAction.getAttribute(driver.findElement(By.xpath(columnCellTypeText)),
					"data-icon");
			String expectedCrushColumn = null;
			if (Constants.getFormType().equalsIgnoreCase("LONG EDIT")) {
				expectedCrushColumn = "close";
			} else if (Constants.getCrashEditNeeded().equalsIgnoreCase("YES")) {
				expectedCrushColumn = "check";
			} else {
				expectedCrushColumn = "close";
			}
			Assert.assertTrue(actualCrushColumn.contains(expectedCrushColumn),
					"Expected crush icon is " + expectedCrushColumn + " and actual crush icon is " + actualCrushColumn);
			ReportGenerate.test.log(Status.INFO,
					expectedCrushColumn + " icon is displying for crush column in the dashboard");

			// To validate submitted date
			if (SubmittedText != null) {
				columnTypeNoText = "15";
				String submittedColumnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/div[1]");
				SubmittedText = producerDashboardGeneralPage.generateDate(SubmittedText, "M/d/yyyy");
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
						submittedColumnCellTypeText, SubmittedText);
			}

		} catch (

		Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}