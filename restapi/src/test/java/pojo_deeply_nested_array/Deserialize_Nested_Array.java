package pojo_deeply_nested_array;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import pojo_nameless_json_array.Application;
import utilities.Reusable_Methods;

public class Deserialize_Nested_Array 
{
	@Test
	public void deserialize_deeply_nested_json_array() throws IOException
	{
		String response = 
				Reusable_Methods.convertRawJsonToString("./src/test/resources/resources/DeeplyNestedJsonPayload.json");
		Gson gs = new Gson();
		Bakery[] lib = gs.fromJson(response, Bakery[].class);
		System.out.println(lib.length);
		for(int i=0; i<lib.length; i++)
		{
			List<Batter> bat = lib[i].getBatters().getBatter();
			for(Batter b : bat)
			{
				System.out.println(b.getId());
				System.out.println(b.getType());
			}
			System.out.println("|||||||||||||||||");
			List<Topping> top = lib[i].getTopping();
			for(Topping t : top)
			{
				System.out.println(t.getId());
				System.out.println(t.getType());
			}
			System.out.println("============================");
		}
	}
}
