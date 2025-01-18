package UserStories.PagesObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UserStories.AbstractComponents.AbstractComponent;

public class RegisterPage extends AbstractComponent{

WebDriver driver;
	
	public RegisterPage(WebDriver driver)
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
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(id="input-confirm")
	WebElement confirmPassword;
	
	@FindBy(css="input[name='agree']")
	WebElement privacyPolicy;
	
	@FindBy(css="input.btn-primary")
	WebElement contiuneBtn;
	
	@FindBy(css="div.alert-danger")
	WebElement emailAlert;
	
	@FindBy(css="div.text-danger")
	WebElement invalidEmailText;
	
	public void registerAccount(HashMap<String,String> input)
	{
		firstName.sendKeys(input.get("firstName"));
		lastName.sendKeys(input.get("lastName"));
		email.sendKeys(input.get("email"));
		telephone.sendKeys(input.get("telephone"));
		password.sendKeys(input.get("password"));
		confirmPassword.sendKeys(input.get("confirmPassword"));
		
		privacyPolicy.click();
		contiuneBtn.click();
		
	}
	
	public String verifyEmailAlert()
	{
		return emailAlert.getText();
	}
	
	public String getErrorTextForInvalidPassword()
	{
		return invalidEmailText.getText();
	}
	
}
