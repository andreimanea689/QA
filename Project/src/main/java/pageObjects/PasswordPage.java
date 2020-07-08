package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordPage {
	
	public WebDriver driver;
	
	By login = By.cssSelector("a[href*='ServiceLogin']");
	By email = By.xpath("//input[@type='email']");
	By emailNextStep = By.cssSelector("span[class*='RveJvd']");
	
	By password = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input");
	By passNextStep = By.xpath("//*[@id='passwordNext']/div/span/span");
	By forgotPass = By.xpath("//*[@id='forgotPassword']/div/span/span");
	By invalidPassText = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span");
	
	
	
	public PasswordPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public WebElement getLoginClick() {

		return driver.findElement(login);
	}

	public WebElement getEmail() {

		return driver.findElement(email);
	}

	public WebElement getEmailNextStep() {

		return driver.findElement(emailNextStep);
	}

	public WebElement getPassword() {
		
		return driver.findElement(password);
		}
	
	public WebElement getPassNextStep() {

		return driver.findElement(passNextStep);
	}

	public WebElement getForgotPass() {

		return driver.findElement(forgotPass);
	}
	
	public WebElement getInvalidText() {

		return driver.findElement(invalidPassText);
	}
	
}
