package pojo_nameless_json_array;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import pojo1.Books;
import pojo1.Library;
import utilities.Reusable_Methods;

public class Deserialize_Namless_JsonArray 
{
	@Test
	public void deserialize() throws IOException
	{
		String response = 
				Reusable_Methods.convertRawJsonToString("./src/test/resources/resources/jira/NamelessJSONArray_1.json");
		Gson gs = new Gson();
		Application[] lib = gs.fromJson(response, Application[].class);
	/*	List<Books> books = lib.getBooks();
		for(Books b : books)
		{
			System.out.println(b.getAuthor());
			System.out.println(b.getIsbn());
			System.out.println("==============================");
		}
		*/
		System.out.println(lib);
		for(int i=0; i<lib.length; i++)
		{
			System.out.println(lib[i].getId());
			System.out.println(lib[i].getApplicationID());
			System.out.println("========================");
		}
		
	}
}
