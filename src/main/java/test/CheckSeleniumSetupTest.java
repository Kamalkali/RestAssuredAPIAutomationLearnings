package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CheckSeleniumSetupTest {

@Test
public void url(){
	// TODO Auto-generated method stub

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ckamalkali\\Documents\\chromedriver.exe");
			

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		}
		
	}


