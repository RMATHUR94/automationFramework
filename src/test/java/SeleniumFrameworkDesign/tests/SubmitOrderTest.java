package SeleniumFrameworkDesign.tests;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.pageobjects.CartPage;
import SeleniumFrameworkDesign.pageobjects.CheckoutPage;
import SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import SeleniumFrameworkDesign.pageobjects.LandingPage;
import SeleniumFrameworkDesign.pageobjects.OrderPage;
import SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulsheetyacademy.TestComponents.BaseTests;

public class SubmitOrderTest extends BaseTests {
     
	String prodtwo = "IPHONE 13 PRO";
	
	// public void submitOrder(String email,String password ,String prodtwo) throws IOException for input data in another method
	 @Test(dataProvider ="getData",groups ={"Purchase"})
	 public void submitOrder(HashMap<String,String> input) throws IOException
	{
		 
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		ChromeDriver driver = new ChromeDriver(options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
		
		//login Step
		String prodone = "ZARA COAT 3";
		//String prodtwo = "IPHONE 13 PRO";
		//LandingPage landingPage = new LandingPage(driver);
		//landingPage.goTo();
		//LandingPage landingPage = launchApplication();
		ProductCatalogue ProductCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
		//ProductCatalogue ProductCatalogue = new ProductCatalogue(driver);
		//List<WebElement> products =ProductCatalogue.getProductList();
		//ProductCatalogue.addProductToCart(prodone);
		ProductCatalogue.addProductToCart(input.get("prodtwo"));
		CartPage CartPage = ProductCatalogue.goToCartPage();
		
		
		//CartPage CartPage = new CartPage(driver);
		Boolean match = CartPage.VerifyProductDisplay(input.get("prodtwo"));
		Assert.assertTrue(match);
		
		   CheckoutPage CheckoutPage = CartPage.goToCheckout();
		   CheckoutPage.SelectCountry("india");
		   ConfirmationPage ConfirmationPage = CheckoutPage.submitOrder();
	
		
		
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		//wait for the load all products
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));		
//		WebElement selectprodone = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(prodone)).findFirst().orElse(null);
//		selectprodone.findElement(By.cssSelector(".card-body button:last-of-type")).click();
				
		//for toast added
//		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#toast-container"))));
//		//for loader ng-animating
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//Adding second productTwo
//		
//		WebElement selectprodtwo = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(prodtwo)).findFirst().orElse(null);
//		selectprodtwo.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		//for toast added
//		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#toast-container"))));
//		//for loader ng-animating
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		// Adding wait for visibility of cart button then clicking the button
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[routerlink*='cart']")));
				
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//		
//		List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
//		Boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(prodtwo));
		
		//for this line it is failing
		
		//clicking kart using javascript executor, other method is not working throwing exception
//		WebElement kart = driver.findElement(By.cssSelector(".totalRow button"));
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();",kart);
//		
//		Actions a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//    	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//    	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//    	
//    	WebElement e = driver.findElement(By.cssSelector(".btnn"));
//
//    	JavascriptExecutor js = (JavascriptExecutor) driver;
//
//    	js.executeScript("arguments[0].click(0);", e);
//    	
//    	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//    	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//    	driver.close();
    	
    	String text=ConfirmationPage.getConfirmationMessage();
        System.out.println(text);
        Assert.assertEquals(text, "THANKYOU FOR THE ORDER.");
        //driver.close();
		}
	 
	 @Test(dependsOnMethods= {"submitOrder"})
	 public void OrderHistoryTest()
	 {
		//IPHONE 13 PRO
       ProductCatalogue ProductCatalogue = landingPage.loginApplication("rahul.bwn05@gmail.com","R@hul123");	 
       OrderPage ordersPage = ProductCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(prodtwo));	 
	 }
	 
	 @DataProvider
	 public Object[][] getData() throws IOException
	 {
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email","rahul.bwn05@gmail.com");
//		map.put("password","R@hul123");
//		map.put("prodtwo","ZARA COAT 3");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email","uma_mathur01@gmail.com");
//		map1.put("password","Umamathur@1234");
//		map1.put("prodtwo","IPHONE 13 PRO");
		 
		List<HashMap<String,String>> data = getJsonDataToMap("C:\\Users\\user\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\test\\java\\rahulsheetyacademy\\data\\PurchaseOrder.json");
		return new Object [][] {{data.get(0)},{data.get(1)}};
	 }
	 
//	 @DataProvider
//	 public Object[][] getData()
//	 {
//		return new Object [][] {{"rahul.bwn05@gmail.com","R@hul123","ZARA COAT 3"},{"uma_mathur01@gmail.com","Umamathur@1234","IPHONE 13 PRO"}};
//	 }

}
