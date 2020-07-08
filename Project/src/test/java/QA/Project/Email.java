package QA.Project;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import pageObjects.EmailPage;
import resources.Base;

public class Email extends Base{
	
	public WebDriver driver;
	

	@BeforeTest
	public WebDriver initializeDriverData() throws IOException {
		
		driver = InitialiseDriver();
		driver.get(prop.getProperty("URL"));
		
		EmailPage emailPg = new EmailPage(driver);
		emailPg.getLoginClick().click();
		
		return driver;		
		
		}
	
	/*@Test
	public void TC1_EmailPageTitle(){
		
		String expectedEmailTitle = prop.getProperty("EmailPageTitle");
		String actualEmailTitle = driver.getTitle();
		
		Assert.assertEquals(actualEmailTitle, expectedEmailTitle);
		
	} */
	
	@Test
	public void TC2_EmailPageURL() {
		
		String expectedEmailURL = prop.getProperty("EmailPageURL");
		String actualEmailURL = driver.getCurrentUrl();
		
		AssertJUnit.assertEquals(actualEmailURL, expectedEmailURL);		
	}
	
	@Test
	public void TC3_insertEmailDisplayed() {
		
		EmailPage emailPg = new EmailPage(driver);
		AssertJUnit.assertTrue(emailPg.getEmail().isDisplayed());
	}

	@Test
	public void TC4_insertInvalidEmail() {
		
		String invalidEmail = prop.getProperty("InvalidEmail");
		
		EmailPage emailPg = new EmailPage(driver);
		emailPg.getEmail().sendKeys(invalidEmail);
		emailPg.getEmailNextStep().click();
		
		AssertJUnit.assertTrue(emailPg.getInvalidEmailText().isDisplayed());
				
	}
	
	@Test
	public void TC5_insertValidEmail() throws InterruptedException {
		
		
		String validEmail = prop.getProperty("ValidEmail");
		String expectedValidEmailText = prop.getProperty("ValidEmailText");
		
		EmailPage emailPg = new EmailPage(driver);
		emailPg.getEmail().clear();
		emailPg.getEmail().sendKeys(validEmail);
		emailPg.getEmailNextStep().click();
		
		//Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.textToBePresentInElement(emailPg.getValidEmailText(), expectedValidEmailText));
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='headingText']/span"), expectedValidEmailText));		
		
		String actualValidEmailText = emailPg.getValidEmailText().getText();
		AssertJUnit.assertEquals(actualValidEmailText, expectedValidEmailText);
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.quit();
		}

}
