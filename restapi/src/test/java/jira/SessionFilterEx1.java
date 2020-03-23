package jira;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import utilities.Reusable_Methods;

public class SessionFilterEx1 
{
	SessionFilter session = new SessionFilter();
	@Test
	public void createLoginSession() throws IOException
	{
		SessionFilter session = new SessionFilter();
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("Content-type", "application/json");
		RestAssured.baseURI="http://localhost:8080";
		Response response = given().
		headers(hMap).
		body(Reusable_Methods.convertRawJsonToString("./src/test/resources/resources/jira/CreateSession.json")).
		filter(session).
		when().post("rest/auth/1/session").
		then().extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("session.name"), "JSESSIONID");
		Assert.assertTrue(response.jsonPath().getString("session.value").length()==32);
		String sessionValue = response.jsonPath().getString("session.value");
		System.out.println(sessionValue);
		
		//////////////////////////////
		RestAssured.baseURI="http://localhost:8080";
		Response response1 = given().log().all().
		headers(hMap).
		body(Reusable_Methods.convertRawJsonToString("./src/test/resources/resources/jira/CreateIssue.json")).
		filter(session).
		when().
		post("rest/api/2/issue").
		then().extract().response();
		
		System.out.println(response1.getBody().prettyPeek());
		Assert.assertEquals(response1.getStatusCode(), 201);
	}
}
