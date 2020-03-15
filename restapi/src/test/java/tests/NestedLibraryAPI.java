package tests;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utilities.PayLoad;

public class NestedLibraryAPI 
{
	@Test
	public void displayHeadersFromComplexLibraryApi()
	{
		String response = new PayLoad().getNestedLibraryPayload();
		JsonPath js = new JsonPath(response);
		List<Object> list = js.getList("item");
		JSONArray ja1 = new JSONArray(list);
		for(int i=0; i<ja1.length(); i++)
		{
			JSONObject jo1 = ja1.getJSONObject(i);
			JSONObject jo2 = jo1.getJSONObject("request");
			JSONArray ja2 = jo2.getJSONArray("header");
			for(int j=0; j<ja2.length(); j++)
			{
				JSONObject jo3 = ja2.getJSONObject(j);
				System.out.println(jo3.getString("key"));
				System.out.println(jo3.getString("value"));
			}
		}
	}
}
