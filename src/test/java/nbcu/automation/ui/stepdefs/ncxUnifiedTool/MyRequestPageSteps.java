package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nbcu.automation.ui.pages.ncxUnifiedTool.MyRequestPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProdRockCenterRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProducerDashboardGeneralPage;
import nbcu.framework.utils.cucumber.CucumberUtils;

public class MyRequestPageSteps {

	MyRequestPage myRequestPage = new MyRequestPage();
	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	@Given("user clicks on forms link")
	public void openFormsPage() throws Exception {

		myRequestPage.clickCloseButtonInTestVersionBanner();
		myRequestPage.clickFormsButton();
		myRequestPage.verifySelectRequestPanelDisplayed();
	}

	@Given("user selects {string} form")
	public void selectForm(String formName) throws Exception {
		myRequestPage.selectRequestForm(formName);
		producerDashboardGeneralPage.verifySelectedRequestPageDisplayed(formName);
	}

	@Then("user get the Request ID with Request Type from Success message")
	public void getRequestIDFromSuccessMessage() throws Exception {
		myRequestPage.getRequestID();
	}

	@Then("verify {string} of {string} status is {string} in my request page")
	public void verifyStatusColor(String cssType, String status, String expectedColor) throws Exception {
		myRequestPage.verifyStatusBackgroundColor(cssType, status, expectedColor);

	}

	@Then("user logs out from application")
	public void logout() throws Exception {
		myRequestPage.logOut();
	}

	@Given("user searches request in my request page")
	public void searchRequest() throws Exception {
		myRequestPage.searchRequest();
	}

	@Given("user click on request ID link of the request")
	public void clickRequestIdLink() throws Exception {
		myRequestPage.clickRequestIdLink();
	}

	@Given("user click edit link of the request in {string}")
	public void clickEditLink(String pageName) throws Exception {
		if (pageName.toUpperCase().contains("MY REQUEST"))
			myRequestPage.clickEditLink();
		else
			producerDashboardGeneralPage.clickEditLink();
	}

	@And("validate Notes updated by {string} from fulfiller end")
	public void noteValidationByOtherUser(String role) throws Exception {
		producerDashboardGeneralPage.noteValidationByOtherUser(role);
	}

	@Then("verify submitted {string} is present in my request page with {string} status")
	public void verifySubmittedRequestInMyRequestTable(String formName, String status) throws Exception {
		myRequestPage.verifyProductionRequestInmyRequestPage(formName, status);
	}

	@When("user verifies whether the status is {string}")
	public void verifyRequestStatus(String status) throws Exception {
		myRequestPage.verifyStatus(status);
	}

	@When("user verifies the status on the request is {string}")
	public void verifyRequestStatusText(String status) throws Exception {
		myRequestPage.verifyRequestStatusText(status);
	}

	@Then("user get the Request ID with Request Type from Success msg")
	public void getRequestIdFromSuccessMessage() throws Exception {
		myRequestPage.getRequestIDFromSuccMsg();
	}

	@Then("user get the Request IDs with Request Type from Success message")
	public void getRequestIDsAndRequestTypeFromSuccessMessage() throws Exception {
		myRequestPage.getRequestIDs();
	}

	@And("click {string} on {string} alert message")
	public void clickYesOrNo(String option, String cancelStatus) throws Exception {
		myRequestPage.clickOption(option);
	}

	@Then("user verifies whether {string} is displayed the top of the request")
	public void verifyTextOnRequest(String text) throws Exception {
		myRequestPage.verifyTextDisplayed(text);
	}

	@Then("user opens the request in read only mode")
	public void openRequestInReadMode() {
		myRequestPage.openRequestInReadMode();
	}

	@Then("user sees modal for successful {string} request creation")
	public void checkRequestCreatedModal(String formName) throws Exception {
		myRequestPage.checkRequestCreatedModal(formName);
	}

	@When("user opens the created request")
	public void openCreatedRequest() throws Exception {
		myRequestPage.openCreatedRequest();
	}

