
package nbcu.automation.ui.pages.ncxUnifiedTool;

import static nbcu.framework.factory.DriverFactory.getCurrentDriver;
import static nbcu.framework.utils.ui.WebAction.click;
import static nbcu.framework.utils.ui.WebAction.getText;
import static nbcu.framework.utils.ui.WebAction.scrollIntoView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PrimitiveIterator.OfInt;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
import nbcu.automation.ui.enums.UserRole;
import nbcu.automation.ui.pojos.ncxUnifiedTool.CrewRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.LocationRecord;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.factory.DriverFactory;
import nbcu.framework.utils.Other.DateFunctions;
import nbcu.framework.utils.propertyfilereader.ConfigFileReader;
import nbcu.framework.utils.report.ReportGenerate;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;
import nbcu.framework.utils.ui.WebAction;

public class ProdCNBCRequestFormPage {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	public ProducerDashboardGeneralPage getProducerDashboardGeneralPage() {
		return producerDashboardGeneralPage;
	}

	@FindBy(xpath = "(//*[contains(text(),'Sub Division')]//following::nz-select-search[1])[1]")
	WebElement subDivisionSection;

	@FindBy(xpath = "//textarea[@placeholder='Add Staging Needs']")
	WebElement StagingNeedsTextarea;

	@FindBy(xpath = "//*[@forminputname='controlRoomNeeded']//label[@label-value='true']")
	WebElement controlRoomNeeded_Yes;

	@FindBy(xpath = "//*[@forminputname='controlRoomNeeded']//label[@label-value='false']")
	WebElement controlRoomNeeded_No;

	@FindBy(xpath = "//*[@forminputname='ingest']//label[@label-value='true']")
	WebElement ingest_Yes;

	@FindBy(xpath = "//*[@forminputname='ingest']//label[@label-value='false']")
	WebElement ingest_No;

	@FindBy(xpath = "//*[@forminputname='iso']//label[@label-value='true']")
	WebElement iso_Yes;

	@FindBy(xpath = "//*[@forminputname='iso']//label[@label-value='false']")
	WebElement iso_No;

	@FindBy(xpath = "//*[contains(text(),' Is a Control Room Needed')]/ancestor::div[3]//div[contains(@class,'error')]")
	WebElement controlRoomNeededError;

	@FindBy(xpath = "//*[contains(text(),' Is a Control Room Needed? ')]")
	WebElement IsAControlRoomNeededLabel;

	@FindBy(xpath = "//*[contains(text(),' Is Budget Code Available? ')]/../following::*[1]//input")
	List<WebElement> isBudgetCodeAvailableRadios;

	@FindBy(xpath = "//*[contains(text(),' Is Budget Code Available? ')]/../following::*[1]//*[text()]")
	List<WebElement> isBudgetCodeAvailableRadioLabels;

	@FindBy(xpath = "//*[contains(text(),' Is a Control Room Needed? ')]/../following::*[1]//input")
	List<WebElement> isAControlRoomNeededRadios;

	@FindBy(xpath = "//*[contains(text(),' Is a Control Room Needed? ')]/../following::*[1]//*[text()]")
	List<WebElement> isAControlRoomNeededRadioLabels;

	@FindBy(xpath = "//*[contains(text(),' Ingest: Do you need content to be recorded? ')]/../following::*[1]//input")
	List<WebElement> ingestRadios;

	@FindBy(xpath = "//*[contains(text(),' Ingest: Do you need content to be recorded? ')]/../following::*[1]//*[text()]")
	List<WebElement> ingestRadioLabels;

	@FindBy(xpath = "//*[contains(text(),' ISO: Do you need ISO recordings? ')]/../following::*[1]//input")
	List<WebElement> isoRadios;

	@FindBy(xpath = "//*[contains(text(),' ISO: Do you need ISO recordings? ')]/../following::*[1]//*[text()]")
	List<WebElement> isoRadioLabels;

	@FindBy(xpath = "//*[contains(text(),' Ingest: Do you need content to be recorded? ')]/../following::*[1]//*[text()]")
	List<WebElement> ingestDoYouNeedContentToBeRecordedRadioLabels;

	@FindBy(xpath = "//*[contains(text(),' ISO: Do you need ISO recordings? ')]/../following::*[1]//input")
	List<WebElement> isoDoYouNeedIsoRecordingsRadios;

	@FindBy(xpath = "//*[contains(text(),' ISO: Do you need ISO recordings? ')]/../following::*[1]//*[text()]")
	List<WebElement> isoDoYouNeedIsoRecordingsRadioLabels;

	@FindBy(xpath = "//*[@sectionTitle]//*[contains(@class,'status-title-area')]//p[contains(@class,'left-hand-title')]")
	List<WebElement> formSectionTitles;

	@FindBy(xpath = "//*[@sectiontitle='Production Purpose']//nz-form-label//label")
	List<WebElement> productionPurposeSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Set Location']//nz-form-label//label")
	List<WebElement> setLocationSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Set Crew']//nz-form-label//label")
	List<WebElement> setCrewSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Staging']//nz-form-label//label")
	List<WebElement> stagingSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Control Room']//nz-form-label//label")
	List<WebElement> controlRoomSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Control Room CREW']//nz-form-label//label")
	List<WebElement> controlRoomCrewSectionFieldLabels;

	@FindBy(xpath = "//label[contains(text(),'Division')]/ancestor::nz-form-label/following::input[1]")
	WebElement divisionInput;

	@FindBy(xpath = "//label[contains(text(),'Show Unit or Project Name')]/ancestor::nz-form-label/following::input[1]")
	WebElement showUnitOrProjectNameInput;

	@FindBy(xpath = "//*[text()=' Request For ']/../following::*[1]//input")
	WebElement requestForInput;

	@FindBy(xpath = "//*[text()=' Location ']/../following::*[1]//input")
	List<WebElement> locationInputs;

	@FindBy(xpath = "//*[text()=' Set Crew ']/../following::*[1]//input")
	WebElement setCrewInput;

	@FindBy(xpath = "//*[text()=' Control Room Crew ']/../following::*[1]//input")
	WebElement controlRoomCrewInput;

	@FindBy(xpath = "//*[text()=' Details & Notes ']/../following::*[1]//textarea")
	WebElement detailsAndNotesInput;

	@FindBy(xpath = "//*[text()=' Staging Needs ']/../following::*[1]//textarea")
	WebElement stagingNeedsInput;

	@FindBy(xpath = "//*[contains(@class,'ant-select-item') and text()]")
	List<WebElement> dropdownOptions;

	@FindBy(xpath = "//*[text()=' Location ']/ancestor::button")
	WebElement addLocationButton;

	@FindBy(xpath = "//label[contains(text(),'Air Platform')]/ancestor::nz-form-label/following::input[1]")
	WebElement airPlatformInput;

	@FindBy(xpath = "//label[contains(text(),'Start Date')]/ancestor::nz-form-label/following::input[1]")
	WebElement startDateInput;

	@FindBy(xpath = "//label[contains(text(),'Start Time')]/ancestor::nz-form-label/following::input[1]")
	WebElement startTimeInput;

	@FindBy(xpath = "//label[contains(text(),'End Time')]/ancestor::nz-form-label/following::input[1]")
	WebElement endTimeInput;

	@FindBy(xpath = "//label[contains(text(),'Call Time')]/ancestor::nz-form-label/following::input[1]")
	WebElement callTimeInput;

	@FindBy(xpath = "//label[text()=' Budget Code ']/ancestor::nz-form-label/following::input[1]")
	WebElement budgetCodeInput;

	@FindBy(xpath = "//*[text()=' Division ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]")
	List<WebElement> mandatoryFieldErrorBelowDivision;

	@FindBy(xpath = "//*[text()=' Request For ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]")
	List<WebElement> mandatoryFieldErrorBelowRequestFor;

	@FindBy(xpath = "//*[text()=' Air Platform ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]")
	List<WebElement> mandatoryFieldErrorBelowAirPlatform;

	@FindBy(xpath = "//*[text()=' Show Unit or Project Name ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]")
	List<WebElement> mandatoryFieldErrorBelowShowUnit;

	@FindBy(xpath = "//*[text()=' Budget Code ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]")
	List<WebElement> mandatoryFieldErrorBelowBudgetCode;

	@FindBy(xpath = "//*[text()=' Start Date ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]")
	List<WebElement> mandatoryFieldErrorBelowStartDate;

	@FindBy(xpath = "//*[text()=' Start Time ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]")
	List<WebElement> mandatoryFieldErrorBelowStartTime;

	@FindBy(xpath = "//*[text()=' End Time ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]")
	List<WebElement> mandatoryFieldErrorBelowEndTime;

	@FindBy(xpath = "//*[text()=' Location ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]")
	List<WebElement> mandatoryFieldErrorBelowLocation;

	@FindBy(xpath = "//*[text()=' Is a Control Room Needed? ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]")
	List<WebElement> mandatoryFieldErrorBelowIsAControlRoomNeeded;

	@FindBy(xpath = "(//label[contains(text(),'Division')]/ancestor::nz-form-label/following::i[contains(@class,'ant-select-close-icon')])[1]")
	WebElement clearIconForDivision;

	@FindBy(xpath = "(//label[contains(text(),'Request For')]/ancestor::nz-form-label/following::i[contains(@class,'ant-select-close-icon')])[1]")
	WebElement clearIconForRequestFor;

	@FindBy(xpath = "(//label[contains(text(),'Air Platform')]/ancestor::nz-form-label/following::i[contains(@class,'ant-select-close-icon')])[1]")
	WebElement clearIconForAirPlatform;

	@FindBy(xpath = "(//label[contains(text(),'Sub Divison')]/ancestor::nz-form-label/following::i[contains(@class,'ant-select-close-icon')])[1]")
	WebElement clearIconForSubDivision;

