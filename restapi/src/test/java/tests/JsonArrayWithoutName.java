package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import utilities.PayLoad;

public class JsonArrayWithoutName 
{
	@Test
	public void processJsonArrayWithoutName()
	{
		String response = new PayLoad().getJsonArrayWithoutName();
		JsonPath js = new JsonPath(response);
		JSONArray json = new JSONArray(response);
		int arrayLen = json.length();
		System.out.println(arrayLen);
		for(int i=0; i<arrayLen; i++)
		{
			JSONObject jobj = json.getJSONObject(i);
			System.out.println(jobj.get("name"));
		}
	}
}
