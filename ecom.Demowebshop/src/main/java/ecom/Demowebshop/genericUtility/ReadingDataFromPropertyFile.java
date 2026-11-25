package ecom.Demowebshop.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadingDataFromPropertyFile {
	public String getDataFromProperty(String key) throws Exception {
		FileInputStream fis = new FileInputStream("./src/main/resources/CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
}
