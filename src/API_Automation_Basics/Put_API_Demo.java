package API_Automation_Basics;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Put_API_Demo 
{
	
	@Test
	public void PUT_HTTP_Request() 
	{
		
        RequestSpecification request   =  RestAssured.given();
        request.contentType(ContentType.JSON);
        
        request.baseUri("https://reqres.in/api");
        request.basePath("/users/");
        request.queryParam("id", "2");
        
        
        JSONObject obj_JSON = new JSONObject ();
        
        obj_JSON.put("name", "Mark");
        obj_JSON.put("JOB", "SSE");
       
        request.body(obj_JSON.toString());
        
        Response resp  = request.put();
	     
	     System.out.println("The response code is ******************"+resp.getStatusCode());
	     System.out.println("The Statud Line is   ******************"+resp.getStatusLine());
	     
	     System.out.println(resp.prettyPrint());
	     
        

	}

}
