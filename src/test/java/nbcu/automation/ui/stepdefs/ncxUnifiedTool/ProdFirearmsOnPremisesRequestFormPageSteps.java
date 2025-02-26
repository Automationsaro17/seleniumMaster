package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProdAnimalOnPremisesRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProdFirearmsOnPremisesRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProdRockCenterRequestFormPage;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.utils.cucumber.CucumberUtils;
import nbcu.framework.utils.propertyfilereader.ExcelReader;

public class ProdFirearmsOnPremisesRequestFormPageSteps {

	ProdFirearmsOnPremisesRequestFormPage prodFirearmsOnPremisesRequestFormPage = new ProdFirearmsOnPremisesRequestFormPage();

	@Then("Verify error message is displayed for all mandatory fields in Firearms Information section For Firearms on Premises Production form")
	public void verifyFirearmInfoMissingFieldError(DataTable dataTable) throws Exception {
		prodFirearmsOnPremisesRequestFormPage.verifyFirearmsInfoMissingFieldError(
				CucumberUtils.getValuesFromDataTable(dataTable, "Type Of Firearm Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "How Many Firearm Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Firearm Type Error"));
	}

	@When("user enters Firearms information for Firearms on Premises Production form")
	public void fillFirearmInformation(DataTable dataTable) throws Exception {
		prodFirearmsOnPremisesRequestFormPage.addFirearmsInformation(
				CucumberUtils.getValuesFromDataTable(dataTable, "Type Of Firearm"),
				CucumberUtils.getValuesFromDataTable(dataTable, "How Many Firearm"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Firearm Type"));
	}
	@Then("user verifies the form sections on {string} form")
	public void verifyFormSectionsInFirearmsOnPremisesForm(String formName) {
		prodFirearmsOnPremisesRequestFormPage.verifyFormSectionsInFirearmsOnPremisesForm();
	}
	@Then("user verifies the fields present in {string} section of Firearms on Premises Production form")
	public void verifyFieldsPresentSectionOfCnbcProduction(String sectionName) {
		prodFirearmsOnPremisesRequestFormPage.checkFieldsInSectionOfFirearmsOnPremisesProduction(sectionName);
	}
	@When("user clicks on + Firearm button in {string} section of Firearm on Premises Production form")
	public void addFirearm(String sectionName) {
		prodFirearmsOnPremisesRequestFormPage.addFirearm(1);
	}
	@When("user clicks on + Location button in {string} section of Firearm on Premises Production form")
	public void addLocation(String sectionName) {
		prodFirearmsOnPremisesRequestFormPage.addLocation(1);
	}
	@Then("user checks error for {string} required field in {string} section on Firearm on Premises Production request")
	public void checkRequiredFieldErrorIfEmpty(String field, String sectionName){
		prodFirearmsOnPremisesRequestFormPage.verifyErrorBelowFieldIfEmpty(field);
	}
	@Then("user checks error not displayed for {string} required field in {string} section on Firearm on Premises Production request")
	public void checkRequiredFieldErrorIfNotEmpty(String field, String sectionName){
		prodFirearmsOnPremisesRequestFormPage.verifyErrorBelowFieldIfNotEmpty(field);
	}
	@Then("user checks placeholder of Talent field in {string} section on Firearm on Premises Production request")
	public void checkPlaceholderOfTalentInput(String sectionName) {
		prodFirearmsOnPremisesRequestFormPage.getProducerDashboardGeneralPage().checkPlaceholderForInputsHavingPlaceholderAttribute("Talent");
	}
	@Then("user checks placeholder of {string} field in {string} section on Firearm on Premises Production request")
	public void checkPlaceholderOfField(String field, String sectionName) {
		prodFirearmsOnPremisesRequestFormPage.checkPlaceholderOfSelectFields(field);
	}
	@When("user clears Details and Notes in {string} section on Firearms on Premises production request")
	public void clearInputOfTheField(String section){
		prodFirearmsOnPremisesRequestFormPage.clearTextareaInput("Details and Notes",0);
	}
	@Then("user verifies the form sections on Firearms on Premises production form")
	public void verifyTheFormSectionsInFirearmsOnPremisesProductionForm() {
		prodFirearmsOnPremisesRequestFormPage.verifyTheFormSectionsInFirearmsOnPremisesProductionForm();
	}
	@When("user selects Type of Firearm\\(s) in {string} section on Firearms on Premises production request")
	public void provideTypeOfFirearms(String section,DataTable dataTable) throws Exception {
		String position=CucumberUtils.getValuesFromDataTable(dataTable, "Position");
		String text=CucumberUtils.getValuesFromDataTable(dataTable, "Type of Firearm(s)");
		prodFirearmsOnPremisesRequestFormPage.fillTextbox("Type of Firearm(s)",text,position);
	}
	@When("user selects How Many in {string} section on Firearms on Premises production request")
	public void selectHowMany(String section,DataTable dataTable) throws Exception {
		String position=CucumberUtils.getValuesFromDataTable(dataTable, "Position");
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "How Many");
		Integer quantity = Integer.parseInt(option);
		prodFirearmsOnPremisesRequestFormPage.selectQuantity("How Many",quantity,position);
	}
	@When("user selects Type in {string} section on Firearms on Premises production request")
	public void selectType(String section,DataTable dataTable) throws Exception {
		String position=CucumberUtils.getValuesFromDataTable(dataTable, "Position");
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Type");
		prodFirearmsOnPremisesRequestFormPage.selectRadioOption("Type",option,position);
	}
	@When("user selects Location in {string} section on Firearms on Premises production request")
	public void selectLocation(String section,DataTable dataTable) throws Exception {
		String position=CucumberUtils.getValuesFromDataTable(dataTable, "Position");
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Location");
		prodFirearmsOnPremisesRequestFormPage.selectValueInDropdown(option, "Location", position);
	}
	@When("user selects Set Location in {string} section on Firearms on Premises production request")
	public void selectSetLocation(String section,DataTable dataTable) throws Exception {
		String position=CucumberUtils.getValuesFromDataTable(dataTable, "Position");
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Set Location");
		prodFirearmsOnPremisesRequestFormPage.selectValueInDropdown(option, "Set Location", position);
	}
	@When("user selects Address in {string} section on Firearms on Premises production request")
	public void provideAddress(String section,DataTable dataTable) throws Exception {
		String position=CucumberUtils.getValuesFromDataTable(dataTable, "Position");
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Address");
		prodFirearmsOnPremisesRequestFormPage.fillTextbox("Address", option, position);
	}
	@When("user selects Details and Notes in {string} section on Firearms on Premises production request")
	public void provideDetailsAndNotes(String section,DataTable dataTable) throws Exception {
		String text=CucumberUtils.getValuesFromDataTable(dataTable, "Details and Notes");
		prodFirearmsOnPremisesRequestFormPage.fillTextbox("Details and Notes",text,"0");
	}
	@When("user selects Division in {string} section on Firearms on Premises production request")
	public void selectDivision(String section,DataTable dataTable) throws Exception {
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Division");
		prodFirearmsOnPremisesRequestFormPage.selectValueInDropdown(option, "Division", "0");
	}
	@When("user selects Air Platform in {string} section on Firearms on Premises production request")
	public void selectAirPlatform(String section,DataTable dataTable) throws Exception {
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Air Platform");
		prodFirearmsOnPremisesRequestFormPage.selectValueInDropdown(option, "Air Platform", "0");
	}
	@When("user selects Show Unit or Project Name in {string} section on Firearms on Premises production request")
	public void selectShowUnitOrProjectName(String section,DataTable dataTable) throws Exception {
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit or Project Name");
		prodFirearmsOnPremisesRequestFormPage.selectValueInDropdown(option, "Show Unit or Project Name", "0");
	}
	@When("user selects Work Order # in {string} section on Firearms on Premises production request")
	public void provideWorkOrder(String section,DataTable dataTable) throws Exception {
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Work Order #");
		prodFirearmsOnPremisesRequestFormPage.fillTextbox("Work Order #",option, "0");
	}
	@When("user selects Arrival Date in {string} section on Firearms on Premises production request")
	public void setArrivalDate(String section,DataTable dataTable) throws Exception {
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Arrival Date");
		prodFirearmsOnPremisesRequestFormPage.selectDate("Arrival Date", option, "0");
	}
	@When("user selects Departure Date in {string} section on Firearms on Premises production request")
	public void setDepartureDate(String section,DataTable dataTable) throws Exception {
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Departure Date");
		prodFirearmsOnPremisesRequestFormPage.selectDate("Departure Date", option, "0");
	}
	@When("user selects Arrival Time in {string} section on Firearms on Premises production request")
	public void setArrivalTime(String section,DataTable dataTable) throws Exception {
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Arrival Time");
		prodFirearmsOnPremisesRequestFormPage.fillTextbox("Arrival Time", option, "0");
	}
	@When("user selects Departure Time in {string} section on Firearms on Premises production request")
	public void setDepartureTime(String section,DataTable dataTable) throws Exception {
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Departure Time");
		prodFirearmsOnPremisesRequestFormPage.fillTextbox("Departure Time", option, "0");
	}
	@When("user selects Other in {string} section on Firearms on Premises production request")
	public void setOtherInShowInfo(String section,DataTable dataTable) throws Exception {
		String option=CucumberUtils.getValuesFromDataTable(dataTable, "Other");
		prodFirearmsOnPremisesRequestFormPage.fillTextbox("Other", option, "0");
	}
	@Then("user verifies the value displayed for {string} field in SHOW INFO section in readonly mode on Firearms on Premises production request")
	public void verifyInputInShowInfoInReadOnlyForm(String field) throws Exception {
		prodFirearmsOnPremisesRequestFormPage.verifyInputInShowInfoSectionInReadOnlyForm(field);
	}
	@Then("user verifies the values displayed in SET LOCATION section in readonly mode on Firearms on Premises production request")
	public void verifyInputsInSetLocationSectionInReadOnlyForm() throws Exception {
		prodFirearmsOnPremisesRequestFormPage.verifyInputsInSetLocationSectionInReadOnlyForm();
	}
	@Then("user verifies the values displayed in FIREARM\\(S) INFORMATION section in readonly mode on Firearms on Premises production request")
	public void verifyInputsInFirearmsInformationSectionInReadOnlyForm() throws Exception {
		prodFirearmsOnPremisesRequestFormPage.verifyFirearmsInformationSectionInReadOnlyMode();
	}
	@Then("user verifies the value displayed for Details and Notes field in DETAILS section in readonly mode on Firearms on Premises production request")
	public void verifyDetailsAndNotesInReadOnlyForm() throws Exception {
		prodFirearmsOnPremisesRequestFormPage.verifyInputsInDetailsSectionInReadOnlyForm();
	}
	@Then("user verifies the Talents in TALENT section in readonly mode on Firearms on Premises production request")
	public void verifyAddedTalentsDisplayedInReadOnlyForm() throws Exception {
		prodFirearmsOnPremisesRequestFormPage.getProducerDashboardGeneralPage().verifyAddedTalentsDisplayedInReadOnlyForm();
	}
	@Then("user verifies that status of Firearms on Premises production request is {string}")
	public void verifyStatusOfRequest(String expectedStatus) throws Exception {
		prodFirearmsOnPremisesRequestFormPage.getProducerDashboardGeneralPage().verifyStatusOfTheRequest(expectedStatus);
	}
	@Then("user verifies the value displayed for Division field in GENERAL DETAILS section in readonly mode on Firearms on Premises production request")
	public void verifyDivisionInGeneralDetailsSectionInReadOnlyForm() throws Exception {
		prodFirearmsOnPremisesRequestFormPage.verifyDivisionInGeneralDetailsSectionInReadOnlyForm();
	}

}
