package files;

public class PayLoad 
{
	public String getAppPlacePayLoad()
	{
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383111,\r\n" + 
				"    \"lng\": 33.427111\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"kkhi Residancy\",\r\n" + 
				"  \"phone_number\": \"(+91) 9999999999\",\r\n" + 
				"  \"address\": \"9th main, 1st cross tatanagar Devinagar\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"House\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}";
	}
	
	
	public String updatePlacePayLoad(String plceID)
	{
		return "{\r\n" + 
				"\"place_id\":\""+plceID+"\",\r\n" + 
				"\"address\":\"XXXXXXX XXXXXXXXxxx\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}";
	}
	
	public String getLittleComplexJson()
	{
		return "{\r\n" + 
				"\"dashboard\": \r\n" + 
				"{\r\n" + 
				"\"purchaseAmount\": 910,\r\n" + 
				"\"website\": \"rahulshettyacademy.com\"\r\n" + 
				"},\r\n" + 
				"\"courses\": [\r\n" + 
				"{\r\n" + 
				"\"title\": \"Selenium Python\",\r\n" + 
				"\"price\": 50,\r\n" + 
				"\"copies\": 6\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"title\": \"Cypress\",\r\n" + 
				"\"price\": 40,\r\n" + 
				"\"copies\": 4\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"title\": \"RPA\",\r\n" + 
				"\"price\": 45,\r\n" + 
				"\"copies\": 10\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}";
	}
}
