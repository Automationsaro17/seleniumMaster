package nbcu.automation.ui.pojos.ncxUnifiedTool;

public class FirearmRecord {
	private String typeOfFirearms;
	private Integer howMany=0;
	private String type;
	public FirearmRecord(String typeOfFirearms, Integer howMany, String type) {
		super();
		this.typeOfFirearms = typeOfFirearms;
		this.howMany = howMany;
		this.type = type;
	}
	public FirearmRecord() {
		super();
		howMany=0;
	}
	public String getTypeOfFirearms() {
		return typeOfFirearms;
	}
	public void setTypeOfFirearms(String typeOfFirearms) {
		this.typeOfFirearms = typeOfFirearms;
	}
	public Integer getHowMany() {
		return howMany;
	}
	public void setHowMany(Integer howMany) {
		this.howMany = howMany;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return " typeOfFirearms=" + typeOfFirearms + ", howMany=" + howMany + ", type="
				+ type + "]";
	}
}
