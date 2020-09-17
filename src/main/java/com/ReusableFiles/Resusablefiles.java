package com.ReusableFiles;

import io.restassured.path.json.JsonPath;

public class Resusablefiles {

	
	public static JsonPath rawtoJson(String response)
	{
		JsonPath Jsp=new JsonPath(response);
		return Jsp;

	}
}
