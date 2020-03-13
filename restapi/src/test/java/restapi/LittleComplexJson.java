package restapi;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class LittleComplexJson 
{
	@Test
	public void processComplexJson()
	{
		String response = new PayLoad().getLittleComplexJson();
		JsonPath js = new JsonPath(response);
		int size = js.getList("courses").size();
		int ttl = 0;
		for(int i=0; i<size; i++)
		{
			System.out.println(i +"th index title  is :"+ js.get("courses["+i+"].title"));
			System.out.println(i +"th index price  is :"+ js.get("courses["+i+"].price"));
			System.out.println(i +"th index copies is :"+ js.get("courses["+i+"].copies"));
			ttl = ttl + (js.getInt("courses["+i+"].price") * js.getInt("courses["+i+"].copies"));
			System.out.println("=====================================================");
		}
		System.out.println("Total purchase amount is: "+ttl);
		Assert.assertTrue(ttl == js.getInt("dashboard.purchaseAmount"));
	}
}
