package nbcu.automation.ui.pojos.ncxUnifiedTool;

public class TalentRecord {
	private String name;
	private String jobTitle;
	
	public TalentRecord(String name, String jobTitle) {
		this.name = name;
		this.jobTitle = jobTitle;
	}
	
	public TalentRecord(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "TalentRecord [name=" + name + ", jobTitle=" + jobTitle + "]";
	}
	
}
