package pomSalesForce.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.ClassLoaderUtils;

// >>> I needed LoginTests to extend it! but LoginTests already extends BaseAction so I included the method 
// getValuesFromPropertyFile() in the BaseAction.java class

//1.------------- Let's Use directly PROPERTIES File ------------

public class ReadPropertyFile {
	public static Map<String, String> getValuesFromPropertyFile() throws Exception {
	Map<String, String> mapWithKeyValue;
	mapWithKeyValue = new HashMap<>();	
    String curDir = System.getProperty("user.dir");
	FileInputStream fis = new FileInputStream(curDir+"/src/test/resources/testData.properties");
	Properties props =new Properties();
	
    // Load properties from the file
    props.load(fis);
    
    //I need to extract all the values of the file here to use them later
    
    String url = props.getProperty("url");
    String username = props.getProperty("userid");
    String password = props.getProperty("password");
    String invaliduserid=props.getProperty("invaliduserid");
    String invalidpassword= props.getProperty("invalidpassword");
    mapWithKeyValue.put("url", url);
    mapWithKeyValue.put("userid", username);
    mapWithKeyValue.put("password", password);
    mapWithKeyValue.put("invaliduserid", invaliduserid);
    mapWithKeyValue.put("invalidpassword", invalidpassword);
    return mapWithKeyValue;
    
}
}

/*2.----------------------------------------------------------------- ANOTHER WAY FOUND --- LET'S USE CONSTANTS TOO -------------
	
	
//Store value of Properties file in a Hash Map
//	public static void main(String[] args) throws IOException {
//	Map<String, String> asdkls = new HashMap<>();
//		
//		asdkls = ReadPropertyFile.getValuesFromPropertyFile();
//		
//	}
	
	//Store value of Properties file in a Hash Map
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
*/