
package nbcu.automation.ui.pages.ncxUnifiedTool;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;
import nbcu.automation.ui.pojos.ncxUnifiedTool.AnimalRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.HandlerRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.LocationRecord;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.factory.DriverFactory;
import nbcu.framework.utils.Other.DateFunctions;
import nbcu.framework.utils.report.ReportGenerate;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;
import nbcu.framework.utils.ui.WebAction;
import static nbcu.framework.utils.ui.WebAction.scrollIntoView;
import static nbcu.framework.utils.ui.WebAction.getText;
import static nbcu.framework.utils.ui.WebAction.click;
import static nbcu.framework.factory.DriverFactory.getCurrentDriver;
import static nbcu.framework.utils.ui.Waits.waitForElement;

public class ProdAnimalOnPremisesRequestFormPage {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	public ProducerDashboardGeneralPage getProducerDashboardGeneralPage() {
		return producerDashboardGeneralPage;
	}

	private ThreadLocal<Integer> numberOfAnimals = new ThreadLocal<Integer>() {
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
	private ThreadLocal<Integer> numberOfHandlers = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 1;
		}
	};

	@FindBy(xpath = "//div[contains(text(),'Ultimatte')]/ancestor::div[1]//input")
	WebElement ultimatteInputbox;

	@FindBy(xpath = "//div[contains(text(),'Voice Activated Prompter')]/ancestor::div[1]//input")
	WebElement vapInputbox;

	@FindBy(xpath = "//*[@forminputname='isStagingNeeded']//label[@label-value='false']")
	WebElement isStagingNeeded_No;

	@FindBy(xpath = "//*[@forminputname='isStagingNeeded']//label[@label-value='true']")
	WebElement isStagingNeeded_Yes;

	@FindBy(xpath = "//*[@forminputname='isCarpentryNeeded']//label[@label-value='true']")
	WebElement isCarpentryNeeded_Yes;

	@FindBy(xpath = "//*[@forminputname='isCarpentryNeeded']//label[@label-value='false']")
	WebElement isCarpentryNeeded_No;

	@FindBy(xpath = "//*[@forminputname='isLightingNeeded']//label[@label-value='true']")
	WebElement isLightingNeeded_Yes;

	@FindBy(xpath = "//*[@forminputname='isLightingNeeded']//label[@label-value='false']")
	WebElement isLightingNeeded_No;

	@FindBy(xpath = "//*[@forminputname='isPropsNeeded']//label[@label-value='true']")
	WebElement isPropsNeeded_Yes;

	@FindBy(xpath = "//*[@forminputname='isPropsNeeded']//label[@label-value='false']")
	WebElement isPropsNeeded_No;

	String dropDownvaluesXpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item";

	@FindBy(xpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item | //nz-option-item ")
	List<WebElement> dropDownvalues;

	@FindBy(xpath = "//*[@label='Additional Crew']//nz-select")
	WebElement additionalCrew;

	@FindBy(xpath = "//*[@forminputname='tpmOrTm']//label[@label-value='Yes']")
	WebElement tpmOrTm_Yes;

	@FindBy(xpath = "//*[@forminputname='tpmOrTm']//label[@label-value='No']")
	WebElement tpmOrTm_No;

	@FindBy(xpath = "//*[contains(text(),'Same as requester')]")
	WebElement sameAsRequesterCheckBox;

	@FindBy(xpath = "//*[@forminputname='tpmTmName']//input")
	WebElement tpmTmName;

	@FindBy(xpath = "//p[contains(text(),'HANDLER(S) INFORMATION')]")
	WebElement handlersInformationSection;

	@FindBy(xpath = "//p[contains(text(),'ANIMAL(S) INFORMATION')]")
	WebElement animalsInformationSection;

	@FindBy(xpath = "//*[contains(@placeholder,'Handler’s Name')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement handlersNameError;

	@FindBy(xpath = "//*[contains(@placeholder,'Handler’s Email')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement handlersEmailError;

	@FindBy(xpath = "//*[contains(@label,'Phone')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement handlersPhoneError;

	@FindBy(xpath = "//*[contains(@placeholder,'Type of Animal')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement typeOfAnimalError;

	@FindBy(xpath = "//*[contains(@label,'Weight')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement animalWeightError;

	@FindBy(xpath = "//*[contains(text(),'How Many')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement howManyError;

	@FindBy(xpath = "//*[contains(@nzplaceholder,'Select Handler')]/ancestor::div[3]//div[contains(@class,'error')]")
	WebElement handlersError;

	@FindBy(xpath = "//*[contains(@placeholder,'Handler’s Name')]//input")
	WebElement handlersNameInput;

	@FindBy(xpath = "//*[contains(@label,'Email Address')]//input")
	WebElement handlersEmailInput;

	@FindBy(xpath = "//*[contains(@label,'Phone')]//input")
	WebElement handlersPhoneInput;

	@FindBy(xpath = "//*[contains(@label,'Type of Animal')]//input")
	WebElement animalType;

	@FindBy(xpath = "//*[contains(@label,'Weight')]//input")
	WebElement animalWeight;

	@FindBy(xpath = "//*[contains(text(),'How Many')]/ancestor::div[1]//input")
	WebElement animalNos;

	@FindBy(xpath = "//*[@nzplaceholder='Select Handler']//input")
	WebElement animalHandler;

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

	@FindBy(xpath = "//*[@sectiontitle='Details']//nz-form-label//label")
	List<WebElement> detailsSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Animal(s) Information']//nz-form-label//label")
	List<WebElement> animalsInformationSectionFieldLabels;

	@FindBy(xpath = "//*[@sectiontitle='Handler(s) Information']//nz-form-label//label")
	List<WebElement> handlersInformationSectionFieldLabels;

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

	@FindBy(xpath = "//*[@sectionTitle]//*[contains(@class,'status-title-area')]//p[contains(@class,'left-hand-title')]")
	List<WebElement> formSectionTitles;

	public ProdAnimalOnPremisesRequestFormPage() {
		PageFactory.initElements(DriverFactory.getCurrentDriver(), this);
	}

	/**
	 * To verify handlers info section missing field error message
	 *
	 * @throws Exception
	 */
	public void verifyHandlersInfoMissingFieldError(String handlersNameErrorMessage, String handlersEmailErrorMessage,
			String handlersPhoneErrorMessage) throws Exception {
		WebAction.scrollIntoView(handlersInformationSection);
		try {
			handlersNameErrorMessage(handlersNameErrorMessage);
			handlersEmailErrorMessage(handlersEmailErrorMessage);
			handlersPhoneErrorMessage(handlersPhoneErrorMessage);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void handlersNameErrorMessage(String handlersNameErrorMessage) {
		CommonValidations.verifyTextValue(handlersNameError, handlersNameErrorMessage);
	}

	public void handlersEmailErrorMessage(String handlersEmailErrorMessage) {
		CommonValidations.verifyTextValue(handlersEmailError, handlersEmailErrorMessage);
	}

	public void handlersPhoneErrorMessage(String handlersPhoneErrorMessage) {
		CommonValidations.verifyTextValue(handlersPhoneError, handlersPhoneErrorMessage);
	}

	/**
	 * To verify animals info section missing field error message
	 *
	 * @throws Exception
	 */
	public void verifyAnimalsInfoMissingFieldError(String animalTypeErrorMessage, String animalWeightErrorMessage,
			String animalHowManyErrorMessage, String animalHandlerErrorMessage) throws Exception {
		WebAction.scrollIntoView(animalsInformationSection);
		try {
			animalTypeErrorMessage(animalTypeErrorMessage);
			animalWeightErrorMessage(animalWeightErrorMessage);
			animalHowManyErrorMessage(animalHowManyErrorMessage);
			animalHandlerErrorMessage(animalHandlerErrorMessage);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void animalTypeErrorMessage(String animalTypeErrorMessage) {
		CommonValidations.verifyTextValue(typeOfAnimalError, animalTypeErrorMessage);
	}

	public void animalWeightErrorMessage(String animalWeightErrorMessage) {
		CommonValidations.verifyTextValue(animalWeightError, animalWeightErrorMessage);
	}

	public void animalHowManyErrorMessage(String animalHowManyErrorMessage) {
		CommonValidations.verifyTextValue(howManyError, animalHowManyErrorMessage);
	}

	public void animalHandlerErrorMessage(String animalHandlerErrorMessage) {
		CommonValidations.verifyTextValue(handlersError, animalHandlerErrorMessage);
	}

	public void addHandlersInformation(String handlerNameText, String handlerEmailText, String handlerPhoneText)
			throws Exception {
		WebAction.scrollIntoView(animalsInformationSection);
		try {
			addHandlerName(handlerNameText);
			addHandlerEmail(handlerEmailText);
			addHandlerPhone(handlerPhoneText);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addHandlerName(String handlerNameText) throws Exception {
		if (handlerNameText != null) {
			Waits.waitForElement(handlersNameInput, WAIT_CONDITIONS.CLICKABLE);
			WebAction.click(handlersNameInput);
			WebAction.sendKeys(handlersNameInput, handlerNameText);
			ReportGenerate.test.log(Status.INFO,
					"User enters " + handlerNameText + " as Handler Name in Handlers information section");
		}
	}

	public void addHandlerEmail(String handlerEmailText) throws Exception {
		if (handlerEmailText != null) {
			Waits.waitForElement(handlersEmailInput, WAIT_CONDITIONS.CLICKABLE);
			WebAction.click(handlersEmailInput);
			WebAction.sendKeys(handlersEmailInput, handlerEmailText);
			ReportGenerate.test.log(Status.INFO,
					"User enters " + handlerEmailText + " as Handler Email in Handlers information section");
		}
	}

	public void addHandlerPhone(String handlerPhoneText) throws Exception {
		if (handlerPhoneText != null) {
			Waits.waitForElement(handlersPhoneInput, WAIT_CONDITIONS.CLICKABLE);
			WebAction.click(handlersPhoneInput);
			WebAction.sendKeys(handlersPhoneInput, handlerPhoneText);
			ReportGenerate.test.log(Status.INFO,
					"User enters " + handlerPhoneText + " as Handler Phone Number in Handlers information section");
		}
	}

	public void addAnimalsInformation(String animalTypeText, String animalWeightText, String animalHowManyText,
			String animalHandlerText) throws Exception {
		WebAction.scrollIntoView(animalsInformationSection);
		try {
			addAnimalType(animalTypeText);
			addAnimalWeight(animalWeightText);
			addAnimalHowMany(animalHowManyText);
			addAnimalHandler(animalHandlerText);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addAnimalType(String animalTypeText) throws Exception {
		if (animalTypeText != null) {
			Waits.waitForElement(animalType, WAIT_CONDITIONS.CLICKABLE);
			WebAction.click(animalType);
			WebAction.sendKeys(animalType, animalTypeText);
			ReportGenerate.test.log(Status.INFO,
					"User enters " + animalTypeText + " as Type of Animal in Animal information section");
		}
	}

	public void addAnimalWeight(String animalWeightText) throws Exception {
		// To select weight
		if (animalWeightText != null) {
			boolean valuePresent = false;
			WebAction.clickUsingJs(animalWeight);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (WebElement ele : dropDownvalues) {
				if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(animalWeightText)) {
					WebAction.click(ele);
					ReportGenerate.test.log(Status.INFO,
							"User selects " + animalWeightText + " as weight of Animal in Animal information section");
					valuePresent = true;
					break;
				}
			}
			if (valuePresent == false)
				throw new Exception("'" + animalWeightText + "' value is not present in the weight drop down");
		}
	}

	public void addAnimalHowMany(String animalHowManyText) throws Exception {
		// To select how many
		if (animalHowManyText != null) {
			WebAction.clickUsingJs(animalNos);
			WebAction.sendKeys(animalNos, animalHowManyText);
			ReportGenerate.test.log(Status.INFO,
					"User enters " + animalHowManyText + " as How Many Animals in Animal information section");

		}
	}

	public void addAnimalHandler(String animalHandlerText) throws Exception {
		// To select handler
		if (animalHandlerText != null) {
			boolean valuePresent = false;
			WebAction.clickUsingJs(animalHandler);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (WebElement ele : dropDownvalues) {
				if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(animalHandlerText)) {
					WebAction.click(ele);
					ReportGenerate.test.log(Status.INFO,
							"User selects " + animalHandlerText + " as Handler in Animal information section");
					valuePresent = true;
					break;
				}
			}
			if (valuePresent == false)
				throw new Exception("'" + animalHandlerText + "' value is not present in the handler drop down");
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
		} else if (sectionName.equalsIgnoreCase("ANIMAL(S) INFORMATION")) {
			return animalsInformationSectionFieldLabels;
		} else if (sectionName.equalsIgnoreCase("HANDLER(S) INFORMATION")) {
			return handlersInformationSectionFieldLabels;
		}
		return null;
	}

	public List<String> getExpectedFieldsSectionWise(String sectionName) {
		List<String> fieldNamesList = new ArrayList<String>();
		if (sectionName.equalsIgnoreCase("GENERAL DETAILS")) {
			fieldNamesList.addAll(Arrays.asList("Division"));
		} else if (sectionName.equalsIgnoreCase("REQUESTER(S)")) {
			fieldNamesList.addAll(Arrays.asList("Add Requester(s)"));
		} else if (sectionName.equalsIgnoreCase("TALENT")) {
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
			fieldNamesList.addAll(Arrays.asList("Arrival Date", "Arrival Time", "Departure Date", "Departure Time"));
		} else if (sectionName.equalsIgnoreCase("SET LOCATION")) {
			int size = numberOfLocations.get();
			for (int itr = 0; itr < size; ++itr) {
				fieldNamesList.add("Location");
				fieldNamesList.add("Set Location");
			}
		} else if (sectionName.equalsIgnoreCase("HANDLER(S) INFORMATION")) {
			int size = numberOfHandlers.get();
			for (int itr = 1; itr <= size; ++itr) {
				fieldNamesList.addAll(Arrays.asList("Handler - " + itr, "Name", "Email Address", "Phone"));
			}
		} else if (sectionName.equalsIgnoreCase("ANIMAL(S) INFORMATION")) {
			int size = numberOfAnimals.get();
			for (int itr = 1; itr <= size; ++itr) {
				fieldNamesList.addAll(Arrays.asList("Type of Animal(s)", "Weight", "How Many", "Handler"));
			}
		} else if (sectionName.equalsIgnoreCase("DETAILS")) {
			fieldNamesList.addAll(Arrays.asList("Details and Notes"));
		}
		return fieldNamesList;
	}

	public List<String> getRequiredFieldsSectionWise(String sectionName) {
		List<String> fieldNamesList = new ArrayList<String>();
		if (sectionName.equalsIgnoreCase("GENERAL DETAILS")) {
			fieldNamesList.addAll(Arrays.asList("Division"));
		} else if (sectionName.equalsIgnoreCase("REQUESTER(S)") || sectionName.equalsIgnoreCase("TALENT")) {
			fieldNamesList.addAll(Arrays.asList());
		} else if (sectionName.equalsIgnoreCase("SHOW INFO")) {
			fieldNamesList.addAll(Arrays.asList("Air Platform", "Show Unit or Project Name", "Other", "Arrival Date",
					"Arrival Time", "Departure Date", "Departure Time"));
		} else if (sectionName.equalsIgnoreCase("SET LOCATION")) {
			fieldNamesList.addAll(Arrays.asList("Location", "Set Location"));
		} else if (sectionName.equalsIgnoreCase("HANDLER(S) INFORMATION")) {
			fieldNamesList.addAll(Arrays.asList("Name", "Email Address", "Phone"));
		} else if (sectionName.equalsIgnoreCase("ANIMAL(S) INFORMATION")) {
			fieldNamesList.addAll(Arrays.asList("Type of Animal(s)", "Weight", "How Many", "Handler"));
		} else if (sectionName.equalsIgnoreCase("DETAILS")) {
			fieldNamesList.addAll(Arrays.asList());
		}
		return fieldNamesList;
	}

	public void checkFieldsInSectionOfAnimalsOnPremisesProduction(String sectionName) {
		List<WebElement> sectionLabelElements = getSectionLabelElements(sectionName);
		if (sectionLabelElements == null) {
			Assert.assertTrue(false, sectionName + " section is not present in Animals on Premises production form");
			return;
		}

		List<String> expectedFieldNamesList = getExpectedFieldsSectionWise(sectionName);
		List<String> expectedRequiredFieldList = getRequiredFieldsSectionWise(sectionName);
		if (sectionLabelElements.size() != expectedFieldNamesList.size()) {
			Assert.assertEquals(sectionLabelElements.size(), expectedFieldNamesList.size(),
					"Number of displayed " + "fields and expected fields not equal in " + sectionName
							+ " section of Animals on Premises Production");
			return;
		}
		for (int itr = 0; itr < expectedFieldNamesList.size(); itr++) {
			String expectedName = expectedFieldNamesList.get(itr);
			String displayedField = WebAction.getText(sectionLabelElements.get(itr));
			Assert.assertEquals(displayedField, expectedName, "Displayed field is not same as expected field in "
					+ sectionName + " " + "section of Animals on Premises Production");
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

	public Optional<WebElement> getButtonElement(String section) {
		Optional<String> locator = Optional.empty();
		if (section.equals("Animal's Information")) {
			locator = Optional.of("//*[text()=' Animal ']/ancestor::button");
		} else if (section.equals("Handler's Information")) {
			locator = Optional.of("//*[text()=' Handler ']/ancestor::button");
		} else if (section.equals("Location")) {
			locator = Optional.of("//*[text()=' Location ']/ancestor::button");
		}
		WebDriver driver = getCurrentDriver();
		Optional<WebElement> buttonOptional = locator.isEmpty() ? Optional.empty()
				: Optional.of(driver.findElement(By.xpath(locator.get())));
		return buttonOptional;
	}

	public void addLocation(int times) {
		Optional<WebElement> buttonOptional = getButtonElement("Location");
		Assert.assertFalse(buttonOptional.isEmpty(), "Cannot locate 'Add Location' button");
		WebElement addButton = buttonOptional.get();
		while (times-- > 0) {
			scrollIntoView(addButton);
			addButton.click();
			numberOfLocations.set(numberOfLocations.get() + 1);
		}
	}

	public Optional<List<WebElement>> getPlaceholderElementForField(String field) {
		WebDriver driver = getCurrentDriver();
		Optional<String> locator = Optional.empty();
		if (field.equals("Division")) {
			locator = Optional.of("//*[text()=' Division ']/../following::*[1]//nz-select-placeholder");
		} else if (field.equals("Air Platform")) {
			locator = Optional.of("//*[text()=' Air Platform ']/../following::*[1]//nz-select-placeholder");
		} else if (field.equals("Location")) {
			locator = Optional.of("//*[text()=' Location ']/../following::*[1]//nz-select-placeholder");
		} else if (field.equals("Set Location")) {
			locator = Optional.of("//*[text()=' Set Location ']/../following::*[1]//nz-select-placeholder");
		} else if (field.equals("Show Unit or Project Name")) {
			locator = Optional
					.of("//*[text()=' Show Unit or Project Name ']/../following::*[1]//nz-select-placeholder");
		}
		Optional<List<WebElement>> elementsOptional = locator.isEmpty() ? Optional.empty()
				: Optional.of(driver.findElements(By.xpath(locator.get())));
		return elementsOptional;
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
		} else if (field.equals("Type of Animal(s)")) {
			return "Type of Animal";
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
		} else if (field.equals("Handler")) {
			return "Select Handler";
		} else if (field.equals("Name")) {
			return "Handler’s Name";
		} else if (field.equals("Email Address")) {
			return "Handler’s Email";
		} else if (field.equals("Phone")) {
			return "( xxx ) xxx - xxxx";
		}
		return "";
	}

	public void checkPlaceholderOfSelectFields(String fieldName) {
		Optional<List<WebElement>> placeholderElementOptional = getPlaceholderElementForField(fieldName);
		Assert.assertFalse(placeholderElementOptional.isEmpty(),
				String.format("xpath locator for placeholder of '%s' is not specified", fieldName));
		String storedValue = getFromConstants(fieldName, 0);
		if (storedValue == null) {
			Assert.assertTrue(placeholderElementOptional.get().size() > 0,
					String.format("Placeholder for '%s' field is not present", fieldName));
			String displayed = WebAction.getText(placeholderElementOptional.get().get(0));
			String expected = getExpectedPlaceholder(fieldName);
			Assert.assertEquals(displayed, expected, "Placeholder for '" + fieldName + "' field is not correct");
		} else {
//			Assert.assertTrue(placeholderElementOptional.get().size()==0,String.format("Placeholder for '%s' field should not display if value is selected", fieldName));
		}
	}

	public void verifyErrorBelowFieldIfEmpty(String fieldName) {
		Optional<List<WebElement>> elementsOptional = getErrorElementForField(fieldName);
		Assert.assertEquals(elementsOptional.isPresent(), true,
				String.format("xpath locator for error below '%s' field is not specified", fieldName));
		Assert.assertFalse(elementsOptional.get().size() == 0,
				String.format("Error text for '%s' required field is not present", fieldName));
		WebElement element = elementsOptional.get().get(0);
		scrollIntoView(element);
		String displayed = getText(element);
		String expected = getExpectedErrorMessageForRequiredField(fieldName);
		Assert.assertEquals(displayed, expected,
				String.format("Error text for '%s' required field is not correct", fieldName));
	}

	public void verifyErrorBelowFieldIfNotEmpty(String fieldName) {
		Optional<List<WebElement>> elementsOptional = getErrorElementForField(fieldName);
		Assert.assertEquals(elementsOptional.isPresent(), true,
				String.format("xpath locator for error below '%s' field is not specified", fieldName));
		Assert.assertTrue(elementsOptional.get().size() == 0,
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
		} else if (field.equals("Type of Animal(s)")) {
			return "Please enter type of animal";
		} else if (field.equals("Weight")) {
			return "Please enter animal weight";
		} else if (field.equals("How Many")) {
			return "Please enter no of animals";
		} else if (field.equals("Handler")) {
			return "Please select Handler";
		} else if (field.equals("Set Location")) {
			return "Select a value";
		} else if (field.equals("Name")) {
			return "Enter a value";
		} else if (field.equals("Email Address")) {
			return "Enter a value";
		} else if (field.equals("Phone")) {
			return "Enter a value";
		} else if (field.equals("Other")) {
			return "Please enter Show or Project title";
		}
		return "";
	}

	public Optional<List<WebElement>> getErrorElementForField(String field) {
		Optional<String> locator = Optional.empty();
		if (field.equals("Division")) {
			locator = Optional.of(
					"//*[text()=' Division ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("Location")) {
			locator = Optional.of(
					"//*[text()=' Location ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("Set Location")) {
			locator = Optional.of(
					"//*[text()=' Set Location ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("Air Platform")) {
			locator = Optional.of(
					"//*[text()=' Air Platform ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("Show Unit or Project Name")) {
			locator = Optional.of("//*[text()=' Show Unit or Project Name ']/../following::*[1]"
					+ "//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("Arrival Date")) {
			locator = Optional.of("//*[text()=' Arrival Date ']/../following::*[1]//*[contains(@class,"
					+ "'ant-form-item-explain-error')]");
		} else if (field.equals("Arrival Time")) {
			locator = Optional.of(
					"//*[text()=' Arrival Time ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("Departure Date")) {
			locator = Optional.of(
					"//*[text()=' Departure Date ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("Departure Time")) {
			locator = Optional.of(
					"//*[text()=' Departure Time ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("Type of Animal(s)")) {
			locator = Optional.of(
					"//*[text()=' Type of Animal(s) ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("Handler")) {
			locator = Optional.of(
					"//label[text()='Handler ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("How Many")) {
			locator = Optional.of(
					"//*[text()=' How Many ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("Other")) {
			locator = Optional
					.of("//*[text()=' Other ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("Address")) {
			locator = Optional.of(
					"//*[text()=' Address ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("Weight")) {
			locator = Optional
					.of("//*[text()=' Weight ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("Name")) {
			locator = Optional
					.of("//*[text()=' Name ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("Email Address")) {
			locator = Optional.of(
					"//*[text()=' Email Address ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		} else if (field.equals("Phone")) {
			locator = Optional
					.of("//*[text()=' Phone ']/../following::*[1]//*[contains(@class,'ant-form-item-explain-error')]");
		}
		WebDriver driver = getCurrentDriver();
		Optional<List<WebElement>> elementsOptional = locator.isEmpty() ? Optional.empty()
				: Optional.of(driver.findElements(By.xpath(locator.get())));
		return elementsOptional;
	}

	public void isInputElementAvailable(Optional<WebElement> elementOptional, String field, Integer position) {
		Assert.assertEquals(elementOptional.isPresent(), true,
				String.format("Either xpath locator of %s "
						+ "is not specified or the number of %s input elements displayed on UI are less than %d", field,
						field, position + 1));
	}

	public void fillTextbox(String field, String text, String pos) throws Exception {
		Integer position = parsePosition(pos);
		Optional<WebElement> elementOptional = getInputElement(field, position);
		isInputElementAvailable(elementOptional, field, position);
		if (elementOptional.isPresent()) {
			WebElement element = elementOptional.get();
			scrollIntoView(element);
			WebAction.clear(element);
			element.sendKeys(text);
			WebAction.blur(element);
			storeInConstants(field, text, position);
		}
		checkPlaceholderForInputsHavingPlaceholderAttribute(field, position);
	}

	public Optional<WebElement> getInputElement(String fieldName, int position) {
		WebDriver driver = getCurrentDriver();
		Optional<WebElement> elementRequired = Optional.empty();
		if (fieldName.equals("Division")) {
			elementRequired = Optional.of(divisionInput);
		} else if (fieldName.equals("Show Unit or Project Name")) {
			elementRequired = Optional.of(showUnitOrProjectNameInput);
		} else if (fieldName.equals("Details and Notes")) {
			elementRequired = Optional.of(detailsAndNotesInput);
		} else if (fieldName.equals("Air Platform")) {
			elementRequired = Optional.of(airPlatformInput);
		} else if (fieldName.equals("Show Unit or Project Name")) {
			elementRequired = Optional.of(showUnitOrProjectNameInput);
		} else if (fieldName.equals("Arrival Date")) {
			elementRequired = Optional.of(arrivalDateInput);
		} else if (fieldName.equals("Arrival Time")) {
			elementRequired = Optional.of(arrivalTimeInput);
		} else if (fieldName.equals("Departure Date")) {
			elementRequired = Optional.of(departureDateInput);
		} else if (fieldName.equals("Departure Time")) {
			elementRequired = Optional.of(departureTimeInput);
		} else if (fieldName.equals("Work Order #")) {
			elementRequired = Optional.of(workOrderInput);
		} else if (fieldName.equals("Other")) {
			elementRequired = Optional.of(otherInput);
		} else {
			Optional<String> inputsLocator = Optional.empty();
			if (fieldName.equals("Location")) {
				inputsLocator = Optional.of("//*[text()=' Location ']/../following::*[1]//input");
			} else if (fieldName.equals("Set Location")) {
				inputsLocator = Optional.of("//*[text()=' Set Location ']/../following::*[1]//input");
			} else if (fieldName.equals("Type of Animal(s)")) {
				inputsLocator = Optional.of("//*[text()=' Type of Animal(s) ']/../following::*[1]//input");
			} else if (fieldName.equals("How Many")) {
				inputsLocator = Optional.of("//*[text()=' How Many ']/../following::*[1]//input");
			} else if (fieldName.equals("Weight")) {
				inputsLocator = Optional.of("//*[text()=' Weight ']/../following::*[1]//input");
			} else if (fieldName.equals("Handler")) {
				inputsLocator = Optional.of("//label[text()='Handler ']/../following::*[1]//input");
			} else if (fieldName.equals("Name")) {
				inputsLocator = Optional.of("//*[text()=' Name ']/../following::*[1]//input");
			} else if (fieldName.equals("Email Address")) {
				inputsLocator = Optional.of("//*[text()=' Email Address ']/../following::*[1]//input");
			} else if (fieldName.equals("Phone")) {
				inputsLocator = Optional.of("//*[text()=' Phone ']/../following::*[1]//input");
			}
			Optional<List<WebElement>> optionalElements = inputsLocator.isPresent()
					? Optional.of(driver.findElements(By.xpath(inputsLocator.get())))
					: Optional.empty();
			elementRequired = (optionalElements.isEmpty() || optionalElements.get().size() <= position)
					? Optional.empty()
					: Optional.of(optionalElements.get().get(position));
		}
		return elementRequired;
	}

	public void storeInConstants(String fieldName, Object option, Integer position) {
		if (fieldName.equals("Location") || fieldName.equals("Set Location")) {
			List<LocationRecord> locationRecords = Constants.getLocation();
			int count = locationRecords.size();
			int totalRecords = position + 1;
			while (count++ < totalRecords) {
				locationRecords.add(new LocationRecord());
			}
			if (fieldName.equals("Location")) {
				locationRecords.get(position).setLocation((String) option);
			} else if (fieldName.equals("Set Location")) {
				locationRecords.get(position).setSetLocation((String) option);
			}
		} else if (fieldName.equals("Name") || fieldName.equals("Email Address") || fieldName.equals("Phone")) {
			List<HandlerRecord> handlerRecords = Constants.getHandlers();
			int count = handlerRecords.size();
			int totalRecords = position + 1;
			while (count++ < totalRecords) {
				handlerRecords.add(new HandlerRecord());
			}
			if (fieldName.equals("Name")) {
				handlerRecords.get(position).setName((String) option);
			} else if (fieldName.equals("Email Address")) {
				handlerRecords.get(position).setEmailAddress((String) option);
			} else if (fieldName.equals("Phone")) {
				handlerRecords.get(position).setPhone((String) option);
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
		} else if (fieldName.equals("Type of Animal(s)") || fieldName.equals("How Many") || fieldName.equals("Weight")
				|| fieldName.equals("Handler")) {
			List<AnimalRecord> animalsList = Constants.getAnimals();
			int count = animalsList.size();
			int totalRecords = position + 1;
			while (count++ < totalRecords) {
				animalsList.add(new AnimalRecord());
			}
			if (fieldName.equals("Type of Animal(s)")) {
				animalsList.get(position).setTypeOfAnimals((String) option);
			} else if (fieldName.equals("How Many")) {
				animalsList.get(position).setHowMany((Integer) option);
			} else if (fieldName.equals("Weight")) {
				animalsList.get(position).setWeight((String) option);
			} else if (fieldName.equals("Handler")) {
				List<HandlerRecord> handlers = Constants.getHandlers();
				Optional<HandlerRecord> handler = handlers.stream()
						.filter((HandlerRecord rec) -> rec.getName() != null && rec.getName().equals((String) option))
						.findFirst();
				if (handler.isPresent()) {
					animalsList.get(position).setHandler(handler.get());
				}
			}
		}
	}

	public String getFromConstants(String fieldName, Integer position) {
		if (fieldName.equals("Location") || fieldName.equals("Set Location")) {
			List<LocationRecord> locationRecords = Constants.getLocation();
			if (locationRecords.size() <= position) {
				return null;
			} else {
				if (fieldName.equals("Location")) {
					return locationRecords.get(position).getLocation();
				} else if (fieldName.equals("Set Location")) {
					return locationRecords.get(position).getSetLocation();
				}
			}
		} else if (fieldName.equals("Name") || fieldName.equals("Email Address") || fieldName.equals("Phone")) {
			List<HandlerRecord> handlerRecords = Constants.getHandlers();
			if (handlerRecords.size() <= position) {
				return null;
			} else {
				if (fieldName.equals("Name")) {
					return handlerRecords.get(position).getName();
				} else if (fieldName.equals("Email Address")) {
					return handlerRecords.get(position).getEmailAddress();
				} else if (fieldName.equals("Phone")) {
					return handlerRecords.get(position).getPhone();
				}
			}
		} else if (fieldName.equals("Division")) {
			return Constants.getDivision();
		} else if (fieldName.equals("Details and Notes")) {
			return Constants.getDetailsAndNotes();
		} else if (fieldName.equals("Show Unit or Project Name")) {
			return Constants.getShowUnitOrProjectName();
		} else if (fieldName.equals("Air Platform")) {
			return Constants.getAirPlatform();
		} else if (fieldName.equals("Arrival Date")) {
			return Constants.getArrivalDate();
		} else if (fieldName.equals("Arrival Time")) {
			return Constants.getArrivalTime();
		} else if (fieldName.equals("Departure Time")) {
			return Constants.getDepartureTime();
		} else if (fieldName.equals("Departure Date")) {
			return Constants.getDepartureDate();
		} else if (fieldName.equals("Work Order #")) {
			return Constants.getWorkOrder();
		} else if (fieldName.equals("Other")) {
			return Constants.getOtherInShowInfo();
		} else if (fieldName.equals("Type of Animal(s)") || fieldName.equals("How Many") || fieldName.equals("Weight")
				|| fieldName.equals("Handler")) {
			List<AnimalRecord> animalsList = Constants.getAnimals();
			if (animalsList.size() <= position) {
				return null;
			} else {
				if (fieldName.equals("Type of Animal(s)")) {
					return animalsList.get(position).getTypeOfAnimals();
				} else if (fieldName.equals("How Many")) {
					return animalsList.get(position).getHowMany().toString();
				} else if (fieldName.equals("Weight")) {
					return animalsList.get(position).getWeight();
				} else if (fieldName.equals("Handler")) {
					return animalsList.get(position).getHandler().getName();
				}
			}
		}
		return null;
	}

	public void checkPlaceholderForInputsHavingPlaceholderAttribute(String field, Integer position) {
		// verify the placeholder of the inputs or textarea that has placeholder
		// attribute
		Optional<WebElement> elementOptional = getInputElement(field, position);
		isInputElementAvailable(elementOptional, field, position);
		WebElement element = elementOptional.get();
		String displayed = WebAction.getAttribute(element, "placeholder");
		String expected = getExpectedPlaceholder(field);
		Assert.assertEquals(displayed.trim(), expected,
				String.format("Placeholder for '%s' textarea is not correct", field));
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

	public void selectValueInDropdown(String option, String fieldName, String pos) {
		Integer position = parsePosition(pos);
		try {
			WebDriver driver = getCurrentDriver();
			Optional<WebElement> elementOptional = getInputElement(fieldName, position);
			isInputElementAvailable(elementOptional, fieldName, position);
			WebElement input = elementOptional.get();
			try {
				waitForElement(input, WAIT_CONDITIONS.VISIBLE);
			} catch (Exception e) {
				e.printStackTrace();
			}
			scrollIntoView(input);
			input.sendKeys(option);
			By dropdownOptionsBy = By.xpath("//*[contains(@class,'ant-select-item') and text()]");
			waitForElement(dropdownOptionsBy, WAIT_CONDITIONS.VISIBLE);
			List<WebElement> options = driver.findElements(dropdownOptionsBy);
			Optional<WebElement> optional = options.stream()
					.filter((WebElement divisionOption) -> getText(divisionOption).equals(option)).findAny();
			Assert.assertEquals(optional.isPresent(), true,
					String.format(
							"'%s' is not present as an option in '%s' on " + "Animals on Premises production form",
							option, fieldName));
			if (optional.isPresent()) {
				WebElement optionToSelect = optional.get();
				scrollIntoView(optionToSelect);
				click(optionToSelect);
				storeInConstants(fieldName, option, position);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(String.format("Error while selecting '%s' in '%s' on " + "Animals on Premises Production form",
					option, fieldName));
		}
	}

	public void selectQuantity(String fieldName, Integer option, String pos) {
		Integer position = parsePosition(pos);
		try {
			Optional<WebElement> inputOptional = getInputElement(fieldName, position);
			isInputElementAvailable(inputOptional, fieldName, position);
			if (inputOptional.isPresent()) {
				WebElement input = inputOptional.get();
				waitForElement(input, WAIT_CONDITIONS.VISIBLE);
				scrollIntoView(input);
				WebAction.sendKeys(input, Integer.toString(option));
				storeInConstants(fieldName, option, position);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String.format("Error while selecting '%s' in '%s' on Animals On " + "Premises Production form", option,
					fieldName);
		}
	}

	public void clearTextareaInput(String field, Integer position) {
		Optional<WebElement> elementOptional = getInputElement(field, position);
		isInputElementAvailable(elementOptional, field, position);
		if (elementOptional.isPresent()) {
			WebElement element = elementOptional.get();
			scrollIntoView(element);
			WebAction.clearInputOneCharAtTime(element);
			storeInConstants(field, "", position);
		}
	}

	public void addAnimal(int times) {
		Optional<WebElement> buttonOptional = getButtonElement("Animal's Information");
		Assert.assertFalse(buttonOptional.isEmpty(), "Cannot locate 'Add Animal' button");
		WebElement addButton = buttonOptional.get();
		while (times-- > 0) {
			scrollIntoView(addButton);
			addButton.click();
			numberOfAnimals.set(numberOfAnimals.get() + 1);
		}
	}

	public void addHandler(int times) {
		Optional<WebElement> buttonOptional = getButtonElement("Handler's Information");
		Assert.assertFalse(buttonOptional.isEmpty(), "Cannot locate 'Add Handler' button");
		WebElement addButton = buttonOptional.get();
		while (times-- > 0) {
			scrollIntoView(addButton);
			addButton.click();
			numberOfHandlers.set(numberOfHandlers.get() + 1);
		}
	}

	public void verifyTheFormSectionsInAnimalsOnPremisesProductionForm() {
		Object[] expectedHeaders = { "STATUS", "GENERAL DETAILS", "REQUESTER(S)", "TALENT", "SHOW INFO", "SET LOCATION",
				"HANDLER(S) INFORMATION", "ANIMAL(S) INFORMATION", "DETAILS" };
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
					"All expected sections are not present on Animals on Premises Production form");
		}
	}

	public void setDateInShowInfo(String field, String option, String pos) throws Exception {
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

}