package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nbcu.automation.ui.enums.RequestMode;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProdExtendorBridgeCrewRequestFormPage;
import nbcu.framework.utils.cucumber.CucumberUtils;

public class ProdExtendorBridgeCrewRequestFormPageSteps {

	ProdExtendorBridgeCrewRequestFormPage prodExtendorBridgeCrewRequestFormPage = new ProdExtendorBridgeCrewRequestFormPage();

	@Then("Verify error message is displayed for all mandatory fields in show info section for Extend or Bridge Crew Production form")
	public void verifyShowInfoMissingFieldError(DataTable dataTable) throws Exception {
		prodExtendorBridgeCrewRequestFormPage.verifyShowInfoMissingFieldError(
				CucumberUtils.getValuesFromDataTable(dataTable, "Request For Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Air Platform Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Budget Code Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Start Date Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Start Time Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "End Time Error"));

	}

	@Then("Verify error message is displayed for all mandatory fields in Control Room & Crew section for Extend or Bridge Crew Production form")
	public void verifyControlRoomAndCrewMissingFieldErrorInProductionSection(DataTable dataTable) throws Exception {
		prodExtendorBridgeCrewRequestFormPage.verifyControlRoomAndCrewMissingFieldError(
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room And Crew Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room Location Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "control Room Error"));
	}

	@When("user enters show information in Extend or Bridge Crew Production form")
	public void fillShowInfo(DataTable dataTable) throws Exception {
		prodExtendorBridgeCrewRequestFormPage.addShowInfoExtendorBridgeCrewProduction(
				CucumberUtils.getValuesFromDataTable(dataTable, "Request For"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Air Platform"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show or Project Name"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Start Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Start Time"),
				CucumberUtils.getValuesFromDataTable(dataTable, "End Time"));
	}

	@When("user enters control room and crew information in Extend or Bridge Crew Production form")
	public void fillControlRoomInfoInRockCenterProduction(DataTable dataTable) throws Exception {
		prodExtendorBridgeCrewRequestFormPage.addControlRoomAndCrewInfo(
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room And Crew Option"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room"));
	}

	@Then("user verifies the form sections on Extend or Bridge Crew & Facilities production form")
	public void verifyTheFormSectionsInAnimalsOnPremisesProductionForm() {
		prodExtendorBridgeCrewRequestFormPage.verifyTheFormSectionsInExtendOrBrigeCrewAndFacilitiesProductionForm();
	}

	@Then("user verifies the fields present in {string} section of Extend or Bridge Crew & Facilities Production form")
	public void verifyFieldsPresentSectionOfCnbcProduction(String sectionName) {
		prodExtendorBridgeCrewRequestFormPage
				.checkFieldsInSectionOfExtendOrBridgeCrewAndFacilitiesProduction(sectionName);
	}

	@Then("user checks placeholder of Talent field in {string} section on Extend or Bridge Crew & Facilities Production request")
	public void checkPlaceholderOfTalentInput(String sectionName) {
		prodExtendorBridgeCrewRequestFormPage.getProducerDashboardGeneralPage()
				.checkPlaceholderForInputsHavingPlaceholderAttribute("Talent");
	}

	@Then("user checks placeholder of Show Unit or Project Name field in {string} section on Extend or Bridge Crew & Facilities Production request")
	public void checkPlaceholderofShowUnitOrProjectName(String sectionName) {
		prodExtendorBridgeCrewRequestFormPage
				.checkPlaceholderForInputsHavingPlaceholderAttribute("Show Unit or Project Name", 0, sectionName);
	}

	@Then("user checks placeholder of {string} field in {string} section on Extend or Bridge Crew & Facilities Production request")
	public void checkPlaceholderOfField(String field, String sectionName) {
		prodExtendorBridgeCrewRequestFormPage.checkPlaceholderOfSelectFields(field, sectionName);
	}

	@Then("user checks error for {string} required field in {string} section on Extend or Bridge Crew & Facilities Production request")
	public void checkRequiredFieldErrorIfEmpty(String field, String sectionName) {
		prodExtendorBridgeCrewRequestFormPage.verifyErrorBelowFieldIfEmpty(field, sectionName);
	}

	@Then("user checks error not displayed for {string} required field in {string} section on Extend or Bridge Crew & Facilities Production request")
	public void checkRequiredFieldErrorIfNotEmpty(String field, String sectionName) {
		prodExtendorBridgeCrewRequestFormPage.verifyErrorBelowFieldIfNotEmpty(field, sectionName);
	}

	@When("user clears Details and Notes on Extend or Bridge Crew & Facilities production request")
	public void clearDetailsAndNotes() {
		prodExtendorBridgeCrewRequestFormPage.clearDetailsAndNotesOnExtendOrBridgeProduction();
	}

	@Then("user checks `TPM/TM Name` field is readonly on Extend or Bridge Crew & Facilities production request")
	public void isTpmTmNameInputReadonly() {
		prodExtendorBridgeCrewRequestFormPage.isTpmTmNameInputReadonly();
	}

	@Then("user checks `TPM/TM Name` field is enabled on Extend or Bridge Crew & Facilities production request")
	public void isTpmTmNameInputEnabled() {
		prodExtendorBridgeCrewRequestFormPage.isTpmTmNameInputEnabled();
	}

	@Then("user checks `Same as requester?` checkbox is disabled on Extend or Bridge Crew & Facilities production request")
	public void isSameAsRequesterCheckboxDisabled() {
		prodExtendorBridgeCrewRequestFormPage.isSameAsRequesterCheckboxDisabled();
	}

	@Then("user checks `Same as requester?` checkbox is enabled on Extend or Bridge Crew & Facilities production request")
	public void isSameAsRequesterCheckboxEnabled() {
		prodExtendorBridgeCrewRequestFormPage.isSameAsRequesterCheckboxEnabled();
	}

	@When("user selects Location on Extend or Bridge Crew & Facilities production request")
	public void selectLocation(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Location");
		prodExtendorBridgeCrewRequestFormPage.selectLocationOnExtendOrBridgeProduction(option);
	}

	@When("user selects Set Location on Extend or Bridge Crew & Facilities production request")
	public void selectSetLocation(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Set Location");
		prodExtendorBridgeCrewRequestFormPage.selectSetLocationOnExtendOrBridgeProduction(option);
	}

	@When("user selects Address in Set Location & Crew on Extend or Bridge Crew & Facilities production request")
	public void fillAddressInSetLocationAndCrew(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Address");
		prodExtendorBridgeCrewRequestFormPage.selectAddressOnSetLocationAndCrew(option);
	}

	@When("user selects Control Room & Crew on Extend or Bridge Crew & Facilities production request")
	public void selectControlRoomAndCrew(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Control Room & Crew");
		prodExtendorBridgeCrewRequestFormPage.selectControlRoomAndCrew(option);
	}

	@When("user selects Control Room Location on Extend or Bridge Crew & Facilities production request")
	public void selectControlRoomLocation(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Control Room Location");
		prodExtendorBridgeCrewRequestFormPage.selectControlRoomLocation(option);
	}

	@When("user selects Control Room on Extend or Bridge Crew & Facilities production request")
	public void selectControlRoom(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Control Room");
		prodExtendorBridgeCrewRequestFormPage.selectControlRoom(option);
	}

	@When("user selects Details and Notes on Extend or Bridge Crew & Facilities production request")
	public void fillDetailsAndNotes(DataTable dataTable) throws Exception {
		String text = CucumberUtils.getValueFromDataTable(dataTable, "Details and Notes");
		prodExtendorBridgeCrewRequestFormPage.provideDetailsAndNotesOnExtendOrBridgeProduction(text);
	}

	@When("user selects Division on Extend or Bridge Crew & Facilities production request")
	public void selectDivision(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Division");
		prodExtendorBridgeCrewRequestFormPage.selectDivisionOnExtendOrBridgeProduction(option);
	}

	@When("user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request")
	public void selectIsATpmOrTmNeeded(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Choice");
		prodExtendorBridgeCrewRequestFormPage.selectIsATpmOrTmNeeded(option);
	}

	@When("user selects `Same as requester?` on Extend or Bridge Crew & Facilities production request")
	public void selectSameAsRequester() throws Exception {
		prodExtendorBridgeCrewRequestFormPage.selectSameAsRequester();
	}

	@When("user selects TPM\\/TM Name on Extend or Bridge Crew & Facilities production request")
	public void selectTpmTmName(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "TPM/TM Name");
		prodExtendorBridgeCrewRequestFormPage.selectTpmTmNameOnExtendOrBridgeProduction(option);
	}