	@FindBy(xpath = "(//label[contains(text(),'Start Date')]/ancestor::nz-form-label/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearIconForStartDate;

	@FindBy(xpath = "(//label[contains(text(),'Call Time')]/ancestor::nz-form-label/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearIconForCallTime;

	@FindBy(xpath = "(//label[contains(text(),'Start Time')]/ancestor::nz-form-label/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearIconForStartTime;

	@FindBy(xpath = "(//label[contains(text(),'End Time')]/ancestor::nz-form-label/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearIconForEndTime;

	@FindBy(xpath = "(//label[contains(text(),'Location')]/ancestor::nz-form-label/following::i[contains(@class,'ant-select-close-icon')])[1]")
	List<WebElement> clearIconsForLocation;

	@FindBy(xpath = "//label[contains(text(),'Location')]/ancestor::*[contains(@class,'body-section')]//*[text()=' Remove ']/ancestor::button")
	List<WebElement> removeButtonsForLocation;

	@FindBy(xpath = "(//label[contains(text(),'Set Crew')]/ancestor::nz-form-label/following::i[contains(@class,'ant-select-close-icon')])[1]")
	WebElement clearIconForSetCrew;

	@FindBy(xpath = "(//label[contains(text(),'Control Room Crew')]/ancestor::nz-form-label/following::i[contains(@class,'ant-select-close-icon')])[1]")
	WebElement clearIconForControlRoomCrew;

	@FindBy(xpath = "//label[contains(text(),' - Control Room ')]")
	List<WebElement> controlRoomRecordsLabel;

	@FindBy(xpath = "//label[contains(text(),' - Control Room ')]/../following::input[1]")
	List<WebElement> controlRoomRecordsInputs;

	@FindBy(xpath = "//*[contains(text(),' ISO: Do you need ISO recordings? ')]")
	List<WebElement> isoLabels;

	@FindBy(xpath = "//*[contains(text(),' Ingest: Do you need content to be recorded? ')]")
	List<WebElement> ingestLabels;

	@FindBy(xpath = "//label[contains(text(),' Control Room Crew ')]")
	List<WebElement> controlRoomCrewLabels;

	@FindBy(xpath = "//label[contains(text(),' Control Room Crew ')]/../following::input[1]")
	List<WebElement> controlRoomCrewInputs;

	@FindBy(xpath = "//label[contains(text(),'Sub Division')]/ancestor::nz-form-label/following::input[1]")
	WebElement subDivisionInput;

	@FindBy(xpath = "//*[text()=' Location ']/../following::*[1]//nz-select-placeholder")
	List<WebElement> locationInputPlaceholder;

	@FindBy(xpath = "//*[text()=' Division ']/../following::*[1]//nz-select-placeholder")
	List<WebElement> divisionInputPlaceholder;

	@FindBy(xpath = "//*[text()=' Request For ']/../following::*[1]//nz-select-placeholder")
	List<WebElement> requestForInputPlaceholder;

	@FindBy(xpath = "//*[text()=' Set Crew ']/../following::*[1]//nz-select-placeholder")
	List<WebElement> setCrewInputPlaceholder;

	@FindBy(xpath = "//*[text()=' Ingest ']/ancestor::*[@class='ant-row']//i")
	WebElement ingestIconInReadOnlyMode;

	@FindBy(xpath = "//*[text()=' ISO ']/ancestor::*[@class='ant-row']//i")
	WebElement isoIconInReadOnlyMode;

	@FindBy(xpath = "//*[text()=' Control Room Needed ']/ancestor::*[@class='ant-row']//i")
	WebElement controlRoomNeededIconInReadOnlyMode;

	@FindBy(xpath = "//*[@label='Control Room Crew']//*[contains(@class,'crew-member-pannels')]//*[contains(@class,'ant-collapse-header')]")
	List<WebElement> selectedControlRoomCrewsListInReadOnlyMode;

	@FindBy(xpath = "//*[@label='Control Room Crew']//*[contains(@class,'crew-member-pannels')]")
	List<WebElement> selectedControlRoomCrewsContainerListInReadOnlyMode;

	@FindBy(xpath = "//*[@label='Set Crew']//*[contains(@class,'crew-member-pannels')]//*[contains(@class,'ant-collapse-header')]")
	List<WebElement> selectedSetCrewsListInReadOnlyMode;

	@FindBy(xpath = "//*[@label='Set Crew']//*[contains(@class,'crew-member-pannels')]")
	List<WebElement> selectedSetCrewsContainerListInReadOnlyMode;

	@FindBy(xpath = "//*[contains(@class,'status-panel')]//*[@role='tab']")
	List<WebElement> fulfillmentStatusesForRequestor;

	@FindBy(xpath = "//*[@sectiontitle='Control Room CREW']//*[contains(@class,'ant-select-selection-item-content')]")
	List<WebElement> selectedControlRoomCrewNames;

	@FindBy(xpath = "//*[@sectiontitle='Control Room CREW']//*[contains(@class,'ant-select-selection-item-content')]/following::i[@nztype='close'][1]")
	List<WebElement> selectedControlRoomCrewRemovalIcons;

	@FindBy(xpath = "//*[@sectiontitle='Set Crew']//*[contains(@class,'ant-select-selection-item-content')]/following::i[@nztype='close'][1]")
	List<WebElement> selectedSetCrewRemovalIcons;

	@FindBy(xpath = "//*[@sectiontitle='Set Crew']//*[contains(@class,'ant-select-selection-item-content')]")
	List<WebElement> selectedSetCrewNames;

	@FindBy(xpath = "//*[text()='EDITING ']")
	List<WebElement> editingStatus;

	@FindBy(xpath = "//*[@sectionTitle]//*[contains(@class,'button-section')]//i")
	List<WebElement> sectionStatusIcons;

	@FindBy(xpath = "//*[@sectionTitle]//*[contains(@class,'button-section')]//i"
			+ "/ancestor::*[@class='button-section']/following::*[contains(@class,'status-title-area')]//p")
	List<WebElement> sectionNamesHavingStatusIcon;

	@FindBy(xpath = "//*[@sectiontitle='Talent']//*[contains(@class,'display-container')]//p")
	List<WebElement> talentNamesInCreateOrEditMode;

	@FindBy(xpath = "//*[@sectiontitle='Requester(s)']//*[contains(@class,'display-container')]//span")
	List<WebElement> requesterNamesInCreateOrEditMode;

	@FindBy(xpath = "//label[contains(text(),' Other ')]/ancestor::nz-form-label/following::input[1]")
	WebElement otherInput;

	@FindBy(xpath = "//*[@label='Set Crew']//*[contains(@class,'ant-select-selection-item-content')]")
	List<WebElement> setCrewNamesInCreateOrEditMode;

	@FindBy(xpath = "//*[contains(text(),' Is a Control Room Needed? ')]/../following::*[1]//*[contains(@class,'ant-radio-button-checked')]/following::*[text()][1]")
	List<WebElement> controlRoomNeededSelectedOptionValue;

	@FindBy(xpath = "//*[contains(text(),' Ingest: Do you need content to be recorded? ')]/../following::*[1]//*[contains(@class,'ant-radio-button-checked')]/following::*[text()][1]")
	List<WebElement> ingestSelectedOptionValue;

	@FindBy(xpath = "//*[contains(text(),' ISO: Do you need ISO recordings? ')]/../following::*[1]//*[contains(@class,'ant-radio-button-checked')]/following::*[text()][1]")
	List<WebElement> isoSelectedOptionValue;

	@FindBy(xpath = "//*[@label='Control Room Crew']//*[contains(@class,'ant-select-selection-item-content')]")
	List<WebElement> controlRoomCrewNamesInCreateOrEditMode;

	@FindBy(xpath = "//label[contains(text(),'Request For')]/ancestor::nz-form-label/following::*[1]//*[contains(@class,'ant-select-selection-item')][1]")
	List<WebElement> requestForValue;

	@FindBy(xpath = "//label[text()=' Division ']/ancestor::nz-form-label/following::*[1]//*[contains(@class,'ant-select-selection-item')][1]")
	List<WebElement> divisionValue;

	@FindBy(xpath = "//label[contains(text(),'Air Platform')]/ancestor::nz-form-label/following::*[1]//*[contains(@class,'ant-select-selection-item')][1]")
	List<WebElement> airPlatformValue;

	@FindBy(xpath = "//label[contains(text(),'Location')]/ancestor::nz-form-label/following::*[1]//*[contains(@class,'ant-select-selection-item')][1]")
	List<WebElement> locationValues;

	@FindBy(xpath = "//label[contains(text(),'Sub Division')]/ancestor::nz-form-label/following::*[1]//*[contains(@class,'ant-select-selection-item')][1]")
	List<WebElement> subDivisionValue;

	@FindBy(xpath = "//*[@sectiontitle='Set Location']//label[text()=' Location ']/../following::*[1]//nz-select-item")
	List<WebElement> selectedLocationInSetLocationSection;

	@FindBy(xpath = "//*[text()=' Is a Control Room Needed? ']/ancestor::*[@class='ant-row']//*[contains(@class,'ant-radio-button-checked')]/following::*[1]")
	WebElement selectedIsAControlRoomNeededOption;

	@FindBy(xpath = "//*[contains(@class,'crew-member-title')]//*[contains(@class,'title')]")
	List<WebElement> crewNamesInFulfillmentContainer;

	// %s in below locator will be replaced with the crew name in String.format
	String crewQuanitityInputLocator = "//*[contains(@class,'crew-member-title')]//*[text()=' %s ']"
			+ "/ancestor::*[contains(@class,'crew-member-container')]//*[contains(@class,'crew-member-title')]//input";
	// %s in below locator will be replaced with the crew name in String.format
	String crewMemberInputLocator = "(//*[contains(@class,'crew-member-title')]//*[text()=' %s ']"
			+ "/ancestor::*[contains(@class,'crew-member-container')]//form)[2]//input";
	// %s in below locator will be replaced with the crew name in String.format
	String crewMemberDeleteButtonLocator = "(//*[contains(@class,'crew-member-title')]//*[text()=' %s ']"
			+ "/ancestor::*[contains(@class,'crew-member-container')]//form)[2]//i[contains(@class,'anticon-delete')]/ancestor::button";
	// %s in below locator will be replaced with the crew name in String.format
	String crewDeleteButtonLocator = "//*[contains(@class,'crew-member-title')]//*[text()=' %s ']"
			+ "/ancestor::*[contains(@class,'crew-member-container')]//*[contains(@class,'crew-member-title')]"
			+ "//i[contains(@class,'anticon-delete')]/ancestor::button";

	@FindBy(xpath = "//status-edit-panel//*[contains(@class,'pending-area')]//*[text()]")
	List<WebElement> uncheckedFulfillmentStatusElements;

	@FindBy(xpath = "//status-edit-panel//*[contains(@class,'pending-area')]//*[contains(@class,'check-button')]")
	List<WebElement> checkButtonForUncheckedFulfillmentStatusElements;

	@FindBy(xpath = "//status-edit-panel//button[contains(@class,'clear-button')]")
	List<WebElement> clearButtonForCheckedFulfillmentStatusElements;

	@FindBy(xpath = "//button[contains(@class,'clear-button')]/ancestor::status-edit-panel//h1")
	List<WebElement> statusNamesHavingClearButton;

	@FindBy(xpath = "//*[@sectiontitle='Show Info']//nz-form-label//label")
	List<WebElement> showInfoSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='General Details']//nz-form-label//label")
	List<WebElement> generalDetailsSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Requester(s)']//nz-form-label//label")
	List<WebElement> requestersSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Talent']//nz-form-label//label")
	List<WebElement> talentSectionFieldLabels;

	@FindBy(xpath = "//*[text()=' Location ']/../following::*[1]//input")
	WebElement locationInput;

	WebDriver driver = DriverFactory.getCurrentDriver();

	public ProdCNBCRequestFormPage() {
		PageFactory.initElements(DriverFactory.getCurrentDriver(), this);
	}

	public void executeStorage(String fieldName, Runnable store, RequestMode... mode) {
		getProducerDashboardGeneralPage().executeStorage(fieldName, store, mode);
	}

	/**
	 * To verify set location section missing field error message
	 *
	 * @throws Exception
	 */
	public void verifySetLocationMissingFieldError(String locationErrorMessage) throws Exception {
		WebAction.scrollIntoView(producerDashboardGeneralPage.setLocationSection);
		try {
			CommonValidations.verifyTextValue(producerDashboardGeneralPage.locationError, locationErrorMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify control room section missing field error message
	 *
	 * @throws Exception
	 */
	public void verifyControlRoomNeededMissingFieldError(String controlRoomNeededErrorMessage) throws Exception {
		WebAction.scrollIntoView(producerDashboardGeneralPage.stagingSection);
		try {
			CommonValidations.verifyTextValue(controlRoomNeededError, controlRoomNeededErrorMessage);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addShowInfoInCNBCProduction(String airPlatformText, String subDivisionText, String showText,
			String startDateText, String callTimeText, String startTimeText, String endTimeText) throws Exception {
		try {
			WebAction.scrollIntoView(producerDashboardGeneralPage.productionPurposeSection);
			producerDashboardGeneralPage.selectAirPlatform(airPlatformText);
			selectSubDivision(subDivisionText);
			producerDashboardGeneralPage.enterShow(showText);
			producerDashboardGeneralPage.selectStartDate(startDateText);
			producerDashboardGeneralPage.selectPrepCallTime(callTimeText);
			producerDashboardGeneralPage.selectStartTime(startTimeText);
			producerDashboardGeneralPage.selectEndTime(endTimeText);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private void selectSubDivision(String subDivisionText) throws Exception {
		// To select sub division
		if (subDivisionText != null && WebAction.isDisplayed(subDivisionSection)) {
			boolean valuePresent = false;
			WebAction.clickUsingJs(subDivisionSection);
			Waits.waitUntilElementSizeGreater(By.xpath(producerDashboardGeneralPage.dropDownvaluesXpath), 0);
			for (WebElement ele : producerDashboardGeneralPage.dropDownvalues) {
				if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(subDivisionText)) {
					WebAction.click(ele);
					valuePresent = true;
					break;
				}
			}
			if (valuePresent == false)
				throw new Exception(
						"'" + subDivisionText + "' value is not present in the sub division type drop down");
		}
	}

	public void addSetLocationInfoInCNBCProduction(String locationText) throws Exception {
		try {
			WebAction.scrollIntoView(producerDashboardGeneralPage.setLocationSection);
			producerDashboardGeneralPage.selectLocation(locationText);
			Constants.setLocations(locationText);
//			ProducerDashboardGeneralPage.emailCCList.add(ConfigFileReader
//					.getProperty("cnbc-location-" + locationText.toLowerCase(), "emailconfig.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addStagingInfoInCNBCProduction(String StagingNeedsText) throws Exception {
		try {
			if (StagingNeedsText != null) {
				Waits.waitForElement(StagingNeedsTextarea, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(StagingNeedsTextarea);
				WebAction.sendKeys(StagingNeedsTextarea, StagingNeedsText);
				Constants.setStagingNeeds(StagingNeedsText);
			}
		} catch (

		Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addControlRoomInfoInCNBCProduction(String controlRoomNeededText, String ingestText, String isoText,
			String controlRoomCrewText) throws Exception {
		try {
			WebAction.scrollIntoView(producerDashboardGeneralPage.controlRoomSection);
			if (controlRoomNeededText != null) {
				if (controlRoomNeededText.equalsIgnoreCase("No"))
					WebAction.click(controlRoomNeeded_No);
				else {
					WebAction.click(controlRoomNeeded_Yes);
					if (ingestText.equalsIgnoreCase("yes")) {
						Constants.setIngestDoYouNeedContentToBeRecorded(ingestText);
						WebAction.click(ingest_Yes);
					} else {
						WebAction.click(ingest_No);
					}
					if (isoText.equalsIgnoreCase("yes")) {
						WebAction.click(iso_Yes);
					} else {
						WebAction.click(iso_No);
					}
					if (controlRoomCrewText != null) {
						producerDashboardGeneralPage.addControlRoomCrew(controlRoomCrewText);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyIfControlRoomCrewSectionAndRelatedFieldsShouldDisplayOrNot() throws Exception {
		producerDashboardGeneralPage.waitForLoadingSpinnerToDisappear();
		String yesOrNo = Constants.getIsAControlRoomNeeded();
		if (yesOrNo.equalsIgnoreCase("Yes")) {
			Assert.assertTrue(controlRoomRecordsLabel.size() == 1,
					"'x - Control Room' field is not displaying. It should.");
			Assert.assertTrue(controlRoomRecordsInputs.size() == 1,
					"'x - Control Room' input field is not displaying. It should.");
			Assert.assertTrue(ingestLabels.size() == 1,
					"'Ingest: Do you need content to be recorded?' field is not displaying. It should.");
			Assert.assertTrue(isoLabels.size() == 1,
					"'ISO: Do you need ISO recordings?' field is not displaying. It should.");
			Assert.assertTrue(controlRoomCrewLabels.size() == 1,
					"'Control Room Crew' field is not displaying. It should.");
			Assert.assertTrue(controlRoomCrewInputs.size() == 1,
					"'Control Room Crew Input' field is not displaying. It should.");
		} else if (yesOrNo.equalsIgnoreCase("No")) {
			Assert.assertTrue(controlRoomRecordsLabel.size() == 0,
					"'x - Control Room' field is displaying. It should not.");
			Assert.assertTrue(controlRoomRecordsInputs.size() == 0,
					"'x - Control Room' input field is displaying. It should not.");
			Assert.assertTrue(ingestLabels.size() == 0,
					"'Ingest: Do you need content to be recorded?' field is displaying. It should not.");
			Assert.assertTrue(isoLabels.size() == 0,
					"'ISO: Do you need ISO recordings?' field is displaying. It should not.");
			Assert.assertTrue(controlRoomCrewLabels.size() == 0,
					"'Control Room Crew' field is displaying. It should not.");
			Assert.assertTrue(controlRoomCrewInputs.size() == 0,
					"'Control Room Crew Input' field is displaying. It should not.");
		}
	}

	public void selectRadioOption(String option, List<WebElement> radios) {
		Consumer<WebElement> consumer = (op) -> {
			WebAction.scrollIntoViewTillBottom(op);
			if (WebAction.getText(op).equalsIgnoreCase(option)) {
				int trials = 3;
				while (--trials >= 0) {
					try {
						op.click();
						break;
					} catch (Exception e) {
						try {
							Thread.sleep(2000);
						} catch (Exception ee) {
							ee.printStackTrace();
						}
					}
				}
			}
		};
		radios.forEach(consumer);
	}

	public void shouldBudgetCodeInputBeEnabled() {
		Assert.assertTrue(budgetCodeInput != null, "Budget Code Input not displayed on CNBC Production form");
		String selectedOption = Constants.getIsBudgetCodeAvailable();
		if (selectedOption.equalsIgnoreCase("Available")) {
			Assert.assertTrue(WebAction.getAttribute(budgetCodeInput, "disabled") == null,
					"Budget Code input is not enabled");
		} else if (selectedOption.equalsIgnoreCase("Will Provide")) {
			Assert.assertTrue(WebAction.getAttribute(budgetCodeInput, "disabled") != null,
					"Budget Code input is not disabled");
		}
	}

	public void verifyTheFormSectionsInCnbcProductionForm() {
		Object[] expectedHeaders = { "STATUS", "GENERAL DETAILS", "REQUESTER(S)", "TALENT", "PRODUCTION PURPOSE",
				"SHOW INFO", "SET LOCATION", "SET CREW", "STAGING", "CONTROL ROOM" };
		String isControlRoomNeeded = Constants.getIsAControlRoomNeeded();
		if (isControlRoomNeeded != null && isControlRoomNeeded.equalsIgnoreCase("Yes")) {
			List<Object> list = Arrays.asList(expectedHeaders);
			list.add("CONTROL ROOM CREW");
			expectedHeaders = list.toArray();
		}
		Assert.assertEquals(formSectionTitles.size(), expectedHeaders.length,
				"Total number of sections are not the same as expected");
		for (int itr = 0; itr < expectedHeaders.length; itr++) {
			String expectedName = (String) expectedHeaders[itr];
			String displayedName = WebAction.getText(formSectionTitles.get(itr));
			if (!expectedName.equals(displayedName)) {
				Assert.assertEquals(displayedName, expectedName, "Expected section name is not same as displayed name");
			}
		}
	}

	public void checkFieldsInSectionOfCnbcProduction(String sectionName) {
		List<WebElement> sectionLabelElements = getSectionLabelElements(sectionName);
		if (sectionLabelElements == null) {
			Assert.assertTrue(sectionLabelElements == null,
					String.format("%s section is not present in CNBC production form", sectionName));
			return;
		}
		List<String> expectedFieldNamesList = getExpectedFieldsSectionWise(sectionName);
		List<String> expectedRequiredFieldList = getRequiredFieldsSectionWise(sectionName);
		if (sectionLabelElements.size() != expectedFieldNamesList.size()) {
			Assert.assertEquals(sectionLabelElements.size(), expectedFieldNamesList.size(),
					String.format(
							"Number of displayed fields and expected fields not equal in %s section of CNBC Production",
							sectionName));
			return;
		}
		for (int itr = 0; itr < expectedFieldNamesList.size(); itr++) {
			String expectedName = expectedFieldNamesList.get(itr);
			String displayedField = WebAction.getText(sectionLabelElements.get(itr));
			Assert.assertEquals(displayedField, expectedName, String.format(
					"Displayed field is not same as expected field in %s section of CNBC Production", sectionName));
			String cssClasses = WebAction.getAttribute(sectionLabelElements.get(itr), "class");
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
		} else if (sectionName.equalsIgnoreCase("PRODUCTION PURPOSE")) {
			return productionPurposeSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("SHOW INFO")) {
			return showInfoSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("SET LOCATION")) {
			return setLocationSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("SET CREW")) {
			return setCrewSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("STAGING")) {
			return stagingSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("CONTROL ROOM")) {
			return controlRoomSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("CONTROL ROOM CREW")) {
			return controlRoomCrewSectionFieldLabels;
		}
		return null;
	}

	public List<String> getExpectedFieldsSectionWise(String sectionName) {
		List<String> fieldNamesList = new ArrayList<String>();
		if (sectionName.equalsIgnoreCase("GENERAL DETAILS")) {
			fieldNamesList.addAll(Arrays.asList("Division"));
		} else if (sectionName.equalsIgnoreCase("REQUESTER(S)")) {
			fieldNamesList.addAll(Arrays.asList("Add Requester(s)"));
		} else if (sectionName.equalsIgnoreCase("TALENT")) {
			fieldNamesList.addAll(Arrays.asList("Talent"));
		} else if (sectionName.equalsIgnoreCase("PRODUCTION PURPOSE")) {
			fieldNamesList.addAll(Arrays.asList("Request For", "Details & Notes"));
		} else if (sectionName.equalsIgnoreCase("SHOW INFO")) {
			fieldNamesList.add("Air Platform");
			String division = Constants.getDivision();
			if (division != null && division.equals("CNBC")) {
				fieldNamesList.add("Sub Division");
			}
			fieldNamesList.add("Show Unit or Project Name");
			String showUnitOrProjectName = Constants.getShowUnitOrProjectName();
			if (showUnitOrProjectName != null && showUnitOrProjectName.equalsIgnoreCase("Other")) {
				fieldNamesList.add("Other");
			}
			fieldNamesList.addAll(Arrays.asList("Is Budget Code Available?", "Budget Code", "Start Date", "Call Time",
					"Start Time", "End Time"));
		} else if (sectionName.equalsIgnoreCase("SET LOCATION")) {
			fieldNamesList.addAll(Arrays.asList("Location", "Set Location"));
		} else if (sectionName.equalsIgnoreCase("SET CREW")) {
			fieldNamesList.addAll(Arrays.asList("Set Crew"));
		} else if (sectionName.equalsIgnoreCase("STAGING")) {
			fieldNamesList.addAll(Arrays.asList("Staging Needs"));
		} else if (sectionName.equalsIgnoreCase("CONTROL ROOM")) {
			List<String> fields = new ArrayList<String>();
			fields.add("Is a Control Room Needed?");
			String yesOrNo = Constants.getIsAControlRoomNeeded();
			if (yesOrNo != null && yesOrNo.equalsIgnoreCase("Yes")) {
				fields.add("1 - Control Room");
				List<String> controlRooms = Constants.getControlRoom();
				int size = controlRooms.size();
				for (int itr = 2; itr <= size; itr++) {
					fields.add(String.format("%d - Control Room", itr));
				}
			}
			fieldNamesList.addAll(fields);
		} else if (sectionName.equalsIgnoreCase("CONTROL ROOM CREW")) {
			fieldNamesList.addAll(Arrays.asList("Ingest: Do you need content to be recorded?",
					"ISO: Do you need ISO recordings?", "Control Room Crew"));
		}
		return fieldNamesList;
	}

	public List<String> getRequiredFieldsSectionWise(String sectionName) {
		List<String> fieldNamesList = new ArrayList<String>();
		if (sectionName.equalsIgnoreCase("GENERAL DETAILS")) {
			fieldNamesList.addAll((Arrays.asList("Division")));
		} else if (sectionName.equalsIgnoreCase("REQUESTER(S)") || sectionName.equalsIgnoreCase("TALENT")) {
			fieldNamesList.addAll((Arrays.asList()));
		} else if (sectionName.equalsIgnoreCase("PRODUCTION PURPOSE")) {
			fieldNamesList.addAll((Arrays.asList("Request For")));
		} else if (sectionName.equalsIgnoreCase("SHOW INFO")) {
			fieldNamesList.addAll((Arrays.asList("Air Platform", "Sub Division", "Show Unit or Project Name", "Other",
					"Is Budget Code Available?", "Budget Code", "Start Date", "Start Time", "End Time")));
		} else if (sectionName.equalsIgnoreCase("SET LOCATION")) {
			fieldNamesList.addAll(Arrays.asList("Location"));
		} else if (sectionName.equalsIgnoreCase("SET CREW") || sectionName.equalsIgnoreCase("STAGING")) {
			fieldNamesList.addAll(Arrays.asList());
		} else if (sectionName.equalsIgnoreCase("CONTROL ROOM")) {
			fieldNamesList.addAll(Arrays.asList("Is a Control Room Needed?"));
		} else if (sectionName.equalsIgnoreCase("CONTROL ROOM CREW")) {
			fieldNamesList.addAll(Arrays.asList());
		}
		return fieldNamesList;
	}

	public void checkLocationInputPlaceholder() {
		if (Constants.getLocation().size() > 0) {
			Optional<LocationRecord> opt = Constants.getLocation().stream()
					.filter((location) -> location.getLocation() == null || location.getLocation().equals(""))
					.findAny();
			if (opt.isPresent()) {
				Assert.assertEquals(getText(locationInputPlaceholder.get(0)), "Select Location",
						"Placeholder of location input is not correct");
			} else {
				Assert.assertTrue(locationInputPlaceholder.size() == 0,
						"Placeholder of location input is visible when value is already filled");
			}
		} else {
			Assert.assertEquals(getText(locationInputPlaceholder.get(0)), "Select Location",
					"Placeholder of location input is not correct");
		}
	}

	public void checkDivisionInputPlaceholder() {
		String division = Constants.getDivision();
		if (division == null || division.equals("")) {
			Assert.assertEquals(getText(divisionInputPlaceholder.get(0)), "Select Division",
					"Placeholder of Division input is not correct");
		} else {
			Assert.assertTrue(divisionInputPlaceholder.size() == 0,
					"Placeholder of Division input is visible even though value is selected");
		}
	}

	public void checkRequestForInputPlaceholder() {
		String requestFor = Constants.getRequestFor();
		if (requestFor == null || requestFor.equals("")) {
			Assert.assertEquals(getText(requestForInputPlaceholder.get(0)), "Select Request For",
					"Placeholder of Request For input is not correct");
		} else {
			Assert.assertTrue(requestForInputPlaceholder.size() == 0,
					"Placeholder of Request For input is visible even though value is selected");
		}
	}

	public void checkSetCrewInputPlaceholder() {
		if (Constants.getSetCrew().size() == 0) {
			Assert.assertEquals(getText(setCrewInputPlaceholder.get(0)), "Select Set Crew",
					"Placeholder of Set Crew input is not correct");
		} else {
			Assert.assertTrue(setCrewInputPlaceholder.size() == 0,
					"Placeholder of Set Crew input is visible even though value is selected");
		}
	}

	public boolean selectValueInDropdown(WebElement input, String option) {
		Boolean selected = false;
		try {
			input.sendKeys(option);
			Waits.waitForAllElements(dropdownOptions, WAIT_CONDITIONS.VISIBLE);
			Predicate<WebElement> isMatchingElementPredicate = (ele) -> getText(ele).equals(option);
			Optional<WebElement> optional = dropdownOptions.stream().filter(isMatchingElementPredicate).findAny();
			if (optional.isPresent()) {
				WebElement optionToSelect = optional.get();
				scrollIntoView(optionToSelect);
				click(optionToSelect);
				selected = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selected;
	}

	public void selectSetCrewOnCNBCProduction(String crewNames, RequestMode... mode) {
		Consumer<String> selectCrewCons = (op) -> {
			final String op2 = new String(op.trim());
			Assert.assertTrue(selectValueInDropdown(setCrewInput, op2),
					String.format("%s not selected in Set Crew", op2));
			Runnable store = () -> {
				Constants.getSetCrew().add(new CrewRecord(op2, 1));
				if (isEditMode(mode)) {
					Constants.getLog().getLogs().putLog("Changed Set Location Crew Section:",
							String.format(" %s: added , Count: 0 → 1", op2));
					changeRequestStatusToModified();
				}
			};
			executeStorage(op, store, mode);
		};
		Arrays.asList(crewNames.split(",")).forEach(selectCrewCons);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectControlRoomCrewOnCNBCProduction(String crewNames, RequestMode... mode) {
		if (crewNames == null) {
			return;
		}
		Consumer<String> selectCrewCons = (op) -> {
			final String op2 = new String(op.trim());
			Assert.assertTrue(selectValueInDropdown(controlRoomCrewInput, op2),
					String.format("%s not selected in Control Room Crew", op2));
			Runnable store = () -> {
				Constants.getControlRoomCrew().add(new CrewRecord(op2, 1));
				if (isEditMode(mode)) {
					Constants.getLog().getLogs().removeLogStartingWith("Changed Control Room Crew Section", null);
					Constants.getLog().getLogs().putLog("Changed Control Room Crew Section:",
							String.format(" %s: added , Count: 0 → 1", op2));
					changeRequestStatusToModified();
					if (op2.equals("TPS")) {
						Constants.getLog().getLogs().putLog("Changed TPS", null);
					} else if (op2.equals("Director")) {
						// this log is a bug in application currently, remove this line once the this
						// log is removed from application
						Constants.getLog().getLogs().putLog("Changed Production Playout", null);
					}
				}
			};
			executeStorage(op, store, mode);
		};
		Arrays.asList(crewNames.split(",")).forEach(selectCrewCons);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectRequestForOnCNBCProduction(String requestFor, RequestMode... mode) {
		if (requestFor == null) {
			return;
		}
		Boolean isSelected = selectValueInDropdown(requestForInput, requestFor);
		Assert.assertTrue(isSelected, String.format("'%s' is not selected in Request For dropdown", requestFor));
		Runnable store = () -> {
			String old = Constants.getRequestFor();
			if (isEditMode(mode) && old != null && !old.equals(requestFor)) {
				Constants.getLog().getLogs().putLog("Changed Production Purpose Section", null);
				changeRequestStatusToModified();
			}
			Constants.setRequestFor(requestFor);
		};
		executeStorage("Request For", store, mode);
	}

	public void provideDetailsAndNotesOnCNBCProduction(String notes, RequestMode... mode) {
		if (notes == null) {
			return;
		}
		detailsAndNotesInput.clear();
		detailsAndNotesInput.sendKeys(notes);
		Runnable store = () -> {
			String old = Constants.getDetailsAndNotes();
			if (old != null && !old.equals(notes)) {
				Constants.getLog().getLogs().putLog("Changed Production Purpose Section", null);
				changeRequestStatusToModified();
			}
			Constants.setDetailsAndNotes(notes);
		};
		executeStorage("Details & Notes", store, mode);
	}

	public Boolean isEditMode(RequestMode... mode) {
		return producerDashboardGeneralPage.isEditMode(mode);
	}

	public void provideStagingNeedsOnCNBCProduction(String stagingNeeds, RequestMode... mode) {
		WebAction.clearInputOneCharAtTime(stagingNeedsInput);
		stagingNeedsInput.sendKeys(stagingNeeds);
		Runnable store = () -> {
			String old = Constants.getStagingNeeds();
			if (isEditMode(mode) && (old == null || !old.equals(stagingNeeds))) {
				Constants.getLog().getLogs().putLog("Changed Staging Section", null);
				changeRequestStatusToModified();
			}
			Constants.setStagingNeeds(stagingNeeds);
		};
		executeStorage("Staging Needs", store, mode);
	}

	public void selectIngest(String choice, RequestMode... mode) {
		if (choice == null) {
			return;
		}
		selectRadioOption(choice, ingestRadioLabels);
		Runnable store = () -> {
			if (isEditMode(mode)) {
				String old = Constants.getIngestDoYouNeedContentToBeRecorded();
				if (!Constants.getLog().getLogs().containsSectionLog("Changed Control Room Crew Section:")) {
					Constants.getLog().getLogs().putLog("Changed Control Room Crew Section", null);
				}
				changeRequestStatusToModified();
				// below log is a current system bug. Remove once bug is fixed
				if (choice.equals("Yes") && (old == null || !old.equals(choice))) {
					Constants.getLog().getLogs().putLog("Completed Ingest", null);
				}
			}
			Constants.setIngestDoYouNeedContentToBeRecorded(choice);
		};
		executeStorage("Ingest", store, mode);
	}

	public void selectISO(String choice, RequestMode... mode) {
		if (choice == null) {
			return;
		}
		selectRadioOption(choice, isoRadioLabels);
		Runnable store = () -> {
			if (isEditMode(mode)) {
				if (!Constants.getLog().getLogs().containsSectionLog("Changed Control Room Crew Section:")) {
					Constants.getLog().getLogs().putLog("Changed Control Room Crew Section", null);
				}
				changeRequestStatusToModified();
			}
			Constants.setIsoDoYouNeedIsoRecordings(choice);
		};
		executeStorage("ISO", store, mode);
	}

	public void selectIsControlRoomNeeded(String choice, RequestMode... mode) {
		String currentSelectedChoice = null;
		if (isEditMode(mode)) {
			currentSelectedChoice = getText(selectedIsAControlRoomNeededOption).trim();
		}
		List<String> visibleCrews = new ArrayList<>();
		selectedControlRoomCrewNames.forEach((ele) -> visibleCrews.add(getText(ele)));
		selectRadioOption(choice, isAControlRoomNeededRadioLabels);
		executeRunnableForIsControlRoomNeeded(currentSelectedChoice, choice, visibleCrews, mode);
	}

	public void executeRunnableForIsControlRoomNeeded(String currentSelectedChoice, String choice,
			List<String> visibleCrews, RequestMode... mode) {
		if (currentSelectedChoice != null && !currentSelectedChoice.equals(choice) && isEditMode(mode)) {
			Runnable storeIngest = () -> {
				String ingest = Constants.getIngestDoYouNeedContentToBeRecorded();
				// putting below log is there was Ingest selected
				if (ingest != null) {
					Constants.getLog().getLogs().putLog("Changed Control Room Crew Section", null);
					changeRequestStatusToModified();
				}
				Constants.setIngestDoYouNeedContentToBeRecorded(null);
			};
			executeStorage("Ingest", storeIngest, mode);
			Runnable storeIso = () -> {
				String iso = Constants.getIsoDoYouNeedIsoRecordings();
				// putting below log is there was ISO selected
				if (iso != null) {
					Constants.getLog().getLogs().putLog("Changed Control Room Crew Section", null);
					changeRequestStatusToModified();
				}
				Constants.setIsoDoYouNeedIsoRecordings(null);
			};
			executeStorage("ISO", storeIso, mode);
			// remove runnables for crews getting displayed on UI
			visibleCrews.forEach((name) -> producerDashboardGeneralPage.removeStorage(name));
			// logs for earlier saved crews
			Iterator<CrewRecord> crewIterator = Constants.getControlRoomCrew().iterator();
			while (crewIterator.hasNext()) {
				CrewRecord crew = crewIterator.next();
				String crewName = crew.getCrewName();
				Runnable store = () -> {
					if (isEditMode(mode)) {
						Constants.getLog().getLogs().removeLogStartingWith("Changed Control Room Crew Section", null);
						Constants.getLog().getLogs().putLog("Changed Control Room Crew Section:",
								String.format(" %s: removed , Count: %d → 0", crew.getCrewName(), crew.getNumber()));
						changeRequestStatusToModified();
					}
					Constants.getControlRoomCrew().remove(crew);
				};
				executeStorage(crewName, store, mode);
			}
		}
		Runnable store = () -> {
			String oldSavedChoice = Constants.getIsAControlRoomNeeded();
			Constants.setIsAControlRoomNeeded(choice);
			if (oldSavedChoice != null && !oldSavedChoice.equals(choice) && isEditMode(mode)) {
				Boolean option1 = oldSavedChoice.equalsIgnoreCase("Yes") ? true : false;
				Constants.getLog().getLogs().putLog("Changed Control Room Section:",
						String.format(" Is a Control Room Needed?: %b → %b", option1, !option1));
				changeRequestStatusToModified();
			}
		};
		executeStorage("Is Control Room Needed", store, mode);
	}

	public void changeRequestStatusToModified() {
		if (Constants.getUserRole() == UserRole.PRODUCER) {
			Constants.setRequestStatus(RequestStatus.MODIFIED);
		}
	}

	public void selectDivisionOnCNBCProduction(String division, RequestMode... mode) {
		if (division == null) {
			return;
		}
		Boolean isSelected = selectValueInDropdown(divisionInput, division);
		Assert.assertTrue(isSelected, String.format("'%s' is not selected in Division dropdown", division));
		Runnable store = () -> {
			String oldVal = Constants.getDivision();
			Constants.setDivision(division);
			if (oldVal != null && !oldVal.equalsIgnoreCase(division)) {
				Constants.getLog().getLogs().putLog("Changed General Details Section:",
						String.format(" Division: %s → %s", oldVal, division));
				changeRequestStatusToModified();
			}
		};
		executeStorage("Division", store, mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectAirPlatformOnCNBCProduction(String airPlatform, RequestMode... mode) {
		if (airPlatform == null) {
			return;
		}
		Boolean isSelected = selectValueInDropdown(airPlatformInput, airPlatform);
		Assert.assertTrue(isSelected,
				String.format("'%s' is not selected in Show Unit or Project Name dropdown", airPlatform));
		Runnable store = () -> {
			String oldVal = Constants.getAirPlatform();
			Constants.setAirPlatform(airPlatform);
			if (isEditMode(mode) && oldVal != null && !oldVal.equalsIgnoreCase(airPlatform)) {
				Constants.getLog().getLogs().putLog("Changed Show Info Section:",
						String.format(" Air Platform: %s → %s", oldVal, airPlatform));
				changeRequestStatusToModified();
			}
		};
		executeStorage("Air Platform", store, mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectSubDivisionOnCNBCProduction(String subDivision, RequestMode... mode) {
		if (subDivision == null) {
			return;
		}
		Boolean isSelected = selectValueInDropdown(subDivisionInput, subDivision);
		Assert.assertTrue(isSelected, String.format("'%s' is not selected in Sub Division dropdown", subDivision));
		Runnable store = () -> {
			Constants.setSubDivision(subDivision);
			// no log for sub division setting currently
		};
		executeStorage("Sub Division", store, mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectShowUnitOnCNBCProduction(String showUnit, RequestMode... mode) {
		if (showUnit == null) {
			return;
		}
		showUnitOrProjectNameInput.clear();
		Boolean isSelected = selectValueInDropdown(showUnitOrProjectNameInput, showUnit);
		Assert.assertTrue(isSelected, String.format("'%s' is not selected in Show Unit dropdown", showUnit));
		String newBudgetCode = WebAction.getAttribute(budgetCodeInput, "value");
		Runnable store = () -> {
			String oldShowUnit = Constants.getShowUnitOrProjectName();
			String oldBudgetCode = Constants.getBudgetCode();
			Constants.setShowUnitOrProjectName(showUnit);
			Constants.setBudgetCode(newBudgetCode);
			if (isEditMode(mode) && oldShowUnit != null && !oldShowUnit.equalsIgnoreCase(showUnit)) {
				Constants.getLog().getLogs().putLog("Changed Show Info Section:",
						String.format(" Show or Project Name: %s → %s", oldShowUnit, showUnit));
				Constants.getLog().getLogs().putLog("Changed Show Info Section:",
						String.format(" Budget Code: %s → %s", oldBudgetCode, newBudgetCode));
				changeRequestStatusToModified();
			}
		};
		executeStorage("Show Unit or Project Name", store, mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectLocationOnCNBCProduction(String location, String position, RequestMode... mode) {
		// 0-based position
		Integer locationNumber = Integer.parseInt(position);
		Boolean isSelected = selectValueInDropdown(locationInputs.get(locationNumber), location);
		Assert.assertTrue(isSelected, String.format("'%s' is not selected in Location dropdown", location));
		Runnable store = () -> {
			List<LocationRecord> locations = Constants.getLocation();
			while (locations.size() <= locationNumber) {
				locations.add(new LocationRecord());
			}
			String oldLocation = locations.get(locationNumber).getLocation();
			locations.get(locationNumber).setLocation(location);
			if (isEditMode(mode)) {
				if (oldLocation == null) {
					Constants.getLog().getLogs().putLog("Changed Set Location Section:",
							String.format(" Location: %s", location));
					changeRequestStatusToModified();
				} else if (!oldLocation.equalsIgnoreCase(location)) {
					Constants.getLog().getLogs().putLog("Changed Set Location Section:",
							String.format(" Location: %s → %s", oldLocation, location));
					changeRequestStatusToModified();
				}
			}
		};
		executeStorage(String.format("Location %d", locationNumber), store, mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void addLocation() {
		try {
			WebAction.scrollIntoViewTillBottom(addLocationButton);
			addLocationButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectIsBudgetCodeAvailable(String choice, RequestMode... mode) {
		selectRadioOption(choice, isBudgetCodeAvailableRadioLabels);
		Runnable store = () -> {
			String oldBudgetCode = Constants.getBudgetCode();
			String oldIsBudgetCodeAvailable = Constants.getIsBudgetCodeAvailable();
			Constants.setIsBudgetCodeAvailable(choice);
			Constants.setBudgetCode(WebAction.getAttribute(budgetCodeInput, "value"));
			if (oldIsBudgetCodeAvailable != null && !oldIsBudgetCodeAvailable.equalsIgnoreCase(choice)) {
				Constants.getLog().getLogs().putLog("Changed Show Info Section:",
						String.format(" Budget Code: %s → %s", oldBudgetCode, Constants.getBudgetCode()));
				changeRequestStatusToModified();
			}
		};
		executeStorage("Is Budget Code Available", store, mode);
	}

	public void selectStartDateOnCNBCProduction(String daysOffsetFromCurrent, RequestMode... mode) {
		if (daysOffsetFromCurrent == null) {
			return;
		}
		try {
			String date = DateFunctions.getDateUsingOffsetFromToday("MM/dd/yyyy",
					Integer.parseInt(daysOffsetFromCurrent));
			startDateInput.sendKeys(date, Keys.ENTER);
			Runnable store = () -> {
				String old = Constants.getStartDate();
				if (old != null && !old.equals(date)) {
					Constants.getLog().getLogs().putLog("Changed Date/Time under Show Info Section:",
							String.format(" Start Date: %s → %s", old, date));
					changeRequestStatusToModified();
				}
				Constants.setStartDate(date);
			};
			executeStorage("Start Date", store, mode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectCallTimeOnCNBCProduction(String time, RequestMode... mode) {
		if (time == null) {
			return;
		}
		callTimeInput.sendKeys(time, Keys.ENTER);
		Runnable store = () -> {
			if (isEditMode(mode)) {
				String oldTime = Constants.getCallTime();
				if (oldTime == null) {
					Constants.getLog().getLogs().putLog("Changed Date/Time under Show Info Section:",
							String.format(" Call Time: %s (EST) , added", time));
				} else if (oldTime != null && !oldTime.equalsIgnoreCase(time)) {
					// uncomment below comment lines when the time in log shows in EDT, currently it
					// is displayed same as we put
					// Constants.getLog().getLogs().putLog("Changed Date/Time under Show Info
					// Section:",
					// String.format(" Call Time: %s (EST) → %s
					// (EST)",DateFunctions.getTimeInEDT(oldTime),DateFunctions.getTimeInEDT(time)));
					Constants.getLog().getLogs().putLog("Changed Date/Time under Show Info Section:",
							String.format(" Call Time: %s (EST) → %s (EST)", oldTime, time));
				}
				changeRequestStatusToModified();
			}
			Constants.setCallTime(time);
		};
		executeStorage("Call Time", store, mode);
	}

	public void selectStartTimeOnCNBCProduction(String time, RequestMode... mode) {
		if (time == null) {
			return;
		}
		startTimeInput.sendKeys(time, Keys.ENTER);
		Runnable store = () -> {
			String oldTime = Constants.getStartTime();
			if (oldTime != null && !oldTime.equalsIgnoreCase(time)) {
				// uncomment below comment lines when the time in log shows in EDT, currently it
				// is displayed same as we put
				// Constants.getLog().getLogs().putLog("Changed Date/Time under Show Info
				// Section:",
				// String.format(" Start Time: %s (EST) → %s
				// (EST)",DateFunctions.getTimeInEDT(oldTime),DateFunctions.getTimeInEDT(time)));
				Constants.getLog().getLogs().putLog("Changed Date/Time under Show Info Section:",
						String.format(" Start Time: %s (EST) → %s (EST)", oldTime, time));
				changeRequestStatusToModified();
			}
			Constants.setStartTime(time);
		};
		executeStorage("Start Time", store, mode);
	}

	public void selectEndTimeOnCNBCProduction(String time, RequestMode... mode) {
		if (time == null) {
			return;
		}
		endTimeInput.sendKeys(time, Keys.ENTER);
		Runnable store = () -> {
			String oldTime = Constants.getEndTime();
			if (oldTime != null && !oldTime.equalsIgnoreCase(time)) {
				// uncomment below comment lines when the time in log shows in EDT, currently it
				// is displayed same as we put
				// Constants.getLog().getLogs().putLog("Changed Date/Time under Show Info
				// Section:",
				// String.format(" End Time: %s (EST) → %s
				// (EST)",DateFunctions.getTimeInEDT(oldTime),DateFunctions.getTimeInEDT(time)));
				Constants.getLog().getLogs().putLog("Changed Date/Time under Show Info Section:",
						String.format(" End Time: %s (EST) → %s (EST)", oldTime, time));
				changeRequestStatusToModified();
			}
			Constants.setEndTime(time);
		};
		executeStorage("End Time", store, mode);
	}

	public void checkMandatoryFieldError(List<WebElement> ele, String fieldName, String errorText, String fieldData) {
		if (fieldData == null) {
			Assert.assertTrue(ele.size() == 1,
					String.format("Mandatory field error below %s is not displayed", fieldName));
			Assert.assertEquals(getText(ele.get(0)), errorText,
					String.format("Mandatory field error below %s not correct", fieldName));
		} else {
			Assert.assertTrue(ele.size() == 0, String.format("Mandatory field error displayed below %s", fieldName));
		}
	}

	public void checkMandatoryFieldErrorBelowDivision() {
		checkMandatoryFieldError(mandatoryFieldErrorBelowDivision, "Division", "Select a value",
				WebAction.getAttribute(divisionInput, "value"));
	}

	public void checkMandatoryFieldErrorBelowAirPlatform() {
		checkMandatoryFieldError(mandatoryFieldErrorBelowAirPlatform, "Air Platform", "Select a value",
				WebAction.getAttribute(airPlatformInput, "value"));
	}

	public void checkMandatoryFieldErrorBelowRequestFor() {
		checkMandatoryFieldError(mandatoryFieldErrorBelowRequestFor, "Request For", "Select a value",
				WebAction.getAttribute(requestForInput, "value"));
	}

	public void checkMandatoryFieldErrorBelowShowUnit() {
		checkMandatoryFieldError(mandatoryFieldErrorBelowShowUnit, "Show Unit or Project Name",
				"Please select/enter a show or project name",
				WebAction.getAttribute(showUnitOrProjectNameInput, "value"));
	}

	public void checkMandatoryFieldErrorBelowBudgetCode() {
		checkMandatoryFieldError(mandatoryFieldErrorBelowBudgetCode, "Budget Code", "Enter a value",
				WebAction.getAttribute(budgetCodeInput, "value"));
	}

	public void checkMandatoryFieldErrorBelowStartDate() {
		checkMandatoryFieldError(mandatoryFieldErrorBelowStartDate, "Start Date", "Select a date",
				WebAction.getAttribute(startDateInput, "value"));
	}

	public void checkMandatoryFieldErrorBelowStartTime() {
		checkMandatoryFieldError(mandatoryFieldErrorBelowStartTime, "Start Time", "Enter a value",
				WebAction.getAttribute(startTimeInput, "value"));
	}

	public void checkMandatoryFieldErrorBelowEndTime() {
		checkMandatoryFieldError(mandatoryFieldErrorBelowEndTime, "End Time", "Enter a value",
				WebAction.getAttribute(endTimeInput, "value"));
	}

	public void checkMandatoryFieldErrorBelowIsAControlRoomNeeded() {
		checkMandatoryFieldError(mandatoryFieldErrorBelowIsAControlRoomNeeded, "Is a Control Room Needed?",
				"Select a value", Constants.getIsAControlRoomNeeded());
	}

	public void checkMandatoryFieldErrorBelowLocation() {
		int counter = -1;
		Iterator<WebElement> locationInputIterator = locationInputs.iterator();
		while (locationInputIterator.hasNext()) {
			String val = WebAction.getAttribute(locationInputIterator.next(), "value");
			if (val == null || val.equals("")) {
				++counter;
			}
			List<WebElement> errorElements;
			if (counter >= mandatoryFieldErrorBelowLocation.size()) {
				errorElements = Arrays.asList();
			} else {
				errorElements = Arrays.asList(mandatoryFieldErrorBelowLocation.get(counter));
			}
			checkMandatoryFieldError(errorElements, "Location", "Select a value", val);
		}
	}

	public void tryClearing(WebElement clearIcon, List<WebElement> valueElement) {
		int trials = 3;
		while (--trials >= 0) {
			try {
				WebAction.mouseOverAndClick(clearIcon);
				Thread.sleep(2000);
				if (valueElement.size() == 0) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void tryClearing(WebElement clearIcon, WebElement input) {
		int trials = 3;
		while (--trials >= 0) {
			try {
				WebAction.mouseOverAndClick(clearIcon);
				Thread.sleep(2000);
				String value = WebAction.getAttribute(input, "value");
				if (value.equals("")) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void clearDivisionOnCNBCProduction(RequestMode... mode) throws Exception {
		tryClearing(clearIconForDivision, divisionValue);
		Assert.assertTrue(divisionValue.size() == 0, "Division input is not cleared");
	}

	public void clearRequestForOnCNBCProduction(RequestMode... mode) throws Exception {
		tryClearing(clearIconForRequestFor, requestForValue);
		Assert.assertTrue(requestForValue.size() == 0, "Request For input is not cleared");
	}

	public void clearAirPlatformOnCNBCProduction(RequestMode... mode) throws Exception {
		tryClearing(clearIconForAirPlatform, airPlatformValue);
		Assert.assertTrue(airPlatformValue.size() == 0, "Air Platform input is not cleared");
	}

	public void clearSubDivisionOnCNBCProduction(RequestMode... mode) throws Exception {
		tryClearing(clearIconForSubDivision, subDivisionValue);
		Assert.assertTrue(subDivisionValue.size() == 0, "Sub Division input is not cleared");
	}

	public void clearShowUnitOrProjectNameOnCNBCProduction(RequestMode... mode) throws Exception {
		showUnitOrProjectNameInput.clear();
		String value = WebAction.getAttribute(showUnitOrProjectNameInput, "value");
		Assert.assertTrue(value.equals(""), "Show Unit or Project Name input is not cleared");
	}

	public void clearBudgetCodeOnCNBCProduction(RequestMode... mode) throws Exception {
		budgetCodeInput.clear();
		String value = WebAction.getAttribute(budgetCodeInput, "value");
		Assert.assertTrue(value.equals(""), "Budget Code input is not cleared");
	}

	public void clearStartDateOnCNBCProduction(RequestMode... mode) throws Exception {
		tryClearing(clearIconForStartDate, startDateInput);
		String value = WebAction.getAttribute(startDateInput, "value");
		Assert.assertTrue(value.equals(""), "Start Date input is not cleared");
	}

	public void clearCallTimeOnCNBCProduction(RequestMode... mode) throws Exception {
		tryClearing(clearIconForCallTime, callTimeInput);
		String value = WebAction.getAttribute(callTimeInput, "value");
		Assert.assertTrue(value.equals(""), "Call Time input is not cleared");
		Runnable store = () -> {
			if (isEditMode(mode)) {
				String sectionLog = "Changed Date/Time under Show Info Section:";
				Constants.getLog().getLogs().removeLogStartingWith(sectionLog, " Call Time");
				Constants.getLog().getLogs().putLog(sectionLog, " Call Time: removed");
				changeRequestStatusToModified();
			}
			Constants.setCallTime(null);
		};
		executeStorage("Call Time", store, mode);
	}

	public void clearStartTimeOnCNBCProduction(RequestMode... mode) throws Exception {
		tryClearing(clearIconForStartTime, startTimeInput);
		String value = WebAction.getAttribute(startTimeInput, "value");
		Assert.assertTrue(value.equals(""), "Start Time input is not cleared");
	}

	public void clearEndTimeOnCNBCProduction(RequestMode... mode) throws Exception {
		tryClearing(clearIconForEndTime, endTimeInput);
		String value = WebAction.getAttribute(endTimeInput, "value");
		Assert.assertTrue(value.equals(""), "End Time input is not cleared");
	}

	public void clearLocationOnCNBCProduction(String locationNumber, RequestMode... mode) throws Exception {
		Integer position = Integer.parseInt(locationNumber);
		WebAction.mouseOverClick(clearIconsForLocation.get(position));
	}

	public void removeLocationOnCNBCProduction(String locationNumber, RequestMode... mode) throws Exception {
		int position = Integer.parseInt(locationNumber);
		String location = getText(selectedLocationInSetLocationSection.get(position));
		WebAction.click(removeButtonsForLocation.get(position));
		Runnable store = () -> {
			Optional<LocationRecord> optional = Constants.getLocation().stream()
					.filter((locRec) -> locRec.getLocation().equals(location)).findFirst();
			if (optional.isPresent()) {
				if (isEditMode(mode)) {
					Constants.getLog().getLogs().putLog("Changed Set Location Section:",
							String.format(" Location: %s removed", location));
					changeRequestStatusToModified();
				}
				Constants.getLocation().remove(optional.get());
			}
		};
		executeStorage(location, store, mode);
	}

	public void clearSetCrewOnCNBCProduction(RequestMode... mode) throws Exception {
		tryClearing(clearIconForSetCrew, selectedSetCrewNames);
		Iterator<CrewRecord> crewIterator = Constants.getSetCrew().iterator();
		while (crewIterator.hasNext()) {
			CrewRecord crew = crewIterator.next();
			String crewName = crew.getCrewName();
			Runnable store = () -> {
				if (isEditMode(mode)) {
					Constants.getLog().getLogs().putLog("Changed Set Location Crew Section:",
							String.format(" %s: removed , Count: %d → 0", crew.getCrewName(), crew.getNumber()));
					changeRequestStatusToModified();
				}
				Constants.getSetCrew().remove(crew);
			};
			executeStorage(crewName, store, mode);
		}
	}

	public void clearControlRoomCrewOnCNBCProduction(RequestMode... mode) throws Exception {
		tryClearing(clearIconForControlRoomCrew, selectedControlRoomCrewNames);
		Iterator<CrewRecord> crewIterator = Constants.getControlRoomCrew().iterator();
		while (crewIterator.hasNext()) {
			CrewRecord crew = crewIterator.next();
			String crewName = crew.getCrewName();
			Runnable store = () -> {
				if (isEditMode(mode)) {
					Constants.getLog().getLogs().removeLogStartingWith("Changed Control Room Crew Section", null);
					Constants.getLog().getLogs().putLog("Changed Control Room Crew Section:",
							String.format(" %s: removed , Count: %d → 0", crew.getCrewName(), crew.getNumber()));
					changeRequestStatusToModified();
				}
				Constants.getControlRoomCrew().remove(crew);
			};
			executeStorage(crewName, store, mode);
		}
	}

	public void checkIfIngestOptionIsCorrectlyDisplayedInReadOnlyCNBCProduction() {
		String selectedOrNot = Constants.getIngestDoYouNeedContentToBeRecorded();
		scrollIntoView(ingestIconInReadOnlyMode);
		String classes = WebAction.getAttribute(ingestIconInReadOnlyMode, "class");
		if (selectedOrNot != null && selectedOrNot.equals("Yes")) {
			Assert.assertTrue(
					classes != null && classes.contains("anticon-check-circle") && classes.contains("selected-color"),
					"Check icon with correct color should display for Ingest in CNBC Production in readonly mode");
		} else if (selectedOrNot == null || selectedOrNot.equals("No")) {
			Assert.assertTrue(
					classes != null && classes.contains("anticon-close-circle") && classes.contains("close-color"),
					"Cross icon with correct color should display for Ingest in CNBC Production in readonly mode");
		}
	}

	public void checkIfIsoOptionIsCorrectlyDisplayedInReadOnlyCNBCProduction() {
		String selectedOrNot = Constants.getIsoDoYouNeedIsoRecordings();
		scrollIntoView(isoIconInReadOnlyMode);
		String classes = WebAction.getAttribute(isoIconInReadOnlyMode, "class");
		if (selectedOrNot != null && selectedOrNot.equals("Yes")) {
			Assert.assertTrue(
					classes != null && classes.contains("anticon-check-circle") && classes.contains("selected-color"),
					"Check icon with correct color should display for ISO in CNBC Production in readonly mode");
		} else if (selectedOrNot == null || selectedOrNot.equals("No")) {
			Assert.assertTrue(
					classes != null && classes.contains("anticon-close-circle") && classes.contains("close-color"),
					"Cross icon with correct color should display for ISO in CNBC Production in readonly mode");
		}
	}

	public void checkIfControlRoomNeededOptionIsCorrectlyDisplayedInReadOnlyCNBCProduction() {
		String selectedOrNot = Constants.getIsAControlRoomNeeded();
		scrollIntoView(controlRoomNeededIconInReadOnlyMode);
		String classes = WebAction.getAttribute(controlRoomNeededIconInReadOnlyMode, "class");
		if (selectedOrNot == null || selectedOrNot.equals("No")) {
			Assert.assertTrue(
					classes != null && classes.contains("anticon-close-circle") && classes.contains("close-color"),
					"Cross icon with correct color should display for Control Room Needed in CNBC Production in readonly mode");
		} else if (selectedOrNot != null && selectedOrNot.equals("Yes")) {
			Assert.assertTrue(
					classes != null && classes.contains("anticon-check-circle") && classes.contains("selected-color"),
					"Check icon with correct color should display for Control Room Needed in CNBC Production in readonly mode");
		}
	}

	public void checkIfCorrectControlRoomCrewSelectionsDisplayedInReadOnlyCNBCProduction() {
		List<CrewRecord> controlRoomCrews = Constants.getControlRoomCrew();
		Set<String> expectedCrewSet = controlRoomCrews.stream()
				.map((crew) -> String.format("%d %s", crew.getNumber(), crew.getCrewName()))
				.collect(Collectors.toSet());
		Assert.assertEquals(selectedControlRoomCrewsListInReadOnlyMode.size(), controlRoomCrews.size(),
				"count of Control Room Crews displayed in readonly mode is not same when request was creaed or edited");
		for (WebElement crewElement : selectedSetCrewsListInReadOnlyMode) {
			String displayedCrew = getText(crewElement);
			Assert.assertTrue(expectedCrewSet.contains(displayedCrew),
					"Control Room Crew record displayed is not as expected");
		}
	}

	public void checkControlRoomCrewSelectionsUnexpandableInReadOnlyCNBCProductionBeforeFulfillment() {
		Consumer<WebElement> consumer = (el) -> {
			String classes = WebAction.getAttribute(el, "class");
			Assert.assertTrue(classes != null && classes.contains("ant-collapse-item-disabled"),
					"Control Room Crew record in readonly CNBC production is expandable");
		};
		selectedControlRoomCrewsContainerListInReadOnlyMode.forEach(consumer);
	}

	public void checkIfCorrectSetCrewSelectionsDisplayedInReadOnlyCNBCProduction() {
		List<CrewRecord> setCrews = Constants.getSetCrew();
		Set<String> expectedCrewSet = setCrews.stream()
				.map((crew) -> String.format("%d %s", crew.getNumber(), crew.getCrewName()))
				.collect(Collectors.toSet());
		Assert.assertEquals(selectedSetCrewsListInReadOnlyMode.size(), expectedCrewSet.size(),
				"count of Set Crews displayed in readonly mode is not same when request was created or edited");
		for (WebElement crewElement : selectedSetCrewsListInReadOnlyMode) {
			String displayedCrew = getText(crewElement);
			Assert.assertTrue(expectedCrewSet.contains(displayedCrew), "Set Crew record displayed is not as expected");
		}
	}

	public void checkSetCrewSelectionsUnexpandableInReadOnlyCNBCProductionBeforeFulfillment() {
		Consumer<WebElement> consumer = (el) -> {
			String classes = WebAction.getAttribute(el, "class");
			Assert.assertTrue(classes != null && classes.contains("ant-collapse-item-disabled"),
					"Set Crew record in readonly CNBC production is expandable");
		};
		selectedSetCrewsContainerListInReadOnlyMode.forEach(consumer);
	}

	public void checkIfCorrectLocationSelectionsDisplayedInReadOnlyCNBCProduction() {
		List<LocationRecord> locations = Constants.getLocation();
		Assert.assertEquals(locationInputs.size(), locations.size(),
				"count of Locations displayed in readonly mode is not same when request was creaed or edited");
		OfInt iterator = IntStream.range(0, locations.size()).iterator();
		Consumer<List<Object>> consumer = (obj) -> {
			LocationRecord location = (LocationRecord) obj.get(0);
			int index = (int) obj.get(1);
			Assert.assertEquals(WebAction.getAttribute(locationInputs.get(index), "value").trim(),
					location.getLocation(), String.format("Location is not as expected as position %d", index));
		};
		locations.stream().map((location) -> Arrays.asList(location, iterator.next())).collect(Collectors.toList())
				.forEach(consumer);
	}

	public void checkIfCorrectAirPlatformSelectionDisplayedInReadOnlyCNBCProduction() {
		Assert.assertEquals(WebAction.getAttribute(airPlatformInput, "value"), Constants.getAirPlatform(),
				"Air platform is not same as selected on readonly CNBC Production request");
	}

	public void checkIfCorrectShowUnitOrProjectNameSelectionDisplayedInReadOnlyCNBCProduction() {
		Assert.assertEquals(WebAction.getAttribute(showUnitOrProjectNameInput, "value"),
				Constants.getShowUnitOrProjectName(),
				"Show Unit or Project Name is not same as selected on readonly CNBC Production request");
	}

	public void checkIfSubDivisionSelectionDisplayedInReadOnlyCNBCProduction() {
		Assert.assertEquals(WebAction.getAttribute(subDivisionInput, "value"), Constants.getSubDivison(),
				"Sub Division is not same as selected on readonly CNBC Production request");
	}

	public void checkIfBudgetCodeSelectionDisplayedInReadOnlyCNBCProduction() {
		Assert.assertEquals(WebAction.getAttribute(budgetCodeInput, "value"), Constants.getBudgetCode(),
				"Budget Code is not same as selected on readonly CNBC Production request");
	}

	public void checkIfStartDateSelectionDisplayedInReadOnlyCNBCProduction() {
		Assert.assertEquals(WebAction.getAttribute(startDateInput, "value"), Constants.getStartTime(),
				"Start Date is not same as selected on readonly CNBC Production request");
	}

	public void checkIfCallTimeSelectionDisplayedInReadOnlyCNBCProduction() {
		Assert.assertEquals(WebAction.getAttribute(callTimeInput, "value"), Constants.getStartTime(),
				"Call Time is not same as selected on readonly CNBC Production request");
	}

	public void checkIfStartTimeSelectionDisplayedInReadOnlyCNBCProduction() {
		Assert.assertEquals(WebAction.getAttribute(startTimeInput, "value"), Constants.getStartTime(),
				"Start Time is not same as selected on readonly CNBC Production request");
	}

	public void checkIfEndTimeSelectionDisplayedInReadOnlyCNBCProduction() {
		Assert.assertEquals(WebAction.getAttribute(endTimeInput, "value"), Constants.getEndTime(),
				"End Time is not same as selected on readonly CNBC Production request");
	}

	public void checkIfRequestForSelectionDisplayedInReadOnlyCNBCProduction() {
		Assert.assertEquals(WebAction.getAttribute(requestForInput, "value"), Constants.getEndTime(),
				"Request For is not same as selected on readonly CNBC Production request");
	}

	public List<String> getExpectedFulfillmentStatuses() {
		List<String> expectedStatuses = Arrays.asList("Acknowledged", "PCR");
		if (Constants.getStagingNeeds() != null && !Constants.getStagingNeeds().equals("")) {
			expectedStatuses.add("Studio");
		}
		Predicate<CrewRecord> controlCrewPredicate = (crew) -> {
			String crewType = crew.getCrewName();
			return crewType.equalsIgnoreCase("Director") || crewType.equalsIgnoreCase("Associate Director");
		};
		Optional<CrewRecord> controlCrewOptional = Constants.getControlRoomCrew().stream().filter(controlCrewPredicate)
				.findAny();
		if (controlCrewOptional.isPresent()) {
			expectedStatuses.add("Director");
		}
		Predicate<CrewRecord> setCrewPredicate = (crew) -> {
			String crewType = crew.getCrewName();
			return crewType.equalsIgnoreCase("Hair Stylist") || crewType.equalsIgnoreCase("Makeup Artist");
		};
		Optional<CrewRecord> setCrewOptional = Constants.getSetCrew().stream().filter(setCrewPredicate).findAny();
		if (setCrewOptional.isPresent()) {
			expectedStatuses.add("Hair & Makeup");
		}
		Optional<CrewRecord> controlCrewOptional2 = Constants.getControlRoomCrew().stream()
				.filter((crew) -> crew.getCrewName().equalsIgnoreCase("TPS")).findAny();
		if (controlCrewOptional2.isPresent()) {
			expectedStatuses.add("TPS");
		}
		if (Constants.getIngestDoYouNeedContentToBeRecorded() != null
				&& Constants.getIngestDoYouNeedContentToBeRecorded().equalsIgnoreCase("Yes")) {
			expectedStatuses.add("Ingest");
		}
		return expectedStatuses;
	}

	public void verifyTheFulfillmentStatusesOnCNBCProduction() {
		List<String> expectedStatuses = getExpectedFulfillmentStatuses();
		Iterator<String> expectedIterator = expectedStatuses.iterator();
		Iterator<WebElement> displayedIterator = fulfillmentStatusesForRequestor.iterator();
		Assert.assertEquals(fulfillmentStatusesForRequestor.size(), expectedStatuses.size(),
				"Count of statuses on CNBC Production request is not same");
		while (expectedIterator.hasNext()) {
			String expected = expectedIterator.next();
			String displayed = WebAction.getText(displayedIterator.next());
			Assert.assertEquals(displayed.trim(), expected, "Fulfillment status is not correct on CNBC Production");
		}
	}

	public void removeSpecificSetCrews(String crewNames, RequestMode... mode) throws Exception {
		Set<String> crewsToRemove = new HashSet<>(Arrays.asList(crewNames.trim().split(",")));
		Iterator<WebElement> removeIconIterator = selectedSetCrewRemovalIcons.iterator();
		Iterator<WebElement> setCrewNamesIterator = selectedSetCrewNames.iterator();
		while (setCrewNamesIterator.hasNext()) {
			WebElement nameEle = setCrewNamesIterator.next();
			WebElement removeEle = removeIconIterator.next();
			String displayedName = getText(nameEle);
			if (crewsToRemove.contains(displayedName)) {
				WebAction.scrollIntoViewTillBottom(removeEle);
				Thread.sleep(2000);
				WebAction.click(removeEle);
				Runnable store = () -> {
					Optional<CrewRecord> optional = Constants.getSetCrew().stream()
							.filter((crew) -> crew.getCrewName().equals(displayedName)).findAny();
					if (optional.isPresent()) {
						CrewRecord crew = optional.get();
						if (isEditMode(mode)) {
							Constants.getLog().getLogs().putLog("Changed Set Location Crew Section:",
									String.format("%s: removed , Count: %d → 0", crew.getCrewName(), crew.getNumber()));
							changeRequestStatusToModified();
						}
						Constants.getSetCrew().remove(crew);
					}
				};
				executeStorage(displayedName, store, mode);
			}
		}
	}

	public void removeSpecificControlRoomCrews(String crewNames, RequestMode... mode) throws Exception {
		Set<String> crewsToRemove = new HashSet<>(Arrays.asList(crewNames.trim().split(",")));
		Iterator<WebElement> removeIconIterator = selectedControlRoomCrewRemovalIcons.iterator();
		Iterator<WebElement> controlCrewNamesIterator = selectedControlRoomCrewNames.iterator();
		while (controlCrewNamesIterator.hasNext()) {
			WebElement nameEle = controlCrewNamesIterator.next();
			WebElement removeEle = removeIconIterator.next();
			String displayedName = getText(nameEle);
			if (crewsToRemove.contains(displayedName)) {
				WebAction.scrollIntoViewTillBottom(removeEle);
				Thread.sleep(2000);
				WebAction.click(removeEle);
				Runnable store = () -> {
					Optional<CrewRecord> optional = Constants.getControlRoomCrew().stream()
							.filter((crew) -> crew.getCrewName().equals(displayedName)).findAny();
					if (optional.isPresent()) {
						CrewRecord crew = optional.get();
						if (isEditMode(mode)) {
							Constants.getLog().getLogs().removeLogStartingWith("Changed Control Room Crew Section",
									null);
							Constants.getLog().getLogs().putLog("Changed Control Room Crew Section:",
									String.format("%s: removed , Count: %d → 0", crew.getCrewName(), crew.getNumber()));
							changeRequestStatusToModified();
						}
						Constants.getControlRoomCrew().remove(crew);
					}
				};
				executeStorage(displayedName, store, mode);
			}
		}
	}

	public void setPredicateForMandatorySection(WebElement ele, String sectionName, Map<String, Predicate<String>> map,
			Predicate<String> isChecked, Predicate<String> isCrossed, Predicate<String> neitherCheckedNorCrossed) {
		Boolean isSubmitButtonClicked = Constants.isSubmitButtonClicked();
		String val = WebAction.getAttribute(ele, "value");
		Predicate<String> selectedPredicate = (val == null || val.equals(""))
				? (isSubmitButtonClicked ? isCrossed : neitherCheckedNorCrossed)
				: isChecked;
		map.put(sectionName, selectedPredicate);
	}

	public void setPredicateForOptionalSection(WebElement ele, String sectionName, Map<String, Predicate<String>> map,
			Predicate<String> isChecked, Predicate<String> neitherCheckedNorCrossed) {
		String val = WebAction.getAttribute(ele, "value");
		Predicate<String> selectedPredicate = (val == null || val.equals("")) ? neitherCheckedNorCrossed : isChecked;
		map.put(sectionName, selectedPredicate);
	}

	public void setPredicateForMandatorySection(int size, String sectionName, Map<String, Predicate<String>> map,
			Predicate<String> isChecked, Predicate<String> isCrossed, Predicate<String> neitherCheckedNorCrossed) {
		Boolean isSubmitButtonClicked = Constants.isSubmitButtonClicked();
		Predicate<String> selectedPredicate = size == 0 ? (isSubmitButtonClicked ? isCrossed : neitherCheckedNorCrossed)
				: isChecked;
		map.put(sectionName, selectedPredicate);
	}

	public void setPredicateForOptionalSection(int size, String sectionName, Map<String, Predicate<String>> map,
			Predicate<String> isChecked, Predicate<String> neitherCheckedNorCrossed) {
		Predicate<String> selectedPredicate = size == 0 ? neitherCheckedNorCrossed : isChecked;
		map.put(sectionName, selectedPredicate);
	}

	public Map<String, Predicate<String>> getMapForCheckingIfSectionIsCheckedOrCrossed() {
		Map<String, Predicate<String>> map = new HashMap<>();
		Predicate<String> isChecked = (cssClasses) -> {
			return cssClasses.contains("anticon-check") && !cssClasses.contains("anticon-close");
		};
		Predicate<String> isCrossed = (cssClasses) -> {
			return !cssClasses.contains("anticon-check") && cssClasses.contains("anticon-close");
		};
		Predicate<String> neitherCheckedNorCrossed = (cssClasses) -> {
			return cssClasses.contains("anticon-") && !cssClasses.contains("anticon-check")
					&& !cssClasses.contains("anticon-close");
		};
		setPredicateForMandatorySection(divisionValue.size(), "GENERAL DETAILS", map, isChecked, isCrossed,
				neitherCheckedNorCrossed);
		setPredicateForOptionalSection(requesterNamesInCreateOrEditMode.size(), "REQUESTER(S)", map, isChecked,
				neitherCheckedNorCrossed);
		setPredicateForOptionalSection(talentNamesInCreateOrEditMode.size(), "TALENT", map, isChecked,
				neitherCheckedNorCrossed);
		setPredicateForMandatorySection(requestForValue.size(), "PRODUCTION PURPOSE", map, isChecked, isCrossed,
				neitherCheckedNorCrossed);
		Boolean anyEmpty = airPlatformValue.size() == 0;
		if (!anyEmpty) {
			if (divisionValue.size() > 0 && getText(divisionValue.get(0)).equals("CNBC")) {
				anyEmpty = subDivisionValue.size() == 0;
			}
		}
		if (!anyEmpty) {
			List<WebElement> showInfoWebElements = new ArrayList<WebElement>(Arrays.asList(showUnitOrProjectNameInput,
					budgetCodeInput, startDateInput, startTimeInput, endTimeInput));
			String showUnit = WebAction.getAttribute(showUnitOrProjectNameInput, "value");
			if (showUnit != null && showUnit.equalsIgnoreCase("Other")) {
				showInfoWebElements.add(otherInput);
			}
			for (WebElement ele : showInfoWebElements) {
				if (WebAction.getAttribute(ele, "value").length() == 0) {
					anyEmpty = true;
					break;
				}
			}
		}
		setPredicateForMandatorySection(anyEmpty ? 0 : 1, "SHOW INFO", map, isChecked, isCrossed,
				neitherCheckedNorCrossed);
		setPredicateForMandatorySection(locationInputs.size() > locationValues.size() ? 0 : 1, "SET LOCATION", map,
				isChecked, isCrossed, neitherCheckedNorCrossed);
		setPredicateForOptionalSection(setCrewNamesInCreateOrEditMode.size(), "SET CREW", map, isChecked,
				neitherCheckedNorCrossed);
		setPredicateForOptionalSection(stagingNeedsInput, "STAGING", map, isChecked, neitherCheckedNorCrossed);
		setPredicateForMandatorySection(controlRoomNeededSelectedOptionValue.size(), "CONTROL ROOM", map, isChecked,
				isCrossed, neitherCheckedNorCrossed);
		if (controlRoomNeededSelectedOptionValue.size() > 0
				&& getText(controlRoomNeededSelectedOptionValue.get(0)).equalsIgnoreCase("Yes")) {
			Boolean anySelected = isoSelectedOptionValue.size() > 0 || ingestSelectedOptionValue.size() > 0
					|| controlRoomCrewNamesInCreateOrEditMode.size() > 0;
			// remove below line 'anySelected=true' when the bug for control room crew
			// checking is fixed
			anySelected = true;
			setPredicateForOptionalSection(anySelected ? 1 : 0, "CONTROL ROOM CREW", map, isChecked,
					neitherCheckedNorCrossed);
		}
		return map;
	}

	public void checkSectionsAreCorrectlyCheckedOrCrossedOnCNBCProduction() {
		Map<String, Predicate<String>> map = getMapForCheckingIfSectionIsCheckedOrCrossed();
		Assert.assertEquals(sectionNamesHavingStatusIcon.size(), map.size(),
				"Count of sections on CNBC is not correct");
		Assert.assertEquals(sectionNamesHavingStatusIcon.size(), sectionStatusIcons.size(),
				"Number of section names and section icons not same");
		for (int itr = 0; itr < sectionNamesHavingStatusIcon.size(); ++itr) {
			String displayedSectionName = WebAction.getText(sectionNamesHavingStatusIcon.get(itr));
			Predicate<String> pred = map.get(displayedSectionName);
			Assert.assertTrue(pred != null,
					String.format("%s should not display on CNBC Production", displayedSectionName));
			Assert.assertTrue(pred.test(WebAction.getAttribute(sectionStatusIcons.get(itr), "class")), String.format(
					"%s is neither marked checked nor crossed correctly on CNBC Production", displayedSectionName));
		}
	}

	public void executeRunnableForSetCrewInFulfillment(CrewRecord crew, RequestMode... mode) {
		WebDriver driver = getCurrentDriver();
		String crewName = crew.getCrewName();
		int prevSavedQuantity = crew.getNumber();
		List<WebElement> crewMemberInputElements = driver
				.findElements(By.xpath(String.format(crewMemberInputLocator, crewName)));
		int newQuantityToBe = crewMemberInputElements.size();
		// new members
		StringBuilder newMembers = new StringBuilder();
		List<String> visibleMembers = new ArrayList<>();
		for (int i = 0; i < newQuantityToBe; ++i) {
			String member = WebAction.getAttribute(crewMemberInputElements.get(i), "value");
			visibleMembers.add(member);
			if (!member.equals("")) {
				newMembers.append(String.format(" %s,", member));
			}
		}
		String newMembersString = newMembers.toString();
		newMembersString = newMembersString.endsWith(",") ? newMembersString.substring(0, newMembersString.length() - 1)
				: newMembersString;
		final String newMembersString2 = newMembersString;
		Runnable store = () -> {
			// old members
			StringBuilder oldMembers = new StringBuilder();
			List<String> members = crew.getCrewMemberNames();
			for (String member : members) {
				if (!member.equals("")) {
					oldMembers.append(String.format(" %s,", member));
				}
			}
			String oldMembersString = oldMembers.toString();
			oldMembersString = oldMembersString.endsWith(",")
					? oldMembersString.substring(0, oldMembersString.length() - 1)
					: oldMembersString;
			if (newQuantityToBe == 0) {
				Constants.getLog().getLogs().putLog("Changed Set Location Crew Section:",
						String.format("%s: removed , Count: %d → 0", crewName, prevSavedQuantity));

			} else if (newMembersString2.equals("") && oldMembersString.equals("")) {
				if (prevSavedQuantity != newQuantityToBe) {
					Constants.getLog().getLogs().putLog("Changed Set Location Crew Section:", String
							.format("%s: changed , Count: %d → %d", crewName, prevSavedQuantity, newQuantityToBe));
				}
			} else if (oldMembersString.equals("") && !newMembersString2.equals("")) {
				if (prevSavedQuantity != newQuantityToBe) {
					Constants.getLog().getLogs().putLog("Changed Set Location Crew Section:",
							String.format("%s: Count: %d → %d , name:%s added", crewName, prevSavedQuantity,
									newQuantityToBe, newMembersString2));
				} else {
					Constants.getLog().getLogs().putLog("Changed Set Location Crew Section:", String
							.format("%s: Count: %d , name:%s added", crewName, prevSavedQuantity, newMembersString2));
				}
			} else if (!oldMembersString.equals("") && newMembersString2.equals("")) {
				if (prevSavedQuantity != newQuantityToBe) {
					Constants.getLog().getLogs().putLog("Changed Set Location Crew Section:",
							String.format("%s: Count: %d → %d , name:%s removed", crewName, prevSavedQuantity,
									newQuantityToBe, oldMembersString));
				} else {
					Constants.getLog().getLogs().putLog("Changed Set Location Crew Section:", String
							.format("%s: Count: %d , name:%s removed", crewName, prevSavedQuantity, oldMembersString));
				}
			} else if (!oldMembersString.equals("") && !newMembersString2.equals("")) {
				if (prevSavedQuantity != newQuantityToBe) {
					Constants.getLog().getLogs().putLog("Changed Set Location Crew Section:",
							String.format("%s: Count: %d → %d , name:%s →%s", crewName, prevSavedQuantity,
									newQuantityToBe, oldMembersString, newMembersString2));
				} else {
					Constants.getLog().getLogs().putLog("Changed Set Location Crew Section:",
							String.format("%s: Count: %d , name:%s →%s", crewName, prevSavedQuantity, newQuantityToBe,
									oldMembersString, newMembersString2));
				}
			}
			if (newQuantityToBe == 0) {
				Constants.getSetCrew().remove(crew);
			} else {
				members.clear();
				visibleMembers.forEach((member) -> members.add(member));
				crew.setNumber(newQuantityToBe);
			}
		};
		executeStorage(crewName, store, mode);
	}

	public void provideSetCrewMembersInFulfillment(RequestMode... mode) {
		WebDriver driver = getCurrentDriver();
		Constants.getSetCrew().forEach((crew) -> {
			String crewName = crew.getCrewName();
			List<WebElement> inputElements = driver
					.findElements(By.xpath(String.format(crewMemberInputLocator, crewName)));
			List<String> added = new ArrayList<>();
			for (int i = 0; i < inputElements.size(); ++i) {
				WebElement inputElement = inputElements.get(i);
				WebAction.scrollIntoView(inputElement);
				String currValue = WebAction.getAttribute(inputElement, "value");
				String newValue = currValue.equals("") ? String.format("%s %d", crewName, i)
						: String.format("%s-edited", currValue);
				inputElement.clear();
				inputElement.sendKeys(newValue);
				added.add(newValue);
			}
			executeRunnableForSetCrewInFulfillment(crew, mode);
		});
	}

	public void modifySetCrewMemberQuantitiesInFulfillment(RequestMode... mode) {
		WebDriver driver = getCurrentDriver();
		int quantityUpperLimit = 5;
		Constants.getSetCrew().forEach((crew) -> {
			String crewName = crew.getCrewName();
			List<WebElement> inputElements = driver
					.findElements(By.xpath(String.format(crewQuanitityInputLocator, crewName)));
			WebElement inputElement = inputElements.get(0);
			WebAction.scrollIntoView(inputElement);
			String newQuantity = Integer.toString(Math.max(1, (int) (Math.random() * quantityUpperLimit)));
			WebAction.clearInputOneCharAtTime(inputElement);
			inputElement.sendKeys(newQuantity);
			executeRunnableForSetCrewInFulfillment(crew, mode);
		});
	}

	public void deleteSetCrewMembersInFulfillmentRandomly(RequestMode... mode) {
		WebDriver driver = getCurrentDriver();
		Constants.getSetCrew().forEach((crew) -> {
			String crewName = crew.getCrewName();
			List<WebElement> deleteButtonElements = driver
					.findElements(By.xpath(String.format(crewMemberDeleteButtonLocator, crewName)));
			for (int i = 0; i < deleteButtonElements.size(); ++i) {
				boolean toDelete = Math.random() >= 0.5 ? true : false;
				if (toDelete) {
					WebElement deleteButtonElement = deleteButtonElements.get(i);
					try {
						WebAction.click(deleteButtonElement);
						executeRunnableForSetCrewInFulfillment(crew, mode);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	public void deleteSetCrewInFulfillment(String crewNamesToDelete, RequestMode... mode) {
		Set<String> namesToDelete = new HashSet<>();
		Arrays.asList(crewNamesToDelete.split(",")).forEach((name) -> namesToDelete.add(name.trim()));
		WebDriver driver = getCurrentDriver();
		crewNamesInFulfillmentContainer.forEach((titleEle) -> {
			String title = getText(titleEle);
			if (namesToDelete.contains(title)) {
				WebElement deleteButtonElement = driver
						.findElement(By.xpath(String.format(crewDeleteButtonLocator, title)));
				try {
					WebAction.click(deleteButtonElement);
					Optional<CrewRecord> crewOptional = Constants.getSetCrew().stream()
							.filter((crewRec) -> crewRec.getCrewName().equals(title)).findAny();
					if (crewOptional.isPresent()) {
						executeRunnableForSetCrewInFulfillment(crewOptional.get(), mode);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void executeRunnableForControlRoomCrewInFulfillment(CrewRecord crew, RequestMode... mode) {
		WebDriver driver = getCurrentDriver();
		String crewName = crew.getCrewName();
		int prevSavedQuantity = crew.getNumber();
		List<WebElement> crewMemberInputElements = driver
				.findElements(By.xpath(String.format(crewMemberInputLocator, crewName)));
		int newQuantityToBe = crewMemberInputElements.size();
		// new members
		StringBuilder newMembers = new StringBuilder();
		List<String> visibleMembers = new ArrayList<>();
		for (int i = 0; i < newQuantityToBe; ++i) {
			String member = WebAction.getAttribute(crewMemberInputElements.get(i), "value");
			visibleMembers.add(member);
			if (!member.equals("")) {
				newMembers.append(String.format(" %s,", member));
			}
		}
		String newMembersString = newMembers.toString();
		newMembersString = newMembersString.endsWith(",") ? newMembersString.substring(0, newMembersString.length() - 1)
				: newMembersString;
		final String newMembersString2 = newMembersString;
		Runnable store = () -> {
			// old members
			StringBuilder oldMembers = new StringBuilder();
			List<String> members = crew.getCrewMemberNames();
			for (String member : members) {
				if (!member.equals("")) {
					oldMembers.append(String.format(" %s,", member));
				}
			}
			String oldMembersString = oldMembers.toString();
			oldMembersString = oldMembersString.endsWith(",")
					? oldMembersString.substring(0, oldMembersString.length() - 1)
					: oldMembersString;
			if (newQuantityToBe == 0) {
				Constants.getLog().getLogs().putLog("Changed Control Room Crew Section:",
						String.format("%s: removed , Count: %d → 0", crewName, prevSavedQuantity));

			} else if (newMembersString2.equals("") && oldMembersString.equals("")) {
				if (prevSavedQuantity != newQuantityToBe) {
					Constants.getLog().getLogs().putLog("Changed Control Room Crew Section:", String
							.format("%s: changed , Count: %d → %d", crewName, prevSavedQuantity, newQuantityToBe));
				}
			} else if (oldMembersString.equals("") && !newMembersString2.equals("")) {
				if (prevSavedQuantity != newQuantityToBe) {
					Constants.getLog().getLogs().putLog("Changed Control Room Crew Section:",
							String.format("%s: Count: %d → %d , name:%s added", crewName, prevSavedQuantity,
									newQuantityToBe, newMembersString2));
				} else {
					Constants.getLog().getLogs().putLog("Changed Control Room Crew Section:", String
							.format("%s: Count: %d , name:%s added", crewName, prevSavedQuantity, newMembersString2));
				}
			} else if (!oldMembersString.equals("") && newMembersString2.equals("")) {
				if (prevSavedQuantity != newQuantityToBe) {
					Constants.getLog().getLogs().putLog("Changed Control Room Crew Section:",
							String.format("%s: Count: %d → %d , name:%s removed", crewName, prevSavedQuantity,
									newQuantityToBe, oldMembersString));
				} else {
					Constants.getLog().getLogs().putLog("Changed Control Room Crew Section:", String
							.format("%s: Count: %d , name:%s removed", crewName, prevSavedQuantity, oldMembersString));
				}
			} else if (!oldMembersString.equals("") && !newMembersString2.equals("")) {
				if (prevSavedQuantity != newQuantityToBe) {
					Constants.getLog().getLogs().putLog("Changed Control Room Crew Section:",
							String.format("%s: Count: %d → %d , name:%s →%s", crewName, prevSavedQuantity,
									newQuantityToBe, oldMembersString, newMembersString2));
				} else {
					Constants.getLog().getLogs().putLog("Changed Control Room Crew Section:",
							String.format("%s: Count: %d , name:%s →%s", crewName, prevSavedQuantity, newQuantityToBe,
									oldMembersString, newMembersString2));
				}
			}
			if (newQuantityToBe == 0) {
				Constants.getControlRoomCrew().remove(crew);
			} else {
				members.clear();
				visibleMembers.forEach((member) -> members.add(member));
				crew.setNumber(newQuantityToBe);
			}
		};
		executeStorage(crewName, store, mode);
	}

	public void provideControlRoomCrewMembersInFulfillment(RequestMode... mode) {
		WebDriver driver = getCurrentDriver();
		Constants.getControlRoomCrew().forEach((crew) -> {
			String crewName = crew.getCrewName();
			List<WebElement> inputElements = driver
					.findElements(By.xpath(String.format(crewMemberInputLocator, crewName)));
			for (int i = 0; i < inputElements.size(); ++i) {
				WebElement inputElement = inputElements.get(i);
				WebAction.scrollIntoView(inputElement);
				String currValue = WebAction.getAttribute(inputElement, "value");
				String newValue = currValue.equals("") ? String.format("%s %d", crewName, i)
						: String.format("%s-edited", currValue);
				inputElement.clear();
				inputElement.sendKeys(newValue);
			}
			executeRunnableForControlRoomCrewInFulfillment(crew, mode);
		});
	}

	public void modifyControlRoomCrewMemberQuantitiesInFulfillment(RequestMode... mode) {
		WebDriver driver = getCurrentDriver();
		int quantityUpperLimit = 5;
		Constants.getControlRoomCrew().forEach((crew) -> {
			String crewName = crew.getCrewName();
			List<WebElement> inputElements = driver
					.findElements(By.xpath(String.format(crewQuanitityInputLocator, crewName)));
			WebElement inputElement = inputElements.get(0);
			WebAction.scrollIntoView(inputElement);
			String newQuantity = Integer.toString(Math.max(1, (int) (Math.random() * quantityUpperLimit)));
			WebAction.clearInputOneCharAtTime(inputElement);
			inputElement.sendKeys(newQuantity);
			executeRunnableForControlRoomCrewInFulfillment(crew, mode);
		});
	}

	public void deleteControlRoomCrewMembersInFulfillmentRandomly(RequestMode... mode) {
		WebDriver driver = getCurrentDriver();
		Constants.getControlRoomCrew().forEach((crew) -> {
			String crewName = crew.getCrewName();
			List<WebElement> deleteButtonElements = driver
					.findElements(By.xpath(String.format(crewMemberDeleteButtonLocator, crewName)));
			for (int i = 0; i < deleteButtonElements.size(); ++i) {
				boolean toDelete = Math.random() >= 0.5 ? true : false;
				if (toDelete) {
					WebElement deleteButtonElement = deleteButtonElements.get(i);
					try {
						WebAction.click(deleteButtonElement);
						executeRunnableForControlRoomCrewInFulfillment(crew, mode);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	public void deleteControlRoomCrewInFulfillment(String crewNamesToDelete, RequestMode... mode) {
		Set<String> namesToDelete = new HashSet<>();
		Arrays.asList(crewNamesToDelete.split(",")).forEach((name) -> namesToDelete.add(name.trim()));
		WebDriver driver = getCurrentDriver();
		crewNamesInFulfillmentContainer.forEach((titleEle) -> {
			String title = getText(titleEle);
			if (namesToDelete.contains(title)) {
				WebElement deleteButtonElement = driver
						.findElement(By.xpath(String.format(crewDeleteButtonLocator, title)));
				try {
					WebAction.click(deleteButtonElement);
					Optional<CrewRecord> crewOptional = Constants.getControlRoomCrew().stream()
							.filter((crewRec) -> crewRec.getCrewName().equals(title)).findAny();
					if (crewOptional.isPresent()) {
						executeRunnableForControlRoomCrewInFulfillment(crewOptional.get(), mode);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void checkStatusOnFulfillment(String statuses, RequestMode... mode) throws Exception {
		List<String> statusesList = Arrays.asList(statuses.split(",")).stream().map((status) -> status.trim())
				.collect(Collectors.toList());
		for (String status : statusesList) {
			int size = uncheckedFulfillmentStatusElements.size();
			for (int i = 0; i < size; ++i) {
				String displayedName = getText(uncheckedFulfillmentStatusElements.get(i)).trim();
				if (displayedName.equalsIgnoreCase(status)) {
					WebElement checkButton = checkButtonForUncheckedFulfillmentStatusElements.get(i);
					WebAction.scrollIntoViewTillBottom(checkButton);
					WebAction.click(checkButton);
					Waits.waitUntilElementSizeEquals(uncheckedFulfillmentStatusElements, size - 1);
					Runnable store = () -> {
						if (status.equalsIgnoreCase("Acknowledged")) {
							Constants.getLog().getLogs().putLog("Acknowledged", null);
						} else if (status.equalsIgnoreCase("PCR")) {
							// this is an existing system bug
							Constants.getLog().getLogs().putLog("Completed Technical", null);
						} else if (status.equalsIgnoreCase("Studio")) {
							Constants.getLog().getLogs().putLog("Completed Staging", null);
						} else if (status.equalsIgnoreCase("TPS")) {
							Constants.getLog().getLogs().putLog("Completed TPS", null);
						} else if (status.equalsIgnoreCase("Director")) {
							// this is an existing system bug
							Constants.getLog().getLogs().putLog("Completed Production Playout", null);
						}
					};
					Boolean isRunnablePresent = producerDashboardGeneralPage
							.removeStorage(String.format("Changed %s", status));
					if (!isRunnablePresent) {
						executeStorage(String.format("Completed %s", status), store, mode);
					}
					RequestStatus statusDuringChange = RequestStatus.valueOf(Constants.getRequestStatus().name());
					Runnable store2 = () -> {
						Constants.setRequestStatus(RequestStatus.WORKING);
						if (size - 1 == 0) {
							if (statusDuringChange != RequestStatus.FULFILLED) {
								Constants.getLog().getLogs().putLog("Fulfillment Email Sent", null);
							}
							Constants.setRequestStatus(RequestStatus.FULFILLED);
						}
					};
					executeStorage("Status Change", store2, mode);
					break;
				}
			}
		}
	}

	public void clearStatusOnFulfillment(String statuses, RequestMode... mode) {
		List<String> statusesList = Arrays.asList(statuses.split(",")).stream().map((status) -> status.trim())
				.collect(Collectors.toList());
		for (String status : statusesList) {

			int size = statusNamesHavingClearButton.size();
			for (int i = 0; i < size; ++i) {
				String displayedName = getText(statusNamesHavingClearButton.get(i)).trim();
				if (displayedName.equalsIgnoreCase(status)) {
					int trials = 3;
					while (trials-- > 0) {
						try {
							WebElement checkButton = clearButtonForCheckedFulfillmentStatusElements.get(i);
							WebAction.scrollIntoViewTillBottom(checkButton);
							Waits.waitForElement(checkButton, Waits.WAIT_CONDITIONS.CLICKABLE);
							WebAction.click(checkButton);
							Waits.waitUntilElementSizeEquals(statusNamesHavingClearButton, size - 1);
						} catch (Exception e) {
							;
						} finally {
							if (statusNamesHavingClearButton.size() == size - 1) {
								break;
							}
						}
					}
					Runnable store = () -> {
						if (status.equalsIgnoreCase("PCR")) {
							// this is an existing system bug
							Constants.getLog().getLogs().putLog("Changed Technical", null);
						} else if (status.equalsIgnoreCase("Studio")) {
							Constants.getLog().getLogs().putLog("Changed Staging", null);
						} else if (status.equalsIgnoreCase("TPS")) {
							Constants.getLog().getLogs().putLog("Changed TPS", null);
						} else if (status.equalsIgnoreCase("Director")) {
							// this is an existing system bug
							Constants.getLog().getLogs().putLog("Changed Production Playout", null);
						}
					};
					Boolean isRunnablePresent = producerDashboardGeneralPage
							.removeStorage(String.format("Completed %s", status));
					if (!isRunnablePresent) {
						executeStorage(String.format("Changed %s", status), store, mode);
					}
					Runnable store2 = () -> {
						// this is possibly a bug
						Constants.setRequestStatus(RequestStatus.WORKING);
					};
					executeStorage("Status Change", store2, mode);
					break;
				}
			}
		}
	}

	/**
	 * To verify values in the cnbc form are present in production dashboard columns
	 * 
	 * @throws Exception
	 */
	public void verifyCNBCRequestValuesWithProductionDashboardValues(String additionalRequestersText,
			String ProdDateText, String ShowProjectText, String ProductionPurposeText, String SetLocationText,
			String ControlRoomText, String PositionsText, String SubmittedText) throws Exception {
		try {
			String formType = Constants.getFormType();
			String requestNumber = Constants.getRequestNumber();
			String columnCellString = "//a[contains(text(),'<<RequestId>>')]/ancestor::tr/td[contains(@class,'<<ColumnType>>')]";
			producerDashboardGeneralPage.verifyStatusColorBaseOnProductionDateInDashboard(requestNumber,
					columnCellString);

			// To validate workflow of the request
			List<String> workflowList = new ArrayList<String>();
			if (formType.equalsIgnoreCase("CNBC")) {
				workflowList.add("P");
			}

			String stageingNeeded = Constants.getStagingNeeds();
			if (stageingNeeded != null) {
				workflowList.add("S");
				boolean stdioStatus = ProducerDashboardGeneralPage.stdioCheckedIn;

				if (stdioStatus) {

					for (int i = 0; i < workflowList.size(); i++) {

						String updatedStr = workflowList.get(i).replace("S", "✔");

						workflowList.set(i, updatedStr);

					}

				}
			}

			List<String> controlRoomCrewNamesList = new ArrayList<String>();
			List<CrewRecord> controlRoomCrewStringList = Constants.getControlRoomCrew();
			for (CrewRecord controlRoomCrew : controlRoomCrewStringList) {
				controlRoomCrewNamesList.add(controlRoomCrew.getCrewName());
			}
			boolean workflowListAdded = false;
			for (String controlRoomCrewAbb : controlRoomCrewNamesList) {
				switch (controlRoomCrewAbb.toUpperCase()) {
				case "DIRECTOR":
				case "ASSOCIATE DIRECTOR":
					if (!workflowListAdded) {
						workflowList.add("D");
						workflowListAdded = true;
					}
					break;
				}
			}

			List<String> setCrewNamesList = new ArrayList<String>();
			List<CrewRecord> setCrewStringList = Constants.getSetCrew();
			for (CrewRecord setCrew : setCrewStringList) {
				setCrewNamesList.add(setCrew.getCrewName());
			}
			workflowListAdded = false;
			for (String setCrewAbb : setCrewNamesList) {
				switch (setCrewAbb.toUpperCase()) {
				case "MAKEUP ARTIST":
				case "HAIR STYLIST":
				case "WARDROBE DRESSER":
					if (!workflowListAdded) {
						workflowList.add("H");
						boolean hairMakeupWardrobeStatus = ProducerDashboardGeneralPage.hairMakeupWardrobeCheckedIn;

						if (hairMakeupWardrobeStatus) {

							for (int i = 0; i < workflowList.size(); i++) {

								String updatedStr = workflowList.get(i).replace("H", "✔");

								workflowList.set(i, updatedStr);

							}
						}
						workflowListAdded = true;
					}

					break;
				}
			}

			for (String controlRoomCrewAbb : controlRoomCrewNamesList) {
				switch (controlRoomCrewAbb.toUpperCase()) {
				case "TPS":
					workflowList.add("T");
					boolean tpsStatus = ProducerDashboardGeneralPage.tpsCheckedIn;

					if (tpsStatus) {

						for (int i = 0; i < workflowList.size(); i++) {

							String updatedStr = workflowList.get(i).replace("T", "✔");

							workflowList.set(i, updatedStr);

						}
					}
					break;
				}
			}

			String ingestOption = Constants.getIngestDoYouNeedContentToBeRecorded();
			if (ingestOption != null && ingestOption.equalsIgnoreCase("YES")) {
				workflowList.add("✔");
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

			verifyDefaultRequesterInCNBCDashboard(requestNumber, columnCellString);
			producerDashboardGeneralPage.verifyAdditionalRequesterInDashboard(additionalRequestersText, requestNumber,
					columnCellString);
			producerDashboardGeneralPage.verifyProdDateInDashboard(ProdDateText, requestNumber, columnCellString);
			producerDashboardGeneralPage.verifyShowProjectInDashboard(ShowProjectText, requestNumber, columnCellString);
			producerDashboardGeneralPage.verifyProductionPurposeInDashboard(ProductionPurposeText, requestNumber,
					columnCellString);
			verifySetLocationInCNBCDashboard(SetLocationText, requestNumber, columnCellString);
			producerDashboardGeneralPage.verifyControlRoomInDashboard(ControlRoomText, requestNumber, columnCellString);
			verifyPositionsColumnInCNBCDashboard(PositionsText, requestNumber, columnCellString);
			producerDashboardGeneralPage.verifySubmittedInDashboard(SubmittedText, requestNumber, columnCellString);
			producerDashboardGeneralPage.verifyActionsColumnInDashboard(requestNumber, columnCellString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyPositionsColumnInCNBCDashboard(String PositionsText, String requestNumber,
			String columnCellString) throws Exception {
		if (PositionsText != null) {
			String[] positionsTextArrayList;
			positionsTextArrayList = PositionsText.split("-");
			String columnTypeText = "position";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnType>>", columnTypeText);
			String setCrewText = positionsTextArrayList[0];
			String controlRoomCrewText = positionsTextArrayList[1];

			// To validate set crew
			String SetCrewArrayList[] = null;
			if (setCrewText != null) {
				if (setCrewText.contains(",")) {
					SetCrewArrayList = setCrewText.split(",");
				} else {
					SetCrewArrayList = setCrewText.split(" ");
				}
				for (int i = 0; i < SetCrewArrayList.length; i++) {
					switch (SetCrewArrayList[i].toUpperCase()) {
					case "HAIR STYLIST":
						SetCrewArrayList[i] = "HAIR";
						break;
					case "MAKEUP ARTIST":
						SetCrewArrayList[i] = "MU";
						break;
					}
				}
				for (String SetCrewArray : SetCrewArrayList) {
					String updatedColumnCellTypeText = columnCellTypeText + "/div/div[1]";
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
							updatedColumnCellTypeText, SetCrewArray);
				}
			}
			// To validate control room crew
			if (controlRoomCrewText != null) {
				String controlRoomCrewArrayList[] = null;
				if (controlRoomCrewText.contains(",")) {
					controlRoomCrewArrayList = controlRoomCrewText.split(",");
				} else {
					controlRoomCrewArrayList = controlRoomCrewText.split(" ");
				}

				for (String controlRoomCrewArray : controlRoomCrewArrayList) {
					String updatedColumnCellTypeText = columnCellTypeText + "/div/div[2]";
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
							updatedColumnCellTypeText, controlRoomCrewArray);
				}
			}

		}
	}

	public void verifyDefaultRequesterInCNBCDashboard(String requestNumber, String columnCellString) throws Exception {
		String columnTypeText;
		// To validate default requester
		String defaultRequesterName = Constants.getDefaultRequesterName();
		columnTypeText = "modifiedBy";
		String defaultRequesterNamecolumnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
				.replace("<<ColumnType>>", columnTypeText);
		String defaultRequesterNameTextIndashboard = defaultRequesterNamecolumnCellTypeText.concat("//div");
		producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
				defaultRequesterNameTextIndashboard, defaultRequesterName);
	}

	public void verifySetLocationInCNBCDashboard(String SetLocationText, String requestNumber, String columnCellString)
			throws Exception, InterruptedException {
		String columnTypeText;
		// To validate set location
		if (SetLocationText != null) {
			columnTypeText = "setLocation";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnType>>", columnTypeText);
			String[] SetLocationArrayList;
			if (SetLocationText.contains(",")) {
				SetLocationArrayList = SetLocationText.split(",");
				String SetLocationArrayListTextIndashboard = columnCellTypeText.concat("/div/div/span");
				WebElement SetLocationArrayListWebelement = driver
						.findElement(By.xpath(SetLocationArrayListTextIndashboard));
				Waits.waitForElement(SetLocationArrayListWebelement, WAIT_CONDITIONS.VISIBLE);
				Thread.sleep(1000);
				WebAction.click(SetLocationArrayListWebelement);
				String locationNamesXpath = "(//div[contains(@class,'popover')])[last()]/div[<<locationNo>>]";
				for (int i = 0; i < SetLocationArrayList.length; i++) {
					String locationNamesNewXpath = locationNamesXpath.replace("<<locationNo>>",
							Integer.toString(i + 1));
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
							locationNamesNewXpath, SetLocationArrayList[i]);
				}
			} else {
				SetLocationArrayList = SetLocationText.split(" ");
				String SetLocationArrayListTextIndashboard = columnCellTypeText.concat("/div/div");
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
						SetLocationArrayListTextIndashboard, SetLocationArrayList[0]);
			}
		}
	}
}
