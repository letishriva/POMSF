package pomSalesForce.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pomSalesForce.utility.LoginUtility;
import pomSalesForce.utility.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomSalesForce.base.BaseAction;
import pomSalesForce.base.BasePage;
import pomSalesForce.pages.login.ForgotPasswordPage;
import pomSalesForce.pages.login.LoginPage;
import pomSalesForce.pages.login.PasswordResetPage;
import pomSalesForce.pages.home.HomePage;

import java.util.Map;

import org.apache.logging.log4j.Logger;


public class LoginTests extends ReadPropertyFile {//extends BasePage{
	

	@Test
	public void tc1loginErrorMessage() throws Exception  {
	
//		logger.info("inside TC1 Login Error Message");
		Map<String, String> propFileKeyValue; // = mapWithKeyValue;
		propFileKeyValue = ReadPropertyFile.getValuesFromPropertyFile();
		
		WebDriver driver;		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(propFileKeyValue.get("url"));
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(propFileKeyValue.get("invaliduserid"));// we enter User@gmail.com
		loginpage.clearPassword();// we enter clear password 
		loginpage.clickLogin();
		Thread.sleep(4000);
		String expectedMessage = "Please enter your password.";// Expected: Error message "Please enter your password."
		String actualMessage = loginpage.getErrorMessage();
		if (actualMessage.equalsIgnoreCase(expectedMessage)) {
			System.out.println("Error Message displayed - script passed"); 
		} else {
			System.out.println("Error Message non displayed - script failed");
		}
	}
		
	@Test
	public void tc2loginToSalesForce() throws Exception  {
		Map<String, String> propFileKeyValue; // = mapWithKeyValue;
		propFileKeyValue = ReadPropertyFile.getValuesFromPropertyFile();
//		logger.info("inside TC2 Login To SalesForce");
		WebDriver driver;		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(propFileKeyValue.get("url"));
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(propFileKeyValue.get("userid"));
		loginpage.enterPassword(propFileKeyValue.get("password"));
		loginpage.clickLogin();
		Thread.sleep(4000);
		String expected = "Home Page ~ Salesforce - Developer Edition";
		HomePage homepage = new HomePage(driver);
		String actual = homepage.getHomePageTitle(driver);
		Assert.assertEquals(actual, expected, "login passed");
	}

	
	@Test
	public static void tc3checkRememberMe () throws Exception {
//		logger.info("inside TC3 Check RememberMe");
		Map<String, String> propFileKeyValue; // = mapWithKeyValue;
		propFileKeyValue = ReadPropertyFile.getValuesFromPropertyFile();
		WebDriver driver;		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(propFileKeyValue.get("url"));
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(propFileKeyValue.get("userid"));
		loginpage.enterPassword(propFileKeyValue.get("password"));
		loginpage.clickLogin();
		Thread.sleep(4000);
		String expected = "Home Page ~ Salesforce - Developer Edition";
		HomePage homepage = new HomePage(driver);
		String actual = homepage.getHomePageTitle(driver);
		Assert.assertEquals(actual, expected, "login passed");
		//----------
		homepage.clickUsernameDropdown();
		Thread.sleep(1000); 
		homepage.clicklogoutOptionDropdown();
		Thread.sleep(3000); 
		String expectedusername = propFileKeyValue.get("userid");// username should be displayed after logout - same as the one entered
		String actualusername = loginpage.getIDchecked();// we check again for the login username field that should match expected one / Id changed 
		System.out.println(actualusername);
		if (actualusername.equalsIgnoreCase(expectedusername)) {
			System.out.println("TC3 Remember Me script passed : Username not displayed after logout"); 
		} else {
			System.out.println("TC3 Remember Me script failed : Username not displayed after logout");
		}
		}
	
	@Test
	public static void tc4aForgotPassword() throws Throwable {
//		logger.info("inside TC4A Forgot Password");
		Map<String, String> propFileKeyValue; // = mapWithKeyValue;
		propFileKeyValue = ReadPropertyFile.getValuesFromPropertyFile();
		WebDriver driver;		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(propFileKeyValue.get("url"));
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickForgotPassword();
		String expectedForgotPage = "Forgot Your Password | Salesforce";
		String expectedResetPage = "Check Your Email | Salesforce";

		// Salesforce forgot password page is displayed
		ForgotPasswordPage forgotpasswordpage = new ForgotPasswordPage(driver);
		String actualForgotPage = forgotpasswordpage.getForgotPasswordPageTitle(driver);
		if (actualForgotPage.equalsIgnoreCase(expectedForgotPage)) {
			System.out.println("SalesForce forgot password page is displayed - PASS"); 
		} else {
			System.out.println("SalesForce forgot password page is NOT displayed - FAIL");
		}
		
		// provide username in forgot your password page - we enter correct username 
		forgotpasswordpage.enterUsername((propFileKeyValue.get("userid")));
		// click continue button
		forgotpasswordpage.clickContinueButton();
		Thread.sleep(2000); 
		
		PasswordResetPage passwordresetpage = new PasswordResetPage(driver);
		String actualResetPage = passwordresetpage.PasswordResetPageTitle(driver);
		if (actualResetPage.equalsIgnoreCase(expectedResetPage)) {
			System.out.println("Password reset message page is displayed - PASS"); 
		} else {
			System.out.println("Password reset message page is NOT displayed - FAIL");
		}
	}
	@Test
	public void tc4bForgotPassword() throws Exception  {
//		logger.info("inside TC4B Forgot Password");
		// we provive wrong username and password
		Map<String, String> propFileKeyValue; // = mapWithKeyValue;
		propFileKeyValue = ReadPropertyFile.getValuesFromPropertyFile();
		WebDriver driver;		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(propFileKeyValue.get("url"));
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(propFileKeyValue.get("invaliduserid"));// we enter incorrect username 
		loginpage.enterPassword(propFileKeyValue.get("invalidpassword"));// we enter incorrect password
		loginpage.clickLogin();
		Thread.sleep(4000);
		String expected = "Your login attempt has failed. The username or password may be incorrect, or your location or login time may be restricted. Please contact the administrator at your company for help";
		String actual = loginpage.getErrorMessage();
		if (actual.equalsIgnoreCase(expected)) {
			System.out.println("Login script passed"); 
		} else {
			System.out.println("expected message: " + expected);
			System.out.println("actual message: " + actual);
			System.out.println("Login script failed");
		}
	}
}

	
