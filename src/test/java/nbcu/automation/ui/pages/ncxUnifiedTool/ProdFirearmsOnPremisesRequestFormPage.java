
package nbcu.automation.ui.pages.ncxUnifiedTool;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;
import nbcu.automation.ui.pojos.ncxUnifiedTool.FirearmRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.LocationRecord;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.factory.DriverFactory;
import static nbcu.framework.factory.DriverFactory.getCurrentDriver;

import nbcu.framework.utils.report.ReportGenerate;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;
import nbcu.framework.utils.ui.WebAction;
import static nbcu.framework.utils.ui.WebAction.getText;
import static nbcu.framework.utils.ui.Waits.waitForElement;

public class ProdFirearmsOnPremisesRequestFormPage {

	private ThreadLocal<Integer> numberOfFirearms = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 1;
		}
	};
	private ThreadLocal<Integer> numberOfLocations = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 1;
		}
	};

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	public ProducerDashboardGeneralPage getProducerDashboardGeneralPage() {
		return producerDashboardGeneralPage;
	}

	@FindBy(xpath = "//p[contains(text(),'FIREARM(S) INFORMATION')]")
	WebElement firearmsInformationSection;

	@FindBy(xpath = "//*[contains(@placeholder,'Type of Firearm')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement typeOfFirearmError;

	@FindBy(xpath = "//*[contains(text(),'How Many')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement howManyFirearmError;

	@FindBy(xpath = "//*[contains(@name,'firearmType')]/ancestor::div[3]//div[contains(@class,'error')]")
	WebElement firearmTypeError;

	@FindBy(xpath = "//*[contains(@label,'Type of Firearm')]//input")
	WebElement firearmTypeInputBox;

	@FindBy(xpath = "//*[contains(text(),'How Many')]/ancestor::div[1]//input")
	WebElement firearmHowMany;

	@FindBy(xpath = "//*[@name='firearmType']//label[@nzvalue='Yes']")
	WebElement typeFirearms_Yes_Replica;

	@FindBy(xpath = "//*[@name='firearmType']//label[@nzvalue='No']")
	WebElement typeFirearms_No_Functioning;

	@FindBy(xpath = "//*[@sectionTitle]//*[contains(@class,'status-title-area')]//p[contains(@class,'left-hand-title')]")
	List<WebElement> formSectionTitles;

	@FindBy(xpath = "//*[@sectiontitle='General Details']//nz-form-label//label")
	List<WebElement> generalDetailsSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Requester(s)']//nz-form-label//label")
	List<WebElement> requestersSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Talent']//nz-form-label//label")
	List<WebElement> talentSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Show Info']//nz-form-label//label")
	List<WebElement> showInfoSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Set Location']//nz-form-label//label")
	List<WebElement> setLocationSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='FIREARM(s) Information']//nz-form-label//label")
	List<WebElement> firearmsInformationSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Details']//nz-form-label//label")
	List<WebElement> detailsSectionFieldLabels;

	@FindBy(xpath = "//*[text()=' Location ']/../following::*[1]//input")
	WebElement locationInput;

	@FindBy(xpath = "//label[contains(text(),'Division')]/ancestor::nz-form-label/following::input[1]")
	WebElement divisionInput;

	@FindBy(xpath = "//label[contains(text(),'Show Unit or Project Name')]/ancestor::nz-form-label/following::input[1]")
	WebElement showUnitOrProjectNameInput;

	@FindBy(xpath = "//label[text()=' Air Platform ']/ancestor::nz-form-label/following::input[1]")
	WebElement airPlatformInput;

	@FindBy(xpath = "//label[text()=' Work Order # ']/ancestor::nz-form-label/following::input[1]")
	WebElement workOrderInput;

	@FindBy(xpath = "//label[text()=' Arrival Date ']/ancestor::nz-form-label/following::input[1]")
	WebElement arrivalDateInput;

	@FindBy(xpath = "//label[text()=' Arrival Time ']/ancestor::nz-form-label/following::input[1]")
	WebElement arrivalTimeInput;

	@FindBy(xpath = "//label[text()=' Departure Date ']/ancestor::nz-form-label/following::input[1]")
	WebElement departureDateInput;

	@FindBy(xpath = "//label[text()=' Departure Time ']/ancestor::nz-form-label/following::input[1]")
	WebElement departureTimeInput;

	@FindBy(xpath = "//label[text()=' Other ']/ancestor::nz-form-label/following::input[1]")
	WebElement otherInput;

	@FindBy(xpath = "//*[text()=' Details and Notes ']/../following::*[1]//textarea")
	WebElement detailsAndNotesInput;

	@FindBy(xpath = "//*[contains(text(),' Type ')]/../following::*[1]//input")
	List<WebElement> typeRadios;

	@FindBy(xpath = "//*[contains(text(),' Type ')]/../following::*[1]//*[text()]")
	List<WebElement> typeRadioLabels;

	@FindBy(xpath = "//*[@sectiontitle='Set Location']//label")
	List<WebElement> labelsInSetLocationSectionInReadOnlyForm;

	@FindBy(xpath = "//*[@sectiontitle='Set Location']//input")
	List<WebElement> inputsInSetLocationSectionInReadOnlyForm;

	@FindBy(xpath = "//*[@sectiontitle='FIREARM(s) Information']//*[@role='tab']")
	List<WebElement> tabButtonsInFirearmsInformationInReadOnlyForm;

	@FindBy(xpath = "//*[@sectiontitle='FIREARM(s) Information']//*[contains(@class,'ant-collapse-content-active')]//label")
	List<WebElement> labelsInFirearmsInformationInReadOnlyForm;

	@FindBy(xpath = "//*[@sectiontitle='FIREARM(s) Information']//*[contains(@class,'ant-collapse-content-active')]//input")
	List<WebElement> inputsInFirearmsInformationInReadOnlyForm;

	@FindBy(xpath = "(//*[@sectiontitle='Details']//label)[1]")
	WebElement detailsAndNotesLabel;

	@FindBy(xpath = "(//*[@sectiontitle='Details']//label)[2]")
	WebElement detailsAndNotesValue;

	@FindBy(xpath = "//*[contains(text(),'Division')]/following::*[1]//p")
	WebElement divisionValue;

	public ProdFirearmsOnPremisesRequestFormPage() {
		PageFactory.initElements(DriverFactory.getCurrentDriver(), this);
	}

	/**
	 * To verify handlers info section missing field error message
	 *
	 * @throws Exception
	 */
	public void verifyFirearmsInfoMissingFieldError(String typeOfFirearmErrorMessage, String howManyFirearmErrorMessage,
			String firearmTypeErrorMessage) throws Exception {
		WebAction.scrollIntoView(firearmsInformationSection);
		try {
			typeOfFirearmErrorMessage(typeOfFirearmErrorMessage);
			howManyFirearmErrorMessage(howManyFirearmErrorMessage);
			firearmTypeErrorMessage(firearmTypeErrorMessage);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void typeOfFirearmErrorMessage(String typeOfFirearmErrorMessage) {
		CommonValidations.verifyTextValue(typeOfFirearmError, typeOfFirearmErrorMessage);
	}

	public void howManyFirearmErrorMessage(String howManyFirearmErrorMessage) {
		CommonValidations.verifyTextValue(howManyFirearmError, howManyFirearmErrorMessage);
	}

	public void firearmTypeErrorMessage(String firearmTypeErrorMessage) {
		CommonValidations.verifyTextValue(firearmTypeError, firearmTypeErrorMessage);
	}

	public void addFirearmsInformation(String typeOfFirearmsText, String HowManyFirearmsText, String FirearmTypeText)
			throws Exception {
		WebAction.scrollIntoView(firearmsInformationSection);
		try {
			addTypeOfFirearms(typeOfFirearmsText);
			addHowManyFirearms(HowManyFirearmsText);
			selectFirearmType(FirearmTypeText);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addTypeOfFirearms(String typeOfFirearmsText) throws Exception {
		if (typeOfFirearmsText != null) {
			Waits.waitForElement(firearmTypeInputBox, WAIT_CONDITIONS.CLICKABLE);
			WebAction.click(firearmTypeInputBox);
			WebAction.sendKeys(firearmTypeInputBox, typeOfFirearmsText);
			ReportGenerate.test.log(Status.INFO,
					"User enters " + typeOfFirearmsText + " as Type of Firearms in Firearms information section");
		}
	}

	public void addHowManyFirearms(String HowManyFirearmsText) throws Exception {
		// To select how many
		if (HowManyFirearmsText != null) {
			WebAction.clickUsingJs(firearmHowMany);
			WebAction.sendKeys(firearmHowMany, HowManyFirearmsText);
			ReportGenerate.test.log(Status.INFO,
					"User enters " + HowManyFirearmsText + " as How Many Firearms in Firearms information section");

		}
	}

	public void selectFirearmType(String FirearmTypeText) throws Exception {
		// To select firearm type
		if (FirearmTypeText != null) {
			if (FirearmTypeText.equalsIgnoreCase("Yes")) {
				WebAction.click(typeFirearms_Yes_Replica);
				ReportGenerate.test.log(Status.INFO,
						"User selects " + FirearmTypeText + " for Type in Firearms information section");
			} else {
				WebAction.click(typeFirearms_No_Functioning);
				ReportGenerate.test.log(Status.INFO, "User selects No for Type in Firearms information section");
			}
		}
	}

	public By getBy(String name) {
		if (name.equals("locationInputBy")) {
			return By.xpath("//*[text()=' Location ']/../following::*[1]//input");
		} else if (name.equals("locationSelectedOptionBy")) {
			return By.xpath("//*[text()=' Location ']/../following::*[1]//*[text()]");
		} else if (name.equals("setLocationInputBy")) {
			return By.xpath("//*[text()=' Set Location ']/../following::*[1]//input");
		} else if (name.equals("addressInputBy")) {
			return By.xpath("//*[text()=' Address ']/../following::*[1]//input");
		} else if (name.equals("typeOfFirearmInputsBy")) {
			return By.xpath("//*[text()=' Type of Firearm(s) ']/../following::*[1]//input");
		} else if (name.equals("howManyInputsBy")) {
			return By.xpath("//*[text()=' How Many ']/../following::*[1]//input");
		} else if (name.equals("dropdownOptionsBy")) {
			return By.xpath("//*[contains(@class,'ant-select-item') and text()]");
		} else if (name.equals("addFirearmButtonBy")) {
			return By.xpath("//*[text()=' Firearm ']/ancestor::button");
		} else if (name.equals("addLocationButtonBy")) {
			return By.xpath("//*[text()=' Location ']/ancestor::button");
		} else if (name.equals("sectionStatusIconsBy")) {
			return By.xpath("//*[@sectionTitle]//*[contains(@class,'button-section')]//i");
		} else if (name.equals("sectionNamesHavingStatusIconBy")) {
			return By.xpath("//*[@sectionTitle]//*[contains(@class,'button-section')]//i"
					+ "/ancestor::*[@class='button-section']/following::*[contains(@class,'status-title-area')]//p");
		} else if (name.equals("typeRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Type ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("howManyRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' How Many ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("typeOfFirearmRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Type of Firearm(s) ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("locationRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Location ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("setLocationRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Set Location ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("addressRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Address ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("airPlatformRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Air Platform ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("showUnitOrProjectNameRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Show Unit or Project Name ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("otherRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Other ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("arrivalDateRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Arrival Date ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("departureDateRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Departure Date ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("arrivalTimeRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Arrival Time ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("departureTimeRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Departure Time ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("divisionRequiredErrorBy")) {
			return By.xpath(
					"//*[text()=' Division ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (name.equals("divisionInputPlaceholderBy")) {
			return By.xpath("//*[text()=' Division ']/../following::*[1]//nz-select-placeholder");
		} else if (name.equals("airPlatformInputPlaceholderBy")) {
			return By.xpath("//*[text()=' Air Platform ']/../following::*[1]//nz-select-placeholder");
		} else if (name.equals("showUnitOrProjectNameInputPlaceholderBy")) {
			return By.xpath("//*[text()=' Show Unit or Project Name ']/../following::*[1]//nz-select-placeholder");
		} else if (name.equals("locationInputPlaceholderBy")) {
			return By.xpath("//*[text()=' Location ']/../following::*[1]//nz-select-placeholder");
		} else if (name.equals("setLocationInputPlaceholderBy")) {
			return By.xpath("//*[text()=' Set Location ']/../following::*[1]//nz-select-placeholder");
		}
		Assert.fail(String.format("Could not find the By locator for '%s'", name));
		return By.xpath("");
	}

	public void verifyFormSectionsInFirearmsOnPremisesForm() {
		Object[] expectedHeaders = { "STATUS", "GENERAL DETAILS", "REQUESTER(S)", "TALENT", "SHOW INFO", "SET LOCATION",
				"FIREARM(S) INFORMATION", "DETAILS" };
		if (expectedHeaders.length != formSectionTitles.size()) {
			Assert.assertEquals(formSectionTitles.size(), expectedHeaders.length,
					"Total number of sections " + "are not the same as expected on Firearms On Premises form");
		} else {
			boolean allFormSectionsArePresent = true;
			for (int itr = 0; itr < expectedHeaders.length; itr++) {
				String expectedName = (String) expectedHeaders[itr];
				String displayedName = WebAction.getText(formSectionTitles.get(itr));
				if (!expectedName.equals(displayedName)) {
					allFormSectionsArePresent = false;
					Assert.assertEquals(displayedName, expectedName,
							"Expected section name is not same as " + "displayed name on Firearms On Premises form");
				}
			}
			Assert.assertTrue(allFormSectionsArePresent,
					"All expected sections are not present on " + "Firearms On Premises form");
		}
	}

	public List<WebElement> getSectionLabelElements(String sectionName) {
		if (sectionName.equalsIgnoreCase("GENERAL DETAILS")) {
			return generalDetailsSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("REQUESTER(S)")) {
			return requestersSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("TALENT")) {
			return talentSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("SHOW INFO")) {
			return showInfoSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("SET LOCATION")) {
			return setLocationSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("DETAILS")) {
			return detailsSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("FIREARM(S) INFORMATION")) {
			return firearmsInformationSectionFieldLabels;
		}
		return null;
	}

	public List<String> getExpectedFieldsSectionWise(String sectionName) {
		List<String> fieldNamesList = new ArrayList<String>();
		if (sectionName.equalsIgnoreCase("GENERAL DETAILS")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Division")));
		}
		else if(sectionName.equalsIgnoreCase("REQUESTER(S)")) {
			fieldNamesList.addAll(Arrays.asList("Add Requester(s)"));
		}
		else if(sectionName.equalsIgnoreCase("TALENT")) {
			fieldNamesList.addAll(Arrays.asList("Talent"));
		} else if (sectionName.equalsIgnoreCase("SHOW INFO")) {
			fieldNamesList.add("Air Platform");
			fieldNamesList.add("Show Unit or Project Name");
			String showUnitOrProjectName = Constants.getShowUnitOrProjectName();
			if (showUnitOrProjectName != null && showUnitOrProjectName.equalsIgnoreCase("Other")) {
				fieldNamesList.add("Other");
			}
			String division = Constants.getDivision();
			if (division != null && division.equals("CNBC")) {
				fieldNamesList.add("Work Order #");
			}
			fieldNamesList.addAll(new ArrayList<String>(
					Arrays.asList("Arrival Date", "Arrival Time", "Departure Date", "Departure Time")));
		} else if (sectionName.equalsIgnoreCase("SET LOCATION")) {
			int size = numberOfLocations.get();
			for (int itr = 0; itr < size; ++itr) {
				fieldNamesList.add("Location");
				if (Constants.getLocation().size() > itr) {
					LocationRecord locationRecord = Constants.getLocation().get(itr);
					if (locationRecord != null && locationRecord.getLocation() != null
							&& locationRecord.getLocation().equalsIgnoreCase("Field")) {
						fieldNamesList.add("Address");
					} else {
						fieldNamesList.add("Set Location");
					}
				} else {
					fieldNamesList.add("Set Location");
				}
			}
		} else if (sectionName.equalsIgnoreCase("FIREARM(S) INFORMATION")) {
			int size = numberOfFirearms.get();
			for (int itr = 1; itr <= size; ++itr) {
				fieldNamesList.addAll(Arrays.asList("Firearm - " + itr, "Type of Firearm(s)", "How Many", "Type"));
			}
		} else if (sectionName.equalsIgnoreCase("DETAILS")) {
			fieldNamesList.addAll(Arrays.asList("Details and Notes"));
		}
		return fieldNamesList;
	}

	public List<String> getRequiredFieldsSectionWise(String sectionName) {
		List<String> fieldNamesList = new ArrayList<String>();
		if (sectionName.equalsIgnoreCase("GENERAL DETAILS")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Division")));
		} else if (sectionName.equalsIgnoreCase("REQUESTER(S)") || sectionName.equalsIgnoreCase("TALENT")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList()));
		} else if (sectionName.equalsIgnoreCase("SHOW INFO")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Air Platform", "Show Unit or Project Name",
					"Other", "Arrival Date", "Arrival Time", "Departure Date", "Departure Time")));
		} else if (sectionName.equalsIgnoreCase("SET LOCATION")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Location", "Set Location", "Address")));
		} else if (sectionName.equalsIgnoreCase("FIREARM(S) INFORMATION")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList("Type of Firearm(s)", "How Many", "Type")));
		} else if (sectionName.equalsIgnoreCase("DETAILS")) {
			fieldNamesList.addAll(new ArrayList<String>(Arrays.asList()));
		}
		return fieldNamesList;
	}

	public void checkFieldsInSectionOfFirearmsOnPremisesProduction(String sectionName) {
		List<WebElement> sectionLabelElements = getSectionLabelElements(sectionName);
		if (sectionLabelElements == null) {
			Assert.assertTrue(false, sectionName + " section is not present in Firearms on Premises production form");
			return;
		}

		List<String> expectedFieldNamesList = getExpectedFieldsSectionWise(sectionName);
		List<String> expectedRequiredFieldList = getRequiredFieldsSectionWise(sectionName);
		if (sectionLabelElements.size() != expectedFieldNamesList.size()) {
			Assert.assertEquals(sectionLabelElements.size(), expectedFieldNamesList.size(),
					"Number of displayed " + "fields and expected fields not equal in " + sectionName
							+ " section of Firearms on Premises " + "Production");
			return;
		}
		for (int itr = 0; itr < expectedFieldNamesList.size(); itr++) {
			String expectedName = expectedFieldNamesList.get(itr);
			String displayedField = WebAction.getText(sectionLabelElements.get(itr));
			Assert.assertEquals(displayedField, expectedName, "Displayed field is not same as expected field in "
					+ sectionName + " " + "section of Firearms on Premises Production");
			String cssClasses = WebAction.getAttribute(sectionLabelElements.get(itr), "class");
			if (cssClasses.contains(" ant-form-item-required") && !expectedRequiredFieldList.contains(displayedField)) {
				Assert.assertTrue(false, "'" + displayedField + "' is not a required field in " + sectionName
						+ " section but displayed " + "with *(required symbol)");
			} else if (!cssClasses.contains(" ant-form-item-required")
					&& expectedRequiredFieldList.contains(displayedField)) {
				Assert.assertTrue(false, "'" + displayedField + "' is a required field in " + sectionName
						+ " section but not displayed " + "with *(required symbol)");
			}
		}
	}

	public WebElement getInputElement(String fieldName, int position) {
		WebDriver driver = getCurrentDriver();
		if (fieldName.equals("Location")) {
			return driver.findElements(getBy("locationInputBy")).get(position);
		} else if (fieldName.equals("Set Location") || fieldName.equals("Address")) {
			int setLocationIndex = position, addressIndex = position;
			List<LocationRecord> list = Constants.getLocation();
			for (LocationRecord rec : list) {
				String location = rec.getLocation();
				if (location.equals("Field")) {
					--setLocationIndex;
				} else if (location.equals("Rock Center")) {
					--addressIndex;
				}
			}
			if (fieldName.equals("Address")) {
				return driver.findElements(getBy("addressInputBy")).get(addressIndex);
			} else if (fieldName.equals("Set Location")) {
				return driver.findElements(getBy("setLocationInputBy")).get(setLocationIndex);
			}
		} else if (fieldName.equals("Division")) {
			return divisionInput;
		} else if (fieldName.equals("Show Unit or Project Name")) {
			return showUnitOrProjectNameInput;
		} else if (fieldName.equals("Type of Firearm(s)")) {
			List<WebElement> elements = driver.findElements(getBy("typeOfFirearmInputsBy"));
			return elements.get(position);
		} else if (fieldName.equals("How Many")) {
			return driver.findElements(getBy("howManyInputsBy")).get(position);
		} else if (fieldName.equals("Details and Notes")) {
			return detailsAndNotesInput;
		} else if (fieldName.equals("Air Platform")) {
			return airPlatformInput;
		} else if (fieldName.equals("Show Unit or Project Name")) {
			return showUnitOrProjectNameInput;
		} else if (fieldName.equals("Arrival Date")) {
			return arrivalDateInput;
		} else if (fieldName.equals("Arrival Time")) {
			return arrivalTimeInput;
		} else if (fieldName.equals("Departure Date")) {
			return departureDateInput;
		} else if (fieldName.equals("Departure Time")) {
			return departureTimeInput;
		} else if (fieldName.equals("Work Order #")) {
			return workOrderInput;
		} else if (fieldName.equals("Other")) {
			return otherInput;
		}
		return null;
	}

	public void storeInConstants(String fieldName, Object option, Integer position) {
		if (fieldName.equals("Location") || fieldName.equals("Set Location") || fieldName.equals("Address")) {
			List<LocationRecord> locationRecords = Constants.getLocation();
			if (position == locationRecords.size()) {
				locationRecords.add(new LocationRecord());
			}
			if (fieldName.equals("Location")) {
				locationRecords.get(position).setLocation((String) option);
			} else if (fieldName.equals("Set Location")) {
				locationRecords.get(position).setSetLocation((String) option);
			} else if (fieldName.equals("Address")) {
				locationRecords.get(position).setAddress((String) option);
			}
		} else if (fieldName.equals("Division")) {
			Constants.setDivision((String) option);
		} else if (fieldName.equals("Details and Notes")) {
			Constants.setDetailsAndNotes((String) option);
		} else if (fieldName.equals("Show Unit or Project Name")) {
			Constants.setShowUnitOrProjectName((String) option);
		} else if (fieldName.equals("Air Platform")) {
			Constants.setAirPlatform((String) option);
		} else if (fieldName.equals("Arrival Date")) {
			Constants.setArrivalDate((String) option);
		} else if (fieldName.equals("Arrival Time")) {
			Constants.setArrivalTime((String) option);
		} else if (fieldName.equals("Departure Time")) {
			Constants.setDepartureTime((String) option);
		} else if (fieldName.equals("Departure Date")) {
			Constants.setDepartureDate((String) option);
		} else if (fieldName.equals("Work Order #")) {
			Constants.setWorkOrder((String) option);
		} else if (fieldName.equals("Other")) {
			Constants.setOtherInShowInfo((String) option);
		} else if (fieldName.equals("Type of Firearm(s)") || fieldName.equals("How Many") || fieldName.equals("Type")) {
			List<FirearmRecord> firearmsList = Constants.getFirearms();
			if (position == firearmsList.size()) {
				firearmsList.add(new FirearmRecord());
			}
			if (fieldName.equals("Type of Firearm(s)")) {
				firearmsList.get(position).setTypeOfFirearms((String) option);
			} else if (fieldName.equals("How Many")) {
				firearmsList.get(position).setHowMany((Integer) option);
			} else if (fieldName.equals("Type")) {
				firearmsList.get(position).setType((String) option);
			}
		}
	}

	public void selectValueInDropdown(String option, String fieldName, String pos) {
		Integer position = parsePosition(pos);
		try {
			WebDriver driver = getCurrentDriver();
			WebElement input = getInputElement(fieldName, position);
			waitForElement(input, WAIT_CONDITIONS.VISIBLE);
			WebAction.scrollIntoView(input);
			input.sendKeys(option);
			By dropdownOptionsBy = getBy("dropdownOptionsBy");
			waitForElement(dropdownOptionsBy, WAIT_CONDITIONS.VISIBLE);
			List<WebElement> options = driver.findElements(dropdownOptionsBy);
			Optional<WebElement> optional = options.stream()
					.filter((WebElement divisionOption) -> getText(divisionOption).equals(option)).findAny();
			if (optional.isPresent()) {
				WebElement optionToSelect = optional.get();
				WebAction.scrollIntoView(optionToSelect);
				WebAction.click(optionToSelect);
				storeInConstants(fieldName, option, position);
			} else {
				Assert.assertTrue(false, "'" + option + "' is not present as an option in '" + fieldName
						+ "' on Firearms on Premises production form");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error while selecting '" + option + "' in '" + fieldName + "' on CNBC Production form");
		}
	}

	public void fillTextbox(String field, String text, String pos) throws Exception {
		Integer position = parsePosition(pos);
		WebElement element = getInputElement(field, position);
		WebAction.scrollIntoView(element);
		WebAction.clear(element);
		element.sendKeys(text);
		WebAction.blur(element);
		storeInConstants(field, text, position);
		checkPlaceholderForInputsHavingPlaceholderAttribute(field, position);
	}

	public void checkPlaceholderForInputsHavingPlaceholderAttribute(String field, Integer position) {
		// verify the placeholder of the inputs or textarea that has placeholder
		// attribute
		WebElement element = getInputElement(field, position);
		String displayed = WebAction.getAttribute(element, "placeholder");
		String expected = getExpectedPlaceholder(field);
		Assert.assertEquals(displayed.trim(), expected, "Placeholder for '" + field + "' textarea is not correct");
	}

	public String getExpectedPlaceholder(String field) {
		if (field.equals("Division")) {
			return "Select Division";
		} else if (field.equals("Location")) {
			return "Select Location";
		} else if (field.equals("Air Platform")) {
			return "Select Air Platform";
		} else if (field.equals("Show Unit or Project Name")) {
			return "Show or Project Name";
		} else if (field.equals("Details and Notes")) {
			return "Type additional details here...";
		} else if (field.equals("Type of Firearm(s)")) {
			return "Type of Firearm(s)";
		} else if (field.equals("Address")) {
			return "Enter address here";
		} else if (field.equals("Arrival Date")) {
			return "Select Date";
		} else if (field.equals("Departure Date")) {
			return "Select Date";
		} else if (field.equals("Arrival Time")) {
			return "Select Time";
		} else if (field.equals("Departure Time")) {
			return "Select Time";
		} else if (field.equals("Work Order #")) {
			return "Enter work order here";
		} else if (field.equals("Other")) {
			return "Enter Show or Project title";
		} else if (field.equals("Set Location")) {
			return "Select Set Location";
		}
		return "";
	}

	public Integer getExpectedNumberOfOptions(String field) {
		if (field.equals("Type")) {
			return 2;
		}
		return 0;
	}

	public void selectRadioOption(String field, String option, String pos) throws Exception {
		Integer position = parsePosition(pos);
		Boolean optionSelected = false;
		List<WebElement> radioLabels = getRadioLabelElements(field);
		Integer numberOfOptions = getExpectedNumberOfOptions(field);
		int start = numberOfOptions * position;
		int end = numberOfOptions * (position + 1);
		for (int itr = start; itr < end; ++itr) {
			WebElement optionNameElement = radioLabels.get(itr);
			String val = WebAction.getText(optionNameElement);
			if (val.equals(option)) {
				WebAction.scrollIntoView(optionNameElement);
				int trials = 3;
				while (trials-- > 0) {
					try {
						optionNameElement.click();
						break;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				optionSelected = true;
				storeInConstants(field, option, position);
			}
		}
		if (!optionSelected) {
			Assert.assertTrue(optionSelected,
					"Option '" + option + "' is not displayed for '" + field + "' indexed " + position);
		}
	}

	public List<WebElement> getRadioLabelElements(String field) {
		if (field.equals("Type")) {
			return typeRadioLabels;
		}
		return new ArrayList<WebElement>();
	}

	public void addFirearm(int times) {
		WebDriver driver = DriverFactory.getCurrentDriver();
		WebElement addButton = driver.findElement(getBy("addFirearmButtonBy"));
		while (times-- > 0) {
			WebAction.scrollIntoView(addButton);
			addButton.click();
			numberOfFirearms.set(numberOfFirearms.get() + 1);
		}
	}

	public void addLocation(int times) {
		WebDriver driver = DriverFactory.getCurrentDriver();
		WebElement addButton = driver.findElement(getBy("addLocationButtonBy"));
		while (times-- > 0) {
			WebAction.scrollIntoView(addButton);
			addButton.click();
			numberOfLocations.set(numberOfLocations.get() + 1);
		}
	}

	public void selectQuantity(String fieldName, Integer option, String pos) {
		Integer position = parsePosition(pos);
		try {
			WebElement input = getInputElement(fieldName, position);
			waitForElement(input, WAIT_CONDITIONS.VISIBLE);
			WebAction.scrollIntoView(input);
			WebAction.sendKeys(input, Integer.toString(option));
			storeInConstants(fieldName, option, position);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error while selecting '" + option + "' in '" + fieldName + "' on CNBC Production form");
		}
	}

	public void verifyErrorBelowFieldIfEmpty(String fieldName) {
		List<WebElement> elements = getErrorElementForField(fieldName);
		Assert.assertFalse(elements.size() == 0,
				String.format("Error text for '%s' required field is not present", fieldName));
		WebElement element = elements.get(0);
		WebAction.scrollIntoView(element);
		String displayed = getText(element);
		String expected = getExpectedErrorMessageForRequiredField(fieldName);
		Assert.assertEquals(displayed, expected,
				String.format("Error text for '%s' required field is not correct", fieldName));
	}

	public void verifyErrorBelowFieldIfNotEmpty(String fieldName) {
		List<WebElement> elements = getErrorElementForField(fieldName);
		Assert.assertTrue(elements.size() == 0,
				String.format("Error text for '%s' required field should not display", fieldName));
	}

	public String getExpectedErrorMessageForRequiredField(String field) {
		if (field.equals("Division")) {
			return "Select a value";
		} else if (field.equals("Location")) {
			return "Select a value";
		} else if (field.equals("Air Platform")) {
			return "Please select an Air Platform";
		} else if (field.equals("Show Unit or Project Name")) {
			return "Select a value";
		} else if (field.equals("Arrival Date")) {
			return "Please select a Arrival date";
		} else if (field.equals("Arrival Time")) {
			return "Please select a Arrival time";
		} else if (field.equals("Departure Date")) {
			return "Please select a Departure date";
		} else if (field.equals("Departure Time")) {
			return "Please select a Departure time";
		} else if (field.equals("Type of Firearm(s)")) {
			return "Enter a value";
		} else if (field.equals("Type")) {
			return "Please enter this field";
		} else if (field.equals("How Many")) {
			return "Please enter how many";
		} else if (field.equals("Set Location")) {
			return "Select a value";
		} else if (field.equals("Address")) {
			return "Enter a value";
		} else if (field.equals("Other")) {
			return "Please enter Show or Project title";
		}
		return "";
	}

	public List<WebElement> getErrorElementForField(String field) {
		WebDriver driver = getCurrentDriver();
		if (field.equals("Division")) {
			return driver.findElements(getBy("divisionRequiredErrorBy"));
		} else if (field.equals("Location")) {
			return driver.findElements(getBy("locationRequiredErrorBy"));
		} else if (field.equals("Set Location")) {
			return driver.findElements(getBy("setLocationRequiredErrorBy"));
		} else if (field.equals("Air Platform")) {
			return driver.findElements(getBy("airPlatformRequiredErrorBy"));
		} else if (field.equals("Show Unit or Project Name")) {
			return driver.findElements(getBy("showUnitOrProjectNameRequiredErrorBy"));
		} else if (field.equals("Arrival Date")) {
			return driver.findElements(getBy("arrivalDateRequiredErrorBy"));
		} else if (field.equals("Arrival Time")) {
			return driver.findElements(getBy("arrivalTimeRequiredErrorBy"));
		} else if (field.equals("Departure Date")) {
			return driver.findElements(getBy("departureDateRequiredErrorBy"));
		} else if (field.equals("Departure Time")) {
			return driver.findElements(getBy("departureTimeRequiredErrorBy"));
		} else if (field.equals("Type of Firearm(s)")) {
			return driver.findElements(getBy("typeOfFirearmRequiredErrorBy"));
		} else if (field.equals("Type")) {
			return driver.findElements(getBy("typeRequiredErrorBy"));
		} else if (field.equals("How Many")) {
			return driver.findElements(getBy("howManyRequiredErrorBy"));
		} else if (field.equals("Other")) {
			return driver.findElements(getBy("otherRequiredErrorBy"));
		} else if (field.equals("Address")) {
			return driver.findElements(getBy("addressRequiredErrorBy"));
		}
		return new ArrayList<WebElement>();
	}

	public void checkPlaceholderOfSelectFields(String fieldName) {
		List<WebElement> placeholderElement = getPlaceholderElementForField(fieldName);
		String requestForValue = Constants.getRequestFor();
		if (requestForValue == null) {
			if (placeholderElement.size() == 0) {
				Assert.assertEquals(placeholderElement.size(), 1,
						"Placeholder for '" + fieldName + "' field is not present");
			}
			if (placeholderElement.size() > 1) {
				Assert.assertEquals(placeholderElement.size(), 1,
						"More than 1 placeholder for '" + fieldName + "' field is present");
			} else {
				String displayed = WebAction.getText(placeholderElement.get(0));
				String expected = getExpectedPlaceholder(fieldName);
				Assert.assertEquals(displayed, expected, "Placeholder for '" + fieldName + "' field is not correct");
			}
		} else {
			if (placeholderElement.size() > 0) {
				Assert.assertEquals(placeholderElement.size(), 0,
						"Placeholder for '" + fieldName + "' field should not " + "display if value is selected");
			}
		}
	}

	public List<WebElement> getPlaceholderElementForField(String field) {
		WebDriver driver = getCurrentDriver();
		if (field.equals("Division")) {
			return driver.findElements(getBy("divisionInputPlaceholderBy"));
		} else if (field.equals("Air Platform")) {
			return driver.findElements(getBy("airPlatformInputPlaceholderBy"));
		} else if (field.equals("Location")) {
			return driver.findElements(getBy("locationInputPlaceholderBy"));
		} else if (field.equals("Set Location")) {
			return driver.findElements(getBy("setLocationInputPlaceholderBy"));
		} else if (field.equals("Show Unit or Project Name")) {
			return driver.findElements(getBy("showUnitOrProjectNameInputPlaceholderBy"));
		}
		return new ArrayList<WebElement>();
	}

	public void clearTextareaInput(String field, Integer position) {
		WebElement element = getInputElement(field, position);
		WebAction.scrollIntoView(element);
		WebAction.clearInputOneCharAtTime(element);
		storeInConstants(field, "", position);
	}

	public void verifyTheFormSectionsInFirearmsOnPremisesProductionForm() {
		Object[] expectedHeaders = { "STATUS", "GENERAL DETAILS", "REQUESTER(S)", "TALENT", "SHOW INFO", "SET LOCATION",
				"FIREARM(S) INFORMATION", "DETAILS" };
		if (expectedHeaders.length != formSectionTitles.size()) {
			Assert.assertEquals(formSectionTitles.size(), expectedHeaders.length,
					"Total number of sections are not the same as expected");
		} else {
			boolean allFormSectionsArePresent = true;
			for (int itr = 0; itr < expectedHeaders.length; itr++) {
				String expectedName = (String) expectedHeaders[itr];
				String displayedName = WebAction.getText(formSectionTitles.get(itr));
				if (!expectedName.equals(displayedName)) {
					allFormSectionsArePresent = false;
					Assert.assertEquals(displayedName, expectedName,
							"Expected section name is not same as displayed name");
				}
			}
			Assert.assertTrue(allFormSectionsArePresent,
					"All expected sections are not present on Firearms on Premises Production form");
		}
	}

	public Integer parsePosition(String position) {
		Integer index = 0;
		try {
			if (position != null) {
				index = Integer.parseInt(position) - 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return index;
	}

	public void selectDate(String field, String option, String pos) throws Exception {
		if (option.contains("currentDate+")) {
			String offset = option.substring(option.indexOf("+") + 1);
			int offsetInt = 0;
			try {
				if (offset != null) {
					offsetInt = Integer.parseInt(offset);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			LocalDate date = LocalDate.now().plusDays(offsetInt);
			String text = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			fillTextbox(field, text, pos);
		} else {
			Assert.fail("Unable to set the field " + field + " with value " + option);
		}
	}

	public void verifyThatInputIsReadOnlyOrDisabled(String field) {
		WebElement input = getInputElement(field, 0);
		Boolean isReadOnly = input.getAttribute("readonly") != null || input.getAttribute("disabled") != null ? true
				: false;
		Assert.assertTrue(isReadOnly, String.format("input of field %s is not readonly and can be edited", field));
	}

	public void verifyThatInputIsReadOnlyOrDisabled(String field, WebElement element) {
		Boolean isReadOnly = element.getAttribute("readonly") != null || element.getAttribute("disabled") != null ? true
				: false;
		Assert.assertTrue(isReadOnly, String.format("input of field %s is not readonly and can be edited", field));
	}

	public String getFromStore(String field, int position) {
		String storedValue = "";
		switch (field) {
		case "Air Platform":
			storedValue = Constants.getAirPlatform();
			break;
		case "Show Unit or Project Name":
			storedValue = Constants.getShowUnitOrProjectName();
			break;
		case "Other":
			storedValue = Constants.getOtherInShowInfo();
			break;
		case "Work Order #":
			storedValue = Constants.getWorkOrder();
			break;
		case "Arrival Date":
			storedValue = Constants.getArrivalDate();
			break;
		case "Arrival Time":
			storedValue = Constants.getArrivalTime();
			break;
		case "Departure Date":
			storedValue = Constants.getDepartureDate();
			break;
		case "Departure Time":
			storedValue = Constants.getDepartureTime();
			break;
		case "Division":
			storedValue = Constants.getDivision();
			break;
		}
		return storedValue;
	}

	public void verifyInputInShowInfoSectionInReadOnlyForm(String field) {
		verifyThatInputIsReadOnlyOrDisabled(field);
		String expected = getFromStore(field, 0);
		WebElement element = getInputElement(field, 0);
		String displayed = element.getAttribute("value");
		Assert.assertEquals(displayed, expected,
				String.format("value displayed in read only form for %s not same as input provided earlier", field));
	}

	public void verifyInputsInSetLocationSectionInReadOnlyForm() {
		List<LocationRecord> locations = Constants.getLocation();
		// number of location labels
		int countOfLocationLabels = labelsInSetLocationSectionInReadOnlyForm.size() / 2;
		Assert.assertEquals(countOfLocationLabels, locations.size(),
				"Count of location labels is not correct under Set Location section");
		// in each set location record there will at most two fields having values :
		// location and (Set Location or Address) depending on location value
		SoftAssert softAssert = new SoftAssert();
		for (int recordIndex = 0; recordIndex < countOfLocationLabels; ++recordIndex) {
			int pos1 = 2 * recordIndex;
			int pos2 = 2 * recordIndex + 1;
			String displayedLabel1 = getText(labelsInSetLocationSectionInReadOnlyForm.get(pos1));
			String expectedLabel1 = "Location";
			softAssert.assertEquals(displayedLabel1, expectedLabel1, "Label name is incorrect in Set Location section");
			String displayedLabel2 = getText(labelsInSetLocationSectionInReadOnlyForm.get(pos2));
			String expectedLabel2 = locations.get(recordIndex).getLocation().equals("Rock Center") ? "Set Location"
					: "Address";
			softAssert.assertEquals(displayedLabel2, expectedLabel2, "Label name is incorrect in Set Location section");
			WebElement input1 = inputsInSetLocationSectionInReadOnlyForm.get(pos1);
			WebElement input2 = inputsInSetLocationSectionInReadOnlyForm.get(pos2);
			// check inputs are readonly or disabled
			verifyThatInputIsReadOnlyOrDisabled(displayedLabel1, input1);
			verifyThatInputIsReadOnlyOrDisabled(expectedLabel2, input2);
			// check value of location input
			String displayedValue1 = input1.getAttribute("value");
			String expectedValue1 = locations.get(recordIndex).getLocation();
			softAssert.assertEquals(displayedValue1, expectedValue1, String.format(
					"value displayed in read only form for %s not same as input provided earlier at position %d",
					expectedLabel1, pos1));
			// if Location='Rock Center', check value of Set Location, else check value of
			// Address
			String displayedValue2 = input2.getAttribute("value");
			String expectedValue2 = expectedLabel2.equals("Set Location") ? locations.get(recordIndex).getSetLocation()
					: locations.get(recordIndex).getAddress();
			softAssert.assertEquals(displayedValue2, expectedValue2, String.format(
					"value displayed in read only form for %s not same as input provided earlier at position %d",
					expectedLabel2, pos2));
		}
		softAssert.assertAll();
	}

	public void expandOrCollapseFirearmsTab(WebElement tabButton) {
		WebAction.scrollIntoView(tabButton);
		// expands or collapses on clicking
		tabButton.click();
	}

	public void verifyFirearmsInformationSectionInReadOnlyMode() {
		List<FirearmRecord> firearms = Constants.getFirearms();
		int countOfTabs = tabButtonsInFirearmsInformationInReadOnlyForm.size();
		Assert.assertEquals(countOfTabs, firearms.size(),
				"Count of expansion tabs displayed in Firearm(s) Information section is not correct");
		SoftAssert softAssert = new SoftAssert();
		for (int tabIndex = 0; tabIndex < countOfTabs; ++tabIndex) {
			WebElement tabButton = tabButtonsInFirearmsInformationInReadOnlyForm.get(tabIndex);
			expandOrCollapseFirearmsTab(tabButton);
			String expectedTypeOfFirearms = firearms.get(tabIndex).getTypeOfFirearms();
			String displayedTypeOfFirearms = getText(tabButton);
			softAssert.assertEquals(displayedTypeOfFirearms, expectedTypeOfFirearms,
					"Type of Firearms value is not correct in Firearm(s) Information");
			// check labels
			Assert.assertEquals(getText(labelsInFirearmsInformationInReadOnlyForm.get(0)), "Amount",
					"Label is not correct in the Firearms(s) Information");
			Assert.assertEquals(getText(labelsInFirearmsInformationInReadOnlyForm.get(1)), "Type",
					"Label is not correct in the Firearms(s) Information");
			// checks amount
			int expectedAmount = firearms.get(tabIndex).getHowMany();
			int displayedAmount = Integer
					.parseInt(inputsInFirearmsInformationInReadOnlyForm.get(0).getAttribute("value"));
			softAssert.assertEquals(displayedAmount, expectedAmount,
					String.format("Amount value is not correct in Firearm(s) Information at position %d", 0));
			// checks type
			String expectedType = firearms.get(tabIndex).getType();
			String displayedType = inputsInFirearmsInformationInReadOnlyForm.get(1).getAttribute("value");
			softAssert.assertEquals(displayedType, expectedType,
					String.format("Type value is not correct in Firearm(s) Information at position %d", 1));
			expandOrCollapseFirearmsTab(tabButton);
		}
		softAssert.assertAll();
	}

	public void verifyInputsInDetailsSectionInReadOnlyForm() {
		Assert.assertEquals(getText(detailsAndNotesLabel), "Details and Notes",
				"Label for Details and Notes field is not correct");
		String expected = Constants.getDetailsAndNotes();
		String displayed = getText(detailsAndNotesValue);
		Assert.assertEquals(displayed, expected, "Value for Details and Notes field is not correct");
	}

	public void verifyDivisionInGeneralDetailsSectionInReadOnlyForm() {
		String expected = getFromStore("Division", 0);
		String displayed = getText(divisionValue);
		Assert.assertEquals(displayed, expected, String
				.format("value displayed in read only form for %s not same as input provided earlier", "Division"));
	}
}