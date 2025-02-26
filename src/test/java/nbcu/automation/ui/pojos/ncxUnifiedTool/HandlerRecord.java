package nbcu.automation.ui.pojos.ncxUnifiedTool;

public class HandlerRecord {
	private String name;
	private String emailAddress;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public HandlerRecord(String name, String emailAddress, String phone) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.phone = phone;
	}
	public HandlerRecord() {
		super();
	}
	@Override
	public String toString() {
		return "HandlerRecord [name=" + name + ", emailAddress=" + emailAddress + ", phone=" + phone + "]";
	}
}

