package nbcu.automation.api.pojo;

import java.util.ArrayList;

public class CreateCNBCProductionRequest{
    public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getOtherDivision() {
		return otherDivision;
	}

	public void setOtherDivision(String otherDivision) {
		this.otherDivision = otherDivision;
	}

	public String getWorkOrder() {
		return workOrder;
	}

	public void setWorkOrder(String workOrder) {
		this.workOrder = workOrder;
	}

	public String getStudioType() {
		return studioType;
	}

	public void setStudioType(String studioType) {
		this.studioType = studioType;
	}

	public String getUnifiedRequestId() {
		return unifiedRequestId;
	}

	public void setUnifiedRequestId(String unifiedRequestId) {
		this.unifiedRequestId = unifiedRequestId;
	}

	public String getSeniorProducer() {
		return seniorProducer;
	}

	public void setSeniorProducer(String seniorProducer) {
		this.seniorProducer = seniorProducer;
	}

	public String getSeniorProducerKey() {
		return seniorProducerKey;
	}

	public void setSeniorProducerKey(String seniorProducerKey) {
		this.seniorProducerKey = seniorProducerKey;
	}

	public String getRequestorContact() {
		return requestorContact;
	}

	public void setRequestorContact(String requestorContact) {
		this.requestorContact = requestorContact;
	}

	public String getRequestorEmail() {
		return requestorEmail;
	}

	public void setRequestorEmail(String requestorEmail) {
		this.requestorEmail = requestorEmail;
	}

	public String getRequestorKey() {
		return requestorKey;
	}

	public void setRequestorKey(String requestorKey) {
		this.requestorKey = requestorKey;
	}

	public String getRequestorName() {
		return requestorName;
	}

	public void setRequestorName(String requestorName) {
		this.requestorName = requestorName;
	}

	public boolean isRequestComplete() {
		return requestComplete;
	}

	public void setRequestComplete(boolean requestComplete) {
		this.requestComplete = requestComplete;
	}

