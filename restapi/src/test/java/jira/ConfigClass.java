package jira;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class ConfigClass 
{
	
//	public WebDriver driver = null;
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver.exe");
//		driver = new ChromeDriver();
	}
}
