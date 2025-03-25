package New;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PaginationResponsevalitation {
	
	/*
	Sample API response 
	
	
	{
		  "page": 1,
		  "total_pages": 3,
		  "data": [
		    { "name": "John" },
		    { "name": "Alice" }
		  ]
		}
	*/
	
	
	
	@Test                             /// This is the reference code form the Chat GPT /////////////////////////
	
	public void verify_paginationInThe_Response() 
	{    
        int currentPage = 1;
        int totalPages =0;
        
		
		do {
		

    	RestAssured.baseURI   = "http://example";
		RestAssured.basePath  = "/datacenter/";
        
		RequestSpecification request   =  RestAssured.given();
        request.contentType(ContentType.JSON);
        
        Response apiResponse = RestAssured.get();
        
        int respCode =apiResponse.getStatusCode();
        
        Assert.assertEquals(respCode, 200);
        
        totalPages = apiResponse.jsonPath().getInt("total_pages");
        
        currentPage++;

		}
		
		while (currentPage <= totalPages);
		
	}

}
