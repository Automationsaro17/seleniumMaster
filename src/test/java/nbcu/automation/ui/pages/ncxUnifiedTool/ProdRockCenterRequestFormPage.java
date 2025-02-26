
package nbcu.automation.ui.pages.ncxUnifiedTool;

import static nbcu.framework.utils.ui.WebAction.click;
import static nbcu.framework.utils.ui.WebAction.getText;
import static nbcu.framework.utils.ui.WebAction.scrollIntoView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;
import nbcu.automation.ui.enums.RequestMode;
import nbcu.automation.ui.enums.RequestStatus;
import nbcu.automation.ui.enums.UserRole;
import nbcu.automation.ui.pojos.ncxUnifiedTool.ControlRoomAndCrewRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.CrewRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.LocationRecord;
import nbcu.framework.factory.DriverFactory;
import nbcu.framework.utils.Other.DateFunctions;
import nbcu.framework.utils.propertyfilereader.ConfigFileReader;
import nbcu.framework.utils.report.ReportGenerate;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.WebAction;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;

public class ProdRockCenterRequestFormPage {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	@FindBy(xpath = "//div[contains(text(),'Ultimatte')]/ancestor::div[1]//input")
	WebElement ultimatteInputbox;

	@FindBy(xpath = "//div[contains(text(),'Voice Activated Prompter')]/ancestor::div[1]//input")
	WebElement vapInputbox;

	@FindBy(xpath = "//*[@forminputname='isStagingNeeded']//label[@label-value='false']")
	WebElement isStagingNeeded_No;

	@FindBy(xpath = "//*[@forminputname='isStagingNeeded']//label[@label-value='true']")
	WebElement isStagingNeeded_Yes;

	@FindBy(xpath = "//*[@forminputname='isCarpentryNeeded']//label[@label-value='true']")
	WebElement isCarpentryNeeded_Yes;

	@FindBy(xpath = "//*[@forminputname='isCarpentryNeeded']//label[@label-value='false']")
	WebElement isCarpentryNeeded_No;

	@FindBy(xpath = "//*[@forminputname='isLightingNeeded']//label[@label-value='true']")
	WebElement isLightingNeeded_Yes;

	@FindBy(xpath = "//*[@forminputname='isLightingNeeded']//label[@label-value='false']")
	WebElement isLightingNeeded_No;

	@FindBy(xpath = "//*[@forminputname='isPropsNeeded']//label[@label-value='true']")
	WebElement isPropsNeeded_Yes;

	@FindBy(xpath = "//*[@forminputname='isPropsNeeded']//label[@label-value='false']")
	WebElement isPropsNeeded_No;

	String dropDownvaluesXpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item";

	@FindBy(xpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item | //nz-option-item")
	List<WebElement> dropDownvalues;

	@FindBy(xpath = "//*[@label='Additional Crew']//nz-select//input")
	WebElement additionalCrew;

	@FindBy(xpath = "//*[@label='Set Location']//input")
	WebElement setLocationDropDown;

	@FindBy(xpath = "//*[@label='Location']//input")
	WebElement locationDropDown;

	@FindBy(xpath = "//*[@sectionTitle]//*[contains(@class,'status-title-area')]//p")
	List<WebElement> formSectionTitles;

	@FindBy(xpath = "//*[@sectiontitle='Show Info']//nz-form-label//label")
	List<WebElement> showInfoSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='General Details']//nz-form-label//label")
	List<WebElement> generalDetailsSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Requester(s)']//nz-form-label//label")
	List<WebElement> requestersSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Talent']//nz-form-label//label")
	List<WebElement> talentSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Production Purpose']//nz-form-label//label")
	List<WebElement> productionPurposeSectionFieldLabels;

