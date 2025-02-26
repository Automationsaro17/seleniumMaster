package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;
import nbcu.automation.ui.pages.ncxUnifiedTool.ContentManagementRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.EditRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProducerDashboardGeneralPage;
import nbcu.framework.utils.cucumber.CucumberUtils;

public class EditRequestFormPageSteps {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();
	EditRequestFormPage editRequestFormPage = new EditRequestFormPage();
	ContentManagementRequestFormPage contentManagementRequestFormPage = new ContentManagementRequestFormPage();

	@When("user selects {string} edit type in Edit request form")
	public void selectEditTypeSection(String editType) throws Exception {
		editRequestFormPage.selectEditType(editType);
	}

	@When("user enters show info Information in Standard Edit request form")
	public void fillShowInfoInEdit(DataTable dataTable) throws Exception {
		editRequestFormPage.addShowInfoInECM(CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Budget Code"));
		editRequestFormPage.addAirDateTimeInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Air Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Air Time"));
	}

	@When("user enters show info Information in Long Edit request form")
	public void fillShowInfoInLongEdit(DataTable dataTable) throws Exception {
		fillShowInfoInEdit(dataTable);
		editRequestFormPage
				.fillDateofFirstScreening(CucumberUtils.getValuesFromDataTable(dataTable, "Date of First Screening"));
	}

	@When("user enters Show Length in Standard Edit Request form")
	public void fillShowLengthSectionInStandardEdit(DataTable dataTable) throws Exception {
		editRequestFormPage
				.filllengthOfShowInfoMinutes(CucumberUtils.getValuesFromDataTable(dataTable, "Length Of Show Minutes"));
		editRequestFormPage
				.filllengthOfShowInfoSeconds(CucumberUtils.getValuesFromDataTable(dataTable, "Length Of Show Seconds"));
	}

	@When("user enters Show Length in Long Edit Request form")
	public void fillShowLengthSectionInLongEdit(DataTable dataTable) throws Exception {
		editRequestFormPage.filllengthOfShowInfoNoOfActs(
				CucumberUtils.getValuesFromDataTable(dataTable, "Length Of Show No of Acts"));
		editRequestFormPage
				.filllengthOfShowInfoHours(CucumberUtils.getValuesFromDataTable(dataTable, "Length Of Show Hours"));
		fillShowLengthSectionInStandardEdit(dataTable);
	}

	@When("user enters Session details info in Standard Edit Request form")
	public void fillSessionDetailsSectionInStandardEdit(DataTable dataTable) throws Exception {

		editRequestFormPage.fillLocationOfEdit(CucumberUtils.getValuesFromDataTable(dataTable, "Location"));
		editRequestFormPage.fillEditStartDate(CucumberUtils.getValuesFromDataTable(dataTable, "Edit Start Date"));
		if (Constants.getDivision().equalsIgnoreCase("CNBC")) {
			editRequestFormPage.selectediusOrAvid(CucumberUtils.getValuesFromDataTable(dataTable, "ediusOrAvid"));
		}
		editRequestFormPage
				.fillReqStartTime(CucumberUtils.getValuesFromDataTable(dataTable, "Requested Edit Session Start Time"));
		editRequestFormPage.fillEditTimeNeededInfoInStandard(
				CucumberUtils.getValuesFromDataTable(dataTable, "Edit Time Needed Days"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Edit Time Needed Hours"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Edit Time Needed Minutes"));
	}

	@When("user enters Session details info in Long Edit Request form")
	public void fillSessionDetailsSectionInLongEdit(DataTable dataTable) throws Exception {
		editRequestFormPage.fillLocationOfEdit(CucumberUtils.getValuesFromDataTable(dataTable, "Location"));
		editRequestFormPage.fillEditStartDate(CucumberUtils.getValuesFromDataTable(dataTable, "Edit Start Date"));
		if (Constants.getDivision().equalsIgnoreCase("CNBC")) {
			editRequestFormPage.selectediusOrAvid(CucumberUtils.getValuesFromDataTable(dataTable, "ediusOrAvid"));
		}

		editRequestFormPage.fillNoOfEditors(CucumberUtils.getValuesFromDataTable(dataTable, "No Of Editors"));
		editRequestFormPage.fillEditTimeNeededInfoInLong(
				CucumberUtils.getValuesFromDataTable(dataTable, "Edit Time Needed Weeks"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Edit Time Needed Days"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Edit Time Needed Hours"));
	}

	@When("user selects type of edit info in Standard Edit Request form")
	public void filltypeOfEditSection(DataTable dataTable) throws Exception {
		editRequestFormPage.fillTypeOfEditDetails(CucumberUtils.getValuesFromDataTable(dataTable, "Type of Edit"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Type of Edit Quantity"));
		editRequestFormPage.fillHowManyVersions(CucumberUtils.getValuesFromDataTable(dataTable, "How Many Versions"));
	}

	@When("user selects  Additional Requirements info in Standard Edit Request form")
	public void fillAdditionalRequirementsSection(DataTable dataTable) throws Exception {
		editRequestFormPage.fillAdditionalRequirementsDetails(
				CucumberUtils.getValuesFromDataTable(dataTable, "Additional Requirements"));
		editRequestFormPage
				.fillIsthisaCrashEditDetails(CucumberUtils.getValuesFromDataTable(dataTable, "is Crash Edit"));
	}

	@When("user selects Final Delivery in Long Edit Request form")
	@When("user selects Final Delivery in Standard Edit Request form")
	public void fillFinalDeliverySection(DataTable dataTable) throws Exception {
		editRequestFormPage.fillFinalDeliveryDetails(CucumberUtils.getValuesFromDataTable(dataTable, "Final Delivery"));
	}

	@When("user selects Source Material info in Standard Edit Request form")
	public void fillSourceMaterialSection(DataTable dataTable) throws Exception {
		editRequestFormPage
				.fillsourceMaterialDetails(CucumberUtils.getValuesFromDataTable(dataTable, "Source Material"));
	}

	@When("user enters asst producer info in Long Edit Request form")
	public void fillAsstProducerInfoInLongForm(DataTable dataTable) throws Exception {
		editRequestFormPage.fillAsstProducerInfoSection(
				CucumberUtils.getValuesFromDataTable(dataTable, "Asst Producer same as Requester"));
	}

	@When("user enters Additional Recipients info in Long Edit Request form")
	public void fillAdditionalRecipientsInLongForm(DataTable dataTable) throws Exception {
		editRequestFormPage
				.fillAdditionalRecipients(CucumberUtils.getValuesFromDataTable(dataTable, "Additional Recipients"));
	}

	@When("user enters comments info in Long Edit Request form")
	@When("user enters comments info in Standard Edit Request form")
	public void fillCommentsSection(DataTable dataTable) throws Exception {
		editRequestFormPage.fillCommentInEdit(CucumberUtils.getValuesFromDataTable(dataTable, "Comments"));
	}

	@When("user selects {string} in Fulfillment Request Status")
	public void fillFulfillmentStatus(String requestStatusName) throws Exception {
		editRequestFormPage.fillRequestStatus(requestStatusName);
	}

	@When("user enters fulfillment comments in Long Edit Request form")
	@When("user enters fulfillment comments in Standard Edit Request form")
	public void fillFulfillmentCommentsSection(DataTable dataTable) throws Exception {
		editRequestFormPage
				.fillFulfillmentComment(CucumberUtils.getValuesFromDataTable(dataTable, "Fulfillment Comments"));
	}

	@And("user enters Editor Controls info in Long Edit Request form")
	@And("user enters Editor Controls info in Standard Edit Request form")
	public void user_enters_ER_fulfillment_details(DataTable dataTable) throws Exception {
		editRequestFormPage.fillEditorControlsSection(CucumberUtils.getValuesFromDataTable(dataTable, "EditorName"),
				CucumberUtils.getValuesFromDataTable(dataTable, "EditorPhoneNumber"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Room"),
				CucumberUtils.getValuesFromDataTable(dataTable, "AssignedFromDate"),
				CucumberUtils.getValuesFromDataTable(dataTable, "AssignedToDate"),
				CucumberUtils.getValuesFromDataTable(dataTable, "AssignedFromTime"),
				CucumberUtils.getValuesFromDataTable(dataTable, "AssignedToTime"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Different Room"));
	}

	@Then("verify all fields in the Edit Standard form are matching with columns in edit request dashboard")
	@Then("verify all fields in the Edit Long form are matching with columns in edit request dashboard")
	public void verifyEditRequestDashboardValuesWithForm(DataTable dataTable) throws Exception {
		String cssType = "background color";
		contentManagementRequestFormPage.verifyStatusBackgroundColorInECM(cssType,
				CucumberUtils.getValuesFromDataTable(dataTable, "Status"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Color"));
		editRequestFormPage.verifyEditRequestValuesWithEditDashboardValues(
				CucumberUtils.getValuesFromDataTable(dataTable, "Slug"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Division"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Edit Start Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Air Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Air Time"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Requesters"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Producer"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Sr Producer"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Submitted"));
	}
}