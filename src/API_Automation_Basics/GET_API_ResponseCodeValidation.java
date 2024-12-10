package API_Automation_Basics;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_API_ResponseCodeValidation {
    
    
	@Test
	public void get_API_ResponseCodeValidation() {
		
		RestAssured.baseURI   = "http://postalpincode.in";
		RestAssured.basePath  = "/api/pincode/110016";
		
		
		  Response response = RestAssured.get();
		
		  int responseCode = response.getStatusCode();
		  
		  Assert.assertEquals(responseCode, 200);
		
          System.out.println(response.prettyPrint());

	}

}
