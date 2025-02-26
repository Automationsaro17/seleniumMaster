package nbcu.automation.ui.constants.ncxUnifiedTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nbcu.automation.ui.enums.RequestStatus;
import nbcu.automation.ui.enums.RequestType;
import nbcu.automation.ui.enums.UserRole;
import nbcu.automation.ui.pojos.ncxUnifiedTool.AnimalRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.ControlRoomAndCrewRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.CrewRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.DestinationRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.FirearmRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.HandlerRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.LocationRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.NoteRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.RequestLog;
import nbcu.automation.ui.pojos.ncxUnifiedTool.RequesterRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.ShowUnitRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.SourceRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.TalentRecord;
import nbcu.automation.ui.pojos.ncxUnifiedTool.TpmOrTmInformation;

public class Constants {

	private static ThreadLocal<HashMap<String, Object>> constantMap = new ThreadLocal<HashMap<String, Object>>() {
		@Override
		protected HashMap<String, Object> initialValue() {
			return new HashMap<>();
		}
	};

	// To get ECM request number
	public static String getRequestNumber() {
		return (String) constantMap.get().get("Request Number");
	}

	// To set ECM request Number
	public static void setRequestNumber(String requestNumber) {
		constantMap.get().put("Request Number", requestNumber);
	}

	// To get default requester name
	public static String getDefaultRequesterName() {
		return (String) constantMap.get().get("Default Requester Name");
	}

	public static String getDefaultRequesterPhoneNumber() {
		return (String) constantMap.get().get("Default Requester Phone Number");
	}

	public static String getProducerName() {
		return (String) constantMap.get().get("Producer Name");
	}

	public static String getProducerPhoneNumber() {
		return (String) constantMap.get().get("Producer Phone Number");
	}

	public static String getIsOnsiteProducer() {
		return (String) constantMap.get().get("Is Onsite Producer");
	}

	public static String getSeniorProducerName() {
		return (String) constantMap.get().get("Senior Producer Name");
	}

	// To get Show Info
	public static String getShowUnit() {
		return (String) constantMap.get().get("Show Unit");
	}

	// To get business value
	public static String getBusinessValue() {
		return (String) constantMap.get().get("Business Value");
	}

	// To get budget code
	public static String getBudgetCode() {
		return (String) constantMap.get().get("Budget Code");
	}

	public static String getTalent() {
		return (String) constantMap.get().get("Talent Name");
	}

	public static String getProductionType() {
		return (String) constantMap.get().get("Production Type");
	}

	public static String getShootStatus() {
		return (String) constantMap.get().get("Shoot Status");
	}

	public static String getShootType() {
		return (String) constantMap.get().get("Shoot Type");
	}

	public static String getColorSpace() {
		return (String) constantMap.get().get("Color Space");
	}

	public static String getShootDescription() {
		return (String) constantMap.get().get("Shoot Description");
	}

	public static String getAudioNeeds() {
		return (String) constantMap.get().get("Audio Needs");
	}

	public static String getSpecialCondition() {
		return (String) constantMap.get().get("Special Condition");
	}

	public static String getTransmissionType() {
		return (String) constantMap.get().get("Tranmission Type");
	}

	public static String getIsDroneNeeded() {
		return (String) constantMap.get().get("Drone Needed");
	}

	public static String getIs360CamNeeded() {
		return (String) constantMap.get().get("360 Camera Needed");
	}

	public static String getIpadPrompter() {
		return (String) constantMap.get().get("Ipad Prompter Required");
	}

	public static String getSpecialGear() {
		return (String) constantMap.get().get("Special Gear");
	}

	public static String getBureauLocation() {
		return (String) constantMap.get().get("Bureau Location");
	}

	public static String getAddressLine1() {
		return (String) constantMap.get().get("Address Line1");
	}

	public static String getCity() {
		return (String) constantMap.get().get("City");
	}

	public static String getState() {
		return (String) constantMap.get().get("State");
	}

	public static String getZipCode() {
		return (String) constantMap.get().get("Zip Code");
	}

	public static String getCountry() {
		return (String) constantMap.get().get("Country");
	}

	public static String getRiskCategory() {
		return (String) constantMap.get().get("Risk Category");
	}

	public static String getRiskAssessment() {
		return (String) constantMap.get().get("Risk Assessment");
	}

	public static String getOtherHazards() {
		return (String) constantMap.get().get("Other Hazards");
	}

	public static String getEquipmentsForSafety() {
		return (String) constantMap.get().get("Safety Equipments");
	}

	public static String getRiskApprover() {
		return (String) constantMap.get().get("Risk Approver Name");
	}

	public static String getCameraOpsCount() {
		return (String) constantMap.get().get("Camera Ops Count");
	}

	public static String getAudioOpsCount() {
		return (String) constantMap.get().get("Audio Ops Count");
	}

	public static String getEstimatedCost() {
		return (String) constantMap.get().get("Estimated Cost");
	}

	public static String getPrimaryCameraType() {
		return (String) constantMap.get().get("Primary Camera Type");
	}

	public static String getMediaFormat() {
		return (String) constantMap.get().get("Media Format");
	}

	public static String getVideoSpecs() {
		return (String) constantMap.get().get("Video Specs");
	}

	// To get allocation resource count
	public static int getAllocation() {
		return (int) constantMap.get().get("Allocation");
	}

	// To get threshold percentage
	public static int getThresholdPercent() {
		return (int) constantMap.get().get("Threshold");
	}

	// To get actual resource count
	public static int getResourcesCount() {
		if (constantMap.get().containsKey("Resources Count"))
			return (int) constantMap.get().get("Resources Count");
		else
			return 0;
	}

	// To get number of shoot days
	public static int getShootDaysCount() {
		return (int) constantMap.get().get("Shoot Days Count");
	}

	// To get shoot start date
	public static String getShootStartDate() {
		return (String) constantMap.get().get("Shoot Start Date");
	}

	// To get shoot end date
	public static String getShootEndDate() {
		return (String) constantMap.get().get("Shoot End Date");
	}

	// To get shoot start time
	public static String getShootMeetTime() {
		return (String) constantMap.get().get("Shoot Meet Time");
	}

	// To get shoot start time
	public static String getShootStartTime() {
		return (String) constantMap.get().get("Shoot Start Time");
	}

	// To get shoot end time
	public static String getShootEndTime() {
		return (String) constantMap.get().get("Shoot End Time");
	}

	// To get time zone
	public static String getShootTimeZone() {
		return (String) constantMap.get().get("Shoot Time Zone");
	}

	// To get assignment slug
	public static String getAssignmentSlug() {
		return (String) constantMap.get().get("Assignment Slug");
	}

	// To get crew resource role
	public static String getCrewResourceRole(int resourceNumber) {
		return (String) constantMap.get().get("Resource Role_" + resourceNumber);
	}

	// To get crew resource name
	public static String getCrewResourceName(int resourceNumber) {
		return (String) constantMap.get().get("Resource Name_" + resourceNumber);
	}

	// To get crew resource phone
	public static String getCrewResourcePhone(int resourceNumber) {
		return (String) constantMap.get().get("Resource Phone_" + resourceNumber);
	}

