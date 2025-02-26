package nbcu.automation.ui.pojos.ncxUnifiedTool;

public class AnimalRecord {
	private String typeOfAnimals;
	private Integer howMany=0;
	private String weight;
	private HandlerRecord handler;
	public String getTypeOfAnimals() {
		return typeOfAnimals;
	}
	public void setTypeOfAnimals(String typeOfAnimals) {
		this.typeOfAnimals = typeOfAnimals;
	}
	public Integer getHowMany() {
		return howMany;
	}
	public void setHowMany(Integer howMany) {
		this.howMany = howMany;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public HandlerRecord getHandler() {
		return handler;
	}
	public void setHandler(HandlerRecord handler) {
		this.handler = handler;
	}
	public AnimalRecord(String typeOfAnimals, Integer howMany, String weight, HandlerRecord handler) {
		super();
		this.typeOfAnimals = typeOfAnimals;
		this.howMany = howMany;
		this.weight = weight;
		this.handler = handler;
	}
	public AnimalRecord() {
		super();
	}
	@Override
	public String toString() {
		return "AnimalRecord [typeOfAnimals=" + typeOfAnimals + ", howMany=" + howMany + ", weight=" + weight
				+ ", handler=" + handler + "]";
	}
}
