package tests;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.PayLoad;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;

public class E2EPlaceInMaps 
{
	
	@Test
	public void addPlaceInMaps(ITestContext context)
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response response = given().queryParam("key", "qaclick123")
		.header("content-type", "application/json")
		.body(new PayLoad().getAppPlacePayLoad())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200)
		.body(
				"status", equalTo("OK"),
				"scope", equalTo("APP"),
				"place_id", hasLength(32)
			  )
		.headers(
				"Access-Control-Allow-Methods", equalTo("POST"),
				"Server",equalTo("Apache/2.4.18 (Ubuntu)"),
				"Content-Type", equalTo("application/json;charset=UTF-8")
			    ).extract().response();
		String place_id = response.jsonPath().getString("place_id");
		System.out.println("Value of place_id ==========>>>>>"+place_id);
		context.setAttribute("plceID",place_id);
	}
	
	
	@Test(dependsOnMethods = "addPlaceInMaps")
	public void updatePlaceInMaps(ITestContext context)
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response response1 = given().queryParam("key", "qaclick123").header("content-type", "application/json")
		.body(new PayLoad().updatePlacePayLoad(context.getAttribute("plceID").toString()))
		.when().put("maps/api/place/update/json")
		.then().extract().response();
		
		System.out.println("======>>>>>>>>>>>>>>   "+response1.getStatusCode());
		Assert.assertEquals(response1.jsonPath().getString("msg"), "Address successfully updated");
//		System.out.println(response1.getBody().prettyPeek());
	}
	
	
	@Test(dependsOnMethods = "updatePlaceInMaps")
	public void getPlace(ITestContext context)
	{
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("key", "qaclick123");
		hMap.put("place_id", context.getAttribute("plceID").toString());
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response response1 = given().log().all()
				/*
				 * .queryParam("key", "qaclick123") .queryParam("place_id",
				 * context.getAttribute("plceID").toString())
				 */
		.queryParams(hMap)
		.header("content-type", "application/json")
		.when().get("maps/api/place/get/json")
		.then().extract().response();
		
		System.out.println("======>>>>>>>>>>>>>>   "+response1.getStatusCode());
		Assert.assertEquals(response1.getStatusCode(), 200);
		System.out.println(response1.getBody().prettyPeek());
		System.out.println(">>>>>>>>>>>>||||||||||||||||<<<<<<<<<<<<<<<");
		System.out.println(response1.jsonPath().getString("location.latitude"));
	}
	
}
