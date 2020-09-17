package com.basicRest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Files.Payload;

import io.restassured.path.json.JsonPath;

public class SumValidation {

@Test
public void check() {
		int sum=0;
		JsonPath jsp=new JsonPath(Payload.coursePrice());
		int count=jsp.getInt("courses.size()");
		for(int i=0;i<count;i++)
		{
        int prices=jsp.getInt("courses["+i+"].price");
        int copies=jsp.getInt("courses["+i+"].copies");
        int amount=prices*copies;
        System.out.println(amount);
        sum=sum+amount;
		}
		System.out.println(sum);
		int purchaseAmount =jsp.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
	}
	
}
