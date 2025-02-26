package nbcu.automation.ui.validation.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import nbcu.framework.utils.report.ReportGenerate;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;
import nbcu.framework.utils.ui.WebAction;

public class CommonValidations {

	// Missing fields Elements
	@FindBy(xpath = "//*[text()='Missing Fields: Please complete any mandatory fields and click Save']")
	WebElement missingFieldsPopup;
//
//	@FindBy(xpath = "//span[i[*[@data-icon='close']]]")
//	WebElement closeMessagePopup;

	/**
	 * To verify css value is matches with expected value
	 * 
	 * @param element       - Web Element
	 * @param typeOfCss     - CSS attribute name
	 * @param expectedValue - expected value
	 */
	public static void verifyCssValueOfWebElement(WebElement element, String typeOfCss, String expectedValue) {
		try {
			if ((typeOfCss.toLowerCase().contains("background color"))
					|| (typeOfCss.toLowerCase().contains("stroke")||(typeOfCss.toLowerCase().contains("revision highlight")))) {
				String actualColorRgbValue = null;
				if (typeOfCss.toLowerCase().contains("background color")) {
					System.out.println("actualColorRgbValue value before" + actualColorRgbValue);
					actualColorRgbValue = WebAction.getCssValue(element, "color");
					System.out.println("actualColorRgbValue value after" + actualColorRgbValue);
				}
				else if(typeOfCss.toLowerCase().contains("revision highlight")) {
					actualColorRgbValue = WebAction.getCssValue(element, "border-color");
					System.out.println("actualColorRgbValue value after" + actualColorRgbValue);
				}
				else if (typeOfCss.toLowerCase().contains("stroke"))
					actualColorRgbValue = WebAction.getCssValue(element, "Stroke");
				// System.out.println("***actual RGB ****:"+actualColorRgbValue);
				String actualColorHexaValue = Color.fromString(actualColorRgbValue).asHex();
				String expectedColorHexaValue = "";
				System.out.println("***actual Hex value ****:" + actualColorHexaValue);
				// Defining expected rgb values based on color
				switch (expectedValue.toUpperCase()) {
				case "PINK":
					expectedColorHexaValue = "#eb2f96";
					break;
				case "ORANGE":
					expectedColorHexaValue = "#fa8c16";
					break;
				case "BLUE":
					expectedColorHexaValue = "#1890ff";
					break;
				case "GREEN":
					expectedColorHexaValue = "#52c41a";
					break;
				case "GREY":
					expectedColorHexaValue = "#808080";
					break;
//				case "WHITE":
//					expectedColorHexaValue = "#ffffff";
//					break;
//				case "RED":
//					expectedColorHexaValue = "#d4380d";
//					break;
//				case "PURPLE":
//					expectedColorHexaValue = "#9254de";
//					break;
//				case "GOLD":
//					expectedColorHexaValue = "#FAAD14";
//					break;
				case "BLACK":
					expectedColorHexaValue = "#000000";
					break;
				default:
					Assert.assertTrue(false, "Given expected color is not valid-" + expectedValue);
					break;
				}
				Assert.assertTrue(actualColorHexaValue.equalsIgnoreCase(expectedColorHexaValue),
						"Expected " + typeOfCss + " is '" + expectedColorHexaValue + "' and actual " + typeOfCss
								+ " is '" + actualColorHexaValue + "'");
			} else {
				String actualValue = WebAction.getCssValue(element, typeOfCss);
				Assert.assertTrue(actualValue.contains(expectedValue), "Expected " + typeOfCss + " is '" + expectedValue
						+ "' and actual " + typeOfCss + " is '" + actualValue + "'");
			}
		} catch (Exception | Error e) {
			// Allure.captureScreenshot(typeOfCss + " css value does not match error");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify the attribute value of element matches with expected value
	 * 
	 * @param element                - Web Element
	 * @param attributeName          - attribute name
	 * @param expectedAttributeValue - expected attribute value
	 */
	public static void verifyAttributeValue(WebElement element, String attributeName, String expectedAttributeValue) {
		try {
			String ActualAttributeValue = WebAction.getAttribute(element, attributeName);
			Assert.assertTrue(ActualAttributeValue.contains(expectedAttributeValue), "Expected attribute value is '"
					+ expectedAttributeValue + "' and actual attribute value is '" + ActualAttributeValue + "'");
		} catch (Exception | Error e) {
			// Allure.captureScreenshot(attributeName + " attribute value does not match
			// error");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify the text of element matches with expected value
	 * 
	 * @param element      - Web Element
	 * @param expectedText - expected value
	 */
	public static void verifyTextValue(WebElement element, String expectedText) {
		try {
			String actualText = WebAction.getText(element).trim();
			Assert.assertTrue(actualText.toLowerCase().contains(expectedText.toLowerCase()),
					"Expected text is '" + expectedText + "' and actual text is '" + actualText + "'");
			//ReportGenerate.test.log(Status.INFO,"Expected text is '" + expectedText + "' and actual text is '" + actualText + "'");
		} catch (Exception | Error e) {
			// Allure.captureScreenshot("Text value does not match error");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To Verify element is enabled
	 * 
	 * @param element - Web Element
	 */
	public static void verifyElementIsEnabled(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			Assert.assertTrue(enabled, "Element is disabled");
		} catch (Exception | Error e) {
			// Allure.captureScreenshot("element is disabled error");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify element 1 position based element 2 position
	 * 
	 * @param element1 - Web Element 1
	 * @param element2 - Web Element 2
	 * @param position - below/above/right/left
	 * @throws Throwable
	 */
	public static void compareTwoElementPosition(WebElement element1, WebElement element2, String position)
			throws Throwable {
		try {
			// wait for visibility of both element
			Waits.waitForElement(element1, WAIT_CONDITIONS.VISIBLE);
			Waits.waitForElement(element2, WAIT_CONDITIONS.VISIBLE);

			// Comparing position
			Point element1Point = WebAction.getLocation(element1);
			Point element2Point = WebAction.getLocation(element2);
			switch (position.toUpperCase()) {
			case "ABOVE":
				Assert.assertTrue(element1Point.y < element2Point.y, "Element 1 is not above element 2");
				break;
			case "BELOW":
				System.out.println(element1Point.y);
				System.out.println(element2Point.y);
				Assert.assertTrue(element1Point.y > element2Point.y, "Element 1 is not below element 2");
				break;
			case "RIGHT":
				Assert.assertTrue(element1Point.x > element2Point.x, "Element 1 is not right to element 2");
				break;
			case "LEFT":
				Assert.assertTrue(element1Point.x > element2Point.x, "Element 1 is not left to element 2");
				break;
			default:
				Assert.assertTrue(false, "Given position is not valid-" + position);
				break;
			}
		} catch (Exception | Error e) {
			// Allure.captureScreenshot("position not matched error");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To validation option is present in dropdown
	 * 
	 * @param element        - WebElement
	 * @param expectedOption - Expected option
	 */
	public static void verifyDropdownOptions(WebElement element, String expectedOption) {
		boolean check = false;
		try {
			Select select = new Select(element);
			List<WebElement> optionElements = select.getOptions();
			for (WebElement e : optionElements) {
				String actualOption = WebAction.getText(e);
				if (actualOption.equalsIgnoreCase(expectedOption))
					check = true;
			}
			Assert.assertTrue(check, "Option '" + expectedOption + "' is not present in dropdown");

		} catch (Exception | Error e) {
			// Allure.captureScreenshot("option not present in dropdown error");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify both dates in descending order. i.e newest to old
	 * 
	 * @param actualDates
	 */
	public static void verifyDatesfromNewestToOldest(List<Date> actualDates) {
		try {
			List<Date> expectedDates = new ArrayList<Date>();
			expectedDates.addAll(actualDates);
			Collections.sort(actualDates, Collections.reverseOrder());
			Assert.assertEquals(actualDates, expectedDates, "Search results not in descending order");

		} catch (Exception | Error e) {
			// Allure.captureScreenshot("Search results not in descending order");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify 2 text
	 * 
	 * @param element      - Web Element
	 * @param expectedText - expected value
	 */
	public static void verifytextValue(int actual, int expected) {
		try {
			Assert.assertTrue(actual == expected, "Expected is '" + expected + "' and actual is '" + actual + "'");
		} catch (Exception | Error e) {
			// Allure.captureScreenshot("Value does not match error");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify the text of element matches with expected value
	 * 
	 * @param element      - Web Element
	 * @param expectedText - expected value
	 */
	public static void verifyTextValue(WebElement element, String expectedText, String failureMessage) {
		try {
			String actualText = WebAction.getText(element).trim();
			Assert.assertTrue(actualText.toLowerCase().contains(expectedText.toLowerCase()), failureMessage
					+ ". Expected text is '" + expectedText + "' and actual text is '" + actualText + "'");
		} catch (Exception | Error e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify 'missing field' error pop up
	 * 
	 * @throws Exception
	 */
	public void verifyOverallMissingFieldErrorPopup() throws Exception {
		try {
			Waits.waitForElement(missingFieldsPopup, WAIT_CONDITIONS.VISIBLE);
			// WebAction.click(closeMessagePopup);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
