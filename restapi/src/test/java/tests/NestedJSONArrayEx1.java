package tests;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import utilities.PayLoad;

public class NestedJSONArrayEx1 
{
	@Test
	public void nestedJSONArray()
	{
		String response = new PayLoad().getNestedJsonPayload();
		JsonPath js = new JsonPath(response);
		List<Object> list = js.getList("batters.batter");
		JSONArray arr = new JSONArray(list);
		for(int i=0; i<arr.length(); i++)
		{
			JSONObject obj = arr.getJSONObject(i);
			System.out.println(obj.getString("id"));
		}
		
		System.out.println("=======>>>>>>>>||||||||||<<<<<<<<=======");
		
		List<Object> list1 = js.getList("topping");
		JSONArray arr1 = new JSONArray(list);
		for(int i=0; i<arr1.length(); i++)
		{
			JSONObject obj1 = arr1.getJSONObject(i);
			System.out.println(obj1.getString("type"));
		}
		
	}
}
