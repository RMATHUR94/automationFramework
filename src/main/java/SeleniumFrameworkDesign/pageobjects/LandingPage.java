package SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;
    
    public LandingPage(WebDriver driver)
    {
    	super(driver);
    	//initialization
    	this.driver=driver;
    	//design-method
    	PageFactory.initElements(driver, this);
    }   
    //driver.findElement(By.id("userEmail")).sendKeys("rahul.bwn05@gmail.com");
    @FindBy(id="userEmail")
    WebElement userEmail;
    //driver.findElement(By.id("userPassword")).sendKeys("R@hul123");
    @FindBy(id="userPassword")
    WebElement passwordEle;
    //driver.findElement(By.id("login"))
    @FindBy(id="login")
    WebElement submit;
    
    //.ng-tns-c4-5.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;
    
    public ProductCatalogue loginApplication(String email,String password)
    {
    	userEmail.sendKeys(email);
    	passwordEle.sendKeys(password);
    	submit.click();
    	ProductCatalogue ProductCatalogue = new ProductCatalogue(driver);
    	return ProductCatalogue;
    }
    public String getErrorMessage()
    {
    	
    	waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
       
    }
     
    public void goTo()
    {
    	driver.get("https://rahulshettyacademy.com/client");
    }
}
