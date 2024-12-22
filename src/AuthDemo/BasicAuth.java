package AuthDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuth 
{
	
	
	//@Test // Non - Preemptive 
	public void basicAuth_NONPreemptive() 
	
	{
		  RequestSpecification requestSpec  =  RestAssured.given();
		  
			requestSpec.baseUri("http://postman-echo.com");
			requestSpec.basePath("/basic-auth");
			
		    Response resp  = 	requestSpec.auth().basic("postman", "password").get();
		    
		    System.out.println("Response Status   " + resp.getStatusLine());
		                      
	}
	
	//@Test
	public void basicAuth_Preemptive() 
	
	{
		RequestSpecification requestSpec  =  RestAssured.given();
		  
		requestSpec.baseUri("http://postman-echo.com");
		requestSpec.basePath("/basic-auth");
		
	    Response resp  = 	requestSpec.auth().preemptive().basic("postman", "password").get();
	    
	    System.out.println("Response Status   " + resp.getStatusLine());
		
	}
	
	@Test
	public void DigestAuth()
	
	{
		
		RequestSpecification requestSpec  =  RestAssured.given();
		  
		requestSpec.baseUri("http://httpbin.org");
		requestSpec.basePath("/digest-auth/undefined/ankit/ankit");
		
	    Response resp  = 	requestSpec.auth().digest("ankit", "ankit").get();
	    
	    System.out.println("Response Status   " + resp.getStatusLine());
		
		
	}
	

}
