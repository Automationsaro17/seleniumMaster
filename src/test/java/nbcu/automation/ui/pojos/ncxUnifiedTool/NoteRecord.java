package nbcu.automation.ui.pojos.ncxUnifiedTool;

import java.time.LocalDateTime;

import nbcu.automation.ui.enums.UserRole;

public class NoteRecord {
	private UserRole userRole;
	private LocalDateTime dateTime;
	private String noteCreator;
	private String noteContent;
	
	public NoteRecord() {
		super();
	}
	public NoteRecord(UserRole userRole, LocalDateTime dateTime, String noteCreator, String noteContent) {
		super();
		this.userRole = userRole;
		this.dateTime = dateTime;
		this.noteCreator = noteCreator;
		this.noteContent = noteContent;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getNoteCreator() {
		return noteCreator;
	}
	public void setNoteCreator(String noteCreator) {
		this.noteCreator = noteCreator;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	@Override
	public String toString() {
		return "NoteRecord [userRole=" + userRole + ", dateTime=" + dateTime + ", noteCreator=" + noteCreator
				+ ", noteContent=" + noteContent + "]";
	}
}
