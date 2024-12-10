package API_Automation_Basics;


import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_API_With_Complex_Payload 
{
////////////**************** Below is JSON Payload *****************************//////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/*{
 "firstName" : "Ankit",
 "lastName"  : "Srv",
 "gender"    : "Male",
 "age"       : 25,
 "salary"    : 10000.30,
 "hobby"     : ["singing", "writing", "cricket"],
 "Address"   : {
        "Street": "Arifac Avenue",
	"City": "RK Puram, Delhi",
	"State": "New Delhi",
	"pincode":110066
                 }
                 
    ___________________________________________________________________________             
                 Note : Use below dependency to access JSON Array 
                 
                 <dependency>
  		<groupId>org.json</groupId>
  		<artifactId>json</artifactId>
  		<version>20190722</version>
  	    </dependency>
   
}
*/
	
	@Test
	public void PostCall() 
	{	
              RequestSpecification request   =  RestAssured.given();
              request.contentType(ContentType.JSON);
              
              JSONArray  Hobby = new JSONArray ();
              
              Hobby.put("Singing");
              Hobby.put("Swiming");
              Hobby.put("Planting");
              
              Map <String, Object> address = new HashMap <> ();
              
              address.put("Street", "Arifac Avenue");
              address.put("City", "New Delhi");
              address.put("State", "New Delhi");
              address.put("pincode", "110016");
              
              JSONObject obj_JSON = new JSONObject ();
              
 		     obj_JSON.put("firstName", "AnkitA");
 		     obj_JSON.put("lastName", "SRV");
 		     obj_JSON.put("gender", "male");
 		     obj_JSON.put("age", 55);
 		     obj_JSON.put("salary",33333.00);
 		     obj_JSON.put("hobby", Hobby);
 		     obj_JSON.put("Address", address);
 		     
 		    request.body(obj_JSON.toString());
 		    
		     
		     Response resp  = request.post("http://httpbin.org/post");
		     
		     System.out.println("The response code is ******************"+resp.getStatusCode());
		     System.out.println("The Statud Line is   ******************"+resp.getStatusLine());
		     
		     System.out.println(resp.prettyPrint());
		     
	}	     
              
	
	
}
