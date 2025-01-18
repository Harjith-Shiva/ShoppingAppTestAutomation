package UserStories.PagesObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UserStories.AbstractComponents.AbstractComponent;

public class HeaderPage extends AbstractComponent{

WebDriver driver;
	
	public HeaderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="a[title='My Account']")
	WebElement myAccount;
	
	@FindBy(css="ul.dropdown-menu.dropdown-menu-right li")
	List<WebElement> myAccountDropdown;
	
	public void selectRegisterAccount()
	{
		myAccount.click();
		WebElement registerAccount = myAccountDropdown.stream().filter(account->account.getText().trim().equalsIgnoreCase("register")).findFirst().orElse(null);
		registerAccount.click();
		
	}
}
