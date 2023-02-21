package pomSalesForce.pages.login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomSalesForce.base.BasePage;


public class LoginPage extends BasePage{
	WebDriver driver;
	@FindBy (id = "username") WebElement username;
	@FindBy (id = "password") WebElement password;
	@FindBy (id = "Login") WebElement loginButton;
	@FindBy (id= "idcard-identity") WebElement userID;
	@FindBy (id="forgot_password_link") WebElement forgotPassword;
	@FindBy (id="error") WebElement errorMessage;
	
	
	// constructor called when object of this class is created
	public LoginPage(WebDriver driver) {
		super(driver); // we will use same driver all along
	}
	
	public void enterUsername (String data) {
		username.sendKeys(data);
	}
	
	public void clearPassword () {
		password.clear();
	}

	public void enterPassword (String data) {
		password.sendKeys(data);
	}

	public WebDriver clickLogin (){
		loginButton.click();
		return driver; // we take driver from loginpage
	
	}
	
	public WebDriver clickForgotPassword() {
		forgotPassword.click();
		return driver;
		
	}
	public String getIDchecked(){
		return userID.getText();
	}
	
	public String getErrorMessage(){
		return errorMessage.getText();
	}
	
	
	public void closeDriver () {
		driver.close();
	}
}
