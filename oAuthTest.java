package com.oAuthTest;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class oAuthTest {
	public static void main(String[] args) throws InterruptedException {

	String url ="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2F4QElDar4HmqcNAmAwJn9fZLgc85w42yDD37RfoOms3w8xc45RsAZD2XTWt2mFqbCox9mnV4YtchiUR9hdk-_rWQ&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent#";


	String partialcode=url.split("code=")[1];
	String code=partialcode.split("&scope")[0];
	System.out.println(code);
	
	
	//   tagname[attribute='value']
	
String accessTokenResponse=	given().urlEncodingEnabled(false)
.queryParams("code",code)
.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
.queryParams("grant_type","authorization_code")
.when().log().all()
.post("https://www.googleapis.com/oauth2/v4/token").asString();
JsonPath js=new JsonPath(accessTokenResponse);
String accessToken=js.getString("access_token");
}}