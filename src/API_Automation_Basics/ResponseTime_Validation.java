package API_Automation_Basics;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.internal.common.assertion.AssertParameter;
import io.restassured.response.Response;

public class ResponseTime_Validation 

{
	   @Test
	   public void Demo_1() 
	   {    
		   
		   
		    Response response = RestAssured.get("http://postalpincode.in/api/pincode/110016");
			
			long response_time = response.getTime();
			
			if (response_time > 2000) {
	            throw new AssertionError("Response time exceeded 2000 ms. Actual time: " + response_time + " ms");
	        } 
			
			else {
	            System.out.println("Response time is within acceptable limit.");
	        }
			
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
