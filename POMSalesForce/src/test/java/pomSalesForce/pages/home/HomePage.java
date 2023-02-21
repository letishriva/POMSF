package pomSalesForce.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomSalesForce.base.BasePage;

public class HomePage extends BasePage {
	WebDriver driver;
	
	@FindBy (id = "userNavLabel") WebElement usernameDropdown;
	@FindBy (xpath = "//div[3]/div/div/div[2]/div[3]/a[5]") WebElement logoutOptionDropdown;
	
	public HomePage(WebDriver driver) {
		super(driver); // we will use same driver all along
	}
	
			
	public String getHomePageTitle(WebDriver driver){
		this.driver = driver;
		return driver.getTitle();
	}

	public WebDriver clickUsernameDropdown (){
		usernameDropdown.click();
		return driver; 
	
	}
	
	public WebDriver clicklogoutOptionDropdown (){
		logoutOptionDropdown.click();
		return driver; 
	
	}
	
	
}
