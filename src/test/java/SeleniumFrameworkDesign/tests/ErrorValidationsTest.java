package SeleniumFrameworkDesign.tests;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.pageobjects.CartPage;
import SeleniumFrameworkDesign.pageobjects.CheckoutPage;
import SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import SeleniumFrameworkDesign.pageobjects.LandingPage;
import SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulsheetyacademy.TestComponents.BaseTests;
import rahulsheetyacademy.TestComponents.Retry;

public class ErrorValidationsTest extends BaseTests {

    @Test(groups = {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException {

		//login Step
	

		ProductCatalogue ProductCatalogue = landingPage.loginApplication("rahul.bwn05@gmail.com","R@hu1123");
		System.out.println(landingPage.getErrorMessage());
		Assert.assertEquals("Incorrect email or password." ,landingPage.getErrorMessage());
	
		

	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String prodtwo = "IPHONE 13 PRO";
		ProductCatalogue ProductCatalogue = landingPage.loginApplication("rahul.bwn05@gmail.com","R@hul123");
		ProductCatalogue.addProductToCart(prodtwo);
		CartPage CartPage = ProductCatalogue.goToCartPage();
		Boolean match = CartPage.VerifyProductDisplay("IPHONE 11 PRO");
		Assert.assertTrue(match);
		
	

	}

//	public class ErrorValidationsTest extends BaseTest {
//
//		@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
//		public void LoginErrorValidation() throws IOException, InterruptedException {
//
//		
//			landingPage.loginApplication("anshika@gmail.com", "Iamki000");
//			Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
//
//		}
		
}
