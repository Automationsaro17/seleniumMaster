package nbcu.automation.ui.enums;

public enum RequestType {
	CNBC("CNBC"),
	FirearmsOnPremises("Firearms On Premises"),
	AnimalsOnPremises("Animals On Premises"),
	ExtendOrBridgeCrewFacilities("Extend or Bridge Crew & Facilities"),
	RockCenter("Rock Center"),
	SingleCameraLiveShot("Single Camera Live Shot"),
	NewsGear("News Gear"),
	MTD("Media Transcoding / Transferring / Duplication"),
	FileIngest("File Ingest"),
	FeedOut("Feed Out"),
	StandardEdit("Standard Edit"),
	LongEdit("Long Edit"),
	EditSelfReporting("Edit Self Reporting"),
	CNBCCrew("CNBC Crew"),
	DigitalJournalist("Digital Journalist / DJ Shoot"),
	NBCNews("NBC News"),
	TelemundoNews("Telemundo News");
	
	public final String requestType;
	
	public String getRequestTypeValue() {
		return requestType;
	}
	
	private RequestType(String requestType) {
		this.requestType=requestType;
	}
}
