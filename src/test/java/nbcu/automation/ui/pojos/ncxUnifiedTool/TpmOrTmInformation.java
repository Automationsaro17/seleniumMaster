package nbcu.automation.ui.pojos.ncxUnifiedTool;

public class TpmOrTmInformation {
	private String IsATpmOrTmNeeded;
	private Boolean sameAsRequester;
	private String tpmOrTmName;
	public TpmOrTmInformation(String isATpmOrTmNeeded, Boolean sameAsRequester, String tpmOrTmName) {
		super();
		IsATpmOrTmNeeded = isATpmOrTmNeeded;
		this.sameAsRequester = sameAsRequester;
		this.tpmOrTmName = tpmOrTmName;
	}
	public TpmOrTmInformation() {
		super();
	}
	public TpmOrTmInformation(String isATpmOrTmNeeded) {
		IsATpmOrTmNeeded = isATpmOrTmNeeded;
	}
	public String getIsATpmOrTmNeeded() {
		return IsATpmOrTmNeeded;
	}
	public void setIsATpmOrTmNeeded(String isATpmOrTmNeeded) {
		IsATpmOrTmNeeded = isATpmOrTmNeeded;
	}
	public Boolean getSameAsRequester() {
		return sameAsRequester;
	}
	public void setSameAsRequester(Boolean sameAsRequester) {
		this.sameAsRequester = sameAsRequester;
	}
	public String getTpmOrTmName() {
		return tpmOrTmName;
	}
	public void setTpmOrTmName(String tpmOrTmName) {
		this.tpmOrTmName = tpmOrTmName;
	}
	@Override
	public String toString() {
		return "TpmTmInformation [IsATpmOrTmNeeded=" + IsATpmOrTmNeeded + ", sameAsRequester=" + sameAsRequester
				+ ", tpmOrTmName=" + tpmOrTmName + "]";
	}
}
