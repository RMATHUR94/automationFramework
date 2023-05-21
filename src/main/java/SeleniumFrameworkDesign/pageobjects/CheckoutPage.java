package SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent 
{
   WebDriver driver;
   public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

  //".btnn"
  @FindBy(css = ".btnn")
  WebElement submit;
  
//a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
  @FindBy(css = "[placeholder='Select Country']")
   WebElement country;
  
  @FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
  WebElement SelectIndia;
  
  By results = By.cssSelector(".ta-results");
  
  public void SelectCountry(String CountryName)
  {

		Actions a = new Actions(driver);
		
		a.sendKeys(country,CountryName).build().perform();
		
		waitForElementToAppear(results);
		
		SelectIndia.click();	
  }
  
  public ConfirmationPage submitOrder()
  {
	  submit.click();
	  return new ConfirmationPage(driver);
  }
  
//Actions a = new Actions(driver);
//a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//driver.findElement(By.cssSelector(".btnn")).click(); //another locator for placeorder = .action__submit

}

