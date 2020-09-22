package com.SpecificationBuider;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class RequestAndResponseSpecificationBuilder {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		AddPlace p=new AddPlace();
		p.setAccuracy(50);
		p.setName("Frontline house");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		p.setLanguage("French-IN");
		p.setAddress("29, side layout, cohen 09");
		List<String> mylist=new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		p.setTypes(mylist);
			Location l=new Location();
			l.setLat(-38.383494);
			l.setLng(33.427362);
			
			p.setLocation(l);
			
		RequestSpecification Req=new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
			.addQueryParam("Key", "qaclick123")
			.setContentType(ContentType.JSON).build();
		
		ResponseSpecification Resp=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
		.build();
		
		
		RequestSpecification rsp=given().spec(Req)
				.body(p);
		
		Response Rspe=rsp.
				when().post("/maps/api/place/add/json")
		.then().spec(Resp).extract().response();
		
		String response=Rspe.asString();
		System.out.println(response);
		
		
	
	

	}

}
