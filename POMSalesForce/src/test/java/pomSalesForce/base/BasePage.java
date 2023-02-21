package pomSalesForce.base;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
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
	
@BeforeMethod
	public void setUpBeforeMethod(Method method) {
        logger = LogManager.getLogger(BaseAction.class.getName());
        logger.info("method started");
        extentreport.startSingleTestReport("Single Test Report " + logger.getName());
        driver.manage().window().maximize();
}

@AfterMethod
public void closeDriver() {
	driver.close();
}
}