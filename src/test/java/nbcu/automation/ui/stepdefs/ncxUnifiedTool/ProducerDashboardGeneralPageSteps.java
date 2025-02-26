package nbcu.automation.ui.stepdefs.ncxUnifiedTool;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import nbcu.automation.ui.enums.RequestMode;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProducerDashboardGeneralPage;
import nbcu.automation.ui.validation.common.CommonValidations;
import nbcu.framework.utils.cucumber.CucumberUtils;
public class ProducerDashboardGeneralPageSteps {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();
	CommonValidations commonValidations = new CommonValidations();

	@Then("verify missing fields error popup is displayed")
	public void verifyMissingFieldsPopup() throws Exception {
		commonValidations.verifyOverallMissingFieldErrorPopup();
	}

	// error field validation
	@Then("verify the mandatory sections highlights as incomplete in MTD form")
	@Then("verify the mandatory sections highlights as incomplete in File Ingest form")
	@Then("verify the mandatory sections highlights as incomplete in Feed Out form")
	@Then("verify the mandatory sections highlights as incomplete in Standard Edit form")
	@Then("verify the mandatory sections highlights as incomplete in Edit Self Reporting form")
	@Then("verify the mandatory sections highlights as incomplete in Long Edit form")
	@Then("verify the mandatory sections highlights as incomplete in News Gear form")
	@Then("verify the mandatory sections highlights as incomplete in Telemundo Crew form")
	@Then("verify the mandatory sections highlights as incomplete in NBC News Crew form")
	@Then("verify the mandatory sections highlights as incomplete in NBC Bureau Camera Crew form")
	@Then("verify the mandatory sections highlights as incomplete in NBC Breaking News Crew form")
	@Then("verify the mandatory sections highlights as incomplete in Digital Journalist DJ Shoot Crew form")
	@Then("verify the mandatory sections highlights as incomplete in CNBC Crew form")
	@Then("verify the mandatory sections highlights as incomplete in Extend or Bridge Crew Production form")
	@Then("verify the mandatory sections highlights as incomplete in Single Camera Live Shot Production form")
	@Then("verify the mandatory sections highlights as incomplete in Firearms on Premises Production form")
	@Then("verify the mandatory sections highlights as incomplete in Animals on Premises Production form")
	@Then("verify the mandatory sections highlights as incomplete in CNBC Production form")
	@Then("verify the mandatory sections highlights as incomplete in Rock Center Production form")
	public void verifyApplicationHighlightsAsIncomplete(DataTable dataTable) throws Exception {
		String sectionNames = CucumberUtils.getValuesFromDataTable(dataTable, "Error sections");
		String[] sectionNamesArrayList = sectionNames.split(",");
		for (String sectionNamesList : sectionNamesArrayList) {
			producerDashboardGeneralPage.verifySectionNameHighlightedInRedColor(sectionNamesList.trim());
		}
	}