	@Then("verify all fields in the Single Camera Live Shot Production form are matching with columns in My Request dashboard")
	@Then("verify all fields in the Rock Center Production form are matching with columns in My Request dashboard")
	@Then("verify all fields in the Extend or Bridge Crew Production form are matching with columns in My Request dashboard")
	@Then("verify all fields in the Firearms on Premises Production form are matching with columns in My Request dashboard")
	@Then("verify all fields in the CNBC Production form are matching with columns in My Request dashboard")
	@Then("verify all fields in the Animals on Premises Production form are matching with columns in My Request dashboard")
	@Then("verify all fields in the News Gear form are matching with columns in My Request dashboard")
	@Then("verify all fields in the Edit Self Reporting form are matching with columns in My Request dashboard")
	@Then("verify all fields in the MTD form are matching with columns in My Request dashboard")
	@Then("verify all fields in the File Ingest form are matching with columns in My Request dashboard")
	@Then("verify all fields in the Feed Out form are matching with columns in My Request dashboard")
	@Then("verify all fields in the Standard Edit form are matching with columns in My Request dashboard")
	@Then("verify all fields in the Long Edit form are matching with columns in My Request dashboard")
	@Then("verify all fields in the Telemundo News Crew form are matching with columns in My Request dashboard")
	@Then("verify all fields in the NBC News Crew form are matching with columns in My Request dashboard")
	@Then("verify all fields in the Digital Journalist DJ Shoot Crew form are matching with columns in My Request dashboard")
	@Then("verify all fields in the CNBC Crew form are matching with columns in My Request dashboard")
	public void verifyMyRequestDashboardValuesWithForm(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.clickButton("My Request Dashboard Page");
		producerDashboardGeneralPage.clickButton("My Requests");
		myRequestPage.verifyRequestValuesWithMyRequestDashboardValues(
				CucumberUtils.getValuesFromDataTable(dataTable, "Slug"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Prod Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show Title"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Submitted"));
	}

	@Then("verify all fields in the Single Camera Live Shot Production form are matching with columns in All Request dashboard")
	@Then("verify all fields in the Rock Center Production form are matching with columns in All Request dashboard")
	@Then("verify all fields in the Extend or Bridge Crew Production form are matching with columns in All Request dashboard")
	@Then("verify all fields in the Firearms on Premises Production form are matching with columns in All Request dashboard")
	@Then("verify all fields in the CNBC Production form are matching with columns in All Request dashboard")
	@Then("verify all fields in the Animals on Premises Production form are matching with columns in All Request dashboard")
	@Then("verify all fields in the News Gear form are matching with columns in All Request dashboard")
	@Then("verify all fields in the Edit Self Reporting form are matching with columns in All Request dashboard")
	@Then("verify all fields in the MTD form are matching with columns in All Request dashboard")
	@Then("verify all fields in the File Ingest form are matching with columns in All Request dashboard")
	@Then("verify all fields in the Feed Out form are matching with columns in All Request dashboard")
	@Then("verify all fields in the Standard Edit form are matching with columns in All Request dashboard")
	@Then("verify all fields in the Long Edit form are matching with columns in All Request dashboard")
	@Then("verify all fields in the Telemundo News Crew form are matching with columns in All Request dashboard")
	@Then("verify all fields in the NBC News Crew form are matching with columns in All Request dashboard")
	@Then("verify all fields in the Digital Journalist DJ Shoot Crew form are matching with columns in All Request dashboard")
	@Then("verify all fields in the CNBC Crew form are matching with columns in All Request dashboard")
	public void verifyAllRequestDashboardValuesWithForm(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.clickButton("My Request Dashboard Page");
		producerDashboardGeneralPage.clickButton("All Requests");	
		myRequestPage.verifyRequestValuesWithAllRequestDashboardValues(
				CucumberUtils.getValuesFromDataTable(dataTable, "Requesters"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Slug"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Prod Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show Title"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Submitted"));
	}
}
