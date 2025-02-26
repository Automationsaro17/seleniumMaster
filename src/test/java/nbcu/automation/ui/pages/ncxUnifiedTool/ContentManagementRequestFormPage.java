
package nbcu.automation.ui.pages.ncxUnifiedTool;

import static nbcu.framework.utils.ui.WebAction.getText;

import java.time.LocalDateTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;
import nbcu.automation.ui.enums.RequestMode;
import nbcu.automation.ui.enums.RequestStatus;
import nbcu.automation.ui.enums.RequestType;
import nbcu.automation.ui.pojos.ncxUnifiedTool.DestinationRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.ShowUnitRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.SourceRecord;
import com.aventstack.extentreports.Status;

import nbcu.automation.ui.pojos.ncxUnifiedTool.RequesterRecord;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.factory.DriverFactory;
import nbcu.framework.utils.Other.DateFunctions;
import nbcu.framework.utils.report.ReportGenerate;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;
import nbcu.framework.utils.ui.WebAction;

public class ContentManagementRequestFormPage {

	@FindBy(xpath = "//*[@role='menuitem']/div")
	List<WebElement> SearchList;

	String dropDownvaluesXpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item";

	@FindBy(xpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item | //nz-option-item ")
	List<WebElement> dropDownvalues;

	@FindBy(xpath = "//*[@forminputname='dateNeededBy']//input")
	WebElement dateNeededBy;

	@FindBy(xpath = "//*[@formcontrolname='dateNeededByASAPBin' or @formcontrolname='dateNeededByASAP']//input")
	WebElement dateNeededByASAPCheckBox;

	@FindBy(xpath = "//*[@forminputname='timeNeededBy']//input")
	WebElement timeNeededBy;

	@FindBy(xpath = "//*[@formcontrolname='timeNeededByFlexible' or @formcontrolname='timeNeededByFlexibleBin']//input")
	WebElement timeNeededByFlexibleCheckBox;

	String sourceTypeDropDown = "(//*[@forminputname='deviceType']//input)[<<sourceTypeDropDownNo>>]";

	String destinationTypeDropDown = "(//*[@forminputname='selectDestination']//input)[<<destinationTypeDropDownNo>>]";

	String quantityInputBox = "(//*[@forminputname='quantity' or @forminputname='inputQuantity']//input)[<<quantityInputBoxNo>>]";

	String commentsInputBox = "(//*[@forminputname='sourceComments' or @forminputname='comments']//textarea)[<<commentsInputBoxNo>>]";

	String detailsInputBox = "(//*[@forminputname='textareaDestinationDetails']//textarea)[<<detailsInputBoxNo>>]";

	String slugInputBox = "((//*[@formarrayname='cnbcStratusSlug'])[<<sourceTypeDropDownNo>>]//*[@forminputname='slug']//input)[<<slugInputBoxNo>>]";

	String addStratusSlugButton = "(//span[contains(text(),'Stratus Slug')])[<<sourceTypeDropDownNo>>]";

	String sourceDetailsInputBox = "(//*[@forminputname='sourceDetails']//textarea)[<<sourceDetailsInputBoxNo>>]";

	String timeCodesInputBox = "(//*[@forminputname='timeCodes']//input)[<<timeCodesInputBoxNo>>]";

	@FindBy(xpath = "//*[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'source')]/ancestor::button/span")
	WebElement addSourceButton;

	@FindBy(xpath = "//span[contains(text(),'Destination')]")
	WebElement addDestinationButton;

	String addCameraTypeButtonText = "(//*[@forminputname='deviceType']//input)[<<sourceTypeDropDownNo>>]//ancestor::div[6]//*[contains(text(),'Camera Type')]";

	String cameraTypeInputBox = "((//*[@forminputname='deviceType']//input)[<<sourceTypeDropDownNo>>]//ancestor::div[6]//*[@forminputname='cameraTypeInput' or @forminputname='cameraType']//input)[<<cameraInputBoxNo>>]";

	String finalDestination = "//*[contains(@sectiontitle,'Destination')]//p[text()='<<finalDestinationName>>']/ancestor::div[2]//input[@type='checkbox']";

	@FindBy(xpath = "//*[@placeholder='Other Sources']//input")
	WebElement otherFinalDestinationInputBox;

	@FindBy(xpath = "//*[@forminputname='contentDescription']//textarea")
	WebElement contentDescriptionTextArea;

	@FindBy(xpath = "//*[@forminputname='fiComments' or @forminputname='generalComments']//textarea")
	WebElement commentTextArea;

	@FindBy(xpath = "//*[@forminputname='textareaInstructions']//textarea")
	WebElement instructionsTextArea;

	@FindBy(xpath = "//p[contains(text(),'SHOW INFORMATION')]")
	WebElement showInformationSection;

	@FindBy(xpath = "//p[contains(text(),'DATE & TIME NEEDED')]")
	WebElement dateAndTimeNeededSection;

	@FindBy(xpath = "//p[contains(text(),'ADDITIONAL SOURCE')]")
	WebElement additionalSourceSection;

	@FindBy(xpath = "//p[contains(text(),'ATTACHMENTS')]")
	WebElement attachmentsSection;

	@FindBy(xpath = "//*[@label='Method of Ingest']//input")
	WebElement methodOfIngest;

	@FindBy(xpath = "//*[@label='Destination(s)']//input | //h1[text()='Destination(s)']//ancestor::div[1]//input")
	WebElement destinations;

	@FindBy(xpath = "//input[@placeholder='Enter Other Method of Ingest']")
	WebElement otherMethodOfIngestInputBox;

	@FindBy(xpath = "//input[@placeholder='Enter Other File Format'] | //*[@forminputname='fulFillerFileFormat']//ancestor::div[1]//*[@forminputname='fulFillerFileFormatOther']//input")
	WebElement otherFileFormatInputBox;

	@FindBy(xpath = "//input[@placeholder='Enter Other Folder Format']")
	WebElement otherFolderFormatInputBox;

	@FindBy(xpath = "//*[@label='File Format']//input | //*[@forminputname='fulFillerFileFormat']//input")
	WebElement fileFormat;

	@FindBy(xpath = "//*[@label='Gig Size']//input")
	WebElement gigSize;

	@FindBy(xpath = "//*[@label='Clip Count']//input | //h1[text()='Clip Count']//ancestor::div[1]//input")
	WebElement clipCount;

	@FindBy(xpath = "//*[@label='Folder Format']//input")
	WebElement folderFormat;

	@FindBy(xpath = "//*[@label='Bin Name']//input")
	WebElement binName;

	@FindBy(xpath = "//*[@label='Media ID #']//input | //h1[text()='Media ID#']//ancestor::div[1]//input")
	WebElement mediaID;

	@FindBy(xpath = "//*[@label='Assistant Editor Assigned']//input")
	WebElement assistantEditorAssigned;

	@FindBy(xpath = "//*[@label='Hours']//input")
	WebElement deviceTimerHours;

	@FindBy(xpath = "//*[@label='Minutes']//input")
	WebElement deviceTimerMinutes;

	@FindBy(xpath = "//*[@label='Seconds']//input")
	WebElement deviceTimerSeconds;

	@FindBy(xpath = "//div[@class='fulfillment']//*[@forminputname='comments']//textarea | //*[@forminputname='ffComments' or @forminputname='fulFillerComments']//textarea")
	WebElement fulfillmentComments;

	@FindBy(xpath = "//*[@forminputname='feedTime']//input")
	WebElement feedTime;

	@FindBy(xpath = "//*[@formarrayname='fulfillerDestinations']//div[@title='Destinations']")
	List<WebElement> fullfilmentSectionDestionationList;

	@FindBy(xpath = "//button[@title='Add Destination']")
	WebElement addFulfillmentDestinationButton;

	String destinationsInputBox = "(//*[@formarrayname='fulfillerDestinations']//div[@title='Destinations'])[<<destinationsInputBoxNo>>]";

	String findRequestById = "//a[contains(text(),'<<RequestId>>')]";

	@FindBy(xpath = "//*[@sectiontitle='Destination(s)']//p[@class='check-text']")
	List<WebElement> destinationNames;

	@FindBy(xpath = "//*[@sectiontitle='Destination(s)']//input")
	List<WebElement> destinationCheckboxes;

	@FindBy(xpath = "//*[@sectiontitle='Comments']//textarea")
	WebElement commentsTextarea;

	@FindBy(xpath = "//*[@sectiontitle='Content Description']//textarea")
	WebElement contentDescriptionTextarea;

	@FindBy(xpath = "//label[text()=' Source Compression ']/ancestor::nz-form-label/following::input[1]")
	WebElement sourceCompressionInput;

	@FindBy(xpath = "//label[text()=' Source Frame Rate ']/ancestor::nz-form-label/following::input[1]")
	WebElement sourceFrameRateInput;

	@FindBy(xpath = "//label[text()=' Time Codes ']/ancestor::nz-form-label/following::input[1]")
	WebElement timecodesInput;

	@FindBy(xpath = "//*[text()='Slug ']/ancestor::button")
	WebElement addSlugButton;

	@FindBy(xpath = "//*[text()='Bin Name ']/ancestor::button")
	WebElement addBinNameButton;

	@FindBy(xpath = "//*[text()=' Show Unit ']/ancestor::button")
	WebElement addShowUnitButton;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'SOURCE')]/ancestor::button"),
			@FindBy(xpath = "//*[contains(text(),'Source')]/ancestor::button") })
	WebElement addAdditionalSourceButton;

	@FindBy(xpath = "//*[contains(text(),'Camera Type')]/ancestor::button")
	List<WebElement> addCameraTypeButtons;

	@FindBy(xpath = "//label[text()=' AVID Workspace ']/ancestor::nz-form-label/following::input[1]")
	WebElement avidWorkspaceInput;

	@FindBy(xpath = "//label[text()=' AVID Project Name ']/ancestor::nz-form-label/following::input[1]")
	WebElement avidProjectNameInput;

	@FindBy(xpath = "//label[contains(text(),'AVID Bin Name')]/ancestor::nz-form-label/following::input[1]")
	List<WebElement> avidBinNameInputs;

	@FindBy(xpath = "//label[contains(text(),'CNBC Stratus Slug(s)')]/ancestor::nz-form-label/following::input[1]")
	List<WebElement> cnbcStratusSlugInputs;

	@FindBy(xpath = "//label[contains(text(),'CNBC Stratus Slug(s)')]/ancestor::nz-form-item//*[@title='Remove Slug']")
	List<WebElement> removeSlugButtons;

	@FindBy(xpath = "//*[@sectiontitle='Additional Recipient(s)']//*[@title='Remove Slug']")
	List<WebElement> removeAdditionalRecipientButtons;

	@FindBy(xpath = "//label[contains(text(),'AVID Bin Name')]/ancestor::nz-form-item//*[@title='Remove Slug']")
	List<WebElement> removeBinNamesButtons;

	@FindBy(xpath = "//*[contains(text(),' Transcode Needed? ')]/../following::*[1]//*[text()]")
	List<WebElement> transcodeNeededRadioLabels;

	@FindBy(xpath = "//*[contains(text(),' Need Material Archived? ')]/../following::*[1]//*[text()]")
	List<WebElement> needMaterialArchivedRadioLabels;

	@FindBy(xpath = "//label[text()=' Details ']/ancestor::nz-form-label/following::*[1]//textarea")
	WebElement detailsInputInNimbus;

	// %d in cameraInputsInSpecificSource will be replace by source section index

	String cameraInputsInSpecificSource = "(//*[contains(text(),'SOURCE')]/ancestor::phase-two-container)[%d]"
			+ "//label[contains(text(),'Camera')]/ancestor::nz-form-label/following::input[1]";

	// %d in removeCameraButtonsInSpecificSource will be replace by source section
	// index

	String removeCameraButtonsInSpecificSource = "(//*[contains(text(),'SOURCE')]/ancestor::phase-two-container)[%d]"
			+ "//label[contains(text(),'Camera')]/ancestor::nz-form-label/following::*[contains(@class,'delete-icon')][1]";

	@FindBy(xpath = "//p[contains(text(),'SOURCE') and not(contains(text(),'ADDITIONAL'))]/ancestor::phase-two-container")
	List<WebElement> sourceSectionContainers;

	@FindBy(xpath = "//*[contains(text(),'SOURCE')]/ancestor::phase-two-container"
			+ "//label[contains(text(),'Source') and not(contains(text(),'Details'))]/ancestor::nz-form-label/following::input[1]")
	List<WebElement> sourceInputs;

	@FindBy(xpath = "//*[contains(text(),'SOURCE')]/ancestor::phase-two-container//*[contains(@class,'anticon-delete')]/ancestor::button")
	List<WebElement> removeSourceSectionButtons;

	@FindBy(xpath = "//label[text()=' Quantity ']/ancestor::nz-form-label/following::input[1]")
	List<WebElement> quantityInputs;

	@FindBy(xpath = "//label[text()=' Comments ']/ancestor::nz-form-label/following::textarea[1]")
	List<WebElement> commentInputsInSource;

	@FindBy(xpath = "//label[text()=' Slug ']/ancestor::nz-form-label/following::input[1]")
	WebElement slugInput;

	@FindBy(xpath = "//label[text()=' NCX Story Name ']/ancestor::nz-form-label/following::input[1]")
	WebElement ncxStoryNameInput;

	@FindBy(xpath = "//label[text()=' Division ']/ancestor::nz-form-label/following::input[1]")
	WebElement divisionInput;

	@FindBy(xpath = "//*[contains(@class,'story-list-elem')]//button")
	List<WebElement> storyNameSearchResults;

	@FindBy(xpath = "//*[@sectiontitle='Additional Recipient(s)']//input")
	List<WebElement> additionalRecipientInputs;

	@FindBy(xpath = "//*[@sectiontitle='Additional Recipient(s)']//*[contains(@class,'delete-icon')]")
	List<WebElement> deleteButtonForAdditionalRecipients;

	@FindBy(xpath = "//*[text()=' Additional Recipient(s) ']/ancestor::button")
	WebElement addAdditionalRecipientButton;

	@FindBy(xpath = "//*[@sectiontitle='Date & Time Needed']//label[text()=' Date Needed By ']/ancestor::nz-form-label/following::input[1]")
	WebElement dateNeededByInput;

	@FindBy(xpath = "//*[@sectiontitle='Date & Time Needed']//*[text()='ASAP']/../following::*[1]//input")
	WebElement asapInput;

	@FindBy(xpath = "//*[@sectiontitle='Date & Time Needed']//label[text()=' Time Needed By ']/ancestor::nz-form-label/following::input[1]")
	WebElement timeNeededByInput;

	@FindBy(xpath = "//*[@sectiontitle='Date & Time Needed']//*[text()='Flexible']/../following::*[1]//input")
	WebElement flexibleInputInDateAndTimeNeeded;

	@FindBy(xpath = "(//label[contains(text(),'Date Needed By')]/ancestor::nz-form-label/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearDateNeededByButton;

	@FindBy(xpath = "(//label[contains(text(),'Time Needed By')]/ancestor::nz-form-label/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearTimeNeededByButton;

	@FindBy(xpath = "//*[@sectiontitle='Show Information']//label[text()=' Air Date ']/ancestor::nz-form-label/following::input[1]")
	WebElement airDateInput;

	@FindBy(xpath = "//*[@sectiontitle='Show Information']//*[text()='To Be Determined']/../following::*[1]//input")
	WebElement toBeDeterminedInput;

	@FindBy(xpath = "//*[@sectiontitle='Show Information']//label[text()=' Air Time ']/ancestor::nz-form-label/following::input[1]")
	WebElement airTimeInput;

	@FindBy(xpath = "//*[@sectiontitle='Show Information']//*[text()='Flexible']/../following::*[1]//input")
	WebElement flexibleInputInShowInformation;

	@FindBy(xpath = "(//label[contains(text(),'Air Date')]/ancestor::nz-form-label/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearAirDateButton;

	@FindBy(xpath = "(//label[contains(text(),'Air Time')]/ancestor::nz-form-label/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearAirTimeButton;

	@FindBy(xpath = "//label[contains(text(),'Show Unit or Project Name')]/ancestor::nz-form-label/following::input[1]")
	List<WebElement> showUnitOrProjctNameInputs;

	@FindBy(xpath = "//label[contains(text(),'Budget Code')]/ancestor::nz-form-label/following::input[1]")
	List<WebElement> budgetCodeInputs;

	@FindBy(xpath = "//*[@sectiontitle='Show Information']//*[contains(text(),'Remove')]/ancestor::button")
	List<WebElement> removeShowUnitButtons;

	@FindBy(xpath = "//i[contains(@class,'anticon-loading')]")
	List<WebElement> loadingIconInList;

	@FindBy(xpath = "//*[@sectiontitle='Destination(s)']//label[contains(text(),'Other')]"
			+ "/ancestor::nz-form-label/following::input[1]")
	WebElement otherInputInDestinationsSection;

	@FindBy(xpath = "//*[contains(text(),'SOURCE')]/ancestor::phase-two-container"
			+ "//label[contains(text(),'Source Details')]/ancestor::nz-form-label/following::textarea[1]")
	List<WebElement> sourceDetailsInputsInSourcesSection;

	@FindBy(xpath = "//label[text()=' Time Codes ']/ancestor::nz-form-label/following::input[1]")
	List<WebElement> timecodesInputsInMTD;

	// %d in removeCnbcSlugButtonsInSpecificSource will be replace by source section
	// index

	String removeCnbcSlugButtonsInSpecificSource = "(//*[contains(text(),'SOURCE')]/ancestor::phase-two-container)[%d]"
			+ "//label[contains(text(),'CNBC Stratus Slug')]/ancestor::nz-form-label/following::*[contains(@class,'delete-icon')][1]";

	// %d in cnbcStratusSlugInputsInSpecificSource will be replace by source section
	// index

	String cnbcStratusSlugInputsInSpecificSource = "(//*[contains(text(),'SOURCE')]/ancestor::phase-two-container)[%d]"
			+ "//label[contains(text(),'CNBC Stratus Slug')]/ancestor::nz-form-label/following::input[1]";

	// %d in cnbcStratusSlugInputsInSpecificSource will be replace by source section
	// index

	String addStratusSlugButtonInSpecificSource = "(//*[contains(text(),'SOURCE')]/ancestor::phase-two-container)[%d]"
			+ "//*[contains(text(),'Stratus Slug')]/ancestor::button";

	@FindBy(xpath = "//*[contains(text(),'Destination')]/ancestor::phase-two-container//label[contains(text(),'Destination')]/ancestor::nz-form-label/following::input[1]")
	List<WebElement> destinationInputsInDestinationsSecionOnMTD;

	@FindBy(xpath = "//*[contains(text(),'Destination')]/ancestor::phase-two-container//label[contains(text(),'Quantity')]/ancestor::nz-form-label/following::input[1]")
	List<WebElement> quantityInputsInDestinationsSecionOnMTD;

	@FindBy(xpath = "//*[contains(text(),'Destination')]/ancestor::phase-two-container//label[contains(text(),'Details')]/ancestor::nz-form-label/following::textarea[1]")
	List<WebElement> detailsTextareasInDestinationsSecionOnMTD;

	@FindBy(xpath = "//*[contains(text(),'Destination')]/ancestor::phase-two-container//*[contains(text(),'Remove')]/ancestor::button")
	List<WebElement> removeDestinationButtonsInMTD;

	@FindBy(xpath = "//*[contains(text(),'Destination')]/ancestor::button")
	WebElement addDestinationButtonInMTD;

	@FindBy(xpath = "//*[@sectiontitle='Instructions']//textarea")
	WebElement instructionsInput;

	@FindBy(xpath = "//*[contains(@class,'side-container')]//*[contains(text(),'Method of Ingest')]/ancestor::nz-form-label/following::input[1]")
	WebElement methodOfIngestInputInFulfillment;

	@FindBy(xpath = "//*[contains(@class,'side-container')]//*[contains(text(),'DESTINATION(S)')]/../following::*[1]//input")
	List<WebElement> destinationsInputsInMtdFulfillment;

	@FindBy(xpath = "//*[contains(@class,'side-container')]//*[contains(text(),'Destination(s)')]/ancestor::nz-form-label/following::input[1]")
	WebElement destinationsInputInFileIngestFulfillment;

	@FindBy(xpath = "//*[contains(@class,'side-container')]//*[contains(text(),'Destination(s)')]/following::input[1]")
	WebElement destinationsInputInFeedOutFulfillment;

	@FindBy(xpath = "//*[contains(@class,'side-container')]//*[contains(text(),'FILE FORMAT')]/following::input[1]")
	WebElement fileFormatInputInFeedOutFulfillment;

	@FindBy(xpath = "//*[contains(@class,'side-container')]//*[contains(text(),'File Format')]/ancestor::nz-form-label/following::input[1]")
	WebElement fileFormatInputInFileIngestFulfillment;

	@FindBy(xpath = "//*[contains(@class,'side-container')]//*[contains(text(),'Folder Format')]/ancestor::nz-form-label/following::input[1]")
	WebElement folderFormatInputInFulfillment;

	@FindBy(xpath = "//*[contains(@class,'side-container')]//*[contains(text(),'Gig Size')]/ancestor::nz-form-label/following::input[1]")
	WebElement gigSizeInputInFulfillment;

	@FindBy(xpath = "//*[contains(@class,'side-container')]//*[contains(text(),'Clip Count')]/following::input[1]")
	WebElement clipCountInputInFeedOutFulfillment;

	@FindBy(xpath = "//*[contains(@class,'side-container')]//*[contains(text(),'Clip Count')]/ancestor::nz-form-label/following::input[1]")
	WebElement clipCountInputInFileIngestFulfillment;

	@FindBy(xpath = "//*[contains(@class,'side-container')]//*[contains(text(),'Bin Name')]/ancestor::nz-form-label/following::input[1]")
	WebElement binNameInputInFulfillment;

	@FindBy(xpath = "//*[contains(@class,'side-container')]//*[contains(text(),'Media ID#')]/following::input[1]")
	WebElement mediaIdInputInFeedOutFulfillment;

	@FindBy(xpath = "//*[contains(@class,'side-container')]//*[contains(text(),'Media ID #')]/ancestor::nz-form-label/following::input[1]")
	WebElement mediaIdInputInFileIngestFulfillment;

	@FindBy(xpath = "//*[contains(@class,'side-container')]//*[contains(text(),'Assistant Editor Assigned')]/ancestor::nz-form-label/following::input[1]")
	WebElement assistantEditorAssignedInputInFulfillment;

	@FindBy(xpath = "//*[contains(text(),'CNBC - STRATUS INGEST')]/..//*[contains(text(),'Ingest Complete?')]/../following::*[1]//*[text()]")
	List<WebElement> ingestCompleteRadioLabelsInCnbcStratusIngest;

	@FindBy(xpath = "//*[contains(text(),'CNBC - STRATUS INGEST')]/..//*[contains(text(),'Hours')]/ancestor::nz-form-label/following::input[1]")
	WebElement hoursInputInCnbcStratusIngest;

	@FindBy(xpath = "//*[contains(text(),'CNBC - STRATUS INGEST')]/..//*[contains(text(),'Minutes')]/ancestor::nz-form-label/following::input[1]")
	WebElement minutesInputInCnbcStratusIngest;

	@FindBy(xpath = "//*[contains(text(),'CNBC - STRATUS INGEST')]/..//*[contains(text(),'Seconds')]/ancestor::nz-form-label/following::input[1]")
	WebElement secondsInputInCnbcStratusIngest;

	@FindBy(xpath = "//*[contains(text(),'CNBC - STRATUS INGEST')]/..//*[contains(text(),'Transcoding Needed')]/following::button[1]")
	WebElement transcodingNeededButtonInCnbcStratusIngest;

	@FindBy(xpath = "//*[contains(text(),'CNBC - STRATUS INGEST')]/..//*[contains(text(),'Transcode Complete?')]/../following::*[1]//*[text()]")
	List<WebElement> transcodeCompleteRadioLabelsInCnbcStratusIngest;

	@FindBy(xpath = "//*[contains(text(),'CNBC - AVID INGEST')]/..//*[contains(text(),'Ingest Complete?')]/../following::*[1]//*[text()]")
	List<WebElement> ingestCompleteRadioLabelsInCnbcAvidIngest;

	@FindBy(xpath = "//*[contains(text(),'CNBC - AVID INGEST')]/..//*[contains(text(),'Hours')]/ancestor::nz-form-label/following::input[1]")
	WebElement hoursInputInCnbcAvidIngest;

	@FindBy(xpath = "//*[contains(text(),'CNBC - AVID INGEST')]/..//*[contains(text(),'Minutes')]/ancestor::nz-form-label/following::input[1]")
	WebElement minutesInputInCnbcAvidIngest;

	@FindBy(xpath = "//*[contains(text(),'CNBC - AVID INGEST')]/..//*[contains(text(),'Seconds')]/ancestor::nz-form-label/following::input[1]")
	WebElement secondsInputInCnbcAvidIngest;

	@FindBy(xpath = "//*[contains(text(),'CNBC - AVID INGEST')]/..//*[contains(text(),'Workspace')]/ancestor::nz-form-label/following::input[1]")
	WebElement workspaceInputInCnbcAvidIngest;

	@FindBy(xpath = "//*[contains(text(),'CNBC - AVID INGEST')]/..//*[contains(text(),'Project')]/ancestor::nz-form-label/following::input[1]")
	WebElement projectInputInCnbcAvidIngest;

	@FindBy(xpath = "//*[contains(text(),'CNBC - AVID INGEST')]/..//*[contains(text(),'Bin Name')]/ancestor::nz-form-label/following::input[1]")
	List<WebElement> binNameInputsInCnbcAvidIngest;

	@FindBy(xpath = "//*[contains(text(),'CNBC - AVID INGEST')]/..//*[contains(text(),'Bin Name')]/ancestor::button")
	WebElement addBinNameButtonInCnbcAvidIngest;

	@FindBy(xpath = "//*[contains(text(),'Timer')]/..//*[contains(text(),'Hours')]/following::input[1]")
	WebElement hoursInputInTimerInFeedOutFulfillment;

	@FindBy(xpath = "//*[contains(text(),'TIMER')]/..//*[contains(text(),'Hours')]/ancestor::nz-form-label/following::input[1]")
	WebElement hoursInputInTimerInFileIngestFulfillment;

	@FindBy(xpath = "//*[contains(text(),'Timer')]/..//*[contains(text(),'Minutes')]/following::input[1]")
	WebElement minutesInputInTimerInFeedOutFulfillment;

	@FindBy(xpath = "//*[contains(text(),'TIMER')]/..//*[contains(text(),'Minutes')]/ancestor::nz-form-label/following::input[1]")
	WebElement minutesInputInTimerInFileIngestFulfillment;

	@FindBy(xpath = "//*[contains(text(),'Timer')]/..//*[contains(text(),'Seconds')]/following::input[1]")
	WebElement secondsInputInTimerInFeedOutFulfillment;

	@FindBy(xpath = "//*[contains(text(),'TIMER')]/..//*[contains(text(),'Seconds')]/ancestor::nz-form-label/following::input[1]")
	WebElement secondsInputInTimerInFileIngestFulfillment;

	@FindBy(xpath = "//*[contains(text(),'Comments')]/..//textarea")
	WebElement commentsInputInFeedOutFulfillment;

	@FindBy(xpath = "//*[contains(text(),'COMMENTS')]/..//textarea")
	WebElement commentsInputInFileIngestFulfillment;

	@FindBy(xpath = "//*[contains(text(),'Status')]/..//input")
	WebElement statusButtonInFeedOutFulfillment;

	@FindBy(xpath = "//*[contains(text(),'STATUS')]/..//input")
	WebElement statusButtonInFileIngestFulfillment;

	@FindBy(xpath = "//nz-option-item//*[text()]")
	List<WebElement> statusOptionsInFulfillment;

	@FindBy(xpath = "//*[contains(@class,'side-container')]//*[contains(text(),'Feed Time')]/following::input[1]")
	WebElement feedtimeInputInFulfillment;

	@FindBy(xpath = "(//*[contains(@class,'side-container')]//*[contains(text(),'Feed Time')]"
			+ "/following::i[contains(@class,'anticon-close-circle')])[1]")
	WebElement clearFeedTimeInputInFulfillment;

	@FindBy(xpath = "//i[contains(@class,'anticon-loading')]")
	List<WebElement> loadingIconInRequestersList;

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();

	WebDriver driver = DriverFactory.getCurrentDriver();

	@FindBy(xpath = "//*[@forminputname='nimbusTranscodeNeeded']//label[@label-value='Yes']")
	WebElement nimbusTranscodeNeeded_Yes;

	@FindBy(xpath = "//*[@forminputname='nimbusTranscodeNeeded']//label[@label-value='No']")
	WebElement nimbusTranscodeNeeded_No;

	@FindBy(xpath = "//*[@forminputname='isMaterialArchived']//label[@label-value='Yes']")
	WebElement isMaterialArchived_Yes;

	@FindBy(xpath = "//*[@forminputname='isMaterialArchived']//label[@label-value='No']")
	WebElement isMaterialArchived_No;

	@FindBy(xpath = "//*[@forminputname='avidWorkspace']//input")
	WebElement avidWorkspacedropdown;

	@FindBy(xpath = "//*[@forminputname='avidProjectName']//input")
	WebElement avidProjectNameInputbox;

	@FindBy(xpath = "//*[@forminputname='binNameInput']//input")
	WebElement binNameInputbox;

	@FindBy(xpath = "//*[@forminputname='stratusSlugInput']//input")
	WebElement stratusSlugInputbox;

	@FindBy(xpath = "//*[@forminputname='stratusFFIngestComplete']//label[@label-value='true']")
	WebElement stratusFFIngestComplete_Yes;

	@FindBy(xpath = "//*[@forminputname='stratusFFIngestComplete']//label[@label-value='false']")
	WebElement stratusFFIngestComplete_No;

	@FindBy(xpath = "//*[@formcontrolname='stratusFFTranscodeNeeded']//button/span[1]")
	WebElement stratusFFTranscodeNeeded_Toggle;

	@FindBy(xpath = "//*[@forminputname='stratusFFTranscodeComplete']//label[@label-value='true']")
	WebElement stratusFFTranscodeComplete_Yes;

	@FindBy(xpath = "//*[@forminputname='stratusFFTranscodeComplete']//label[@label-value='false']")
	WebElement stratusFFTranscodeComplete_No;

	@FindBy(xpath = "//*[@forminputname='avidFFIngestComplete']//label[@label-value='true']")
	WebElement avidFFIngestComplete_Yes;

	@FindBy(xpath = "//*[@forminputname='avidFFIngestComplete']//label[@label-value='false']")
	WebElement avidFFIngestComplete_No;

	public ContentManagementRequestFormPage() {
		PageFactory.initElements(DriverFactory.getCurrentDriver(), this);
	}

	/**
	 * To fill Date Needed By & Time Needed By setLocationSection
	 * 
	 * @param commentText - Date Needed By & Time Needed By in this form
	 * @throws Exception
	 */
	public void fillDateNeededByTimeNeededBy(String dateNeededByText, String timeNeededByText) throws Exception {
		try {
			WebAction.scrollIntoView(showInformationSection);
			// To fill Date Needed By
			if (dateNeededByText != null && !(dateNeededByText.equalsIgnoreCase("ASAP"))) {
				Constants.setDateNeededBy(generateDate(dateNeededByText, "MM/dd/yyyy"));
				WebAction.click(dateNeededBy);
				WebAction.sendKeys(dateNeededBy, generateDate(dateNeededByText, "MM/dd/yyyy"));
				WebAction.keyPress(dateNeededBy, "Enter");
				ReportGenerate.test.log(Status.INFO, "User selects the Date Needed By as " + dateNeededByText);
			}
			if (dateNeededByText.equalsIgnoreCase("ASAP")) {
				WebAction.clickUsingJs(dateNeededByASAPCheckBox);
				ReportGenerate.test.log(Status.INFO, "User selects ASAP option for Date Needed By");
				Constants.setDateNeededBy("ASAP");
			}

			// To fill Time Needed By
			if (timeNeededByText != null && !(timeNeededByText.equalsIgnoreCase("FLEXIBLE"))) {
				WebAction.click(timeNeededBy);
				WebAction.sendKeys(timeNeededBy, generateTime(timeNeededByText, "hh:mm a"));
				ReportGenerate.test.log(Status.INFO, "User selects the Time Needed By as " + timeNeededByText);
				String timeNeededByTextFromRequestForm = WebAction.getAttribute(timeNeededBy, "value").trim();
				Constants.setTimeNeededBy(timeNeededByTextFromRequestForm);
			}
			if (timeNeededByText.equalsIgnoreCase("FLEXIBLE")) {
				WebAction.clickUsingJs(timeNeededByFlexibleCheckBox);
				ReportGenerate.test.log(Status.INFO, "User selects Flexible option for Time Needed By");
				Constants.setTimeNeededBy("FLEXIBLE");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
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
			if (date.trim() != null) {
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
			if (time.trim() != null) {
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

	public int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	/**
	 * To fill Source section
	 * 
	 * @param Source this form
	 * @throws Exception
	 */
	public void fillSource(String SourceText, String quantityText, String commentsText, String cameraText)
			throws Exception {
		try {
			WebAction.scrollIntoView(dateAndTimeNeededSection);
			// To select Source type
			String[] SourceTextArrayList;
			List<String> SourceStringList = new ArrayList<>();
			if (SourceText != null) {
				if (SourceText.contains(",")) {
					SourceTextArrayList = SourceText.split(",");
				} else {
					SourceTextArrayList = new String[1];
					SourceTextArrayList[0] = SourceText;
				}
				int j = 1, k = 0, l = 0;
				for (k = 0; k < SourceTextArrayList.length; k++) {
					String sourceTypeDropDownXpath = sourceTypeDropDown.replace("<<sourceTypeDropDownNo>>",
							Integer.toString(k + 1));
					WebElement sourceTypeDropDownWebElement = driver.findElement(By.xpath(sourceTypeDropDownXpath));
					Waits.waitForElement(sourceTypeDropDownWebElement, WAIT_CONDITIONS.CLICKABLE);
					boolean valuePresent = false;
					WebAction.click(sourceTypeDropDownWebElement);
					WebAction.sendKeys(sourceTypeDropDownWebElement, SourceTextArrayList[k].trim());
					Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
					for (WebElement ele : dropDownvalues) {
						if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(SourceTextArrayList[k].trim())) {
							SourceStringList.add(SourceTextArrayList[k].trim());
							Constants.setSources(SourceStringList);
							WebAction.clickUsingJs(ele);
							valuePresent = true;
							break;
						}
					}
					// To enter quantity
					fillQuantity(quantityText, k);
					// To enter comments
					String[] commentsTextArrayList;
					if (commentsText != null) {
						if (commentsText.contains(",")) {
							commentsTextArrayList = commentsText.split(",");
						} else {
							commentsTextArrayList = new String[1];
							commentsTextArrayList[0] = commentsText;
						}
						String commentsInputBoxXpath = commentsInputBox.replace("<<commentsInputBoxNo>>",
								Integer.toString(k + 1));
						WebElement commentsInputBoxWebElement = driver.findElement(By.xpath(commentsInputBoxXpath));
						WebAction.sendKeys(commentsInputBoxWebElement, commentsTextArrayList[k]);
					}
					fillCamera(cameraText, k);
					// need to check here
					if (j <= SourceTextArrayList.length - 1
							&& addSourceButton.getAttribute("class").contains("ng-star-inserted")) {
						Waits.waitForElement(addSourceButton, WAIT_CONDITIONS.CLICKABLE);
						WebAction.click(addSourceButton);
						j++;
					}
				}
			}
		}

		catch (

		Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillSourceFeedOut(String SourceText, String slugText, String quantityText, String commentsText)
			throws Exception {
		try {
			WebAction.scrollIntoView(dateAndTimeNeededSection);
			// To select Source type
			String[] SourceTextArrayList;
			List<String> SourceStringList = new ArrayList<>();
			if (SourceText != null) {
				if (SourceText.contains(",")) {
					SourceTextArrayList = SourceText.split(",");
				} else {
					SourceTextArrayList = new String[1];
					SourceTextArrayList[0] = SourceText;
				}
				int j = 1, k = 0, l = 0;
				for (k = 0; k < SourceTextArrayList.length; k++) {
					String sourceTypeDropDownXpath = sourceTypeDropDown.replace("<<sourceTypeDropDownNo>>",
							Integer.toString(k + 1));
					WebElement sourceTypeDropDownWebElement = driver.findElement(By.xpath(sourceTypeDropDownXpath));
					Waits.waitForElement(sourceTypeDropDownWebElement, WAIT_CONDITIONS.CLICKABLE);
					boolean valuePresent = false;
					WebAction.click(sourceTypeDropDownWebElement);
					WebAction.sendKeys(sourceTypeDropDownWebElement, SourceTextArrayList[k].trim());
					Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
					for (WebElement ele : dropDownvalues) {
						if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(SourceTextArrayList[k].trim())) {
							SourceStringList.add(SourceTextArrayList[k].trim());
							Constants.setSources(SourceStringList);
							if (SourceTextArrayList[k].trim().equalsIgnoreCase("CNBC- Stratus")) {
								l++;
							}
							WebAction.clickUsingJs(ele);
							valuePresent = true;
							break;
						}
					}
					// To enter slug for CNBC - Stratus source type
					String[] slugTextArrayList;
					if (SourceTextArrayList[k].trim().equalsIgnoreCase("CNBC- Stratus") && slugText != null) {
						int a = 0;
						if (slugText.contains(",")) {
							slugTextArrayList = slugText.split(",");
						} else {
							slugTextArrayList = new String[1];
							slugTextArrayList[0] = slugText;
						}
						for (int x = 1; x <= SourceTextArrayList.length; x++) {
							if (!(x == 1)) {
								String addStratusSlugButtonXpath = addStratusSlugButton
										.replace("<<sourceTypeDropDownNo>>", Integer.toString(l));
								WebElement addStratusSlugButtonWebElement = driver
										.findElement(By.xpath(addStratusSlugButtonXpath));
								Waits.waitForElement(addStratusSlugButtonWebElement, WAIT_CONDITIONS.CLICKABLE);
								WebAction.click(addStratusSlugButtonWebElement);
							}
							String slugInputBoxXpath = slugInputBox.replace("<<sourceTypeDropDownNo>>",
									Integer.toString(l));
							slugInputBoxXpath = slugInputBoxXpath.replace("<<slugInputBoxNo>>", Integer.toString(x));
							WebElement slugInputBoxWebElement = driver.findElement(By.xpath(slugInputBoxXpath));
							WebAction.sendKeys(slugInputBoxWebElement, slugTextArrayList[a]);
							a++;
						}
					}

					// To enter quantity
					fillQuantity(quantityText, k);
					// To enter comments
					String[] commentsTextArrayList;
					if (commentsText != null) {
						if (commentsText.contains(",")) {
							commentsTextArrayList = commentsText.split(",");
						} else {
							commentsTextArrayList = new String[1];
							commentsTextArrayList[0] = commentsText;
						}
						String commentsInputBoxXpath = commentsInputBox.replace("<<commentsInputBoxNo>>",
								Integer.toString(k + 1));
						WebElement commentsInputBoxWebElement = driver.findElement(By.xpath(commentsInputBoxXpath));
						WebAction.sendKeys(commentsInputBoxWebElement, commentsTextArrayList[k]);
					}
					// need to check here
					if (j <= SourceTextArrayList.length - 1
							&& addSourceButton.getAttribute("class").contains("ng-star-inserted")) {
						Waits.waitForElement(addSourceButton, WAIT_CONDITIONS.CLICKABLE);
						WebAction.click(addSourceButton);
						j++;
					}
				}
			}
		}

		catch (

		Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To fill Source section
	 * 
	 * @param Source this form
	 * @throws Exception
	 */
	public void fillSourceInMTD(String SourceText, String sourceDetailsText, String timeCodesText, String cameraText)
			throws Exception {
		try {
			WebAction.scrollIntoView(dateAndTimeNeededSection);
			// To select Source type
			String[] SourceTextArrayList;
			List<String> SourceStringList = new ArrayList<>();
			if (SourceText != null) {
				if (SourceText.contains(",")) {
					SourceTextArrayList = SourceText.split(",");
				} else {
					SourceTextArrayList = new String[1];
					SourceTextArrayList[0] = SourceText;
				}
				int j = 1, k = 0, l = 0;
				for (k = 0; k < SourceTextArrayList.length; k++) {
					String sourceTypeDropDownXpath = sourceTypeDropDown.replace("<<sourceTypeDropDownNo>>",
							Integer.toString(k + 1));
					WebElement sourceTypeDropDownWebElement = driver.findElement(By.xpath(sourceTypeDropDownXpath));
					Waits.waitForElement(sourceTypeDropDownWebElement, WAIT_CONDITIONS.CLICKABLE);
					boolean valuePresent = false;
					WebAction.click(sourceTypeDropDownWebElement);
					WebAction.sendKeys(sourceTypeDropDownWebElement, SourceTextArrayList[k].trim());
					Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
					for (WebElement ele : dropDownvalues) {
						if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(SourceTextArrayList[k].trim())) {
							SourceStringList.add(SourceTextArrayList[k].trim());
							Constants.setSources(SourceStringList);
							WebAction.clickUsingJs(ele);
							valuePresent = true;
							break;
						}
					}
					// To enter source details
					fillSourceDetails(sourceDetailsText, k);
					// To enter Time codes
					String[] timeCodesTextArrayList;
					if (timeCodesText != null) {
						if (timeCodesText.contains(",")) {
							timeCodesTextArrayList = timeCodesText.split(",");
						} else {
							timeCodesTextArrayList = new String[1];
							timeCodesTextArrayList[0] = timeCodesText;
						}
						String timeCodeInputBoxXpath = timeCodesInputBox.replace("<<timeCodesInputBoxNo>>",
								Integer.toString(k + 1));
						WebElement timeCodeInputBoxWebElement = driver.findElement(By.xpath(timeCodeInputBoxXpath));
						Waits.waitForElement(timeCodeInputBoxWebElement, WAIT_CONDITIONS.CLICKABLE);
						WebAction.sendKeys(timeCodeInputBoxWebElement, timeCodesTextArrayList[k]);
						Thread.sleep(1000);
						Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
						Thread.sleep(1000);
						for (WebElement ele : dropDownvalues) {
							if (WebAction.getAttribute(ele, "title")
									.equalsIgnoreCase(timeCodesTextArrayList[k].trim())) {
								WebAction.clickUsingJs(ele);
							}
						}
					}
					fillCamera(cameraText, k);
					// need to check here
					if (j <= SourceTextArrayList.length - 1
							&& addSourceButton.getAttribute("class").contains("ng-star-inserted")) {
						WebAction.scrollIntoView(additionalSourceSection);
						Waits.waitForElement(addSourceButton, WAIT_CONDITIONS.CLICKABLE);
						WebAction.clickUsingJs(addSourceButton);
						j++;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillSourceDetails(String sourceDetailsText, int k) throws Exception {
		try {
			// To enter source Details
			String[] sourceDetailsTextArrayList;
			if (sourceDetailsText != null) {
				if (sourceDetailsText.contains(",")) {
					sourceDetailsTextArrayList = sourceDetailsText.split(",");
				} else {
					sourceDetailsTextArrayList = new String[1];
					sourceDetailsTextArrayList[0] = sourceDetailsText;
				}
				String sourceDetailsXpath = sourceDetailsInputBox.replace("<<sourceDetailsInputBoxNo>>",
						Integer.toString(k + 1));
				WebElement sourceDetailsWebElement = driver.findElement(By.xpath(sourceDetailsXpath));
				Thread.sleep(1000);
				WebAction.sendKeys(sourceDetailsWebElement, sourceDetailsTextArrayList[k]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To enter quantity in form
	 * 
	 * @param quantity in form
	 * @throws Exception
	 */
	public void fillQuantity(String quantityText, int k) throws Exception {
		try {
			// To enter quantity
			String[] quantityTextArrayList;
			if (quantityText != null) {
				if (quantityText.contains(",")) {
					quantityTextArrayList = quantityText.split(",");
				} else {
					quantityTextArrayList = new String[1];
					quantityTextArrayList[0] = quantityText;
				}
				String quantityInputBoxXpath = quantityInputBox.replace("<<quantityInputBoxNo>>",
						Integer.toString(k + 1));
				WebElement quantityInputBoxWebElement = driver.findElement(By.xpath(quantityInputBoxXpath));
				WebAction.sendKeys(quantityInputBoxWebElement, "\u0008");
				Thread.sleep(2000);
				WebAction.sendKeys(quantityInputBoxWebElement, quantityTextArrayList[k]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To select Camera type
	 * 
	 * @param select Camera type
	 * @throws Exception
	 */
	public void fillCamera(String cameraText, int k) throws Exception {
		try {
			int j = 0;
			String[] cameraTextArrayList = null;
			List<String> CameraStringList = new ArrayList<>();
			if (cameraText != null) {
				if (cameraText.contains(",")) {
					cameraTextArrayList = cameraText.split(",");
				} else {
					cameraTextArrayList = new String[1];
					cameraTextArrayList[0] = cameraText;
				}
				for (int x = 0; x < cameraTextArrayList.length; x++) {
					String cameraTextXpath = cameraTypeInputBox
							.replace("<<sourceTypeDropDownNo>>", Integer.toString(k + 1))
							.replace("<<cameraInputBoxNo>>", Integer.toString(x + 1));
					WebElement cameraTextWebElement = driver.findElement(By.xpath(cameraTextXpath));
					WebAction.sendKeys(cameraTextWebElement, cameraTextArrayList[x]);
					WebAction.keyPress(cameraTextWebElement, "Enter");
					CameraStringList.add(cameraTextArrayList[x].trim());
					Constants.setCameras(CameraStringList);
					j++;
					if (j < cameraTextArrayList.length) {
						String addCameraTypeButtonXpath = addCameraTypeButtonText.replace("<<sourceTypeDropDownNo>>",
								Integer.toString(k + 1));
						WebElement addCameraTypeButton = driver.findElement(By.xpath(addCameraTypeButtonXpath));
						Waits.waitForElement(addCameraTypeButton, WAIT_CONDITIONS.CLICKABLE);
						WebAction.click(addCameraTypeButton);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To fill Destinations
	 * 
	 * @throws Exception
	 */
	public void fillDestinationDetails(String finalDestinationText) throws Exception {
		try {
			WebAction.scrollIntoView(additionalSourceSection);
			// To select final Delivery
			String[] finalDestinationTextArrayList;
			List<String> finalDestinationStringList = new ArrayList<>();
			if (finalDestinationText != null) {
				if (finalDestinationText.contains(",")) {
					finalDestinationTextArrayList = finalDestinationText.split(",");
				} else {
					finalDestinationTextArrayList = new String[1];
					finalDestinationTextArrayList[0] = finalDestinationText;
				}
				for (int i = 0; i < finalDestinationTextArrayList.length; i++) {
					if (finalDestinationTextArrayList[i].toUpperCase().contains(("OTHER"))) {
						WebAction.sendKeys(otherFinalDestinationInputBox, finalDestinationTextArrayList[i]);
						finalDestinationStringList.add(finalDestinationTextArrayList[i]);
					} else if (finalDestinationTextArrayList[i].toUpperCase().contains(("NIMBUS"))) {
						String finalDestinationXpath = finalDestination.replace("<<finalDestinationName>>",
								finalDestinationTextArrayList[i].trim());
						WebAction.clickUsingJs(driver.findElement(By.xpath(finalDestinationXpath)));
						finalDestinationStringList.add(finalDestinationTextArrayList[i]);
						WebAction.click(nimbusTranscodeNeeded_Yes);
						ReportGenerate.test.log(Status.INFO,
								"User selects Yes for - Transcode Needed? option in File Ingest form");
					} else if (finalDestinationTextArrayList[i].toUpperCase().contains(("DC NETWORK NEWS"))) {
						String finalDestinationXpath = finalDestination.replace("<<finalDestinationName>>",
								finalDestinationTextArrayList[i].trim());
						WebAction.clickUsingJs(driver.findElement(By.xpath(finalDestinationXpath)));
						finalDestinationStringList.add(finalDestinationTextArrayList[i]);
						WebAction.click(isMaterialArchived_Yes);
						ReportGenerate.test.log(Status.INFO,
								"User selects Yes for - Need Material Archived? option in File Ingest form");
					} else if (finalDestinationTextArrayList[i].toUpperCase().contains(("CNBC - AVID"))) {
						String finalDestinationXpath = finalDestination.replace("<<finalDestinationName>>",
								finalDestinationTextArrayList[i].trim());
						WebAction.clickUsingJs(driver.findElement(By.xpath(finalDestinationXpath)));
						finalDestinationStringList.add(finalDestinationTextArrayList[i]);
						Waits.waitForElement(avidWorkspacedropdown, WAIT_CONDITIONS.CLICKABLE);
						WebAction.click(avidWorkspacedropdown);
						WebAction.sendKeys(avidWorkspacedropdown, "Promo Projects");
						Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
						for (WebElement ele : dropDownvalues) {
							if (WebAction.getAttribute(ele, "title").equalsIgnoreCase("Promo Projects")) {
								WebAction.clickUsingJs(ele);
								break;
							}
						}
						ReportGenerate.test.log(Status.INFO,
								"User selects Promo Projects for - AVID Workspace option in File Ingest form");
						WebAction.sendKeys(avidProjectNameInputbox, finalDestinationTextArrayList[i]);
						ReportGenerate.test.log(Status.INFO, "User enters " + finalDestinationTextArrayList[i]
								+ " for - Avid Project Name Inputbox in File Ingest form");
						WebAction.sendKeys(binNameInputbox, finalDestinationTextArrayList[i]);
						ReportGenerate.test.log(Status.INFO, "User enters " + finalDestinationTextArrayList[i]
								+ " for - Avid Bin Name Inputbox in File Ingest form");
					} else if (finalDestinationTextArrayList[i].toUpperCase().contains(("CNBC - STRATUS"))) {
						String finalDestinationXpath = finalDestination.replace("<<finalDestinationName>>",
								finalDestinationTextArrayList[i].trim());
						WebAction.clickUsingJs(driver.findElement(By.xpath(finalDestinationXpath)));
						finalDestinationStringList.add(finalDestinationTextArrayList[i]);
						WebAction.sendKeys(stratusSlugInputbox, finalDestinationTextArrayList[i]);
						ReportGenerate.test.log(Status.INFO, "User enters " + finalDestinationTextArrayList[i]
								+ " for - CNBC Stratus Slug Inputbox in File Ingest form");
					} else {
						String finalDestinationXpath = finalDestination.replace("<<finalDestinationName>>",
								finalDestinationTextArrayList[i].trim());
						WebAction.clickUsingJs(driver.findElement(By.xpath(finalDestinationXpath)));
						finalDestinationStringList.add(finalDestinationTextArrayList[i]);
					}
				}
				Constants.setFinalDestination(finalDestinationStringList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillContentDescriptionInCM(String contentDescriptionText) throws Exception {
		try {
			if (contentDescriptionText != null) {
				WebAction.scrollIntoView(attachmentsSection);
				Waits.waitForElement(contentDescriptionTextArea, WAIT_CONDITIONS.CLICKABLE);
				WebAction.sendKeys(contentDescriptionTextArea, contentDescriptionText);
				Constants.setContentDescription(contentDescriptionText);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillCommentInCM(String commentText) throws Exception {
		try {
			if (commentText != null) {
				Waits.waitForElement(commentTextArea, WAIT_CONDITIONS.CLICKABLE);
				WebAction.sendKeys(commentTextArea, commentText);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fileIngestFillFulfullmentSection(String MethodOfIngest, String Destinations, String FileFormat,
			String gigSizeText, String clipCountText, String FolderFormat, String BinName, String mediaIDText,
			String assistantEditorAssignedText, String cnbcStratusIngestCompleteOptionText,
			String transcodingNeededOptionText, String cnbcStratusIngestTranscodeCompleteOptionText,
			String cnbcAvidIngestCompleteOptionText, String deviceTimerHoursText, String deviceTimerMinutesText,
			String deviceTimerSecondsText, String fulfillerComments) throws Exception {
		try {
			enterMethodOfIngest(MethodOfIngest);
			enterDestinations(Destinations);
			enterFileFormat(FileFormat);
			fillgigSize(gigSizeText);
			fillclipCount(clipCountText);
			enterFolderFormat(FolderFormat);
			fillBinName(BinName);
			fillMediaID(mediaIDText);
			enterAssistantEditorAssigned(assistantEditorAssignedText);
			if (Constants.getFinalDestination().stream().map(String::toUpperCase).anyMatch("CNBC - STRATUS"::equals)) {
				// To fill fulfillment details in CNBC - STRATUS INGEST
				// Ingest Complete
				if (cnbcStratusIngestCompleteOptionText.equalsIgnoreCase("Yes")) {
					WebAction.click(stratusFFIngestComplete_Yes);
					ReportGenerate.test.log(Status.INFO, "User selects " + cnbcStratusIngestCompleteOptionText
							+ " for CNBC - STRATUS INGEST Complete option");
				} else {
					WebAction.click(stratusFFIngestComplete_No);
					ReportGenerate.test.log(Status.INFO, "User selects No for CNBC - STRATUS INGEST Complete option");
				}

				// Transcoding needed
				if (transcodingNeededOptionText != null) {
					WebAction.click(stratusFFTranscodeNeeded_Toggle);
					ReportGenerate.test.log(Status.INFO, "User selects " + transcodingNeededOptionText
							+ " for CNBC - STRATUS INGEST Transcoding Needed option");
				}

				// Ingest Complete
				if (cnbcStratusIngestTranscodeCompleteOptionText.equalsIgnoreCase("Yes")) {
					WebAction.click(stratusFFTranscodeComplete_Yes);
					ReportGenerate.test.log(Status.INFO, "User selects " + cnbcStratusIngestTranscodeCompleteOptionText
							+ " for CNBC - STRATUS INGEST Transcode Complete option");
				} else {
					WebAction.click(stratusFFTranscodeComplete_No);
					ReportGenerate.test.log(Status.INFO,
							"User selects No for CNBC - STRATUS INGEST Transcode Complete option");
				}
			}

			// if (Constants.getFinalDestination().contains("CNBC - AVID")) {
			if (Constants.getFinalDestination().stream().map(String::toUpperCase).anyMatch("CNBC - AVID"::equals)) {
				// To fill fulfillment details in CNBC - AVID INGEST
				// Ingest Complete
				if (cnbcAvidIngestCompleteOptionText.equalsIgnoreCase("Yes")) {
					WebAction.click(avidFFIngestComplete_Yes);
					ReportGenerate.test.log(Status.INFO, "User selects " + cnbcAvidIngestCompleteOptionText
							+ " for CNBC - AVID INGEST Complete option");
				} else {
					WebAction.click(avidFFIngestComplete_No);
					ReportGenerate.test.log(Status.INFO, "User selects No for CNBC - AVID INGEST Complete option");
				}
			}
			filldeviceTimerHoursHours(deviceTimerHoursText);
			filldeviceTimerMinutes(deviceTimerMinutesText);
			filldeviceTimerSeconds(deviceTimerSecondsText);
			fillFulfillmentComment(fulfillerComments);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void fillBinName(String BinName) throws Exception {
		if (BinName != null) {
			WebAction.sendKeys(binName, BinName);
		}
	}

	public void fillMediaID(String mediaIDText) throws Exception {
		if (mediaIDText != null) {
			WebAction.sendKeys(mediaID, mediaIDText);
		}
	}

	public void enterFolderFormat(String FolderFormat) throws Exception {
		String FolderFormatTextArrayList[];
		if (FolderFormat != null) {
			boolean valuePresent = false;
			if (FolderFormat.contains(",")) {
				FolderFormatTextArrayList = FolderFormat.split(",");
			} else {
				FolderFormatTextArrayList = new String[1];
				FolderFormatTextArrayList[0] = FolderFormat;
			}
			WebAction.clickUsingJs(folderFormat);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (String FolderFormatTextList : FolderFormatTextArrayList) {
				WebAction.sendKeys(folderFormat, FolderFormatTextList.trim());
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(FolderFormatTextList.trim())) {
						WebAction.click(ele);
						valuePresent = true;
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception(
							"'" + FolderFormatTextList + "' value is not present in the Folder Format type drop down");
			}
			WebAction.keyPress(folderFormat, "Esc");
			for (int i = 0; i < FolderFormatTextArrayList.length; i++) {
				if (FolderFormatTextArrayList[i].toUpperCase().contains(("OTHER"))) {
					WebAction.sendKeys(otherFolderFormatInputBox, FolderFormatTextArrayList[i]);
				}
			}
		}
	}

	public void enterFileFormat(String FileFormat) throws Exception {
		String FileFormatTextArrayList[];
		if (FileFormat != null) {
			boolean valuePresent = false;
			if (FileFormat.contains(",")) {
				FileFormatTextArrayList = FileFormat.split(",");
			} else {
				FileFormatTextArrayList = new String[1];
				FileFormatTextArrayList[0] = FileFormat;
			}
			WebAction.clickUsingJs(fileFormat);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (String FileFormatTextList : FileFormatTextArrayList) {
				WebAction.sendKeys(fileFormat, FileFormatTextList.trim());
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(FileFormatTextList.trim())) {
						WebAction.click(ele);
						valuePresent = true;
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception(
							"'" + FileFormatTextList + "' value is not present in the File Format type drop down");
			}
			WebAction.keyPress(fileFormat, "Esc");
			for (int i = 0; i < FileFormatTextArrayList.length; i++) {
				if (FileFormatTextArrayList[i].toUpperCase().contains(("OTHER"))) {
					WebAction.sendKeys(otherFileFormatInputBox, FileFormatTextArrayList[i]);
				}
			}
		}
	}

	public void enterMethodOfIngest(String MethodOfIngest) throws Exception {
		// To fill method of ingest
		String MethodOfIngestTextArrayList[];
		if (MethodOfIngest != null) {
			boolean valuePresent = false;
			if (MethodOfIngest.contains(",")) {
				MethodOfIngestTextArrayList = MethodOfIngest.split(",");
			} else {
				MethodOfIngestTextArrayList = new String[1];
				MethodOfIngestTextArrayList[0] = MethodOfIngest;
			}
			WebAction.clickUsingJs(methodOfIngest);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (String MethodOfIngestTextList : MethodOfIngestTextArrayList) {
				WebAction.sendKeys(methodOfIngest, MethodOfIngestTextList.trim());
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(MethodOfIngestTextList.trim())) {
						WebAction.click(ele);
						valuePresent = true;
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception("'" + MethodOfIngestTextList
							+ "' value is not present in the method of ingest type drop down");
			}
			WebAction.keyPress(methodOfIngest, "Esc");
			for (int i = 0; i < MethodOfIngestTextArrayList.length; i++) {
				if (MethodOfIngestTextArrayList[i].toUpperCase().contains(("OTHER"))) {
					WebAction.sendKeys(otherMethodOfIngestInputBox, MethodOfIngestTextArrayList[i]);
				}
			}
		}
	}

	public void enterDestinations(String Destinations) throws Exception {
		// To fill destinations
		String DestinationsTextArrayList[];
		if (Destinations != null) {
			boolean valuePresent = false;
			if (Destinations.contains(",")) {
				DestinationsTextArrayList = Destinations.split(",");
			} else {
				DestinationsTextArrayList = new String[1];
				DestinationsTextArrayList[0] = Destinations;
			}
			WebAction.clickUsingJs(destinations);
			Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
			for (String DestinationsTextList : DestinationsTextArrayList) {
				WebAction.sendKeys(destinations, DestinationsTextList.trim());
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(DestinationsTextList.trim())) {
						WebAction.click(ele);
						valuePresent = true;
						break;
					}
				}
				if (valuePresent == false)
					throw new Exception(
							"'" + DestinationsTextList + "' value is not present in the Destinations type drop down");
			}
			WebAction.keyPress(destinations, "Esc");
		}
	}

	public void fillgigSize(String gigSizeText) throws Exception {
		// To fill gig size
		if (gigSizeText != null) {
			WebAction.sendKeys(gigSize, gigSizeText);
		}
	}

	public void fillclipCount(String clipCountText) throws Exception {
		// To fill clip count
		if (clipCountText != null) {
			WebAction.sendKeys(clipCount, clipCountText);
		}
	}

	public void fillFulfillmentComment(String fulfillmentCommentText) throws Exception {
		try {
			if (fulfillmentCommentText != null) {
				Waits.waitForElement(fulfillmentComments, WAIT_CONDITIONS.CLICKABLE);
				WebAction.sendKeys(fulfillmentComments, fulfillmentCommentText);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void enterAssistantEditorAssigned(String assistantEditorAssignedText) throws Exception {
		if (assistantEditorAssignedText != null) {
			Waits.waitForElement(assistantEditorAssigned, WAIT_CONDITIONS.CLICKABLE);
			WebAction.sendKeys(assistantEditorAssigned, assistantEditorAssignedText);
			Thread.sleep(1000);
			Waits.waitUntilElementSizeGreater(SearchList, 0);
			Thread.sleep(1000);
			WebAction.click(SearchList.get(0));
		}
	}

	public void filldeviceTimerHoursHours(String deviceTimerHoursText) throws Exception {
		if (deviceTimerHoursText != null) {
			WebAction.sendKeys(deviceTimerHours, deviceTimerHoursText);
		}
	}

	public void filldeviceTimerMinutes(String deviceTimerMinutesText) throws Exception {
		if (deviceTimerMinutesText != null) {
			WebAction.sendKeys(deviceTimerMinutes, deviceTimerMinutesText);
		}
	}

	public void filldeviceTimerSeconds(String deviceTimerSecondsText) throws Exception {
		if (deviceTimerSecondsText != null) {
			WebAction.sendKeys(deviceTimerSeconds, deviceTimerSecondsText);
		}
	}

	public void selectFeedTime(String feedTimeText) throws Exception {
		// To fill feed Time
		if (feedTimeText != null) {
			WebAction.click(feedTime);
			WebAction.sendKeys(feedTime, generateTime(feedTimeText, "hh:mm a"));
			WebAction.keyPress(feedTime, "Enter");
		}
	}

	public void feedOutFillFulfullmentSection(String Destinations, String mediaIDText, String feedTimeText,
			String deviceTimerHoursText, String deviceTimerMinutesText, String deviceTimerSecondsText,
			String clipCountText, String fulfillerComments) throws Exception {

		try {
			enterDestinations(Destinations);
			fillMediaID(mediaIDText);
			selectFeedTime(feedTimeText);
			filldeviceTimerHoursHours(deviceTimerHoursText);
			filldeviceTimerMinutes(deviceTimerMinutesText);
			filldeviceTimerSeconds(deviceTimerSecondsText);
			fillclipCount(clipCountText);
			fillFulfillmentComment(fulfillerComments);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void fillInstructionsInCM(String instructionsText) throws Exception {
		try {
			if (instructionsText != null) {
				Waits.waitForElement(instructionsTextArea, WAIT_CONDITIONS.CLICKABLE);
				WebAction.sendKeys(instructionsTextArea, instructionsText);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fillDestinationInMTD(String destinationText, String quantityText, String detailsText) throws Exception {
		try {
			WebAction.scrollIntoView(additionalSourceSection);
			// To select Source type
			String destinationTextArrayList[];
			List<String> finalDestinationStringList = new ArrayList<>();
			if (destinationText != null) {
				if (destinationText.contains(",")) {
					destinationTextArrayList = destinationText.split(",");
				} else {
					destinationTextArrayList = new String[1];
					destinationTextArrayList[0] = destinationText;
				}
				int j = 1, k = 0, l = 0;
				for (k = 0; k < destinationTextArrayList.length; k++) {
					String destinationTypeDropDownXpath = destinationTypeDropDown
							.replace("<<destinationTypeDropDownNo>>", Integer.toString(k + 1));
					WebElement destinationTypeDropDownWebElement = driver
							.findElement(By.xpath(destinationTypeDropDownXpath));
					Waits.waitForElement(destinationTypeDropDownWebElement, WAIT_CONDITIONS.CLICKABLE);
					boolean valuePresent = false;
					WebAction.click(destinationTypeDropDownWebElement);
					WebAction.sendKeys(destinationTypeDropDownWebElement, destinationTextArrayList[k].trim());
					Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
					for (WebElement ele : dropDownvalues) {
						if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(destinationTextArrayList[k].trim())) {
							WebAction.clickUsingJs(ele);
							finalDestinationStringList.add(destinationTextArrayList[k]);
							Constants.setFinalDestination(finalDestinationStringList);
							valuePresent = true;
							break;
						}
					}
					fillQuantity(quantityText, k);

					if (detailsText != null) {
						String[] detailsTextArrayList = detailsText.split(",");
						String detailsInputBoxXpath = detailsInputBox.replace("<<detailsInputBoxNo>>",
								Integer.toString(k + 1));
						WebElement detailsInputBoxWebElement = driver.findElement(By.xpath(detailsInputBoxXpath));
						WebAction.sendKeys(detailsInputBoxWebElement, detailsTextArrayList[k]);
					}

					// need to check here
					if (j <= destinationTextArrayList.length - 1
							&& addDestinationButton.getAttribute("class").contains("ng-star-inserted")) {
						Waits.waitForElement(addDestinationButton, WAIT_CONDITIONS.CLICKABLE);
						WebAction.click(addDestinationButton);
						j++;
					}
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void MTDFillFulfullmentSection(String Destinations, String FileFormat, String gigSizeText,
			String clipCountText, String deviceTimerHoursText, String deviceTimerMinutesText,
			String deviceTimerSecondsText, String fulfillerComments) throws Exception {

		try {
			enterDestinationsInMTD(Destinations);
			enterFileFormat(FileFormat);
			fillgigSize(gigSizeText);
			fillclipCount(clipCountText);
			filldeviceTimerHoursHours(deviceTimerHoursText);
			filldeviceTimerMinutes(deviceTimerMinutesText);
			filldeviceTimerSeconds(deviceTimerSecondsText);
			fillFulfillmentComment(fulfillerComments);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void enterDestinationsInMTD(String Destinations) throws Exception {
		// To fill MTD destinations
		if (Destinations != null) {
			boolean valuePresent = false;
			String[] DestinationsTextArrayList = Destinations.split(",");
			int NoOfDestination = fullfilmentSectionDestionationList.size();
			Waits.waitForElement(addFulfillmentDestinationButton, WAIT_CONDITIONS.CLICKABLE);
			WebAction.click(addFulfillmentDestinationButton);
			int j = 0;
			for (int k = 0; k < DestinationsTextArrayList.length; k++) {
				String destinationsInputBoxXpath = destinationsInputBox.replace("<<destinationsInputBoxNo>>",
						Integer.toString(NoOfDestination + k + 1));
				WebElement destinationsInputBoxtWebElement = driver.findElement(By.xpath(destinationsInputBoxXpath));
				Waits.waitForElement(destinationsInputBoxtWebElement, WAIT_CONDITIONS.CLICKABLE);
				WebAction.click(destinationsInputBoxtWebElement);
				Waits.waitUntilElementSizeGreater(By.xpath(dropDownvaluesXpath), 0);
				for (WebElement ele : dropDownvalues) {
					if (WebAction.getAttribute(ele, "title").equalsIgnoreCase(DestinationsTextArrayList[k].trim())) {
						WebAction.clickUsingJs(ele);
						valuePresent = true;
						break;
					}
				}
				j++;
				if (j < DestinationsTextArrayList.length) {
					Waits.waitForElement(addFulfillmentDestinationButton, WAIT_CONDITIONS.CLICKABLE);
					WebAction.click(addFulfillmentDestinationButton);
				}
			}
		}
	}

	/**
	 * To verify status background color
	 *
	 * @param typeOfCss
	 * @param status
	 * @param expectedColor
	 * @throws Exception
	 */
	public void verifyStatusBackgroundColorInECM(String typeOfCss, String status, String expectedColor)
			throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			WebElement requestIDField = driver
					.findElement(By.xpath(findRequestById.replace("<<RequestId>>", requestNumber)));
			Waits.waitForElement(requestIDField, WAIT_CONDITIONS.VISIBLE);
			Waits.waitForElement(requestIDField, WAIT_CONDITIONS.CLICKABLE);
			try {
				WebAction.mouseOver(requestIDField);
				Thread.sleep(2000);
			} catch (Exception e) {
				WebAction.clickUsingJs(requestIDField);
			}
			String actualStatus = WebAction
					.getText(driver.findElement(By.xpath("//div[contains(@class,'tooltip-title')]//span[2]"))).trim();

			if (!(actualStatus.equalsIgnoreCase(status))) {
				throw new Exception("Status of the request is not correct. Expected status is '" + status
						+ "' and actual status is '" + actualStatus + "'");
			}
			CommonValidations.verifyCssValueOfWebElement(requestIDField, typeOfCss, expectedColor);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyContentManagementRequestDashboardValuesOfFeedOutForm(String SlugText, String ShowUnitText,
			String divisionText, String dateNeededByText, String timeNeededByText, String finalDestinationText,
			String additionalRequestersText, String ProducerText, String SrProducerText, String sourceText,
			String contentDescriptionText, String SubmittedText) throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			String columnCellString = "//*[contains(text(),'<<RequestId>>')]/ancestor::tr/td[<<ColumnTypeNo>>]";
			String columnTypeNoText;

			// To validate timer
			// To validate device received

			verifySlugInDashboard(SlugText, requestNumber, columnCellString);
			verifyShowUnitInDashboard(ShowUnitText, requestNumber, columnCellString);
			verifyDivisionInDashboard(divisionText, requestNumber, columnCellString);
			verifyDateNeededByInDashboard(dateNeededByText, requestNumber, columnCellString);
			verifyTimeNeededByInDashboard(timeNeededByText, requestNumber, columnCellString);
			verifyDestinationsInDashboard(finalDestinationText, requestNumber, columnCellString);
			verifyDefaultAndAdditionalRequesterInDashboard(additionalRequestersText, requestNumber, columnCellString);
			verifyProducerInDashboard(ProducerText, requestNumber, columnCellString);
			verifySrProducerInDashboard(SrProducerText, requestNumber, columnCellString);
			verifySourceInDashboard(sourceText, requestNumber, columnCellString);
			verifyContentDescriptionInDashboard(contentDescriptionText, requestNumber, columnCellString);
			verifySubmittedDateInDashboard(SubmittedText, requestNumber, columnCellString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void verifySlugInDashboard(String SlugText, String requestNumber, String columnCellString) throws Exception {
		String columnTypeNoText;
		// To validate slug
		if (SlugText != null) {
			columnTypeNoText = "4";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String slugText = Constants.getAssignmentSlug();
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
					slugText);
		}
	}

	public void verifyShowUnitInDashboard(String ShowUnitText, String requestNumber, String columnCellString)
			throws Exception, InterruptedException {
		String columnTypeNoText;
		// To validate show unit
		if (ShowUnitText != null) {
			columnTypeNoText = "5";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String showCellTypeText = columnCellTypeText.concat("/span/span");
			List<String> showList = Constants.getMultipleShowUnits();
			String[] ShowArrayList;
			if (ShowUnitText.contains(",")) {
				// ShowArrayList = ShowUnitText.split(",");
				WebElement showArrayListWebelement = driver.findElement(By.xpath(showCellTypeText.concat("/span")));
				Waits.waitForElement(showArrayListWebelement, WAIT_CONDITIONS.VISIBLE);
				Thread.sleep(1000);
				WebAction.click(showArrayListWebelement);
				String showNamesXpath = "((//div[contains(@class,'tooltip')])[last()]//li)[<<showNo>>]";
				for (int i = 0; i < showList.size(); i++) {
					String showNamesNewXpath = showNamesXpath.replace("<<showNo>>", Integer.toString(i + 1));
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(showNamesNewXpath,
							showList.get(i).trim());
				}
			} else {
				ShowArrayList = new String[1];
				ShowArrayList[0] = ShowUnitText;
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(showCellTypeText,
						ShowArrayList[0]);
			}
		}
	}

	public void verifyDivisionInDashboard(String divisionText, String requestNumber, String columnCellString)
			throws Exception {
		String columnTypeNoText;
		// To validate division
		if (divisionText != null) {
			columnTypeNoText = "6";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String expectedDivision = Constants.getDivision();
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
					expectedDivision);
		}
	}

	public void verifyDateNeededByInDashboard(String dateNeededByText, String requestNumber, String columnCellString)
			throws Exception {
		String columnTypeNoText;
		// To validate date needed by
		if (dateNeededByText != null) {
			columnTypeNoText = "7";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String date = Constants.getDateNeededBy();
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText, date);
		}
	}

	public void verifyTimeNeededByInDashboard(String timeNeededByText, String requestNumber, String columnCellString) {
		String columnTypeNoText;
		// To validate time needed by
		if (timeNeededByText != null) {
			columnTypeNoText = "8";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String columnCellText = WebAction.getText(driver.findElement(By.xpath(columnCellTypeText)));
			String actualTime = columnCellText.trim();
			String expectedTime = Constants.getTimeNeededBy();
			SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
			Date date = null;
			try {
				date = sdf.parse(expectedTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			expectedTime = sdf.format(date);
			Assert.assertTrue(actualTime.toUpperCase().contains(expectedTime.toUpperCase()),
					"Expected value is " + expectedTime + " and actual value is " + actualTime);
			ReportGenerate.test.log(Status.INFO,
					"\"" + expectedTime + "\"" + " Present in the form is also displaying in dashboard");
			System.out.println("" + expectedTime + "\"" + " Present in the form is also displaying in dashboard");
		}
	}

	public void verifyDestinationsInDashboard(String finalDestinationText, String requestNumber,
			String columnCellString) throws Exception, InterruptedException {
		String columnTypeNoText;
		// To validate Destinations
		if (finalDestinationText != null) {
			columnTypeNoText = "9";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String finalDestinationCellTypeText = columnCellTypeText.concat("/span/span");
			List<String> FinalDestinationList = Constants.getFinalDestination();
			String[] FinalDestinationArrayList;
			if (finalDestinationText.contains(",")) {
				FinalDestinationArrayList = finalDestinationText.split(",");
				WebElement FinalDestinationArrayListWebelement = driver
						.findElement(By.xpath(finalDestinationCellTypeText.concat("/span")));
				Waits.waitForElement(FinalDestinationArrayListWebelement, WAIT_CONDITIONS.VISIBLE);
				Thread.sleep(1000);
				WebAction.click(FinalDestinationArrayListWebelement);
				String FinalDestinationNamesXpath = "((//div[contains(@class,'tooltip')])[last()]//li)[<<FinalDestinationNo>>]";
				for (int i = 0; i < FinalDestinationArrayList.length; i++) {
					String FinalDestinationNamesNewXpath = FinalDestinationNamesXpath.replace("<<FinalDestinationNo>>",
							Integer.toString(i + 1));
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
							FinalDestinationNamesNewXpath, FinalDestinationList.get(i).trim());
				}
				WebAction.click(producerDashboardGeneralPage.ecmDashboardTitleHeader);
			} else {
				FinalDestinationArrayList = new String[1];
				FinalDestinationArrayList[0] = finalDestinationText;
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
						finalDestinationCellTypeText, FinalDestinationArrayList[0]);
			}
		}
	}

	public void verifyDefaultAndAdditionalRequesterInDashboard(String additionalRequestersText, String requestNumber,
			String columnCellString) throws Exception, InterruptedException {
		String columnTypeNoText;
		// To validate default requester
		columnTypeNoText = "10";
		String defaultRequesterNamecolumnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
				.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/span/span/span/a");
		String defaultRequesterName = Constants.getDefaultRequesterName();
		producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
				defaultRequesterNamecolumnCellTypeText, defaultRequesterName);

		// To validate additional requester
		String[] additionalRequestersArrayList;
		if (additionalRequestersText != null) {
			if (additionalRequestersText.contains("-")) {
				additionalRequestersArrayList = additionalRequestersText.split("-");
			} else {
				additionalRequestersArrayList = additionalRequestersText.split(" ");
			}
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/span/span/span/span");
			List<String> addreqNamesList = new ArrayList<String>();
			List<RequesterRecord> additionalRequestersStringList = Constants.getRequesters();
			for (RequesterRecord additionalRequester : additionalRequestersStringList) {
				addreqNamesList.add(additionalRequester.getName());
			}
			WebElement additionalRequestersWebelement = driver.findElement(By.xpath(columnCellTypeText));
			Waits.waitForElement(additionalRequestersWebelement, WAIT_CONDITIONS.VISIBLE);
			Thread.sleep(1000);
			WebAction.mouseOverAndClick(additionalRequestersWebelement);
			// WebAction.click(additionalRequestersWebelement);
			String additionalreqNamesXpath = "((//div[contains(@class,'tooltip')])[last()]//li/a)[<<additionalReqNo>>]";
			for (int i = 0; i < additionalRequestersArrayList.length; i++) {
				String additionalreqNamesNewXpath = additionalreqNamesXpath.replace("<<additionalReqNo>>",
						Integer.toString(i + 2));
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
						additionalreqNamesNewXpath, addreqNamesList.get(i).trim());
			}
			WebAction.click(producerDashboardGeneralPage.ecmDashboardTitleHeader);
		}
	}

	public void verifyProducerInDashboard(String ProducerText, String requestNumber, String columnCellString)
			throws Exception {
		String columnTypeNoText;
		// To validate Producer
		if (ProducerText != null) {
			columnTypeNoText = "11";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/span/span/a");
			String Producer = Constants.getProducerName();
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
					Producer);
		}
	}

	public void verifySrProducerInDashboard(String SrProducerText, String requestNumber, String columnCellString)
			throws Exception {
		String columnTypeNoText;
		// To validate Sr Producer
		if (SrProducerText != null) {
			columnTypeNoText = "12";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/span/span/a");
			String SrProducer = Constants.getSeniorProducerName();
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(columnCellTypeText,
					SrProducer);
		}
	}

	public void verifySourceInDashboard(String sourceText, String requestNumber, String columnCellString)
			throws Exception, InterruptedException {
		String columnTypeNoText;
		// To validate source
		if (sourceText != null) {
			columnTypeNoText = "13";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String sourceCellTypeText = columnCellTypeText.concat("/span/span");
			List<String> SourceList = Constants.getSources();
			for (int i = 0; i < SourceList.size(); i++) {
				if (SourceList.get(i).equals("CNBC- Stratus")) {
					SourceList.set(i, "CNBC - Stratus");
				}
			}
			String[] sourceArrayList;
			if (sourceText.contains(",")) {
				// sourceArrayList = sourceText.split(",");
				WebElement sourceArrayListWebelement = driver.findElement(By.xpath(sourceCellTypeText.concat("/span")));
				Waits.waitForElement(sourceArrayListWebelement, WAIT_CONDITIONS.VISIBLE);
				Thread.sleep(1000);
				WebAction.mouseOverAndClick(sourceArrayListWebelement);
				String sourceNamesXpath = "((//div[contains(@class,'tooltip')])[last()]//li)[<<sourceNo>>]";
				for (int i = 0; i < SourceList.size(); i++) {
					// CNBC- startus showing instaed of CNBC - Startus
					String sourceNamesNewXpath = sourceNamesXpath.replace("<<sourceNo>>", Integer.toString(i + 1));
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
							sourceNamesNewXpath, SourceList.get(i).trim());
				}
				WebAction.click(producerDashboardGeneralPage.ecmDashboardTitleHeader);
			} else {
				sourceArrayList = new String[1];
				sourceArrayList[0] = sourceText;
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(sourceCellTypeText,
						sourceArrayList[0]);
			}
		}
	}

	public void verifyContentDescriptionInDashboard(String contentDescriptionText, String requestNumber,
			String columnCellString) throws Exception, InterruptedException {
		String columnTypeNoText;
		// To validate content description
		if (contentDescriptionText != null) {
			columnTypeNoText = "18";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String contentDescriptionCellTypeText = columnCellTypeText.concat("/span//*[local-name()='svg']");
			WebElement contentDescriptionCellTypeTextWebelement = driver
					.findElement(By.xpath(contentDescriptionCellTypeText));
			Waits.waitForElement(contentDescriptionCellTypeTextWebelement, WAIT_CONDITIONS.VISIBLE);
			Thread.sleep(1000);
			WebAction.click(contentDescriptionCellTypeTextWebelement);
			String contentDescriptionXpath = "//*[@class='content-desc']/ancestor::div[2]/div[3]";
			String expectedContentDescription = Constants.getContentDescription();
			producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(contentDescriptionXpath,
					expectedContentDescription);
			WebElement leftPanelCloseButtonIconWebelement = driver
					.findElement(By.xpath("//*[@class='content-desc']/div[2]//*[@data-icon='close']"));
			Waits.waitForElement(leftPanelCloseButtonIconWebelement, WAIT_CONDITIONS.CLICKABLE);
			WebAction.click(leftPanelCloseButtonIconWebelement);
		}
	}

	public void verifySubmittedDateInDashboard(String SubmittedText, String requestNumber, String columnCellString)
			throws Exception {
		String columnTypeNoText;
		// To validate submitted date
		if (SubmittedText != null) {
			columnTypeNoText = "20";
			String submittedColumnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText).concat("/div[1]");
			String expecteddate = generateDate(SubmittedText, "MM/dd/yyyy");
			String actualSubmittedColumn = WebAction.getText(driver.findElement(By.xpath(submittedColumnCellTypeText)));
			String actualSubmittedColumnText[];
			if (actualSubmittedColumn.contains(" ")) {
				actualSubmittedColumnText = actualSubmittedColumn.split(" ");
			} else {
				actualSubmittedColumnText = new String[1];
				actualSubmittedColumnText[0] = actualSubmittedColumn;
			}
			Assert.assertTrue(actualSubmittedColumnText[0].contains(expecteddate), "Expected submitted date is "
					+ expecteddate + " and actual submitted date is " + actualSubmittedColumnText[0]);
			ReportGenerate.test.log(Status.INFO,
					expecteddate + " date is displying for submitted column in the dashboard");

		}
	}

	public void verifyContentManagementRequestDashboardValuesOfFileIngestForm(String SlugText, String ShowUnitText,
			String divisionText, String dateNeededByText, String timeNeededByText, String finalDestinationText,
			String additionalRequestersText, String ProducerText, String SrProducerText, String sourceText,
			String cameraText, String contentDescriptionText, String SubmittedText) throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			String columnCellString = "//*[contains(text(),'<<RequestId>>')]/ancestor::tr/td[<<ColumnTypeNo>>]";
			String columnTypeNoText;

			// To validate timer
			// To validate device received

			verifySlugInDashboard(SlugText, requestNumber, columnCellString);
			verifyShowUnitInDashboard(ShowUnitText, requestNumber, columnCellString);
			verifyDivisionInDashboard(divisionText, requestNumber, columnCellString);
			verifyDateNeededByInDashboard(dateNeededByText, requestNumber, columnCellString);
			verifyTimeNeededByInDashboard(timeNeededByText, requestNumber, columnCellString);
			verifyDestinationsInDashboard(finalDestinationText, requestNumber, columnCellString);
			verifyDefaultAndAdditionalRequesterInDashboard(additionalRequestersText, requestNumber, columnCellString);
			verifyProducerInDashboard(ProducerText, requestNumber, columnCellString);
			verifySrProducerInDashboard(SrProducerText, requestNumber, columnCellString);
			verifySourceInDashboard(sourceText, requestNumber, columnCellString);
			verifyCamerasInDashboard(cameraText, requestNumber, columnCellString);
			verifyContentDescriptionInDashboard(contentDescriptionText, requestNumber, columnCellString);
			verifySubmittedDateInDashboard(SubmittedText, requestNumber, columnCellString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyCamerasInDashboard(String cameraText, String requestNumber, String columnCellString)
			throws Exception, InterruptedException {
		String columnTypeNoText;
		// To validate camera
		if (cameraText != null) {
			columnTypeNoText = "14";
			String columnCellTypeText = columnCellString.replace("<<RequestId>>", requestNumber)
					.replace("<<ColumnTypeNo>>", columnTypeNoText);
			String cameraCellTypeText = columnCellTypeText.concat("/span/span");
			List<String> CameraList = Constants.getCameras();
			String[] cameraArrayList;
			if (cameraText.contains(",")) {
				WebElement cameraArrayListWebelement = driver.findElement(By.xpath(cameraCellTypeText.concat("/span")));
				Waits.waitForElement(cameraArrayListWebelement, WAIT_CONDITIONS.VISIBLE);
				Thread.sleep(1000);
				WebAction.mouseOverAndClick(cameraArrayListWebelement);
				String cameraNamesXpath = "((//div[contains(@class,'tooltip')])[last()]//li)[<<cameraNo>>]";
				for (int i = 0; i < CameraList.size(); i++) {
					String cameraNamesNewXpath = cameraNamesXpath.replace("<<cameraNo>>", Integer.toString(i + 1));
					producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(
							cameraNamesNewXpath, CameraList.get(i).trim());
				}
				WebAction.click(producerDashboardGeneralPage.ecmDashboardTitleHeader);
			} else {
				cameraArrayList = new String[1];
				cameraArrayList[0] = cameraText;
				producerDashboardGeneralPage.verifyExpectedValueInFormWithActualValueInDashboard(cameraCellTypeText,
						cameraArrayList[0]);
			}
		}
	}

	public void verifyContentManagementRequestDashboardValuesOfMTDForm(String SlugText, String ShowUnitText,
			String divisionText, String dateNeededByText, String timeNeededByText, String finalDestinationText,
			String additionalRequestersText, String ProducerText, String SrProducerText, String sourceText,
			String cameraText, String SubmittedText) throws Exception {
		try {
			String requestNumber = Constants.getRequestNumber();
			String columnCellString = "//*[contains(text(),'<<RequestId>>')]/ancestor::tr/td[<<ColumnTypeNo>>]";
			String columnTypeNoText;

			// To validate timer
			// To validate device received

			verifySlugInDashboard(SlugText, requestNumber, columnCellString);
			verifyShowUnitInDashboard(ShowUnitText, requestNumber, columnCellString);
			verifyDivisionInDashboard(divisionText, requestNumber, columnCellString);
			verifyDateNeededByInDashboard(dateNeededByText, requestNumber, columnCellString);
			verifyTimeNeededByInDashboard(timeNeededByText, requestNumber, columnCellString);
			verifyDestinationsInDashboard(finalDestinationText, requestNumber, columnCellString);
			verifyDefaultAndAdditionalRequesterInDashboard(additionalRequestersText, requestNumber, columnCellString);
			verifyProducerInDashboard(ProducerText, requestNumber, columnCellString);
			verifySrProducerInDashboard(SrProducerText, requestNumber, columnCellString);
			verifySourceInDashboard(sourceText, requestNumber, columnCellString);
			verifyCamerasInDashboard(cameraText, requestNumber, columnCellString);
			verifySubmittedDateInDashboard(SubmittedText, requestNumber, columnCellString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void executeStorage(String fieldName, Runnable store, RequestMode... mode) {
		producerDashboardGeneralPage.executeStorage(fieldName, store, mode);
	}

	public Boolean isEditMode(RequestMode... mode) {
		return producerDashboardGeneralPage.isEditMode(mode);
	}

	public void selectDestinations(String destinationsToSelect, RequestMode... mode) {
		List<String> selectList = Arrays.asList(destinationsToSelect.split(",")).stream().map((op) -> op.trim())
				.collect(Collectors.toList());
		Consumer<String> cons = (op) -> {
			int size = destinationNames.size();
			for (int i = 0; i < size; ++i) {
				String val = WebAction.getText(destinationNames.get(i)).trim();
				if (val.equals(op)) {
					WebElement ele = destinationCheckboxes.get(i);
					if (!ele.isSelected()) {
						try {
							WebAction.scrollIntoViewTillBottom(ele);
							ele.click();
							Runnable store = () -> {
								Boolean isPresent = Constants.getDestinations().stream().filter((des) -> des.equals(op))
										.findFirst().isPresent();
								if (!isPresent) {
									Constants.getDestinations().add(op);
									if (isEditMode(mode)) {
										Constants.getLog().getLogs().putLog("Changed Destinations Section", null);
										producerDashboardGeneralPage.changeRequestStatusToRevised();
									}
								}
							};
							executeStorage(op, store, mode);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					break;
				}
			}
		};
		selectList.forEach(cons);
	}

	public void unselectDestinations(String destinationsToUnselect, RequestMode... mode) {
		List<String> unselectList = Arrays.asList(destinationsToUnselect.split(",")).stream().map((op) -> op.trim())
				.collect(Collectors.toList());
		Consumer<String> cons = (op) -> {
			int size = destinationNames.size();
			for (int i = 0; i < size; ++i) {
				String val = WebAction.getText(destinationNames.get(i)).trim();
				if (val.equals(op)) {
					WebElement ele = destinationCheckboxes.get(i);
					if (ele.isSelected()) {
						try {
							WebAction.scrollIntoViewTillBottom(ele);
							ele.click();
							Runnable store = () -> {
								Boolean isPresent = Constants.getDestinations().stream().filter((des) -> des.equals(op))
										.findFirst().isPresent();
								if (isPresent) {
									Constants.getDestinations().remove(op);
									clearStoredDataRelatedToDestination(op);
									if (isEditMode(mode)) {
										Constants.getLog().getLogs().putLog("Changed Destinations Section", null);
										producerDashboardGeneralPage.changeRequestStatusToRevised();
									}
								}
							};
							executeStorage(op, store, mode);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					break;
				}
			}
		};
		unselectList.forEach(cons);
	}

	public void clearStoredDataRelatedToDestination(String op) {
		if (op.equalsIgnoreCase("Nimbus")) {
			Constants.setDetailsInNimbus(null);
			Constants.setTranscodeNeeded(null);
		} else if (op.equalsIgnoreCase("DC Network News")) {
			Constants.setNeedMaterialArchived(null);
		} else if (op.equalsIgnoreCase("CNBC - AVID")) {
			Constants.setAvidWorkspace(null);
			Constants.setAvidProjectName(null);
			Constants.getAvidBinNames().clear();
		} else if (op.equalsIgnoreCase("CNBC - Stratus")) {
			Constants.getCNBCStratusSlugs().clear();
			Constants.setSourceCompression(null);
			Constants.setSourceFrameRate(null);
			Constants.setTimeCodes(null);
		}

	}

	public void provideOtherDestinationOnFeedout(String option, RequestMode... mode) {
		if (option == null) {
			return;
		}
		otherInputInDestinationsSection.clear();
		otherInputInDestinationsSection.sendKeys(option);
		Runnable store = () -> {
			String old = Constants.getOtherDestinationInDestinations();
			old = (old == null) ? "" : old;
			Constants.setOtherDestinationInDestinations(option);
			if (isEditMode(mode) && !old.equals(option)) {
				Constants.getLog().getLogs().putLog("Changed Destinations Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Other Destination in Destinations", store, mode);
	}

	public void clearOtherDestinationOnFeedout(RequestMode... mode) {
		otherInputInDestinationsSection.clear();
		Runnable store = () -> {
			String old = Constants.getOtherDestinationInDestinations();
			Constants.setOtherDestinationInDestinations(null);
			if (isEditMode(mode) && old != null) {
				Constants.getLog().getLogs().putLog("Changed Destinations Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Other Destination in Destinations", store, mode);
	}

	public void provideCommentsInCommentsSection(String notes, RequestMode... mode) {
		if (notes == null) {
			return;
		}
		commentsTextarea.clear();
		commentsTextarea.sendKeys(notes);
		Runnable store = () -> {
			String old = Constants.getComments();
			old = (old == null) ? "" : old;
			Constants.setComments(notes);
			if (isEditMode(mode) && !old.equals(notes)) {
				Constants.getLog().getLogs().putLog("Changed Comments Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Comments in Comments Section", store, mode);
	}

	public void provideContentDescription(String notes, RequestMode... mode) {
		if (notes == null) {
			return;
		}
		contentDescriptionTextarea.clear();
		contentDescriptionTextarea.sendKeys(notes);
		Runnable store = () -> {
			String old = Constants.getContentDescription();
			old = (old == null) ? "" : old;
			Constants.setContentDescription(notes);
			if (isEditMode(mode) && !old.equals(notes)) {
				Constants.getLog().getLogs().putLog("Changed Content Description Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Content Description", store, mode);
	}

	public void selectSourceCompression(String option, RequestMode... mode) {
		if (option == null) {
			return;
		}
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(sourceCompressionInput, option);
		Assert.assertTrue(isSelected, String.format("'%s' is not selected in Source Compression dropdown", option));
		Runnable store = () -> {
			String oldVal = Constants.getSourceCompression();
			Constants.setSourceCompression(option);
			if (isEditMode(mode) && (oldVal == null || !oldVal.equalsIgnoreCase(option))) {
				Constants.getLog().getLogs().putLog("Changed CNBC Stratus Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Source Compression", store, mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectSourceFrameRate(String option, RequestMode... mode) {
		if (option == null) {
			return;
		}
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(sourceFrameRateInput, option);
		Assert.assertTrue(isSelected, String.format("'%s' is not selected in Source Frame Rate dropdown", option));
		Runnable store = () -> {
			String oldVal = Constants.getSourceFrameRate();
			Constants.setSourceFrameRate(option);
			if (isEditMode(mode) && (oldVal == null || !oldVal.equalsIgnoreCase(option))) {
				Constants.getLog().getLogs().putLog("Changed CNBC Stratus Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Source Frame Rate", store, mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectTimeCodesInFileIngest(String option, RequestMode... mode) {
		if (option == null) {
			return;
		}
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(timecodesInput, option);
		Assert.assertTrue(isSelected, String.format("'%s' is not selected in Time Codes dropdown", option));
		Runnable store = () -> {
			String oldVal = Constants.getTimeCodes();
			Constants.setTimeCodes(option);
			if (isEditMode(mode) && (oldVal == null || !oldVal.equalsIgnoreCase(option))) {
				Constants.getLog().getLogs().putLog("Changed CNBC Stratus Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Time Codes", store, mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void addSlug() {
		try {
			WebAction.scrollIntoViewTillBottom(addSlugButton);
			addSlugButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addBinName() {
		try {
			WebAction.scrollIntoViewTillBottom(addBinNameButton);
			addBinNameButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addAdditionalRecipient() {
		try {
			WebAction.scrollIntoViewTillBottom(addAdditionalRecipientButton);
			Thread.sleep(2000);
			WebAction.click(addAdditionalRecipientButton);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAvidWorkspace(String option, RequestMode... mode) {
		if (option == null) {
			return;
		}
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(avidWorkspaceInput, option);
		Assert.assertTrue(isSelected, String.format("'%s' is not selected in AVID Workspace dropdown", option));
		Runnable store = () -> {
			String oldVal = Constants.getAvidWorkspace();
			Constants.setAvidWorkspace(option);
			if (isEditMode(mode) && oldVal != null && !oldVal.equalsIgnoreCase(option)) {
				Constants.getLog().getLogs().putLog("Changed CNBC Avid Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("AVID Workspace", store, mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectAvidProjectName(String option, RequestMode... mode) {
		if (option == null) {
			return;
		}
		avidProjectNameInput.clear();
		avidProjectNameInput.sendKeys(option);
		Runnable store = () -> {
			String oldVal = Constants.getAvidProjectName();
			Constants.setAvidProjectName(option);
			if (isEditMode(mode) && oldVal != null && !oldVal.equalsIgnoreCase(option)) {
				Constants.getLog().getLogs().putLog("Changed CNBC Avid Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("AVID Project Name", store, mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectNeedMaterialArchived(String choice, RequestMode... mode) {
		if (choice == null) {
			return;
		}
		producerDashboardGeneralPage.selectRadioOption(choice, needMaterialArchivedRadioLabels);
		Runnable store = () -> {
			String old = Constants.getNeedMaterialArchived();
			Constants.setNeedMaterialArchived(choice);
			if (isEditMode(mode) && (old == null || !old.equalsIgnoreCase(choice))) {
				Constants.getLog().getLogs().putLog("Changed DC Network Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Need Material Archived", store, mode);
	}

	public void selectTranscodeNeeded(String choice, RequestMode... mode) {
		if (choice == null) {
			return;
		}
		producerDashboardGeneralPage.selectRadioOption(choice, transcodeNeededRadioLabels);
		Runnable store = () -> {
			String old = Constants.getTranscodeNeeded();
			Constants.setTranscodeNeeded(choice);
			if (isEditMode(mode) && (old == null || !old.equalsIgnoreCase(choice))) {
				Constants.getLog().getLogs().putLog("Changed Nimbus Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Transcode Needed?", store, mode);
	}

	public void provideDetailsInNimbus(String notes, RequestMode... mode) {
		if (notes == null) {
			return;
		}
		detailsInputInNimbus.clear();
		detailsInputInNimbus.sendKeys(notes);
		Runnable store = () -> {
			String old = Constants.getDetailsInNimbus();
			Constants.setDetailsInNimbus(notes);
			old = (old == null) ? "No" : old;
			if (isEditMode(mode) && !old.equals(notes)) {
				Constants.getLog().getLogs().putLog("Changed Nimbus Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Details in Nimbus", store, mode);
	}

	public void putSourceRunnables(RequestMode... mode) {
		List<SourceRecord> existing = new ArrayList<>();
		Constants.getSourcesList().forEach((unit) -> existing.add(unit.copy()));
		Runnable store = () -> {
			if (isEditMode(mode) && !existing.equals(Constants.getSourcesList())) {
				if (Constants.getRequestType() == RequestType.FeedOut) {
					Constants.getLog().getLogs().putLog("Changed Feed Out Request Sources Section", null);
				} else {
					Constants.getLog().getLogs().putLog("Changed Source Section", null);
				}
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Changed Sources", store, mode);
	}

	public void clearDataAccordingToSource(String op, int sourceIndex) {
		// for feed out form
		if (op.equalsIgnoreCase("Tapes")) {
			Constants.getSourcesList().get(sourceIndex).getCnbcStratusSlugs().clear();
		}
	}

	public void selectSourceInSourceSection(String option, String position, RequestMode... mode) {
		if (option == null || position == null) {
			return;
		}
		// 0-based position
		Integer number = Integer.parseInt(position);
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(sourceInputs.get(number), option);
		Assert.assertTrue(isSelected, String.format("'%s' is not selected in Source dropdown", option));
		Runnable store = () -> {
			List<SourceRecord> sources = Constants.getSourcesList();
			while (sources.size() <= number) {
				sources.add(new SourceRecord());
			}
			clearDataAccordingToSource(option, number);
			sources.get(number).setSource(option);
		};
		executeStorage(String.format("Source source %d", number), store, mode);
		putSourceRunnables(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectQuantityInSourceSection(String qty, String position, RequestMode... mode) {
		if (qty == null || position == null) {
			return;
		}
		// 0-based position
		Integer number = Integer.parseInt(position);
		if (number >= quantityInputs.size()) {
			return;
		}
		WebAction.clearInputOneCharAtTime(quantityInputs.get(number));
		quantityInputs.get(number).sendKeys(qty);
		Runnable store = () -> {
			List<SourceRecord> sources = Constants.getSourcesList();
			while (sources.size() <= number) {
				sources.add(new SourceRecord());
			}
			sources.get(number).setQuantity(Integer.parseInt(qty));
		};
		executeStorage(String.format("Source Quantity %d", number), store, mode);
		putSourceRunnables(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectCommentsInSourceSection(String option, String position, RequestMode... mode) {
		if (option == null || position == null) {
			return;
		}
		// 0-based position
		Integer number = Integer.parseInt(position);
		if (number >= quantityInputs.size()) {
			return;
		}
		commentInputsInSource.get(number).clear();
		commentInputsInSource.get(number).sendKeys(option);
		Runnable store = () -> {
			List<SourceRecord> sources = Constants.getSourcesList();
			while (sources.size() <= number) {
				sources.add(new SourceRecord());
			}
			sources.get(number).setComments(option);
		};
		executeStorage(String.format("Source comments %d", number), store, mode);
		putSourceRunnables(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectCameraInSpecificSource(String sourceNumber, String option, String position, RequestMode... mode) {
		if (option == null || position == null) {
			return;
		}
		// 0-based position
		int sourceIndex = Integer.parseInt(sourceNumber);
		WebDriver driver = DriverFactory.getCurrentDriver();
		List<WebElement> inputs = driver
				.findElements(By.xpath(String.format(cameraInputsInSpecificSource, sourceIndex + 1)));
		int number = Integer.parseInt(position);
		if (number >= inputs.size()) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(inputs.get(number));
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(inputs.get(number), option);
		Assert.assertTrue(isSelected, String.format("'%s' is not selected in Camera dropdown", option));
		Runnable store = () -> {
			List<SourceRecord> sources = Constants.getSourcesList();
			while (sources.size() <= sourceIndex) {
				sources.add(new SourceRecord());
			}
			List<String> cameras = sources.get(sourceIndex).getCameras();
			while (cameras.size() <= number) {
				cameras.add(null);
			}
			cameras.set(number, option);
		};
		executeStorage(String.format("Source %d camera %d", sourceIndex, number), store, mode);
		putSourceRunnables(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void removeCamerasFromSources(String sourceNumber, String position, RequestMode... mode) {
		if (sourceNumber == null || position == null) {
			return;
		}
		// 0-based position
		int sourceIndex = Integer.parseInt(sourceNumber);
		int number = Integer.parseInt(position);
		WebDriver driver = DriverFactory.getCurrentDriver();
		List<WebElement> inputs = driver
				.findElements(By.xpath(String.format(cameraInputsInSpecificSource, sourceIndex + 1)));
		if (inputs.size() == 1) {
			WebAction.scrollIntoViewTillBottom(inputs.get(0));
			inputs.get(0).clear();
		} else {
			List<WebElement> removeButtons = driver
					.findElements(By.xpath(String.format(removeCameraButtonsInSpecificSource, sourceIndex + 1)));
			if (number >= removeButtons.size()) {
				return;
			}
			WebAction.scrollIntoViewTillBottom(removeButtons.get(number));
			removeButtons.get(number).click();
		}
		Runnable store = () -> {
			Constants.getSourcesList().get(sourceIndex).getCameras().remove(number);
		};
		executeStorage(LocalDateTime.now().toString(), store, mode);
		putSourceRunnables(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void removeSourceSection(String sourceNumber, RequestMode... mode) {
		if (sourceNumber == null) {
			return;
		}
		if (sourceInputs.size() == 1) {
			return;
		}
		// 0-based position
		int sourceIndex = Integer.parseInt(sourceNumber);
		if (sourceIndex >= removeSourceSectionButtons.size()) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(removeSourceSectionButtons.get(sourceIndex));
		removeSourceSectionButtons.get(sourceIndex).click();
		Runnable store = () -> {
			if (Constants.getSourcesList().size() > sourceIndex) {
				Constants.getSourcesList().remove(sourceIndex);
			}
		};
		executeStorage(LocalDateTime.now().toString(), store, mode);
		putSourceRunnables(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void addAdditionalSource() {
		try {
			WebAction.scrollIntoViewTillBottom(addAdditionalSourceButton);
			addAdditionalSourceButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addDestination() {
		try {
			WebAction.scrollIntoViewTillBottom(addDestinationButtonInMTD);
			addDestinationButtonInMTD.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addCameraType(String sourceNumber) {
		Integer number = Integer.parseInt(sourceNumber);
		try {
			WebElement addButton = addCameraTypeButtons.get(number);
			WebAction.scrollIntoViewTillBottom(addButton);
			addButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addSlugInSourcesInFeedout(String sourceNumber) {
		if (sourceNumber == null) {
			return;
		}
		int number = Integer.parseInt(sourceNumber);
		if (number >= sourceSectionContainers.size()) {
			return;
		}
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			String locator = String.format(addStratusSlugButtonInSpecificSource, number + 1);
			WebElement addButton = driver.findElement(By.xpath(locator));
			WebAction.scrollIntoViewTillBottom(addButton);
			addButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectDivision(String division, RequestMode... mode) {
		if (division == null) {
			return;
		}
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(divisionInput, division);
		Assert.assertTrue(isSelected, String.format("'%s' is not selected in Division dropdown", division));
		Runnable store = () -> {
			String oldVal = Constants.getDivision();
			Constants.setDivision(division);
			if (isEditMode(mode) && oldVal != null && !oldVal.equalsIgnoreCase(division)) {
				Constants.getLog().getLogs().putLog("Changed General Details Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Division", store, mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void provideSlug(String slug, RequestMode... mode) {
		if (slug == null) {
			return;
		}
		slugInput.clear();
		slugInput.sendKeys(slug);
		Runnable store = () -> {
			String oldVal = Constants.getSlug();
			Constants.setSlug(slug);
			if (isEditMode(mode) && oldVal != null && !oldVal.equalsIgnoreCase(slug)) {
				Constants.getLog().getLogs().putLog("Changed General Details Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Slug", store, mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectNcxStoryName(RequestMode... mode) {
		try {
			Waits.waitUntilElementSizeGreater(storyNameSearchResults, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (storyNameSearchResults.size() > 0) {
			int index = (int) (Math.random() * storyNameSearchResults.size());
			WebElement ele = storyNameSearchResults.get(index);
			String storyName = WebAction.getText(ele).trim();
			WebAction.scrollIntoViewTillBottom(ele);
			ele.click();
			Runnable store = () -> {
				String oldVal = Constants.getNcxStoryName();
				Constants.setNcxStoryName(storyName);
				if (isEditMode(mode) && (oldVal == null || !oldVal.equalsIgnoreCase(storyName))) {
					Constants.getLog().getLogs().putLog("Changed General Details Section", null);
					producerDashboardGeneralPage.changeRequestStatusToRevised();
				}
			};
			executeStorage("NCX Story Name", store, mode);
		}
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void putAdditionalRecipientsRunnable(RequestMode... mode) {
		List<String> existingSlugs = new ArrayList<>();
		Constants.getAdditionalRecipients().forEach((str) -> existingSlugs.add(new String(str)));
		Runnable store = () -> {
			if (isEditMode(mode) && !existingSlugs.equals(Constants.getAdditionalRecipients())) {
				if (Constants.getRequestType() == RequestType.FeedOut) {
					Constants.getLog().getLogs().putLog("Changed Additional Recipient Section", null);
				} else {
					Constants.getLog().getLogs().putLog("Changed Additional Recipient(s) Section", null);
				}
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Changed Additional Recipients", store, mode);
	}

	public void selectAdditionalRecipient(String option, String position, RequestMode... mode) {
		if (option == null || position == null) {
			return;
		}
		// 0-based position
		Integer number = Integer.parseInt(position);
		if (number >= additionalRecipientInputs.size()) {
			return;
		}
		additionalRecipientInputs.get(number).clear();
		additionalRecipientInputs.get(number).sendKeys(option);
		Runnable store = () -> {
			List<String> sources = Constants.getAdditionalRecipients();
			while (sources.size() <= number) {
				sources.add(null);
			}
			sources.set(number, option);
		};
		executeStorage(String.format("Additional Recipients %d", number), store, mode);
		putAdditionalRecipientsRunnable(mode);
	}

	public void removeAdditionalRecipient(String position, RequestMode... mode) throws Exception {
		if (position == null) {
			return;
		}
		// 0-based position
		int number = Integer.parseInt(position);
		if (number >= removeAdditionalRecipientButtons.size()) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(removeAdditionalRecipientButtons.get(number));
		removeAdditionalRecipientButtons.get(number).click();
		Runnable store = () -> {
			if (Constants.getAdditionalRecipients().size() > number) {
				Constants.getAdditionalRecipients().remove(number);
			}
		};
		executeStorage(LocalDateTime.now().toString(), store, mode);
		putAdditionalRecipientsRunnable(mode);
	}

	public void selectDateNeededBy(String daysOffsetFromCurrent, RequestMode... mode) {
		if (daysOffsetFromCurrent == null) {
			return;
		}
		try {
			String date = DateFunctions.getDateUsingOffsetFromToday("MM/dd/yyyy",
					Integer.parseInt(daysOffsetFromCurrent));
			dateNeededByInput.sendKeys(date, Keys.ENTER);
			Runnable store = () -> {
				String old = Constants.getDateNeededBy();
				old = (old == null) ? "" : old;
				if (isEditMode(mode) && !old.equals(date)) {
					Constants.getLog().getLogs().putLog("Changed Date & Time Needed Section", null);
					producerDashboardGeneralPage.changeRequestStatusToRevised();
				}
				Constants.setDateNeededBy(date);
			};
			executeStorage("Date Needed By", store, mode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectTimeNeededBy(String time, RequestMode... mode) throws Exception {
		if (time == null) {
			return;
		}
		timeNeededByInput.sendKeys(time, Keys.ENTER);
		Runnable store = () -> {
			String oldTime = Constants.getTimeNeededBy();
			if (oldTime == null) {
				oldTime = "";
			}
			if (isEditMode(mode) && !oldTime.equalsIgnoreCase(time)) {
				Constants.getLog().getLogs().putLog("Changed Date & Time Needed Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
			Constants.setTimeNeededBy(time);
		};
		executeStorage("Time Needed By", store, mode);
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void tryClearing(WebElement clearIcon, WebElement input) {
		int trials = 3;
		while (--trials >= 0) {
			try {
				WebAction.mouseOverAndClick(clearIcon);
				Thread.sleep(2000);
				String value = WebAction.getAttribute(input, "value");
				if (value.equals("")) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void clearDateNeededBy() throws Exception {
		tryClearing(clearDateNeededByButton, dateNeededByInput);
		String value = WebAction.getAttribute(dateNeededByInput, "value");
		Assert.assertTrue(value.equals(""), "Date Needed By input is not cleared");
	}

	public void clearTimeNeededBy() throws Exception {
		tryClearing(clearTimeNeededByButton, timeNeededByInput);
		String value = WebAction.getAttribute(timeNeededByInput, "value");
		Assert.assertTrue(value.equals(""), "Time Needed By input is not cleared");
	}

	public void selectAirDate(String daysOffsetFromCurrent, RequestMode... mode) {
		if (daysOffsetFromCurrent == null) {
			return;
		}
		try {
			String date = DateFunctions.getDateUsingOffsetFromToday("MM/dd/yyyy",
					Integer.parseInt(daysOffsetFromCurrent));
			airDateInput.sendKeys(date, Keys.ENTER);
			Runnable store = () -> {
				String old = Constants.getAirDate();
				old = (old == null) ? "" : old;
				if (isEditMode(mode) && !old.equals(date)) {
					Constants.getLog().getLogs().putLog("Changed Show Information Section", null);
					producerDashboardGeneralPage.changeRequestStatusToRevised();
				}
				Constants.setAirDate(date);
			};
			executeStorage("Air Date", store, mode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAirTime(String time, RequestMode... mode) throws Exception {
		if (time == null) {
			return;
		}
		airTimeInput.sendKeys(time, Keys.ENTER);
		Runnable store = () -> {
			String oldTime = Constants.getAirTime();
			if (oldTime == null) {
				oldTime = "";
			}
			if (isEditMode(mode) && !oldTime.equalsIgnoreCase(time)) {
				Constants.getLog().getLogs().putLog("Changed Show Information Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
			Constants.setAirTime(time);
		};
		executeStorage("Air Time", store, mode);
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void clearAirTime(RequestMode... mode) throws Exception {
		tryClearing(clearAirTimeButton, airTimeInput);
		String value = WebAction.getAttribute(airTimeInput, "value");
		Assert.assertTrue(value.equals(""), "Air Time input is not cleared");
		Runnable store = () -> {
			if (isEditMode(mode)) {
				Constants.getLog().getLogs().putLog("Changed Show Information Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
			Constants.setAirTime(null);
		};
		executeStorage("Air Time", store, mode);
	}

	public void clearAirDate(RequestMode... mode) throws Exception {
		tryClearing(clearAirDateButton, airDateInput);
		String value = WebAction.getAttribute(airDateInput, "value");
		Assert.assertTrue(value.equals(""), "Air date input is not cleared");
		Runnable store = () -> {
			if (isEditMode(mode)) {
				Constants.getLog().getLogs().putLog("Changed Show Information Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
			Constants.setAirDate(null);
		};
		executeStorage("Air Date", store, mode);
	}

	public void selectToBeDetermined(RequestMode... mode) throws Exception {
		if (!toBeDeterminedInput.isSelected()) {
			WebAction.scrollIntoViewTillBottom(toBeDeterminedInput);
			toBeDeterminedInput.click();
			Runnable store = () -> {
				Constants.setAirDate(null);
				String old = Constants.getToBeDeterminedInShowInformation();
				old = (old == null) ? "No" : old;
				Constants.setToBeDeterminedInShowInformation("Yes");
				if (isEditMode(mode) && !old.equalsIgnoreCase("Yes")) {
					Constants.getLog().getLogs().putLog("Changed Show Information Section", null);
					producerDashboardGeneralPage.changeRequestStatusToRevised();
				}
			};
			executeStorage("TBD", store, mode);
		}
	}

	public void unselectToBeDetermined(RequestMode... mode) throws Exception {
		if (toBeDeterminedInput.isSelected()) {
			WebAction.scrollIntoViewTillBottom(toBeDeterminedInput);
			toBeDeterminedInput.click();
			Runnable store = () -> {
				String old = Constants.getToBeDeterminedInShowInformation();
				old = (old == null) ? "No" : old;
				Constants.setToBeDeterminedInShowInformation("No");
				if (isEditMode(mode) && !old.equalsIgnoreCase("No")) {
					Constants.getLog().getLogs().putLog("Changed Show Information Section", null);
					producerDashboardGeneralPage.changeRequestStatusToRevised();
				}
			};
			executeStorage("TBD", store, mode);
		}
	}

	public void selectFlexibleInShowInformation(RequestMode... mode) throws Exception {
		if (!flexibleInputInShowInformation.isSelected()) {
			WebAction.scrollIntoViewTillBottom(flexibleInputInShowInformation);
			flexibleInputInShowInformation.click();
			Runnable store = () -> {
				Constants.setAirTime(null);
				String old = Constants.getFlexibleInShowInformation();
				old = (old == null) ? "No" : old;
				Constants.setFlexibleInShowInformation("Yes");
				if (isEditMode(mode) && !old.equalsIgnoreCase("Yes")) {
					Constants.getLog().getLogs().putLog("Changed Show Information Section", null);
					producerDashboardGeneralPage.changeRequestStatusToRevised();
				}
			};
			executeStorage("Flexible In Show Information", store, mode);
		}
	}

	public void unselectFlexibleInShowInformation(RequestMode... mode) throws Exception {
		if (flexibleInputInShowInformation.isSelected()) {
			WebAction.scrollIntoViewTillBottom(flexibleInputInShowInformation);
			flexibleInputInShowInformation.click();
			Runnable store = () -> {
				String old = Constants.getFlexibleInShowInformation();
				old = (old == null) ? "No" : old;
				Constants.setFlexibleInShowInformation("No");
				if (isEditMode(mode) && !old.equalsIgnoreCase("No")) {
					Constants.getLog().getLogs().putLog("Changed Show Information Section", null);
					producerDashboardGeneralPage.changeRequestStatusToRevised();
				}
			};
			executeStorage("Flexible In Show Information", store, mode);
		}
	}

	public void selectFlexibleInDateAndTimeNeeded(RequestMode... mode) throws Exception {
		if (!flexibleInputInDateAndTimeNeeded.isSelected()) {
			WebAction.scrollIntoViewTillBottom(flexibleInputInDateAndTimeNeeded);
			flexibleInputInDateAndTimeNeeded.click();
			Runnable store = () -> {
				Constants.setTimeNeededBy(null);
				String old = Constants.getFlexibleInDateAndTimeNeeded();
				old = (old == null) ? "No" : old;
				Constants.setFlexibleInDateAndTimeNeeded("Yes");
				if (isEditMode(mode) && !old.equalsIgnoreCase("Yes")) {
					Constants.getLog().getLogs().putLog("Changed Date & Time Needed Section", null);
					producerDashboardGeneralPage.changeRequestStatusToRevised();
				}
			};
			executeStorage("Flexible In Date & Time Needed", store, mode);
		}
	}

	public void unselectFlexibleInDateAndTimeNeeded(RequestMode... mode) throws Exception {
		if (flexibleInputInDateAndTimeNeeded.isSelected()) {
			WebAction.scrollIntoViewTillBottom(flexibleInputInDateAndTimeNeeded);
			flexibleInputInDateAndTimeNeeded.click();
			Runnable store = () -> {
				String old = Constants.getFlexibleInDateAndTimeNeeded();
				old = (old == null) ? "No" : old;
				Constants.setFlexibleInDateAndTimeNeeded("No");
				if (isEditMode(mode) && !old.equalsIgnoreCase("No")) {
					Constants.getLog().getLogs().putLog("Changed Date & Time Needed Section", null);
					producerDashboardGeneralPage.changeRequestStatusToRevised();
				}
			};
			executeStorage("Flexible In Date & Time Needed", store, mode);
		}
	}

	public void selectAsap(RequestMode... mode) throws Exception {
		if (!asapInput.isSelected()) {
			WebAction.scrollIntoViewTillBottom(asapInput);
			asapInput.click();
			Runnable store = () -> {
				Constants.setDateNeededBy(null);
				String old = Constants.getASAPInDateAndTimeNeeded();
				old = (old == null) ? "No" : old;
				Constants.setASAPInDateAndTimeNeeded("Yes");
				if (isEditMode(mode) && !old.equalsIgnoreCase("Yes")) {
					Constants.getLog().getLogs().putLog("Changed Date & Time Needed Section", null);
					producerDashboardGeneralPage.changeRequestStatusToRevised();
				}
			};
			executeStorage("ASAP", store, mode);
		}
	}

	public void unselectAsap(RequestMode... mode) throws Exception {
		if (asapInput.isSelected()) {
			WebAction.scrollIntoViewTillBottom(asapInput);
			asapInput.click();
			Runnable store = () -> {
				String old = Constants.getASAPInDateAndTimeNeeded();
				old = (old == null) ? "No" : old;
				Constants.setASAPInDateAndTimeNeeded("No");
				if (isEditMode(mode) && !old.equalsIgnoreCase("No")) {
					Constants.getLog().getLogs().putLog("Changed Date & Time Needed Section", null);
					producerDashboardGeneralPage.changeRequestStatusToRevised();
				}
			};
			executeStorage("ASAP", store, mode);
		}
	}

	public void addShowUnit() {
		try {
			WebAction.scrollIntoViewTillBottom(addShowUnitButton);
			addShowUnitButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void putCnbcStratusSlugsRunnable(RequestMode... mode) {
		List<String> existingSlugs = new ArrayList<>();
		Constants.getCNBCStratusSlugs().forEach((str) -> existingSlugs.add(new String(str)));
		Runnable store = () -> {
			if (isEditMode(mode) && !existingSlugs.equals(Constants.getCNBCStratusSlugs())) {
				Constants.getLog().getLogs().putLog("Changed CNBC Stratus Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Changed CNBC Stratus slugs", store, mode);
	}

	public void selectSlugsInCNBCStratusSection(String option, String position, RequestMode... mode) {
		if (option == null || position == null) {
			return;
		}
		// 0-based position
		Integer number = Integer.parseInt(position);
		if (number >= cnbcStratusSlugInputs.size()) {
			return;
		}
		cnbcStratusSlugInputs.get(number).clear();
		cnbcStratusSlugInputs.get(number).sendKeys(option);
		Runnable store = () -> {
			List<String> slugs = Constants.getCNBCStratusSlugs();
			while (slugs.size() <= number) {
				slugs.add(null);
			}
			slugs.set(number, option);
		};
		executeStorage(String.format("CNBC Stratus Slug %d", number), store, mode);
		putCnbcStratusSlugsRunnable(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void removeSlugsInCNBCStratusSection(String position, RequestMode... mode) throws Exception {
		if (position == null) {
			return;
		}
		Runnable store;
		if (cnbcStratusSlugInputs.size() == 1) {
			WebAction.scrollIntoViewTillBottom(cnbcStratusSlugInputs.get(0));
			cnbcStratusSlugInputs.get(0).clear();
			store = () -> {
				System.out.println("removing : " + Constants.getCNBCStratusSlugs().get(0));
				Constants.getCNBCStratusSlugs().remove(0);
			};
		} else {
			// 0-based position
			int number = Integer.parseInt(position);
			if (number >= removeSlugButtons.size()) {
				return;
			}
			WebAction.scrollIntoViewTillBottom(removeSlugButtons.get(number));
			removeSlugButtons.get(number).click();
			store = () -> {
				System.out.println("removing : " + Constants.getCNBCStratusSlugs().get(number));
				Constants.getCNBCStratusSlugs().remove(number);
			};
		}
		executeStorage(LocalDateTime.now().toString(), store, mode);
		putCnbcStratusSlugsRunnable(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void putCnbcAvidBinNamesRunnable(RequestMode... mode) {
		List<String> existing = new ArrayList<>();
		Constants.getAvidBinNames().forEach((str) -> existing.add(new String(str)));
		Runnable store = () -> {
			if (isEditMode(mode) && !existing.equals(Constants.getAvidBinNames())) {
				Constants.getLog().getLogs().putLog("Changed CNBC Avid Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Changed CNBC Avid Bin Names", store, mode);
	}

	public void selectBinNamesInCNBCAvidSection(String option, String position, RequestMode... mode) {
		if (option == null || position == null) {
			return;
		}
		// 0-based position
		Integer number = Integer.parseInt(position);
		if (number >= avidBinNameInputs.size()) {
			return;
		}
		avidBinNameInputs.get(number).clear();
		avidBinNameInputs.get(number).sendKeys(option);
		Runnable store = () -> {
			List<String> binNames = Constants.getAvidBinNames();
			while (binNames.size() <= number) {
				binNames.add(null);
			}
			binNames.set(number, option);
		};
		executeStorage(String.format("CNBC Avid Bin Name %d", number), store, mode);
		putCnbcAvidBinNamesRunnable(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void removeBinNamesInCNBCAvidSection(String position, RequestMode... mode) {
		if (position == null) {
			return;
		}
		Runnable store;
		if (cnbcStratusSlugInputs.size() == 1) {
			WebAction.scrollIntoViewTillBottom(avidBinNameInputs.get(0));
			avidBinNameInputs.get(0).clear();
			store = () -> {
				Constants.getAvidBinNames().remove(0);
			};
		} else {
			// 0-based position
			int number = Integer.parseInt(position);
			if (number >= removeBinNamesButtons.size()) {
				return;
			}
			WebAction.scrollIntoViewTillBottom(removeBinNamesButtons.get(number));
			removeBinNamesButtons.get(number).click();
			store = () -> {
				Constants.getAvidBinNames().remove(number);
			};
		}
		executeStorage(LocalDateTime.now().toString(), store, mode);
		putCnbcAvidBinNamesRunnable(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void putShowUnitsRunnable(RequestMode... mode) {
		List<ShowUnitRecord> existing = new ArrayList<>();
		Constants.getShowUnits().forEach((unit) -> existing.add(unit.copy()));
		Runnable store = () -> {
			if (isEditMode(mode) && !existing.equals(Constants.getShowUnits())) {
				Constants.getLog().getLogs().putLog("Changed Show Information Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Changed Show Units or Project Names", store, mode);
	}

	public void selectShowUnitOrProjectName(String option, String position, RequestMode... mode) throws Exception {
		if (option == null || position == null) {
			return;
		}
		// 0-based position
		int number = Integer.parseInt(position);
		if (number >= showUnitOrProjctNameInputs.size()) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(showUnitOrProjctNameInputs.get(number));
		try {
			WebAction.sendKeys(showUnitOrProjctNameInputs.get(number), option);
//			Waits.waitUntilElementSizeEquals(loadingIconInList, 1);
//			Waits.waitUntilElementSizeEquals(loadingIconInList, 0);
			producerDashboardGeneralPage.waitForOptionToBeVisible(SearchList, option);
			Optional<WebElement> optional = SearchList.stream().filter((ele) -> getText(ele).trim().contains(option))
					.findFirst();
			if (optional.isPresent()) {
				WebElement record = optional.get();
				WebAction.click(record);
				Thread.sleep(2000);
				String budgetCode = WebAction.getAttribute(budgetCodeInputs.get(number), "value");
				Runnable store = () -> {
					List<ShowUnitRecord> showUnits = Constants.getShowUnits();
					while (showUnits.size() <= number) {
						showUnits.add(new ShowUnitRecord());
					}
					showUnits.get(number).setShowUnit(option);
					showUnits.get(number).setBudgetCode(budgetCode);
				};
				executeStorage(String.format("Show Unit or Project Name %d", number), store, mode);
				putShowUnitsRunnable(mode);
				// for closing the dropdown
				producerDashboardGeneralPage.clickFormTitle();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeShowUnitOrProjectName(String position, RequestMode... mode) {
		if (position == null) {
			return;
		}
		// 0-based position
		int number = Integer.parseInt(position);
		if (showUnitOrProjctNameInputs.size() == 1) {
			WebAction.scrollIntoViewTillBottom(budgetCodeInputs.get(0));
			showUnitOrProjctNameInputs.get(0).clear();
			budgetCodeInputs.get(0).clear();
		} else {
			if (number >= removeShowUnitButtons.size()) {
				return;
			}
			WebAction.scrollIntoViewTillBottom(removeShowUnitButtons.get(number));
			removeShowUnitButtons.get(number).click();
		}
		Runnable store = () -> {
			Constants.getShowUnits().remove(number);
		};
		executeStorage(LocalDateTime.now().toString(), store, mode);
		putShowUnitsRunnable(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectCnbcSlugInSpecificSource(String sourceNumber, String position, String option,
			RequestMode... mode) {
		if (option == null || position == null || sourceNumber == null) {
			return;
		}
		// 0-based position
		int sourceIndex = Integer.parseInt(sourceNumber);
		if (sourceIndex >= sourceSectionContainers.size()) {
			return;
		}
		WebDriver driver = DriverFactory.getCurrentDriver();
		String locator = String.format(cnbcStratusSlugInputsInSpecificSource, sourceIndex + 1);
		List<WebElement> inputs = driver.findElements(By.xpath(locator));
		System.out.println("inputs size: " + inputs.size());
		int number = Integer.parseInt(position);
		if (number >= inputs.size()) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(inputs.get(number));
		inputs.get(number).clear();
		inputs.get(number).sendKeys(option);
		Runnable store = () -> {
			List<SourceRecord> sources = Constants.getSourcesList();
			while (sources.size() <= sourceIndex) {
				sources.add(new SourceRecord());
			}
			List<String> slugs = sources.get(sourceIndex).getCnbcStratusSlugs();
			while (slugs.size() <= number) {
				slugs.add(null);
			}
			slugs.set(number, option);
		};
		executeStorage(String.format("Source %d Slug %d", sourceIndex, number), store, mode);
		putSourceRunnables(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void removeSlugFromSources(String sourceNumber, String position, RequestMode... mode) {
		if (sourceNumber == null || position == null) {
			return;
		}
		// 0-based position
		int sourceIndex = Integer.parseInt(sourceNumber);
		if (sourceIndex >= sourceSectionContainers.size()) {
			return;
		}
		WebDriver driver = DriverFactory.getCurrentDriver();
		String locator = String.format(cnbcStratusSlugInputsInSpecificSource, sourceIndex + 1);
		List<WebElement> inputs = driver.findElements(By.xpath(locator));
		int number = Integer.parseInt(position);
		if (inputs.size() == 1) {
			WebAction.scrollIntoViewTillBottom(inputs.get(0));
			inputs.get(0).clear();
		} else {
			String locator2 = String.format(removeCnbcSlugButtonsInSpecificSource, sourceIndex + 1);
			List<WebElement> removeButtons = driver.findElements(By.xpath(locator2));
			if (number >= removeButtons.size()) {
				return;
			}
			WebAction.scrollIntoViewTillBottom(removeButtons.get(number));
			removeButtons.get(number).click();
		}
		Runnable store = () -> {
			Constants.getSourcesList().get(sourceIndex).getCnbcStratusSlugs().remove(number);
		};
		executeStorage(LocalDateTime.now().toString(), store, mode);
		putSourceRunnables(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void provideSourceDetailsInSourceSection(String option, String position, RequestMode... mode) {
		if (option == null || position == null) {
			return;
		}
		// 0-based position
		Integer number = Integer.parseInt(position);
		if (number >= sourceDetailsInputsInSourcesSection.size()) {
			return;
		}
		sourceDetailsInputsInSourcesSection.get(number).clear();
		sourceDetailsInputsInSourcesSection.get(number).sendKeys(option);
		Runnable store = () -> {
			List<SourceRecord> sources = Constants.getSourcesList();
			while (sources.size() <= number) {
				sources.add(new SourceRecord());
			}
			sources.get(number).setSourceDetails(option);
		};
		executeStorage(String.format("Source Source details %d", number), store, mode);
		putSourceRunnables(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectTimeCodesInMTD(String sourceIndex, String option, RequestMode... mode) {
		if (option == null || sourceIndex == null) {
			return;
		}
		int number = Integer.parseInt(sourceIndex);
		if (number >= timecodesInputsInMTD.size()) {
			return;
		}
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(timecodesInputsInMTD.get(number),
				option);
		Assert.assertTrue(isSelected,
				String.format("'%s' is not selected in Time Codes dropdown in source %d in MTD", option, number));
		Runnable store = () -> {
			List<SourceRecord> sources = Constants.getSourcesList();
			while (sources.size() <= number) {
				sources.add(new SourceRecord());
			}
			sources.get(number).setTimecodes(option);
		};
		executeStorage(String.format("Source Time Codes %d", number), store, mode);
		putSourceRunnables(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void putDestinationsInMtdRunnables(RequestMode... mode) {
		List<DestinationRecord> existing = new ArrayList<>();
		Constants.getDestinationsInMTD().forEach((dest) -> existing.add(dest.copy()));
		Runnable store = () -> {
			if (isEditMode(mode) && !existing.equals(Constants.getDestinationsInMTD())) {
				Constants.getLog().getLogs().putLog("Changed Destination Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Changed Destination in MTD", store, mode);
	}

	public void selectDestinationInMTD(String option, String position, RequestMode... mode) {
		if (option == null || position == null) {
			return;
		}
		// 0-based position
		Integer number = Integer.parseInt(position);
		Boolean isSelected = producerDashboardGeneralPage
				.selectValueInDropdown(destinationInputsInDestinationsSecionOnMTD.get(number), option);
		Assert.assertTrue(isSelected, String.format("'%s' is not selected in Destination dropdown", option));
		Runnable store = () -> {
			List<DestinationRecord> destinations = Constants.getDestinationsInMTD();
			while (destinations.size() <= number) {
				destinations.add(new DestinationRecord());
			}
			destinations.get(number).setDestination(option);
		};
		executeStorage(String.format("Destination destination %d", number), store, mode);
		putDestinationsInMtdRunnables(mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectQuantityInDestinationInMtd(String qty, String position, RequestMode... mode) {
		if (qty == null || position == null) {
			return;
		}
		// 0-based position
		Integer number = Integer.parseInt(position);
		if (number >= quantityInputsInDestinationsSecionOnMTD.size()) {
			return;
		}
		WebAction.clearInputOneCharAtTime(quantityInputsInDestinationsSecionOnMTD.get(number));
		quantityInputsInDestinationsSecionOnMTD.get(number).sendKeys(qty);
		Runnable store = () -> {
			List<DestinationRecord> destinations = Constants.getDestinationsInMTD();
			while (destinations.size() <= number) {
				destinations.add(new DestinationRecord());
			}
			destinations.get(number).setQuantity(Integer.parseInt(qty));
		};
		executeStorage(String.format("Destination quantity %d", number), store, mode);
		putDestinationsInMtdRunnables(mode);
	}

	public void selectDetailsInDestinationInMtd(String option, String position, RequestMode... mode) {
		if (option == null || position == null) {
			return;
		}
		// 0-based position
		Integer number = Integer.parseInt(position);
		if (number >= detailsTextareasInDestinationsSecionOnMTD.size()) {
			return;
		}
		detailsTextareasInDestinationsSecionOnMTD.get(number).clear();
		detailsTextareasInDestinationsSecionOnMTD.get(number).sendKeys(option);
		Runnable store = () -> {
			List<DestinationRecord> destinations = Constants.getDestinationsInMTD();
			while (destinations.size() <= number) {
				destinations.add(new DestinationRecord());
			}
			destinations.get(number).setDetails(option);
		};
		executeStorage(String.format("Destination details %d", number), store, mode);
		putDestinationsInMtdRunnables(mode);
	}

	public void removeDestinationSectionInMtd(String destinationNumber, RequestMode... mode) {
		if (destinationNumber == null) {
			return;
		}
		if (destinationInputsInDestinationsSecionOnMTD.size() == 1) {
			return;
		}
		// 0-based position
		int destinationIndex = Integer.parseInt(destinationNumber);
		if (destinationIndex >= removeDestinationButtonsInMTD.size()) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(removeDestinationButtonsInMTD.get(destinationIndex));
		removeDestinationButtonsInMTD.get(destinationIndex).click();
		Runnable store = () -> {
			if (Constants.getDestinationsInMTD().size() > destinationIndex) {
				Constants.getDestinationsInMTD().remove(destinationIndex);
			}
		};
		executeStorage(LocalDateTime.now().toString(), store, mode);
		putDestinationsInMtdRunnables(mode);
	}

	public void provideInstructionsInInstructionsSection(String notes, RequestMode... mode) {
		if (notes == null) {
			return;
		}
		instructionsInput.clear();
		instructionsInput.sendKeys(notes);
		Runnable store = () -> {
			String old = Constants.getInstructions();
			old = (old == null) ? "" : old;
			Constants.setInstructions(notes);
			if (isEditMode(mode) && !old.equals(notes)) {
				Constants.getLog().getLogs().putLog("Changed Instructions Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Instructions in Instructions Section", store, mode);
	}

	public void clearInstructionsInInstructionsSection(RequestMode... mode) {
		instructionsInput.clear();
		Runnable store = () -> {
			String old = Constants.getInstructions();
			Constants.setInstructions(null);
			if (isEditMode(mode) && old != null) {
				Constants.getLog().getLogs().putLog("Changed Instructions Section", null);
				producerDashboardGeneralPage.changeRequestStatusToRevised();
			}
		};
		executeStorage("Instructions in Instructions Section", store, mode);
	}

	public void selectMethodOfIngestInFulfillment(String options, RequestMode... mode) {
		if (options == null) {
			return;
		}
		List<String> optionsToSelect = Arrays.asList(options.split(",")).stream().map((op) -> op.trim())
				.collect(Collectors.toList());
		for (String option : optionsToSelect) {
			Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(methodOfIngestInputInFulfillment,
					option);
			Assert.assertTrue(isSelected, String.format("'%s' is not selected in Method of Ingest dropdown", option));
			Runnable store = () -> {
				List<String> ingests = Constants.getMethodsOfIngest();
				if (!ingests.contains(option)) {
					Constants.getMethodsOfIngest().add(option);
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage(String.format("ingest method %s", option), store, mode);
		}
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectDestinationsInFileIngestFulfillment(String options, RequestMode... mode) {
		if (options == null) {
			return;
		}
		List<String> optionsToSelect = Arrays.asList(options.split(",")).stream().map((op) -> op.trim())
				.collect(Collectors.toList());
		for (String option : optionsToSelect) {
			Boolean isSelected = producerDashboardGeneralPage
					.selectValueInDropdown(destinationsInputInFileIngestFulfillment, option);
			Assert.assertTrue(isSelected,
					String.format("'%s' is not selected in Destination(s) dropdown " + "in fulfillment", option));
			Runnable store = () -> {
				List<String> destinations = Constants.getDestinationsInFulfillment();
				if (!destinations.contains(option)) {
					Constants.getDestinationsInFulfillment().add(option);
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage(String.format("destinations in fulfillment %s", option), store, mode);
		}
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectDestinationsInFeedOutFulfillment(String options, RequestMode... mode) {
		if (options == null) {
			return;
		}
		List<String> optionsToSelect = Arrays.asList(options.split(",")).stream().map((op) -> op.trim())
				.collect(Collectors.toList());
		for (String option : optionsToSelect) {
			Boolean isSelected = producerDashboardGeneralPage
					.selectValueInDropdown(destinationsInputInFeedOutFulfillment, option);
			Assert.assertTrue(isSelected,
					String.format("'%s' is not selected in Destination(s) dropdown " + "in fulfillment", option));
			Runnable store = () -> {
				List<String> destinations = Constants.getDestinationsInFulfillment();
				if (!destinations.contains(option)) {
					Constants.getDestinationsInFulfillment().add(option);
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage(String.format("destinations in fulfillment %s", option), store, mode);
		}
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectDestinationsInMtdFulfillment(String option, String position, RequestMode... mode) {
		if (Objects.isNull(option) || Objects.isNull(position)) {
			return;
		}
		int pos = Integer.parseInt(position);
		if (pos >= destinationsInputsInMtdFulfillment.size()) {
			return;
		}
		Boolean isSelected = producerDashboardGeneralPage
				.selectValueInDropdown(destinationsInputsInMtdFulfillment.get(pos), option);
		Assert.assertTrue(isSelected,
				String.format("'%s' is not selected in Destination(s) dropdown " + "in fulfillment", option));
		Runnable store = () -> {
			List<String> destinations = Constants.getDestinationsInFulfillment();
			if (!destinations.contains(option)) {
				Constants.getDestinationsInFulfillment().add(option);
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage(String.format("destinations in fulfillment %s", option), store, mode);

		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectFileFormatsInFileIngestFulfillment(String options, RequestMode... mode) {
		if (options == null) {
			return;
		}
		List<String> optionsToSelect = Arrays.asList(options.split(",")).stream().map((op) -> op.trim())
				.collect(Collectors.toList());
		for (String option : optionsToSelect) {
			Boolean isSelected = producerDashboardGeneralPage
					.selectValueInDropdown(fileFormatInputInFileIngestFulfillment, option);
			Assert.assertTrue(isSelected,
					String.format("'%s' is not selected in File Format dropdown " + "in fulfillment", option));
			Runnable store = () -> {
				List<String> fileFormats = Constants.getFileFormatInFulfillment();
				if (!fileFormats.contains(option)) {
					Constants.getFileFormatInFulfillment().add(option);
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage(String.format("file format in fulfillment %s", option), store, mode);
		}
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectFileFormatsInFeedOutFulfillment(String options, RequestMode... mode) {
		if (options == null) {
			return;
		}
		List<String> optionsToSelect = Arrays.asList(options.split(",")).stream().map((op) -> op.trim())
				.collect(Collectors.toList());
		for (String option : optionsToSelect) {
			Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(fileFormatInputInFeedOutFulfillment,
					option);
			Assert.assertTrue(isSelected,
					String.format("'%s' is not selected in File Format dropdown " + "in fulfillment", option));
			Runnable store = () -> {
				List<String> fileFormats = Constants.getFileFormatInFulfillment();
				if (!fileFormats.contains(option)) {
					Constants.getFileFormatInFulfillment().add(option);
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage(String.format("file format in fulfillment %s", option), store, mode);
		}
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectFolderFormatsInFulfillment(String options, RequestMode... mode) {
		if (options == null) {
			return;
		}
		List<String> optionsToSelect = Arrays.asList(options.split(",")).stream().map((op) -> op.trim())
				.collect(Collectors.toList());
		for (String option : optionsToSelect) {
			Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(folderFormatInputInFulfillment,
					option);
			Assert.assertTrue(isSelected,
					String.format("'%s' is not selected in Folder Format dropdown " + "in fulfillment", option));
			Runnable store = () -> {
				List<String> folderFormats = Constants.getFolderFormatInFulfillment();
				if (!folderFormats.contains(option)) {
					Constants.getFolderFormatInFulfillment().add(option);
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage(String.format("folder format in fulfillment %s", option), store, mode);
		}
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectGigSizeInFulfillment(String qty, RequestMode... mode) {
		if (qty == null) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(gigSizeInputInFulfillment);
		WebAction.clearInputOneCharAtTime(gigSizeInputInFulfillment);
		gigSizeInputInFulfillment.sendKeys(qty);
		Runnable store = () -> {
			Integer old = Constants.getGigSize();
			Integer newQty = Integer.parseInt(qty);
			Constants.setGigSize(newQty);
			if (!Objects.equals(old, newQty)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Gig Size", store, mode);
	}

	public void selectClipCountInFileIngestFulfillment(String qty, RequestMode... mode) {
		if (qty == null) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(clipCountInputInFileIngestFulfillment);
		WebAction.clearInputOneCharAtTime(clipCountInputInFileIngestFulfillment);
		clipCountInputInFileIngestFulfillment.sendKeys(qty);
		Runnable store = () -> {
			Integer old = Constants.getClipCount();
			Integer newQty = Integer.parseInt(qty);
			Constants.setClipCount(newQty);
			if (!Objects.equals(old, newQty)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Clip count", store, mode);
	}

	public void selectClipCountInFeedOutFulfillment(String qty, RequestMode... mode) {
		if (qty == null) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(clipCountInputInFeedOutFulfillment);
		WebAction.clearInputOneCharAtTime(clipCountInputInFeedOutFulfillment);
		clipCountInputInFeedOutFulfillment.sendKeys(qty);
		Runnable store = () -> {
			Integer old = Constants.getClipCount();
			Integer newQty = Integer.parseInt(qty);
			Constants.setClipCount(newQty);
			if (!Objects.equals(old, newQty)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Clip count", store, mode);
	}

	public void selectBinNameInFulfillment(String option, RequestMode... mode) {
		if (option == null) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(binNameInputInFulfillment);
		binNameInputInFulfillment.clear();
		binNameInputInFulfillment.sendKeys(option);
		Runnable store = () -> {
			String binName = Constants.getBinNameInFulfillment();
			Constants.setBinNameInFulfillment(option);
			if (!Objects.equals(binName, option)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Bin Name in Fulfillment", store, mode);
	}

	public void selectMediaIdInFileIngestFulfillment(String option, RequestMode... mode) {
		if (option == null) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(mediaIdInputInFileIngestFulfillment);
		mediaIdInputInFileIngestFulfillment.clear();
		mediaIdInputInFileIngestFulfillment.sendKeys(option);
		Runnable store = () -> {
			String mediaId = Constants.getMediaIdInFulfillment();
			Constants.setMediaIdInFulfillment(option);
			if (!Objects.equals(mediaId, option)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Media Id in Fulfillment", store, mode);
	}

	public void selectMediaIdInFeedOutFulfillment(String option, RequestMode... mode) {
		if (option == null) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(mediaIdInputInFeedOutFulfillment);
		mediaIdInputInFeedOutFulfillment.clear();
		mediaIdInputInFeedOutFulfillment.sendKeys(option);
		Runnable store = () -> {
			String mediaId = Constants.getMediaIdInFulfillment();
			Constants.setMediaIdInFulfillment(option);
			if (!Objects.equals(mediaId, option)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Media Id in Fulfillment", store, mode);
	}

	public void selectAssistantEditorAssignedInFulfillment(String name, RequestMode... mode) throws Exception {
		if (Objects.isNull(name)) {
			return;
		}
		WebAction.scrollIntoView(assistantEditorAssignedInputInFulfillment);
		try {
			assistantEditorAssignedInputInFulfillment.clear();
			WebAction.sendKeys(assistantEditorAssignedInputInFulfillment, name);
			Waits.waitUntilElementSizeEquals(loadingIconInRequestersList, 1);
			Waits.waitUntilElementSizeEquals(loadingIconInRequestersList, 0);
			Optional<WebElement> optional = SearchList.stream().filter((ele) -> getText(ele).trim().contains(name))
					.findFirst();
			if (optional.isPresent()) {
				WebElement record = optional.get();
				WebAction.click(record);
				Runnable store = () -> {
					String old = Constants.getAssistantEditorAssigned();
					Constants.setAssistantEditorAssigned(name);
					if (!Objects.equals(old, name)) {
						Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
					}
				};
				executeStorage("Assistant Editor Assigned in fulfillment", store, mode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectIngestCompleteInCnbcStratusIngestInFulfillment(String option, RequestMode... mode) {
		if (Objects.isNull(option)) {
			return;
		}
		producerDashboardGeneralPage.selectRadioOption(option, ingestCompleteRadioLabelsInCnbcStratusIngest);
		Runnable store = () -> {
			String old = Constants.getIngestCompleteInCnbcStratusInFulfillment();
			Constants.setIngestCompleteInCnbcStratusInFulfillment(option);
			if (!Objects.equals(old, option)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Ingest Complete in CNBC Stratus in Fulfillment", store, mode);
	}

	public void selectTimeInCnbcStratusIngestInFulfillment(String hours, String minutes, String seconds,
			RequestMode... mode) {
		if (Objects.nonNull(hours)) {
			WebAction.scrollIntoViewTillBottom(hoursInputInCnbcStratusIngest);
			hoursInputInCnbcStratusIngest.clear();
			hoursInputInCnbcStratusIngest.sendKeys(hours);
			Runnable store = () -> {
				String oldHours = Constants.getHoursInCnbcStratusInFulfillment();
				Constants.setHoursInCnbcStratusInFulfillment(hours);
				if (!Objects.equals(oldHours, hours)) {
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage("Hours in CNBC Stratus in Fulfillment", store, mode);
		}
		if (Objects.nonNull(minutes)) {
			WebAction.scrollIntoViewTillBottom(minutesInputInCnbcStratusIngest);
			minutesInputInCnbcStratusIngest.clear();
			minutesInputInCnbcStratusIngest.sendKeys(minutes);
			Runnable store = () -> {
				String oldMinutes = Constants.getMinutesInCnbcStratusInFulfillment();
				Constants.setMinutesInCnbcStratusInFulfillment(hours);
				if (!Objects.equals(oldMinutes, minutes)) {
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage("Minutes in CNBC Stratus in Fulfillment", store, mode);
		}
		if (Objects.nonNull(seconds)) {
			WebAction.scrollIntoViewTillBottom(secondsInputInCnbcStratusIngest);
			secondsInputInCnbcStratusIngest.clear();
			secondsInputInCnbcStratusIngest.sendKeys(seconds);
			Runnable store = () -> {
				String oldSeconds = Constants.getSecondsInCnbcStratusInFulfillment();
				Constants.setSecondsInCnbcStratusInFulfillment(hours);
				if (!Objects.equals(oldSeconds, seconds)) {
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage("Seconds in CNBC Stratus in Fulfillment", store, mode);
		}
	}

	public void selectTranscodeCompleteInCnbcStratusIngestInFulfillment(String option, RequestMode... mode) {
		if (Objects.isNull(option)) {
			return;
		}
		producerDashboardGeneralPage.selectRadioOption(option, transcodeCompleteRadioLabelsInCnbcStratusIngest);
		Runnable store = () -> {
			String old = Constants.getTranscodeCompleteInCnbcStratusInFulfillment();
			Constants.setTranscodeCompleteInCnbcStratusInFulfillment(option);
			if (!Objects.equals(old, option)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Transcode Complete in CNBC Stratus in Fulfillment", store, mode);
	}

	public void selectTranscodingNeededInCnbcStratusIngestInFulfillment(String option, RequestMode... mode) {
		if (Objects.isNull(option)) {
			return;
		}
		String classes = WebAction.getAttribute(transcodingNeededButtonInCnbcStratusIngest, "class");
		Boolean isSelected = classes.contains("ant-switch-checked");
		if ((isSelected && option.equalsIgnoreCase("No")) || (!isSelected && option.equalsIgnoreCase("Yes"))) {
			WebAction.scrollIntoViewTillBottom(transcodingNeededButtonInCnbcStratusIngest);
			transcodingNeededButtonInCnbcStratusIngest.click();
		}
		Runnable store = () -> {
			String old = Constants.getTranscodingNeededInCnbcStratusInFulfillment();
			Constants.setTranscodingNeededInCnbcStratusInFulfillment(option);
			if (!Objects.equals(old, option)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Transcoding Needed in CNBC Stratus in Fulfillment", store, mode);
	}

	public void selectIngestCompleteInCnbcAvidIngestInFulfillment(String option, RequestMode... mode) {
		if (Objects.isNull(option)) {
			return;
		}
		producerDashboardGeneralPage.selectRadioOption(option, ingestCompleteRadioLabelsInCnbcAvidIngest);
		Runnable store = () -> {
			String old = Constants.getIngestCompleteInCnbcAvidInFulfillment();
			Constants.setIngestCompleteInCnbcAvidInFulfillment(option);
			if (!Objects.equals(old, option)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Ingest Complete in CNBC Avid in Fulfillment", store, mode);
	}

	public void selectTimeInCnbcAvidIngestInFulfillment(String hours, String minutes, String seconds,
			RequestMode... mode) {
		if (Objects.nonNull(hours)) {
			WebAction.scrollIntoViewTillBottom(hoursInputInCnbcAvidIngest);
			hoursInputInCnbcAvidIngest.clear();
			hoursInputInCnbcAvidIngest.sendKeys(hours);
			Runnable store = () -> {
				String oldHours = Constants.getHoursInCnbcAvidInFulfillment();
				Constants.setHoursInCnbcAvidInFulfillment(hours);
				if (!Objects.equals(oldHours, hours)) {
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage("Hours in CNBC Avid in Fulfillment", store, mode);
		}
		if (Objects.nonNull(minutes)) {
			WebAction.scrollIntoViewTillBottom(minutesInputInCnbcAvidIngest);
			minutesInputInCnbcAvidIngest.clear();
			minutesInputInCnbcAvidIngest.sendKeys(minutes);
			Runnable store = () -> {
				String oldMinutes = Constants.getMinutesInCnbcAvidInFulfillment();
				Constants.setMinutesInCnbcAvidInFulfillment(minutes);
				if (!Objects.equals(oldMinutes, minutes)) {
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage("Minutes in CNBC Avid in Fulfillment", store, mode);
		}
		if (Objects.nonNull(seconds)) {
			WebAction.scrollIntoViewTillBottom(secondsInputInCnbcAvidIngest);
			secondsInputInCnbcAvidIngest.clear();
			secondsInputInCnbcAvidIngest.sendKeys(seconds);
			Runnable store = () -> {
				String oldSeconds = Constants.getSecondsInCnbcAvidInFulfillment();
				Constants.setSecondsInCnbcAvidInFulfillment(seconds);
				if (!Objects.equals(oldSeconds, seconds)) {
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage("Seconds in CNBC Avid in Fulfillment", store, mode);
		}
	}

	public void selectWorkspaceInCnbcAvidInFulfillment(String option, RequestMode... mode) {
		if (Objects.isNull(option)) {
			return;
		}
		Boolean isSelected = producerDashboardGeneralPage.selectValueInDropdown(workspaceInputInCnbcAvidIngest, option);
		Assert.assertTrue(isSelected,
				String.format("'%s' is not selected in Workspace dropdown " + "in CNBC Avid in fulfillment", option));
		Runnable store = () -> {
			String old = Constants.getWorkspaceInCnbcAvidInFulfillment();
			Constants.setWorkspaceInCnbcAvidInFulfillment(option);
			if (!Objects.equals(old, option)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Workspace In Cnbc Avid In Fulfillment", store, mode);
		// for closing the dropdown
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void selectProjectInCnbcAvidInFulfillment(String option, RequestMode... mode) {
		if (Objects.isNull(option)) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(projectInputInCnbcAvidIngest);
		projectInputInCnbcAvidIngest.clear();
		projectInputInCnbcAvidIngest.sendKeys(option);
		Runnable store = () -> {
			String old = Constants.getProjectInCnbcAvidInFulfillment();
			Constants.setProjectInCnbcAvidInFulfillment(option);
			if (!Objects.equals(old, option)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Project In Cnbc Avid In Fulfillment", store, mode);
	}

	public void putBinNamesInCnbcAvidInFulfillmentRunnable(RequestMode... mode) {
		List<String> existing = new ArrayList<>();
		Constants.getBinNamesInCnbcAvidInFulfillment().forEach((str) -> existing.add(new String(str)));
		Runnable store = () -> {
			if (Objects.equals(existing, Constants.getBinNamesInCnbcAvidInFulfillment())) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Changed Bin Names in CNBC Avid in Fulfillment", store, mode);
	}

	public void selectBinNamesInCNBCAvidInFulfillment(String option, String position, RequestMode... mode) {
		if (Objects.isNull(option) || Objects.isNull(position)) {
			return;
		}
		// 0-based position
		Integer number = Integer.parseInt(position);
		if (number >= binNameInputsInCnbcAvidIngest.size()) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(binNameInputsInCnbcAvidIngest.get(number));
		binNameInputsInCnbcAvidIngest.get(number).clear();
		binNameInputsInCnbcAvidIngest.get(number).sendKeys(option);
		Runnable store = () -> {
			List<String> binNames = Constants.getBinNamesInCnbcAvidInFulfillment();
			while (binNames.size() <= number) {
				binNames.add(null);
			}
			binNames.set(number, option);
		};
		executeStorage(String.format("Bin Name %d in CNBC Avid in Fulfillment", number), store, mode);
		putBinNamesInCnbcAvidInFulfillmentRunnable(mode);
	}

	public void addBinNameInCnbcAvidInFulfillment() {
		try {
			WebAction.scrollIntoViewTillBottom(addBinNameButtonInCnbcAvidIngest);
			addBinNameButtonInCnbcAvidIngest.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectTimeInTimerInFileIngestFulfillment(String hours, String minutes, String seconds,
			RequestMode... mode) {
		if (Objects.nonNull(hours)) {
			WebAction.scrollIntoViewTillBottom(hoursInputInTimerInFileIngestFulfillment);
			hoursInputInTimerInFileIngestFulfillment.clear();
			hoursInputInTimerInFileIngestFulfillment.sendKeys(hours);
			Runnable store = () -> {
				String oldHours = Constants.getHoursInTimerInFulfillment();
				Constants.setHoursInTimerInFulfillment(hours);
				if (!Objects.equals(oldHours, hours)) {
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage("Hours in Timer in Fulfillment", store, mode);
		}
		if (Objects.nonNull(minutes)) {
			WebAction.scrollIntoViewTillBottom(minutesInputInTimerInFileIngestFulfillment);
			minutesInputInTimerInFileIngestFulfillment.clear();
			minutesInputInTimerInFileIngestFulfillment.sendKeys(minutes);
			Runnable store = () -> {
				String oldMinutes = Constants.getMinutesInTimerInFulfillment();
				Constants.setMinutesInTimerInFulfillment(hours);
				if (!Objects.equals(oldMinutes, minutes)) {
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage("Minutes in Timer in Fulfillment", store, mode);
		}
		if (Objects.nonNull(seconds)) {
			WebAction.scrollIntoViewTillBottom(secondsInputInTimerInFileIngestFulfillment);
			secondsInputInTimerInFileIngestFulfillment.clear();
			secondsInputInTimerInFileIngestFulfillment.sendKeys(seconds);
			Runnable store = () -> {
				String oldSeconds = Constants.getSecondsInTimerInFulfillment();
				Constants.setSecondsInTimerInFulfillment(hours);
				if (!Objects.equals(oldSeconds, seconds)) {
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage("Seconds in Timer in Fulfillment", store, mode);
		}
	}

	public void selectTimeInTimerInFeedOutFulfillment(String hours, String minutes, String seconds,
			RequestMode... mode) {
		if (Objects.nonNull(hours)) {
			WebAction.scrollIntoViewTillBottom(hoursInputInTimerInFeedOutFulfillment);
			hoursInputInTimerInFeedOutFulfillment.clear();
			hoursInputInTimerInFeedOutFulfillment.sendKeys(hours);
			Runnable store = () -> {
				String oldHours = Constants.getHoursInTimerInFulfillment();
				Constants.setHoursInTimerInFulfillment(hours);
				if (!Objects.equals(oldHours, hours)) {
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage("Hours in Timer in Fulfillment", store, mode);
		}
		if (Objects.nonNull(minutes)) {
			WebAction.scrollIntoViewTillBottom(minutesInputInTimerInFeedOutFulfillment);
			minutesInputInTimerInFeedOutFulfillment.clear();
			minutesInputInTimerInFeedOutFulfillment.sendKeys(minutes);
			Runnable store = () -> {
				String oldMinutes = Constants.getMinutesInTimerInFulfillment();
				Constants.setMinutesInTimerInFulfillment(hours);
				if (!Objects.equals(oldMinutes, minutes)) {
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage("Minutes in Timer in Fulfillment", store, mode);
		}
		if (Objects.nonNull(seconds)) {
			WebAction.scrollIntoViewTillBottom(secondsInputInTimerInFeedOutFulfillment);
			secondsInputInTimerInFeedOutFulfillment.clear();
			secondsInputInTimerInFeedOutFulfillment.sendKeys(seconds);
			Runnable store = () -> {
				String oldSeconds = Constants.getSecondsInTimerInFulfillment();
				Constants.setSecondsInTimerInFulfillment(hours);
				if (!Objects.equals(oldSeconds, seconds)) {
					Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
				}
			};
			executeStorage("Seconds in Timer in Fulfillment", store, mode);
		}
	}

	public void provideCommentsInFileIngestFulfillment(String notes, RequestMode... mode) {
		if (Objects.isNull(notes)) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(commentsInputInFileIngestFulfillment);
		commentsInputInFileIngestFulfillment.clear();
		commentsInputInFileIngestFulfillment.sendKeys(notes);
		Runnable store = () -> {
			String old = Constants.getCommentsInFulfillment();
			Constants.setCommentsInFulfillment(notes);
			if (!Objects.equals(old, notes)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Comments in Fulfillment", store, mode);
	}

	public void changeStatusInFileIngestFulfillment(String status, RequestMode... mode) throws Exception {
		if (Objects.isNull(status)) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(statusButtonInFileIngestFulfillment);
		statusButtonInFileIngestFulfillment.click();
		Waits.waitUntilElementSizeGreater(statusOptionsInFulfillment, 0);
		Optional<WebElement> suitableStatusElement = statusOptionsInFulfillment.stream()
				.filter((el) -> getText(el).trim().equalsIgnoreCase(status)).findAny();
		if (suitableStatusElement.isPresent()) {
			suitableStatusElement.get().click();
			Runnable store = () -> {
				Constants.setRequestStatus(RequestStatus.getStatus(status));
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			};
			executeStorage("Status in Fulfillment", store, mode);
		}
	}

	public void provideCommentsInFeedOutFulfillment(String notes, RequestMode... mode) {
		if (Objects.isNull(notes)) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(commentsInputInFeedOutFulfillment);
		commentsInputInFeedOutFulfillment.clear();
		commentsInputInFeedOutFulfillment.sendKeys(notes);
		Runnable store = () -> {
			String old = Constants.getCommentsInFulfillment();
			Constants.setCommentsInFulfillment(notes);
			if (!Objects.equals(old, notes)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Comments in Fulfillment", store, mode);
	}

	public void changeStatusInFeedOutFulfillment(String status, RequestMode... mode) throws Exception {
		if (Objects.isNull(status)) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(statusButtonInFeedOutFulfillment);
		statusButtonInFeedOutFulfillment.click();
		Waits.waitUntilElementSizeGreater(statusOptionsInFulfillment, 0);
		Optional<WebElement> suitableStatusElement = statusOptionsInFulfillment.stream()
				.filter((el) -> getText(el).trim().equalsIgnoreCase(status)).findAny();
		if (suitableStatusElement.isPresent()) {
			suitableStatusElement.get().click();
			Runnable store = () -> {
				Constants.setRequestStatus(RequestStatus.getStatus(status));
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			};
			executeStorage("Status in Fulfillment", store, mode);
		}
	}

	public void selectFeedTimeInFulfillment(String time, RequestMode... mode) throws Exception {
		if (Objects.isNull(time)) {
			return;
		}
		WebAction.scrollIntoViewTillBottom(feedtimeInputInFulfillment);
		feedtimeInputInFulfillment.sendKeys(time, Keys.ENTER);
		Runnable store = () -> {
			String old = Constants.getFeedTimeInFulfillment();
			Constants.setFeedTimeInFulfillment(time);
			if (!Objects.equals(old, time)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Feed Time in fulfillment", store, mode);
		producerDashboardGeneralPage.clickFormTitle();
	}

	public void clearFeedTimeInFulfillment(RequestMode... mode) throws Exception {
		tryClearing(clearFeedTimeInputInFulfillment, feedtimeInputInFulfillment);
		String value = WebAction.getAttribute(feedtimeInputInFulfillment, "value");
		Assert.assertTrue(value.equals(""), "Feed Time input in fulfillment is not cleared");
		Runnable store = () -> {
			String old = Constants.getFeedTimeInFulfillment();
			Constants.setFeedTimeInFulfillment(null);
			if (!Objects.equals(old, null)) {
				Constants.getLog().getLogs().putLog("Changed Fulfillment Section", null);
			}
		};
		executeStorage("Feed Time in fulfillment", store, mode);
	}
}
