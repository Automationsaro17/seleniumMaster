package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nbcu.automation.ui.pages.ncxUnifiedTool.EditRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.GearNewsRequestFormPage;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProducerDashboardGeneralPage;
import nbcu.framework.utils.cucumber.CucumberUtils;
import nbcu.framework.utils.ui.Waits;
import nbcu.framework.utils.ui.WebAction;
import nbcu.framework.utils.ui.Waits.WAIT_CONDITIONS;

public class GearNewsRequestFormPageSteps {

	ProducerDashboardGeneralPage producerDashboardGeneralPage = new ProducerDashboardGeneralPage();
	GearNewsRequestFormPage gearNewsRequestFormPage = new GearNewsRequestFormPage();
	EditRequestFormPage editRequestFormPage = new EditRequestFormPage();

	@When("user enters Gear User Information in News Gear form")
	public void fillGearUserInfoInNewsGear(DataTable dataTable) throws Exception {
		gearNewsRequestFormPage.addGearUserInfoInNews(CucumberUtils.getValuesFromDataTable(dataTable, "Gear User"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Mobile Phone"));
	}

	@When("user enters show info Information in News Gear form")
	public void fillShowInfoInNewsGear(DataTable dataTable) throws Exception {
		gearNewsRequestFormPage.addShowUnitInNews(CucumberUtils.getValuesFromDataTable(dataTable, "Show Unit"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Budget Code"));
		gearNewsRequestFormPage.addSegmentTypeInNews(CucumberUtils.getValuesFromDataTable(dataTable, "Segment Type"));
	}

	@When("user enters Logistic details Information in News Gear form")
	public void fillLocationDateTimeInfoInNewsGear(DataTable dataTable) throws Exception {
		gearNewsRequestFormPage.fillLocationDateTimeInfoInNews(
				CucumberUtils.getValuesFromDataTable(dataTable, "Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Pick Up Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Pick Up Time"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Return Date"));
	}

	@Then("user enters Add Gear details Information in News Gear form")
	public void addGearDetailsInNewsGear(DataTable dataTable) throws Exception {
		String[] typeOfGearArrayList = null;
		String[] howManyArrayList = null;
		String[] commentsTextArrayList = null;
		String typeOfGear = CucumberUtils.getValuesFromDataTable(dataTable, "Type of Gear");
		if (typeOfGear != null) {
			typeOfGearArrayList = typeOfGear.split(",");

			String howMany = CucumberUtils.getValuesFromDataTable(dataTable, "How many");
			if (howMany != null) {
				howManyArrayList = howMany.split(",");
			}
			String commentsText = CucumberUtils.getValuesFromDataTable(dataTable, "Comments");
			if (commentsText != null) {
				commentsTextArrayList = commentsText.split(",");
			}
			for (int i = 0; i < typeOfGearArrayList.length; i++) {
				gearNewsRequestFormPage.addGearDetailsInNews(typeOfGearArrayList[i].trim(), howManyArrayList[i].trim(),
						commentsTextArrayList[i].trim());
			}
		}
	}

	@When("user enters Usage deatils Information in News Gear form")
	public void fillUsageDeatilsInNewsGear(DataTable dataTable) throws Exception {
		gearNewsRequestFormPage.fillUsageSectionInNews(
				CucumberUtils.getValuesFromDataTable(dataTable,
						"Is this the gear being used as a hidden camera or microphone?"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Is this gear being used outside the US?"),
				CucumberUtils.getValuesFromDataTable(dataTable,
						"Will any wireless audio equipment be used in any NBC studio location?"),
				CucumberUtils.getValuesFromDataTable(dataTable,
						"Is this gear being given to someone outside of NBC Universal to use?"),
				CucumberUtils.getValuesFromDataTable(dataTable, "description"));
	}

	@When("user enters additional Information in News Gear form")
	public void additionalInformationInNewsGear(DataTable dataTable) throws Exception {
		gearNewsRequestFormPage.fillCommentInNews(CucumberUtils.getValuesFromDataTable(dataTable, "additional info"));
	}

	@Then("user selects sub category type for requested gear in Equipment section")
	public void selectsSubCategoryTypeForRequestedGearInEquipmentSection(DataTable dataTable) throws Exception {

		String typeOfGear = CucumberUtils.getValuesFromDataTable(dataTable, "Type of Gear");
		String[] typeOfGearArrayList = typeOfGear.split(",");
		String howMany = CucumberUtils.getValuesFromDataTable(dataTable, "How many?");
		String[] howManyArrayList = howMany.split(",");
		String subCategory = CucumberUtils.getValuesFromDataTable(dataTable, "Sub Category");
		String[] subCategoryArrayList = subCategory.split("-");

		for (int i = 0; i < typeOfGearArrayList.length; i++) {
			if (typeOfGearArrayList[i].trim().contains("Camera")) {
				gearNewsRequestFormPage.selectsSubCategoryTypeForRequestedGear(typeOfGearArrayList[i].trim(),
						howManyArrayList[i].trim(), subCategoryArrayList[i].trim());
			}
		}
	}

	@Then("verify all fields in the News Gear form are matching with columns in gear dashboard")
	public void verifyGearDashboardValuesWithForm(DataTable dataTable) throws Exception {
		String cssType = "background color";
		producerDashboardGeneralPage.verifyStatusBackgroundColor(cssType,
				CucumberUtils.getValuesFromDataTable(dataTable, "Status"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Color"));
		gearNewsRequestFormPage.verifyNewsGearRequestValuesWithGearDashboardValues(
				CucumberUtils.getValuesFromDataTable(dataTable, "Submitted"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Requesters"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Location"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Pick Up Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Pick Up Time"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Return Date"),
				CucumberUtils.getValuesFromDataTable(dataTable, "Show"));
	}

}
