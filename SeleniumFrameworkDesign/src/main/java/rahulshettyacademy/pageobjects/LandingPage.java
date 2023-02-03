package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	WebDriver driver;

	public LandingPage(WebDriver driver) {

		super(driver);
//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	
	
	//WebElement userEmail= driver.findElement(By.id("userEmail"));
		//PageFactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	//driver.findElement(By.id("userPassword"))
	@FindBy (id="userPassword")
	WebElement passwordEle;
	
	@FindBy (id="login")
	WebElement submit;
	
	//Lets create action method to perform action for log in
	
	public void loginApplication(String email,String password) {
	userEmail.sendKeys(email);
	passwordEle.sendKeys(password);
	submit.click();
	}
		
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	


	
	
}
