package jira;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import utilities.Reusable_Methods;

public class Nameless_Json_Array_3 
{
	@Test
	public void parseArray() throws IOException
	{
		String response = Reusable_Methods.convertRawJsonToString
				("./src/test/resources/resources/DeeplyNestedJsonPayload.json");
		JsonPath json = new JsonPath(response);
		List<Object> list = json.getList("$");
		for(Object o : list)
		{
			Map<String, Object> m = (LinkedHashMap)o;
				System.out.println(m.get("id"));
				System.out.println(m.get("type"));
				System.out.println(m.get("name"));
				System.out.println(m.get("ppu"));
				
				Map m1 = (LinkedHashMap)m.get("batters");
					List<Object> list2 = (List<Object>) m1.get("batter");
					System.out.println("Batter array objects");
						for(Object o1 : list2)
						{
//							System.out.println(o1);
							Map<String, Object> m2 = (LinkedHashMap)o1;
							System.out.println("id : "+m2.get("id"));
							System.out.println("type : "+m2.get("type"));
						}
				List<Object> list3 = (List<Object>) m.get("topping");
				System.out.println("topping array objects");
					for(Object o2 : list3)
					{
						Map m3 = (LinkedHashMap)o2;
						System.out.println("id : "+m3.get("id"));
						System.out.println("type : "+m3.get("type"));
					}
//			System.out.println(m.get("topping"));
			System.out.println("================||||||||||||||||||||||||||=================");
		}
	}
}
