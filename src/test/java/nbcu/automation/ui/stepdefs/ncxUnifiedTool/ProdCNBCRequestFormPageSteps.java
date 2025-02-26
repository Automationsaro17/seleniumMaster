package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nbcu.automation.ui.enums.RequestMode;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProdCNBCRequestFormPage;
import nbcu.framework.utils.cucumber.CucumberUtils;

public class ProdCNBCRequestFormPageSteps {

	ProdCNBCRequestFormPage prodCNBCRequestFormPage = new ProdCNBCRequestFormPage();

	// CNBC Production error field validation
	@Then("Verify error message is displayed for all mandatory fields in set Location info section In CNBC Production Form")
	public void verifySetLocationMissingFieldErrorInProductionSection(DataTable dataTable) throws Exception {
		prodCNBCRequestFormPage
				.verifySetLocationMissingFieldError(CucumberUtils.getValuesFromDataTable(dataTable, "Location Error"));
	}

	@Then("Verify error message is displayed for all mandatory fields in Control Room section In CNBC Production Form")
	public void verifyControlRoomMissingFieldErrorInProductionSection(DataTable dataTable) throws Exception {
		prodCNBCRequestFormPage.verifyControlRoomNeededMissingFieldError(
				CucumberUtils.getValuesFromDataTable(dataTable, "control Room Needed Error"));
	}

	// CNBC Production filling form
	@When("user enters show information in CNBC Production form")
	public void fillShowInfoInCNBCProduction(DataTable dataTable) throws Exception {
		prodCNBCRequestFormPage.addShowInfoInCNBCProduction(
				CucumberUtils.getValuesFromDataTable(dataTable, "Air Platform"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Sub Division"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show or Project Name"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Start Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Call Time"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Start Time"),
				CucumberUtils.getValuesFromDataTable(dataTable, "End Time"));
	}

	@When("user enters set location information in CNBC Production form")
	public void fillSetLocationInfoInCNBCProduction(DataTable dataTable) throws Exception {
		prodCNBCRequestFormPage
				.addSetLocationInfoInCNBCProduction(CucumberUtils.getValuesFromDataTable(dataTable, "Location"));
	}

	@When("user enters staging information in CNBC Production form")
	public void fillStagingInfoInCNBCProduction(DataTable dataTable) throws Exception {
		prodCNBCRequestFormPage
				.addStagingInfoInCNBCProduction(CucumberUtils.getValuesFromDataTable(dataTable, "Staging Needs"));
	}

