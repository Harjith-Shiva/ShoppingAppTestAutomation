package UserStories.PagesObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UserStories.AbstractComponents.AbstractComponent;

public class SideCoulmnWhenSignedIn extends AbstractComponent{

WebDriver driver;
	
	public SideCoulmnWhenSignedIn(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	
	@FindBy(css="aside#column-right div a")
	List<WebElement> rightColumnWhenSignedIn;
	
	
	public void clickOn(String attribute) throws InterruptedException
	{
		waitForElementsToAppear(rightColumnWhenSignedIn);
		WebElement attributeToBeClicked = rightColumnWhenSignedIn.stream().filter(account->account.getText().trim().equalsIgnoreCase(attribute)).findFirst().orElse(null);
		attributeToBeClicked.click();
		
		
	}
}