	// To get crew resource email
	public static String getCrewResourceEmail(int resourceNumber) {
		return (String) constantMap.get().get("Resource Email_" + resourceNumber);
	}

	public static String getEmailToList() {
		return (String) constantMap.get().get("Email To List");
	}

	public static String getEmailCcList() {
		return (String) constantMap.get().get("Email CC List");
	}

	public static String getEmailSubject() {
		return (String) constantMap.get().get("Email Subject");
	}

	public static String getEmailBody() {
		return (String) constantMap.get().get("Email Body");
	}

	// To get requester notes
	public static String getRequesterNotes(int notesNumber) {
		return (String) constantMap.get().get("Requester Notes_" + notesNumber);
	}

	// To get fulfiller notes
	public static String getFulfillerNotes(int notesNumber) {
		return (String) constantMap.get().get("Fulfiller Notes_" + notesNumber);
	}

	public static String getRequesterNotesTime(int notesNumber) {
		return (String) constantMap.get().get("Requester Notes Time_" + notesNumber);
	}

	public static String getFulfillerNotesTime(int notesNumber) {
		return (String) constantMap.get().get("Fulfiller Notes Time_" + notesNumber);
	}

	// To get requester notes count
	public static int getRequesterNotesCount() {
		return (int) constantMap.get().get("Requester Notes Count");
	}

	// To set fulfiller notes count
	public static int getFulfillerNotesCount() {
		return (int) constantMap.get().get("Fulfiller Notes Count");
	}

	public static String getLogTime() {
		return (String) constantMap.get().get("Log Time");
	}

	// To set default requester name
	public static void setDefaultRequesterName(String defaultRequestorName) {
		constantMap.get().put("Default Requester Name", defaultRequestorName);
	}

	public static void setDefaultRequesterPhoneNumber(String defaultRequestorPhoneNumber) {
		constantMap.get().put("Default Requester Phone Number", defaultRequestorPhoneNumber);
	}

	public static void setProducerName(String producerName) {
		constantMap.get().put("Producer Name", producerName);
	}

	public static void setProducerPhoneNumber(String producerPhoneNumber) {
		constantMap.get().put("Producer Phone Number", producerPhoneNumber);
	}

	public static void setIsOnsiteProducer(String isOnsiteProducer) {
		constantMap.get().put("Is Onsite Producer", isOnsiteProducer);
	}

	public static void setSeniorProducerName(String seniorProducerName) {
		constantMap.get().put("Senior Producer Name", seniorProducerName);
	}

	// To set Show Info
	public static void setShowUnit(String showUnit) {
		constantMap.get().put("Show Unit", showUnit);
	}

	// To set business value
	public static void setBusinessValue(String businessValue) {
		constantMap.get().put("Business Value", businessValue);
	}

	// To set budget code
	public static void setBudgetCode(String budgetCode) {
		constantMap.get().put("Budget Code", budgetCode);
	}

	public static void setTalent(String talentName) {
		constantMap.get().put("Talent Name", talentName);
	}

	public static void setProductionType(String productionType) {
		constantMap.get().put("Production Type", productionType);
	}

	public static void setShootStatus(String shootStatus) {
		constantMap.get().put("Shoot Status", shootStatus);
	}

	public static void setShootType(String shootType) {
		constantMap.get().put("Shoot Type", shootType);
	}

	public static void setColorSpace(String colorSpace) {
		constantMap.get().put("Color Space", colorSpace);
	}

	public static void setShootDescription(String shootDescription) {
		constantMap.get().put("Shoot Description", shootDescription);
	}

	public static void setAudioNeeds(String audioNeeds) {
		constantMap.get().put("Audio Needs", audioNeeds);
	}

	public static void setSpecialCondition(String specialCondition) {
		constantMap.get().put("Special Condition", specialCondition);
	}

	public static void setTransmissionType(String transmissionType) {
		constantMap.get().put("Tranmission Type", transmissionType);
	}

	public static void setIsDroneNeeded(String isDroneNeeded) {
		constantMap.get().put("Drone Needed", isDroneNeeded);
	}

	public static void setIs360CamNeeded(String is360CamNeeded) {
		constantMap.get().put("360 Camera Needed", is360CamNeeded);
	}

	public static void setIpadPrompter(String isIpadPrompterRequired) {
		constantMap.get().put("Ipad Prompter Required", isIpadPrompterRequired);
	}

	public static void setSpecialGear(String specialGear) {
		constantMap.get().put("Special Gear", specialGear);
	}

	public static void setBureauLocation(String bureauLocation) {
		constantMap.get().put("Bureau Location", bureauLocation);
	}

	public static void setAddressLine1(String addressLine1) {
		constantMap.get().put("Address Line1", addressLine1);
	}

	public static void setCity(String city) {
		constantMap.get().put("City", city);
	}

	public static void setState(String state) {
		constantMap.get().put("State", state);
	}

	public static void setZipCode(String zipCode) {
		constantMap.get().put("Zip Code", zipCode);
	}

	public static void setCountry(String country) {
		constantMap.get().put("Country", country);
	}

	public static void setRiskCategory(String riskCategory) {
		constantMap.get().put("Risk Category", riskCategory);
	}

	public static void setRiskAssessment(String riskAssessment) {
		constantMap.get().put("Risk Assessment", riskAssessment);
	}

	public static void setOtherHazards(String otherHazards) {
		constantMap.get().put("Other Hazards", otherHazards);
	}

	public static void setEquipmentsForSafety(String equipmentForSafety) {
		constantMap.get().put("Safety Equipments", equipmentForSafety);
	}

	public static void setRiskApprover(String riskApprover) {
		constantMap.get().put("Risk Approver Name", riskApprover);
	}

	public static void setCameraOpsCount(String cameraOpsCount) {
		constantMap.get().put("Camera Ops Count", cameraOpsCount);
	}

	public static void setAudioOpsCount(String audioOpsCount) {
		constantMap.get().put("Audio Ops Count", audioOpsCount);
	}

	public static void setEstimatedCost(String estimatedCost) {
		constantMap.get().put("Estimated Cost", estimatedCost);
	}

	// To set allocation resource count
	public static void setAllocationCount(int allocation) {
		constantMap.get().put("Allocation", allocation);
	}

	// To set threshold percentage
	public static void setThresholdPercent(int threshold) {
		constantMap.get().put("Threshold", threshold);
	}

	// To set actual resource count
	public static void setShootDaysCount(int shootDaysCount) {
		constantMap.get().put("Shoot Days Count", shootDaysCount);
	}

	// To set number of shoot days
	public static void setResourceCount(int ResourcesCount) {
		constantMap.get().put("Resources Count", ResourcesCount);
	}

	// To set shoot start date
	public static void setShootStartDate(String shootStartDate) {
		constantMap.get().put("Shoot Start Date", shootStartDate);
	}

	// To set shoot end date
	public static void setShootEndDate(String shootEndDate) {
		constantMap.get().put("Shoot End Date", shootEndDate);
	}

