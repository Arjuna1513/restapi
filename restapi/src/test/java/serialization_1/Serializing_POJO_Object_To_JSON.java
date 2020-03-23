package serialization_1;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Serializing_POJO_Object_To_JSON 
{
	@Test
	public void serializePOJO()
	{
		List<Books> list = new ArrayList<Books>();
		
		Books b1 = new Books("111","Java","Core Java", "Malli", "2014", "My Printing Press", 100, "Java", "google.com");
		Books b2 = new Books("111","C","Core Java", "Malli", "2014", "My Printing Press", 100, "Java", "google.com");
		Books b3 = new Books("111","C#","Core Java", "Malli", "2014", "My Printing Press", 100, "Java", "google.com");
		Books b4 = new Books("111","Python","Core Java", "Malli", "2014", "My Printing Press", 100, "Java", "google.com");
		Books b5 = new Books("111","Kannada","Core Java", "Malli", "2014", "My Printing Press", 100, "Java", "google.com");
		Books b6 = new Books("111","English","Core Java", "Malli", "2014", "My Printing Press", 100, "Java", "google.com");
		Books b7 = new Books("111","Telugu","Core Java", "Malli", "2014", "My Printing Press", 100, "Java", "google.com");
		
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);
		list.add(b6);
		list.add(b7);
		
		Library l = new Library();
		l.setBooks(list);
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response response = 
				given().
					log().all().
					queryParam("key", "qaclick123").
					header("Content-Type", "application/json").
					body(l).
				when().
					post("/maps/api/place/add/json").
				then().
//					log().all().
					extract().response();
	}
}
