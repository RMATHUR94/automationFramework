package SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;
    
    public ProductCatalogue(WebDriver driver)
    {
    	super(driver);
    	//initialization
    	this.driver=driver;
    	//design-method
    	PageFactory.initElements(driver, this);
    }   
    
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
    @FindBy(css=".mb-3")
    List<WebElement> products;
    ////wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
   
    @FindBy(css=".ng-animating")
    WebElement spinner;
    
    By productsby = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");
    By clickable= By.cssSelector("[routerlink*='cart']");
     
    public List<WebElement> getProductList()
    {
    	waitForElementToAppear(productsby);
    	return products;
    }
    
    public WebElement getProductByName(String prodone)
    {
    	WebElement selectprodone = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(prodone)).findFirst().orElse(null);
		//selectprodone.findElement(By.cssSelector(".card-body button:last-of-type")).click();
    	return selectprodone;
    }
    public void addProductToCart(String prodone)
    {
    	WebElement selectprodone = getProductByName(prodone);
    	selectprodone.findElement(addToCart).click();
    	waitForElementToAppear(toastMessage);
    	waitForElementToDisappear(spinner);
    	//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
    }
   
}
