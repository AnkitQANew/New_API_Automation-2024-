package New;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Handeling_API_Versions {
	
	
	////////////////////////////////////////////////////////   This is the dummy code from the Chat GPT ////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void Handeling_API_Version_IN_BaseURL() 
	{
		
		String API_VERSION = "v1";
		
		RestAssured.baseURI    = "https://abctest.com"+API_VERSION;
		
		RestAssured.basePath  =  "/users";
		
		RequestSpecification  request  =  RestAssured.given();
		
		request.contentType(ContentType.JSON);
		
		Response  apiResponse  =  request.get();
		
		int respCose  = apiResponse.getStatusCode();			
	}
	
	
	@Test
	public void Handeling_API_Version_IN_headers() 
	
	{
		RestAssured.baseURI    = "https://abctest.com";
		
		RestAssured.basePath  =  "/users";
		
		RequestSpecification  request  =  RestAssured.given();
		
		request.header("Accept-Version", "v1");
		
		request.contentType(ContentType.JSON);
		
		Response  apiResponse  =  request.get();
		
		int respCose  = apiResponse.getStatusCode();
				
	}
	@Test	
	public void Handeling_API_Version_IN_QueryParam()
	{
		RestAssured.baseURI    = "https://abctest.com";
		
		RestAssured.basePath  =  "/users";
		
		RequestSpecification  request  =  RestAssured.given();
		
		request.contentType(ContentType.JSON);
		
		request.queryParam("version", "1");
		
		Response  apiResponse  =  request.get();
		
		int respCose  = apiResponse.getStatusCode();
				
	}
	
	@Test
	public void Handeling_API_VersionIN_PathParam()
	{
		
		RestAssured.baseURI    = "https://abctest.com";
		
		RestAssured.basePath  =  "/users";
		
		RequestSpecification  request  =  RestAssured.given();
		
		request.contentType(ContentType.JSON);
		
		request.pathParam("version", "1");
		
		Response  apiResponse  =  request.get();
		
		int respCose  = apiResponse.getStatusCode();
		
	}

}
