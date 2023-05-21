package SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;
	
	// List<WebElement> cartproducts 
	// driver.findElements(By.cssSelector(".cartSection h3"));
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartproducts;

	
	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productNames;

	

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyOrderDisplay(String prodtwo) {
		Boolean match = productNames.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(prodtwo));
		return match;
	}

	
}
