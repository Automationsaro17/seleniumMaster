package nbcu.automation.ui.pojos.ncxUnifiedTool;

public class ControlRoomAndCrewRecord {
	private String controlRoomAndCrew;
	private String controlRoomLocation;
	private String controlRoom;
	private String address;
	public String getControlRoomAndCrew() {
		return controlRoomAndCrew;
	}
	public void setControlRoomAndCrew(String controlRoomAndCrew) {
		this.controlRoomAndCrew = controlRoomAndCrew;
	}
	public String getControlRoomLocation() {
		return controlRoomLocation;
	}
	public void setControlRoomLocation(String controlRoomAndLocation) {
		this.controlRoomLocation = controlRoomAndLocation;
	}
	public String getControlRoom() {
		return controlRoom;
	}
	public void setControlRoom(String controlRoom) {
		this.controlRoom = controlRoom;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ControlRoomAndCrewRecord(String controlRoomAndCrew, String controlRoomAndLocation, String controlRoom,
			String address) {
		super();
		this.controlRoomAndCrew = controlRoomAndCrew;
		this.controlRoomLocation = controlRoomAndLocation;
		this.controlRoom = controlRoom;
		this.address = address;
	}
	public ControlRoomAndCrewRecord() {
		super();
	}
	@Override
	public String toString() {
		return "ControlRoomAndCrewRecord [controlRoomAndCrew=" + controlRoomAndCrew + ", controlRoomAndLocation="
				+ controlRoomLocation + ", controlRoom=" + controlRoom + ", address=" + address + "]";
	}
}
