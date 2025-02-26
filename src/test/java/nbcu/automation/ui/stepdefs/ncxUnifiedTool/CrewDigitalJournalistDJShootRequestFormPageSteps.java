package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProducerDashboardGeneralPage;
import nbcu.framework.utils.cucumber.CucumberUtils;

public class CrewDigitalJournalistDJShootRequestFormPageSteps {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();
	CrewNBCNewsRequestFormPageSteps crewNBCNewsRequestFormPageSteps = new CrewNBCNewsRequestFormPageSteps();

	@When("user enters shoot details Information in Digital Journalist DJ Shoot Crew form")
	public void fillShootDetailsInfoInDigitalJournalistDJShootCrewRequest(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.addProductionType(CucumberUtils.getValuesFromDataTable(dataTable, "Production Type"));
		producerDashboardGeneralPage.enterShootStatus(CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Status"));
		producerDashboardGeneralPage.enterShootType(CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Type"));
		producerDashboardGeneralPage
				.enterShootDescription(CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Description"));
	}

	@When("user enters shoot specs Information in Digital Journalist DJ Shoot Crew form")
	public void fillShootSpecsInfoInDigitalJournalistDJShootCrewRequest(DataTable dataTable) throws Exception {
		crewNBCNewsRequestFormPageSteps.fillShootSpecsInfoInNBCNewsCrewRequest(dataTable);
		producerDashboardGeneralPage.fillprimaryCameraTypeInFulfillmentSection(
				CucumberUtils.getValuesFromDataTable(dataTable, "Primary Camera Type"));
	}

	@When("user enters Date & Time Information in Digital Journalist DJ Shoot Crew form")
	public void fillDateTimeInfoInDigitalJournalistDJShootCrewRequest(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.fillWhenIsShoot(
				CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Start Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Shoot End Date"));
		producerDashboardGeneralPage.selectTimeZone(CucumberUtils.getValuesFromDataTable(dataTable, "Time Zone"));
	}

	@When("user enters shoot specs in Digital Journalist DJ Shoot crew fulfillment section")
	public void fillShootSpecsInDigitalJournalistDJShootCrewFulfillmentsection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.fillmediaFormatInFulfillmentSection(CucumberUtils.getValuesFromDataTable(dataTable, "Media Format"));
		producerDashboardGeneralPage
				.fillVideoSpecsInFulfillmentSection(CucumberUtils.getValuesFromDataTable(dataTable, "Video Specs"));
	}
}
