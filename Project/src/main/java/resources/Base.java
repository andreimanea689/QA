package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver InitialiseDriver() throws IOException {
		
		// Create new properties object, an input stream object and set the path to the properties file
		prop = new Properties();
		FileInputStream fis = new FileInputStream("/home/andrei/eclipse-workspace/Project/src/main/java/resources/data.properties");
		
		// Load the properties file
		prop.load(fis);
		String browserType = prop.getProperty("browser");
		//String URL = prop.getProperty("URL");
		
		if (browserType.equals("chrome")){
			
			// Chrome Browser initialisation
			System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
			driver = new ChromeDriver();
			
		}
		
		else {
			
			System.out.println("Only Chrome browser can be set");
			
		}
		
		// Add implicit wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
}
