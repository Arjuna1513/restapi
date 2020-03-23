package responseSpecificationBuilder;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utilities.Reusable_Methods;

public class RequestSpecBuilder_Exercise 
{
	@Test
	public void reqSpecBuilder() throws IOException
	{
		RequestSpecification reqSpecBld = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
								setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();
		
		ResponseSpecification respSpecBld = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		Response response = given().spec(reqSpecBld).
			body(Reusable_Methods.convertRawJsonToString("./src/test/resources/resources/AddPlace.json")).
			when().post("/maps/api/place/add/json").then().spec(respSpecBld).extract().response();
		
//		Assert.assertTrue(response.getStatusCode()==200);
		System.out.println(response.prettyPeek());
		Assert.assertEquals(response.getHeader("Content-Type"),"application/json;charset=UTF-8");
	}
}
