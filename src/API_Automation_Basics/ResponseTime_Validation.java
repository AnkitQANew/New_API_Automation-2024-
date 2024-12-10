package API_Automation_Basics;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseTime_Validation 

{
	   @Test
	   public void Demo_1() 
	   {
		    Response response = RestAssured.get("http://postalpincode.in/api/pincode/110016");
			
			var response_time = response.getTime();
			
			System.out.println("The API Response time is  "+response_time);
	   }

	   @Test
	   public void Demo_2()
	   
	   {
		   Response response = RestAssured.get("http://postalpincode.in/api/pincode/110016");
		   
		   SoftAssert objAssert = new SoftAssert ();
		   
		   objAssert.assertTrue(response.getTimeIn(TimeUnit.MILLISECONDS)<1000, "API is taking more time to response");
		   
		   objAssert.assertAll();
		   
	   }

}
