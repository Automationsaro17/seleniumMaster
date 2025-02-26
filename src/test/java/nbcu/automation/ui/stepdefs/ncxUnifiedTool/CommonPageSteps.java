package nbcu.automation.ui.stepdefs.ncxUnifiedTool;

import java.io.IOException;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nbcu.automation.api.pojo.ECMServices;

public class CommonPageSteps {

	// ************** API ***************
	ECMServices ecms = new ECMServices();

	@Given("user set up base uri")
	public void user_sets_up_base_uri() throws Exception {
		ecms.user_sets_up_base_uri();
	}

	@And("user set up headers")
	public void user_set_up_headers(Map<String, String> header) throws Exception {
		ecms.user_set_up_headers(header);
	}
	@When("user invokes {string} service to create new request")
	public void user_invokes_the_service(String serviceName,String request_payload) throws IOException {
		ecms.setADataAndInvokeService(serviceName, request_payload );
	}

	@Then("validate the status code {string}")
	public void validate_the_status_code(String statuscode) {
		ecms.validateStatusCode(Integer.parseInt(statuscode));
	}
	
	@Then("user invokes {string} service to Revise the request")
	public void user_invokes_service_to_revise_the_request(String serviceName, String request_payload) throws IOException {
		ecms.reviseRequest(serviceName, request_payload);
	}
	@Then("user invokes {string} service to search the request")
	public void user_invokes_service_to_search_the_created_request_is_present_or_not(String serviceName, String request_payload) throws IOException {
	    ecms.searchRequest(serviceName, request_payload);
	}
	
	@Then("validate {string} in the response {string}")
	public void validate_the_response(String attribute, String reponse_path) {
		ecms.validate_the_response(attribute,reponse_path);
	}

	@Then("validate entire attributes of {string}")
	public void validate_the_response_attribute(String serviceName) {
		ecms.validateResponseAttribute(serviceName);
	}

	@When("The response should have equivalent to active results list")
	public void verifyActiveResult(DataTable params) throws Exception {
		ecms.verifyTheResults(params);
	}

	@And("validate request id type status and submission message from final submit response")
	public void validate_final_submit_response() throws Exception {
		ecms.validateFinalSubmitResponse();
	}
	
	@And("user read data {string} and create payload for {string}")
	public void read_data_and_update_json(String scenario_name,String service) throws Exception {
		ecms.read_data_and_update_json(scenario_name,service);
	}

	@And("fetch request id {string}")
	public void fetch_request_id(String req_name) throws Exception {
		ecms.fetch_request_id(req_name);
	}
	
	@Then("validate the response values")
	public void validate_the_response_values() throws Exception {
		ecms.validate_response();
	}

	@Then("validate the {string} response values")
	public void validate_the_response_values(String reqType) throws Exception {
		ecms.validate_response(reqType);
	}
}
