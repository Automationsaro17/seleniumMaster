package nbcu.automation.ui.pages.ncxUnifiedTool;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import nbcu.framework.utils.Other.ConfigurationTest;

public class StudioFormServices {

	public static Response response;
	int statusCode;
	public static String ecm_request_id;
	Set<String> request_type_list = new HashSet<String>();
	List<Map<String, String>> queued_requests_api1=null;


//	public void setADataAndInvokeService(String serviceName, Map<String, String> header) throws IOException {
//		ConfigurationTest.readConfig();
//
//		System.out.println("Service " + serviceName);
//		Map<String, String> headers = new HashMap<String, String>();
//		headers.put("Content-Type", header.get("Content-Type"));
//		headers.put("accept", "*/*");
//
//		RestAssured.baseURI = ConfigurationTest.ECM_BASE_URL;
//
//		switch (serviceName) {
//		case "Health Check":
//
//			response = RestAssured.given().contentType(header.get("Content-Type")).get(ConfigurationTest.HEALTH_CHECK)
//					.then().log().all().assertThat().extract().response();
//			break;
//		case "Save ECM Request":
//			String req_body = new JsonParser()
//					.parse(new FileReader(
//							new File("").getAbsolutePath() + "\\src\\test\\resources\\json\\saveECMRequest.json"))
//					.toString();
//
//			Gson gson = new Gson();
//			save_ecm_req = gson.fromJson(req_body, SaveECMRequest.class);
//			String req_body_json = gson.toJson(save_ecm_req, SaveECMRequest.class);
//			System.out.println(req_body_json);
//			headers.put("messageid", header.get("messageid"));
//			headers.put("ncxjwttoken", ConfigurationTest.NCXJWT_TOKEN);
//			RestAssured.baseURI = ConfigurationTest.ECM_BASE_URL;
//
//			response = given().log().all().headers(headers).accept(ContentType.JSON).contentType("application/json")
//					.and().body(req_body_json)
//					.post(ConfigurationTest.ECM_BASE_URL + ConfigurationTest.getEndPoint("saveECMRequest"))
//					.thenReturn();
//
//			System.out.println(
//					"url :" + ConfigurationTest.ECM_BASE_URL + ConfigurationTest.getEndPoint("saveECMRequest"));
//			System.out.println("Save ECM Response: \n" + response.asPrettyString());
//			JsonPath jsonPath = response.jsonPath();
//
//			System.out.println("ecm request id ============>   " + jsonPath.getString("ecmRequestId"));
//			ecm_request_id = jsonPath.getString("ecmRequestId");
//
//			break;
//
//		case "ECM Final Submit":
//			 queued_requests_api1 = response.jsonPath().getList("content.queuedRequests");
//			headers.put("messageid", header.get("messageid"));
//			headers.put("ncxjwttoken", ConfigurationTest.NCXJWT_TOKEN);
//			RestAssured.baseURI = ConfigurationTest.ECM_BASE_URL;
//
//			headers.put("messageid", header.get("messageid"));
//			headers.put("ncxjwttoken", ConfigurationTest.NCXJWT_TOKEN);
//
//			RestAssured.baseURI = ConfigurationTest.ECM_BASE_URL + ConfigurationTest.getEndPoint("finalSubmit");
//
//			JsonObject jsonObject = new JsonParser().parse(response.asPrettyString()).getAsJsonObject();
//			String final_submit_req_Body = jsonObject.getAsJsonObject("content").toString();
//
//			response = given().log().all().headers(headers).accept(ContentType.JSON).contentType("application/json")
//					.and().body(final_submit_req_Body)
//					.put(ConfigurationTest.ECM_BASE_URL + ConfigurationTest.getEndPoint("finalSubmit")).thenReturn();
//
//			System.out.println("url :" + ConfigurationTest.ECM_BASE_URL + ConfigurationTest.getEndPoint("finalSubmit"));
//			System.out.println("Final submission Response :\n" + response.asPrettyString());
//			
//			
//			break;
//
//		case "ECM Request By ID":
//			headers.put("messageid", header.get("messageid"));
//			headers.put("ncxjwttoken", ConfigurationTest.NCXJWT_TOKEN);
//			response = RestAssured.given().headers(headers).pathParam("ecmRequestId", ecm_request_id)
//					.get("/{ecmRequestId}").then().log().all().assertThat().extract().response();
//			break;
//		case "Update ECM Request":
//			String update_req_body = new JsonParser()
//					.parse(new FileReader(
//							new File("").getAbsolutePath() + "\\src\\test\\resources\\json\\updateECMRequest.json"))
//					.toString();
//
//			gson = new Gson();
//			UpdateECMRequest update_ecm_req = gson.fromJson(update_req_body, UpdateECMRequest.class);
//			update_ecm_req.setEcmRequestId("ECM202301111");
//
//			String uer_req_body_json = gson.toJson(update_ecm_req, UpdateECMRequest.class);
//			System.out.println(uer_req_body_json);
//			headers.put("messageid", header.get("messageid"));
//			headers.put("ncxjwttoken", ConfigurationTest.NCXJWT_TOKEN);
//			RestAssured.baseURI = ConfigurationTest.ECM_BASE_URL;
//
//			response = given().log().all().headers(headers).accept(ContentType.JSON).contentType("application/json")
//					.and().body(uer_req_body_json).post(ConfigurationTest.ECM_BASE_URL).thenReturn();
//			break;
//
//		case "Create FileIngest Request":
//			request_type_list.add("File Ingest");
//			String create_FileIngest_req_body = new JsonParser().parse(new FileReader(
//					new File("").getAbsolutePath() + "\\src\\test\\resources\\json\\createFileIngestRequest.json"))
//					.toString();
//
//			gson = new Gson();
//			common = gson.fromJson(create_FileIngest_req_body, CommonPojo.class);
//			System.out.println("id " + ecm_request_id);
//			common.setEcmRequestId(ecm_request_id);
//			String cFIRBodyString = gson.toJson(common, CommonPojo.class);
//			System.out.println("File ingest body:\n" + cFIRBodyString);
//			headers.put("messageid", header.get("messageid"));
//			headers.put("ncxjwttoken", ConfigurationTest.NCXJWT_TOKEN);
//			RestAssured.baseURI = ConfigurationTest.ECM_BASE_URL + ConfigurationTest.getEndPoint("fileIngestRequest");
//
//			response = given().log().all().headers(headers).accept(ContentType.JSON).contentType("application/json")
//					.and().body(cFIRBodyString)
//					.post(ConfigurationTest.ECM_BASE_URL + ConfigurationTest.getEndPoint("fileIngestRequest"))
//					.thenReturn();
//
//			System.out.println(
//					"url :" + ConfigurationTest.ECM_BASE_URL + ConfigurationTest.getEndPoint("fileIngestRequest"));
//			System.out.println("Create File Ingest Response :\n" + response.asPrettyString());
//			JsonPath jsp = response.jsonPath();
//
//			System.out.println("After file ingest ecm request id ============>   " + jsp.getString("ecmRequestId"));
//
//			break;
//		case "Create FeedOut Request":
//			request_type_list.add("Feed Out");
//			String create_FeedOut_req_body = new JsonParser()
//					.parse(new FileReader(
//							new File("").getAbsolutePath() + "\\src\\test\\resources\\json\\createFeedOutRequest.json"))
//					.toString();
//
//			gson = new Gson();
//			common = gson.fromJson(create_FeedOut_req_body, CommonPojo.class);
//			common.setEcmRequestId(ecm_request_id);
//			String cFORBodyString = gson.toJson(common, CommonPojo.class);
//			System.out.println("Feed outbody:\n" + cFORBodyString);
//
//			headers.put("messageid", header.get("messageid"));
//			headers.put("ncxjwttoken", ConfigurationTest.NCXJWT_TOKEN);
//			RestAssured.baseURI = ConfigurationTest.ECM_BASE_URL;
//
//			response = given().log().all().headers(headers).accept(ContentType.JSON).contentType("application/json")
//					.and().body(cFORBodyString)
//					.post(ConfigurationTest.ECM_BASE_URL + ConfigurationTest.getEndPoint("feedOutRequest"))
//					.thenReturn();
//
//			System.out.println(
//					"url :" + ConfigurationTest.ECM_BASE_URL + ConfigurationTest.getEndPoint("feedOutRequest"));
//			System.out.println("Create feedOutRequest Response :\n" + response.asPrettyString());
//			break;
//
//		case "Create Edit Request":
//			String createEditRequestStd = new JsonParser()
//					.parse(new FileReader(
//							new File("").getAbsolutePath() + "\\src\\test\\resources\\json\\createEditRequestStd.json"))
//					.toString();
//
//			gson = new Gson();
//			common = gson.fromJson(createEditRequestStd, CommonPojo.class);
//			common.setEcmRequestId(ecm_request_id);
//			String ersBodyString = gson.toJson(common, CommonPojo.class);
//
//			headers.put("messageid", header.get("messageid"));
//			headers.put("ncxjwttoken", ConfigurationTest.NCXJWT_TOKEN);
//			RestAssured.baseURI = ConfigurationTest.ECM_BASE_URL;
//
//			response = given().log().all().headers(headers).accept(ContentType.JSON).contentType("application/json")
//					.and().body(ersBodyString)
//					.post(ConfigurationTest.ECM_BASE_URL + ConfigurationTest.getEndPoint("editRequest")).thenReturn();
//
//			System.out.println("url :" + ConfigurationTest.ECM_BASE_URL + ConfigurationTest.getEndPoint("editRequest"));
//			System.out.println("Create edit Request Response :\n" + response.asPrettyString());
//
//			break;
//
//		case "Create MTD Request":
//			String createMTDRequest = new JsonParser()
//					.parse(new FileReader(
//							new File("").getAbsolutePath() + "\\src\\test\\resources\\json\\createMTDRequest.json"))
//					.toString();
//
//			gson = new Gson();
//			common = gson.fromJson(createMTDRequest, CommonPojo.class);
//			common.setEcmRequestId(ecm_request_id);
//			String mtdBodyString = gson.toJson(common, CommonPojo.class);
//
//			headers.put("messageid", header.get("messageid"));
//			headers.put("ncxjwttoken", ConfigurationTest.NCXJWT_TOKEN);
//			RestAssured.baseURI = ConfigurationTest.ECM_BASE_URL;
//
//			response = given().log().all().headers(headers).accept(ContentType.JSON).contentType("application/json")
//					.and().body(mtdBodyString)
//					.post(ConfigurationTest.ECM_BASE_URL + ConfigurationTest.getEndPoint("mtdRequest")).thenReturn();
//
//			System.out.println("url :" + ConfigurationTest.ECM_BASE_URL + ConfigurationTest.getEndPoint("mtdRequest"));
//			System.out.println("Create mtdRequest Response :\n" + response.asPrettyString());
//
//			break;
//		}
//
//	}

