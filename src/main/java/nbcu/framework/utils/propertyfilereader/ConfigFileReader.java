package nbcu.framework.utils.propertyfilereader;

import java.io.FileReader;
import java.util.Properties;

public class ConfigFileReader {

	/**
	 * To read the config.properties file and return value for given key
	 * 
	 * @param key - property key
	 * @return - property value
	 * @throws Exception
	 */
	public static String getProperty(String key) throws Exception {
		String propertyValue = "";
		try {
			FileReader reader = new FileReader("config.properties");
			Properties prop = new Properties();
			prop.load(reader);
			propertyValue = prop.getProperty(key);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return propertyValue;
	}

	/**
	 * To read the config.properties file and return value for given key
	 * 
	 * @param key
	 * @param configFilename
	 * @return
	 * @throws Exception
	 */
	public static String getProperty(String key,String configFilename) throws Exception {
		String propertyValue = "";
		try {
			FileReader reader = new FileReader(configFilename);
			Properties prop = new Properties();
			prop.load(reader);
			propertyValue = prop.getProperty(key);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return propertyValue;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(ConfigFileReader.getProperty("Selenium-Host"));
	}

}
