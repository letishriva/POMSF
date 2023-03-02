package pomSalesForce.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginUtility {
	
//I want to make Login as a reusable method. It requires a driver, URL, User ID and Password
	
	public void loginToSalesForce(WebDriver dr) throws InterruptedException {
				
		System.out.println("Entered class LoginUtility");
		dr.get("https://login.salesforce.com/");
		Thread.sleep(2000);		
		dr.findElement(By.id("username")).sendKeys("leti@isreal.com"); 
		dr.findElement(By.id("password")).sendKeys("testtest123"); 
		dr.findElement(By.id("Login")).click();
	}
	

//I want to create another method because I want to implement test NG with parameters and it requires values from my XML file (testngparameters.xml)
	public void loginToSalesForce(WebDriver dr, String webURL, String userID, String userPass) throws InterruptedException {		
		System.out.println("Entered class LoginUtility with 4 arguments");
		dr.get(webURL);
		Thread.sleep(2000);		
		dr.findElement(By.id("username")).sendKeys(userID); 
		dr.findElement(By.id("password")).sendKeys(userPass); 
		dr.findElement(By.id("Login")).click();
	}
}

/*

package com.firebase.test.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class CommonUtilities {
	
	public FileInputStream stream=null;
	
	public Properties loadFile(String filename){
		Properties propertyFile = new Properties();
		String  PropertyFilePath=null;
		switch(filename) {
		case "applicationProperties":
			PropertyFilePath =Constants.APPLICATION_PROPERTIES_PATH;
							break;
		case "studentRegistrationProperties":
			PropertyFilePath =Constants.STUDENT_REGISTRATION_PROPERTIES_PATH;
							break;
		}
		try {
			stream=new FileInputStream(PropertyFilePath);
			propertyFile.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propertyFile;
	}
	
	public String getApplicationProperty(String Key,Properties propertyFile) {
		String value = propertyFile.getProperty(Key);
		System.out.println("Property we got from the file is::" + value);
		try {
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public HashMap getAllPropertiesAsSet(Properties propertyFile) {
		
		return new HashMap(propertyFile);
	}

}












*/