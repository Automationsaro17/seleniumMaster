package nbcu.automation.api.pojo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import nbcu.automation.api.pojo.CreateStudioRequest.Requester;
import nbcu.automation.api.pojo.CreateStudioRequest.Showunit;
import nbcu.automation.api.pojo.CreateStudioRequest.StudioControlRoom;
import nbcu.automation.api.pojo.CreateStudioRequest.StudioLocation;
import nbcu.automation.api.pojo.CreateStudioRequest.Talent;
import nbcu.automation.ui.stepdefs.ncxUnifiedTool.LoginPageSteps;
import nbcu.automation.ui.validation.common.ExcelReader;
//import nbcu.automation.api.pojo.CommonPojo;
//import nbcu.automation.api.pojo.CreateFeedOutRequestResponse;
//import nbcu.automation.api.pojo.CreateFileIngestRequestResponse;
//import nbcu.automation.api.pojo.ECMFinalRequestResponse;
//import nbcu.automation.api.pojo.SaveECMRequest;
//import nbcu.automation.api.pojo.UpdateECMRequest;
import nbcu.framework.utils.Other.ConfigurationTest;
import nbcu.framework.utils.report.ReportGenerate;

public class ECMServices {

	RequestSpecification requestSpec = null;
	ExcelReader excelReader = null;
	CreateStudioRequest createStudioRequest;

	public static Response response;
	int statusCode;
	public static String request_id;
	Set<String> request_type_list = new HashSet<String>();
	List<Map<String, String>> queued_requests_api1 = null;
	public static String requestPayload = "";

	private String createRequestBody() {
		String json = "";
		return "";
	}

