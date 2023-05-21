package SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent
{ 
	
	
	//List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		@FindBy( css = ".cartSection h3" )
		List<WebElement> cartproducts;
		
	//WebElement kart = driver.findElement(By.cssSelector(".totalRow button"));
		@FindBy( css = ".totalRow button" )
		WebElement checkoutEle;
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	

	
public boolean VerifyProductDisplay(String prodtwo)
{
	Boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(prodtwo));
    return match;
}
	
public CheckoutPage goToCheckout()
{
	checkoutEle.click();
	return new CheckoutPage(driver);
}
	
//List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//
//Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(prodTwo));
////System.out.println(match);
//Assert.assertTrue(match);
	
   
}
