package SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	 @FindBy(css=".hero-primary")
	    WebElement confirmationMessage;
	 
	 @FindBy(css="[placeholder='.action__submit']")
	    WebElement submit;

	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public String getConfirmationMessage()
	{
		return confirmationMessage.getText();
	}

////String text=driver.findElement(By.cssSelector(".hero-primary")).getText();
//
//System.out.println(text);
//
//Assert.assertEquals(text, "THANKYOU FOR THE ORDER.");
//driver.close();

}
