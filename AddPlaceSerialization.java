package OauthSerializationandDeserialization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class AddPlaceSerialization {
	
public static void main(String args[])
{
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
	
	Response rsp=given().log().all().queryParam("Key", "qaclick123").body(p).when().post("/maps/api/place/add/json")
	.then().assertThat().statusCode(200).extract().response();
	String response=rsp.asString();
	System.out.println(response);
	
	
}
}
