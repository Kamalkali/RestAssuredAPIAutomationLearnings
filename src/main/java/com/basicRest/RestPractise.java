package com.basicRest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import com.Files.Payload;
import com.ReusableFiles.Resusablefiles;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class RestPractise {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
		//given belongs to static Rest assured package
		//Given-Input all details.
		//when-Resource and HTTP method
		
		//Add a place
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\ckamalkali\\eclipse-workspace\\RestAssureTraining\\AddPlacee.json")))).when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server","Apache/2.4.18 (Ubuntu)").extract().response().asString();
		System.out.println(response);
		//get the placeid from the response.
		//parse=breaks data into smaller component for easy translation.
		JsonPath js=Resusablefiles.rawtoJson(response);
      String place=js.getString("place_id");
		System.out.println(place);
		
		//update the place
		String newplace="NorthEast";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+place+"\",\r\n" + 
				"\"address\":\""+newplace+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").when().put("/maps/api/place/update/json").then().assertThat().log()
		.all().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		
		//get the place
		
		String GetResponse=given().log().all().queryParam("key", "qaclick123").queryParam("place_id" ,place)
		.when().get("/maps/api/place/get/json").then().assertThat().log()
		.all().statusCode(200).extract().response().asString();
		
		JsonPath Jsp=Resusablefiles.rawtoJson(GetResponse);
		String actualaddress=Jsp.getString("address");
		System.out.println(actualaddress);
	  Assert.assertEquals(actualaddress,newplace);	
  


	}

}
