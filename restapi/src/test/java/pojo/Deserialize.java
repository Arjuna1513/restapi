package pojo;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class Deserialize 
{
	@Test
	public void deserialize()
	{
		Response response = 
				given().log().all().urlEncodingEnabled(false).
					queryParam("code","4%2FxwGzuuJuLcKtMcbhLDwRVB0NYg0ZcqIaouhLK0vdFV0Gn41AhP5EL4oNNIFaLb8vjGfjYVY1-KPX8lAAGoiaF_Y").
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
				
				
				Courses_Json_response cjr = 
				given().
					queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON).
				when().
					get("https://rahulshettyacademy.com/getCourse.php").as(Courses_Json_response.class);
				System.out.println("Printing the values of all fields after deserialization");
				System.out.println(cjr.getInstructor());
				System.out.println(cjr.getUrl());
				System.out.println(cjr.getServices());
				System.out.println(cjr.getExpertise());
				System.out.println(cjr.getLinkedIn());
				List<WebAutomation> list = cjr.getCourses().getWebAutomation();
				for(WebAutomation i : list)
				{
					System.out.println(i.getCourseTitle());
					System.out.println(i.getPrice());
				}
				
				List<Api> list1 = cjr.getCourses().getApi();
				for(Api i : list1)
				{
					System.out.println(i.getCourseTitle());
					System.out.println(i.getPrice());
				}
				
				List<Mobile> list2 = cjr.getCourses().getMobile();
				for(Mobile i : list2)
				{
					System.out.println(i.getCourseTitle());
					System.out.println(i.getPrice());
				}
				
				System.out.println(cjr.getCourses().getApi().get(1).getCourseTitle());
	}
}