	public Object getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(Object loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	public Object getAnchorOrHostOrGuestName() {
		return anchorOrHostOrGuestName;
	}

	public void setAnchorOrHostOrGuestName(Object anchorOrHostOrGuestName) {
		this.anchorOrHostOrGuestName = anchorOrHostOrGuestName;
	}

	public String getIsRequestorProducer() {
		return isRequestorProducer;
	}

	public void setIsRequestorProducer(String isRequestorProducer) {
		this.isRequestorProducer = isRequestorProducer;
	}

	public String getProducerKey() {
		return producerKey;
	}

	public void setProducerKey(String producerKey) {
		this.producerKey = producerKey;
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public ArrayList<StudioControlRoom> getStudioControlRoom() {
		return studioControlRoom;
	}

	public void setStudioControlRoom(ArrayList<StudioControlRoom> studioControlRoom) {
		this.studioControlRoom = studioControlRoom;
	}

	public String getLocOtherstxt() {
		return locOtherstxt;
	}

	public void setLocOtherstxt(String locOtherstxt) {
		this.locOtherstxt = locOtherstxt;
	}

	public String getCrOtherstxt() {
		return crOtherstxt;
	}

	public void setCrOtherstxt(String crOtherstxt) {
		this.crOtherstxt = crOtherstxt;
	}

	public double getCreated() {
		return created;
	}

	public void setCreated(double created) {
		this.created = created;
	}

	public String getStudioRequestStatus() {
		return studioRequestStatus;
	}

	public void setStudioRequestStatus(String studioRequestStatus) {
		this.studioRequestStatus = studioRequestStatus;
	}

	public String getRequesterEmail() {
		return requesterEmail;
	}

	public void setRequesterEmail(String requesterEmail) {
		this.requesterEmail = requesterEmail;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public int getFulfillmentEmailNo() {
		return fulfillmentEmailNo;
	}

	public void setFulfillmentEmailNo(int fulfillmentEmailNo) {
		this.fulfillmentEmailNo = fulfillmentEmailNo;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getStoryName() {
		return storyName;
	}

	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}

	public String getStorySlugID() {
		return storySlugID;
	}

	public void setStorySlugID(String storySlugID) {
		this.storySlugID = storySlugID;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getSubDivision() {
		return subDivision;
	}

	public void setSubDivision(String subDivision) {
		this.subDivision = subDivision;
	}

	public ArrayList<Requester> getRequesters() {
		return requesters;
	}

	public void setRequesters(ArrayList<Requester> requesters) {
		this.requesters = requesters;
	}

	public ArrayList<Talent> getTalent() {
		return talent;
	}

	public void setTalent(ArrayList<Talent> talent) {
		this.talent = talent;
	}

	public String getProductionPurpose() {
		return productionPurpose;
	}

	public void setProductionPurpose(String productionPurpose) {
		this.productionPurpose = productionPurpose;
	}

	public String getDetailsAndNotes() {
		return detailsAndNotes;
	}

	public void setDetailsAndNotes(String detailsAndNotes) {
		this.detailsAndNotes = detailsAndNotes;
	}

	public String getAirPlatform() {
		return airPlatform;
	}

	public void setAirPlatform(String airPlatform) {
		this.airPlatform = airPlatform;
	}

	public ArrayList<Showunit> getShowunit() {
		return showunit;
	}

	public void setShowunit(ArrayList<Showunit> showunit) {
		this.showunit = showunit;
	}

	public StartDates getStartDates() {
		return startDates;
	}

	public void setStartDates(StartDates startDates) {
		this.startDates = startDates;
	}

	public ArrayList<StudioLocation> getStudioLocation() {
		return studioLocation;
	}

	public void setStudioLocation(ArrayList<StudioLocation> studioLocation) {
		this.studioLocation = studioLocation;
	}

	public ArrayList<String> getAudioProdA2() {
		return audioProdA2;
	}

	public void setAudioProdA2(ArrayList<String> audioProdA2) {
		this.audioProdA2 = audioProdA2;
	}

	public ArrayList<String> getCamOpJIB() {
		return camOpJIB;
	}

	public void setCamOpJIB(ArrayList<String> camOpJIB) {
		this.camOpJIB = camOpJIB;
	}

	public ArrayList<String> getCamOpPed() {
		return camOpPed;
	}

	public void setCamOpPed(ArrayList<String> camOpPed) {
		this.camOpPed = camOpPed;
	}

	public ArrayList<Object> getCamStediCam() {
		return camStediCam;
	}

	public void setCamStediCam(ArrayList<Object> camStediCam) {
		this.camStediCam = camStediCam;
	}

	public ArrayList<Object> getCloudSwitchOperator() {
		return cloudSwitchOperator;
	}

	public void setCloudSwitchOperator(ArrayList<Object> cloudSwitchOperator) {
		this.cloudSwitchOperator = cloudSwitchOperator;
	}

	public ArrayList<Object> getFlashCam() {
		return flashCam;
	}

	public void setFlashCam(ArrayList<Object> flashCam) {
		this.flashCam = flashCam;
	}

	public ArrayList<Object> getLightingDirector() {
		return lightingDirector;
	}

	public void setLightingDirector(ArrayList<Object> lightingDirector) {
		this.lightingDirector = lightingDirector;
	}

	public ArrayList<Object> getProductionPlayout() {
		return productionPlayout;
	}

	public void setProductionPlayout(ArrayList<Object> productionPlayout) {
		this.productionPlayout = productionPlayout;
	}

	public ArrayList<Object> getPlayout() {
		return playout;
	}

	public void setPlayout(ArrayList<Object> playout) {
		this.playout = playout;
	}

	public ArrayList<Object> getPrompter() {
		return prompter;
	}

	public void setPrompter(ArrayList<Object> prompter) {
		this.prompter = prompter;
	}

	public ArrayList<Object> getPtzOperator() {
		return ptzOperator;
	}

	public void setPtzOperator(ArrayList<Object> ptzOperator) {
		this.ptzOperator = ptzOperator;
	}

	public ArrayList<Object> getStageAssistant() {
		return stageAssistant;
	}

	public void setStageAssistant(ArrayList<Object> stageAssistant) {
		this.stageAssistant = stageAssistant;
	}

	public ArrayList<Object> getStageManager() {
		return stageManager;
	}

	public void setStageManager(ArrayList<Object> stageManager) {
		this.stageManager = stageManager;
	}

	public ArrayList<Object> getTechnicalproducer() {
		return technicalproducer;
	}

	public void setTechnicalproducer(ArrayList<Object> technicalproducer) {
		this.technicalproducer = technicalproducer;
	}

	public ArrayList<Object> getUtility() {
		return utility;
	}

	public void setUtility(ArrayList<Object> utility) {
		this.utility = utility;
	}

	public ArrayList<Object> getVidRobo() {
		return vidRobo;
	}

	public void setVidRobo(ArrayList<Object> vidRobo) {
		this.vidRobo = vidRobo;
	}

	public ArrayList<Object> getStudioTd() {
		return studioTd;
	}

	public void setStudioTd(ArrayList<Object> studioTd) {
		this.studioTd = studioTd;
	}

	public ArrayList<Object> getHairStylist() {
		return hairStylist;
	}

	public void setHairStylist(ArrayList<Object> hairStylist) {
		this.hairStylist = hairStylist;
	}

	public ArrayList<Object> getMakeupArtist() {
		return makeupArtist;
	}

	public void setMakeupArtist(ArrayList<Object> makeupArtist) {
		this.makeupArtist = makeupArtist;
	}

	public Object getLocOthers() {
		return locOthers;
	}

	public void setLocOthers(Object locOthers) {
		this.locOthers = locOthers;
	}

	public boolean isStagingNeeded() {
		return stagingNeeded;
	}

	public void setStagingNeeded(boolean stagingNeeded) {
		this.stagingNeeded = stagingNeeded;
	}

	public String getStagingNeedsDesc() {
		return stagingNeedsDesc;
	}

	public void setStagingNeedsDesc(String stagingNeedsDesc) {
		this.stagingNeedsDesc = stagingNeedsDesc;
	}

	public String getControlRoomNeeded() {
		return controlRoomNeeded;
	}

	public void setControlRoomNeeded(String controlRoomNeeded) {
		this.controlRoomNeeded = controlRoomNeeded;
	}

	public String getIngest() {
		return ingest;
	}

	public void setIngest(String ingest) {
		this.ingest = ingest;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public ArrayList<String> getAssociateDirector() {
		return associateDirector;
	}

	public void setAssociateDirector(ArrayList<String> associateDirector) {
		this.associateDirector = associateDirector;
	}

	public ArrayList<String> getAudioA1() {
		return audioA1;
	}

	public void setAudioA1(ArrayList<String> audioA1) {
		this.audioA1 = audioA1;
	}

	public ArrayList<String> getAudioProtools() {
		return audioProtools;
	}

	public void setAudioProtools(ArrayList<String> audioProtools) {
		this.audioProtools = audioProtools;
	}

	public ArrayList<Object> getChyron() {
		return chyron;
	}

	public void setChyron(ArrayList<Object> chyron) {
		this.chyron = chyron;
	}

	public ArrayList<Object> getDirector() {
		return director;
	}

	public void setDirector(ArrayList<Object> director) {
		this.director = director;
	}

	public ArrayList<Object> getRossExpressionDirector() {
		return rossExpressionDirector;
	}

	public void setRossExpressionDirector(ArrayList<Object> rossExpressionDirector) {
		this.rossExpressionDirector = rossExpressionDirector;
	}

	public ArrayList<Object> getTechnicalDirector() {
		return technicalDirector;
	}

	public void setTechnicalDirector(ArrayList<Object> technicalDirector) {
		this.technicalDirector = technicalDirector;
	}

	public ArrayList<Object> getTps() {
		return tps;
	}

	public void setTps(ArrayList<Object> tps) {
		this.tps = tps;
	}

	public ArrayList<Object> getVizGraphics() {
		return vizGraphics;
	}

	public void setVizGraphics(ArrayList<Object> vizGraphics) {
		this.vizGraphics = vizGraphics;
	}

	public Object getCrOthers() {
		return crOthers;
	}

	public void setCrOthers(Object crOthers) {
		this.crOthers = crOthers;
	}

	public AcknowledgedStatus getAcknowledgedStatus() {
		return acknowledgedStatus;
	}

	public void setAcknowledgedStatus(AcknowledgedStatus acknowledgedStatus) {
		this.acknowledgedStatus = acknowledgedStatus;
	}

	public AckTechnicalStatus getAckTechnicalStatus() {
		return ackTechnicalStatus;
	}

	public void setAckTechnicalStatus(AckTechnicalStatus ackTechnicalStatus) {
		this.ackTechnicalStatus = ackTechnicalStatus;
	}

	public AckStagingStatus getAckStagingStatus() {
		return ackStagingStatus;
	}

	public void setAckStagingStatus(AckStagingStatus ackStagingStatus) {
		this.ackStagingStatus = ackStagingStatus;
	}

	public AckPlayoutStatus getAckPlayoutStatus() {
		return ackPlayoutStatus;
	}

	public void setAckPlayoutStatus(AckPlayoutStatus ackPlayoutStatus) {
		this.ackPlayoutStatus = ackPlayoutStatus;
	}

	public AckHairStatus getAckHairStatus() {
		return ackHairStatus;
	}

	public void setAckHairStatus(AckHairStatus ackHairStatus) {
		this.ackHairStatus = ackHairStatus;
	}

	public AckTPSStatus getAckTPSStatus() {
		return ackTPSStatus;
	}

	public void setAckTPSStatus(AckTPSStatus ackTPSStatus) {
		this.ackTPSStatus = ackTPSStatus;
	}

	public AckIngestStatus getAckIngestStatus() {
		return ackIngestStatus;
	}

	public void setAckIngestStatus(AckIngestStatus ackIngestStatus) {
		this.ackIngestStatus = ackIngestStatus;
	}

	public Object getAcknowledgedBy() {
		return acknowledgedBy;
	}

	public void setAcknowledgedBy(Object acknowledgedBy) {
		this.acknowledgedBy = acknowledgedBy;
	}

	public Object getAckTechnicalBy() {
		return ackTechnicalBy;
	}

	public void setAckTechnicalBy(Object ackTechnicalBy) {
		this.ackTechnicalBy = ackTechnicalBy;
	}

	public Object getAckStagingBy() {
		return ackStagingBy;
	}

	public void setAckStagingBy(Object ackStagingBy) {
		this.ackStagingBy = ackStagingBy;
	}

	public Object getAckPlayoutBy() {
		return ackPlayoutBy;
	}

	public void setAckPlayoutBy(Object ackPlayoutBy) {
		this.ackPlayoutBy = ackPlayoutBy;
	}

	public String getAckHairBy() {
		return ackHairBy;
	}

	public void setAckHairBy(String ackHairBy) {
		this.ackHairBy = ackHairBy;
	}

	public String getAckTPSBy() {
		return ackTPSBy;
	}

	public void setAckTPSBy(String ackTPSBy) {
		this.ackTPSBy = ackTPSBy;
	}

	public Object getAckIngestBy() {
		return ackIngestBy;
	}

	public void setAckIngestBy(Object ackIngestBy) {
		this.ackIngestBy = ackIngestBy;
	}

	public boolean isDoNotSendmail() {
		return doNotSendmail;
	}

	public void setDoNotSendmail(boolean doNotSendmail) {
		this.doNotSendmail = doNotSendmail;
	}

	public int getModifiedBySSO() {
		return modifiedBySSO;
	}

	public void setModifiedBySSO(int modifiedBySSO) {
		this.modifiedBySSO = modifiedBySSO;
	}

	public String cc;
    public String otherDivision;
    public String workOrder;
    public String studioType;
    public String unifiedRequestId;
    public String seniorProducer;
    public String seniorProducerKey;
    public String requestorContact;
    public String requestorEmail;
    public String requestorKey;
    public String requestorName;
    public boolean requestComplete;
    public Object loggedInUser;
    public Object anchorOrHostOrGuestName;
    public String isRequestorProducer;
    public String producerKey;
    public String producerName;
    public ArrayList<StudioControlRoom> studioControlRoom;
    public String locOtherstxt;
    public String crOtherstxt;
    public double created;
    public String studioRequestStatus;
    public String requesterEmail;
    public String cellPhone;
    public String client;
    public int fulfillmentEmailNo;
    public String slug;
    public String storyName;
    public String storySlugID;
    public String division;
    public String subDivision;
    public ArrayList<Requester> requesters;
    public ArrayList<Talent> talent;
    public String productionPurpose;
    public String detailsAndNotes;
    public String airPlatform;
    public ArrayList<Showunit> showunit;
    public StartDates startDates;
    public ArrayList<StudioLocation> studioLocation;
    public ArrayList<String> audioProdA2;
    public ArrayList<String> camOpJIB;
    public ArrayList<String> camOpPed;
    public ArrayList<Object> camStediCam;
    public ArrayList<Object> cloudSwitchOperator;
    public ArrayList<Object> flashCam;
    public ArrayList<Object> lightingDirector;
    public ArrayList<Object> productionPlayout;
    public ArrayList<Object> playout;
    public ArrayList<Object> prompter;
    public ArrayList<Object> ptzOperator;
    public ArrayList<Object> stageAssistant;
    public ArrayList<Object> stageManager;
    public ArrayList<Object> technicalproducer;
    public ArrayList<Object> utility;
    public ArrayList<Object> vidRobo;
    public ArrayList<Object> studioTd;
    public ArrayList<Object> hairStylist;
    public ArrayList<Object> makeupArtist;
    public Object locOthers;
    public boolean stagingNeeded;
    public String stagingNeedsDesc;
    public String controlRoomNeeded;
    public String ingest;
    public String iso;
    public ArrayList<String> associateDirector;
    public ArrayList<String> audioA1;
    public ArrayList<String> audioProtools;
    public ArrayList<Object> chyron;
    public ArrayList<Object> director;
    public ArrayList<Object> rossExpressionDirector;
    public ArrayList<Object> technicalDirector;
    public ArrayList<Object> tps;
    public ArrayList<Object> vizGraphics;
    public Object crOthers;
    public AcknowledgedStatus acknowledgedStatus;
    public AckTechnicalStatus ackTechnicalStatus;
    public AckStagingStatus ackStagingStatus;
    public AckPlayoutStatus ackPlayoutStatus;
    public AckHairStatus ackHairStatus;
    public AckTPSStatus ackTPSStatus;
    public AckIngestStatus ackIngestStatus;
    public Object acknowledgedBy;
    public Object ackTechnicalBy;
    public Object ackStagingBy;
    public Object ackPlayoutBy;
    public String ackHairBy;
    public String ackTPSBy;
    public Object ackIngestBy;
    public boolean doNotSendmail;
    public int modifiedBySSO;
    
    
    
    public class AckHairStatus{
        public String name;
        public String position;
        public int revisedDate;
        public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public int getRevisedDate() {
			return revisedDate;
		}
		public void setRevisedDate(int revisedDate) {
			this.revisedDate = revisedDate;
		}
		
    }

    public class AckIngestStatus{
    	public String name;
        public String position;
        public int revisedDate;
    	public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public int getRevisedDate() {
			return revisedDate;
		}
		public void setRevisedDate(int revisedDate) {
			this.revisedDate = revisedDate;
		}
		
    }

    public class AcknowledgedStatus{
        public String name;
        public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public int getRevisedDate() {
			return revisedDate;
		}
		public void setRevisedDate(int revisedDate) {
			this.revisedDate = revisedDate;
		}
		public String position;
        public int revisedDate;
    }

    public class AckPlayoutStatus{
        public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public int getRevisedDate() {
			return revisedDate;
		}
		public void setRevisedDate(int revisedDate) {
			this.revisedDate = revisedDate;
		}
		public String name;
        public String position;
        public int revisedDate;
    }

    public class AckStagingStatus{
        public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public int getRevisedDate() {
			return revisedDate;
		}
		public void setRevisedDate(int revisedDate) {
			this.revisedDate = revisedDate;
		}
		public String name;
        public String position;
        public int revisedDate;
    }

    public class AckTechnicalStatus{
        public String name;
        public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public int getRevisedDate() {
			return revisedDate;
		}
		public void setRevisedDate(int revisedDate) {
			this.revisedDate = revisedDate;
		}
		public String position;
        public int revisedDate;
    }

    public class AckTPSStatus{
        public String name;
        public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public int getRevisedDate() {
			return revisedDate;
		}
		public void setRevisedDate(int revisedDate) {
			this.revisedDate = revisedDate;
		}
		public String position;
        public int revisedDate;
    }

    public class Requester{
        public String displayName;
        public String getDisplayName() {
			return displayName;
		}
		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getJobTitle() {
			return jobTitle;
		}
		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}
		public Object getSsoId() {
			return ssoId;
		}
		public void setSsoId(Object ssoId) {
			this.ssoId = ssoId;
		}
		public String getWorkPhone() {
			return workPhone;
		}
		public void setWorkPhone(String workPhone) {
			this.workPhone = workPhone;
		}
		public String emailId;
        public String jobTitle;
        public Object ssoId;
        public String workPhone;
    }
    public class Showunit{
        public String getShowunittitle() {
			return showunittitle;
		}
		public void setShowunittitle(String showunittitle) {
			this.showunittitle = showunittitle;
		}
		public Object getOtherShowunittitle() {
			return otherShowunittitle;
		}
		public void setOtherShowunittitle(Object otherShowunittitle) {
			this.otherShowunittitle = otherShowunittitle;
		}
		public String getBudgetCode() {
			return budgetCode;
		}
		public void setBudgetCode(String budgetCode) {
			this.budgetCode = budgetCode;
		}
		public String showunittitle;
        public Object otherShowunittitle;
        public String budgetCode;
    }

    public class StartDates{
        public double startDate;
        public double getStartDate() {
			return startDate;
		}
		public void setStartDate(double startDate) {
			this.startDate = startDate;
		}
		public int getPrepStartTime() {
			return prepStartTime;
		}
		public void setPrepStartTime(int prepStartTime) {
			this.prepStartTime = prepStartTime;
		}
		public int getProdStartTime() {
			return prodStartTime;
		}
		public void setProdStartTime(int prodStartTime) {
			this.prodStartTime = prodStartTime;
		}
		public int getEndTime() {
			return endTime;
		}
		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}
		public int prepStartTime;
        public int prodStartTime;
        public int endTime;
    }

    public class StudioControlRoom{
        public String getControlRoom() {
			return controlRoom;
		}
		public void setControlRoom(String controlRoom) {
			this.controlRoom = controlRoom;
		}
		public String getSpecificControlRoom() {
			return specificControlRoom;
		}
		public void setSpecificControlRoom(String specificControlRoom) {
			this.specificControlRoom = specificControlRoom;
		}
		public String getOtherControlRoom() {
			return otherControlRoom;
		}
		public void setOtherControlRoom(String otherControlRoom) {
			this.otherControlRoom = otherControlRoom;
		}
		public String getFieldAddress() {
			return fieldAddress;
		}
		public void setFieldAddress(String fieldAddress) {
			this.fieldAddress = fieldAddress;
		}
		public String controlRoom;
        public String specificControlRoom;
        public String otherControlRoom;
        public String fieldAddress;
    }

    public class StudioLocation{
        public String location;
        public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public Object getSetLocation() {
			return setLocation;
		}
		public void setSetLocation(Object setLocation) {
			this.setLocation = setLocation;
		}
		public String getOtherSetLocation() {
			return otherSetLocation;
		}
		public void setOtherSetLocation(String otherSetLocation) {
			this.otherSetLocation = otherSetLocation;
		}
		public String getSetBackground() {
			return setBackground;
		}
		public void setSetBackground(String setBackground) {
			this.setBackground = setBackground;
		}
		public String getOtherSetBackground() {
			return otherSetBackground;
		}
		public void setOtherSetBackground(String otherSetBackground) {
			this.otherSetBackground = otherSetBackground;
		}
		public String getFieldAddress() {
			return fieldAddress;
		}
		public void setFieldAddress(String fieldAddress) {
			this.fieldAddress = fieldAddress;
		}
		public Object setLocation;
        public String otherSetLocation;
        public String setBackground;
        public String otherSetBackground;
        public String fieldAddress;
    }

    public class Talent{
        public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String name;
    }
}