	@FindBy(xpath = "//*[contains(@class,'location-items')]//label")
	List<WebElement> setLocationSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Set Crew']//nz-form-label//label")
	List<WebElement> setCrewSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Staging']//nz-form-label//label")
	List<WebElement> stagingSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Control Room']//nz-form-label//label")
	List<WebElement> controlRoomSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Control Room CREW']//nz-form-label//label")
	List<WebElement> controlRoomCrewSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='TPM / TM Information']//nz-form-label//label")
	List<WebElement> TPMTMInfoSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Additional Crew']//nz-form-label//label")
	List<WebElement> additionalCrewSectionFieldLabels;

	@FindBy(xpath = "//*[@class='crew-member-title']/div[contains(@class,'title')]")
	List<WebElement> systemsSectionFieldLabels;

	@FindBy(xpath = "//*[@emptylistmessage='No Requesters Selected']//*[@nztype='link']")
	List<WebElement> additionalRequestersDisplayed;

	@FindBy(xpath = "//*[@class='display-container']//div[@class='ant-col ant-col-xs-10']")
	List<WebElement> AdditionalTalent;

	@FindBy(xpath = "//*[@forminputname='tpmTmName']//input")
	WebElement tpmTmName;

	@FindBy(xpath = "//*[@forminputname='tpmOrTm']//label[@label-value='Yes']")
	WebElement tpmOrTm_Yes;

	@FindBy(xpath = "//*[@forminputname='tpmOrTm']//label[@label-value='No']")
	WebElement tpmOrTm_No;

	@FindBy(xpath = "//*[contains(text(),'Same as requester')]")
	WebElement sameAsRequesterCheckBox;

	@FindBy(xpath = "//p[contains(text(),'TPM / TM INFORMATION')]")
	WebElement tpmOrTmSection;

	@FindBy(xpath = "//p[contains(text(),'SET LOCATION')] | //p[contains(text(),'SET LOCATION & CREW')]")
	WebElement setLocationSection;

	@FindBy(xpath = "(//*[@placeholder='Enter address here'])[1]")
	WebElement locationAddressInputBox;

	@FindBy(xpath = "//*[@label='Control Room Location']//input")
	WebElement controlRoomLocationDropDown;

	@FindBy(xpath = "//*[@label='Control Room']//input")
	WebElement controlRoomDropDown;

	@FindBy(xpath = "(//*[@placeholder='Enter address here'])[2]")
	WebElement controlRoomAddressInputBox;

	@FindBy(xpath = "//*[@forminputname='isStagingNeeded']//label")
	List<WebElement> stagingButtons;

	@FindBy(xpath = "//*[@forminputname='isLightingNeeded']//label")
	List<WebElement> lightingButtons;

	@FindBy(xpath = "//*[@forminputname='isCarpentryNeeded']//label")
	List<WebElement> carpentryButtons;

	@FindBy(xpath = "//*[@forminputname='isPropsNeeded']//label")
	List<WebElement> propsButtons;

	@FindBy(xpath = "//*[text()='FLASHCAM CREW']")
	WebElement flashcamSection;

	@FindBy(xpath = "//phase-two-container[@class='ng-star-inserted'][4]")
	List<WebElement> flashcamCrewoSectionFieldLabels;
	
	@FindBy(xpath = "//label[contains(text(),'Division')]/ancestor::nz-form-label/following::input[1]")
	WebElement divisionInput;
	
	@FindBy(xpath="//*[contains(@class,'ant-select-item') and text()]")
	List<WebElement> dropdownOptions;
	
	@FindBy(xpath="//*[text()=' Request For ']/../following::*[1]//input")
	WebElement requestForInput;
	
	@FindBy(xpath="//*[text()=' Details & Notes ']/../following::*[1]//textarea")
	WebElement detailsAndNotesInput;
	
	@FindBy(xpath="//*[text()=' Describe Staging Needs ']/../following::*[1]//textarea")
	WebElement describeStagingNeedsInput;
	
	@FindBy(xpath="//*[text()=' Notes ']/../following::*[1]//textarea")
	WebElement systemNotesInput;
	
	@FindBy(xpath = "//label[text()=' Air Platform ']/ancestor::nz-form-label/following::input[1]")
	WebElement airPlatformInput;
	
	@FindBy(xpath = "//label[text()=' Work Order # ']/ancestor::nz-form-label/following::input[1]")
	WebElement workOrderInput;
	
	@FindBy(xpath = "//label[text() = ' Budget Code ']/ancestor::nz-form-label/following::input[1]")
	WebElement budgetCodeInput;

	@FindBy(xpath = "//label[contains(text(),'Show Unit or Project Name')]/ancestor::nz-form-label/following::input[1]")
	WebElement showUnitOrProjectNameInput;

	@FindBy(xpath = "//label[text()=' Start Date ']/ancestor::nz-form-label/following::input[1]")
	WebElement startDateInput;

	@FindBy(xpath = "//label[text()=' Start Time ']/ancestor::nz-form-label/following::input[1]")
	WebElement startTimeInput;

	@FindBy(xpath = "//label[text()=' End Time ']/ancestor::nz-form-label/following::input[1]")
	WebElement endTimeInput;

	@FindBy(xpath = "//label[text()=' Other ']/ancestor::nz-form-label/following::input[1]")
	WebElement otherInput;
	
	@FindBy(xpath="(//label[contains(text(),'Start Date')]/ancestor::nz-form-label/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearIconForStartDate;

	@FindBy(xpath="(//label[contains(text(),'Start Time')]/ancestor::nz-form-label/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearIconForStartTime;

	@FindBy(xpath="(//label[contains(text(),'End Time')]/ancestor::nz-form-label/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearIconForEndTime;
	
	@FindBy(xpath="(//label[contains(text(),'Prep Time')]/ancestor::nz-form-label/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearIconForPrepTime;

	@FindBy(xpath="//label[contains(text(),'Prep Time')]/ancestor::nz-form-label/following::input[1]")
	WebElement prepTimeInput;
	
	@FindBy(xpath = "//*[contains(text(),' Is Budget Code Available? ')]/../following::*[1]//span[text()]")
	List<WebElement> isBudgetCodeAvailableRadioLabels;
	
	@FindBy(xpath="//*[text()=' Location ']/ancestor::button")
	WebElement addLocationButton;
	
	@FindBy(xpath="//*[text()=' Control Room ']/ancestor::button")
	WebElement addControlRoomButton;
	
	@FindBy(xpath="//*[text()=' Location ']/../following::*[1]//input")
	List<WebElement> locationInputs;
	
	@FindBy(xpath="//*[text()=' Set Location ']/../following::*[1]//input")
	List<WebElement> setLocationInputs;
	
	@FindBy(xpath="//*[text()=' Control Room Location ']/../following::*[1]//input")
	List<WebElement> controlRoomLocationInputs;
	
	@FindBy(xpath="//*[text()=' Control Room ']/../following::*[1]//input")
	List<WebElement> controlRoomInputs;
	
	@FindBy(xpath="//*[text()=' Set Crew ']/../following::*[1]//input")
	WebElement setCrewInput;
	
	@FindBy(xpath="//*[text()=' Control Room Crew ']/../following::*[1]//input")
	WebElement controlRoomCrewInput;
	
	@FindBy(xpath="//*[text()=' Additional Crew ']/../following::*[1]//input")
	WebElement additionalCrewInput;
	
	@FindBy(xpath="//*[text()=' Set Crew ']/ancestor::*[contains(@class,'body-section')]/following::*[1]//*[contains(@class,'crew-member-container')]//*[contains(@class,'title ')]")
	List<WebElement> displayedSetCrewNamesInEditMode;

	@FindBy(xpath="//*[text()=' Set Crew ']/ancestor::*[contains(@class,'body-section')]/following::*[1]//*[contains(@class,'crew-member-container')]//input")
	List<WebElement> displayedSetCrewInputsInEditMode;

	@FindBy(xpath="//*[text()=' Set Crew ']/ancestor::*[contains(@class,'body-section')]/following::*[1]//*[contains(@class,'crew-member-container')]//i[contains(@class,'anticon-delete')]/ancestor::button")
	List<WebElement> displayedSetCrewDeleteButtonsInEditMode;
	
	@FindBy(xpath="//*[text()=' Control Room Crew ']/ancestor::*[contains(@class,'body-section')]/following::*[1]//*[contains(@class,'crew-member-container')]//*[contains(@class,'title ')]")
	List<WebElement> displayedControlRoomCrewNamesInEditMode;

	@FindBy(xpath="//*[text()=' Control Room Crew ']/ancestor::*[contains(@class,'body-section')]/following::*[1]//*[contains(@class,'crew-member-container')]//input")
	List<WebElement> displayedControlRoomCrewInputsInEditMode;

	@FindBy(xpath="//*[text()=' Control Room Crew ']/ancestor::*[contains(@class,'body-section')]/following::*[1]//*[contains(@class,'crew-member-container')]//i[contains(@class,'anticon-delete')]/ancestor::button")
	List<WebElement> displayedControlRoomCrewDeleteButtonsInEditMode;
	
	@FindBy(xpath="//*[text()=' Additional Crew ']/ancestor::*[contains(@class,'body-section')]/following::*[1]//*[contains(@class,'crew-member-container')]//*[contains(@class,'title ')]")
	List<WebElement> displayedAdditionalCrewNamesInEditMode;

	@FindBy(xpath="//*[text()=' Additional Crew ']/ancestor::*[contains(@class,'body-section')]/following::*[1]//*[contains(@class,'crew-member-container')]//input")
	List<WebElement> displayedAdditionalCrewInputsInEditMode;

	@FindBy(xpath="//*[text()=' Additional Crew ']/ancestor::*[contains(@class,'body-section')]/following::*[1]//*[contains(@class,'crew-member-container')]//i[contains(@class,'anticon-delete')]/ancestor::button")
	List<WebElement> displayedAdditionalCrewDeleteButtonsInEditMode;
	
	@FindBy(xpath="(//label[contains(text(),'Set Crew')]/ancestor::nz-form-label/following::i[contains(@class,'ant-select-close-icon')])[1]")
	WebElement clearIconForSetCrew;
	
	@FindBy(xpath="(//label[contains(text(),'Control Room Crew')]/ancestor::nz-form-label/following::i[contains(@class,'ant-select-close-icon')])[1]")
	WebElement clearIconForControlRoomCrew;
	
	@FindBy(xpath="(//label[contains(text(),'Additional Crew')]/ancestor::nz-form-label/following::i[contains(@class,'ant-select-close-icon')])[1]")
	WebElement clearIconForAdditionalCrew;
	
	@FindBy(xpath="//*[@sectiontitle='Set Crew']//*[contains(@class,'ant-select-selection-item-content')]/following::i[@nztype='close'][1]")
	List<WebElement> selectedSetCrewRemovalIcons;

	@FindBy(xpath="//*[@sectiontitle='Set Crew']//*[contains(@class,'ant-select-selection-item-content')]")
	List<WebElement> selectedSetCrewNames;
	
	@FindBy(xpath="//*[@sectiontitle='Control Room CREW']//*[contains(@class,'ant-select-selection-item-content')]/following::i[@nztype='close'][1]")
	List<WebElement> selectedControlRoomCrewRemovalIcons;

	@FindBy(xpath="//*[@sectiontitle='Control Room CREW']//*[contains(@class,'ant-select-selection-item-content')]")
	List<WebElement> selectedControlRoomCrewNames;
	
	@FindBy(xpath = "//*[contains(text(),' Capture Manager: ')]/../following::*[1]//*[text()]")
	List<WebElement> captureManagerRadioLabels;
	
	@FindBy(xpath="//*[@sectiontitle='Additional Crew']//*[contains(@class,'ant-select-selection-item-content')]/following::i[@nztype='close'][1]")
	List<WebElement> selectedAdditionalCrewRemovalIcons;

	@FindBy(xpath="//*[@sectiontitle='Additional Crew']//*[contains(@class,'ant-select-selection-item-content')]")
	List<WebElement> selectedAdditionalCrewNames;
	
	@FindBy(xpath="//label[text()=' TPM/TM Name ']/ancestor::nz-form-label/following::input[1]")
	WebElement tpmTmNameInput;
	
	@FindBy(xpath="//*[contains(text(),' Is a TPM or TM Needed? ')]/../following::*[1]//*[text()]")
	List<WebElement> isATpmOrTmNeededRadioLabels;
	
	@FindBy(xpath = "//label[text()=' Same as requester? ']/ancestor::nz-form-label/following::input[1]")
	WebElement sameAsRequesterCheckbox;
	
	@FindBy(xpath="//*[contains(text(),' Is STAGING Needed? ')]/../following::*[1]//*[text()]")
	List<WebElement> isStagingNeededRadioLabels;

	@FindBy(xpath="//*[contains(text(),' Is CARPENTRY Needed? ')]/../following::*[1]//*[text()]")
	List<WebElement> isCarpentryNeededRadioLabels;

	@FindBy(xpath="//*[contains(text(),' Is LIGHTING Needed? ')]/../following::*[1]//*[text()]")
	List<WebElement> isLightingNeededRadioLabels;

	@FindBy(xpath="//*[contains(text(),' Are PROPS needed? ')]/../following::*[1]//*[text()]")
	List<WebElement> arePropsNeededRadioLabels;

	@FindBy(xpath = "//*[text()=' Ultimatte ']/..//input")
	WebElement ultimatteInput;
	
	@FindBy(xpath = "//*[text()=' Voice Activated Prompter ']/..//input")
	WebElement voiceActivatedPrompterInput;
	
	@FindBy(xpath = "//*[contains(text(),'SET LOCATION')]/ancestor::phase-two-container"
			+ "//label[text()=' Address ']/ancestor::nz-form-label/following::input[1]")
	List<WebElement> addressInputInSetLocationSection;
	
	@FindBy(xpath="//*[text()=' Location ']/../following::*[1]//nz-select-item")
	List<WebElement> displayedLocationValues;

	@FindBy(xpath="//*[text()=' Control Room Location ']/../following::*[1]//nz-select-item")
	List<WebElement> displayedControlRoomLocationValues;
	
	public ProdRockCenterRequestFormPage() {
		PageFactory.initElements(DriverFactory.getCurrentDriver(), this);
	}

	/**
	 * To verify control room section missing field error message
	 *
	 * @throws Exception
	 */
	public void verifyControlRoomMissingFieldError(String controlRoomLocationErrorMessage,
			String controlRoomErrorMessage) throws Exception {
		WebAction.scrollIntoView(producerDashboardGeneralPage.controlRoomSection);
		try {
			producerDashboardGeneralPage.controlRoomLocationErrorMessage(controlRoomLocationErrorMessage);
			producerDashboardGeneralPage.controlRoomErrorMessage(controlRoomErrorMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addControlRoomInfoInRockcenter(String controlRoomLocationText, String controlRoomText)
			throws Exception {
		try {
			if (Constants.getLocations().toUpperCase().contains("NONE")) {
				WebAction.scrollIntoView(producerDashboardGeneralPage.setLocationSection);
			} else {
				WebAction.scrollIntoView(producerDashboardGeneralPage.setCrewSection);
			}
			producerDashboardGeneralPage.addControlRoomLocation(controlRoomLocationText);
			producerDashboardGeneralPage.addControlRoom(controlRoomText, controlRoomLocationText);
			Constants.setControlRoomLocation(controlRoomLocationText);
//			ProducerDashboardGeneralPage.emailCCList.add(ConfigFileReader.getProperty(
//					"prodreq-controlroom-" + controlRoomLocationText.toLowerCase(), "emailconfig.properties"));

		}

		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void selectControlRoomCrew(String captureManagerText, String controlRoomCrewText) throws Exception {
		// To select control room crew
		// WebAction.scrollIntoView(producerDashboardGeneralPage.controlRoomSection);
		if (!(Constants.getControlRoomLocation().toUpperCase().contains("NO CONTROL ROOM"))) {
			try {
				producerDashboardGeneralPage.selectCaptureManager(captureManagerText);
				producerDashboardGeneralPage.addControlRoomCrew(controlRoomCrewText);
			} catch (

			Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	public void selectAdditionalCrew(String additionalCrewText) throws Exception {
		if (Constants.getControlRoomLocation().toUpperCase().contains("NO CONTROL ROOM")) {
			WebAction.scrollIntoView(producerDashboardGeneralPage.controlRoomSection);
		} else {
			WebAction.scrollIntoView(producerDashboardGeneralPage.controlRoomCrewSection);
		}
		try {
			WebAction.clickUsingJs(additionalCrew);
			if (additionalCrewText != null) {
				String additionalCrewArrayList[];
				if (additionalCrewText.contains(",")) {
					additionalCrewArrayList = additionalCrewText.split(",");
				} else {
					additionalCrewArrayList = new String[1];
					additionalCrewArrayList[0] = additionalCrewText;
				}
				for (String enterAdditionalCrew : additionalCrewArrayList) {
					WebAction.sendKeys(additionalCrew, enterAdditionalCrew);
					Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
					for (WebElement ele : dropDownvalues) {
						if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(enterAdditionalCrew)) {
							WebAction.click(ele);
							if(enterAdditionalCrew.trim().equalsIgnoreCase("Studio Maintenance")) {
							String enterAdditionalCrewTxt = enterAdditionalCrew.replace(" ", "");
							ProducerDashboardGeneralPage.emailCCList.add(ConfigFileReader.getProperty(
									"prodreq-additionalcrew-" + enterAdditionalCrewTxt.toLowerCase(),
									"emailconfig.properties"));
							}
							break;
						}
					}
				}
				List<CrewRecord> additionalCrewStringList = new ArrayList<>();
				for (String additionalCrew : additionalCrewArrayList) {
					additionalCrewStringList.add(new CrewRecord(additionalCrew));
				}
				Constants.setAdditionalCrew(additionalCrewStringList);
			}
			WebAction.clickUsingJs(producerDashboardGeneralPage.additionalCrewSection);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addingAdditionalCrew(String additionalCrewText) throws Exception {
		WebAction.scrollIntoView(producerDashboardGeneralPage.additionalCrewSection);
		try {
			String[] additionalCrewArrayList = null;
			if (additionalCrewText != null) {
				if (additionalCrewText.contains(",")) {
					additionalCrewArrayList = additionalCrewText.split(",");
				} else {
					additionalCrewArrayList = additionalCrewText.split(" ");
				}
				for (String additionalCrewList : additionalCrewArrayList) {
					WebAction.clickUsingJs(additionalCrew);
					Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
					for (WebElement ele : dropDownvalues) {
						if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(additionalCrewList)) {
							WebAction.click(ele);
							break;
						}
					}
					WebAction.clickUsingJs(producerDashboardGeneralPage.additionalCrewSection);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addtionalCrewSelection(String additionalCrewText) throws Exception {
		WebAction.scrollIntoView(setLocationSection);
		try {
			if (additionalCrewText.contains(",") || additionalCrewText.contains("-"))
				addingAdditionalCrew(additionalCrewText);
			else
				selectAdditionalCrew(additionalCrewText);
			WebAction.clickUsingJs(producerDashboardGeneralPage.additionalCrewSection);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addSystemInfo(String ultimatteText, String voiceActivatedPrompteText, String notesText)
			throws Exception {
		try {
			WebAction.scrollIntoView(producerDashboardGeneralPage.additionalCrewSection);
			// To select ultimatte
			if (ultimatteText != null) {
				WebAction.clickUsingJs(ultimatteInputbox);
				WebAction.sendKeys(ultimatteInputbox, ultimatteText);

			}
			// To select voiceActivatedPrompte
			if (voiceActivatedPrompteText != null) {
				WebAction.clickUsingJs(vapInputbox);
				WebAction.sendKeys(vapInputbox, voiceActivatedPrompteText);

			}
			producerDashboardGeneralPage.addNotes(notesText);
		}

		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addStagingInfoInRockCenter(String StagingText, String CarpentryText, String LightingText,
			String PropsText, String DescribeStagingNeedsText) throws Exception {
		try {
			if (StagingText != null) {
				WebAction.scrollIntoView(producerDashboardGeneralPage.systemsSection);

				if (StagingText.equalsIgnoreCase("Yes")) {
					WebAction.click(isStagingNeeded_Yes);
					ProducerDashboardGeneralPage.emailCCList
							.add(ConfigFileReader.getProperty("prodreq-staging", "emailconfig.properties"));
					Constants.setStagingNeeds(StagingText);
					if (CarpentryText.equalsIgnoreCase("Yes"))
						WebAction.click(isCarpentryNeeded_Yes);
					else
						WebAction.click(isCarpentryNeeded_No);

					if (LightingText.equalsIgnoreCase("Yes"))
						WebAction.click(isLightingNeeded_Yes);
					else
						WebAction.click(isLightingNeeded_No);

					if (PropsText.equalsIgnoreCase("Yes"))
						WebAction.click(isPropsNeeded_Yes);
					else
						WebAction.click(isPropsNeeded_No);
				} else
					WebAction.click(isStagingNeeded_No);
			}
			producerDashboardGeneralPage.addDescribeStagingNeeds(DescribeStagingNeedsText);
		} catch (

		Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify sections on the form
	 */
	public void verifyTheFormSectionsInRockCenterForm() {

		Object[] expectedHeaders = { "STATUS", "GENERAL DETAILS", "REQUESTER(S)", "TALENT", "PRODUCTION PURPOSE",
				"SHOW INFO", "SET CREW", "CONTROL ROOM", "CONTROL ROOM CREW", "ADDITIONAL CREW", "SYSTEMS", "STAGING",
				"TPM / TM INFORMATION" };
		if (Constants.getLocations() != null && Constants.getLocations().equals("Telemundo Center")
				&& (Constants.getSetLocations().equals("Newsroom Flashcam")
						|| Constants.getSetLocations().equals("Newsroom Desk"))) {
			List<Object> expectedHeadersList = (Arrays.asList(expectedHeaders));
			expectedHeadersList.add("FLASHCAM CREW");
			expectedHeadersList.remove("SET CREW");
			expectedHeadersList.remove("STAGING");
			expectedHeaders = expectedHeadersList.toArray();
		} else if (Constants.getLocations() != null && Constants.getLocations().equals("None")) {
			List<Object> expectedHeadersList = (Arrays.asList(expectedHeaders));
			expectedHeadersList.remove("SET CREW");
			expectedHeadersList.remove("STAGING");
			expectedHeaders = expectedHeadersList.toArray();
		} else if (Constants.getLocations() != null && Constants.getLocations().equals("Telemundo Center")
				&& (Constants.getSetLocations().equals("Studio"))) {
			List<Object> expectedHeadersList = (Arrays.asList(expectedHeaders));
			expectedHeadersList.add("FLASHCAM CREW");
			expectedHeaders = expectedHeadersList.toArray();
		}

		if (expectedHeaders.length != formSectionTitles.size()) {
			Assert.assertEquals(formSectionTitles.size(), expectedHeaders.length,
					"Total number of sections " + "are not the same as expected");
		} else {
			boolean allFormSectionsArePresent = true;
			for (int itr = 0; itr < expectedHeaders.length; itr++) {
				String expectedName = (String) expectedHeaders[itr];
				String displayedName = WebAction.getText(formSectionTitles.get(itr));
				if (!expectedName.equals(displayedName)) {
					allFormSectionsArePresent = false;
					Assert.assertEquals(displayedName, expectedName,
							"Expected section name is not same as " + "displayed name");
				}
			}
			Assert.assertTrue(allFormSectionsArePresent,
					"All expected sections are not present on " + "Rock Center Production form");
		}
	}

	public void checkFieldsInSectionOfRockCenter(String sectionName) {
		List<WebElement> sectionLabelElements = getSectionLabelElements(sectionName);
		if (sectionLabelElements == null) {
			Assert.assertTrue(false, sectionName + " section is not present in Rock center production form");
			return;
		}

		List<String> expectedFieldNamesList = getExpectedFieldsSectionWise(sectionName);
		List<String> expectedRequiredFieldList = getRequiredFieldsSectionWise(sectionName);
		if (sectionLabelElements.size() != expectedFieldNamesList.size()) {
			Assert.assertEquals(sectionLabelElements.size(), expectedFieldNamesList.size(),
					"Number of displayed fields and expected fields not equal in " + sectionName
							+ " section of Rock center Production");
			return;
		}
		for (int itr = 0; itr < expectedFieldNamesList.size(); itr++) {
			String expectedName = expectedFieldNamesList.get(itr);
			String displayedField = WebAction.getText(sectionLabelElements.get(itr));
			if (displayedField.contains("Prep Time")) {
				displayedField = (displayedField.split(" ")[0] + " " + displayedField.split(" ")[1].trim());
			}
			Assert.assertEquals(displayedField, expectedName, "Displayed field is not same as expected field in "
					+ sectionName + " section of rock center Production");
			String cssClasses = WebAction.getAttribute(sectionLabelElements.get(itr), "class");
			if (cssClasses.contains(" ant-form-item-required") && !expectedRequiredFieldList.contains(displayedField)) {
				Assert.assertTrue(false, "'" + displayedField + "' is not a required field in " + sectionName
						+ " section but displayed with *(required symbol)");
			} else if (!cssClasses.contains(" ant-form-item-required")
					&& expectedRequiredFieldList.contains(displayedField)) {
				Assert.assertTrue(false, "'" + displayedField + "' is a required field in " + sectionName
						+ " section but not displayed with *(required symbol)");
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
		} else if (sectionName.equalsIgnoreCase("ADDITIONAL CREW")) {
			return additionalCrewSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("SYSTEMS")) {
			return systemsSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("TPM / TM INFORMATION")) {
			return TPMTMInfoSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("FLASHCAM CREW")) {
			return flashcamCrewoSectionFieldLabels;
		}
		return null;
	}

	public List<String> getExpectedFieldsSectionWise(String sectionName) {
		List<String> fieldNamesList = new ArrayList<String>();
		if (sectionName.equalsIgnoreCase("GENERAL DETAILS")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Division")));
		} else if (sectionName.equalsIgnoreCase("REQUESTER(S)")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Add Requester(s)")));
		} else if (sectionName.equalsIgnoreCase("TALENT")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Talent")));
		} else if (sectionName.equalsIgnoreCase("PRODUCTION PURPOSE")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Request For", "Details & Notes")));
		} else if (sectionName.equalsIgnoreCase("SHOW INFO")) {
			fieldNamesList.add("Air Platform");
			fieldNamesList.add("Show Unit or Project Name");
			String showUnitOrProjectName = Constants.getShowUnitOrProjectName();
			if (showUnitOrProjectName != null && showUnitOrProjectName.equalsIgnoreCase("Other")) {
				fieldNamesList.add("Other");
			}
			fieldNamesList.addAll(Arrays.asList("Is Budget Code Available?", "Budget Code"));
			String division = Constants.getDivision();
			if (division != null && division.equals("CNBC")) {
				fieldNamesList.add("Work Order #");
			}
			fieldNamesList
					.addAll(new ArrayList<String>(Arrays.asList("Start Date", "Prep Time", "Start Time", "End Time")));
		} else if (sectionName.equalsIgnoreCase("SET LOCATION")) {
			fieldNamesList.add("Location");
			String locationdetail = Constants.getLocations();
			if (locationdetail != null && locationdetail.equalsIgnoreCase("Field")) {
				fieldNamesList.add("Address");
			} else if (locationdetail != null && !locationdetail.equalsIgnoreCase("None")) {
				fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Set Location")));
			}
		} else if (sectionName.equalsIgnoreCase("SET CREW")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Set Crew")));
		} else if (sectionName.equalsIgnoreCase("CONTROL ROOM")) {
			fieldNamesList.add("Control Room Location");
			String controlRoom = Constants.getControlRoomLocation();
			if (controlRoom != null && controlRoom.equalsIgnoreCase("Field")) {
				fieldNamesList.add("Address");
			} else if (controlRoom != null && !controlRoom.equalsIgnoreCase("No Control Room")) {
				fieldNamesList.add("Control Room");
			}
		} else if (sectionName.equalsIgnoreCase("CONTROL ROOM CREW")) {
			String controlRoom = Constants.getControlRoomLocation();
			if (controlRoom != null && !controlRoom.equalsIgnoreCase("No Control Room")) {
				fieldNamesList.addAll(new ArrayList<String>(
						Arrays.asList("Capture Manager: Do you need content to be recorded?", "Control Room Crew")));
			}
		} else if (sectionName.equalsIgnoreCase("ADDITIONAL CREW")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Additional Crew")));
		} else if (sectionName.equalsIgnoreCase("SYSTEMS")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Ultimatte", "Voice Activated Prompter")));
		} else if (sectionName.equalsIgnoreCase("STAGING")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Is STAGING Needed?", "Is LIGHTING Needed?",
					"Is CARPENTRY Needed?", "Are PROPS needed?", "Describe Staging Needs")));
		} else if (sectionName.equalsIgnoreCase("TPM / TM INFORMATION")) {
			fieldNamesList.addAll(new ArrayList<String>(
					Arrays.asList("Is a TPM or TM Needed?", "Same as requester?", "TPM/TM Name")));
		} else if (sectionName.equalsIgnoreCase("FLASHCAM CREW")) {
			String locationdetail = Constants.getLocations();
			String setLocationdetail = Constants.getSetLocations();
			if (locationdetail != null && locationdetail.equalsIgnoreCase("Telemundo Center")
					&& setLocationdetail.equalsIgnoreCase("Newsroom Desk")) {
				fieldNamesList.addAll(
						new ArrayList<String>(Arrays.asList("Set Flashcam Crew", "Notes", "CAMERA OPERATOR", "A1")));
			} else if (locationdetail != null && locationdetail.equalsIgnoreCase("Telemundo Center")
					&& setLocationdetail.equalsIgnoreCase("Newsroom Flashcam")) {
				fieldNamesList
						.addAll(new ArrayList<String>(Arrays.asList("Set Flashcam Crew", "Notes", "TECH MANAGER")));
			}
		}
		return fieldNamesList;
	}

	public List<String> getRequiredFieldsSectionWise(String sectionName) {
		List<String> fieldNamesList = new ArrayList<String>();
		if (sectionName.equalsIgnoreCase("GENERAL DETAILS")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Division")));
		} else if (sectionName.equalsIgnoreCase("REQUESTER(S)") || sectionName.equalsIgnoreCase("TALENT")
				|| sectionName.equalsIgnoreCase("SET CREW") || sectionName.equalsIgnoreCase("CONTROL ROOM CREW")
				|| sectionName.equalsIgnoreCase("ADDITIONAL CREW")
				|| sectionName.equalsIgnoreCase("TPM / TM INFORMATION") || sectionName.equalsIgnoreCase("SYSTEMS")
				|| sectionName.equalsIgnoreCase("FLASHCAM CREW")) {
			fieldNamesList.addAll(new ArrayList<String>());
		} else if (sectionName.equalsIgnoreCase("PRODUCTION PURPOSE")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Request For")));
		} else if (sectionName.equalsIgnoreCase("SHOW INFO")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Air Platform", "Show Unit or Project Name",
					"Other", "Is Budget Code Available?", "Budget Code", "Start Date", "Start Time", "End Time")));
		} else if (sectionName.equalsIgnoreCase("SET LOCATION")) {
			fieldNamesList.add("Location");
			String locationdetail = Constants.getLocations();
			if (locationdetail != null && locationdetail.equalsIgnoreCase("Field")) {
				fieldNamesList.add("Address");
			} else if (locationdetail != null && !locationdetail.equalsIgnoreCase("None"))
				fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Set Location")));
		} else if (sectionName.equalsIgnoreCase("STAGING")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Is STAGING Needed?", "Is LIGHTING Needed?",
					"Is CARPENTRY Needed?", "Are PROPS needed?")));
		} else if (sectionName.equalsIgnoreCase("CONTROL ROOM")) {
			fieldNamesList.add("Control Room Location");
			String locationdetail = Constants.getControlRoomLocation();
			if (locationdetail != null && locationdetail.equalsIgnoreCase("Field")) {
				fieldNamesList.add("Address");
			} else if (locationdetail != null && !locationdetail.equalsIgnoreCase("None"))
				fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Control Room")));
		}
		return fieldNamesList;
	}

	/**
	 * To verify additional talent added in the form
	 *
	 * @param talent- additional talent name
	 */
	public void verifyAdditionOfTalent(String talent) {
		String[] additionalTalentList;
		try {
			if (talent != null) {
				if (talent.contains("-")) {
					additionalTalentList = talent.split("-");

				} else {
					additionalTalentList = talent.split(" ");
				}
				for (String additionalTal : additionalTalentList) {
					for (int i = 0; i < AdditionalTalent.size(); i++) {
						String displayedTalentName = WebAction.getText(AdditionalTalent.get(i));
						Assert.assertEquals(displayedTalentName, additionalTal);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void TPMorTMSectionDetails(String TPMorTM) throws InterruptedException {

		WebAction.scrollIntoView(tpmOrTmSection);
		if (!tpmOrTm_No.isSelected()) {
			tpmTmName.sendKeys("TPMorTM");
		}

	}

	public void fillSetLocationDetails(String locationText, String setLocationText, String Division) throws Exception {
		try {
			WebAction.scrollIntoView(setLocationSection);
			producerDashboardGeneralPage.selectDivision(Division);
			producerDashboardGeneralPage.selectLocation(locationText);
			if (!locationText.equalsIgnoreCase("None") && !locationText.equalsIgnoreCase("Field")
					&& setLocationText != null) {
				boolean valuePresent = false;
				WebAction.clickUsingJs(setLocationDropDown);
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(setLocationText)) {
						WebAction.click(ele);
						valuePresent = true;
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception(
							"'" + setLocationText + "' value is not present in the set location type drop down");
			} else if (locationText.equalsIgnoreCase("Field") && setLocationText != null) {
				WebAction.sendKeys(locationAddressInputBox, setLocationText);
			} else {
				Assert.assertTrue(true, "set location field is not present as location is None");
			}
			Constants.setLocations(locationText);
			Constants.setSetLocations(setLocationText);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillControlRoomDetails(String ControlRoomLocation, String ControlRoom) throws Exception {
		try {
			WebAction.scrollIntoView(controlRoomLocationDropDown);
			producerDashboardGeneralPage.addControlRoomLocation(ControlRoomLocation);
			Constants.setControlRoomLocation(ControlRoomLocation);
			if (!ControlRoomLocation.equalsIgnoreCase("No Control Room")
					&& !ControlRoomLocation.equalsIgnoreCase("Field") && ControlRoomLocation != null) {
				WebAction.clickUsingJs(controlRoomDropDown);
				boolean valuePresent = false;
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(ControlRoom)) {
						WebAction.click(ele);
						valuePresent = true;
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception(
							"'" + ControlRoom + "' value is not present in the set location type drop down");
			} else if (ControlRoomLocation.equalsIgnoreCase("Field") && ControlRoom != null) {
				WebAction.sendKeys(controlRoomAddressInputBox, ControlRoom);
				Constants.setControlRoomOption(ControlRoom);
			} else {

				Assert.assertTrue(true,
						"Control room field is not present as No control room is selected as control room location");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void checkDefaultState() {
		WebAction.scrollIntoView(producerDashboardGeneralPage.stagingSection);
		for (int i = 0; i < stagingButtons.size(); i++) {
			String cssClasses = WebAction.getAttribute(stagingButtons.get(i), "class");
			if (!cssClasses.contains(" ant-radio-button-wrapper-checked")) {
				Assert.assertTrue(true, "The staging buttons are in unchecked state");
			}
			if (stagingButtons.get(i).getText().equalsIgnoreCase("No")) {
				stagingButtons.get(i).click();
				String cssClassesOfLighting = WebAction.getAttribute(lightingButtons.get(i), "class");
				if (cssClassesOfLighting.contains(" ant-radio-button-wrapper-disabled")) {
					Assert.assertTrue(true, "The lighting buttons are in enabled state");
				}
				String cssClassesOfCarpentry = WebAction.getAttribute(carpentryButtons.get(i), "class");
				if (!cssClassesOfCarpentry.contains(" ant-radio-button-wrapper-disabled")) {
					Assert.assertTrue(true, "The Carpentry buttons are in enabled state");
				}
				String cssClassesOfProps = WebAction.getAttribute(propsButtons.get(i), "class");
				if (!cssClassesOfProps.contains(" ant-radio-button-wrapper-disabled")) {
					Assert.assertTrue(true, "The Props buttons are in enabled state");
				}
			} else {
				stagingButtons.get(i).click();
				String cssClassesOfLighting = WebAction.getAttribute(lightingButtons.get(i), "class");
				if (!cssClassesOfLighting.contains(" ant-radio-button-wrapper-disabled")) {
					Assert.assertTrue(true, "The lighting buttons are in disabled state");
				}
				String cssClassesOfCarpentry = WebAction.getAttribute(carpentryButtons.get(i), "class");
				if (!cssClassesOfCarpentry.contains(" ant-radio-button-wrapper-disabled")) {
					Assert.assertTrue(true, "The Carpentry buttons are in disabled state");
				}
				String cssClassesOfProps = WebAction.getAttribute(propsButtons.get(i), "class");
				if (!cssClassesOfProps.contains(" ant-radio-button-wrapper-disabled")) {
					Assert.assertTrue(true, "The Props buttons are in disabled state");

				}
			}

		}

	}

	/**
	 * To verify flashcam crew section in the form
	 *
	 * @param locationText-    location detail
	 * @param Division-        Division detail
	 * @param SetLocationText- Set location detail
	 * @throws Exception
	 */
	public void verifyPresenceOfFlashCamSection(String locationText, String Division, String SetLocationText)
			throws Exception {
		String ExpectedName = "FLASHCAM CREW";
		WebAction.scrollIntoView(locationDropDown);
		fillSetLocationDetails(locationText, Division, SetLocationText);
		if (Constants.getLocations().equalsIgnoreCase("Telemundo Center")
				&& (Constants.getSetLocations().equalsIgnoreCase("Newsroom Flashcam")
						|| Constants.getSetLocations().equalsIgnoreCase("Newsroom Desk"))) {
			Assert.assertEquals(flashcamSection.getText(), ExpectedName, "flashcam section is visible");
		}

	}

	public boolean selectValueInDropdown(WebElement input,String option) {
		Boolean selected = false;
		try {
			input.sendKeys(option);
			Waits.waitUntilElementSizeGreater(dropdownOptions,0);
			Predicate<WebElement> isMatchingElementPredicate = (ele)-> getText(ele).equals(option);
			Optional<WebElement> optional =  dropdownOptions.stream().filter(isMatchingElementPredicate).findAny();
			if(optional.isPresent()) {
				WebElement optionToSelect = optional.get();
				scrollIntoView(optionToSelect);
				click(optionToSelect);
				selected=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return selected;
	}
	
	public Boolean isEditMode(RequestMode...mode) {
		return producerDashboardGeneralPage.isEditMode(mode);
	}
	public void changeRequestStatusToModified() {
		if(Constants.getUserRole() == UserRole.PRODUCER) {
			Constants.setRequestStatus(RequestStatus.MODIFIED);
		}
	}
	public void executeStorage(String fieldName,Runnable store,RequestMode...mode){
		producerDashboardGeneralPage.executeStorage(fieldName,store, mode);
	}
	public void selectDivision(String division,RequestMode...mode) {
		if(division == null) {
			return;
		}
		Boolean isSelected = selectValueInDropdown(divisionInput, division);
		Assert.assertTrue(isSelected,String.format("'%s' is not selected in Division dropdown",division));
		Runnable store = ()->{
			String oldVal = Constants.getDivision();
			Constants.setDivision(division);
			if(isEditMode(mode) && oldVal != null && !oldVal.equalsIgnoreCase(division)) {
				Constants.getLog().getLogs().putLog("Changed General Details Section:", 
						String.format(" Division: %s → %s", oldVal,division));
				changeRequestStatusToModified();
			}
		};
		executeStorage("Division",store,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public void selectRequestFor(String requestFor,RequestMode...mode) {
		if(requestFor == null) {
			return;
		}
		Boolean isSelected = selectValueInDropdown(requestForInput, requestFor);
		Assert.assertTrue(isSelected,String.format("'%s' is not selected in Request For dropdown",requestFor));
		Runnable store = ()->{
			String old = Constants.getRequestFor();
			if(isEditMode(mode)&& old != null && !old.equals(requestFor)) {
				Constants.getLog().getLogs().putLog("Changed Production Purpose Section",null);
				changeRequestStatusToModified();
			}
			Constants.setRequestFor(requestFor);
		};
		executeStorage("Request For",store,mode);
	}
	public void provideDetailsAndNotes(String notes,RequestMode...mode) {
		if(notes == null) {
			return;
		}
		detailsAndNotesInput.clear();
		detailsAndNotesInput.sendKeys(notes);
		Runnable store = ()->{
			String old = Constants.getDetailsAndNotes();
			Constants.setDetailsAndNotes(notes);
			if(isEditMode(mode)) {
				if(old == null) {
					old="";
				}
				if(old != null && !old.equals(notes)) {
					Constants.getLog().getLogs().putLog("Changed Production Purpose Section",null);
					changeRequestStatusToModified();
				}
			}
		};
		executeStorage("Details & Notes",store,mode);
	}
	public void selectAirPlatform(String airPlatform,RequestMode...mode) {
		if(airPlatform == null) {
			return ;
		}
		Boolean isSelected = selectValueInDropdown(airPlatformInput, airPlatform);
		Assert.assertTrue(isSelected,String.format("'%s' is not selected in Show Unit or Project Name dropdown",airPlatform));
		Runnable store = ()->{
			String oldVal = Constants.getAirPlatform();
			Constants.setAirPlatform(airPlatform);
			if(isEditMode(mode) && oldVal != null && !oldVal.equalsIgnoreCase(airPlatform)) {
				Constants.getLog().getLogs().removeLogStartingWith("Changed Show Info Section",null);
				Constants.getLog().getLogs().putLog("Changed Show Info Section:", 
						String.format(" Air Platform: %s → %s", oldVal,airPlatform));
				changeRequestStatusToModified();
			}
		};
		executeStorage("Air Platform",store,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public void selectWorkOrderInShowInfo(String workOrder,RequestMode...mode) {
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
				changeRequestStatusToModified();
			}
			Constants.setWorkOrder(workOrder);
		};
		executeStorage("Work Order",store,mode);
	}
	public void selectShowUnit(String showUnit,RequestMode...mode) {
		if(showUnit == null) {
			return ;
		}
		showUnitOrProjectNameInput.clear();
		Boolean isSelected = selectValueInDropdown(showUnitOrProjectNameInput, showUnit);
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
	public void selectStartDate(String daysOffsetFromCurrent,RequestMode...mode) {
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
					changeRequestStatusToModified();
				}
				Constants.setStartDate(date);
			};
			executeStorage("Start Date",store,mode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selectStartTime(String time,RequestMode...mode) throws Exception {
		if(time == null) {
			return;
		}
		startTimeInput.sendKeys(time,Keys.ENTER);
		Runnable store = ()->{
			String oldTime = Constants.getStartTime();
			if(isEditMode(mode) && oldTime != null && !oldTime.equalsIgnoreCase(time)) {
				Constants.getLog().getLogs().putLog("Changed Date/Time under Show Info Section:",
						String.format(" Start Time: %s (EST) → %s (EST)",oldTime,time));
				changeRequestStatusToModified();
			}
			Constants.setStartTime(time);
		};
		executeStorage("Start Time",store,mode);
	}
	public void selectEndTime(String time,RequestMode...mode) throws Exception {
		if(time == null) {
			return;
		}
		endTimeInput.sendKeys(time,Keys.ENTER);
		Runnable store = ()->{
			String oldTime = Constants.getEndTime();
			if(isEditMode(mode) && oldTime != null && !oldTime.equalsIgnoreCase(time)) {
				Constants.getLog().getLogs().putLog("Changed Date/Time under Show Info Section:",
						String.format(" End Time: %s (EST) → %s (EST)",oldTime,time));
				changeRequestStatusToModified();
			}
			Constants.setEndTime(time);
		};
		executeStorage("End Time",store,mode);
	}
	public void selectOtherInShowInfo(String other,RequestMode...mode) {
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
				changeRequestStatusToModified();
			}
			Constants.setOtherInShowInfo(other);
		};
		executeStorage("Other In Show Info",store,mode);
	}
	public void selectBudgetCode(String code,RequestMode...mode) {
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
				changeRequestStatusToModified();
			}
			Constants.setBudgetCode(code);
		};
		executeStorage("Budget Code",store,mode);
	}
	public void tryClearing(WebElement clearIcon,List<WebElement> valueElement) {
		int trials = 3;
		while(--trials >= 0) {
			try {
				WebAction.mouseOverAndClick(clearIcon);
				Thread.sleep(2000);
				if(valueElement.size() == 0) {
					break;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
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
	public void clearPrepTime(RequestMode...mode) throws Exception {
		tryClearing(clearIconForPrepTime,prepTimeInput);
		String value = WebAction.getAttribute(prepTimeInput, "value");
		Assert.assertTrue(value.equals(""),"Prep Start Time input is not cleared");
		Runnable store = ()->{
			if(isEditMode(mode)) {
				String sectionLog = "Changed Date/Time under Show Info Section:";
				Constants.getLog().getLogs().removeLogStartingWith(sectionLog, " Prep Start Time");
				Constants.getLog().getLogs().putLog(sectionLog," Prep Start Time: removed");
				changeRequestStatusToModified();
			}
			Constants.setPrepTime(null);
		};
		executeStorage("Prep Time",store,mode);
	}
	public void selectPrepTime(String time,RequestMode...mode) {
		if(time == null) {
			return;
		}
		prepTimeInput.sendKeys(time,Keys.ENTER);
		Runnable store = ()->{
			if(isEditMode(mode)) {
				String oldTime = Constants.getPrepTime();
				if(oldTime == null) {
					Constants.getLog().getLogs().putLog("Changed Date/Time under Show Info Section:",
							String.format(" Prep Start Time: %s (EST) , added",time));
				}
				else if(oldTime != null && !oldTime.equalsIgnoreCase(time)) {
					Constants.getLog().getLogs().putLog("Changed Date/Time under Show Info Section:",
							String.format(" Prep Start Time: %s (EST) → %s (EST)",oldTime,time));
				}
				changeRequestStatusToModified();
			}
			Constants.setPrepTime(time);
		};
		executeStorage("Prep Time",store,mode);
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
	public void selectIsBudgetCodeAvailable(String choice,RequestMode...mode) {
		if(choice == null) {
			return ;
		}
		selectRadioOption(choice, isBudgetCodeAvailableRadioLabels);
		String newCode = WebAction.getAttribute(budgetCodeInput, "value");
		Runnable store = ()->{
			String oldBudgetCode = Constants.getBudgetCode();
			String oldIsBudgetCodeAvailable = Constants.getIsBudgetCodeAvailable();
			Constants.setIsBudgetCodeAvailable(choice);
			Constants.setBudgetCode(newCode);
			if(isEditMode(mode) && oldIsBudgetCodeAvailable != null && !oldIsBudgetCodeAvailable.equalsIgnoreCase(choice)) {
				Constants.getLog().getLogs().putLog("Changed Show Info Section:",
						String.format(" Budget Code: %s → %s", oldBudgetCode,Constants.getBudgetCode()));
				changeRequestStatusToModified();
			}
		};
		executeStorage("Is Budget Code Available",store,mode);
	}
	public void selectLocation(String location, String position,RequestMode...mode) {
		// 0-based position
		Integer locationNumber = Integer.parseInt(position);
		Boolean isSelected = selectValueInDropdown(locationInputs.get(locationNumber), location);
		Assert.assertTrue(isSelected,String.format("'%s' is not selected in Location dropdown",location));
		Runnable store = ()->{
			List<LocationRecord> locations = Constants.getLocation();
			while(locations.size() <= locationNumber) {
				locations.add(new LocationRecord());
			}
			String oldLocation = locations.get(locationNumber).getLocation();
			locations.get(locationNumber).setLocation(location);
			if(isEditMode(mode)) {
				if(oldLocation == null) {
					Constants.getLog().getLogs().putLog("Changed Set Location Section:", String.format(" Location: %s", location));
					changeRequestStatusToModified();
				}
				else if(!oldLocation.equalsIgnoreCase(location)) {
					Constants.getLog().getLogs().putLog("Changed Set Location Section:", String.format(" Location: %s → %s", oldLocation,location));
					changeRequestStatusToModified();
				}
			}
		};
		executeStorage(String.format("Location %d", locationNumber),store,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public void addLocation(){
		try {
			WebAction.scrollIntoViewTillBottom(addLocationButton);
			addLocationButton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void selectSetLocation(String setLocation, String position,RequestMode...mode) {
		// 0-based position
		Integer setLocationNumber = Integer.parseInt(position);
		Boolean isSelected = selectValueInDropdown(setLocationInputs.get(setLocationNumber), setLocation);
		Assert.assertTrue(isSelected,String.format("'%s' is not selected in Location dropdown",setLocation));
		Runnable store = ()->{
			List<LocationRecord> locations = Constants.getLocation();
			while(locations.size() <= setLocationNumber) {
				locations.add(new LocationRecord());
			}
			String oldSetLocation = locations.get(setLocationNumber).getLocation();
			locations.get(setLocationNumber).setLocation(setLocation);
			if(isEditMode(mode)) {
				if(oldSetLocation == null) {
					Constants.getLog().getLogs().putLog("Changed Set Location Section:", 
							String.format(" Set Location: %s", setLocation));
					changeRequestStatusToModified();
				}
				else if(!oldSetLocation.equalsIgnoreCase(setLocation)) {
					Constants.getLog().getLogs().putLog("Changed Set Location Section:", 
							String.format(" Set Location: %s → %s", oldSetLocation,setLocation));
					changeRequestStatusToModified();
				}
			}
		};
		executeStorage(String.format("Set Location %d", setLocationNumber),store,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public void selectControlRoomLocation(String location, String position,RequestMode...mode) {
		if(location == null || position == null) {
			return;
		}
		// 0-based position
		Integer locationNumber = Integer.parseInt(position);
		Boolean isSelected = selectValueInDropdown(controlRoomLocationInputs.get(locationNumber), location);
		Assert.assertTrue(isSelected,String.format("'%s' is not selected in Control Room Location dropdown",location));
		Runnable store = ()->{
			List<ControlRoomAndCrewRecord> locations = Constants.getControlRoomAndCrew();
			while(locations.size() <= locationNumber) {
				locations.add(new ControlRoomAndCrewRecord());
			}
			String oldLocation = locations.get(locationNumber).getControlRoomLocation();
			locations.get(locationNumber).setControlRoomLocation(location);
			if(isEditMode(mode)) {
				if(oldLocation == null) {
					Constants.getLog().getLogs().putLog("Changed Control Room Section:", 
							String.format(" Location: %s", location));
					changeRequestStatusToModified();
				}
				else if(!oldLocation.equalsIgnoreCase(location)) {
					Constants.getLog().getLogs().putLog("Changed Control Room Section:", 
							String.format(" Location: %s → %s", oldLocation,location));
					changeRequestStatusToModified();
				}
			}
		};
		executeStorage(String.format("Control Room Location %d", locationNumber),store,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public void addControlRoom(){
		try {
			WebAction.scrollIntoViewTillBottom(addControlRoomButton);
			addControlRoomButton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void selectControlRoom(String controlRoom, String position,RequestMode...mode) {
		// 0-based position
		Integer controlRoomNumber = Integer.parseInt(position);
		Boolean isSelected = selectValueInDropdown(controlRoomInputs.get(controlRoomNumber), controlRoom);
		Assert.assertTrue(isSelected,String.format("'%s' is not selected in Control Room dropdown",controlRoom));
		Runnable store = ()->{
			List<ControlRoomAndCrewRecord> locations = Constants.getControlRoomAndCrew();
			while(locations.size() <= controlRoomNumber) {
				locations.add(new ControlRoomAndCrewRecord());
			}
			String oldControlRoom = locations.get(controlRoomNumber).getControlRoom();
			locations.get(controlRoomNumber).setControlRoom(controlRoom);
			if(isEditMode(mode)) {
				if(oldControlRoom == null) {
					Constants.getLog().getLogs().putLog("Changed Control Room Section:", 
							String.format(" Set Location: %s", controlRoom));
					changeRequestStatusToModified();
				}
				else if(!oldControlRoom.equalsIgnoreCase(controlRoom)) {
					Constants.getLog().getLogs().putLog("Changed Control Room Section:", 
							String.format(" Set Location: %s → %s", oldControlRoom,controlRoom));
					changeRequestStatusToModified();
				}
			}
		};
		executeStorage(String.format("Control Room %d", controlRoomNumber),store,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public String changeNameAccordingToLogForSetCrew(String op2) {
		String option = op2;
		if(op2.equalsIgnoreCase("Monitor Mix -Foldback")) {
			option = "Foldback";
		}
		else if(op2.equalsIgnoreCase("Front of House Mix")) {
			option = "FOH";
		}
		else if(op2.equalsIgnoreCase("Audio Boom Op")) {
			option = "Audio Boom Ped";
		}
		return option;
	}
	public void putSetCrewRemovalLog(CrewRecord old) {
		String option = changeNameAccordingToLogForSetCrew(old.getCrewName());
		if(option.equals("Plaza Productions Op")){
			if(!Constants.getLog().getLogs().containsSectionLog("Changed Set Crew Section:")) {
				Constants.getLog().getLogs().putLog("Changed Set Crew Section",null);
			}
		}
		else {
			Constants.getLog().getLogs().removeLogStartingWith("Changed Set Crew Section",null);
			Constants.getLog().getLogs().putLog("Changed Set Crew Section:",
					String.format("%s: removed , Count: %d → 0", option.toUpperCase(),old.getNumber()));
		}
	}
	public void putSetCrewAdditionLog(CrewRecord updated,List<String> checkList,Boolean makeupOrHairStylistPresentAlready) {
		String option = changeNameAccordingToLogForSetCrew(updated.getCrewName());
		if(option.equals("Plaza Productions Op")){
			if(!Constants.getLog().getLogs().containsSectionLog("Changed Set Crew Section:")) {
				Constants.getLog().getLogs().putLog("Changed Set Crew Section",null);
			}
		}
		else {
			Constants.getLog().getLogs().removeLogStartingWith("Changed Set Crew Section",null);
			Constants.getLog().getLogs().putLog("Changed Set Crew Section:", 
					String.format(" %s: added , Count: 0 → %d",option.toUpperCase(),updated.getNumber()));
			if(checkList.contains(updated.getCrewName()) && !makeupOrHairStylistPresentAlready) {
				Constants.getLog().getLogs().putLog("Changed Hair/MU/WR",null);
			}
		}
	}
	public void putSetCrewUpdationLog(CrewRecord old,CrewRecord updated) {
		int oldQty = old.getNumber();
		int newQty = updated.getNumber();
		if(oldQty != newQty) {
			String option = changeNameAccordingToLogForSetCrew(old.getCrewName());
			if(option.equals("Plaza Productions Op")){
				if(!Constants.getLog().getLogs().containsSectionLog("Changed Set Crew Section:")) {
					Constants.getLog().getLogs().putLog("Changed Set Crew Section",null);
				}
			}
			else {
			Constants.getLog().getLogs().removeLogStartingWith("Changed Set Crew Section",null);
			Constants.getLog().getLogs().putLog("Changed Set Crew Section:", 
					String.format(" %s: changed , Count: %d → %d",option.toUpperCase(),oldQty,newQty));
			}
		}
	}
	public void putSetCrewRunnables(RequestMode...mode) {
		List<CrewRecord> existing =new ArrayList<>(); 
		Constants.getSetCrew().forEach((crew)->existing.add(crew.copy()));
		// is Makeup Artist or Hair Stylist already present in set crew before this method changes
		List<String> checkList = Arrays.asList("Hair Stylist","Makeup Artist","Wardrobe Dresser");
		Boolean makeupOrHairStylistPresentAlready = existing.stream()
							.filter((crew)->checkList.contains(crew.getCrewName())).findAny().isPresent();
		Runnable store = ()->{
			if(isEditMode(mode)) {
				// sorting the lists
				Comparator<CrewRecord> comparator=(o1,o2)->{
					return o1.getCrewName().compareTo(o2.getCrewName());
				};
				List<CrewRecord> updatedCrews = Constants.getSetCrew();
				Collections.sort(existing, comparator);
				Collections.sort(updatedCrews,comparator);
				
				// capturing the change logs
				int counter1=0,counter2=0;
				int size1=existing.size(),size2=updatedCrews.size();
				while(counter1 < size1 && counter2 < size2) {
					CrewRecord old = existing.get(counter1);
					CrewRecord updated = updatedCrews.get(counter2);
					int comparison=old.getCrewName().compareTo(updated.getCrewName());
					if(comparison < 0) {
						putSetCrewRemovalLog(old);
						++counter1;
					}
					else if(comparison > 0) {
						putSetCrewAdditionLog(updated,checkList,makeupOrHairStylistPresentAlready);
						++counter2;
					}
					else if(comparison == 0) {
						putSetCrewUpdationLog(old, updated);
						++counter1;
						++counter2;
					}
				}
				while(counter1 < size1) {
					putSetCrewRemovalLog(existing.get(counter1));
					++counter1;
				}
				while(counter2 < size2) {
					putSetCrewAdditionLog(updatedCrews.get(counter2),checkList
							,makeupOrHairStylistPresentAlready);
					++counter2;
				}
				changeRequestStatusToModified();
			}
		};
		executeStorage("Set Crew",store,mode);
	}
	public void selectSetCrew(String crewNames,RequestMode... mode) {
		if(crewNames == null) {
			return;
		}
		Consumer<String> selectCrewCons = (op) -> {
			final String op2 = new String(op.trim());
			Assert.assertTrue(selectValueInDropdown(setCrewInput, op2),String.format("%s not selected in Set Crew", op2));
			Runnable store = ()->{
				Constants.getSetCrew().add(new CrewRecord(op2,1));
			};
			executeStorage(op2,store,mode);
		};
		Arrays.asList(crewNames.split(",")).forEach(selectCrewCons);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
		putSetCrewRunnables(mode);
	}
	/*
	 * this method needs to either run when the crew is already added via selectSetCrew method
	 */
	public void changeQuantitiesOfSetCrew(String namesWithQuantities, RequestMode... mode) throws Exception {
		if(namesWithQuantities == null) {
			return;
		}
		Map<String,Integer> crewMap=new HashMap<>();
		// nameWithQuantities in the format of name=quantity,name=quantity
		Arrays.asList(namesWithQuantities.split(",")).forEach((nameWithQuantity)->{
			String[] parts=nameWithQuantity.split("=");
			crewMap.put(parts[0].trim(),Integer.parseInt(parts[1].trim()));
		});
		Set<String> names = crewMap.keySet();
		for(String name : names) {
			int quantity = crewMap.get(name);
			int size = displayedSetCrewNamesInEditMode.size();
			for(int itr=0; itr < size; ++itr) {
				String displayedName = getText(displayedSetCrewNamesInEditMode.get(itr)).trim();
				if(displayedName.equals(name)) {
					changeCrewQuantity(displayedSetCrewNamesInEditMode,displayedSetCrewInputsInEditMode,itr,quantity);
					Runnable store = ()->{
						Optional<CrewRecord> crew=Constants.getSetCrew().stream()
								.filter((crewRec)->crewRec.getCrewName().equals(name)).findAny();
						if(crew.isPresent()) {
							crew.get().setNumber(quantity);
						}
						else {
							Constants.getSetCrew().add(new CrewRecord(name,quantity));
						}
					};
					executeStorage(name,store,mode);
					break;
				}
			}
		}
		putSetCrewRunnables(mode);
	}
	public void removeSpecificSetCrews(String crewNames,RequestMode...mode) throws Exception {
		if(crewNames == null) {
			return;
		}
		Set<String> crewsToRemove = new HashSet<>();
		Arrays.asList(crewNames.split(",")).forEach((c)->crewsToRemove.add(c.trim()));
		Iterator<WebElement> removeIconIterator=selectedSetCrewRemovalIcons.iterator();
		Iterator<WebElement> setCrewNamesIterator = selectedSetCrewNames.iterator();
		while(setCrewNamesIterator.hasNext()) {
			WebElement nameEle = setCrewNamesIterator.next();
			WebElement removeEle = removeIconIterator.next();
			String displayedName = getText(nameEle);
			if(crewsToRemove.contains(displayedName)) {
				WebAction.scrollIntoViewTillBottom(removeEle);
				Thread.sleep(2000);
				WebAction.click(removeEle);
				Runnable store = ()->{
					Optional<CrewRecord> optional = Constants.getSetCrew().stream()
							.filter((crew)->crew.getCrewName().equals(displayedName))
							.findAny();
					if(optional.isPresent()) {
						Constants.getSetCrew().remove(optional.get());
					}
				};
				executeStorage(displayedName,store,mode);
			}
		}
		putSetCrewRunnables(mode);
	}
	public String changeNameAccordingToLogForControlRoomCrew(String op2) {
		String option = op2;
		if(op2.equalsIgnoreCase("A1 Production Mix")) {
			option = "A1";
		}
		else if(op2.equalsIgnoreCase("CR AUDIO ASSIST - TX")) {
			option = "CR AUDIO ASSIST / TX";
		}
		return option;
	}
	public void putControlRoomCrewRemovalLog(CrewRecord old) {
		String option = changeNameAccordingToLogForControlRoomCrew(old.getCrewName());
		Constants.getLog().getLogs().removeLogStartingWith("Changed Control Room Crew Section",null);
		Constants.getLog().getLogs().putLog("Changed Control Room Crew Section:",
				String.format("%s: removed , Count: %d → 0", option.toUpperCase(),old.getNumber()));
	}
	public void putControlRoomCrewAdditionLog(CrewRecord updated) {
		String option = changeNameAccordingToLogForControlRoomCrew(updated.getCrewName());
		Constants.getLog().getLogs().removeLogStartingWith("Changed Control Room Crew Section",null);
		Constants.getLog().getLogs().putLog("Changed Control Room Crew Section:", 
				String.format(" %s: added , Count: 0 → %d",option.toUpperCase(),updated.getNumber()));
		if(option.equalsIgnoreCase("Video Playback")) {
			Constants.getLog().getLogs().putLog("Changed DPS PlayBack", null);
		}
	}
	public void putControlRoomCrewUpdationLog(CrewRecord old,CrewRecord updated) {
		int oldQty = old.getNumber();
		int newQty = updated.getNumber();
		if(oldQty != newQty) {
			String option = changeNameAccordingToLogForControlRoomCrew(old.getCrewName());
			Constants.getLog().getLogs().removeLogStartingWith("Changed Control Room Crew Section",null);
			Constants.getLog().getLogs().putLog("Changed Control Room Crew Section:", 
					String.format(" %s: changed , Count: %d → %d",option.toUpperCase(),oldQty,newQty));
		}
	}
	public void putControlRoomCrewRunnables(RequestMode...mode) {
		List<CrewRecord> existing =new ArrayList<>(); 
		Constants.getControlRoomCrew().forEach((crew)->existing.add(crew.copy()));
		Runnable store = ()->{
			if(isEditMode(mode)) {
				// sorting the lists
				Comparator<CrewRecord> comparator=(o1,o2)->{
					return o1.getCrewName().compareTo(o2.getCrewName());
				};
				List<CrewRecord> updatedCrews = Constants.getControlRoomCrew();
				Collections.sort(existing, comparator);
				Collections.sort(updatedCrews,comparator);
				
				// capturing the change logs
				int counter1=0,counter2=0;
				int size1=existing.size(),size2=updatedCrews.size();
				while(counter1 < size1 && counter2 < size2) {
					CrewRecord old = existing.get(counter1);
					CrewRecord updated = updatedCrews.get(counter2);
					int comparison=old.getCrewName().compareTo(updated.getCrewName());
					if(comparison < 0) {
						putControlRoomCrewRemovalLog(old);
						++counter1;
					}
					else if(comparison > 0) {
						putControlRoomCrewAdditionLog(updated);
						++counter2;
					}
					else if(comparison == 0) {
						putControlRoomCrewUpdationLog(old, updated);
						++counter1;
						++counter2;
					}
				}
				while(counter1 < size1) {
					putControlRoomCrewRemovalLog(existing.get(counter1));
					++counter1;
				}
				while(counter2 < size2) {
					putControlRoomCrewAdditionLog(updatedCrews.get(counter2));
					++counter2;
				}
				changeRequestStatusToModified();
			}
		};
		executeStorage("Control Room Crew",store,mode);
	}
	public void selectControlRoomCrew(String crewNames,RequestMode... mode) {
		if(crewNames == null) {
			return;
		}
		Consumer<String> selectCrewCons = (op) -> {
			final String op2 = new String(op.trim());
			Assert.assertTrue(selectValueInDropdown(controlRoomCrewInput, op2),String.format("%s not selected in Control Room Crew", op2));
			Runnable store = ()->{
				Constants.getControlRoomCrew().add(new CrewRecord(op2,1));
			};
			executeStorage(op2,store,mode);
		};
		Arrays.asList(crewNames.split(",")).forEach(selectCrewCons);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
		putControlRoomCrewRunnables(mode);
	}
	/*
	 * this method needs to either run when the crew is already added via selectSetCrew method
	 */
	public void changeQuantitiesOfControlRoomCrew(String namesWithQuantities, RequestMode... mode) throws Exception {
		if(namesWithQuantities == null) {
			return;
		}
		Map<String,Integer> crewMap=new HashMap<>();
		// nameWithQuantities in the format of name=quantity,name=quantity
		Arrays.asList(namesWithQuantities.split(",")).forEach((nameWithQuantity)->{
			String[] parts=nameWithQuantity.split("=");
			crewMap.put(parts[0].trim(),Integer.parseInt(parts[1].trim()));
		});
		Set<String> names = crewMap.keySet();
		for(String name : names) {
			int quantity = crewMap.get(name);
			int size = displayedControlRoomCrewNamesInEditMode.size();
			for(int itr=0; itr < size; ++itr) {
				String displayedName = getText(displayedControlRoomCrewNamesInEditMode.get(itr)).trim();
				if(displayedName.equals(name)) {
					changeCrewQuantity(displayedControlRoomCrewNamesInEditMode,displayedControlRoomCrewInputsInEditMode,itr,quantity);
					Runnable store = ()->{
						Optional<CrewRecord> crew=Constants.getControlRoomCrew().stream()
								.filter((crewRec)->crewRec.getCrewName().equals(name)).findAny();
						if(crew.isPresent()) {
							crew.get().setNumber(quantity);
						}
						else {
							Constants.getControlRoomCrew().add(new CrewRecord(name,quantity));
						}
					};
					executeStorage(name,store,mode);
					break;
				}
			}
		}
		putControlRoomCrewRunnables(mode);
	}
	public void removeSpecificControlRoomCrews(String crewNames,RequestMode...mode) throws Exception {
		if(crewNames == null) {
			return;
		}
		Set<String> crewsToRemove = new HashSet<>();
		Arrays.asList(crewNames.split(",")).forEach((c)->crewsToRemove.add(c.trim()));
		Iterator<WebElement> removeIconIterator=selectedControlRoomCrewRemovalIcons.iterator();
		Iterator<WebElement> setCrewNamesIterator = selectedControlRoomCrewNames.iterator();
		while(setCrewNamesIterator.hasNext()) {
			WebElement nameEle = setCrewNamesIterator.next();
			WebElement removeEle = removeIconIterator.next();
			String displayedName = getText(nameEle);
			if(crewsToRemove.contains(displayedName)) {
				WebAction.scrollIntoViewTillBottom(removeEle);
				Thread.sleep(2000);
				WebAction.click(removeEle);
				Runnable store = ()->{
					Optional<CrewRecord> optional = Constants.getControlRoomCrew().stream()
							.filter((crew)->crew.getCrewName().equals(displayedName))
							.findAny();
					if(optional.isPresent()) {
						Constants.getControlRoomCrew().remove(optional.get());
					}
				};
				executeStorage(displayedName,store,mode);
			}
		}
		putControlRoomCrewRunnables(mode);
	}
	public void selectCaptureManager(String choice,RequestMode...mode) {
		selectRadioOption(choice, captureManagerRadioLabels);
		Runnable store = ()->{
			String old = Constants.getCaptureManager();
			Constants.setCaptureManager(choice);
			if(isEditMode(mode)) {
				if(old == null || !old.equalsIgnoreCase(choice)) {
					changeRequestStatusToModified();
					if(!Constants.getLog().getLogs().containsSectionLog("Changed Control Room Crew Section:")) {
						Constants.getLog().getLogs().putLog("Changed Control Room Crew Section",null);
					}
					if(choice.equalsIgnoreCase("Yes")) {
						Constants.getLog().getLogs().putLog("Completed Capture Manager",null);
					}
				}
			}
		};
		executeStorage("Capture Manager",store,mode);
	}
	public void putAdditionalCrewRemovalLog(CrewRecord old) {
		Constants.getLog().getLogs().putLog("Changed Additional Crew Section:",
				String.format("%s: removed , Count: %d → 0", old.getCrewName().toUpperCase(),old.getNumber()));
	}
	public void putAdditionalCrewAdditionLog(CrewRecord updated) {
		String name = updated.getCrewName();
		Constants.getLog().getLogs().putLog("Changed Additional Crew Section:", 
				String.format(" %s: added , Count: 0 → %d",name.toUpperCase(),updated.getNumber()));
		if(name.equalsIgnoreCase("Studio Maintenance")) {
			Constants.getLog().getLogs().putLog("Completed Studio Maintenance", null);
		}
	}
	public void putAdditionalCrewUpdationLog(CrewRecord old,CrewRecord updated) {
		String name = old.getCrewName();
		int oldQty = old.getNumber();
		int newQty = updated.getNumber();
		if(oldQty != newQty) {
			Constants.getLog().getLogs().putLog("Changed Additional Crew Section:", 
					String.format(" %s: changed , Count: %d → %d",name.toUpperCase(),oldQty,newQty));
		}
	}
	public void putAdditionalCrewRunnables(RequestMode...mode) {
		List<CrewRecord> existing =new ArrayList<>(); 
		Constants.getAdditionalCrew().forEach((crew)->existing.add(crew.copy()));
		Runnable store = ()->{
			if(isEditMode(mode)) {
				// sorting the lists
				Comparator<CrewRecord> comparator=(o1,o2)->{
					return o1.getCrewName().compareTo(o2.getCrewName());
				};
				List<CrewRecord> updatedCrews = Constants.getAdditionalCrew();
				Collections.sort(existing, comparator);
				Collections.sort(updatedCrews,comparator);
				
				// capturing the change logs
				int counter1=0,counter2=0;
				int size1=existing.size(),size2=updatedCrews.size();
				while(counter1 < size1 && counter2 < size2) {
					CrewRecord old = existing.get(counter1);
					CrewRecord updated = updatedCrews.get(counter2);
					int comparison=old.getCrewName().compareTo(updated.getCrewName());
					if(comparison < 0) {
						putAdditionalCrewRemovalLog(old);
						++counter1;
					}
					else if(comparison > 0) {
						putAdditionalCrewAdditionLog(updated);
						++counter2;
					}
					else if(comparison == 0) {
						putAdditionalCrewUpdationLog(old, updated);
						++counter1;
						++counter2;
					}
				}
				while(counter1 < size1) {
					putAdditionalCrewRemovalLog(existing.get(counter1));
					++counter1;
				}
				while(counter2 < size2) {
					putAdditionalCrewAdditionLog(updatedCrews.get(counter2));
					++counter2;
				}
				changeRequestStatusToModified();
			}
		};
		executeStorage("Additional Crew",store,mode);
	}
	public void selectAdditionalCrewOnRockCenter(String crewNames,RequestMode... mode) {
		if(crewNames == null) {
			return;
		}
		Consumer<String> selectCrewCons = (op) -> {
			final String op2 = new String(op.trim());
			Assert.assertTrue(selectValueInDropdown(additionalCrewInput, op2),String.format("%s not selected in Additional Crew", op2));
			Runnable store = ()->{
				Constants.getAdditionalCrew().add(new CrewRecord(op2,1));
			};
			executeStorage(op2,store,mode);
		};
		Arrays.asList(crewNames.split(",")).forEach(selectCrewCons);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
		putAdditionalCrewRunnables(mode);
	}
	public void changeCrewQuantity(List<WebElement> crewNames,List<WebElement> crewInputs,int itr,int quantity) throws Exception {
		WebElement nameElement = crewNames.get(itr);
		WebAction.scrollIntoViewTillBottom(nameElement);
		WebAction.click(nameElement);
		Thread.sleep(1000);
		int trials=5;
		String qty = Integer.toString(quantity);
		while(trials-- > 0) {
			WebElement inputElement = crewInputs.get(itr);
			try {
				WebAction.clearInputOneCharAtTime(inputElement);
				inputElement.sendKeys(qty);
			}
			catch(Exception e) {
				;
			}
			finally {
				String value = WebAction.getAttribute(inputElement, "value");
				if(value.equals(qty)) {
					break;
				}
			}
		}
	}
	/*
	 * this method needs to either run when the crew is already added via selectSetCrew method
	 */
	public void changeQuantitiesOfAdditionalCrew(String namesWithQuantities, RequestMode... mode) throws Exception {
		if(namesWithQuantities == null) {
			return;
		}
		
		Map<String,Integer> crewMap=new HashMap<>();
		// nameWithQuantities in the format of name=quantity,name=quantity
		Arrays.asList(namesWithQuantities.split(",")).forEach((nameWithQuantity)->{
			String[] parts=nameWithQuantity.split("=");
			crewMap.put(parts[0].trim(),Integer.parseInt(parts[1].trim()));
		});
		Set<String> names = crewMap.keySet();
		for(String name : names) {
			int quantity = crewMap.get(name);
			int size = displayedAdditionalCrewNamesInEditMode.size();
			for(int itr=0; itr < size; ++itr) {
				String displayedName = getText(displayedAdditionalCrewNamesInEditMode.get(itr)).trim();
				if(displayedName.equals(name)) {
					changeCrewQuantity(displayedAdditionalCrewNamesInEditMode,displayedAdditionalCrewInputsInEditMode,itr,quantity);
					Runnable store = ()->{
						Optional<CrewRecord> crew=Constants.getAdditionalCrew().stream()
								.filter((crewRec)->crewRec.getCrewName().equals(name)).findAny();
						if(crew.isPresent()) {
							crew.get().setNumber(quantity);
						}
						else {
							Constants.getAdditionalCrew().add(new CrewRecord(name,quantity));
						}
					};
					executeStorage(name,store,mode);
					break;
				}
			}
		}
		putAdditionalCrewRunnables(mode);
	}
	public void removeSpecificAdditionalCrews(String crewNames,RequestMode...mode) throws Exception {
		if(crewNames == null) {
			return;
		}
		Set<String> crewsToRemove = new HashSet<>();
		Arrays.asList(crewNames.split(",")).forEach((c)->crewsToRemove.add(c.trim()));
		Iterator<WebElement> removeIconIterator=selectedAdditionalCrewRemovalIcons.iterator();
		Iterator<WebElement> setCrewNamesIterator = selectedAdditionalCrewNames.iterator();
		while(setCrewNamesIterator.hasNext()) {
			WebElement nameEle = setCrewNamesIterator.next();
			WebElement removeEle = removeIconIterator.next();
			String displayedName = getText(nameEle);
			if(crewsToRemove.contains(displayedName)) {
				WebAction.scrollIntoViewTillBottom(removeEle);
				Thread.sleep(2000);
				WebAction.click(removeEle);
				Runnable store = ()->{
					Optional<CrewRecord> optional = Constants.getAdditionalCrew().stream()
							.filter((crew)->crew.getCrewName().equals(displayedName))
							.findAny();
					if(optional.isPresent()) {
						Constants.getAdditionalCrew().remove(optional.get());
					}
				};
				executeStorage(displayedName,store,mode);
			}
		}
		putAdditionalCrewRunnables(mode);
	}
	public void selectTpmTmName(String name,RequestMode...mode) {
		if(name == null) {
			return;
		}
		tpmTmNameInput.clear();
		tpmTmNameInput.sendKeys(name);
		Runnable store = ()->{
			String old = Constants.getTpmOrTmInformation().getTpmOrTmName();
			if(isEditMode(mode) && (old == null || !old.equalsIgnoreCase(name))) {
				Constants.getLog().getLogs().putLog("Changed TPM/TM Information Section",null);
				changeRequestStatusToModified();
			}
			Constants.getTpmOrTmInformation().setTpmOrTmName(name);
		};
		executeStorage("TPM/TM Name",store,mode);
	}
	public void changeSameAsRequester(String choice,RequestMode...mode) {
		if(choice == null) {
			return;
		}
		if(choice.equalsIgnoreCase("Yes")) {
			selectSameAsRequester(mode);
		}
		else {
			uncheckSameAsRequester(mode);
		}
	}
	public void selectSameAsRequester(RequestMode...mode) {
		scrollIntoView(sameAsRequesterCheckbox);
		if (!sameAsRequesterCheckbox.isSelected()) {
			sameAsRequesterCheckbox.click();
			Runnable store = ()->{
				if(isEditMode(mode)) {
					Constants.getLog().getLogs().putLog("Changed TPM/TM Information Section",null);
					changeRequestStatusToModified();
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
					changeRequestStatusToModified();
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
	public void selectIsATpmOrTmNeeded(String choice,RequestMode...mode) {
		selectRadioOption(choice, isATpmOrTmNeededRadioLabels);
		Runnable store = ()->{
			String old = Constants.getTpmOrTmInformation().getIsATpmOrTmNeeded();
			if(old == null) {
				old="No";
			}
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
				changeRequestStatusToModified();
			}
		};
		executeStorage("Is a TPM or TM Needed",store,mode);
	}
	public void selectIsStagingNeeded(String choice,RequestMode...mode) {
		selectRadioOption(choice, isStagingNeededRadioLabels);
		Runnable store = ()->{
			String old = Constants.getIsStagingNeeded();
			if(old == null) {
				old="No";
			}
			Constants.setIsStagingNeeded(choice);
			if(choice.equalsIgnoreCase("No")) {
				Constants.setIsLightingNeeded(null);
				Constants.setIsCarpentryNeeded(null);
				Constants.setArePropsNeeded(null);
			}
			if(isEditMode(mode) && old != null && !old.equalsIgnoreCase(choice)) {
				Constants.getLog().getLogs().putLog("Changed Staging Section",null);
				if(choice.equalsIgnoreCase("Yes")) {
					Constants.getLog().getLogs().putLog("Changed Staging",null);
				}
				changeRequestStatusToModified();
			}
		};
		executeStorage("Is Staging Needed",store,mode);
	}
	public void selectIsLightingNeeded(String choice,RequestMode...mode) {
		selectRadioOption(choice, isLightingNeededRadioLabels);
		Runnable store = ()->{
			String old = Constants.getIsLightingNeeded();
			Constants.setIsLightingNeeded(choice);
			if(isEditMode(mode) && (old == null || !old.equalsIgnoreCase(choice))) {
				Constants.getLog().getLogs().putLog("Changed Staging Section",null);
				changeRequestStatusToModified();
			}
		};
		executeStorage("Is Lighting Needed",store,mode);
	}
	public void selectIsCarpentryNeeded(String choice,RequestMode...mode) {
		selectRadioOption(choice, isCarpentryNeededRadioLabels);
		Runnable store = ()->{
			String old = Constants.getIsCarpentryNeeded();
			Constants.setIsCarpentryNeeded(choice);
			if(isEditMode(mode) && (old == null || !old.equalsIgnoreCase(choice))) {
				Constants.getLog().getLogs().putLog("Changed Staging Section",null);
				changeRequestStatusToModified();
			}
		};
		executeStorage("Is Carpentry Needed",store,mode);
	}
	public void selectArePropsNeeded(String choice,RequestMode...mode) {
		selectRadioOption(choice, arePropsNeededRadioLabels);
		Runnable store = ()->{
			String old = Constants.getArePropsNeeded();
			Constants.setArePropsNeeded(choice);
			if(isEditMode(mode) && (old == null || !old.equalsIgnoreCase(choice))) {
				Constants.getLog().getLogs().putLog("Changed Staging Section",null);
				changeRequestStatusToModified();
			}
		};
		executeStorage("Are Props Needed",store,mode);
	}
	public void provideDescribeStagingNeeds(String notes,RequestMode...mode) {
		if(notes == null) {
			return;
		}
		describeStagingNeedsInput.clear();
		describeStagingNeedsInput.sendKeys(notes);
		Runnable store = ()->{
			String old = Constants.getDescribeStagingNeeds();
			if(isEditMode(mode) && (old == null || !old.equals(notes))) {
				Constants.getLog().getLogs().putLog("Changed Staging Section",null);
				changeRequestStatusToModified();
			}
			Constants.setDescribeStagingNeeds(notes);
		};
		executeStorage("Describe Staging Needs",store,mode);
	}
	public void provideSystemNotes(String notes,RequestMode...mode) {
		if(notes == null) {
			return;
		}
		systemNotesInput.clear();
		systemNotesInput.sendKeys(notes);
		Runnable store = ()->{
			String old = Constants.getSystemNotes();
			if(isEditMode(mode) && (old == null || !old.equals(notes))) {
				if(!Constants.getLog().getLogs().containsSectionLog("Changed System Section:")) {
					Constants.getLog().getLogs().putLog("Changed System Section",null);
				}
				changeRequestStatusToModified();
			}
			Constants.setSystemNotes(notes);
		};
		executeStorage("System notes",store,mode);
	}
	public void selectUltimatte(String qty,RequestMode...mode) {
		if(qty == null) {
			return;
		}
		WebAction.clearInputOneCharAtTime(ultimatteInput);
		ultimatteInput.sendKeys(qty);
		Runnable store = ()->{
			String old = Constants.getUltimatte();
			Constants.setUltimatte(qty);
			if(isEditMode(mode)) {
				if(old == null) {
					old="0";
				}
				if(!old.equals(qty)) {
					Constants.getLog().getLogs().removeLogStartingWith("Changed System Section", null);
					if(old.equals("0")) {
						Constants.getLog().getLogs().putLog("Changed System Section:",
								String.format("Ultimatte: added , Count: 0 → %s",qty));
					}
					else if(qty.equals("0")) {
						Constants.getLog().getLogs().putLog("Changed System Section:",
								String.format("Ultimatte: removed , Count: %s → 0",old));
					}
					else {
						Constants.getLog().getLogs().putLog("Changed System Section:",
								String.format("Ultimatte: changed , Count: %s → %s",old,qty));
					}
					changeRequestStatusToModified();
				}
			}
		};
		executeStorage("Ultimatte",store,mode);
	}
	public void selectVoiceActivatedPrompter(String qty,RequestMode...mode) {
		if(qty == null) {
			return;
		}
		WebAction.clearInputOneCharAtTime(voiceActivatedPrompterInput);
		voiceActivatedPrompterInput.sendKeys(qty);
		Runnable store = ()->{
			String old = Constants.getVoiceActivatedPrompter();
			if(isEditMode(mode)) {
				if(old == null) {
					old="0";
				}
				if(!old.equals(qty)) {
					Constants.getLog().getLogs().removeLogStartingWith("Changed System Section", null);
					if(old.equals("0")) {
						Constants.getLog().getLogs().putLog("Changed System Section:",
								String.format("Voice Activated Prompter: added , Count: 0 → %s",qty));
					}
					else if(qty.equals("0")) {
						Constants.getLog().getLogs().putLog("Changed System Section:",
								String.format("Voice Activated Prompter: removed , Count: %s → 0",old));
					}
					else {
						Constants.getLog().getLogs().putLog("Changed System Section:",
								String.format("Voice Activated Prompter: changed , Count: %s → %s",old,qty));
					}
					changeRequestStatusToModified();
				}
			}
			Constants.setVoiceActivatedPrompter(qty);
		};
		executeStorage("Voice Activated Prompter",store,mode);
	}
	public void selectAddressOnSetLocation(String address,String position,RequestMode...mode) {
		if(address == null) {
			return;
		}
		Integer locationNumber = Integer.parseInt(position);
		int addressElementIndex = -1;
		for(int itr=0; itr < displayedLocationValues.size() && itr < locationNumber; ++itr) {
			if(getText(displayedLocationValues.get(itr)).trim().equals("Field")) {
				++addressElementIndex;
			}
		}
		Assert.assertTrue(addressElementIndex >= 0, "Could not find an Address input in the Set Location section at position "+locationNumber);
		addressInputInSetLocationSection.get(addressElementIndex).clear();
		addressInputInSetLocationSection.get(addressElementIndex).sendKeys(address);
		Runnable store = ()->{
			List<LocationRecord> locations = Constants.getLocation();
			while(locations.size() < locationNumber) {
				locations.add(new LocationRecord());
			}
			String oldAddress = locations.get(locationNumber).getAddress();
			locations.get(locationNumber).setSetLocation(null);
			locations.get(locationNumber).setAddress(address);
			if(isEditMode(mode)) {
				if(oldAddress == null) {
					Constants.getLog().getLogs().putLog("Changed Set Location Section:", 
							String.format(" Address: → %s", address));
					changeRequestStatusToModified();
				}
				else if(!oldAddress.equalsIgnoreCase(address)) {
					Constants.getLog().getLogs().putLog("Changed Set Location Section:", 
							String.format(" Address: %s → %s", oldAddress,address));
					changeRequestStatusToModified();
				}
			}
		};
		executeStorage(String.format("Set Location Address %d",addressElementIndex),store,mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public void clearControlRoomCrew(RequestMode...mode) throws Exception {
		tryClearing(clearIconForControlRoomCrew,selectedControlRoomCrewNames);
		Iterator<CrewRecord> crewIterator = Constants.getControlRoomCrew().iterator();
		while(crewIterator.hasNext()) {
			CrewRecord crew = crewIterator.next();
			String crewName = crew.getCrewName();
			Runnable store = ()->{
				Constants.getControlRoomCrew().remove(crew);
			};
			executeStorage(crewName,store,mode);
		}
		putControlRoomCrewRunnables(mode);
	}
	public void clearSetCrew(RequestMode...mode) throws Exception {
		tryClearing(clearIconForSetCrew,selectedSetCrewNames);
		Iterator<CrewRecord> crewIterator = Constants.getSetCrew().iterator();
		while(crewIterator.hasNext()) {
			CrewRecord crew = crewIterator.next();
			String crewName = crew.getCrewName();
			Runnable store = ()->{
				Constants.getSetCrew().remove(crew);
			};
			executeStorage(crewName,store,mode);
		}
		putSetCrewRunnables(mode);
	}
	public void clearAdditionalCrew(RequestMode...mode) throws Exception {
		tryClearing(clearIconForAdditionalCrew,selectedAdditionalCrewNames);
		Iterator<CrewRecord> crewIterator = Constants.getAdditionalCrew().iterator();
		while(crewIterator.hasNext()) {
			CrewRecord crew = crewIterator.next();
			String crewName = crew.getCrewName();
			Runnable store = ()->{
				Constants.getAdditionalCrew().remove(crew);
			};
			executeStorage(crewName,store,mode);
		}
		putAdditionalCrewRunnables(mode);
	}
	public void clearDetailsAndNotes(RequestMode...mode) {
		WebAction.clearInputOneCharAtTime(detailsAndNotesInput);
		Runnable store = ()->{
			String old = Constants.getDetailsAndNotes();
			if(isEditMode(mode) && old != null) {
				Constants.getLog().getLogs().putLog("Changed Production Purpose Section",null);
				changeRequestStatusToModified();
			}
			Constants.setDetailsAndNotes(null);
		};
		executeStorage("Details and Notes",store,mode);
	}
//	public void selectAddressOnSetLocation(String address,String position,RequestMode...mode) {
//		if(address == null) {
//			return;
//		}
//		Integer locationNumber = Integer.parseInt(position);
//		int addressElementIndex = -1;
//		for(int itr=0; itr < displayedLocationValues.size() && itr < locationNumber; ++itr) {
//			if(getText(displayedLocationValues.get(itr)).trim().equals("Field")) {
//				++addressElementIndex;
//			}
//		}
//		Assert.assertTrue(addressElementIndex >= 0, "Could not find an Address input in the Set Location section at position "+locationNumber);
//		addressInputInSetLocationSection.get(addressElementIndex).clear();
//		addressInputInSetLocationSection.get(addressElementIndex).sendKeys(address);
//		Runnable store = ()->{
//			List<LocationRecord> locations = Constants.getLocation();
//			while(locations.size() < locationNumber) {
//				locations.add(new LocationRecord());
//			}
//			String oldAddress = locations.get(locationNumber).getAddress();
//			locations.get(locationNumber).setSetLocation(null);
//			locations.get(locationNumber).setAddress(address);
//			if(isEditMode(mode)) {
//				if(oldAddress == null) {
//					Constants.getLog().getLogs().putLog("Changed Set Location Section:", 
//							String.format(" Address: → %s", address));
//					changeRequestStatusToModified();
//				}
//				else if(!oldAddress.equalsIgnoreCase(address)) {
//					Constants.getLog().getLogs().putLog("Changed Set Location Section:", 
//							String.format(" Address: %s → %s", oldAddress,address));
//					changeRequestStatusToModified();
//				}
//			}
//		};
//		executeStorage(String.format("Set Location Address %d",addressElementIndex),store,mode);
//		// for closing the dropdown
//		producerDashboardGeneralPage.clickFormTitle();
//	}
}