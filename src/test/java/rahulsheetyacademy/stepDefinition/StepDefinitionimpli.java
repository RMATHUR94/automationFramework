package rahulsheetyacademy.stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import SeleniumFrameworkDesign.pageobjects.CartPage;
import SeleniumFrameworkDesign.pageobjects.CheckoutPage;
import SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import SeleniumFrameworkDesign.pageobjects.LandingPage;
import SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulsheetyacademy.TestComponents.BaseTests;

public class StepDefinitionimpli extends BaseTests {

	public LandingPage landingPage;
	public ProductCatalogue ProductCatalogue;
	public ConfirmationPage ConfirmationPage;

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
	}
	

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password) {
		ProductCatalogue = landingPage.loginApplication(username, password);
	}
	

	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) {
		// List<WebElement> products =ProductCatalogue.getProductList();
		// ProductCatalogue.addProductToCart(prodone);
		ProductCatalogue.addProductToCart(productName);

	}
	
	
	@When("^Checkout (.+) and submit the order$")
    public void checkout_submit_order(String productName)
    {
        CartPage CartPage = ProductCatalogue.goToCartPage();
	
		//CartPage CartPage = new CartPage(driver);
		Boolean match = CartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		
		   CheckoutPage CheckoutPage = CartPage.goToCheckout();
		   CheckoutPage.SelectCountry("india");
		   ConfirmationPage = CheckoutPage.submitOrder();
    }
	
	
	 @Then("{string} message is displayed on ConfirmationPage")
	 public void message_is_displayed_on_ConfirmationPage(String string)
	 {
         String text=ConfirmationPage.getConfirmationMessage();
	     Assert.assertTrue(text.equalsIgnoreCase(string));
	     driver.close();
	 }
	 
	 @Then("^\"([^\"]*)\" message is displayed on confirmationPage.$")
	    public void something_message_is_displayed_on_confirmationpage(String strArg1) throws Throwable {
		 Assert.assertEquals(strArg1 ,landingPage.getErrorMessage());
		 driver.close();
	    }

}
