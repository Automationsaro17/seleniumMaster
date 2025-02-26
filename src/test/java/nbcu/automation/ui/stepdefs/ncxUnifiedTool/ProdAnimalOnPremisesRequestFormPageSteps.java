package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProdAnimalOnPremisesRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProdRockCenterRequestFormPage;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.utils.cucumber.CucumberUtils;
import nbcu.framework.utils.propertyfilereader.ExcelReader;

public class ProdAnimalOnPremisesRequestFormPageSteps {

	ProdAnimalOnPremisesRequestFormPage prodAnimalOnPremisesRequestFormPage = new ProdAnimalOnPremisesRequestFormPage();

	@Then("Verify error message is displayed for all mandatory fields in Handlers Information section For Animals on Premises Production form")
	public void verifyHandlersInfoMissingFieldError(DataTable dataTable) throws Exception {
		prodAnimalOnPremisesRequestFormPage.verifyHandlersInfoMissingFieldError(
				CucumberUtils.getValuesFromDataTable(dataTable, "Handlers Name Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Handlers Email Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Handlers Phone Error"));
	}

	@Then("Verify error message is displayed for all mandatory fields in Animals Information section For Animals on Premises Production form")
	public void verifyAnimalsInfoMissingFieldError(DataTable dataTable) throws Exception {
		prodAnimalOnPremisesRequestFormPage.verifyAnimalsInfoMissingFieldError(
				CucumberUtils.getValuesFromDataTable(dataTable, "Animal Type Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Animal Weight Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Animal HowMany Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Animal Handler Error"));
	}

	// Animals on Premises Production filling form

	@When("user enters Handlers information for Animals on Premises Production form")
	public void fillHandlersInformation(DataTable dataTable) throws Exception {
		prodAnimalOnPremisesRequestFormPage.addHandlersInformation(
				CucumberUtils.getValuesFromDataTable(dataTable, "Handlers Name"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Handlers Email"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Handlers Phone"));
	}

