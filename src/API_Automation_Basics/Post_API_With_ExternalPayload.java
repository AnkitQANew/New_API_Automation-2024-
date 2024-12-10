package API_Automation_Basics;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_API_With_ExternalPayload 
{
	
	@Test
	public void Demo1() 
	{	
		
		File objfile = new File (".//src//JSON_Files//PostCall_Paylpad.JSON");		
		//File objfile = new File (".//src//JSON_Files//EmpDATA");
		
		RequestSpecification request   =  RestAssured.given();
        request.contentType(ContentType.JSON);
        
        request.body(objfile);
        
        Response resp  = request.post("http://httpbin.org/post");
	     
	     System.out.println("The response code is ******************"+resp.getStatusCode());
	     System.out.println("The Statud Line is   ******************"+resp.getStatusLine());
	     
	     System.out.println(resp.prettyPrint());
	     
        
	}
	
	

}