	@When("user selects Air Platform on Extend or Bridge Crew & Facilities production request")
	public void selectAirPlatform(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Air Platform");
		prodExtendorBridgeCrewRequestFormPage.selectAirPlatformOnExtendOrBridgeProduction(option);
	}

	@When("user selects Request For on Extend or Bridge Crew & Facilities production request")
	public void selectRequestFor(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Request For");
		prodExtendorBridgeCrewRequestFormPage.selectRequestFor(option);
	}

	@When("user selects Show Unit or Project Name on Extend or Bridge Crew & Facilities production request")
	public void selectShowUnitOrProjectName(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Show Unit or Project Name");
		prodExtendorBridgeCrewRequestFormPage.selectShowUnitOnExtendOrBridgeProduction(option);
	}

	@When("user selects Work Order # on Extend or Bridge Crew & Facilities production request")
	public void provideWorkOrder(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Work Order");
		prodExtendorBridgeCrewRequestFormPage.selectWorkOrderOnExtendOrBridgeProduction(option);
	}

	@When("user selects Budget Code on Extend or Bridge Crew & Facilities production request")
	public void selectBudgetCode(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Budget Code");
		prodExtendorBridgeCrewRequestFormPage.selectBudgetCodeOnExtendOrBridgeProduction(option);
	}

