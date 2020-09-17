package com.Files;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ReusableFiles.Resusablefiles;



public class DynamicJson {

	//public static void main(String[] args) {
	@Test(dataProvider="BooksData")
	public void addBook(String isbn,String aisle)
	{
	//{
		RestAssured.baseURI="http://216.10.245.166" ;
		String rsp=given().header("Content-Type","application/json").
		body(Payload.Addbook(isbn,aisle))
		.when().post("Library/Addbook.php").then().log().all()
		.assertThat().statusCode(200)
		.extract().response().asString();
		System.out.println(rsp);
		JsonPath js=Resusablefiles.rawtoJson(rsp);
		String place=js.getString("ID");
		System.out.println(place);
		
	}
	@DataProvider(name="BooksData")

	public Object[][]  getData()
	{
		return new Object[][] {{"bcs","6465"},{"nhb","897"}};
	}
}
