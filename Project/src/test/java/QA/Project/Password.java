package QA.Project;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.PasswordPage;
import resources.Base;

public class Password extends Base{
	
	public WebDriver driver;
	

	@BeforeTest
	public WebDriver initializeDriverData() throws IOException {
		
		driver = InitialiseDriver();
		driver.get(prop.getProperty("URL"));
		
		PasswordPage passPage = new PasswordPage(driver);
		passPage.getLoginClick().click();
		
		String validEmail = prop.getProperty("ValidEmail");		
		
		passPage.getEmail().sendKeys(validEmail);
		passPage.getEmailNextStep().click();
		
		return driver;		
		}
	
	
		
	@Test
	public void TC1_insertPassDisplayed() {
		
		PasswordPage passPage = new PasswordPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(passPage.getPassword()));
	}
	
	@Test
	public void TC2_forgotPassDisplayed() {
		
		PasswordPage passPage = new PasswordPage(driver);
		AssertJUnit.assertTrue(passPage.getForgotPass().isDisplayed());
	}

	@Test
	public void TC3_insertInvalidPass() {
		
		String invalidPass = prop.getProperty("InvalidPass");
		
		PasswordPage passPage = new PasswordPage(driver);
		passPage.getPassword().sendKeys(invalidPass);
		passPage.getPassNextStep().click();
		
		AssertJUnit.assertTrue(passPage.getInvalidText().isDisplayed());
				
	}
	
	@Test
	public void TC4_insertValidPass() {
		
		
		String validPass = prop.getProperty("ValidPass");
		//String expectedValidEmailText = prop.getProperty("ValidEmailText");
		
		PasswordPage passPage = new PasswordPage(driver);
		passPage.getPassword().clear();
		passPage.getPassword().sendKeys(validPass);
		passPage.getPassNextStep().click();
		
		String expectedHomeTitle = prop.getProperty("HomeTitle");
		//String actualHomeTitle = driver.getTitle();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleIs(expectedHomeTitle));
		//Assert.assertEquals(actualHomeTitle, expectedHomeTitle);
		
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.quit();
		}

}
