package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProducerDashboardGeneralPage;
import nbcu.framework.utils.cucumber.CucumberUtils;

public class CrewNBCBreakingNewsRequestFormPageSteps {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	@When("user enters shoot specs Information in NBC Breaking News Crew form")
	public void fillShootSpecsInfoInNBCBreakingNewsCrewRequest(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.addTransmissionType(CucumberUtils.getValuesFromDataTable(dataTable, "Transmission Type"));
		producerDashboardGeneralPage
				.enterIsthisaDroneShootText(CucumberUtils.getValuesFromDataTable(dataTable, "Is this a Drone Shoot"));
	}

	@When("user enters Date & Time Information in NBC Breaking News Crew form")
	public void fillDateTimeInfoInNBCBreakingNewsCrewRequest(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.selectTimeZone(CucumberUtils.getValuesFromDataTable(dataTable, "Time Zone"));
		producerDashboardGeneralPage.fillMeetTime(CucumberUtils.getValuesFromDataTable(dataTable, "Meet Time"));
		producerDashboardGeneralPage.selectStartTime(CucumberUtils.getValuesFromDataTable(dataTable, "Start Time"));
		producerDashboardGeneralPage.selectEndTime(CucumberUtils.getValuesFromDataTable(dataTable, "End Time"));
	}

}
