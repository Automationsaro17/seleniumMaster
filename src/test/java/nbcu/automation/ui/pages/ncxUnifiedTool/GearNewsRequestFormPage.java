
package nbcu.automation.ui.pages.ncxUnifiedTool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.factory.DriverFactory;
import nbcu.framework.utils.Other.DateFunctions;
import nbcu.framework.utils.cucumber.CucumberUtils;
import nbcu.framework.utils.report.ReportGenerate;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;
import nbcu.framework.utils.ui.WebAction;

public class GearNewsRequestFormPage {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	WebDriver driver = DriverFactory.getCurrentDriver();

	// news gear
	@FindBy(xpath = "(//p[contains(text(),'GEAR')])[2]")
	WebElement gearSection;

	@FindBy(xpath = "//*[@formselectname='prodUser']//input")
	WebElement gearUserName;

	@FindBy(xpath = "//*[@forminputname='prodUserNumber']//input")
	WebElement gearUserMobile;

	@FindBy(xpath = "//input[@placeholder='Show Unit or Project Name']")
	WebElement showTitle;

	String showTitleString = "(//input[@placeholder='Show Unit or Project Name'])[<<showUnitNo>>]";

	String budgetCodeTitleString = "(//input[@placeholder='Search Budget Code'])[<<budgetCodeNo>>]";

	@FindBy(xpath = "//input[@placeholder='Search Budget Code']")
	WebElement budgetCode;

	@FindBy(xpath = "//*[@forminputname='segmentType']//label[@label-value='Live']")
	WebElement segmentType_Live;

	@FindBy(xpath = "//*[@forminputname='segmentType']//label[@label-value='Taped']")
	WebElement segmentType_Taped;

	@FindBy(xpath = "//*[text()=' Show Unit ']")
	WebElement showTitleAddButton;

	@FindBy(xpath = "//*[@forminputname='location']//input")
	WebElement location;

	@FindBy(xpath = "//*[@forminputname='pickupDate']//input")
	WebElement pickupDate;

	@FindBy(xpath = "//*[@forminputname='returnDate']//input")
	WebElement returnDate;

	@FindBy(xpath = "//*[@forminputname='pickupTime']//input")
	WebElement pickupTime;

	@FindBy(xpath = "//span[text()='Add Gear']")
	WebElement addGearTitle;

	String typeOfGear = "//span[contains(text(),'<<typeOfGear>>')]/..//input";

	String equipmentCommentsInputBox = "//div[contains(@class,'row-border')]//span[contains(text(),'<<typeOfGear>>')]/../following-sibling::div//input";

	String selectDetailLineButton = "//span[contains(text(),'<<typeOfGear>>')]/..//span[contains(text(),'Detail Line')]";

	@FindBy(xpath = "//p[contains(text(),'USAGE')]")
	WebElement usageSection;

	@FindBy(xpath = "//*[@forminputname='hiddenCameraMicro']//label[@label-value='true']")
	WebElement hiddenCameraOrMicrophone_Yes;

	@FindBy(xpath = "//*[@forminputname='hiddenCameraMicro']//label[@label-value='false']")
	WebElement hiddenCameraOrMicrophone_No;

	@FindBy(xpath = "//*[@forminputname='outsideUs']//label[@label-value='true']")
	WebElement gearBeingUsedOutsideUS_Yes;

	@FindBy(xpath = "//*[@forminputname='outsideUs']//label[@label-value='false']")
	WebElement gearBeingUsedOutsideUS_No;

	@FindBy(xpath = "//*[@forminputname='nbcStudioLocation']//label[@label-value='true']")
	WebElement wirelessUsedInNBC_Yes;

	@FindBy(xpath = "//*[@forminputname='nbcStudioLocation']//label[@label-value='false']")
	WebElement wirelessUsedInNBC_No;

	@FindBy(xpath = "//*[@forminputname='outsider']//label[@label-value='true']")
	WebElement gearBeingGivenOutside_Yes;

	@FindBy(xpath = "//*[@forminputname='outsider']//label[@label-value='false']")
	WebElement gearBeingGivenOutside_No;

	@FindBy(xpath = "//textarea[@placeholder='Add all Usage Descriptions ']")
	WebElement descriptionInputBox;

	@FindBy(xpath = "//*[@forminputname='comments']//textarea")
	WebElement commentTextArea;

	String typeOfSubCategoryToSelect = "(//*[@class='gear-type' and text()='<<TypeOfGear>>']//ancestor::div[2]//*[@formcontrolname='name']//child::input)[<<NumberOfGears>>]";

