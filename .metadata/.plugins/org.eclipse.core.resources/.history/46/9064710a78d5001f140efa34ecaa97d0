package UserStories.Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;

import UserStories.Data.DataReader;
import UserStories.PagesObjects.EditAccountPage;
import UserStories.PagesObjects.HeaderPage;
import UserStories.PagesObjects.Hooks;
import UserStories.PagesObjects.RegisterPage;
import UserStories.PagesObjects.SideCoulmnWhenSignedIn;

public class UserStory1 extends Hooks {
	@Test(dataProvider="getPositiveData",groups="positive")
	public void userStoryPositiveTest(HashMap<String,String> input) throws InterruptedException, IOException
	{
		
	WebDriver driver = launchApplication();
	HeaderPage headerPage = new HeaderPage(driver);
	headerPage.selectRegisterAccount();
	
	RegisterPage registerPage = new RegisterPage(driver);
	registerPage.registerAccount(input);
	
	SideCoulmnWhenSignedIn sideColumn = new SideCoulmnWhenSignedIn(driver);
	sideColumn.clickOn("Edit Account");
	
	EditAccountPage editAccountPage = new EditAccountPage(driver);
	
	Assert.assertEquals(input.get("firstName"), editAccountPage.getfirstName());
	Assert.assertEquals(input.get("lastName"), editAccountPage.getlastName());
	Assert.assertEquals(input.get("email"), editAccountPage.getEmail());
	Assert.assertEquals(input.get("telephone"), editAccountPage.getTelephone());
	

	
	}
	
	@Test(dataProvider="getNegativeData",groups="negative")
	public void userStoryNegativeEmailTest(HashMap<String,String> input) throws InterruptedException, IOException
	{
		
	WebDriver driver = launchApplication();
	HeaderPage headerPage = new HeaderPage(driver);
	headerPage.selectRegisterAccount();
	
	RegisterPage registerPage = new RegisterPage(driver);
	registerPage.registerAccount(input);
	Assert.assertEquals(registerPage.verifyEmailAlert(),"Warning: E-Mail Address is already registered!");
	
	
	}
	
	

	@Test(dataProvider="getInvalidPasswordData",groups="negative")
	public void userStoryNegativePasswordTest(HashMap<String,String> input) throws InterruptedException, IOException
	{
		
	WebDriver driver = launchApplication();
	HeaderPage headerPage = new HeaderPage(driver);
	headerPage.selectRegisterAccount();
	
	RegisterPage registerPage = new RegisterPage(driver);
	registerPage.registerAccount(input);
	Assert.assertEquals(registerPage.getErrorTextForInvalidPassword(),"Password must be between 4 and 20 characters!");
	
	
	}
	
	
	@Test(dataProvider="getPasswordNotMatchData",groups="negative")
	public void userStoryPasswordNotMatchingTest(HashMap<String,String> input) throws InterruptedException, IOException
	{
		
	WebDriver driver = launchApplication();
	HeaderPage headerPage = new HeaderPage(driver);
	headerPage.selectRegisterAccount();
	
	RegisterPage registerPage = new RegisterPage(driver);
	registerPage.registerAccount(input);
	Assert.assertEquals(registerPage.getErrorTextForInvalidPassword(),"Password confirmation does not match password!");
	
	
	}
	
	
	
	
	
	public String getScreenshot(String testCaseName) throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot)driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	
	
	//Extent Reports
	
	
	@DataProvider
	public Object[][] getPositiveData() throws IOException
	{		
		DataReader dataReader = new DataReader();
		List<HashMap<String,String>> data = dataReader.getJsonDataToMap(System.getProperty("user.dir")+"//src//main//java//UserStories//Data//RegisterAccountPositiveData.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		
	}
	
	@DataProvider
	public Object[][] getNegativeData() throws IOException
	{		
		DataReader dataReader = new DataReader();
		List<HashMap<String,String>> data = dataReader.getJsonDataToMap(System.getProperty("user.dir")+"//src//main//java//UserStories//Data//RegisterAccountNegativeData.json");
		return new Object[][] {{data.get(0)}};
		
	}

	@DataProvider
	public Object[][] getInvalidPasswordData() throws IOException
	{		
		DataReader dataReader = new DataReader();
		List<HashMap<String,String>> data = dataReader.getJsonDataToMap(System.getProperty("user.dir")+"//src//main//java//UserStories//Data//RegisterAccountInvalidPassword.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		
	}
	
	@DataProvider
	public Object[][] getPasswordNotMatchData() throws IOException
	{		
		DataReader dataReader = new DataReader();
		List<HashMap<String,String>> data = dataReader.getJsonDataToMap(System.getProperty("user.dir")+"//src//main//java//UserStories//Data//RegisterAccountPasswordNotMatch.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
}
