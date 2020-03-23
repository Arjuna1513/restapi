package pojo1;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.path.json.JsonPath;
import utilities.Reusable_Methods;

public class Deserialize_JSON_POJO 
{
	@Test
	public void deserialize() throws IOException
	{
		String response = 
				Reusable_Methods.convertRawJsonToString("./src/test/resources/deserialize/deserialize_ex1.json");
		Gson gs = new Gson();
		Library lib = gs.fromJson(response, Library.class);
		List<Books> books = lib.getBooks();
		for(Books b : books)
		{
			System.out.println(b.getAuthor());
			System.out.println(b.getIsbn());
			System.out.println("==============================");
		}
		
	}
}
