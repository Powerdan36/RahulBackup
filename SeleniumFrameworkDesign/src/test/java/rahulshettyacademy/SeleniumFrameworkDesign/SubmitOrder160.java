package rahulshettyacademy.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConformationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrder160 {

	public static void main(String[] args) {
		String productName = "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LandingPage landingpage = new LandingPage(driver);
		landingpage.goTo();
		landingpage.loginApplication("power@gmail.com", "Abcd1234");
		ProductCatalogue productCatalogue=new ProductCatalogue (driver);
		List<WebElement>products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		//159 not finish restart
		productCatalogue.goToCart();
		CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.VarifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConformationPage conformationPage= checkoutPage.submitOrder();
			
		String confirmMessage=conformationPage.getConformationMessage(); 
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
		
		
		
	
		
		
		
				
		
		
		
		
	
		
	}

}