	private String createRequestBody() {
		String json = "";
		return "";
	}

	public void validateStatusCode(int statuscode) {
		try {
			Assert.assertEquals(response.getStatusCode(), statuscode);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateECMFinalSubmitResponse(Response response) {

//		Gson gson = new Gson();
//		ECMFinalRequestResponse final_res = gson.fromJson(response.getBody().asPrettyString(),
//				ECMFinalRequestResponse.class);
//		ecm_request_id = final_res.getEcmRequestId();
	}

//	public void verifyTheResults(DataTable params) {
//
//		String value = "";
//		try {
//
//			JsonPath jsonPath = response.jsonPath();
//
//
// 			for (String param : params.asList()) {
//				System.out.println("Param ===" + param);
//				System.out.println("op==========> " + jsonPath.getString(param));
//
//				switch (param) {
//				case "content.division":
//					Assert.assertEquals(jsonPath.getString(param), save_ecm_req.getDivision());
//					break;
//				case "content.producerName":
//					Assert.assertEquals(jsonPath.getString(param), save_ecm_req.getProducerName());
//					break;
//				case "content.slug":
//					Assert.assertEquals(jsonPath.getString(param), save_ecm_req.getSlug());
//					break;
//				case "content.storyName":
//					Assert.assertEquals(jsonPath.getString(param), save_ecm_req.getStoryName());
//					break;
//				case "content.queuedRequests.requestType":
//					List<Map<String, String>> queued_requests_api = jsonPath.getList("content.queuedRequests");
//					Set<String> req_type_api = new HashSet<String>();
//					for (Map<String, String> map : queued_requests_api) {
//						req_type_api.add(map.get("requestType"));
//					}
//
//					Assert.assertTrue(req_type_api.containsAll(request_type_list));
//
//					break;
//				case "content.queuedRequests[0].destinations[0]":
//					Assert.assertEquals(jsonPath.getString(param), common.getDestinations().get(0));
//					break;
//				case "Final.queuedRequests.IdTypeStatus":
//					
//					for(int i=0; i<queued_requests_api1.size(); i++) {
//						String reqTyp = queued_requests_api1.get(i).get("requestType").toString();
//						System.out.println(reqTyp);
//						String reqId = queued_requests_api1.get(i).get("requestId").toString();
//						System.out.println(reqId);
//						
//						Assert.assertEquals(jsonPath.getString("queuedRequestStatus["+i+"].requestId"), reqId);
//						Assert.assertEquals(jsonPath.getString("queuedRequestStatus["+i+"].requestType"), reqTyp);
//						Assert.assertEquals(jsonPath.getString("queuedRequestStatus["+i+"].submissionStatus"), "Success");
//						Assert.assertEquals(jsonPath.getString("queuedRequestStatus["+i+"].submissionStatusMessage"), "Request Processed Successfully");
//						
//					}
//
//					break;
//
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	public void validateFinalSubmitResponse() {

		JsonPath jsonPath = response.jsonPath();
		
		for(int i=0; i<queued_requests_api1.size(); i++) {
			String reqTyp = queued_requests_api1.get(i).get("requestType").toString();
			System.out.println(reqTyp);
			String reqId = queued_requests_api1.get(i).get("requestId").toString();
			System.out.println(reqId);
			
			Assert.assertEquals(jsonPath.getString("queuedRequestStatus["+i+"].requestId"), reqId);
			Assert.assertEquals(jsonPath.getString("queuedRequestStatus["+i+"].requestType"), reqTyp);
			Assert.assertEquals(jsonPath.getString("queuedRequestStatus["+i+"].submissionStatus"), "Success");
			Assert.assertEquals(jsonPath.getString("queuedRequestStatus["+i+"].submissionStatusMessage"), "Request Processed Successfully");
			
		}
	}

	public void validateResponseAttribute(String serviceName) {

		switch (serviceName) {
		case "Save ECM Response":
			String root ="ecmRequestId,content";
			String content = "slug,storyName,storySlugID,division,airDate,airDateTBD,airTime,airTimeFlexible,requesters,isRequestorProducer,producerName,producerKey,seniorProducer,seniorProducerKey,correspondent,queuedRequests,ecmRequestId,requestComplete,requestorName,deleted,created,modified";
			String requesters = "displayName,thumbnailUrl,userId,jobTitle,ssoId,emailId,workPhone";
			String queuedRequests = "queuedRequests";
			
			for(String str : root.split(",")) {
				try {
					response.jsonPath().getString(str);
					System.out.println("Attribute inside Root: "+str+" present in reponse and its value is "+response.jsonPath().getString(str));
					Assert.assertEquals(true,true,"Attribute : "+str+" present in reponse and its value is "+response.jsonPath().getString(str));
				}catch(Exception e) {
					System.out.println("Attribute1 is not exist");
				}
			}
			
			for(String str : content.split(",")) {
				try {
					response.jsonPath().getString("content."+str);
					System.out.println("Attribute inside Content : "+str+" is present in reponse and its value is "+response.jsonPath().getString("content."+str));
					Assert.assertEquals(true,true,"Attribute inside Content : "+str+" is present in reponse and its value is "+response.jsonPath().getString("content."+str));
				
				}catch(Exception e) {
					System.out.println("Attribute2 is not exist");
				}
			}
			
			for(String str : requesters.split(",")) {
				try {
					response.jsonPath().getString("requesters."+str);
					System.out.println("Attribute inside Requesters : "+str+" is present in reponse and its value is "+response.jsonPath().getString("content."+str));
					Assert.assertEquals(true,true,"Attribute inside Requesters : "+str+" is present in reponse and its value is "+response.jsonPath().getString("content."+str));
				
				}catch(Exception e) {
					System.out.println("Attribute3 is not exist");
				}
			}
			
			for(String str : queuedRequests.split(",")) {
				try {
					response.jsonPath().getString("queuedRequests."+str);
					System.out.println("Attribute inside QueuedRequests : "+str+" is present in reponse and its value is "+response.jsonPath().getString("content."+str));
					Assert.assertEquals(true,true,"Attribute inside QueuedRequests : "+str+" is present in reponse and its value is "+response.jsonPath().getString("content."+str));
				
				}catch(Exception e) {
					System.out.println("Attribute4 is not exist");
				}
			}
			break;
		}
	}
}