	@When("user selects Start Date on Extend or Bridge Crew & Facilities production request")
	public void selectStartDate(DataTable dataTable) throws Exception {
		String offset = CucumberUtils.getValueFromDataTable(dataTable, "Days from today");
		prodExtendorBridgeCrewRequestFormPage.selectStartDateOnExtendOrBridgeProduction(offset);
	}

	@When("user selects Start Time on Extend or Bridge Crew & Facilities production request")
	public void selectStartTime(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Start Time");
		prodExtendorBridgeCrewRequestFormPage.selectStartTimeOnExtendOrBridgeProduction(option);
	}

	@When("user selects End Time on Extend or Bridge Crew & Facilities production request")
	public void selectEndTime(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "End Time");
		prodExtendorBridgeCrewRequestFormPage.selectEndTimeOnExtendOrBridgeProduction(option);
	}

	@When("user selects Other on Extend or Bridge Crew & Facilities production request")
	public void provideTextInOther(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Other");
		prodExtendorBridgeCrewRequestFormPage.selectOtherOnExtendOrBridgeProduction(option);
	}

	@Then("verify all fields in the Extend or Bridge form are matching with columns in production dashboard")
	public void verifyExtendBridgeProductionDashboardValuesWithForm(DataTable dataTable) throws Exception {
		prodExtendorBridgeCrewRequestFormPage.verifyExtendBridgeRequestValuesWithProductionDashboardValues(
				CucumberUtils.getValuesFromDataTable(dataTable, "Requesters"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Prod Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show/Project"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Production Purpose"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Set Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Submitted"));
	}
	@Then("user checks `Control Room Location` field is disabled on Extend or Bridge Crew & Facilities production request")
	public void isControlRoomLocationInputDisabled() {
		prodExtendorBridgeCrewRequestFormPage.isControlRoomLocationInputDisabled();
	}
	@Then("user checks `Control Room` field is disabled on Extend or Bridge Crew & Facilitmies production request")
	public void isControlRoomInputDisabled() {
		prodExtendorBridgeCrewRequestFormPage.isControlRoomInputDisabled();
	}
	@When("user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request")
	public void selectFieldsInShowInfoSection(DataTable dataTable) throws Exception{
		selectRequestFor(dataTable);
		selectAirPlatform(dataTable);
		selectShowUnitOrProjectName(dataTable);
		provideWorkOrder(dataTable);
		selectStartDate(dataTable);
		selectStartTime(dataTable);
		selectEndTime(dataTable);
	}
	@When("user selects Address in Control Room & Crew on Extend or Bridge Crew & Facilities production request")
	public void fillAddressInControlRoomAndCrew(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Address");
		prodExtendorBridgeCrewRequestFormPage.selectAddressOnControlRoomAndCrew(option);
	}
	@When("user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request")
	public void selectFieldsInControlRoomAndCrewSection(DataTable dataTable) throws Exception{
		selectControlRoomAndCrew(dataTable);
		selectControlRoomLocation(dataTable);
		selectControlRoom(dataTable);
		fillAddressInControlRoomAndCrew(dataTable);
	}
	@When("user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request")
	public void selectFieldsInSetLocationAndCrewSection(DataTable dataTable) throws Exception{
		selectLocation(dataTable);
		selectSetLocation(dataTable);
		fillAddressInSetLocationAndCrew(dataTable);
	}
	@When("user selects Location on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editLocation(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Location");
		prodExtendorBridgeCrewRequestFormPage.selectLocationOnExtendOrBridgeProduction(option,RequestMode.EDIT);
	}

	@When("user selects Set Location on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editSetLocation(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Set Location");
		prodExtendorBridgeCrewRequestFormPage.selectSetLocationOnExtendOrBridgeProduction(option,RequestMode.EDIT);
	}

	@When("user selects Address in Set Location & Crew on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editAddressInSetLocationAndCrew(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Address");
		prodExtendorBridgeCrewRequestFormPage.selectAddressOnSetLocationAndCrew(option,RequestMode.EDIT);
	}
	@When("user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editFieldsInSetLocationAndCrewSection(DataTable dataTable) throws Exception{
		editLocation(dataTable);
		editSetLocation(dataTable);
		editAddressInSetLocationAndCrew(dataTable);
	}
	@When("user selects Other on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editTextInOther(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Other");
		prodExtendorBridgeCrewRequestFormPage.selectOtherOnExtendOrBridgeProduction(option,RequestMode.EDIT);
	}
	@When("user selects Air Platform on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editAirPlatform(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Air Platform");
		prodExtendorBridgeCrewRequestFormPage.selectAirPlatformOnExtendOrBridgeProduction(option,RequestMode.EDIT);
	}

	@When("user selects Request For on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editRequestFor(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Request For");
		prodExtendorBridgeCrewRequestFormPage.selectRequestFor(option,RequestMode.EDIT);
	}

	@When("user selects Show Unit or Project Name on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editShowUnitOrProjectName(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Show Unit or Project Name");
		prodExtendorBridgeCrewRequestFormPage.selectShowUnitOnExtendOrBridgeProduction(option,RequestMode.EDIT);
	}
	@When("user selects Work Order # on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editWorkOrder(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Work Order");
		prodExtendorBridgeCrewRequestFormPage.selectWorkOrderOnExtendOrBridgeProduction(option,RequestMode.EDIT);
	}

	@When("user selects Budget Code on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editBudgetCode(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Budget Code");
		prodExtendorBridgeCrewRequestFormPage.selectBudgetCodeOnExtendOrBridgeProduction(option,RequestMode.EDIT);
	}

	@When("user selects Start Date on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editStartDate(DataTable dataTable) throws Exception {
		String offset = CucumberUtils.getValueFromDataTable(dataTable, "Days from today");
		prodExtendorBridgeCrewRequestFormPage.selectStartDateOnExtendOrBridgeProduction(offset,RequestMode.EDIT);
	}

	@When("user selects Start Time on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editStartTime(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Start Time");
		prodExtendorBridgeCrewRequestFormPage.selectStartTimeOnExtendOrBridgeProduction(option,RequestMode.EDIT);
	}

	@When("user selects End Time on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editEndTime(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "End Time");
		prodExtendorBridgeCrewRequestFormPage.selectEndTimeOnExtendOrBridgeProduction(option,RequestMode.EDIT);
	}
	@When("user clears End Time on Extend or Bridge Crew & Facilities production request")
	public void clearEndTime() throws Exception {
		prodExtendorBridgeCrewRequestFormPage.clearEndTime();
	}
	@When("user clears Start Time on Extend or Bridge Crew & Facilities production request")
	public void clearStartTime() throws Exception {
		prodExtendorBridgeCrewRequestFormPage.clearStartTime();
	}
	@When("user clears Start Date on Extend or Bridge Crew & Facilities production request")
	public void clearStartDate() throws Exception {
		prodExtendorBridgeCrewRequestFormPage.clearStartDate();
	}
	@When("user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editFieldsInShowInfoSection(DataTable dataTable) throws Exception{
		editRequestFor(dataTable);
		editAirPlatform(dataTable);
		editShowUnitOrProjectName(dataTable);
		editWorkOrder(dataTable);
		editStartDate(dataTable);
		editStartTime(dataTable);
		editEndTime(dataTable);
		editTextInOther(dataTable);
		editBudgetCode(dataTable);
	}
	@When("user selects Control Room & Crew on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editControlRoomAndCrew(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Control Room & Crew");
		prodExtendorBridgeCrewRequestFormPage.selectControlRoomAndCrew(option,RequestMode.EDIT);
	}

	@When("user selects Control Room Location on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editControlRoomLocation(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Control Room Location");
		prodExtendorBridgeCrewRequestFormPage.selectControlRoomLocation(option,RequestMode.EDIT);
	}

	@When("user selects Control Room on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editControlRoom(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Control Room");
		prodExtendorBridgeCrewRequestFormPage.selectControlRoom(option,RequestMode.EDIT);
	}
	@When("user selects Address in Control Room & Crew on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editAddressInControlRoomAndCrew(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Address");
		prodExtendorBridgeCrewRequestFormPage.selectAddressOnControlRoomAndCrew(option,RequestMode.EDIT);
	}
	@When("user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editFieldsInControlRoomAndCrewSection(DataTable dataTable) throws Exception{
		editControlRoomAndCrew(dataTable);
		editControlRoomLocation(dataTable);
		editControlRoom(dataTable);
		editAddressInControlRoomAndCrew(dataTable);
	}
	@Then("user completes below status in fulfillment on Extend or Bridge Crew & Facilities Request")
	public void checkStatusOnFulfillment(DataTable dataTable) throws Exception {
		prodExtendorBridgeCrewRequestFormPage.checkStatusOnFulfillment(CucumberUtils.getValuesFromDataTable(dataTable, "Status"),RequestMode.EDIT);
	}
	@Then("user clears below status in fulfillment on Extend or Bridge Crew & Facilities Request")
	public void clearStatusOnFulfillment(DataTable dataTable) throws Exception {
		prodExtendorBridgeCrewRequestFormPage.clearStatusOnFulfillment(CucumberUtils.getValuesFromDataTable(dataTable, "Status"),RequestMode.EDIT);
	}
	@When("user selects Details and Notes on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editDetailsAndNotes(DataTable dataTable) throws Exception {
		String text = CucumberUtils.getValueFromDataTable(dataTable, "Details and Notes");
		prodExtendorBridgeCrewRequestFormPage.provideDetailsAndNotesOnExtendOrBridgeProduction(text,RequestMode.EDIT);
	}
	@When("user clears Details and Notes on Extend or Bridge Crew & Facilities production request in edit mode")
	public void clearDetailsAndNotesInEditMode() {
		prodExtendorBridgeCrewRequestFormPage.clearDetailsAndNotesOnExtendOrBridgeProduction(RequestMode.EDIT);
	}
	@When("user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editIsATpmOrTmNeeded(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "Choice");
		prodExtendorBridgeCrewRequestFormPage.selectIsATpmOrTmNeeded(option,RequestMode.EDIT);
	}
	@When("user selects TPM\\/TM Name on Extend or Bridge Crew & Facilities production request in edit mode")
	public void editTpmTmName(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValueFromDataTable(dataTable, "TPM/TM Name");
		prodExtendorBridgeCrewRequestFormPage.selectTpmTmNameOnExtendOrBridgeProduction(option,RequestMode.EDIT);
	}
}
