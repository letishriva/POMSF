package pomSalesForce.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomSalesForce.base.BasePage;

public class ForgotPasswordPage extends BasePage {
	WebDriver driver;
	@FindBy (id = "un") WebElement username;
	@FindBy (id="continue") WebElement continueButton;
		
	// constructor called when object of this class is created
	public ForgotPasswordPage(WebDriver driver) {
		super(driver); // we will use same driver all along
	}
	
	public void enterUsername (String data) {
		username.sendKeys(data);
	}
	
	public WebDriver clickContinueButton () {
		continueButton.click();
		return driver; 
	}

	public String getForgotPasswordPageTitle (WebDriver driver){
		this.driver = driver;
		return driver.getTitle();
	}
	
	public void closeDriver () {
		driver.close();
	}
}

