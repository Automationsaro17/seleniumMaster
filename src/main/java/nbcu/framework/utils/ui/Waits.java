package nbcu.framework.utils.ui;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.reactivex.rxjava3.internal.util.BlockingIgnoringReceiver;
import nbcu.framework.factory.DriverFactory;
import nbcu.framework.utils.propertyfilereader.ConfigFileReader;

public class Waits {

	public enum WAIT_CONDITIONS {
		CLICKABLE, VISIBLE, INVISIBLE, LESS_THAN, GREATER_THAN, EQUAL_TO
	};

	/**
	 * To make driver to wait for particular condition.It will throw timeout
	 * exception if max wait time is reached
	 * 
	 * @param element       - Web Element
	 * @param waitCondition - CLICKABLE/VISIBLE/INVISBLE
	 * @throws Exception - If condition not satisfied for max wait time, it will
	 *                   throw time out exception
	 */
	public static void waitForElement(WebElement element, WAIT_CONDITIONS waitCondition) throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(
					Integer.parseInt(ConfigFileReader.getProperty("max-wait-time"))));
			switch (waitCondition) {
			case CLICKABLE:
				wait.until(ExpectedConditions.elementToBeClickable(element));
				break;
			case VISIBLE:
				wait.until(ExpectedConditions.visibilityOf(element));
				break;
			case INVISIBLE:
				wait.until(ExpectedConditions.invisibilityOf(element));
				break;
			default:
				Assert.assertTrue(false, "provide valid wait condition");
				break;

			}
		} catch (Exception e) {
			 
			e.printStackTrace();
			throw new Exception("wait condition has been failed");
		}
	}
	
	/**
	 * To make driver to wait for particular condition.It will throw timeout
	 * exception if max wait time is reached
	 * @param by - By
	 * @param waitCondition - CLICKABLE/VISIBLE/INVISBLE
	 * @throws Exception
	 */
	public static void waitForElement(By by, WAIT_CONDITIONS waitCondition) throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(
					Integer.parseInt(ConfigFileReader.getProperty("max-wait-time"))));
			switch (waitCondition) {
			case CLICKABLE:
				wait.until(ExpectedConditions.elementToBeClickable(by));
				break;
			case VISIBLE:
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
				break;
			case INVISIBLE:
				wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
				break;
			default:
				Assert.assertTrue(false, "provide valid wait condition");
				break;

			}
		} catch (Exception e) {
			 
			e.printStackTrace();
			throw new Exception("wait condition has been failed");
		}
	}

	/**
	 * To make driver to wait for particular condition.It will throw timeout
	 * exception if max wait time is reached
	 * 
	 * @param elements      - List of Web Elements
	 * @param waitCondition - Maximum wait time
	 * @throws Exception - If condition not satisfied for max wait time, it will
	 *                   throw time out exception
	 */
	public static void waitForAllElements(List<WebElement> elements, WAIT_CONDITIONS waitCondition) throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(
					Integer.parseInt(ConfigFileReader.getProperty("max-wait-time"))));
			switch (waitCondition) {
			case VISIBLE:
				wait.until(ExpectedConditions.visibilityOfAllElements(elements));
				break;
			case INVISIBLE:
				wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
				break;
			default:
				Assert.assertTrue(false, "provide valid wait condition");
				break;

			}
		} catch (Exception e) {
			 
			e.printStackTrace();
			throw new Exception("wait condition has been failed");
		}
	}

	/**
	 * To wait and check element state. It will return true or false
	 * 
	 * @param element       - Web Element
	 * @param waitCondition - CLICKABLE/VISIBLE/INVISBLE
	 * @param maxWaitTime   - Maximum wait time
	 * @return - true/false
	 */
	public static boolean checkElementState(WebElement element, WAIT_CONDITIONS waitCondition) {
		boolean flag = true;
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(
					Integer.parseInt(ConfigFileReader.getProperty("max-wait-time"))));
			switch (waitCondition) {
			case CLICKABLE:
				wait.until(ExpectedConditions.elementToBeClickable(element));
				break;
			case VISIBLE:
				wait.until(ExpectedConditions.visibilityOf(element));
				break;
			case INVISIBLE:
				wait.until(ExpectedConditions.invisibilityOf(element));
				break;

			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * To wait until the element size is greater than given count
	 * @param elements
	 * @param count
	 * @throws Exception
	 */
	public static void waitUntilElementSizeGreater(List<WebElement> elements, int count) throws Exception {
		try {
			int intialWaitCount=0;
			while(intialWaitCount<Integer.parseInt(ConfigFileReader.getProperty("max-wait-time")))
			{
				Thread.sleep(1000);
				if(elements.size()>count) {
					Thread.sleep(1000);
					break;
				}
				intialWaitCount++;
			}
			
			if(intialWaitCount==Integer.parseInt(ConfigFileReader.getProperty("max-wait-time")))
				throw new Exception("wait condition has been failed");
			
		} catch (Exception e) {
			 
			e.printStackTrace();
			throw new Exception("wait condition has been failed");
		}
	}
	
	/**
	 * To wait until drop down list has options
	 * @param elements
	 * @param count
	 * @throws Exception
	 */
	public static void waitUntilElementSizeGreater(By by,int count) throws Exception {
		WebDriver driver=DriverFactory.getCurrentDriver();
		try {
			int intialWaitCount=0;
			while(intialWaitCount<Integer.parseInt(ConfigFileReader.getProperty("max-wait-time")))
			{
				Thread.sleep(1000);
				List<WebElement> elements=driver.findElements(by);
				if(elements.size()>count) {
					Thread.sleep(1000);
					break;
				}
				intialWaitCount++;
			}
			
			if(intialWaitCount==Integer.parseInt(ConfigFileReader.getProperty("max-wait-time")))
				throw new Exception("wait condition has been failed");
			
		} catch (Exception e) {
			 
			e.printStackTrace();
			throw new Exception("wait condition has been failed");
		}
	}
	/**
	 * To wait until the element size is equal than given count
	 * @param elements
	 * @param count
	 * @throws Exception
	 */
	public static void waitUntilElementSizeEquals(List<WebElement> elements, int count) throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		int timeout = Integer.parseInt(ConfigFileReader.getProperty("max-wait-time"));
		Wait<WebDriver> wait = new FluentWait<>(driver)
									.withTimeout(Duration.ofSeconds(timeout))
									.pollingEvery(Duration.ofMillis(1000))
									.ignoreAll(Arrays.asList(ElementNotInteractableException.class,StaleElementReferenceException.class,NoSuchElementException.class));
		
		wait.until((d)->elements.size()==count);
	}
	/**
	 * To wait until the element is clickable
	 * @param elements
	 * @param count
	 * @throws  
	 * @throws Exception
	 */
	public static void waitUntilElementIsClickable(WebElement element) throws Exception{
		WebDriver driver = DriverFactory.getCurrentDriver();
		int timeout = Integer.parseInt(ConfigFileReader.getProperty("max-wait-time"));
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
									.withTimeout(Duration.ofSeconds(timeout))
									.pollingEvery(Duration.ofMillis(1000))
									.ignoring(ElementClickInterceptedException.class)
									.ignoring(ElementNotInteractableException.class)
									.ignoring(StaleElementReferenceException.class)
									.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}