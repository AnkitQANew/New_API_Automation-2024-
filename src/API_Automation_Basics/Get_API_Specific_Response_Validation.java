package API_Automation_Basics;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Get_API_Specific_Response_Validation 
{	
	
	@Test
	public void Validate_Specific_Data_In_Response() 
	{
		RestAssured.baseURI   = "http://postalpincode.in";
		RestAssured.basePath  = "/api/pincode/110016";
		
		  Response apiResponse = RestAssured.get();
		  
		  String resp   = apiResponse.body().path("PostOffice.Name[1]");
		  
		  String resp2  =  apiResponse.jsonPath().get("PostOffice.Name[1]");
		   
		 
		  Assert.assertEquals(resp, "Hauz Khas");
		  
		  System.out.println(resp);
		  
		  System.out.println(apiResponse.prettyPrint());
		  
		  System.out.println("The json path is :::::::::::::::::::"+resp2);
		  
	}

}
