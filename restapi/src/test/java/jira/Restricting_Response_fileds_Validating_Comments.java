package jira;

import static io.restassured.RestAssured.given;

//import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.Reusable_Methods;

public class Restricting_Response_fileds_Validating_Comments 
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
	
	@Test
	public void getIssue() throws IOException
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("Cookie", "JSESSIONID="+sessionID);
		hMap.put("Content-Type", "application/json");
		RestAssured.baseURI="http://localhost:8080";
		Response response = 
				given().
					headers(hMap).
					queryParam("fields", "comment").
				when().
					get("rest/api/2/issue/MYF-18").
				then().
					log().all().extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getInt("fields.comment.maxResults"), 4);
		Assert.assertEquals(response.jsonPath().getInt("fields.comment.total"), 4);
		List<Object> list = response.jsonPath().getList("fields.comment.comments");
		JSONArray ja = new JSONArray(list);
		for(int i=0; i<ja.length(); i++)
		{
			JSONObject jo = ja.getJSONObject(i);
			System.out.println(jo.getString("id"));
			System.out.println(jo.getString("self"));
			System.out.println(jo.getString("body"));
			System.out.println(jo.getString("created"));
			System.out.println(jo.getString("updated"));
			
			JSONObject author = jo.getJSONObject("author");
			System.out.println(author.getString("name"));
			
			JSONObject upAuthor = jo.getJSONObject("author");
			System.out.println(upAuthor.getString("key"));
			
			JSONObject visibility = jo.getJSONObject("visibility");
			System.out.println(visibility.getString("value"));
			System.out.println("============================================");
		}
	}
	
	
	
/*	@Test(dependsOnMethods = "createSession")
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
	*/
}
