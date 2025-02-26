package nbcu.framework.runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.Status;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import nbcu.framework.utils.report.ReportGenerate;

 

@CucumberOptions(features = { "@target/cucumber-reports/rerun-reports/rerun.txt" }, glue = {

        "nbcu.automation.ui.stepdefs", "nbcu.framework.hooks","nbcu.automation.hooks" }, plugin = { "pretty",

                "json:target/cucumber-reports/Cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

                 }, monochrome = true)



public class RerunCucumberTest extends AbstractTestNGCucumberTests {

 

    @DataProvider(parallel = true)

    public Object[][] scenarios() {

        System.out.println("********** RETRY EXECUTION ***********");

        return super.scenarios();

    }
    
    @AfterSuite(alwaysRun = true)
	public void afterSuite() throws Exception {
		ReportGenerate.generateExtentReportLocal();
	}
}