	String scrollToTypeOfSubCategory = "//*[@class='gear-type' and text()='<<TypeOfGear>>']";

	// Other WebElements

	@FindBy(xpath = "//*[@role='menuitem']/div")
	List<WebElement> SearchList;

	@FindBy(xpath = "//div[contains(@class, 'story-list-elem')]/button")
	List<WebElement> ncxStoryNamesdropDownvalues;

	String dropDownvaluesXpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item";

	@FindBy(xpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item | //nz-option-item ")
	List<WebElement> dropDownvalues;

	@FindBy(xpath = "//span[i[*[@data-icon='close']]]")
	WebElement closeMessagePopup;

	public GearNewsRequestFormPage() {
		PageFactory.initElements(DriverFactory.getCurrentDriver(), this);
	}

	// News Gear
	public void addGearUserInfoInNews(String gearUserText, String gearUserPhoneText) throws Exception {
		try {
			enterGearUser(gearUserText);
			enterGearUserPhone(gearUserPhoneText);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private void enterGearUser(String gearUserText) throws Exception {
		WebAction.scrollIntoView(gearUserName);
		// To enter gear user
		if (gearUserText != null) {
			Waits.waitForElement(gearUserName, WAIT_CONDITIONS.CLICKABLE);
			WebAction.clear(gearUserName);
			WebAction.sendKeys(gearUserName, gearUserText);
			Thread.sleep(1000);
			WebAction.sendKeys_WithoutClear(gearUserName, " ");
			Waits.waitUntilElementSizeGreater(SearchList, 0);
			Thread.sleep(1000);
			WebAction.click(SearchList.get(0));
			ReportGenerate.test.log(Status.INFO,
					"User enters Gear User name as " + gearUserText + " in News Gear form");
		}
	}

	private void enterGearUserPhone(String gearUserPhoneText) throws Exception {
		if (gearUserPhoneText != null) {
			Waits.waitForElement(gearUserMobile, WAIT_CONDITIONS.CLICKABLE);
			WebAction.clear(gearUserMobile);
			WebAction.sendKeys(gearUserMobile, gearUserPhoneText);
			ReportGenerate.test.log(Status.INFO,
					"User enters Gear User phone as " + gearUserPhoneText + " in News Gear form");
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
			if (time.trim().length() > 0) {
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

	public void addSegmentTypeInNews(String segmentType) throws Exception {
		try {
			// To select 'Segment type ' value
			if (segmentType != null) {
				if (segmentType.equalsIgnoreCase("Taped")) {
					WebAction.click(segmentType_Taped);
				} else
					WebAction.click(segmentType_Live);
			}
			ReportGenerate.test.log(Status.INFO, "User selects segment type as " + segmentType + " in News Gear form");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addShowUnitInNews(String showTitleText, String budgetCodeText) throws Exception {
		try {
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

	public void fillLocationDateTimeInfoInNews(String locationText, String PickUpDateText, String PickUpTimeText,
			String ReturnDateText) throws Exception {
		try {
			// WebAction.scrollIntoView(location);
			// To select location
			if (locationText != null) {
				boolean valuePresent = false;
				WebAction.click(location);
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(locationText)) {
						WebAction.click(ele);
						Constants.setLocations(locationText);
						valuePresent = true;
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception("'" + locationText + "' value is not present in the location drop down");
			}
			ReportGenerate.test.log(Status.INFO, "User selects location as " + locationText + " in News Gear form");

			// To fill Start Date
			if (PickUpDateText != null) {
				Constants.setPickUpDate(generateTime(PickUpDateText, "MM/dd/yyyy"));
				// WebAction.click(dates.get(0));
				WebAction.click(pickupDate);
				WebAction.sendKeys(pickupDate, generateDate(PickUpDateText, "MM/dd/yyyy"));
				WebAction.keyPress(pickupDate, "Enter");
				ReportGenerate.test.log(Status.INFO, "User selects Date as " + PickUpDateText);
			}

			// To fill start time
			if (PickUpTimeText != null) {
				Constants.setPickUpTime(generateTime(PickUpTimeText, "h:mm a"));
				WebAction.click(pickupTime);
				WebAction.sendKeys(pickupTime, generateTime(PickUpTimeText, "hh:mm a"));
				ReportGenerate.test.log(Status.INFO, "User selects pickup/start time as " + PickUpTimeText);
			}

			// To fill end Date
			if (ReturnDateText != null) {
				Constants.setReturnDate(generateTime(ReturnDateText, "MM/dd/yyyy"));
				WebAction.click(returnDate);
				WebAction.sendKeys(returnDate, generateDate(ReturnDateText, "MM/dd/yyyy"));
				WebAction.keyPress(returnDate, "Enter");
				ReportGenerate.test.log(Status.INFO, "User selects return/end time as " + ReturnDateText);
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addGearDetailsInNews(String typeOfGearValue, String howManyValue, String commentsText)
			throws Exception {
		try {
			WebAction.scrollIntoView(gearSection);
			WebDriver driver = DriverFactory.getCurrentDriver();

			String typeOfGearXpath = typeOfGear.replace("<<typeOfGear>>", typeOfGearValue);
			String equipmentCommentsInputBoxXpath = equipmentCommentsInputBox.replace("<<typeOfGear>>",
					typeOfGearValue);

			// To enter number of values
			WebAction.sendKeys(driver.findElement(By.xpath(typeOfGearXpath)), howManyValue);
			ReportGenerate.test.log(Status.INFO,
					"User selects " + howManyValue + typeOfGearValue + " as gear type in News Gear form");
			Thread.sleep(1000);
			// To enter equipment comments
			for (int i = 0; i < Integer.parseInt(howManyValue); i++) {
				WebAction.click(driver
						.findElement(By.xpath(selectDetailLineButton.replace("<<typeOfGear>>", typeOfGearValue))));
				List<WebElement> listOfEquipmentCommentsInputBox = driver
						.findElements(By.xpath(equipmentCommentsInputBoxXpath));
				WebAction.sendKeys(listOfEquipmentCommentsInputBox.get(i), commentsText);
				ReportGenerate.test.log(Status.INFO, "User enters " + commentsText + " in " + typeOfGearValue
						+ " gear type comments in News Gear form");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillUsageSectionInNews(String hiddenOptionValue, String outsideUSOptionValue,
			String nBCStudioLocationOptionValue, String outsideNBCUniversalOptionValue, String descriptionValue)
			throws Exception {
		try {
			WebAction.scrollIntoView(usageSection);

			// To select Hidden Option
			if (hiddenOptionValue != null) {
				if (hiddenOptionValue.equalsIgnoreCase("No")) {
					WebAction.click(hiddenCameraOrMicrophone_No);
					ReportGenerate.test.log(Status.INFO, "User selects " + hiddenOptionValue
							+ " for - Is this gear being used as a hidden camera or microphone? option in News Gear form");
				} else
					WebAction.click(hiddenCameraOrMicrophone_Yes);
				ReportGenerate.test.log(Status.INFO,
						"User selects Yes for - Is this gear being used as a hidden camera or microphone? option in News Gear form");
			}

			// To select Outside US Option
			if (outsideUSOptionValue != null) {
				if (outsideUSOptionValue.equalsIgnoreCase("No")) {
					WebAction.click(gearBeingUsedOutsideUS_No);
					ReportGenerate.test.log(Status.INFO, "User selects " + outsideUSOptionValue
							+ " for - Is this gear being used outside of US? option in News Gear form");
				} else
					WebAction.click(gearBeingUsedOutsideUS_Yes);
				ReportGenerate.test.log(Status.INFO,
						"User selects Yes for - Is this gear being used outside of US? option in News Gear form");
			}
			// To select NBC Studio Location Option
			if (nBCStudioLocationOptionValue != null) {
				if (nBCStudioLocationOptionValue.equalsIgnoreCase("No")) {
					WebAction.click(wirelessUsedInNBC_No);
					ReportGenerate.test.log(Status.INFO, "User selects " + nBCStudioLocationOptionValue
							+ " for - Will any wireless audio equipment be used in any NBC Studio location? option in News Gear form");
				} else
					WebAction.click(wirelessUsedInNBC_Yes);
				ReportGenerate.test.log(Status.INFO,
						"User selects Yes for - Will any wireless audio equipment be used in any NBC Studio location? option in News Gear form");
			}
			// To select Outside NBC Universal Option
			if (outsideNBCUniversalOptionValue != null) {
				if (outsideNBCUniversalOptionValue.equalsIgnoreCase("No")) {
					WebAction.click(gearBeingGivenOutside_No);
					ReportGenerate.test.log(Status.INFO, "User selects " + outsideNBCUniversalOptionValue
							+ " for - Is this gear being given to someone outside of NBC Universal to use? option in News Gear form");
				} else
					WebAction.click(gearBeingGivenOutside_Yes);
				ReportGenerate.test.log(Status.INFO,
						"User selects Yes for - Is this gear being given to someone outside of NBC Universal to use? option in News Gear form");
			}
			// To enter Description
			if (descriptionValue != null) {
				WebAction.sendKeys(descriptionInputBox, descriptionValue);
				ReportGenerate.test.log(Status.INFO,
						"User enters " + descriptionValue + " as usage description in News Gear form");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillCommentInNews(String commentText) throws Exception {
		try {
			if (commentText != null) {
				Waits.waitForElement(commentTextArea, WAIT_CONDITIONS.CLICKABLE);
				WebAction.sendKeys(commentTextArea, commentText);
				ReportGenerate.test.log(Status.INFO, "User enters " + commentText + " as comments in News Gear form");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To selects sub category type for requested gear in Equipment section
	 * 
	 * @throws Exception
	 */
	public void selectsSubCategoryTypeForRequestedGear(String typeOfGearValue, String howManyValue,
			String subCategoryValue) throws Exception {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebAction.scrollIntoView(
					driver.findElement(By.xpath(scrollToTypeOfSubCategory.replace("<<TypeOfGear>>", typeOfGearValue))));
			if (!subCategoryValue.isBlank()) {
				for (int i = 0; i < Integer.parseInt(howManyValue); i++) {
					String typeOfSubCategoryToSelectXpath = typeOfSubCategoryToSelect
							.replace("<<TypeOfGear>>", typeOfGearValue)
							.replace("<<NumberOfGears>>", (Integer.toString(i + 1)));
					WebElement typeOfSubCategoryToSelectElement = driver
							.findElement(By.xpath(typeOfSubCategoryToSelectXpath));
					// click on camera sub category dropdown
					WebAction.click(typeOfSubCategoryToSelectElement);
					Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
					String[] typeOfGearValueArrayList = subCategoryValue.split(",", 0);
					for (WebElement ele : dropDownvalues) {
						if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(typeOfGearValueArrayList[i].trim())) {
							WebAction.click(ele);
							ReportGenerate.test.log(Status.INFO, "User selects " + typeOfGearValueArrayList[i].trim()
									+ " as " + typeOfGearValue + " type Fulfillment section for News Gear form");
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify values in the news gear form are present in gear dashboard columns
	 * 
	 * @throws Exception
	 */
	public void verifyNewsGearRequestValuesWithGearDashboardValues(String SubmittedText,
			String additionalRequestersText, String LocationText, String PickUpDateText, String PickUpTimeText,
			String ReturnDateText, String ShowText) throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			String columnCellString = "//*[contains(text(),'<<RequestId>>')]/ancestor::tr/td[<<ColumnTypeNo>>]";
			String columnTypeNoText;
			verifySubmittedDateInGearDashboard(SubmittedText, requestNumber, columnCellString);
			verifyAdditionalRequesterInGearDashboard(additionalRequestersText, requestNumber, columnCellString);
			verifyLocationInGearDashboard(LocationText, requestNumber, columnCellString);
			verifyPickUpDateInGearDashboard(PickUpDateText, requestNumber, columnCellString);
			verifyPickUpTimeInGearDashboard(PickUpTimeText, requestNumber, columnCellString);
			verifyReturnDateInGearDashboard(ReturnDateText, requestNumber, columnCellString);
			verifyShowInGearDashboard(ShowText, requestNumber, columnCellString);

			// To validate Edit button enabled or not in Action Cell column
			columnTypeNoText = "11";
			columnCellString = columnCellString.replace("<<RequestId>>", requestNumber).replace("<<ColumnTypeNo>>",
					columnTypeNoText);
			producerDashboardGeneralPage.verifyActionsColumnInDashboard(requestNumber, columnCellString);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifySubmittedDateInGearDashboard(String SubmittedText, String requestNumber, String columnCellString)
			throws Exception {
		String columnTypeNoText;
		// To validate submitted date
		if (SubmittedText != null) {
			columnTypeNoText = "3";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			SubmittedText = generateDate(SubmittedText, "M/d/yyyy");
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
					SubmittedText);
		}
	}

	public void verifyShowInGearDashboard(String ShowText, String requestNumber, String columnCellString)
			throws Exception, InterruptedException {
		String columnTypeNoText;
		// To validate show unit
		if (ShowText != null) {
			columnTypeNoText = "10";
			String showTextIndashboard = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/span/span");
			List<String> showList = Constants.getMultipleShowUnits();
			String[] ShowArrayList;
			if (ShowText.contains(",")) {
				WebElement showArrayListWebelement = driver.findElement(By.xpath(showTextIndashboard.concat("[2]")));
				Waits.waitForElement(showArrayListWebelement, WAIT_CONDITIONS.VISIBLE);
				Thread.sleep(1000);
				WebAction.click(showArrayListWebelement);
				String showNamesXpath = "(//div[contains(@class,'popover')])[last()]/div[<<showNo>>]";
				for (int i = 0; i < showList.size(); i++) {
					String showNamesNewXpath = showNamesXpath.replace("<<showNo>>", Integer.toString(i + 1));
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(showNamesNewXpath,
							showList.get(i).trim());
				}
			} else {
				ShowArrayList = new String[1];
				ShowArrayList[0] = ShowText;
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
						showTextIndashboard.concat("[1]"), ShowArrayList[0]);
			}
		}
	}

	public void verifyReturnDateInGearDashboard(String ReturnDateText, String requestNumber, String columnCellString)
			throws Exception {
		String columnTypeNoText;
		// To validate return date
		if (ReturnDateText != null) {
			columnTypeNoText = "8";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String date = generateDate(Constants.getReturnDate(), "M/d/yyyy");
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText, date);
		}
	}

	public void verifyPickUpTimeInGearDashboard(String PickUpTimeText, String requestNumber, String columnCellString)
			throws ParseException {
		String columnTypeNoText;
		// To validate pick up time
		if (PickUpTimeText != null) {
			columnTypeNoText = "7";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String dateString = Constants.getPickUpTime();
			SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
			Date date = sdf.parse(dateString);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int minutes = calendar.get(Calendar.MINUTE);
			int roundInterval = 5;
			int roundedMinutes = (minutes / roundInterval) * roundInterval;
			calendar.set(Calendar.MINUTE, roundedMinutes);
			Date roundedDate = calendar.getTime();
			String expectedRoundedTime = sdf.format(roundedDate);
			String columnCellText = WebAction.getText(driver.findElement(By.xpath(columnCellTypeText)));
			String actualValue;
			actualValue = columnCellText.trim();
			Assert.assertTrue(actualValue.toUpperCase().contains(expectedRoundedTime.toUpperCase()),
					"Expected value is " + expectedRoundedTime + " and actual value is " + actualValue);
			ReportGenerate.test.log(Status.INFO,
					"\"" + expectedRoundedTime + "\"" + " Present in the form is also displaying in dashboard");
			System.out
					.println("" + expectedRoundedTime + "\"" + " Present in the form is also displaying in dashboard");
		}
	}

	public void verifyPickUpDateInGearDashboard(String PickUpDateText, String requestNumber, String columnCellString)
			throws Exception {
		String columnTypeNoText;
		// To validate pick up date
		if (PickUpDateText != null) {
			columnTypeNoText = "6";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String date = generateDate(Constants.getPickUpDate(), "M/d/yyyy");
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText, date);
		}
	}

	public void verifyLocationInGearDashboard(String LocationText, String requestNumber, String columnCellString)
			throws Exception {
		String columnTypeNoText;
		// To validate location
		if (LocationText != null) {
			columnTypeNoText = "5";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
					Constants.getLocations());
		}
	}

	public void verifyAdditionalRequesterInGearDashboard(String additionalRequestersText, String requestNumber,
			String columnCellString) throws Exception, InterruptedException {
		String columnTypeNoText;
		// To validate default requester
		String defaultRequesterName = Constants.getDefaultRequesterName();
		columnTypeNoText = "4";
		String defaultRequesterNamecolumnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
				.replace("<<ColumnTypeNo>>", columnTypeNoText);
		String defaultRequesterNameTextIndashboard = defaultRequesterNamecolumnCellTypeText.concat("/div/span[1]");
		producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
				defaultRequesterNameTextIndashboard, defaultRequesterName);

		// To validate additional requester
		String[] additionalRequestersArrayList;
		if (additionalRequestersText != null) {
			if (additionalRequestersText.contains("-")) {
				additionalRequestersArrayList = additionalRequestersText.split("-");
			} else {
				additionalRequestersArrayList = new String[1];
				additionalRequestersArrayList[0] = additionalRequestersText;
			}
			columnTypeNoText = "4";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String additionalRequesterTextXpathIndashboard = columnCellTypeText.concat("/div/span[last()]");

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
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
						additionalreqNamesNewXpath, addreqNamesList.get(i));
			}
		}
	}
}
