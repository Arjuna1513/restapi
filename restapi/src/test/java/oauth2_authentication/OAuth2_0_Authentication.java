package oauth2_authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2_0_Authentication 
{
	@Test
	public void oauth2Authentication() throws InterruptedException
	{
		/*
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?"
				+ "scope=https://www.googleapis.com/auth/userinfo.email&"
				+ "auth_url=https://accounts.google.com/o/oauth2/v2/auth&"
				+ "client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&"
				+ "response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='kHn9Lb']")));
		driver.findElement(By.xpath("//input[@id='identifierId']")).click();
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("advaithab1513@gmail.com");
		driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
		driver.findElement(By.xpath("//div[@class='aXBtI I0VJ4d Wic03c']/div/div")).clear();
		driver.findElement(By.xpath("//div[@class='aXBtI I0VJ4d Wic03c']/div/div")).sendKeys("RohiArjun@123", Keys.ENTER);
		String newURL = driver.getCurrentUrl();
		System.out.println(newURL);
		
//		Thread.sleep(5000);
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		driver.close();
		*/
		
//		RestAssured.baseURI = "https://www.googleapis.com";
		Response response = 
		given().log().all().urlEncodingEnabled(false).
			queryParam("code","4%2FxwFZxeZbVlb-54i8CwqphAFSJvhXOmVQj8-ZnrdjhenGZYfoOOcr_klcHP5DJ_c-v3_5XvGjeVh7-6ZKXPP2JRY").
			queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
			queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
			queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php").
			queryParam("grant_type", "authorization_code").
		when().
			post("https://www.googleapis.com/oauth2/v4/token").
		then().log().all().
			extract().response();
		String accessToken = response.jsonPath().getString("access_token");
		System.out.println(accessToken);
		
		
		Response response2 = 
		given().
			queryParam("access_token", accessToken).
		when().
			get("https://rahulshettyacademy.com/getCourse.php").
		then().log().all().
			extract().response();
		System.out.println(response2.prettyPeek());
		
	}
}
