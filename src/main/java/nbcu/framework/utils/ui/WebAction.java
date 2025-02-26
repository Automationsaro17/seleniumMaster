package nbcu.framework.utils.ui;

import static nbcu.framework.factory.DriverFactory.getCurrentDriver;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import nbcu.framework.factory.DriverFactory;
import nbcu.framework.utils.propertyfilereader.ConfigFileReader;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;

public class WebAction {
	/**
	 * To clear the text box, then enter value in text box
	 * 
	 * @param element   - Web Element
	 * @param inputText - Text to be entered in text box
	 */
	public static void sendKeys(WebElement element, String inputText) {
		try {
			element.clear();
			element.sendKeys(inputText);
		} catch (Exception e) {
			// Allure.captureScreenshot("webelement send keys error");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To enter value in text box
	 * 
	 * @param element
	 * @param inputText
	 */
	public static void sendKeys_WithoutClear(WebElement element, String inputText) {
		try {
			element.sendKeys(inputText);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void sendKeys_WithTimeGap(WebElement element, String inputText) throws Exception {
		try {
			element.clear();
			for (int i = 0; i < inputText.length(); i++) {
				Thread.sleep(30);
				element.sendKeys(inputText.substring(i, i + 1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To click button/Web element
	 * 
	 * @param element - Web Element
	 * @throws Exception
	 */
	public static void click(WebElement element) throws Exception {
		try {
			Waits.waitForElement(element, WAIT_CONDITIONS.VISIBLE);
			Waits.waitForElement(element, WAIT_CONDITIONS.CLICKABLE);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To clear value in text box
	 * 
	 * @param element - Web Element
	 */
	public static void clear(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To select value from drop down
	 * 
	 * @param element       - Web Element
	 * @param selectionType - VISIBLETEXT/VALUE/INDEX
	 * @param value         - Value for drop down
	 */
	public static void selectDropDown(WebElement element, String selectionType, String value) {
		try {
			Select select = new Select(element);
			switch (selectionType.toUpperCase()) {
			case "VISIBLETEXT":
				select.selectByVisibleText(value);
				break;
			case "VALUE":
				select.selectByValue(value);
				break;
			case "INDEX":
				select.selectByIndex(Integer.parseInt(value));
				break;
			default:
				Assert.assertTrue(false, "Given selection type is not valid-" + selectionType);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To mover over on web element
	 * 
	 * @param element - Web Element
	 * @throws Exception
	 */
	public static void mouseOver(WebElement element) throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To click web element using java script
	 * 
	 * @param element - Web Element
	 */
	public static void clickUsingJs(WebElement element) throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			Thread.sleep(1000);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To get text of web element
	 * 
	 * @param element - Web Element
	 * @return - web element text
	 */
	public static String getText(WebElement element) {
		String elementText = "";
		try {
			elementText = element.getText().trim();
			if (elementText.equals(""))
				elementText = element.getAttribute("innerHTML").trim();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return elementText;
	}

	/**
	 * To get the attribute value
	 * 
	 * @param element      - Web Element
	 * @param attributeKey - Attribute name
	 * @return - attribute value
	 */
	public static String getAttribute(WebElement element, String attributeName) {
		String attributeValue = "";
		try {
			attributeValue = element.getAttribute(attributeName);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return attributeValue;
	}

	/**
	 * To get the CSS property values
	 * 
	 * @param element     - Web Element
	 * @param cssProperty - CSS property
	 * @return
	 */
	public static String getCssValue(WebElement element, String cssProperty) {
		String cssValue = "";
		try {
			cssValue = element.getCssValue(cssProperty);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return cssValue;
	}

	/**
	 * To get the location of the element
	 * 
	 * @param element - Web Element
	 * @return
	 */
	public static Point getLocation(WebElement element) {
		Point point;
		try {
			point = element.getLocation();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return point;
	}

	/**
	 * To verify element is displayed
	 * 
	 * @param element - Web Element
	 * @return - true/false
	 */
	public static boolean isDisplayed(WebElement element) {
		boolean isDiplayed = false;
		try {
			element.isDisplayed();
			isDiplayed = true;

		} catch (Exception e) {

		}
		return isDiplayed;
	}

	/**
	 * To navigate to given url
	 * 
	 * @param applicationUrl - url of the application/page
	 */
	public static void navigateTo(String applicationUrl) {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			driver.navigate().to(applicationUrl);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To scroll into element
	 * 
	 * @param ele - Web Element
	 */
	public static void scrollIntoView(WebElement ele) {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ele);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To switch to frame using frame id
	 * 
	 * @param frameId
	 * @throws Exception
	 */
	public static void switchToFrame(String frameId) throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			WebDriverWait wait = new WebDriverWait(driver,
					Duration.ofSeconds(Integer.parseInt(ConfigFileReader.getProperty("max-wait-time"))));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		} catch (Exception e) {
			// Allure.captureScreenshot("iframe switch error");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To come out of frame
	 * 
	 * @throws Exception
	 */
	public static void switchToDefaultContent() throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void keyPress(WebElement element, String keyType) {
		try {

			switch (keyType.toUpperCase()) {
			case "DOWN":
				element.sendKeys(Keys.ARROW_DOWN);
				break;
			case "ENTER":
				element.sendKeys(Keys.ENTER);
				break;
			case "TAB":
				element.sendKeys(Keys.TAB);
				break;
			case "ESC":
				element.sendKeys(Keys.ESCAPE);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To click the Webelement using Action method
	 * @param element
	 * @throws Exception
	 */
	public static void mouseOverClick(WebElement element) throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).click().perform();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/*
	 *  @param : WebElement
	 *  @description : clears input one char at a time
	 */
	public static void clearInputOneCharAtTime(WebElement element) {
		Actions actions = new Actions(getCurrentDriver());
		Action action = actions.sendKeys(element,Keys.END,Keys.BACK_SPACE).build();
		int trials = 5;
		while(trials-- >= 0) {
			String value = WebAction.getAttribute(element, "value");
			int size = value == null ? 0 : value.length();
			if(size ==0) {
				break;
			}
			while(size-- >= 0) {
				action.perform();
			}
		}
	}
	/**
	 * @param : WebElement
	 * @description : for blurring the focused input element
	 */
	public static void blur(WebElement element) throws Exception{
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].blur();", element);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * @param : WebElement
	 * @description : for focusing input element
	 */
	public static void focus(WebElement element) throws Exception{
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].focus();", element);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * To scroll into element till the end of view window
	 * 
	 * @param ele - Web Element
	 */
	public static void scrollIntoViewTillBottom(WebElement ele) {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(false);", ele);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * To click the WebElement by moving over it
	 * @param element
	 * @throws Exception
	 */
	public static void mouseOverAndClick(WebElement element) throws Exception {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			action.click(element).build().perform();
		} catch (Exception e) {
			throw e;
		}
	}
}
