package nbcu.automation.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;

public class TestHooks {
	@After
	public void cleanupConstantMapOfScenario(Scenario scenario) {
		if(Constants.getConstantMapOfScenario() != null) {
			Constants.getConstantMapOfScenario().clear();
		}
	}
}
