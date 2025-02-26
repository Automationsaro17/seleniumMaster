package nbcu.framework.utils.propertyfilereader;

import java.io.FileReader;
import java.util.Properties;

public class AllurePropertiesReader {

	/**
	 * To read the allure.properties file and return value for given key
	 * 
	 * @param key - property key
	 * @return - property value
	 * @throws Exception
	 */
	public static String getProperty(String key) throws Exception {
		String propertyValue = "";
		try {
			FileReader reader = new FileReader("src/test/resources/allure.properties");
			Properties prop = new Properties();
			prop.load(reader);
			propertyValue = prop.getProperty(key);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return propertyValue;
	}

}
