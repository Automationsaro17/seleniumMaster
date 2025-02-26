package nbcu.framework.factory;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DriverFactory {

	private static ThreadLocal<WebDriver> currentDriver = new ThreadLocal<WebDriver>();

	/**
	 * To get the current thread web driver
	 * 
	 * @return - current thread web driver
	 */
	public static WebDriver getCurrentDriver() {
		WebDriver driver = currentDriver.get();
		if (driver != null)
			return driver;
		else {
			System.out.println("Driver not initialized");
			return null;
		}
	}

	/**
	 * To initialize the web driver
	 * 
	 * @param platform - WEB/API/MOBILE
	 * @throws Exception
	 */
	public static void initDriver(String platform) throws Exception {
		try {
			switch (platform.toUpperCase()) {
			case "WEB":
				currentDriver.set(WebDrivers.getNewDriver());
				break;
			case "API":
				currentDriver.set(WebDrivers.getNewDriver());
				break;
			default:
				Assert.assertTrue(false, "Given browser name is not valid-" + platform);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To close the current thread web driver
	 */
	public static void cleanDrivers() {
		currentDriver.get().quit();
	}
}