	// To set shoot meet time
	public static void setShootMeetTime(String shootMeetTime) {
		constantMap.get().put("Shoot Meet Time", shootMeetTime);
	}

	// To set shoot start time
	public static void setShootStartTime(String shootStartTime) {
		constantMap.get().put("Shoot Start Time", shootStartTime);
	}

	// To set shoot end time
	public static void setShootEndTime(String shootEndTime) {
		constantMap.get().put("Shoot End Time", shootEndTime);
	}

	// To set crew resource role
	public static void setCrewResourceRole(int resourceNumber, String resourceRole) {
		constantMap.get().put("Resource Role_" + resourceNumber, resourceRole);
	}

	// To set crew resource name
	public static void setCrewResourceName(int resourceNumber, String resourceName) {
		constantMap.get().put("Resource Name_" + resourceNumber, resourceName);
	}

	// To set crew resource phone
	public static void setCrewResourcePhone(int resourceNumber, String resourcePhone) {
		constantMap.get().put("Resource Phone_" + resourceNumber, resourcePhone);
	}

	// To set crew resource email
	public static void setCrewResourceEmail(int resourceNumber, String resourceEmail) {
		constantMap.get().put("Resource Email_" + resourceNumber, resourceEmail);
	}

	// To set shoot end time
	public static void setShootTimeZone(String shootTimeZone) {
		constantMap.get().put("Shoot Time Zone", shootTimeZone);
	}

	// To set crew Assignment slug
	public static void setAssignmentSlug(String assignmentSlug) {
		constantMap.get().put("Assignment Slug", assignmentSlug);
	}

	public static void setPrimaryCameraType(String primaryCameraType) {
		constantMap.get().put("Primary Camera Type", primaryCameraType);
	}

	public static void setMediaFormat(String mediaFormat) {
		constantMap.get().put("Media Format", mediaFormat);
	}

	public static void setVideoSpecs(String videoSpecs) {
		constantMap.get().put("Video Specs", videoSpecs);
	}

	public static void setEmailToList(String emailToList) {
		constantMap.get().put("Email To List", emailToList);
	}

	public static void setEmailCcList(String emailCcList) {
		constantMap.get().put("Email CC List", emailCcList);
	}

	public static void setEmailSubject(String emailSubject) {
		constantMap.get().put("Email Subject", emailSubject);
	}

	public static void setEmailBody(String emailBody) {
		constantMap.get().put("Email Body", emailBody);
	}

	// To set requester notes count
	public static void setRequesterNotesCount(int count) {
		constantMap.get().put("Requester Notes Count", count);
	}

	// To set fulfiller notes count
	public static void setFulfillerNotesCount(int count) {
		constantMap.get().put("Fulfiller Notes Count", count);
	}

	// To set requester notes
	public static void setRequesterNotes(int notesNumber, String requesterNotes) {
		constantMap.get().put("Requester Notes_" + notesNumber, requesterNotes);
	}

	// To set fulfiller notes
	public static void setFulfillerNotes(int notesNumber, String fulfillerNotes) {
		constantMap.get().put("Fulfiller Notes_" + notesNumber, fulfillerNotes);
	}

	public static void setRequesterNotesTime(int notesNumber, String requesterNotesTime) {
		constantMap.get().put("Requester Notes Time_" + notesNumber, requesterNotesTime);
	}

	public static void setFulfillerNotesTime(int notesNumber, String fulfillerNotesTime) {
		constantMap.get().put("Fulfiller Notes Time_" + notesNumber, fulfillerNotesTime);
	}

	public static void setLogTime(String logTime) {
		constantMap.get().put("Log Time", logTime);
	}

	public static String getIsAControlRoomNeeded() {
		return (String) constantMap.get().get("Is a Control Room Needed");
	}

	public static void setIsAControlRoomNeeded(String yesOrNo) {
		constantMap.get().put("Is a Control Room Needed", yesOrNo);
	}

	public static String getIsBudgetCodeAvailable() {
		return (String) constantMap.get().get("Is Budget Code Available?");
	}

	public static void setIsBudgetCodeAvailable(String option) {
		constantMap.get().put("Is Budget Code Available?", option);
	}

	public static String getDivision() {
		return (String) constantMap.get().get("Division");
	}

	public static void setDivision(String option) {
		constantMap.get().put("Division", option);
	}

	@SuppressWarnings("unchecked")
	public static List<RequesterRecord> getRequesters() {
		Object obj = constantMap.get().get("Requesters");
		if (obj == null) {
			obj = new ArrayList<RequesterRecord>();
			setRequesters((List<RequesterRecord>) obj);
		}
		return (List<RequesterRecord>) obj;
	}

	public static void setRequesters(List<RequesterRecord> requesters) {
		constantMap.get().put("Requesters", requesters);
	}

	public static String getShowUnitOrProjectName() {
		return (String) constantMap.get().get("Show Unit or Project Name");
	}

	public static void setShowUnitOrProjectName(String option) {
		constantMap.get().put("Show Unit or Project Name", option);
	}

	public static String getSubDivison() {
		return (String) constantMap.get().get("Sub Division");
	}

	public static void setSubDivision(String option) {
		constantMap.get().put("Sub Division", option);
	}

	public static String getOtherInShowInfo() {
		return (String) constantMap.get().get("Other");
	}

	public static void setOtherInShowInfo(String option) {
		constantMap.get().put("Other", option);
	}

	public static String getStartDate() {
		return (String) constantMap.get().get("Start Date");
	}

	public static void setStartDate(String option) {
		constantMap.get().put("Start Date", option);
	}

	public static String getCallTime() {
		return (String) constantMap.get().get("Call Time");
	}

	public static void setCallTime(String option) {
		constantMap.get().put("Call Time", option);
	}

	public static String getStartTime() {
		return (String) constantMap.get().get("Start Time");
	}

	public static void setStartTime(String option) {
		constantMap.get().put("Start Time", option);
	}

	public static String getEndTime() {
		return (String) constantMap.get().get("End Time");
	}