	public void validateStatusCode(int statuscode) {
		try {

			Assert.assertEquals(response.getStatusCode(), statuscode);
			ReportGenerate.test.log(Status.PASS,
					"After submit the request Status Code is <b>" + response.getStatusCode() + "</b>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public void validateECMFinalSubmitResponse(Response response) {
	 * 
	 * Gson gson = new Gson(); ECMFinalRequestResponse final_res =
	 * gson.fromJson(response.getBody().asPrettyString(),
	 * ECMFinalRequestResponse.class); ecm_request_id = final_res.getEcmRequestId();
	 * }
	 */

	public void verifyTheResults(DataTable params) {

		String value = "";
		try {

			JsonPath jsonPath = response.jsonPath();

			// List<Map<String, String>> keyValues = params.asMaps(String.class,
			// String.class);
//			 if(keyValues.get(0).containsKey(key)) {
//			 value = keyValues.get(0).get(key);
//			 }

////			String key="book";//array key (as it mentioned in your Json)
//			List<HashMap<String,Object>>qr=response.jsonPath().getList("content.queuedRequests");
//			//Now parse value from List
//			for(int i=0; i<qr.size(); i++) {
//				HashMap<String,Object> qali =qr.get(i);
//				for(int j=0; j<qali.size(); j++) {
//					String dest=(String)qali.get("destinations");
//					System.out.println(dest);
//				}
//			}

			for (String param : params.asList()) {
				System.out.println("Param ===" + param);
				System.out.println("op==========> " + jsonPath.getString(param));

				switch (param) {
				/*
				 * case "content.division": Assert.assertEquals(jsonPath.getString(param),
				 * save_ecm_req.getDivision()); break; case "content.producerName":
				 * Assert.assertEquals(jsonPath.getString(param),
				 * save_ecm_req.getProducerName()); break; case "content.slug":
				 * Assert.assertEquals(jsonPath.getString(param), save_ecm_req.getSlug());
				 * break; case "content.storyName":
				 * Assert.assertEquals(jsonPath.getString(param), save_ecm_req.getStoryName());
				 * break; case "content.queuedRequests.requestType": List<Map<String, String>>
				 * queued_requests_api = jsonPath.getList("content.queuedRequests"); Set<String>
				 * req_type_api = new HashSet<String>(); for (Map<String, String> map :
				 * queued_requests_api) { req_type_api.add(map.get("requestType")); }
				 * 
				 * Assert.assertTrue(req_type_api.containsAll(request_type_list));
				 * 
				 * break; case "content.queuedRequests[0].destinations[0]":
				 * Assert.assertEquals(jsonPath.getString(param),
				 * common.getDestinations().get(0)); break; case
				 * "Final.queuedRequests.IdTypeStatus":
				 * 
				 * for(int i=0; i<queued_requests_api1.size(); i++) { String reqTyp =
				 * queued_requests_api1.get(i).get("requestType").toString();
				 * System.out.println(reqTyp); String reqId =
				 * queued_requests_api1.get(i).get("requestId").toString();
				 * System.out.println(reqId);
				 * 
				 * Assert.assertEquals(jsonPath.getString("queuedRequestStatus["+i+"].requestId"
				 * ), reqId); Assert.assertEquals(jsonPath.getString("queuedRequestStatus["+i+
				 * "].requestType"), reqTyp);
				 * Assert.assertEquals(jsonPath.getString("queuedRequestStatus["+i+
				 * "].submissionStatus"), "Success");
				 * Assert.assertEquals(jsonPath.getString("queuedRequestStatus["+i+
				 * "].submissionStatusMessage"), "Request Processed Successfully");
				 * 
				 * }
				 * 
				 * break;
				 * 
				 */}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void validateFinalSubmitResponse() {

		JsonPath jsonPath = response.jsonPath();

		for (int i = 0; i < queued_requests_api1.size(); i++) {
			String reqTyp = queued_requests_api1.get(i).get("requestType").toString();
			System.out.println(reqTyp);
			String reqId = queued_requests_api1.get(i).get("requestId").toString();
			System.out.println(reqId);

			Assert.assertEquals(jsonPath.getString("queuedRequestStatus[" + i + "].requestId"), reqId);
			Assert.assertEquals(jsonPath.getString("queuedRequestStatus[" + i + "].requestType"), reqTyp);
			Assert.assertEquals(jsonPath.getString("queuedRequestStatus[" + i + "].submissionStatus"), "Success");
			Assert.assertEquals(jsonPath.getString("queuedRequestStatus[" + i + "].submissionStatusMessage"),
					"Request Processed Successfully");

		}
	}

	public void validateResponseAttribute(String serviceName) {

		switch (serviceName) {
		case "Save ECM Response":
			String root = "ecmRequestId,content";
			String content = "slug,storyName,storySlugID,division,airDate,airDateTBD,airTime,airTimeFlexible,requesters,isRequestorProducer,producerName,producerKey,seniorProducer,seniorProducerKey,correspondent,queuedRequests,ecmRequestId,requestComplete,requestorName,deleted,created,modified";
			String requesters = "displayName,thumbnailUrl,userId,jobTitle,ssoId,emailId,workPhone";
			String queuedRequests = "queuedRequests";

			for (String str : root.split(",")) {
				try {
					response.jsonPath().getString(str);
					System.out.println("Attribute inside Root: " + str + " present in reponse and its value is "
							+ response.jsonPath().getString(str));
					Assert.assertEquals(true, true, "Attribute : " + str + " present in reponse and its value is "
							+ response.jsonPath().getString(str));
				} catch (Exception e) {
					System.out.println("Attribute1 is not exist");
				}
			}

			for (String str : content.split(",")) {
				try {
					response.jsonPath().getString("content." + str);
					System.out.println("Attribute inside Content : " + str + " is present in reponse and its value is "
							+ response.jsonPath().getString("content." + str));
					Assert.assertEquals(true, true,
							"Attribute inside Content : " + str + " is present in reponse and its value is "
									+ response.jsonPath().getString("content." + str));

				} catch (Exception e) {
					System.out.println("Attribute2 is not exist");
				}
			}

			for (String str : requesters.split(",")) {
				try {
					response.jsonPath().getString("requesters." + str);
					System.out
							.println("Attribute inside Requesters : " + str + " is present in reponse and its value is "
									+ response.jsonPath().getString("content." + str));
					Assert.assertEquals(true, true,
							"Attribute inside Requesters : " + str + " is present in reponse and its value is "
									+ response.jsonPath().getString("content." + str));

				} catch (Exception e) {
					System.out.println("Attribute3 is not exist");
				}
			}

			for (String str : queuedRequests.split(",")) {
				try {
					response.jsonPath().getString("queuedRequests." + str);
					System.out.println(
							"Attribute inside QueuedRequests : " + str + " is present in reponse and its value is "
									+ response.jsonPath().getString("content." + str));
					Assert.assertEquals(true, true,
							"Attribute inside QueuedRequests : " + str + " is present in reponse and its value is "
									+ response.jsonPath().getString("content." + str));

				} catch (Exception e) {
					System.out.println("Attribute4 is not exist");
				}
			}
			break;
		}
	}

	/**
	 * 
	 * @throws IOException
	 */
	public void user_sets_up_base_uri() throws IOException {
		ConfigurationTest.readConfig();
		RestAssured.baseURI = ConfigurationTest.PRODUCER_DASHBOARD_BASE_URL;
		requestSpec = RestAssured.given();
		requestSpec.baseUri(ConfigurationTest.PRODUCER_DASHBOARD_BASE_URL);
		ReportGenerate.test.log(Status.INFO, "<b>Base URI : </b>" + ConfigurationTest.PRODUCER_DASHBOARD_BASE_URL);

	}

	public void user_set_up_headers(Map<String, String> header) {
		Map<String, String> headers = new HashMap<String, String>();

		headers.put("Content-Type", header.get("Content-Type"));
		headers.put("accept", "*/*");
		headers.put("Messageid", header.get("messageid"));
		headers.put("userId", header.get("userId"));
//		headers.put("Ncxjwttoken", ConfigurationTest.NCXJWT_TOKEN);
		headers.put("Ncxjwttoken", LoginPageSteps.NCXJWT_TOKEN);
		requestSpec = RestAssured.given().headers(headers);

		ReportGenerate.test.log(Status.INFO, "<b>NCX JWT Token : </b>" + LoginPageSteps.NCXJWT_TOKEN);
	}

	public void setADataAndInvokeService(String serviceName, String request_payload) throws IOException {

		if (null == request_payload || request_payload == "") {
			request_payload = requestPayload;
		}

		response = requestSpec.given().log().all().accept(ContentType.JSON).contentType("application/json").and()
				.body(request_payload).post(ConfigurationTest.getEndPoint(serviceName)).thenReturn();
		ReportGenerate.test.log(Status.PASS, "<b>Response : </b>" + response.asPrettyString());
	}

	/**
	 * 
	 * @param serviceName
	 * @param dataTable
	 * @throws IOException
	 */
	public void searchRequest(String serviceName, String request_payload) throws IOException {

		JsonObject jsonObject = new Gson().fromJson(request_payload, JsonObject.class);
		jsonObject.remove("search");

		jsonObject.addProperty("search", request_id);
		request_payload = jsonObject.toString();
		response = requestSpec.given().log().all().accept(ContentType.JSON).contentType("application/json").and()
				.body(request_payload).post(ConfigurationTest.getEndPoint(serviceName)).thenReturn();

	}

	/**
	 * 
	 * @param serviceName
	 * @param dataTable
	 * @throws IOException
	 */
	public void reviseRequest(String serviceName, String request_payload) throws IOException {

		response = requestSpec.given().log().all().accept(ContentType.JSON).contentType("application/json").and()
				.body(request_payload).put(ConfigurationTest.getEndPoint(serviceName)).thenReturn();
		JsonObject jsonObject = new Gson().fromJson(response.asString(), JsonObject.class);
		jsonObject.remove("crewRequestID");

		jsonObject.addProperty("crewRequestID", request_id);
	}

	/**
	 * Method to validate to response values
	 * 
	 * @param attribute
	 * @param reponse_path
	 */
	public void validate_the_response(String attribute, String reponse_path) {

		JsonPath jsonPath = response.jsonPath();
		Assert.assertEquals(jsonPath.getString(reponse_path), request_id);

	}

	@SuppressWarnings("deprecation")
	public void read_data_and_update_json(String scenario_name, String servicename) throws Exception {

		switch (servicename) {
		case "Create_Studio_Prod_Req":
			ReportGenerate.test.log(Status.INFO, "<b>Service Name : </b>"
					+ ConfigurationTest.PRODUCER_DASHBOARD_BASE_URL + ConfigurationTest.CREATE_STUDIO_PROD_REQ);
			ReportGenerate.test.log(Status.INFO, "<b>Scenario to be validated : </b>" + scenario_name);
			createStudioRequest = getDataForStudioProdRequest("Studio Production Request", servicename, scenario_name);
			break;
		case "CNBC Production Request":
			excelReader = new ExcelReader();
			Map<String, String> excel_data = excelReader.getData("CNBC Production Request", servicename, scenario_name);

			String json = new JsonParser()
					.parse(new FileReader(
							new File("").getAbsolutePath() + "\\src\\test\\resources\\json\\" + servicename + ".json"))
					.toString();

			Gson gson = new Gson();
			CreateCNBCRequest createNbcrequest = gson.fromJson(json, CreateCNBCRequest.class);

			createNbcrequest.setStudioType(excel_data.get("StudioType"));
			createNbcrequest.setSeniorProducer(excel_data.get("seniorProducer"));
			createNbcrequest.setRequesterEmail(excel_data.get("requestorEmail"));
			createNbcrequest.setDivision(excel_data.get("division"));
			requestPayload = gson.toJson(createNbcrequest);
			break;
		}

	}

	private ArrayList<Requester> createRequesterObject(Map<String, String> excel_data) {

		ArrayList<Requester> list = new ArrayList<Requester>();
		CreateStudioRequest studiore = new CreateStudioRequest();

		for (int i = 1; i <= 10; i++) {

			if (null != excel_data.get("Requestor" + i) && !excel_data.get("Requestor" + i).isEmpty()) {
				String[] reqList = excel_data.get("Requestor" + i).split("~");
				Requester req = studiore.new Requester();
				req.setDisplayName(reqList[0]);
				req.setEmailId(reqList[1]);
				req.setJobTitle(reqList[2]);
				req.setSsoId(Integer.parseInt(reqList[3]));
				req.setWorkPhone(null == reqList[4] ? "" : reqList[4]);
				list.add(req);
			}

		}

		return list;
	}

	private ArrayList<StudioLocation> createStudioLocation(Map<String, String> excel_data) {

		ArrayList<StudioLocation> list = new ArrayList<StudioLocation>();
		CreateStudioRequest studiore = new CreateStudioRequest();

		for (int i = 1; i <= 10; i++) {
			if (null != excel_data.get("SetLocation_Location" + i)
					&& !excel_data.get("SetLocation_Location" + i).isEmpty()) {
				String[] studioData = excel_data.get("SetLocation_Location" + i).split("~");
				StudioLocation studioLoc = studiore.new StudioLocation();
				studioLoc.setLocation(studioData[0]);
				studioLoc.setSetLocation(studioData[1]);
				studioLoc.setOtherSetLocation("");
				studioLoc.setSetBackground("");
				studioLoc.setOtherSetBackground("");
				studioLoc.setFieldAddress("");
				list.add(studioLoc);
			}
		}
		return list;
	}

	private ArrayList<StudioControlRoom> createStudioControlRoomLocation(Map<String, String> excel_data) {

		ArrayList<StudioControlRoom> list = new ArrayList<StudioControlRoom>();
		CreateStudioRequest studiore = new CreateStudioRequest();

		for (int i = 1; i <= 10; i++) {
			if (null != excel_data.get("ControlRoom_StudioControlRoomLocation" + i)
					&& !excel_data.get("ControlRoom_StudioControlRoomLocation" + i).isEmpty()) {
				String[] studioControlRommData = excel_data.get("ControlRoom_StudioControlRoomLocation" + i).split("~");
				StudioControlRoom studioControlRoomLoc = studiore.new StudioControlRoom();
				studioControlRoomLoc.setControlRoom(studioControlRommData[0]);
				studioControlRoomLoc.setSpecificControlRoom(studioControlRommData[1]);
				studioControlRoomLoc.setOtherControlRoom("");
				studioControlRoomLoc.setFieldAddress(studioControlRommData[2]);

				list.add(studioControlRoomLoc);
			}
		}
		return list;
	}

	public void fetch_request_id(String req_name) {

		JsonPath jsonPath = response.jsonPath();
		// System.out.println("RESPONSE............." + response.asPrettyString());
		request_id = jsonPath.getString(req_name);
		System.out.println("********************** Request id : " + request_id);
		ReportGenerate.test.log(Status.INFO, "Request Created! And the Request id is<b> " + request_id + "</b>");
	}

	private void validate_Division(JsonPath jsonPath, String res_Division, String req_Division) {
		String response_Division = res_Division;
		String request_Division = req_Division;
		try {
			Assert.assertEquals(response_Division, request_Division);
			ReportGenerate.test.pass("As expected <b>DIVISION : " + response_Division + "</b> is present in Response.");
		} catch (AssertionError e) {
			ReportGenerate.test
					.fail("Expected <b>REQUEST FOR is " + response_Division + "</b> but not present in Response !");
		}

	}

	public void validate_Requesters(JsonPath jsonPath, ArrayList<Requester> reqbody_Requestors) {
		
		
		List<Map<String, String>> response_requesters_list = jsonPath.getList("content.requesters");
		try {
			Assert.assertEquals(response_requesters_list.size(), reqbody_Requestors.size());
			ReportGenerate.test.pass("As expected <b>No of Requesters : " + response_requesters_list.size()
					+ "</b> is correct in Response.");
			for (Requester requester : reqbody_Requestors) {
				for (Map<String, String> req_map : response_requesters_list) {
					if (requester.getDisplayName().equals(req_map.get("displayName"))) {
						try {
							Assert.assertEquals(requester.getDisplayName(), req_map.get("displayName"));
							ReportGenerate.test.pass("As expected <b>DISPLAY NAME : " + req_map.get("displayName")
									+ "</b> is present in Response.");
						} catch (AssertionError e) {
							ReportGenerate.test.fail("Expected <b>DISPLAY NAME is " + req_map.get("displayName")
									+ "</b> but its not present in Response!");
						}
						try {
							Assert.assertEquals(requester.getEmailId(), req_map.get("emailId"));
							ReportGenerate.test.log(Status.PASS, "As expected <b>EMAIL ID : " + req_map.get("emailId")
									+ "</b> is present in Response.");
						} catch (AssertionError e) {
							ReportGenerate.test.fail("Expected <b>EMAIL ID is " + req_map.get("emailId")
									+ "</b> but its not present in Response!");
						}
						try {
							Assert.assertEquals(requester.jobTitle, req_map.get("jobTitle"));
							ReportGenerate.test.log(Status.PASS, "As expected <b>JOB TITLE : " + req_map.get("jobTitle")
									+ "</b> is present in Response.");
						} catch (AssertionError e) {
							ReportGenerate.test.fail("Expected <b>JOB TITLE is " + req_map.get("jobTitle")
									+ "</b> but its not present in Response!");
						}
						try {
							Assert.assertEquals(requester.ssoId, Integer.parseInt(req_map.get("ssoId")));
							ReportGenerate.test.log(Status.PASS, "As expected <b>SSO ID : "
									+ Integer.parseInt(req_map.get("ssoId")) + "</b> is present in Response.");
						} catch (AssertionError e) {
							ReportGenerate.test.fail("Expected <b>SSO ID is " + req_map.get("ssoId")
									+ "</b> but its not present in Response!");
						}
						try {
							Assert.assertEquals(requester.getWorkPhone(), req_map.get("workPhone"));
							ReportGenerate.test.log(Status.PASS, "As expected <b>WORK PHONE : "
									+ req_map.get("workPhone") + "</b> is present in Response.");
						} catch (AssertionError e) {
							ReportGenerate.test.fail("Expected <b>WORK PHONE is " + req_map.get("workPhone")
									+ "</b> but its not present in Response!");
						}
					}
				}
			}
		} catch (AssertionError e) {
			ReportGenerate.test.fail("Expected <b>No of Requesters is " + response_requesters_list.size()
					+ "</b> but Requesters count in response is not correct!");
		}

	}

	private void validate_Talents(JsonPath jsonPath, ArrayList<Talent> reqbody_Talent) {

		List<Map<String, String>> response_Talent_list = jsonPath.getList("content.talent");
		List<Map<String, String>> response_talent_list = response_Talent_list;
		ArrayList<Talent> reqbody_talent = reqbody_Talent;
		try {
			Assert.assertEquals(response_talent_list.size(), reqbody_talent.size());
			ReportGenerate.test.pass(
					"As expected <b>No of Talents : " + response_talent_list.size() + "</b> is correct in Response.");
			for (Talent talent : reqbody_talent) {
				for (Map<String, String> req_map : response_talent_list) {
					try {
						Assert.assertEquals(talent.getName(), req_map.get("name"));
						ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : " + req_map.get("name")
								+ "</b> is present in Response.");
						break;
					} catch (AssertionError e) {
						ReportGenerate.test.fail("Expected <b>TALANT NAME : " + talent.getName()
								+ "</b> but in Response showing " + req_map.get("name") + "!!");
					}
				}
			}
		} catch (AssertionError e) {
			ReportGenerate.test.fail("Expected <b>Total no of Talents are " + reqbody_talent.size()
					+ "</b> but in Response showing " + response_talent_list.size() + " !!");
		}
	}

	private void validate_ProductionPurposeNotes(JsonPath jsonPath, String request_ProductionPurpose_detailsAndNotes
			) {
		String response_ProductionPurpose_detailsAndNotes = jsonPath.get("content.detailsAndNotes");
		String response_productionPurpose_detailsAndNotes = response_ProductionPurpose_detailsAndNotes;
		String request_productionPurpose_detailsAndNotes = request_ProductionPurpose_detailsAndNotes;
		try {
			Assert.assertEquals(response_productionPurpose_detailsAndNotes, request_productionPurpose_detailsAndNotes);
			ReportGenerate.test.pass("As expected <b>PRODUCTION PURPOSE NOTES : "
					+ jsonPath.get("content.detailsAndNotes") + "</b> is present in Response.");
		} catch (AssertionError e) {
			ReportGenerate.test
					.fail("Expected <b>PRODUCTION PURPOSE NOTES is " + request_productionPurpose_detailsAndNotes
							+ "</b> but in Response showing " + response_productionPurpose_detailsAndNotes + " !!");
		}
	}

	private void validate_AirPlatform(JsonPath jsonPath, String request_AirPlatform) {
		
		String response_AirPlatform = jsonPath.get("content.airPlatform");
		String response_airPlatform = response_AirPlatform;
		String request_airPlatform = request_AirPlatform;
		try {
			Assert.assertEquals(response_airPlatform, request_airPlatform);
			ReportGenerate.test.pass("As expected <b>AIR PLATFORM : " + jsonPath.get("content.airPlatform")
					+ "</b> is present in Response.");
		} catch (AssertionError e) {
			ReportGenerate.test.fail("Expected <b>AIR PLATFORM is " + request_airPlatform
					+ "</b> but in Response showing " + response_airPlatform + " !!");
		}
	}

	private void validate_ShowUnit(ArrayList<Showunit> request_Shownit, JsonPath jsonPath) {
		
		List<Map<String, String>> response_Showunit = jsonPath.getList("content.showunit");
		ArrayList<Showunit> request_shownit = request_Shownit;
		List<Map<String, String>> response_showunit = response_Showunit;
		try {
			Assert.assertEquals(response_showunit.size(), request_shownit.size());
			ReportGenerate.test.pass("As expected <b>SHOW INFO</b> is present in Response.");
			for (Showunit showunit : request_shownit) {
				for (Map<String, String> respShowunit : response_showunit) {
					try {
						Assert.assertEquals(showunit.getShowunittitle(), respShowunit.get("showunittitle"));
						ReportGenerate.test.pass("As expected <b>SHOW UNIT TITLE : " + showunit.getShowunittitle()
								+ "</b> is present in Response.");
					} catch (AssertionError e) {
						ReportGenerate.test.fail("Expected <b>SHOW UNIT TITLE is " + showunit.getShowunittitle()
								+ "</b> but in Response showing " + respShowunit.get("showunittitle") + " !!");
					}
					try {
						Assert.assertEquals(showunit.getBudgetCode(), respShowunit.get("budgetCode"));
						ReportGenerate.test.pass("As expected <b>BUDGET CODE : " + respShowunit.get("budgetCode")
								+ "</b> is present in Response.");
					} catch (AssertionError e) {
						ReportGenerate.test.fail("Expected <b>BUDGET CODE is " + showunit.getBudgetCode()
								+ "</b> but in Response showing " + respShowunit.get("budgetCode") + " !!");
					}
				}
			}
		} catch (AssertionError e) {
			ReportGenerate.test.fail("Not as expected <b>SHOW UNIT </b> is not present in Response !!");
		}
	}

	private void validate_StudioLocation(ArrayList<StudioLocation> request_SetLocation_list,JsonPath jsonPath) {
		
		List<Map<String, String>> response_StudioLocation = jsonPath.getList("content.studioLocation");
		ArrayList<StudioLocation> request_setLocation_list = request_SetLocation_list;
		List<Map<String, String>> response_studioLocation = response_StudioLocation;
		try {
			Assert.assertEquals(request_setLocation_list.size(), response_studioLocation.size());
			ReportGenerate.test.pass("As expected <b>NO OF STUDIO LOCATIONS : " + response_studioLocation.size()
					+ "</b> is correct in Response.");

			boolean dcflag = false;
			boolean laflag = false;
			boolean rcflag = false;

			for (StudioLocation studioLoc : request_setLocation_list) {
				for (Map<String, String> respStudioLoc : response_studioLocation) {
//				String locAppend = null;
					if (dcflag == false && studioLoc.getLocation().equalsIgnoreCase("DC")
							&& (respStudioLoc.get("location")).equalsIgnoreCase("DC")) {
//					 locAppend = studioLoc.getLocation().toLowerCase() + "nc";
						try {
							Assert.assertEquals(studioLoc.getLocation(), (respStudioLoc.get("location")));
							ReportGenerate.test.pass("As expected <b>LOCATION : " + respStudioLoc.get("location")
									+ "</b> is present in Response.");
						} catch (AssertionError e) {
							ReportGenerate.test
									.fail("Not Expected!! Expeted <b>LOCATION </b> is " + studioLoc.getLocation()
											+ " but in Response showing " + (respStudioLoc.get("location")));
						}
						try {
							Assert.assertEquals(studioLoc.getSetLocation(), respStudioLoc.get("setLocation"));
							ReportGenerate.test.pass("As expected <b>SET LOCATION : " + respStudioLoc.get("setLocation")
									+ "</b> is present in Response.");
						} catch (AssertionError e) {
							ReportGenerate.test
									.fail("Not Expected!! Expeted <b>SET LOCATION </b> is " + studioLoc.getSetLocation()
											+ " but in Response showing " + respStudioLoc.get("setLocation"));
						}
						dcflag = true;
						break;
					} else if (laflag == false && studioLoc.getLocation().equalsIgnoreCase("LA")
							&& (respStudioLoc.get("location")).equalsIgnoreCase("LA")) {
//					locAppend = studioLoc.getLocation().toLowerCase() + "nc";
//					Assert.assertEquals(locAppend, respStudioLoc.get("location"));
						try {
							Assert.assertEquals(studioLoc.getLocation(), (respStudioLoc.get("location")));
							ReportGenerate.test.pass("As expected <b>LOCATION : " + respStudioLoc.get("location")
									+ "</b> is present in Response.");
						} catch (AssertionError e) {
							ReportGenerate.test
									.fail("Not Expected!! Expeted <b>LOCATION </b> is " + studioLoc.getLocation()
											+ " but in Response showing " + (respStudioLoc.get("location")));
						}
						try {
							Assert.assertEquals(studioLoc.getSetLocation(), respStudioLoc.get("setLocation"));
							ReportGenerate.test.pass("As expected <b>SET LOCATION : " + respStudioLoc.get("setLocation")
									+ "</b> is present in Response.");
						} catch (AssertionError e) {
							ReportGenerate.test
									.fail("Not Expected!! Expeted <b>SET LOCATION </b> is " + studioLoc.getSetLocation()
											+ " but in Response showing " + respStudioLoc.get("setLocation"));
						}
						laflag = true;
						break;
					} else if (rcflag == false && studioLoc.getLocation().equalsIgnoreCase("rockcentre")
							&& (respStudioLoc.get("location")).equalsIgnoreCase("rockcentre")) {
						try {
							Assert.assertEquals(studioLoc.getLocation(), respStudioLoc.get("location"));
							ReportGenerate.test.pass("As expected <b>LOCATION : " + respStudioLoc.get("location")
									+ "</b> is present in Response.");
						} catch (AssertionError e) {
							ReportGenerate.test
									.fail("Not Expected!! Expeted <b>LOCATION </b> is " + studioLoc.getSetLocation()
											+ " but in Response showing " + respStudioLoc.get("setLocation"));
						}
						try {
							Assert.assertEquals(studioLoc.getSetLocation(), respStudioLoc.get("setLocation"));
							ReportGenerate.test.pass("As expected <b>SET LOCATION : " + respStudioLoc.get("setLocation")
									+ "</b> is present in Response.");
						} catch (AssertionError e) {
							ReportGenerate.test
									.fail("Not Expected!! Expeted <b>SET LOCATION </b> is " + studioLoc.getSetLocation()
											+ " but in Response showing " + respStudioLoc.get("setLocation"));
						}
						rcflag = true;
						break;
					}
				}
			}
		} catch (AssertionError e) {
			ReportGenerate.test.fail("Expected <b>NO OF STUDIO LOCATIONS are " + request_setLocation_list.size()
					+ "</b> but count is not correct in Response. Actual count is " + response_studioLocation.size());
		}
	}

	public void validate_response(String reqType) {
		switch (reqType.toUpperCase()) {
		case "Create_Studio_Prod_Req" -> validate_Create_Studio_Prod_Response();
		case "Create_AnimalsOnPremises_Prod_Req" -> validate_Create_AnimalsOnPremises_Prod_Response();
		case "Create_CNBC_Prod_Req" -> validate_Create_CNBC_Prod_Response();
		case "Create_ExtendOrBridge_Prod_Req" -> validate_Create_ExtendOrBridge_Prod_Response();
		case "Create_Create_FirearmsOnPremises_Prod_Req" -> validate_Create_FirearmsOnPremises_Prod_Response();
		case "Create_Create_SCLS_Prod_Req" -> validate_Create_SCLS_Prod_Response();
		default -> ReportGenerate.test.fail("Request Type is not correct !!");
		}
	}

	public void validate_Create_AnimalsOnPremises_Prod_Response() {
	}

	public void validate_Create_CNBC_Prod_Response() {
	}

	public void validate_Create_ExtendOrBridge_Prod_Response() {
	}

	public void validate_Create_FirearmsOnPremises_Prod_Response() {
	}

	public void validate_Create_SCLS_Prod_Response() {
	}

	public void validate_Create_Studio_Prod_Response() {

		JsonPath jsonPath = response.jsonPath();

		validate_Division(jsonPath, jsonPath.getString("content.division"), createStudioRequest.getDivision());

		validate_Requesters(jsonPath, createStudioRequest.getRequesters());

		validate_Talents(jsonPath, createStudioRequest.getTalent());

		validate_RequestFor(jsonPath, createStudioRequest.getRequestFor());

		validate_ProductionPurposeNotes(jsonPath, createStudioRequest.getDetailsAndNotes());

		validate_AirPlatform(jsonPath, createStudioRequest.getAirPlatform());

		validate_ShowUnit(createStudioRequest.getShowunit(), jsonPath);

		validate_StudioLocation(createStudioRequest.getStudioLocation(), jsonPath);

		if (createStudioRequest.getCamJIB() != null) {
			ArrayList<String> request_jibList = createStudioRequest.getCamJIB();
			List<Map<String, String>> response_jiblist = jsonPath.getList("content.camJIB");
			Assert.assertEquals(request_jibList.size(), response_jiblist.size());
			ReportGenerate.test
					.pass("As expected <b>No of JIB : " + response_jiblist.size() + "</b> is correct in Response.");
		}

		if (createStudioRequest.getCamMerlin() != null) {
			ArrayList<String> request_merlinList = createStudioRequest.getCamMerlin();
			List<Map<String, String>> response_merlinlist = jsonPath.getList("content.camMerlin");
			Assert.assertEquals(request_merlinList.size(), response_merlinlist.size());
			ReportGenerate.test.pass(
					"As expected <b>No of MERLIN : " + response_merlinlist.size() + "</b> is correct in Response.");
		}

		ArrayList<StudioControlRoom> request_StudioControlRoom = createStudioRequest.getStudioControlRoom();
		List<Map<String, String>> response_StudioControlRoom = jsonPath.getList("content.studioControlRoom");
		Assert.assertEquals(request_StudioControlRoom.size(), response_StudioControlRoom.size());
		for (StudioControlRoom studioControlRoom : request_StudioControlRoom) {
			for (Map<String, String> respStudioControlRoom : response_StudioControlRoom) {

//				Assert.assertEquals(studioControlRoom.getControlRoom(), respStudioControlRoom.get("controlRoom"));
//				if (!respStudioControlRoom.get("controlRoom").equalsIgnoreCase("Field")) {
//					Assert.assertEquals(studioControlRoom.getSpecificControlRoom(),
//							respStudioControlRoom.get("specificControlRoom"));
//				} else {
//					Assert.assertEquals(studioControlRoom.getFieldAddress(), respStudioControlRoom.get("fieldAddress"));
//				}

				if (studioControlRoom.getControlRoom().equalsIgnoreCase("rockcentre")
						&& (respStudioControlRoom.get("controlRoom")).equalsIgnoreCase("rockcentre")) {
					Assert.assertEquals(studioControlRoom.getControlRoom(), respStudioControlRoom.get("controlRoom"));
//					ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
					Assert.assertEquals(studioControlRoom.getSpecificControlRoom(),
							respStudioControlRoom.get("specificControlRoom"));
//					ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
					break;
				} else if (studioControlRoom.getControlRoom().equalsIgnoreCase("DC")
						&& (respStudioControlRoom.get("controlRoom")).equalsIgnoreCase("DC")) {
					Assert.assertEquals(studioControlRoom.getControlRoom(), respStudioControlRoom.get("controlRoom"));
//					ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
					Assert.assertEquals(studioControlRoom.getSpecificControlRoom(),
							respStudioControlRoom.get("specificControlRoom"));
//					ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
					break;
				} else if (studioControlRoom.getControlRoom().equalsIgnoreCase("field")
						&& (respStudioControlRoom.get("controlRoom")).equalsIgnoreCase("Field")) {
					Assert.assertEquals(studioControlRoom.getControlRoom(), respStudioControlRoom.get("controlRoom"));
//					ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
					Assert.assertEquals(studioControlRoom.getFieldAddress(), respStudioControlRoom.get("fieldAddress"));
//					ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
					break;
				}
			}
		}

		if (createStudioRequest.getCaptureManager() != null) {
			String request_captureManager = createStudioRequest.getCaptureManager();
			String response_captureManager = jsonPath.get("content.captureManager");
			Assert.assertEquals(request_captureManager.toUpperCase(), response_captureManager.toUpperCase());
			ReportGenerate.test.pass("As expected <b>CAPTURE MANAGER : " + response_captureManager.toUpperCase()
					+ "</b> is present in Response.");
		}

		if (createStudioRequest.getA1() != null) {
			ArrayList<String> request_A1List = createStudioRequest.getA1();
			List<Map<String, String>> response_A1list = jsonPath.getList("content.a1");
			Assert.assertEquals(request_A1List.size(), response_A1list.size());
//			ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
		}

		if (createStudioRequest.getT2() != null) {
			ArrayList<String> request_T2List = createStudioRequest.getT2();
			List<Map<String, String>> response_T2list = jsonPath.getList("content.t2");
			Assert.assertEquals(request_T2List.size(), response_T2list.size());
//			ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
		}

		if (createStudioRequest.getMusicMix() != null) {
			ArrayList<String> request_MusicMixList = createStudioRequest.getMusicMix();
			List<Map<String, String>> response_MusicMixlist = jsonPath.getList("content.musicMix");
			Assert.assertEquals(request_MusicMixList.size(), response_MusicMixlist.size());
		}

		if (createStudioRequest.getRoboCam() != null) {
			ArrayList<String> request_RoboCamList = createStudioRequest.getRoboCam();
			List<Map<String, String>> response_RoboCamlist = jsonPath.getList("content.roboCam");
			Assert.assertEquals(request_RoboCamList.size(), response_RoboCamlist.size());
//			ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
		}

		if (createStudioRequest.getUltimatte() != null) {
			ArrayList<String> request_UltimatteList = createStudioRequest.getUltimatte();
			List<Map<String, String>> response_UltimatteList = jsonPath.getList("content.ultimatte");
			Assert.assertEquals(request_UltimatteList.size(), response_UltimatteList.size());
//			ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
		}
		if (createStudioRequest.getVap() != null) {
			ArrayList<String> request_vapList = createStudioRequest.getVap();
			List<Map<String, String>> response_vaplist = jsonPath.getList("content.vap");
			Assert.assertEquals(request_vapList.size(), response_vaplist.size());
//			ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
		}
		if (createStudioRequest.getSystemNotes() != null) {
			String request_systemNotes = createStudioRequest.getSystemNotes();
			String response_systemNotes = jsonPath.get("content.systemNotes");
			Assert.assertEquals(request_systemNotes, response_systemNotes);
//			ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
		}

		String request_isStagingNeeded = createStudioRequest.getIsStagingNeeded();
		String response_isStagingNeeded = jsonPath.get("content.isStagingNeeded");
		Assert.assertEquals(request_isStagingNeeded.toUpperCase(), response_isStagingNeeded.toUpperCase());
		ReportGenerate.test.log(Status.PASS, "As expected <b>STAGE NEEDED : " + response_isStagingNeeded.toUpperCase()
				+ "</b> is present in Response.");

		String request_isCarpentryNeeded = createStudioRequest.getIsCarpentryNeeded();
		String response_isCarpentryNeeded = jsonPath.get("content.isCarpentryNeeded");
		Assert.assertEquals(request_isCarpentryNeeded.toUpperCase(), response_isCarpentryNeeded.toUpperCase());
		ReportGenerate.test.log(Status.PASS, "As expected <b>CARPENTRY NEEDED : "
				+ response_isCarpentryNeeded.toUpperCase() + "</b> is present in Response.");

		String request_isLightingNeeded = createStudioRequest.getIsLightingNeeded();
		String response_isLightingNeeded = jsonPath.get("content.isLightingNeeded");
		Assert.assertEquals(request_isLightingNeeded.toUpperCase(), response_isLightingNeeded.toUpperCase());
		ReportGenerate.test.log(Status.PASS, "As expected <b>LIGHTING NEEDED : "
				+ response_isLightingNeeded.toUpperCase() + "</b> is present in Response.");

		String request_isPropsNeeded = createStudioRequest.getIsPropsNeeded();
		String response_isPropsNeeded = jsonPath.get("content.isStagingNeeded");
		Assert.assertEquals(request_isPropsNeeded.toUpperCase(), response_isPropsNeeded.toUpperCase());
		ReportGenerate.test.log(Status.PASS, "As expected <b>PROPS NEEDED : " + response_isPropsNeeded.toUpperCase()
				+ "</b> is present in Response.");

		validate_StagingNeedsDesc(createStudioRequest.getStagingNeedsDesc(), jsonPath);
		validate_TPMTMNeeded(createStudioRequest.getTpmOrTm(), jsonPath);
	}
	public void validate_response() {

		JsonPath jsonPath = response.jsonPath();

		validate_Division(jsonPath, jsonPath.getString("content.division"), createStudioRequest.getDivision());

		validate_Requesters(jsonPath, createStudioRequest.getRequesters());

		validate_Talents(jsonPath, createStudioRequest.getTalent());

		validate_RequestFor(jsonPath, createStudioRequest.getRequestFor());

		validate_ProductionPurposeNotes(jsonPath, createStudioRequest.getDetailsAndNotes());

		validate_AirPlatform(jsonPath, createStudioRequest.getAirPlatform());

		validate_ShowUnit(createStudioRequest.getShowunit(), jsonPath);

		validate_StudioLocation(createStudioRequest.getStudioLocation(),jsonPath);

		if (createStudioRequest.getCamJIB() != null) {
			ArrayList<String> request_jibList = createStudioRequest.getCamJIB();
			List<Map<String, String>> response_jiblist = jsonPath.getList("content.camJIB");
			Assert.assertEquals(request_jibList.size(), response_jiblist.size());
			ReportGenerate.test
					.pass("As expected <b>No of JIB : " + response_jiblist.size() + "</b> is correct in Response.");
		}

		if (createStudioRequest.getCamMerlin() != null) {
			ArrayList<String> request_merlinList = createStudioRequest.getCamMerlin();
			List<Map<String, String>> response_merlinlist = jsonPath.getList("content.camMerlin");
			Assert.assertEquals(request_merlinList.size(), response_merlinlist.size());
			ReportGenerate.test.pass(
					"As expected <b>No of MERLIN : " + response_merlinlist.size() + "</b> is correct in Response.");
		}

		ArrayList<StudioControlRoom> request_StudioControlRoom = createStudioRequest.getStudioControlRoom();
		List<Map<String, String>> response_StudioControlRoom = jsonPath.getList("content.studioControlRoom");
		Assert.assertEquals(request_StudioControlRoom.size(), response_StudioControlRoom.size());
		for (StudioControlRoom studioControlRoom : request_StudioControlRoom) {
			for (Map<String, String> respStudioControlRoom : response_StudioControlRoom) {

//				Assert.assertEquals(studioControlRoom.getControlRoom(), respStudioControlRoom.get("controlRoom"));
//				if (!respStudioControlRoom.get("controlRoom").equalsIgnoreCase("Field")) {
//					Assert.assertEquals(studioControlRoom.getSpecificControlRoom(),
//							respStudioControlRoom.get("specificControlRoom"));
//				} else {
//					Assert.assertEquals(studioControlRoom.getFieldAddress(), respStudioControlRoom.get("fieldAddress"));
//				}

				if (studioControlRoom.getControlRoom().equalsIgnoreCase("rockcentre")
						&& (respStudioControlRoom.get("controlRoom")).equalsIgnoreCase("rockcentre")) {
					Assert.assertEquals(studioControlRoom.getControlRoom(), respStudioControlRoom.get("controlRoom"));
//					ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
					Assert.assertEquals(studioControlRoom.getSpecificControlRoom(),
							respStudioControlRoom.get("specificControlRoom"));
//					ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
					break;
				} else if (studioControlRoom.getControlRoom().equalsIgnoreCase("DC")
						&& (respStudioControlRoom.get("controlRoom")).equalsIgnoreCase("DC")) {
					Assert.assertEquals(studioControlRoom.getControlRoom(), respStudioControlRoom.get("controlRoom"));
//					ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
					Assert.assertEquals(studioControlRoom.getSpecificControlRoom(),
							respStudioControlRoom.get("specificControlRoom"));
//					ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
					break;
				} else if (studioControlRoom.getControlRoom().equalsIgnoreCase("field")
						&& (respStudioControlRoom.get("controlRoom")).equalsIgnoreCase("Field")) {
					Assert.assertEquals(studioControlRoom.getControlRoom(), respStudioControlRoom.get("controlRoom"));
//					ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
					Assert.assertEquals(studioControlRoom.getFieldAddress(), respStudioControlRoom.get("fieldAddress"));
//					ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
					break;
				}
			}
		}

		if (createStudioRequest.getCaptureManager() != null) {
			String request_captureManager = createStudioRequest.getCaptureManager();
			String response_captureManager = jsonPath.get("content.captureManager");
			Assert.assertEquals(request_captureManager.toUpperCase(), response_captureManager.toUpperCase());
			ReportGenerate.test.pass("As expected <b>CAPTURE MANAGER : " + response_captureManager.toUpperCase()
					+ "</b> is present in Response.");
		}

		if (createStudioRequest.getA1() != null) {
			ArrayList<String> request_A1List = createStudioRequest.getA1();
			List<Map<String, String>> response_A1list = jsonPath.getList("content.a1");
			Assert.assertEquals(request_A1List.size(), response_A1list.size());
//			ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
		}

		if (createStudioRequest.getT2() != null) {
			ArrayList<String> request_T2List = createStudioRequest.getT2();
			List<Map<String, String>> response_T2list = jsonPath.getList("content.t2");
			Assert.assertEquals(request_T2List.size(), response_T2list.size());
//			ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
		}

		if (createStudioRequest.getMusicMix() != null) {
			ArrayList<String> request_MusicMixList = createStudioRequest.getMusicMix();
			List<Map<String, String>> response_MusicMixlist = jsonPath.getList("content.musicMix");
			Assert.assertEquals(request_MusicMixList.size(), response_MusicMixlist.size());
		}

		if (createStudioRequest.getRoboCam() != null) {
			ArrayList<String> request_RoboCamList = createStudioRequest.getRoboCam();
			List<Map<String, String>> response_RoboCamlist = jsonPath.getList("content.roboCam");
			Assert.assertEquals(request_RoboCamList.size(), response_RoboCamlist.size());
//			ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
		}

		if (createStudioRequest.getUltimatte() != null) {
			ArrayList<String> request_UltimatteList = createStudioRequest.getUltimatte();
			List<Map<String, String>> response_UltimatteList = jsonPath.getList("content.ultimatte");
			Assert.assertEquals(request_UltimatteList.size(), response_UltimatteList.size());
//			ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
		}
		if (createStudioRequest.getVap() != null) {
			ArrayList<String> request_vapList = createStudioRequest.getVap();
			List<Map<String, String>> response_vaplist = jsonPath.getList("content.vap");
			Assert.assertEquals(request_vapList.size(), response_vaplist.size());
//			ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
		}
		if (createStudioRequest.getSystemNotes() != null) {
			String request_systemNotes = createStudioRequest.getSystemNotes();
			String response_systemNotes = jsonPath.get("content.systemNotes");
			Assert.assertEquals(request_systemNotes, response_systemNotes);
//			ReportGenerate.test.log(Status.PASS, "As expected <b>TALENT NAMES(s) : "+req_map.get("name")+"</b> is present in Response.");
		}

		String request_isStagingNeeded = createStudioRequest.getIsStagingNeeded();
		String response_isStagingNeeded = jsonPath.get("content.isStagingNeeded");
		Assert.assertEquals(request_isStagingNeeded.toUpperCase(), response_isStagingNeeded.toUpperCase());
		ReportGenerate.test.log(Status.PASS, "As expected <b>STAGE NEEDED : " + response_isStagingNeeded.toUpperCase()
				+ "</b> is present in Response.");

		String request_isCarpentryNeeded = createStudioRequest.getIsCarpentryNeeded();
		String response_isCarpentryNeeded = jsonPath.get("content.isCarpentryNeeded");
		Assert.assertEquals(request_isCarpentryNeeded.toUpperCase(), response_isCarpentryNeeded.toUpperCase());
		ReportGenerate.test.log(Status.PASS, "As expected <b>CARPENTRY NEEDED : "
				+ response_isCarpentryNeeded.toUpperCase() + "</b> is present in Response.");

		String request_isLightingNeeded = createStudioRequest.getIsLightingNeeded();
		String response_isLightingNeeded = jsonPath.get("content.isLightingNeeded");
		Assert.assertEquals(request_isLightingNeeded.toUpperCase(), response_isLightingNeeded.toUpperCase());
		ReportGenerate.test.log(Status.PASS, "As expected <b>LIGHTING NEEDED : "
				+ response_isLightingNeeded.toUpperCase() + "</b> is present in Response.");

		String request_isPropsNeeded = createStudioRequest.getIsPropsNeeded();
		String response_isPropsNeeded = jsonPath.get("content.isStagingNeeded");
		Assert.assertEquals(request_isPropsNeeded.toUpperCase(), response_isPropsNeeded.toUpperCase());
		ReportGenerate.test.log(Status.PASS, "As expected <b>PROPS NEEDED : " + response_isPropsNeeded.toUpperCase()
				+ "</b> is present in Response.");

		validate_StagingNeedsDesc(createStudioRequest.getStagingNeedsDesc(), jsonPath);
		validate_TPMTMNeeded(createStudioRequest.getTpmOrTm(), jsonPath);
	}

	private void validate_StagingNeedsDesc(String request_StagingNeededDesc, JsonPath jsonPath) {
		if (createStudioRequest.getStagingNeedsDesc() != null) {
			String request_stagingNeededDesc = request_StagingNeededDesc;
			String response_stagingNeededDesc = jsonPath.get("content.stagingNeedsDesc");
			try {
				Assert.assertEquals(request_stagingNeededDesc, response_stagingNeededDesc);
				ReportGenerate.test.log(Status.PASS, "As expected <b>STAGING NEEDS DESC : " + response_stagingNeededDesc
						+ "</b> is present in Response.");
			} catch (AssertionError e) {
				ReportGenerate.test.fail("Not Expected!! Expected <b>STAGING NEED DESC is " + request_stagingNeededDesc
						+ "</b> but in Response " + response_stagingNeededDesc);
			}
		}
	}

	private void validate_TPMTMNeeded(String request_TPMTNeeded, JsonPath jsonPath) {
		String request_TPMTMNeeded = request_TPMTNeeded;
		String response_TPMTMNeeded = jsonPath.get("content.tpmOrTm");
		try {
			Assert.assertEquals(request_TPMTMNeeded, response_TPMTMNeeded);
			ReportGenerate.test.log(Status.PASS,
					"As expected <b>TPM/TM : " + response_TPMTMNeeded + "</b> is present in Response.");
		} catch (AssertionError e) {
			ReportGenerate.test.fail("Not Expected!! Expected <b>TPM/TM is " + request_TPMTMNeeded
					+ "</b> but in Response " + response_TPMTMNeeded);
		}
	}

	private void validate_RequestFor(JsonPath jsonPath,  String req_requestFor) {
		String response_requestFor = jsonPath.get("content.requestFor");
//		String response_requestFor = res_RequestFor;
		String request_requestFor = req_requestFor;
		try {
			Assert.assertEquals(response_requestFor, request_requestFor);
			ReportGenerate.test
					.pass("As expected <b>REQUEST FOR : " + request_requestFor + "</b> is present in Response.");
		} catch (AssertionError e) {
			ReportGenerate.test
					.fail("Expected <b>REQUEST FOR is " + request_requestFor + "</b> but not present in Response !");
		}

	}

	public ArrayList<Talent> createTalentsObject(String talents) {

		ArrayList<Talent> talentList = new ArrayList<Talent>();
		Talent tlnt = new CreateStudioRequest().new Talent();

		if (null != talents) {
			String talentArr[] = talents.split("~");
			for (int i = 0; i < talentArr.length; i++) {
				tlnt.setName(talentArr[i]);
				talentList.add(tlnt);
			}
		}
		return talentList;
	}

	public CreateStudioRequest getDataForStudioProdRequest(String excelName, String serviceName, String scenario_name)
			throws Exception, Exception {
		excelReader = new ExcelReader();
		Map<String, String> excel_data = excelReader.getData("Studio Production Request", serviceName, scenario_name);

		String json = new JsonParser()
				.parse(new FileReader(
						new File("").getAbsolutePath() + "\\src\\test\\resources\\json\\" + serviceName + ".json"))
				.toString();

		Gson gson = new Gson();

		CreateStudioRequest createRockCenterProdrequest = gson.fromJson(json, CreateStudioRequest.class);
		createRockCenterProdrequest.setDivision(excel_data.get("Division"));

		ArrayList<Requester> reqList = createRequesterObject(excel_data);
		createRockCenterProdrequest.setRequesters(reqList);

		ArrayList<Talent> talentList = createTalentsObject(excel_data.get("Talent List"));
		createRockCenterProdrequest.setTalent(talentList);

		createRockCenterProdrequest.setRequestFor(excel_data.get("ProductionPurpose_Request For"));
		createRockCenterProdrequest.setDetailsAndNotes(excel_data.get("ProductionPurpose_Notes"));
		createRockCenterProdrequest.setAirPlatform(excel_data.get("ShowInfo_AirPlatform"));

		ArrayList<Showunit> showUnitList = createShowUnits(excel_data);
		createRockCenterProdrequest.setShowunit(showUnitList);

		ArrayList<StudioLocation> setLocList = createStudioLocation(excel_data);
		createRockCenterProdrequest.setStudioLocation(setLocList);

		String crew = excel_data.get("SetCrew List");

		if (null != crew) {
			String[] crewArr = crew.split("~");
			for (int i = 0; i < crewArr.length; i++) {
				String[] cam = crewArr[i].split("-");
				if (cam[0].equals("JIB")) {
					createRockCenterProdrequest.setCamJIB(createEmptyStrings(Integer.parseInt(cam[1])));
				} else if (cam[0].equals("MERLIN")) {
					createRockCenterProdrequest.setCamMerlin(createEmptyStrings(Integer.parseInt(cam[1])));
				}
			}
		} else {
			createRockCenterProdrequest.setCamJIB(createEmptyStrings(0));
			createRockCenterProdrequest.setCamMerlin(createEmptyStrings(0));

		}
		ArrayList<StudioControlRoom> setStudioControlList = createStudioControlRoomLocation(excel_data);
		createRockCenterProdrequest.setStudioControlRoom(setStudioControlList);

		createRockCenterProdrequest.setCaptureManager((null == excel_data.get("ControlRoomCrew_CaptureManager")
				|| excel_data.get("ControlRoomCrew_CaptureManager").isEmpty()) ? ""
						: excel_data.get("ControlRoomCrew_CaptureManager").toLowerCase());

		String controlRoomcrew = excel_data.get("ControlRoomCrew List");
		if (null != controlRoomcrew) {
			String[] controlRoomcrewArr = controlRoomcrew.split("~");
			for (int i = 0; i < controlRoomcrewArr.length; i++) {
				String[] cam = controlRoomcrewArr[i].split("-");
				if (cam[0].equals("A1")) {
					createRockCenterProdrequest.setA1(createEmptyStrings(Integer.parseInt(cam[1])));
				} else if (cam[0].equals("T2")) {
					createRockCenterProdrequest.setT2(createEmptyStrings(Integer.parseInt(cam[1])));
				}
			}
		} else {
			createRockCenterProdrequest.setA1(createEmptyStrings(0));
			createRockCenterProdrequest.setT2(createEmptyStrings(0));

		}
		String additionalcrew = excel_data.get("AdditionalCrew List");
		if (null != additionalcrew) {
			String[] addcrewArr = additionalcrew.split("~");
			for (int i = 0; i < addcrewArr.length; i++) {
				String[] cam = addcrewArr[i].split("-");
				if (cam[0].equals("ROBO CAM")) {
					createRockCenterProdrequest.setRoboCam(createEmptyStrings(Integer.parseInt(cam[1])));
				} else if (cam[0].equals("MUSIC MIX")) {
					createRockCenterProdrequest.setMusicMix(createEmptyStrings(Integer.parseInt(cam[1])));
				} else if (cam[0].equals("PROMPTER OP")) {
					createRockCenterProdrequest.setTelePrompter(createEmptyStrings(Integer.parseInt(cam[1])));
				} else if (cam[0].equals("STUDIO MAINTENANCE")) {
					createRockCenterProdrequest.setStudioMaintenance(createEmptyStrings(Integer.parseInt(cam[1])));
				} else if (cam[0].equals("VIDEO/LD/ROBO CAM")) {
					createRockCenterProdrequest.setVideoLdRoboCam(createEmptyStrings(Integer.parseInt(cam[1])));
				} else if (cam[0].equals("VIDEO OP/ROBO CAM")) {
					createRockCenterProdrequest.setVideoOpRoboCam(createEmptyStrings(Integer.parseInt(cam[1])));
				} else if (cam[0].equals("VIDEO OP")) {
					createRockCenterProdrequest.setVideoOp(createEmptyStrings(Integer.parseInt(cam[1])));
				} else if (cam[0].equals("LIGHTING DIRECTOR")) {
					createRockCenterProdrequest.setLightingDirector(createEmptyStrings(Integer.parseInt(cam[1])));
				}
			}
		} else {
			createRockCenterProdrequest.setRoboCam(createEmptyStrings(0));
			createRockCenterProdrequest.setMusicMix(createEmptyStrings(0));
			createRockCenterProdrequest.setTelePrompter(createEmptyStrings(0));
			createRockCenterProdrequest.setStudioMaintenance(createEmptyStrings(0));
			createRockCenterProdrequest.setVideoLdRoboCam(createEmptyStrings(0));
			createRockCenterProdrequest.setVideoOpRoboCam(createEmptyStrings(0));
			createRockCenterProdrequest.setVideoOp(createEmptyStrings(0));
			createRockCenterProdrequest.setLightingDirector(createEmptyStrings(0));

		}

		createRockCenterProdrequest.setUltimatte(
				(null == excel_data.get("Systems_Ultimate") || excel_data.get("Systems_Ultimate").isEmpty())
						? createEmptyStrings(0)
						: createEmptyStrings(Integer.parseInt(excel_data.get("Systems_Ultimate"))));
		createRockCenterProdrequest
				.setVap((null == excel_data.get("Systems_VAP") || excel_data.get("Systems_VAP").isEmpty())
						? createEmptyStrings(0)
						: createEmptyStrings(Integer.parseInt(excel_data.get("Systems_VAP"))));
		createRockCenterProdrequest.setSystemNotes(excel_data.get("Systems_Notes"));
		createRockCenterProdrequest.setIsStagingNeeded(null == excel_data.get("Staging_IsStagingNeeded") ? ""
				: excel_data.get("Staging_IsStagingNeeded").toLowerCase());
		createRockCenterProdrequest.setIsLightingNeeded(null == excel_data.get("Staging_IsLightingNeeded") ? ""
				: excel_data.get("Staging_IsLightingNeeded").toLowerCase());
		createRockCenterProdrequest.setIsCarpentryNeeded(null == excel_data.get("Staging_IsCarpentaryNeeded") ? ""
				: excel_data.get("Staging_IsCarpentaryNeeded").toLowerCase());
		createRockCenterProdrequest.setIsPropsNeeded(null == excel_data.get("Staging_ArePropsNeeded") ? ""
				: excel_data.get("Staging_ArePropsNeeded").toLowerCase());

		createRockCenterProdrequest.setStagingNeedsDesc(excel_data.get("Staging_DescribeStagingNeedsNotes"));

		if (null != excel_data.get("TPM/PMInformation_TPM/TMNeeded")
				&& excel_data.get("TPM/PMInformation_TPM/TMNeeded").equalsIgnoreCase("YES")) {
			createRockCenterProdrequest.setTpmOrTm(excel_data.get("TPM/PMInformation_TPM/TMName"));
		} else {
			createRockCenterProdrequest.setTpmOrTm("");
		}

		requestPayload = gson.toJson(createRockCenterProdrequest);
		ReportGenerate.test.log(Status.INFO, "<b>Request Payload : </b>" + requestPayload.toString());
		return createRockCenterProdrequest;

	}

	private ArrayList<Showunit> createShowUnits(Map<String, String> excel_data) {

		String showunit = excel_data.get("ShowInfo_ShowUnitBudgetCode");
		String budgetCode = excel_data.get("ShowInfo_IsBudgetCodeAvailable");

		ArrayList<Showunit> showUnitList = new ArrayList<Showunit>();
		Showunit show_unit = new CreateStudioRequest().new Showunit();

		if (null != showunit) {
			String showUnitArr[] = showunit.split("~");
			show_unit.setShowunittitle(showUnitArr[0]);

			if (budgetCode.equals("NA")) {
				show_unit.setBudgetCode(showUnitArr[1]);
			} else {
				show_unit.setBudgetCode(budgetCode);
			}
			showUnitList.add(show_unit);
		}
		return showUnitList;
	}

	private ArrayList<String> createEmptyStrings(int count) {

		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			list.add("");
		}

		return list;
	}
}
