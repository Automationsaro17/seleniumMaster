package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;
import nbcu.automation.ui.pages.ncxUnifiedTool.CrewDashboardPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.MyRequestPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProducerDashboardGeneralPage;
import nbcu.framework.utils.cucumber.CucumberUtils;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.WebAction;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;

public class CrewNBCNewsRequestFormPageSteps {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();
	CrewDashboardPage crewDashboardPage = new CrewDashboardPage();

	@When("user enters shoot specs Information in NBC News Crew form")
	public void fillShootSpecsInfoInNBCNewsCrewRequest(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.addAudioNeeds(CucumberUtils.getValuesFromDataTable(dataTable, "Audio Needs"));
		producerDashboardGeneralPage
				.addSpecialConditions(CucumberUtils.getValuesFromDataTable(dataTable, "Special Conditions"));
		producerDashboardGeneralPage
				.addTransmissionType(CucumberUtils.getValuesFromDataTable(dataTable, "Transmission Type"));
		producerDashboardGeneralPage
				.addAcquisitionSpecs(CucumberUtils.getValuesFromDataTable(dataTable, "Acquisition Specs"));
		producerDashboardGeneralPage
				.enterIsthisaDroneShootText(CucumberUtils.getValuesFromDataTable(dataTable, "Is this a Drone Shoot"));
		producerDashboardGeneralPage.enterSpecialGear(CucumberUtils.getValuesFromDataTable(dataTable, "Special Gear"));
	}

	@When("user enters shoot specs in NBC News crew fulfillment section")
	public void fillShootSpecsInFulfillmentsection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.fillprimaryCameraTypeInFulfillmentSection(
				CucumberUtils.getValuesFromDataTable(dataTable, "Primary Camera Type"));
		producerDashboardGeneralPage
				.fillmediaFormatInFulfillmentSection(CucumberUtils.getValuesFromDataTable(dataTable, "Media Format"));
	}

	@Then("verify all fields in the Telemundo News Crew form are matching with {string} view columns in crew dashboard")
	@Then("verify all fields in the Digital Journalist DJ Shoot Crew form are matching with {string} view columns in crew dashboard")
	@Then("verify all fields in the CNBC Crew form are matching with {string} view columns in crew dashboard")
	@Then("verify all fields in the NBC News Crew form are matching with {string} view columns in crew dashboard")
	public void verifyCrewDashboardValuesWithForm(String dashboardName, DataTable dataTable) throws Exception {
		String cssType = "background color";
		producerDashboardGeneralPage.verifyStatusBackgroundColor(cssType,
				CucumberUtils.getValuesFromDataTable(dataTable, "Status"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Color"));
		String[] dashboardView;
		if (dashboardName.contains("-")) {
			dashboardView = dashboardName.split("-");
		} else {
			dashboardView = new String[1];
			dashboardView[0] = dashboardName;
		}
		for (int i = 0; i < dashboardView.length; i++) {
			crewDashboardPage.selectViewTypeInCrewDashboard(dashboardView[i].trim());
			if (dashboardView[i].trim().equalsIgnoreCase("STANDARD")) {
				crewDashboardPage.verifyCrewRequestValuesWithStandardViewCrewDashboardValues(
						CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Start Date"),
						CucumberUtils.getValuesFromDataTable(dataTable, "Meet Time"),
						CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Status"),
						CucumberUtils.getValuesFromDataTable(dataTable, "Slug"),
						CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Location"),
						CucumberUtils.getValuesFromDataTable(dataTable, "Talent"),
						CucumberUtils.getValuesFromDataTable(dataTable, "Show Title"),
						CucumberUtils.getValuesFromDataTable(dataTable, "Requesters"),
						CucumberUtils.getValuesFromDataTable(dataTable, "Producer"),
						CucumberUtils.getValuesFromDataTable(dataTable, "Sr Producer"),
						CucumberUtils.getValuesFromDataTable(dataTable, "Submitted"));
			} else if (dashboardView[i].trim().equalsIgnoreCase("RESOURCE")) {
				crewDashboardPage.verifyCrewRequestValuesWithResourceViewCrewDashboardValues(
						CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Start Date"),
						CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Status"),
						CucumberUtils.getValuesFromDataTable(dataTable, "Slug"),
						CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Location"),
						CucumberUtils.getValuesFromDataTable(dataTable, "Talent"),
						CucumberUtils.getValuesFromDataTable(dataTable, "Show Title"));
			}
			Thread.sleep(2000);
		}
	}

	@Then("verify resource count and crew details in the Telemundo News Crew form are matching with {string} view columns in crew dashboard")
	@Then("verify resource count and crew details in the Digital Journalist DJ Shoot Crew form are matching with {string} view columns in crew dashboard")
	@Then("verify resource count and crew details in the CNBC Crew form are matching with {string} view columns in crew dashboard")
	@Then("verify resource count and crew details in the NBC News Crew form are matching with {string} view columns in crew dashboard")
	public void verifyResourceCountAndCrewDetailsInDashboard(String dashboardName) throws Exception {
		crewDashboardPage.actualRequiredCamAudioResourceCount();
		producerDashboardGeneralPage.clickButton("My Request Dashboard Page");
		producerDashboardGeneralPage.openDashboard(Constants.getFormType());
		producerDashboardGeneralPage.searchRequest();
		String[] dashboardView;
		if (dashboardName.contains("-")) {
			dashboardView = dashboardName.split("-");
		} else {
			dashboardView = new String[1];
			dashboardView[0] = dashboardName;
		}
		for (int i = 0; i < dashboardView.length; i++) {
			crewDashboardPage.selectViewTypeInCrewDashboard(dashboardView[i].trim());
			if (dashboardView[i].trim().equalsIgnoreCase("STANDARD")) {
				crewDashboardPage.verifyResourceCountAndCrewDetailsWithStandardViewCrewDashboardValues();
			} else if (dashboardView[i].trim().equalsIgnoreCase("RESOURCE")) {
				crewDashboardPage.verifyResourceCountAndCrewDetailsWithResourceViewCrewDashboardValues();
			}
			Thread.sleep(2000);
		}
	}

	@Then("user selects {string} view in crew dashboard")
	public void selectViewTypeInCrewDashboard(String dashboardName) throws Exception {
		String viewType = dashboardName;
		crewDashboardPage.selectViewTypeInCrewDashboard(viewType);
	}
}
