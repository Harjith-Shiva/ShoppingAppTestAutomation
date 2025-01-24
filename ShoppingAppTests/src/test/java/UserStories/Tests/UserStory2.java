package UserStories.Tests;

import static org.testng.Assert.assertTrue;

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
import UserStories.PagesObjects.AddressBookPage;
import UserStories.PagesObjects.EditAccountPage;
import UserStories.PagesObjects.HeaderPage;
import UserStories.PagesObjects.Hooks;
import UserStories.PagesObjects.LoginPage;
import UserStories.PagesObjects.RegisterPage;
import UserStories.PagesObjects.SideCoulmnWhenSignedIn;
import utils.MenuUtils;

public class UserStory2 extends Hooks {
	//@Test(dataProvider = "getPositiveData", groups = "positive")
	public void userStoryPositiveTest(HashMap<String, String> input) throws InterruptedException, IOException {

		WebDriver driver = launchApplication();

		HeaderPage headerPage = new HeaderPage(driver);
		headerPage.LoignAccount();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginIntoAccount(input);

		SideCoulmnWhenSignedIn sideColumn = new SideCoulmnWhenSignedIn(driver);
		List<String> missingMenus = MenuUtils.getMissingSubMenus(sideColumn.getExpectedSubMenus(), sideColumn.getActualSideMenus());

		if (!missingMenus.isEmpty()) {
            // If there are missing submenus, fail the test and print them
            Assert.fail("Missing submenus: " + String.join(", ", missingMenus));
        } else {
            // Optionally, assert true if no missing submenus
            Assert.assertTrue(true, "All expected submenus are present.");
        }
	
	
	}
	
	//@Test(dataProvider = "getPositiveData", groups = "positive")
	public void verifyEditAccount(HashMap<String, String> input) throws InterruptedException, IOException {
	    
		WebDriver driver = launchApplication();

		HeaderPage headerPage = new HeaderPage(driver);
		headerPage.LoignAccount();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginIntoAccount(input);
		
		SideCoulmnWhenSignedIn sideColumn = new SideCoulmnWhenSignedIn(driver);
		sideColumn.clickOn("Edit Account");
		
		EditAccountPage editAccountPage = new EditAccountPage(driver);
		editAccountPage.enterNewPersonalDetails(input);
		
		Assert.assertEquals("Success: Your account has been successfully updated.",editAccountPage.getSuccessMessage() );
		sideColumn.clickOn("Edit Account");
		
		Assert.assertEquals(input.get("newFirstName"), editAccountPage.getfirstName());
		Assert.assertEquals(input.get("newLastName"), editAccountPage.getlastName());
		Assert.assertEquals(input.get("newEmail"), editAccountPage.getEmail());
		Assert.assertEquals(input.get("newTelephone"), editAccountPage.getTelephone());
		
		
		System.out.println("ALL DONE-----------------");
	}
	
	
	
	
	//@Test(dataProvider = "getNewAddressData", groups = "positive")
	public void verifyAddingNewAccount(HashMap<String, String> input) throws InterruptedException, IOException {
	    
		WebDriver driver = launchApplication();

		HeaderPage headerPage = new HeaderPage(driver);
		headerPage.LoignAccount();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginIntoAccount(input);
		
		SideCoulmnWhenSignedIn sideColumn = new SideCoulmnWhenSignedIn(driver);
		sideColumn.clickOn("Address Book");
		
		AddressBookPage addressBookPage = new AddressBookPage(driver);
		addressBookPage.clickOnNewAddressButton();
		addressBookPage.enterAddress(input);
		Assert.assertEquals("Your address has been successfully added",addressBookPage.verifySuccessMessage() );
		
		
		
	}
	
	@Test(dataProvider = "getLoginForAddressData", groups = "positive")
	public void verifyDefaultAddressAccount(HashMap<String, String> input) throws InterruptedException, IOException {
	    
		WebDriver driver = launchApplication();

		HeaderPage headerPage = new HeaderPage(driver);
		headerPage.LoignAccount();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginIntoAccount(input);
		
		SideCoulmnWhenSignedIn sideColumn = new SideCoulmnWhenSignedIn(driver);
		sideColumn.clickOn("Address Book");
		
		
		AddressBookPage addressBookPage = new AddressBookPage(driver);
		addressBookPage.setAllAddressAsDefaultAddress();
		Assert.assertEquals(addressBookPage.getCountOfDefaultAddress(), "1", "There is more than one default address!!");
		
		System.out.println("ALL DONE ****************************************************");
		
	}
	
	
	

	@DataProvider
	public Object[][] getPositiveData() throws IOException {
		DataReader dataReader = new DataReader();
		List<HashMap<String, String>> data = dataReader.getJsonDataToMap(
				System.getProperty("user.dir") + "//src//main//java//UserStories//Data//LoginDetails.json");
		return new Object[][] { { data.get(0) } };

	}
	
	@DataProvider
	public Object[][] getNewAddressData() throws IOException {
		DataReader dataReader = new DataReader();
		List<HashMap<String, String>> data = dataReader.getJsonDataToMap(
				System.getProperty("user.dir") + "//src//main//java//UserStories//Data//NewAddress.json");
		return new Object[][] { { data.get(0) },{data.get(1)}, {data.get(2)} };

	}

	@DataProvider
	public Object[][] getLoginForAddressData() throws IOException {
		DataReader dataReader = new DataReader();
		List<HashMap<String, String>> data = dataReader.getJsonDataToMap(
				System.getProperty("user.dir") + "//src//main//java//UserStories//Data//LoginForAddressBook.json");
		return new Object[][] { { data.get(0) }};

	}

	
}
