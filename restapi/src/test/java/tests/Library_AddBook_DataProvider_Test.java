package tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.PayLoad;

public class Library_AddBook_DataProvider_Test 
{
	public static ArrayList<String> list = new ArrayList<String>();
	public static String ID = null;
	
	@Test(dataProvider = "dataProvider")
	public void addBookToLobrary(String isbn, String aisle)
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("content-type", "application/json");
		RestAssured.baseURI = "http://216.10.245.166";
		Response response = given().headers(hMap).
		body(new PayLoad().getLibraryAddBookUsingProvider(isbn,aisle)).
		when().post("Library/Addbook.php").
		then().extract().response();
		
		//Validations
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getHeader("Server"), "Apache");
		Assert.assertEquals(response.jsonPath().getString("Msg"), "successfully added");
		ID = response.jsonPath().getString("ID");
		list.add(ID);
		System.out.println(response.getBody().prettyPeek());
	}
	
	@Test(dataProvider = "deleteBooks")
	public void deleteBooksFromLibrary(String bookID)
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("content-type", "application/json");
		RestAssured.baseURI = "http://216.10.245.166";
		Response response = given().headers(hMap).
		body(new PayLoad().getDeleteBookFromLibraryPayload(bookID)).
		when().post("Library/DeleteBook.php").
		then().extract().response();
		
		//Validations
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getHeader("Server"), "Apache");
		Assert.assertEquals(response.jsonPath().getString("msg"), "book is successfully deleted");
		System.out.println(response.getBody().prettyPeek());
	}
	
	@Test(dataProvider = "getBooks")
	public void getBookFromLibrary(String bookID)
	{
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("content-type", "application/json");
		RestAssured.baseURI = "http://216.10.245.166";
		Response response = given().headers(hMap).
		queryParam("ID", bookID).
		body(new PayLoad().getDeleteBookFromLibraryPayload(bookID)).
		when().get("/Library/GetBook.php").
		then().extract().response();
		
		//Validations
		Assert.assertEquals(response.getStatusCode(), 404);
		Assert.assertEquals(response.getHeader("Server"), "Apache");
		Assert.assertEquals(response.jsonPath().getString("msg"), "The book by requested bookid / author name does not exists!");
		System.out.println(response.getBody().prettyPeek());
	}
	
	@DataProvider
	public Object[][] dataProvider()
	{
		return new Object[][]  {
									{"RM222","1"},
									{"RM223","1"},
									{"RM224","1"},
									{"RM225","1"}
								};
	}
	
	@DataProvider
	public Object[][] deleteBooks()
	{
		 Object[][] obj = new Object[list.size()][1]; 
		  for(int i=0; i<list.size(); i++)
		  {
			  obj[i][0] = list.get(i);
		  }
		  return obj;
	}
	
	@DataProvider
	public Object[][] getBooks()
	{
		 Object[][] obj = new Object[list.size()][1]; 
		  for(int i=0; i<list.size(); i++)
		  {
			  obj[i][0] = list.get(i);
		  }
		  return obj;
	}
}
