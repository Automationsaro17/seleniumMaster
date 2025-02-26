package nbcu.framework.hooks;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import nbcu.framework.factory.DriverFactory;
import nbcu.framework.utils.propertyfilereader.ConfigFileReader;
import nbcu.framework.utils.report.ReportGenerate;

public class CucumberAnnotations {

	String apiORui = null;
	/**
	 * To initialize the web driver before each scenario
	 * @throws Exception
	 */
	@Before
	public void beforeScenario() throws Exception {
		/*
		 * apiORui = System.getProperty("job"); if (!apiORui.equalsIgnoreCase("api")) {
		 */
			DriverFactory.initDriver(ConfigFileReader.getProperty("Application-Type"));
		}
	//}

	/**
	 * To close the web driver after each scenario
	 * @param scenario
	 * @throws Exception 
	 */
	@After
	public void AfterScenario(Scenario scenario) throws Exception {
		//validate if scenario has failed
        if(scenario.isFailed()) {
        	if(!ConfigFileReader.getProperty("Application-Type").trim().equalsIgnoreCase("API")) {
            final byte[] screenshot = ((TakesScreenshot) DriverFactory.getCurrentDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName()); 
        	}
        } 
       // if (!apiORui.equalsIgnoreCase("api")) {
			//DriverFactory.cleanDrivers();
		//}
        
        if(!ConfigFileReader.getProperty("Application-Type").trim().equalsIgnoreCase("API")) {
        	DriverFactory.cleanDrivers();
        }
        
	}
	
	
}
