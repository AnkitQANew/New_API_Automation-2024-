package API_Automation_Basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Path_Parameters {
	
	
	@Test
	public void path_ParametersDemo1() 
	
	{ 
		   RequestSpecification  request = RestAssured.given();  
		   
		   request.pathParam("mypath", "users");
		
		   request.baseUri("https://reqres.in");
		   request.basePath("/api/{mypath}");
		   
           Response resp =  request.get();
           
           int respCode         =  resp.statusCode();
           
           String statusLine    =  resp.statusLine();
           
           System.out.println("Response Code is _________  "+respCode);
           System.out.println("Status Line   is _________  "+statusLine);
           
           
	}    
		   
		
	
}
