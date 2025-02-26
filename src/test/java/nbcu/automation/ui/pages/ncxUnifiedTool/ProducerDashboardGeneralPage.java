
package nbcu.automation.ui.pages.ncxUnifiedTool;

import static nbcu.framework.factory.DriverFactory.getCurrentDriver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import nbcu.automation.ui.pojos.ncxUnifiedTool.CrewRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.NoteRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.RequestLog;
import com.aventstack.extentreports.Status;
import nbcu.automation.ui.pojos.ncxUnifiedTool.RequesterRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.TalentRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.TpmOrTmInformation;
import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;
import nbcu.automation.ui.enums.RequestMode;
import nbcu.automation.ui.enums.RequestStatus;
import nbcu.automation.ui.enums.RequestType;
import nbcu.automation.ui.enums.UserRole;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.factory.DriverFactory;
import nbcu.framework.utils.Other.DateFunctions;
import nbcu.framework.utils.cucumber.CucumberUtils;
import nbcu.framework.utils.propertyfilereader.ConfigFileReader;
import nbcu.framework.utils.report.ReportGenerate;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;
import nbcu.framework.utils.ui.WebAction;

import static nbcu.framework.utils.ui.WebAction.click;
import static nbcu.framework.utils.ui.WebAction.getText;
import static nbcu.framework.utils.ui.WebAction.scrollIntoView;

import static org.testng.Assert.assertNotNull;

import io.cucumber.datatable.DataTable;

public class ProducerDashboardGeneralPage {

	MyRequestPage myRequestPage = new MyRequestPage();

	public static List<String> emailtoList = new ArrayList<String>();
	public static List<String> workingEmailtoList = new ArrayList<String>();

	public static List<String> emailCCList = new ArrayList<String>();
	public static List<String> workingEmailCCList = new ArrayList<String>();

