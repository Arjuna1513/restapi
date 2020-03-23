package jira;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.Reusable_Methods;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Jira_E2E_Test 
{
	public static String sessionValue = null;
	public static String issueID = null;
	
	@Test
	public void createLoginSession() throws IOException
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("Content-type", "application/json");
		RestAssured.baseURI="http://localhost:8080";
		Response response = given().
		headers(hMap).
		body(Reusable_Methods.convertRawJsonToString("./src/test/resources/resources/jira/CreateSession.json")).
		when().post("rest/auth/1/session").
		then().extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("session.name"), "JSESSIONID");
		Assert.assertTrue(response.jsonPath().getString("session.value").length()==32);
		sessionValue = response.jsonPath().getString("session.value");
		System.out.println(sessionValue);
	}
	
	@Test(dependsOnMethods = "createLoginSession")
	public void createIssue() throws IOException
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("Cookie", "JSESSIONID="+sessionValue);
		hMap.put("Content-Type", "application/json");
		String cookie = "JSESSIONID="+sessionValue;
		System.out.println(cookie);
		RestAssured.baseURI="http://localhost:8080";
		Response response = given().
		headers(hMap).
		body(Reusable_Methods.convertRawJsonToString("./src/test/resources/resources/jira/CreateIssue.json")).
		when().
		post("rest/api/2/issue").
		then().extract().response();
		
		System.out.println(response.getBody().prettyPeek());
		Assert.assertEquals(response.getStatusCode(), 201);
		issueID = response.jsonPath().getString("id");
		
	}
	
	@Test(dependsOnMethods = "getIssue")
	public void deleteIssue() throws IOException
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("Cookie", "JSESSIONID="+sessionValue);
		RestAssured.baseURI="http://localhost:8080";
		Response response = given().
		headers(hMap).
		when().delete("rest/api/2/issue/"+issueID).
		then().extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 204);
	}
	
	@Test(dependsOnMethods = "deleteIssue")
	public void getIssueAfterDeletion() throws IOException
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("Cookie", "JSESSIONID="+sessionValue);
		hMap.put("Content-Type", "application/json");
		RestAssured.baseURI="http://localhost:8080";
		Response response = given().
		headers(hMap).
		when().get("rest/api/2/issue/"+issueID).
		then().extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 404);
		List<Object> list = response.jsonPath().getList("errorMessages");
		JSONArray json = new JSONArray(list);
		System.out.println(json.getString(0));
		Assert.assertEquals(json.getString(0), "Issue Does Not Exist");
	}
	
	
	@Test(dependsOnMethods = "createIssue")
	public void getIssue() throws IOException
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("Cookie", "JSESSIONID="+sessionValue);
		hMap.put("Content-Type", "application/json");
		RestAssured.baseURI="http://localhost:8080";
		Response response = given().
		headers(hMap).
		when().get("rest/api/2/issue/"+issueID).
		then().extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	


}
