package pomSalesForce.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomSalesForce.base.BasePage;

public class PasswordResetPage extends BasePage {
	WebDriver driver;

	// constructor called when object of this class is created
	public PasswordResetPage(WebDriver driver) {
		super(driver); // we will use same driver all along
	}
	
	public String PasswordResetPageTitle (WebDriver driver){
		this.driver = driver;
		return driver.getTitle();
	}
}
