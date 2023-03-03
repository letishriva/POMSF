package pomSalesForce.utility;
import org.openqa.selenium.WebDriver;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import pomSalesForce.base.BaseAction;


public class testNGListenersSF extends BaseAction implements ITestListener {
	protected static ExtentReportsUtility extentreport=null;
	
	  public testNGListenersSF() {//
		    super(); // we will call the constructor for BaseAction
		  }//
	
//	protected static WebDriver driver;
	
	@Override
	public void onTestStart(ITestResult Result) {
	System.out.println(Result.getTestClass()+" Test Case started");	
	System.out.println(Result.getName()+" Method started");	
	IClass classInfo =  Result.getTestClass();
	extentreport.startSingleTestReport(classInfo.toString());

	}
	
    // When Test case get failed, this method is called.		
    @Override		
    public void onTestFailure(ITestResult Result) 					
    {	
	    extentreport.logTestFailed("from testNGListenersSF : Test Case Failed " +Result.getTestClass());// in extent report, we print the name of the test failed
	    System.out.println("The name of the Method failed is :"+Result.getName());
	    System.out.println("The name of the Test Case failed is :"+Result.getTestClass());	
	    	    
	    String path;
	    
		try {
			path = BaseAction.getScreenShotOfThePage(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			path = null;
			e.printStackTrace();			
		}// path = path of the screenshot taken
		
	    extentreport.logTestScreenshot(path);
    }		

    // When Test case get Skipped, this method is called.		
    @Override		
    public void onTestSkipped(ITestResult Result)					
    {	
    System.out.println("The name of the Method skipped is :"+Result.getName());
    System.out.println("The name of the Test Case skipped is :"+Result.getTestClass());	
    }		

    // When Test case get passed, this method is called.		
    @Override		
    public void onTestSuccess(ITestResult Result)					
    {
    extentreport.logTestpassed("from testNGListenersSF : Test Case PASSED " +Result.getTestClass());
    System.out.println("The name of the Method passed is :"+Result.getName());		
    System.out.println("The name of the Test Case passed is :"+Result.getTestClass());	
    }
    
    @Override		
    public void onStart(ITestContext Context)					
    {		
    extentreport=new ExtentReportsUtility();
    extentreport.startExtentReport();
				
    }	

    @Override		
    public void onFinish(ITestContext Context)					
    {		
      extentreport.endReport();
				
    }	
}