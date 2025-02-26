package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProducerDashboardGeneralPage;
import nbcu.framework.utils.cucumber.CucumberUtils;

public class CrewTelemundoRequestFormPageSteps {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();
	CrewCNBCRequestFormPageSteps crewCNBCRequestFormPageSteps = new CrewCNBCRequestFormPageSteps();

	@When("user enters shoot specs Information in Telemundo Crew form")
	public void fillShootSpecsInfoInTelemundoCrewRequest(DataTable dataTable) throws Exception {
		crewCNBCRequestFormPageSteps.fillShootSpecsInfoInCNBCCrewRequest(dataTable);
		producerDashboardGeneralPage
				.enterIPadPrompterRequired(CucumberUtils.getValuesFromDataTable(dataTable, "iPad Prompter Required"));
	}
}
