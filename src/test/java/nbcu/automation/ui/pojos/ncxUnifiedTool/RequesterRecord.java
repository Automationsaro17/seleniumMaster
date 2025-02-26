package nbcu.automation.ui.pojos.ncxUnifiedTool;

public class RequesterRecord {
	private String name;
	private String jobTitle;
	
	public RequesterRecord(String name,String jobTitle) {
		this.name=name;
		this.jobTitle=jobTitle;
	}
	
	public RequesterRecord(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
}
