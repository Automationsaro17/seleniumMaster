
package nbcu.automation.ui.pages.ncxUnifiedTool;


import static nbcu.framework.factory.DriverFactory.getCurrentDriver;
import static nbcu.framework.utils.ui.WebAction.getText;
import static nbcu.framework.utils.ui.WebAction.scrollIntoView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;
import nbcu.automation.ui.enums.RequestMode;
import nbcu.automation.ui.enums.RequestStatus;
import nbcu.automation.ui.pojos.ncxUnifiedTool.ControlRoomAndCrewRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.LocationRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.RequesterRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.TpmOrTmInformation;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.factory.DriverFactory;
import nbcu.framework.utils.Other.DateFunctions;
import nbcu.framework.utils.propertyfilereader.ConfigFileReader;
import nbcu.framework.utils.report.ReportGenerate;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;
import nbcu.framework.utils.ui.WebAction;

public class ProdExtendorBridgeCrewRequestFormPage {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	public ProducerDashboardGeneralPage getProducerDashboardGeneralPage() {
		return producerDashboardGeneralPage;
	}
	@FindBy(xpath = "//*[contains(@forminputname,'requestFor')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement requestForError;

	@FindBy(xpath = "//*[contains(@forminputname,'controlRoom')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement controlRoomAndCrewError;

	@FindBy(xpath = "//*[@forminputname='requestFor']//label[@label-value='Extend']")
	WebElement requestFor_Extend;

	@FindBy(xpath = "//*[@forminputname='requestFor']//label[@label-value='Bridge']")
	WebElement requestFor_Bridge;

	@FindBy(xpath = "//*[@forminputname='controlRoom']//label[@label-value='Eob_Yes']")
	WebElement controlRoom_Eob_Yes;

	@FindBy(xpath = "//*[@forminputname='controlRoom']//label[@label-value='Eob_Yes']")
	WebElement controlRoom_Eob_No;

	@FindBy(xpath = "//phase-two-container//*[contains(@class,'status-title-area')]//p[contains(@class,'left-hand-title')]")
	List<WebElement> formSectionTitles;

	@FindBy(xpath = "//*[contains(text(),' Request For ')]/../following::*[1]//*[text()]")
	List<WebElement> requestForRadioLabels;

	@FindBy(xpath = "//*[contains(text(),' Is Budget Code Available? ')]/../following::*[1]//span[text()]")
	List<WebElement> isBudgetCodeAvailableRadioLabels;

	@FindBy(xpath = "//*[contains(text(),' Control Room & Crew ')]/../following::*[1]//span[text()]")
	List<WebElement> controlRoomAndCrewRadioLabels;

	@FindBy(xpath = "//label[text()=' Same as requester? ']/ancestor::nz-form-label/following::input[1]")
	WebElement sameAsRequesterCheckbox;

	@FindBy(xpath = "//label[contains(text(),'Division')]/ancestor::nz-form-label/following::input[1]")
	WebElement divisionInput;

	@FindBy(xpath = "//label[text()=' Control Room ']/ancestor::nz-form-label/following::input[1]")
	WebElement controlRoomInput;

	@FindBy(xpath = "//label[text()=' Control Room Location ']/ancestor::nz-form-label/following::input[1]")
	WebElement controlRoomLocationInput;

	@FindBy(xpath = "//label[text() = ' Budget Code ']/ancestor::nz-form-label/following::input[1]")
	WebElement budgetCodeInput;

	@FindBy(xpath = "//label[contains(text(),'Show Unit or Project Name')]/ancestor::nz-form-label/following::input[1]")
	WebElement showUnitOrProjectNameInput;

	@FindBy(xpath = "//label[text()=' Air Platform ']/ancestor::nz-form-label/following::input[1]")
	WebElement airPlatformInput;

	@FindBy(xpath = "//label[text()=' Work Order # ']/ancestor::nz-form-label/following::input[1]")
	WebElement workOrderInput;

	@FindBy(xpath = "//label[text()=' Start Date ']/ancestor::nz-form-label/following::input[1]")
	WebElement startDateInput;

	@FindBy(xpath = "//label[text()=' Start Time ']/ancestor::nz-form-label/following::input[1]")
	WebElement startTimeInput;

	@FindBy(xpath = "//label[text()=' End Time ']/ancestor::nz-form-label/following::input[1]")
	WebElement endTimeInput;

	@FindBy(xpath = "//label[text()=' Other ']/ancestor::nz-form-label/following::input[1]")
	WebElement otherInput;

	@FindBy(xpath = "//*[text()=' Details and Notes ']/../following::*[1]//textarea")
	WebElement detailsAndNotesInput;

	@FindBy(xpath = "//*[contains(text(),'SET LOCATION & CREW')]/ancestor::phase-two-container"
			+ "//label[text()=' Address ']/ancestor::nz-form-label/following::input[1]")
	WebElement addressInputInSetLocationAndCrewSection;

	@FindBy(xpath = "//*[contains(text(),'CONTROL ROOM & CREW')]/ancestor::phase-two-container"
			+ "//label[text()=' Address ']/ancestor::nz-form-label/following::input[1]")
	WebElement addressInputInControlRoomAndCrewSection;

	@FindBy(xpath = "//*[@sectiontitle='General Details']//nz-form-label//label")
	List<WebElement> generalDetailsSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='TPM / TM Information']//nz-form-label//label")
	List<WebElement> tpmOrTmInformationSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Requester(s)']//nz-form-label//label")
	List<WebElement> requestersSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Talent']//nz-form-label//label")
	List<WebElement> talentSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Show Info']//nz-form-label//label")
	List<WebElement> showInfoSectionFieldLabels;

	@FindBy(xpath = "//*[text()='EXTEND SET LOCATION & CREW']/ancestor::phase-two-container//nz-form-label//label")
	List<WebElement> extendSetLocationAndCrewSectionFieldLabels;

	@FindBy(xpath = "//*[text()='BRIDGE SET LOCATION & CREW']/ancestor::phase-two-container//nz-form-label//label")
	List<WebElement> bridgeSetLocationAndCrewSectionFieldLabels;

	@FindBy(xpath = "//*[text()='BRIDGE CONTROL ROOM & CREW']/ancestor::phase-two-container//nz-form-label//label")
	List<WebElement> bridgeControlRoomAndCrewSectionFieldLabels;

	@FindBy(xpath = "//*[text()='EXTEND CONTROL ROOM & CREW']/ancestor::phase-two-container//nz-form-label//label")
	List<WebElement> extendControlRoomAndCrewSectionFieldLabels;

	@FindBy(xpath = "//*[text()=' SET LOCATION & CREW']/ancestor::phase-two-container//nz-form-label//label")
	List<WebElement> setLocationAndCrewSectionFieldLabels;

	@FindBy(xpath = "//*[text()=' CONTROL ROOM & CREW']/ancestor::phase-two-container//nz-form-label//label")
	List<WebElement> controlRoomAndCrewSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Details']//nz-form-label//label")
	List<WebElement> detailsSectionFieldLabels;
	
	@FindBy(xpath="//*[contains(@class,'ant-select-item') and text()]")
	List<WebElement> dropdownOptions;
	
	@FindBy(xpath="//label[text()=' TPM/TM Name ']/ancestor::nz-form-label/following::input[1]")
	WebElement tpmTmNameInput;
	
	@FindBy(xpath="//*[contains(text(),' Is a TPM or TM Needed? ')]/../following::*[1]//*[text()]")
	List<WebElement> isATpmOrTmNeededRadioLabels;
	
	@FindBy(xpath="//*[text()=' Location ']/../following::*[1]//input")
	List<WebElement> locationInputs;
	
	@FindBy(xpath="//*[text()=' Set Location ']/../following::*[1]//input")
	List<WebElement> setLocationInputs;
	
	@FindBy(xpath="(//label[contains(text(),'Start Date')]/ancestor::nz-form-label/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearIconForStartDate;

	@FindBy(xpath="(//label[contains(text(),'Start Time')]/ancestor::nz-form-label/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearIconForStartTime;

	@FindBy(xpath="(//label[contains(text(),'End Time')]/ancestor::nz-form-label/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearIconForEndTime;
	
	@FindBy(xpath="//status-edit-panel//*[contains(@class,'pending-area')]//*[text()]")
	List<WebElement> uncheckedFulfillmentStatusElements;

	@FindBy(xpath="//status-edit-panel//*[contains(@class,'pending-area')]//*[contains(@class,'check-button')]")
	List<WebElement> checkButtonForUncheckedFulfillmentStatusElements;
	
	@FindBy(xpath="//status-edit-panel//button[contains(@class,'clear-button')]")
	List<WebElement> clearButtonForCheckedFulfillmentStatusElements;
	
	@FindBy(xpath="//button[contains(@class,'clear-button')]/ancestor::status-edit-panel//h1")
	List<WebElement> statusNamesHavingClearButton;

	public ProdExtendorBridgeCrewRequestFormPage() {
		PageFactory.initElements(DriverFactory.getCurrentDriver(), this);
	}

	/**
	 * To verify request for details info missing field error message
	 *
	 * @throws Exception
	 */
	public void verifyShowInfoMissingFieldError(String requestForErrorMessage, String airPlatformErrorMessage,
			String showUnitErrorMessage, String budgetCodeErrorMessage, String startDateErrorMessage,
			String startTimeErrorMessage, String endTimeErrorMessage) throws Exception {
		try {
			CommonValidations.verifyTextValue(requestForError, requestForErrorMessage);
			producerDashboardGeneralPage.verifyShowInfoMissingFieldError(airPlatformErrorMessage, showUnitErrorMessage,
					budgetCodeErrorMessage, startDateErrorMessage, startTimeErrorMessage, endTimeErrorMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify control room and crew section missing field error message
	 *
	 * @throws Exception
	 */
	public void verifyControlRoomAndCrewMissingFieldError(String controlRoomAndCrewErrorMessage,
			String controlRoomLocationErrorMessage, String controlRoomErrorMessage) throws Exception {
		WebAction.scrollIntoView(producerDashboardGeneralPage.controlRoomAndCrewSection);
		try {
			CommonValidations.verifyTextValue(controlRoomAndCrewError, controlRoomAndCrewErrorMessage);
			producerDashboardGeneralPage.controlRoomLocationErrorMessage(controlRoomLocationErrorMessage);
			producerDashboardGeneralPage.controlRoomErrorMessage(controlRoomErrorMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addShowInfoExtendorBridgeCrewProduction(String requestFor, String airPlatformText, String showText,
			String startDateText, String startTimeText, String endTimeText) throws Exception {
		if (requestFor != null) {
			if (requestFor.equalsIgnoreCase("Extend")) {
				WebAction.click(requestFor_Extend);
				ReportGenerate.test.log(Status.INFO,
						"User selects " + requestFor + " for Request For section in Extend or Bridge Form");
			} else {
				WebAction.click(requestFor_Bridge);
				ReportGenerate.test.log(Status.INFO,
						"User selects Bridge for Request For section in Extend or Bridge Form");
			}
			ProducerDashboardGeneralPage.emailtoList.add(ConfigFileReader
					.getProperty("division-engineering", "emailconfig.properties"));
			
			ProducerDashboardGeneralPage.emailtoList.add(ConfigFileReader
					.getProperty("prodreq-staging", "emailconfig.properties"));
			
			ProducerDashboardGeneralPage.emailtoList.add(ConfigFileReader
					.getProperty("extendBridge-setcrew-hairstylist", "emailconfig.properties"));
		}
		WebAction.scrollIntoView(producerDashboardGeneralPage.talentSection);
		producerDashboardGeneralPage.selectAirPlatform(airPlatformText);
		producerDashboardGeneralPage.enterShow(showText);
		producerDashboardGeneralPage.selectStartDate(startDateText);
		producerDashboardGeneralPage.selectStartTime(startTimeText);
		producerDashboardGeneralPage.selectEndTime(endTimeText);
	}

	public void selectControlRoomAndCrewOption(String controlRoomAndCrewOptionText) throws Exception {
		if (controlRoomAndCrewOptionText != null) {
			if (controlRoomAndCrewOptionText.equalsIgnoreCase("Yes")) {
				WebAction.click(controlRoom_Eob_Yes);
				ReportGenerate.test.log(Status.INFO, "User selects " + controlRoomAndCrewOptionText
						+ " for Control Room & Crew section in Extend or Bridge Form");
			} else {
				WebAction.click(controlRoom_Eob_No);
				ReportGenerate.test.log(Status.INFO,
						"User selects No for Control Room & Crew section in Extend or Bridge Form");
			}
		}
	}

	public void addControlRoomAndCrewInfo(String controlRoomAndCrewOptionText, String controlRoomLocationText,
			String controlRoomText) throws Exception {
		try {
			WebAction.scrollIntoView(producerDashboardGeneralPage.controlRoomAndCrewSection);
			selectControlRoomAndCrewOption(controlRoomAndCrewOptionText);
			Constants.setControlRoomOption(controlRoomAndCrewOptionText);
			if (controlRoomAndCrewOptionText.equalsIgnoreCase("Yes")) {
				producerDashboardGeneralPage.addControlRoomLocation(controlRoomLocationText);
				producerDashboardGeneralPage.addControlRoom(controlRoomText, controlRoomLocationText);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public By getBy(String name) {
		if (name.equals("dropdownOptionsBy")) {
			return By.xpath("//*[contains(@class,'ant-select-item') and text()]");
		} else if (name.equals("locationInputBy")) {
			return By.xpath("//*[text()=' Location ']/../following::*[1]//input");
		} else if (name.equals("setLocationInputBy")) {
			return By.xpath("//*[text()=' Set Location ']/../following::*[1]//input");
		} else if (name.equals("addressInputBy")) {
			return By.xpath("//*[text()=' Address ']/../following::*[1]//input");
		} else if (name.equals("divisionInputPlaceholderBy")) {
			return By.xpath("//*[text()=' Division ']/../following::*[1]//nz-select-placeholder");
		} else if (name.equals("airPlatformInputPlaceholderBy")) {
			return By.xpath("//*[text()=' Air Platform ']/../following::*[1]//nz-select-placeholder");
		} else if (name.equals("showUnitOrProjectNameInputPlaceholderBy")) {
			return By.xpath("//*[text()=' Show Unit or Project Name ']/../following::*[1]//nz-select-placeholder");
		} else if (name.equals("locationInputPlaceholderBy")) {
			return By.xpath("//*[text()=' Location ']/../following::*[1]//nz-select-placeholder");
		} else if (name.equals("setLocationInputPlaceholderBy")) {
			return By.xpath("//*[text()=' Set Location ']/../following::*[1]//nz-select-placeholder");
		} else if (name.equals("controlRoomLocationInputPlaceholderBy")) {
			return By.xpath("//*[text()=' Control Room Location ']/../following::*[1]//nz-select-placeholder");
		} else if (name.equals("controlRoomInputPlaceholderBy")) {
			return By.xpath("//*[text()=' Control Room ']/../following::*[1]//nz-select-placeholder");
		} else if (name.equals("locationRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Location ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("setLocationRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Set Location ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("addressRequiredErrorInControlRoomAndCrewBy")) {
			return By.xpath(
					"//*[contains(text(),'CONTROL ROOM & CREW')]/ancestor::phase-two-container//label[text()=' Address ']"
							+ "/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("addressRequiredErrorInSetLocationAndCrewBy")) {
			return By.xpath(
					"//*[contains(text(),'SET LOCATION & CREW')]/ancestor::phase-two-container//label[text()=' Address ']"
							+ "/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("airPlatformRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Air Platform ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("showUnitOrProjectNameRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Show Unit or Project Name ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("otherRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Other ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("startDateRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Start Date ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("startTimeRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Start Time ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("endTimeRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' End Time ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("divisionRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Division ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("requestForRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Request For ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("budgetCodeRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Budget Code ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("controlRoomAndCrewRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Control Room & Crew ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("controlRoomLocationRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Control Room Location ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("controlRoomRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Control Room ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("IsATpmorTmNeededRadioLabels")) {
			return By.xpath(
					"//*[contains(text(),' Is a TPM or TM Needed? ')]/../following::*[1]//label[contains(@class,'ant-radio-button')]");
		} else if (name.equals("tpmOrTmNameInput")) {
			return By.xpath("//label[text()=' TPM/TM Name ']/ancestor::nz-form-label/following::input[1]");
		}
		Assert.fail(String.format("Could not find the By locator for '%s'", name));
		return By.xpath("");
	}

	public void verifyTheFormSectionsInExtendOrBrigeCrewAndFacilitiesProductionForm() {
		List<String> expectedHeaders = new ArrayList<String>();
		expectedHeaders
				.addAll(Arrays.asList("STATUS", "GENERAL DETAILS", "REQUESTER(S)", "TALENT", "DETAILS", "SHOW INFO"));
		String requestFor = Constants.getRequestFor();
		if (requestFor != null && requestFor.equals("Bridge")) {
			expectedHeaders.addAll(Arrays.asList("BRIDGE SET LOCATION & CREW", "BRIDGE CONTROL ROOM & CREW"));
		} else if (requestFor != null && requestFor.equals("Extend")) {
			expectedHeaders.addAll(Arrays.asList("EXTEND SET LOCATION & CREW", "EXTEND CONTROL ROOM & CREW"));
		} else {
			expectedHeaders.addAll(Arrays.asList("SET LOCATION & CREW", "CONTROL ROOM & CREW"));
		}
		expectedHeaders.add("TPM / TM INFORMATION");
		if (expectedHeaders.size() != formSectionTitles.size()) {
			Assert.assertEquals(formSectionTitles.size(), expectedHeaders.size(),
					"Total number of sections are not the same as expected");
		} else {
			boolean allFormSectionsArePresent = true;
			for (int itr = 0; itr < expectedHeaders.size(); itr++) {
				String expectedName = expectedHeaders.get(itr);
				String displayedName = WebAction.getText(formSectionTitles.get(itr));
				if (!expectedName.equals(displayedName)) {
					allFormSectionsArePresent = false;
					Assert.assertEquals(displayedName, expectedName,
							"Expected section name is not same as displayed name");
				}
			}
			Assert.assertTrue(allFormSectionsArePresent,
					"All expected sections are not present on Extend or Bridge Crew & Facilities Production form");
		}
	}

	public List<WebElement> getRadioLabelElements(String field) {
		WebDriver driver = getCurrentDriver();
		if (field.equals("Request For")) {
			return requestForRadioLabels;
		} else if (field.equals("Is Budget Code Available?")) {
			return isBudgetCodeAvailableRadioLabels;
		} else if (field.equals("Control Room & Crew")) {
			return controlRoomAndCrewRadioLabels;
		} else if (field.equals("Is a TPM or TM Needed?")) {
			return driver.findElements(getBy("IsATpmorTmNeededRadioLabels"));
		}
		return new ArrayList<WebElement>();
	}

	public void storeInConstants(String fieldName, Object option, Integer position, String sectionName) {
		if (sectionName.contains("SET LOCATION & CREW")) {
			if (fieldName.equals("Location") || fieldName.equals("Set Location") || fieldName.equals("Address")) {
				List<LocationRecord> locationRecords = Constants.getLocation();
				int count = locationRecords.size();
				int totalRecords = position + 1;
				while (count++ < totalRecords) {
					locationRecords.add(new LocationRecord());
				}
				if (fieldName.equals("Location")) {
					locationRecords.get(position).setLocation((String) option);
				} else if (fieldName.equals("Set Location")) {
					locationRecords.get(position).setSetLocation((String) option);
				} else if (fieldName.equals("Address")) {
					locationRecords.get(position).setAddress((String) option);
				}
			}
		} else if (sectionName.contains("CONTROL ROOM & CREW")) {
			if (fieldName.equals("Control Room & Crew") || fieldName.equals("Control Room Location")
					|| fieldName.equals("Control Room") || fieldName.equals("Address")) {
				List<ControlRoomAndCrewRecord> records = Constants.getControlRoomAndCrew();
				int count = records.size();
				int totalRecords = position + 1;
				while (count++ < totalRecords) {
					records.add(new ControlRoomAndCrewRecord());
				}
				if (fieldName.equals("Control Room & Crew")) {
					String val = (String) option;
					records.get(position).setControlRoomAndCrew(val);
					if (val.equalsIgnoreCase("No")) {
						records.get(position).setControlRoomLocation("");
						records.get(position).setControlRoom("");
						records.get(position).setAddress("");
					}
				} else if (fieldName.equals("Control Room Location")) {
					records.get(position).setControlRoomLocation((String) option);
				} else if (fieldName.equals("Control Room")) {
					records.get(position).setControlRoom((String) option);
				} else if (fieldName.equals("Address")) {
					records.get(position).setAddress((String) option);
				}
			}
		} else if (sectionName.equals("TPM / TM INFORMATION")) {
			TpmOrTmInformation rec = Constants.getTpmOrTmInformation();
			if (fieldName.equals("Is a TPM or TM Needed?")) {
				String choice = (String) option;
				rec.setIsATpmOrTmNeeded(choice);
				if (choice.equalsIgnoreCase("No")) {
					rec.setSameAsRequester(false);
					rec.setTpmOrTmName("");
				}
			} else if (fieldName.equals("Same as requester?")) {
				Boolean choice = (Boolean) option;
				rec.setSameAsRequester(choice);
				if (choice == false) {
					rec.setTpmOrTmName("");
				} else {
					List<RequesterRecord> list = Constants.getRequesters();
					if (list.size() > 0) {
						rec.setTpmOrTmName(list.get(0).getName());
					}
				}
			} else if (fieldName.equals("TPM/TM Name")) {
				rec.setTpmOrTmName((String) option);
			}
		} else if (fieldName.equals("Division")) {
			Constants.setDivision((String) option);
		} else if (fieldName.equals("Details and Notes")) {
			Constants.setDetailsAndNotes((String) option);
		} else if (fieldName.equals("Request For")) {
			Constants.setRequestFor((String) option);
		} else if (fieldName.equals("Show Unit or Project Name")) {
			Constants.setShowUnitOrProjectName((String) option);
		} else if (fieldName.equals("Air Platform")) {
			Constants.setAirPlatform((String) option);
		} else if (fieldName.equals("Is Budget Code Available?")) {
			Constants.setIsBudgetCodeAvailable((String) option);
		} else if (fieldName.equals("Budget Code")) {
			Constants.setBudgetCode((String) option);
		} else if (fieldName.equals("Start Date")) {
			Constants.setStartDate((String) option);
		} else if (fieldName.equals("Start Time")) {
			Constants.setStartTime((String) option);
		} else if (fieldName.equals("End Time")) {
			Constants.setEndTime((String) option);
		} else if (fieldName.equals("Work Order #")) {
			Constants.setWorkOrder((String) option);
		} else if (fieldName.equals("Other")) {
			Constants.setOtherInShowInfo((String) option);
		}
	}

	/*
	 * metadata is a collection of strings first string should be a section name of
	 * the form
	 */
	public WebElement getInputElement(String fieldName, int position, String... metadata) {
		WebDriver driver = getCurrentDriver();
		if (fieldName.equals("Location")) {
			return driver.findElements(getBy("locationInputBy")).get(position);
		} else if (fieldName.equals("Set Location")) {
			return driver.findElements(getBy("setLocationInputBy")).get(position);
		} else if (fieldName.equals("Division")) {
			return divisionInput;
		} else if (fieldName.equals("Show Unit or Project Name")) {
			return showUnitOrProjectNameInput;
		} else if (fieldName.equals("Details and Notes")) {
			return detailsAndNotesInput;
		} else if (fieldName.equals("Air Platform")) {
			return airPlatformInput;
		} else if (fieldName.equals("Show Unit or Project Name")) {
			return showUnitOrProjectNameInput;
		} else if (fieldName.equals("Start Date")) {
			return startDateInput;
		} else if (fieldName.equals("Start Time")) {
			return startTimeInput;
		} else if (fieldName.equals("End Time")) {
			return endTimeInput;
		} else if (fieldName.equals("Work Order #")) {
			return workOrderInput;
		} else if (fieldName.equals("Other")) {
			return otherInput;
		} else if (fieldName.equals("Budget Code")) {
			return budgetCodeInput;
		} else if (fieldName.equals("Control Room Location")) {
			return controlRoomLocationInput;
		} else if (fieldName.equals("Control Room")) {
			return controlRoomInput;
		} else if (fieldName.equals("Address")) {
			String sectionName = metadata.length > 0 ? metadata[0] : "";
			if (sectionName.contains("SET LOCATION & CREW")) {
				return addressInputInSetLocationAndCrewSection;
			} else if (sectionName.contains("CONTROL ROOM & CREW")) {
				return addressInputInControlRoomAndCrewSection;
			}
		}
		return null;
	}

	public void checkPlaceholderForInputsHavingPlaceholderAttribute(String field, Integer position,
			String sectionName) {
		// verify the placeholder of the inputs or textarea that has placeholder
		// attribute
		WebElement element = getInputElement(field, position, sectionName);
		String displayed = WebAction.getAttribute(element, "placeholder");
		String expected = getExpectedPlaceholder(field, sectionName);
		Assert.assertEquals(displayed.trim(), expected, "Placeholder for '" + field + "' textarea is not correct");
	}

	public String getExpectedPlaceholder(String field, String... metadata) {
		if (field.equals("Division")) {
			return "Select Division";
		} else if (field.equals("Location")) {
			return "Select Location";
		} else if (field.equals("Air Platform")) {
			return "Select Air Platform";
		} else if (field.equals("Show Unit or Project Name")) {
			return "Show or Project Name";
		} else if (field.equals("Budget Code")) {
			return "Budget Code";
		} else if (field.equals("Details and Notes")) {
			return "Type additional details here...";
		} else if (field.equals("Start Date")) {
			return "Select Date";
		} else if (field.equals("Start Time")) {
			return "Select time";
		} else if (field.equals("End Time")) {
			return "Select time";
		} else if (field.equals("Work Order #")) {
			return "Enter work order here";
		} else if (field.equals("Other")) {
			return "Enter Show or Project title";
		} else if (field.equals("Set Location")) {
			return "Select Set Location";
		} else if (field.equals("TPM/TM Name")) {
			return "FirstName LastName";
		} else if (field.equals("Address")) {
			String sectionName = metadata.length > 0 ? metadata[0] : "";
			if (sectionName.contains("SET LOCATION & CREW")) {
				return "Enter address here";
			} else if (sectionName.contains("CONTROL ROOM & CREW")) {
				return "Enter address here";
			}
		}
		return "";
	}

	public void checkFieldsInSectionOfExtendOrBridgeCrewAndFacilitiesProduction(String sectionName) {
		List<WebElement> sectionLabelElements = getSectionLabelElements(sectionName);
		Assert.assertTrue(sectionLabelElements != null, String.format(
				"%s section is not present in Extend or Bridge Crew & Facilities production form", sectionName));
		List<String> expectedFieldNamesList = getExpectedFieldsSectionWise(sectionName);
		System.out.println("required validation : expected fields : " + expectedFieldNamesList);
		Assert.assertEquals(sectionLabelElements.size(), expectedFieldNamesList.size(), String.format(
				"Number of displayed fields and expected fields not equal in %s section of Extend or Bridge Crew & Facilities Production",
				sectionName));
		List<String> expectedRequiredFieldList = getRequiredFieldsSectionWise(sectionName);
		System.out.println("required validation : required fields : " + expectedRequiredFieldList);
		for (int itr = 0; itr < expectedFieldNamesList.size(); itr++) {
			String expectedName = expectedFieldNamesList.get(itr);
			String displayedField = WebAction.getText(sectionLabelElements.get(itr));
			Assert.assertEquals(displayedField, expectedName, String.format(
					"Displayed field is not same as expected field in %s section of Extend or Bridge Crew & Facilities Production",
					sectionName));
			String cssClasses = WebAction.getAttribute(sectionLabelElements.get(itr), "class");
			System.out.println("required cssClasses : " + cssClasses);
			if (cssClasses.contains(" ant-form-item-required") && !expectedRequiredFieldList.contains(displayedField)) {
				Assert.assertTrue(
						cssClasses.contains(" ant-form-item-required")
								&& !expectedRequiredFieldList.contains(displayedField),
						String.format(
								"'%s' is not a required field in %s section but displayed with *(required symbol)",
								displayedField, sectionName));
			} else if (!cssClasses.contains(" ant-form-item-required")
					&& expectedRequiredFieldList.contains(displayedField)) {
				Assert.assertTrue(
						!cssClasses.contains(" ant-form-item-required")
								&& expectedRequiredFieldList.contains(displayedField),
						String.format(
								"'%s' is a required field in %s section but not displayed with *(required symbol)",
								displayedField, sectionName));
			}
		}
	}

	public List<WebElement> getSectionLabelElements(String sectionName) {
		if (sectionName.equalsIgnoreCase("GENERAL DETAILS")) {
			return generalDetailsSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("REQUESTER(S)")) {
			return requestersSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("TALENT")) {
			return talentSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("SHOW INFO")) {
			return showInfoSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("SET LOCATION & CREW")) {
			return setLocationAndCrewSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("CONTROL ROOM & CREW")) {
			return controlRoomAndCrewSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("EXTEND SET LOCATION & CREW")) {
			return extendSetLocationAndCrewSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("BRIDGE SET LOCATION & CREW")) {
			return bridgeSetLocationAndCrewSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("EXTEND CONTROL ROOM & CREW")) {
			return extendControlRoomAndCrewSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("BRIDGE CONTROL ROOM & CREW")) {
			return bridgeControlRoomAndCrewSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("DETAILS")) {
			return detailsSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("TPM / TM INFORMATION")) {
			return tpmOrTmInformationSectionFieldLabels;
		}
		return null;
	}

	public List<String> getExpectedFieldsSectionWise(String sectionName) {
		List<String> fieldNamesList = new ArrayList<String>();
		if (sectionName.equalsIgnoreCase("GENERAL DETAILS")) {
			fieldNamesList.addAll((Arrays.asList("Division")));
		} else if (sectionName.equalsIgnoreCase("REQUESTER(S)")) {
			fieldNamesList.addAll((Arrays.asList("Add Requester(s)")));
		} else if (sectionName.equalsIgnoreCase("TALENT")) {
			fieldNamesList.addAll((Arrays.asList("Talent")));
		} else if (sectionName.equalsIgnoreCase("DETAILS")) {
			fieldNamesList.addAll((Arrays.asList("Details and Notes")));
		} else if (sectionName.equalsIgnoreCase("SHOW INFO")) {
			fieldNamesList.addAll(Arrays.asList("Request For", "Air Platform", "Show Unit or Project Name"));
			String showUnitOrProjectName = Constants.getShowUnitOrProjectName();
			if (showUnitOrProjectName != null && showUnitOrProjectName.equalsIgnoreCase("Other")) {
				fieldNamesList.add("Other");
			}
			fieldNamesList.addAll(Arrays.asList("Is Budget Code Available?", "Budget Code"));
			String division = Constants.getDivision();
			if (division != null && division.equals("CNBC")) {
				fieldNamesList.add("Work Order #");
			}
			fieldNamesList.addAll(Arrays.asList("Start Date", "Start Time", "End Time"));
		} else if (sectionName.equalsIgnoreCase("SET LOCATION & CREW")
				|| sectionName.equalsIgnoreCase("BRIDGE SET LOCATION & CREW")
				|| sectionName.equalsIgnoreCase("EXTEND SET LOCATION & CREW")) {
			fieldNamesList.addAll(Arrays.asList("Location"));
			List<LocationRecord> locationRecords = Constants.getLocation();
			String location = locationRecords.size() > 0 ? locationRecords.get(0).getLocation() : null;
			if (location != null && location.equals("Field")) {
				fieldNamesList.addAll(Arrays.asList("Address"));
			} else if (location != null && location.equals("None")) {
				fieldNamesList.addAll(Arrays.asList());
			} else {
				fieldNamesList.addAll(Arrays.asList("Set Location"));
			}
		} else if (sectionName.equalsIgnoreCase("CONTROL ROOM & CREW")
				|| sectionName.equalsIgnoreCase("BRIDGE CONTROL ROOM & CREW")
				|| sectionName.equalsIgnoreCase("EXTEND CONTROL ROOM & CREW")) {
			fieldNamesList.addAll((Arrays.asList("Control Room & Crew", "Control Room Location")));
			List<ControlRoomAndCrewRecord> records = Constants.getControlRoomAndCrew();
			if (records == null || records.size() == 0) {
				fieldNamesList.addAll((Arrays.asList("Control Room")));
			} else {
				String controlRoomLocation = records.get(0).getControlRoomLocation();
				String controlRoomAndCrew = records.get(0).getControlRoomAndCrew();
				if (controlRoomLocation == null || controlRoomAndCrew == null) {
					fieldNamesList.addAll((Arrays.asList("Control Room")));
				} else if (controlRoomLocation.equals("Rock Center") || controlRoomAndCrew.equals("No")) {
					fieldNamesList.addAll((Arrays.asList("Control Room")));
				} else if (controlRoomLocation.equals("Field")) {
					fieldNamesList.addAll((Arrays.asList("Address")));
				} else if (controlRoomLocation.equals("No Control Room")) {
					fieldNamesList.addAll((Arrays.asList()));
				}
			}
		} else if (sectionName.equals("TPM / TM INFORMATION")) {
			fieldNamesList.addAll(Arrays.asList("Is a TPM or TM Needed?", "Same as requester?", "TPM/TM Name"));
		}
		return fieldNamesList;
	}

	public List<String> getRequiredFieldsSectionWise(String sectionName) {
		List<String> fieldNamesList = new ArrayList<String>();
		if (sectionName.equalsIgnoreCase("GENERAL DETAILS")) {
			fieldNamesList.addAll((Arrays.asList("Division")));
		} else if (sectionName.equalsIgnoreCase("REQUESTER(S)") || sectionName.equalsIgnoreCase("TALENT")) {
			fieldNamesList.addAll((Arrays.asList()));
		} else if (sectionName.equalsIgnoreCase("SHOW INFO")) {
			fieldNamesList.addAll((Arrays.asList("Air Platform", "Show Unit or Project Name", "Other", "Start Date",
					"Start Time", "End Time", "Request For", "Is Budget Code Available?", "Budget Code")));
		} else if (sectionName.equalsIgnoreCase("SET LOCATION & CREW")
				|| sectionName.equalsIgnoreCase("BRIDGE SET LOCATION & CREW")
				|| sectionName.equalsIgnoreCase("EXTEND SET LOCATION & CREW")) {
			fieldNamesList.addAll((Arrays.asList("Location", "Set Location", "Address")));
		} else if (sectionName.equalsIgnoreCase("CONTROL ROOM & CREW")
				|| sectionName.equalsIgnoreCase("BRIDGE CONTROL ROOM & CREW")
				|| sectionName.equalsIgnoreCase("EXTEND CONTROL ROOM & CREW")) {
			List<ControlRoomAndCrewRecord> records = Constants.getControlRoomAndCrew();
			if (records == null || records.size() == 0) {
				fieldNamesList.addAll(
						(Arrays.asList("Control Room & Crew", "Control Room Location", "Control Room", "Address")));
			} else {
				String controlRoomAndCrew = records.get(0).getControlRoomAndCrew();
				System.out.println("getControlRoomAndCrew : " + controlRoomAndCrew);
				if (controlRoomAndCrew.equalsIgnoreCase("No")) {
					fieldNamesList.addAll((Arrays.asList("Control Room & Crew")));
				} else if (controlRoomAndCrew.equalsIgnoreCase("Yes")) {
					fieldNamesList.addAll(
							(Arrays.asList("Control Room & Crew", "Control Room Location", "Control Room", "Address")));
				}
			}
		} else if (sectionName.equalsIgnoreCase("DETAILS")) {
			fieldNamesList.addAll((Arrays.asList()));
		} else if (sectionName.equals("TPM / TM INFORMATION")) {
			fieldNamesList.addAll(Arrays.asList());
		}
		return fieldNamesList;
	}

	public String getStringFromConstants(String fieldName, String sectionName) {
		if (fieldName.equals("Request For")) {
			return Constants.getRequestFor();
		} else if (fieldName.equals("Division")) {
			return Constants.getDivision();
		} else if (fieldName.equals("Details & Notes")) {
			return Constants.getDetailsAndNotes();
		} else if (sectionName.contains("SET LOCATION & CREW")
				&& (fieldName.equals("Location") || fieldName.equals("Set Location") || fieldName.equals("Address"))) {
			if (Constants.getLocation().size() > 0) {
				LocationRecord rec = Constants.getLocation().get(0);
				if (fieldName.equals("Location")) {
					return rec.getLocation();
				} else if (fieldName.equals("Set Location")) {
					return rec.getSetLocation();
				} else if (fieldName.equals("Address")) {
					return rec.getAddress();
				}
			}
		} else if (fieldName.equals("Show Unit or Project Name")) {
			return Constants.getShowUnitOrProjectName();
		} else if (fieldName.equals("Is Budget Code Available?")) {
			return Constants.getIsBudgetCodeAvailable();
		} else if (sectionName.contains("SET LOCATION & CREW")
				&& (fieldName.equals("Control Room Location") || fieldName.equals("Control Room")
						|| fieldName.equals("Control Room & Crew") || fieldName.equals("Address"))) {
			List<ControlRoomAndCrewRecord> records = Constants.getControlRoomAndCrew();
			if (records.size() > 0) {
				ControlRoomAndCrewRecord rec = records.get(0);
				if (fieldName.equals("Control Room Location")) {
					return rec.getControlRoomLocation();
				} else if (fieldName.equals("Control Room")) {
					return rec.getControlRoom();
				} else if (fieldName.equals("Control Room & Crew")) {
					return rec.getControlRoomAndCrew();
				} else if (fieldName.equals("Address")) {
					return rec.getAddress();
				}
			}
		} else if (fieldName.equals("Is a TPM or TM Needed?")) {
			String choice = Constants.getTpmOrTmInformation().getIsATpmOrTmNeeded();
			if (choice == null) {
				storeInConstants(fieldName, "No", 0, sectionName);
			}
			return Constants.getTpmOrTmInformation().getIsATpmOrTmNeeded();
		}
		return null;
	}

	public void checkPlaceholderOfSelectFields(String fieldName, String sectionName) {
		List<WebElement> placeholderElement = getPlaceholderElementForField(fieldName);
		String requestForValue = getStringFromConstants(fieldName, sectionName);
		if (requestForValue == null) {
			if (placeholderElement.size() == 0) {
				Assert.assertEquals(placeholderElement.size(), 1,
						"Placeholder for '" + fieldName + "' field is not present");
			}
			if (placeholderElement.size() > 1) {
				Assert.assertEquals(placeholderElement.size(), 1,
						"More than 1 placeholder for '" + fieldName + "' field is present");
			} else {
				String displayed = WebAction.getText(placeholderElement.get(0));
				String expected = getExpectedPlaceholder(fieldName);
				Assert.assertEquals(displayed, expected, "Placeholder for '" + fieldName + "' field is not correct");
			}
		} else {
//			if(placeholderElement.size() > 0) {
//				Assert.assertEquals(placeholderElement.size(),0, "Placeholder for '"+fieldName+"' field should not "
//						+ "display if value is selected");
//			}
		}
	}

	public List<WebElement> getPlaceholderElementForField(String field) {
		WebDriver driver = getCurrentDriver();
		if (field.equals("Division")) {
			return driver.findElements(getBy("divisionInputPlaceholderBy"));
		} else if (field.equals("Air Platform")) {
			return driver.findElements(getBy("airPlatformInputPlaceholderBy"));
		} else if (field.equals("Location")) {
			return driver.findElements(getBy("locationInputPlaceholderBy"));
		} else if (field.equals("Set Location")) {
			return driver.findElements(getBy("setLocationInputPlaceholderBy"));
		} else if (field.equals("Show Unit or Project Name")) {
			return driver.findElements(getBy("showUnitOrProjectNameInputPlaceholderBy"));
		} else if (field.equals("Control Room Location")) {
			return driver.findElements(getBy("controlRoomLocationInputPlaceholderBy"));
		} else if (field.equals("Control Room")) {
			return driver.findElements(getBy("controlRoomInputPlaceholderBy"));
		}
		return new ArrayList<WebElement>();
	}

	public void verifyErrorBelowFieldIfEmpty(String fieldName, String section) {
		List<WebElement> elements = getErrorElementForField(fieldName, section);
		Assert.assertFalse(elements.size() == 0,
				String.format("Error text for '%s' required field is not present", fieldName));
		WebElement element = elements.get(0);
		scrollIntoView(element);
		String displayed = getText(element);
		String expected = getExpectedErrorMessageForRequiredField(fieldName, section);
		Assert.assertEquals(displayed, expected,
				String.format("Error text for '%s' required field is not correct", fieldName));
	}

	public void verifyErrorBelowFieldIfNotEmpty(String fieldName, String section) {
		List<WebElement> elements = getErrorElementForField(fieldName, section);
		Assert.assertTrue(elements.size() == 0,
				String.format("Error text for '%s' required field should not display", fieldName));
	}

	public String getExpectedErrorMessageForRequiredField(String field, String sectionName) {
		if (field.equals("Division")) {
			return "Select a value";
		} else if (field.equals("Location")) {
			return "Select a value";
		} else if (field.equals("Air Platform")) {
			return "Select a value";
		} else if (field.equals("Show Unit or Project Name")) {
			return "Please select/enter a show or project name";
		} else if (field.equals("Start Date")) {
			return "Select a date";
		} else if (field.equals("Start Time")) {
			return "Enter a value";
		} else if (field.equals("End Time")) {
			return "Enter a value";
		} else if (field.equals("Set Location")) {
			return "Select a value";
		} else if (field.equals("Location")) {
			return "Select a value";
		} else if (field.equals("Control Room & Crew")) {
			return "Select a value";
		} else if (field.equals("Control Room")) {
			return "Select a value";
		} else if (field.equals("Control Room Location")) {
			return "Select a value";
		} else if (field.equals("Request For")) {
			return "Select a value";
		} else if (field.equals("Budget Code")) {
			return "Enter a value";
		} else if (field.equals("Other")) {
			return "Please enter Show or Project title";
		} else if (field.equals("Address")) {
			if (sectionName.contains("SET LOCATION & CREW")) {
				return "Enter a value";
			}
			if (sectionName.contains("CONTROL ROOM & CREW")) {
				return "Enter a value";
			}
		}
		return "";
	}

	public List<WebElement> getErrorElementForField(String field, String sectionName) {
		WebDriver driver = getCurrentDriver();
		if (field.equals("Division")) {
			return driver.findElements(getBy("divisionRequiredErrorBy"));
		} else if (field.equals("Location")) {
			return driver.findElements(getBy("locationRequiredErrorBy"));
		} else if (field.equals("Set Location")) {
			return driver.findElements(getBy("setLocationRequiredErrorBy"));
		} else if (field.equals("Air Platform")) {
			return driver.findElements(getBy("airPlatformRequiredErrorBy"));
		} else if (field.equals("Show Unit or Project Name")) {
			return driver.findElements(getBy("showUnitOrProjectNameRequiredErrorBy"));
		} else if (field.equals("Start Date")) {
			return driver.findElements(getBy("startDateRequiredErrorBy"));
		} else if (field.equals("Start Time")) {
			return driver.findElements(getBy("startTimeRequiredErrorBy"));
		} else if (field.equals("End Time")) {
			return driver.findElements(getBy("endTimeRequiredErrorBy"));
		} else if (field.equals("Other")) {
			return driver.findElements(getBy("otherRequiredErrorBy"));
		} else if (field.equals("Address")) {
			if (sectionName.contains("SET LOCATION & CREW")) {
				return driver.findElements(getBy("addressRequiredErrorInSetLocationAndCrewBy"));
			} else if (sectionName.contains("CONTROL ROOM & CREW")) {
				return driver.findElements(getBy("addressRequiredErrorInControlRoomAndCrewBy"));
			}
		} else if (field.equals("Control Room & Crew")) {
			return driver.findElements(getBy("controlRoomAndCrewRequiredErrorBy"));
		} else if (field.equals("Control Room")) {
			return driver.findElements(getBy("controlRoomRequiredErrorBy"));
		} else if (field.equals("Control Room Location")) {
			return driver.findElements(getBy("controlRoomLocationRequiredErrorBy"));
		} else if (field.equals("Budget Code")) {
			return driver.findElements(getBy("budgetCodeRequiredErrorBy"));
		} else if (field.equals("Request For")) {
			return driver.findElements(getBy("requestForRequiredErrorBy"));
		}
		return new ArrayList<WebElement>();
	}

	/**
	 * To verify values in the extend or bridge form are present in production
	 * dashboard columns
	 * 
	 * @throws Exception
	 */
	public void verifyExtendBridgeRequestValuesWithProductionDashboardValues(String additionalRequestersText,
			String ProdDateText, String ShowProjectText, String ProductionPurposeText, String SetLocationText,
			String ControlRoomText, String SubmittedText) throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			String columnCellString = "//a[contains(text(),'<<RequestId>>')]/ancestor::tr/td[contains(@class,'<<ColumnType>>')]";
			producerDashboardGeneralPage.verifyStatusColorBaseOnProductionDateInDashboard(requestNumber,
					columnCellString);

			WebDriver driver = DriverFactory.getCurrentDriver();
			String formType = Constants.getFormType();
			// To validate workflow of the request
			List<String> workflowList = new ArrayList<String>();
			if (formType.equalsIgnoreCase("Rock Center") || formType.equalsIgnoreCase("Single Camera Live Shot")
					|| formType.equalsIgnoreCase("Extend Or Bridge Crew & Facilities")) {
				workflowList.add("T");
			}
			String locationNames = Constants.getLocations();
			String[] locationText;

			if (locationNames.contains(",")) {
				locationText = locationNames.split(",");
			} else {
				locationText = new String[1];
				locationText[0] = locationNames;
			}
			for (int i = 0; i < locationText.length; i++) {
				switch (locationText[i].toUpperCase()) {
				case "DC":
					workflowList.add("D");
					break;
				case "LA":
					workflowList.add("L");
					break;
				case "TELEMUNDO CENTER":
					workflowList.add("TC");
					break;
				}
			}

			String isTpmOrTmNeeded = Constants.getTpmOrTmInformation().toString();
			if (isTpmOrTmNeeded != null) {
				workflowList.add("M");
			}

			try {
				List<String> ExpectedWorkflowList = new ArrayList<String>();
				String columnTypeText = "workflow";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnType>>", columnTypeText)
						.concat("/nz-tag[contains(@class,'ant-tag-default')]");
				List<WebElement> workflowAbb = driver.findElements(By.xpath(columnCellTypeText));
				Waits.waitForAllElements(workflowAbb, WAIT_CONDITIONS.VISIBLE);

				for (int i = 0; i < workflowAbb.size(); i++) {
					System.out.println(
							workflowAbb.get(i).getText().trim() + " is displaying in workflow column in dashboard");
					ReportGenerate.test.log(Status.INFO,
							workflowAbb.get(i).getText().trim() + " is displaying in workflow column in dashboard");
					ExpectedWorkflowList.add(workflowAbb.get(i).getText().trim());
				}

				if (workflowList.equals(ExpectedWorkflowList)) {
					System.out.println("The workflow displaying in dashboard as expected");
					ReportGenerate.test.log(Status.INFO, "The workflow displaying in dashboard as expected");
				} else {
					System.out.println("The workflow not displaying in dashboard as expected");
					ReportGenerate.test.log(Status.INFO, "The workflow not displaying in dashboard as expected");
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}

			producerDashboardGeneralPage.verifyDefaultAndAdditionalRequesterInDashboard(additionalRequestersText,
					requestNumber, columnCellString);

			verifyExtendBridgeFormProdDateInDashboard(ProdDateText, requestNumber, columnCellString);

			producerDashboardGeneralPage.verifyShowProjectInDashboard(ShowProjectText, requestNumber, columnCellString);
			producerDashboardGeneralPage.verifyProductionPurposeInDashboard(ProductionPurposeText, requestNumber,
					columnCellString);
			producerDashboardGeneralPage.verifySetLocationInDashboard(SetLocationText, requestNumber, columnCellString);
			if (Constants.getControlRoomOption().equalsIgnoreCase("Yes")) {
				producerDashboardGeneralPage.verifyControlRoomInDashboard(ControlRoomText, requestNumber,
						columnCellString);
			}
			producerDashboardGeneralPage.verifySubmittedInDashboard(SubmittedText, requestNumber, columnCellString);
			producerDashboardGeneralPage.verifyActionsColumnInDashboard(requestNumber, columnCellString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyExtendBridgeFormProdDateInDashboard(String ProdDateText, String requestNumber,
			String columnCellString) throws Exception {
		try {
			String columnTypeText;
			// To validate production date,start time,end time
			if (ProdDateText != null) {
				String[] timeStampTextArrayList;
				timeStampTextArrayList = ProdDateText.split(",");
				columnTypeText = "timestamp";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnType>>", columnTypeText);
				if (timeStampTextArrayList[0] != null) {
					String date = producerDashboardGeneralPage.generateDate(timeStampTextArrayList[0], "MM/dd/yy");
					String dateTextIndashboard = columnCellTypeText.concat("/span[1]");
					producerDashboardGeneralPage
							.verifyExpectedValueInFormWithActualValueInDashboard(dateTextIndashboard, date);
				}
				if (timeStampTextArrayList[1] != null) {
					String startTime = Constants.getStartTime();
					String startTimeTextIndashboard = columnCellTypeText.concat("/span[2]");
					producerDashboardGeneralPage
							.verifyExpectedValueInFormWithActualValueInDashboard(startTimeTextIndashboard, startTime);
				}
				if (timeStampTextArrayList[2] != null) {
					String endTime = Constants.getEndTime();
					String endTimeTextIndashboard = columnCellTypeText.concat("/span[3]");
					producerDashboardGeneralPage
							.verifyExpectedValueInFormWithActualValueInDashboard(endTimeTextIndashboard, endTime);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public void executeStorage(String fieldName,Runnable store,RequestMode...mode){
		getProducerDashboardGeneralPage().executeStorage(fieldName,store, mode);
	}
	public void selectDivisionOnExtendOrBridgeProduction(String division,RequestMode...mode) {
		if(division == null) {
			return;
		}
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(divisionInput, division);
		Assert.assertTrue(isSelected,String.format("'%s' is not selected in Division dropdown",division));
		Runnable store = ()->{
			String oldVal = Constants.getDivision();
			Constants.setDivision(division);
			if(isEditMode(mode) && oldVal != null && !oldVal.equalsIgnoreCase(division)) {
				Constants.getLog().getLogs().putLog("Changed General Details Section:", 
						String.format(" Division: %s → %s", oldVal,division));
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
			}
		};
		executeStorage("Division",store,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public void provideDetailsAndNotesOnExtendOrBridgeProduction(String notes,RequestMode...mode) {
		if(notes == null) {
			return;
		}
		WebAction.clearInputOneCharAtTime(detailsAndNotesInput);
		detailsAndNotesInput.sendKeys(notes);
		Runnable store = ()->{
			String old = Constants.getDetailsAndNotes();
			if(isEditMode(mode) &&((old == null && notes.length()>0) || !old.equals(notes))) {
				Constants.getLog().getLogs().putLog("Changed Details Section",null);
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
			}
			Constants.setDetailsAndNotes(notes);
		};
		executeStorage("Details and Notes",store,mode);
	}
	public void clearDetailsAndNotesOnExtendOrBridgeProduction(RequestMode...mode) {
		WebAction.clearInputOneCharAtTime(detailsAndNotesInput);
		Runnable store = ()->{
			String old = Constants.getDetailsAndNotes();
			if(isEditMode(mode) && old != null) {
				Constants.getLog().getLogs().putLog("Changed Details Section",null);
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
			}
			Constants.setDetailsAndNotes(null);
		};
		executeStorage("Details and Notes",store,mode);
	}
	public void selectIsBudgetCodeAvailable(String choice,RequestMode...mode) {
		selectRadioOption(choice, isBudgetCodeAvailableRadioLabels);
		Runnable store = ()->{
			String oldBudgetCode = Constants.getBudgetCode();
			String oldIsBudgetCodeAvailable = Constants.getIsBudgetCodeAvailable();
			Constants.setIsBudgetCodeAvailable(choice);
			Constants.setBudgetCode(WebAction.getAttribute(budgetCodeInput, "value"));
			if(isEditMode(mode) && oldIsBudgetCodeAvailable != null && !oldIsBudgetCodeAvailable.equalsIgnoreCase(choice)) {
				Constants.getLog().getLogs().putLog("Changed Show Info Section:",
						String.format(" Budget Code: %s → %s", oldBudgetCode,Constants.getBudgetCode()));
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
			}
		};
		executeStorage("Is Budget Code Available",store,mode);
	}
	public void selectRadioOption(String option,List<WebElement> radios){
		Consumer<WebElement> consumer = (op) -> {
			WebAction.scrollIntoViewTillBottom(op);
			if(WebAction.getText(op).equalsIgnoreCase(option)) {
				int trials = 3;
				while(--trials >= 0) {
					try {
						op.click();
						break;
					}
					catch(Exception e) {
						try {
							Thread.sleep(2000);
						}
						catch(Exception ee) {
							ee.printStackTrace();
						}
					}
				}
			}
		};
		radios.forEach(consumer);
	}
	public void selectRequestFor(String choice,RequestMode...mode) {
		selectRadioOption(choice, requestForRadioLabels);
		Runnable store = ()->{
			String oldRequestFor = Constants.getRequestFor();
			Constants.setRequestFor(choice);
			if(isEditMode(mode) && oldRequestFor != null && !oldRequestFor.equalsIgnoreCase(choice)) {
				Constants.getLog().getLogs().putLog("Changed Show Info Section",null);
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
			}
		};
		executeStorage("Request For",store,mode);
	}
	public void selectAirPlatformOnExtendOrBridgeProduction(String airPlatform,RequestMode...mode) {
		if(airPlatform == null) {
			return ;
		}
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(airPlatformInput, airPlatform);
		Assert.assertTrue(isSelected,String.format("'%s' is not selected in Show Unit or Project Name dropdown",airPlatform));
		Runnable store = ()->{
			String oldVal = Constants.getAirPlatform();
			Constants.setAirPlatform(airPlatform);
			if(isEditMode(mode) && oldVal != null && !oldVal.equalsIgnoreCase(airPlatform)) {
				Constants.getLog().getLogs().removeLogStartingWith("Changed Show Info Section",null);
				Constants.getLog().getLogs().putLog("Changed Show Info Section:", 
						String.format(" Air Platform: %s → %s", oldVal,airPlatform));
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
			}
		};
		executeStorage("Air Platform",store,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public Boolean isEditMode(RequestMode...mode) {
		return producerDashboardGeneralPage.isEditMode(mode);
	}
	public void selectShowUnitOnExtendOrBridgeProduction(String showUnit,RequestMode...mode) {
		if(showUnit == null) {
			return ;
		}
		showUnitOrProjectNameInput.clear();
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(showUnitOrProjectNameInput, showUnit);
		Assert.assertTrue(isSelected,String.format("'%s' is not selected in Show Unit dropdown",showUnit));
		String newBudgetCode = WebAction.getAttribute(budgetCodeInput, "value");
		Runnable store = ()->{
			String oldShowUnit = Constants.getShowUnitOrProjectName();
			Constants.setShowUnitOrProjectName(showUnit);
			if(isEditMode(mode) && oldShowUnit != null && !oldShowUnit.equalsIgnoreCase(showUnit)) {
				Constants.getLog().getLogs().removeLogStartingWith("Changed Show Info Section",null);
				Constants.getLog().getLogs().putLog("Changed Show Info Section:", 
						String.format(" Show or Project Name: %s → %s", oldShowUnit,showUnit));
			}
		};
		executeStorage("Show Unit or Project Name",store,mode);
		Runnable store2 = ()->{
			String oldBudgetCode = Constants.getBudgetCode();
			Constants.setBudgetCode(newBudgetCode);
			if(isEditMode(mode) && oldBudgetCode != null && !oldBudgetCode.equalsIgnoreCase(newBudgetCode)) {
				Constants.getLog().getLogs().putLog("Changed Show Info Section:", 
						String.format(" Budget Code: %s → %s", oldBudgetCode,newBudgetCode));
			}
		};
		executeStorage("Budget Code",store2,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public void selectStartDateOnExtendOrBridgeProduction(String daysOffsetFromCurrent,RequestMode...mode) {
		if(daysOffsetFromCurrent == null) {
			return;
		}
		try {
			String date = DateFunctions.getDateUsingOffsetFromToday("MM/dd/yyyy", Integer.parseInt(daysOffsetFromCurrent));
			startDateInput.sendKeys(date,Keys.ENTER);
			Runnable store = ()->{
				String old = Constants.getStartDate();
				if(isEditMode(mode) && old != null && !old.equals(date)) {
					Constants.getLog().getLogs().putLog("Changed Date/Time under Show Info Section:",
							String.format(" Start Date: %s → %s", old,date));
					producerDashboardGeneralPage.changeStatusOnRequestUpdate();
				}
				Constants.setStartDate(date);
			};
			executeStorage("Start Date",store,mode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selectStartTimeOnExtendOrBridgeProduction(String time,RequestMode...mode) throws Exception {
		if(time == null) {
			return;
		}
		startTimeInput.sendKeys(time,Keys.ENTER);
		Runnable store = ()->{
			String oldTime = Constants.getStartTime();
			if(isEditMode(mode) && oldTime != null && !oldTime.equalsIgnoreCase(time)) {
				Constants.getLog().getLogs().putLog("Changed Date/Time under Show Info Section:",
						String.format(" Start Time: %s (EST) → %s (EST)",oldTime,time));
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
			}
			Constants.setStartTime(time);
		};
		executeStorage("Start Time",store,mode);
	}
	public void selectEndTimeOnExtendOrBridgeProduction(String time,RequestMode...mode) throws Exception {
		if(time == null) {
			return;
		}
		endTimeInput.sendKeys(time,Keys.ENTER);
		Runnable store = ()->{
			String oldTime = Constants.getEndTime();
			if(isEditMode(mode) && oldTime != null && !oldTime.equalsIgnoreCase(time)) {
				Constants.getLog().getLogs().putLog("Changed Date/Time under Show Info Section:",
						String.format(" End Time: %s (EST) → %s (EST)",oldTime,time));
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
			}
			Constants.setEndTime(time);
		};
		executeStorage("End Time",store,mode);
	}
	public void selectOtherOnExtendOrBridgeProduction(String other,RequestMode...mode) {
		if(other == null) {
			return;
		}
		otherInput.clear();
		otherInput.sendKeys(other);
		Runnable store = ()->{
			String old = Constants.getOtherInShowInfo();
			if(isEditMode(mode)) {
				Constants.getLog().getLogs().removeLogStartingWith("Changed Show Info Section",null);
				if(old == null) {
					Constants.getLog().getLogs().putLog("Changed Show Info Section:",
							String.format(" otherShowunittitle: %s",other));
				}
				else if(!old.equalsIgnoreCase(other)) {
					Constants.getLog().getLogs().putLog("Changed Show Info Section:",
							String.format(" otherShowunittitle: %s → %s",old,other));
				}
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
			}
			Constants.setOtherInShowInfo(other);
		};
		executeStorage("Other In Show Info",store,mode);
	}
	public void selectBudgetCodeOnExtendOrBridgeProduction(String code,RequestMode...mode) {
		if(code == null) {
			return;
		}
		budgetCodeInput.clear();
		budgetCodeInput.sendKeys(code);
		Runnable store = ()->{
			String old = Constants.getBudgetCode();
			if(isEditMode(mode) && old != null && !old.equalsIgnoreCase(code)) {
				Constants.getLog().getLogs().removeLogStartingWith("Changed Show Info Section",null);
				Constants.getLog().getLogs().putLog("Changed Show Info Section:",
						String.format(" Budget Code: %s → %s",old,code));
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
			}
			Constants.setBudgetCode(code);
		};
		executeStorage("Budget Code",store,mode);
	}
	public void selectWorkOrderOnExtendOrBridgeProduction(String workOrder,RequestMode...mode) {
		if(workOrder == null) {
			return;
		}
		workOrderInput.clear();
		workOrderInput.sendKeys(workOrder);
		Runnable store = ()->{
			String old = Constants.getWorkOrder();
			if(isEditMode(mode)) {
				Constants.getLog().getLogs().removeLogStartingWith("Changed Show Info Section",null);
				if(old == null) {
					Constants.getLog().getLogs().putLog("Changed Show Info Section:",
							String.format("Work Order#: null → %s",workOrder));
				}
				else if(!old.equalsIgnoreCase(workOrder)) {
					Constants.getLog().getLogs().putLog("Changed Show Info Section:",
							String.format("Work Order#: %s → %s",old,workOrder));
				}
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
			}
			Constants.setWorkOrder(workOrder);
		};
		executeStorage("Work Order",store,mode);
	}
	public void selectTpmTmNameOnExtendOrBridgeProduction(String name,RequestMode...mode) {
		if(name == null) {
			return;
		}
		tpmTmNameInput.clear();
		tpmTmNameInput.sendKeys(name);
		Runnable store = ()->{
			String old = Constants.getTpmOrTmInformation().getTpmOrTmName();
			if(isEditMode(mode) && (old == null || !old.equalsIgnoreCase(name))) {
				Constants.getLog().getLogs().putLog("Changed TPM/TM Information Section",null);
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
			}
			Constants.getTpmOrTmInformation().setTpmOrTmName(name);
		};
		executeStorage("TPM/TM Name",store,mode);
	}
	public void selectSameAsRequester(RequestMode...mode) {
		scrollIntoView(sameAsRequesterCheckbox);
		if (!sameAsRequesterCheckbox.isSelected()) {
			sameAsRequesterCheckbox.click();
			Runnable store = ()->{
				if(isEditMode(mode)) {
					Constants.getLog().getLogs().putLog("Changed TPM/TM Information Section",null);
					producerDashboardGeneralPage.changeStatusOnRequestUpdate();
				}
				Constants.getTpmOrTmInformation().setSameAsRequester(true);
			};
			executeStorage("Same as Requester?",store,mode);
			Runnable store2 = ()->{
				String newName = Constants.getLoggedInUsersDisplayName();
				Constants.getTpmOrTmInformation().setTpmOrTmName(newName);
			};
			executeStorage("TPM/TM Name",store2,mode);
		}
	}
	public void uncheckSameAsRequester(RequestMode...mode) {
		scrollIntoView(sameAsRequesterCheckbox);
		if (sameAsRequesterCheckbox.isSelected()) {
			sameAsRequesterCheckbox.click();
			Runnable store = ()->{
				if(isEditMode(mode)) {
					Constants.getLog().getLogs().putLog("Changed TPM/TM Information Section",null);
					producerDashboardGeneralPage.changeStatusOnRequestUpdate();
				}
				Constants.getTpmOrTmInformation().setSameAsRequester(false);
			};
			executeStorage("Same as Requester?",store,mode);
			Runnable store2 = ()->{
				Constants.getTpmOrTmInformation().setTpmOrTmName(null);
			};
			executeStorage("TPM/TM Name",store2,mode);
		}
	}
	public void isSameAsRequesterCheckboxDisabled() {
		String isDisabled = WebAction.getAttribute(sameAsRequesterCheckbox, "disabled");
		Assert.assertTrue(isDisabled != null, "`Same as Requester?` is not disabled in Extend or Bridge Crew & Facilities form");
	}

	public void isSameAsRequesterCheckboxEnabled() {
		String isDisabled = WebAction.getAttribute(sameAsRequesterCheckbox, "disabled");
		String isReadOnly = WebAction.getAttribute(sameAsRequesterCheckbox, "readonly");
		Assert.assertTrue(isDisabled==null && isReadOnly==null, "`Same as Requester?` is not enabled in Extend or Bridge Crew & Facilities form");
	}
	public void isTpmTmNameInputDisabled() {
		String isDisabled = WebAction.getAttribute(tpmTmNameInput, "disabled");
		Assert.assertTrue(isDisabled != null, "TPM/TM Name input is not disabled in Extend or Bridge Crew & Facilities form");
	}

	public void isTpmTmNameInputReadonly() {
		String readOnly = WebAction.getAttribute(tpmTmNameInput, "readonly");
		Assert.assertTrue(readOnly != null, "TPM/TM Name input is not read only in Extend or Bridge Crew & Facilities form");
	}
	public void isTpmTmNameInputEnabled() {
		String isDisabled = WebAction.getAttribute(tpmTmNameInput, "disabled");
		String readOnly = WebAction.getAttribute(tpmTmNameInput, "readonly");
		Assert.assertTrue(isDisabled == null && readOnly == null, "TPM/TM Name input is not enabled in Extend or Bridge Crew & Facilities form");
	}
	
	public void isControlRoomInputDisabled() {
		String isDisabled = WebAction.getAttribute(controlRoomInput, "disabled");
		Assert.assertTrue(isDisabled != null, "Control Room input is not disabled in Extend or Bridge Crew & Facilities form");
	}
	public void isControlRoomLocationInputDisabled() {
		String isDisabled = WebAction.getAttribute(controlRoomLocationInput, "disabled");
		Assert.assertTrue(isDisabled != null, "Control Room Location input is not disabled in Extend or Bridge Crew & Facilities form");
	}
	public void selectLocationOnExtendOrBridgeProduction(String location,RequestMode...mode) {
		if(location == null) {
			return;
		}
		// 0-based position
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(locationInputs.get(0), location);
		Assert.assertTrue(isSelected,String.format("'%s' is not selected in Location dropdown",location));
		Runnable store = ()->{
			List<LocationRecord> locations = Constants.getLocation();
			if(locations.size() == 0) {
				locations.add(new LocationRecord());
			}
			String oldLocation = locations.get(0).getLocation();
			locations.get(0).setLocation(location);
			if(location.equals("None")) {
				locations.get(0).setAddress(null);
				locations.get(0).setSetLocation(null);
			}
			if(isEditMode(mode) && !oldLocation.equalsIgnoreCase(location)) {
				String oldLocationInLog = oldLocation;
				String newLocationInLog = location;
				List<String> possibleLocations=Arrays.asList("DC","LA");
				if(possibleLocations.contains(oldLocation)) {
					oldLocationInLog = oldLocation.toLowerCase().concat("nc");
				}
				if(possibleLocations.contains(location)) {
					newLocationInLog = location.toLowerCase().concat("nc");
				}
				Constants.getLog().getLogs().putLog("Changed Set Location Section:", 
						String.format(" Location: %s → %s", oldLocationInLog,newLocationInLog));
				if(possibleLocations.contains(location)) {
					possibleLocations.forEach((loc)->{
						Constants.getLog().getLogs()
								.removeLogStartingWith(String.format("Changed %s Fulfillment", loc),null);
					});
					Constants.getLog().getLogs().putLog(String.format("Changed %s Fulfillment", location),null);
				}
				else if(location.equals("None")) {
					Constants.getLog().getLogs().putLog("Changed Staging Section", null);
				}
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
			}
		};
		executeStorage("Location",store,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public void selectSetLocationOnExtendOrBridgeProduction(String setLocation,RequestMode...mode) {
		if(setLocation == null) {
			return;
		}
		// 0-based position
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(setLocationInputs.get(0), setLocation);
		Assert.assertTrue(isSelected,String.format("'%s' is not selected in Set Location dropdown",setLocation));
		Runnable store = ()->{
			List<LocationRecord> locations = Constants.getLocation();
			if(locations.size() == 0) {
				locations.add(new LocationRecord());
			}
			String oldSetLocation = locations.get(0).getSetLocation();
			locations.get(0).setSetLocation(setLocation);
			locations.get(0).setAddress(null);
			if(isEditMode(mode)) {
				if(oldSetLocation == null) {
					Constants.getLog().getLogs().putLog("Changed Set Location Section:", 
							String.format(" Set Location: → %s", setLocation));
					producerDashboardGeneralPage.changeStatusOnRequestUpdate();
				}
				else if(!oldSetLocation.equalsIgnoreCase(setLocation)) {
					Constants.getLog().getLogs().putLog("Changed Set Location Section:", 
							String.format(" Set Location: %s → %s", oldSetLocation,setLocation));
					producerDashboardGeneralPage.changeStatusOnRequestUpdate();
				}
			}
		};
		executeStorage("Set Location",store,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public void selectAddressOnSetLocationAndCrew(String address,RequestMode...mode) {
		if(address == null) {
			return;
		}
		addressInputInSetLocationAndCrewSection.clear();
		addressInputInSetLocationAndCrewSection.sendKeys(address);
		Runnable store = ()->{
			List<LocationRecord> locations = Constants.getLocation();
			if(locations.size() == 0) {
				locations.add(new LocationRecord());
			}
			String oldAddress = locations.get(0).getAddress();
			locations.get(0).setSetLocation(null);
			locations.get(0).setAddress(address);
			if(isEditMode(mode)) {
				if(oldAddress == null) {
					Constants.getLog().getLogs().putLog("Changed Set Location Section:", 
							String.format(" Address: → %s", address));
					producerDashboardGeneralPage.changeStatusOnRequestUpdate();
				}
				else if(!oldAddress.equalsIgnoreCase(address)) {
					Constants.getLog().getLogs().putLog("Changed Set Location Section:", 
							String.format(" Address: %s → %s", oldAddress,address));
					producerDashboardGeneralPage.changeStatusOnRequestUpdate();
				}
			}
		};
		executeStorage("Set Location & Crew Address",store,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public void selectControlRoomAndCrew(String choice,RequestMode...mode) {
		if(choice == null) {
			return;
		}
		selectRadioOption(choice, controlRoomAndCrewRadioLabels);
		Runnable store = ()->{
			List<ControlRoomAndCrewRecord> controlRoomAndCrews = Constants.getControlRoomAndCrew();
			if(controlRoomAndCrews.size() == 0) {
				controlRoomAndCrews.add(new ControlRoomAndCrewRecord());
			}
			String oldChoice = controlRoomAndCrews.get(0).getControlRoomAndCrew(); 
			controlRoomAndCrews.get(0).setControlRoomAndCrew(choice);
			if(choice.equals("No")) {
				controlRoomAndCrews.get(0).setControlRoomLocation(null);
				controlRoomAndCrews.get(0).setControlRoom(null);
				if(isEditMode(mode) && oldChoice != null && !oldChoice.equalsIgnoreCase(choice)) {
					Constants.getLog().getLogs().putLog("Changed Control Room Section",null);
					producerDashboardGeneralPage.changeStatusOnRequestUpdate();
				}
			}
		};
		executeStorage("Control Room & Crew",store,mode);
	}
	public void selectControlRoomLocation(String location,RequestMode...mode) {
		if(location == null) {
			return;
		}
		// 0-based position
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(controlRoomLocationInput, location);
		Assert.assertTrue(isSelected,String.format("'%s' is not selected in Control Room Location dropdown",location));
		Runnable store = ()->{
			List<ControlRoomAndCrewRecord> controlRoomAndCrews = Constants.getControlRoomAndCrew();
			if(controlRoomAndCrews.size() == 0) {
				controlRoomAndCrews.add(new ControlRoomAndCrewRecord());
			}
			String oldLocation = controlRoomAndCrews.get(0).getControlRoomLocation();
			controlRoomAndCrews.get(0).setControlRoomLocation(location);
			if(isEditMode(mode)) {
				Constants.getLog().getLogs().removeLogStartingWith("Changed Control Room Section",null);
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
				List<String> possibleLocations=Arrays.asList("No Control Room");
				String newLocationInLog = location;
				if(possibleLocations.contains(location)) {
					newLocationInLog = "noCRoom";
				}
				if(oldLocation == null) {
					Constants.getLog().getLogs().putLog("Changed Control Room Section:", 
							String.format(" Control Room Location: → %s", newLocationInLog));
				}
				else if(!oldLocation.equalsIgnoreCase(location)) {
					String oldLocationInLog = oldLocation;
					if(possibleLocations.contains(oldLocation)) {
						oldLocationInLog = "noCRoom";
					}
					Constants.getLog().getLogs().putLog("Changed Control Room Section:", 
							String.format(" Control Room Location: %s → %s", oldLocationInLog,newLocationInLog));
				}
			}
		};
		executeStorage("Control Room Location",store,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public void selectControlRoom(String controlRoom,RequestMode...mode) {
		if(controlRoom == null) {
			return;
		}
		// 0-based position
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(controlRoomInput, controlRoom);
		try {
			Thread.sleep(10000);
		}
		catch(Exception e) {
			;
		};
		Assert.assertTrue(isSelected,String.format("'%s' is not selected in Set Location dropdown",controlRoom));
		Runnable store = ()->{
			List<ControlRoomAndCrewRecord> controlRoomAndCrews = Constants.getControlRoomAndCrew();
			if(controlRoomAndCrews.size() == 0) {
				controlRoomAndCrews.add(new ControlRoomAndCrewRecord());
			}
			String oldControlRoom = controlRoomAndCrews.get(0).getControlRoom();
			controlRoomAndCrews.get(0).setControlRoom(controlRoom);
			controlRoomAndCrews.get(0).setAddress(null);
			if(isEditMode(mode)) {
				Constants.getLog().getLogs().removeLogStartingWith("Changed Control Room Section",null);
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
				if(oldControlRoom == null) {
					Constants.getLog().getLogs().putLog("Changed Control Room Section:", 
							String.format(" Control Room: → %s", controlRoom));
				}
				else if(!oldControlRoom.equalsIgnoreCase(controlRoom)) {
					Constants.getLog().getLogs().putLog("Changed Control Room Section:", 
							String.format(" Control Room: %s → %s", oldControlRoom,controlRoom));
				}
			}
		};
		executeStorage("Control Room",store,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public void selectAddressOnControlRoomAndCrew(String address,RequestMode...mode) {
		if(address == null) {
			return;
		}
		addressInputInControlRoomAndCrewSection.clear();
		addressInputInControlRoomAndCrewSection.sendKeys(address);
		Runnable store = ()->{
			List<ControlRoomAndCrewRecord> controlRoomAndCrews = Constants.getControlRoomAndCrew();
			if(controlRoomAndCrews.size() == 0) {
				controlRoomAndCrews.add(new ControlRoomAndCrewRecord());
			}
			String oldAddress = controlRoomAndCrews.get(0).getAddress();
			controlRoomAndCrews.get(0).setControlRoom(null);
			controlRoomAndCrews.get(0).setAddress(address);
			if(isEditMode(mode)) {
				Constants.getLog().getLogs().removeLogStartingWith("Changed Control Room Section",null);
				if(oldAddress == null) {
					Constants.getLog().getLogs().putLog("Changed Set Location Section:", 
							String.format(" Address: → %s",address));
				}
				else if(!oldAddress.equalsIgnoreCase(address)) {
					Constants.getLog().getLogs().putLog("Changed Control Room Section:", 
							String.format(" Address: %s → %s", oldAddress,address));
				}
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
			}
		};
		executeStorage("Control Room & Crew Address",store,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public void selectIsATpmOrTmNeeded(String choice,RequestMode...mode) {
		selectRadioOption(choice, isATpmOrTmNeededRadioLabels);
		Runnable store = ()->{
			String old = Constants.getTpmOrTmInformation().getIsATpmOrTmNeeded();
			if(choice.equals("No")) {
				Constants.getTpmOrTmInformation().setSameAsRequester(false);
				Constants.getTpmOrTmInformation().setTpmOrTmName(null);
			}
			Constants.getTpmOrTmInformation().setIsATpmOrTmNeeded(choice);
			if(isEditMode(mode) && old != null && !old.equalsIgnoreCase(choice)) {
				Constants.getLog().getLogs().putLog("Changed TPM/TM Information Section",null);
				if(choice.equalsIgnoreCase("Yes")) {
					Constants.getLog().getLogs().putLog("Changed TM/TPM",null);
				}
				producerDashboardGeneralPage.changeStatusOnRequestUpdate();
			}
		};
		executeStorage("Is a TPM or TM Needed",store,mode);
	}
	public void tryClearing(WebElement clearIcon,WebElement input) {
		int trials = 3;
		while(--trials >= 0) {
			try {
				WebAction.mouseOverAndClick(clearIcon);
				Thread.sleep(2000);
				String value=WebAction.getAttribute(input, "value");
				if(value.equals("")) {
					break;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void clearStartDate(RequestMode...mode) throws Exception {
		tryClearing(clearIconForStartDate,startDateInput);
		String value = WebAction.getAttribute(startDateInput, "value");
		Assert.assertTrue(value.equals(""),"Start Date input is not cleared");
	}
	public void clearStartTime(RequestMode...mode) throws Exception {
		tryClearing(clearIconForStartTime,startTimeInput);
		String value = WebAction.getAttribute(startTimeInput, "value");
		Assert.assertTrue(value.equals(""),"Start Time input is not cleared");
	}
	public void clearEndTime(RequestMode...mode) throws Exception {
		tryClearing(clearIconForEndTime,endTimeInput);
		String value = WebAction.getAttribute(endTimeInput, "value");
		Assert.assertTrue(value.equals(""),"End Time input is not cleared");
	}
	public void checkStatusOnFulfillment(String statuses,RequestMode...mode) throws Exception {
		List<String> statusesList = Arrays.asList(statuses.split(",")).stream()
										  .map((status)->status.trim()).collect(Collectors.toList());
		for(String status : statusesList) {
			int size = uncheckedFulfillmentStatusElements.size();
			for(int i=0; i<size; ++i) {
				String displayedName = getText(uncheckedFulfillmentStatusElements.get(i)).trim();
				if(displayedName.equalsIgnoreCase(status)) {
					WebElement checkButton = checkButtonForUncheckedFulfillmentStatusElements.get(i);
					WebAction.scrollIntoViewTillBottom(checkButton);
					WebAction.click(checkButton);
					Waits.waitUntilElementSizeEquals(uncheckedFulfillmentStatusElements, size-1);
					Runnable store = ()->{
						if(status.equalsIgnoreCase("Acknowledged")) {
							Constants.getLog().getLogs().putLog("Acknowledged",null);
						}
						else if(status.equalsIgnoreCase("Technical")) {
							// this is an existing system bug
							Constants.getLog().getLogs().putLog("Completed Technical",null);
						}
						else if(status.equalsIgnoreCase("LA Fulfillment")) {
							Constants.getLog().getLogs().putLog("Completed LA Fulfillment",null);
						}
						else if(status.equalsIgnoreCase("DC Fulfillment")) {
							Constants.getLog().getLogs().putLog("Completed DC Fulfillment",null);
						}
						else if(status.equalsIgnoreCase("TPM/TM")) {
							// this is an existing system bug
							Constants.getLog().getLogs().putLog("Completed TM/TPM",null);
						}
					};
					RequestStatus statusDuringChange = RequestStatus.valueOf(Constants.getRequestStatus().name());
					Runnable store2 = ()->{
						Constants.setRequestStatus(RequestStatus.WORKING);
						if(size-1 == 0) {
							if(statusDuringChange != RequestStatus.FULFILLED) {
								Constants.getLog().getLogs().putLog("Fulfillment Email Sent",null);
							}
							Constants.setRequestStatus(RequestStatus.FULFILLED);
						}
					};
					Boolean isRunnablePresent = 
							producerDashboardGeneralPage.removeStorage(String.format("Changed %s", status));
					if(!isRunnablePresent) {
						executeStorage(String.format("Completed %s", status),store,mode);
					}
					executeStorage("Status Change",store2,mode);
					break;
				}
			}
		}
	}
	public void clearStatusOnFulfillment(String statuses,RequestMode...mode) throws Exception {
		List<String> statusesList = Arrays.asList(statuses.split(",")).stream()
										  .map((status)->status.trim()).collect(Collectors.toList());
		for(String status : statusesList) {
			int size = statusNamesHavingClearButton.size();
			for(int i=0; i<size; ++i) {
				String displayedName = getText(statusNamesHavingClearButton.get(i)).trim();
				if(displayedName.equalsIgnoreCase(status)) {
					WebElement checkButton = clearButtonForCheckedFulfillmentStatusElements.get(i);
					WebAction.scrollIntoViewTillBottom(checkButton);
					WebAction.click(checkButton);
					Waits.waitUntilElementSizeEquals(statusNamesHavingClearButton, size-1);
					Runnable store = ()->{
						if(status.equalsIgnoreCase("Technical")) {
							// this is an existing system bug
							Constants.getLog().getLogs().putLog("Changed Technical",null);
						}
						else if(status.equalsIgnoreCase("LA Fulfillment")) {
							Constants.getLog().getLogs().putLog("Changed LA Fulfillment",null);
						}
						else if(status.equalsIgnoreCase("DC Fulfillment")) {
							Constants.getLog().getLogs().putLog("Changed DC Fulfillment",null);
						}
						else if(status.equalsIgnoreCase("TPM/TM")) {
							// this is an existing system bug
							Constants.getLog().getLogs().putLog("Changed TM/TPM",null);
						}
					};
					Runnable store2 = ()->{
						// this is possibly a bug
						Constants.setRequestStatus(RequestStatus.WORKING);
					};
					Boolean isRunnablePresent = 
							producerDashboardGeneralPage.removeStorage(String.format("Completed %s", status));
					if(!isRunnablePresent) {
						executeStorage(String.format("Changed %s", status),store,mode);
					}
					executeStorage("Status Change",store2,mode);
					break;
				}
			}
		}
	}
}