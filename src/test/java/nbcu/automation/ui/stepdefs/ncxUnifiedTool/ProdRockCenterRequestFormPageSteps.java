package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;
import nbcu.automation.ui.enums.RequestMode;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProdRockCenterRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProducerDashboardGeneralPage;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.utils.cucumber.CucumberUtils;
import nbcu.framework.utils.propertyfilereader.ExcelReader;

public class ProdRockCenterRequestFormPageSteps {

	ProdRockCenterRequestFormPage prodRockCenterRequestFormPage = new ProdRockCenterRequestFormPage();
	CommonValidations commonValidations = new CommonValidations();
	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	@Then("Verify error message is displayed for all mandatory fields in Control Room section In Rock Center Production Form")
	public void verifyControlRoomMissingFieldErrorInProductionSection(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.verifyControlRoomMissingFieldError(
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room Location Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "control Room Error"));
	}

	// Rock Center Production filling form

	@When("user enters control room information in Rock Center Production form")
	public void fillControlRoomInfoInRockCenterProduction(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.addControlRoomInfoInRockcenter(
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room"));
	}

	@When("user enters control room crew information in Rock Center Production form")
	public void fillControlRoomCrewInfoInRockCenterProduction(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.selectControlRoomCrew(
				CucumberUtils.getValuesFromDataTable(dataTable, "Capture Manager"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room Crew"));
	}

	@When("user enters additional crew information in Rock Center Production form")
	public void fillAdditionalCrewInfoInRockCenterProduction(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage
				.selectAdditionalCrew(CucumberUtils.getValuesFromDataTable(dataTable, "Additional Crew"));
	}
	@When("user enters adds additional crew in Rock Center Production form")
	public void additionalCrewInfoInProductionForm(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage
				.addtionalCrewSelection(CucumberUtils.getValuesFromDataTable(dataTable, "Additional Crew"));
	}

	@When("user enters system information in Rock Center Production form")
	public void fillSystemInfoInRockCenterProduction(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.addSystemInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Ultimatte"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Voice Activated Prompter"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Notes"));
	}

	@When("user enters staging information in Rock Center Production form")
	public void fillStagingInfoInRockCenterProduction(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.addStagingInfoInRockCenter(
				CucumberUtils.getValuesFromDataTable(dataTable, "Staging"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Carpentry"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Lighting"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Props"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Describe Staging Needs"));
	}

	@Then("user verifies the form sections on Rock Center production form")
	public void verifyTheFormSectionsInRockCenterForm() {
		prodRockCenterRequestFormPage.verifyTheFormSectionsInRockCenterForm();
	}

	@Then("user verifies the fields present in {string} section of Rock Center Production form")
	public void verifyFieldsPresentOnSectionOfRockCenter(String sectionName) {
		if (sectionName != null) {
			prodRockCenterRequestFormPage.checkFieldsInSectionOfRockCenter(sectionName);
		}
	}

	@When("user selects division from the dropdown for Rock Center production form")
	public void addProducerInfoinGeneralSectionInProductionForm(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.selectDivision(CucumberUtils.getValuesFromDataTable(dataTable, "Division"));
	}

	@When("user adds talent in the talent section")
	public void addTalent(DataTable dataTable) throws InterruptedException, Exception {
		producerDashboardGeneralPage.enterTalentValue(CucumberUtils.getValuesFromDataTable(dataTable, "Talent"));
	}

	@Then("user verifies added talent is displayed in the section")
	public void verifyAdditionOfTalent(DataTable dataTable) {
		prodRockCenterRequestFormPage.verifyAdditionOfTalent(CucumberUtils.getValuesFromDataTable(dataTable, "Talent"));
	}

	@When("user provides TPMorTM information in Rock Center Production form")
	public void TPMorTMSectionDetails(DataTable dataTable) throws InterruptedException {
		prodRockCenterRequestFormPage
				.TPMorTMSectionDetails(CucumberUtils.getValuesFromDataTable(dataTable, "TPM or TM"));

	}

	@When("user enters set location information for different location in Rock Center Production form")
	public void fillSetLocationDetails(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.fillSetLocationDetails(
				CucumberUtils.getValuesFromDataTable(dataTable, "Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Set Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Division"));
	}

	@When("user enters control room details in Rock Center Production form")
	public void fillControlRoomDetails(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.fillControlRoomDetails(
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room"));
	}

	@Then("user checks the default state of is staging needed buttons")
	public void checkDefaultState() {
		prodRockCenterRequestFormPage.checkDefaultState();
	}

	@Then("user verifies presence of flashcam crew section")
	public void verifyPresenceOfFlashCamSection(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.verifyPresenceOfFlashCamSection(
				CucumberUtils.getValuesFromDataTable(dataTable, "Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Set Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Division"));
	}
	@When("user selects Division on Rockcenter request")
	public void selectDivision(DataTable dataTable) {
		prodRockCenterRequestFormPage.selectDivision(
				CucumberUtils.getValueFromDataTable(dataTable, "Division"));
	}
	@When("user selects fields in Production Purpose section on Rockcenter request")
	public void provideProductionPurpose(DataTable dataTable) {
		prodRockCenterRequestFormPage.selectRequestFor(
				CucumberUtils.getValueFromDataTable(dataTable, "Request For"));
		prodRockCenterRequestFormPage.provideDetailsAndNotes(
				CucumberUtils.getValueFromDataTable(dataTable, "Details & Notes"));
	}
	@When("user selects fields in Production Purpose section on Rockcenter request in edit mode")
	public void editProductionPurpose(DataTable dataTable) {
		prodRockCenterRequestFormPage.selectRequestFor(
				CucumberUtils.getValueFromDataTable(dataTable, "Request For"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.provideDetailsAndNotes(
				CucumberUtils.getValueFromDataTable(dataTable, "Details & Notes"),RequestMode.EDIT);
	}
	@When("user selects fields in Show Info section on Rockcenter request")
	public void selectShowInfoData(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.selectAirPlatform(
				CucumberUtils.getValueFromDataTable(dataTable, "Air Platform"));
		prodRockCenterRequestFormPage.selectShowUnit(
				CucumberUtils.getValueFromDataTable(dataTable, "Show Unit or Project Name"));
		prodRockCenterRequestFormPage.selectOtherInShowInfo(
				CucumberUtils.getValueFromDataTable(dataTable, "Other"));
		prodRockCenterRequestFormPage.selectWorkOrderInShowInfo(
				CucumberUtils.getValueFromDataTable(dataTable, "Work Order"));
		prodRockCenterRequestFormPage.selectIsBudgetCodeAvailable(
				CucumberUtils.getValueFromDataTable(dataTable, "Is Budget Code Available"));
		prodRockCenterRequestFormPage.selectBudgetCode(
				CucumberUtils.getValueFromDataTable(dataTable, "Budget Code"));
		prodRockCenterRequestFormPage.selectStartDate(
				CucumberUtils.getValueFromDataTable(dataTable, "Days from today"));
		prodRockCenterRequestFormPage.selectStartTime(
				CucumberUtils.getValueFromDataTable(dataTable, "Start Time"));
		prodRockCenterRequestFormPage.selectPrepTime(
				CucumberUtils.getValueFromDataTable(dataTable, "Prep Time"));
		prodRockCenterRequestFormPage.selectEndTime(
				CucumberUtils.getValueFromDataTable(dataTable, "End Time"));
	}
	@When("user selects fields in Show Info section on Rockcenter request in edit mode")
	public void editShowInfoData(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.selectAirPlatform(
				CucumberUtils.getValueFromDataTable(dataTable, "Air Platform"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectShowUnit(
				CucumberUtils.getValueFromDataTable(dataTable, "Show Unit or Project Name"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectOtherInShowInfo(
				CucumberUtils.getValueFromDataTable(dataTable, "Other"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectWorkOrderInShowInfo(
				CucumberUtils.getValueFromDataTable(dataTable, "Work Order"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectIsBudgetCodeAvailable(
				CucumberUtils.getValueFromDataTable(dataTable, "Is Budget Code Available"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectBudgetCode(
				CucumberUtils.getValueFromDataTable(dataTable, "Budget Code"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectStartDate(
				CucumberUtils.getValueFromDataTable(dataTable, "Days from today"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectStartTime(
				CucumberUtils.getValueFromDataTable(dataTable, "Start Time"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectPrepTime(
				CucumberUtils.getValueFromDataTable(dataTable, "Prep Time"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectEndTime(
				CucumberUtils.getValueFromDataTable(dataTable, "End Time"),RequestMode.EDIT);
	}
	@When("user clears Start Date on Rockcenter request")
	public void clearStartDate() throws Exception {
		prodRockCenterRequestFormPage.clearStartDate();
	}
	@When("user clears Start Time on Rockcenter request")
	public void clearStartTime() throws Exception {
		prodRockCenterRequestFormPage.clearStartTime();
	}
	@When("user clears End Time on Rockcenter request")
	public void clearEndTime() throws Exception {
		prodRockCenterRequestFormPage.clearEndTime();
	}
	@When("user clears Prep Time on Rockcenter request")
	public void clearPrepTime() throws Exception {
		prodRockCenterRequestFormPage.clearPrepTime();
	}
	@When("user clears Prep Time on Rockcenter request in edit mode")
	public void clearPrepTimeInEditMode() throws Exception {
		prodRockCenterRequestFormPage.clearPrepTime(RequestMode.EDIT);
	}
	@When("user clears Details & Notes on Rockcenter request")
	public void clearDetailsAndNotes() throws Exception {
		prodRockCenterRequestFormPage.clearDetailsAndNotes();
	}
	@When("user clears Details & Notes on Rockcenter request in edit mode")
	public void clearDetailsAndNotesInEditMode() throws Exception {
		prodRockCenterRequestFormPage.clearDetailsAndNotes(RequestMode.EDIT);
	}
	@When("user selects fields in Set Location section on Rockcenter request")
	public void selectSetLocation(DataTable dataTable) {
		String position = CucumberUtils.getValueFromDataTable(dataTable, "Location Number");
		prodRockCenterRequestFormPage.selectLocation(
				CucumberUtils.getValueFromDataTable(dataTable, "Location"),position);
		prodRockCenterRequestFormPage.selectSetLocation(
				CucumberUtils.getValueFromDataTable(dataTable, "Set Location"),position);
	}
	@When("user selects fields in Set Location section on Rockcenter request in edit mode")
	public void editSetLocation(DataTable dataTable) {
		String position = CucumberUtils.getValueFromDataTable(dataTable, "Location Number");
		prodRockCenterRequestFormPage.selectLocation(
				CucumberUtils.getValueFromDataTable(dataTable, "Location"),position,RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectSetLocation(
				CucumberUtils.getValueFromDataTable(dataTable, "Set Location"),position,RequestMode.EDIT);
	}
	@When("user selects fields in Control Room section on Rockcenter request in edit mode")
	public void editControlRoom(DataTable dataTable) {
		String position = CucumberUtils.getValueFromDataTable(dataTable, "Location Number");
		prodRockCenterRequestFormPage.selectControlRoomLocation(
				CucumberUtils.getValueFromDataTable(dataTable, "Control Room Location"),position,RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectControlRoom(
				CucumberUtils.getValueFromDataTable(dataTable, "Control Room"),position,RequestMode.EDIT);
	}
	@When("user selects fields in Control Room section on Rockcenter request")
	public void selectControlRoom(DataTable dataTable) {
		String position = CucumberUtils.getValueFromDataTable(dataTable, "Location Number");
		prodRockCenterRequestFormPage.selectControlRoomLocation(
				CucumberUtils.getValueFromDataTable(dataTable, "Control Room Location"),position);
		prodRockCenterRequestFormPage.selectControlRoom(
				CucumberUtils.getValueFromDataTable(dataTable, "Control Room"),position);
	}
	@When("user clicks `+ Location` button on Rockcenter request")
	public void clickAddLocationButton() {
		prodRockCenterRequestFormPage.addLocation();
	}
	@When("user clicks `+ Control Room` button on Rockcenter request")
	public void clickAddControlRoomButton() {
		prodRockCenterRequestFormPage.addControlRoom();
	}
	@When("user selects fields in Control Room Crew section on Rockcenter request in edit mode")
	public void editControlRoomCrewSection(DataTable dataTable) {
		prodRockCenterRequestFormPage.selectCaptureManager(
				CucumberUtils.getValueFromDataTable(dataTable, "Capture Manager"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectControlRoomCrew(
				CucumberUtils.getValueFromDataTable(dataTable, "Control Room Crew"),RequestMode.EDIT);
	}
	@When("user selects fields in Control Room Crew section on Rockcenter request")
	public void selectControlRoomCrewSection(DataTable dataTable) {
		prodRockCenterRequestFormPage.selectCaptureManager(
				CucumberUtils.getValueFromDataTable(dataTable, "Capture Manager"));
		prodRockCenterRequestFormPage.selectControlRoomCrew(
				CucumberUtils.getValueFromDataTable(dataTable, "Control Room Crew"));
	}
	@When("user changes quantities of Control Room Crew on Rockcenter request")
	public void changeControlRoomCrewQuantity(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.changeQuantitiesOfControlRoomCrew(
				CucumberUtils.getValueFromDataTable(dataTable, "NamesWithQuantities"));
	}
	@When("user changes quantities of Control Room Crew on Rockcenter request in edit mode")
	public void editControlRoomCrewQuantity(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.changeQuantitiesOfControlRoomCrew(
				CucumberUtils.getValueFromDataTable(dataTable, "NamesWithQuantities"),RequestMode.EDIT);
	}
	@When("user removes specific Control Room Crews on Rockcenter request")
	public void removeCrewsFromControlRoomCrew(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.removeSpecificControlRoomCrews(
				CucumberUtils.getValueFromDataTable(dataTable, "Control Room Crew"));
	}
	@When("user removes specific Control Room Crews on Rockcenter request in edit mode")
	public void removeCrewsFromControlRoomCrewInEditMode(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.removeSpecificControlRoomCrews(
				CucumberUtils.getValueFromDataTable(dataTable, "Control Room Crew"),RequestMode.EDIT);
	}
	@When("user removes all Control Room Crew on Rockcenter request")
	public void removeAllCrewsFromControlRoomCrew() throws Exception {
		prodRockCenterRequestFormPage.clearControlRoomCrew();
	}
	@When("user removes all Control Room Crew on Rockcenter request in edit mode")
	public void removeAllCrewsFromControlRoomCrewInEditMode() throws Exception {
		prodRockCenterRequestFormPage.clearControlRoomCrew(RequestMode.EDIT);
	}
	@When("user selects fields in Set Crew section on Rockcenter request in edit mode")
	public void editSetCrewSection(DataTable dataTable) {
		prodRockCenterRequestFormPage.selectSetCrew(
				CucumberUtils.getValueFromDataTable(dataTable, "Set Crew"),RequestMode.EDIT);
	}
	@When("user selects fields in Set Crew section on Rockcenter request")
	public void selectSetCrewSection(DataTable dataTable) {
		prodRockCenterRequestFormPage.selectSetCrew(
				CucumberUtils.getValueFromDataTable(dataTable, "Set Crew"));
	}
	@When("user changes quantities of Set Crew on Rockcenter request")
	public void changeSetCrewQuantity(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.changeQuantitiesOfSetCrew(
				CucumberUtils.getValueFromDataTable(dataTable, "NamesWithQuantities"));
	}
	@When("user changes quantities of Set Crew on Rockcenter request in edit mode")
	public void editSetCrewQuantity(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.changeQuantitiesOfSetCrew(
				CucumberUtils.getValueFromDataTable(dataTable, "NamesWithQuantities"),RequestMode.EDIT);
	}
	@When("user removes specific Set Crews on Rockcenter request")
	public void removeCrewsFromSetCrew(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.removeSpecificSetCrews(
				CucumberUtils.getValueFromDataTable(dataTable, "Set Crew"));
	}
	@When("user removes specific Set Crews on Rockcenter request in edit mode")
	public void removeCrewsFromSetCrewInEditMode(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.removeSpecificSetCrews(
				CucumberUtils.getValueFromDataTable(dataTable, "Set Crew"),RequestMode.EDIT);
	}
	@When("user removes all Set Crew on Rockcenter request")
	public void removeAllCrewsFromSetCrew() throws Exception {
		prodRockCenterRequestFormPage.clearSetCrew();
	}
	@When("user removes all Set Crew on Rockcenter request in edit mode")
	public void removeAllCrewsFromSetCrewInEditMode() throws Exception {
		prodRockCenterRequestFormPage.clearSetCrew(RequestMode.EDIT);
	}
	@When("user selects fields in Additional Crew section on Rockcenter request in edit mode")
	public void editAdditionalCrewSection(DataTable dataTable) {
		prodRockCenterRequestFormPage.selectAdditionalCrewOnRockCenter(
				CucumberUtils.getValueFromDataTable(dataTable, "Additional Crew"),RequestMode.EDIT);
	}
	@When("user selects fields in Additional Crew section on Rockcenter request")
	public void selectAdditionalCrewSection(DataTable dataTable) {
		prodRockCenterRequestFormPage.selectAdditionalCrewOnRockCenter(
				CucumberUtils.getValueFromDataTable(dataTable, "Additional Crew"));
	}
	@When("user changes quantities of Additional Crew on Rockcenter request")
	public void changeAdditionalCrewQuantity(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.changeQuantitiesOfAdditionalCrew(
				CucumberUtils.getValueFromDataTable(dataTable, "NamesWithQuantities"));
	}
	@When("user changes quantities of Additional Crew on Rockcenter request in edit mode")
	public void editAdditionalCrewQuantity(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.changeQuantitiesOfAdditionalCrew(
				CucumberUtils.getValueFromDataTable(dataTable, "NamesWithQuantities"),RequestMode.EDIT);
	}
	@When("user removes specific Additional Crews on Rockcenter request")
	public void removeCrewsFromAdditionalCrew(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.removeSpecificAdditionalCrews(
				CucumberUtils.getValueFromDataTable(dataTable, "Additional Crew"));
	}
	@When("user removes specific Additional Crews on Rockcenter request in edit mode")
	public void removeCrewsFromAdditionalCrewInEditMode(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.removeSpecificAdditionalCrews(
				CucumberUtils.getValueFromDataTable(dataTable, "Additional Crew"),RequestMode.EDIT);
	}
	@When("user removes all Additional Crew on Rockcenter request")
	public void removeAllCrewsFromAdditionalCrew() throws Exception {
		prodRockCenterRequestFormPage.clearAdditionalCrew();
	}
	@When("user removes all Additional Crew on Rockcenter request in edit mode")
	public void removeAllCrewsFromAdditionalCrewInEditMode() throws Exception {
		prodRockCenterRequestFormPage.clearAdditionalCrew(RequestMode.EDIT);
	}
	@When("user selects fields in Systems section on Rockcenter request in edit mode")
	public void editSystemsSection(DataTable dataTable) {
		prodRockCenterRequestFormPage.selectUltimatte(
				CucumberUtils.getValueFromDataTable(dataTable, "Ultimatte"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectVoiceActivatedPrompter(
				CucumberUtils.getValueFromDataTable(dataTable, "Voice Activated Prompter"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.provideSystemNotes(
				CucumberUtils.getValueFromDataTable(dataTable, "System Notes"),RequestMode.EDIT);
	}
	@When("user selects fields in Systems section on Rockcenter request")
	public void selectSystemsSection(DataTable dataTable) {
		prodRockCenterRequestFormPage.selectUltimatte(
				CucumberUtils.getValueFromDataTable(dataTable, "Ultimatte"));
		prodRockCenterRequestFormPage.selectVoiceActivatedPrompter(
				CucumberUtils.getValueFromDataTable(dataTable, "Voice Activated Prompter"));
		prodRockCenterRequestFormPage.provideSystemNotes(
				CucumberUtils.getValueFromDataTable(dataTable, "System Notes"));
	}
	@When("user selects fields in Staging section on Rockcenter request")
	public void selectStagingSection(DataTable dataTable) {
		prodRockCenterRequestFormPage.selectIsStagingNeeded(
				CucumberUtils.getValueFromDataTable(dataTable, "Is Staging Needed"));
		prodRockCenterRequestFormPage.selectIsLightingNeeded(
				CucumberUtils.getValueFromDataTable(dataTable, "Is Lighting Needed"));
		prodRockCenterRequestFormPage.selectIsCarpentryNeeded(
				CucumberUtils.getValueFromDataTable(dataTable, "Is Carpentry Needed"));
		prodRockCenterRequestFormPage.selectArePropsNeeded(
				CucumberUtils.getValueFromDataTable(dataTable, "Are Props Needed"));
		prodRockCenterRequestFormPage.provideDescribeStagingNeeds(
				CucumberUtils.getValueFromDataTable(dataTable, "Describe Staging Needs"));
	}
	@When("user selects fields in Staging section on Rockcenter request in edit mode")
	public void editStagingSection(DataTable dataTable) {
		prodRockCenterRequestFormPage.selectIsStagingNeeded(
				CucumberUtils.getValueFromDataTable(dataTable, "Is Staging Needed"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectIsLightingNeeded(
				CucumberUtils.getValueFromDataTable(dataTable, "Is Lighting Needed"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectIsCarpentryNeeded(
				CucumberUtils.getValueFromDataTable(dataTable, "Is Carpentry Needed"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectArePropsNeeded(
				CucumberUtils.getValueFromDataTable(dataTable, "Are Props Needed"),RequestMode.EDIT);
		prodRockCenterRequestFormPage.provideDescribeStagingNeeds(
				CucumberUtils.getValueFromDataTable(dataTable, "Describe Staging Needs"),RequestMode.EDIT);
	}
	@When("user selects fields in TPM\\/TM Information section on Rockcenter request")
	public void selectTpmTmInformationSection(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.selectIsATpmOrTmNeeded(
				CucumberUtils.getValueFromDataTable(dataTable, "Is a TPM or TM Needed"));
		String option = CucumberUtils.getValueFromDataTable(dataTable, "TPM or TM Same as requester");
		prodRockCenterRequestFormPage.changeSameAsRequester(option);
		prodRockCenterRequestFormPage.selectTpmTmName(
				CucumberUtils.getValueFromDataTable(dataTable, "TPM/TM Name"));
	}
	@When("user selects fields in TPM\\/TM Information section on Rockcenter request in edit mode")
	public void editTpmTmInformationSection(DataTable dataTable) throws Exception {
		prodRockCenterRequestFormPage.selectIsATpmOrTmNeeded(
				CucumberUtils.getValueFromDataTable(dataTable, "Is a TPM or TM Needed"),RequestMode.EDIT);
		String option = CucumberUtils.getValueFromDataTable(dataTable, "TPM or TM Same as requester");
		prodRockCenterRequestFormPage.changeSameAsRequester(option,RequestMode.EDIT);
		prodRockCenterRequestFormPage.selectTpmTmName(
				CucumberUtils.getValueFromDataTable(dataTable, "TPM/TM Name"),RequestMode.EDIT);
	}
}
