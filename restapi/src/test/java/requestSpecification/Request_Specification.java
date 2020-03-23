package requestSpecification;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import serialization.Location;
import serialization.Serialize_Add_Place_Json_Request;
import utilities.Reusable_Methods;

public class Request_Specification 
{
	@Test
	public void addPlce_Using_Request_Specification() throws IOException
	{
			RestAssured.baseURI = "https://rahulshettyacademy.com";
			RequestSpecification reqSpec = 
					given().queryParam("key", "qaclick123").
				header("Content-Type","application/json").
				body(Reusable_Methods.convertRawJsonToString("./src/test/resources/resources/AddPlace.json"));
					
			Response response = reqSpec.when().post("/maps/api/place/add/json").
			then().extract().response();
			
			Assert.assertTrue(response.getStatusCode()==200);
			System.out.println(response.prettyPeek());
			Assert.assertEquals(response.getHeader("Content-Type"),"application/json;charset=UTF-8");
			
			
		
			
		/*	Response response = 
					given().
						log().all().
						queryParam("key", "qaclick123").
						header("Content-Type", "application/json").
						body(s).
					when().
						post("/maps/api/place/add/json").
					then().
						log().all().
						extract().response();
						*/
		
	}
}