	@When("user enters Animals information for Animals on Premises Production form")
	public void fillAnimalsInformation(DataTable dataTable) throws Exception {
		prodAnimalOnPremisesRequestFormPage.addAnimalsInformation(
				CucumberUtils.getValuesFromDataTable(dataTable, "Animal Type"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Animal Weight"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Animal HowMany"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Animal Handler"));
	}

	@Then("user verifies the fields present in {string} section of Animals on Premises Production form")
	public void verifyFieldsPresentSectionOfCnbcProduction(String sectionName) {
		prodAnimalOnPremisesRequestFormPage.checkFieldsInSectionOfAnimalsOnPremisesProduction(sectionName);
	}

	@Then("user checks placeholder of {string} field in {string} section on Animals on Premises Production request")
	public void checkPlaceholderOfField(String field, String sectionName) {
		prodAnimalOnPremisesRequestFormPage.checkPlaceholderOfSelectFields(field);
	}

	@Then("user checks placeholder of Talent field in {string} section on Animals on Premises Production request")
	public void checkPlaceholderOfTalentField(String sectionName) {
		prodAnimalOnPremisesRequestFormPage.getProducerDashboardGeneralPage()
				.checkPlaceholderForInputsHavingPlaceholderAttribute("Talent");
	}

	@Then("user checks error for {string} required field in {string} section on Animals on Premises Production request")
	public void checkRequiredFieldErrorIfEmpty(String field, String sectionName) {
		prodAnimalOnPremisesRequestFormPage.verifyErrorBelowFieldIfEmpty(field);
	}

	@Then("user checks error not displayed for {string} required field in {string} section on Animals on Premises Production request")
	public void checkRequiredFieldErrorIfNotEmpty(String field, String sectionName) {
		prodAnimalOnPremisesRequestFormPage.verifyErrorBelowFieldIfNotEmpty(field);
	}

	@When("user clears Details and Notes in {string} section on Animals on Premises production request")
	public void clearDetailsAndNotes(String sectionName) {
		prodAnimalOnPremisesRequestFormPage.clearTextareaInput("Details and Notes", 0);
	}

	@When("user clicks on `+ Handler` button in {string} section of Animals on Premises Production form")
	public void addHandler(String sectionName) {
		prodAnimalOnPremisesRequestFormPage.addHandler(1);
	}

	@When("user clicks on `+ Animal` button in {string} section of Animals on Premises Production form")
	public void addAnimal(String sectionName) {
		prodAnimalOnPremisesRequestFormPage.addAnimal(1);
	}

	@When("user clicks on `+ Location` button in {string} section of Animals on Premises Production form")
	public void addLocation(String sectionName) {
		prodAnimalOnPremisesRequestFormPage.addLocation(1);
	}

	@Then("user verifies the form sections on Animals on Premises production form")
	public void verifyTheFormSectionsInAnimalsOnPremisesProductionForm() {
		prodAnimalOnPremisesRequestFormPage.verifyTheFormSectionsInAnimalsOnPremisesProductionForm();
	}

	@When("user selects Weight in {string} section on Animals on Premises production request")
	public void selectWeight(String sectionName, DataTable dataTable) throws Exception {
		String position = CucumberUtils.getValuesFromDataTable(dataTable, "Position");
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Weight");
		prodAnimalOnPremisesRequestFormPage.selectValueInDropdown(option, "Weight", position);
	}

	@When("user selects Handler in {string} section on Animals on Premises production request")
	public void selectHandler(String sectionName, DataTable dataTable) throws Exception {
		String position = CucumberUtils.getValuesFromDataTable(dataTable, "Position");
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Handler");
		prodAnimalOnPremisesRequestFormPage.selectValueInDropdown(option, "Handler", position);
	}

	@When("user selects How Many in {string} section on Animals on Premises production request")
	public void selectHowMany(String sectionName, DataTable dataTable) throws Exception {
		String position = CucumberUtils.getValuesFromDataTable(dataTable, "Position");
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "How Many");
		Integer quantity = Integer.parseInt(option);
		prodAnimalOnPremisesRequestFormPage.selectQuantity("How Many", quantity, position);
	}

	@When("user selects Type of Animal\\(s) in {string} section on Animals on Premises production request")
	public void selectTypeOfAnimal(String sectionName, DataTable dataTable) throws Exception {
		String position = CucumberUtils.getValuesFromDataTable(dataTable, "Position");
		String text = CucumberUtils.getValuesFromDataTable(dataTable, "Type of Animal(s)");
		prodAnimalOnPremisesRequestFormPage.fillTextbox("Type of Animal(s)", text, position);
	}

	@When("user selects Phone in {string} section on Animals on Premises production request")
	public void fillPhoneNumberInHandlersInformation(String sectionName, DataTable dataTable) throws Exception {
		String position = CucumberUtils.getValuesFromDataTable(dataTable, "Position");
		String text = CucumberUtils.getValuesFromDataTable(dataTable, "Phone");
		prodAnimalOnPremisesRequestFormPage.fillTextbox("Phone", text, position);
	}

	@When("user selects Name in {string} section on Animals on Premises production request")
	public void fillNameInHandlersInformation(String sectionName, DataTable dataTable) throws Exception {
		String position = CucumberUtils.getValuesFromDataTable(dataTable, "Position");
		String text = CucumberUtils.getValuesFromDataTable(dataTable, "Name");
		prodAnimalOnPremisesRequestFormPage.fillTextbox("Name", text, position);
	}

	@When("user selects Email Address in {string} section on Animals on Premises production request")
	public void fillEmailAddressInHandlersInformation(String sectionName, DataTable dataTable) throws Exception {
		String position = CucumberUtils.getValuesFromDataTable(dataTable, "Position");
		String text = CucumberUtils.getValuesFromDataTable(dataTable, "Email Address");
		prodAnimalOnPremisesRequestFormPage.fillTextbox("Email Address", text, position);
	}

	@When("user selects Location in {string} section on Animals on Premises production request")
	public void setLocation(String sectionName, DataTable dataTable) throws Exception {
		String position = CucumberUtils.getValuesFromDataTable(dataTable, "Position");
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Location");
		prodAnimalOnPremisesRequestFormPage.selectValueInDropdown(option, "Location", position);
	}

	@When("user selects Set Location in {string} section on Animals on Premises production request")
	public void setSetLocation(String sectionName, DataTable dataTable) throws Exception {
		String position = CucumberUtils.getValuesFromDataTable(dataTable, "Position");
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Set Location");
		prodAnimalOnPremisesRequestFormPage.selectValueInDropdown(option, "Set Location", position);
	}

	@When("user selects Air Platform in {string} section on Animals on Premises production request")
	public void setAirPlatformInShowInfo(String sectionName, DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Air Platform");
		prodAnimalOnPremisesRequestFormPage.selectValueInDropdown(option, "Air Platform", "0");
	}

	@When("user selects Show Unit or Project Name in {string} section on Animals on Premises production request")
	public void setShowUintOrProjectNameInShowInfo(String sectionName, DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit or Project Name");
		prodAnimalOnPremisesRequestFormPage.selectValueInDropdown(option, "Show Unit or Project Name", "0");
	}

	@When("user selects Work Order # in {string} section on Animals on Premises production request")
	public void setWorkOrderInShowInfo(String sectionName, DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Work Order #");
		prodAnimalOnPremisesRequestFormPage.fillTextbox("Work Order #", option, "0");
	}

	@When("user selects Other in {string} section on Animals on Premises production request")
	public void setOtherInShowInfo(String sectionName, DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Other");
		prodAnimalOnPremisesRequestFormPage.fillTextbox("Other", option, "0");
	}

	@When("user selects Arrival Date in {string} section on Animals on Premises production request")
	public void setArrivalDateInShowInfo(String sectionName, DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Arrival Date");
		prodAnimalOnPremisesRequestFormPage.setDateInShowInfo("Arrival Date", option, "0");
	}

	@When("user selects Departure Date in {string} section on Animals on Premises production request")
	public void setDepartureDateInShowInfo(String sectionName, DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Departure Date");
		prodAnimalOnPremisesRequestFormPage.setDateInShowInfo("Departure Date", option, "0");
	}

	@When("user selects Departure Time in {string} section on Animals on Premises production request")
	public void setDepartureTimeInShowInfo(String section, DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Departure Time");
		prodAnimalOnPremisesRequestFormPage.fillTextbox("Departure Time", option, "0");
	}

	@When("user selects Arrival Time in {string} section on Animals on Premises production request")
	public void setArrivalTimeInShowInfo(String section, DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Arrival Time");
		prodAnimalOnPremisesRequestFormPage.fillTextbox("Arrival Time", option, "0");
	}

	@When("user selects Details and Notes in {string} section on Animals on Premises production request")
	public void setDetailsAndNotes(String section, DataTable dataTable) throws Exception {
		String text = CucumberUtils.getValuesFromDataTable(dataTable, "Details and Notes");
		prodAnimalOnPremisesRequestFormPage.fillTextbox("Details and Notes", text, "0");
	}

	@When("user selects Division in {string} section on Animals on Premises production request")
	public void selectDivision(String section, DataTable dataTable) throws Exception {
		String option = CucumberUtils.getValuesFromDataTable(dataTable, "Division");
		prodAnimalOnPremisesRequestFormPage.selectValueInDropdown(option, "Division", "0");
	}

}
