package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.When.Whens;
import nbcu.automation.ui.enums.RequestMode;
import nbcu.automation.ui.pages.ncxUnifiedTool.ContentManagementRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.EditRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProducerDashboardGeneralPage;
import nbcu.framework.utils.cucumber.CucumberUtils;

public class ContentManagementRequestFormPageSteps {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();
	EditRequestFormPage editRequestFormPage = new EditRequestFormPage();
	ContentManagementRequestFormPage contentManagementRequestFormPage = new ContentManagementRequestFormPage();

	@When("user enters General info in Feed Out Request form")
	@When("user enters General info in File Ingest Request form")
	public void addProducerInfoinGeneralSectionInContentManagementForm(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.addGeneralInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Slug"),
				CucumberUtils.getValuesFromDataTable(dataTable, "NCX Story Name"));
		producerDashboardGeneralPage.selectDivision(CucumberUtils.getValuesFromDataTable(dataTable, "Division"));
		producerDashboardGeneralPage
				.additionalRequestersListInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Additional Requesters"));
		editRequestFormPage
				.fillAdditionalRecipients(CucumberUtils.getValuesFromDataTable(dataTable, "Additional Recipients"));
		producerDashboardGeneralPage
				.addProducerInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Is Producer Same as Requestor"));
		producerDashboardGeneralPage
				.enterSeniorProducerValue(CucumberUtils.getValuesFromDataTable(dataTable, "Sr Producer"));
		producerDashboardGeneralPage.enterTalentValue(CucumberUtils.getValuesFromDataTable(dataTable, "Talent"));
	}

	@When("user enters show info Information in MTD Request form")
	@When("user enters show info Information in Feed Out Request form")
	@When("user enters show info Information in File Ingest Request form")
	public void fillShowInfoInContentManagement(DataTable dataTable) throws Exception {
		editRequestFormPage.addShowInfoInECM(CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Budget Code"));
		editRequestFormPage.addAirDateTimeInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Air Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Air Time"));
	}

	@When("user enters Date Needed By and Time Needed By info in MTD Request form")
	@When("user enters Date Needed By and Time Needed By info in Feed Out Request form")
	@When("user enters Date Needed By and Time Needed By info in File Ingest Request form")
	public void fillDateNeededByTimeNeededBy(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.fillDateNeededByTimeNeededBy(
				CucumberUtils.getValuesFromDataTable(dataTable, "Date Needed By"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Time Needed By"));
	}

	@When("user enters source info in File Ingest Request form")
	public void fillSourceInFileIngest(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.fillSource(CucumberUtils.getValuesFromDataTable(dataTable, "Source"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Quantity"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Comments"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Camera"));
	}

	@When("user selects Final Destination in Feed Out Request form")
	@When("user selects Final Destination in File Ingest Request form")
	public void fillFinalDestinationSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage
				.fillDestinationDetails(CucumberUtils.getValuesFromDataTable(dataTable, "Final Destination"));
	}

	@When("user enters content description info in Feed Out Request form")
	@When("user enters content description info in File Ingest Request form")
	public void fillContentDescriptionSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage
				.fillContentDescriptionInCM(CucumberUtils.getValuesFromDataTable(dataTable, "Content Description"));
	}

	@When("user enters comments info in Feed Out Request form")
	@When("user enters comments info in File Ingest Request form")
	public void fillCommentsSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.fillCommentInCM(CucumberUtils.getValuesFromDataTable(dataTable, "Comments"));
	}

	@And("user enters fulfillment info in File Ingest Fulfillment section")
	public void user_enters_FileIngest_fulfillment_details(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.fileIngestFillFulfullmentSection(
				CucumberUtils.getValuesFromDataTable(dataTable, "Method Of Ingest"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Destinations"),
				CucumberUtils.getValuesFromDataTable(dataTable, "File Format"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Gig Size"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Clip Count"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Folder Format"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Bin Name"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Media ID"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Assistant Editor Assigned"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Cnbc Stratus Ingest"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Transcoding Needed"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Transcode Complete"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Cnbc Avid Ingest"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Device Timer Hours"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Device Timer Minutes"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Device Timer Seconds"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Fulfiller Comments"));
	}

	@When("user enters source info in Feed Out Request form")
	public void fillSourceInFeedOut(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.fillSourceFeedOut(CucumberUtils.getValuesFromDataTable(dataTable, "Source"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Source Slug"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Quantity"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Comments"));
	}

	@And("user enters fulfillment info in Feed Out Fulfillment section")
	public void user_enters_Feedout_fulfillment_details(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.feedOutFillFulfullmentSection(
				CucumberUtils.getValuesFromDataTable(dataTable, "Destinations"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Media ID"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Feed Time"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Device Timer Hours"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Device Timer Minutes"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Device Timer Seconds"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Clip Count"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Fulfiller Comments"));
	}

	@When("user enters source info in MTD Request form")
	public void fillSourceInMTD(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.fillSourceInMTD(CucumberUtils.getValuesFromDataTable(dataTable, "Source"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Source Details"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Time Codes"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Camera"));
	}

	@When("user selects Final Destination in MTD Request form")
	public void fillFinalDestinationSectionINMTD(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.fillDestinationInMTD(
				CucumberUtils.getValuesFromDataTable(dataTable, "Destination"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Quantity"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Details"));
	}

	@When("user enters Instructions info in MTD Request form")
	public void fillInstructionsSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage
				.fillInstructionsInCM(CucumberUtils.getValuesFromDataTable(dataTable, "Instructions"));
	}

	@And("user enters fulfillment info in MTD Fulfillment section")
	public void user_enters_MTD_fulfillment_details(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.MTDFillFulfullmentSection(
				CucumberUtils.getValuesFromDataTable(dataTable, "Destinations"),
				CucumberUtils.getValuesFromDataTable(dataTable, "File Format"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Gig Size"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Clip Count"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Device Timer Hours"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Device Timer Minutes"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Device Timer Seconds"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Fulfiller Comments"));
	}

	@Then("verify {string} of {string} status is {string} in ECM fullfiller dashboard")
	public void verifyStatusColorinECM(String cssType, String status, String expectedColor) throws Exception {
		contentManagementRequestFormPage.verifyStatusBackgroundColorInECM(cssType, status, expectedColor);
	}

	@Then("verify all fields in the Feed Out form are matching with columns in content management dashboard")
	public void verifyContentManagementRequestDashboardValuesWithFeedOutForm(DataTable dataTable) throws Exception {
		String cssType = "background color";
		contentManagementRequestFormPage.verifyStatusBackgroundColorInECM(cssType,
				CucumberUtils.getValuesFromDataTable(dataTable, "Status"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Color"));
		contentManagementRequestFormPage.verifyContentManagementRequestDashboardValuesOfFeedOutForm(
				CucumberUtils.getValuesFromDataTable(dataTable, "Slug"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Division"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Date Needed By"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Time Needed By"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Final Destination"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Requesters"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Producer"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Sr Producer"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Source"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Content Description"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Submitted"));
	}

	@Then("verify all fields in the File Ingest form are matching with columns in content management dashboard")
	public void verifyContentManagementRequestDashboardValuesWithFileIngestForm(DataTable dataTable) throws Exception {
		String cssType = "background color";
		contentManagementRequestFormPage.verifyStatusBackgroundColorInECM(cssType,
				CucumberUtils.getValuesFromDataTable(dataTable, "Status"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Color"));
		contentManagementRequestFormPage.verifyContentManagementRequestDashboardValuesOfFileIngestForm(
				CucumberUtils.getValuesFromDataTable(dataTable, "Slug"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Division"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Date Needed By"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Time Needed By"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Final Destination"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Requesters"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Producer"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Sr Producer"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Source"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Camera"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Content Description"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Submitted"));
	}

	@Then("verify all fields in the MTD form are matching with columns in content management dashboard")
	public void verifyContentManagementRequestDashboardValuesWithMTDForm(DataTable dataTable) throws Exception {
		String cssType = "background color";
		contentManagementRequestFormPage.verifyStatusBackgroundColorInECM(cssType,
				CucumberUtils.getValuesFromDataTable(dataTable, "Status"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Color"));
		contentManagementRequestFormPage.verifyContentManagementRequestDashboardValuesOfMTDForm(
				CucumberUtils.getValuesFromDataTable(dataTable, "Slug"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Division"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Date Needed By"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Time Needed By"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Final Destination"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Requesters"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Producer"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Sr Producer"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Source"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Camera"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Submitted"));
	}
	@When("user selects fields in General Details section on ECM request")
	public void selectFieldsInGeneralDetailsSection(DataTable dataTable) {
		String slug = CucumberUtils.getValueFromDataTable(dataTable, "Slug");
		contentManagementRequestFormPage.provideSlug(slug);
		if(slug != null) {
			contentManagementRequestFormPage.selectNcxStoryName();
		}
		contentManagementRequestFormPage.selectDivision(
				CucumberUtils.getValueFromDataTable(dataTable, "Division"));
	}
	@When("user selects fields in General Details section on ECM request in edit mode")
	public void editFieldsInGeneralDetailsSection(DataTable dataTable) {
		String slug = CucumberUtils.getValueFromDataTable(dataTable, "Slug");
		contentManagementRequestFormPage.provideSlug(slug,RequestMode.EDIT);
		if(slug != null) {
			contentManagementRequestFormPage.selectNcxStoryName(RequestMode.EDIT);
		}
		contentManagementRequestFormPage.selectDivision(
				CucumberUtils.getValueFromDataTable(dataTable, "Division"),RequestMode.EDIT);
	}
	@When("user selects fields in Additional Recipients\\(s) section on ECM request")
	public void selectFieldsInAdditionalRecipientsSection(DataTable dataTable) throws Exception {
		String option=CucumberUtils.getValueFromDataTable(dataTable, "Email"); 
		String position=CucumberUtils.getValueFromDataTable(dataTable, "Position");
		contentManagementRequestFormPage.selectAdditionalRecipient(option,position);
		contentManagementRequestFormPage.removeAdditionalRecipient(
				CucumberUtils.getValueFromDataTable(dataTable, "Remove email from position"));
	}
	@When("user selects fields in Additional Recipients\\(s) section on ECM request in edit mode")
	public void editFieldsInAdditionalRecipientsSection(DataTable dataTable) throws Exception {
		String option=CucumberUtils.getValueFromDataTable(dataTable, "Email"); 
		String position=CucumberUtils.getValueFromDataTable(dataTable, "Position");
		contentManagementRequestFormPage.selectAdditionalRecipient(option,position,RequestMode.EDIT);
		contentManagementRequestFormPage.removeAdditionalRecipient(
				CucumberUtils.getValueFromDataTable(dataTable, "Remove email from position"),RequestMode.EDIT);
	}
	@When("user selects fields in Producer Details section on ECM request")
	public void selectFieldsInProducerDetailsSection(DataTable dataTable) throws Exception {
		String reqSameAsProducer = CucumberUtils.getValueFromDataTable(dataTable, "Req same as producer");
		if(reqSameAsProducer != null) {
			if(reqSameAsProducer.equals("Yes")) {
				producerDashboardGeneralPage.selectReqSameAsProducer();
			}
			else {
				producerDashboardGeneralPage.unselectReqSameAsProducer();
			}
		}
		producerDashboardGeneralPage.selectProducer(
				CucumberUtils.getValueFromDataTable(dataTable, "Producer"));
		producerDashboardGeneralPage.selectSeniorProducer(
				CucumberUtils.getValueFromDataTable(dataTable, "Senior Producer"));
	}
	@When("user selects fields in Producer Details section on ECM request in edit mode")
	public void editFieldsInProducerDetailsSection(DataTable dataTable) throws Exception {
		String reqSameAsProducer = CucumberUtils.getValueFromDataTable(dataTable, "Req same as producer");
		if(reqSameAsProducer != null) {
			if(reqSameAsProducer.equals("Yes")) {
				producerDashboardGeneralPage.selectReqSameAsProducer(RequestMode.EDIT);
			}
			else {
				producerDashboardGeneralPage.unselectReqSameAsProducer(RequestMode.EDIT);
			}
		}
		producerDashboardGeneralPage.selectProducer(
				CucumberUtils.getValueFromDataTable(dataTable, "Producer"),RequestMode.EDIT);
		producerDashboardGeneralPage.selectSeniorProducer(
				CucumberUtils.getValueFromDataTable(dataTable, "Senior Producer"),RequestMode.EDIT);
	}
	@When("user selects fields in Date & Time Needed section on ECM request")
	public void selectFieldsInDateAndTimeNeededSection(DataTable dataTable) throws Exception {
		String asap = CucumberUtils.getValueFromDataTable(dataTable, "ASAP");
		if(asap != null) {
			if(asap.equals("Yes")) {
				contentManagementRequestFormPage.selectAsap();
			}
			else {
				contentManagementRequestFormPage.unselectAsap();
			}
		}
		String flexible = CucumberUtils.getValueFromDataTable(dataTable, "Flexible");
		if(flexible != null) {
			if(flexible.equals("Yes")) {
				contentManagementRequestFormPage.selectFlexibleInDateAndTimeNeeded();
			}
			else {
				contentManagementRequestFormPage.unselectFlexibleInDateAndTimeNeeded();
			}
		}
		contentManagementRequestFormPage.selectTimeNeededBy(
				CucumberUtils.getValueFromDataTable(dataTable, "Time"));
		contentManagementRequestFormPage.selectDateNeededBy(
				CucumberUtils.getValueFromDataTable(dataTable, "Days from today"));
	}
	@When("user selects fields in Date & Time Needed section on ECM request in edit mode")
	public void editFieldsInDateAndTimeNeededSection(DataTable dataTable) throws Exception {
		String asap = CucumberUtils.getValueFromDataTable(dataTable, "ASAP");
		if(asap != null) {
			if(asap.equals("Yes")) {
				contentManagementRequestFormPage.selectAsap(RequestMode.EDIT);
			}
			else {
				contentManagementRequestFormPage.unselectAsap(RequestMode.EDIT);
			}
		}
		String flexible = CucumberUtils.getValueFromDataTable(dataTable, "Flexible");
		if(flexible != null) {
			if(flexible.equals("Yes")) {
				contentManagementRequestFormPage.selectFlexibleInDateAndTimeNeeded(RequestMode.EDIT);
			}
			else {
				contentManagementRequestFormPage.unselectFlexibleInDateAndTimeNeeded(RequestMode.EDIT);
			}
		}
		contentManagementRequestFormPage.selectDateNeededBy(
				CucumberUtils.getValueFromDataTable(dataTable, "Days from today"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectTimeNeededBy(
				CucumberUtils.getValueFromDataTable(dataTable, "Time"),RequestMode.EDIT);
	}
	@When("user selects fields in Comments section on ECM request")
	public void selectFieldsInCommentsSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.provideCommentsInCommentsSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Comments"));
	}
	@When("user selects fields in Comments section on ECM request in edit mode")
	public void editFieldsInCommentsSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.provideCommentsInCommentsSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Comments"),RequestMode.EDIT);
	}
	@When("user selects fields in Content Description section on ECM request")
	public void selectFieldsInContentDescriptionSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.provideContentDescription(
				CucumberUtils.getValueFromDataTable(dataTable, "Content Description"));
	}
	@When("user selects fields in Content Description section on ECM request in edit mode")
	public void editFieldsInContentDescriptionSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.provideContentDescription(
				CucumberUtils.getValueFromDataTable(dataTable, "Content Description"),RequestMode.EDIT);
	}
	@When("user selects fields in CNBC-Stratus section on ECM request")
	public void selectFieldsInCNBCStratusSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectSourceCompression(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Compression"));
		contentManagementRequestFormPage.selectSourceFrameRate(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Frame Rate"));
		contentManagementRequestFormPage.selectTimeCodesInFileIngest(
				CucumberUtils.getValueFromDataTable(dataTable, "Time Codes"));
		contentManagementRequestFormPage.selectSlugsInCNBCStratusSection(
				CucumberUtils.getValueFromDataTable(dataTable, "CNBC Stratus Slug"),
				CucumberUtils.getValueFromDataTable(dataTable, "Add slug at location"));
		contentManagementRequestFormPage.removeSlugsInCNBCStratusSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Remove slug having location"));
	}
	@When("user selects fields in CNBC-Stratus section on ECM request in edit mode")
	public void editFieldsInCNBCStratusSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectSourceCompression(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Compression"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectSourceFrameRate(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Frame Rate"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectTimeCodesInFileIngest(
				CucumberUtils.getValueFromDataTable(dataTable, "Time Codes"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectSlugsInCNBCStratusSection(
				CucumberUtils.getValueFromDataTable(dataTable, "CNBC Stratus Slug"),
				CucumberUtils.getValueFromDataTable(dataTable, "Add slug at location"),RequestMode.EDIT);
		contentManagementRequestFormPage.removeSlugsInCNBCStratusSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Remove slug having location"),RequestMode.EDIT);
	}
	@When("user selects fields in CNBC-Avid section on ECM request")
	public void selectFieldsInCNBCAvidSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectAvidWorkspace(
				CucumberUtils.getValueFromDataTable(dataTable, "AVID Workspace"));
		contentManagementRequestFormPage.selectAvidProjectName(
				CucumberUtils.getValueFromDataTable(dataTable, "AVID Project Name"));
		contentManagementRequestFormPage.selectBinNamesInCNBCAvidSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Bin Name"),
				CucumberUtils.getValueFromDataTable(dataTable, "Add bin name at location"));
		contentManagementRequestFormPage.removeBinNamesInCNBCAvidSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Remove bin name having location"));
	}
	@When("user selects fields in CNBC-Avid section on ECM request in edit mode")
	public void editFieldsInCNBCAvidSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectAvidWorkspace(
				CucumberUtils.getValueFromDataTable(dataTable, "AVID Workspace"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectAvidProjectName(
				CucumberUtils.getValueFromDataTable(dataTable, "AVID Project Name"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectBinNamesInCNBCAvidSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Bin Name"),
				CucumberUtils.getValueFromDataTable(dataTable, "Add bin name at location"),RequestMode.EDIT);
		contentManagementRequestFormPage.removeBinNamesInCNBCAvidSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Remove bin name having location"),RequestMode.EDIT);
	}
	@When("user clicks `+ Bin Name` button on ECM request")
	public void addBinName() {
		contentManagementRequestFormPage.addBinName();
	}
	@When("user clicks `+ Additional Recipient` button on ECM request")
	public void addAdditionalRecipient() {
		contentManagementRequestFormPage.addAdditionalRecipient();
	}
	@When("user clicks `+ Slug` button on ECM request")
	public void addSlug() {
		contentManagementRequestFormPage.addSlug();
	}
	@When("user clicks `+ Show Unit` button on ECM request")
	public void addShowUnit() {
		contentManagementRequestFormPage.addShowUnit();
	}
	@When("user clicks `+ Source` button on ECM request")
	public void addAdditionalSource() {
		contentManagementRequestFormPage.addAdditionalSource();
	}
	@When("user clicks `+ Camera Type` button on ECM request")
	public void addCameraType(DataTable dataTable) {
		contentManagementRequestFormPage.addCameraType(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"));
	}
	@When("user selects fields in Nimbus section on ECM request")
	public void selectFieldsInNimbusSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.provideDetailsInNimbus(
				CucumberUtils.getValueFromDataTable(dataTable, "Details"));
		contentManagementRequestFormPage.selectTranscodeNeeded(
				CucumberUtils.getValueFromDataTable(dataTable, "Transcode Needed?"));
	}
	@When("user selects fields in Nimbus section on ECM request in edit mode")
	public void editFieldsInNimbusSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.provideDetailsInNimbus(
				CucumberUtils.getValueFromDataTable(dataTable, "Details"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectTranscodeNeeded(
				CucumberUtils.getValueFromDataTable(dataTable, "Transcode Needed?"),RequestMode.EDIT);
	}
	@When("user selects fields in DC Network News section on ECM request")
	public void selectFieldsInDCNetworkNewsSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectNeedMaterialArchived(
				CucumberUtils.getValueFromDataTable(dataTable, "Need Material Archived?"));
	}
	@When("user selects fields in DC Network News section on ECM request in edit mode")
	public void editFieldsInDCNetworkNewsSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectNeedMaterialArchived(
				CucumberUtils.getValueFromDataTable(dataTable, "Need Material Archived?"),RequestMode.EDIT);
	}
	@When("user selects Destinations on File Ingest request")
	public void selectDestinations(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectDestinations(
				CucumberUtils.getValueFromDataTable(dataTable, "Destinations"));
	}
	@When("user selects Destinations on File Ingest request in edit mode")
	public void selectDestinationsInEditMode(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectDestinations(
				CucumberUtils.getValueFromDataTable(dataTable, "Destinations"),RequestMode.EDIT);
	}
	@When("user unselects Destinations on File Ingest request")
	public void unselectDestinations(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.unselectDestinations(
				CucumberUtils.getValueFromDataTable(dataTable, "Destinations"));
	}
	@When("user unselects Destinations on File Ingest request in edit mode")
	public void unselectDestinationsInEditMode(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.unselectDestinations(
				CucumberUtils.getValueFromDataTable(dataTable, "Destinations"),RequestMode.EDIT);
	}
	@When("user selects fields in Show Information section on ECM request")
	public void selectFieldsInShowInformationSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectShowUnitOrProjectName(
				CucumberUtils.getValueFromDataTable(dataTable, "Show Unit or Project Name"),
				CucumberUtils.getValueFromDataTable(dataTable, "Index"));
		contentManagementRequestFormPage.removeShowUnitOrProjectName(
				CucumberUtils.getValueFromDataTable(dataTable, "Remove show unit index"),RequestMode.EDIT);
		String flexible = CucumberUtils.getValueFromDataTable(dataTable, "Flexible");
		if(flexible != null) {
			if(flexible.equals("Yes")) {
				contentManagementRequestFormPage.selectFlexibleInShowInformation();
			}
			else {
				contentManagementRequestFormPage.unselectFlexibleInShowInformation();
			}
		}
		String TBD = CucumberUtils.getValueFromDataTable(dataTable, "To Be Determined");
		if(TBD != null) {
			if(TBD.equals("Yes")) {
				contentManagementRequestFormPage.selectToBeDetermined();
			}
			else {
				contentManagementRequestFormPage.unselectToBeDetermined();
			}
		}
		contentManagementRequestFormPage.selectAirDate(
				CucumberUtils.getValueFromDataTable(dataTable, "Days from today"));
		contentManagementRequestFormPage.selectAirTime(
				CucumberUtils.getValueFromDataTable(dataTable, "Time"));
	}
	@When("user selects fields in Show Information section on ECM request in edit mode")
	public void editFieldsInShowInformationSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectShowUnitOrProjectName(
				CucumberUtils.getValueFromDataTable(dataTable, "Show Unit or Project Name"),
				CucumberUtils.getValueFromDataTable(dataTable, "Index"),RequestMode.EDIT);
		contentManagementRequestFormPage.removeShowUnitOrProjectName(
				CucumberUtils.getValueFromDataTable(dataTable, "Remove show unit index"),RequestMode.EDIT);
		String flexible = CucumberUtils.getValueFromDataTable(dataTable, "Flexible");
		if(flexible != null) {
			if(flexible.equals("Yes")) {
				contentManagementRequestFormPage.selectFlexibleInShowInformation(RequestMode.EDIT);
			}
			else {
				contentManagementRequestFormPage.unselectFlexibleInShowInformation(RequestMode.EDIT);
			}
		}
		String TBD = CucumberUtils.getValueFromDataTable(dataTable, "To Be Determined");
		if(TBD != null) {
			if(TBD.equals("Yes")) {
				contentManagementRequestFormPage.selectToBeDetermined(RequestMode.EDIT);
			}
			else {
				contentManagementRequestFormPage.unselectToBeDetermined(RequestMode.EDIT);
			}
		}
		contentManagementRequestFormPage.selectAirDate(
				CucumberUtils.getValueFromDataTable(dataTable, "Days from today"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectAirTime(
				CucumberUtils.getValueFromDataTable(dataTable, "Time"),RequestMode.EDIT);
	}
	@When("user selects fields in Sources section on File Ingest request")
	public void selectFieldsInSourcesSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectSourceInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Source"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"));
		contentManagementRequestFormPage.selectQuantityInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Qty"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"));
		contentManagementRequestFormPage.selectCommentsInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Comments"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"));
		contentManagementRequestFormPage.selectCameraInSpecificSource(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Camera Type"),
				CucumberUtils.getValueFromDataTable(dataTable, "Select Camera Index"));
		contentManagementRequestFormPage.removeCamerasFromSources(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Remove Camera Index"));
	}
	@When("user selects fields in Sources section on File Ingest request in edit mode")
	public void editFieldsInSourcesSection(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectSourceInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Source"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectQuantityInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Qty"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectCommentsInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Comments"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectCameraInSpecificSource(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Camera Type"),
				CucumberUtils.getValueFromDataTable(dataTable, "Select Camera Index"),RequestMode.EDIT);
		contentManagementRequestFormPage.removeCamerasFromSources(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Remove Camera Index"),RequestMode.EDIT);
	}
	@When("user removes Source section on ECM request")
	public void removeSourceSection(DataTable dataTable) {
		contentManagementRequestFormPage.removeSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"));
	}
	@When("user removes Source section on ECM request in edit mode")
	public void removeSourceSectionInEditMode(DataTable dataTable) {
		contentManagementRequestFormPage.removeSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),RequestMode.EDIT);
	}
	@When("user clears Date Needed By on ECM request")
	public void clearDateNeededBy() throws Exception {
		contentManagementRequestFormPage.clearDateNeededBy();
	}
	@When("user clears Time Needed By on ECM request")
	public void clearTimeNeededBy() throws Exception {
		contentManagementRequestFormPage.clearTimeNeededBy();
	}
	@When("user clears Air Date on ECM request")
	public void clearAirDate() throws Exception {
		contentManagementRequestFormPage.clearAirDate();
	}
	@When("user clears Air Date on ECM request in edit mode")
	public void clearAirDateInEditMode() throws Exception {
		contentManagementRequestFormPage.clearAirDate(RequestMode.EDIT);
	}
	@When("user clears Air Time on ECM request")
	public void clearAirTime() throws Exception {
		contentManagementRequestFormPage.clearAirTime();
	}
	@When("user clears Air Time on ECM request in edit mode")
	public void clearAirTimeInEditMode() throws Exception {
		contentManagementRequestFormPage.clearAirTime(RequestMode.EDIT);
	}
	@When("user selects Destinations on Feed out request")
	public void selectDestinationsOnFeedout(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectDestinations(
				CucumberUtils.getValueFromDataTable(dataTable, "Destinations"));
		contentManagementRequestFormPage.provideOtherDestinationOnFeedout(
				CucumberUtils.getValueFromDataTable(dataTable, "Other"));
	}
	@When("user selects Destinations on Feed out request in edit mode")
	public void selectDestinationsInEditModeOnFeedout(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectDestinations(
				CucumberUtils.getValueFromDataTable(dataTable, "Destinations"),RequestMode.EDIT);
		contentManagementRequestFormPage.provideOtherDestinationOnFeedout(
				CucumberUtils.getValueFromDataTable(dataTable, "Other"),RequestMode.EDIT);
	}
	@When("user unselects Destinations on Feed out request")
	public void unselectDestinationsOnFeedout(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.unselectDestinations(
				CucumberUtils.getValueFromDataTable(dataTable, "Destinations"));
		String removeOther = CucumberUtils.getValueFromDataTable(dataTable, "Remove other");
		if(removeOther != null) {
			contentManagementRequestFormPage.clearOtherDestinationOnFeedout();
		}
	}
	@When("user unselects Destinations on Feed out request in edit mode")
	public void unselectDestinationsInEditModeOnFeedout(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.unselectDestinations(
				CucumberUtils.getValueFromDataTable(dataTable, "Destinations"),RequestMode.EDIT);
		String removeOther = CucumberUtils.getValueFromDataTable(dataTable, "Remove other");
		if(removeOther != null) {
			contentManagementRequestFormPage.clearOtherDestinationOnFeedout(RequestMode.EDIT);
		}
	}
	@When("user selects fields in Sources section on Feed out request")
	public void selectFieldsInSourcesSectionOnFeedout(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectSourceInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Source"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"));
		contentManagementRequestFormPage.selectQuantityInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Qty"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"));
		contentManagementRequestFormPage.selectCommentsInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Comments"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"));
	}
	@When("user selects fields in Sources section on Feed out request in edit mode")
	public void editFieldsInSourcesSectionOnFeedout(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectSourceInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Source"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectQuantityInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Qty"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectCommentsInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Comments"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),RequestMode.EDIT);
	}
	@When("user selects CNBC-Stratus Slug\\(s) in Sources section on Feed out request")
	public void selectCnbcSlugInSourcesSectionOnFeedout(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectCnbcSlugInSpecificSource(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Slug Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Slug"));
		contentManagementRequestFormPage.removeSlugFromSources(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Remove slug having index"));
	}
	@When("user selects CNBC-Stratus Slug\\(s) in Sources section on Feed out request in edit mode")
	public void editCnbcSlugInSourcesSectionOnFeedout(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectCnbcSlugInSpecificSource(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Slug Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Slug"),RequestMode.EDIT);
		contentManagementRequestFormPage.removeSlugFromSources(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Remove slug having index"),RequestMode.EDIT);
	}
	@When("user clicks `+ Stratus Slug` button on Feed out request")
	public void addSlugInSourcesInFeedout(DataTable dataTable) {
		contentManagementRequestFormPage.addSlugInSourcesInFeedout(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"));
	}
	@When("user selects fields in Sources section on MTD request")
	public void selectFieldsInSourcesSectionInMTD(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectSourceInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Source"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"));
		contentManagementRequestFormPage.provideSourceDetailsInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Details"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"));
		contentManagementRequestFormPage.selectTimeCodesInMTD(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Time Codes"));
		contentManagementRequestFormPage.selectCameraInSpecificSource(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Camera Type"),
				CucumberUtils.getValueFromDataTable(dataTable, "Select Camera Index"));
		contentManagementRequestFormPage.removeCamerasFromSources(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Remove Camera Index"));
	}
	@When("user selects fields in Sources section on MTD request in edit mode")
	public void editFieldsInSourcesSectionInMTD(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectSourceInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Source"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),RequestMode.EDIT);
		contentManagementRequestFormPage.provideSourceDetailsInSourceSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Details"),
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectTimeCodesInMTD(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Time Codes"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectCameraInSpecificSource(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Camera Type"),
				CucumberUtils.getValueFromDataTable(dataTable, "Select Camera Index"),RequestMode.EDIT);
		contentManagementRequestFormPage.removeCamerasFromSources(
				CucumberUtils.getValueFromDataTable(dataTable, "Source Index"),
				CucumberUtils.getValueFromDataTable(dataTable, "Remove Camera Index"),RequestMode.EDIT);
	}
	@When("user selects fields in Destinations section on MTD request")
	public void selectFieldsInDestinationsSectionInMTD(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectDestinationInMTD(
				CucumberUtils.getValueFromDataTable(dataTable, "Destination"),
				CucumberUtils.getValueFromDataTable(dataTable, "Destination Index"));
		contentManagementRequestFormPage.selectDetailsInDestinationInMtd(
				CucumberUtils.getValueFromDataTable(dataTable, "Destination Details"),
				CucumberUtils.getValueFromDataTable(dataTable, "Destination Index"));
		contentManagementRequestFormPage.selectQuantityInDestinationInMtd(
				CucumberUtils.getValueFromDataTable(dataTable, "Qty"),
				CucumberUtils.getValueFromDataTable(dataTable, "Destination Index"));
	}
	@When("user selects fields in Destinations section on MTD request in edit mode")
	public void editFieldsInDestinationsSectionInMTD(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectDestinationInMTD(
				CucumberUtils.getValueFromDataTable(dataTable, "Destination"),
				CucumberUtils.getValueFromDataTable(dataTable, "Destination Index"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectDetailsInDestinationInMtd(
				CucumberUtils.getValueFromDataTable(dataTable, "Destination Details"),
				CucumberUtils.getValueFromDataTable(dataTable, "Destination Index"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectQuantityInDestinationInMtd(
				CucumberUtils.getValueFromDataTable(dataTable, "Qty"),
				CucumberUtils.getValueFromDataTable(dataTable, "Destination Index"),RequestMode.EDIT);
	}
	@When("user removes Destination section on MTD request")
	public void removeDestinationSectionOnMtd(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.removeDestinationSectionInMtd(
				CucumberUtils.getValueFromDataTable(dataTable, "Destination Index"));
	}
	@When("user removes Destination section on MTD request in edit mode")
	public void removeDestinationSectionOnMtdInEditMode(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.removeDestinationSectionInMtd(
				CucumberUtils.getValueFromDataTable(dataTable, "Destination Index"),RequestMode.EDIT);
	}
	@When("user clicks `+ Destination` button on MTD request")
	public void addDestination() {
		contentManagementRequestFormPage.addDestination();
	}
	@When("user selects fields in Instructions section on MTD request")
	public void selectFieldsInInstructionSectionInMTD(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.provideInstructionsInInstructionsSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Instructions"));
	}
	@When("user selects fields in Instructions section on MTD request in edit mode")
	public void editFieldsInInstructionSectionInMTD(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.provideInstructionsInInstructionsSection(
				CucumberUtils.getValueFromDataTable(dataTable, "Instructions"),RequestMode.EDIT);
	}
	@When("user clears Instructions on MTD request")
	public void clearInstructionsInMtd() throws Exception {
		contentManagementRequestFormPage.clearInstructionsInInstructionsSection();
	}
	@When("user clears Instructions on MTD request in edit mode")
	public void clearInstructionsInMtdInEditMode() throws Exception {
		contentManagementRequestFormPage.clearInstructionsInInstructionsSection(RequestMode.EDIT);
	}
	@When("user selects fields in File Ingest fulfillment")
	public void selectFieldsInFileIngestFulfillment(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectMethodOfIngestInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Method of Ingest"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectDestinationsInFileIngestFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Destinations"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectFileFormatsInFileIngestFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "File formats"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectGigSizeInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Gig size"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectClipCountInFileIngestFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Clip count"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectFolderFormatsInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Folder formats"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectBinNameInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Bin Name"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectMediaIdInFileIngestFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Media Id"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectAssistantEditorAssignedInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Assistant Editor"),RequestMode.EDIT);
	}
	@When("user selects fields in CNBC-Stratus Ingest in File Ingest fulfillment")
	public void selectFieldsInCnbcStratusInFileIngestFulfillment(DataTable dataTable) {
		contentManagementRequestFormPage.selectIngestCompleteInCnbcStratusIngestInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Ingest Complete?"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectTimeInCnbcStratusIngestInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Hours"),
				CucumberUtils.getValueFromDataTable(dataTable, "Minutes"),
				CucumberUtils.getValueFromDataTable(dataTable, "Seconds"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectTranscodingNeededInCnbcStratusIngestInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Transcoding Needed"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectTranscodeCompleteInCnbcStratusIngestInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Transcode Complete?"),RequestMode.EDIT);
	}
	@When("user selects fields in CNBC-Avid Ingest in File Ingest fulfillment")
	public void selectFieldsInCnbcAvidInFileIngestFulfillment(DataTable dataTable) {
		contentManagementRequestFormPage.selectIngestCompleteInCnbcAvidIngestInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Ingest Complete?"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectTimeInCnbcAvidIngestInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Hours"),
				CucumberUtils.getValueFromDataTable(dataTable, "Minutes"),
				CucumberUtils.getValueFromDataTable(dataTable, "Seconds"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectWorkspaceInCnbcAvidInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Workspace"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectProjectInCnbcAvidInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Project"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectBinNamesInCNBCAvidInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Bin Name"),
				CucumberUtils.getValueFromDataTable(dataTable, "Position"),RequestMode.EDIT);
	}
	@When("user clicks `+ Bin Name` button in ECM Fulfillment")
	public void addBinNameInECMFulfillment() {
		contentManagementRequestFormPage.addBinNameInCnbcAvidInFulfillment();
	}
	@Whens({
		@When("user selects fields in Timer in File Ingest fulfillment"),
		@When("user selects fields in Timer in MTD fulfillment")
	})
	public void selectFieldsInTimerInFileIngestFulfillment(DataTable dataTable) {
		contentManagementRequestFormPage.selectTimeInTimerInFileIngestFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Hours"),
				CucumberUtils.getValueFromDataTable(dataTable, "Minutes"),
				CucumberUtils.getValueFromDataTable(dataTable, "Seconds"),RequestMode.EDIT);
	}
	@Whens({
		@When("user selects fields in Comments in File Ingest fulfillment")
	})
	public void selectFieldsInCommentsInFileIngestFulfillment(DataTable dataTable) {
		contentManagementRequestFormPage.provideCommentsInFileIngestFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Comments"),RequestMode.EDIT);
	}
	@When("user selects fields in Timer in Feed Out fulfillment")
	public void selectFieldsInTimerInFeedOutFulfillment(DataTable dataTable) {
		contentManagementRequestFormPage.selectTimeInTimerInFeedOutFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Hours"),
				CucumberUtils.getValueFromDataTable(dataTable, "Minutes"),
				CucumberUtils.getValueFromDataTable(dataTable, "Seconds"),RequestMode.EDIT);
	}
	@Whens({
		@When("user selects fields in Comments in Feed Out fulfillment"),
		@When("user selects fields in Comments in MTD fulfillment")
		})
	public void selectFieldsInCommentsInFeedOutFulfillment(DataTable dataTable) {
		contentManagementRequestFormPage.provideCommentsInFeedOutFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Comments"),RequestMode.EDIT);
	}
	@Whens({
		@When("user selects fields in Status in File Ingest fulfillment")
	})
	public void selectFieldsInStatusInFileIngestFulfillment(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.changeStatusInFileIngestFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Status"),RequestMode.EDIT);
	}
	@Whens({
		@When("user selects fields in Status in Feed Out fulfillment"),
		@When("user selects fields in Status in MTD fulfillment")
	})
	public void selectFieldsInStatusInFeedOutFulfillment(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.changeStatusInFeedOutFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Status"),RequestMode.EDIT);
	}
	@When("user selects fields in Feed Out fulfillment")
	public void selectFieldsInFeedOutFulfillment(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectDestinationsInFeedOutFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Destinations"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectClipCountInFeedOutFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Clip count"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectMediaIdInFeedOutFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Media Id"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectFeedTimeInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Feed Out Time"),RequestMode.EDIT);
	}
	@When("user selects fields in MTD fulfillment")
	public void selectFieldsInMtdFulfillment(DataTable dataTable) throws Exception {
		contentManagementRequestFormPage.selectDestinationsInMtdFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Destinations"),
				CucumberUtils.getValueFromDataTable(dataTable, "Position"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectFileFormatsInFeedOutFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "File formats"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectClipCountInFileIngestFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Clip count"),RequestMode.EDIT);
		contentManagementRequestFormPage.selectGigSizeInFulfillment(
				CucumberUtils.getValueFromDataTable(dataTable, "Gig size"),RequestMode.EDIT);
	}
}
