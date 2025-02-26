package nbcu.framework.utils.cucumber;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;

public class CucumberUtils {

	/**
	 * To get value from data table using key
	 * 
	 * @param param - Data Table
	 * @param key   - Data table key name
	 * @return - value of data table key
	 */
	public static String getValuesFromDataTable(DataTable params, String key) {
		String value = "";
		try {
			List<Map<String, String>> keyValues = params.asMaps(String.class, String.class);
			if(keyValues.get(0).containsKey(key))
				value = keyValues.get(0).get(key);
		} catch (Exception e) {

		}
		return value;
	}

	/**
	 * To get value from data table using key
	 * 
	 * @param param - Data Table
	 * @return - List
	 */
	public static List<Map<String, String>> getValuesFromDataTableAsList(DataTable params) {
		List<Map<String, String>> keyValues = null;
		try {
			keyValues = params.asMaps(String.class, String.class);

		} catch (Exception e) {

		}
		return keyValues;
	}

	/**
	 * To get value from data table using key
	 * 
	 * @param param - Data Table
	 * @param key   - Data table key name
	 * @return - value of data table key
	 */
	public static String getValueFromDataTable(DataTable params, String key) {
		String value = null;
		try {
			List<Map<String, String>> keyValues = params.asMaps(String.class, String.class);
			if(keyValues.get(0).containsKey(key)) {
				value = keyValues.get(0).get(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}
