package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import io.cucumber.java.en.When;
import nbcu.automation.ui.emailvalidations.EmailValidation;

public class EmailValidationSteps {
	
	EmailValidation emailValidation  = new EmailValidation();

	@When("validate recieved email notification for status {string}")
	public void validateRecievedEmailNotififcation(String status) throws Exception {
		emailValidation.verifyEmailReceived(null, status);
	}
	
	@When("validate {string} in the recieved email")
	public void validateToORCCListInTheRecievedEmail(String toOrCCList) throws Exception {
		emailValidation.validateTOandCCList(toOrCCList);
	}
	
	@When("validate {string} in the recieved email for {string} status")
	public void validateToORCCListInTheRecievedEmail(String toOrCCList, String status) throws Exception {
		emailValidation.validateTOandCCList(toOrCCList, status);
	}
	

	
}
