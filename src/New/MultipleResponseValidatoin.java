package New;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.codehaus.groovy.transform.sc.ListOfExpressionsExpression;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MultipleResponseValidatoin {
	
	
/*	Resonse Body -
	
	{
		  "users": [
		    { "id": 1, "name": "John", "age": 30, "role": "Admin" },
		    { "id": 2, "name": "Alice", "age": 25, "role": "User" },
		    { "id": 3, "name": "Bob", "age": 28, "role": "User" }
		  ]
		}
	*/
	     ///////////////////////   This script is based on the Chat GPT ////////////////////////////////////////
	
	@Test
	public void validateMultipleValuesInResponse() 
	
	{
		RestAssured.baseURI   = "http://example";
		RestAssured.basePath  = "/datacenter/";
        
		RequestSpecification request   =  RestAssured.given();
        request.contentType(ContentType.JSON);
        
        Response apiResponse = RestAssured.get();
        
        int respCode =apiResponse.getStatusCode();
        
        Assert.assertEquals(respCode, 200);
        
        
        List<String> names  =  apiResponse.jsonPath().getList("users.name");
        
        assertTrue(names.contains("John"), "John is not found in the response");
        assertTrue(names.contains("Bib"), "John is not found in the response");
        
        
        List<String> age  =  apiResponse.jsonPath().getList("users.age");
        
        assertTrue(age.containsAll(List.of(30,25,28)));
        
        
        List<String> roles  =  apiResponse.jsonPath().getList("users.role");
        
        assertTrue(roles.contains("Admin"), "Admin is not found in the response");
	}

}
