package rahulshettyacademy.pageobjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponent;



public class CartPage extends AbstractComponent{


	WebDriver driver;
	
	@FindBy(css= ".cartSection h3")
	private List <WebElement> cartProduts;
	@FindBy(css= ".totalRow button")
	WebElement checkoutEle;
	
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public Boolean VarifyProductDisplay(String productName) {
		Boolean match = cartProduts.stream().anyMatch(cartProducts->cartProducts.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	
	public CheckoutPage goToCheckout() {
		checkoutEle.click();
		return new CheckoutPage(driver);
	}
	

}

