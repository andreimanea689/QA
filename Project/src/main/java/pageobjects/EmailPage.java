package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailPage {

	public WebDriver driver;
	
	By login = By.cssSelector("a[href*='ServiceLogin']");
	By email = By.xpath("//input[@type='email']");
	By emailNextStep = By.cssSelector("span[class*='RveJvd']");
	By invalidEmailField = By.xpath("//div[@class = 'o6cuMc']");
	By validEmailText = By.xpath("//*[@id='headingText']/span");

	public EmailPage(WebDriver driver) {

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
	
	public WebElement getInvalidEmailText() {

		return driver.findElement(invalidEmailField);
	}
	
	public WebElement getValidEmailText() {

		return driver.findElement(validEmailText);
	}

}
