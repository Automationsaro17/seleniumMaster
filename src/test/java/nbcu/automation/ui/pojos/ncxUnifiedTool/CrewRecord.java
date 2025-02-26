package nbcu.automation.ui.pojos.ncxUnifiedTool;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CrewRecord {
	private String crewName;
	private Integer number;
	private List<String> crewMemberNames;
	
	public CrewRecord(String crewName,Integer number) {
		super();
		this.crewName=crewName;
		this.number=number;
		this.crewMemberNames = new ArrayList<>();
	}
	public CrewRecord(String crewName) {
		this.crewName=crewName;
	}

	public CrewRecord() {
		// TODO Auto-generated constructor stub
	}
	public String getCrewName() {
		return crewName;
	}

	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	public void addCrewMember(String name) {
		crewMemberNames.add(name);
	}
	public void removeCrewMember(String name) {
		crewMemberNames.remove(name);
	}
	public List<String> getCrewMemberNames() {
		return crewMemberNames;
	}
	public void setCrewMemberNames(List<String> members) {
		crewMemberNames=members;
	}
	@Override
	public String toString() {
		return "CrewRecord [crewName=" + crewName + ", number=" + number + ", crewMemberNames=" + crewMemberNames + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(crewMemberNames, crewName, number);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrewRecord other = (CrewRecord) obj;
		return Objects.equals(crewMemberNames, other.crewMemberNames) && Objects.equals(crewName, other.crewName)
				&& Objects.equals(number, other.number);
	}
	public CrewRecord copy() {
		CrewRecord rec = new CrewRecord();
		if(Objects.nonNull(crewName)) {
			rec.setCrewName(new String(crewName));
		}
		if(Objects.nonNull(number)) {
			rec.setNumber(((int)(number)));
		}
		if(Objects.nonNull(crewMemberNames)) {
			crewMemberNames.forEach((name)->{
				rec.crewMemberNames.add(new String(name));
			});
		}
		return rec;
	}
}
