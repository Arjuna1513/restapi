package tests;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import utilities.PayLoad;

public class EmployeeJsonEx1 
{
	@Test
	public void processJsonArray()
	{
		String response = new PayLoad().getJsonPayLoad();
		JsonPath js = new JsonPath(response);
		List<Object> list = js.getList("employees");
		JSONArray json = new JSONArray(list);
		int arrayLen = json.length();
		System.out.println(arrayLen);
		for(int i=0; i<arrayLen; i++)
		{
			JSONObject jobj = json.getJSONObject(i);
			System.out.println(jobj.get("name"));
		}
	}
}
