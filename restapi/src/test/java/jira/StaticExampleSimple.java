package jira;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StaticExampleSimple
{
	public WebDriver driver;
	public POM pom;
	
	@Test
	public void method1()
	{
		driver = new ChromeDriver();
		driver.get("https://google.com");
		pom = new POM(driver);
		pom.getGmailLink().click();
		driver.close();
	}
	
	@Test
	public void method2() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.get("https://google.com");
		Thread.sleep(3000);
		pom.getGmailLink().click();
		driver.close();
	}
	
	@Test
	public void method3()
	{
		driver = new ChromeDriver();
		driver.close();
	}
}
