package jira;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import utilities.Reusable_Methods;

public class Nameless_JSONArray_2 
{
	@Test
	public void parseArray() throws IOException
	{
		String response = Reusable_Methods.convertRawJsonToString
				("./src/test/resources/resources/jira/NamelessJSONArray_2.json");
		JsonPath json = new JsonPath(response);
		List<Object> list = json.getList("books");
		JSONArray ja = new JSONArray(list);
		for(int i=0; i<ja.length(); i++)
		{
			JSONObject jo = ja.getJSONObject(i);
			System.out.println("id : "+jo.getString("isbn"));
		}
		System.out.println("=======================================");
	}
	
	
	@Test
	public void parseArray2() throws IOException
	{
		String response = Reusable_Methods.convertRawJsonToString
				("./src/test/resources/resources/jira/NamelessJSONArray_2.json");
		JsonPath json = new JsonPath(response);
		List<Object> list = json.getList("books");
		for(int i=0; i<list.size(); i++)
		{
			System.out.println("id : "+json.getString("books["+i+"].isbn"));
		}
		System.out.println("=======================================");
	}
	
	
	@Test
	public void parseArray3() throws IOException
	{
		String response = Reusable_Methods.convertRawJsonToString
				("./src/test/resources/resources/jira/NamelessJSONArray_2.json");
		JsonPath json = new JsonPath(response);
		/*List<String> list = json.getList("books.isbn");
		for(String s : list)
		{
			System.out.println(s);
		}*/
		List<Object> list = json.getList("books");
		for(Object o : list)
		{
			Map m = (LinkedHashMap)o;
			System.out.println(m.get("isbn"));
			System.out.println(m.get("title"));
			System.out.println(m.get("subtitle"));
		}
	}
	
}
