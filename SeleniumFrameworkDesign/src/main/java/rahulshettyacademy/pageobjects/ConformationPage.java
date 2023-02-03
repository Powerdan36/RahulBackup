package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ConformationPage extends AbstractComponent{
	WebDriver driver;

	public ConformationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	
		PageFactory.initElements(driver, this);
				
	}
	
	@FindBy(css= ".hero-primary")
	WebElement ConformationMessage;
	
	public String getConformationMessage() {
		return ConformationMessage.getText();
		
	}
	
	
	
	
	

}
