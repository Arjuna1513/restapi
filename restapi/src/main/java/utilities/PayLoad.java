package utilities;

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

	public String getJsonArrayWithoutName()
	{
		return "[\r\n" + 
				"  {\r\n" + 
				"    \"cnt\": 1,\r\n" + 
				"    \"name\": \"American\",\r\n" + 
				"    \"pk\": 7\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"cnt\": 2,\r\n" + 
				"    \"name\": \"Celebrities\",\r\n" + 
				"    \"pk\": 3\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"cnt\": 1,\r\n" + 
				"    \"name\": \"Female\",\r\n" + 
				"    \"pk\": 2\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"cnt\": 1,\r\n" + 
				"    \"name\": \"Language\",\r\n" + 
				"    \"pk\": 8\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"cnt\": 1,\r\n" + 
				"    \"name\": \"Male\",\r\n" + 
				"    \"pk\": 1\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"cnt\": 1,\r\n" + 
				"    \"name\": \"Region\",\r\n" + 
				"    \"pk\": 9\r\n" + 
				"  }\r\n" + 
				"]";
	}

	public String getJsonPayLoad()
	{
		return "{\r\n" + 
				"  \"employees\": [\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"Ram\",\r\n" + 
				"      \"email\": \"ram@gmail.com\",\r\n" + 
				"      \"age\": 23\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"Shyam\",\r\n" + 
				"      \"email\": \"shyam23@gmail.com\",\r\n" + 
				"      \"age\": 28\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"John\",\r\n" + 
				"      \"email\": \"john@gmail.com\",\r\n" + 
				"      \"age\": 33\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"Bob\",\r\n" + 
				"      \"email\": \"bob32@gmail.com\",\r\n" + 
				"      \"age\": 41\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
	}

	public String getNestedJsonPayload()
	{
		return "{\r\n" + 
				"	\"id\": \"0001\",\r\n" + 
				"	\"type\": \"donut\",\r\n" + 
				"	\"name\": \"Cake\",\r\n" + 
				"	\"ppu\": 0.55,\r\n" + 
				"	\"batters\":\r\n" + 
				"		{\r\n" + 
				"			\"batter\":\r\n" + 
				"				[\r\n" + 
				"					{ \"id\": \"1001\", \"type\": \"Regular\" },\r\n" + 
				"					{ \"id\": \"1002\", \"type\": \"Chocolate\" },\r\n" + 
				"					{ \"id\": \"1003\", \"type\": \"Blueberry\" },\r\n" + 
				"					{ \"id\": \"1004\", \"type\": \"Devil's Food\" }\r\n" + 
				"				]\r\n" + 
				"		},\r\n" + 
				"	\"topping\":\r\n" + 
				"		[\r\n" + 
				"			{ \"id\": \"5001\", \"type\": \"None\" },\r\n" + 
				"			{ \"id\": \"5002\", \"type\": \"Glazed\" },\r\n" + 
				"			{ \"id\": \"5005\", \"type\": \"Sugar\" },\r\n" + 
				"			{ \"id\": \"5007\", \"type\": \"Powdered Sugar\" },\r\n" + 
				"			{ \"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\" },\r\n" + 
				"			{ \"id\": \"5003\", \"type\": \"Chocolate\" },\r\n" + 
				"			{ \"id\": \"5004\", \"type\": \"Maple\" }\r\n" + 
				"		]\r\n" + 
				"}";
	}

	public String getDeeplyNestedPayload()
	{
		return "[\r\n" + 
				"  {\r\n" + 
				"    \"id\": \"0001\",\r\n" + 
				"    \"type\": \"donut\",\r\n" + 
				"    \"name\": \"Cake\",\r\n" + 
				"    \"ppu\": 0.55,\r\n" + 
				"    \"batters\": {\r\n" + 
				"      \"batter\": [\r\n" + 
				"        {\r\n" + 
				"          \"id\": \"1001\",\r\n" + 
				"          \"type\": \"Regular\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"id\": \"1002\",\r\n" + 
				"          \"type\": \"Chocolate\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"id\": \"1003\",\r\n" + 
				"          \"type\": \"Blueberry\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"id\": \"1004\",\r\n" + 
				"          \"type\": \"Devil's Food\"\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    \"topping\": [\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5001\",\r\n" + 
				"        \"type\": \"None\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5002\",\r\n" + 
				"        \"type\": \"Glazed\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5005\",\r\n" + 
				"        \"type\": \"Sugar\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5007\",\r\n" + 
				"        \"type\": \"Powdered Sugar\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5006\",\r\n" + 
				"        \"type\": \"Chocolate with Sprinkles\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5003\",\r\n" + 
				"        \"type\": \"Chocolate\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5004\",\r\n" + 
				"        \"type\": \"Maple\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"id\": \"0002\",\r\n" + 
				"    \"type\": \"donut\",\r\n" + 
				"    \"name\": \"Raised\",\r\n" + 
				"    \"ppu\": 0.55,\r\n" + 
				"    \"batters\": {\r\n" + 
				"      \"batter\": [\r\n" + 
				"        {\r\n" + 
				"          \"id\": \"1001\",\r\n" + 
				"          \"type\": \"Regular\"\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    \"topping\": [\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5001\",\r\n" + 
				"        \"type\": \"None\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5002\",\r\n" + 
				"        \"type\": \"Glazed\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5005\",\r\n" + 
				"        \"type\": \"Sugar\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5003\",\r\n" + 
				"        \"type\": \"Chocolate\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5004\",\r\n" + 
				"        \"type\": \"Maple\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"id\": \"0003\",\r\n" + 
				"    \"type\": \"donut\",\r\n" + 
				"    \"name\": \"Old Fashioned\",\r\n" + 
				"    \"ppu\": 0.55,\r\n" + 
				"    \"batters\": {\r\n" + 
				"      \"batter\": [\r\n" + 
				"        {\r\n" + 
				"          \"id\": \"1001\",\r\n" + 
				"          \"type\": \"Regular\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"id\": \"1002\",\r\n" + 
				"          \"type\": \"Chocolate\"\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    \"topping\": [\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5001\",\r\n" + 
				"        \"type\": \"None\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5002\",\r\n" + 
				"        \"type\": \"Glazed\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5003\",\r\n" + 
				"        \"type\": \"Chocolate\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"id\": \"5004\",\r\n" + 
				"        \"type\": \"Maple\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  }\r\n" + 
				"]";
	}

	public String getNestedLibraryPayload()
	{
		return "{\r\n" + 
				"  \"variables\": [],\r\n" + 
				"  \"info\": {\r\n" + 
				"    \"name\": \"Library API\",\r\n" + 
				"    \"_postman_id\": \"e1dd2bdc-85db-8847-9904-1b1b6ea294d8\",\r\n" + 
				"    \"description\": \"\",\r\n" + 
				"    \"schema\": \"https://schema.getpostman.com/json/collection/v2.0.0/collection.json\"\r\n" + 
				"  },\r\n" + 
				"  \"item\": [\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"AddBook\",\r\n" + 
				"      \"request\": {\r\n" + 
				"        \"url\": \"http://216.10.245.166/Library/Addbook.php\",\r\n" + 
				"        \"method\": \"POST\",\r\n" + 
				"        \"header\": [\r\n" + 
				"          {\r\n" + 
				"            \"key\": \"Content-Type\",\r\n" + 
				"            \"value\": \"application/json\",\r\n" + 
				"            \"description\": \"\"\r\n" + 
				"          }\r\n" + 
				"        ],\r\n" + 
				"        \"body\": {\r\n" + 
				"          \"mode\": \"raw\",\r\n" + 
				"          \"raw\": \"{\\r\\n\\r\\n\\\"name\\\":\\\"Learn Appium Automation with Java\\\",\\r\\n\\\"isbn\\\":\\\"bczd\\\",\\r\\n\\\"aisle\\\":\\\"227\\\",\\r\\n\\\"author\\\":\\\"John foe\\\"\\r\\n}\\r\\n \\r\\n\"\r\n" + 
				"        },\r\n" + 
				"        \"description\": \"\"\r\n" + 
				"      },\r\n" + 
				"      \"response\": []\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"GetBookByAuthor\",\r\n" + 
				"      \"request\": {\r\n" + 
				"        \"url\": \"http://216.10.245.166/Library/GetBook.php?AuthorName=Rahul\",\r\n" + 
				"        \"method\": \"GET\",\r\n" + 
				"        \"header\": [],\r\n" + 
				"        \"body\": {},\r\n" + 
				"        \"description\": \"\"\r\n" + 
				"      },\r\n" + 
				"      \"response\": []\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"GetBookByID\",\r\n" + 
				"      \"request\": {\r\n" + 
				"        \"url\": \"http://216.10.245.166/Library/GetBook.php?ID=bczd227\",\r\n" + 
				"        \"method\": \"GET\",\r\n" + 
				"        \"header\": [],\r\n" + 
				"        \"body\": {},\r\n" + 
				"        \"description\": \"\"\r\n" + 
				"      },\r\n" + 
				"      \"response\": []\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"DeleteBook\",\r\n" + 
				"      \"request\": {\r\n" + 
				"        \"url\": \"http://216.10.245.166/Library/DeleteBook.php\",\r\n" + 
				"        \"method\": \"POST\",\r\n" + 
				"        \"header\": [\r\n" + 
				"          {\r\n" + 
				"            \"key\": \"Content-Type\",\r\n" + 
				"            \"value\": \"application/json\",\r\n" + 
				"            \"description\": \"\"\r\n" + 
				"          }\r\n" + 
				"        ],\r\n" + 
				"        \"body\": {\r\n" + 
				"          \"mode\": \"raw\",\r\n" + 
				"          \"raw\": \"{\\r\\n \\r\\n\\\"ID\\\" : \\\"a23h345122332\\\"\\r\\n \\r\\n}\\r\\n\"\r\n" + 
				"        },\r\n" + 
				"        \"description\": \"\"\r\n" + 
				"      },\r\n" + 
				"      \"response\": []\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
	}
	
	public String getLibraryAddBookPayload(String name, String isbn, String author, String aisle)
	{
		return "{\r\n" + 
				"\r\n" + 
				"\"name\":\""+name+"\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\""+author+"\"\r\n" + 
				"}";
	}
	
	public String getLibraryAddBookUsingProvider(String isbn, String aisle)
	{
		return "{\r\n" + 
				"\r\n" + 
				"\"name\":\"DataScience\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"MK\"\r\n" + 
				"}";
	}

	public String getDeleteBookFromLibraryPayload(String ID)
	{
		return "{\r\n" + 
				" \r\n" + 
				"\"ID\" : \""+ID+"\"\r\n" + 
				" \r\n" + 
				"} ";
	}
}
