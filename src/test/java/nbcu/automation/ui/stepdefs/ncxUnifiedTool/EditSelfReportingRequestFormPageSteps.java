package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;
import nbcu.automation.ui.pages.ncxUnifiedTool.ContentManagementRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.EditRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.EditSelfReportingRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProducerDashboardGeneralPage;
import nbcu.framework.utils.cucumber.CucumberUtils;

public class EditSelfReportingRequestFormPageSteps {

	EditRequestFormPage editRequestFormPage = new EditRequestFormPage();
	EditSelfReportingRequestFormPage editSelfReportingRequestFormPage = new EditSelfReportingRequestFormPage();
	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();
	ContentManagementRequestFormPage contentManagementRequestFormPage = new ContentManagementRequestFormPage();

	@When("user enters General info in Edit Self Reporting request form")
	public void fillShowInfoInEditSelfReporting(DataTable dataTable) throws Exception {
		editRequestFormPage.addShowInfoInECM(CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Budget Code"));
	}

	@When("user enters Show info in Edit Self Reporting request form")
	public void fillShowInfoInLongEdit(DataTable dataTable) throws Exception {
		editSelfReportingRequestFormPage.addAirDateTimeInfoInESR(
				CucumberUtils.getValuesFromDataTable(dataTable, "Air Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Edit Date"));
	}

	@When("user enters Edit Type info in Edit Self Reporting request form")
	public void fillShowLengthSectionInStandardEdit(DataTable dataTable) throws Exception {
		editSelfReportingRequestFormPage
				.selectWhoIsEditing(CucumberUtils.getValuesFromDataTable(dataTable, "Who Is Editing"));
		editRequestFormPage.fillTypeOfEditDetails(CucumberUtils.getValuesFromDataTable(dataTable, "Type of Edit"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Type of Edit Quantity"));
	}

	@When("user enters Location info in Edit Self Reporting request form")
	public void fillShowLengthSectionInEditSelfReporting(DataTable dataTable) throws Exception {
		editSelfReportingRequestFormPage.fillLocationInfoInESR(
				CucumberUtils.getValuesFromDataTable(dataTable, "Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Room"));
	}

	@When("user enters comments info in Edit Self Reporting request form")
	public void fillCommentsSection(DataTable dataTable) throws Exception {
		editSelfReportingRequestFormPage
				.fillCommentInEditSelfReporting(CucumberUtils.getValuesFromDataTable(dataTable, "Comments"));
	}

	@Then("user get the Edit Self Reporting Request ID with Request Type from Success message")
	public void getRequestIDFromSuccessMessage() throws Exception {
		editSelfReportingRequestFormPage.getRequestID();
	}

	@Then("verify all fields in the Edit Self Reporting form are matching with columns in edit self reporting dashboard")
	public void verifyEditSelfReportingRequestDashboardValuesWithForm(DataTable dataTable) throws Exception {
		editSelfReportingRequestFormPage.actualEnteredIntoStormAndDivision();
		producerDashboardGeneralPage.clickButton("My Request Dashboard Page");
		producerDashboardGeneralPage.openDashboard(Constants.getFormType());
		producerDashboardGeneralPage.searchRequest();
		String cssType = "background color";
		contentManagementRequestFormPage.verifyStatusBackgroundColorInECM(cssType,
				CucumberUtils.getValuesFromDataTable(dataTable, "Status"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Color"));
		editSelfReportingRequestFormPage.verifyEditSelfReportingRequestValuesWithEditSelfReportingDashboardValues(
				CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Air Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Who Is Editing"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Submitted"));

	}
}