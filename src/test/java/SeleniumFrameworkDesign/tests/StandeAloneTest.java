package SeleniumFrameworkDesign.tests;

import java.awt.event.ActionEvent;
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

import SeleniumFrameworkDesign.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandeAloneTest {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		//login step
		String prodone = "ZARA COAT 3";
		String prodtwo = "IPHONE 13 PRO";
		driver.findElement(By.id("userEmail")).sendKeys("rahul.bwn05@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("R@hul123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait for the load all products
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement selectprodone = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(prodone)).findFirst().orElse(null);
		selectprodone.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		//for toast added
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#toast-container"))));
		//for loader ng-animating
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//Adding second productTwo
		WebElement selectprodtwo = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(prodtwo)).findFirst().orElse(null);
		selectprodtwo.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		//for toast added
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#toast-container"))));
		//for loader ng-animating
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		// Adding wait for visibility of cart button then clicking the button
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[routerlink*='cart']")));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(prodtwo));
		Assert.assertTrue(match);
		//clicking kart using javascript executor, other method is not working throwing exception
		WebElement kart = driver.findElement(By.cssSelector(".totalRow button"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",kart);
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
    	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
    	
    	WebElement e = driver.findElement(By.cssSelector(".btnn"));

    	JavascriptExecutor js = (JavascriptExecutor) driver;

    	js.executeScript("arguments[0].click(0);", e);
    	
    	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
    	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    	driver.close();
		
		}

}
