package nbcu.automation.ui.emailvalidations;

import java.util.HashMap;

public class EmailConstants {

	private static final ThreadLocal<HashMap<String, Object>> constantMap = new ThreadLocal<HashMap<String, Object>>() {
		@Override
		protected HashMap<String, Object> initialValue() {
			return new HashMap<>();
		}
	};
	
	// Email Subject
	public static String getEmailSubject() {
		return (String) constantMap.get().get("Email Subject");
	}

	public static void setEmailSubject(String emailSubject) {
		constantMap.get().put("Email Subject", emailSubject);
	}

	// Email to list
	public static String getEmailToList() {
		return (String) constantMap.get().get("Email To List");
	}

	public static void setEmailToList(String emailToList) {
		constantMap.get().put("Email To List", emailToList);
	}

	//Email cc list
	public static String getEmailCcList() {
		return (String) constantMap.get().get("Email Cc List");
	}

	public static void setEmailCcList(String emailCcList) {
		constantMap.get().put("Email Cc List", emailCcList);
	}

	//Email body
	public static String getEmailBody() {
		return (String) constantMap.get().get("Email Body");
	}

	public static void setEmailBody(String emailBody) {
		constantMap.get().put("Email Body", emailBody);
	}
}
