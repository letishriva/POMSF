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
