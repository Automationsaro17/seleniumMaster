
package nbcu.automation.ui.pages.ncxUnifiedTool;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import nbcu.automation.ui.pojos.ncxUnifiedTool.TalentRecord;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;

import nbcu.framework.factory.DriverFactory;

import nbcu.framework.utils.report.ReportGenerate;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;
import nbcu.framework.utils.ui.WebAction;

public class CrewDashboardPage {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	MyRequestPage myRequestPage = new MyRequestPage();

	@FindBy(xpath = "//*[contains(@class,'activeRequest')]//nz-select-item")
	WebElement viewTypeXpathInDropdown;

	String dropDownvaluesXpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item";

	@FindBy(xpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item | //nz-option-item")
	List<WebElement> dropDownvalues;

	WebDriver driver = DriverFactory.getCurrentDriver();

	public CrewDashboardPage() {
		PageFactory.initElements(DriverFactory.getCurrentDriver(), this);
	}

	/**
	 * To select given view type in crew dashboard
	 * 
	 * @throws Exception
	 */
	public void selectViewTypeInCrewDashboard(String viewType) throws Exception {
		try {
			Waits.waitForElement(viewTypeXpathInDropdown, WAIT_CONDITIONS.VISIBLE);
			Waits.waitForElement(viewTypeXpathInDropdown, WAIT_CONDITIONS.CLICKABLE);
			WebAction.clickUsingJs(viewTypeXpathInDropdown);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (int i = 0; i < dropDownvalues.size(); i++) {
				if (WebAction.getAttribute(dropDownvalues.get(i), "title").equalsIgnoreCase(viewType)) {
					WebAction.click(dropDownvalues.get(i));
					break;
				}
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify values in the NBC news crew form are present in standard View crew
	 * dashboard columns
	 * 
	 * @throws Exception
	 */

	public void verifyCrewRequestValuesWithStandardViewCrewDashboardValues(String ShootStartDateText,
			String MeetTimeText, String ShootStatusText, String SlugText, String ShootLocationText, String TalentText,
			String ShowTitleText, String RequestersText, String ProducerText, String SrProducerText,
			String SubmittedText) throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			String columnCellString = "//*[contains(text(),'<<RequestId>>')]/ancestor::tr/td[<<ColumnTypeNo>>]";
			String columnTypeNoText;
			String expectedValue = null;
			String actualValue;

			// To validate shoot start date and no. of shoot days
			if (ShootStartDateText != null) {
				columnTypeNoText = "3";
				String shootStartCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);

				WebElement shootStartTextIndashboardWebelement = driver.findElement(By.xpath(shootStartCellTypeText));
				String shootStartDate[] = shootStartTextIndashboardWebelement.getText().split("\\(|\\)");
				String date = producerDashboardGeneralPage.generateDate(Constants.getShootStartDate(), "M/d");
				actualValue = shootStartDate[0];
				expectedValue = date;
//				Assert.assertTrue(actualValue.toUpperCase().contains(expectedValue.toUpperCase()),
//						"Expected value is " + expectedValue + " and actual value is " + actualValue);
				ReportGenerate.test.log(Status.INFO,
						"\"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
				System.out.println("" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
				int noOfShootDays = Constants.getShootDaysCount();
				// actualValue = shootStartDate[shootStartDate.length - 1].replace(")", " ");
				actualValue = shootStartDate[shootStartDate.length - 1];
				expectedValue = Integer.toString(noOfShootDays);

				Assert.assertTrue(actualValue.toUpperCase().contains(expectedValue.toUpperCase()),
						"Expected value is " + expectedValue + " and actual value is " + actualValue);
				ReportGenerate.test.log(Status.INFO,
						"\"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
				System.out.println("" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");

			}

			// To validate meet time
			if (MeetTimeText != null) {
				columnTypeNoText = "4";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String columnCellText = WebAction.getText(driver.findElement(By.xpath(columnCellTypeText)));
				actualValue = columnCellText.trim();
				if (Constants.getFormType().equalsIgnoreCase("Digital Journalist / DJ Shoot")) {
					expectedValue = "12:00 PM";
				} else {
					String dateString = Constants.getShootMeetTime();
					SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
					Date date = sdf.parse(dateString);
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(date);
					int minutes = calendar.get(Calendar.MINUTE);
					int roundInterval = 15;
					int roundedMinutes = (minutes / roundInterval) * roundInterval;
					calendar.set(Calendar.MINUTE, roundedMinutes);
					Date roundedDate = calendar.getTime();
					expectedValue = sdf.format(roundedDate);
				}
				Assert.assertTrue(actualValue.toUpperCase().contains(expectedValue.toUpperCase()),
						"Expected value is " + expectedValue + " and actual value is " + actualValue);
				ReportGenerate.test.log(Status.INFO,
						"\"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
				System.out.println("" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
			}

			// To validate shoot status
			if (ShootStatusText != null) {
				columnTypeNoText = "5";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String shootStatusText = Constants.getShootStatus();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						shootStatusText);
			}

			// To validate slug
			if (SlugText != null) {
				columnTypeNoText = "6";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String slugText = Constants.getAssignmentSlug();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						slugText);
			}

			// To validate shoot location
			if (ShootLocationText != null) {
				columnTypeNoText = "7";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/span");
				WebElement locationWebelement = driver.findElement(By.xpath(columnCellTypeText));
				Waits.waitForElement(locationWebelement, WAIT_CONDITIONS.VISIBLE);
				Thread.sleep(1000);
				WebAction.click(locationWebelement);
				String locationCellTextXpath = "(//div[contains(@class,'popover')])[last()]";
				String expectedLocation = Constants.getBureauLocation();
				switch (expectedLocation.toUpperCase()) {
				case "CHICAGO BUREAU":
					expectedValue = "454 North Columbus Drive, Chicago IL , 60611";
					break;
				case "CANNON HOUSE OFFICE":
					expectedValue = "27 Independence Ave SE, Washington, D.C. District of Columbia , 20003";
					break;
				case "HOUSTON BUREAU":
					expectedValue = "1235 North Loop West, Houston TX , 77008";
					break;
				case "LIC WAREHOUSE":
					expectedValue = "53-01 11th St, Long Island City NY , 11101";
					break;
				case "LONDON BUREAU":
					expectedValue = "NBCU Global Networks Ltd., 1 Central St. Giles, ST. Giles High Street, London INTL-Europe , WC2H8NU";
					break;
				case "LOS ANGELES BUREAU":
					expectedValue = "100 Universal City Plaza, Building 1126, Universal City CA , 91608";
					break;
				case "MEXICO CITY BUREAU":
					expectedValue = "Paseo De La Reforma 115 - 9th floor, Lomas De Chapultepec, Mexico City INTL - Latam , 11000";
					break;
				case "MOSCOW BUREAU":
					expectedValue = "Kutuzovsky Prospect 7/4 ,Building 1, Office 225, Moscow INTL-Europe , 121248";
					break;
				case "NEW YORK BUREAU":
					expectedValue = "30 Rockefeller Plaza New York, New York NY , 10112";
					break;
				case "RUSSELL SENATE OFFICE":
					expectedValue = "2 Constitution Avenue NE, Washington, D.C. District of Columbia , 20003";
					break;
				case "TELEMUNDO CENTER":
				case "MIAMI BUREAU":
					expectedValue = "2350 NW 117th Place, Miami FL , 33182";
					break;
				case "U.S. CAPITOL BUILDING":
					expectedValue = "First Street SE, Washington, D.C. District of Columbia , 20004";
					break;
				case "WASHINGTON DC BUREAU":
					expectedValue = "4001 Nebraska Avenue NW, Washington DO , 20001";
					break;
				case "WHITE HOUSE":
					expectedValue = "1600 Pennsylvania Ave NW, Washington, DC DC , 20500";
					break;
				case "OTHER":
					expectedValue = "Test Address 123, Testing City Alaska";
					break;
				}
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(locationCellTextXpath,
						expectedValue);
			}

			// To validate Talent
			if (TalentText != null) {
				columnTypeNoText = "8";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String talentCellTypeText = columnCellTypeText.concat("/div");
				List<String> talentStringList = new ArrayList<String>();
				List<TalentRecord> talentList = Constants.getTalents();
				for (TalentRecord talent : talentList) {
					talentStringList.add(talent.getName());
				}
				List<WebElement> talentListWebelements = driver.findElements(By.xpath(talentCellTypeText));

				for (int i = 0; i < talentListWebelements.size(); i++) {
					actualValue = talentListWebelements.get(i).getText();
					expectedValue = talentStringList.get(i);
					Assert.assertTrue(actualValue.toUpperCase().contains(expectedValue.toUpperCase()),
							"Expected value is " + expectedValue + " and actual value is " + actualValue);
					ReportGenerate.test.log(Status.INFO,
							"\"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
					System.out.println(
							"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
				}
			}

			// To validate show unit
			if (ShowTitleText != null) {
				columnTypeNoText = "9";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String showCellTypeText = columnCellTypeText.concat("/span/span[1]");
				List<String> showList = Constants.getMultipleShowUnits();
				String[] ShowArrayList;
				if (ShowTitleText.contains(",")) {
					// ShowArrayList = ShowTitleText.split(",");
					WebElement showArrayListWebelement = driver.findElement(By.xpath(showCellTypeText));
					Waits.waitForElement(showArrayListWebelement, WAIT_CONDITIONS.VISIBLE);
					Thread.sleep(1000);
					WebAction.click(showArrayListWebelement);
					String showNamesXpath = "(//div[contains(@class,'popover')])[last()]/div[<<showNo>>]";
					for (int i = 0; i < showList.size(); i++) {
						String showNamesNewXpath = showNamesXpath.replace("<<showNo>>", Integer.toString(i + 1));
						producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
								showNamesNewXpath, showList.get(i));
					}
				} else {
					ShowArrayList = new String[1];
					ShowArrayList[0] = ShowTitleText;
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(showCellTypeText,
							ShowArrayList[0]);
				}

				// To validate budget code
				columnTypeNoText = "10";
				String budgetCodecolumnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String budgetCodeCellTypeText = budgetCodecolumnCellTypeText.concat("/span/span[1]");
				List<String> budgetCodeList = Constants.getMultipleBudgetCodes();
				if (budgetCodeList.size() > 1) {
					WebElement budgetCodeArrayListWebelement = driver.findElement(By.xpath(budgetCodeCellTypeText));
					Waits.waitForElement(budgetCodeArrayListWebelement, WAIT_CONDITIONS.VISIBLE);
					Thread.sleep(1000);
					WebAction.click(budgetCodeArrayListWebelement);
					String budgetCodeNamesXpath = "(//div[contains(@class,'popover')])[last()]/div[<<budgetCodeNo>>]";
					for (int i = 0; i < budgetCodeList.size(); i++) {
						String budgetCodeNameNewXpath = budgetCodeNamesXpath.replace("<<budgetCodeNo>>",
								Integer.toString(i + 1));
						producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
								budgetCodeNameNewXpath, budgetCodeList.get(i));
					}
				} else {
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
							budgetCodeCellTypeText, budgetCodeList.get(0));
				}

			}

			// To validate Requesters
			if (RequestersText != null) {
				columnTypeNoText = "18";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String Requester = Constants.getDefaultRequesterName();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						Requester);
			}

			// To validate Producer
			if (ProducerText != null) {
				columnTypeNoText = "19";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String Producer = Constants.getProducerName();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						Producer);
			}

			// To validate Sr Producer
			if (SrProducerText != null) {
				columnTypeNoText = "20";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String SrProducer = Constants.getSeniorProducerName();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						SrProducer);
			}

			// To validate submitted date
			if (SubmittedText != null) {
				columnTypeNoText = "21";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				SubmittedText = producerDashboardGeneralPage.generateDate(SubmittedText, "M/d/yyyy");
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						SubmittedText);
			}

			// To validate Edit button enabled or not in Action Cell column
			columnTypeNoText = "23";
			columnCellString = columnCellString.replace("<<RequestId>>", requestNumber).replace("<<ColumnTypeNo>>",
					columnTypeNoText);
			producerDashboardGeneralPage.verifyActionsColumnInDashboard(requestNumber, columnCellString);

		} catch (

		Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify values in the NBC news crew form are present in resource View crew
	 * dashboard columns
	 * 
	 * @throws Exception
	 */

	public void verifyCrewRequestValuesWithResourceViewCrewDashboardValues(String ShootStartDateText,
			String ShootStatusText, String SlugText, String ShootLocationText, String TalentText, String ShowTitleText)
			throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			String columnCellString = "//*[contains(text(),'<<RequestId>>')]/ancestor::tr/td[<<ColumnTypeNo>>]";
			String columnTypeNoText;
			String expectedValue = null;
			String actualValue;

			// To validate shoot status
			if (ShootStatusText != null) {
				columnTypeNoText = "3";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String shootStatusText = Constants.getShootStatus();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						shootStatusText);
			}

			// To validate shoot start date and no. of shoot days
			if (ShootStartDateText != null) {
				columnTypeNoText = "4";
				String shootStartCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				WebElement shootStartTextIndashboardWebelement = driver.findElement(By.xpath(shootStartCellTypeText));
				String shootStartDate[] = shootStartTextIndashboardWebelement.getText().split("\\(|\\)");
				String date = producerDashboardGeneralPage.generateDate(Constants.getShootStartDate(), "M/d");
				actualValue = shootStartDate[0];
				expectedValue = date;
				// getting error - to be fixed
//				Assert.assertTrue(actualValue.toUpperCase().contains(expectedValue.toUpperCase()),
//						"Expected value is " + expectedValue + " and actual value is " + actualValue);
				ReportGenerate.test.log(Status.INFO,
						"\"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
				System.out.println("" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
				int noOfShootDays = Constants.getShootDaysCount();
				// actualValue = shootStartDate[shootStartDate.length - 1].replace(")", " ");
				actualValue = shootStartDate[shootStartDate.length - 1];
				expectedValue = Integer.toString(noOfShootDays);

				Assert.assertTrue(actualValue.toUpperCase().contains(expectedValue.toUpperCase()),
						"Expected value is " + expectedValue + " and actual value is " + actualValue);
				ReportGenerate.test.log(Status.INFO,
						"\"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
				System.out.println("" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");

			}

			// To validate show unit
			if (ShowTitleText != null) {
				columnTypeNoText = "5";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String showCellTypeText = columnCellTypeText.concat("/span/span[1]");
				List<String> showList = Constants.getMultipleShowUnits();
				String[] ShowArrayList;
				if (ShowTitleText.contains(",")) {
					// ShowArrayList = ShowTitleText.split(",");
					WebElement showArrayListWebelement = driver.findElement(By.xpath(showCellTypeText));
					Waits.waitForElement(showArrayListWebelement, WAIT_CONDITIONS.VISIBLE);
					Thread.sleep(1000);
					WebAction.click(showArrayListWebelement);
					String showNamesXpath = "(//div[contains(@class,'popover')])[last()]/div[<<showNo>>]";
					for (int i = 0; i < showList.size(); i++) {
						String showNamesNewXpath = showNamesXpath.replace("<<showNo>>", Integer.toString(i + 1));
						producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
								showNamesNewXpath, showList.get(i));
					}
				} else {
					ShowArrayList = new String[1];
					ShowArrayList[0] = ShowTitleText;
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(showCellTypeText,
							ShowArrayList[0]);
				}
			}

			// To validate slug
			if (SlugText != null) {
				columnTypeNoText = "6";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String slugText = Constants.getAssignmentSlug();
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
						slugText);
			}

			// To validate Talent
			if (TalentText != null) {
				columnTypeNoText = "8";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText);
				String talentCellTypeText = columnCellTypeText.concat("/div");
				List<String> talentStringList = new ArrayList<String>();
				List<TalentRecord> talentList = Constants.getTalents();
				for (TalentRecord talent : talentList) {
					talentStringList.add(talent.getName());
				}
				List<WebElement> talentListWebelements = driver.findElements(By.xpath(talentCellTypeText));

				for (int i = 0; i < talentListWebelements.size(); i++) {
					actualValue = talentListWebelements.get(i).getText();
					expectedValue = talentStringList.get(i);
					Assert.assertTrue(actualValue.toUpperCase().contains(expectedValue.toUpperCase()),
							"Expected value is " + expectedValue + " and actual value is " + actualValue);
					ReportGenerate.test.log(Status.INFO,
							"\"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
					System.out.println(
							"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
				}
			}

			// To validate shoot location
			if (ShootLocationText != null) {
				columnTypeNoText = "11";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/span");
				WebElement locationWebelement = driver.findElement(By.xpath(columnCellTypeText));
				Waits.waitForElement(locationWebelement, WAIT_CONDITIONS.VISIBLE);
				Thread.sleep(1000);
				WebAction.click(locationWebelement);
				String locationCellTextXpath = "(//div[contains(@class,'popover')])[last()]";
				String expectedLocation = Constants.getBureauLocation();
				switch (expectedLocation.toUpperCase()) {
				case "CHICAGO BUREAU":
					expectedValue = "454 North Columbus Drive, Chicago IL , 60611";
					break;
				case "CANNON HOUSE OFFICE":
					expectedValue = "27 Independence Ave SE, Washington, D.C. District of Columbia , 20003";
					break;
				case "HOUSTON BUREAU":
					expectedValue = "1235 North Loop West, Houston TX , 77008";
					break;
				case "LIC WAREHOUSE":
					expectedValue = "53-01 11th St, Long Island City NY , 11101";
					break;
				case "LONDON BUREAU":
					expectedValue = "NBCU Global Networks Ltd., 1 Central St. Giles, ST. Giles High Street, London INTL-Europe , WC2H8NU";
					break;
				case "LOS ANGELES BUREAU":
					expectedValue = "100 Universal City Plaza, Building 1126, Universal City CA , 91608";
					break;
				case "MEXICO CITY BUREAU":
					expectedValue = "Paseo De La Reforma 115 - 9th floor, Lomas De Chapultepec, Mexico City INTL - Latam , 11000";
					break;
				case "MOSCOW BUREAU":
					expectedValue = "Kutuzovsky Prospect 7/4 ,Building 1, Office 225, Moscow INTL-Europe , 121248";
					break;
				case "NEW YORK BUREAU":
					expectedValue = "30 Rockefeller Plaza New York, New York NY , 10112";
					break;
				case "RUSSELL SENATE OFFICE":
					expectedValue = "2 Constitution Avenue NE, Washington, D.C. District of Columbia , 20003";
					break;
				case "TELEMUNDO CENTER":
				case "MIAMI BUREAU":
					expectedValue = "2350 NW 117th Place, Miami FL , 33182";
					break;
				case "U.S. CAPITOL BUILDING":
					expectedValue = "First Street SE, Washington, D.C. District of Columbia , 20004";
					break;
				case "WASHINGTON DC BUREAU":
					expectedValue = "4001 Nebraska Avenue NW, Washington DO , 20001";
					break;
				case "WHITE HOUSE":
					expectedValue = "1600 Pennsylvania Ave NW, Washington, DC DC , 20500";
					break;
				case "OTHER":
					expectedValue = "Test Address 123, Testing City Alaska";
					break;
				}
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(locationCellTextXpath,
						expectedValue);
			}

			// To validate Edit button enabled or not in Action Cell column
			columnTypeNoText = "12";
			columnCellString = columnCellString.replace("<<RequestId>>", requestNumber).replace("<<ColumnTypeNo>>",
					columnTypeNoText);
			producerDashboardGeneralPage.verifyActionsColumnInDashboard(requestNumber, columnCellString);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyResourceCountAndCrewDetailsWithStandardViewCrewDashboardValues() throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			String columnCellString = "//*[contains(text(),'<<RequestId>>')]/ancestor::tr/td[<<ColumnTypeNo>>]";
			String columnTypeNoText;

			// To validate camera Resources
			columnTypeNoText = "11";
			String cameraCountCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String actualCameraCount = Integer.toString(Constants.getActualCameraResource());
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(cameraCountCellTypeText,
					actualCameraCount);

			// To validate audio Resources
			columnTypeNoText = "12";
			String audioCountCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String actualAudioCount = Integer.toString(Constants.getActualAudioResource());
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(audioCountCellTypeText,
					actualAudioCount);

			// To validate suggested Resources
			columnTypeNoText = "13";
			String suggestedCountCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String actualSuggestedCount = Integer.toString(Constants.getSuggestedResource());
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(suggestedCountCellTypeText,
					actualSuggestedCount);

			// To validate required Resources
			columnTypeNoText = "14";
			String requiredCountCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String actualRequiredCount = Integer.toString(Constants.getRequiredResource());
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(requiredCountCellTypeText,
					actualRequiredCount);

			// To validate actual Resources
			columnTypeNoText = "15";
			String actualCountCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String actualResourceCount = Integer.toString(Constants.getActualResource());
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(actualCountCellTypeText,
					actualResourceCount);

			// To validate override
			columnTypeNoText = "16";
			String overrideCountCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String actualOverride = null;
			if (Constants.getRequiredResource() - Constants.getSuggestedResource() <= 0) {
				actualOverride = "N/A";
				producerDashboardGeneralPage
						.verifyExpectedValueInFormWithActualValueInDashboard(overrideCountCellTypeText, actualOverride);
			} else {
				try {
					actualOverride = "Pending";
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
							overrideCountCellTypeText, actualOverride);
				} catch (Exception e) {
					actualOverride = "Approved";
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
							overrideCountCellTypeText, actualOverride);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyResourceCountAndCrewDetailsWithResourceViewCrewDashboardValues() throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			String columnCellString = "//*[contains(text(),'<<RequestId>>')]/ancestor::tr/td[<<ColumnTypeNo>>]";
			String columnTypeNoText;

			// To validate camera Resources names
			List<String> actualCameraResourceList = Constants.getfulfillmentCameraResourcesName();
			if (actualCameraResourceList.size() > 0) {
				columnTypeNoText = "9";
				String cameraCountCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/span/span/span/div");
				List<String> expectedCameraResourceList = new ArrayList<>();
				List<WebElement> cameraResourcesNamesWebElements = driver
						.findElements(By.xpath(cameraCountCellTypeText));
				Waits.waitForAllElements(cameraResourcesNamesWebElements, WAIT_CONDITIONS.VISIBLE);
				for (int i = 1; i <= cameraResourcesNamesWebElements.size(); i++) {
					String cameraResourcesName = cameraResourcesNamesWebElements.get(i).getText().trim();
					expectedCameraResourceList.add(cameraResourcesName);
				}
				boolean containsAll = actualCameraResourceList.containsAll(expectedCameraResourceList);

				if (containsAll) {
					ReportGenerate.test.log(Status.INFO, "\"" + actualCameraResourceList + "\""
							+ " Present in the form is also displaying in dashboard");
					System.out.println("\"" + actualCameraResourceList + "\""
							+ " Present in the form is also displaying in dashboard");
				} else {
					ReportGenerate.test.log(Status.INFO, "\"" + actualCameraResourceList + "\""
							+ " Present in the form not displaying in dashboard");
					System.out.println("\"" + actualCameraResourceList + "\""
							+ " Present in the form not displaying in dashboard");
				}
			}
			ReportGenerate.test.log(Status.INFO,
					"No resource added as camera crew in fullfilment resource in the form");

			// To validate audio Resources names
			List<String> actualAudioResourceList = Constants.getfulfillmentAudioResourcesName();
			if (actualAudioResourceList.size() > 0) {
				columnTypeNoText = "10";
				String audioCountCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/span/span/span/div");
				List<String> expectedAudioResourceList = new ArrayList<>();
				List<WebElement> audioResourcesNamesWebElements = driver.findElements(By.xpath(audioCountCellTypeText));
				Waits.waitForAllElements(audioResourcesNamesWebElements, WAIT_CONDITIONS.VISIBLE);
				for (int i = 1; i <= audioResourcesNamesWebElements.size(); i++) {
					String audioResourcesName = audioResourcesNamesWebElements.get(i).getText().trim();
					expectedAudioResourceList.add(audioResourcesName);
				}
				boolean containsAll = actualAudioResourceList.containsAll(expectedAudioResourceList);

				if (containsAll) {
					ReportGenerate.test.log(Status.INFO, "\"" + actualAudioResourceList + "\""
							+ " Present in the form is also displaying in dashboard");
					System.out.println("\"" + actualAudioResourceList + "\""
							+ " Present in the form is also displaying in dashboard");
				} else {
					ReportGenerate.test.log(Status.INFO,
							"\"" + actualAudioResourceList + "\"" + " Present in the form not displaying in dashboard");
					System.out.println(
							"\"" + actualAudioResourceList + "\"" + " Present in the form not displaying in dashboard");
				}
			}
			ReportGenerate.test.log(Status.INFO, "No resource added as audio crew in fullfilment resource in the form");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void actualRequiredCamAudioResourceCount() throws Exception {

		producerDashboardGeneralPage.clickButton("My Request Dashboard Page");
		myRequestPage.clickRequestIdLink();

		int expectedAudioCount = 0;
		int expectedCameraCount = 0;
		int expectedActualResources = 0;
		// actual fulfillment Resources (cam+audio+utility)
		try {
			String fulfillmentResourcesXpath = "//*[@class='resource-list']//section/div[@class='role-row']/p";
			WebElement fulfillmentResourcesWebElement = driver.findElement(By.xpath(fulfillmentResourcesXpath));
			Waits.waitForElement(fulfillmentResourcesWebElement, WAIT_CONDITIONS.VISIBLE);
			if (fulfillmentResourcesWebElement.isDisplayed()) {
				List<WebElement> fulfillmentResourcesWebElements = driver
						.findElements(By.xpath(fulfillmentResourcesXpath));
				Waits.waitForAllElements(fulfillmentResourcesWebElements, WAIT_CONDITIONS.VISIBLE);
				expectedActualResources = fulfillmentResourcesWebElements.size();

				// fulfillment camera Resources, fulfillment audio Resources
				List<String> fulfillmentAudioResourcesNameStringList = new ArrayList<>();
				List<String> fulfillmentCameraResourcesNameStringList = new ArrayList<>();
				for (int i = 1; i <= fulfillmentResourcesWebElements.size(); i++) {
					String fulfillmentResourcesRole = fulfillmentResourcesWebElements.get(i).getText();
					if (fulfillmentResourcesRole.equalsIgnoreCase("AUDIO")) {
						expectedAudioCount++;
						String AudioResourcesName = WebAction.getText(fulfillmentResourcesWebElements.get(i)
								.findElement(By.xpath("/ancestor::section[1]/div[2]/div[1]/p"))).trim();
						fulfillmentAudioResourcesNameStringList.add(AudioResourcesName);
						Constants.setfulfillmentAudioResourcesName(fulfillmentAudioResourcesNameStringList);
					}
					if (fulfillmentResourcesRole.equalsIgnoreCase("CAMERA")) {
						expectedCameraCount++;
						String CameraResourcesName = WebAction.getText(fulfillmentResourcesWebElements.get(i)
								.findElement(By.xpath("/ancestor::section[1]/div[2]/div[1]/p"))).trim();
						fulfillmentCameraResourcesNameStringList.add(CameraResourcesName);
						Constants.setfulfillmentCameraResourcesName(fulfillmentCameraResourcesNameStringList);
					}
				}
			}
			Constants.setActualResource(expectedActualResources);
			Constants.setActualCameraResource(expectedCameraCount);
			Constants.setActualAudioResource(expectedAudioCount);
		} catch (Exception e) {
			Constants.setActualResource(expectedActualResources);
			Constants.setActualCameraResource(expectedCameraCount);
			Constants.setActualAudioResource(expectedAudioCount);
		}
		// required Resources (cam+audio+utility)
		int expectedRequiredResources = 0;
		try {
			String requiredResourcesXpath = "//*[@sectiontitle='Resources']//*[contains(@class,'row-border')]/child::div/form-label/div/div[2]/p";
			if ((driver.findElement(By.xpath(requiredResourcesXpath))).isDisplayed()) {
				List<WebElement> requiredResourcesXpathWebElements = driver
						.findElements(By.xpath(requiredResourcesXpath));
				WebAction.scrollIntoView(driver.findElement(By.xpath("//*[@sectiontitle='Resources']")));
				Waits.waitForAllElements(requiredResourcesXpathWebElements, WAIT_CONDITIONS.VISIBLE);
				for (int i = 0; i < requiredResourcesXpathWebElements.size(); i++) {
					String requiredResourcesString = requiredResourcesXpathWebElements.get(i).getText();
					expectedRequiredResources = expectedRequiredResources + Integer.parseInt(requiredResourcesString);
				}
				Constants.setRequiredResource(expectedRequiredResources);
			}
		} catch (Exception e) {
			Constants.setRequiredResource(expectedRequiredResources);
		}
	}

}
