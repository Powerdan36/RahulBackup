package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css= ".action__submit")
	WebElement submit;

	@FindBy(css= "[placeholder='Select Country']")
	WebElement country;
	
	//@FindBy(xpath="//button[contain(@type='button'])[2]")
	@FindBy(css= "button:nth-child(2) span:nth-child(1)")
	WebElement selectcountry;
	
	By results = By.cssSelector(".ta-backdrop");
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-backdrop"));
		selectcountry.click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-backdrop")));
	}

	public ConformationPage submitOrder() {
		submit.click();
		return new ConformationPage(driver);
	}
}
