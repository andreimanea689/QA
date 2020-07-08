package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By login = By.cssSelector("a[href*='ServiceLogin']");
	By search = By.xpath("//div[@class = 'SDkEP']");
	By keyboard = By.xpath("//span[@class = 'hOoLGe']");
	By belowText1 = By.xpath("/html/body/div/div[2]/form/div[2]/div[1]/div[3]/center/input[1]");
	By belowText2 = By.xpath("/html/body/div/div[2]/form/div[2]/div[1]/div[3]/center/input[2]");
	
	

	public LandingPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getLogin() {

		return driver.findElement(login);
	}
	
	public WebElement getSearch() {

		return driver.findElement(search);
	}
	
	public WebElement getKeyboard() {

		return driver.findElement(keyboard);
	}
	
	public WebElement getBelowText1() {

		return driver.findElement(belowText1);
	}
	
	public WebElement getBelowText2() {

		return driver.findElement(belowText2);
	}
	

}
