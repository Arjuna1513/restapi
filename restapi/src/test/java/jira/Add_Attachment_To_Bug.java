package jira;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.Reusable_Methods;

public class Add_Attachment_To_Bug 
{
	public static String sessionID = null;
	public static String issueID = null;
	
	@Test
	public void createSession() throws IOException
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("Content-Type", "application/json");
		RestAssured.baseURI = "http://localhost:8080";
		Response response = 
		given().
			headers(hMap).
			body(Reusable_Methods.convertRawJsonToString("./src/test/resources/resources/jira/CreateSession.json")).
		when().
			post("rest/auth/1/session").
		then().
			extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		sessionID = response.jsonPath().getString("session.value");
	}
	
	@Test(dependsOnMethods = "createSession")
	public void createIssue() throws IOException
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("Content-Type", "application/json");
		hMap.put("Cookie", "JSESSIONID="+sessionID);
		
		RestAssured.baseURI = "http://localhost:8080";
		Response response = 
		given().
			headers(hMap).
			body(Reusable_Methods.convertRawJsonToString("./src/test/resources/resources/jira/CreateIssue.json")).
		when().
			post("rest/api/2/issue").
		then().
			extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 201);
		issueID = response.jsonPath().getString("key");
	}
	
	@Test(dependsOnMethods = "createIssue")
	public void addComment() throws IOException
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("Content-Type", "application/json");
		hMap.put("Cookie", "JSESSIONID="+sessionID);
		
		RestAssured.baseURI = "http://localhost:8080";
		Response response = 
		given().
			headers(hMap).
			pathParam("key",issueID).
			body(Reusable_Methods.convertRawJsonToString("./src/test/resources/resources/jira/AddComment.json")).
		when().
			post("rest/api/2/issue/{key}/comment").
		then().
			extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 201);
	}
	
	@Test(dependsOnMethods = "createIssue")
	public void addAttachment() throws IOException
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("Content-Type", "multipart/form-data");
		hMap.put("Cookie", "JSESSIONID="+sessionID);
		hMap.put("X-Atlassian-Token", "no-check");
		
		RestAssured.baseURI = "http://localhost:8080";
		Response response = 
		given().
			headers(hMap).
			pathParam("key",issueID).
			multiPart("file", new File("./src/test/resources/resources/jira/jellyfish.mp4")).
			body(Reusable_Methods.convertRawJsonToString("./src/test/resources/resources/jira/CreateSession.json")).
		when().
			post("rest/api/2/issue/{key}/attachments").
		then().
			extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
