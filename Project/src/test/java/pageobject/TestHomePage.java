package pageobject;

import org.testng.annotations.Test;

import pageobjects.HomePage;

import org.testng.Assert;
import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import resources.BaseConfiguration;

public class TestHomePage extends BaseConfiguration{
	
	public WebDriver driver;
	

	@BeforeTest
	public WebDriver initializeDriverData() throws IOException {
		
		driver = InitialiseDriver();
		driver.get(prop.getProperty("URL"));
		
		return driver;		
		
		}
	
	@Test
	public void TC1_HomePageTitle(){
		
		String expectedTitle = prop.getProperty("HomeTitle");
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test
	public void TC2_HomePageURL() throws IOException {
		
		String expectedURL = prop.getProperty("HomePageURL");
		String actualURL = driver.getCurrentUrl();
		
		Assert.assertEquals(actualURL, expectedURL);		
	}
	
	@Test
	public void TC3_HomeSearchField() {
		
		HomePage land = new HomePage(driver);
		Assert.assertTrue(land.getSearch().isDisplayed());
				
	}
	
	@Test
	public void TC4_HomeKeyboardEnabled() {
		
		HomePage land = new HomePage(driver);
		Assert.assertTrue(land.getKeyboard().isEnabled());
				
	}
	
	@Test
	public void TC5_HomeBelowText1() {
		
		HomePage land = new HomePage(driver);
		Assert.assertTrue(land.getBelowText1().isDisplayed());
				
	}
	
	@Test
	public void TC6_HomeBelowText2() {
		
		HomePage land = new HomePage(driver);
		Assert.assertTrue(land.getBelowText2().isDisplayed());
				
	}
	
	@Test
	public void TC7_HomeLoginClick() {
	
		HomePage land = new HomePage(driver);
		land.getLogin().click();
						
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.quit();
		}

}
