package pomSalesForce.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.ClassLoaderUtils;

//Store value of Properties file in a Hash Map
public class ReadPropertyFile {
	
	
//	public static void main(String[] args) throws IOException {
//	Map<String, String> asdkls = new HashMap<>();
//		
//		asdkls = ReadPropertyFile.getValuesFromPropertyFile();
//		
//	}
	public static Map<String, String> mapWithKeyValue;
	
	
	public static Map<String, String> getValuesFromPropertyFile() throws IOException {
		//String abc = null;
		mapWithKeyValue = new HashMap<>();		
		Properties testDataProp = new Properties();
		FileInputStream TDfileInputStream = new FileInputStream(Constants.TESTDATA_PROPERTIES);	
//		FileInputStream TDfileInputStream = new FileInputStream("C:\\working\\eclipseworkspace\\POMSalesForce\\POMSalesForce\\src\\test\\resources\\testData.properties");		
		testDataProp.load(TDfileInputStream);
		testDataProp.forEach((k, v) -> mapWithKeyValue.put(k.toString(), v.toString()));
		//System.out.println(" value of UID is  - " + mapWithKeyValue.get("userid"));		
		return mapWithKeyValue;

		
		//https://www.w3schools.io/file/properties-read-write-java/
		//Set<String> keys = testDataProp.stringPropertyNames();
//		Set<Entry<Object, Object>> keys = testDataProp.entrySet();
//		
//		for(Object key : keys) {
//			
//			mapWithKeyValue.put();
//			
//			testDataProp.getProperty(key);
//		}
		
		
		//String userIDValue = testDataProp.getProperty("userid");
		//String passwordValue = testDataProp.getProperty("password");
		//System.out.println(" UID - " + userIDValue + " Pass - " + passwordValue);
		
		
		//return userIDValue;
		
	}

}


//ClassLoaderUtils.class().
//String url = getClass().getClassLoader().getResource("testData.properties").getPath();