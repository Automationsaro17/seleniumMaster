package nbcu.automation.ui.enums;

// add enums for different statuses as required
public enum RequestStatus {
	NEW("NEW"), MODIFIED("MODIFIED"), COMPLETED("COMPLETED"), WORKING("WORKING"), FULFILLED("FULFILLED"),
	CANCELLED("CANCELLED"), CONFIRM_CANCELLATION("CONFIRM CANCELLATION"), REVISED("REVISED"), EFFORTING("EFFORTING"),
	ROFR("ROFR"), BOOKED("BOOKED"), IN_PROGRESS("IN PROGRESS"), ACKNOWLEDGED("ACKNOWLEDGED"),
	READY_FOR_PICK_UP("READY FOR PICK UP"), EXTENDED("EXTENDED");

	public final String status;

	private RequestStatus(String status) {
		this.status = status;
	}

	public String getStatusValue() {
		return status;
	}

	public static RequestStatus getStatus(String statusVal) {
		for (RequestStatus st : RequestStatus.values()) {
			if (statusVal.equals(st.getStatusValue())) {
				return st;
			}
		}
		return null;
	}
}
