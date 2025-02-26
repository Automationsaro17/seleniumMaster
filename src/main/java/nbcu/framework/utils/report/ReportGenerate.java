package nbcu.framework.utils.report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.apache.commons.io.FileUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import nbcu.framework.utils.propertyfilereader.ConfigFileReader;

public class ReportGenerate {

	/**
	 * To host the extent report in local
	 * 
	 * @throws Exception
	 */
	public static void generateExtentReportLocal() throws Exception {
		try {
		String batFilePath = System.getProperty("user.dir") + "/"
					+ ConfigFileReader.getProperty("Extent-Report-Bat-File-Name");
			File dir = new File(batFilePath);

			// To delete old bat file
			//FileUtils.cleanDirectory(dir);

			// create new bat file
			
			FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/" + ConfigFileReader.getProperty("Extent-Report-Bat-File-Name"));
			BufferedWriter buffer = new BufferedWriter(writer);
			buffer.write("cd " + System.getProperty("user.dir")+"\\Reports");
			buffer.newLine();
			buffer.write("Spark*.html");
			buffer.close();

			// Running bat file
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "Start",
					ConfigFileReader.getProperty("Extent-Report-Bat-File-Name"));
			//pb.directory(dir);
			Process process = pb.start();
			Thread.sleep(15000);
			process.destroy();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	static public ExtentReports extent;
	public static ExtentTest test;

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "/Reports/ProducerDashboard_Report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Producer Dashboard Automation Tests");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		test = extent.createTest("Producer Dashboard : NCX Unified Tool");
		return extent;
	}

}
