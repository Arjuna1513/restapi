package jira;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StaticExampleSimple2 extends ConfigClass
{
//	WebDriver driver = new ChromeDriver();
	public POM pom;
	@Test
	public void method10()
	{
		WebDriver driver = new ChromeDriver();
		pom = new POM(driver);
		driver.get("https://google.com");
		pom.getGmailLink().click();
		driver.close();
		
	}
	
	@Test
	public void method11() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		pom = new POM(driver);
		driver.get("https://google.com");
		pom.getGmailLink().click();
		driver.close();
	}
	
	@Test
	public void method12()
	{
		WebDriver driver = new ChromeDriver();
		pom = new POM(driver);
		driver.get("https://google.com");
		pom.getGmailLink().click();
		driver.close();
	}
}
