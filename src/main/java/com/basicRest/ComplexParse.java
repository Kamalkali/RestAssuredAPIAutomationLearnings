package com.basicRest;

import com.Files.Payload;

import io.restassured.path.json.JsonPath;

public class ComplexParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath Jsp=new JsonPath(Payload.coursePrice());
//Print the number of course in the Json
	int count=Jsp.getInt("courses.size()");
		//Courses is an array it will give 
		System.out.println(count);

		//Print the purchaseamount.
		int Totalamount=Jsp.getInt("dashboard.purchaseAmount");
		//Traverse from Parent to child with.operator
		System.out.println(Totalamount);
		
		//print the title of the firstcourse
		String title=Jsp.get("courses[0].title");
		System.out.println(title);
		
		//print all title and respective Prices.
		for(int i=0;i<count;i++)
		{
    String titleofcourse=Jsp.get("courses["+i+"].title");
    System.out.println(Jsp.get("courses["+i+"].price"));
    //+i+->Writing a variable in between String
    //System.out.println->Always expects String arguments and when we don't know what the line
    //Returns in that case just add ".tostring();
		
	System.out.println(titleofcourse);}
		

	//Print number of copies sold by RPA
		System.out.println("Print number of copies sold by RPA");

	for( int i=0;i<count;i++)
	{
	    String courseTitles=Jsp.get("courses["+i+"].title");

  if(courseTitles.equalsIgnoreCase("RPA"))
  {
  int RPAcopies=Jsp.get("courses["+i+"].copies");
  System.out.println(RPAcopies);
  break;
  
	}

}}}
