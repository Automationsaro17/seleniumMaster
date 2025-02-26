package nbcu.automation.ui.enums;

public enum UserRole {
	PRODUCER("PRODUCER"),
	FULFILLER("FULFILLER"),
	ADMIN("ADMIN");
	
	public final String role;
	
	private UserRole(String role) {
		this.role=role;
	}
}
