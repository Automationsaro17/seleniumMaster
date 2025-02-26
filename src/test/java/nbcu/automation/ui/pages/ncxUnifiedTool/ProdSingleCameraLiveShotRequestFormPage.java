
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
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
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
import nbcu.automation.ui.enums.UserRole;
import nbcu.automation.ui.pojos.ncxUnifiedTool.CrewRecord;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.factory.DriverFactory;
import nbcu.framework.utils.Other.DateFunctions;
import nbcu.framework.utils.propertyfilereader.ConfigFileReader;
import nbcu.framework.utils.report.ReportGenerate;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;
import nbcu.framework.utils.ui.WebAction;

public class ProdSingleCameraLiveShotRequestFormPage {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	@FindBy(xpath = "//*[contains(text(),'Select Set Background')]/ancestor::div[3]//div[contains(@class,'error')]")
	WebElement setBackgroundError;

	@FindBy(xpath = "//*[contains(@forminputname,'setStagingNeeded')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement setStagingNeededError;

	@FindBy(xpath = "//*[contains(text(),'Select Set Background')]")
	WebElement setBackgroundDropDown;

	@FindBy(xpath = "//div[contains(text(),'HAIR STYLIST')]/ancestor::div[1]//input")
	WebElement hairStylistInputbox;

	@FindBy(xpath = "//div[contains(text(),'PROMPTER OP')]/ancestor::div[1]//input")
	WebElement prompterOpInputbox;

	@FindBy(xpath = "//div[contains(text(),'MAKEUP ARTIST')]/ancestor::div[1]//input")
	WebElement makeUpArtistInputbox;

	@FindBy(xpath = "//*[@forminputname='setStagingNeeded']//label[@label-value='false']")
	WebElement setStagingNeeded_No;

	@FindBy(xpath = "//*[@forminputname='setStagingNeeded']//label[@label-value='true']")
	WebElement setStagingNeeded_Yes;

	String dropDownvaluesXpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item";

	@FindBy(xpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item | //nz-option-item ")
	List<WebElement> dropDownvalues;

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

	@FindBy(xpath = "//*[@sectiontitle='Details']//nz-form-label//label")
	List<WebElement> detailsSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='SET CREW']//nz-form-label//label")
	List<WebElement> setCrewSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Set Information']//nz-form-label//label")
	List<WebElement> setInformationSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Details']//textarea")
	WebElement DetailNotes;

	@FindBy(xpath = "//*[@class='cdk-overlay-pane']//nz-option-item")
	List<WebElement> setBackgroundOptions;

	@FindBy(xpath = "//*[contains(text(),' Set Background ')]//ancestor::div[1]//input")
	WebElement setBackgroundDropdown;

	@FindBy(xpath = "//*[text()='SET INFORMATION']")
	WebElement setInformationSection;
	
	@FindBy(xpath="//*[text()=' Set Crew ']/../following::*[1]//input")
	WebElement setCrewInput;
	
	@FindBy(xpath="//*[contains(@class,'crew-member-container')]//*[contains(@class,'title ')]")
	List<WebElement> displayedSetCrewNamesInEditMode;

	@FindBy(xpath="//*[contains(@class,'crew-member-container')]//input")
	List<WebElement> displayedSetCrewInputsInEditMode;

	@FindBy(xpath="//*[contains(@class,'crew-member-container')]//i[contains(@class,'anticon-delete')]/ancestor::button")
	List<WebElement> displayedSetCrewDeleteButtonsInEditMode;
	
	@FindBy(xpath="(//label[contains(text(),'Set Crew')]/ancestor::nz-form-label/following::i[contains(@class,'ant-select-close-icon')])[1]")
	WebElement clearIconForSetCrew;
	
	@FindBy(xpath = "//*[contains(text(),' Staging: Are set changes needed? ')]/../following::*[1]//*[text()]")
	List<WebElement> stagingRadioLabels;
	
	@FindBy(xpath = "//*[contains(text(),' Capture Manager: ')]/../following::*[1]//*[text()]")
	List<WebElement> captureManagerRadioLabels;
	
	@FindBy(xpath = "//label[contains(text(),'Set Background')]/ancestor::nz-form-label/following::input[1]")
	WebElement setBackgroundInput;
	
	@FindBy(xpath = "//label[contains(text(),'Division')]/ancestor::nz-form-label/following::input[1]")
	WebElement divisionInput;
	
	@FindBy(xpath="//*[contains(@class,'ant-select-item') and text()]")
	List<WebElement> dropdownOptions;
	
	@FindBy(xpath = "//label[text()=' Air Platform ']/ancestor::nz-form-label/following::input[1]")
	WebElement airPlatformInput;
	
	@FindBy(xpath = "//label[text()=' Work Order # ']/ancestor::nz-form-label/following::input[1]")
	WebElement workOrderInput;
	
	@FindBy(xpath="//*[@sectiontitle='SET CREW']//*[contains(@class,'ant-select-selection-item-content')]/following::i[@nztype='close'][1]")
	List<WebElement> selectedSetCrewRemovalIcons;

	@FindBy(xpath="//*[@sectiontitle='SET CREW']//*[contains(@class,'ant-select-selection-item-content')]")
	List<WebElement> selectedSetCrewNames;
	
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

	@FindBy(xpath = "//*[text()=' Details and Notes ']/../following::*[1]//textarea")
	WebElement detailsAndNotesInput;
	
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
	
	@FindBy(xpath = "//*[text()='EDITING ']")
	List<WebElement> editingStatus;
	
	@FindBy(xpath = "//*[contains(text(),' Is Budget Code Available? ')]/../following::*[1]//span[text()]")
	List<WebElement> isBudgetCodeAvailableRadioLabels;
	
	@FindBy(xpath="//status-edit-panel//*[contains(@class,'pending-area')]//*[text()]")
	List<WebElement> uncheckedFulfillmentStatusElements;

	@FindBy(xpath="//status-edit-panel//*[contains(@class,'pending-area')]//*[contains(@class,'check-button')]")
	List<WebElement> checkButtonForUncheckedFulfillmentStatusElements;
	
	@FindBy(xpath="//status-edit-panel//button[contains(@class,'clear-button')]")
	List<WebElement> clearButtonForCheckedFulfillmentStatusElements;
	
	@FindBy(xpath="//button[contains(@class,'clear-button')]/ancestor::status-edit-panel//h1")
	List<WebElement> statusNamesHavingClearButton;
	
	@FindBy(xpath="//*[contains(@class,'crew-member-title')]//*[contains(@class,'title')]")
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

	public ProdSingleCameraLiveShotRequestFormPage() {
		PageFactory.initElements(DriverFactory.getCurrentDriver(), this);
	}

	/**
	 * To verify set Information section missing field error message
	 *
	 * @throws Exception
	 */
	public void verifySetInformationMissingFieldError(String setBackgroundErrorMessage,
			String setStagingNeededErrorMessage) throws Exception {
		try {
			CommonValidations.verifyTextValue(setBackgroundError, setBackgroundErrorMessage);
			CommonValidations.verifyTextValue(setStagingNeededError, setStagingNeededErrorMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void selectSetInformation(String backgroundText, String stageingNeededText) throws Exception {
		WebAction.scrollIntoView(producerDashboardGeneralPage.setInformationSection);
		try {
			selectSetBackground(backgroundText);
			addSetStagingNeeded(stageingNeededText);
		} catch (

		Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addSetBackground(String backgroundText) throws Exception {
		// To select set background
		if (backgroundText != null) {
			boolean valuePresent = false;

			WebAction.clickUsingJs(setBackgroundDropDown);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (WebElement ele : dropDownvalues) {
				if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(backgroundText)) {
					WebAction.click(ele);
					ReportGenerate.test.log(Status.INFO,
							"User selects " + backgroundText + " as Set Background option");
					valuePresent = true;
					break;
				}
			}
			if (valuePresent == false)
				throw new Exception(
						"'" + backgroundText + "' value is not present in the set background type drop down");
		}
	}

	public void addSetStagingNeeded(String stageingNeededText) throws Exception {
		try {
			if (stageingNeededText != null) {
				if (stageingNeededText.equalsIgnoreCase("Yes")) {
					Constants.setStagingNeeds(stageingNeededText);
					WebAction.click(setStagingNeeded_Yes);
					ProducerDashboardGeneralPage.emailCCList.add(
							ConfigFileReader.getProperty("prodreq-staging","emailconfig.properties"));
					ReportGenerate.test.log(Status.INFO,
							"User selects " + stageingNeededText + " for Staging: Are set changes needed? option");
				} else {
					WebAction.click(setStagingNeeded_No);
					ReportGenerate.test.log(Status.INFO, "User selects No for Staging: Are set changes needed? option");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addSetCrew(String captureManagerText, String setCrewText) throws Exception {
		WebAction.scrollIntoView(producerDashboardGeneralPage.setCrewSection);
		producerDashboardGeneralPage.selectCaptureManager(captureManagerText);
		producerDashboardGeneralPage.addSetCrewText(setCrewText);
		WebAction.clickUsingJs(producerDashboardGeneralPage.setCrewSection);

	}

	/**
	 * To verify sections on request form
	 * 
	 */
	public void verifyTheFormSectionsInSingleCameraLiveShotForm() {
		Object[] expectedHeaders = { "STATUS", "GENERAL DETAILS", "REQUESTER(S)", "TALENT", "DETAILS", "SHOW INFO",
				"SET INFORMATION", "SET CREW" };
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
					"All expected sections are not present on " + "Single camera live shot form");
		}
	}

	/**
	 * To check fields on the single camera live form
	 * 
	 * @param sectionName - section name
	 */
	public void checkFieldsInSectionOfSingleCameraLiveShot(String sectionName) {
		List<WebElement> sectionLabelElements = getSectionLabelElements(sectionName);
		if (sectionLabelElements == null) {
			Assert.assertTrue(false, sectionName + " section is not present in Single camera live shot form");
			return;
		}

		List<String> expectedFieldNamesList = getExpectedFieldsSectionWise(sectionName);
		List<String> expectedRequiredFieldList = getRequiredFieldsSectionWise(sectionName);
		if (sectionLabelElements.size() != expectedFieldNamesList.size()) {
			Assert.assertEquals(sectionLabelElements.size(), expectedFieldNamesList.size(),
					"Number of displayed fields and expected fields not equal in " + sectionName
							+ " section of single live camera shot");
			return;
		}
		for (int itr = 0; itr < expectedFieldNamesList.size(); itr++) {
			String expectedName = expectedFieldNamesList.get(itr);
			String displayedField = WebAction.getText(sectionLabelElements.get(itr));
			if (displayedField.contains("Prep Time")) {
				displayedField = (displayedField.split(" ")[0] + " " + displayedField.split(" ")[1].trim());
			}
			Assert.assertEquals(displayedField, expectedName, "Displayed field is not same as expected field in "
					+ sectionName + " section of single live camera shot form");
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
		} else if (sectionName.equalsIgnoreCase("DETAILS")) {
			return detailsSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("SHOW INFO")) {
			return showInfoSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("SET CREW")) {
			return setCrewSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("SET INFORMATION")) {
			return setInformationSectionFieldLabels;
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
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Talent")));
		} else if (sectionName.equalsIgnoreCase("DETAILS")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Details and Notes")));
		} else if (sectionName.equalsIgnoreCase("SHOW INFO")) {
			fieldNamesList.add("Air Platform");
			fieldNamesList.add("Show Unit or Project Name");
			String showUnitOrProjectName = Constants.getShowUnitOrProjectName();
			if (showUnitOrProjectName != null && showUnitOrProjectName.equalsIgnoreCase("Other")) {
				fieldNamesList.add("Other");
			}
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Is Budget Code Available?", "Budget Code")));
			String division = Constants.getDivision();
			if (division != null && division.equals("CNBC")) {
				fieldNamesList.add("Work Order #");
			}
			fieldNamesList
					.addAll(new ArrayList<String>(Arrays.asList("Start Date", "Prep Time", "Start Time", "End Time")));
		} else if (sectionName.equalsIgnoreCase("SET CREW")) {
			fieldNamesList.addAll(new ArrayList<String>(
					Arrays.asList("Capture Manager: Do you need content to be recorded?", "Set Crew")));
		} else if (sectionName.equalsIgnoreCase("SET INFORMATION")) {
			fieldNamesList.add("Set Background");
			String setBackground = Constants.getSetBackground();
			if (setBackground != null && setBackground.equalsIgnoreCase("Other")) {
				fieldNamesList.add("Other");
			}
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Staging: Are set changes needed?")));
		}
		return fieldNamesList;
	}

	public List<String> getRequiredFieldsSectionWise(String sectionName) {
		List<String> fieldNamesList = new ArrayList<String>();
		if (sectionName.equalsIgnoreCase("GENERAL DETAILS")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Division")));
		} else if (sectionName.equalsIgnoreCase("REQUESTER(S)") || sectionName.equalsIgnoreCase("TALENT")
				|| sectionName.equalsIgnoreCase("SET CREW") || sectionName.equalsIgnoreCase("DETAILS")) {
			fieldNamesList.addAll(new ArrayList<String>());
		} else if (sectionName.equalsIgnoreCase("SHOW INFO")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Air Platform", "Show Unit or Project Name",
					"Other", "Is Budget Code Available?", "Budget Code", "Start Date", "Start Time", "End Time")));
		} else if (sectionName.equalsIgnoreCase("SET INFORMATION")) {
			fieldNamesList
					.addAll(new ArrayList<String>(Arrays.asList("Set Background", "Staging: Are set changes needed?")));
		}
		return fieldNamesList;
	}

	/**
	 * To add details and notes in the form
	 *
	 * @param Notes- Notes
	 */
	public void addDetailsAndNotes(String Notes) throws Exception {
		WebAction.scrollIntoView(DetailNotes);
		WebAction.sendKeys(DetailNotes, Notes);
		ReportGenerate.test.log(Status.INFO, "User enters " + Notes + " in Details and Notes section");
	}

	/**
	 * To select set background in the form
	 *
	 * @param setBackground- Set Background
	 */
	public void selectSetBackground(String setBackground) throws Exception {
		WebAction.scrollIntoView(setInformationSection);
		if (setBackground != null) {
			boolean valuePresent = false;
			WebAction.clickUsingJs(setBackgroundDropdown);
			for (WebElement options : setBackgroundOptions) {
				if (WebAction.getAttribute(options, "title").equalsIgnoreCase(setBackground)) {
					WebAction.click(options);
					Constants.setSetBackground(options.getText());
					valuePresent = true;
					ReportGenerate.test.log(Status.INFO, "User selects " + setBackground + " as Set Background option");
					break;
				}

			}

			if (valuePresent == false)
				throw new Exception("'" + setBackground + "' value is not present in the location type drop down");
		}
	}

	/**
	 * To verify values in the Single Camera Live Shot form are present in
	 * production dashboard columns
	 * 
	 * @throws Exception
	 */
	public void verifySingleCameraLiveShotRequestValuesWithProductionDashboardValues(String additionalRequestersText,
			String ProdDateText, String ShowProjectText, String ProductionPurposeText, String SetLocationText,
			String ControlRoomText, String PositionsText, String SubmittedText) throws Exception {
		try {

			String columnCellString = "//a[contains(text(),'<<RequestId>>')]/ancestor::tr/td[contains(@class,'<<ColumnType>>')]/div";			
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", Constants.getRequestNumber())
					.replace("<<ColumnType>>", "position");

			// To validate set crew
			if (PositionsText != null) {
				String SetCrewArrayList[] = null;
				if (PositionsText.contains(",")) {
					SetCrewArrayList = PositionsText.split(",");
				} else {
					SetCrewArrayList = PositionsText.split(" ");
				}
				for (int i = 0; i < SetCrewArrayList.length; i++) {
					switch (SetCrewArrayList[i].toUpperCase()) {

					case "HAIR STYLIST":
						SetCrewArrayList[i] = "HAIR";
						break;
					case "MAKEUP ARTIST":
						SetCrewArrayList[i] = "MU";
						break;
					case "PLAZA PRODUCTIONS OP":
						// SetCrewArrayList[i] = "";
						break;
					case "PROMPTER OP":
						SetCrewArrayList[i] = "PMT";
						break;
					}
				}
				for (String SetCrewArray : SetCrewArrayList) {
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
							SetCrewArray);
				}
			}

			ProductionPurposeText = "Live Shot - Single Camera";
			SetLocationText = "Any Room Plaza Prod";
			ControlRoomText = null;
			PositionsText = null;

			producerDashboardGeneralPage.verifyRockCenterRequestValuesWithProductionDashboardValues(
					additionalRequestersText, ProdDateText, ShowProjectText, ProductionPurposeText, SetLocationText,
					ControlRoomText, PositionsText, SubmittedText);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean selectValueInDropdown(WebElement input,String option) {
		Boolean selected = false;
		try {
			input.sendKeys(option);
			Waits.waitForAllElements(dropdownOptions,WAIT_CONDITIONS.VISIBLE);
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
	public void selectStagingSetChangedNeeded(String choice,RequestMode...mode) {
		selectRadioOption(choice, stagingRadioLabels);
		Runnable store = ()->{
			String oldStagingNeeds = Constants.getStagingNeeds();
			Constants.setStagingNeeds(choice);
			if(isEditMode(mode) && oldStagingNeeds != null && !oldStagingNeeds.equalsIgnoreCase(choice)) {
				if(!Constants.getLog().getLogs().containsSectionLog("Changed Set Information Section:")) {
					Constants.getLog().getLogs().putLog("Changed Set Information Section",null);
				}
				if(choice.equalsIgnoreCase("Yes")) {
					Constants.getLog().getLogs().putLog("Changed Staging",null);
				}
				changeRequestStatusToModified();
			}
		};
		executeStorage("Staging",store,mode);
	}
	public void selectCaptureManager(String choice,RequestMode...mode) {
		selectRadioOption(choice, captureManagerRadioLabels);
		Runnable store = ()->{
			String old = Constants.getCaptureManager();
			Constants.setCaptureManager(choice);
			if(isEditMode(mode)) {
				if(old == null || !old.equalsIgnoreCase(choice)) {
					changeRequestStatusToModified();
					if(!Constants.getLog().getLogs().containsSectionLog("Changed Set Crew Section:")) {
						Constants.getLog().getLogs().putLog("Changed Set Crew Section",null);
					}
					if(choice.equalsIgnoreCase("Yes")) {
						Constants.getLog().getLogs().putLog("Completed Capture Manager",null);
					}
				}
			}
		};
		executeStorage("Capture Manager",store,mode);
	}
	public void selectSetBackgroundInSetInformation(String option,RequestMode...mode) {
		if(option == null) {
			return;
		}
		Boolean isSelected = selectValueInDropdown(setBackgroundInput, option);
		Assert.assertTrue(isSelected,String.format("'%s' is not selected in Set Background dropdown",option));
		Runnable store = ()->{
			String oldVal = Constants.getSetBackground();
			Constants.setSetBackground(option);
			if(isEditMode(mode) && oldVal != null && !oldVal.equalsIgnoreCase(option)) {
				Constants.getLog().getLogs().removeLogStartingWith("Changed Set Information Section", null);
				Constants.getLog().getLogs().putLog("Changed Set Information Section:", 
						String.format(" Set Background: %s → %s", oldVal,option));
				changeRequestStatusToModified();
			}
		};
		executeStorage("Set Background",store,mode);		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	public void selectSetCrew(String crewNames,RequestMode... mode) {
		if(crewNames == null) {
			return;
		}
		// is Makeup Artist or Hair Stylist already present in set crew before this method changes
		List<String> checkList = Arrays.asList("Hair Stylist","Makeup Artist");
		Boolean makeupOrHairStylistPresentAlready = Constants.getSetCrew().stream()
					.filter((crew)->checkList.contains(crew.getCrewName())).findAny().isPresent();
				
		Consumer<String> selectCrewCons = (op) -> {
			final String op2 = new String(op.trim());
			Assert.assertTrue(selectValueInDropdown(setCrewInput, op2),String.format("%s not selected in Set Crew", op2));
			Runnable store = ()->{
				Constants.getSetCrew().add(new CrewRecord(op2,1));
				if(isEditMode(mode)) {
					changeRequestStatusToModified();
					if(op2.equalsIgnoreCase("Plaza Productions Op")) {
						if(!Constants.getLog().getLogs().containsSectionLog("Changed Set Crew Section:")) {
							Constants.getLog().getLogs().putLog("Changed Set Crew Section",null);
						}
					}
					else {
						Constants.getLog().getLogs().removeLogStartingWith("Changed Set Crew Section",null);
						Constants.getLog().getLogs().putLog("Changed Set Crew Section:", 
								String.format(" %s: added , Count: 0 → 1",op2.toUpperCase()));
						if(checkList.contains(op2) && !makeupOrHairStylistPresentAlready) {
							Constants.getLog().getLogs().putLog("Changed Hair/MU/WR",null);
						}
					}
				}
			};
			executeStorage(op2,store,mode);
		};
		Arrays.asList(crewNames.split(",")).forEach(selectCrewCons);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}
	/*
	 * this method needs to either run when the crew is already added via selectSetCrew method
	 */
	public void changeQuantitiesOfSetCrew(String namesWithQuantities, RequestMode... mode) {
		if(namesWithQuantities == null) {
			return;
		}
		// is Makeup Artist or Hair Stylist already present in set crew before this method changes
		List<String> checkList = Arrays.asList("Hair Stylist","Makeup Artist");
		Boolean makeupOrHairStylistPresentAlready = Constants.getSetCrew().stream()
			.filter((crew)->checkList.contains(crew.getCrewName())).findAny().isPresent();
		
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
					WebElement inputElement = displayedSetCrewInputsInEditMode.get(itr);
					WebAction.clearInputOneCharAtTime(inputElement);
					inputElement.sendKeys(Integer.toString(quantity));
					Runnable store = ()->{
						Optional<CrewRecord> crew=Constants.getSetCrew().stream()
								.filter((crewRec)->crewRec.getCrewName().equals(name)).findAny();
						if(crew.isPresent()) {
							int oldQty = crew.get().getNumber();
							crew.get().setNumber(quantity);
							if(isEditMode(mode) && oldQty != quantity) {
								changeRequestStatusToModified();
								if(name.equalsIgnoreCase("Plaza Productions Op")) {
									if(!Constants.getLog().getLogs().containsSectionLog("Changed Set Crew Section:")) {
										Constants.getLog().getLogs().putLog("Changed Set Crew Section",null);
									}
								}
								else {
									Constants.getLog().getLogs().removeLogStartingWith("Changed Set Crew Section",null);
									Constants.getLog().getLogs().putLog("Changed Set Crew Section:", 
											String.format(" %s: changed , Count: %d → %d",name.toUpperCase(),oldQty,quantity));
								}
							}
						}
						else {
							Constants.getSetCrew().add(new CrewRecord(name,quantity));
							if(isEditMode(mode)) {
								changeRequestStatusToModified();
								if(name.equalsIgnoreCase("Plaza Productions Op")) {
									if(!Constants.getLog().getLogs().containsSectionLog("Changed Set Crew Section:")) {
										Constants.getLog().getLogs().putLog("Changed Set Crew Section",null);
									}
								}
								else {
									Constants.getLog().getLogs().removeLogStartingWith("Changed Set Crew Section",null);
									Constants.getLog().getLogs().putLog("Changed Set Crew Section:", 
											String.format(" %s: added , Count: %d → %d",name.toUpperCase(),0,quantity));
									if(checkList.contains(name) && !makeupOrHairStylistPresentAlready) {
										Constants.getLog().getLogs().putLog("Changed Hair/MU/WR",null);
									}
								}
							}
						}
					};
					executeStorage(name,store,mode);
					break;
				}
			}
		}
	}
	public void removeSpecificSetCrews(String crewNames,RequestMode...mode) throws Exception {
		if(crewNames == null) {
			return;
		}
		Set<String> crewsToRemove = new HashSet<>(Arrays.asList(crewNames.trim().split(",")));
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
						CrewRecord crew = optional.get();
						if(isEditMode(mode)) {
							if(displayedName.equalsIgnoreCase("Plaza Productions Op")) {
								if(!Constants.getLog().getLogs().containsSectionLog("Changed Set Crew Section:")) {
									Constants.getLog().getLogs().putLog("Changed Set Crew Section",null);
								}
							}
							else {
								Constants.getLog().getLogs().removeLogStartingWith("Changed Set Crew Section",null);
								Constants.getLog().getLogs().putLog("Changed Set Crew Section:",
										String.format("%s: removed , Count: %d → 0", crew.getCrewName().toUpperCase(),crew.getNumber()));
							}
							changeRequestStatusToModified();
						}
						Constants.getSetCrew().remove(crew);
					}
				};
				executeStorage(displayedName,store,mode);
			}
		}
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
	public void clearSetCrewOnSCLS(RequestMode...mode) throws Exception {
		tryClearing(clearIconForSetCrew,selectedSetCrewNames);
		Iterator<CrewRecord> crewIterator = Constants.getSetCrew().iterator();
		while(crewIterator.hasNext()) {
			CrewRecord crew = crewIterator.next();
			String crewName = crew.getCrewName();
			Runnable store = ()->{
				if(isEditMode(mode)) {
					changeRequestStatusToModified();
					if(crewName.equalsIgnoreCase("Plaza Productions Op")) {
						if(!Constants.getLog().getLogs().containsSectionLog("Changed Set Crew Section:")) {
							Constants.getLog().getLogs().putLog("Changed Set Crew Section",null);
						}
					}
					else {
						Constants.getLog().getLogs().removeLogStartingWith("Changed Set Crew Section", null);
						Constants.getLog().getLogs().putLog("Changed Set Crew Section:",
								String.format(" %s: removed , Count: %d → 0",crew.getCrewName().toUpperCase(), crew.getNumber()));
					}
				}
				Constants.getSetCrew().remove(crew);
			};
			executeStorage(crewName,store,mode);
		}
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
	public void provideDetailsAndNotes(String notes,RequestMode...mode) {
		if(notes == null) {
			return;
		}
		WebAction.clearInputOneCharAtTime(detailsAndNotesInput);
		detailsAndNotesInput.sendKeys(notes);
		Runnable store = ()->{
			String old = Constants.getDetailsAndNotes();
			if(isEditMode(mode) &&((old == null && notes.length()>0) || !old.equals(notes))) {
				Constants.getLog().getLogs().putLog("Changed Details Section",null);
				changeRequestStatusToModified();
			}
			Constants.setDetailsAndNotes(notes);	
		};
		executeStorage("Details and Notes",store,mode);
	}
	public void clearDetailsAndNotes(RequestMode...mode) {
		WebAction.clearInputOneCharAtTime(detailsAndNotesInput);
		Runnable store = ()->{
			String old = Constants.getDetailsAndNotes();
			if(isEditMode(mode) && old != null) {
				Constants.getLog().getLogs().putLog("Changed Details Section",null);
				changeRequestStatusToModified();
			}
			Constants.setDetailsAndNotes(null);
		};
		executeStorage("Details and Notes",store,mode);
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
	public void checkStatusOnFulfillment(String statuses,RequestMode...mode) throws Exception {
		List<String> statusesList = Arrays.asList(statuses.split(";")).stream()
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
						else if(status.equalsIgnoreCase("Staging")) {
							Constants.getLog().getLogs().putLog("Completed Staging",null);
						}
						else if(status.equalsIgnoreCase("Hair, Makeup & Wardrobe")) {
							Constants.getLog().getLogs().putLog("Completed Hair/MU/WR",null);
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
		List<String> statusesList = Arrays.asList(statuses.split(";")).stream()
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
						else if(status.equalsIgnoreCase("Staging")) {
							Constants.getLog().getLogs().putLog("Changed Staging",null);
						}
						else if(status.equalsIgnoreCase("Hair, Makeup & Wardrobe")) {
							Constants.getLog().getLogs().putLog("Changed Hair/MU/WR",null);
						}
					};
					Runnable store2 = ()->{
						// this is possibly a bug, i.e. without making any change status is changing to Working
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
	public void executeRunnableForSetCrewInFulfillment(CrewRecord crew,RequestMode...mode) {
		WebDriver driver = getCurrentDriver();
		String crewName = crew.getCrewName();
		int prevSavedQuantity=crew.getNumber();
		List<WebElement> crewMemberInputElements = driver.findElements(By.xpath(String.format(crewMemberInputLocator, crewName)));
		int newQuantityToBe = crewMemberInputElements.size();
		// new members
		StringBuilder newMembers = new StringBuilder();
		List<String> visibleMembers = new ArrayList<>();
		for(int i=0; i<newQuantityToBe; ++i) {
			String member = WebAction.getAttribute(crewMemberInputElements.get(i),"value");
			visibleMembers.add(member);
			if(!member.equals("")) {
				newMembers.append(String.format(" %s,",member));
			}
		}
		String newMembersString = newMembers.toString();
		newMembersString = newMembersString.endsWith(",") ? newMembersString.substring(0, newMembersString.length()-1) : newMembersString;
		final String newMembersString2 = newMembersString;
		Runnable store = ()->{
			// old members
			StringBuilder oldMembers = new StringBuilder();
			List<String> members = crew.getCrewMemberNames();
			for(String member : members) {
				if(!member.equals("")) {
					oldMembers.append(String.format(" %s,",member));
				}
			}
			String oldMembersString = oldMembers.toString();
			oldMembersString = oldMembersString.endsWith(",") ? oldMembersString.substring(0, oldMembersString.length()-1) : oldMembersString;
			String crewNameUppercase = crewName.toUpperCase();
			// this is a bug, logs for plaza productions op are not mentioning the plaza productions op in it
			if(crewName.equals("Plaza Productions Op")){
				if(!Constants.getLog().getLogs().containsSectionLog("Changed Set Crew Section:")) {
					Constants.getLog().getLogs().putLog("Changed Set Crew Section",null);
				}
			}
			else {
				Constants.getLog().getLogs().removeLogStartingWith("Changed Set Crew Section", null);
				if(newQuantityToBe == 0) {
					Constants.getLog().getLogs().putLog("Changed Set Crew Section:",
							String.format("%s: removed , Count: %d → 0", crewNameUppercase,prevSavedQuantity));
					
				}
				else if(newMembersString2.equals("") && oldMembersString.equals("")) {
					if(prevSavedQuantity != newQuantityToBe) {
						Constants.getLog().getLogs().putLog("Changed Set Crew Section:",
								String.format("%s: changed , Count: %d → %d", crewNameUppercase,prevSavedQuantity,newQuantityToBe));
					}
				}
				else if(oldMembersString.equals("") && !newMembersString2.equals("")) {
					if(prevSavedQuantity != newQuantityToBe) {
						Constants.getLog().getLogs().putLog("Changed Set Crew Section:",
								String.format("%s: Count: %d → %d , name:%s added", crewNameUppercase,prevSavedQuantity,newQuantityToBe,newMembersString2));
					}
					else {
						Constants.getLog().getLogs().putLog("Changed Set Crew Section:",
								String.format("%s: Count: %d , name:%s added", crewNameUppercase,prevSavedQuantity,newMembersString2));
					}
				}
				else if(!oldMembersString.equals("") && newMembersString2.equals("")) {
					if(prevSavedQuantity != newQuantityToBe) {
						Constants.getLog().getLogs().putLog("Changed Set Crew Section:",
								String.format("%s: Count: %d → %d , name:%s removed", crewNameUppercase,prevSavedQuantity,newQuantityToBe,oldMembersString));
					}
					else {
						Constants.getLog().getLogs().putLog("Changed Set Crew Section:",
								String.format("%s: Count: %d , name:%s removed", crewNameUppercase,prevSavedQuantity,oldMembersString));
					}
				}
				else if(!oldMembersString.equals("") && !newMembersString2.equals("")) {
					if(prevSavedQuantity != newQuantityToBe) {
						Constants.getLog().getLogs().putLog("Changed Set Crew Section:",
								String.format("%s: Count: %d → %d , name:%s →%s", crewNameUppercase,prevSavedQuantity,newQuantityToBe
										,oldMembersString,newMembersString2));
					}
					else {
						Constants.getLog().getLogs().putLog("Changed Set Crew Section:",
								String.format("%s: Count: %d , name:%s →%s", crewNameUppercase,prevSavedQuantity,newQuantityToBe
										,oldMembersString,newMembersString2));
					}
				}
			}
			if(newQuantityToBe == 0) {
				Constants.getSetCrew().remove(crew);
			}else {
				members.clear();
				visibleMembers.forEach((member)->members.add(member));
				crew.setNumber(newQuantityToBe);
			}
		};
		executeStorage(crewName,store,mode);
	}
	public void provideSetCrewMembersInFulfillment(RequestMode...mode) {
		WebDriver driver = getCurrentDriver();
		Constants.getSetCrew().forEach((crew)->{
			String crewName = crew.getCrewName();
			List<WebElement> inputElements = driver.findElements(By.xpath(String.format(crewMemberInputLocator, crewName)));
			List<String> added = new ArrayList<>();
			for(int i=0;i<inputElements.size(); ++i) {
				WebElement inputElement = inputElements.get(i);
				WebAction.scrollIntoView(inputElement);
				String currValue = WebAction.getAttribute(inputElement, "value");
				String newValue = currValue.equals("") ? String.format("%s %d", crewName,i) : String.format("%s-edited", currValue);
				inputElement.clear();
				inputElement.sendKeys(newValue);
				added.add(newValue);
			}
			executeRunnableForSetCrewInFulfillment(crew, mode);
		});
	}
	public void modifySetCrewMemberQuantitiesInFulfillment(RequestMode...mode) {
		WebDriver driver = getCurrentDriver();
		int quantityUpperLimit = 5;
		int quantityUpperLimitForPrompterOp = 3;
		Constants.getSetCrew().forEach((crew)->{
			String crewName = crew.getCrewName();
			List<WebElement> inputElements = driver.findElements(By.xpath(String.format(crewQuanitityInputLocator, crewName)));
			WebElement inputElement = inputElements.get(0);
			WebAction.scrollIntoView(inputElement);
			String newQuantity = "1";
			if(crewName.equals("Prompter Op")) {
				newQuantity = Integer.toString(Math.max(1, (int)(Math.random()*quantityUpperLimitForPrompterOp)));
			}
			else {
				newQuantity = Integer.toString(Math.max(1, (int)(Math.random()*quantityUpperLimit)));
			}
			WebAction.clearInputOneCharAtTime(inputElement);
			inputElement.sendKeys(newQuantity);
			executeRunnableForSetCrewInFulfillment(crew, mode);
		});
	}
	public void deleteSetCrewMembersInFulfillmentRandomly(RequestMode... mode) {
		WebDriver driver = getCurrentDriver();
		Constants.getSetCrew().forEach((crew)->{
			String crewName = crew.getCrewName();
			List<WebElement> deleteButtonElements = driver.findElements(By.xpath(String.format(crewMemberDeleteButtonLocator, crewName)));
			for(int i=0;i<deleteButtonElements.size(); ++i) {
				boolean toDelete = Math.random() >= 0.5 ? true : false;
				if(toDelete) {
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
	public void deleteSetCrewInFulfillment(String crewNamesToDelete,RequestMode... mode) {
		Set<String> namesToDelete = new HashSet<>();
		Arrays.asList(crewNamesToDelete.split(",")).forEach((name)->namesToDelete.add(name.trim()));
		WebDriver driver = getCurrentDriver();
		crewNamesInFulfillmentContainer.forEach((titleEle)->{ 
			String title = getText(titleEle);
			if(namesToDelete.contains(title)) {
				WebElement deleteButtonElement = driver.findElement(By.xpath(String.format(crewDeleteButtonLocator, title)));
				try {
					WebAction.click(deleteButtonElement);
					Optional<CrewRecord> crewOptional=Constants.getSetCrew().stream().filter((crewRec)->crewRec.getCrewName().equals(title)).findAny();
					if(crewOptional.isPresent()) {
						executeRunnableForSetCrewInFulfillment(crewOptional.get(), mode);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}