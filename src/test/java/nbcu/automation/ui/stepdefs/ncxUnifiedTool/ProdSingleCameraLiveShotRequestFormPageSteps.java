package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nbcu.automation.ui.enums.RequestMode;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProdRockCenterRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProdSingleCameraLiveShotRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProducerDashboardGeneralPage;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.utils.cucumber.CucumberUtils;
import nbcu.framework.utils.propertyfilereader.ExcelReader;

public class ProdSingleCameraLiveShotRequestFormPageSteps {

	ProdSingleCameraLiveShotRequestFormPage prodSingleCameraLiveShotRequestFormPage = new ProdSingleCameraLiveShotRequestFormPage();
	CommonValidations commonValidations = new CommonValidations();
	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	@Then("Verify error message is displayed for all mandatory fields in Set Information section In Single Camera Live Shot Production Form")
	public void verifySetInformationMissingFieldError(DataTable dataTable) throws Exception {
		prodSingleCameraLiveShotRequestFormPage.verifySetInformationMissingFieldError(
				CucumberUtils.getValuesFromDataTable(dataTable, "Set Background Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Set Staging Needed Error"));
	}

	@When("user enters set information in Single Camera Live Shot Production form")
	public void fillSetInformation(DataTable dataTable) throws Exception {
		prodSingleCameraLiveShotRequestFormPage.selectSetInformation(
				CucumberUtils.getValuesFromDataTable(dataTable, "Set Background"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Set Staging Needed"));
	}

	@When("user enters set crew in Single Camera Live Shot Production form")
	public void fillSystemInfoInRockCenterProduction(DataTable dataTable) throws Exception {
		prodSingleCameraLiveShotRequestFormPage.addSetCrew(
				CucumberUtils.getValuesFromDataTable(dataTable, "Capture Manager"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Set Crew"));
	}

	@Then("user verifies the form sections on Single Camera Live Shot production form")
	public void verifyTheFormSectionsInSingleCameraLiveShotForm() {
		prodSingleCameraLiveShotRequestFormPage.verifyTheFormSectionsInSingleCameraLiveShotForm();
	}

	@Then("user verifies the fields present in {string} section of Single Live Camera Shot form")
	public void verifyFieldsPresentOnSectionOfSingleCameraLiveShot(String sectionName) {
		if (sectionName != null) {
			prodSingleCameraLiveShotRequestFormPage.checkFieldsInSectionOfSingleCameraLiveShot(sectionName);
		}
	}

	@When("user provides notes under Details and Notes section")
	public void addDetailsAndNotes(DataTable dataTable) throws Exception {
		prodSingleCameraLiveShotRequestFormPage
				.addDetailsAndNotes(CucumberUtils.getValuesFromDataTable(dataTable, "Notes"));
	}

	@When("user selects set background option from the dropdown")
	public void selectSetBackground(DataTable dataTable) throws Exception {
		prodSingleCameraLiveShotRequestFormPage
				.selectSetBackground(CucumberUtils.getValuesFromDataTable(dataTable, "Set Background"));
	}

	@Then("verify all fields in the Single Camera Live Shot form are matching with columns in production dashboard")
	public void verifySingleCameraLiveShotProductionDashboardValuesWithForm(DataTable dataTable) throws Exception {
		prodSingleCameraLiveShotRequestFormPage.verifySingleCameraLiveShotRequestValuesWithProductionDashboardValues(
				CucumberUtils.getValuesFromDataTable(dataTable, "Requesters"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Prod Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show/Project"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Production Purpose"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Set Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Positions"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Submitted"));
	}
	@When("user selects `Staging: are changes needed?` on Single Camera Live Shot request")
	public void selectStagingSetChangedNeeded(DataTable dataTable) {
		prodSingleCameraLiveShotRequestFormPage.selectStagingSetChangedNeeded(CucumberUtils.getValueFromDataTable(dataTable, "Choice"));
	}
	@When("user selects `Capture Manager: Do you need content to be recorded?` on Single Camera Live Shot request")
	public void selectCaptureManager(DataTable dataTable) {
		prodSingleCameraLiveShotRequestFormPage.selectCaptureManager(CucumberUtils.getValueFromDataTable(dataTable, "Choice"));
	}
	@When("user selects fields in Set Information section on Single Camera Live Shot request")
	public void selectSetInformationSection(DataTable dataTable) {
		prodSingleCameraLiveShotRequestFormPage.selectSetBackgroundInSetInformation(
				CucumberUtils.getValueFromDataTable(dataTable, "Set Background"));
		prodSingleCameraLiveShotRequestFormPage.selectStagingSetChangedNeeded(
				CucumberUtils.getValueFromDataTable(dataTable, "Staging"));
	}
	@When("user selects fields in Set Information section on Single Camera Live Shot request in edit mode")
	public void editSetInformationSection(DataTable dataTable) {
		prodSingleCameraLiveShotRequestFormPage.selectSetBackgroundInSetInformation(
				CucumberUtils.getValueFromDataTable(dataTable, "Set Background"),RequestMode.EDIT);
		prodSingleCameraLiveShotRequestFormPage.selectStagingSetChangedNeeded(
				CucumberUtils.getValueFromDataTable(dataTable, "Staging"),RequestMode.EDIT);
	}
	@When("user selects fields in Set Crew section on Single Camera Live Shot request in edit mode")
	public void editSetCrewSection(DataTable dataTable) {
		prodSingleCameraLiveShotRequestFormPage.selectCaptureManager(
				CucumberUtils.getValueFromDataTable(dataTable, "Capture Manager"),RequestMode.EDIT);
		prodSingleCameraLiveShotRequestFormPage.selectSetCrew(
				CucumberUtils.getValueFromDataTable(dataTable, "Set Crew"),RequestMode.EDIT);
	}
	@When("user selects fields in Set Crew section on Single Camera Live Shot request")
	public void selectSetCrewSection(DataTable dataTable) {
		prodSingleCameraLiveShotRequestFormPage.selectCaptureManager(
				CucumberUtils.getValueFromDataTable(dataTable, "Capture Manager"));
		prodSingleCameraLiveShotRequestFormPage.selectSetCrew(
				CucumberUtils.getValueFromDataTable(dataTable, "Set Crew"));
	}
	@When("user changes quantities of Set Crew on Single Camera Live Shot request")
	public void changeSetCrewQuantity(DataTable dataTable) {
		prodSingleCameraLiveShotRequestFormPage.changeQuantitiesOfSetCrew(
				CucumberUtils.getValueFromDataTable(dataTable, "NamesWithQuantities"));
	}
	@When("user changes quantities of Set Crew on Single Camera Live Shot request in edit mode")
	public void editSetCrewQuantity(DataTable dataTable) {
		prodSingleCameraLiveShotRequestFormPage.changeQuantitiesOfSetCrew(
				CucumberUtils.getValueFromDataTable(dataTable, "NamesWithQuantities"),RequestMode.EDIT);
	}
	@When("user removes specific crews on Single Camera Live Shot request")
	public void removeCrewsFromSetCrew(DataTable dataTable) throws Exception {
		prodSingleCameraLiveShotRequestFormPage.removeSpecificSetCrews(
				CucumberUtils.getValueFromDataTable(dataTable, "Crews"));
	}
	@When("user removes specific crews on Single Camera Live Shot request in edit mode")
	public void removeCrewsFromSetCrewInEditMode(DataTable dataTable) throws Exception {
		prodSingleCameraLiveShotRequestFormPage.removeSpecificSetCrews(
				CucumberUtils.getValueFromDataTable(dataTable, "Crews"),RequestMode.EDIT);
	}
	@When("user removes all Set Crew on Single Camera Live Shot request")
	public void removeAllCrewsFromSetCrew() throws Exception {
		prodSingleCameraLiveShotRequestFormPage.clearSetCrewOnSCLS();
	}
	@When("user removes all Set Crew on Single Camera Live Shot request in edit mode")
	public void removeAllCrewsFromSetCrewInEditMode() throws Exception {
		prodSingleCameraLiveShotRequestFormPage.clearSetCrewOnSCLS(RequestMode.EDIT);
	}
	@When("user selects fields in Show Info section on Single Camera Live Shot request")
	public void selectShowInfoSection(DataTable dataTable) throws Exception {
		prodSingleCameraLiveShotRequestFormPage.selectAirPlatform(
				CucumberUtils.getValueFromDataTable(dataTable, "Air Platform"));
		prodSingleCameraLiveShotRequestFormPage.selectShowUnit(
				CucumberUtils.getValueFromDataTable(dataTable, "Show Unit or Project Name"));
		prodSingleCameraLiveShotRequestFormPage.selectOtherInShowInfo(
				CucumberUtils.getValueFromDataTable(dataTable, "Other"));
		prodSingleCameraLiveShotRequestFormPage.selectIsBudgetCodeAvailable(
				CucumberUtils.getValueFromDataTable(dataTable, "Is Budget Code Available"));
		prodSingleCameraLiveShotRequestFormPage.selectBudgetCode(
				CucumberUtils.getValueFromDataTable(dataTable, "Budget Code"));
		prodSingleCameraLiveShotRequestFormPage.selectWorkOrderInShowInfo(
				CucumberUtils.getValueFromDataTable(dataTable, "Work Order"));
		prodSingleCameraLiveShotRequestFormPage.selectStartDate(
				CucumberUtils.getValueFromDataTable(dataTable, "Days from today"));
		prodSingleCameraLiveShotRequestFormPage.selectPrepTime(
				CucumberUtils.getValueFromDataTable(dataTable, "Prep Time"));
		prodSingleCameraLiveShotRequestFormPage.selectStartTime(
				CucumberUtils.getValueFromDataTable(dataTable, "Start Time"));
		prodSingleCameraLiveShotRequestFormPage.selectEndTime(
				CucumberUtils.getValueFromDataTable(dataTable, "End Time"));
	}
	@When("user selects fields in Show Info section on Single Camera Live Shot request in edit mode")
	public void editShowInfoSection(DataTable dataTable) throws Exception {
		prodSingleCameraLiveShotRequestFormPage.selectAirPlatform(
				CucumberUtils.getValueFromDataTable(dataTable, "Air Platform"),RequestMode.EDIT);
		prodSingleCameraLiveShotRequestFormPage.selectShowUnit(
				CucumberUtils.getValueFromDataTable(dataTable, "Show Unit or Project Name"),RequestMode.EDIT);
		prodSingleCameraLiveShotRequestFormPage.selectOtherInShowInfo(
				CucumberUtils.getValueFromDataTable(dataTable, "Other"),RequestMode.EDIT);
		prodSingleCameraLiveShotRequestFormPage.selectIsBudgetCodeAvailable(
				CucumberUtils.getValueFromDataTable(dataTable, "Is Budget Code Available"),RequestMode.EDIT);
		prodSingleCameraLiveShotRequestFormPage.selectBudgetCode(
				CucumberUtils.getValueFromDataTable(dataTable, "Budget Code"),RequestMode.EDIT);
		prodSingleCameraLiveShotRequestFormPage.selectWorkOrderInShowInfo(
				CucumberUtils.getValueFromDataTable(dataTable, "Work Order"),RequestMode.EDIT);
		prodSingleCameraLiveShotRequestFormPage.selectStartDate(
				CucumberUtils.getValueFromDataTable(dataTable, "Days from today"),RequestMode.EDIT);
		prodSingleCameraLiveShotRequestFormPage.selectPrepTime(
				CucumberUtils.getValueFromDataTable(dataTable, "Prep Time"),RequestMode.EDIT);
		prodSingleCameraLiveShotRequestFormPage.selectStartTime(
				CucumberUtils.getValueFromDataTable(dataTable, "Start Time"),RequestMode.EDIT);
		prodSingleCameraLiveShotRequestFormPage.selectEndTime(
				CucumberUtils.getValueFromDataTable(dataTable, "End Time"),RequestMode.EDIT);
	}
	@When("user provides Details and Notes on Single Camera Live Shot request in edit mode")
	public void editDetailsAndNotes(DataTable dataTable) throws Exception {
		prodSingleCameraLiveShotRequestFormPage.provideDetailsAndNotes(
				CucumberUtils.getValueFromDataTable(dataTable, "Details and Notes"),RequestMode.EDIT);
	}
	@When("user provides Details and Notes on Single Camera Live Shot request")
	public void provideDetailsAndNotes(DataTable dataTable) throws Exception {
		prodSingleCameraLiveShotRequestFormPage.provideDetailsAndNotes(
				CucumberUtils.getValueFromDataTable(dataTable, "Details and Notes"));
	}
	@When("user clears Details and Notes on Single Camera Live Shot request in edit mode")
	public void clearDetailsAndNotesInEditMode() throws Exception {
		prodSingleCameraLiveShotRequestFormPage.clearDetailsAndNotes(RequestMode.EDIT);
	}
	@When("user clears Details and Notes on Single Camera Live Shot request")
	public void clearDetailsAndNotes() throws Exception {
		prodSingleCameraLiveShotRequestFormPage.clearDetailsAndNotes();
	}
	@When("user selects Division on Single Camera Live Shot request")
	public void selectDivision(DataTable dataTable) throws Exception {
		prodSingleCameraLiveShotRequestFormPage.selectDivision(
				CucumberUtils.getValueFromDataTable(dataTable, "Division"));
	}
	@When("user clears End Time on Single Camera Live Shot request")
	public void clearEndTime() throws Exception {
		prodSingleCameraLiveShotRequestFormPage.clearEndTime();
	}
	@When("user clears Start Time on Single Camera Live Shot request")
	public void clearStartTime() throws Exception {
		prodSingleCameraLiveShotRequestFormPage.clearStartTime();
	}
	@When("user clears Start Date on Single Camera Live Shot request")
	public void clearStartDate() throws Exception {
		prodSingleCameraLiveShotRequestFormPage.clearStartDate();
	}
	@When("user clears Prep Time on Single Camera Live Shot request")
	public void clearPrepTime() throws Exception {
		prodSingleCameraLiveShotRequestFormPage.clearPrepTime();
	}
	@When("user clears Prep Time on Single Camera Live Shot request in edit mode")
	public void clearPrepTimeInEditMode() throws Exception {
		prodSingleCameraLiveShotRequestFormPage.clearPrepTime(RequestMode.EDIT);
	}
	@Then("user completes below status in fulfillment on Single Camera Live Shot Request")
	public void checkStatusOnFulfillment(DataTable dataTable) throws Exception {
		prodSingleCameraLiveShotRequestFormPage.checkStatusOnFulfillment(
				CucumberUtils.getValuesFromDataTable(dataTable, "Status"),RequestMode.EDIT);
	}
	@Then("user clears below status in fulfillment on Single Camera Live Shot Request")
	public void clearStatusOnFulfillment(DataTable dataTable) throws Exception {
		prodSingleCameraLiveShotRequestFormPage.clearStatusOnFulfillment(
				CucumberUtils.getValuesFromDataTable(dataTable, "Status"),RequestMode.EDIT);
	}
	@Then("user modifies the Set Crew Member quantities in fulfillment on Single Camera Live Shot")
	public void increaseSetCrewMemberQuantitiesInFulfillment() {
		prodSingleCameraLiveShotRequestFormPage.modifySetCrewMemberQuantitiesInFulfillment(RequestMode.EDIT);
	}
	@Then("user provides the Set Crew Member names in fulfillment on Single Camera Live Shot")
	public void provideSetCrewMembersInFulfillment() {
		prodSingleCameraLiveShotRequestFormPage.provideSetCrewMembersInFulfillment(RequestMode.EDIT);
	}
	@Then("user deletes Set Crew Member names in fulfillment randomly on Single Camera Live Shot")
	public void deleteSetCrewMembersInFulfillmentRandomly() {
		prodSingleCameraLiveShotRequestFormPage.deleteSetCrewMembersInFulfillmentRandomly(RequestMode.EDIT);
	}
	@Then("user deletes Set Crew names in fulfillment on Single Camera Live Shot")
	public void deleteSetCrewInFulfillment(DataTable dataTable) {
		String setCrew = CucumberUtils.getValuesFromDataTable(dataTable, "Set Crew");
		prodSingleCameraLiveShotRequestFormPage.deleteSetCrewInFulfillment(setCrew,RequestMode.EDIT);
	}
}
