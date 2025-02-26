package nbcu.framework.utils.Other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ConfigurationTest {

	public static String PRODUCER_DASHBOARD_BASE_URL = "";
	public static String HEALTH_CHECK = "";
	public static String EMC_REQUEST = "";
	public static String NCXJWT_TOKEN = "";
	public static String SAVE_ECM_REQ = "";
	public static String CREATE_STUDIO_PROD_REQ ="";

	public static String readConfig() throws IOException {
		File configFile = new File(new File("").getAbsolutePath() + "\\config.properties");
		System.out.println("Location print " + new File("").getAbsolutePath() + "\\\\config.properties");

		//File jsonTxts = new File(new File("").getAbsolutePath() + "\\src\\test\\resources\\json\\saveECMRequest.json");
//		System.out.println("Location print "+jsonTxts.);
		//BufferedReader br = new BufferedReader(new FileReader(jsonTxts));
		//String st;
		//while ((st = br.readLine()) != null) {
		//	System.out.println(br.toString());
		//}
		InputStream inputStream = new FileInputStream(configFile);
		Properties props = new Properties();

		props.load(inputStream);
		PRODUCER_DASHBOARD_BASE_URL = props.getProperty("producer_dashboard_base_url");
		HEALTH_CHECK = props.getProperty("health_check");
		NCXJWT_TOKEN = props.getProperty("ncxjwttoken");
		CREATE_STUDIO_PROD_REQ=props.getProperty("Create_Studio_Prod_Req");
		//EC = props.getProperty("ecmrequest");
		
		inputStream.close();
		return props.getProperty("producer_dashboard_base_url");

	}
	
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		 Object o = new JsonParser().parse(new FileReader(new File("").getAbsolutePath() + "\\src\\test\\resources\\json\\saveECMRequest.json"));

         System.out.println(o.toString());
         
         Gson gson = new Gson();
        // SaveECMRequest scm =  gson.fromJson(o.toString(), SaveECMRequest.class);
         

	}
	
	public static String getEndPoint(String endpoint) throws IOException {
		String endpointURL=null;
		File configFile = new File(new File("").getAbsolutePath() + "\\config.properties");
		System.out.println("Location print " + new File("").getAbsolutePath() + "\\\\config.properties");
		InputStream inputStream = new FileInputStream(configFile);
		Properties props = new Properties();

		props.load(inputStream);
		switch(endpoint) {
		case "saveECMRequest":
			endpointURL = props.getProperty("saveECMRequest");
			break;
		case "fileIngestRequest":
			endpointURL = props.getProperty("fileIngestRequest");
			break;	
		case "feedOutRequest":
			endpointURL = props.getProperty("feedOutRequest");
			break;
		case "editRequest":
			endpointURL = props.getProperty("editRequest");
			break;
		case "finalSubmit":
			endpointURL = props.getProperty("finalSubmit");
			break;	
		case "mtdRequest":
			endpointURL = props.getProperty("mtdRequest");
			break;
		case "Create_NBC_Crew_Request":
			endpointURL = props.getProperty("Create_NBC_Crew_Request");
			break;
		case "Update_NBC_Crew_Request":
			endpointURL = props.getProperty("Update_NBC_Crew_Request");
			break;
		case "Common_Search_Request":
			endpointURL = props.getProperty("Common_Search_Request");
			break;
		case "Create_CNBC_Production_Request":
			endpointURL = props.getProperty("Create_CNBC_Production_Request");
			break;
		case "Create_RockCenter_Prod_Req":
			endpointURL = props.getProperty("Create_Studio_Prod_Req");
			break;
			
		}
		
		inputStream.close();
		return endpointURL;

	}
}