	@When("user enters control room information in CNBC Production form")
	public void fillControlRoomInfoInCNBCProduction(DataTable dataTable) throws Exception {
		prodCNBCRequestFormPage.addControlRoomInfoInCNBCProduction(
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room Needed"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Ingest"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Iso"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room Crew"));
	}
	@When("user selects `Is a Control Room Needed?` in CNBC production form")
	public void selectIsAControlRoomNeeded(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Choice");
		prodCNBCRequestFormPage.selectIsControlRoomNeeded(option);
	}
	@Then("user verifies that Control Room Crew section and fields under the section are not displayed in CNBC production form")
	public void verifyThatControlRoomCrewSectionAndRelatedFieldsAreNotDisplayed() throws Exception {
		prodCNBCRequestFormPage.verifyIfControlRoomCrewSectionAndRelatedFieldsShouldDisplayOrNot();
	}
	@Then("user verifies that Control Room Crew section and fields under the section are displayed in CNBC production form")
	public void verifyThatControlRoomCrewSectionAndRelatedFieldsAreDisplayed() throws Exception {
		prodCNBCRequestFormPage.verifyIfControlRoomCrewSectionAndRelatedFieldsShouldDisplayOrNot();
	}
	@When("user selects `Is Budget Code Available?` on CNBC Production")
	public void selectIsBudgetCodeAvailable(DataTable dataTable) throws Exception {
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Is Budget Code Available?");
		prodCNBCRequestFormPage.selectIsBudgetCodeAvailable(option);
	}
	@Then("user verifies `Budget Code` input is disabled")
	public void verifyIfBudgetCodeInputIsEnabled() {
		prodCNBCRequestFormPage.shouldBudgetCodeInputBeEnabled();
	}
	@Then("user verifies `Budget Code` input is enabled")
	public void verifyIfBudgetCodeInputIsDisabled() {
		prodCNBCRequestFormPage.shouldBudgetCodeInputBeEnabled();
	}
	@Then("user verifies the form title on CNBC production")
	public void verifyFormTitle() throws Exception {
		prodCNBCRequestFormPage.getProducerDashboardGeneralPage().verifySelectedRequestPageDisplayed("CNBC Production");
	}
	@Then("user verifies the form sections on CNBC production form")
	public void verifyTheFormSectionsInCnbcProductionForm() {
		prodCNBCRequestFormPage.verifyTheFormSectionsInCnbcProductionForm();
	}
	@Then("user verifies the fields present in {string} section of CNBC Production form")
	public void verifyFieldsPresentSectionOfCnbcProduction(String sectionName) {
		prodCNBCRequestFormPage.checkFieldsInSectionOfCnbcProduction(sectionName);
	}
	@When("user selects {string} as Division on CNBC Production")
	public void selectDivision(String option) throws Exception {
		prodCNBCRequestFormPage.selectDivisionOnCNBCProduction(option);
	}
	@When("user selects {string} as Show Unit or Project Name on CNBC Production")
	public void selectShowUnitOrProjectName(String option) throws Exception {
		prodCNBCRequestFormPage.selectShowUnitOnCNBCProduction(option);
	}
	@When("user populates GENERAL DETAILS section on CNBC Production request")
	public void populateGeneralDetailsSection(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Division");
		prodCNBCRequestFormPage.selectDivisionOnCNBCProduction(option);
	}
	@When("user selects {string} as Request For in Production Purpose section on CNBC Production request")
	public void selectRequestForInProductionPurpose(String requestFor) throws Exception {
		prodCNBCRequestFormPage.selectRequestForOnCNBCProduction(requestFor);
	}
	@When("user gives {string} as Details & Notes in Production Purpose section on CNBC Production request")
	public void giveDetailsAndNotesInProductionPurpose(String detailsAndNotes){
		prodCNBCRequestFormPage.provideDetailsAndNotesOnCNBCProduction(detailsAndNotes);
	}
	@When("user selects Location on CNBC Production request")
	public void selectLocation(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Location");
		String locationNumber = CucumberUtils.getValuesFromDataTable(dataTable, "Location Number");
		prodCNBCRequestFormPage.selectLocationOnCNBCProduction(option,locationNumber);
	}
	@When("user selects Control Room Crew in {string} section on CNBC Production request")
	public void selectControlRoomCrew(String section,DataTable dataTable) throws Exception {
		String options=CucumberUtils.getValuesFromDataTable(dataTable, "Control Room Crew");
		prodCNBCRequestFormPage.selectControlRoomCrewOnCNBCProduction(options);
	}
	@When("user selects `ISO: Do you need ISO recordings?` on CNBC Production request")
	public void chooseDoYouNeedIsoRecordings(DataTable dataTable) throws Exception {
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Choice");
		prodCNBCRequestFormPage.selectISO(option);
	}
	@When("user selects `Ingest: Do you need content to be recorded?` on CNBC Production request")
	public void chooseIngestDoYouNeedContentToBeRecorded(DataTable dataTable){
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Choice");
		prodCNBCRequestFormPage.selectIngest(option);
	}
	@When("user selects Staging Needs on CNBC Production request")
	public void provideStagingNeeds(DataTable dataTable) throws Exception {
		String text = CucumberUtils.getValuesFromDataTable(dataTable, "Staging Needs");
		prodCNBCRequestFormPage.provideStagingNeedsOnCNBCProduction(text);
	}
	@When("user selects Set Crew on CNBC Production request")
	public void selectSetCrewOnCNBCProduction(DataTable dataTable) throws Exception {
		String options = CucumberUtils.getValuesFromDataTable(dataTable, "Set Crew");
		prodCNBCRequestFormPage.selectSetCrewOnCNBCProduction(options);
	}
	@Then("verify all fields in the CNBC form are matching with columns in production dashboard")
	public void verifyCNBCProductionDashboardValuesWithForm(DataTable dataTable) throws Exception {
		prodCNBCRequestFormPage.verifyCNBCRequestValuesWithProductionDashboardValues(
				CucumberUtils.getValuesFromDataTable(dataTable, "Requesters"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Prod Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show/Project"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Production Purpose"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Set Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Positions"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Submitted"));
	}
	@When("user selects Request For in PRODUCTION PURPOSE section on CNBC Production request")
	public void selectRequestForOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Request For");
		prodCNBCRequestFormPage.selectRequestForOnCNBCProduction(option);
	}
	@When("user gives Details & Notes in Production Purpose section on CNBC Production request")
	public void giveDetailsAndNotesInProductionPurpose(DataTable dataTable){
		String text = CucumberUtils.getValuesFromDataTable(dataTable, "Details & Notes");
		prodCNBCRequestFormPage.provideDetailsAndNotesOnCNBCProduction(text);
	}
	@When("user clicks `+ Location` on CNBC Production request")
	public void addLocation() throws Exception{
		prodCNBCRequestFormPage.addLocation();
	}
	@When("user selects Air Platform in SHOW INFO section on CNBC Production request")
	public void selectAirPlatformOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Air Platform");
		prodCNBCRequestFormPage.selectAirPlatformOnCNBCProduction(option);
	}
	@When("user selects Sub Division in SHOW INFO section on CNBC Production request")
	public void selectSubDivisionOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Sub Division");
		prodCNBCRequestFormPage.selectSubDivisionOnCNBCProduction(option);
	}
	@When("user selects Show Unit or Project Name in SHOW INFO section on CNBC Production request")
	public void selectShowUnitOrProjectNameOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit or Project Name");
		prodCNBCRequestFormPage.selectShowUnitOnCNBCProduction(option);
	}
	@When("user selects Start Date in SHOW INFO section on CNBC Production request")
	public void selectStartDateOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Days from today");
		prodCNBCRequestFormPage.selectStartDateOnCNBCProduction(option);
	}
	@When("user selects Start Time in SHOW INFO section on CNBC Production request")
	public void selectStartTimeOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Time");
		prodCNBCRequestFormPage.selectStartTimeOnCNBCProduction(option);
	}
	@When("user selects End Time in SHOW INFO section on CNBC Production request")
	public void selectEndTimeOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Time");
		prodCNBCRequestFormPage.selectEndTimeOnCNBCProduction(option);
	}
	@When("user selects Call Time in SHOW INFO section on CNBC Production request")
	public void selectCallTimeOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Time");
		prodCNBCRequestFormPage.selectCallTimeOnCNBCProduction(option);
	}
	@Then("user checks mandatory field error below `Division` on CNBC Production request")
	public void checkMandatoryFieldErrorBelowDivision() {
		prodCNBCRequestFormPage.checkMandatoryFieldErrorBelowDivision();
	}
	@Then("user checks mandatory field error below `Air Platform` on CNBC Production request")
	public void checkMandatoryFieldErrorBelowAirPlatform() {
		prodCNBCRequestFormPage.checkMandatoryFieldErrorBelowAirPlatform();
	}
	@Then("user checks mandatory field error below `Request For` on CNBC Production request")
	public void checkMandatoryFieldErrorBelowRequestFor() {
		prodCNBCRequestFormPage.checkMandatoryFieldErrorBelowRequestFor();
	}
	@Then("user checks mandatory field error below `Show Unit or Project Name` on CNBC Production request")
	public void checkMandatoryFieldErrorBelowShowUnit() {
		prodCNBCRequestFormPage.checkMandatoryFieldErrorBelowShowUnit();
	}
	@Then("user checks mandatory field error below `Budget Code` on CNBC Production request")
	public void checkMandatoryFieldErrorBelowBudgetCode() {
		prodCNBCRequestFormPage.checkMandatoryFieldErrorBelowBudgetCode(); 
	}
	@Then("user checks mandatory field error below `Start Date` on CNBC Production request")
	public void checkMandatoryFieldErrorBelowStartDate() {
		prodCNBCRequestFormPage.checkMandatoryFieldErrorBelowStartDate();
	}
	@Then("user checks mandatory field error below `Start Time` on CNBC Production request")
	public void checkMandatoryFieldErrorBelowStartTime() {
		prodCNBCRequestFormPage.checkMandatoryFieldErrorBelowStartTime();
	}
	@Then("user checks mandatory field error below `End Time` on CNBC Production request")
	public void checkMandatoryFieldErrorBelowEndTime() {
		prodCNBCRequestFormPage.checkMandatoryFieldErrorBelowEndTime();
	}
	@Then("user checks mandatory field error below `Is a Control Room Needed?` on CNBC Production request")
	public void checkMandatoryFieldErrorBelowIsAControlRoomNeeded() {
		prodCNBCRequestFormPage.checkMandatoryFieldErrorBelowIsAControlRoomNeeded();
	}
	@Then("user checks mandatory field error for `Location` on CNBC Production request")
	public void checkMandatoryFieldErrorForLocation() {
		prodCNBCRequestFormPage.checkMandatoryFieldErrorBelowLocation();
	}
	@When("user clears `Division` on CNBC Production request")
	public void clearDivisionOnCNBCProduction() throws Exception {
		prodCNBCRequestFormPage.clearDivisionOnCNBCProduction();
	}
	@When("user clears `Request For` on CNBC Production request")
	public void clearRequestForOnCNBCProduction() throws Exception {
		prodCNBCRequestFormPage.clearRequestForOnCNBCProduction();
	}
	@When("user clears `Air Platform` on CNBC Production request")
	public void clearAirPlatformOnCNBCProduction() throws Exception {
		prodCNBCRequestFormPage.clearAirPlatformOnCNBCProduction();
	}
	@When("user clears `Sub Division` on CNBC Production request")
	public void clearSubDivisionOnCNBCProduction() throws Exception {
		prodCNBCRequestFormPage.clearSubDivisionOnCNBCProduction();
	}
	@When("user clears `Show Unit or Project Name` on CNBC Production request")
	public void clearShowUnitOrProjectNameOnCNBCProduction() throws Exception {
		prodCNBCRequestFormPage.clearShowUnitOrProjectNameOnCNBCProduction();
	}
	@When("user clears `Budget Code` on CNBC Production request")
	public void clearBudgetCodeOnCNBCProduction() throws Exception {
		prodCNBCRequestFormPage.clearBudgetCodeOnCNBCProduction();
	}
	@When("user clears `Start Date` on CNBC Production request")
	public void clearStartDateOnCNBCProduction() throws Exception {
		prodCNBCRequestFormPage.clearStartDateOnCNBCProduction();
	}
	@When("user clears `Start Time` on CNBC Production request")
	public void clearStartTimeOnCNBCProduction() throws Exception {
		prodCNBCRequestFormPage.clearStartTimeOnCNBCProduction();
	}
	@When("user clears `End Time` on CNBC Production request")
	public void clearEndTimeOnCNBCProduction() throws Exception {
		prodCNBCRequestFormPage.clearEndTimeOnCNBCProduction();
	}
	@When("user clears `Call Time` on CNBC Production request on create page")
	public void clearCallTimeOnCNBCProductionOnCreatePage() throws Exception {
		prodCNBCRequestFormPage.clearCallTimeOnCNBCProduction();
	}
	@When("user clears `Call Time` on CNBC Production request in edit mode")
	public void clearCallTimeOnCNBCProductionInEditMode() throws Exception {
		prodCNBCRequestFormPage.clearCallTimeOnCNBCProduction(RequestMode.EDIT);
	}
	@When("user clears `Location` on CNBC Production request")
	public void clearLocationOnCNBCProduction(DataTable dataTable) throws Exception {
		String locationNumber = CucumberUtils.getValuesFromDataTable(dataTable, "Location Number");
		prodCNBCRequestFormPage.clearLocationOnCNBCProduction(locationNumber);
	}
	@When("user clears `Set Crew` on CNBC Production request in creation mode")
	public void clearSetCrewOnCNBCProduction() throws Exception {
		prodCNBCRequestFormPage.clearSetCrewOnCNBCProduction();
	}
	@When("user clears `Control Room Crew` on CNBC Production request in creation mode")
	public void clearControlRoomCrewOnCNBCProduction() throws Exception {
		prodCNBCRequestFormPage.clearControlRoomCrewOnCNBCProduction();
	}
	@When("user clears `Set Crew` on CNBC Production request in edit mode")
	public void clearSetCrewOnCNBCProductionInEditMode() throws Exception {
		prodCNBCRequestFormPage.clearSetCrewOnCNBCProduction(RequestMode.EDIT);
	}
	@When("user clears `Control Room Crew` on CNBC Production request in edit mode")
	public void clearControlRoomCrewOnCNBCProductionInEditMode() throws Exception {
		prodCNBCRequestFormPage.clearControlRoomCrewOnCNBCProduction(RequestMode.EDIT);
	}
	@Then("user checks placeholder of `Location` field on CNBC Production request")
	public void checkPlaceholderOfLocation() {
		prodCNBCRequestFormPage.checkLocationInputPlaceholder();
	}
	@Then("user checks placeholder of `Request For` field on CNBC Production request")
	public void checkPlaceholderOfRequestFor() {
		prodCNBCRequestFormPage.checkRequestForInputPlaceholder();
	}
	@Then("user checks placeholder of `Division` field on CNBC Production request")
	public void checkDivisionInputPlaceholder() {
		prodCNBCRequestFormPage.checkDivisionInputPlaceholder();
	}
	@Then("user checks correct Ingest option is selected on CNBC Production readonly request")
	public void checkIfIngestOptionIsCorrectlyDisplayedInReadOnlyCNBCProduction() {
		prodCNBCRequestFormPage.checkIfIngestOptionIsCorrectlyDisplayedInReadOnlyCNBCProduction();
	}
	@Then("user checks correct ISO option is selected on CNBC Production readonly request")
	public void checkIfIsoOptionIsCorrectlyDisplayedInReadOnlyCNBCProduction() {
		prodCNBCRequestFormPage.checkIfIsoOptionIsCorrectlyDisplayedInReadOnlyCNBCProduction();
	}
	@Then("user checks correct Control Room Crew selections are displayed on CNBC Production readonly request")
	public void checkIfCorrectControlRoomCrewSelectionsDisplayedInReadOnlyCNBCProduction() {
		prodCNBCRequestFormPage.checkIfCorrectControlRoomCrewSelectionsDisplayedInReadOnlyCNBCProduction();
	}
	@Then("user checks correct Control Room Crew selections are not expandable before fulfilment on CNBC Production readonly request")
	public void checkControlRoomCrewSelectionsUnexpandableInReadOnlyCNBCProductionBeforeFulfillment() {
		prodCNBCRequestFormPage.checkControlRoomCrewSelectionsUnexpandableInReadOnlyCNBCProductionBeforeFulfillment();
	}
	@Then("user checks correct Set Crew selections are displayed on CNBC Production readonly request")
	public void checkIfCorrectSetCrewSelectionsDisplayedInReadOnlyCNBCProduction() {
		prodCNBCRequestFormPage.checkIfCorrectSetCrewSelectionsDisplayedInReadOnlyCNBCProduction();
	}
	@Then("user checks correct Set Crew selections are not expandable before fulfilment on CNBC Production readonly request")
	public void checkSetCrewSelectionsUnexpandableInReadOnlyCNBCProductionBeforeFulfillment() {
		prodCNBCRequestFormPage.checkSetCrewSelectionsUnexpandableInReadOnlyCNBCProductionBeforeFulfillment();
	}
	@Then("user checks correct Control Room Needed option is selected on CNBC Production readonly request")
	public void checkIfControlRoomNeededOptionIsCorrectlyDisplayedInReadOnlyCNBCProduction() {
		prodCNBCRequestFormPage.checkIfControlRoomNeededOptionIsCorrectlyDisplayedInReadOnlyCNBCProduction();
	}
	@Then("user checks correct Location selections are displayed on CNBC Production readonly request")
	public void checkIfCorrectLocationSelectionsDisplayedInReadOnlyCNBCProduction() {
		prodCNBCRequestFormPage.checkIfCorrectLocationSelectionsDisplayedInReadOnlyCNBCProduction();
	}
	@Then("user checks correct Air Platform selection is displayed on CNBC Production readonly request")
	public void checkIfCorrectAirPlatformSelectionDisplayedInReadOnlyCNBCProduction() {
		prodCNBCRequestFormPage.checkIfCorrectAirPlatformSelectionDisplayedInReadOnlyCNBCProduction();
	}
	@Then("user checks correct Show Unit or Project Name selection is displayed on CNBC Production readonly request")
	public void checkIfCorrectShowUnitOrProjectNameSelectionDisplayedInReadOnlyCNBCProduction() {
		prodCNBCRequestFormPage.checkIfCorrectShowUnitOrProjectNameSelectionDisplayedInReadOnlyCNBCProduction();
	}
	@Then("user checks correct Sub Division selection is displayed on CNBC Production readonly request")
	public void checkIfSubDivisionSelectionDisplayedInReadOnlyCNBCProduction() {
		prodCNBCRequestFormPage.checkIfSubDivisionSelectionDisplayedInReadOnlyCNBCProduction();
	}
	@Then("user checks correct Budget Code selection is displayed on CNBC Production readonly request")
	public void checkIfBudgetCodeSelectionDisplayedInReadOnlyCNBCProduction() {
		prodCNBCRequestFormPage.checkIfBudgetCodeSelectionDisplayedInReadOnlyCNBCProduction();
	}
	@Then("user checks correct Start Date selection is displayed on CNBC Production readonly request")
	public void checkIfStartDateSelectionDisplayedInReadOnlyCNBCProduction() {
		prodCNBCRequestFormPage.checkIfStartDateSelectionDisplayedInReadOnlyCNBCProduction();
	}
	@Then("user checks correct Call Time selection is displayed on CNBC Production readonly request")
	public void checkIfCallTimeSelectionDisplayedInReadOnlyCNBCProduction() {
		prodCNBCRequestFormPage.checkIfCallTimeSelectionDisplayedInReadOnlyCNBCProduction();
	}
	@Then("user checks correct Start Time selection is displayed on CNBC Production readonly request")
	public void checkIfStartTimeSelectionDisplayedInReadOnlyCNBCProduction() {
		prodCNBCRequestFormPage.checkIfStartTimeSelectionDisplayedInReadOnlyCNBCProduction();
	}
	@Then("user checks correct End Time selection is displayed on CNBC Production readonly request")
	public void checkIfEndTimeSelectionDisplayedInReadOnlyCNBCProduction() {
		prodCNBCRequestFormPage.checkIfEndTimeSelectionDisplayedInReadOnlyCNBCProduction();
	}
	@Then("user checks correct Request For selection is displayed on CNBC Production readonly request")
	public void checkIfRequestForSelectionDisplayedInReadOnlyCNBCProduction() {
		prodCNBCRequestFormPage.checkIfRequestForSelectionDisplayedInReadOnlyCNBCProduction();
	}
	@When("user edits `Is a Control Room Needed?` in CNBC production form")
	public void editIsAControlRoomNeededInEditMode(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Choice");
		prodCNBCRequestFormPage.selectIsControlRoomNeeded(option,RequestMode.EDIT);
	}
	@When("user edits `Is Budget Code Available?` on CNBC Production")
	public void editIsBudgetCodeAvailableInEditMode(DataTable dataTable) throws Exception {
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Is Budget Code Available?");
		prodCNBCRequestFormPage.selectIsBudgetCodeAvailable(option,RequestMode.EDIT);
	}
	@When("user edits Division and selects {string} on CNBC Production")
	public void editDivision(String option) throws Exception {
		prodCNBCRequestFormPage.selectDivisionOnCNBCProduction(option,RequestMode.EDIT);
	}
	@When("user edits Show Unit or Project Name and selects {string} on CNBC Production")
	public void editShowUnitOrProjectName(String option) throws Exception {
		prodCNBCRequestFormPage.selectShowUnitOnCNBCProduction(option,RequestMode.EDIT);
	}
	@When("user edits Request For and selects {string} in Production Purpose section on CNBC Production request")
	public void editRequestForInProductionPurpose(String requestFor) throws Exception {
		prodCNBCRequestFormPage.selectRequestForOnCNBCProduction(requestFor,RequestMode.EDIT);
	}
	@When("user edits Details & Notes and gives {string} in Production Purpose section on CNBC Production request")
	public void editDetailsAndNotesInProductionPurpose(String detailsAndNotes){
		prodCNBCRequestFormPage.provideDetailsAndNotesOnCNBCProduction(detailsAndNotes,RequestMode.EDIT);
	}
	@When("user edits Location on CNBC Production request")
	public void editLocation(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Location");
		String locationNumber = CucumberUtils.getValuesFromDataTable(dataTable, "Location Number");
		prodCNBCRequestFormPage.selectLocationOnCNBCProduction(option,locationNumber,RequestMode.EDIT);
	}
	@When("user edits Control Room Crew on CNBC Production request")
	public void editControlRoomCrew(String section,DataTable dataTable) throws Exception {
		String options=CucumberUtils.getValuesFromDataTable(dataTable, "Control Room Crew");
		prodCNBCRequestFormPage.selectControlRoomCrewOnCNBCProduction(options,RequestMode.EDIT);
	}
	@When("user edits `ISO: Do you need ISO recordings?` on CNBC Production request")
	public void editDoYouNeedIsoRecordings(DataTable dataTable) throws Exception {
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Choice");
		prodCNBCRequestFormPage.selectISO(option,RequestMode.EDIT);
	}
	@When("user edits `Ingest: Do you need content to be recorded?` on CNBC Production request")
	public void editIngestDoYouNeedContentToBeRecorded(DataTable dataTable){
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Choice");
		prodCNBCRequestFormPage.selectIngest(option,RequestMode.EDIT);
	}
	@When("user edits Staging Needs on CNBC Production request")
	public void editStagingNeeds(DataTable dataTable) throws Exception {
		String text = CucumberUtils.getValuesFromDataTable(dataTable, "Staging Needs");
		prodCNBCRequestFormPage.provideStagingNeedsOnCNBCProduction(text,RequestMode.EDIT);
	}
	@When("user adds Set Crew on CNBC Production request in edit mode")
	public void editSetCrewOnCNBCProduction(DataTable dataTable) throws Exception {
		String options = CucumberUtils.getValuesFromDataTable(dataTable, "Set Crew");
		prodCNBCRequestFormPage.selectSetCrewOnCNBCProduction(options,RequestMode.EDIT);
	}
	@When("user edits Request For on CNBC Production request")
	public void editRequestForOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Request For");
		prodCNBCRequestFormPage.selectRequestForOnCNBCProduction(option,RequestMode.EDIT);
	}
	@When("user edits Details & Notes on CNBC Production request")
	public void editDetailsAndNotesInProductionPurpose(DataTable dataTable){
		String text = CucumberUtils.getValuesFromDataTable(dataTable, "Details & Notes");
		prodCNBCRequestFormPage.provideDetailsAndNotesOnCNBCProduction(text,RequestMode.EDIT);
	}
	@When("user edits Air Platform on CNBC Production request")
	public void editAirPlatformOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Air Platform");
		prodCNBCRequestFormPage.selectAirPlatformOnCNBCProduction(option,RequestMode.EDIT);
	}
	@When("user edits Sub Division on CNBC Production request")
	public void editSubDivisionOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Sub Division");
		prodCNBCRequestFormPage.selectSubDivisionOnCNBCProduction(option,RequestMode.EDIT);
	}
	@When("user edits Show Unit or Project Name on CNBC Production request")
	public void editShowUnitOrProjectNameOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit or Project Name");
		prodCNBCRequestFormPage.selectShowUnitOnCNBCProduction(option,RequestMode.EDIT);
	}
	@When("user edits Start Date on CNBC Production request")
	public void editStartDateOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Days from today");
		prodCNBCRequestFormPage.selectStartDateOnCNBCProduction(option,RequestMode.EDIT);
	}
	@When("user edits Start Time on CNBC Production request")
	public void editStartTimeOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Time");
		prodCNBCRequestFormPage.selectStartTimeOnCNBCProduction(option,RequestMode.EDIT);
	}
	@When("user edits End Time on CNBC Production request")
	public void editEndTimeOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Time");
		prodCNBCRequestFormPage.selectEndTimeOnCNBCProduction(option,RequestMode.EDIT);
	}
	@When("user edits Call Time on CNBC Production request")
	public void editCallTimeOnCNBCProduction(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Time");
		prodCNBCRequestFormPage.selectCallTimeOnCNBCProduction(option,RequestMode.EDIT);
	}
	@When("user removes Control Room Crew from Control Room Crew on CNBC Production request in edit mode")
	public void removeSpecificControlRoomCrews(DataTable dataTable) throws Exception {
		String crewNames = CucumberUtils.getValuesFromDataTable(dataTable, "Control Room Crew");
		prodCNBCRequestFormPage.removeSpecificControlRoomCrews(crewNames,RequestMode.EDIT);
	}
	@When("user removes Set Crew from Set Crew on CNBC Production request in edit mode")
	public void removeSpecificSetCrew(DataTable dataTable) throws Exception {
		String crewNames = CucumberUtils.getValuesFromDataTable(dataTable, "Set Crew");
		prodCNBCRequestFormPage.removeSpecificSetCrews(crewNames,RequestMode.EDIT);
	}
	@Then("user checks whether the sections are marked either checked or crossed or neither")
	public void checkSectionsAreCorrectlyCheckedOrCrossedOnCNBCProduction() {
		prodCNBCRequestFormPage.checkSectionsAreCorrectlyCheckedOrCrossedOnCNBCProduction();
	}
	@When("user selects fields in SHOW INFO section on CNBC Production request")
	public void selectFieldsInShowInfoSection(DataTable dataTable) throws Exception{
		prodCNBCRequestFormPage.selectAirPlatformOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Air Platform"));
		prodCNBCRequestFormPage.selectSubDivisionOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Sub Division"));
		prodCNBCRequestFormPage.selectShowUnitOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Show Unit or Project Name"));
		prodCNBCRequestFormPage.selectStartDateOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Days from today"));
		prodCNBCRequestFormPage.selectStartTimeOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Start Time"));
		prodCNBCRequestFormPage.selectEndTimeOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "End Time"));
		prodCNBCRequestFormPage.selectCallTimeOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Call Time"));
	}
	@When("user populates PRODUCTION PURPOSE section on CNBC Production request")
	public void populateProductionPurposeSection(DataTable dataTable) throws Exception {
		prodCNBCRequestFormPage.selectRequestForOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Request For"));
		prodCNBCRequestFormPage.provideDetailsAndNotesOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Details & Notes"));
	}
	@When("user populates PRODUCTION PURPOSE section on CNBC Production request in edit mode")
	public void populateProductionPurposeSectionInEditMode(DataTable dataTable) throws Exception {
		prodCNBCRequestFormPage.selectRequestForOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Request For")
				,RequestMode.EDIT);
		prodCNBCRequestFormPage.provideDetailsAndNotesOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Details & Notes")
				,RequestMode.EDIT);
	}
	@When("user selects fields in Control Room Crew section on CNBC Production request")
	public void selectFieldsInControlRoomCrewSection(DataTable dataTable) throws Exception {
		prodCNBCRequestFormPage.selectIngest(CucumberUtils.getValueFromDataTable(dataTable, "Ingest"));
		prodCNBCRequestFormPage.selectISO(CucumberUtils.getValueFromDataTable(dataTable, "ISO"));
		prodCNBCRequestFormPage.selectControlRoomCrewOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Control Room Crew"));
	}
	@When("user edits fields in Control Room Crew section on CNBC Production request")
	public void selectFieldsInControlRoomCrewSectionInEditMode(DataTable dataTable) throws Exception {
		prodCNBCRequestFormPage.selectIngest(CucumberUtils.getValueFromDataTable(dataTable, "Ingest"),RequestMode.EDIT);
		prodCNBCRequestFormPage.selectISO(CucumberUtils.getValueFromDataTable(dataTable, "ISO"),RequestMode.EDIT);
		prodCNBCRequestFormPage.selectControlRoomCrewOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Control Room Crew"),RequestMode.EDIT);
	}
	@When("user edits fields in SHOW INFO section on CNBC Production request in edit mode")
	public void selectFieldsInShowInfoSectionInEditSection(DataTable dataTable) throws Exception{
		prodCNBCRequestFormPage.selectAirPlatformOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Air Platform")
				,RequestMode.EDIT);
		prodCNBCRequestFormPage.selectSubDivisionOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Sub Division")
				,RequestMode.EDIT);
		prodCNBCRequestFormPage.selectShowUnitOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Show Unit or Project Name")
				,RequestMode.EDIT);
		prodCNBCRequestFormPage.selectStartDateOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Days from today")
				,RequestMode.EDIT);
		prodCNBCRequestFormPage.selectStartTimeOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Start Time")
				,RequestMode.EDIT);
		prodCNBCRequestFormPage.selectEndTimeOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "End Time")
				,RequestMode.EDIT);
		prodCNBCRequestFormPage.selectCallTimeOnCNBCProduction(CucumberUtils.getValueFromDataTable(dataTable, "Call Time")
				,RequestMode.EDIT);
	}
	@When("user removes location from Set Location section on CNBC Production in create mode")
	public void removeLocationInCreateMode(DataTable dataTable) throws Exception {
		String locationNumber = CucumberUtils.getValueFromDataTable(dataTable, "Location Number");
		prodCNBCRequestFormPage.removeLocationOnCNBCProduction(locationNumber);
	}
	@When("user removes location from Set Location section on CNBC Production in edit mode")
	public void removeLocationInEditMode(DataTable dataTable) throws Exception {
		String locationNumber = CucumberUtils.getValueFromDataTable(dataTable, "Location Number");
		prodCNBCRequestFormPage.removeLocationOnCNBCProduction(locationNumber, RequestMode.EDIT);
	}
	@When("user selects `Is a Control Room Needed?` in CNBC production form in edit mode")
	public void selectIsAControlRoomNeededInEditMode(DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Choice");
		prodCNBCRequestFormPage.selectIsControlRoomNeeded(option,RequestMode.EDIT);
	}
	@Then("user modifies the Set Crew Member quantities in fulfillment")
	public void increaseSetCrewMemberQuantitiesInFulfillment() {
		prodCNBCRequestFormPage.modifySetCrewMemberQuantitiesInFulfillment(RequestMode.EDIT);
	}
	@Then("user provides the Set Crew Member names in fulfillment")
	public void provideSetCrewMembersInFulfillment() {
		prodCNBCRequestFormPage.provideSetCrewMembersInFulfillment(RequestMode.EDIT);
	}
	@Then("user deletes Set Crew Member names in fulfillment randomly")
	public void deleteSetCrewMembersInFulfillmentRandomly() {
		prodCNBCRequestFormPage.deleteSetCrewMembersInFulfillmentRandomly(RequestMode.EDIT);
	}
	@Then("user deletes Set Crew names in fulfillment")
	public void deleteSetCrewInFulfillment(DataTable dataTable) {
		String setCrew = CucumberUtils.getValuesFromDataTable(dataTable, "Set Crew");
		prodCNBCRequestFormPage.deleteSetCrewInFulfillment(setCrew,RequestMode.EDIT);
	}
	@Then("user modifies the Control Room Crew Member quantities in fulfillment")
	public void increaseControlRoomCrewMemberQuantitiesInFulfillment() {
		prodCNBCRequestFormPage.modifyControlRoomCrewMemberQuantitiesInFulfillment(RequestMode.EDIT);
	}
	@Then("user provides the Control Room Crew Member names in fulfillment")
	public void provideControlRoomCrewMembersInFulfillment() {
		prodCNBCRequestFormPage.provideControlRoomCrewMembersInFulfillment(RequestMode.EDIT);
	}
	@Then("user deletes Control Room Crew Member names in fulfillment randomly")
	public void deleteControlRoomCrewMembersInFulfillmentRandomly() {
		prodCNBCRequestFormPage.deleteControlRoomCrewMembersInFulfillmentRandomly(RequestMode.EDIT);
	}
	@Then("user deletes Control Room Crew names in fulfillment")
	public void deleteControlRoomCrewInFulfillment(DataTable dataTable) {
		String setCrew = CucumberUtils.getValuesFromDataTable(dataTable, "Control Room Crew");
		prodCNBCRequestFormPage.deleteControlRoomCrewInFulfillment(setCrew,RequestMode.EDIT);
	}
	@Then("user completes below status in fulfillment")
	public void checkStatusOnFulfillment(DataTable dataTable) throws Exception {
		prodCNBCRequestFormPage.checkStatusOnFulfillment(CucumberUtils.getValuesFromDataTable(dataTable, "Status"),RequestMode.EDIT);
	}
	@Then("user clears below status in fulfillment")
	public void clearStatusOnFulfillment(DataTable dataTable) throws Exception {
		prodCNBCRequestFormPage.clearStatusOnFulfillment(CucumberUtils.getValuesFromDataTable(dataTable, "Status"),RequestMode.EDIT);
	}
}
