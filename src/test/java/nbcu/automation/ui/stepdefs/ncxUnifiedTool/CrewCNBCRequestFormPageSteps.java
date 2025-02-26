package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProducerDashboardGeneralPage;
import nbcu.framework.utils.cucumber.CucumberUtils;

public class CrewCNBCRequestFormPageSteps {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	@When("user enters shoot specs Information in CNBC Crew form")
	public void fillShootSpecsInfoInCNBCCrewRequest(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.addAudioNeeds(CucumberUtils.getValuesFromDataTable(dataTable, "Audio Needs"));
		producerDashboardGeneralPage
				.addSpecialConditions(CucumberUtils.getValuesFromDataTable(dataTable, "Special Conditions"));
		producerDashboardGeneralPage
				.addTransmissionType(CucumberUtils.getValuesFromDataTable(dataTable, "Transmission Type"));
		producerDashboardGeneralPage
				.enterIsthisaDroneShootText(CucumberUtils.getValuesFromDataTable(dataTable, "Is this a Drone Shoot"));
		producerDashboardGeneralPage.enterSpecialGear(CucumberUtils.getValuesFromDataTable(dataTable, "Special Gear"));
	}

}
