package nbcu.automation.ui.pojos.ncxUnifiedTool;

import java.util.Objects;

public class ShowUnitRecord {
	private String showUnit;
	private String budgetCode;
	public String getShowUnit() {
		return showUnit;
	}
	public void setShowUnit(String showUnit) {
		this.showUnit = showUnit;
	}
	public String getBudgetCode() {
		return budgetCode;
	}
	public void setBudgetCode(String budgetCode) {
		this.budgetCode = budgetCode;
	}
	@Override
	public String toString() {
		return "ShowUnitRecord [showUnit=" + showUnit + ", budgetCode=" + budgetCode + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(budgetCode, showUnit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShowUnitRecord other = (ShowUnitRecord) obj;
		return Objects.equals(budgetCode, other.budgetCode) && Objects.equals(showUnit, other.showUnit);
	}
	public ShowUnitRecord copy() {
		ShowUnitRecord rec = new ShowUnitRecord();
		if(showUnit != null) {
			rec.setShowUnit(new String(showUnit));
		}
		if(budgetCode != null) {
			rec.setBudgetCode(new String(budgetCode));
		}
		return rec;
	}
}
