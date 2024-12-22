package AuthDemo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerTokenAuth {
	
	@Test
	public void BearerAuth_Demo() 
	{
		RequestSpecification requestSpec  =  RestAssured.given();
		  
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");
		
		JSONObject payload = new JSONObject();
		payload.put("name", "prachigupta");
		payload.put("gender", "Female");
		payload.put("email", "prachigupta123@gmail.com");
		payload.put("status", "Active");
		
		String authToken = "Bearer 10fc50ac64335eab203f404f848cfe3a291d5dafd286f3d9c38de12b5dc1ff27";
		
		requestSpec.header("Authorization" ,authToken )
		.contentType(ContentType.JSON)
		.body(payload);
		
		
		  Response response  = requestSpec.post();
		  
		  Assert.assertEquals(response.statusCode()/*actual*/, 201/*expected*/,"check for status code");
			
			//print status line & response boy
			System.out.println("Responsne status line:" + response.statusLine());
			System.out.println("Response body:" + response.body().asString());
			
		
		
		
	}

}
