package QA.Project;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pageObjects.LandingPage;
import resources.Base;

public class Home extends Base{
	
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
		
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test
	public void TC2_HomePageURL() throws IOException {
		
		String expectedURL = prop.getProperty("HomePageURL");
		String actualURL = driver.getCurrentUrl();
		
		AssertJUnit.assertEquals(actualURL, expectedURL);		
	}
	
	@Test
	public void TC3_HomeSearchField() {
		
		LandingPage land = new LandingPage(driver);
		AssertJUnit.assertTrue(land.getSearch().isDisplayed());
				
	}
	
	@Test
	public void TC4_HomeKeyboardEnabled() {
		
		LandingPage land = new LandingPage(driver);
		AssertJUnit.assertTrue(land.getKeyboard().isEnabled());
				
	}
	
	@Test
	public void TC5_HomeBelowText1() {
		
		LandingPage land = new LandingPage(driver);
		AssertJUnit.assertTrue(land.getBelowText1().isDisplayed());
		/*String expectedBelowText1 = prop.getProperty("BelowText1");
		String actualBelowText1 = land.getBelowText1().getText();
		
		Assert.assertEquals(actualBelowText1, expectedBelowText1);	*/	
				
	}
	
	@Test
	public void TC6_HomeBelowText2() {
		
		LandingPage land = new LandingPage(driver);
		AssertJUnit.assertTrue(land.getBelowText2().isDisplayed());
		/*String expectedBelowText2 = prop.getProperty("BelowText2");
		String actualBelowText2 = land.getBelowText2().getText();
		
		Assert.assertEquals(actualBelowText2, expectedBelowText2);	*/	
				
	}
	
	@Test
	public void TC7_HomeLoginClick() {
		
		// Click the login button in the home page
		LandingPage land = new LandingPage(driver);
		land.getLogin().click();
						
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.quit();
		}

}