	@FindBy(xpath = "//*[contains(text(),'LA Fulfillment')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement laFulfillmentStatus;

	@FindBy(xpath = "//section[@class='note-container']//div[@class='ng-star-inserted']//div[@class='ant-card-body']//div[@class='middle-row ng-star-inserted']/p")
	WebElement RequesterTxtInsideNotes;

	@FindBy(xpath = "//section[@class='note-container']//div[@class='ng-star-inserted']//div[@class='ant-card-body']//*[@forminputname='editNote']")
	WebElement RequesterTxtInsideEditNotes;

	@FindBy(xpath = "//section[@class='note-container']//div[@class='ng-star-inserted']//div[@class='ant-card-body']//div[@class='top-row ng-star-inserted']/p")
	WebElement UserRoleInsideNotes;

	@FindBy(xpath = "//section[@class='note-container']//div[@class='ng-star-inserted']//div[@class='ant-card-body']//div[@class='top-row ng-star-inserted']//p[@class='time-date']")
	WebElement TimeInsideNotes;

	@FindBy(xpath = "//section[@class='note-container']//div[@class='ng-star-inserted']//div[@class='ant-card-body']//div[@class='bottom-row ng-star-inserted']//div[@class='sso-name']")
	WebElement ssoInsideNotes;

	@FindBy(xpath = "//section[@class='note-container']//div[@class='ng-star-inserted']//div[@class='ant-card-body']//div[@class='bottom-row ng-star-inserted']//span[@class='anticon anticon-delete']")
	WebElement deleteIconInsideNotes;

	@FindBy(xpath = "//section[@class='note-container']//div[@class='ng-star-inserted']//div[@class='ant-card-body']//div[@class='bottom-row ng-star-inserted']//span[@class='anticon anticon-edit']")
	WebElement editIconInsideNotes;

	@FindBy(xpath = "//section[@class='note-container']//div[@class='ng-star-inserted']//div[@class='ant-card-body']//*[@forminputname='editNote']//textarea")
	WebElement noteTextArea;

	@FindBy(xpath = "//section[@class='note-container']//div[@class='ng-star-inserted']//div[@class='ant-card-body']//span[@class='anticon anticon-save']")
	WebElement saveBtnInsdeNotes;

	// rock center Request
	@FindBy(xpath = "(//div[contains(@class,'title')]//p)[1]")
	WebElement formTitle;

	@FindBy(xpath = "//*[@label='Air Platform']//input")
	WebElement airPlatformDropDown;

	@FindBy(xpath = "//*[contains(text(),'Show Unit or Project Name')]//ancestor::div[1]//input | //*[contains(text(),'Budget Code / Show Title')]//ancestor::div[1]//input")
	WebElement showInputBox;

	@FindBy(xpath = "(//*[@placeholder='Select Date'])[1]//input")
	WebElement startDate;

	// @FindBy(xpath = "//*[@forminputname='prepStartTime']//input")
	// WebElement prepTime;

	@FindBy(xpath = "//*[@forminputname='callTime']//input")
	WebElement callTimePrepTime;

	@FindBy(xpath = "//*[@forminputname='prodStartTime']//input | //*[@forminputname='startTime']//input | //*[@forminputname='rollTime']//input")
	WebElement startTime;

	@FindBy(xpath = "//*[@forminputname='endTime']//input")
	WebElement endTime;

	@FindBy(xpath = "//div[contains(text(),'Ultimatte')]/ancestor::div[1]//input")
	WebElement ultimatteInputbox;

	@FindBy(xpath = "//div[contains(text(),'Voice Activated Prompter')]/ancestor::div[1]//input")
	WebElement vapInputbox;

	@FindBy(xpath = "//textarea[@placeholder='Add System Notes']")
	WebElement systemNotesTextArea;

	@FindBy(xpath = "(//*[contains(text(),'Sub Division')]//following::nz-select-search[1])[1]")
	WebElement subDivisionSection;

	String locationDropDown = "(//*[@label='Location']//input)[<<locationTypeDropDownNo>>]";

	String locationAddressInputBox = "(//*[@label='Location']/ancestor::div[2]//*[@label='Address']//input)[<<locationAddressInputBoxNo>>]";

	@FindBy(xpath = "//span[contains(text(),'Location')]")
	WebElement addLocationButton;

	String setLocationDropDown = "(//*[@label='Set Location']//input)[<<setLocationTypeDropDownNo>>]";

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

	@FindBy(xpath = "//textarea[@placeholder='Add Staging Needs']")
	WebElement DescribeStagingNeedsTextarea;

	String controlRoomLocationDropDown = "(//*[@label='Control Room Location']//input)[<<controlRoomLocationDropDownNo>>]";

	String controlRoomDropDown = "(//*[@label='Control Room']//input)[<<controlRoomDropDownNo>>]";

	String controlRoomAddressInputBox = "(//*[@label='Control Room Location']/ancestor::div[2]//*[@label='Address']//input)[<<controlRoomAddressInputBoxNo>>]";

	@FindBy(xpath = "//span[contains(text(),'Control Room')]")
	WebElement addControlRoomButton;

	@FindBy(xpath = "//*[@label='Request For']//input")
	WebElement requestForDropDown;

	@FindBy(xpath = "//*[@forminputname='tpmOrTm']//input")
	WebElement tpmOrTmDropDown;

	@FindBy(xpath = "//*[@label='Details & Notes']//textarea | //*[@label='Details and Notes']//textarea")
	WebElement detailsAndNotesTextarea;

	@FindBy(xpath = "//*[@forminputname='craftEditComments']//textarea | //*[@forminputname='comments']//textarea | //*[@forminputname='sfComments']//textarea")
	WebElement commentsTextArea;

	// Crew Request Details

	@FindBy(xpath = "//div[contains(@class, 'story-list-elem')]/button")
	List<WebElement> ncxStoryNamesdropDownvalues;

	@FindBy(xpath = "//input[contains(@placeholder,'Enter Slug')]")
	WebElement slugTextArea;

	@FindBy(xpath = "//*[@forminputname='storyName']/following::div[1]//span")
	WebElement firstNCXStoryName;

	@FindBy(xpath = "//input[@placeholder='Search NCX Story Name']")
	WebElement nCXStoryName;

	@FindBy(xpath = "//*[@formcontrolname='isRequestorProducer']//input[@type='checkbox']")
	WebElement producerSameasRequestor_CheckBox;

	@FindBy(xpath = "//*[@forminputname='producerName']//input[@placeholder='Search for Producer']")
	WebElement producerSameAsRequestInputBox;

	@FindBy(xpath = "//input[@placeholder='Search for Senior Producer / Approver']")
	WebElement seniorProducerInputBox;

	@FindBy(xpath = "//*[@forminputname='fieldContactName']//input")
	WebElement fieldContactName;

	@FindBy(xpath = "//*[@forminputname='producerCellNumber']//input")
	WebElement fieldMobile;

	@FindBy(xpath = "//*[@forminputname='isThereAnOnsiteProducer']//label[@label-value='yes']")
	WebElement hasOnSiteProducer_Yes;

	@FindBy(xpath = "//*[@forminputname='isThereAnOnsiteProducer']//label[@label-value='no']")
	WebElement hasOnSiteProducer_No;

	@FindBy(xpath = "//span[text()='Shoot Specs']")
	WebElement shootSpecsTitle;

	@FindBy(xpath = "//span[text()='Shoot Details']")
	WebElement shootDetails;

	@FindBy(xpath = "//*[@forminputname='productionType']//input")
	WebElement productionType;

	@FindBy(xpath = "//*[@forminputname='shootStatus']//label[@label-value='Firm']")
	WebElement shootStatus_Firm;

	@FindBy(xpath = "//*[@forminputname='shootStatus']//label[@label-value='Tent']")
	WebElement shootStatus_Tent;

	@FindBy(xpath = "//*[@forminputname='shootDescription']//textarea")
	WebElement shootDescription;

	@FindBy(xpath = "//*[@forminputname='audioNeeds']//input")
	WebElement audioNeeds;

	@FindBy(xpath = "//*[@forminputname='specialConditions']//input")
	WebElement specialConditions;

	@FindBy(xpath = "//*[@forminputname='transmissionType']//input")
	WebElement transmissionType;

	@FindBy(xpath = "//*[@forminputname='acquisitionSpecs']//input")
	WebElement acquisitionSpecs;

	@FindBy(xpath = "//*[@forminputname='droneShoot']//label[@label-value='true']")
	WebElement droneShoot_true;

	@FindBy(xpath = "//*[@forminputname='droneShoot']//label[@label-value='false']")
	WebElement droneShoot_false;

	@FindBy(xpath = "//*[@forminputname='specialGear']//label[@label-value='true']")
	WebElement specialGear_true;

	@FindBy(xpath = "//*[@forminputname='specialGear']//label[@label-value='false']")
	WebElement specialGear_false;

	@FindBy(xpath = "//*[@forminputname='gearNotes']//textarea")
	WebElement gearNotes;

	@FindBy(xpath = "//*[@forminputname='bureauLocation']//input")
	WebElement shootLocationBureauLocationDropdown;

	@FindBy(xpath = "//*[@forminputname='addressLine1']//input")
	WebElement shootLocationBureauLocationAddressInputField;

	@FindBy(xpath = "//*[@forminputname='city']//input")
	WebElement shootLocationCityInputField;

	@FindBy(xpath = "//*[@forminputname='state']//input")
	WebElement shootLocationStateInputField;

	@FindBy(xpath = "//span[@class='ant-radio-button']/following::span[text()='Standard ']")
	WebElement standardOption;

	@FindBy(xpath = "//*[text()=' Confirm which risk assessments apply: ']/ancestor::nz-form-item//span[text()='Filming on Roads']")
	WebElement filmingOnRoadsOption;

	@FindBy(xpath = "//*[text()=' Confirm which risk assessments apply: ']/ancestor::nz-form-item//span[text()='HMI Lighting']")
	WebElement hmiLightingOption;

	@FindBy(xpath = "//*[text()=' Confirm which risk assessments apply: ']/ancestor::nz-form-item//span[text()='Live Positions']")
	WebElement livePositionsOption;

	@FindBy(xpath = "//*[text()=' Confirm which risk assessments apply: ']/ancestor::nz-form-item//span[text()='Long Working']")
	WebElement longWorkingOption;

	@FindBy(xpath = "//*[text()=' Confirm which risk assessments apply: ']/ancestor::nz-form-item//span[text()='Structure & Access Equipment']")
	WebElement structureAccessEquipmentOption;

	@FindBy(xpath = "//*[text()=' Confirm which risk assessments apply: ']/ancestor::nz-form-item//span[text()='Working Heights']")
	WebElement workingHeightsOption;

	@FindBy(xpath = "//span[@class='ant-radio-button']/following::span[text()='High ']")
	WebElement highOption;

	@FindBy(xpath = "//*[text()=' Confirm which risk assessments apply: ']/ancestor::nz-form-item//span[text()='Aircraft']")
	WebElement aircraftOption;

	@FindBy(xpath = "//*[text()=' Confirm which risk assessments apply: ']/ancestor::nz-form-item//span[text()='Emergencies & Disasters']")
	WebElement emergenciesDisastersOption;

	@FindBy(xpath = "//*[text()=' Confirm which risk assessments apply: ']/ancestor::nz-form-item//span[text()='Filming on or Near Water']")
	WebElement filmingOnOrNearWaterOption;

	@FindBy(xpath = "//*[text()=' Confirm which risk assessments apply: ']/ancestor::nz-form-item//span[text()='Riots & Civil Disturbances']")
	WebElement riotsCivilDisturbancesOption;

	@FindBy(xpath = "//*[text()=' Confirm which risk assessments apply: ']/ancestor::nz-form-item//span[text()='Storm & Extreme Weather']")
	WebElement stormExtremeWeatherOption;

	@FindBy(xpath = "//*[text()=' Confirm which risk assessments apply: ']/ancestor::nz-form-item//span[text()='War Zones']")
	WebElement warZoneOption;

	@FindBy(xpath = "//textarea[@placeholder='Enter risk arrangements here']")
	WebElement riskArrangementsTextarea;

	@FindBy(xpath = "//input[@placeholder='Search Approver here...']")
	WebElement riskApproverInputBox;

	@FindBy(xpath = "//nz-auto-option[@role='menuitem']/div")
	List<WebElement> riskApproverMenuitem;

	@FindBy(xpath = "//*[@title='Add Resources']//input[@placeholder='Search Resources']")
	WebElement searchResourcesTextbox;

	@FindBy(xpath = "//form//*[text()='Risk Assessment']")
	WebElement riskAssessmentArea;

	@FindBy(xpath = "//div[contains(@class,'edit-content-management')]//span[contains(@class,'title') and text()='Date & Time']")
	WebElement dateTimeTitle;

	@FindBy(xpath = "(//*[@forminputname='shootDates']//input)[1]")
	WebElement shootStartDate;

	@FindBy(xpath = "(//*[@forminputname='shootDates']//input)[2]")
	WebElement shootEndDate;

	@FindBy(xpath = "//*[@forminputname='timeZone']//input")
	WebElement timeZone;

	@FindBy(xpath = "//*[@forminputname='meetTime']//input")
	WebElement meetTime;

	@FindBy(xpath = "//*[@forminputname='iPadPrompter']//label[@label-value='true']")
	WebElement iPadPrompter_true;

	@FindBy(xpath = "//*[@forminputname='iPadPrompter']//label[@label-value='false']")
	WebElement iPadPrompter_false;

	@FindBy(xpath = "//*[@forminputname='primaryCameraType']//input")
	WebElement primaryCameraType;

	@FindBy(xpath = "//*[@forminputname='mediaFormat']//nz-select")
	WebElement mediaFormat;

	@FindBy(xpath = "//*[@forminputname='videoSpecs']//nz-select")
	WebElement videoSpecs;

	@FindBy(xpath = "//*[@forminputname='shootType']//label[@label-value='Live']")
	WebElement shootType_Live;

	@FindBy(xpath = "//*[@forminputname='shootType']//label[@label-value='Tape']")
	WebElement shootType_Tape;

	// Other WebElements

	@FindBy(xpath = "//*[@role='menuitem']/div")
	List<WebElement> SearchList;

	String dropDownvaluesXpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item";

	@FindBy(xpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item | //nz-option-item ")
	List<WebElement> dropDownvalues;

	@FindBy(xpath = "//*[@title='ADDITIONAL']//textarea[@placeholder='Enter Content Description Here']")
	WebElement fiContentDescTextbox;

	// section wise error
	String sectionIcon = "//*[contains(text(),'<<SectionName>>')]/ancestor::div[2]/div/button/i";

	@FindBy(xpath = "//*[contains(text(),'Select Division')]/ancestor::div[3]//div[contains(@class,'error')]")
	WebElement divisionError;

	@FindBy(xpath = "//*[contains(text(),' Select Request For')]/ancestor::div[3]//div[contains(@class,'error')]")
	WebElement requestForError;

	@FindBy(xpath = "//*[contains(text(),'Select Air Platform')]/ancestor::div[3]//div[contains(@class,'error')]")
	WebElement airPlatformError;

	@FindBy(xpath = "//*[contains(text(),'Show Unit or Project Name')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement showUnitError;

	@FindBy(xpath = "//*[contains(@placeholder,'Budget Code')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement budgetCodeError;

	@FindBy(xpath = "//*[contains(@placeholder,'Select Date')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement startDateError;

	@FindBy(xpath = "(//*[contains(@placeholder,'Select time')]/ancestor::div[1]//div[contains(@class,'error')])[1]")
	WebElement startTimeError;

	@FindBy(xpath = "(//*[contains(@placeholder,'Select time')]/ancestor::div[1]//div[contains(@class,'error')])[2]")
	WebElement endTimeError;

	@FindBy(xpath = "(//*[contains(@placeholder,'Select Date')]/ancestor::div[4]//div[contains(@class,'error')])[1]")
	WebElement arrivalDateError;

	@FindBy(xpath = "(//*[contains(@placeholder,'Select Time')]/ancestor::div[4]//div[contains(@class,'error')])[1]")
	WebElement arrivalTimeError;

	@FindBy(xpath = "(//*[contains(@placeholder,'Select Date')]/ancestor::div[4]//div[contains(@class,'error')])[2]")
	WebElement departureDateError;

	@FindBy(xpath = "(//*[contains(@placeholder,'Select Time')]/ancestor::div[4]//div[contains(@class,'error')])[2]")
	WebElement departureTimeError;

	@FindBy(xpath = "//*[contains(text(),'Select Location')]/ancestor::div[3]//div[contains(@class,'error')]")
	WebElement locationError;

	@FindBy(xpath = "//*[contains(text(),'Select Set Location')]/ancestor::div[3]//div[contains(@class,'error')]")
	WebElement setLocationError;

	@FindBy(xpath = "//*[contains(text(),'Control Room Location')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement controlRoomLocationError;

	@FindBy(xpath = "(//*[contains(text(),'Control Room')]/ancestor::div[1]//div[contains(@class,'error')])[last()]")
	WebElement controlRoomError;

	@FindBy(xpath = "//*[contains(@placeholder,'Enter Slug, Project Name, or Title')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement slugError;

	@FindBy(xpath = "//*[contains(@placeholder,'Search for Producer')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement producerError;

	@FindBy(xpath = "//*[contains(@placeholder,'Search for Senior Producer / Approver')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement srProducerOrApproverError;

	@FindBy(xpath = "//*[contains(@forminputname,'isThereAnOnsiteProducer')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement isThereAnOnsiteProducerError;

	@FindBy(xpath = "//*[contains(@forminputname,'producerCellNumber')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement producerCellNumberError;

	@FindBy(xpath = "//*[contains(@forminputname,'prodUserNumber')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement prodUserNumberError;

	@FindBy(xpath = "//*[contains(@placeholder,'Budget Code / Show Title')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement showTitleBudgetCodeError;

	@FindBy(xpath = "//*[contains(@placeholder,'Show Unit or Project Name')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement showUnitorProjectNameError;

	@FindBy(xpath = "//*[contains(@forminputname,'segmentType')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement segmentTypeError;

	@FindBy(xpath = "//*[contains(@forminputname,'location')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement gearLocationError;

	@FindBy(xpath = "//*[contains(@forminputname,'pickupDate')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement pickUpDateError;

	@FindBy(xpath = "//*[contains(@forminputname,'pickupTime')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement pickUpTimeError;

	@FindBy(xpath = "//*[contains(@forminputname,'returnDate')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement returnDateError;

	@FindBy(xpath = "//*[contains(@forminputname,'productionType')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement productionTypeError;

	@FindBy(xpath = "//*[contains(@forminputname,'shootType')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement shootTypeError;

	@FindBy(xpath = "//*[contains(@forminputname,'shootDescription')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement shootDescriptionError;

	@FindBy(xpath = "//*[contains(@forminputname,'audioNeeds')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement audioNeedsError;

	@FindBy(xpath = "//*[contains(@forminputname,'specialConditions')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement specialConditionsError;

	@FindBy(xpath = "//*[contains(@forminputname,'transmissionType')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement transmissionTypeError;

	@FindBy(xpath = "//*[contains(@forminputname,'primaryCameraType')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement primaryCameraTypeError;

	@FindBy(xpath = "//*[contains(@forminputname,'acquisitionSpecs')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement acquisitionSpecsError;

	@FindBy(xpath = "//*[contains(@forminputname,'droneShoot')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement droneShootError;

	@FindBy(xpath = "//*[contains(@forminputname,'addressLine1')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement addressLine1Error;

	@FindBy(xpath = "//*[contains(@forminputname,'city')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement cityError;

	@FindBy(xpath = "//*[contains(@forminputname,'state')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement stateError;

	@FindBy(xpath = "//*[contains(@forminputname,'country')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement countryError;

	@FindBy(xpath = "//*[contains(@forminputname,'shootDates')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement shootDatesError;

	@FindBy(xpath = "//*[contains(@forminputname,'timeZone')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement timeZoneError;

	@FindBy(xpath = "//*[contains(@forminputname,'meetTime')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement meetTimeError;

	@FindBy(xpath = "//*[contains(@forminputname,'rollTime')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement rollTimeError;

	@FindBy(xpath = "//*[contains(@forminputname,'endTime')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement endTimeCrewError;

	@FindBy(xpath = "//*[contains(@forminputname,'hiddenCameraMicro')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement hiddenCameraMicroError;

	@FindBy(xpath = "//*[contains(@forminputname,'outsideUs')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement outsideUsError;

	@FindBy(xpath = "//*[contains(@forminputname,'nbcStudioLocation')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement nbcStudioLocationError;

	@FindBy(xpath = "//*[contains(@forminputname,'outsider')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement outsiderError;

	@FindBy(xpath = "//*[contains(@forminputname,'description')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement descriptionError;

	@FindBy(xpath = "//*[contains(@forminputname,'locationofEdit')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement editOfLocationError;

	@FindBy(xpath = "//*[contains(@forminputname,'editStartDate')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement editStartDateError;

	@FindBy(xpath = "//*[contains(@forminputname,'producerOrEditor')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement whoIsEditingError;

	@FindBy(xpath = "//*[contains(@label,'Type of Edits')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement typeofEditError;

	@FindBy(xpath = "//*[contains(@label,'Quantity')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement quantityError;

	@FindBy(xpath = "//*[contains(@forminputname,'dateNeededBy')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement dateNeededByError;

	@FindBy(xpath = "//*[contains(@forminputname,'timeNeededBy')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement timeNeededByError;

	@FindBy(xpath = "//*[contains(@forminputname,'deviceType')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement sourceError;

	@FindBy(xpath = "//*[contains(@forminputname,'contentDescription')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement contentDescriptionError;

	@FindBy(xpath = "//*[contains(@forminputname,'timeCodes')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement timeCodesError;

	@FindBy(xpath = "//*[contains(@forminputname,'selectDestination')]/ancestor::div[1]//div[contains(@class,'error')]")
	WebElement destinationError;

	@FindBy(xpath = "//*[contains(text(),'STATUS')]")
	WebElement statusSection;

	@FindBy(xpath = "//*[@forminputname='division']//input")
	WebElement divisionTypeDropDown; // *[contains(text(),'Select Division')] | //*[@forminputname='division']//input

	@FindBy(xpath = "//*[@label='Add Requester(s)']//input")
	WebElement addRequester;

	@FindBy(xpath = "//*[@label='Talent']//*[@placeholder='Search or Enter Correspondent, Anchor, Host, Guest Name(s)']")
	WebElement talentInputBox;

	@FindBy(xpath = "//*[@label='Set Crew']//nz-select//input")
	WebElement setCrew;

	@FindBy(xpath = "//*[@label='Set Flashcam Crew']//nz-select//input")
	WebElement setFlashcamCrew;

	@FindBy(xpath = "//*[@sectiontitle='Set Crew']//*[@label='Other']//input")
	WebElement otherSetCrewInputBox;

	@FindBy(xpath = "//*[@label='Additional Crew']//nz-select//input")
	WebElement additionalCrew;

	@FindBy(xpath = "//*[@forminputname='captureManager']//label[@label-value='yes'] | //*[@forminputname='setCaptureManager']//label[@label-value='true']")
	WebElement captureManager_Yes;

	@FindBy(xpath = "//*[@forminputname='captureManager']//label[@label-value='no'] | //*[@forminputname='setCaptureManager']//label[@label-value='false']")
	WebElement captureManager_No;

	@FindBy(xpath = "//*[@label='Control Room Crew']//nz-select//input")
	WebElement controlRoomCrew;

	@FindBy(xpath = "//*[@sectiontitle='Control Room CREW']//*[@label='Other']//input")
	WebElement otherControlRoomCrewInputBox;

	@FindBy(xpath = "//*[@forminputname='tpmOrTm']//label[@label-value='Yes']")
	WebElement tpmOrTm_Yes;

	@FindBy(xpath = "//*[@forminputname='tpmOrTm']//label[@label-value='No']")
	WebElement tpmOrTm_No;

	@FindBy(xpath = "//*[contains(text(),'Same as requester')]")
	WebElement sameAsRequesterCheckBox;

	@FindBy(xpath = "//*[@forminputname='tpmTmName']//input")
	WebElement tpmTmName;

	@FindBy(xpath = "//p[contains(text(),'REQUESTER')]")
	WebElement requestersSection;

	@FindBy(xpath = "//p[contains(text(),'SET LOCATION')] | //p[contains(text(),'SET LOCATION & CREW')]")
	WebElement setLocationSection;

	@FindBy(xpath = "//p[contains(text(),'GENERAL DETAILS')]")
	WebElement generaldetailsSection;

	@FindBy(xpath = "//p[contains(text(),'CONTROL ROOM CREW')]")
	WebElement controlRoomCrewSection;

	@FindBy(xpath = "//p[contains(text(),'ADDITIONAL CREW')]")
	WebElement additionalCrewSection;

	@FindBy(xpath = "//p[contains(text(),'CONTROL ROOM')]")
	WebElement controlRoomSection;

	@FindBy(xpath = "//p[contains(text(),'SYSTEMS')]")
	WebElement systemsSection;

	@FindBy(xpath = "//p[contains(text(),'STAGING')]")
	WebElement stagingSection;

	@FindBy(xpath = "//p[contains(text(),'TPM / TM INFORMATION')]")
	WebElement tpmOrTmSection;

	@FindBy(xpath = "//p[contains(text(),'TALENT')]")
	WebElement talentSection;

	@FindBy(xpath = "//p[contains(text(),'PRODUCTION PURPOSE')]")
	WebElement productionPurposeSection;

	@FindBy(xpath = "//p[contains(text(),'SHOW INFO')]")
	WebElement showInfoSection;

	@FindBy(xpath = "//p[contains(text(),'SET CREW')]")
	WebElement setCrewSection;

	@FindBy(xpath = "//p[contains(text(),'DETAILS')]")
	WebElement detailsSection;

	@FindBy(xpath = "//p[contains(text(),'SET INFORMATION')]")
	WebElement setInformationSection;

	@FindBy(xpath = "//p[contains(text(),'CONTROL ROOM & CREW')]")
	WebElement controlRoomAndCrewSection;

	@FindBy(xpath = "//p[contains(text(),'PRODUCER DETAILS')]")
	WebElement producerDetailsSection;

	@FindBy(xpath = "//p[contains(text(),'FIELD CONTACT')]")
	WebElement fieldContactSection;

	@FindBy(xpath = "//p[contains(text(),'SHOOT DETAILS')]")
	WebElement shootDetailsSection;

	@FindBy(xpath = "//p[contains(text(),'SHOOT SPECS')]")
	WebElement shootSpecsSection;

	@FindBy(xpath = "//p[contains(text(),'ATTACHMENTS')]")
	WebElement attachmentsSection;

	@FindBy(xpath = "//p[contains(text(),'SHOOT LOCATION')]")
	WebElement shootLocationSection;

	@FindBy(xpath = "//p[contains(text(),'GEAR USER')]")
	WebElement gearUserSection;

	@FindBy(xpath = "//p[contains(text(),'LOCATION, DATE & TIME')]")
	WebElement locationDateTimeSection;

	@FindBy(xpath = "//p[contains(text(),'COMMENTS')]")
	WebElement commentsSection;

	@FindBy(xpath = "//p[contains(text(),'DATE & TIME')]")
	WebElement dateTimeSection;

	@FindBy(xpath = "//*[@forminputname='arrivalDate']//input")
	WebElement arrivalDate;

	@FindBy(xpath = "//*[@forminputname='arrivalTime']//input")
	WebElement arrivalTime;

	@FindBy(xpath = "//*[@forminputname='departureDate']//input")
	WebElement departureDate;

	@FindBy(xpath = "//*[@forminputname='departureTime']//input")
	WebElement departureTime;

	// fulfiller details xpaths

	@FindBy(xpath = "//li[contains(text(),'Fulfilled')]")
	WebElement fulfilledTab;

	@FindBy(xpath = "//li[contains(text(),'Cancelled')]")
	WebElement cancelledTab;

	@FindBy(xpath = "//li[contains(text(),'Active')]")
	WebElement activeTab;

	@FindBy(xpath = "//*[text()='Crew']/preceding-sibling::i")
	WebElement crewIcon;

	@FindBy(xpath = "//a[contains(text(),'Executive Dashboard')]")
	WebElement executiveDashboard;

	@FindBy(xpath = "//a[contains(text(),'CNBC Dashboard')]")
	WebElement cnbcDashboard;

	@FindBy(xpath = "//a[contains(text(),'Digital Dashboard')]")
	WebElement digitalDashboard;

	@FindBy(xpath = "//a[contains(text(),'Telemundo Dashboard')]")
	WebElement telemundoDashboard;

	@FindBy(xpath = "//p[text()='NBC News Crew']")
	WebElement nbcCrewDashboardTitle;

	@FindBy(xpath = "//p[text()='CNBC Crew']")
	WebElement cnbcCrewDashboardTitle;

	@FindBy(xpath = "//p[text()='Digital Crew']")
	WebElement digitalCrewDashboardTitle;

	@FindBy(xpath = "//p[text()='Telemundo Crew']")
	WebElement telemundoCrewDashboardTitle;

	@FindBy(xpath = "//span[text()='Request Center']")
	WebElement executiveDashboardTitle;

	// Dashboard toggle filter
	@FindBy(xpath = "//button[contains(@class,'has-no-value-toggle-o')]")
	WebElement toggleFilter;

	// Dashboard Table Element
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchTextBox;

	@FindBy(xpath = "(//span[contains(text(),'Edit')])[last()] |button[@class='ecm-fulfillment-btn ant-btn ant-btn-primary ant-btn-round ng-star-inserted']")
	WebElement editButton;

	@FindBy(xpath = "//tr[contains(@class,'ant-table-row')]")
	List<WebElement> fulfillerTableRows;

	String findRequestById = "//a[contains(text(),'<<RequestId>>')]";

	@FindBy(xpath = "//span[text()='My Requests']//preceding-sibling::button")
	WebElement myRequestIcon;

	// Tabs in Fulfiller Dashboard page
	@FindBy(xpath = "//div[contains(text(),'CREW')]")
	WebElement formTab;

	@FindBy(xpath = "//div[contains(text(),'STATUS')]")
	WebElement statusTab;

	@FindBy(xpath = "//div[contains(text(),'NOTES')]")
	WebElement notesTab;

	@FindBy(xpath = "(//span[contains(text(),'Log')] | //div[contains(text(),'LOG')])[last()]")
	WebElement logTab; // log in view mode and edit mode both 1/2

	@FindBy(xpath = "//div[contains(text(),'FULFILLMENT')]")
	WebElement fulfillmentTab;

	// Notes section
	@FindBy(xpath = "//span[contains(text(),' Add Notes ')]")
	WebElement addNotesButton;

	@FindBy(xpath = "(//*[@placeholder='Add Notes here...'])[1]")
	WebElement notesTextArea;

	@FindBy(xpath = "//section[contains(@class,'note')]//button[span[contains(text(),'Add')]]")
	WebElement notesAddButton;

	// Menu fold unfold icon
	@FindBy(xpath = "//*[@data-icon='menu-fold']")
	WebElement menuIconFold;

	@FindBy(xpath = "//*[@data-icon='menu-unfold']")
	WebElement menuIconUnfold;

	// Status Elements

	@FindBy(xpath = "//*[contains(text(),'ACKNOWLEDGE') or contains(text(),'Acknowledged')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement acknowledgedRadioButton;

	@FindBy(xpath = "//*[contains(text(),'READY FOR PICK UP')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement readyForPickUpRadioButton;

	@FindBy(xpath = "//*[contains(text(),'COMPLETE')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement completeRadioButton;

	@FindBy(xpath = "//*[contains(text(),'Technical')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement technicalRadioButton;

	@FindBy(xpath = "//*[contains(text(),'PCR')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement pcrRadioButton;

	@FindBy(xpath = "//*[contains(text(),'Capture Manager')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement captureManagerRadioButton;

	@FindBy(xpath = "//*[contains(text(),'DPS Playback')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement DPSPlaybackRadioButton;

	@FindBy(xpath = "//*[contains(text(),'Telemundo Center')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement telemundoCenterRadioButton;

	@FindBy(xpath = "//*[contains(text(),'Hair, Makeup & Wardrobe')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement hairMakeupWardrobeRadioButton;

	@FindBy(xpath = "//*[@label-value='Efforting']")
	WebElement effortingStatus;

	@FindBy(xpath = "//*[@label-value='ROFR']")
	WebElement rofrStatus;

	@FindBy(xpath = "//*[@label-value='Booked']")
	WebElement bookedStatus;

	@FindBy(xpath = "//*[contains(text(),'Staging')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement stagingStatus;

	@FindBy(xpath = "//*[contains(text(),'TPM/TM')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement tmtpmStatus;

	@FindBy(xpath = "//*[contains(text(),'DC Fulfillment')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement dcFulfillmentStatus;

	@FindBy(xpath = "//*[contains(text(),'Studio')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement studioStatus;

	@FindBy(xpath = "//*[contains(text(),'Director')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement directorStatus;

	@FindBy(xpath = "//*[contains(text(),'TPS')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement tpsStatus;

	@FindBy(xpath = "//*[contains(text(),'Ingest')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement ingestStatus;

	@FindBy(xpath = "//*[contains(text(),'Entered Into Storm')]/ancestor::div[1]/child::button//*[@data-icon='check-square']")
	WebElement enteredIntoStormStatus;

	// Submitted popup

	@FindBy(xpath = "//*[text()='Request Submitted']")
	WebElement submissionSuccessMessage;

	@FindBy(xpath = "//*[contains(text(),'Published')]")
	WebElement publishSuccessMessage;

	@FindBy(xpath = "//*[contains(text(),'Request was updated successfully')]")
	WebElement updatedSuccessMessage;

	@FindBy(xpath = "//*[contains(text(),'Request was published successfully')]")
	WebElement publishedSuccessMessage;

	@FindBy(xpath = "//*[contains(text(),'Status of the request has been changed to \"Acknowledged\"')]")
	WebElement acknowledgedSuccessMessage;

	@FindBy(xpath = "//*[contains(text(),'Status of the request has been changed to \"Ready For Pick Up\"')]")
	WebElement readyForPickUpSuccessMessage;

	@FindBy(xpath = "//*[contains(text(),'Status of the request has been changed to \"Completed\"')]")
	WebElement completedSuccessMessage;

	@FindBy(xpath = "//*[contains(text(),'Cancellation Requested')]")
	WebElement cancellationRequestSuccessMessage;

	@FindBy(xpath = "//*[contains(text(),'Cancellation Confirmation Sent')] | //*[contains(text(),'Cancellation Confirmed')]")
	WebElement cancelledSuccessMessage;

	@FindBy(xpath = "//*[contains(text(),'The request is cancelled. You can check the status of your request in dashboard')]")
	WebElement premisesRequestCancelledSuccessMessage;

	@FindBy(xpath = "//button/span[text()=' OK ']")
	WebElement closeMessagePopup;

	@FindBy(xpath = "//li[contains(text(),'Extended')]")
	WebElement extendedTab;

	// Cancellation popup Elements
	@FindBy(xpath = "//*[contains(text(),'Are you sure you want to')] | (//*[contains(text(),'Do you Want to cancel this request?')])[2]")
	WebElement cancellationAlertMessage;

	@FindBy(xpath = "//*[contains(text(),'Are you sure to want to send this assingment to STORM')]")
	WebElement sendToStormAlertMessage;

	@FindBy(xpath = "//button[span[text()='Yes']]")
	WebElement cancel_Yes;

	@FindBy(xpath = "//button[span[text()='No']]")
	WebElement cancel_No;

	@FindBy(xpath = "//section[@class='body']//*[text()='Add']")
	WebElement addButton;

	@FindBy(xpath = "//*[@data-id='subheader']//button/i")
	WebElement myRequestDropdownIcon;

	@FindBy(xpath = "//section[@data-id='subheader']//button//i")
	WebElement dashboardDropdownCarrotIcon;

	@FindBy(xpath = "//li//button[text()=' CNBC Production ']")
	WebElement cnbcProductionDashboardInDropdown;

	@FindBy(xpath = "//li//button[text()=' CNBC Crew ']")
	WebElement cnbcCrewDashboardInDropdown;

	@FindBy(xpath = "//li//button[text()=' Digital Crew ']")
	WebElement digitalCrewDashboardInDropdown;

	@FindBy(xpath = "//li//button[text()=' Telemundo Crew ']")
	WebElement telemundoCrewDashboardInDropdown;

	@FindBy(xpath = "//nz-select[@nzplaceholder='Active']//input")
	WebElement myRequestDropdownInputField;

	@FindBy(xpath = "//div[contains(text(),'Fulfilled')]")
	WebElement fulfilledRequestsDropdown;

	@FindBy(xpath = "//div[contains(text(),'All')]")
	WebElement allRequestsDropdown;

	@FindBy(xpath = "//div[contains(text(),'Active')]")
	WebElement activeRequestsDropdown;

	@FindBy(xpath = "//button[contains(text(),'Fulfilled')]")
	WebElement fulfilledRequestsTitle;

	@FindBy(xpath = "//button[contains(text(),'All')]")
	WebElement allRequestsTitle;

	@FindBy(xpath = "//button[contains(text(),'Active')]")
	WebElement activeRequestsTitle;

	// Left Panel Menu icons
	// gearIcon = "//*[text()='Gear']/preceding-sibling::i"
	@FindBy(xpath = "//*[text()='Gear']")
	WebElement gearIcon;

	// Dashboard Elements
	@FindBy(xpath = "//a[contains(@href,'crew-requests/dashboard')]")
	WebElement CrewDashboard;

	@FindBy(xpath = "//a[contains(@href,'gear-requests/dashboard')]")
	WebElement newsDashboard;

	@FindBy(xpath = "//p[text()='Gear']")
	WebElement newsGearDashboardTitle;

	@FindBy(xpath = "//*[text()='Production']")
	WebElement productionIcon;

	@FindBy(xpath = "//a[contains(@href,'production-requests/dashboard')]")
	WebElement ProductionDashboard;

	@FindBy(xpath = "//p[text()='Rock Center Production']")
	WebElement rockProductionDashboardTitle;

	@FindBy(xpath = "//*[text()='Edit & Content Mgmt']")
	WebElement ecmIcon;

	@FindBy(xpath = "//a[contains(@href,'unified-requests/dashboard') and contains(text(),'Dashboard')]")
	WebElement ecmDashboard;

	@FindBy(xpath = "//span[contains(@class,'title') and text()='Edit & Content Mgmt']")
	WebElement ecmDashboardTitleHeader;

	@FindBy(xpath = "//li//button[text()=' Content Management ']")
	WebElement contentManagementDashboardInDropdown;

	@FindBy(xpath = "//li//button[text()=' Edit ']")
	WebElement editRequestDashboardInDropdown;

	@FindBy(xpath = "//li//button[text()=' Edit Self Reporting ']")
	WebElement editSelfReportingDashboardInDropdown;

	@FindBy(xpath = "//div[contains(@class,'title')]//preceding-sibling::button//i[contains(@class,'down')]")
	WebElement dashboardDownIcon;

	// Dashboard Elements
	// @FindBy(xpath = "//a[contains(@href,'production-requests/dashboard') and
	// contains(text(),'CNBC Dashboard')]")
	// WebElement cnbcProductionDashboard;

	@FindBy(xpath = "//div[contains(@class,'title')]//p[text()='CNBC Production']")
	WebElement cnbcProductionDashboardTitle;

	@FindBy(xpath = "//div[contains(@class,'title')]//p[text()='Content Management']")
	WebElement contentManagementDashboardTitle;

	@FindBy(xpath = "//div[contains(@class,'title')]//p[text()='Edit']")
	WebElement editRequestDashboardTitle;

	@FindBy(xpath = "//div[contains(@class,'title')]//p[text()='Edit Self Reporting']")
	WebElement editSelfReportingDashboardTitle;

	@FindBy(xpath = "//*[contains(text(),'No Data ')]")
	WebElement noDataFound;

	// @FindBy(xpath = "(//*[@class='ant-tabs-nav
	// ng-star-inserted']//div[text()='Fulfillment'])[2]")
	// public WebElement fulfillmentTab;

	@FindBy(xpath = "//*[@emptylistmessage='No Requesters Selected']//*[@nztype='link']")
	List<WebElement> additionalRequestersDisplayed;

	@FindBy(xpath = "//*[text()=' Talent ']/../following::*[1]//input")
	WebElement talentInput;

	@FindBy(xpath = "//*[contains(@data-component,'talent')]/*//p[not(contains(@class,'phase-two-job-title'))]")
	List<WebElement> namesInTalentRecords;

	@FindBy(xpath = "//*[contains(@data-component,'talent')]/*//p[contains(@class,'phase-two-job-title')]")
	List<WebElement> jobTitlesInTalentRecords;

	@FindBy(xpath = "//*[@sectionTitle]//*[contains(@class,'button-section')]//i")
	List<WebElement> sectionStatusIcons;

	@FindBy(xpath = "//*[@sectionTitle]//*[contains(@class,'button-section')]//i"
			+ "/ancestor::*[@class='button-section']/following::*[contains(@class,'status-title-area')]//p")
	List<WebElement> sectionNamesHavingStatusIcon;

	@FindBy(xpath = "//*[@sectiontitle='Set Crew']//div[@class='crew-member-title']//div[contains(@class,'title')]")
	List<WebElement> addedSetCrew;

	@FindBy(xpath = "//*[@sectiontitle='Control Room CREW']//div[@class='crew-member-title']//div[contains(@class,'title')]")
	List<WebElement> addedControlRoomCrew;

	@FindBy(xpath = "//*[@sectiontitle='Additional Crew']//div[@class='crew-member-title']//div[contains(@class,'title')]")
	List<WebElement> additionalAddedCrew;

	@FindBy(xpath = "//button[contains(@class,'edit-banner')]//span")
	WebElement editingStateBanner;

	@FindBy(xpath = "//*[@class='bottom-header']//button[@nztype='primary']")
	WebElement cancelButton;

	@FindBy(xpath = "//*[@class='bottom-header']//button[@nztype='primary']/following:: button[1]")
	WebElement discardButton;

	@FindBy(xpath = "//*[@class='note-container']//*[@name='addNotes']")
	WebElement notesInputArea;

	@FindBy(xpath = "//*[@class='submit-button']/button")
	WebElement noteAddButton;

	@FindBy(xpath = "//*[contains(@class,'notes-card')]//div[contains(@class,'top-row')]/p")
	WebElement requesterNoteTag;

	@FindBy(xpath = "//*[contains(@class,'notes-card')]//div[contains(@class,'middle-row')]/p")
	List<WebElement> noteDisplayed;

	@FindBy(xpath = "//*[contains(@class,'statusText')]")
	WebElement requestStatus;

	@FindBy(xpath = "//*[contains(@class,'bottom-row')]//*[@nztype='edit']")
	WebElement editButtonDisplayed;

	@FindBy(xpath = "//*[contains(@class,'bottom-row')]//*[@nztype='save']")
	WebElement noteSavebutton;

	@FindBy(xpath = "//*[@forminputname='editNote']//textarea")
	WebElement textArea;

	@FindBy(xpath = "//*[contains(@class,'bottom-row')]//*[@nztype='delete']")
	WebElement deleteButton;

	@FindBy(xpath = "//div[contains(@class,'popover-buttons')]/button[2]")
	WebElement okButton;

	@FindBy(xpath = "(//*[@class='ant-tabs-nav ng-star-inserted']//div[text()='Notes'])[2]")
	public WebElement fulfillmentNotes;

	@FindBy(xpath = "(//*[@class='ant-tabs-nav ng-star-inserted']//div[text()='Log'])[2]")
	public WebElement fulfillmentLog;

	@FindBy(xpath = "//*[@class='edit-button-area']//span[contains(text(),'Save')]")
	public WebElement saveButtonOnRequest;

	@FindBy(xpath = "//*[@sectiontitle='Resources']//span[text()=' View Estimated Cost Breakdown ']//parent::button")
	public WebElement viewEstimatedCostBreakdown;

	@FindBy(xpath = "//form-input-number//label[text()=' Camera Ops ']//parent::*[1]//following-sibling::*[1]//*[@class='ant-input-number-handler ant-input-number-handler-up']")
	WebElement cameraOpsUp;

	@FindBy(xpath = "//form-input-number//label[text()=' Audio Ops ']//parent::*[1]//following-sibling::*[1]//*[@class='ant-input-number-handler ant-input-number-handler-up']")
	WebElement audioOpsUp;

	@FindBy(xpath = "//form-input-number//label[text()=' Utility Ops ']//parent::*[1]//following-sibling::*[1]//*[@class='ant-input-number-handler ant-input-number-handler-up']")
	WebElement utilityOpsUp;

	@FindBy(xpath = "//*[@sectiontitle='Resources']//p[text()='Estimated Cost:']//parent::div[1]//following-sibling::div/p")
	WebElement estimatedCost;

	@FindBy(xpath = "//p[text()='Estimated Cost']//following-sibling::p")
	WebElement calculatorOverlayEstimatedCost;

	@FindBy(xpath = "//*[@sectiontitle='Resources']//div[@class='requested-resources ng-star-inserted']/p")
	WebElement resourceIncreaseNotificationMsg;

	@FindBy(xpath = "//*[@sectiontitle='Resources']//div[@class='disclaimer-row ant-row ng-star-inserted']/p")
	WebElement disclaimerMsg;

	@FindBy(xpath = "//button//*[text()=' OK ']")
	WebElement alertMsgOkBtn;

	@FindBy(xpath = "//*[@class='ant-drawer-wrapper-body']//div[text()='Calculator']")
	WebElement calculatorOverlay;

	@FindBy(xpath = "(//div[@class='ant-drawer-content-wrapper']//button[@aria-label='Close'])[3]")
	WebElement calculatorOverlayCloseBtn;

	@FindBy(xpath = "//*[@sectiontitle='Resources']//span[text()=' View Estimated Cost Breakdown ']")
	WebElement costBreakdownBtn;

	@FindBy(xpath = "//*[@sectiontitle='Override Info']//*[@class='ant-select-selection-search ng-star-inserted']//input")
	WebElement resourceReason;

	@FindBy(xpath = "//form-textarea[@forminputname='resourceDescription']//nz-form-control//textarea[@placeholder='Add Resources Description here']")
	WebElement resourceReasonDesc;

	@FindBy(xpath = "(//*[@role='tablist']//*[@role='tab'])[2]")
	WebElement logsTab;

	@FindBy(xpath = "(//*[@role='tablist']//*[@role='tab'])[1]")
	WebElement noteTab;

	@FindBy(xpath = "//*[@class='top-row']//*[contains(@class,'phase-two-status')]")
	List<WebElement> logStatus;

	@FindBy(xpath = "//*[@class='middle-row']/p")
	WebElement logDetail;

	@FindBy(xpath = "//*[@role='tablist']//div//*[text()='STATUS']")
	List<WebElement> statusTabFulfilment;

	@FindBy(xpath = "//div[@class='edit-button-area']/button")
	List<WebElement> editButtonOnFrom;

	@FindBy(xpath = "//*[contains(@class,'revised ant-card-bordered')]")
	WebElement revisedNote;

	@FindBy(xpath = "//*[@label='Request For']//input //ancestor::nz-select-top-control")
	WebElement revisedRequestFor;

	@FindBy(xpath = "//*[@label='Air Platform']//input/ancestor::nz-select-top-control")
	WebElement revisedAirPlatform;

	@FindBy(xpath = "(//*[@placeholder='Select Date'])[1]//input/ancestor::nz-date-picker")
	WebElement revisedStartDate;

	@FindBy(xpath = "//*[@forminputname='startTime']//input/ancestor::nz-time-picker")
	WebElement revisedStartTime;

	@FindBy(xpath = "//*[@forminputname='endTime']//input/ancestor::nz-time-picker")
	WebElement revisedEndTime;

	@FindBy(xpath = "//*[@forminputname='budgetCode']//input")
	WebElement revisedBudgetCode;

	@FindBy(xpath = "//*[@label='Location']//input/ancestor::nz-select-top-control")
	WebElement revisedLocation;

	@FindBy(xpath = "//*[@label='Set Location']//input/ancestor::nz-select-top-control")
	WebElement revisedSetLocation;

	@FindBy(xpath = "//*[@label='Set Crew']//nz-select//nz-select-top-control")
	WebElement revisedSetCrew;

	@FindBy(xpath = "//*[@label='Control Room Location']//input//ancestor::nz-select-top-control")
	WebElement revisedControlRoomLocation;

	@FindBy(xpath = "//*[@label='Control Room']//input//ancestor::nz-select-top-control")
	WebElement revisedControlRoom;

	@FindBy(xpath = "//*[@label='Control Room Crew']//nz-select/nz-select-top-control")
	WebElement revisedControlRoomCrew;

	@FindBy(xpath = "//*[@label='Additional Crew']//nz-select/nz-select-top-control")
	WebElement revisedAdditionalCrew;

	@FindBy(xpath = "//div[contains(text(),'Ultimatte')]/ancestor::div[1]//input/ancestor::nz-input-number")
	WebElement revisedUltimatte;

	@FindBy(xpath = "//div[contains(text(),'Voice Activated Prompter')]/ancestor::div[1]//input/ancestor::nz-input-number")
	WebElement revisedVoicePromp;

	@FindBy(xpath = "//*[@label='Details & Notes']//textarea | //*[@label='Details and Notes']//textarea")
	WebElement revisedDetailsAndNotes;

	@FindBy(xpath = "//*[contains(text(),' Set Background ')]//following::nz-select-top-control[1]")
	WebElement revisedSetBackgroundDropdown;

	@FindBy(xpath = "//*[@forminputname='setStagingNeeded']//label[@label-value='false']")
	WebElement setStagingNeeded_No;

	@FindBy(xpath = "//*[@forminputname='setStagingNeeded']//label[@label-value='true']")
	WebElement setStagingNeeded_Yes;

	@FindBy(xpath = "//*[@forminputname='ingest']//label[@label-value='true']")
	WebElement ingest_Yes;

	@FindBy(xpath = "//*[@forminputname='ingest']//label[@label-value='false']")
	WebElement ingest_No;

	@FindBy(xpath = "//*[@forminputname='iso']//label[@label-value='true']")
	WebElement iso_Yes;

	@FindBy(xpath = "//*[@forminputname='iso']//label[@label-value='false']")
	WebElement iso_No;

	@FindBy(xpath = "//*[@class='talent-card']//div[contains(@class,'changed-border')]")
	WebElement revisedTalent;

	@FindBy(xpath = "//*[@sectiontitle='Talent']//*[@class='phase-two-row-label']/../following::*[1]//p")
	List<WebElement> talentNamesInTalentSectionInReadOnlyMode;

	@FindBy(xpath = "//*[@sectiontitle='Talent']//*[@class='phase-two-row-label']")
	List<WebElement> labelsInTalentSectionInReadOnlyMode;

	@FindBy(xpath = "//*[@sectiontitle='STATUS']//*[@class='status-title']//i")
	WebElement statusIconInStatusSection;

	@FindBy(xpath = "//*[@sectiontitle='STATUS']//*[@class='status-title']//p")
	WebElement statusTitleInStatusSection;

	@FindBy(xpath = "//*[contains(@class,'ant-select-item-option-content')]//span")
	List<WebElement> talentOptions;

	@FindBy(xpath = "//*[@sectiontitle='Requester(s)']//*[contains(@class,'display-name')]")
	List<WebElement> requesterNames;

	@FindBy(xpath = "//*[@sectiontitle='Requester(s)']//*[contains(@class,'job-title')]")
	List<WebElement> requesterJobTitles;

	private String estimateCost = "";
	private String intialEstimateCost = "";
	private String finalEstimateCost = "";
	public int NumberOfLogs;

	@FindBy(xpath = "//i[contains(@class,'anticon-loading')]")
	List<WebElement> loadingIconInRequestersList;

	@FindBy(xpath = "//i[contains(@class,'anticon-loading')]")
	List<WebElement> loadingIconInTalentList;

	@FindBy(xpath = "//*[text()='EDITING ']")
	WebElement editingStatus;

	@FindBy(xpath = "//*[@class='edit-button-area']//span[contains(text(),'Save')]")
	WebElement saveButton;

	@FindBy(xpath = "//*[@class='button-row ng-star-inserted']//span[contains(text(),'Publish')]")
	WebElement publishButton;

	@FindBy(xpath = "//*[contains(@class,'ant-modal-confirm-title')]//span")
	WebElement modalTitleAfterClickingSave;

	@FindBy(xpath = "//*[contains(@class,'ant-modal-confirm-title')]//span")
	List<WebElement> modalTitleAfterClickingSubmit;

	@FindBy(xpath = "//*[text()='Discard Changes ']/ancestor::button")
	WebElement discardChangesButton;

	@FindBy(xpath = "//i[contains(@class,'anticon-edit')]")
	List<WebElement> editIcons;

	@FindBy(xpath = "//*[contains(@class,'ant-drawer-open')]//*[@data-icon='close']/ancestor::button")
	List<WebElement> closeLogDrawerButton;

	@FindBy(xpath = "//*[@class='ant-drawer-body']//*[@class='middle-row']/p")
	List<WebElement> displayedLogs;

	@FindBy(xpath = "//*[@sectiontitle='Requester(s)']//i[contains(@class,'anticon-delete')]/ancestor::*[contains(@class,'delete-icon')]/..//*[1]//span")
	List<WebElement> addedRequesterNamesInEditMode;

	@FindBy(xpath = "//*[@sectiontitle='Requester(s)']//button[contains(@class,'delete')]")
	List<WebElement> deleteIconForaddedRequesterNamesInEditMode;

	@FindBy(xpath = "//*[@sectiontitle='Talent']//i[contains(@class,'anticon-delete')]/../../..//*[1]//p")
	List<WebElement> addedTalentNamesInEditMode;

	@FindBy(xpath = "//*[@sectiontitle='Talent']//button[contains(@class,'delete')]")
	List<WebElement> deleteIconsForAddedTalentNamesInEditMode;

	@FindBy(xpath = "//*[text()='Unlock This Record']/ancestor::button")
	List<WebElement> unlockButton;

	@FindBy(xpath = "//*[@role='tablist']//*[@role='tab']")
	List<WebElement> tabsInRightContainer;

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	WebElement submitButton;

	@FindBy(xpath = "//*[contains(@class,'note-container')]//textarea[@name='addNotes']")
	WebElement requestNotesTextarea;

	@FindBy(xpath = "//*[contains(@class,'notes-card')]//textarea")
	WebElement requestNotesTextareaInEditMode;

	@FindBy(xpath = "//*[contains(@class,'note-container')]//*[contains(text(),'+ Add')]/ancestor::button")
	WebElement addRequestNotesButton;

	@FindBy(xpath = "//*[contains(@class,'note-container')]//*[contains(@class,'anticon-edit')]/ancestor::button")
	List<WebElement> editNoteButtons;

	@FindBy(xpath = "//*[contains(@class,'note-container')]//*[contains(@class,'anticon-delete')]/ancestor::button")
	List<WebElement> deleteNoteButtons;

	@FindBy(xpath = "//*[contains(@class,'notes-card')]//*[contains(@class,'anticon-save')]/ancestor::button")
	WebElement saveNoteButtonInEditMode;

	@FindBy(xpath = "//div[contains(text(),'NOTES')]")
	List<WebElement> notesTabs;

	@FindBy(xpath = "//*[contains(text(),'Yes')]/ancestor::button")
	WebElement yesButtonInModalConfirmation;

	@FindBy(xpath = "//*[contains(text(),'No')]/ancestor::button")
	WebElement noButtonInModalConfirmation;

	@FindBy(xpath = "//*[contains(text(),'OK')]/ancestor::button")
	WebElement okButtonInModalConfirmation;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Confirm Cancellation')]/ancestor::button"),
			@FindBy(xpath = "//*[contains(text(),'Confirm Cancel Request')]/ancestor::button") })
	WebElement confirmCancelRequestButton;

	@FindBy(xpath = "//*[contains(text(),'Cancel Request')]/ancestor::button")
	WebElement cancelRequestButton;

	@FindBy(xpath = "//*[contains(@class,'ant-select-item') and text()]")
	List<WebElement> dropdownOptions;

	@FindBy(xpath = "//label[text()=' Req same as Producer? ']/ancestor::nz-form-label/following::input[1]")
	WebElement reqSameAsProducerCheckbox;

	@FindBy(xpath = "//label[text()=' Producer ']/ancestor::nz-form-label/following::input[1]")
	WebElement producerInput;

	@FindBy(xpath = "//label[text()=' Sr. Producer/Approver ']/ancestor::nz-form-label/following::input[1]")
	WebElement seniorProducerInput;

	@FindBy(xpath = "//*[contains(@class,'pagination')]//li[contains(@title,'Previous Page')]")
	WebElement paginationPreviousPage;

	@FindBy(xpath = "//*[contains(@class,'pagination')]//li[contains(@title,'1')]")
	WebElement pagination1Page;

	@FindBy(xpath = "//*[contains(@class,'pagination')]//li[contains(@title,'Next Page')]")
	WebElement paginationNextPage;

	@FindBy(xpath = "//*[contains(@class,'pagination')]//*[contains(@title,'20 / page')]")
	WebElement pagination20PerPage;

	@FindBy(xpath = "//*[contains(text(),'Go to')]")
	WebElement paginationGoToPage;

	@FindBy(xpath = "//i//*[local-name()='svg' and  @data-icon='clear']")
	WebElement clearButtonWebElement;

	private List<NoteRecord> currentlyDisplayedRequestNotes;

	public void setCurrentlyDisplayedRequestNotes(List<NoteRecord> notes) {
		this.currentlyDisplayedRequestNotes = notes;
	}

	public List<NoteRecord> getCurrentlyDisplayedRequestNotes() {
		if (currentlyDisplayedRequestNotes == null) {
			currentlyDisplayedRequestNotes = new ArrayList<>();
			Constants.getRequestNotes().forEach((note) -> {
				String noteCreatorDuplicate = new String(note.getNoteCreator());
				String noteContentDuplicate = new String(note.getNoteContent());
				LocalDateTime dateTimeDuplicate = LocalDateTime.parse(note.getDateTime().toString());
				NoteRecord noteDuplicate = new NoteRecord(note.getUserRole(), dateTimeDuplicate, noteCreatorDuplicate,
						noteContentDuplicate);
				currentlyDisplayedRequestNotes.add(noteDuplicate);
			});
		}
		return currentlyDisplayedRequestNotes;
	}

	WebDriver driver = DriverFactory.getCurrentDriver();

	public ProducerDashboardGeneralPage() {
		PageFactory.initElements(DriverFactory.getCurrentDriver(), this);
	}

	/**
	 * To verify Request form page loaded
	 *
	 * @param formName - request form name
	 * @throws Exception
	 */
	public void verifySelectedRequestPageDisplayed(String formName) throws Exception {
		// Waits.waitForElement(slugTextArea, WAIT_CONDITIONS.CLICKABLE);
		Waits.waitForElement(statusSection, WAIT_CONDITIONS.VISIBLE);
		switch (formName.toUpperCase()) {
		case "DIGITAL JOURNALIST / DJ SHOOT":
			formName = "Digital Journalist / DJ Shoot Crew";
			break;
		case "TELEMUNDO NEWS":
			formName = "Telemundo Crew";
			break;
		case "NBC BREAKING NEWS":
			formName = "Breaking News Crew";
			break;
		case "NBC BUREAU CAMERA":
			formName = "Bureau Camera Crew";
			break;
		case "STANDARD EDIT":
		case "LONG EDIT":
			formName = "Edit Request";
			break;
		}
		CommonValidations.verifyTextValue(formTitle, formName);
	}

	/**
	 * To verify additional requester added in the form
	 *
	 * @param additionalRequestor- additional requester name
	 */
	public void verifyAdditionalRequester(String additionalRequestor) {
		String[] additionalRequestorList;
		String displayedName = null;
		try {
			if (additionalRequestor != null) {
				if (additionalRequestor.contains("-")) {
					additionalRequestorList = additionalRequestor.split("-");
				} else {
					additionalRequestorList = additionalRequestor.split(" ");
				}
				for (int i = 1; i < additionalRequestersDisplayed.size(); i++) {
					displayedName = WebAction.getText(additionalRequestersDisplayed.get(i));
					Assert.assertEquals(displayedName, additionalRequestorList[i - 1]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void enterDetailsAndNotes(String DetailsAndNotesText) throws Exception {
		if (DetailsAndNotesText != null) {
			Waits.waitForElement(detailsAndNotesTextarea, WAIT_CONDITIONS.CLICKABLE);
			WebAction.sendKeys(detailsAndNotesTextarea, DetailsAndNotesText);
		}
	}

	public void selectEndTime(String endTimeText) throws Exception {
		// To fill end Time
		if (endTimeText != null) {
			WebAction.click(endTime);
			Constants.setEndTime(generateTime(endTimeText, "hh:mm a"));
			WebAction.sendKeys(endTime, generateTime(endTimeText, "hh:mm a"));
			WebAction.keyPress(endTime, "Enter");
		}
	}

	public void selectStartTime(String startTimeText) throws Exception {
		// To fill start Time
		if (startTimeText != null) {
			WebAction.click(startTime);
			Constants.setStartTime(generateTime(startTimeText, "hh:mm a"));
			WebAction.sendKeys(startTime, generateTime(startTimeText, "hh:mm a"));
			WebAction.keyPress(startTime, "Enter");
		}
	}

	public void selectPrepCallTime(String prepCallTimeText) throws Exception {
		// To fill call time/prepTime
		if (prepCallTimeText != null) {
			WebAction.click(callTimePrepTime);
			Constants.setPrepTime(generateTime(prepCallTimeText, "hh:mm a"));
			WebAction.sendKeys(callTimePrepTime, generateTime(prepCallTimeText, "hh:mm a"));
			WebAction.keyPress(callTimePrepTime, "Enter");
		}
	}

	public void selectStartDate(String startDateText) throws Exception {
		// To fill start Date
		if (startDateText != null) {
			// WebAction.click(dates.get(0));
			WebAction.click(startDate);
			Constants.setStartDate(generateDate(startDateText, "MM/dd/yyyy"));
			WebAction.sendKeys(startDate, generateDate(startDateText, "MM/dd/yyyy"));
			WebAction.keyPress(startDate, "Enter");
		}
	}

	public void enterShow(String showText) throws InterruptedException, Exception {
		WebAction.scrollIntoView(showInfoSection);
		// To enter show unit value
		if (showText != null) {
			String showTitleTextArrayList[];
			if (showText.contains(",")) {
				showTitleTextArrayList = showText.split(",");
			} else {
				showTitleTextArrayList = new String[1];
				showTitleTextArrayList[0] = showText;
				Constants.setShowUnit(showTitleTextArrayList[0]);
			}
			for (int i = 0; i < showTitleTextArrayList.length; i++) {
				WebAction.sendKeys(showInputBox,
						showTitleTextArrayList[i].trim().substring(0, showTitleTextArrayList[i].length() - 1));
				Waits.waitForAllElements(SearchList, WAIT_CONDITIONS.VISIBLE);
				Waits.waitUntilElementSizeGreater(SearchList, 0);
				Waits.waitForElement(SearchList.get(0), WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(SearchList.get(0));
				ReportGenerate.test.log(Status.INFO,
						"User enters show unit as " + showTitleTextArrayList[i].trim() + " in form");
				Thread.sleep(500);
			}

			String formType = Constants.getFormType();
			if (formType.equalsIgnoreCase("NBC News") || formType.equalsIgnoreCase("CNBC Crew")
					|| formType.equalsIgnoreCase("Digital Journalist / DJ Shoot")
					|| formType.equalsIgnoreCase("Telemundo News")) {
				List<String> showNameStringList = new ArrayList<>();
				List<String> budgetCodeNameStringList = new ArrayList<>();
				for (int i = 0; i < showTitleTextArrayList.length; i++) {
					String showNameXpath = "((//*[@sectiontitle='Show Info']//div[contains(@class,'display-container')]//div[contains(@class,'title')])[<<ShowSlNo>>]/div/div/p)[1]";
					String showNameNewXpath = showNameXpath.replace("<<ShowSlNo>>", Integer.toString(i + 1));
					WebElement showNameWebElement = driver.findElement(By.xpath(showNameNewXpath));
					String showName = WebAction.getText(showNameWebElement).trim();
					showNameStringList.add(showName);
					Constants.setMultipleShowUnits(showNameStringList);
					String budgetCodeNameXpath = "((//*[@sectiontitle='Show Info']//div[contains(@class,'display-container')]//div[contains(@class,'title')])[<<BudgetCodeSlNo>>]/div/div/p)[2]";
					String budgetCodeNameNewXpath = budgetCodeNameXpath.replace("<<BudgetCodeSlNo>>",
							Integer.toString(i + 1));
					WebElement budgetCodeNameWebElement = driver.findElement(By.xpath(budgetCodeNameNewXpath));
					String budgetCodeName = WebAction.getText(budgetCodeNameWebElement).trim();
					budgetCodeNameStringList.add(budgetCodeName);
					Constants.setMultipleBudgetCodes(budgetCodeNameStringList);
				}
			}
		}
	}

	public void selectAirPlatform(String airPlatformText) throws Exception {
		WebAction.scrollIntoView(showInfoSection);
		// To select air platform type
		if (airPlatformText != null) {
			boolean valuePresent = false;
			WebAction.clickUsingJs(airPlatformDropDown);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (WebElement ele : dropDownvalues) {
				if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(airPlatformText)) {
					WebAction.click(ele);
					valuePresent = true;
					emailValidationAirPlatform(Constants.getFormName(), airPlatformText, Constants.getRequestStatus());

					break;
				}
			}
			if (valuePresent == false)
				throw new Exception(
						"'" + airPlatformText + "' value is not present in the air platform type drop down");
		}
	}

	/**
	 * To add the DLs to corresponding forms
	 * 
	 * @param formName
	 * @param airPlatformText
	 * @param requestStatus2
	 * @throws Exception
	 */
	private void emailValidationAirPlatform(String formName, String airPlatformText, RequestStatus requestStatus2)
			throws Exception {
		switch (formName.toUpperCase()) {
		case "SINGLE CAMERA LIVE SHOT":
		case "EXTEND OR BRIDGE CREW & FACILITIES":
		case "ROCK CENTER":
			if (airPlatformText.equals("Video Conference")) {
				emailtoList.add(ConfigFileReader.getProperty("prodreq-videoconfairplatform", "emailconfig.properties"));
			} else {
				try {
					emailtoList.remove(
							ConfigFileReader.getProperty("prodreq-videoconfairplatform", "emailconfig.properties"));
				} catch (Exception e) {
				}
				/*
				 * ListIterator<String> listIterator = emailtoList.listIterator(); while
				 * (listIterator.hasNext()) { int position = listIterator.nextIndex();
				 * 
				 * // ListIterator used for replacing the // value if
				 * (listIterator.toString().equals("Video Conference")) { listIterator.set("");
				 * } listIterator.next(); }
				 */
			}
			break;
		case "CNBC":
			break;
		case "ANIMALS ON PREMISES":
		case "FIREARMS ON PREMISES":
			break;
		}

	}

	/**
	 * To generate date based on input. Date should like CurrebDate+1,
	 * CurrentDate-2, etc.,
	 * 
	 * @param date   - date
	 * @param format - date format
	 * @throws Exception
	 */
	public String generateDate(String date, String format) throws Exception {
		String updateddate = "";
		try {
			if (date.trim().length() > 0) {
				if (date.toUpperCase().contains("CURRENTDATE")) {
					String days = date.replaceAll("[a-zA-Z]", "").trim();
					if (days.length() == 0) {
						days = "0";
					}
					updateddate = DateFunctions.addOrMinusDateFromCurrentDate(format, days);
				} else
					throw new Exception("Please provide date in valid format");
			} else
				throw new Exception("Date is empty");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return updateddate;
	}

	/**
	 * To generate time based on input. Time should like CurrentTime+1,
	 * CurrentTime-2, etc.,
	 * 
	 * @param time   - time
	 * @param format - time format
	 * @return
	 * @throws Exception
	 */
	public String generateTime(String time, String format) throws Exception {
		String updatedTime = "";
		try {
			if (time.trim().length() > 0) {
				if (time.toUpperCase().contains("CURRENTTIME")) {
					String hours = time.replaceAll("[a-zA-Z]", "").trim();
					if (hours.length() == 0) {
						hours = "0";
					}
					updatedTime = DateFunctions.addOrMinusTimeFromCurrentTime(format, hours);
				} else
					updatedTime = time;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return updatedTime;
	}

	public void setCrewTextAddition(String setCrewText) throws Exception {
		WebAction.clickUsingJs(setCrew);
		String[] setCrewArrayList = null;

		if (setCrewText != null) {
			if (setCrewText.contains(",")) {
				setCrewArrayList = setCrewText.split(",");
			} else {
				setCrewArrayList = setCrewText.split(" ");
			}

			for (String setCrewoption : setCrewArrayList) {
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(setCrewoption)) {
						WebAction.click(ele);
						break;
					}
				}

			}
		}
	}

	/**
	 * To verify application all section is incomplete
	 *
	 * @param sectionName - section name
	 * @throws Exception
	 */
	public void verifySectionNameHighlightedInRedColor(String sectionName) throws Exception {
		try {
			// WebAction.scrollIntoView(statusSection);
			String sectionIconXpath = "";
			switch (sectionName.toUpperCase()) {
			case "GENERAL DETAILS":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "GENERAL DETAILS");
				break;
			case "PRODUCTION PURPOSE":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "PRODUCTION PURPOSE");
				break;
			case "SHOW INFO":
			case "SHOW INFORMATION":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "SHOW INFO");
				break;
			case "SET LOCATION":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "SET LOCATION");
				break;
			case "CONTROL ROOM":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "CONTROL ROOM");
				break;
			case "HANDLER(S) INFORMATION":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "HANDLER(S) INFORMATION");
				break;
			case "ANIMAL(S) INFORMATION":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "ANIMAL(S) INFORMATION");
				break;
			case "FIREARM(S) INFORMATION":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "FIREARM(S) INFORMATION");
				break;
			case "SET INFORMATION":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "SET INFORMATION");
				break;
			case "SET LOCATION & CREW":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "SET LOCATION & CREW");
				break;
			case "CONTROL ROOM & CREW":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "CONTROL ROOM & CREW");
				break;
			case "PRODUCER DETAILS":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "PRODUCER DETAILS");
				break;
			case "FIELD CONTACT":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "FIELD CONTACT");
				break;
			case "SHOOT DETAILS":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "SHOOT DETAILS");
				break;
			case "SHOOT SPECS":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "SHOOT SPECS");
				break;
			case "SHOOT LOCATION":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "SHOOT LOCATION");
				break;
			case "DATE & TIME":
			case "DATE & TIME NEEDED":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "DATE & TIME");
				break;
			case "GEAR USER":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "GEAR USER");
				break;
			case "LOCATION":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "LOCATION");
				break;
			case "GEAR":
				String sectionIconString = "(//*[contains(text(),'<<SectionName>>')]/ancestor::div[2]/div/button/i)[2]";
				sectionIconXpath = sectionIconString.replace("<<SectionName>>", "GEAR");
				break;
			case "USAGE":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "USAGE");
				break;
			case "SESSION DETAILS":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "SESSION DETAILS");
				break;
			case "EDIT TYPE":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "EDIT TYPE");
				break;
			case "SOURCE":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "SOURCE");
				break;
			case "DESTINATION":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "DESTINATION");
				break;
			case "CONTENT DESCRIPTION":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "CONTENT DESCRIPTION");
				break;
			case "STAGING":
				sectionIconXpath = sectionIcon.replace("<<SectionName>>", "STAGING");
				break;
			}
			CommonValidations.verifyAttributeValue(driver.findElement(By.xpath(sectionIconXpath)), "class", "close");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify general details info section missing field error message
	 *
	 * @throws Exception
	 */
	public void verifyGeneralDetailsInfoMissingFieldError(String divisionErrorMessage) throws Exception {
		try {
			CommonValidations.verifyTextValue(divisionError, divisionErrorMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify Production Purpose details info section missing field error message
	 *
	 * @throws Exception
	 */
	public void verifyProductionPurposeInfoMissingFieldError(String requestForErrorMessage) throws Exception {
		try {
			CommonValidations.verifyTextValue(requestForError, requestForErrorMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify show info section missing field error message
	 *
	 * @throws Exception
	 */
	public void verifyShowInfoMissingFieldError(String airPlatformErrorMessage, String showUnitErrorMessage,
			String budgetCodeErrorMessage, String startDateErrorMessage, String startTimeErrorMessage,
			String endTimeErrorMessage) throws Exception {
		WebAction.scrollIntoView(showInfoSection);
		try {
			airPlatformErrorMessage(airPlatformErrorMessage);
			showUnitErrorMessage(showUnitErrorMessage);
			budgetCodeErrorMessage(budgetCodeErrorMessage);
			startDateErrorMessage(startDateErrorMessage);
			startTimeErrorMessage(startTimeErrorMessage);
			endTimeErrorMessage(endTimeErrorMessage);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify show info section missing field error message
	 *
	 * @throws Exception
	 */
	public void verifyShowInfoMissingFieldErrorFireArmAndAnimalPremises(String airPlatformErrorMessage,
			String showUnitErrorMessage, String arrivalDateErrorMessage, String arrivalTimeErrorMessage,
			String departureDateErrorMessage, String departureTimeErrorMessage) throws Exception {
		WebAction.scrollIntoView(showInfoSection);
		try {
			airPlatformErrorMessage(airPlatformErrorMessage);
			showUnitErrorMessage(showUnitErrorMessage);
			arrivalDateErrorMessage(arrivalDateErrorMessage);
			arrivalTimeErrorMessage(arrivalTimeErrorMessage);
			departureDateErrorMessage(departureDateErrorMessage);
			departureTimeErrorMessage(departureTimeErrorMessage);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void arrivalDateErrorMessage(String arrivalDateErrorMessage) {
		CommonValidations.verifyTextValue(arrivalDateError, arrivalDateErrorMessage);
	}

	public void arrivalTimeErrorMessage(String arrivalTimeErrorMessage) {
		CommonValidations.verifyTextValue(arrivalTimeError, arrivalTimeErrorMessage);
	}

	public void departureDateErrorMessage(String departureDateErrorMessage) {
		CommonValidations.verifyTextValue(departureDateError, departureDateErrorMessage);
	}

	public void departureTimeErrorMessage(String departureTimeErrorMessage) {
		CommonValidations.verifyTextValue(departureTimeError, departureTimeErrorMessage);
	}

	public void endTimeErrorMessage(String endTimeErrorMessage) {
		CommonValidations.verifyTextValue(endTimeError, endTimeErrorMessage);
	}

	public void startTimeErrorMessage(String startTimeErrorMessage) {
		CommonValidations.verifyTextValue(startTimeError, startTimeErrorMessage);
	}

	public void startDateErrorMessage(String startDateErrorMessage) {
		CommonValidations.verifyTextValue(startDateError, startDateErrorMessage);
	}

	public void budgetCodeErrorMessage(String budgetCodeErrorMessage) {
		CommonValidations.verifyTextValue(budgetCodeError, budgetCodeErrorMessage);
	}

	public void showUnitErrorMessage(String showUnitErrorMessage) {
		CommonValidations.verifyTextValue(showUnitError, showUnitErrorMessage);
	}

	public void airPlatformErrorMessage(String airPlatformErrorMessage) {
		CommonValidations.verifyTextValue(airPlatformError, airPlatformErrorMessage);
	}

	public void setLocationErrorMessage(String setLocationErrorMessage) {
		CommonValidations.verifyTextValue(setLocationError, setLocationErrorMessage);
	}

	public void locationErrorMessage(String locationErrorMessage) {
		CommonValidations.verifyTextValue(locationError, locationErrorMessage);
	}

	public void controlRoomErrorMessage(String controlRoomErrorMessage) {
		CommonValidations.verifyTextValue(controlRoomError, controlRoomErrorMessage);
	}

	public void controlRoomLocationErrorMessage(String controlRoomLocationErrorMessage) {
		CommonValidations.verifyTextValue(controlRoomLocationError, controlRoomLocationErrorMessage);
	}

	/**
	 * To verify set location section missing field error message
	 *
	 * @throws Exception
	 */
	public void verifySetLocationMissingFieldError(String locationErrorMessage, String setLocationErrorMessage)
			throws Exception {
		WebAction.scrollIntoView(setLocationSection);
		try {
			locationErrorMessage(locationErrorMessage);
			setLocationErrorMessage(setLocationErrorMessage);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addShowInfo(String airPlatformText, String showText, String startDateText, String prepTimeText,
			String startTimeText, String endTimeText) throws Exception {
		try {
			// WebAction.scrollIntoView(airPlatformDropDown);
			WebAction.scrollIntoView(talentSection);
			selectAirPlatform(airPlatformText);
			enterShow(showText);
			selectStartDate(startDateText);
			selectPrepCallTime(prepTimeText);
			selectStartTime(startTimeText);
			selectEndTime(endTimeText);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void selectDivision(String divisionText) {
		try {
			emailValidation(Constants.getFormType(), divisionText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebAction.scrollIntoView(statusSection);
		if (divisionText != null) {
			// To select Division type
			try {
				if (divisionText != null && (!(divisionText.contains("Universal Kids")))) {
					boolean valuePresent = false;
					WebAction.clickUsingJs(divisionTypeDropDown);
					Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
					for (WebElement ele : dropDownvalues) {
						if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(divisionText)) {
							WebAction.click(ele);
							valuePresent = true;
							break;
						}
					}
					if (valuePresent == false)
						throw new Exception(
								"'" + divisionText + "' value is not present in the Division type drop down");
				} else {
					WebAction.sendKeys(divisionTypeDropDown, divisionText);
					WebAction.keyPress(divisionTypeDropDown, "Enter");
				}
				Constants.setDivision(divisionText);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * To add/remove dls based on form and divisions for all requests
	 * 
	 * @param formName
	 * @param divisionText
	 * @throws Exception
	 */
	private void emailValidation(String formName, String divisionText) throws Exception {
		switch (formName.toUpperCase()) {
		case "FIREARMS ON PREMISES":
		case "ANIMALS ON PREMISES":
		case "CNBC":
			emailtoList.add(ConfigFileReader.getProperty("Gmail-UserName"));
			break;
		case "SINGLE CAMERA LIVE SHOT":
		case "EXTEND OR BRIDGE CREW & FACILITIES":
		case "ROCK CENTER":
			emailtoList.add(ConfigFileReader.getProperty("Gmail-UserName"));
			workingEmailtoList.add(ConfigFileReader.getProperty("Gmail-UserName"));
			String divisionName = divisionText.toLowerCase().replace(" ", "").trim();

			if (!divisionName.equalsIgnoreCase("acorn") || divisionName.equalsIgnoreCase("ERGEvents")
					|| divisionName.equalsIgnoreCase("NBCNewsStudios") || divisionName.equalsIgnoreCase("Olympics")) {
				emailtoList.add(ConfigFileReader.getProperty(
						"division-" + divisionText.toLowerCase().replace(" ", "").trim(), "emailconfig.properties"));
			}
			break;
		}

	}

	/**
	 * To add additional requesters in the form
	 * 
	 * @param additionalRequestor
	 * @throws Exception
	 */
	public void additionalRequestersListInfo(String additionalRequestor) throws Exception {
		WebAction.scrollIntoView(generaldetailsSection);
		try {
			String[] additionalRequestersArrayList;
			WebElement defaultRequesterWebElement = driver.findElement(
					By.xpath("//*[contains(@emptylistmessage,'No Requesters Selected')]/div/div[1]//span"));
			Waits.waitForElement(defaultRequesterWebElement, WAIT_CONDITIONS.VISIBLE);
			String defaultRequesterName = WebAction.getText(defaultRequesterWebElement).trim();
			Constants.setDefaultRequesterName(defaultRequesterName);
			if (additionalRequestor != null) {
				if (additionalRequestor.contains("-")) {
					additionalRequestersArrayList = additionalRequestor.split("-");
				} else {
					additionalRequestersArrayList = new String[1];
					additionalRequestersArrayList[0] = additionalRequestor;
				}
				for (String additionalRequestersList : additionalRequestersArrayList) {
					WebAction.sendKeys(addRequester, additionalRequestersList);
					Thread.sleep(1000);
					WebAction.sendKeys_WithoutClear(addRequester, " ");
					Waits.waitUntilElementSizeGreater(SearchList, 0);
					Thread.sleep(3000);
					WebAction.click(SearchList.get(0));

					List<WebElement> requesterList = driver
							.findElements(By.xpath("//*[@emptylistmessage='No Requesters Selected']//span"));
					for (WebElement list : requesterList) {
						if (list.getText().contains(additionalRequestersList)) {
							emailCCList.add(ConfigFileReader.getProperty(
									"additionalrequestor-" + additionalRequestersList.toLowerCase(),
									"emailconfig.properties"));
							workingEmailCCList.add(ConfigFileReader.getProperty(
									"additionalrequestor-" + additionalRequestersList.toLowerCase(),
									"emailconfig.properties"));
							break;
						}
					}
				}
				List<RequesterRecord> additionalRequestersStringList = new ArrayList<>();
				for (String additionalRequesters : additionalRequestersArrayList) {
					additionalRequestersStringList.add(new RequesterRecord(additionalRequesters));
					ReportGenerate.test.log(Status.PASS,
							"Added Additional Requester <b>" + additionalRequesters.toString() + "</b>");
				}
				Constants.setRequesters(additionalRequestersStringList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void enterTalentValue(String talentValue) throws InterruptedException, Exception {
		String[] talentValueArrayList;
		WebAction.scrollIntoView(requestersSection);
		if (talentValue != null) {
			if (talentValue.contains("-")) {
				talentValueArrayList = talentValue.split("-");
			} else {
				talentValueArrayList = talentValue.split(" ");
			}
			for (String talentValueList : talentValueArrayList) {
				WebAction.scrollIntoView(talentInputBox);
				// To enter talent value
				WebAction.sendKeys(talentInputBox, talentValueList);
				Thread.sleep(1000);
				WebAction.sendKeys_WithoutClear(talentInputBox, " ");
				Waits.waitUntilElementSizeGreater(SearchList, 0);
				Thread.sleep(1000);
				WebAction.clickUsingJs(SearchList.get(0));
			}
			List<TalentRecord> talentsStringList = new ArrayList<>();
			for (String talents : talentValueArrayList) {
				talentsStringList.add(new TalentRecord(talents));
			}
			Constants.setTalents(talentsStringList);
		}
	}

	public void addProductionPurposeInfo(String requestForText, String DetailsAndNotesText) throws Exception {
		try {
			WebAction.scrollIntoView(talentSection);
			enterRequestFor(requestForText);
			enterDetailsAndNotes(DetailsAndNotesText);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void enterRequestFor(String requestForText) throws Exception {
		if (requestForText != null) {
			boolean valuePresent = false;
			WebAction.clickUsingJs(requestForDropDown);
			WebAction.sendKeys(requestForDropDown, requestForText);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (WebElement ele : dropDownvalues) {
				if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(requestForText)) {
					WebAction.click(ele);
					valuePresent = true;
					break;
				}
			}
			if (valuePresent == false)
				throw new Exception("'" + requestForText + "' value is not present in the request for type drop down");
		}
	}

	public int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	/**
	 * To set the location information based on below parameters
	 * 
	 * @param locationText
	 * @param setLocationText
	 * @throws Exception
	 */
	public void addSetLocationInfo(String locationText, String setLocationText) throws Exception {
		try {
			WebAction.scrollIntoView(setLocationSection);
			selectLocation(locationText);
			selectSetLocation(setLocationText, locationText);
			Constants.setLocations(locationText);
			Constants.setSetLocations(setLocationText);
			// emailValidationSetLocation(Constants.getFormName(), locationText,
			// Constants.getRequestStatus());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To add/create DLs list for corresponding forms
	 * 
	 * @param formName
	 * @param locationText
	 * @param requestStatus2
	 * @throws Exception
	 */
	private void emailValidationSetLocation(String formName, String locationText, RequestStatus requestStatus2)
			throws Exception {
		switch (formName.toUpperCase()) {
		case "EXTEND OR BRIDGE CREW & FACILITIES":
		case "ROCK CENTER":
			if (locationText.equalsIgnoreCase("LA") || locationText.equalsIgnoreCase("DC")
					|| locationText.equalsIgnoreCase("Telemundo Center")) {

				if (!emailCCList.contains(ConfigFileReader.getProperty(
						"prodreq-setlocation-" + locationText.toLowerCase().replace(" ", "").trim(),
						"emailconfig.properties"))) {

					ProducerDashboardGeneralPage.emailCCList.add(ConfigFileReader.getProperty(
							"prodreq-setlocation-" + locationText.toLowerCase().replace(" ", "").trim(),
							"emailconfig.properties"));
				}

			}
			break;
		case "CNBC":
			if (!emailCCList.contains(ConfigFileReader.getProperty(
					"cnbc-location-" + locationText.toLowerCase().replace(" ", "").trim(), "emailconfig.properties"))) {
				ProducerDashboardGeneralPage.emailCCList.add(ConfigFileReader.getProperty(
						"cnbc-location-" + locationText.toLowerCase().replace(" ", "").trim(),
						"emailconfig.properties"));
			}
			break;
		case "ANIMALS ON PREMISES":
		case "FIREARMS ON PREMISES":
			break;
		}

	}

	public void specificSetLocationEmailValidation(String setSetLocationText) throws Exception {
		String formname = Constants.getFormName();
		switch (formname.toUpperCase()) {
		case "ANIMALS ON PREMISES":
		case "FIREARMS ON PREMISES":
		case "EXTEND OR BRIDGE CREW & FACILITIES":
			break;
		case "CNBC":
		case "ROCK CENTER":
			if (Constants.getStagingNeeds() != null && Constants.getStagingNeeds().equalsIgnoreCase("Yes")) {// jeev) {
				switch (setSetLocationText.toUpperCase()) {
				case "1A STUDIO":
				case "1A UP":
				case "3B STUDIO":
				case "3B WEST":
				case "3A STUDIO":
				case "3A WEST":
				case "3K STUDIO":
					ProducerDashboardGeneralPage.emailCCList.add(ConfigFileReader.getProperty(
							"prodreq-setsetlocation-" + setSetLocationText.toLowerCase().replace(" ", ""),
							"emailconfig.properties"));
					break;
				}
			}
			break;
		}
		/*
		 * if (!formname.equalsIgnoreCase("ANIMALS ON PREMISES") ||
		 * formname.equalsIgnoreCase("FIREARMS ON PREMISES") ||
		 * !formname.equalsIgnoreCase("Extend or Bridge Crew & Facilities")) { if
		 * (Constants.getStagingNeeds().equalsIgnoreCase("Yes")) {// jeev) { switch
		 * (setSetLocationText.toUpperCase()) { case "1A STUDIO": case "1A UP": case
		 * "3B STUDIO": case "3B WEST": case "3A STUDIO": case "3A WEST": case
		 * "3K STUDIO":
		 * ProducerDashboardGeneralPage.emailCCList.add(ConfigFileReader.getProperty(
		 * "prodreq-setsetlocation-" + setSetLocationText.toLowerCase().replace(" ",
		 * ""), "emailconfig.properties")); break; } } }
		 */
	}

	public void selectSetLocation(String setLocationText, String locationText) throws Exception {
		// To select set location
		String setLocationDropDownXpath;
		WebElement setLocationDropDownWebElement;
		String locationAddressInputBoxXpath;
		WebElement locationAddressInputBoxWebElement;
		if (setLocationText != null && locationText != null && (!(locationText.toUpperCase().contains("NONE")))) {
			if (setLocationText.contains(",")) {
				String[] setLocationTextArrayList = setLocationText.split(",");
				String[] locationTextArrayList = locationText.split(",");
				int k, j = 1, l = 1;
				for (k = 0; k < setLocationTextArrayList.length; k++) {
					if (!(locationTextArrayList[k].toUpperCase().contains("FIELD"))) {
						setLocationDropDownXpath = setLocationDropDown.replace("<<setLocationTypeDropDownNo>>",
								Integer.toString(j));
						setLocationDropDownWebElement = driver.findElement(By.xpath(setLocationDropDownXpath));
						Waits.waitForElement(setLocationDropDownWebElement, WAIT_CONDITIONS.CLICKABLE);
						boolean valuePresent = false;
						WebAction.click(setLocationDropDownWebElement);
						WebAction.sendKeys(setLocationDropDownWebElement, setLocationTextArrayList[k].trim());
						Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
						for (WebElement ele : dropDownvalues) {
							if (WebAction.getAttribute(ele, "title")
									.equalsIgnoreCase(setLocationTextArrayList[k].trim())) {
								WebAction.clickUsingJs(ele);
								specificSetLocationEmailValidation(setLocationTextArrayList[k].trim());
								valuePresent = true;
								break;
							}
						}
						j++;
						if (valuePresent == false)
							throw new Exception("'" + setLocationText
									+ "' value is not present in the set location type drop down");
					} else {
						locationAddressInputBoxXpath = locationAddressInputBox.replace("<<locationAddressInputBoxNo>>",
								Integer.toString(l));
						locationAddressInputBoxWebElement = driver.findElement(By.xpath(locationAddressInputBoxXpath));
						WebAction.sendKeys(locationAddressInputBoxWebElement, setLocationTextArrayList[k].trim());
						l++;
					}
				}
			} else {
				if (!(locationText.equalsIgnoreCase("FIELD"))) {
					boolean valuePresent = false;
					setLocationDropDownXpath = setLocationDropDown.replace("<<setLocationTypeDropDownNo>>", "1");
					setLocationDropDownWebElement = driver.findElement(By.xpath(setLocationDropDownXpath));
					WebAction.clickUsingJs(setLocationDropDownWebElement);
					WebAction.sendKeys(setLocationDropDownWebElement, setLocationText.trim());
					Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
					for (WebElement ele : dropDownvalues) {
						if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(setLocationText)) {
							WebAction.click(ele);
							specificSetLocationEmailValidation(setLocationText);
							valuePresent = true;
							break;
						}
					}
					if (valuePresent == false)
						throw new Exception(
								"'" + setLocationText + "' value is not present in the set location type drop down");
				} else {
					locationAddressInputBoxXpath = locationAddressInputBox.replace("<<locationAddressInputBoxNo>>",
							"1");
					locationAddressInputBoxWebElement = driver.findElement(By.xpath(locationAddressInputBoxXpath));
					WebAction.sendKeys(locationAddressInputBoxWebElement, setLocationText);
				}
			}
		}
	}

	public void selectLocation(String locationText) throws Exception {
		WebAction.scrollIntoView(setLocationSection);
		// To select location
		String locationDropDownXpath;
		WebElement locationDropDownWebElement;
		if (locationText != null) {
			if (!(locationText.toUpperCase().contains("NONE"))) {
				if (locationText.contains(",")) {
					String[] locationTextArrayList = locationText.split(",");
					int j = 1, k = 0;
					for (k = 0; k < locationTextArrayList.length; k++) {
						locationDropDownXpath = locationDropDown.replace("<<locationTypeDropDownNo>>",
								Integer.toString(k + 1));
						locationDropDownWebElement = driver.findElement(By.xpath(locationDropDownXpath));
						Waits.waitForElement(locationDropDownWebElement, WAIT_CONDITIONS.CLICKABLE);
						boolean valuePresent = false;
						WebAction.click(locationDropDownWebElement);
						WebAction.sendKeys(locationDropDownWebElement, locationTextArrayList[k].trim());
						Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
						for (WebElement ele : dropDownvalues) {
							if (WebAction.getAttribute(ele, "title")
									.equalsIgnoreCase(locationTextArrayList[k].trim())) {
								WebAction.clickUsingJs(ele);
								valuePresent = true;
								emailValidationSetLocation(Constants.getFormName(), locationTextArrayList[k].trim(),
										Constants.getRequestStatus());
								break;
							}
						}
						if (valuePresent == false)
							throw new Exception(
									"'" + locationText + "' value is not present in the location type drop down");
						// need to check here
						if (j <= locationTextArrayList.length - 1
								&& addLocationButton.getAttribute("class").contains("ng-star-inserted")) {
							Waits.waitForElement(addLocationButton, WAIT_CONDITIONS.CLICKABLE);
							WebAction.click(addLocationButton);
							j++;
						}
					}
				} else {
					boolean valuePresent = false;
					locationDropDownXpath = locationDropDown.replace("<<locationTypeDropDownNo>>", "1");
					locationDropDownWebElement = driver.findElement(By.xpath(locationDropDownXpath));
					WebAction.clickUsingJs(locationDropDownWebElement);
					WebAction.sendKeys(locationDropDownWebElement, locationText.trim());
					Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
					for (WebElement ele : dropDownvalues) {
						if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(locationText)) {
							WebAction.click(ele);
							valuePresent = true;
							emailValidationSetLocation(Constants.getFormName(), locationText,
									Constants.getRequestStatus());
							break;
						}
					}
					if (valuePresent == false)
						throw new Exception(
								"'" + locationText + "' value is not present in the location type drop down");
				}
			} else {
				locationText = "NONE";
				boolean valuePresent = false;
				locationDropDownXpath = locationDropDown.replace("<<locationTypeDropDownNo>>", "1");
				locationDropDownWebElement = driver.findElement(By.xpath(locationDropDownXpath));
				WebAction.clickUsingJs(locationDropDownWebElement);
				WebAction.sendKeys(locationDropDownWebElement, locationText);
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(locationText)) {
						WebAction.click(ele);
						valuePresent = true;
						emailValidationSetLocation(Constants.getFormName(), locationText, Constants.getRequestStatus());
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception("'" + locationText + "' value is not present in the location type drop down");
			}
		}
	}

	/**
	 * To set the Flashcam Crew
	 * 
	 * @param flashcamCrewText
	 * @throws Exception
	 */
	public void selectFlashcamCrew(String flashcamCrewText) throws Exception {
		// To select flashcam crew
		if (!(Constants.getLocations().toUpperCase().contains("NONE"))) {
			WebAction.scrollIntoView(setLocationSection);
			try {
				String setLocationText = Constants.getSetLocations();
				String preSelectedFlashcamCrewXpath = "//*[@label='Set Flashcam Crew']//nz-select//div";
				List<WebElement> preSelectedFlashcamCrew = driver.findElements(By.xpath(preSelectedFlashcamCrewXpath));

				if (setLocationText.toUpperCase().contains("NEWSROOM FLASHCAM")) {
					for (int i = 0; i < preSelectedFlashcamCrew.size(); i++) {
						String preSelectedFlashcamCrewText = preSelectedFlashcamCrew.get(i).getText().trim();
						if (preSelectedFlashcamCrewText.equalsIgnoreCase("Tech Manager")) {
							System.out.println(preSelectedFlashcamCrewText
									+ " is by default displaying in Flashcam Crew on selecting NEWSROOM FLASHCAM as set Location ");
							ReportGenerate.test.log(Status.INFO, preSelectedFlashcamCrewText
									+ " is by default displaying in Flashcam Crew on selecting NEWSROOM FLASHCAM as set Location ");
						}
					}
				}

				if (setLocationText.toUpperCase().contains("NEWSROOM DESK")) {
					for (int i = 0; i < preSelectedFlashcamCrew.size(); i++) {
						String preSelectedFlashcamCrewText = preSelectedFlashcamCrew.get(i).getText().trim();
						if (preSelectedFlashcamCrewText.equalsIgnoreCase("Camera Operator")
								|| preSelectedFlashcamCrewText.equalsIgnoreCase("A1")) {
							System.out.println(preSelectedFlashcamCrewText
									+ " is by default displaying in Flashcam Crew on selecting NEWSROOM DESK as set Location ");
							ReportGenerate.test.log(Status.INFO, preSelectedFlashcamCrewText
									+ " is by default displaying in Flashcam Crew on selecting NEWSROOM DESK as set Location ");
						}
					}
				}

				addFlashcamCrewText(flashcamCrewText);
				WebAction.clickUsingJs(setLocationSection);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	public void addFlashcamCrewText(String flashcamCrewText) throws Exception {
		if (flashcamCrewText != null) {
			WebAction.clickUsingJs(setFlashcamCrew);
			String flashcamCrewTextArrayList[];
			if (flashcamCrewText.contains(",")) {
				flashcamCrewTextArrayList = flashcamCrewText.split(",");
			} else {
				flashcamCrewTextArrayList = new String[1];
				flashcamCrewTextArrayList[0] = flashcamCrewText;
			}
			for (String enterFlashcamCrewText : flashcamCrewTextArrayList) {
				WebAction.sendKeys(setFlashcamCrew, enterFlashcamCrewText);
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(enterFlashcamCrewText)) {
						WebAction.click(ele);
						ReportGenerate.test.log(Status.INFO,
								"User selects " + enterFlashcamCrewText + " as Flashcam Crew option");
						// String flashcamcrewText = enterFlashcamCrewText.replace(" ", "");
						// emailValidationFlashcamCrew(Constants.getFormName(), flashcamcrewText);
						break;
					}
				}
			}
			List<String> flashcamCrewStringList = new ArrayList<>();
			for (String flashcamCrew : flashcamCrewStringList) {
				flashcamCrewStringList.add(new String(flashcamCrew));
			}
			Constants.setFlashcamCrew(flashcamCrewStringList);
		}
	}

	/**
	 * To set the Set Crew and add the DL in CC list
	 * 
	 * @param setCrewText
	 * @throws Exception
	 */
	public void selectSetCrew(String setCrewText) throws Exception {
		// To select set crew
		if (!(Constants.getLocations().toUpperCase().contains("NONE"))) {
			WebAction.scrollIntoView(setLocationSection);
			try {
				addSetCrewText(setCrewText);
				WebAction.clickUsingJs(setLocationSection);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	/**
	 * To add dls to TO & CC based on form name and setcrew for all forms
	 * 
	 * @param formName
	 * @param setcrewText
	 * @throws Exception
	 */
	private void emailValidationSetCrew(String formName, String setcrewText) throws Exception {
		switch (formName.toUpperCase()) {
		case "CNBC":
			break;
		case "SINGLE CAMERA LIVE SHOT":
		case "ROCK CENTER":
			if (setcrewText.equalsIgnoreCase("HairStylist") || setcrewText.equalsIgnoreCase("MakeupArtist")
					|| setcrewText.equalsIgnoreCase("WardrobeDresser")) {

				if (!emailCCList.contains(ConfigFileReader.getProperty(
						"prodreq-setcrew-" + setcrewText.toLowerCase().replace(" ", "").trim(),
						"emailconfig.properties"))) {

					emailCCList.add(ConfigFileReader.getProperty(
							"prodreq-setcrew-" + setcrewText.toLowerCase().replace(" ", "").trim(),
							"emailconfig.properties"));
				}
			}
			break;
		}

	}

	private void emailValidationControlRoomLocation(String formName, String controlRoomLocationText) throws Exception {
		switch (formName.toUpperCase()) {
		case "CNBC":
			break;
		case "SINGLE CAMERA LIVE SHOT":
		case "ROCK CENTER":
			if (controlRoomLocationText.equalsIgnoreCase("EC") || controlRoomLocationText.equalsIgnoreCase("DC")) {
				if (!emailCCList.contains(ConfigFileReader.getProperty(
						"prodreq-controlroom-" + controlRoomLocationText.toLowerCase().replace(" ", "").trim(),
						"emailconfig.properties"))) {

					emailCCList.add(ConfigFileReader.getProperty(
							"prodreq-controlroom-" + controlRoomLocationText.toLowerCase().replace(" ", "").trim(),
							"emailconfig.properties"));

				}

			}
			break;
		}

	}

	public void addSetCrewText(String setCrewText) throws Exception {
		if (setCrewText != null) {
			WebAction.clickUsingJs(setCrew);
			String setCrewArrayList[];
			if (setCrewText.contains(",")) {
				setCrewArrayList = setCrewText.split(",");
			} else {
				setCrewArrayList = new String[1];
				setCrewArrayList[0] = setCrewText;
			}
			for (String enterSetCrew : setCrewArrayList) {
				WebAction.sendKeys(setCrew, enterSetCrew);
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(enterSetCrew)) {
						WebAction.click(ele);
						if (enterSetCrew.toUpperCase().contains(("OTHER"))) {
							WebAction.sendKeys(otherSetCrewInputBox, "Other test set crew");
						}
						ReportGenerate.test.log(Status.INFO, "User selects " + enterSetCrew + " as Set Crew option");
						String setcrewText = enterSetCrew.replace(" ", "");
						emailValidationSetCrew(Constants.getFormName(), setcrewText);
						break;
					}
				}
			}
			List<CrewRecord> setCrewStringList = new ArrayList<>();
			for (String setCrew : setCrewArrayList) {
				setCrewStringList.add(new CrewRecord(setCrew));
			}
			Constants.setSetCrew(setCrewStringList);
		}
	}

	public void addControlRoom(String controlRoomText, String controlRoomLocationText) throws Exception {
		// To select control room
		String controlRoomDropDownXpath;
		WebElement controlRoomDropDownWebElement;
		String controlRoomAddressInputBoxXpath;
		WebElement controlRoomAddressInputBoxWebElement;
		if (controlRoomText != null && controlRoomLocationText != null
				&& (!(controlRoomLocationText.toUpperCase().contains("NO CONTROL ROOM")))) {
			if (controlRoomText.contains(",")) {
				String[] controlRoomTextArrayList = controlRoomText.split(",");
				String[] controlRoomLocationTextArrayList = controlRoomLocationText.split(",");
				int k, j = 1, l = 1;
				for (k = 0; k < controlRoomTextArrayList.length; k++) {

					if (!(controlRoomLocationTextArrayList[k].toUpperCase().contains("FIELD"))) {
						controlRoomDropDownXpath = controlRoomDropDown.replace("<<controlRoomDropDownNo>>",
								Integer.toString(j));
						controlRoomDropDownWebElement = driver.findElement(By.xpath(controlRoomDropDownXpath));
						Waits.waitForElement(controlRoomDropDownWebElement, WAIT_CONDITIONS.CLICKABLE);
						boolean valuePresent = false;
						WebAction.click(controlRoomDropDownWebElement);
						WebAction.sendKeys(controlRoomDropDownWebElement, controlRoomTextArrayList[k].trim());
						Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
						for (WebElement ele : dropDownvalues) {
							if (WebAction.getAttribute(ele, "title")
									.equalsIgnoreCase(controlRoomTextArrayList[k].trim())) {
								WebAction.clickUsingJs(ele);
								valuePresent = true;
								break;
							}
						}
						j++;
						if (valuePresent == false)
							throw new Exception("'" + controlRoomText
									+ "' value is not present in the control room type drop down");
					} else {
						controlRoomAddressInputBoxXpath = controlRoomAddressInputBox
								.replace("<<controlRoomAddressInputBoxNo>>", Integer.toString(l));
						controlRoomAddressInputBoxWebElement = driver
								.findElement(By.xpath(controlRoomAddressInputBoxXpath));
						WebAction.sendKeys(controlRoomAddressInputBoxWebElement, controlRoomTextArrayList[k].trim());
						l++;
					}
				}
			} else {
				if (!(controlRoomLocationText.equalsIgnoreCase("FIELD"))) {
					boolean valuePresent = false;
					controlRoomDropDownXpath = controlRoomDropDown.replace("<<controlRoomDropDownNo>>", "1");
					controlRoomDropDownWebElement = driver.findElement(By.xpath(controlRoomDropDownXpath));
					WebAction.clickUsingJs(controlRoomDropDownWebElement);
					WebAction.sendKeys(controlRoomDropDownWebElement, controlRoomText.trim());
					Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
					for (WebElement ele : dropDownvalues) {
						if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(controlRoomText)) {
							WebAction.click(ele);
							valuePresent = true;
							break;
						}
					}
					if (valuePresent == false)
						throw new Exception(
								"'" + controlRoomText + "' value is not present in the control room type drop down");
				} else {
					controlRoomAddressInputBoxXpath = controlRoomAddressInputBox
							.replace("<<controlRoomAddressInputBoxNo>>", "1");
					controlRoomAddressInputBoxWebElement = driver
							.findElement(By.xpath(controlRoomAddressInputBoxXpath));
					WebAction.sendKeys(controlRoomAddressInputBoxWebElement, controlRoomText);
				}
			}
		}
	}

	public void addControlRoomLocation(String controlRoomLocationText) throws Exception {
		String controlRoomLocationDropDownXpath;
		WebElement controlRoomLocationDropDownWebElement;
		if (controlRoomLocationText != null) {
			if (!(controlRoomLocationText.toUpperCase().contains("NO CONTROL ROOM"))) {
				if (controlRoomLocationText.contains(",")) {
					String[] controlRoomLocationTextArrayList = controlRoomLocationText.split(",");
					int j = 1, k = 0;
					for (k = 0; k < controlRoomLocationTextArrayList.length; k++) {
						controlRoomLocationDropDownXpath = controlRoomLocationDropDown
								.replace("<<controlRoomLocationDropDownNo>>", Integer.toString(k + 1));
						controlRoomLocationDropDownWebElement = driver
								.findElement(By.xpath(controlRoomLocationDropDownXpath));
						Waits.waitForElement(controlRoomLocationDropDownWebElement, WAIT_CONDITIONS.CLICKABLE);
						boolean valuePresent = false;
						WebAction.click(controlRoomLocationDropDownWebElement);
						WebAction.sendKeys(controlRoomLocationDropDownWebElement,
								controlRoomLocationTextArrayList[k].trim());
						Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
						for (WebElement ele : dropDownvalues) {
							if (WebAction.getAttribute(ele, "title")
									.equalsIgnoreCase(controlRoomLocationTextArrayList[k].trim())) {
								WebAction.clickUsingJs(ele);
								emailValidationControlRoomLocation(Constants.getFormName(),
										controlRoomLocationTextArrayList[k].trim());
								valuePresent = true;
								break;
							}
						}
						if (valuePresent == false)
							throw new Exception("'" + controlRoomLocationText
									+ "' value is not present in the control room location type drop down");
						// need to check here
						if (j <= controlRoomLocationTextArrayList.length - 1
								&& addControlRoomButton.getAttribute("class").contains("ng-star-inserted")) {
							Waits.waitForElement(addControlRoomButton, WAIT_CONDITIONS.CLICKABLE);
							WebAction.click(addControlRoomButton);
							j++;
						}
					}
				} else {
					boolean valuePresent = false;
					controlRoomLocationDropDownXpath = controlRoomLocationDropDown
							.replace("<<controlRoomLocationDropDownNo>>", "1");
					controlRoomLocationDropDownWebElement = driver
							.findElement(By.xpath(controlRoomLocationDropDownXpath));
					WebAction.clickUsingJs(controlRoomLocationDropDownWebElement);
					WebAction.sendKeys(controlRoomLocationDropDownWebElement, controlRoomLocationText.trim());
					Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
					for (WebElement ele : dropDownvalues) {
						if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(controlRoomLocationText)) {
							WebAction.click(ele);
							valuePresent = true;
							emailValidationControlRoomLocation(Constants.getFormName(), controlRoomLocationText);
							break;
						}
					}
					if (valuePresent == false)
						throw new Exception("'" + controlRoomLocationText
								+ "' value is not present in the control room location type drop down");
				}
			} else {
				controlRoomLocationText = "NO CONTROL ROOM";
				boolean valuePresent = false;
				controlRoomLocationDropDownXpath = controlRoomLocationDropDown
						.replace("<<controlRoomLocationDropDownNo>>", "1");
				controlRoomLocationDropDownWebElement = driver.findElement(By.xpath(controlRoomLocationDropDownXpath));
				WebAction.clickUsingJs(controlRoomLocationDropDownWebElement);
				WebAction.sendKeys(controlRoomLocationDropDownWebElement, controlRoomLocationText.trim());
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(controlRoomLocationText)) {

						WebAction.click(ele);
						valuePresent = true;
						emailValidationControlRoomLocation(Constants.getFormName(), controlRoomLocationText);
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception("'" + controlRoomLocationText
							+ "' value is not present in the control room location type drop down");
			}
		}
	}

	public void selectCaptureManager(String captureManagerText) throws Exception {
		if (captureManagerText != null) {
			if (captureManagerText.equalsIgnoreCase("Yes")) {
				WebAction.click(captureManager_Yes);
				ReportGenerate.test.log(Status.INFO,
						"User selects " + captureManagerText + " for Capture Manager option");
				ProducerDashboardGeneralPage.emailCCList
						.add(ConfigFileReader.getProperty("prodreq-capturemanager", "emailconfig.properties"));
			} else {
				WebAction.click(captureManager_No);
				ReportGenerate.test.log(Status.INFO, "User selects No for Capture Manager option");
			}
			Constants.setCaptureManagerOption(captureManagerText);
		}
	}

	public void addControlRoomCrew(String controlRoomCrewText) throws Exception {
		// To select control Room Crew
		try {
			WebAction.clickUsingJs(controlRoomCrew);
			if (controlRoomCrewText != null) {
				String controlRoomCrewArrayList[];
				if (controlRoomCrewText.contains(",")) {
					controlRoomCrewArrayList = controlRoomCrewText.split(",");
				} else {
					controlRoomCrewArrayList = new String[1];
					controlRoomCrewArrayList[0] = controlRoomCrewText;
				}
				for (String enterControlRoomCrew : controlRoomCrewArrayList) {
					WebAction.sendKeys(controlRoomCrew, enterControlRoomCrew);
					Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
					for (WebElement ele : dropDownvalues) {
						if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(enterControlRoomCrew)) {
							WebAction.click(ele);
							if (enterControlRoomCrew.equalsIgnoreCase("Video Playback")) {
								ProducerDashboardGeneralPage.emailCCList.add(ConfigFileReader
										.getProperty("prodreq-controlroomcrew-playbackad", "emailconfig.properties"));
							}
							if (enterControlRoomCrew.toUpperCase().contains(("OTHER"))) {
								WebAction.sendKeys(otherControlRoomCrewInputBox, "Other test control room crew");
							}
							break;
						}
					}
				}
				List<CrewRecord> controlRoomCrewStringList = new ArrayList<>();
				for (String controlRoomCrew : controlRoomCrewArrayList) {
					controlRoomCrewStringList.add(new CrewRecord(controlRoomCrew));
				}
				Constants.setControlRoomCrew(controlRoomCrewStringList);
			}
			WebAction.clickUsingJs(controlRoomCrewSection);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addNotes(String notesText) {
		// To enter notes
		if (notesText != null) {
			WebAction.sendKeys(systemNotesTextArea, notesText);
		}
	}

	public void addDescribeStagingNeeds(String DescribeStagingNeedsText) throws Exception {
		if (DescribeStagingNeedsText != null) {
			Waits.waitForElement(DescribeStagingNeedsTextarea, WAIT_CONDITIONS.CLICKABLE);
			WebAction.click(DescribeStagingNeedsTextarea);
			WebAction.sendKeys(DescribeStagingNeedsTextarea, DescribeStagingNeedsText);
		}
	}

	public void selectTPMorTMInfo(String TPMorTMText) throws Exception {
		WebAction.scrollIntoView(tpmOrTmSection);
		try {
			if (TPMorTMText != null) {
				if (TPMorTMText.equalsIgnoreCase("No"))
					WebAction.click(tpmOrTm_No);
				else {
					Constants.setTpmOrTmInformation(new TpmOrTmInformation(TPMorTMText));
					WebAction.click(tpmOrTm_Yes);
					ProducerDashboardGeneralPage.emailCCList
							.add(ConfigFileReader.getProperty("prodreq-tmORtpm", "emailconfig.properties"));
					if (TPMorTMText.equalsIgnoreCase("Same as requester")) {
						WebAction.click(sameAsRequesterCheckBox);
					} else {
						WebAction.sendKeys(tpmTmName, TPMorTMText);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void selectArrivalTime(String arrivalTimeText) throws Exception {
		// To fill arrival Time
		if (arrivalTimeText != null) {
			Constants.setArrivalTime(generateTime(arrivalTimeText, "hh:mm a"));
			WebAction.click(arrivalTime);
			WebAction.sendKeys(arrivalTime, generateTime(arrivalTimeText, "hh:mm a"));
			WebAction.keyPress(arrivalTime, "Enter");
			arrivalTime.sendKeys(Keys.ESCAPE);
		}
	}

	public void selectArrivalDate(String arrivalDateText) throws Exception {
		// To fill arrival Date
		if (arrivalDateText != null) {
			Constants.setArrivalDate(generateDate(arrivalDateText, "MM/dd/yyyy"));
			WebAction.click(arrivalDate);
			WebAction.sendKeys(arrivalDate, generateDate(arrivalDateText, "MM/dd/yyyy"));
			WebAction.keyPress(arrivalDate, "Enter");
		}
	}

	public void selectDepartureDate(String departureDateText) throws Exception {
		// To fill Departure Date
		if (departureDateText != null) {
			Constants.setDepartureDate(generateDate(departureDateText, "MM/dd/yyyy"));
			WebAction.click(departureDate);
			WebAction.sendKeys(departureDate, generateDate(departureDateText, "MM/dd/yyyy"));
			WebAction.keyPress(departureDate, "Enter");
		}
	}

	public void selectDepartureTime(String departureTimeText) throws Exception {
		// To fill Departure Time
		if (departureTimeText != null) {
			Constants.setDepartureTime(generateTime(departureTimeText, "hh:mm a"));
			WebAction.click(departureTime);
			WebAction.sendKeys(departureTime, generateTime(departureTimeText, "hh:mm a"));
			WebAction.keyPress(departureTime, "Enter");
			departureTime.sendKeys(Keys.ESCAPE);
		}
	}

	public void addShowInfoInFireArmAndAnimalPremises(String airPlatformText, String showText, String arrivalDateText,
			String arrivalTimeText, String departureDateText, String departureTimeText) throws Exception {
		try {
			WebAction.scrollIntoView(showInfoSection);
			selectAirPlatform(airPlatformText);
			enterShowInFireArmAndAnimalPremises(showText);
			selectArrivalDate(arrivalDateText);
			selectArrivalTime(arrivalTimeText);
			selectDepartureDate(departureDateText);
			selectDepartureTime(departureTimeText);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void enterShowInFireArmAndAnimalPremises(String showText) throws InterruptedException, Exception {
		WebAction.scrollIntoView(showInfoSection);
		// To enter show unit value
		if (showText != null) {
			Constants.setShowUnit(showText);
			WebAction.sendKeys(showInputBox, showText);
			WebAction.keyPress(showInputBox, "Enter");
		}
	}

	// Fulfiller Details

	/**
	 * To search the request in fulfiller table
	 *
	 * @throws Exception
	 */
	public void searchRequest() throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			WebAction.click(searchTextBox);
			Waits.waitUntilElementSizeGreater(fulfillerTableRows, 1);
			WebAction.sendKeys(searchTextBox, requestNumber + Keys.ENTER);
			Thread.sleep(1000);
		} catch (Exception e) {
			// AllureUtility.captureScreenshot("Search request is not working in fulfiller
			// dashboard");
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyRequestInfulfillerDashboard(String formName, String status) throws Exception {
		String expectedFormname = "";
		String expectedStatus = "";
		try {
			verifyRequestInfulfillerDashboardMethod(formName, status, expectedFormname, expectedStatus);
		} catch (Exception e) {
			// AllureUtility.captureScreenshot("Request not found in fulfiller dashboard");
			// e.printStackTrace();
			driver.navigate().refresh();
			verifyRequestInfulfillerDashboardMethod(formName, status, expectedFormname, expectedStatus);
			throw e;
		}
	}

	private void verifyRequestInfulfillerDashboardMethod(String formName, String status, String expectedFormname,
			String expectedStatus) throws Exception {
		if (formName.toUpperCase().equalsIgnoreCase("NBC NEWS") || formName.toUpperCase().equalsIgnoreCase("CNBC CREW")
				|| formName.toUpperCase().equalsIgnoreCase("TELEMUNDO NEWS")
				|| formName.toUpperCase().equalsIgnoreCase("DIGITAL JOURNALIST / DJ SHOOT")) {
			driver.navigate().refresh();
		}
		String requestNumber = Constants.getRequestNumber();
		Waits.waitForElement(By.xpath(findRequestById.replace("<<RequestId>>", requestNumber)),
				WAIT_CONDITIONS.VISIBLE);
		Waits.waitForElement(By.xpath(findRequestById.replace("<<RequestId>>", requestNumber)),
				WAIT_CONDITIONS.CLICKABLE);
		WebElement actualFormNameElement = driver
				.findElement(By.xpath(findRequestById.replace("<<RequestId>>", requestNumber) + "/ancestor::tr"));

		// To check form name
		if (formName.toUpperCase().equalsIgnoreCase("NEWS GEAR")) {
			// formName = "News Gear";
			// expectedFormname =
			// WebAction.getText(actualFormNameElement.findElement(By.xpath("td[1]//div"))).trim();
			expectedFormname = formName;
			expectedStatus = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[2]//span"))).trim();
		} else if (formName.toUpperCase().equalsIgnoreCase("ROCK CENTER")) {
			formName = "Rock Center Production";
			expectedStatus = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[3]//span"))).trim();
			expectedFormname = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[2]//p[1]"))).trim();
		} else if (formName.toUpperCase().equalsIgnoreCase("CNBC")) {
			formName = "CNBC Production";
			expectedFormname = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[2]//p[1]"))).trim();
			expectedStatus = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[3]//span"))).trim();
		} else if (formName.toUpperCase().equalsIgnoreCase("ANIMALS ON PREMISES")) {
			formName = "Animals Request";
			expectedFormname = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[2]//p[1]"))).trim();
			expectedStatus = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[3]//span"))).trim();
		} else if (formName.toUpperCase().equalsIgnoreCase("FIREARMS ON PREMISES")) {
			formName = "FireArms Request";
			expectedFormname = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[2]//p[1]"))).trim();
			expectedStatus = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[3]//span"))).trim();
		} else if (formName.toUpperCase().equalsIgnoreCase("SINGLE CAMERA LIVE SHOT")) {
			formName = "Plaza Live Shot";
			expectedFormname = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[2]//p[1]"))).trim();
			expectedStatus = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[3]//span"))).trim();
		} else if (formName.toUpperCase().equalsIgnoreCase("EXTEND OR BRIDGE CREW & FACILITIES")) {
			formName = "Extend or Bridge";
			expectedFormname = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[2]//p[1]"))).trim();
			expectedStatus = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[3]//span"))).trim();
		} else if (formName.toUpperCase().equalsIgnoreCase("NBC NEWS")) {
			formName = "General Crew Request";
			expectedFormname = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[1]//div"))).trim();
			expectedStatus = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[2]//span"))).trim();
		} else if (formName.toUpperCase().equalsIgnoreCase("NBC BREAKING NEWS")) {
			formName = "Breaking News";
			expectedFormname = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[1]//div"))).trim();
			expectedStatus = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[2]//span"))).trim();
		} else if (formName.toUpperCase().equalsIgnoreCase("NBC BUREAU CAMERA")) {
			formName = "Bureau Camera";
			expectedFormname = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[1]//div"))).trim();
			expectedStatus = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[2]//span"))).trim();
		} else if (formName.toUpperCase().equalsIgnoreCase("CNBC CREW")) {
			expectedFormname = formName;
			expectedStatus = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[2]//span"))).trim();
		} else if (formName.toUpperCase().equalsIgnoreCase("TELEMUNDO NEWS")) {
			expectedFormname = formName;
			expectedStatus = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[2]//span"))).trim();
		} else if (formName.toUpperCase().equalsIgnoreCase("DIGITAL JOURNALIST / DJ SHOOT")) {
			// formName = "Digital Journalist";
			// expectedFormname =
			// WebAction.getText(actualFormNameElement.findElement(By.xpath("td[2]//p[1]"))).trim();
			expectedFormname = formName;
			expectedStatus = WebAction.getText(actualFormNameElement.findElement(By.xpath("td[2]//span"))).trim();
		} else if (formName.toUpperCase().equalsIgnoreCase("STANDARD EDIT")
				|| formName.toUpperCase().equalsIgnoreCase("LONG EDIT")
				|| formName.toUpperCase().equalsIgnoreCase("EDIT SELF REPORTING")
				|| formName.toUpperCase().equalsIgnoreCase("FEED OUT")
				|| formName.toUpperCase().equalsIgnoreCase("FILE INGEST")
				|| formName.toUpperCase().equalsIgnoreCase("MEDIA TRANSCODING / TRANSFERRING / DUPLICATION")) {
			WebElement ecmID = actualFormNameElement.findElement(By.xpath("td[1]//span[2]/span[2]"));
			Waits.waitForElement(ecmID, WAIT_CONDITIONS.VISIBLE);
			try {
				WebAction.mouseOver(ecmID);
				Thread.sleep(2000);
			} catch (Exception e) {
				driver.navigate().refresh();
				WebAction.mouseOver(ecmID);
				// WebAction.clickUsingJs(ecmID);
			}
			expectedFormname = WebAction
					.getText(driver
							.findElement(By.xpath("(//div[contains(@class,'tooltip-content-margin')]//span[2])[1]")))
					.trim();
			expectedStatus = WebAction
					.getText(driver.findElement(By.xpath("//div[contains(@class,'tooltip-title')]//span[2]"))).trim();

			switch (formName.toUpperCase()) {
			case "STANDARD EDIT":
				formName = "Standard";
				break;
			case "LONG EDIT":
				formName = "Long Form";
				break;
			case "MEDIA TRANSCODING / TRANSFERRING / DUPLICATION":
				formName = "MTD";
				break;
			}
		}
		if (!((expectedFormname.equalsIgnoreCase(formName)) && (expectedStatus.equalsIgnoreCase(status)))) {
			throw new Exception(
					"Form name is not correct.Actual form name is '" + formName + "' and status is '" + status + "'");
		}
		if (requestNumber.isEmpty()) {
			throw new Exception("Submitted " + formName + "is not present in my request table");
		}

		if (status.equalsIgnoreCase("CONFIRM CANCELLATION")) {
			status = "CONFIRM_CANCELLATION";
		}

		if (status.equalsIgnoreCase("IN PROGRESS")) {
			status = "IN_PROGRESS";
		}

		if (status.equalsIgnoreCase("READY FOR PICK UP")) {
			status = "READY_FOR_PICK_UP";
		}

		Constants.setRequestStatus(RequestStatus.valueOf(status));
	}

	/**
	 * To verify status background color
	 *
	 * @param typeOfCss
	 * @param status
	 * @param expectedColor
	 * @throws Exception
	 */
	public void verifyStatusBackgroundColor(String typeOfCss, String status, String expectedColor) throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			// String requestNumber = "SR-08302024-00316914";
			// To add request number in allure report
			// AllureUtility.addParameter("Request Number", requestNumber);
			String findRequestByIdForBGStatus = "(//a[contains(text(),'<<RequestId>>')]";
			String statusXpath = findRequestByIdForBGStatus.replace("<<RequestId>>", requestNumber)
					+ "/../../..//following-sibling::td[1]//span)[1]";
			WebElement statusElement = driver.findElement(By.xpath(statusXpath));
			String actualStatus = WebAction.getText(statusElement).trim();
			if (!(actualStatus.equalsIgnoreCase(status))) {
				throw new Exception("Status of the request is not correct. Expected status is '" + status
						+ "' and actual status is '" + actualStatus + "'");
			}
			CommonValidations.verifyCssValueOfWebElement(statusElement, typeOfCss, expectedColor);
		} catch (Exception e) {
			// AllureUtility.captureScreenshot("Status color Validation error");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To click edit link of the request
	 *
	 * @throws Exception
	 */
	public void clickEditLink() throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber().trim();

			Waits.waitForElement(By.xpath(findRequestById.replace("<<RequestId>>", requestNumber)),
					WAIT_CONDITIONS.CLICKABLE);

			String editLinkXpath = findRequestById.replace("<<RequestId>>", requestNumber)
					+ "/../.././following-sibling::td[//a[text()='Edit']]//a";

			// To click edit link
			try {
				WebAction.click(driver.findElement(By.xpath(editLinkXpath)));
			} catch (Exception e) {
				editLinkXpath = findRequestById.replace("<<RequestId>>", requestNumber);
				Waits.waitForElement(By.xpath(editLinkXpath), WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(driver.findElement(By.xpath(editLinkXpath)));
				Waits.waitForElement(By.xpath("//span[text()='Edit ']"), WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(driver.findElement(By.xpath("//span[text()='Edit ']")));
			}
		} catch (Exception e) {
			// AllureUtility.captureScreenshot("Click Edit link error in fulfiller table");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify the NOTES section by another user
	 * 
	 * @param role
	 */
	public void noteValidationByOtherUser(String role) {
		String reqNotesbyReq = WebAction.getText(RequesterTxtInsideNotes);
		String reqNotesbyConst = Constants.getDetailsAndNotes();
		Assert.assertTrue(reqNotesbyReq.equals(reqNotesbyConst), "Expected Note which added by Requester is "
				+ reqNotesbyConst + " and actual value is " + reqNotesbyReq);
		String reqffRole = WebAction.getText(UserRoleInsideNotes);
		Assert.assertTrue(role.equalsIgnoreCase(reqffRole),
				"Expected Role is " + role + " but the actual value is " + reqffRole);
		Assert.assertTrue(WebAction.isDisplayed(TimeInsideNotes),
				"Time should be present in Notes section but its not showed");
		Assert.assertTrue(WebAction.isDisplayed(ssoInsideNotes),
				"SSO should be visible inside Notes section but its not displayed");
	}

	/**
	 * To open dashboard page based on form name
	 *
	 * @param formName
	 * @throws Exception
	 */
	public void openDashboard(String formName) throws Exception {
		Constants.setFormType(formName);
		driver.navigate().refresh();
		Waits.waitForElement(menuIconUnfold, WAIT_CONDITIONS.CLICKABLE);
		WebAction.click(menuIconUnfold);
		String dashboardName = "";
		try {
			// To navigate to dashboard page based on form name
			switch (formName.toUpperCase()) {
			case "NBC NEWS":
			case "NBC BREAKING NEWS":
			case "NBC BUREAU CAMERA":
				clickCrewDashboard();
				Waits.waitForElement(nbcCrewDashboardTitle, WAIT_CONDITIONS.VISIBLE);
				break;
			case "CNBC CREW":
				clickCrewDashboard();
				WebAction.click(dashboardDropdownCarrotIcon);
				Thread.sleep(1000);
				Waits.waitForElement(cnbcCrewDashboardInDropdown, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(cnbcCrewDashboardInDropdown);
				Waits.waitForElement(cnbcCrewDashboardTitle, WAIT_CONDITIONS.VISIBLE);
				break;
			case "TELEMUNDO NEWS":
				clickCrewDashboard();
				WebAction.click(dashboardDropdownCarrotIcon);
				Thread.sleep(1000);
				Waits.waitForElement(telemundoCrewDashboardInDropdown, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(telemundoCrewDashboardInDropdown);
				Waits.waitForElement(telemundoCrewDashboardTitle, WAIT_CONDITIONS.VISIBLE);
				break;
			case "DIGITAL JOURNALIST / DJ SHOOT":
				clickCrewDashboard();
				WebAction.click(dashboardDropdownCarrotIcon);
				Thread.sleep(1000);
				Waits.waitForElement(digitalCrewDashboardInDropdown, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(digitalCrewDashboardInDropdown);
				Waits.waitForElement(digitalCrewDashboardTitle, WAIT_CONDITIONS.VISIBLE);
				break;
			case "EXECUTIVE DASHBOARD":
				Waits.waitForElement(crewIcon, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(crewIcon);
				Waits.waitForElement(executiveDashboard, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(executiveDashboard);
				Waits.waitForElement(executiveDashboardTitle, WAIT_CONDITIONS.VISIBLE);
				break;
			case "ROCK CENTER":
			case "ANIMALS ON PREMISES":
			case "FIREARMS ON PREMISES":
			case "SINGLE CAMERA LIVE SHOT":
			case "EXTEND OR BRIDGE CREW & FACILITIES":
				clickProductionDashboard();
				Thread.sleep(1000);
				Waits.waitForElement(rockProductionDashboardTitle, WAIT_CONDITIONS.VISIBLE);
				break;
			case "CNBC":
				clickProductionDashboard();
				WebAction.click(dashboardDropdownCarrotIcon);
				Thread.sleep(1000);
				WebAction.mouseOver(cnbcProductionDashboardInDropdown);
				Waits.waitForElement(cnbcProductionDashboardInDropdown, WAIT_CONDITIONS.CLICKABLE);
				WebAction.clickUsingJs(cnbcProductionDashboardInDropdown);
				Waits.waitForElement(cnbcProductionDashboardTitle, WAIT_CONDITIONS.VISIBLE);
				break;
			case "STANDARD EDIT":
			case "LONG EDIT":
			case "FEED OUT":
			case "FILE INGEST":
			case "MEDIA TRANSCODING / TRANSFERRING / DUPLICATION":
			case "EDIT SELF REPORTING":
				Waits.waitForElement(ecmIcon, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(ecmIcon);
				Waits.waitForElement(ecmDashboard, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(ecmDashboard);
				// To find dashboard page based on form name
				Waits.waitForElement(ecmDashboardTitleHeader, WAIT_CONDITIONS.VISIBLE);
				Waits.waitForElement(dashboardDropdownCarrotIcon, WAIT_CONDITIONS.CLICKABLE);
				Thread.sleep(2000);
				WebAction.click(dashboardDropdownCarrotIcon);
				Thread.sleep(1000);
				// WebAction.mouseOver(dashboardDownIcon);
				if (formName.toUpperCase().equalsIgnoreCase("STANDARD EDIT")
						|| formName.toUpperCase().equalsIgnoreCase("LONG EDIT")) {
					Waits.waitForElement(editRequestDashboardInDropdown, WAIT_CONDITIONS.CLICKABLE);
					WebAction.click(editRequestDashboardInDropdown);
					Waits.waitForElement(editRequestDashboardTitle, WAIT_CONDITIONS.VISIBLE);
				} else if (formName.toUpperCase().equalsIgnoreCase("EDIT SELF REPORTING")) {
					Waits.waitForElement(editSelfReportingDashboardInDropdown, WAIT_CONDITIONS.CLICKABLE);
					WebAction.click(editSelfReportingDashboardInDropdown);
					Waits.waitForElement(editSelfReportingDashboardTitle, WAIT_CONDITIONS.VISIBLE);
				} else {
					Waits.waitForElement(contentManagementDashboardInDropdown, WAIT_CONDITIONS.CLICKABLE);
					WebAction.click(contentManagementDashboardInDropdown);
					Waits.waitForElement(contentManagementDashboardTitle, WAIT_CONDITIONS.VISIBLE);
				}
				break;
			case "NEWS GEAR":
				clickGearDashboard();
				Waits.waitForElement(newsGearDashboardTitle, WAIT_CONDITIONS.VISIBLE);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private void clickGearDashboard() throws Exception {
		Waits.waitForElement(gearIcon, WAIT_CONDITIONS.CLICKABLE);
		WebAction.click(gearIcon);
		Waits.waitForElement(newsDashboard, WAIT_CONDITIONS.CLICKABLE);
		WebAction.click(newsDashboard);
		Thread.sleep(1000);
	}

	private void clickCrewDashboard() throws Exception {
		Waits.waitForElement(crewIcon, WAIT_CONDITIONS.CLICKABLE);
		WebAction.click(crewIcon);
		Waits.waitForElement(CrewDashboard, WAIT_CONDITIONS.CLICKABLE);
		WebAction.click(CrewDashboard);
		Thread.sleep(1000);
	}

	private void clickProductionDashboard() throws Exception {
		Waits.waitForElement(productionIcon, WAIT_CONDITIONS.CLICKABLE);
		WebAction.click(productionIcon);
		Waits.waitForElement(ProductionDashboard, WAIT_CONDITIONS.CLICKABLE);
		WebAction.click(ProductionDashboard);
		Thread.sleep(1000);
		Waits.waitForElement(dashboardDropdownCarrotIcon, WAIT_CONDITIONS.CLICKABLE);
		Thread.sleep(2000);
	}

	/**
	 * To select given tab in the fulfiller table
	 *
	 * @param tabName - tab name
	 * @throws Exception
	 */
	public void selectTabInFulfillerTable(String tabName) throws Exception {
		try {
			switch (tabName.toUpperCase()) {
			case "ACTIVE":
				WebAction.click(activeTab);
				break;
			case "FULFILLED":
				WebAction.click(fulfilledTab);
				break;
			case "CANCELLED":
				WebAction.click(cancelledTab);
				break;
			case "EXTENDED":
				WebAction.click(extendedTab);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To select given tab in the gear Request Page
	 *
	 * @param tabName - tab name
	 * @throws Exception
	 */
	public void selectTabsInRequestPage(String tabName) throws Exception {
		try {
			switch (tabName.toUpperCase()) {
			case "FORM":
				Waits.waitForElement(formTab, WAIT_CONDITIONS.CLICKABLE);
				WebAction.clickUsingJs(formTab);
				break;
			case "STATUS":
				// Waits.waitForElement(statusTab, WAIT_CONDITIONS.CLICKABLE);
				Thread.sleep(1000);
				WebAction.clickUsingJs(statusTab);
				break;
			case "NOTES":
				// Waits.waitForElement(notesTab, WAIT_CONDITIONS.CLICKABLE);
				Thread.sleep(1000);
				WebAction.clickUsingJs(notesTab);
				break;
			case "LOG":
				// Waits.waitForElement(logTab, WAIT_CONDITIONS.CLICKABLE);
				Thread.sleep(1000);
				WebAction.clickUsingJs(logTab);
				break;
			case "FULFILLMENT":
				Waits.waitForElement(fulfillmentTab, WAIT_CONDITIONS.CLICKABLE);
				WebAction.clickUsingJs(fulfillmentTab);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To fill notes details in Notes section
	 *
	 * @param notesText - notes for this form
	 * @throws Exception
	 */
	public void fillNotes(String notesText) throws Exception {
		try {
			Waits.waitForElement(notesTextArea, WAIT_CONDITIONS.CLICKABLE);
			WebAction.sendKeys(notesTextArea, notesText);
			Constants.setDetailsAndNotes(notesText);
			WebAction.click(notesAddButton);
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * NOTE validations based on Role (Requester/Fulfiller)
	 * 
	 * @param role
	 */
	public void noteValidationAfterAdd(String role) {
		String reqNotesbyReq = WebAction.getText(RequesterTxtInsideNotes);
		String reqNotesbyConst = Constants.getDetailsAndNotes();
		Assert.assertTrue(reqNotesbyReq.contentEquals(reqNotesbyConst), "Expected Note which added by Requester is "
				+ reqNotesbyConst + " and actual value is " + reqNotesbyReq);

		String reqffRole = WebAction.getText(UserRoleInsideNotes);
		Assert.assertTrue(role.equalsIgnoreCase(reqffRole),
				"Expected Role is " + role + " but the actual value is " + reqffRole);

		Assert.assertTrue(WebAction.isDisplayed(TimeInsideNotes),
				"Time should be present in Notes section but its not showed");

		Assert.assertTrue(WebAction.isDisplayed(ssoInsideNotes),
				"SSO should be visible inside Notes section but its not displayed");

		Assert.assertTrue(WebAction.isDisplayed(deleteIconInsideNotes),
				"Delete Option should be present inside Notes section but its not Present");

		Assert.assertTrue(WebAction.isDisplayed(editIconInsideNotes),
				"Edit Option should be present inside Notes section but its not Present");
	}

	/**
	 * To Validate the Notes in edit mode
	 * 
	 * @param role
	 * @param txt
	 * @throws Exception
	 */
	public void noteEditValidations(String role, String txt) throws Exception {
		WebAction.click(editIconInsideNotes);
		Waits.waitForElement(RequesterTxtInsideEditNotes, WAIT_CONDITIONS.VISIBLE);
		Waits.waitForElement(RequesterTxtInsideEditNotes, WAIT_CONDITIONS.CLICKABLE);
		// String reqNotesbyReq = WebAction.getText(RequesterTxtInsideEditNotes);
		// String reqNotesbyConst = Constants.getDetailsAndNotes();
		Assert.assertTrue(WebAction.isDisplayed(RequesterTxtInsideEditNotes),
				"Expected Note text area is not displayed.");
		WebAction.sendKeys(noteTextArea, txt);
		Constants.setDetailsAndNotes(txt);
		WebAction.click(saveBtnInsdeNotes);
		noteValidationAfterAdd(role);

	}

	/**
	 * To verify success submission message is displayed
	 *
	 * @throws Exception
	 */
	public void verifyFormSuccessMessage(String status) throws Exception {
		try {
			switch (status.toUpperCase()) {
			case "PUBLISHED":
				Waits.waitForElement(publishSuccessMessage, WAIT_CONDITIONS.VISIBLE);
				CommonValidations.verifyTextValue(publishSuccessMessage, "Published",
						"Crew request is not published successfully");
				break;
			case "SUBMITTED":
				Waits.waitForElement(submissionSuccessMessage, WAIT_CONDITIONS.VISIBLE);
				CommonValidations.verifyTextValue(submissionSuccessMessage, "Request Submitted");
				break;
			case "SAVED":
			case "UPDATED":
				Waits.waitForElement(updatedSuccessMessage, WAIT_CONDITIONS.VISIBLE);
				CommonValidations.verifyTextValue(updatedSuccessMessage, "Request was updated successfully");
				break;
			case "ACKNOWLEDGED":
				Waits.waitForElement(acknowledgedSuccessMessage, WAIT_CONDITIONS.VISIBLE);
				CommonValidations.verifyTextValue(acknowledgedSuccessMessage,
						"request has been changed to \"Acknowledged\"");
				break;
			case "READY FOR PICK UP":
				Waits.waitForElement(readyForPickUpSuccessMessage, WAIT_CONDITIONS.VISIBLE);
				CommonValidations.verifyTextValue(readyForPickUpSuccessMessage,
						"request has been changed to \"Ready For Pick Up\"");
				break;
			case "COMPLETED":
				Waits.waitForElement(completedSuccessMessage, WAIT_CONDITIONS.VISIBLE);
				CommonValidations.verifyTextValue(completedSuccessMessage, "request has been changed to \"Completed\"");
				break;
			case "CANCELLATION REQUESTED":
			case "SUBMITTED FOR CANCELLATION":
				Waits.waitForElement(cancellationRequestSuccessMessage, WAIT_CONDITIONS.VISIBLE);
				CommonValidations.verifyTextValue(cancellationRequestSuccessMessage, "Cancellation Requested");
				break;
			case "CANCELLATION CONFIRMED":
			case "CANCELLED":
				Waits.waitForElement(cancelledSuccessMessage, WAIT_CONDITIONS.VISIBLE);
				// CommonValidations.verifyTextValue(cancelledSuccessMessage, "Cancellation
				// Confirmation");
				CommonValidations.verifyTextValue(cancelledSuccessMessage, "Cancellation Confirmed");
				break;
			// case "PREMISES REQUEST CANCELLED":
			// Waits.waitForElement(premisesRequestCancelledSuccessMessage,
			// WAIT_CONDITIONS.VISIBLE);
			// CommonValidations.verifyTextValue(premisesRequestCancelledSuccessMessage,
			// "request is cancelled");
			// break;
			}
			// To close the update popup
			if (WebAction.isDisplayed(closeMessagePopup))
				WebAction.click(closeMessagePopup);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	static boolean pcrCheckedIn = false;
	static boolean stdioCheckedIn = false;
	static boolean directorCheckedIn = false;
	static boolean tpsCheckedIn = false;
	static boolean hairMakeupWardrobeCheckedIn = false;
	static boolean technicalCheckedIn = false;
	static boolean dcFulfillmentCheckedIn = false;
	static boolean laFulfillmentCheckedIn = false;
	static boolean stagingCheckedIn = false;
	static boolean tmtpmCheckedIn = false;
	static boolean DPSPlaybackCheckedIn = false;
	static boolean telemundoCenterCheckedIn = false;

	/**
	 * To change status of the form. Applicable only for fulfiller login
	 *
	 * @param status - status to change
	 * @throws Exception
	 */
	public void statusUpdate(String status) throws Exception {
		try {
			Thread.sleep(1500);
			switch (status.toUpperCase()) {
			case "ACKNOWLEDGED":
				// WebAction.scrollIntoView(acknowledgedRadioButton);
				Waits.waitForElement(acknowledgedRadioButton, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(acknowledgedRadioButton);
				break;
			case "READY FOR PICK UP":
				// WebAction.scrollIntoView(readyForPickUpRadioButton);
				Waits.waitForElement(readyForPickUpRadioButton, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(readyForPickUpRadioButton);
				break;
			case "COMPLETE":
				// WebAction.scrollIntoView(completeRadioButton);
				Waits.waitForElement(completeRadioButton, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(completeRadioButton);
				break;
			case "TECHNICAL":
				// WebAction.scrollIntoView(technicalRadioButton);
				Waits.waitForElement(technicalRadioButton, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(technicalRadioButton);
				technicalCheckedIn = true;
				break;
			case "PCR":
				// WebAction.scrollIntoView(pcrRadioButton);
				Waits.waitForElement(pcrRadioButton, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(pcrRadioButton);
				pcrCheckedIn = true;
				break;
			case "CAPTURE MANAGER":
				// WebAction.scrollIntoView(captureManagerRadioButton);
				Waits.waitForElement(captureManagerRadioButton, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(captureManagerRadioButton);
				break;
			case "DPS PLAYBACK":
				Waits.waitForElement(DPSPlaybackRadioButton, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(DPSPlaybackRadioButton);
				DPSPlaybackCheckedIn = true;
				break;
			case "TELEMUNDO CENTER":
				Waits.waitForElement(telemundoCenterRadioButton, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(telemundoCenterRadioButton);
				telemundoCenterCheckedIn = true;
				break;
			case "HAIR, MAKEUP & WARDROBE":
				// WebAction.scrollIntoView(hairMakeupWardrobeRadioButton);
				Waits.waitForElement(hairMakeupWardrobeRadioButton, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(hairMakeupWardrobeRadioButton);
				hairMakeupWardrobeCheckedIn = true;
				break;
			case "EFFORTING":
				// WebAction.scrollIntoView(effortingStatus);
				WebAction.click(effortingStatus);
				break;
			case "ROFR":
				// WebAction.scrollIntoView(rofrStatus);
				WebAction.click(rofrStatus);
				break;
			case "BOOKED":
				// WebAction.scrollIntoView(bookedStatus);
				WebAction.click(bookedStatus);
				break;
			case "STAGING":
				// WebAction.scrollIntoView(stagingStatus);
				Waits.waitForElement(stagingStatus, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(stagingStatus);
				stagingCheckedIn = true;
				break;
			case "TM/TPM":
				// WebAction.scrollIntoView(tmtpmStatus);
				Waits.waitForElement(tmtpmStatus, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(tmtpmStatus);
				tmtpmCheckedIn = true;
				break;
			case "STUDIO":
				// WebAction.scrollIntoView(studioStatus);
				Waits.waitForElement(studioStatus, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(studioStatus);
				stdioCheckedIn = true;
				break;
			case "DIRECTOR":
				// WebAction.scrollIntoView(directorStatus);
				Waits.waitForElement(directorStatus, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(directorStatus);
				directorCheckedIn = true;
				break;
			case "TPS":
				// WebAction.scrollIntoView(tpsStatus);
				Waits.waitForElement(tpsStatus, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(tpsStatus);
				tpsCheckedIn = true;
				break;
			case "INGEST":
				// WebAction.scrollIntoView(ingestStatus);
				Waits.waitForElement(ingestStatus, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(ingestStatus);
				break;
			case "ENTERED INTO STORM":
				// WebAction.scrollIntoView(directorStatus);
				Waits.waitForElement(enteredIntoStormStatus, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(enteredIntoStormStatus);
				break;
			case "DC FULFILLMENT":
				// WebAction.scrollIntoView(directorStatus);
				Waits.waitForElement(dcFulfillmentStatus, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(dcFulfillmentStatus);
				dcFulfillmentCheckedIn = true;
				break;
			case "LA FULFILLMENT":
				// WebAction.scrollIntoView(directorStatus);
				Waits.waitForElement(laFulfillmentStatus, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(laFulfillmentStatus);
				laFulfillmentCheckedIn = true;
				break;
			}
			Thread.sleep(1500);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify cancel request/confirm cancellation/send to storm alert message
	 *
	 * @param alertMessage - expected alert message
	 * @throws Exception
	 */
	public void verifyAlertMessage(String action, String alertMessage) throws Exception {
		try {

			if ((action.equalsIgnoreCase("CANCEL REQUEST")) || (action.equalsIgnoreCase("CONFIRM CANCELLATION")))
				CommonValidations.verifyTextValue(cancellationAlertMessage, alertMessage,
						action + " alert message is not matched");
			else if (action.equalsIgnoreCase("SEND TO STORM"))
				CommonValidations.verifyTextValue(sendToStormAlertMessage, alertMessage,
						action + " alert message is not matched");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To open respective requests page based on status of the request
	 *
	 * @throws Exception
	 */

	public void clickRequestsDropdown(String requestsDropdownName) throws Exception {
		try {
			if (requestsDropdownName.equalsIgnoreCase("EXTENDED")) {
				NumberOfLogs++;
				Thread.sleep(500);
			}
			Waits.waitForElement(myRequestDropdownInputField, WAIT_CONDITIONS.CLICKABLE);
			WebAction.sendKeys(myRequestDropdownInputField, requestsDropdownName);
			WebAction.keyPress(myRequestDropdownInputField, "Enter");
			Thread.sleep(1500);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * search the request not present in fulfiller table
	 *
	 * @throws Exception
	 */
	public void verifyRequestNotPresentFulfillerTable() throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			WebAction.click(searchTextBox);
			Waits.waitUntilElementSizeGreater(fulfillerTableRows, 1);
			WebAction.sendKeys(searchTextBox, requestNumber);
			CommonValidations.verifyTextValue(noDataFound, "No Data");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To click submit button
	 *
	 * @param buttonName - button name like submit, cancel, discard changes, etc.,
	 * @throws Exception
	 */
	public void clickButton(String buttonName) throws Exception {
		Thread.sleep(1500);
		try {
			// suggested Resources in crew form
			String formType = Constants.getFormType();
			if ((formType.equalsIgnoreCase("NBC News") || formType.equalsIgnoreCase("CNBC Crew")
					|| formType.equalsIgnoreCase("Digital Journalist / DJ Shoot")
					|| formType.equalsIgnoreCase("Telemundo News"))
					&& (buttonName.equalsIgnoreCase("SAVE") || buttonName.equalsIgnoreCase("SAVE REQUEST")
							|| buttonName.equalsIgnoreCase("SUBMIT")
							|| (buttonName.equalsIgnoreCase("SUBMIT REQUESTS")))) {
				String suggestedResourcesXpath = "//*[@sectiontitle='Resources']//*[contains(text(),'Suggested')]/ancestor::div[2]/child::div[2]/p";
				int expectedSuggestedResources = 00;
				WebElement actualResourceCountWebElement = driver.findElement(By.xpath(suggestedResourcesXpath));
				if (actualResourceCountWebElement.isDisplayed()
						&& !(actualResourceCountWebElement.getText().equals("#"))) {
					expectedSuggestedResources = Integer.parseInt(actualResourceCountWebElement.getText());
				}
				Constants.setSuggestedResource(expectedSuggestedResources);
			}
			switch (buttonName.toUpperCase()) {
			case "NOTES":
				WebAction.click(fulfillmentNotes);
				break;
			case "LOG":
				WebAction.clickUsingJs(fulfillmentLog); // jeeva
				break;
			case "NEXT":
				WebAction.click(myRequestPage.nextButton);
				break;
			case "SAVE":
			case "SAVE REQUEST":
				WebAction.click(saveButton);
				NumberOfLogs++;
				Thread.sleep(500);
				break;
			case "PUBLISH":
				WebAction.click(publishButton);
				NumberOfLogs++;
				Thread.sleep(500);
				break;
			case "EXIT":
				WebAction.click(myRequestPage.exitButton);
				break;
			case "+ ADD FOR ANIMAL":
				WebAction.click(myRequestPage.AddButtonForAnimal);
				break;
			case "+ ADD FOR HANDLER":
			case "+ ADD":
				WebAction.click(myRequestPage.AddButtonForHandler);
				break;
			case "SUBMIT":
			case "SUBMIT REQUESTS":
				WebAction.click(myRequestPage.submitButton);
				NumberOfLogs++;
				break;
			case "NBCU LOGO":
				Waits.waitForElement(myRequestPage.nbcuLogo, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(myRequestPage.nbcuLogo);
				break;
			case "MY REQUEST DASHBOARD PAGE":
//				 Waits.waitForElement(myRequestPage.myRequestsDashboard,
//				 WAIT_CONDITIONS.CLICKABLE);
				WebAction.clickUsingJs(myRequestPage.myRequestsDashboard);
				break;
			case "CANCEL REQUEST":
				// WebAction.click(cancelButton);
				WebAction.click(myRequestPage.cancelRequestButton);
				NumberOfLogs++;
				break;
			case "CONFIRM CANCELLATION":
			case "CONFIRM CANCEL REQUEST":
				WebAction.click(myRequestPage.confirmCancelRequestButton);
				NumberOfLogs++;
				break;
			case "EDIT":
				// Thread.sleep(3000);
				Waits.waitForElement(editButton, WAIT_CONDITIONS.CLICKABLE);
				try {
					WebAction.clickUsingJs(editButton);
				} catch (Exception e) {
					WebAction.click(editButton);
				}
				break;
			case "ALL REQUESTS":
				WebAction.click(myRequestDropdownIcon);
				WebAction.click(myRequestPage.allRequestsInDropdown);
				break;
			case "MY REQUESTS":
				WebAction.click(myRequestDropdownIcon);
				WebAction.click(myRequestPage.myRequestsInDropdown);
				break;
			case "VIEW ESTIMATED COST BREAKDOWN":
				WebAction.click(viewEstimatedCostBreakdown);
				break;
			case "MISSING FIELD ALERT POPUP OK":
				WebAction.click(alertMsgOkBtn);
				break;
			}
			if (buttonName.toUpperCase().matches("OK")) {
				Waits.waitForElement(myRequestPage.closeMessagePopup, WAIT_CONDITIONS.CLICKABLE);
				try {
					WebAction.clickUsingJs(myRequestPage.cancel_Ok);
				} catch (Exception e) {
					WebAction.click(myRequestPage.closeMessagePopup);
				}
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void verifyNumberOfLog() throws Exception {
		try {
			int numberOfExpectedLogs = NumberOfLogs;
			selectTabsInRequestPage("Log");
			int numberOfActualLogs = driver.findElements(By.xpath("//div[contains(@class,'log-card')]")).size();
			// count no of logs for request
			CommonValidations.verifytextValue(numberOfActualLogs, numberOfExpectedLogs);
			System.out.println("Number of Logs displayed : " + numberOfActualLogs);

			int closeButtonInLogPanel = driver.findElements(By.xpath(
					"//div[contains(@class,'log-card')]/ancestor::div[7]//div[contains(text(),'Log')]/ancestor::div[2]//*[@data-icon='close']"))
					.size();
			if (closeButtonInLogPanel > 0) {
				WebAction.click(driver.findElement(By.xpath(
						"//div[contains(@class,'log-card')]/ancestor::div[7]//div[contains(text(),'Log')]/ancestor::div[2]//*[@data-icon='close']")));
				// div[contains(text(),'Logs')]/../..//*[@data-icon='close']
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// Crew form

	/**
	 * To fill slug in general details section To fill division in general details
	 * section To fill Air date & Time in general details section
	 *
	 * @param commentText - slug for this form
	 * @throws Exception
	 */

	public void addGeneralInfo(String slugText, String ncxStoryNameText) throws Exception {

		try {
			if (slugText != null) {
				// to enter slug
				Constants.setAssignmentSlug(slugText);
				Waits.waitForElement(slugTextArea, WAIT_CONDITIONS.CLICKABLE);
				WebAction.sendKeys(slugTextArea, slugText);
				Constants.setAssignmentSlug(slugText);
				// To select ncx story name
				if (ncxStoryNameText != null) {
					Waits.waitForElement(nCXStoryName, WAIT_CONDITIONS.CLICKABLE);
					WebAction.sendKeys(nCXStoryName, ncxStoryNameText);
				} else {
					// WebAction.click(firstNCXStoryName);
					Waits.waitForElement(ncxStoryNamesdropDownvalues.get(2), WAIT_CONDITIONS.CLICKABLE);
					Waits.waitUntilElementSizeGreater(ncxStoryNamesdropDownvalues, 0);
					WebAction.click(ncxStoryNamesdropDownvalues.get(2));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * To fill additional requester section To fill producer info section To fill
	 * sr.producer info section To fill Talent info section
	 *
	 * @param commentText - slug for this form
	 * @throws Exception
	 */

	public void addProducerInfo(String isProducerSameasRequestorValue) throws Exception {
		try {
			if (isProducerSameasRequestorValue != null) {
				WebAction.scrollIntoView(requestersSection);
				if (isProducerSameasRequestorValue.toUpperCase().equalsIgnoreCase("YES")) {
					WebAction.clickUsingJs(producerSameasRequestor_CheckBox);
					Constants.setProducerName(Constants.getDefaultRequesterName());
				} else {
					WebAction.sendKeys(producerSameAsRequestInputBox, isProducerSameasRequestorValue);
					Thread.sleep(500);
					WebAction.sendKeys_WithoutClear(producerSameAsRequestInputBox, " ");
					Waits.waitUntilElementSizeGreater(SearchList, 0);
					Thread.sleep(1000);
					WebAction.click(SearchList.get(0));
					Constants.setProducerName(isProducerSameasRequestorValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void enterSeniorProducerValue(String srProducerValue) throws Exception {
		WebAction.scrollIntoView(seniorProducerInputBox);
		// To enter srProducer value
		if (srProducerValue != null) {
			WebAction.sendKeys(seniorProducerInputBox, srProducerValue);
			Thread.sleep(1000);
			// WebAction.sendKeys_WithoutClear(seniorProducerInputBox, " ");
			Waits.waitUntilElementSizeGreater(SearchList, 0);
			Thread.sleep(1000);
			WebAction.click(SearchList.get(0));
			Constants.setSeniorProducerName(srProducerValue);
		}
	}

	public void addIsOnsiteProducerInfo(String isOnsiteProducerText) throws Exception {
		if (isOnsiteProducerText != null) {
			if (isOnsiteProducerText.equalsIgnoreCase("No")) {
				WebAction.click(hasOnSiteProducer_No);
			} else
				WebAction.click(hasOnSiteProducer_Yes);
		}
	}

	public void enterfieldContact(String fieldContactText) throws Exception {
		if (fieldContactText != null) {
			Waits.waitForElement(fieldContactName, WAIT_CONDITIONS.CLICKABLE);
			WebAction.clear(fieldContactName);
			WebAction.sendKeys(fieldContactName, fieldContactText);
			Thread.sleep(1000);
			WebAction.sendKeys_WithoutClear(fieldContactName, " ");
			Waits.waitUntilElementSizeGreater(SearchList, 0);
			Thread.sleep(1000);
			WebAction.click(SearchList.get(0));
		}
	}

	public void enterfieldPhone(String PhoneText) throws Exception {
		if (PhoneText != null) {
			Waits.waitForElement(fieldMobile, WAIT_CONDITIONS.CLICKABLE);
			WebAction.clear(fieldMobile);
			WebAction.sendKeys(fieldMobile, PhoneText);
		}
	}

	public void addProductionType(String productionTypeText) throws Exception {
		if (productionTypeText != null) {
			boolean valuePresent = false;
			WebAction.scrollIntoView(shootDetailsSection);
			WebAction.clickUsingJs(productionType);

			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (WebElement ele : dropDownvalues) {
				if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(productionTypeText)) {
					WebAction.click(ele);
					valuePresent = true;
					break;
				}
			}
			Thread.sleep(500);
			if (valuePresent == false)
				throw new Exception(
						"'" + productionTypeText + "' value is not present in the production type drop down");
		}
	}

	public void enterShootStatus(String shootStatusText) throws Exception {
		if (shootStatusText == null) {
			WebAction.click(shootStatus_Firm);
		} else
			WebAction.click(shootStatus_Tent);
		Constants.setShootStatus(shootStatusText);
	}

	public void enterShootType(String shootTypeText) throws Exception {
		if (shootTypeText != null) {
			if (shootTypeText.equalsIgnoreCase("Tape")) {
				WebAction.click(shootType_Tape);
			} else
				WebAction.click(shootType_Live);
		}
	}

	public void enterShootDescription(String shootDescriptionText) throws Exception {
		if (shootDescriptionText != null) {
			Waits.waitForElement(shootDescription, WAIT_CONDITIONS.CLICKABLE);
			WebAction.sendKeys(shootDescription, shootDescriptionText);
		}
	}

	public void addAudioNeeds(String audioNeedsText) throws Exception {
		WebAction.scrollIntoView(shootDescription);
		if (audioNeedsText != null) {
			boolean valuePresent = false;
			WebAction.clickUsingJs(audioNeeds);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (WebElement ele : dropDownvalues) {
				if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(audioNeedsText)) {
					WebAction.click(ele);
					valuePresent = true;
					break;
				}
			}
			if (valuePresent == false)
				throw new Exception("'" + audioNeedsText + "' value is not present in the Audio Needs drop down");
		}
	}

	public void addSpecialConditions(String specialConditionsText) throws Exception {
		if (specialConditionsText != null) {
			boolean valuePresent = false;
			WebAction.clickUsingJs(specialConditions);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (WebElement ele : dropDownvalues) {
				if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(specialConditionsText)) {
					WebAction.click(ele);
					valuePresent = true;
					break;
				}
			}
			if (valuePresent == false)
				throw new Exception(
						"'" + specialConditionsText + "' value is not present in the Special Conditions drop down");
		}
	}

	public void addTransmissionType(String transmissionTypeText) throws Exception {
		WebAction.scrollIntoView(shootDetailsSection);
		if (transmissionTypeText != null) {
			boolean valuePresent = false;
			WebAction.clickUsingJs(transmissionType);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (WebElement ele : dropDownvalues) {
				if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(transmissionTypeText)) {
					WebAction.click(ele);
					valuePresent = true;
					break;
				}
			}
			if (valuePresent == false)
				throw new Exception(
						"'" + transmissionTypeText + "' value is not present in the Transmission Type drop down");
		}
	}

	public void addAcquisitionSpecs(String acquisitionSpecsText) throws Exception {
		WebAction.scrollIntoView(audioNeeds);
		if (acquisitionSpecsText != null) {
			boolean valuePresent = false;
			WebAction.clickUsingJs(acquisitionSpecs);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (WebElement ele : dropDownvalues) {
				if (WebAction.getAttribute(ele, "innerHTML").contains(acquisitionSpecsText)) {
					WebAction.click(ele);
					valuePresent = true;
					break;
				}
			}
			if (valuePresent == false)
				throw new Exception(
						"'" + acquisitionSpecsText + "' value is not present in the acquisition Specs Type drop down");
		}
	}

	public void enterIsthisaDroneShootText(String isthisaDroneShootText) throws Exception {
		if (isthisaDroneShootText != null) {
			if (isthisaDroneShootText.equalsIgnoreCase("No")) {
				WebAction.click(droneShoot_false);
			} else
				WebAction.click(droneShoot_true);
		}
	}

	public void enterSpecialGear(String specialGearText) throws Exception {
		if (specialGearText != null) {
			if (specialGearText.equalsIgnoreCase("No")) {
				WebAction.click(specialGear_false);
			} else {
				WebAction.click(specialGear_true);
				WebAction.click(gearNotes);
				WebAction.sendKeys(gearNotes, "Test notes");
			}
		}
	}

	public void addShootLocation(String shootLocationText, String riskAssessmentCategoryValue,
			String riskAssessmentTypeValue, String riskArrangementsValue, String riskApproverValue) throws Exception {
		WebAction.scrollIntoView(attachmentsSection);
		addShootLocationInCrew(shootLocationText, riskAssessmentCategoryValue, riskAssessmentTypeValue,
				riskArrangementsValue, riskApproverValue);
	}

	public void addShootLocationInCrew(String shootLocationText, String riskAssessmentCategoryValue,
			String riskAssessmentTypeValue, String riskArrangementsValue, String riskApproverValue)
			throws InterruptedException, Exception {
		if (shootLocationText != null) {
			Constants.setBureauLocation(shootLocationText);
			if (shootLocationText.toUpperCase().equalsIgnoreCase("OTHER")) {
				WebAction.sendKeys(shootLocationBureauLocationAddressInputField, "Test Address 123");
				WebAction.sendKeys(shootLocationCityInputField, "Testing City");
				WebAction.sendKeys(shootLocationStateInputField, "Alaska");
				Thread.sleep(1000);
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				Thread.sleep(1000);
				WebAction.click(dropDownvalues.get(0));
			} else {
				boolean valuePresent = false;
				WebAction.clickUsingJs(shootLocationBureauLocationDropdown);
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(shootLocationText)) {
						WebAction.click(ele);
						valuePresent = true;
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception(
							"'" + shootLocationText + "' value is not present in the Shoot Location drop down");
			}
			if (shootLocationText.toLowerCase().equalsIgnoreCase("london bureau")
					|| shootLocationText.toLowerCase().equalsIgnoreCase("mexico city bureau")
					|| shootLocationText.toLowerCase().equalsIgnoreCase("moscow bureau")) {
				// To select Risk Assessment category
				if (riskAssessmentCategoryValue != null) {
					WebAction.scrollIntoView(riskAssessmentArea);
					Constants.setRiskCategory(riskAssessmentCategoryValue);
					Constants.setRiskAssessment(riskAssessmentTypeValue);
					if (riskAssessmentCategoryValue.trim().equals("Standard")) {
						WebAction.click(standardOption);
						switch (riskAssessmentTypeValue.toUpperCase()) {
						case "FILMING ON ROADS":
							WebAction.click(filmingOnRoadsOption);
							break;
						case "HMI LIGHTING":
							WebAction.click(hmiLightingOption);
							break;
						case "LIVE POSITIONS":
							WebAction.click(livePositionsOption);
							break;
						case "LONG WORKING":
							WebAction.click(longWorkingOption);
							break;
						case "STRUCTURE & ACCESS EQUIPMENT":
							WebAction.click(structureAccessEquipmentOption);
							break;
						case "WORKING HEIGHTS":
							WebAction.click(workingHeightsOption);
							break;
						}
					} else if (riskAssessmentCategoryValue.trim().equals("High")) {
						WebAction.click(highOption);
						switch (riskAssessmentTypeValue.toUpperCase()) {
						case "AIRCRAFT":
							WebAction.click(aircraftOption);
							break;
						case "EMERGENCIES & DISASTERS":
							WebAction.click(emergenciesDisastersOption);
							break;
						case "FILMING ON OR NEAR WATER":
							WebAction.click(filmingOnOrNearWaterOption);
							break;
						case "RIOTS & CIVIL DISTURBANCES":
							WebAction.click(riotsCivilDisturbancesOption);
							break;
						case "STORM & EXTREME WEATHER":
							WebAction.click(stormExtremeWeatherOption);
							break;
						case "WAR ZONES":
							WebAction.click(warZoneOption);
							break;
						}
					}
				}
				// To enter record Arrangements
				if (riskArrangementsValue != null) {
					Constants.setEquipmentsForSafety(riskArrangementsValue);
					WebAction.sendKeys(riskArrangementsTextarea, riskArrangementsValue);
				}

				// To select Risk Approver
				if (riskApproverValue != null) {
					WebAction.click(riskApproverInputBox);
					WebAction.sendKeys(riskApproverInputBox, riskApproverValue);
					Waits.waitUntilElementSizeGreater(riskApproverMenuitem, 0);
					WebAction.click(riskApproverMenuitem.get(0));
				}
			}
		}
	}

	public void fillWhenIsShoot(String shootStartDateText, String shootEndDateText) throws Exception {
		try {
			WebAction.scrollIntoView(dateTimeSection);
			// To fill When Is Shoot
			if (shootStartDateText != null) {
				WebAction.click(shootStartDate);
				WebAction.sendKeys(shootStartDate, generateDate(shootStartDateText, "MM-dd-yyyy"));
				WebAction.keyPress(shootStartDate, "Enter");
				Thread.sleep(2000);
				WebAction.sendKeys(shootEndDate, generateDate(shootEndDateText, "MM-dd-yyyy"));
				WebAction.keyPress(shootEndDate, "Enter");
				Constants.setShootStartDate(shootStartDateText);
				Constants.setShootEndDate(shootEndDateText);
				WebElement shootDaysCountWebElement = driver
						.findElement(By.xpath("(//*[contains(@labelheader,'Days In Shoot')]//p)[2]"));
				Waits.waitForElement(shootDaysCountWebElement, WAIT_CONDITIONS.VISIBLE);
				String shootDaysCount = WebAction.getText(shootDaysCountWebElement).trim();
				Constants.setShootDaysCount(Integer.parseInt(shootDaysCount));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void selectTimeZone(String timeZoneText) throws Exception {
		try {
			if (timeZoneText != null) {
				WebAction.click(timeZone);
				WebAction.sendKeys(timeZone, timeZoneText);
				Thread.sleep(1000);
				Waits.waitUntilElementSizeGreater(dropDownvalues, 0);
				Thread.sleep(1000);
				WebAction.click(dropDownvalues.get(0));
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillMeetTime(String meetTimeText) throws Exception {
		try {
			// To fill meet time
			if (meetTimeText != null) {
				Constants.setShootMeetTime(generateTime(meetTimeText, "hh:mm a"));
				WebAction.click(meetTime);
				WebAction.sendKeys(meetTime, generateTime(meetTimeText, "hh:mm a"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// Telemundo News Crew Request
	public void enterIPadPrompterRequired(String iPadPrompterRequiredText) throws Exception {
		if (iPadPrompterRequiredText != null) {
			if (iPadPrompterRequiredText.equalsIgnoreCase("No")) {
				WebAction.click(iPadPrompter_false);
			} else
				WebAction.click(iPadPrompter_true);
		}
	}

	// Digital Journalist DJ Shoot Crew Request
	public void addPrimaryCameraType(String primaryCameraTypeText) throws Exception {
		if (primaryCameraTypeText != null) {
			boolean valuePresent = false;
			WebAction.clickUsingJs(primaryCameraType);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);

			System.out.println(" the drop down value  " + dropDownvalues.size());

			for (WebElement ele : dropDownvalues) {
				System.out.println(" the inner html of camera type " + WebAction.getAttribute(ele, "innerHTML"));
				if (WebAction.getAttribute(ele, "innerHTML").contains(primaryCameraTypeText)) {
					WebAction.click(ele);
					valuePresent = true;
					break;
				}
			}
			if (valuePresent == false)
				throw new Exception(
						"'" + primaryCameraTypeText + "' value is not present in the primary Camera Type drop down");

		}
	}

	public void addShootType(String shootTypeText) throws Exception {
		try {
			// To select 'Shoot type' value
			if (shootTypeText == null) {
				WebAction.click(shootType_Tape);
			} else
				WebAction.click(shootType_Live);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To fill shoot specs. It is applicable only for fulfiller login
	 *
	 * @param primaryCameraType - Primary Camera Type drop down
	 * @param mediaFormat       - media format drop down
	 * @throws Exception
	 */
	public void fillprimaryCameraTypeInFulfillmentSection(String primaryCameraTypeValue) throws Exception {
		try {
			// To select Primary camera type
			if (primaryCameraTypeValue != null) {
				Constants.setPrimaryCameraType(primaryCameraTypeValue);
				boolean valuePresent = false;
				// WebAction.scrollIntoView(primaryCameraType);
				WebAction.click(primaryCameraType);
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(primaryCameraTypeValue)) {
						WebAction.click(ele);
						valuePresent = true;
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception("'" + primaryCameraTypeValue
							+ "' value is not present in the primary camera type drop down");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillmediaFormatInFulfillmentSection(String mediaFormatValue) throws Exception {
		try {
			// To select media format
			if (mediaFormatValue != null) {
				Constants.setMediaFormat(mediaFormatValue);
				boolean valuePresent = false;
				WebAction.click(mediaFormat);
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(mediaFormatValue)) {
						WebAction.click(ele);
						valuePresent = true;
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception("'" + mediaFormatValue + "' value is not present in the media type drop down");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillVideoSpecsInFulfillmentSection(String videoSpecsValue) throws Exception {
		try {
			// To select media format
			if (videoSpecsValue != null) {
				Constants.setVideoSpecs(videoSpecsValue);
				boolean valuePresent = false;
				WebAction.click(videoSpecs);
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(videoSpecsValue)) {
						WebAction.click(ele);
						valuePresent = true;
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception(
							"'" + videoSpecsValue + "' value is not present in the video specs type drop down");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void slugErrorMessage(String slugErrorMessage) {
		CommonValidations.verifyTextValue(slugError, slugErrorMessage);
	}

	public void addTalentInProductionForm(String firstName, String lastName) throws Exception {
		WebAction.clear(talentInput);
		WebAction.sendKeys(talentInput, lastName);
		Waits.waitUntilElementSizeGreater(SearchList, 0);
		WebAction.clickUsingJs(SearchList.get(1));
		// if (namesInTalentRecords.size() == jobTitlesInTalentRecords.size()) {
		// String recordName =
		// WebAction.getText(namesInTalentRecords.get(namesInTalentRecords.size() - 1));
		// String recordJobTitle =
		// WebAction.getText(jobTitlesInTalentRecords.get(jobTitlesInTalentRecords.size()
		// - 1));
		// Constants.getTalents().add(new TalentRecord(recordName, recordJobTitle));
		// }
	}

	/**
	 * To check if section is checked/ticked if filled
	 * 
	 * @param sectionName - section name
	 */
	public void checkIfSectionIsChecked(String sectionName) {
		if (sectionNamesHavingStatusIcon.size() == sectionStatusIcons.size()) {
			for (int itr = 0; itr < sectionNamesHavingStatusIcon.size(); ++itr) {
				String displayedSectionName = WebAction.getText(sectionNamesHavingStatusIcon.get(itr));
				if (displayedSectionName.equalsIgnoreCase(sectionName)) {
					String cssClass = WebAction.getAttribute(sectionStatusIcons.get(itr), "class");
					Assert.assertTrue(cssClass.contains("anticon-check"), "'" + sectionName + "' is not checked");
				}
			}
		}
	}

	public void checkIfSectionIsCrossed(String sectionName) {
		WebDriver driver = getCurrentDriver();
		// List<WebElement> sectionNamesHavingStatusIcon =
		// driver.findElements(sectionNamesHavingStatusIconBy);
		// List<WebElement> sectionStatusIcons =
		// driver.findElements(sectionStatusIconsBy);
		if (sectionNamesHavingStatusIcon.size() == sectionStatusIcons.size()) {
			for (int itr = 0; itr < sectionNamesHavingStatusIcon.size(); ++itr) {
				String displayedSectionName = WebAction.getText(sectionNamesHavingStatusIcon.get(itr));
				if (displayedSectionName.equalsIgnoreCase(sectionName)) {
					String cssClass = WebAction.getAttribute(sectionStatusIcons.get(itr), "class");
					Assert.assertTrue(cssClass.contains("anticon-close"), "'" + sectionName + "' is not crossed");
				}
			}
		}
	}

	/**
	 * To check if section is not checked/ticked if not filled
	 * 
	 * @param sectionName - section name
	 */
	public void checkIfSectionIsNeitherCheckedNorCrossed(String sectionName) {
		WebDriver driver = getCurrentDriver();
		// List<WebElement> sectionNamesHavingStatusIcon =
		// driver.findElements(sectionNamesHavingStatusIconBy);
		// List<WebElement> sectionStatusIcons =
		// driver.findElements(sectionStatusIconsBy);
		if (sectionNamesHavingStatusIcon.size() == sectionStatusIcons.size()) {
			for (int itr = 0; itr < sectionNamesHavingStatusIcon.size(); ++itr) {
				String displayedSectionName = WebAction.getText(sectionNamesHavingStatusIcon.get(itr));
				if (displayedSectionName.equalsIgnoreCase(sectionName)) {
					String cssClass = WebAction.getAttribute(sectionStatusIcons.get(itr), "class");
					Assert.assertTrue(
							cssClass.contains("anticon-") && !cssClass.contains("anticon-close")
									&& !cssClass.contains("anticon-check"),
							"'" + sectionName + "' is either checked or crossed");
				}
			}
		}
	}

	/**
	 * To verify added crew in the form
	 * 
	 * @param setCrew - Set Crew details
	 */
	public void verifyAddedCrew(String setCrew) {
		String[] setCrewList = null;
		try {
			if (setCrew != null) {
				if (setCrew.contains(",")) {
					setCrewList = setCrew.split(",");
				}
				if (setCrewList != null) {
					for (String setCrewName : setCrewList) {
						for (int i = 0; i < addedSetCrew.size(); i++) {
							String addedSetCrewName = WebAction.getText(addedSetCrew.get(i));
							Assert.assertEquals(addedSetCrewName, setCrewName);
						}
					}
				} else {
					for (int i = 0; i < addedSetCrew.size(); i++) {
						String addedSetCrewName = WebAction.getText(addedSetCrew.get(i));
						Assert.assertEquals(addedSetCrewName, setCrew);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * To verify added control crew in the form
	 * 
	 * @param controlRoomCrew - control room Crew details
	 */
	public void verifyAddedControlCrew(String controlRoomCrew) {
		String[] setCrewList = null;
		try {
			if (controlRoomCrew != null) {
				if (controlRoomCrew.contains(",")) {
					setCrewList = controlRoomCrew.split(",");
				}
				if (setCrewList != null) {
					for (String setCrewName : setCrewList) {
						for (int i = 0; i < addedControlRoomCrew.size(); i++) {
							String addedSetCrewName = WebAction.getText(addedControlRoomCrew.get(i));
							Assert.assertEquals(addedSetCrewName, setCrewName);
						}
					}
				} else {
					for (int i = 0; i < addedControlRoomCrew.size(); i++) {
						String addedSetCrewName = WebAction.getText(addedControlRoomCrew.get(i));
						Assert.assertEquals(addedSetCrewName, controlRoomCrew);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void verifyAddedAdditionalControlCrew(String AdditionalCrew) {
		String[] additionalCrewList = null;
		try {
			if (AdditionalCrew != null) {
				if (AdditionalCrew.contains(",")) {
					additionalCrewList = AdditionalCrew.split(",");
				}
				if (additionalCrewList != null) {
					for (String setCrewName : additionalCrewList) {
						for (int i = 0; i < additionalAddedCrew.size(); i++) {
							String addedSetCrewName = WebAction.getText(additionalAddedCrew.get(i));
							Assert.assertEquals(addedSetCrewName, setCrewName);
						}
					}
				} else {
					for (int i = 0; i < additionalAddedCrew.size(); i++) {
						String addedSetCrewName = WebAction.getText(additionalAddedCrew.get(i));
						Assert.assertEquals(addedSetCrewName, AdditionalCrew);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void verifyRequestInEditState() {
		Assert.assertTrue(WebAction.getText(editingStateBanner).equalsIgnoreCase("EDITING"),
				"Request is not in edit mode");
	}

	public void verifyButtonsOnRequest() {
		Assert.assertTrue(WebAction.getText(cancelButton).equalsIgnoreCase("Cancel Request"),
				"Cancel button not present on the request");
		Assert.assertTrue(WebAction.getText(discardButton).equalsIgnoreCase("Discard Changes"),
				"Discard Changes button not present on the request");
		Assert.assertTrue(WebAction.getText(saveButton).equalsIgnoreCase("Save"),
				"Save button not present on the request");
	}

	public void addNoteInFulfillementTab(String Notes) throws Exception {
		WebAction.click(notesTab);
		WebAction.sendKeys(notesInputArea, Notes);
		WebAction.click(noteAddButton);
		Assert.assertTrue(WebAction.getText(requesterNoteTag).equalsIgnoreCase("Requester"),
				"Requester tag not present on note");
		Assert.assertEquals(WebAction.getText(noteDisplayed.get(0)), Notes);
	}

	public void verifyStatusOfRequest() {
		Assert.assertEquals(WebAction.getText(requestStatus), "MODIFIED", "The status of the request not changed");
	}

	public void editAddedNote(String editedNote) throws Exception {
		WebAction.scrollIntoView(requesterNoteTag);

		for (int i = 0; i < noteDisplayed.size(); i++) {
			WebAction.click(editButtonDisplayed);
			WebAction.sendKeys(textArea, editedNote + " added");
			WebAction.click(noteSavebutton);
		}
		WebAction.click(saveButton);

	}

	public void verifyEditedNote(String editedNote) throws Exception {
		clickButton("OK");
		myRequestPage.searchRequest();
		clickEditLink();
		WebAction.scrollIntoView(requesterNoteTag);
		Assert.assertEquals(WebAction.getText(noteDisplayed.get(0)), editedNote + " added");
	}

	public void deleteAddedNote() throws Exception {
		WebAction.scrollIntoView(requesterNoteTag);
		for (int i = 0; i < noteDisplayed.size(); i++) {
			WebAction.click(deleteButton);
			WebAction.click(okButton);
		}
		WebAction.click(saveButton);
	}

	public void producerErrorMessage(String producerErrorMessage) {
		CommonValidations.verifyTextValue(producerError, producerErrorMessage);
	}

	public void srProducerOrApproverErrorMessage(String srProducerOrApproverErrorMessage) {
		CommonValidations.verifyTextValue(srProducerOrApproverError, srProducerOrApproverErrorMessage);
	}

	public void isThereAnOnsiteProducerErrorMessage(String isThereAnOnsiteProducerErrorMessage) {
		CommonValidations.verifyTextValue(isThereAnOnsiteProducerError, isThereAnOnsiteProducerErrorMessage);
	}

	public void producerCellNumberErrorMessage(String producerCellNumberErrorMessage) {
		CommonValidations.verifyTextValue(producerCellNumberError, producerCellNumberErrorMessage);
	}

	public void showTitleBudgetCodeErrorMessage(String showTitleBudgetCodeErrorMessage) {
		CommonValidations.verifyTextValue(showTitleBudgetCodeError, showTitleBudgetCodeErrorMessage);
	}

	public void productionTypeErrorMessage(String productionTypeErrorMessage) {
		CommonValidations.verifyTextValue(productionTypeError, productionTypeErrorMessage);
	}

	public void shootTypeErrorMessage(String shootTypeErrorMessageMessage) {
		CommonValidations.verifyTextValue(shootTypeError, shootTypeErrorMessageMessage);
	}

	public void shootDescriptionErrorMessage(String shootDescriptionErrorMessage) {
		CommonValidations.verifyTextValue(shootDescriptionError, shootDescriptionErrorMessage);
	}

	public void audioNeedsErrorMessage(String audioNeedsErrorMessage) {
		CommonValidations.verifyTextValue(audioNeedsError, audioNeedsErrorMessage);
	}

	public void specialConditionsErrorMessage(String specialConditionsErrorMessage) {
		CommonValidations.verifyTextValue(specialConditionsError, specialConditionsErrorMessage);
	}

	public void transmissionTypeErrorMessage(String transmissionTypeErrorMessage) {
		CommonValidations.verifyTextValue(transmissionTypeError, transmissionTypeErrorMessage);
	}

	public void primaryCameraTypeErrorMessage(String primaryCameraTypeErrorMessage) {
		CommonValidations.verifyTextValue(primaryCameraTypeError, primaryCameraTypeErrorMessage);
	}

	public void acquisitionSpecsErrorMessage(String acquisitionSpecsErrorMessage) {
		CommonValidations.verifyTextValue(acquisitionSpecsError, acquisitionSpecsErrorMessage);
	}

	public void droneShootErrorMessage(String droneShootErrorMessage) {
		CommonValidations.verifyTextValue(droneShootError, droneShootErrorMessage);
	}

	public void addressLine1ErrorMessage(String addressLine1ErrorMessage) {
		CommonValidations.verifyTextValue(addressLine1Error, addressLine1ErrorMessage);
	}

	public void cityErrorMessage(String cityErrorMessage) {
		CommonValidations.verifyTextValue(cityError, cityErrorMessage);
	}

	public void stateErrorMessage(String stateErrorMessage) {
		CommonValidations.verifyTextValue(stateError, stateErrorMessage);
	}

	public void countryErrorMessage(String countryErrorMessage) {
		CommonValidations.verifyTextValue(countryError, countryErrorMessage);
	}

	public void shootDatesErrorMessage(String shootDatesErrorMessage) {
		CommonValidations.verifyTextValue(shootDatesError, shootDatesErrorMessage);
	}

	public void timeZoneErrorMessage(String timeZoneErrorMessage) {
		CommonValidations.verifyTextValue(timeZoneError, timeZoneErrorMessage);
	}

	public void meetTimeErrorMessage(String meetTimeErrorMessage) {
		CommonValidations.verifyTextValue(meetTimeError, meetTimeErrorMessage);
	}

	public void rollTimeErrorMessage(String rollTimeErrorMessage) {
		CommonValidations.verifyTextValue(rollTimeError, rollTimeErrorMessage);
	}

	public void endTimeCrewErrorMessage(String endTimeCrewErrorMessage) {
		CommonValidations.verifyTextValue(endTimeCrewError, endTimeCrewErrorMessage);
	}

	public void prodUserNumberErrorMessage(String prodUserNumberErrorMessage) {
		CommonValidations.verifyTextValue(prodUserNumberError, prodUserNumberErrorMessage);
	}

	public void showUnitorProjectNameErrorMessage(String showUnitorProjectNameErrorMessage) {
		CommonValidations.verifyTextValue(showUnitorProjectNameError, showUnitorProjectNameErrorMessage);
	}

	public void segmentTypeErrorMessage(String segmentTypeErrorMessage) {
		CommonValidations.verifyTextValue(segmentTypeError, segmentTypeErrorMessage);
	}

	public void gearLocationErrorMessage(String locationErrorMessage) {
		CommonValidations.verifyTextValue(gearLocationError, locationErrorMessage);
	}

	public void pickUpDateErrorMessage(String pickUpDateErrorMessage) {
		CommonValidations.verifyTextValue(pickUpDateError, pickUpDateErrorMessage);
	}

	public void pickUpTimeErrorMessage(String pickUpTimeErrorMessage) {
		CommonValidations.verifyTextValue(pickUpTimeError, pickUpTimeErrorMessage);
	}

	public void returnDateErrorMessage(String returnDateErrorMessage) {
		CommonValidations.verifyTextValue(returnDateError, returnDateErrorMessage);
	}

	public void hiddenCameraMicroErrorMessage(String hiddenCameraMicroErrorMessage) {
		CommonValidations.verifyTextValue(hiddenCameraMicroError, hiddenCameraMicroErrorMessage);
	}

	public void outsideUsErrorMessage(String outsideUsErrorMessage) {
		CommonValidations.verifyTextValue(outsideUsError, outsideUsErrorMessage);
	}

	public void nbcStudioLocationErrorMessage(String nbcStudioLocationErrorMessage) {
		CommonValidations.verifyTextValue(nbcStudioLocationError, nbcStudioLocationErrorMessage);
	}

	public void outsiderErrorMessage(String outsiderErrorMessage) {
		CommonValidations.verifyTextValue(outsiderError, outsiderErrorMessage);
	}

	public void descriptionErrorMessage(String descriptionErrorMessage) {
		CommonValidations.verifyTextValue(descriptionError, descriptionErrorMessage);
	}

	public void editOfLocationErrorMessage(String editOfLocationErrorMessage) {
		CommonValidations.verifyTextValue(editOfLocationError, editOfLocationErrorMessage);
	}

	public void editStartDateErrorMessage(String editStartDateErrorMessage) {
		CommonValidations.verifyTextValue(editStartDateError, editStartDateErrorMessage);
	}

	public void whoIsEditingErrorMessage(String whoIsEditingErrorMessage) {
		CommonValidations.verifyTextValue(whoIsEditingError, whoIsEditingErrorMessage);
	}

	public void typeofEditErrorMessage(String typeofEditErrorMessage) {
		CommonValidations.verifyTextValue(typeofEditError, typeofEditErrorMessage);
	}

	public void quantityErrorMessage(String quantityErrorMessage) {
		CommonValidations.verifyTextValue(quantityError, quantityErrorMessage);
	}

	public void dateNeededByErrorMessage(String dateNeededByErrorMessage) {
		CommonValidations.verifyTextValue(dateNeededByError, dateNeededByErrorMessage);
	}

	public void timeNeededByErrorMessage(String timeNeededByErrorMessage) {
		CommonValidations.verifyTextValue(timeNeededByError, timeNeededByErrorMessage);
	}

	public void sourceErrorMessage(String sourceErrorMessage) {
		CommonValidations.verifyTextValue(sourceError, sourceErrorMessage);
	}

	public void contentDescriptionErrorMessage(String contentDescriptionErrorMessage) {
		CommonValidations.verifyTextValue(contentDescriptionError, contentDescriptionErrorMessage);
	}

	public void timeCodesErrorMessage(String timeCodesErrorMessage) {
		CommonValidations.verifyTextValue(timeCodesError, timeCodesErrorMessage);
	}

	public void destinationErrorMessage(String destinationErrorMessage) {
		CommonValidations.verifyTextValue(destinationError, destinationErrorMessage);
	}

	public void updateCameraOps(String cameraOps) throws Exception {
		for (int i = 0; i <= Integer.parseInt(cameraOps); i++) {
			WebAction.mouseOverClick(cameraOpsUp);
		}
		String a = WebAction.getText(estimatedCost);
		if (!a.equals(estimateCost))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
		// Assert.assertNotEquals(a, estimateCost, "As expected Estimated cost
		// changed");
		estimateCost = WebAction.getText(estimatedCost);
		intialEstimateCost = WebAction.getText(estimatedCost);
	}

	public void updateAudioOps(String audioOps) throws Exception {
		for (int i = 0; i <= Integer.parseInt(audioOps); i++) {
			WebAction.mouseOverClick(audioOpsUp);
		}

		Assert.assertNotEquals(WebAction.getText(estimatedCost), estimateCost, "As expected Estimated cost changed");
		estimateCost = WebAction.getText(estimatedCost);
	}

	public void updateUtilityOps(String utilityOps) throws Exception {
		for (int i = 0; i <= Integer.parseInt(utilityOps); i++) {
			WebAction.mouseOverClick(utilityOpsUp);
		}
		Assert.assertNotEquals(WebAction.getText(estimatedCost), estimateCost, "As expected Estimated cost changed");
		estimateCost = WebAction.getText(estimatedCost);
	}

	public void estimatedCostUpdate() {
		finalEstimateCost = WebAction.getText(estimatedCost);
		Assert.assertNotEquals(finalEstimateCost, intialEstimateCost, "As expected Estimated cost changed");
		String finalEstimateCost1 = WebAction.getText(estimatedCost);
	}

	public void verifyNoficationMsg(String notification) {
		WebAction.scrollIntoView(viewEstimatedCostBreakdown);
		Assert.assertEquals(WebAction.getText(resourceIncreaseNotificationMsg), notification);
	}

	public void verifyCalculatorOverlay() throws Exception {
		WebAction.isDisplayed(calculatorOverlay);
		Assert.assertEquals(finalEstimateCost, calculatorOverlayEstimatedCost.getText(),
				"As expected Estimated cost showing correctly in Calculator Overlay");
		WebAction.click(calculatorOverlayCloseBtn);
	}

	public void verifyDisclaimer(String notification2) {
		Assert.assertEquals(WebAction.getText(disclaimerMsg), notification2);
	}

	public void verifyMissingFieldsMsg(String missingFieldAlertMsg) {
		WebAction.isDisplayed(
				DriverFactory.getCurrentDriver().findElement(By.xpath("//*[text()='" + missingFieldAlertMsg + "']")));
	}

	public void verifyTheOverrideInfoSectionIsGettingVisible(String info) {
		WebAction.isDisplayed(
				DriverFactory.getCurrentDriver().findElement(By.xpath("//*[@sectiontitle='" + info + "']")));
	}

	public void addResourceReason(String resourceReasonValue) throws Exception {
		if (resourceReason != null) {
			boolean valuePresent = false;
			WebAction.clickUsingJs(resourceReason);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (WebElement ele : dropDownvalues) {
				if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(resourceReasonValue)) {
					WebAction.click(ele);
					valuePresent = true;
					break;
				}
			}
			if (valuePresent == false)
				throw new Exception("'" + resourceReasonValue + "' value is not present in the Audio Needs drop down");
		}
	}

	public void addDescription(String description) {
		WebAction.sendKeys(resourceReasonDesc, description);
	}

	public void verifyStatusOnLog(String status) {
		try {
			WebAction.click(logsTab);
			Assert.assertTrue(WebAction.getText(logStatus.get(0)).equalsIgnoreCase(status));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyDetailsonLog() {
		String[] expectedLogDetails = { "Request is moved to Modified Status", "Changed Requestor Notes" };
		Assert.assertEquals(WebAction.getText(logDetail), expectedLogDetails[0] + ", " + expectedLogDetails[1]);
	}

	public void verifyStatusTab() {
		try {
			if (statusTabFulfilment.size() > 0) {
				Assert.assertTrue(false, "Requester is logged in, the status tab is correctly not present");
			} else {
				Assert.assertTrue(true, "Fulfiller is logged in, the status tab is present");
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void verifyEditButtonNotPresent() {
		try {
			if (editButtonOnFrom.size() > 0) {
				Assert.assertTrue(false, "edit button is not present on the request");
			} else {
				Assert.assertTrue(true, "edit button is present on the request");
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void verifyNoteIsDeleted() {

		try {
			clickButton("OK");
			myRequestPage.searchRequest();
			clickEditLink();
			if (noteDisplayed.size() > 1) {
				Assert.assertTrue(false, "note is not present on the request");
			} else {
				Assert.assertTrue(true, "note is present on the request");
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyRevisionHighlight(String highlightedElement, String typeOfCss, String expectedColor,
			io.cucumber.datatable.DataTable dataTable) {
		if (highlightedElement.equalsIgnoreCase("revisedNote")) {
			WebAction.scrollIntoView(requesterNoteTag);
			CommonValidations.verifyCssValueOfWebElement(revisedNote, typeOfCss, expectedColor);
		} else if (highlightedElement.equalsIgnoreCase("revisedTalent")) {
			CommonValidations.verifyCssValueOfWebElement(revisedTalent, typeOfCss, expectedColor);
		} else if (highlightedElement.equalsIgnoreCase("revisedPurpose")) {
			CommonValidations.verifyCssValueOfWebElement(revisedRequestFor, typeOfCss, expectedColor);
		} else if (highlightedElement.equalsIgnoreCase("revisedShowInfo")) {
			CommonValidations.verifyCssValueOfWebElement(revisedAirPlatform, typeOfCss, expectedColor);
			CommonValidations.verifyCssValueOfWebElement(showInputBox, typeOfCss, expectedColor);
			CommonValidations.verifyCssValueOfWebElement(revisedBudgetCode, typeOfCss, expectedColor);

		}

		else if (highlightedElement.equalsIgnoreCase("revisedSetLocation")) {
			if (CucumberUtils.getValuesFromDataTable(dataTable, "Form Name").equalsIgnoreCase("CNBC")) {
				CommonValidations.verifyCssValueOfWebElement(revisedLocation, typeOfCss, expectedColor);
			} else {
				CommonValidations.verifyCssValueOfWebElement(revisedLocation, typeOfCss, expectedColor);
			}
		}

		else if (highlightedElement.equalsIgnoreCase("revisedSetCrew")) {
			if (CucumberUtils.getValuesFromDataTable(dataTable, "Form Name")
					.equalsIgnoreCase("Single Camera Live Shot")) {
				if (CucumberUtils.getValuesFromDataTable(dataTable, "Capture Manager").equalsIgnoreCase("No")) {
					CommonValidations.verifyCssValueOfWebElement(captureManager_No, typeOfCss, expectedColor);
				} else {
					CommonValidations.verifyCssValueOfWebElement(captureManager_Yes, typeOfCss, expectedColor);
				}
			}
			CommonValidations.verifyCssValueOfWebElement(revisedSetCrew, typeOfCss, expectedColor);
		}

		else if (highlightedElement.equalsIgnoreCase("revisedControlRoom")) {
			CommonValidations.verifyCssValueOfWebElement(revisedControlRoomLocation, typeOfCss, expectedColor);
			CommonValidations.verifyCssValueOfWebElement(revisedControlRoom, typeOfCss, expectedColor);
		} else if (highlightedElement.equalsIgnoreCase("revisedControlRoomCrew")) {
			if (CucumberUtils.getValuesFromDataTable(dataTable, "Capture Manager").equalsIgnoreCase("No")) {
				CommonValidations.verifyCssValueOfWebElement(captureManager_No, typeOfCss, expectedColor);
			} else {
				CommonValidations.verifyCssValueOfWebElement(captureManager_Yes, typeOfCss, expectedColor);
			}
		} else if (highlightedElement.equalsIgnoreCase("revisedControlRoomCrewCNBC")) {
			if (CucumberUtils.getValuesFromDataTable(dataTable, "Ingest").equalsIgnoreCase("Yes")) {
				CommonValidations.verifyCssValueOfWebElement(ingest_Yes, typeOfCss, expectedColor);
			} else if (CucumberUtils.getValuesFromDataTable(dataTable, "Ingest").equalsIgnoreCase("No")) {
				CommonValidations.verifyCssValueOfWebElement(ingest_No, typeOfCss, expectedColor);
			}
			if (CucumberUtils.getValuesFromDataTable(dataTable, "Iso").equalsIgnoreCase("Yes")) {
				CommonValidations.verifyCssValueOfWebElement(iso_Yes, typeOfCss, expectedColor);
			} else if (CucumberUtils.getValuesFromDataTable(dataTable, "Iso").equalsIgnoreCase("No")) {
				CommonValidations.verifyCssValueOfWebElement(iso_No, typeOfCss, expectedColor);
			}
		}

		else if (highlightedElement.equalsIgnoreCase("revisedAdditionalCrew")) {
			CommonValidations.verifyCssValueOfWebElement(revisedAdditionalCrew, typeOfCss, expectedColor);
		} else if (highlightedElement.equalsIgnoreCase("revisedSystem")) {
			CommonValidations.verifyCssValueOfWebElement(revisedUltimatte, typeOfCss, expectedColor);

		}

		else if (highlightedElement.equalsIgnoreCase("revisedStagingRockCenter")) {
			CommonValidations.verifyCssValueOfWebElement(isCarpentryNeeded_No, typeOfCss, expectedColor);
			CommonValidations.verifyCssValueOfWebElement(isLightingNeeded_No, typeOfCss, expectedColor);
			CommonValidations.verifyCssValueOfWebElement(isPropsNeeded_No, typeOfCss, expectedColor);

		} else if (highlightedElement.equalsIgnoreCase("revisedStagingCNBC")) {
			CommonValidations.verifyCssValueOfWebElement(DescribeStagingNeedsTextarea, typeOfCss, expectedColor);
		} else if (highlightedElement.equalsIgnoreCase("revisedTpmTmName")) {
			CommonValidations.verifyCssValueOfWebElement(tpmTmName, typeOfCss, expectedColor);
		} else if (highlightedElement.equalsIgnoreCase("revisedDetails")) {
			CommonValidations.verifyCssValueOfWebElement(detailsAndNotesTextarea, typeOfCss, expectedColor);
		} else if (highlightedElement.equalsIgnoreCase("revisedSetInfo")) {
			CommonValidations.verifyCssValueOfWebElement(revisedSetBackgroundDropdown, typeOfCss, expectedColor);
			if (CucumberUtils.getValuesFromDataTable(dataTable, "Set Staging Needed").equalsIgnoreCase("No")) {
				CommonValidations.verifyCssValueOfWebElement(setStagingNeeded_No, typeOfCss, expectedColor);
			} else {
				CommonValidations.verifyCssValueOfWebElement(setStagingNeeded_Yes, typeOfCss, expectedColor);
			}
		}

	}

	/**
	 * To verify resource count as per Production Type and Audio Needs , Special
	 * Conditions
	 * 
	 * @throws Exception
	 */
	public void verifyResourceCount(String productionTypeText, String audioNeedsText, String specialConditionsText,
			String expectedResourceCount) throws Exception {
		try {
			int actualResourceCount = 0;
			switch (expectedResourceCount.toUpperCase()) {
			case "2 FULL CREWS":
				expectedResourceCount = "4";
				break;
			case "FULL CREW":
				expectedResourceCount = "2";
				break;
			case "OMB":
				expectedResourceCount = "1";
				break;
			case "FULL CREW + OMB":
				expectedResourceCount = "3";
				break;
			}
			// verify actual suggested resources
			WebElement actualResourceCountXpath = driver
					.findElement(By.xpath("(//*[@sectiontitle='Resources']//*[contains(@class,'resource')]/div)[2]/p"));
			WebAction.scrollIntoView(actualResourceCountXpath);
			if (expectedResourceCount.equalsIgnoreCase("NO CREW")) {
				expectedResourceCount = "#";
				CommonValidations.verifyTextValue(actualResourceCountXpath, expectedResourceCount);
			} else {
				actualResourceCount = Integer.parseInt(actualResourceCountXpath.getText());
				CommonValidations.verifytextValue(actualResourceCount, Integer.parseInt(expectedResourceCount));
			}
			System.out.println("Number of Suggested Resources displayed : " + actualResourceCount);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyAddedTalentsDisplayedInReadOnlyForm() {
		List<TalentRecord> talents = Constants.getTalents();
		int count = talentNamesInTalentSectionInReadOnlyMode.size();
		Assert.assertEquals(count, talents.size(), "Count of talent resources shown is not same as added earlier");
		SoftAssert softAssert = new SoftAssert();
		for (int talentPos = 0; talentPos < count; ++talentPos) {
			softAssert.assertEquals(getText(labelsInTalentSectionInReadOnlyMode.get(talentPos)), "Talent");
			softAssert.assertEquals(getText(talentNamesInTalentSectionInReadOnlyMode.get(talentPos)),
					talents.get(talentPos).getName(), "Name of Talent resource not same as added earlier");
		}
		softAssert.assertAll();
	}

	public void verifyStatusOfTheRequest(String expectedStatus) {
		String statusTitle = getText(statusTitleInStatusSection);
		Assert.assertEquals(statusTitle, expectedStatus, "Status of the request is not correct");
		String cssClasses = statusIconInStatusSection.getAttribute("class");
		RequestStatus status = RequestStatus.valueOf(expectedStatus);
		String expectedClass = "anticon";
		if (status == RequestStatus.COMPLETED) {
			expectedClass.concat(" anticon-check-circle");
		} else if (status == RequestStatus.NEW) {
			expectedClass.concat(" anticon-star");
		} else if (status == RequestStatus.MODIFIED) {
			expectedClass.concat(" anticon-exclamation-circle");
		}
		Assert.assertTrue(cssClasses.contains(expectedClass),
				String.format("Status icon beside request status %s is not correct", expectedStatus));
	}

	public void checkPlaceholderForInputsHavingPlaceholderAttribute(String field) {
		// verify the placeholder of the inputs or textarea that has placeholder
		// attribute
		WebElement element = getInputElement(field);
		String displayed = WebAction.getAttribute(element, "placeholder");
		String expected = getExpectedPlaceholder(field);
		Assert.assertEquals(displayed.trim(), expected, "Placeholder for '" + field + "' textarea is not correct");
	}

	public WebElement getInputElement(String fieldName) {
		if (fieldName.equals("Talent")) {
			return talentInput;
		}
		return null;
	}

	public String getExpectedPlaceholder(String field) {
		if (field.equals("Talent")) {
			return "Search or Enter Correspondent, Anchor, Host, Guest Name(s)";
		}
		return "";
	}

	public void waitForLoadingSpinnerToDisappear() throws Exception {
		Waits.waitForElement(By.xpath("//*[contains(@class,'ant-spin-dot-spin')]"), WAIT_CONDITIONS.INVISIBLE);
	}

	public void addTalent(String names, RequestMode... mode) throws Exception {
		WebAction.scrollIntoView(talentInput);
		Comparator<String> com = (o1, o2) -> {
			return 0;
		};
		Consumer<String> consumeFun = (talent) -> {
			try {
				String name = talent.trim();
				talentInput.sendKeys(name);
//				Waits.waitUntilElementSizeEquals(loadingIconInTalentList, 1);
//				Waits.waitUntilElementSizeEquals(loadingIconInTalentList, 0);
				waitForOptionToBeVisible(SearchList, name);
				Predicate<WebElement> filteringFun = (op) -> WebAction.getText(op).trim().contains(name);
				Optional<WebElement> maybeOption = talentOptions.stream().filter(filteringFun).findFirst();
				if (maybeOption.isPresent()) {
					String jobTitle = "";
					WebElement element = maybeOption.get();
					String[] parts = getText(element).split("-");
					if (parts.length == 2) {
						jobTitle = parts[1].trim();
					}
					WebAction.click(element);
					String jobTitle2 = jobTitle;
					Runnable store = () -> {
						if (isEditMode(mode)) {
							Constants.getLog().getLogs().putLog("Changed Talent Section", null);
							changeStatusOnRequestUpdate();
						}
						Constants.getTalents().add(new TalentRecord(name, jobTitle2));
					};
					executeStorage(name, store, mode);
				}
				WebAction.clear(talentInput);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		// talent names separated by '&' symbol
		Arrays.asList(names.split("&")).forEach(consumeFun);
	}

	public void verifyLoggedInUserIsAddedAsRequesterInProductionForm() {
		RequesterRecord defaultRequester = Constants.getRequesters().get(0);
		String name = defaultRequester.getName();
		String jobTitle = defaultRequester.getJobTitle();
		Assert.assertTrue(
				requesterNames.size() > 0 && getText(requesterNames.get(0)).equals(name)
						&& getText(requesterJobTitles.get(0)).equals(jobTitle),
				"Logged in user is not automatically added to Requesters section");
	}

	public void verifyRequestersOfTheRequest() {
		List<RequesterRecord> requesters = Constants.getRequesters();
		Assert.assertEquals(requesterNames.size(), requesters.size(),
				"Count of requesters added is not same as added earlier");
		SoftAssert softAssert = new SoftAssert();
		for (int requesterIndex = 0; requesterIndex < requesters.size(); ++requesterIndex) {
			RequesterRecord requester = requesters.get(requesterIndex);
			String displayedName = getText(requesterNames.get(requesterIndex));
			String displayedJobTitle = getText(requesterJobTitles.get(requesterIndex));
			softAssert.assertEquals(displayedName, requester.getName(), "Requester name is not same as added");
			softAssert.assertEquals(displayedJobTitle, requester.getJobTitle(),
					"Requester Job Title is not same as added");
		}
		softAssert.assertAll();
	}

	public void addRequester(String requester, RequestMode... mode) throws Exception {
		WebAction.scrollIntoView(addRequester);
		try {
			WebAction.sendKeys(addRequester, requester);
//			Waits.waitUntilElementSizeEquals(loadingIconInRequestersList, 1);
//			Waits.waitUntilElementSizeEquals(loadingIconInRequestersList, 0);
			waitForOptionToBeVisible(SearchList, requester);
			Optional<WebElement> optional = SearchList.stream().filter((ele) -> getText(ele).trim().contains(requester))
					.findFirst();
			if (optional.isPresent()) {
				WebElement record = optional.get();
				String nameWithJobTitle = getText(record);
				WebAction.click(record);
				Runnable store = () -> {
					if (isEditMode(mode)) {
						Constants.getLog().getLogs().putLog("Changed Requester Section", null);
						changeStatusOnRequestUpdate();
					}
					Constants.getRequesters()
							.add(new RequesterRecord(requester, nameWithJobTitle.split("-")[1].trim()));
				};
				executeStorage(requester, store, mode);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void setLoggedInUserAsDefaultRequester(String role) {
		try {
			String name = null, jobTitle = null;
			if (role.equalsIgnoreCase("Producer")) {
				name = ConfigFileReader.getProperty("producer-name");
				jobTitle = ConfigFileReader.getProperty("producer-job-title");
			}
			// logged in user will the first and default requester
			if (Constants.getRequesters().size() == 0 && name != null && jobTitle != null) {
				Constants.getRequesters().add(new RequesterRecord(name, jobTitle));
			}
		} catch (Exception e) {
			;
		}
	}

	/**
	 * To verify values in the rock center form are present in production dashboard
	 * columns
	 * 
	 * @throws Exception
	 */
	public void verifyRockCenterRequestValuesWithProductionDashboardValues(String additionalRequestersText,
			String ProdDateText, String ShowProjectText, String ProductionPurposeText, String SetLocationText,
			String ControlRoomText, String PositionsText, String SubmittedText) throws Exception {
		try {
			String formType = Constants.getFormType();
			String requestNumber = Constants.getRequestNumber();
			// String requestNumber = "SR-08302024-00316914";
			String columnCellString = "//a[contains(text(),'<<RequestId>>')]/ancestor::tr/td[contains(@class,'<<ColumnType>>')]";
			verifyStatusColorBaseOnProductionDateInDashboard(requestNumber, columnCellString);

			// To validate workflow of the request
			List<String> workflowList = new ArrayList<String>();
			if (formType.equalsIgnoreCase("Rock Center") || formType.equalsIgnoreCase("Single Camera Live Shot")
					|| formType.equalsIgnoreCase("Extend Or Bridge Crew & Facilities")) {
				workflowList.add("T");
				boolean technicalStatus = ProducerDashboardGeneralPage.technicalCheckedIn;
				if (technicalStatus) {
					for (int i = 0; i < workflowList.size(); i++) {
						String updatedStr = workflowList.get(i).replace("T", "✔");
						workflowList.set(i, updatedStr);
					}
				}
			}

			String stageingNeeded = Constants.getStagingNeeds();
			if (stageingNeeded != null && stageingNeeded.equalsIgnoreCase("YES")) {
				workflowList.add("S");
				boolean stagingStatus = ProducerDashboardGeneralPage.stagingCheckedIn;
				if (stagingStatus) {
					for (int i = 0; i < workflowList.size(); i++) {
						String updatedStr = workflowList.get(i).replace("S", "✔");
						workflowList.set(i, updatedStr);
					}
				}
			}

			List<String> controlRoomCrewNamesList = new ArrayList<String>();
			List<CrewRecord> controlRoomCrewStringList = Constants.getControlRoomCrew();
			for (CrewRecord controlRoomCrew : controlRoomCrewStringList) {
				controlRoomCrewNamesList.add(controlRoomCrew.getCrewName());
			}
			for (String controlRoomCrewAbb : controlRoomCrewNamesList) {
				switch (controlRoomCrewAbb.toUpperCase()) {
				case "VIDEO PLAYBACK":
					workflowList.add("D");
					boolean DPSPlaybackStatus = ProducerDashboardGeneralPage.DPSPlaybackCheckedIn;
					if (DPSPlaybackStatus) {
						for (int i = 0; i < workflowList.size(); i++) {
							String updatedStr = workflowList.get(i).replace("D", "✔");
							workflowList.set(i, updatedStr);
						}
					}
					break;
				}
			}

			List<String> setCrewNamesList = new ArrayList<String>();
			List<CrewRecord> setCrewStringList = Constants.getSetCrew();
			for (CrewRecord setCrew : setCrewStringList) {
				setCrewNamesList.add(setCrew.getCrewName());
			}
			boolean workflowListAdded = false;
			for (String setCrewAbb : setCrewNamesList) {
				switch (setCrewAbb.trim().toUpperCase()) {
				case "MAKEUP ARTIST":
				case "HAIR STYLIST":
				case "WARDROBE DRESSER":
					if (!workflowListAdded) {
						workflowList.add("H");
						boolean hairMakeupWardrobeStatus = ProducerDashboardGeneralPage.hairMakeupWardrobeCheckedIn;
						if (hairMakeupWardrobeStatus) {
							for (int i = 0; i < workflowList.size(); i++) {
								String updatedStr = workflowList.get(i).replace("H", "✔");
								workflowList.set(i, updatedStr);
							}
						}
						workflowListAdded = true;
					}

					break;
				}
			}

			String locationNames = Constants.getLocations();
			if (locationNames != null) {
				String[] locationText;
				if (locationNames.contains(",")) {
					locationText = locationNames.split(",");
				} else {
					locationText = new String[1];
					locationText[0] = locationNames;
				}
				for (int i = 0; i < locationText.length; i++) {
					switch (locationText[i].trim().toUpperCase()) {
					case "DC":
						workflowList.add("D");
						boolean dcFulfillmentStatus = ProducerDashboardGeneralPage.dcFulfillmentCheckedIn;
						if (dcFulfillmentStatus) {
							for (int k = 0; k < workflowList.size(); k++) {
								String updatedStr = workflowList.get(k).replace("D", "✔");
								workflowList.set(k, updatedStr);
							}
						}
						break;
					case "LA":
						workflowList.add("L");
						boolean laFulfillmentStatus = ProducerDashboardGeneralPage.laFulfillmentCheckedIn;
						if (laFulfillmentStatus) {
							for (int j = 0; j < workflowList.size(); j++) {
								String updatedStr = workflowList.get(j).replace("L", "✔");
								workflowList.set(j, updatedStr);
							}
						}
						break;
					}
				}
			}

			String captureManagerOption = Constants.getCaptureManagerOption();
			if (captureManagerOption != null && captureManagerOption.equalsIgnoreCase("YES")) {
				workflowList.add("✔");
			}

			if (formType.equalsIgnoreCase("Rock Center")
					|| formType.equalsIgnoreCase("Extend Or Bridge Crew & Facilities")) {
				String isTpmOrTmNeeded = Constants.getTpmOrTmInformation().toString();
				System.out.println(isTpmOrTmNeeded);
				if (isTpmOrTmNeeded != null) {
					workflowList.add("M");
					boolean tmtpmStatus = ProducerDashboardGeneralPage.tmtpmCheckedIn;
					if (tmtpmStatus) {
						for (int i = 0; i < workflowList.size(); i++) {
							String updatedStr = workflowList.get(i).replace("M", "✔");
							workflowList.set(i, updatedStr);
						}
					}
				}
			}

			List<String> additionalCrewNamesList = new ArrayList<String>();
			List<CrewRecord> additionalCrewStringList = Constants.getAdditionalCrew();
			for (CrewRecord additionalCrew : additionalCrewStringList) {
				additionalCrewNamesList.add(additionalCrew.getCrewName());
			}
			for (String additionalCrewAbb : additionalCrewNamesList) {
				switch (additionalCrewAbb.toUpperCase()) {
				case "STUDIO MAINTENANCE":
					workflowList.add("✔");
					break;
				}
			}

			if (locationNames != null) {
				String[] locationText;
				if (locationNames.contains(",")) {
					locationText = locationNames.split(",");
				} else {
					locationText = new String[1];
					locationText[0] = locationNames;
				}
				for (int i = 0; i < locationText.length; i++) {
					switch (locationText[i].trim().toUpperCase()) {
					case "TELEMUNDO CENTER":
						workflowList.add("TC");
						boolean telemundoCenterStatus = ProducerDashboardGeneralPage.telemundoCenterCheckedIn;
						if (telemundoCenterStatus) {
							for (int k = 0; k < workflowList.size(); k++) {
								String updatedStr = workflowList.get(k).replace("TC", "✔");
								workflowList.set(k, updatedStr);
							}
						}
						break;
					}
				}
			}

			try {
				List<String> ExpectedWorkflowList = new ArrayList<String>();
				String columnTypeText = "workflow";
				String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
						.replace("<<ColumnType>>", columnTypeText)
						.concat("/nz-tag[contains(@class,'ant-tag-default')]");
				List<WebElement> workflowAbb = driver.findElements(By.xpath(columnCellTypeText));
				Waits.waitForAllElements(workflowAbb, WAIT_CONDITIONS.VISIBLE);

				for (int i = 0; i < workflowAbb.size(); i++) {
					System.out.println(
							workflowAbb.get(i).getText().trim() + " is displaying in workflow column in dashboard");
					ReportGenerate.test.log(Status.INFO,
							workflowAbb.get(i).getText().trim() + " is displaying in workflow column in dashboard");
					ExpectedWorkflowList.add(workflowAbb.get(i).getText().trim());
				}

				if (workflowList.equals(ExpectedWorkflowList)) {
					System.out.println("The workflow displaying in dashboard as expected");
					ReportGenerate.test.log(Status.INFO, "The workflow displaying in dashboard as expected");
				} else {
					System.out.println("The workflow not displaying in dashboard as expected");
					ReportGenerate.test.log(Status.INFO, "The workflow not displaying in dashboard as expected");
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			verifyDefaultAndAdditionalRequesterInDashboard(additionalRequestersText, requestNumber, columnCellString);
			verifyProdDateInDashboard(ProdDateText, requestNumber, columnCellString);
			verifyShowProjectInDashboard(ShowProjectText, requestNumber, columnCellString);
			verifyProductionPurposeInDashboard(ProductionPurposeText, requestNumber, columnCellString);
			verifySetLocationInDashboard(SetLocationText, requestNumber, columnCellString);
			verifyControlRoomInDashboard(ControlRoomText, requestNumber, columnCellString);
			verifyPositionsColumnInDashboard(PositionsText, requestNumber, columnCellString);
			verifySubmittedInDashboard(SubmittedText, requestNumber, columnCellString);
			verifyActionsColumnInDashboard(requestNumber, columnCellString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify values in the animals on premises form are present in production
	 * dashboard columns To verify values in the firearms on premises form are
	 * present in production dashboard columns
	 * 
	 * @throws Exception
	 */
	public void verifyAnimalsFirearmsPremisesRequestValuesWithProductionDashboardValues(String additionalRequestersText,
			String ShowProjectText, String SetLocationText, String SubmittedText) throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			String columnCellString = "//a[contains(text(),'<<RequestId>>')]/ancestor::tr/td[contains(@class,'<<ColumnType>>')]";
			verifyStatusColorBaseOnProductionDateInDashboard(requestNumber, columnCellString);
			verifyDefaultAndAdditionalRequesterInDashboard(additionalRequestersText, requestNumber, columnCellString);
			verifyShowProjectInDashboard(ShowProjectText, requestNumber, columnCellString);
			verifySetLocationInDashboard(SetLocationText, requestNumber, columnCellString);
			verifySubmittedInDashboard(SubmittedText, requestNumber, columnCellString);
			verifyActionsColumnInDashboard(requestNumber, columnCellString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyActionsColumnInDashboard(String requestNumber, String columnCellString) {
		String columnTypeText;
		// To validate actions column edit button enabled or not
		columnTypeText = "actions";
		String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber).replace("<<ColumnType>>",
				columnTypeText);
		String actionIndashboard = columnCellTypeText.concat("//a");
		String editButtonEnabledOrDisabled = WebAction.getAttribute(driver.findElement(By.xpath(actionIndashboard)),
				"class");
		if (editButtonEnabledOrDisabled.equalsIgnoreCase("disabled")) {
			ReportGenerate.test.log(Status.FAIL, "Edit button is not enabled for actions column in the dashboard");
			System.out.println("Edit button is not enabled for actions column in the dashboard");
		} else {
			ReportGenerate.test.log(Status.PASS, "Edit button is enabled for actions column in the dashboard");
			System.out.println("Edit button is enabled for actions column in the dashboard");
		}
	}

	public void verifySubmittedInDashboard(String SubmittedText, String requestNumber, String columnCellString)
			throws Exception {
		String columnTypeText;
		// To validate submitted date
		if (SubmittedText != null) {
			columnTypeText = "submitted";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnType>>", columnTypeText);
			SubmittedText = generateDate(SubmittedText, "MM/dd/yy");
			String SubmittedIndashboard = columnCellTypeText.concat("/span[1]");
			verifyExpectedValueInFormWithActualValueInDashboard(SubmittedIndashboard, SubmittedText);
		}
	}

	public void verifyPositionsColumnInDashboard(String PositionsText, String requestNumber, String columnCellString)
			throws Exception {
		String columnTypeText;
		// To validate position-set crew,control room crew,additional crew
		if (PositionsText != null) {
			String[] positionsTextArrayList;
			positionsTextArrayList = PositionsText.split("-");
			columnTypeText = "position";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnType>>", columnTypeText);
			String setCrewText = positionsTextArrayList[0];
			String controlRoomCrewText = positionsTextArrayList[1];
			String additionalCrewText = positionsTextArrayList[2];
			verifySetCrewInPositionsColumnInDashboard(columnCellTypeText, setCrewText);
			verifyControlRoomCrewInPositionsColumnInDashboard(columnCellTypeText, controlRoomCrewText);
			verifyAdditionalCrewInPositionsColumnInDashboard(columnCellTypeText, additionalCrewText);
		}
	}

	public void verifySetCrewInPositionsColumnInDashboard(String columnCellTypeText, String setCrewText)
			throws Exception {
		// To validate set crew
		String SetCrewArrayList[];
		if (setCrewText != null) {
			if (setCrewText.contains(",")) {
				SetCrewArrayList = setCrewText.split(",");
			} else {
				SetCrewArrayList = new String[1];
				SetCrewArrayList[0] = setCrewText;
			}
			for (int i = 0; i < SetCrewArrayList.length; i++) {
				switch (SetCrewArrayList[i].trim().toUpperCase()) {
				case "PROD A2":
					SetCrewArrayList[i] = "A2-P";
					break;
				case "STAGE MANAGER":
					SetCrewArrayList[i] = "SM";
					break;
				case "STEADICAM + UTIL":
					SetCrewArrayList[i] = "ST+U";
					break;
				case "JIB UTILITY":
					SetCrewArrayList[i] = "JIBUTIL";
					break;
				case "HAIR STYLIST":
					SetCrewArrayList[i] = "HAIR";
					break;
				case "MAKEUP ARTIST":
					SetCrewArrayList[i] = "MU";
					break;
				case "WARDROBE DRESSER":
					SetCrewArrayList[i] = "WRDB";
					break;
				case "MUSIC MIX":
					// SetCrewArrayList[i] = "MM";
					break;
				case "MERLIN":
					SetCrewArrayList[i] = "MERL";
					break;
				case "JIB":
					SetCrewArrayList[i] = "JIB";
					break;
				case "PED CAM":
					SetCrewArrayList[i] = "PED";
					break;
				case "HANDHELD CAM":
					SetCrewArrayList[i] = "HH";
					break;
				case "CAMERA UTILITY":
					SetCrewArrayList[i] = "UTIL";
					break;
				case "PLAZA PRODUCTIONS OP":
					// SetCrewArrayList[i] = "";
					break;
				case "LIGHTING BOARD OP":
					SetCrewArrayList[i] = "LBOP";
					break;
				case "MUSIC A2":
					SetCrewArrayList[i] = "A2-M";
					break;
				case "AUDIO BOOM OP":
					SetCrewArrayList[i] = "BOOM";
					break;
				case "FRONT OF HOUSE MIX":
					SetCrewArrayList[i] = "FOH";
					break;
				case "MONITOR MIX -FOLDBACK":
					SetCrewArrayList[i] = "FB";
					break;
				case "SOUND EFFECTS":
					// SetCrewArrayList[i] = "";
					break;
				case "CRANE CAM":
					SetCrewArrayList[i] = "CRAN";
					break;
				case "CRANE DRIVER":
					SetCrewArrayList[i] = "CRANDRIVER";
					break;
				case "CRANE UTILITY":
					SetCrewArrayList[i] = "CRANUTIL";
					break;
				}
			}
			for (String SetCrewArray : SetCrewArrayList) {
				String updatedColumnCellTypeText = columnCellTypeText + "/div/div[1]";
				verifyExpectedValueInFormWithActualValueInDashboard(updatedColumnCellTypeText, SetCrewArray);
			}
		}
	}

	public void verifyControlRoomCrewInPositionsColumnInDashboard(String columnCellTypeText, String controlRoomCrewText)
			throws Exception {
		// To validate control room crew
		if (controlRoomCrewText != null) {
			String controlRoomCrewArrayList[];
			if (controlRoomCrewText.contains(",")) {
				controlRoomCrewArrayList = controlRoomCrewText.split(",");
			} else {
				controlRoomCrewArrayList = new String[1];
				controlRoomCrewArrayList[0] = controlRoomCrewText;
			}
			for (int i = 0; i < controlRoomCrewArrayList.length; i++) {
				switch (controlRoomCrewArrayList[i].trim().toUpperCase()) {
				case "A1 PRODUCTION MIX":
					controlRoomCrewArrayList[i] = "A1";
					break;
				case "VIDEO PLAYBACK":
					controlRoomCrewArrayList[i] = "DPS";
					break;
				case "TECHNICAL DIRECTOR":
					controlRoomCrewArrayList[i] = "TD";
					break;
				case "CR AUDIO ASSIST - TX":
					// controlRoomCrewArrayList[i] = "";
					break;
				case "GFX PB OP FS/L3":
					controlRoomCrewArrayList[i] = "GXLF";
					break;
				case "GFX PB OP FS":
					controlRoomCrewArrayList[i] = "GXFS";
					break;
				case "GFX PB OP L3":
					controlRoomCrewArrayList[i] = "GXL3";
					break;
				case "GFX BUILD OP":
					controlRoomCrewArrayList[i] = "GXBD";
					break;
				case "PLAYBACK AD":
					controlRoomCrewArrayList[i] = "PAD";
					break;
				case "CR AD":
					controlRoomCrewArrayList[i] = "AD";
					break;
				case "FIX AD":
					controlRoomCrewArrayList[i] = "FAD";
					break;
				}
			}
			for (String controlRoomCrewArray : controlRoomCrewArrayList) {
				String updatedColumnCellTypeText = columnCellTypeText + "/div/div[2]";
				verifyExpectedValueInFormWithActualValueInDashboard(updatedColumnCellTypeText, controlRoomCrewArray);
			}
		}
	}

	public void verifyAdditionalCrewInPositionsColumnInDashboard(String columnCellTypeText, String additionalCrewText)
			throws Exception {
		// To validate additional crew
		if (additionalCrewText != null) {
			String additionalCrewArrayList[] = null;
			if (additionalCrewText.contains(",")) {
				additionalCrewArrayList = additionalCrewText.split(",");
			} else {
				additionalCrewArrayList = new String[1];
				additionalCrewArrayList[0] = additionalCrewText;
			}
			for (int i = 0; i < additionalCrewArrayList.length; i++) {
				switch (additionalCrewArrayList[i].trim().toUpperCase()) {
				case "PROMPTER OP":
					additionalCrewArrayList[i] = "PMT";
					break;
				case "VIDEO / LD /  ROBO CAM":
					// additionalCrewArrayList[i] = "";
					break;
				case "VIDEO OP / ROBO CAM":
					// additionalCrewArrayList[i] = "";
					break;
				case "LIGHTING DIRECTOR":
					// additionalCrewArrayList[i] = "LD";
					break;
				case "VIDEO OP":
					// additionalCrewArrayList[i] = "V1";
					break;
				case "ROBO CAM":
					// additionalCrewArrayList[i] = "ROBO";
					break;
				case "STUDIO MAINTENANCE":
					additionalCrewArrayList[i] = "MTCE";
					break;
				}
			}
			for (String additionalCrewArray : additionalCrewArrayList) {
				String updatedColumnCellTypeText = columnCellTypeText + "/div/div[3]";
				verifyExpectedValueInFormWithActualValueInDashboard(updatedColumnCellTypeText, additionalCrewArray);
			}
		}
	}

	public void verifyControlRoomInDashboard(String ControlRoomText, String requestNumber, String columnCellString)
			throws Exception {
		String columnTypeText;
		// To validate control room
		columnTypeText = "controlRoom";
		String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber).replace("<<ColumnType>>",
				columnTypeText);
		if (ControlRoomText != null) {
			String[] ControlRoomArrayList;
			ControlRoomArrayList = ControlRoomText.split(",");
			for (int i = 0; i < ControlRoomArrayList.length; i++) {
				verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText, ControlRoomArrayList[i]);
			}
			if (ControlRoomText.equalsIgnoreCase("YES") || ControlRoomText.equalsIgnoreCase("NO")) {
				verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText, ControlRoomText);
			}
		}
	}

	public void verifySetLocationInDashboard(String SetLocationText, String requestNumber, String columnCellString)
			throws Exception {
		String columnTypeText;
		// To validate set location
		if (SetLocationText != null) {
			columnTypeText = "setLocation";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnType>>", columnTypeText);
			String[] SetLocationArrayList;
			SetLocationArrayList = SetLocationText.split(",");
			for (int i = 0; i < (SetLocationArrayList.length) / 2; i++) {
				int j = i + 1;
				String updatedColumnCellTypeText = columnCellTypeText + "/span[" + j + "]";
				switch (SetLocationArrayList[i].trim().toUpperCase()) {
				case "TELEMUNDO CENTER":
					SetLocationArrayList[i] = "TC";
					break;
				case "NONE":
					SetLocationArrayList[i] = "No Set Location";
					break;
				}
				verifyExpectedValueInFormWithActualValueInDashboard(updatedColumnCellTypeText, SetLocationArrayList[i]);
			}
			int j = 1;
			for (int i = (SetLocationArrayList.length) / 2; i < SetLocationArrayList.length; i++) {
				String updatedColumnCellTypeText = columnCellTypeText + "/span[" + j + "]";
				verifyExpectedValueInFormWithActualValueInDashboard(updatedColumnCellTypeText, SetLocationArrayList[i]);
				j++;
			}
		}
	}

	public void verifyProductionPurposeInDashboard(String ProductionPurposeText, String requestNumber,
			String columnCellString) throws Exception {
		String columnTypeText;
		// To validate production purpose
		if (ProductionPurposeText != null) {
			columnTypeText = "requestFor";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnType>>", columnTypeText);
			verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText, ProductionPurposeText);
		}
	}

	public void verifyShowProjectInDashboard(String ShowProjectText, String requestNumber, String columnCellString)
			throws Exception {
		String columnTypeText;
		// To validate show unit/project
		if (ShowProjectText != null) {
			columnTypeText = "showproject";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnType>>", columnTypeText);
			verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText, ShowProjectText);
		}
	}

	public void verifyProdDateInDashboard(String ProdDateText, String requestNumber, String columnCellString)
			throws Exception {
		String columnTypeText;
		// To validate production date,start time,end time
		if (ProdDateText != null) {
			String[] timeStampTextArrayList;
			timeStampTextArrayList = ProdDateText.split(",");
			columnTypeText = "timestamp";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnType>>", columnTypeText);
			if (timeStampTextArrayList[0] != null) {
				String date = generateDate(timeStampTextArrayList[0], "MM/dd/yy");
				String dateTextIndashboard = columnCellTypeText.concat("/span[1]");
				verifyExpectedValueInFormWithActualValueInDashboard(dateTextIndashboard, date);
			}
			if (timeStampTextArrayList[1] != null) {
				String prepTime = Constants.getPrepTime();
				String prepTextIndashboard = columnCellTypeText.concat("/span[2]");
				verifyExpectedValueInFormWithActualValueInDashboard(prepTextIndashboard, prepTime);
			}
			if (timeStampTextArrayList[2] != null || timeStampTextArrayList[3] != null) {
				String startTime = Constants.getStartTime();
				String endTime = Constants.getEndTime();
				String startEndText = startTime.concat(" - ").concat(endTime);
				String startEndTextIndashboard = columnCellTypeText.concat("/span[3]");
				verifyExpectedValueInFormWithActualValueInDashboard(startEndTextIndashboard, startEndText);
			}
		}
	}

	public void verifyDefaultAndAdditionalRequesterInDashboard(String additionalRequestersText, String requestNumber,
			String columnCellString) throws Exception, InterruptedException {
		String columnTypeText;
		// To validate default requester
		String defaultRequesterName = Constants.getDefaultRequesterName();
		columnTypeText = "modifiedBy";
		String defaultRequesterNamecolumnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
				.replace("<<ColumnType>>", columnTypeText);
		String defaultRequesterNameTextIndashboard = defaultRequesterNamecolumnCellTypeText.concat("//div/div");
		verifyExpectedValueInFormWithActualValueInDashboard(defaultRequesterNameTextIndashboard, defaultRequesterName);

		// To validate additional requester
		verifyAdditionalRequesterInDashboard(additionalRequestersText, requestNumber, columnCellString);
	}

	public void verifyAdditionalRequesterInDashboard(String additionalRequestersText, String requestNumber,
			String columnCellString) throws Exception, InterruptedException {
		String columnTypeText;
		String[] additionalRequestersArrayList;
		if (additionalRequestersText != null) {
			if (additionalRequestersText.contains("-")) {
				additionalRequestersArrayList = additionalRequestersText.split("-");
			} else {
				additionalRequestersArrayList = new String[1];
				additionalRequestersArrayList[0] = additionalRequestersText;
			}
			columnTypeText = "modifiedBy";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnType>>", columnTypeText);
			String additionalRequesterTextXpathIndashboard = columnCellTypeText.concat("//div/span[last()]");

			List<String> addreqNamesList = new ArrayList<String>();
			List<RequesterRecord> additionalRequestersStringList = Constants.getRequesters();
			for (RequesterRecord additionalRequester : additionalRequestersStringList) {
				addreqNamesList.add(additionalRequester.getName());
			}
			WebElement additionalRequestersWebelement = driver
					.findElement(By.xpath(additionalRequesterTextXpathIndashboard));
			Waits.waitForElement(additionalRequestersWebelement, WAIT_CONDITIONS.VISIBLE);
			Thread.sleep(1000);
			WebAction.click(additionalRequestersWebelement);
			String additionalreqNamesXpath = "(//div[contains(@class,'popover')])[last()]/div[<<additionalReqNo>>]";
			for (int i = 0; i < additionalRequestersArrayList.length; i++) {
				String additionalreqNamesNewXpath = additionalreqNamesXpath.replace("<<additionalReqNo>>",
						Integer.toString(i + 2));
				verifyExpectedValueInFormWithActualValueInDashboard(additionalreqNamesNewXpath, addreqNamesList.get(i));
			}
		}
	}

	public void verifyStatusColorBaseOnProductionDateInDashboard(String requestNumber, String columnCellString)
			throws ParseException, Exception {
		String columnTypeText;
		RequestStatus currentStatus = Constants.getRequestStatus();
		String statusOfTheRequest = currentStatus.status;
		// To validate status color based on Production date
		columnTypeText = "padding";
		String statusColorBasedonProductionDateNamecolumnCellText = columnCellString
				.replace("<<RequestId>>", requestNumber).replace("<<ColumnType>>", columnTypeText);
		String statusColorBasedonProductionDateText = statusColorBasedonProductionDateNamecolumnCellText.concat("/div");
		String actualStatusColor = WebAction
				.getAttribute(driver.findElement(By.xpath(statusColorBasedonProductionDateText)), "class");
		String expectedStatusColor = null;
		long diff = 0;
		String formType = Constants.getFormType();
		if (formType.equalsIgnoreCase("Rock Center") || formType.equalsIgnoreCase("CNBC")
				|| formType.equalsIgnoreCase("Single Camera Live Shot")
				|| formType.equalsIgnoreCase("Extend Or Bridge Crew & Facilities")) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
			Date startDate = sdf.parse(Constants.getStartDate());
			Date currentDate = sdf.parse(generateDate("CurrentDate", "MM/dd/yy"));
			diff = TimeUnit.DAYS.convert(startDate.getTime() - currentDate.getTime(), TimeUnit.MILLISECONDS);
			System.out.println("Difference in days: " + diff);
		}
		if (diff == 1) {
			expectedStatusColor = "Yellow";
		}
		if (diff == 0) {
			expectedStatusColor = "Red";
		}
		if (diff >= 2) {
			expectedStatusColor = "Blue";
		}
		if (statusOfTheRequest.equalsIgnoreCase("FULFILLED")) {
			expectedStatusColor = "Green";
		}
		if (statusOfTheRequest.equalsIgnoreCase("CONFIRM CANCELLATION")) {
			expectedStatusColor = "Black";
		}
		if (statusOfTheRequest.equalsIgnoreCase("COMPLETED") || statusOfTheRequest.equalsIgnoreCase("CANCELLED")) {
			expectedStatusColor = "Grey";
		}
		Assert.assertTrue(actualStatusColor.contains(expectedStatusColor), "Expected color is " + expectedStatusColor
				+ " and actual value is " + actualStatusColor.replace("status", ""));
		System.out.println(expectedStatusColor + " color is displying based on production start date in the dashboard");
		ReportGenerate.test.log(Status.INFO,
				expectedStatusColor + " color is displying based on production start date in the dashboard");
	}

	public void verifyExpectedValueInFormWithActualValueInDashboard(String columnCellTypeText, String expectedValue)
			throws Exception {
		Waits.waitForElement(driver.findElement(By.xpath(columnCellTypeText)), WAIT_CONDITIONS.VISIBLE);
		String columnCellText = WebAction.getText(driver.findElement(By.xpath(columnCellTypeText)));
		String[] cellValueArrayList = null;
		String actualValue;
		if (columnCellTypeText.contains("controlRoom") && columnCellText.contains(":")) {
			columnCellText = columnCellText.replace(":", ",");
		}
		if (columnCellText.contains(":")) {
			int count = 0;
			for (int i = 0; i < columnCellText.length(); i++) {
				if (columnCellText.charAt(i) == ':') {
					count++;
				}
			}
			if (count > 1) {
				cellValueArrayList = columnCellText.split(":", 2);
				actualValue = cellValueArrayList[1];
			} else {
				actualValue = columnCellText.replace(":", " ");
			}
		} else {
			actualValue = columnCellText.trim();
		}
		// cellValueArrayList = columnCellText.split(":"); //"\""
		Assert.assertTrue(actualValue.toUpperCase().contains(expectedValue.toUpperCase()),
				"Expected value is " + expectedValue + " and actual value is " + actualValue);
		ReportGenerate.test.log(Status.INFO,
				"\"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
		System.out.println("\"" + expectedValue + "\"" + " Present in the form is also displaying in dashboard");
	}

	public void clickFormTitle() {
		try {
			formTitle.click();
		} catch (Exception e) {
			;
		}
	}

	public void clickEditButton() throws Exception {
		try {
			Waits.waitUntilElementIsClickable(editButton);
			editButton.click();
			Waits.waitUntilElementIsClickable(editingStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void executeStorage(String fieldName, Runnable store, RequestMode... mode) {
		if (Objects.isNull(fieldName) || Objects.isNull(store)) {
			return;
		}
		if (mode == null || mode.length == 0 || mode[0] == RequestMode.CREATE) {
			store.run();
		} else if (mode[0] == RequestMode.EDIT) {
			// below sleep is needed so that LocalDateTime.now().toString() do not give same
			// timestamp
			// unique consecutive timestamp is needed for sorting the runnables
			// do not remove below sleep
			try {
				Thread.sleep(100);
				Object[] objs = Arrays.asList(LocalDateTime.now().toString(), store, fieldName).toArray();
				if (objs.length != 3) {
					Assert.assertTrue(objs.length == 3,
							String.format("Runnable for %s being pushed is not in correct format", fieldName));
				} else {
					Constants.getMapContainingChanges().put(fieldName, objs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Boolean removeStorage(String fieldName) {
		Object[] runnable = Constants.getMapContainingChanges().remove(fieldName);
		return runnable != null;
	}

	public void clickSubmitButton() throws Exception {
		try {
			WebAction.click(submitButton);
			Waits.waitUntilElementSizeEquals(modalTitleAfterClickingSubmit, 1);
			if (isThereErrorWhileSubmittingRequest()) {
				Assert.fail("Error modal on UI after clicking submit button");
			} else if (areThereMissingFieldWhileSubmittingRequest()) {
				Assert.fail("Missing field modal on UI after clicking submit button");
			} else {
				Constants.setSubmitButtonClicked(true);
				RequestType type = Constants.getRequestType();
				Constants.setRequestStatus(RequestStatus.NEW);
				if (type == RequestType.CNBC) {
					Constants.getLog().getLogs().putLog("New CNBC Production Request is submitted", null);
				} else if (type == RequestType.ExtendOrBridgeCrewFacilities || type == RequestType.SingleCameraLiveShot
						|| type == RequestType.RockCenter) {
					Constants.getLog().getLogs().putLog("New Studio Request is submitted", null);
				} else if (type == RequestType.FileIngest) {
					Constants.getLog().getLogs().putLog("New File Ingest Request is submitted", null);
				} else if (type == RequestType.FeedOut) {
					Constants.getLog().getLogs().putLog("New Feedout Request is submitted", null);
				} else if (type == RequestType.MTD) {
					Constants.getLog().getLogs().putLog("New MTD Request is submitted", null);
				}
				saveLog();
			}
		} catch (Exception e) {
			;
		}
	}

	public void saveLog() {
		if (Constants.getLog().getLogs().anySectionLogsPresent()) {
			Constants.getLog().setStatus(Constants.getRequestStatus());
			LocalTime localTime = LocalTime.now();
			String time = localTime.format(DateTimeFormatter.ofPattern("h:mm a"));
			Constants.getLog().setTime(time);
			Constants.getLog().setModifiedBy(Constants.getLoggedInUsersDisplayName());
			Constants.getLog().setRequestNumber(Constants.getRequestNumber());
			Constants.getLogs().add(Constants.getLog());
		}
		Constants.setLog(null);
	}

	public void putStatusChangeLog(RequestStatus statusBeforeChanges) {
		// need to run after all the runnables in the mapcontainingchanges are run
		RequestStatus newStatus = Constants.getRequestStatus();
		if (statusBeforeChanges != newStatus) {
			if (newStatus == RequestStatus.MODIFIED) {
				Constants.getLog().getLogs().putLog("Request is moved to Modified Status", null);
			} else if (newStatus == RequestStatus.WORKING) {
				Constants.getLog().getLogs().putLog("Request is moved to Working Status", null);
			} else if (newStatus == RequestStatus.FULFILLED) {
				Constants.getLog().getLogs().putLog("Request is moved to Fulfilled Status", null);
			} else if (newStatus == RequestStatus.CONFIRM_CANCELLATION) {
				Constants.getLog().getLogs().putLog("Request is moved to Confirm Cancellation Status", null);
			} else if (newStatus == RequestStatus.CANCELLED) {
				Constants.getLog().getLogs().putLog("Request is moved to Cancelled Status", null);
			} else if (newStatus == RequestStatus.REVISED) {
				Constants.getLog().getLogs().putLog("Status changed to REVISED", null);
			} else if (newStatus == RequestStatus.IN_PROGRESS) {
				Constants.getLog().getLogs().putLog("Status changed to IN PROGRESS", null);
			} else if (newStatus == RequestStatus.IN_PROGRESS) {
				Constants.getLog().getLogs().putLog("Status changed to COMPLETED", null);
			}
		}
	}

	public Boolean areNotesChanged() {
		List<NoteRecord> earlierNotes = Constants.getRequestNotes();
		List<NoteRecord> currentNotes = getCurrentlyDisplayedRequestNotes();
		if (earlierNotes.size() != currentNotes.size()) {
			return true;
		} else {
			int size = currentNotes.size();
			for (int itr = 0; itr < size; ++itr) {
				String earlierDateTime = earlierNotes.get(itr).getDateTime().toString();
				String currentDateTime = currentNotes.get(itr).getDateTime().toString();
				if (!earlierDateTime.equals(currentDateTime)) {
					return true;
				}
			}
		}
		return false;
	}

	public void addNoteChangeRunnablesIfAny() {
		if (areNotesChanged()) {
			Runnable runnable = () -> {
				Constants.setRequestNotes(getCurrentlyDisplayedRequestNotes());
				setCurrentlyDisplayedRequestNotes(null);
				List<RequestType> ecmList = Arrays.asList(RequestType.FileIngest, RequestType.FeedOut, RequestType.MTD);
				RequestType currentType = Constants.getRequestType();
				if (Constants.getUserRole() == UserRole.PRODUCER) {
					if (ecmList.contains(currentType)) {
						Constants.getLog().getLogs().putLog("Changed Requester Notes Section", null);
					} else {
						Constants.getLog().getLogs().putLog("Changed Requestor Notes", null);
					}
					changeStatusOnRequestUpdate();
				} else {
					if (ecmList.contains(currentType)) {
						Constants.getLog().getLogs().putLog("Changed Fulfiller Notes Section", null);
					} else {
						Constants.getLog().getLogs().putLog("Changed Fulfiller Notes", null);
					}
				}
			};
			executeStorage("Notes", runnable, RequestMode.EDIT);
		}
	}

	public void runChangeRunnables() {
		List<Object[]> changesList = new ArrayList<>();
		Constants.getMapContainingChanges().values().forEach((change) -> changesList.add(change));
		Comparator<Object[]> comparator = (o1, o2) -> {
			String time1 = (String) o1[0];
			String time2 = (String) o2[0];
			return time1.compareTo(time2);
		};
		Collections.sort(changesList, comparator);
		changesList.forEach((change) -> {
			((Runnable) change[1]).run();
		});
		Constants.getMapContainingChanges().clear();
	}

	public Boolean isThereErrorWhileSaving() {
		String displayedModalText = getText(modalTitleAfterClickingSave);
		if (displayedModalText.toLowerCase().contains("error")) {
			Constants.getMapContainingChanges().clear();
			return true;
		}
		return false;
	}

	public Boolean areThereMissingFieldWhileSaving() {
		String displayedModalText = getText(modalTitleAfterClickingSave);
		if (displayedModalText.toLowerCase().contains("missing field")) {
			Constants.getMapContainingChanges().clear();
			return true;
		}
		return false;
	}

	public Boolean isThereErrorWhileSubmittingRequest() {
		if (modalTitleAfterClickingSubmit.size() > 0) {
			String displayedModalText = getText(modalTitleAfterClickingSubmit.get(0));
			if (displayedModalText.toLowerCase().contains("error")) {
				Constants.getMapContainingChanges().clear();
				return true;
			}
		}
		return false;
	}

	public Boolean areThereMissingFieldWhileSubmittingRequest() {
		if (modalTitleAfterClickingSubmit.size() > 0) {
			String displayedModalText = getText(modalTitleAfterClickingSubmit.get(0));
			if (displayedModalText.toLowerCase().contains("missing field")) {
				Constants.getMapContainingChanges().clear();
				return true;
			}
		}
		return false;
	}

	public void clickSaveButtonOnRequest() throws Exception {
		Waits.waitForElement(saveButtonOnRequest, WAIT_CONDITIONS.CLICKABLE);
		saveButtonOnRequest.click();
		Waits.waitForElement(modalTitleAfterClickingSave, WAIT_CONDITIONS.VISIBLE);
		if (isThereErrorWhileSaving()) {
			Assert.fail("Error modal on UI after clicking save button");
		} else if (areThereMissingFieldWhileSaving()) {
			Assert.fail("Missing field modal on UI after clicking save button");
		} else {
			String expectedTitle = "No changes have been made to the request";
			// are the notes added or modifed or deleted
			addNoteChangeRunnablesIfAny();
			if (Constants.getMapContainingChanges().size() > 0) {
				RequestStatus statusBeforeChanges = Constants.getRequestStatus();
				expectedTitle = "Request Updated";
				runChangeRunnables();
				putStatusChangeLog(statusBeforeChanges);
				saveLog();
			}
			// Assert.assertEquals(getText(modalTitleAfterClickingSave),
			// expectedTitle,"Modal title after clicking save button is not as expected");
		}
	}

	public void clickDiscardChangesButton() throws Exception {
		Waits.waitForElement(discardChangesButton, WAIT_CONDITIONS.CLICKABLE);
		discardChangesButton.click();
		Waits.waitForAllElements(editIcons, WAIT_CONDITIONS.INVISIBLE);
		Constants.getMapContainingChanges().clear();
		Constants.setLog(null);
	}

	public void clickLogButton() throws Exception {
		Waits.waitForElement(logTab, WAIT_CONDITIONS.VISIBLE);
		Waits.waitForElement(logTab, WAIT_CONDITIONS.CLICKABLE);
		WebAction.scrollIntoView(logTab);
		logTab.click();
	}

	public void closeLogDrawer() throws Exception {
		WebAction.scrollIntoView(closeLogDrawerButton.get(0));
		WebAction.click(closeLogDrawerButton.get(0));
		Thread.sleep(1000);
		WebAction.mouseOver(logTab);
	}

	public void verifyAllRequestLogs() throws Exception {
		List<RequestLog> expectedLogs = Constants.getLogs();
		String requestNumber = Constants.getRequestNumber();
		System.out.println("expectedLogs : " + expectedLogs.toString());
		clickLogButton();
		Assert.assertEquals(displayedLogs.size(), expectedLogs.size(),
				"Number of displayed logs and expected log not same");
		ListIterator<RequestLog> reverseItrOnExpected = expectedLogs.listIterator(expectedLogs.size());
		ListIterator<WebElement> itrOnDisplayed = displayedLogs.listIterator();
		SoftAssert softAssert = new SoftAssert();
		while (reverseItrOnExpected.hasPrevious()) {
			RequestLog log = reverseItrOnExpected.previous();
			int index = itrOnDisplayed.nextIndex();
			String displayedLog = getText(itrOnDisplayed.next());
			// remove new lines from the displayed logs
			displayedLog = displayedLog.replaceAll("\r\n", " ");
			Iterator<String> sectionLogsIterator = log.getLogs().getSectionAndFieldLogs().iterator();
			while (sectionLogsIterator.hasNext()) {
				String logging = sectionLogsIterator.next();
				softAssert.assertTrue(displayedLog.contains(logging), String
						.format("`%s` is not displayed at index %d in request %s", logging, index, requestNumber));
				displayedLog = displayedLog.replace(logging, "");
				System.out.println("Logging : `" + logging + "`");
				System.out.println("displayedLog : `" + displayedLog + "`");
			}
			System.out.println();
			softAssert.assertTrue(displayedLog.replaceAll(",", " ").trim().length() == 0,
					String.format("These logs are also displayed which is not expected `%s` at %d in request %s",
							displayedLog, index, requestNumber));
		}
		closeLogDrawer();
		softAssert.assertAll();
	}

	public Boolean isEditMode(RequestMode... mode) {
		return mode.length > 0 && mode[0] == RequestMode.EDIT;
	}

	public void removeRequester(String requesters, RequestMode... mode) throws Exception {
		List<String> nameList = Arrays.asList(requesters.split("&"));
		for (String name : nameList) {
			String nameToDelete = name.trim();
			for (int i = 0; i < addedRequesterNamesInEditMode.size(); ++i) {
				String displayedName = getText(addedRequesterNamesInEditMode.get(i)).trim();
				if (displayedName.equals(nameToDelete)) {
					WebElement deleteButton = deleteIconForaddedRequesterNamesInEditMode.get(i);
					WebAction.scrollIntoViewTillBottom(deleteButton);
					Thread.sleep(2000);
					WebAction.click(deleteButton);
					Waits.waitForElement(okButton, WAIT_CONDITIONS.VISIBLE);
					WebAction.click(okButton);
					Runnable store = () -> {
						Optional<RequesterRecord> optional = Constants.getRequesters().stream()
								.filter((requester) -> requester.getName().equals(displayedName)).findAny();
						if (optional.isPresent()) {
							if (isEditMode(mode)) {
								Constants.getLog().getLogs().putLog("Changed Requester Section", null);
								changeStatusOnRequestUpdate();
							}
							Constants.getRequesters().remove(optional.get());
						}
					};
					executeStorage(displayedName, store, mode);
				}
			}
		}
	}

	public void removeTalent(String talents, RequestMode... mode) throws Exception {
		List<String> nameList = Arrays.asList(talents.split("&"));
		for (String name : nameList) {
			String nameToDelete = name.trim();
			for (int i = 0; i < addedTalentNamesInEditMode.size(); ++i) {
				String displayedName = getText(addedTalentNamesInEditMode.get(i)).trim();
				if (displayedName.equals(nameToDelete)) {
					WebElement deleteButton = deleteIconsForAddedTalentNamesInEditMode.get(i);
					WebAction.scrollIntoViewTillBottom(deleteButton);
					Thread.sleep(2000);
					WebAction.click(deleteButton);
					Waits.waitForElement(okButton, WAIT_CONDITIONS.VISIBLE);
					WebAction.click(okButton);
					Runnable store = () -> {
						Optional<TalentRecord> optional = Constants.getTalents().stream()
								.filter((talent) -> talent.getName().equals(displayedName)).findAny();
						if (optional.isPresent()) {
							if (isEditMode(mode)) {
								Constants.getLog().getLogs().putLog("Changed Talent Section", null);
								changeStatusOnRequestUpdate();
							}
							Constants.getTalents().remove(optional.get());
						}
					};
					executeStorage(displayedName, store, mode);
				}
			}
		}
	}

	public void clickUnlockThisRecordButton() throws Exception {
		try {
			Waits.waitUntilElementSizeGreater(unlockButton, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (unlockButton.size() > 0) {
			WebElement button = unlockButton.get(0);
			WebAction.click(button);
			Waits.waitForElement(editingStatus, WAIT_CONDITIONS.VISIBLE);
		}
	}

	public void switchToTabInFulfillment(String tabLabel) throws Exception {
		try {
			Waits.waitUntilElementSizeGreater(tabsInRightContainer, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Optional<WebElement> tabOptional = tabsInRightContainer.stream()
				.filter((ele) -> getText(ele).equalsIgnoreCase(tabLabel)).findAny();
		if (tabOptional.isPresent()) {
			WebElement tab = tabOptional.get();
			WebAction.click(tab);
		}
	}

	public void clickCancelRequestButton() throws Exception {
		RequestStatus currentStatus = Constants.getRequestStatus();
		WebAction.click(cancelRequestButton);
		Waits.waitForElement(cancelRequestButton, WAIT_CONDITIONS.VISIBLE);
		Waits.waitForElement(cancelRequestButton, WAIT_CONDITIONS.CLICKABLE);
		Waits.waitForElement(yesButtonInModalConfirmation, WAIT_CONDITIONS.VISIBLE);
		WebAction.click(yesButtonInModalConfirmation);
		Waits.waitForElement(okButtonInModalConfirmation, WAIT_CONDITIONS.VISIBLE);
		WebAction.click(okButtonInModalConfirmation);
		if (Constants.getUserRole() == UserRole.PRODUCER) {
			Constants.setRequestStatus(RequestStatus.CONFIRM_CANCELLATION);
		} else if (Constants.getUserRole() == UserRole.FULFILLER || Constants.getUserRole() == UserRole.ADMIN) {
			Constants.setRequestStatus(RequestStatus.CANCELLED);
		}
		putStatusChangeLog(currentStatus);
		saveLog();
	}

	public void clickConfirmCancellationButton() throws Exception {
		RequestStatus currentStatus = Constants.getRequestStatus();
		Waits.waitForElement(confirmCancelRequestButton, WAIT_CONDITIONS.VISIBLE);
		Waits.waitForElement(confirmCancelRequestButton, WAIT_CONDITIONS.CLICKABLE);
		WebAction.click(confirmCancelRequestButton);
		Waits.waitForElement(yesButtonInModalConfirmation, WAIT_CONDITIONS.VISIBLE);
		WebAction.click(yesButtonInModalConfirmation);
		Waits.waitForElement(okButtonInModalConfirmation, WAIT_CONDITIONS.VISIBLE);
		WebAction.click(okButtonInModalConfirmation);
		Constants.setRequestStatus(RequestStatus.CANCELLED);
		putStatusChangeLog(currentStatus);
		saveLog();
	}

	public void switchToNotesTabInFulfillment() throws Exception {
		try {
			Waits.waitUntilElementSizeGreater(notesTabs, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Optional<WebElement> tabOptional = notesTabs.stream().filter((ele) -> getText(ele).contains("NOTES")).findAny();
		if (tabOptional.isPresent()) {
			WebElement tab = tabOptional.get();
			WebAction.click(tab);
		}
	}

	public void addRequestNotes(int numberOfNotesToAdd) throws Exception {
		for (int itr = 0; itr < numberOfNotesToAdd; ++itr) {
			LocalDateTime dateTime = LocalDateTime.now();
			String text = String.format("This is a %s note by Automation %s", Constants.getUserRole().role,
					dateTime.toString());
			requestNotesTextarea.clear();
			requestNotesTextarea.sendKeys(text);
			WebAction.click(addRequestNotesButton);
			NoteRecord note = new NoteRecord(Constants.getUserRole(), LocalDateTime.now(),
					Constants.getLoggedInUsersDisplayName(), text);
			getCurrentlyDisplayedRequestNotes().add(0, note);
		}
	}

	public void editRequestNotesRandomly() throws Exception {
		int size = getCurrentlyDisplayedRequestNotes().size();
		List<NoteRecord> editedNotes = new ArrayList<>();
		int editButtonIndex = 0;
		for (int itr = 0; itr < size; ++itr) {
			NoteRecord noteRecord = getCurrentlyDisplayedRequestNotes().get(itr);
			if (noteRecord.getNoteCreator().equals(Constants.getLoggedInUsersDisplayName())) {
				Boolean shouldEdit = Math.random() > 0.5 ? true : false;
				if (shouldEdit) {
					WebElement editNoteButton = editNoteButtons.get(editButtonIndex);
					WebAction.scrollIntoView(editNoteButton);
					WebAction.click(editNoteButton);
					LocalDateTime dateTime = LocalDateTime.now();
					String text = String.format("This is a %s note by Automation %s edited",
							Constants.getUserRole().role, dateTime.toString());
					requestNotesTextareaInEditMode.clear();
					requestNotesTextareaInEditMode.sendKeys(text);
					WebAction.scrollIntoView(saveNoteButtonInEditMode);
					WebAction.click(saveNoteButtonInEditMode);
					noteRecord.setDateTime(LocalDateTime.now());
					noteRecord.setNoteContent(text);
					editedNotes.add(noteRecord);
				}
				++editButtonIndex;
			}
		}
		editedNotes.forEach((note) -> {
			getCurrentlyDisplayedRequestNotes().remove(note);
			// edited note is displayed in the starting
			getCurrentlyDisplayedRequestNotes().add(0, note);
		});
	}

	public void deleteRequestNotesRandomly() throws Exception {
		int size = getCurrentlyDisplayedRequestNotes().size();
		List<NoteRecord> deletedNotes = new ArrayList<>();
		int deleteButtonIndex = 0;
		for (int itr = 0; itr < size; ++itr) {
			NoteRecord noteRecord = getCurrentlyDisplayedRequestNotes().get(itr);
			if (noteRecord.getNoteCreator().equals(Constants.getLoggedInUsersDisplayName())) {
				Boolean shouldDelete = Math.random() > 0.5 ? true : false;
				if (shouldDelete) {
					WebElement deleteNoteButton = deleteNoteButtons.get(deleteButtonIndex);
					WebAction.scrollIntoView(deleteNoteButton);
					WebAction.click(deleteNoteButton);
					WebAction.scrollIntoView(okButton);
					WebAction.click(okButton);
					deletedNotes.add(noteRecord);
				} else {
					++deleteButtonIndex;
				}
			}
		}
		deletedNotes.forEach((note) -> {
			getCurrentlyDisplayedRequestNotes().remove(note);
		});
	}

	public void changeStatusOnRequestUpdate() {
		RequestType type = Constants.getRequestType();
		List<RequestType> productionRequestTypes = Arrays.asList(RequestType.ExtendOrBridgeCrewFacilities,
				RequestType.CNBC, RequestType.SingleCameraLiveShot, RequestType.RockCenter);
		List<RequestType> ecmRequestTypes = Arrays.asList(RequestType.LongEdit, RequestType.StandardEdit,
				RequestType.MTD, RequestType.FileIngest, RequestType.FeedOut);
		if (productionRequestTypes.contains(type)) {
			changeRequestStatusToModified();
		} else if (ecmRequestTypes.contains(type)) {
			changeRequestStatusToRevised();
		}
	}

	public void changeRequestStatusToModified() {
		if (Constants.getUserRole() == UserRole.PRODUCER) {
			Constants.setRequestStatus(RequestStatus.MODIFIED);
		}
	}

	public void changeRequestStatusToRevised() {
		if (Constants.getUserRole() == UserRole.PRODUCER) {
			Constants.setRequestStatus(RequestStatus.REVISED);
		}
	}

	public boolean selectValueInDropdown(WebElement input, String option) {
		Boolean selected = false;
		try {
			input.sendKeys(option);
			Waits.waitUntilElementSizeGreater(dropdownOptions, 0);
			Predicate<WebElement> isMatchingElementPredicate = (ele) -> getText(ele).equals(option);
			Optional<WebElement> optional = dropdownOptions.stream().filter(isMatchingElementPredicate).findAny();
			if (optional.isPresent()) {
				WebElement optionToSelect = optional.get();
				scrollIntoView(optionToSelect);
				click(optionToSelect);
				selected = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selected;
	}

	public void selectRadioOption(String option, List<WebElement> radios) {
		Consumer<WebElement> consumer = (op) -> {
			WebAction.scrollIntoViewTillBottom(op);
			if (WebAction.getText(op).equalsIgnoreCase(option)) {
				int trials = 3;
				while (--trials >= 0) {
					try {
						op.click();
						break;
					} catch (Exception e) {
						try {
							Thread.sleep(2000);
						} catch (Exception ee) {
							ee.printStackTrace();
						}
					}
				}
			}
		};
		radios.forEach(consumer);
	}

	public void selectProducer(String name, RequestMode... mode) throws Exception {
		if (name == null) {
			return;
		}
		WebAction.scrollIntoView(producerInput);
		try {
			producerInput.clear();
			WebAction.sendKeys(producerInput, name);
//			Waits.waitUntilElementSizeEquals(loadingIconInRequestersList, 1);
//			Waits.waitUntilElementSizeEquals(loadingIconInRequestersList, 0);
			waitForOptionToBeVisible(SearchList, name);
			Optional<WebElement> optional = SearchList.stream().filter((ele) -> getText(ele).trim().contains(name))
					.findFirst();
			if (optional.isPresent()) {
				WebElement record = optional.get();
				WebAction.click(record);
				Runnable store = () -> {
					String old = Constants.getProducerName();
					if (isEditMode(mode) && old != null && !old.equals(name)) {
						Constants.getLog().getLogs().putLog("Changed Producer Details Section", null);
						changeStatusOnRequestUpdate();
					}
					Constants.setProducerName(name);
				};
				executeStorage("Producer", store, mode);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void selectSeniorProducer(String name, RequestMode... mode) throws Exception {
		if (name == null) {
			return;
		}
		WebAction.scrollIntoView(seniorProducerInput);
		try {
			seniorProducerInput.clear();
			WebAction.sendKeys(seniorProducerInput, name);
//			Waits.waitUntilElementSizeEquals(loadingIconInRequestersList, 1);
//			Waits.waitUntilElementSizeEquals(loadingIconInRequestersList, 0);
			waitForOptionToBeVisible(SearchList, name);
			Optional<WebElement> optional = SearchList.stream().filter((ele) -> getText(ele).trim().contains(name))
					.findFirst();
			if (optional.isPresent()) {
				WebElement record = optional.get();
				WebAction.click(record);
				Runnable store = () -> {
					String old = Constants.getSeniorProducerName();
					if (isEditMode(mode) && old != null && !old.equals(name)) {
						Constants.getLog().getLogs().putLog("Changed Producer Details Section", null);
						changeStatusOnRequestUpdate();
					}
					Constants.setSeniorProducerName(name);
				};
				executeStorage("Senior Producer", store, mode);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void selectReqSameAsProducer(RequestMode... mode) throws Exception {
		if (!reqSameAsProducerCheckbox.isSelected()) {
			WebAction.scrollIntoViewTillBottom(reqSameAsProducerCheckbox);
			reqSameAsProducerCheckbox.click();
			Runnable store = () -> {
				Constants.setProducerName(Constants.getLoggedInUsersDisplayName());
				String old = Constants.getReqSameAsProducer();
				old = (old == null) ? "No" : old;
				Constants.setReqSameAsProducer("Yes");
				if (isEditMode(mode) && !old.equalsIgnoreCase("Yes")) {
					Constants.getLog().getLogs().putLog("Changed Producer Details Section", null);
					changeStatusOnRequestUpdate();
				}
			};
			executeStorage("Req same as Producer", store, mode);
		}
	}

	public void unselectReqSameAsProducer(RequestMode... mode) throws Exception {
		if (reqSameAsProducerCheckbox.isSelected()) {
			WebAction.scrollIntoViewTillBottom(reqSameAsProducerCheckbox);
			reqSameAsProducerCheckbox.click();
			Runnable store = () -> {
				Constants.setProducerName(null);
				String old = Constants.getReqSameAsProducer();
				old = (old == null) ? "No" : old;
				Constants.setReqSameAsProducer("No");
				if (isEditMode(mode) && !old.equalsIgnoreCase("No")) {
					Constants.getLog().getLogs().putLog("Changed Producer Details Section", null);
					changeStatusOnRequestUpdate();
				}
			};
			executeStorage("Req same as Producer", store, mode);
		}
	}

	public void verifyDateRangeInDashboard(String startDate, String endDate) throws Exception {
		try {
			int count = 0;
			String formType = Constants.getFormType();
			if (formType.equalsIgnoreCase("NBC News") || formType.equalsIgnoreCase("CNBC Crew")
					|| formType.equalsIgnoreCase("Digital Journalist / DJ Shoot")
					|| formType.equalsIgnoreCase("Telemundo News")) {
				Robot robot = new Robot();
				// Simulate Ctrl + -
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_MINUS);
				robot.keyRelease(KeyEvent.VK_MINUS);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(2000);
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			List<LocalDate> dateList = new ArrayList<>();

			switch (formType.toUpperCase()) {
			case "NBC NEWS":
			case "CNBC CREW":
			case "TELEMUNDO NEWS":
			case "DIGITAL JOURNALIST / DJ SHOOT":

				break;
			case "ROCK CENTER":
			case "ANIMALS ON PREMISES":
			case "FIREARMS ON PREMISES":
			case "SINGLE CAMERA LIVE SHOT":
			case "EXTEND OR BRIDGE CREW & FACILITIES":
			case "CNBC":

				break;
			case "STANDARD EDIT":
			case "LONG EDIT":
			case "FEED OUT":
			case "FILE INGEST":
			case "MEDIA TRANSCODING / TRANSFERRING / DUPLICATION":
			case "EDIT SELF REPORTING":

				break;
			case "NEWS GEAR":

				break;
			}

			LocalDate startDateRange = LocalDate.parse(generateDate(startDate, "yyyy-MM-dd"), formatter);
			LocalDate endDateRange = LocalDate.parse(generateDate(endDate, "yyyy-MM-dd"), formatter);

			WebElement dateRangeStartDateWebElement = driver
					.findElement(By.xpath("//*[@placeholder='Start date'] | //*[@placeholder='Edit Start Date']"));
			WebElement dateRangeEndDateWebElement = driver
					.findElement(By.xpath("//*[@placeholder='End date'] | //*[@placeholder='Edit End Date']"));
			// To fill date range
			WebAction.click(dateRangeStartDateWebElement);
			WebAction.sendKeys(dateRangeStartDateWebElement, generateDate(startDate, "yyyy-MM-dd"));
			WebAction.keyPress(dateRangeStartDateWebElement, "Enter");
			Thread.sleep(2000);
			WebAction.sendKeys(dateRangeEndDateWebElement, generateDate(endDate, "yyyy-MM-dd"));
			WebAction.keyPress(dateRangeEndDateWebElement, "Enter");
			Thread.sleep(2000);

			List<WebElement> prodDateWebElements = driver.findElements(By.xpath(
					"//td[contains(@class,'timestamp')]/span[1] | //p[contains(@class,'ant-empty-description')]"));
			// "//td[contains(@class,'timestamp')]/span[1] | //p[contains(@class,'line') and
			// contains(text(),'Crew')]/ancestor::div//td[contains(@class,'table-cell')][4]
			// "
			// + "| //p[contains(@class,'ant-empty-description')] |
			// //p[contains(@class,'line') and
			// contains(text(),'Gear')]/ancestor::div//td[contains(@class,'table-cell')][6]"));
			// System.out.println(prodDateWebElements.size());
			if (prodDateWebElements.size() > 0) {
				if (!(prodDateWebElements.get(0).getText().trim().equalsIgnoreCase("NO DATA"))) {
					for (int i = 0; i < prodDateWebElements.size(); i++) {
						String[] prodDateString;
						String prodDate = null;
						DateTimeFormatter formatternew = null;
						String prodDateDashboardText = prodDateWebElements.get(i).getText();
						if (formType.equalsIgnoreCase("Rock Center") || formType.equalsIgnoreCase("CNBC")
								|| formType.equalsIgnoreCase("Animals On Premises")
								|| formType.equalsIgnoreCase("Firearms On Premises")
								|| formType.equalsIgnoreCase("Single Camera Live Shot")
								|| formType.equalsIgnoreCase("Extend Or Bridge Crew & Facilities")) {
							prodDateString = prodDateDashboardText.split(":");
							prodDate = prodDateString[1].trim();
							formatternew = DateTimeFormatter.ofPattern("MM/dd/yy");
						}
						if (formType.equalsIgnoreCase("NBC News") || formType.equalsIgnoreCase("CNBC Crew")
								|| formType.equalsIgnoreCase("Digital Journalist / DJ Shoot")
								|| formType.equalsIgnoreCase("Telemundo News")) {
							prodDateString = prodDateDashboardText.split("\\(");
							prodDate = prodDateString[0].trim();
							formatternew = DateTimeFormatter.ofPattern("M/d");
						}
						if (formType.equalsIgnoreCase("News Gear")) {
							prodDateString = prodDateDashboardText.split(":");
							prodDate = prodDateString[1].trim();
							formatternew = DateTimeFormatter.ofPattern("M/d/yyyy");
						}
						if (formType.equalsIgnoreCase("Standard Edit") || formType.equalsIgnoreCase("Long Edit")
								|| formType.equalsIgnoreCase("Edit Self Reporting")
								|| formType.equalsIgnoreCase("Feed Out") || formType.equalsIgnoreCase("File Ingest")
								|| formType.equalsIgnoreCase("Media Transcoding / Transferring / Duplication")) {
							prodDateString = prodDateDashboardText.split(":");
							prodDate = prodDateString[1].trim();
							formatternew = DateTimeFormatter.ofPattern("MM/dd/yy");
						}
						LocalDate filterDate = LocalDate.parse(prodDate, formatternew);
						System.out.println("Parsed date: " + filterDate);
						dateList.add(filterDate);
					}

					for (LocalDate dateToCheck : dateList) {
						if ((dateToCheck.isEqual(startDateRange) || dateToCheck.isAfter(startDateRange))
								&& (dateToCheck.isEqual(endDateRange) || dateToCheck.isBefore(endDateRange))) {
							System.out.println("Date " + dateToCheck + " is within the given range: " + startDateRange
									+ " to " + endDateRange);
							ReportGenerate.test.log(Status.INFO, "Date " + dateToCheck + " is within the given range: "
									+ startDateRange + " to " + endDateRange);
							count++;
						} else {
							System.out.println("Date " + dateToCheck + " is not within the given range: "
									+ startDateRange + " to " + endDateRange);
							ReportGenerate.test.log(Status.INFO, "Date " + dateToCheck
									+ " is not within the given range: " + startDateRange + " to " + endDateRange);
						}
					}
				} else {
					System.out.println("No data is within the given range: " + startDateRange + " to " + endDateRange);
					ReportGenerate.test.log(Status.INFO,
							"No data is within the given range: " + startDateRange + " to " + endDateRange);
				}
			}
			System.out.println(
					"Total " + count + " Dates is within the given range: " + startDateRange + " to " + endDateRange);
			ReportGenerate.test.log(Status.INFO,
					"Total " + count + " Dates is within the given range: " + startDateRange + " to " + endDateRange);
			WebElement clearButtonWebElement = driver
					.findElement(By.xpath("//button[contains(@class,'clear-button')]"));
			WebAction.click(clearButtonWebElement);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyGlobalSearchInDashboard(String globalSearchText) throws Exception {
		try {
			// String globalSearchText = "sainath";
			WebAction.click(searchTextBox);
			Waits.waitUntilElementSizeGreater(fulfillerTableRows, 1);
			WebAction.sendKeys(searchTextBox, globalSearchText + Keys.ENTER);
			Thread.sleep(1000);

			String globalSearchxpath = "//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '<<GlobalSearchText>>')]";
			List<WebElement> globalSearchWebElements = driver
					.findElements(By.xpath(globalSearchxpath.replace("<<GlobalSearchText>>", globalSearchText)));
			// Waits.waitForAllElements(globalSearchWebElements, WAIT_CONDITIONS.VISIBLE);

			if (globalSearchWebElements.size() > 0) {
				System.out.println(globalSearchText + " is searched in global search displaying "
						+ globalSearchWebElements.size() + " times in dashboard");
				ReportGenerate.test.log(Status.INFO, globalSearchText + " is searched in global search displaying "
						+ globalSearchWebElements.size() + "times in dashboard");
			} else {
				System.out.println(globalSearchText + " is searched in global search, not displaying in dashboard");
				ReportGenerate.test.log(Status.INFO,
						globalSearchText + " is searched in global search, not displaying in dashboard");
			}
			WebElement clearButtonWebElement = driver
					.findElement(By.xpath("//button[contains(@class,'clear-button')]"));
			WebAction.click(clearButtonWebElement);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySettingButtonFilterInDashboard(String columnNameRemoved) throws Exception {
		try {
			String formType = Constants.getFormType();
			int a = 2;
			String columnNo = "//tr[contains(@class,'table-row')]/th";
			List<WebElement> columnNoWebElements = driver.findElements(By.xpath(columnNo));
			List<String> columnNameBeforeFilter = new ArrayList<>();
			List<String> columnNameAfterFilter = new ArrayList<>();
			String columnNameText = "(//tr[contains(@class,'table-row')])[1]/th[<<ColumnName>>]";
			for (int i = 0; i < columnNoWebElements.size() - 1; i++) {
				if (formType.equalsIgnoreCase("NBC News") || formType.equalsIgnoreCase("CNBC Crew")
						|| formType.equalsIgnoreCase("Digital Journalist / DJ Shoot")
						|| formType.equalsIgnoreCase("Telemundo News") || formType.equalsIgnoreCase("News Gear")
						|| formType.equalsIgnoreCase("Standard Edit") || formType.equalsIgnoreCase("Long Edit")
						|| formType.equalsIgnoreCase("Edit Self Reporting") || formType.equalsIgnoreCase("Feed Out")
						|| formType.equalsIgnoreCase("File Ingest")
						|| formType.equalsIgnoreCase("Media Transcoding / Transferring / Duplication")
						|| formType.equalsIgnoreCase("Edit Self Reporting")) {
					a = 1;
				}
				WebElement columnNameWebElement = driver
						.findElement(By.xpath(columnNameText.replace("<<ColumnName>>", Integer.toString(i + a))));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", columnNameWebElement);
				System.out.println(columnNameWebElement.getText());
				columnNameBeforeFilter.add(columnNameWebElement.getText().trim());
			}

			WebElement settingButtonWebElement = driver
					.findElement(By.xpath("//i//*[local-name()='svg' and  @data-icon='setting']"));
			Waits.waitForElement(settingButtonWebElement, WAIT_CONDITIONS.CLICKABLE);
			WebAction.click(settingButtonWebElement);

			String[] columnNameRemovedArrayList;
			if (columnNameRemoved.contains(",")) {
				columnNameRemovedArrayList = columnNameRemoved.split(",");
			} else {
				columnNameRemovedArrayList = new String[1];
				columnNameRemovedArrayList[0] = columnNameRemoved;
			}

			String columnNamexpath;
			List<String> listOfColumnsToRemove;

			if (formType.equalsIgnoreCase("Rock Center") || formType.equalsIgnoreCase("CNBC")
					|| formType.equalsIgnoreCase("Animals On Premises")
					|| formType.equalsIgnoreCase("Firearms On Premises")
					|| formType.equalsIgnoreCase("Single Camera Live Shot")
					|| formType.equalsIgnoreCase("Extend Or Bridge Crew & Facilities")
					|| formType.equalsIgnoreCase("NBC News") || formType.equalsIgnoreCase("CNBC Crew")
					|| formType.equalsIgnoreCase("Digital Journalist / DJ Shoot")
					|| formType.equalsIgnoreCase("Telemundo News") || formType.equalsIgnoreCase("News Gear")) {
				columnNamexpath = "//tr[contains(@class,'table-row')]//td[contains(@class,'cdk-drag') and text()=' <<ColumnName>> ']//input";

				for (int i = 0; i < columnNameRemovedArrayList.length; i++) {
					WebElement columnNameWebElementToBeRemoved = driver.findElement(
							By.xpath(columnNamexpath.replace("<<ColumnName>>", columnNameRemovedArrayList[i].trim())));
					WebAction.clickUsingJs(columnNameWebElementToBeRemoved);
				}

				listOfColumnsToRemove = Arrays.asList(columnNameRemovedArrayList);
				columnNameBeforeFilter.removeAll(listOfColumnsToRemove);

				String columnNoAfterFilter = "//tr[contains(@class,'table-row')]/th";
				List<WebElement> columnNocolumnNoAfterFilterWebElements = driver
						.findElements(By.xpath(columnNoAfterFilter));

				for (int i = 0; i < columnNocolumnNoAfterFilterWebElements.size() - 1; i++) {
					if (formType.equalsIgnoreCase("NBC News") || formType.equalsIgnoreCase("CNBC Crew")
							|| formType.equalsIgnoreCase("Digital Journalist / DJ Shoot")
							|| formType.equalsIgnoreCase("Telemundo News")) {
						a = 1;
					}
					WebElement columnNameWebElement = driver
							.findElement(By.xpath(columnNameText.replace("<<ColumnName>>", Integer.toString(i + a))));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
							columnNameWebElement);
					System.out.println(columnNameWebElement.getText());
					columnNameAfterFilter.add(columnNameWebElement.getText().trim());
				}

				if (columnNameBeforeFilter.equals(columnNameAfterFilter)) {
					System.out.println("The removed columns are not displaying in dashboard");
				} else {
					System.out.println("The removed columns are still displaying in dashboard");
				}

				WebAction.click(settingButtonWebElement);

				for (int i = 0; i < columnNameRemovedArrayList.length; i++) {
					WebElement columnNameWebElementToBeRemoved = driver.findElement(
							By.xpath(columnNamexpath.replace("<<ColumnName>>", columnNameRemovedArrayList[i])));
					WebAction.clickUsingJs(columnNameWebElementToBeRemoved);
				}

			}
			if (formType.equalsIgnoreCase("Standard Edit") || formType.equalsIgnoreCase("Long Edit")
					|| formType.equalsIgnoreCase("Edit Self Reporting") || formType.equalsIgnoreCase("Feed Out")
					|| formType.equalsIgnoreCase("File Ingest")
					|| formType.equalsIgnoreCase("Media Transcoding / Transferring / Duplication")
					|| formType.equalsIgnoreCase("Edit Self Reporting")) {
				String customTableName = "Test Custom Table";
				WebElement createCustomTableWebElement = driver
						.findElement(By.xpath("//span[contains(text(),'Create Custom Table')]"));
				Waits.waitForElement(createCustomTableWebElement, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(createCustomTableWebElement);

				WebElement nameOfCustomTableInputBoxWebElement = driver
						.findElement(By.xpath("//input[@placeholder='Enter Table Name']"));
				Waits.waitForElement(nameOfCustomTableInputBoxWebElement, WAIT_CONDITIONS.CLICKABLE);
				WebAction.sendKeys(nameOfCustomTableInputBoxWebElement, customTableName);

				columnNamexpath = "//div[contains(@class,'columns-filter')]//span[contains(text(),'<<ColumnName>>')]/ancestor::*/span/input";

				for (int i = 0; i < columnNameRemovedArrayList.length; i++) {
					WebElement columnNameWebElementToBeRemoved = driver.findElement(
							By.xpath(columnNamexpath.replace("<<ColumnName>>", columnNameRemovedArrayList[i].trim())));
					WebAction.clickUsingJs(columnNameWebElementToBeRemoved);
				}

				listOfColumnsToRemove = Arrays.asList(columnNameRemovedArrayList);
				columnNameBeforeFilter.removeAll(listOfColumnsToRemove);

				WebElement savePreferencesButtonWebElement = driver
						.findElement(By.xpath("//span[contains(text(),'Save Preferences')]"));
				Waits.waitForElement(savePreferencesButtonWebElement, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(savePreferencesButtonWebElement);

				WebElement customTableCloseButtonWebElement = driver.findElement(By.xpath(
						"//div[contains(@class,'modal-content')]//i//*[local-name()='svg' and  @data-icon='close']"));
				Waits.waitForElement(customTableCloseButtonWebElement, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(customTableCloseButtonWebElement);

				WebElement customTableDropdownWebElement = driver.findElement(
						By.xpath("//div[@class='flush-left']//*[contains(@class,'selection-search')]//input"));
				Waits.waitForElement(customTableDropdownWebElement, WAIT_CONDITIONS.CLICKABLE);
				WebAction.sendKeys(customTableDropdownWebElement, customTableName);
				WebAction.keyPress(customTableDropdownWebElement, "Enter");
				Thread.sleep(1500);

				String columnNoAfterFilter = "//tr[contains(@class,'table-row')]/th";
				List<WebElement> columnNocolumnNoAfterFilterWebElements = driver
						.findElements(By.xpath(columnNoAfterFilter));

				for (int i = 0; i < columnNocolumnNoAfterFilterWebElements.size() - 1; i++) {
					a = 1;
					WebElement columnNameWebElement = driver
							.findElement(By.xpath(columnNameText.replace("<<ColumnName>>", Integer.toString(i + a))));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
							columnNameWebElement);
					System.out.println(columnNameWebElement.getText());
					columnNameAfterFilter.add(columnNameWebElement.getText().trim());
				}

				if (columnNameBeforeFilter.equals(columnNameAfterFilter)) {
					System.out.println("The removed columns are not displaying in dashboard");
				} else {
					System.out.println("The removed columns are still displaying in dashboard");
				}

				// WebAction.click(driver.findElement(By.xpath("//app-root//nz-select-clear/i")));
				Waits.waitForElement(customTableDropdownWebElement, WAIT_CONDITIONS.CLICKABLE);
				WebAction.sendKeys(customTableDropdownWebElement, "General");
				WebAction.keyPress(customTableDropdownWebElement, "Enter");
				Thread.sleep(1500);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyPageNaviagtionsInDashboard() throws Exception {
		try {
			if (paginationPreviousPage.isDisplayed()) {
				System.out.println("Previous Page carrot symbol is displaying in footer of the dashboard");
				ReportGenerate.test.log(Status.PASS,
						"Previous Page carrot symbol is displaying in footer of the dashboard");
			} else {
				System.out.println("Previous Page carrot symbol is not displaying in footer of the dashboard");
				ReportGenerate.test.log(Status.FAIL,
						"Previous Page carrot symbol is not displaying in footer of the dashboard");
			}

			if (pagination1Page.isDisplayed()) {
				System.out.println("First Page is displaying in footer of the dashboard");
				ReportGenerate.test.log(Status.PASS, "First Page is displaying in footer of the dashboard");
			} else {
				System.out.println("First Page is not displaying in footer of the dashboard");
				ReportGenerate.test.log(Status.FAIL, "First Page is not displaying in footer of the dashboard");
			}

			if (paginationNextPage.isDisplayed()) {
				System.out.println("Next Page carrot symbol is displaying in footer of the dashboard");
				ReportGenerate.test.log(Status.PASS,
						"Next Page carrot symbol is displaying in footer of the dashboard");
			} else {
				System.out.println("Next Page carrot symbol is not displaying in footer of the dashboard");
				ReportGenerate.test.log(Status.FAIL,
						"Next Page carrot symbol is not displaying in footer of the dashboard");
			}

			if (pagination20PerPage.isDisplayed()) {
				System.out.println("20 Per Page is displaying in footer of the dashboard");
				ReportGenerate.test.log(Status.PASS, "20 Per Page is displaying in footer of the dashboard");
			} else {
				System.out.println("20 Per Page is not displaying in footer of the dashboard");
				ReportGenerate.test.log(Status.FAIL, "20 Per Page is not displaying in footer of the dashboard");
			}

			if (paginationGoToPage.isDisplayed()) {
				System.out.println("Go To is displaying in footer of the dashboard");
				ReportGenerate.test.log(Status.PASS, "Go To is displaying in footer of the dashboard");
			} else {
				System.out.println("Go To is not displaying in footer of the dashboard");
				ReportGenerate.test.log(Status.FAIL, "Go To is not displaying in footer of the dashboard");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyClearButtonInDashboard(String startDate, String endDate) throws Exception {
		try {
			String firstRequestRowID = "(//tbody[contains(@class,'table-tbody')]/tr[contains(@class,'table-row')][1]//a)[1]";
			WebElement firstRequestRowIDWebElement = driver.findElement(By.xpath(firstRequestRowID));
			Waits.waitForElement(firstRequestRowIDWebElement, WAIT_CONDITIONS.VISIBLE);
			String firstRequestRowIDTextBeforeFilter = firstRequestRowIDWebElement.getText();

			WebElement dateRangeStartDateWebElement = driver.findElement(By.xpath(
					"//*[@placeholder='Start date'] | //*[@placeholder='Edit Start Date'] | //*[@placeholder='Needed By Start']"));
			WebElement dateRangeEndDateWebElement = driver.findElement(By.xpath(
					"//*[@placeholder='End date'] | //*[@placeholder='Edit End Date'] | //*[@placeholder='Needed By End']"));

			// To fill date range
			WebAction.click(dateRangeStartDateWebElement);
			WebAction.sendKeys(dateRangeStartDateWebElement, generateDate(startDate, "yyyy-MM-dd"));
			WebAction.keyPress(dateRangeStartDateWebElement, "Enter");
			Thread.sleep(2000);
			WebAction.sendKeys(dateRangeEndDateWebElement, generateDate(endDate, "yyyy-MM-dd"));
			WebAction.keyPress(dateRangeEndDateWebElement, "Enter");

			Thread.sleep(2000);
			String firstRequestRowIDAfterFilter = "(//tbody[contains(@class,'table-tbody')]/tr[contains(@class,'table-row')][1]//a)[1] | //p[contains(@class,'ant-empty-description')]";
			WebElement firstRequestRowIDAfterFilterWebElement = driver
					.findElement(By.xpath(firstRequestRowIDAfterFilter));
			Waits.waitForElement(firstRequestRowIDAfterFilterWebElement, WAIT_CONDITIONS.VISIBLE);
			String firstRequestRowIDTextAfterFilter = firstRequestRowIDAfterFilterWebElement.getText().trim();

			if ((!(firstRequestRowIDTextBeforeFilter.equalsIgnoreCase(firstRequestRowIDTextAfterFilter))
					|| !(firstRequestRowIDTextAfterFilter.equalsIgnoreCase("NO DATA")))
					&& (WebAction.isDisplayed(driver.findElement(
							By.xpath("//button[not(@disabled)]//i//*[local-name()='svg' and  @data-icon='clear']"))))) {
				if (firstRequestRowIDTextAfterFilter.equalsIgnoreCase("NO DATA")) {
					System.out.println(
							"Date range filter is applied, but No data is within the given range and clear button is enabled");
					ReportGenerate.test.log(Status.INFO,
							"Date range filter is applied, but No data is within the given range and clear button is enabled");
				} else {
					System.out.println(
							"Date range filter is applied, corresponding requests are displaying and clear button is enabled");
					ReportGenerate.test.log(Status.INFO,
							"Date range filter is applied, corresponding requests are displaying and clear button is enabled");
				}
			}

			WebAction.click(clearButtonWebElement);
			Thread.sleep(2000);
			String firstRequestRowIDAfterClearingFilter = "(//tbody[contains(@class,'table-tbody')]/tr[contains(@class,'table-row')][1]//a)[1]";
			WebElement firstRequestRowIDAfterClearingFilterWebElement = driver
					.findElement(By.xpath(firstRequestRowIDAfterClearingFilter));
			Waits.waitForElement(firstRequestRowIDAfterClearingFilterWebElement, WAIT_CONDITIONS.VISIBLE);
			String firstRequestRowIDTextAfterClearingFilter = firstRequestRowIDAfterClearingFilterWebElement.getText();

			if (firstRequestRowIDTextBeforeFilter.equalsIgnoreCase(firstRequestRowIDTextAfterClearingFilter)
					&& (WebAction.isDisplayed(driver.findElement(
							By.xpath("//button[(@disabled)]//i//*[local-name()='svg' and  @data-icon='clear']"))))) {
				System.out.println("Date range filter is cleared and clear button is disabled");
				ReportGenerate.test.log(Status.INFO, "Date range filter is cleared and clear button is disabled");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyScrollBarCheckerInDashboard() throws Exception {
		try {
			WebElement isScrollBarPresent = driver
					.findElement(By.xpath("//div[contains(@style,'overflow-y: scroll')]"));
			// Check for scroll bar
			boolean isScrollBarPresentOrNot = isScrollBarPresent.isDisplayed();
			if (isScrollBarPresentOrNot) {
				System.out.println("Scroll Bar Present: " + isScrollBarPresentOrNot);
				ReportGenerate.test.log(Status.PASS, "Scroll Bar Present: " + isScrollBarPresentOrNot);
			} else {
				System.out.println("Scroll Bar Present: " + isScrollBarPresentOrNot);
				ReportGenerate.test.log(Status.PASS, "Scroll Bar Present: " + isScrollBarPresentOrNot);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForOptionToBeVisible(List<WebElement> eles, String expected) {
		int waitingTime = 30;
		while (waitingTime-- >= 0) {
			try {
				for (WebElement ele : eles) {
					String str = WebAction.getText(ele);
					if (str.contains(expected)) {
						return;
					}
				}
				Thread.sleep(1000);
			} catch (Exception e) {
				;
			}
		}
	}
}