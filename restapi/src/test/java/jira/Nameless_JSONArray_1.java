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

public class Nameless_JSONArray_1 
{
	/*@Test
	public void parseArray() throws IOException
	{
		String response = Reusable_Methods.convertRawJsonToString
				("./src/test/resources/resources/jira/NamelessJSONArray_1.json");
		JsonPath json = new JsonPath(response);
		List<Object> list = json.getList("$");
		JSONArray ja = new JSONArray(list);
		for(int i=0; i<ja.length(); i++)
		{
			JSONObject jo = ja.getJSONObject(i);
			System.out.println("id : "+jo.getString("id"));
			System.out.println("applicationId : "+ jo.getString("id"));
		}
		System.out.println(list.size());
//		System.out.println(list);
	}
	
	
	@Test
	public void parseArray2() throws IOException
	{
		String response = Reusable_Methods.convertRawJsonToString
				("./src/test/resources/resources/jira/NamelessJSONArray_1.json");
		JsonPath json = new JsonPath(response);
		List<Object> list = json.getList("$");
		for(int i=0; i<list.size(); i++)
		{
			System.out.println("id : "+json.getString("["+i+"].id"));
		}

	}
	
	
	@Test
	public void parseArray3() throws IOException
	{
		String response = Reusable_Methods.convertRawJsonToString
				("./src/test/resources/resources/jira/NamelessJSONArray_1.json");
		JsonPath json = new JsonPath(response);
		List<String> list = json.getList("id");
		for(String s : list)
		{
			System.out.println(s);
		}

	}*/
	
	@Test
	public void parseArray4() throws IOException
	{
		String response = Reusable_Methods.convertRawJsonToString
				("./src/test/resources/resources/jira/NamelessJSONArray_1.json");
		JsonPath json = new JsonPath(response);
		List<Object> list = json.getList("$");
		for(Object o : list)
		{
			Map m = (LinkedHashMap)o;
			System.out.println(m.get("id"));
			System.out.println(m.get("applicationId"));
		}

	}
	
}
