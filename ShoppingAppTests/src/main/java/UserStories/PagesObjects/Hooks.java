package UserStories.PagesObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

public class Hooks {
	public WebDriver driver;
	public WebDriver initializeDriver() throws IOException
	{
		//properties class
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//UserStories//Resources//GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			// Add argument to ignore certificate errors
	        options.addArguments("--ignore-certificate-errors");
	        options.addArguments("--allow-insecure-localhost");

	        // Instantiate the WebDriver with the ChromeOptions
	        driver = new ChromeDriver(options);
			
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver launchApplication() throws IOException
	{
		driver = initializeDriver();
		driver.get("https://www.demoshop24.com/index.php?route=common/home");
		return driver;
		
	}
	
	public String getAlertText()
	{
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	
	@AfterMethod()
	public void closeCurrentDriver()
	{
		driver.close();
	}
}
