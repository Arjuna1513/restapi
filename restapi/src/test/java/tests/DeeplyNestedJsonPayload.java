package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import utilities.PayLoad;

public class DeeplyNestedJsonPayload 
{
	@Test
	public void read_DeeplyNested_JsonArray_Content()
	{
		String response = new PayLoad().getDeeplyNestedPayload();
		JSONArray j1 = new JSONArray(response);
		for(int i=0; i<j1.length(); i++)
		{
			JSONObject o1 = j1.getJSONObject(i);
			JSONArray j2 = o1.getJSONObject("batters").getJSONArray("batter");
			for(int j=0; j<j2.length(); j++)
			{
				System.out.println(j2.getJSONObject(j).getString("id"));
			}
			
			JSONArray j3 = o1.getJSONArray("topping");
			for(int k=0; k<j3.length(); k++)
			{
				System.out.println(j3.getJSONObject(k).getString("id"));
			}
		}
	}
}