	@Then("Verify error message is displayed for all mandatory fields in general details section for Extend or Bridge Crew Production form")
	@Then("Verify error message is displayed for all mandatory fields in general details section for Single Camera Live Shot Production form")
	@Then("Verify error message is displayed for all mandatory fields in general details section for Firearms on Premises Production form")
	@Then("Verify error message is displayed for all mandatory fields in general details section for Animals on Premises Production form")
	@Then("Verify error message is displayed for all mandatory fields in general details section for CNBC Production form")
	@Then("Verify error message is displayed for all mandatory fields in general details section for Rock Center Production form")
	public void verifyGeneraldetailsMissingFieldErrorInProductionSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.verifyGeneralDetailsInfoMissingFieldError(
				CucumberUtils.getValuesFromDataTable(dataTable, "Division Error"));
	}

	@Then("Verify error message is displayed for all mandatory fields in Production Purpose section for CNBC Production form")
	@Then("Verify error message is displayed for all mandatory fields in Production Purpose section for Rock Center Production form")
	public void verifyProductionPurposeMissingFieldErrorInProductionSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.verifyProductionPurposeInfoMissingFieldError(
				CucumberUtils.getValuesFromDataTable(dataTable, "Request For Error"));
	}

	@Then("Verify error message is displayed for all mandatory fields in show info section for Single Camera Live Shot Production form")
	@Then("Verify error message is displayed for all mandatory fields in show info section for CNBC Production form")
	@Then("Verify error message is displayed for all mandatory fields in show info section for Rock Center Production form")
	public void verifyShowInfoMissingFieldErrorInProductionSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.verifyShowInfoMissingFieldError(
				CucumberUtils.getValuesFromDataTable(dataTable, "Air Platform Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Budget Code Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Start Date Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Start Time Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "End Time Error"));
	}

	@Then("Verify error message is displayed for all mandatory fields in show info section for Firearms on Premises Production form")
	@Then("Verify error message is displayed for all mandatory fields in show info section for Animals on Premises Production form")
	public void verifyShowInfoMissingFieldErrorFireArmAndAnimalPremises(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.verifyShowInfoMissingFieldErrorFireArmAndAnimalPremises(
				CucumberUtils.getValuesFromDataTable(dataTable, "Air Platform Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Arrival Date Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Arrival Time Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Departure Date Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Departure Time Error"));
	}

	@Then("Verify error message is displayed for all mandatory fields in set Location & Crew info section for Extend or Bridge Crew Production form")
	@Then("Verify error message is displayed for all mandatory fields in set Location info section In Firearms on Premises Production form")
	@Then("Verify error message is displayed for all mandatory fields in set Location info section In Animals on Premises Production form")
	@Then("Verify error message is displayed for all mandatory fields in set Location info section In Rock Center Production Form")
	public void verifySetLocationMissingFieldErrorInProductionSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.verifySetLocationMissingFieldError(
				CucumberUtils.getValuesFromDataTable(dataTable, "Location Error"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Set Location Error"));
	}

	// production form details to enter data

	@When("user enters General info in Extend or Bridge Crew Production form")
	@When("user enters General info in Single Camera Live Shot Production form")
	@When("user enters General info in Firearms on Premises Production form")
	@When("user enters General info in Animals on Premises Production form")
	@When("user enters General info in CNBC Production form")
	@When("user enters General info in Rock Center Production form")
	public void addProducerInfoinGeneralSectionInProductionForm(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.selectDivision(CucumberUtils.getValuesFromDataTable(dataTable, "Division"));
		producerDashboardGeneralPage
				.additionalRequestersListInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Additional Requesters"));
		producerDashboardGeneralPage.enterTalentValue(CucumberUtils.getValuesFromDataTable(dataTable, "Talent"));
	}

	@When("user enters Request For info in CNBC Production form")
	@When("user enters Request For info in Rock Center Production form")
	public void addRequestForinfo(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.addProductionPurposeInfo(
				CucumberUtils.getValuesFromDataTable(dataTable, "Request For"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Details and Notes"));
	}

	@When("user enters show information in Single Camera Live Shot Production form")
	@When("user enters show information in Rock Center Production form")
	public void fillShowInfo(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.addShowInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Air Platform"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show or Project Name"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Start Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Prep Start Time"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Start Time"),
				CucumberUtils.getValuesFromDataTable(dataTable, "End Time"));
	}

	@When("user enters set location and crew information in Extend or Bridge Crew Production form")
	@When("user enters set location information in Firearms on Premises Production Form")
	@When("user enters set location information in Animals on Premises Production Form")
	@When("user enters set location information in Rock Center Production form")
	public void fillSetLocationInfo(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.addSetLocationInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Set Location"));
	}

	@When("user enters flashcam crew information in Rock Center Production form")
	public void fillFlashcamCrewInfo(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.selectFlashcamCrew(CucumberUtils.getValuesFromDataTable(dataTable, "Flashcam Crew"));
	}
	
	@When("user enters set crew information in CNBC Production form")
	@When("user enters set crew information in Rock Center Production form")
	public void fillSetCrewInfo(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.selectSetCrew(CucumberUtils.getValuesFromDataTable(dataTable, "Set Crew"));
	}

	@When("user enters TPMorTM information in Extend or Bridge Crew Production form")
	@When("user enters TPMorTM information in Rock Center Production form")
	public void fillTPMorTMInfo(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.selectTPMorTMInfo(CucumberUtils.getValuesFromDataTable(dataTable, "TPM or TM"));
	}

	// animal / firearm on permises

	@When("user enters show information in Firearms on Premises Production form")
	@When("user enters show information in Animals on Premises Production form")
	public void addShowInfoInFireArmAndAnimalPremises(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.addShowInfoInFireArmAndAnimalPremises(
				CucumberUtils.getValuesFromDataTable(dataTable, "Air Platform"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show or Project Name"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Arrival Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Arrival Time"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Departure Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Departure Time"));
	}

	@When("user enters details information in Extend or Bridge Crew Production form")
	@When("user enters details information in Single Camera Live Shot Production form")
	@When("user enters details information in Firearms on Premises Production form")
	@When("user enters details information in Animals on Premises Production form")
	public void enterDetailsAndNotesInFireArmAndAnimalPremises(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.enterDetailsAndNotes(CucumberUtils.getValuesFromDataTable(dataTable, "Details and Notes"));
	}

	// crew form details to enter data

	@Then("user enters General info in Telemundo Crew form")
	@Then("user enters General info in Digital Journalist DJ Shoot Crew form")
	@Then("user enters General info in CNBC Crew form")
	@Then("user enters General info in NBC Bureau Camera Crew form")
	@Then("user enters General info in NBC Breaking News Crew form")
	@Then("user enters General info in NBC News Crew form")
	public void addGeneralInfoInCrewForm(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.addGeneralInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Slug"),
				CucumberUtils.getValuesFromDataTable(dataTable, "NCX Story Name"));
		producerDashboardGeneralPage
				.additionalRequestersListInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Additional Requesters"));
		producerDashboardGeneralPage
				.addProducerInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Is Producer Same as Requestor"));
		producerDashboardGeneralPage
				.enterSeniorProducerValue(CucumberUtils.getValuesFromDataTable(dataTable, "Sr Producer"));
		producerDashboardGeneralPage
				.addIsOnsiteProducerInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Is Onsite Producer"));
		producerDashboardGeneralPage.enterTalentValue(CucumberUtils.getValuesFromDataTable(dataTable, "Talent"));
	}

	@When("user enters field contact Information in Telemundo Crew form")
	@When("user enters field contact Information in Digital Journalist DJ Shoot Crew form")
	@When("user enters field contact Information in CNBC Crew form")
	@When("user enters field contact Information in NBC Breaking News Crew form")
	@When("user enters field contact Information in NBC News Crew form")
	public void fillFieldContactInfoInNBCNewsCrewRequest(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.enterfieldContact(CucumberUtils.getValuesFromDataTable(dataTable, "Field Contact"));
		producerDashboardGeneralPage.enterfieldPhone(CucumberUtils.getValuesFromDataTable(dataTable, "Phone"));
	}

	@When("user enters show title Information in Telemundo Crew form")
	@When("user enters show title Information in Digital Journalist DJ Shoot Crew form")
	@When("user enters show title Information in CNBC Crew form")
	@When("user enters show title Information in NBC Bureau Camera Crew form")
	@When("user enters show title Information in NBC Breaking News Crew form")
	@When("user enters show title Information in NBC News Crew form")
	public void fillShowTitleInfoInNCBCCrewRequest(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.enterShow(CucumberUtils.getValuesFromDataTable(dataTable, "ShowTitle"));
	}

	@When("user enters shoot details Information in Telemundo Crew form")
	@When("user enters shoot details Information in CNBC Crew form")
	@When("user enters shoot details Information in NBC News Crew form")
	public void fillShootDetailsInfoInNBCNewsCrewRequest(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.addProductionType(CucumberUtils.getValuesFromDataTable(dataTable, "Production Type"));
		producerDashboardGeneralPage.enterShootStatus(CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Status"));
		producerDashboardGeneralPage
				.enterShootDescription(CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Description"));
	}

	@When("user enters shoot details Information in NBC Bureau Camera Crew form")
	@When("user enters shoot details Information in NBC Breaking News Crew form")
	public void fillShootDetailsInfoInNBCBreakingNewsCrewRequest(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.enterShootDescription(CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Description"));
	}

	@When("user enters shoot location Information in Telemundo Crew form")
	@When("user enters shoot location Information in Digital Journalist DJ Shoot Crew form")
	@When("user enters shoot location Information in CNBC Crew form")
	@When("user enters shoot location Information in NBC Breaking News Crew form")
	@When("user enters shoot location Information in NBC News Crew form")
	public void fillShootLocationInfoInNBCNewsCrewRequest(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.addShootLocation(CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Risk Assessment Category"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Risk Assessment Type"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Risk Arrangements"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Risk Approver"));
	}

	@When("user enters Date & Time Information in Telemundo Crew form")
	@When("user enters Date & Time Information in CNBC Crew form")
	@When("user enters Date & Time Information in NBC Bureau Camera Crew form")
	@When("user enters Date & Time Information in NBC News Crew form")
	public void fillDateTimeInfoInNBCNewsCrewRequest(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.fillWhenIsShoot(
				CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Start Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Shoot End Date"));
		producerDashboardGeneralPage.selectTimeZone(CucumberUtils.getValuesFromDataTable(dataTable, "Time Zone"));
		producerDashboardGeneralPage.fillMeetTime(CucumberUtils.getValuesFromDataTable(dataTable, "Meet Time"));
		producerDashboardGeneralPage.selectStartTime(CucumberUtils.getValuesFromDataTable(dataTable, "Start Time"));
		producerDashboardGeneralPage.selectEndTime(CucumberUtils.getValuesFromDataTable(dataTable, "End Time"));
	}

	// Fulfiller Details

	@When("user searches request in fulfiller dashboard")
	public void searchRequestInFulfillerDashboard() throws Exception {
		producerDashboardGeneralPage.searchRequest();
	}

	@Then("verify {string} is present in fulfiller dashboard with {string} status")
	public void verifyRequestIsPresnt(String formName, String status) throws Exception {
		producerDashboardGeneralPage.verifyRequestInfulfillerDashboard(formName, status);
	}

	@Then("verify {string} of {string} status is {string} in fullfiller dashboard")
	public void verifyStatusColor(String cssType, String status, String expectedColor) throws Exception {
		producerDashboardGeneralPage.verifyStatusBackgroundColor(cssType, status, expectedColor);
	}

	@Then("user click {string} tab in request form page")
	public void clickTabsInRequestFormPage(String tabName) throws Exception {
		producerDashboardGeneralPage.selectTabsInRequestPage(tabName);
	}

	@When("user enters add notes details in Notes section")
	public void entersAddNotesDetailsInNotesSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.fillNotes(CucumberUtils.getValuesFromDataTable(dataTable, "Notes Info"));
	}

	@And("validate Notes added by {string}")
	@And("validate Notes updated by {string}")
	public void noteValidationAfterAdd(String role) throws Exception {
		producerDashboardGeneralPage.noteValidationAfterAdd(role);
	}

	@And("verifies {string} able to edits the Notes with new text {string}")
	public void noteEditValidations(String role, String newTxt) throws Exception {
		producerDashboardGeneralPage.noteEditValidations(role, newTxt);
	}

	@Given("user opens fulfiller dashboard for {string} form")
	public void openDashboard(String formName) throws Exception {
		producerDashboardGeneralPage.openDashboard(formName);
	}

	@Then("verify request is {string} successfully")
	public void verifySubmissionMessage(String status) throws Exception {
		producerDashboardGeneralPage.verifyFormSuccessMessage(status);
	}

	@Then("user changes status to {string}")
	public void updateStatus(String status) throws Exception {
		producerDashboardGeneralPage.statusUpdate(status);
	}

	@When("verify {string} alert message")
	public void verifyCancelAlertMessage(String action, io.cucumber.datatable.DataTable dataTable) throws Exception {
		String alertMessage = "";
		if (action.equalsIgnoreCase("CANCEL REQUEST"))
			alertMessage = CucumberUtils.getValuesFromDataTable(dataTable, "Cancel Request Alert Message");
		else if (action.equalsIgnoreCase("SEND TO STORM"))
			alertMessage = CucumberUtils.getValuesFromDataTable(dataTable, "Send To Storm Alert Message");
		else
			alertMessage = CucumberUtils.getValuesFromDataTable(dataTable, "Confirm Cancellation Alert Message");
		producerDashboardGeneralPage.verifyAlertMessage(action, alertMessage);
	}

	@Then("user clicks {string} requests dropdown in Crew Dashboard")
	@Given("user clicks {string} requests dropdown in Production Dashboard")
	public void clickRequestsDropdownBasedOnStatus(String requestsDropdownName) throws Exception {
		producerDashboardGeneralPage.clickRequestsDropdown(requestsDropdownName);
	}

	@Then("user opens {string} tab in fulfiller table")
	public void openFulfillerTableTab(String tabName) throws Exception {
		producerDashboardGeneralPage.selectTabInFulfillerTable(tabName);
	}

	@And("user searches request not present in fulfiller dashboard")
	public void verifyRequestInFulfillerTable() throws Exception {
		producerDashboardGeneralPage.verifyRequestNotPresentFulfillerTable();
	}

	@When("user clicks on {string} button")
	@When("user clicks on {string} in Fulfillment")
	public void clickButton(String buttonName) throws Exception {
		producerDashboardGeneralPage.clickButton(buttonName);
	}

	@When("user verifies logs are displaying in Log section")
	public void verifyNumberOfLog() throws Exception {
		producerDashboardGeneralPage.verifyNumberOfLog();
	}

	@When("user enters shoot specs in Telemundo crew fulfillment section")
	@When("user enters shoot specs in NBC Breaking News crew fulfillment section")
	@When("user enters shoot specs in NBC Bureau Camera crew fulfillment section")
	public void fillShootSpecsInFulfillmentsection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.fillprimaryCameraTypeInFulfillmentSection(
				CucumberUtils.getValuesFromDataTable(dataTable, "Primary Camera Type"));
		producerDashboardGeneralPage
				.fillmediaFormatInFulfillmentSection(CucumberUtils.getValuesFromDataTable(dataTable, "Media Format"));
		producerDashboardGeneralPage
				.fillVideoSpecsInFulfillmentSection(CucumberUtils.getValuesFromDataTable(dataTable, "Video Specs"));
	}

	@When("user enters General info in MTD Request form")
	@When("user enters General info in Edit request form")
	@When("user enters General info in News Gear form")
	public void addProducerInfoinGeneralSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.addGeneralInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Slug"),
				CucumberUtils.getValuesFromDataTable(dataTable, "NCX Story Name"));
		producerDashboardGeneralPage.selectDivision(CucumberUtils.getValuesFromDataTable(dataTable, "Division"));
		producerDashboardGeneralPage
				.additionalRequestersListInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Additional Requesters"));
		producerDashboardGeneralPage
				.addProducerInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Is Producer Same as Requestor"));
		producerDashboardGeneralPage
				.enterSeniorProducerValue(CucumberUtils.getValuesFromDataTable(dataTable, "Sr Producer"));
		producerDashboardGeneralPage.enterTalentValue(CucumberUtils.getValuesFromDataTable(dataTable, "Talent"));
	}

	// @When("user add specific user in Talent section")
	// public void addTalentInProudctionForm(DataTable datatable) throws Exception {
	// String firstName = CucumberUtils.getValuesFromDataTable(datatable, "First
	// Name");
	// String lastName = CucumberUtils.getValuesFromDataTable(datatable, "Last
	// Name");
	// producerDashboardGeneralPage.addTalentInProductionForm(firstName, lastName);
	// }

	@Then("user verifies whether {string} section is marked crossed when all required fields are not "
			+ "filled and submit button already clicked once on {string} Production request")
	@Then("user verifies whether {string} section is marked crossed when all required fields are not"
			+ " filled and submit button clicked on {string} Production request")
	public void checkIfSectionIsCrossed(String sectionName, String formName) {
		producerDashboardGeneralPage.checkIfSectionIsCrossed(sectionName);
	}

	@Then("user verifies whether {string} section is marked checked when all required fields are filled"
			+ " on {string} Production request")
	public void checkIfSectionIsChecked(String sectionName, String formName) {
		producerDashboardGeneralPage.checkIfSectionIsChecked(sectionName);
	}

	@Then("user verifies whether {string} section is marked neither checked nor crossed when "
			+ "required fields not filled and submit button not clicked on {string} Production request")
	public void checkIfSectionIsNeitherCheckedNorCrossed(String sectionName, String formName) {
		producerDashboardGeneralPage.checkIfSectionIsNeitherCheckedNorCrossed(sectionName);
	}

	@When("user selects division from the dropdown under general details section")
	public void addGeneralDetails(DataTable dataTable) throws Exception {

		producerDashboardGeneralPage.selectDivision(CucumberUtils.getValuesFromDataTable(dataTable, "Division"));

	}

	@When("user add additional requester in requester section")
	public void additionalRequester(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.additionalRequestersListInfo(CucumberUtils.getValuesFromDataTable(dataTable, "Additional Requesters"));
	}

	@Then("user verifies additional requester name displayed")
	public void verifyAdditionalRequester(DataTable dataTable) {
		producerDashboardGeneralPage
				.verifyAdditionalRequester(CucumberUtils.getValuesFromDataTable(dataTable, "Additional Requesters"));
	}

	@When("user selects show unit or project name details")
	public void addShowUnit(DataTable dataTable) throws InterruptedException, Exception {
		producerDashboardGeneralPage.enterShow(CucumberUtils.getValuesFromDataTable(dataTable, "Show or Project Name"));
	}

	@Then("user verifies the added set crew is displayed in the section")
	public void verifyAddedCrew(DataTable dataTable) {
		producerDashboardGeneralPage.verifyAddedCrew(CucumberUtils.getValuesFromDataTable(dataTable, "Set Crew"));
	}

	@Then("user verifies the added control crew is displayed in the section")
	public void verifyAddedControlCrew(DataTable dataTable) {
		producerDashboardGeneralPage
				.verifyAddedControlCrew(CucumberUtils.getValuesFromDataTable(dataTable, "Control Room Crew"));
	}

	@Then("user verifies the added additional crew is displayed in the section")
	public void verifyAddedAdditionalControlCrew(DataTable dataTable) {
		producerDashboardGeneralPage
				.verifyAddedAdditionalControlCrew(CucumberUtils.getValuesFromDataTable(dataTable, "Additional Crew"));
	}

	@Then("user verifies the request is in edit state")
	public void verifyRequestInEditState() {
		producerDashboardGeneralPage.verifyRequestInEditState();
	}

	@Then("user verifies all the buttons are present on the request")
	public void verifyButtonsOnRequest() {
		producerDashboardGeneralPage.verifyButtonsOnRequest();
	}

	@When("user adds note to the Add Notes section on fulfiller tab")
	public void addNoteInFulfillementTab(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.addNoteInFulfillementTab(CucumberUtils.getValuesFromDataTable(dataTable, "Add Notes"));
	}

	@Then("user verifies status of the request")
	public void verifyStatusOfRequest() {
		producerDashboardGeneralPage.verifyStatusOfRequest();
	}

	@When("user edit added note")
	public void editAddedNote(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.editAddedNote(CucumberUtils.getValuesFromDataTable(dataTable, "Edit Note"));
	}

	@Then("user verifies the note is updated")
	public void verifyEditedNote(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.verifyEditedNote(CucumberUtils.getValuesFromDataTable(dataTable, "Edit Note"));
	}

	@When("user delete added note")
	public void deleteAddedNote() throws Exception {
		producerDashboardGeneralPage.deleteAddedNote();
	}

	// Crew Request Error
	@When("Verify error message is displayed for all mandatory fields in general details section for Telemundo Crew form")
	@When("Verify error message is displayed for all mandatory fields in general details section for NBC News Crew form")
	@When("Verify error message is displayed for all mandatory fields in general details section for NBC Bureau Camera Crew form")
	@When("Verify error message is displayed for all mandatory fields in general details section for NBC Breaking News Crew form")
	@When("Verify error message is displayed for all mandatory fields in general details section for Digital Journalist DJ Shoot Crew form")
	@When("Verify error message is displayed for all mandatory fields in general details section for CNBC Crew form")
	public void verifyGeneraldetailsMissingFieldErrorInCrewSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.slugErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Slug Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in producer deatils section for Telemundo Crew form")
	@When("Verify error message is displayed for all mandatory fields in producer deatils section for NBC News Crew form")
	@When("Verify error message is displayed for all mandatory fields in producer deatils section for NBC Bureau Camera Crew form")
	@When("Verify error message is displayed for all mandatory fields in producer deatils section for NBC Breaking News Crew form")
	@When("Verify error message is displayed for all mandatory fields in producer deatils section for Digital Journalist DJ Shoot Crew form")
	@When("Verify error message is displayed for all mandatory fields in producer deatils section for CNBC Crew form")
	public void verifyProducerdetailsMissingFieldErrorInCrewSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.producerErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Producer Error"));
		producerDashboardGeneralPage
				.srProducerOrApproverErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Sr Producer Error"));
		producerDashboardGeneralPage.isThereAnOnsiteProducerErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Is There An Onsite Producer Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in field contact section for Telemundo Crew form")
	@When("Verify error message is displayed for all mandatory fields in field contact section for NBC News Crew form")
	@When("Verify error message is displayed for all mandatory fields in field contact section for NBC Breaking News Crew form")
	@When("Verify error message is displayed for all mandatory fields in field contact section for Digital Journalist DJ Shoot Crew form")
	@When("Verify error message is displayed for all mandatory fields in field contact section for CNBC Crew form")
	public void verifyFieldContactMissingFieldErrorInCrewSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.producerCellNumberErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Producer Cell Number Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in show info section for Telemundo Crew form")
	@When("Verify error message is displayed for all mandatory fields in show info section for NBC News Crew form")
	@When("Verify error message is displayed for all mandatory fields in show info section for NBC Bureau Camera Crew form")
	@When("Verify error message is displayed for all mandatory fields in show info section for NBC Breaking News Crew form")
	@When("Verify error message is displayed for all mandatory fields in show info section for Digital Journalist DJ Shoot Crew form")
	@When("Verify error message is displayed for all mandatory fields in show info section for CNBC Crew form")
	public void verifyShowInfoMissingFieldErrorInCrewSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.showTitleBudgetCodeErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Show Title Budget Code Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in shoot details section In Telemundo Crew form")
	@When("Verify error message is displayed for all mandatory fields in shoot details section In NBC News Crew form")
	@When("Verify error message is displayed for all mandatory fields in shoot details section In CNBC Crew form")
	public void verifyShootdetailsMissingFieldErrorInCrewSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.productionTypeErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Production Type Error"));
		producerDashboardGeneralPage.shootDescriptionErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Description Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in shoot details section In Digital Journalist DJ Shoot Crew form")
	public void verifyShootdetailsMissingFieldErrorInDigitalJournalistDJShootCrewSection(DataTable dataTable)
			throws Exception {
		producerDashboardGeneralPage
				.productionTypeErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Production Type Error"));
		producerDashboardGeneralPage
				.shootTypeErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Type Error"));
		producerDashboardGeneralPage.shootDescriptionErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Description Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in shoot details section In NBC Bureau Camera Crew form")
	@When("Verify error message is displayed for all mandatory fields in shoot details section In NBC Breaking News Crew form")
	public void verifyShootdetailsMissingFieldErrorInNBCBreakingNewsCrewSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.shootDescriptionErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Description Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in shoot specs section In Telemundo Crew form")
	@When("Verify error message is displayed for all mandatory fields in shoot specs section In CNBC Crew form")
	public void verifyShootSpecsMissingFieldErrorInCrewSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.audioNeedsErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Audio Needs Error"));
		producerDashboardGeneralPage.specialConditionsErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Special Conditions Error"));
		producerDashboardGeneralPage.transmissionTypeErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Transmission Type Error"));
		producerDashboardGeneralPage
				.droneShootErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Drone Shoot Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in shoot specs section In Digital Journalist DJ Shoot Crew form")
	public void verifyShootSpecsMissingFieldErrorInDigitalJournalistDJShootCrewSection(DataTable dataTable)
			throws Exception {
		producerDashboardGeneralPage
				.audioNeedsErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Audio Needs Error"));
		producerDashboardGeneralPage.specialConditionsErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Special Conditions Error"));
		producerDashboardGeneralPage.transmissionTypeErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Transmission Type Error"));
		producerDashboardGeneralPage.primaryCameraTypeErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Primary Camera Type Error"));
		producerDashboardGeneralPage.acquisitionSpecsErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Acquisition Specs Error"));
		producerDashboardGeneralPage
				.droneShootErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Drone Shoot Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in shoot specs section In NBC Breaking News Crew form")
	public void verifyShootSpecsMissingFieldErrorInNBCBreakingNewsCrewSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.transmissionTypeErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Transmission Type Error"));
		producerDashboardGeneralPage
				.droneShootErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Drone Shoot Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in shoot specs section In NBC News Crew form")
	public void verifyShootSpecsMissingFieldErrorInNBCNewsCrewSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.audioNeedsErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Audio Needs Error"));
		producerDashboardGeneralPage.specialConditionsErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Special Conditions Error"));
		producerDashboardGeneralPage.transmissionTypeErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Transmission Type Error"));
		producerDashboardGeneralPage.acquisitionSpecsErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Acquisition Specs Error"));
		producerDashboardGeneralPage
				.droneShootErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Drone Shoot Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in shoot location section In Telemundo Crew form")
	@When("Verify error message is displayed for all mandatory fields in shoot location section In NBC News Crew form")
	@When("Verify error message is displayed for all mandatory fields in shoot location section In NBC Bureau Camera Crew form")
	@When("Verify error message is displayed for all mandatory fields in shoot location section In NBC Breaking News Crew form")
	@When("Verify error message is displayed for all mandatory fields in shoot location section In Digital Journalist DJ Shoot Crew form")
	@When("Verify error message is displayed for all mandatory fields in shoot location section In CNBC Crew form")
	public void verifyShootLocationMissingFieldErrorInCrewSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.addressLine1ErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Address Error"));
		producerDashboardGeneralPage.cityErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "City Error"));
		producerDashboardGeneralPage.stateErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "State Error"));
		producerDashboardGeneralPage
				.countryErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Country Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in date & time section In Telemundo Crew form")
	@When("Verify error message is displayed for all mandatory fields in date & time section In NBC News Crew form")
	@When("Verify error message is displayed for all mandatory fields in date & time section In NBC Bureau Camera Crew form")
	@When("Verify error message is displayed for all mandatory fields in date & time section In CNBC Crew form")
	public void verifyDateTimeMissingFieldErrorInCrewSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.shootDatesErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Dates Error"));
		producerDashboardGeneralPage
				.timeZoneErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Time Zone Error"));
		producerDashboardGeneralPage
				.meetTimeErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Meet Time Error"));
		producerDashboardGeneralPage
				.rollTimeErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Roll Time Error"));
		producerDashboardGeneralPage
				.endTimeCrewErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "End Time Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in date & time section In Digital Journalist DJ Shoot Crew form")
	public void verifyDateTimeMissingFieldErrorInDigitalJournalistDJShootCrewSection(DataTable dataTable)
			throws Exception {
		producerDashboardGeneralPage
				.shootDatesErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Shoot Dates Error"));
		producerDashboardGeneralPage
				.timeZoneErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Time Zone Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in date & time section In NBC Breaking News Crew form")
	public void verifyDateTimeMissingFieldErrorInNBCBreakingNewsCrewSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.timeZoneErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Time Zone Error"));
		producerDashboardGeneralPage
				.endTimeCrewErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "End Time Error"));
	}

	// Gear Request Error
	// ECM Request Error
	@When("Verify error message is displayed for all mandatory fields in general details section for MTD form")
	@When("Verify error message is displayed for all mandatory fields in general details section for File Ingest form")
	@When("Verify error message is displayed for all mandatory fields in general details section for Feed Out form")
	@When("Verify error message is displayed for all mandatory fields in general details section for Standard Edit form")
	@When("Verify error message is displayed for all mandatory fields in general details section for Long Edit form")
	@When("Verify error message is displayed for all mandatory fields in general details section for News Gear form")
	public void verifyGeneraldetailsMissingFieldErrorInGearECMSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.slugErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Slug Error"));
		producerDashboardGeneralPage.verifyGeneralDetailsInfoMissingFieldError(
				CucumberUtils.getValuesFromDataTable(dataTable, "Division Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in producer deatils section for MTD form")
	@When("Verify error message is displayed for all mandatory fields in producer deatils section for File Ingest form")
	@When("Verify error message is displayed for all mandatory fields in producer deatils section for Feed Out form")
	@When("Verify error message is displayed for all mandatory fields in producer deatils section for Standard Edit form")
	@When("Verify error message is displayed for all mandatory fields in producer deatils section for Long Edit form")
	@When("Verify error message is displayed for all mandatory fields in producer deatils section for News Gear form")
	public void verifyProducerdetailsMissingFieldErrorInGearECMSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.producerErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Producer Error"));
		producerDashboardGeneralPage
				.srProducerOrApproverErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Sr Producer Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in field contact section for News Gear form")
	public void verifyFieldContactMissingFieldErrorInGearECMSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.prodUserNumberErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Gear User Cell Number Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in show info section for News Gear form")
	public void verifyShowInfoMissingFieldErrorInGearECMSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.segmentTypeErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Segment Type Error"));
		producerDashboardGeneralPage.showUnitorProjectNameErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit or Project Name Error"));
		producerDashboardGeneralPage
				.budgetCodeErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Budget Code Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in show information section for MTD form")
	@When("Verify error message is displayed for all mandatory fields in show information section for File Ingest form")
	@When("Verify error message is displayed for all mandatory fields in show information section for Feed Out form")
	@When("Verify error message is displayed for all mandatory fields in show information section for Standard Edit form")
	@When("Verify error message is displayed for all mandatory fields in general details section for Edit Self Reporting form")
	@When("Verify error message is displayed for all mandatory fields in show information section for Long Edit form")
	public void verifyShowInfoMissingFieldErrorInEditSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.showUnitorProjectNameErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit or Project Name Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in location date & time section In News Gear form")
	public void verifyLocationDateTimeMissingFieldErrorInGearSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.gearLocationErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Location Error"));
		producerDashboardGeneralPage
				.pickUpDateErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Pick Up Date Error"));
		producerDashboardGeneralPage
				.pickUpTimeErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Pick Up Time Error"));
		producerDashboardGeneralPage
				.returnDateErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Return Date Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in session details section In Standard Edit form")
	@When("Verify error message is displayed for all mandatory fields in session details section In Long Edit form")
	public void verifyLocationDateTimeMissingFieldErrorInEditSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.editOfLocationErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Location of Edit Error"));
		producerDashboardGeneralPage
				.editStartDateErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Edit Start Date Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in Date & Time Needed details section In MTD form")
	@When("Verify error message is displayed for all mandatory fields in Date & Time Needed details section In File Ingest form")
	@When("Verify error message is displayed for all mandatory fields in Date & Time Needed details section In Feed Out form")
	public void verifyDateTimeNeededMissingFieldErrorInCMSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.dateNeededByErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Date Needed By Error"));
		producerDashboardGeneralPage
				.timeNeededByErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Time Needed By Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in Source details section In File Ingest form")
	@When("Verify error message is displayed for all mandatory fields in Source details section In Feed Out form")
	public void verifySourceMissingFieldErrorInCMSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.sourceErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Source Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in Source details section In MTD form")
	public void verifyTimeCodesMissingFieldErrorInCMSection(DataTable dataTable) throws Exception {
		verifySourceMissingFieldErrorInCMSection(dataTable);
		producerDashboardGeneralPage
				.timeCodesErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Time Codes Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in destination section In MTD form")
	public void verifyDestinationMissingFieldErrorInCMSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.destinationErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Destination Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in content description section In File Ingest form")
	@When("Verify error message is displayed for all mandatory fields in content description section In Feed Out form")
	public void verifyContentDescriptionMissingFieldErrorInCMSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.contentDescriptionErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Content Description Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in usage section In News Gear form")
	public void verifyUsageMissingFieldErrorInGearSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.hiddenCameraMicroErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "Hidden Camera Micro Error"));
		producerDashboardGeneralPage
				.outsideUsErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Outside Us Error"));
		producerDashboardGeneralPage.nbcStudioLocationErrorMessage(
				CucumberUtils.getValuesFromDataTable(dataTable, "NBC Studio Location Error"));
		producerDashboardGeneralPage
				.outsiderErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Outsider Error"));
		producerDashboardGeneralPage
				.descriptionErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Description Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in edit type section In Edit Self Reporting form")
	public void verifyEditTypeMissingFieldErrorInEditSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.whoIsEditingErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Who is Editing Error"));
		producerDashboardGeneralPage
				.typeofEditErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Type of Edits Error"));
	}

	@When("Verify error message is displayed for all mandatory fields in edit type section In Standard Edit form")
	public void verifyEditTypeMissingFieldErrorInStandardEditSection(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.typeofEditErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Type of Edits Error"));
		producerDashboardGeneralPage
				.quantityErrorMessage(CucumberUtils.getValuesFromDataTable(dataTable, "Qunatity Error"));
	}

	@Then("user increases Suggested Resources")
	public void userIncreasesTheSuggestedResources(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.updateCameraOps(CucumberUtils.getValuesFromDataTable(dataTable, "Camera Ops"));
		producerDashboardGeneralPage.updateAudioOps(CucumberUtils.getValuesFromDataTable(dataTable, "Audio Ops"));
		producerDashboardGeneralPage.updateUtilityOps(CucumberUtils.getValuesFromDataTable(dataTable, "Utility Ops"));
	}

	@And("verify Estimated Cost getting changed or not")
	public void verifyEstimatedCostGettingChangedOrNot() throws Exception {
		producerDashboardGeneralPage.estimatedCostUpdate();
	}

	@Then("verify the Notification when increases Resources Allocation")
	public void verifyTheNotificationWhenIncreasesResourcesAllocation(DataTable dataTable) {
		producerDashboardGeneralPage
				.verifyNoficationMsg(CucumberUtils.getValuesFromDataTable(dataTable, "Notification1"));
		producerDashboardGeneralPage.verifyDisclaimer(CucumberUtils.getValuesFromDataTable(dataTable, "Notification2"));
	}

	@And("verify whether the overlay Calculator details showing correctly")
	public void verifyWhetherTheRightsideOverlayCalculatorDetailsShowingCorrectly() throws Exception {
		producerDashboardGeneralPage.verifyCalculatorOverlay();
	}

	@Then("verify the Missing Fields Alert msg when user click submit button")
	public void verifyMissingFieldsMsg(DataTable dataTable) {
		producerDashboardGeneralPage
				.verifyMissingFieldsMsg(CucumberUtils.getValuesFromDataTable(dataTable, "Missing Field Alert Msg"));
	}

	@Then("verify the {string} section is getting visible")
	public void verifyTheOverrideInfoSectionIsGettingVisible(String info) {
		producerDashboardGeneralPage.verifyTheOverrideInfoSectionIsGettingVisible(info);
	}

	@And("user enters Resource Reason and Description in the NBC News Crew Form")
	public void userEntersResourceReasonAndDescriptionInTheNBCNewsCrewForm(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage
				.addResourceReason(CucumberUtils.getValuesFromDataTable(dataTable, "Resource Reason"));
		producerDashboardGeneralPage.addDescription(CucumberUtils.getValuesFromDataTable(dataTable, "Description"));
	}

	@Then("user verifies the talents in the request in read only mode")
	public void verifyAddedTalentsDisplayedInReadOnlyForm() {
		producerDashboardGeneralPage.verifyAddedTalentsDisplayedInReadOnlyForm();
	}

	@Given("{string} becomes default requester for every request created by it")
	public void addUserAsDefaultRequester(String role) {
		producerDashboardGeneralPage.setLoggedInUserAsDefaultRequester(role);
	}

	@When("user adds requester to the form")
	public void addRequester(DataTable dataTable) throws Exception {
		String requester = CucumberUtils.getValuesFromDataTable(dataTable, "Requester");
		producerDashboardGeneralPage.addRequester(requester);
	}

	@Then("user verifies the Requesters in the REQUESTER\\(S) section of request")
	public void verifyRequestersOfTheRequest() {
		producerDashboardGeneralPage.verifyRequestersOfTheRequest();
	}

	@When("user verifies that it is added as requester in Requesters section of {string} production form")
	public void verifyIfLoggedInUserIsAutomaticallyAddedAsRequesterInProductionForm(String formName) throws Exception {
		producerDashboardGeneralPage.verifyLoggedInUserIsAddedAsRequesterInProductionForm();
	}

	@Then("user verifies the form title {string} on {string} production form")
	public void verifyFormTitle(String formTitle, String formName) throws Exception {
		producerDashboardGeneralPage.verifySelectedRequestPageDisplayed(formTitle);
	}

	@Then("user verifies that the status is {string} for {string} Production form")
	public void verifyStatusOfProductionRequest(String status, String formName) {
		producerDashboardGeneralPage.verifyStatusOfTheRequest(status);
	}

	@When("user add specific user in Talent section")
	public void addTalent(DataTable datatable) throws Exception {
		String name = CucumberUtils.getValuesFromDataTable(datatable, "Name");
		producerDashboardGeneralPage.addTalent(name);
	}

	@When("Verify suggested resource based on combination of Production Type,Audio Needs,Special Conditions")
	public void verifySuggestedResourceCount(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.verifyResourceCount(
				CucumberUtils.getValuesFromDataTable(dataTable, "Production Type"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Audio Needs"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Special Conditions"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Resource"));
	}

	@Then("verify all fields in the Rock Center form are matching with columns in production dashboard")
	public void verifyRockCenterProductionDashboardValuesWithForm(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.verifyRockCenterRequestValuesWithProductionDashboardValues(
				CucumberUtils.getValuesFromDataTable(dataTable, "Requesters"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Prod Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show/Project"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Production Purpose"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Set Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Control Room"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Positions"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Submitted"));
	}

	@Then("verify all fields in the Firearms On Premises form are matching with columns in production dashboard")
	@Then("verify all fields in the Animal On Premises form are matching with columns in production dashboard")
	public void verifyAnimalsProductionDashboardValuesWithForm(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.verifyAnimalsFirearmsPremisesRequestValuesWithProductionDashboardValues(
				CucumberUtils.getValuesFromDataTable(dataTable, "Requesters"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show/Project"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Set Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Submitted"));
	}

	@Then("user verifies status {string} under log tab")
	public void verifyStatusOnLog(String status) {
		producerDashboardGeneralPage.verifyStatusOnLog(status);
	}

	@Then("user verifies details displayed under log tab")
	public void verifyDetailsonLog() {
		producerDashboardGeneralPage.verifyDetailsonLog();
	}

	@Then("user verifies absence of status tab")
	public void verifyStatusTab() {
		producerDashboardGeneralPage.verifyStatusTab();
	}

	@Then("user verifies absence of edit button")
	public void verifyEditButtonNotPresent() {
		producerDashboardGeneralPage.verifyEditButtonNotPresent();
	}

	@Then("user verifies note is deleted")
	public void verifyNoteIsDeleted() {
		producerDashboardGeneralPage.verifyNoteIsDeleted();
	}

	@Then("user verifies {string} has {string} present in {string} color")
	public void verifyRevisionHighlight(String highlightedElement, String typeOfCss, String expectedColor,
			io.cucumber.datatable.DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.verifyRevisionHighlight(highlightedElement, typeOfCss, expectedColor, dataTable);
	}

	@When("user clicks Edit button on request")
	public void clickEditButton() throws Exception {
		producerDashboardGeneralPage.clickEditButton();
	}

	@When("user clicks Save button on request")
	public void clickSaveButton() throws Exception {
		producerDashboardGeneralPage.clickSaveButtonOnRequest();
	}

	@When("user clicks Discard Changes button on request")
	public void clickDiscardChangesButton() throws Exception {
		producerDashboardGeneralPage.clickDiscardChangesButton();
	}

	@Then("user clicks Log button on request")
	public void clickLogButton() throws Exception {
		producerDashboardGeneralPage.clickLogButton();
	}

	@Then("user closes Log Drawer on request")
	public void closeLogDrawer() throws Exception {
		producerDashboardGeneralPage.closeLogDrawer();
	}

	@Then("user verifies all Logs on request")
	public void verifyAllRequestLogs() throws Exception {
		producerDashboardGeneralPage.verifyAllRequestLogs();
	}

	@When("user adds specific user in Talent section in edit mode")
	public void addTalentInEditMode(DataTable datatable) throws Exception {
		String name = CucumberUtils.getValuesFromDataTable(datatable, "Name");
		producerDashboardGeneralPage.addTalent(name, RequestMode.EDIT);
	}

	@When("user adds requester to the form in edit mode")
	public void addRequesterInEditMode(DataTable dataTable) throws Exception {
		String requester = CucumberUtils.getValuesFromDataTable(dataTable, "Requester");
		producerDashboardGeneralPage.addRequester(requester, RequestMode.EDIT);
	}

	@When("user removes specific user in Talent section in edit mode")
	public void removeTalentInEditMode(DataTable datatable) throws Exception {
		String name = CucumberUtils.getValuesFromDataTable(datatable, "Name");
		producerDashboardGeneralPage.removeTalent(name, RequestMode.EDIT);
	}

	@When("user removes requester to the form in edit mode")
	public void removeRequesterInEditMode(DataTable dataTable) throws Exception {
		String requester = CucumberUtils.getValuesFromDataTable(dataTable, "Requester");
		producerDashboardGeneralPage.removeRequester(requester, RequestMode.EDIT);
	}

	@When("user clicks `Unlock This Record` button")
	public void clickUnlockThisRecord() throws Exception {
		producerDashboardGeneralPage.clickUnlockThisRecordButton();
	}

	@When("user switches to `Crew` tab in Fulfillment")
	public void switchToCrewTabInFulfillment() throws Exception {
		producerDashboardGeneralPage.switchToTabInFulfillment("CREW");
	}

	@When("user switches to `Notes` tab in right container on Request")
	public void switchToNotesTabInFulfillment() throws Exception {
		producerDashboardGeneralPage.switchToNotesTabInFulfillment();
	}

	@Then("user clicks Submit button on request")
	public void clickSubmitButton() throws Exception {
		producerDashboardGeneralPage.clickSubmitButton();
	}

	@Then("user clicks Cancel Request button on request")
	public void clickCancelRequestButton() throws Exception {
		producerDashboardGeneralPage.clickCancelRequestButton();
	}

	@Then("user clicks Confirm Cancellation button on request")
	public void clickConfirmCancellationButton() throws Exception {
		producerDashboardGeneralPage.clickConfirmCancellationButton();
	}

	@Then("user adds {int} notes on request")
	public void addNotesOnRequest(int numberOfNotesToAdd) throws Exception {
		producerDashboardGeneralPage.addRequestNotes(numberOfNotesToAdd);
	}

	@Then("user edits notes on request randomly")
	public void editRequestNotesRandomly() throws Exception {
		producerDashboardGeneralPage.editRequestNotesRandomly();
	}

	@Then("user deletes notes on request randomly")
	public void deleteRequestNotesRandomly() throws Exception {
		producerDashboardGeneralPage.deleteRequestNotesRandomly();
	}

  @When("user switches to `Fulfillment` tab on ECM request")
	public void switchToFulfillmentTabInFulfillment() throws Exception {
		producerDashboardGeneralPage.switchToTabInFulfillment("FULFILLMENT");
	}

	@Then("verify NBC News crew standard dashboard options and functionality")
	@Then("verify Digital Journalist DJ Shoot crew standard dashboard options and functionality")
	@Then("verify CNBC crew standard dashboard options and functionality")
	@Then("verify Telemundo News crew standard dashboard options and functionality")
	@Then("verify Telemundo News crew resource dashboard options and functionality")
	@Then("verify Digital Journalist DJ Shoot crew resource dashboard options and functionality")
	@Then("verify NBC News crew resource dashboard options and functionality")
	@Then("verify CNBC crew resource dashboard options and functionality")
	@Then("verify CNBC production dashboard options and functionality")
	@Then("verify rock center production dashboard options and functionality")
	public void verifyDashboardOptionsFunctionalities(DataTable dataTable) throws Exception {
		producerDashboardGeneralPage.verifyDateRangeInDashboard(
				CucumberUtils.getValuesFromDataTable(dataTable, "StartDate"),
				CucumberUtils.getValuesFromDataTable(dataTable, "EndDate"));
		producerDashboardGeneralPage
				.verifyGlobalSearchInDashboard(CucumberUtils.getValuesFromDataTable(dataTable, "GlobalSearchText"));
		producerDashboardGeneralPage.verifySettingButtonFilterInDashboard(
				CucumberUtils.getValuesFromDataTable(dataTable, "Columns To Be Removed"));
		producerDashboardGeneralPage.verifyPageNaviagtionsInDashboard();
		producerDashboardGeneralPage.verifyClearButtonInDashboard(
				CucumberUtils.getValuesFromDataTable(dataTable, "StartDate"),
				CucumberUtils.getValuesFromDataTable(dataTable, "EndDate"));
		producerDashboardGeneralPage.verifyScrollBarCheckerInDashboard();
	}
}
