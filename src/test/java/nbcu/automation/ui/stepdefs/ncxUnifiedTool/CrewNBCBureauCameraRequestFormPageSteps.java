package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProducerDashboardGeneralPage;
import nbcu.framework.utils.cucumber.CucumberUtils;

public class CrewNBCBureauCameraRequestFormPageSteps {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	@When("user enters shoot location Information in NBC Bureau Camera Crew form")
	public void fillShootLocationInfoInNBCBureauCameraCrewRequest(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.addShootLocationInCrew(
				CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Risk Assessment Category"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Risk Assessment Type"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Risk Arrangements"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Risk Approver"));
	}

}