	public static void setEndTime(String option) {
		constantMap.get().put("End Time", option);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getControlRoom() {
		Object obj = constantMap.get().get("Control Room");
		if (obj == null) {
			obj = new ArrayList<String>();
			setControlRoom((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setControlRoom(List<String> controlRoom) {
		constantMap.get().put("Control Room", controlRoom);
	}

	public static String getDetailsAndNotes() {
		return (String) constantMap.get().get("Details & Notes");
	}

	public static void setDetailsAndNotes(String option) {
		constantMap.get().put("Details & Notes", option);
	}

	public static String getRequestFor() {
		String requestFor = (String) constantMap.get().get("Request For");
		return requestFor;
	}

	public static void setRequestFor(String option) {
		constantMap.get().put("Request For", option);
	}

	public static void setStagingNeeds(String option) {
		constantMap.get().put("Staging Needs", option);
	}

	public static String getStagingNeeds() {
		return (String) constantMap.get().get("Staging Needs");
	}

	public static String getIngestDoYouNeedContentToBeRecorded() {
		return (String) constantMap.get().get("Ingest: Do you need content to be recorded?");
	}

	public static void setIngestDoYouNeedContentToBeRecorded(String option) {
		constantMap.get().put("Ingest: Do you need content to be recorded?", option);
	}

	public static String getIsoDoYouNeedIsoRecordings() {
		return (String) constantMap.get().get("ISO: Do you need ISO recordings?");
	}

	public static void setIsoDoYouNeedIsoRecordings(String option) {
		constantMap.get().put("ISO: Do you need ISO recordings?", option);
	}

	@SuppressWarnings("unchecked")
	public static List<TalentRecord> getTalents() {
		Object obj = constantMap.get().get("Talent");
		if (obj == null) {
			obj = new ArrayList<TalentRecord>();
			setTalents((List<TalentRecord>) obj);
		}
		return (List<TalentRecord>) obj;
	}

	public static void setTalents(List<TalentRecord> talents) {
		constantMap.get().put("Talent", talents);
	}

	@SuppressWarnings("unchecked")
	public static List<LocationRecord> getLocation() {
		Object obj = constantMap.get().get("LocationRecs");
		if (obj == null) {
			obj = new ArrayList<LocationRecord>();
			setLocation((List<LocationRecord>) obj);
		}
		return (List<LocationRecord>) obj;
	}

	public static void setLocation(List<LocationRecord> locations) {
		constantMap.get().put("LocationRecs", locations);
	}

	public static String getWorkOrder() {
		return (String) constantMap.get().get("Work Order #");
	}

	public static void setWorkOrder(String option) {
		constantMap.get().put("Work Order #", option);
	}

	public static String getArrivalDate() {
		return (String) constantMap.get().get("Arrival Date");
	}

	public static void setArrivalDate(String option) {
		constantMap.get().put("Arrival Date", option);
	}

	public static String getArrivalTime() {
		return (String) constantMap.get().get("Arrival Time");
	}

	public static void setArrivalTime(String option) {
		constantMap.get().put("Arrival Time", option);
	}

	public static String getDepartureTime() {
		return (String) constantMap.get().get("Departure Time");
	}

	public static void setDepartureTime(String option) {
		constantMap.get().put("Departure Time", option);
	}

	public static String getDepartureDate() {
		return (String) constantMap.get().get("Departure Date");
	}

	public static void setDepartureDate(String option) {
		constantMap.get().put("Departure Date", option);
	}

	public static String getAirPlatform() {
		return (String) constantMap.get().get("Air Platform");
	}

	public static void setAirPlatform(String option) {
		constantMap.get().put("Air Platform", option);
	}

	public static String getLocations() {
		return (String) constantMap.get().get("Location");
	}

	public static void setLocations(String location) {
		constantMap.get().put("Location", location);
	}

	public static String getControlRoomLocation() {
		return (String) constantMap.get().get("Control Room Location");
	}

	public static void setControlRoomLocation(String setControlRoomLocation) {
		constantMap.get().put("Control Room Location", setControlRoomLocation);
	}

	public static String getControlRoomOption() {
		return (String) constantMap.get().get("Control Room Location");
	}

	public static void setControlRoomOption(String setControlRoom) {
		constantMap.get().put("Control Room Location", setControlRoom);
	}

	public static String getSetLocations() {
		return (String) constantMap.get().get("Set Location");
	}

	public static void setSetLocations(String setLocation) {
		constantMap.get().put("Set Location", setLocation);
	}

	public static String getSetBackground() {
		return (String) constantMap.get().get("Set Background");
	}

	public static void setSetBackground(String setBackground) {
		constantMap.get().put("Set Background", setBackground);
	}

	public static void setFirearms(List<FirearmRecord> firearms) {
		constantMap.get().put("Firearms", firearms);
	}

	@SuppressWarnings("unchecked")
	public static List<FirearmRecord> getFirearms() {
		Object obj = constantMap.get().get("Firearms");
		if (obj == null) {
			obj = new ArrayList<FirearmRecord>();
			setFirearms((List<FirearmRecord>) obj);
		}
		return (List<FirearmRecord>) obj;
	}

	public static void setAnimals(List<AnimalRecord> animals) {
		constantMap.get().put("Animals", animals);
	}

	@SuppressWarnings("unchecked")
	public static List<AnimalRecord> getAnimals() {
		Object obj = constantMap.get().get("Animals");
		if (obj == null) {
			obj = new ArrayList<AnimalRecord>();
			setAnimals((List<AnimalRecord>) obj);
		}
		return (List<AnimalRecord>) obj;
	}

	public static void setHandlers(List<HandlerRecord> handlers) {
		constantMap.get().put("Handlers", handlers);
	}

	@SuppressWarnings("unchecked")
	public static List<HandlerRecord> getHandlers() {
		Object obj = constantMap.get().get("Handlers");
		if (obj == null) {
			obj = new ArrayList<HandlerRecord>();
			setHandlers((List<HandlerRecord>) obj);
		}
		return (List<HandlerRecord>) obj;
	}

	public static void setControlRoomCrew(List<CrewRecord> crews) {
		constantMap.get().put("Control Room Crew", crews);
	}

	@SuppressWarnings("unchecked")
	public static List<CrewRecord> getControlRoomCrew() {
		Object obj = constantMap.get().get("Control Room Crew");
		if (obj == null) {
			obj = new ArrayList<CrewRecord>();
			setControlRoomCrew((List<CrewRecord>) obj);
		}
		return (List<CrewRecord>) obj;
	}

	public static void setAdditionalCrew(List<CrewRecord> crews) {
		constantMap.get().put("Additional Crew", crews);
	}

	@SuppressWarnings("unchecked")
	public static List<CrewRecord> getAdditionalCrew() {
		Object obj = constantMap.get().get("Additional Crew");
		if (obj == null) {
			obj = new ArrayList<CrewRecord>();
			setAdditionalCrew((List<CrewRecord>) obj);
		}
		return (List<CrewRecord>) obj;
	}

	public static void setSetCrew(List<CrewRecord> crews) {
		constantMap.get().put("Set Crew", crews);
	}

	@SuppressWarnings("unchecked")
	public static List<CrewRecord> getSetCrew() {
		Object obj = constantMap.get().get("Set Crew");
		if (obj == null) {
			obj = new ArrayList<CrewRecord>();
			setSetCrew((List<CrewRecord>) obj);
		}
		return (List<CrewRecord>) obj;
	}

	public static void setFlashcamCrew(List<String> flashcamcrews) {
		constantMap.get().put("Set Flashcam Crew", flashcamcrews);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getFlashcamCrew() {
		Object obj = constantMap.get().get("Set Crew");
		if (obj == null) {
			obj = new ArrayList<String>();
			setFlashcamCrew((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static TpmOrTmInformation getTpmOrTmInformation() {
		Object obj = constantMap.get().get("TPM / TM Information");
		if (obj == null) {
			obj = new TpmOrTmInformation();
			setTpmOrTmInformation((TpmOrTmInformation) obj);
		}
		return (TpmOrTmInformation) obj;
	}

	public static void setTpmOrTmInformation(TpmOrTmInformation rec) {
		constantMap.get().put("TPM / TM Information", rec);
	}

	public static void setControlRoomAndCrew(List<ControlRoomAndCrewRecord> records) {
		constantMap.get().put("Control Room & Crew", records);
	}

	@SuppressWarnings("unchecked")
	public static List<ControlRoomAndCrewRecord> getControlRoomAndCrew() {
		Object obj = constantMap.get().get("Control Room & Crew");
		if (obj == null) {
			obj = new ArrayList<ControlRoomAndCrewRecord>();
			setControlRoomAndCrew((List<ControlRoomAndCrewRecord>) obj);
		}
		return (List<ControlRoomAndCrewRecord>) obj;
	}

	public static void setRequestStatus(RequestStatus status) {
		constantMap.get().put("Request Status", status);
	}

	public static RequestStatus getRequestStatus() {
		return (RequestStatus) constantMap.get().get("Request Status");
	}

	public static void setRequestType(RequestType type) {
		constantMap.get().put("Request Type", type);
	}

	public static void setRequestType(String type) {
		try {
			RequestType[] values = RequestType.values();
			for (RequestType requestType : values) {
				if (type.equals(requestType.getRequestTypeValue())) {
					constantMap.get().put("Request Type", RequestType.valueOf(requestType.name()));
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static RequestType getRequestType() {
		return (RequestType) constantMap.get().get("Request Type");
	}

	public static void setUserRole(UserRole role) {
		constantMap.get().put("User Role", role);
	}

	public static UserRole getUserRole() {
		return (UserRole) constantMap.get().get("User Role");
	}

	public static void setLogs(List<RequestLog> logs) {
		constantMap.get().put("Logs", logs);
	}

	@SuppressWarnings("unchecked")
	public static List<RequestLog> getLogs() {
		Object obj = constantMap.get().get("Logs");
		if (obj == null) {
			obj = new ArrayList<RequestLog>();
			setLogs((List<RequestLog>) obj);
		}
		return (List<RequestLog>) obj;
	}

	public static void setLog(RequestLog log) {
		constantMap.get().put("Log", log);
	}

	public static RequestLog getLog() {
		Object obj = constantMap.get().get("Log");
		if (obj == null) {
			obj = new RequestLog();
			setLog((RequestLog) obj);
		}
		return (RequestLog) obj;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object[]> getMapContainingChanges() {
		Object obj = constantMap.get().get("mapContainingChanges");
		if (obj == null) {
			obj = new HashMap<String, Object[]>();
			constantMap.get().put("mapContainingChanges", obj);
		}
		return (HashMap<String, Object[]>) obj;
	}

	public static void setSubmitButtonClicked(Boolean val) {
		constantMap.get().put("Submit button clicked", val);
	}

	public static Boolean isSubmitButtonClicked() {
		Object obj = constantMap.get().get("Submit button clicked");
		if (obj == null) {
			return false;
		}
		return (Boolean) obj;
	}

	public static void setLoggedInUsersDisplayName(String name) {
		constantMap.get().put("loggedInUsersDisplayName", name);
	}

	public static String getLoggedInUsersDisplayName() {
		return (String) constantMap.get().get("loggedInUsersDisplayName");
	}

	@SuppressWarnings("unchecked")
	public static List<NoteRecord> getRequestNotes() {
		Object obj = constantMap.get().get("requestNotes");
		if (obj == null) {
			obj = new ArrayList<>();
			setRequestNotes((List<NoteRecord>) obj);
		}
		return (List<NoteRecord>) obj;
	}

	public static void setRequestNotes(List<NoteRecord> requestNotes) {
		constantMap.get().put("requestNotes", requestNotes);
	}

	// To set Prod timeStamp
	public static void setPrepTime(String prepTime) {
		constantMap.get().put("Prep Time", prepTime);
	}

	// To get Prod timeStamp
	public static String getPrepTime() {
		return (String) constantMap.get().get("Prep Time");
	}

	public static String getPickUpDate() {
		return (String) constantMap.get().get("Pick Up Date");
	}

	public static void setPickUpDate(String option) {
		constantMap.get().put("Pick Up Date", option);
	}

	public static String getPickUpTime() {
		return (String) constantMap.get().get("Pick Up Time");
	}

	public static void setPickUpTime(String option) {
		constantMap.get().put("Pick Up Time", option);
	}

	public static String getReturnDate() {
		return (String) constantMap.get().get("Return Date");
	}

	public static void setReturnDate(String option) {
		constantMap.get().put("Return Date", option);
	}

	public static String getCaptureManager() {
		return (String) constantMap.get().get("Capture Manager");
	}

	public static void setCaptureManager(String option) {
		constantMap.get().put("Capture Manager", option);
	}

	public static String getRequestUrl() {
		return (String) constantMap.get().get("Request Url");
	}

	public static void setRequestUrl(String option) {
		constantMap.get().put("Request Url", option);
	}

	public static HashMap<String, Object> getConstantMapOfScenario() {
		return constantMap.get();
	}

	public static String getIsStagingNeeded() {
		return (String) constantMap.get().get("Is Staging Needed");
	}

	public static void setIsStagingNeeded(String option) {
		constantMap.get().put("Is Staging Needed", option);
	}

	public static void setIsLightingNeeded(String option) {
		constantMap.get().put("Is Lighting Needed", option);
	}

	public static String getIsLightingNeeded() {
		return (String) constantMap.get().get("Is Lighting Needed");
	}

	public static void setIsCarpentryNeeded(String option) {
		constantMap.get().put("Is Carpentry Needed", option);
	}

	public static String getIsCarpentryNeeded() {
		return (String) constantMap.get().get("Is Carpentry Needed");
	}

	public static void setArePropsNeeded(String option) {
		constantMap.get().put("Are Props Needed", option);
	}

	public static String getArePropsNeeded() {
		return (String) constantMap.get().get("Are Props Needed");
	}

	public static void setSystemNotes(String option) {
		constantMap.get().put("System Notes", option);
	}

	public static String getSystemNotes() {
		return (String) constantMap.get().get("System Notes");
	}

	public static void setDescribeStagingNeeds(String option) {
		constantMap.get().put("Describe Staging Needs", option);
	}

	public static String getDescribeStagingNeeds() {
		return (String) constantMap.get().get("Describe Staging Needs");
	}

	public static void setUltimatte(String qty) {
		constantMap.get().put("Ultimatte", qty);
	}

	public static String getUltimatte() {
		return (String) constantMap.get().get("Ultimatte");
	}

	public static void setVoiceActivatedPrompter(String qty) {
		constantMap.get().put("Voice Activated Prompter", qty);
	}

	public static String getVoiceActivatedPrompter() {
		return (String) constantMap.get().get("Voice Activated Prompter");
	}

	@SuppressWarnings("unchecked")
	public static List<String> getDestinations() {
		Object obj = constantMap.get().get("Destinations");
		if (obj == null) {
			obj = new ArrayList<>();
			setDestinations((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setDestinations(List<String> destinations) {
		constantMap.get().put("Destinations", destinations);
	}

	public static void setComments(String comm) {
		constantMap.get().put("Comments", comm);
	}

	public static String getComments() {
		return (String) constantMap.get().get("Comments");
	}

	public static void setSourceCompression(String comm) {
		constantMap.get().put("Source Compression", comm);
	}

	public static String getSourceCompression() {
		return (String) constantMap.get().get("Source Compression");
	}

	public static void setSourceFrameRate(String comm) {
		constantMap.get().put("Source Frame Rate", comm);
	}

	public static String getSourceFrameRate() {
		return (String) constantMap.get().get("Source Frame Rate");
	}

	public static void setTimeCodes(String comm) {
		constantMap.get().put("Time Codes", comm);
	}

	public static String getTimeCodes() {
		return (String) constantMap.get().get("Time Codes");
	}

	public static void setAvidWorkspace(String comm) {
		constantMap.get().put("Avid Workspace", comm);
	}

	public static String getAvidWorkspace() {
		return (String) constantMap.get().get("Avid Workspace");
	}

	public static void setAvidProjectName(String comm) {
		constantMap.get().put("Avid Project Name", comm);
	}

	public static String getAvidProjectName() {
		return (String) constantMap.get().get("Avid Project Name");
	}

	@SuppressWarnings("unchecked")
	public static List<String> getAvidBinNames() {
		Object obj = constantMap.get().get("Avid Bin Names");
		if (obj == null) {
			obj = new ArrayList<>();
			setAvidBinNames((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setAvidBinNames(List<String> binNames) {
		constantMap.get().put("Avid Bin Names", binNames);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getCNBCStratusSlugs() {
		Object obj = constantMap.get().get("CNBC Stratus Slugs");
		if (obj == null) {
			obj = new ArrayList<>();
			setCNBCStratusSlugs((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setCNBCStratusSlugs(List<String> slugs) {
		constantMap.get().put("CNBC Stratus Slugs", slugs);
	}

	public static void setNeedMaterialArchived(String comm) {
		constantMap.get().put("Need Material Archived?", comm);
	}

	public static String getNeedMaterialArchived() {
		return (String) constantMap.get().get("Need Material Archived?");
	}

	public static void setTranscodeNeeded(String comm) {
		constantMap.get().put("Transcode Needed?", comm);
	}

	public static String getTranscodeNeeded() {
		return (String) constantMap.get().get("Transcode Needed?");
	}

	public static void setDetailsInNimbus(String comm) {
		constantMap.get().put("Details in Nimbus", comm);
	}

	public static String getDetailsInNimbus() {
		return (String) constantMap.get().get("Details in Nimbus");
	}

	@SuppressWarnings("unchecked")
	public static List<SourceRecord> getSourcesList() {
		Object obj = constantMap.get().get("Sources List");
		if (obj == null) {
			obj = new ArrayList<>();
			setSourcesList((List<SourceRecord>) obj);
		}
		return (List<SourceRecord>) obj;
	}

	public static void setSourcesList(List<SourceRecord> sources) {
		constantMap.get().put("Sources List", sources);
	}

	public static void setNcxStoryName(String comm) {
		constantMap.get().put("NCX Story Name", comm);
	}

	public static String getNcxStoryName() {
		return (String) constantMap.get().get("NCX Story Name");
	}

	public static void setSlug(String comm) {
		constantMap.get().put("Slug", comm);
	}

	public static String getSlug() {
		return (String) constantMap.get().get("Slug");
	}

	@SuppressWarnings("unchecked")
	public static List<String> getAdditionalRecipients() {
		Object obj = constantMap.get().get("Additional Recipients");
		if (obj == null) {
			obj = new ArrayList<>();
			setAdditionalRecipients((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setAdditionalRecipients(List<String> sources) {
		constantMap.get().put("Additional Recipients", sources);
	}

	public static String getASAPInDateAndTimeNeeded() {
		return (String) constantMap.get().get("ASAP in Date & Time Needed");
	}

	public static void setASAPInDateAndTimeNeeded(String comm) {
		constantMap.get().put("ASAP in Date & Time Neede", comm);
	}

	public static String getFlexibleInDateAndTimeNeeded() {
		return (String) constantMap.get().get("Flexible in Date & Time Needed");
	}

	public static void setFlexibleInDateAndTimeNeeded(String comm) {
		constantMap.get().put("Flexible in Date & Time Needed", comm);
	}

	public static String getAirDate() {
		return (String) constantMap.get().get("Air Date");
	}

	public static String getToBeDeterminedInShowInformation() {
		return (String) constantMap.get().get("To Be Determined in Show Information");
	}

	public static void setToBeDeterminedInShowInformation(String comm) {
		constantMap.get().put("To Be Determined in Show Information", comm);
	}

	public static String getFlexibleInShowInformation() {
		return (String) constantMap.get().get("Flexible in Show Information");
	}

	public static void setFlexibleInShowInformation(String comm) {
		constantMap.get().put("Flexible in Show Information", comm);
	}

	public static String getReqSameAsProducer() {
		return (String) constantMap.get().get("Req same as Producer");
	}

	public static void setReqSameAsProducer(String comm) {
		constantMap.get().put("Req same as Producer", comm);
	}

	@SuppressWarnings("unchecked")
	public static List<ShowUnitRecord> getShowUnits() {
		Object obj = constantMap.get().get("Show Units");
		if (obj == null) {
			obj = new ArrayList<>();
			setShowUnits((List<ShowUnitRecord>) obj);
		}
		return (List<ShowUnitRecord>) obj;
	}

	public static void setShowUnits(List<ShowUnitRecord> sources) {
		constantMap.get().put("Show Units", sources);
	}

	public static String getOtherDestinationInDestinations() {
		return (String) constantMap.get().get("Other Destination in Destinations");
	}

	public static void setOtherDestinationInDestinations(String comm) {
		constantMap.get().put("Other Destination in Destinations", comm);
	}

	public static String getInstructions() {
		return (String) constantMap.get().get("Instructions");
	}

	public static void setInstructions(String comm) {
		constantMap.get().put("Instructions", comm);
	}

	@SuppressWarnings("unchecked")
	public static List<DestinationRecord> getDestinationsInMTD() {
		Object obj = constantMap.get().get("Destinations in MTD");
		if (obj == null) {
			obj = new ArrayList<>();
			setDestinationsInMTD((List<DestinationRecord>) obj);
		}
		return (List<DestinationRecord>) obj;
	}

	public static void setDestinationsInMTD(List<DestinationRecord> destinations) {
		constantMap.get().put("Destinations in MTD", destinations);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getMethodsOfIngest() {
		Object obj = constantMap.get().get("Method of Ingest");
		if (obj == null) {
			obj = new ArrayList<>();
			setMethodsOfIngest((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setMethodsOfIngest(List<String> ingests) {
		constantMap.get().put("Method of Ingest", ingests);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getDestinationsInFulfillment() {
		Object obj = constantMap.get().get("Destinations in Fulfillment");
		if (obj == null) {
			obj = new ArrayList<>();
			setDestinationsInFulfillment((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setDestinationsInFulfillment(List<String> destinations) {
		constantMap.get().put("Destinations in Fulfillment", destinations);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getFileFormatInFulfillment() {
		Object obj = constantMap.get().get("File format in Fulfillment");
		if (obj == null) {
			obj = new ArrayList<>();
			setFileFormatInFulfillment((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setFileFormatInFulfillment(List<String> fileFormats) {
		constantMap.get().put("File format in Fulfillment", fileFormats);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getFolderFormatInFulfillment() {
		Object obj = constantMap.get().get("Folder format in Fulfillment");
		if (obj == null) {
			obj = new ArrayList<>();
			setFolderFormatInFulfillment((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setFolderFormatInFulfillment(List<String> folderFormats) {
		constantMap.get().put("Folder format in Fulfillment", folderFormats);
	}

	public static Integer getGigSize() {
		return (Integer) constantMap.get().get("Gig Size");
	}

	public static void setGigSize(Integer gigSize) {
		constantMap.get().put("Gig Size", gigSize);
	}

	public static Integer getClipCount() {
		return (Integer) constantMap.get().get("Clip count");
	}

	public static void setClipCount(Integer clipCount) {
		constantMap.get().put("Clip count", clipCount);
	}

	public static String getBinNameInFulfillment() {
		return (String) constantMap.get().get("Bin Name In Fulfillment");
	}

	public static void setBinNameInFulfillment(String binName) {
		constantMap.get().put("Bin Name In Fulfillment", binName);
	}

	public static String getMediaIdInFulfillment() {
		return (String) constantMap.get().get("Media ID In Fulfillment");
	}

	public static void setMediaIdInFulfillment(String mediaId) {
		constantMap.get().put("Media ID In Fulfillment", mediaId);
	}

	public static String getAssistantEditorAssigned() {
		return (String) constantMap.get().get("Assistant Editor Assigned");
	}

	public static void setAssistantEditorAssigned(String editor) {
		constantMap.get().put("Assistant Editor Assigned", editor);
	}

	public static String getIngestCompleteInCnbcStratusInFulfillment() {
		return (String) constantMap.get().get("Ingest Complete In Cnbc Stratus In Fulfillment");
	}

	public static void setIngestCompleteInCnbcStratusInFulfillment(String editor) {
		constantMap.get().put("Ingest Complete In Cnbc Stratus In Fulfillment", editor);
	}

	public static String getIngestCompleteInCnbcAvidInFulfillment() {
		return (String) constantMap.get().get("Ingest Complete In Cnbc Avid In Fulfillment");
	}

	public static void setIngestCompleteInCnbcAvidInFulfillment(String editor) {
		constantMap.get().put("Ingest Complete In Cnbc Avid In Fulfillment", editor);
	}

	public static String getHoursInCnbcStratusInFulfillment() {
		return (String) constantMap.get().get("Hours In Cnbc Stratus In Fulfillment");
	}

	public static void setHoursInCnbcStratusInFulfillment(String editor) {
		constantMap.get().put("Hours In Cnbc Stratus In Fulfillment", editor);
	}

	public static String getMinutesInCnbcStratusInFulfillment() {
		return (String) constantMap.get().get("Minutes In Cnbc Stratus In Fulfillment");
	}

	public static void setMinutesInCnbcStratusInFulfillment(String editor) {
		constantMap.get().put("Minutes In Cnbc Stratus In Fulfillment", editor);
	}

	public static String getSecondsInCnbcStratusInFulfillment() {
		return (String) constantMap.get().get("Seconds In Cnbc Stratus In Fulfillment");
	}

	public static void setSecondsInCnbcStratusInFulfillment(String editor) {
		constantMap.get().put("Seconds In Cnbc Stratus In Fulfillment", editor);
	}

	public static String getHoursInCnbcAvidInFulfillment() {
		return (String) constantMap.get().get("Hours In Cnbc Avid In Fulfillment");
	}

	public static void setHoursInCnbcAvidInFulfillment(String editor) {
		constantMap.get().put("Hours In Cnbc Avid In Fulfillment", editor);
	}

	public static String getMinutesInCnbcAvidInFulfillment() {
		return (String) constantMap.get().get("Minutes In Cnbc Avid In Fulfillment");
	}

	public static void setMinutesInCnbcAvidInFulfillment(String editor) {
		constantMap.get().put("Minutes In Cnbc Avid In Fulfillment", editor);
	}

	public static String getSecondsInCnbcAvidInFulfillment() {
		return (String) constantMap.get().get("Seconds In Cnbc Avid In Fulfillment");
	}

	public static void setSecondsInCnbcAvidInFulfillment(String editor) {
		constantMap.get().put("Seconds In Cnbc Avid In Fulfillment", editor);
	}

	public static String getHoursInTimerInFulfillment() {
		return (String) constantMap.get().get("Hours In Timer In Fulfillment");
	}

	public static void setHoursInTimerInFulfillment(String editor) {
		constantMap.get().put("Hours In Timer In Fulfillment", editor);
	}

	public static String getMinutesInTimerInFulfillment() {
		return (String) constantMap.get().get("Minutes In Timer In Fulfillment");
	}

	public static void setMinutesInTimerInFulfillment(String editor) {
		constantMap.get().put("Minutes In Timer In Fulfillment", editor);
	}

	public static String getSecondsInTimerInFulfillment() {
		return (String) constantMap.get().get("Seconds In Timer In Fulfillment");
	}

	public static void setSecondsInTimerInFulfillment(String editor) {
		constantMap.get().put("Seconds In Timer In Fulfillment", editor);
	}

	public static String getTranscodeCompleteInCnbcStratusInFulfillment() {
		return (String) constantMap.get().get("Transcode Complete In Cnbc Stratus In Fulfillment");
	}

	public static void setTranscodeCompleteInCnbcStratusInFulfillment(String editor) {
		constantMap.get().put("Transcode Complete In Cnbc Stratus In Fulfillment", editor);
	}

	public static String getTranscodingNeededInCnbcStratusInFulfillment() {
		return (String) constantMap.get().get("Transcoding Needed In Cnbc Stratus In Fulfillment");
	}

	public static void setTranscodingNeededInCnbcStratusInFulfillment(String editor) {
		constantMap.get().put("Transcoding Needed In Cnbc Stratus In Fulfillment", editor);
	}

	public static void setWorkspaceInCnbcAvidInFulfillment(String comm) {
		constantMap.get().put("Workspace In Cnbc Avid In Fulfillment", comm);
	}

	public static String getWorkspaceInCnbcAvidInFulfillment() {
		return (String) constantMap.get().get("Workspace In Cnbc Avid In Fulfillment");
	}

	public static void setProjectInCnbcAvidInFulfillment(String comm) {
		constantMap.get().put("Project In Cnbc Avid In Fulfillment", comm);
	}

	public static String getProjectInCnbcAvidInFulfillment() {
		return (String) constantMap.get().get("Project In Cnbc Avid In Fulfillment");
	}

	@SuppressWarnings("unchecked")
	public static List<String> getBinNamesInCnbcAvidInFulfillment() {
		Object obj = constantMap.get().get("Bin Names In Cnbc Avid In Fulfillment");
		if (obj == null) {
			obj = new ArrayList<>();
			setBinNamesInCnbcAvidInFulfillment((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setBinNamesInCnbcAvidInFulfillment(List<String> binNames) {
		constantMap.get().put("Bin Names In Cnbc Avid In Fulfillment", binNames);
	}

	public static void setCommentsInFulfillment(String comm) {
		constantMap.get().put("Comments In Fulfillment", comm);
	}

	public static String getCommentsInFulfillment() {
		return (String) constantMap.get().get("Comments In Fulfillment");
	}

	public static void setFeedTimeInFulfillment(String comm) {
		constantMap.get().put("Feed Time In Fulfillment", comm);
	}

	public static String getFeedTimeInFulfillment() {
		return (String) constantMap.get().get("Feed Time In Fulfillment");
	}

	@SuppressWarnings("unchecked")
	public static List<String> getMultipleShowUnits() {
		Object obj = constantMap.get().get("Show Unit");
		if (obj == null) {
			obj = new ArrayList<String>();
			setMultipleShowUnits((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setMultipleShowUnits(List<String> showUnit) {
		constantMap.get().put("Show Unit", showUnit);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getMultipleBudgetCodes() {
		Object obj = constantMap.get().get("Budget Code");
		if (obj == null) {
			obj = new ArrayList<String>();
			setMultipleBudgetCodes((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setMultipleBudgetCodes(List<String> budgetCode) {
		constantMap.get().put("Budget Code", budgetCode);
	}

	public static int getSuggestedResource() {
		return (int) constantMap.get().get("Suggested Resource");
	}

	public static void setSuggestedResource(int option) {
		constantMap.get().put("Suggested Resource", option);
	}

	public static int getActualResource() {
		return (int) constantMap.get().get("Actual Resource");
	}

	public static void setActualResource(int option) {
		constantMap.get().put("Actual Resource", option);
	}

	public static int getRequiredResource() {
		return (int) constantMap.get().get("Required Resource");
	}

	public static void setRequiredResource(int option) {
		constantMap.get().put("Required Resource", option);
	}

	public static int getActualCameraResource() {
		return (int) constantMap.get().get("Actual Camera Resource");
	}

	public static void setActualCameraResource(int option) {
		constantMap.get().put("Actual Camera Resource", option);
	}

	public static int getActualAudioResource() {
		return (int) constantMap.get().get("Actual Audio Resource");
	}

	public static void setActualAudioResource(int option) {
		constantMap.get().put("Actual Audio Resource", option);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getfulfillmentAudioResourcesName() {
		Object obj = constantMap.get().get("Audio Resources Name");
		if (obj == null) {
			obj = new ArrayList<String>();
			setfulfillmentAudioResourcesName((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setfulfillmentAudioResourcesName(List<String> audioResourcesName) {
		constantMap.get().put("Audio Resources Name", audioResourcesName);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getfulfillmentCameraResourcesName() {
		Object obj = constantMap.get().get("Camera Resources Name");
		if (obj == null) {
			obj = new ArrayList<String>();
			setfulfillmentCameraResourcesName((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setfulfillmentCameraResourcesName(List<String> cameraResourcesName) {
		constantMap.get().put("Camera Resources Name", cameraResourcesName);
	}

	public static String getFormType() {
		return (String) constantMap.get().get("Form Type");
	}

	public static void setFormType(String option) {
		constantMap.get().put("Form Type", option);
	}

	public static String getEditStartDate() {
		return (String) constantMap.get().get("Edit Start Date");
	}

	public static void setEditStartDate(String option) {
		constantMap.get().put("Edit Start Date", option);
	}

	public static String getAirtDate() {
		return (String) constantMap.get().get("Air Date");
	}

	public static void setAirDate(String option) {
		constantMap.get().put("Air Date", option);
	}

	public static String getAirTime() {
		return (String) constantMap.get().get("Air Time");
	}

	public static void setAirTime(String option) {
		constantMap.get().put("Air Time", option);
	}

	public static String getCrashEditNeeded() {
		return (String) constantMap.get().get("Crash Edit Needed");
	}

	public static void setCrashEditNeeded(String option) {
		constantMap.get().put("Crash Edit Needed", option);
	}

	public static String getWhoIsEditing() {
		return (String) constantMap.get().get("Who Is Editing");
	}

	public static void setWhoIsEditing(String option) {
		constantMap.get().put("Who Is Editing", option);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getTypeofEdits() {
		Object obj = constantMap.get().get("Type of Edits");
		if (obj == null) {
			obj = new ArrayList<String>();
			setTypeofEdits((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setTypeofEdits(List<String> typeofEdits) {
		constantMap.get().put("Type of Edits", typeofEdits);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getTypeofEditsQuantity() {
		Object obj = constantMap.get().get("Type of Edits Quantity");
		if (obj == null) {
			obj = new ArrayList<String>();
			setTypeofEditsQuantity((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setTypeofEditsQuantity(List<String> typeofEditsQuantity) {
		constantMap.get().put("Type of Edits Quantity", typeofEditsQuantity);
	}

	public static String getEnteredIntoStorm() {
		return (String) constantMap.get().get("Entered Into Storm");
	}

	public static void setEnteredIntoStorm(String option) {
		constantMap.get().put("Entered Into Storm", option);
	}

	public static String getDateNeededBy() {
		return (String) constantMap.get().get("Date Needed By");
	}

	public static void setDateNeededBy(String option) {
		constantMap.get().put("Date Needed By", option);
	}

	public static String getTimeNeededBy() {
		return (String) constantMap.get().get("Time Needed By");
	}

	public static void setTimeNeededBy(String option) {
		constantMap.get().put("Time Needed By", option);
	}

	public static String getContentDescription() {
		return (String) constantMap.get().get("Content Description");
	}

	public static void setContentDescription(String option) {
		constantMap.get().put("Content Description", option);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getFinalDestination() {
		Object obj = constantMap.get().get("Final Destination");
		if (obj == null) {
			obj = new ArrayList<String>();
			setFinalDestination((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setFinalDestination(List<String> finalDestination) {
		constantMap.get().put("Final Destination", finalDestination);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getSources() {
		Object obj = constantMap.get().get("Sources");
		if (obj == null) {
			obj = new ArrayList<String>();
			setSources((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setSources(List<String> sources) {
		constantMap.get().put("Sources", sources);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getCameras() {
		Object obj = constantMap.get().get("Cameras");
		if (obj == null) {
			obj = new ArrayList<String>();
			setCameras((List<String>) obj);
		}
		return (List<String>) obj;
	}

	public static void setCameras(List<String> cameras) {
		constantMap.get().put("Cameras", cameras);
	}

	public static String getFormName() {
		return (String) constantMap.get().get("Form Name");
	}

	public static void setFormName(String option) {
		constantMap.get().put("Form Name", option);
	}

	public static String getCaptureManagerOption() {
		return (String) constantMap.get().get("Capture Manager");
	}

	public static void setCaptureManagerOption(String option) {
		constantMap.get().put("Capture Manager", option);

	}
}
