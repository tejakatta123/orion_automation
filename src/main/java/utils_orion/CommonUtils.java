package utils_orion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class CommonUtils {

	
	public static Properties loadProperties() throws Exception {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				Constants.PROPERTIES_FILE_PATH);
		prop.load(file);
		
		
		return prop;
	}
	
	
	
}
