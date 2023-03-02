package pomSalesForce.base;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pomSalesForce.utility.Constants;
import pomSalesForce.utility.ExtentReportsUtility;

public class BasePage {
	protected static Logger logger;
	protected static ExtentReportsUtility extentreport;
	WebDriver driver;//the one we will use all along
	
	public BasePage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);

	}
	public static String getPageTitle(WebDriver driver) {
		String pageTitle;
		pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	
	public static String getScreenShotOfThePage(WebDriver driver) throws Exception  {
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //Code to take screen shot
		File pathOfScreenShotFile = new File(Constants.SCREENSHOTS_DIRECTORY_PATH + System.currentTimeMillis()+ ".png");	// Code to get File and File path of screen shot	
		FileUtils.copyFile(screenshot, pathOfScreenShotFile); // Copies a file to a new location preserving the file date	
		String ssFilePath = pathOfScreenShotFile.getPath();//we get the path of the screenshot to return it in our ExtentReport		
		System.out.println("Screen shot file path :- " + ssFilePath);
		return ssFilePath;//we get the path of the screenshot to return it in our ExtentReport
	}
	
}


