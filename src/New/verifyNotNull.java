package New;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class verifyNotNull {
	
	@Test
	public void verify_not_Null_inResponse() 
	{
		
		RestAssured.baseURI   = "http://postalpincode.in";
		RestAssured.basePath  = "/api/pincode/110016";
		
		
		  Response response = RestAssured.get();
		  
		 String data   = response.body().path("PostOffice[0].District");
		 
		 assertNotNull(data, "Field 'fieldName' should not be null!");
		  
		  

		  
		 
		  
	}

}
