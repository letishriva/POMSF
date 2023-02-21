package pomSalesForce.base;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.awt.dnd.DragGestureEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomSalesForce.utility.*;


public class BaseAction {
	protected static Logger logger;
	protected static ExtentReportsUtility extentreport;
	protected static WebDriver driver;

	@BeforeTest
	public void setUpBeforeTest() {
        System.out.println("Base Action class - Before Test called - Test is starting");
        System.out.println("Class name " + BaseAction.class.getName());
        logger = LogManager.getLogger(BaseAction.class.getName()); //log4j
        logger.info("test started"); //log4j
        extentreport = new ExtentReportsUtility();
        extentreport.startExtentReport();
 	}
	
	@BeforeMethod
	public void setUpBeforeMethod(Method method) {
        logger = LogManager.getLogger(BaseAction.class.getName());
        logger.info("method started");
        extentreport.startSingleTestReport("Single Test Report " + logger.getName());
        driver = getWebDriver(Constants.useWebDriver);
        driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
	
	@AfterTest 
	public void endReportAfterTest() {
		System.out.println("Base Action class - After Test called - Test is finished");
		extentreport.endReport();
	}


	public WebDriver getWebDriver(String browserName) {
		WebDriver lDriver; //Local within method
		System.out.println("Driver is defined in BaseAction Class");
		switch(browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			lDriver = new ChromeDriver();
			return lDriver;			
		case "firefox":
			WebDriverManager.firefoxdriver().setup(); 
			lDriver = new FirefoxDriver();
			return lDriver;
		case "edge":
			WebDriverManager.edgedriver().setup();
			lDriver =  new EdgeDriver();	 
			return lDriver;
		default:
			WebDriverManager.chromedriver().setup();
			lDriver = new ChromeDriver();
			return lDriver;
		}
	}
	
	public void setMaxWindowBrowser(WebDriver dr) {		  
		dr.manage().window().maximize();
	}

	public  void closeBrowser(WebDriver dr) {
		dr.close();
	}

	public static String getScreenShotOfThePage() throws Exception  {
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //Code to take screen shot
		File pathOfScreenShotFile = new File(Constants.SCREENSHOTS_DIRECTORY_PATH + System.currentTimeMillis()+ ".png");	// Code to get File and File path of screen shot	
		FileUtils.copyFile(screenshot, pathOfScreenShotFile); // Copies a file to a new location preserving the file date	
		String ssFilePath = pathOfScreenShotFile.getPath();//we get the path of the screenshot to return it in our ExtentReport		
		System.out.println("Screen shot file path :- " + ssFilePath);
		return ssFilePath;//we get the path of the screenshot to return it in our ExtentReport
	}
	
}

