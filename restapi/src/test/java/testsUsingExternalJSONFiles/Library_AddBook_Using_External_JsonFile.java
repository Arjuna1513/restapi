package testsUsingExternalJSONFiles;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.PayLoad;
import utilities.Reusable_Methods;

public class Library_AddBook_Using_External_JsonFile 
{
	@Test
	public void addBook_Using_Extrnl_Json_File() throws IOException
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("content-type", "application/json");
		
		RestAssured.baseURI = "http://216.10.245.166";
		Response response = given().headers(hMap).
		body(Reusable_Methods.convertRawJsonToString("./src/test/resources/resources/addBook.json")).
		when().post("Library/Addbook.php").
		then().extract().response();
		
		//Validations
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getHeader("Server"), "Apache");
		Assert.assertEquals(response.jsonPath().getString("Msg"), "successfully added");
		System.out.println(response.getBody().prettyPeek());
	}
}
