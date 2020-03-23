package serialization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class Serialize 
{
	@Test
	public void addPlace()
	{
		List<String> list = new ArrayList< String>();
		list.add("shoe park");
		list.add("shop");
		
		Serialize_Add_Place_Json_Request s = new Serialize_Add_Place_Json_Request();
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		s.setLocation(l);
		
		s.setAccuracy(50);
		s.setName("Brigade Magnum");
		s.setPhone_number("(+91) 983 893 3937");
		s.setAddress("TataNagara Devinagara, 5th main 1st cross");
		s.setTypes(list);
		s.setWebsite("http://google.com");
		s.setLanguage("French-IN");
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response response = 
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
	}
}
