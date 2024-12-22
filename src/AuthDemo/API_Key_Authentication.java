package AuthDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Key_Authentication {
	
	
	@Test
	public void KeyBased_Authentication() 
	{

		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://api.openweathermap.org");
		requestSpec.basePath("/data/2.5/weather");
		
		  requestSpec.queryParam("q", "Delhi")
		 .queryParam("appid", "f738d1dd470f0dc6e8825f61f18550c8");
		  
		  Response response   = requestSpec.get();
		  

		  
		  Assert.assertEquals(response.statusCode()/*actual*/, 200/*expected*/,"check for status code");
			
			//print status line & response boy
			System.out.println("Responsne status line:" + response.statusLine());
			System.out.println("Response body:" + response.body().asString());
			
		 
	}

}
