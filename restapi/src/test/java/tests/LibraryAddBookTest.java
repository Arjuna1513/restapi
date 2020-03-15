package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.PayLoad;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class LibraryAddBookTest 
{
	public static String ID = null;
	public static String name = "Artificial Intelligence & ML";
	public static String id = "0000";
	public static String author = "MK1";
	public static String aisle = "1";
	@Test
	public void addBookToLobrary()
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("content-type", "application/json");
		RestAssured.baseURI = "http://216.10.245.166";
		Response response = given().headers(hMap).
		body(new PayLoad().getLibraryAddBookPayload(name, id, author, aisle)).
		when().post("Library/Addbook.php").
		then().extract().response();
		
		//Validations
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getHeader("Server"), "Apache");
		Assert.assertEquals(response.jsonPath().getString("Msg"), "successfully added");
		ID = response.jsonPath().getString("ID");
		System.out.println(response.getBody().prettyPeek());
	}
	
	@Test
	public void getBookByID()
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("content-type", "application/json");
		RestAssured.baseURI = "http://216.10.245.166";
		Response response = 
		given().headers(hMap).
		queryParam("ID", ID).
		when().get("Library/GetBook.php").
		then().extract().response();
		
		//Validations
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getHeader("Server"), "Apache");
		Assert.assertEquals(response.jsonPath().getString("[0].book_name"), name);
		Assert.assertEquals(response.jsonPath().getString("[0].aisle"), aisle);
		Assert.assertEquals(response.jsonPath().getString("[0].isbn"), id);
		Assert.assertEquals(response.jsonPath().getString("[0].author"), author);
		System.out.println(response.getBody().prettyPeek());
	}
}
