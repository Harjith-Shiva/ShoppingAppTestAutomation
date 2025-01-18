package UserStories.PagesObjects;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UserStories.AbstractComponents.AbstractComponent;

public class EditAccountPage extends AbstractComponent{

WebDriver driver;
	
	public EditAccountPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	
	@FindBy(id="input-firstname")
	WebElement firstName;

	@FindBy(id="input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-telephone")
	WebElement telephone;
	
	
	public String getfirstName()
	{
		return getValueOfAttributeInDOM(firstName,"value");
	}
	
	public String getlastName()
	{
		return getValueOfAttributeInDOM(lastName,"value");
	}
	
	public String getTelephone()
	{
		return getValueOfAttributeInDOM(telephone,"value");
	}
	
	public String getEmail()
	{
		return getValueOfAttributeInDOM(email,"value");
	}
	public String getValueOfAttributeInDOM(WebElement element, String attribute)
	{
		return element.getDomProperty(attribute);
	}
}
