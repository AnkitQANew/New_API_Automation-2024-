package AuthDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class OAuth2 {
	
	String accessToken = "";
	
	@Test(priority=1)
	public void getOAuth_token() 
	{
		 RequestSpecification requestSpec  = RestAssured.given()
		                                    
		                                     .formParam("client_id", "OAuth2.0-Demo")
		                                     .formParam("client_secret", "a0bb4fd47565a62739ef847b5dcf7cd5")
		                                     .formParam("grant_type","client_credentials");
		 
		 Response response      =         requestSpec.post("http://coop.apps.symfonycasts.com/token");
		 
		 accessToken = response.jsonPath().get("access_token");
		 
		 System.out.println("The Access Token is :-  "+accessToken);
		 
	}
	
	@Test(priority=2)
	   public void POST_Call_throught_Token() 
	   {
		 RequestSpecification requestSpec  = RestAssured.given();
		 
		 
		 requestSpec.auth().oauth2(accessToken);
		 
		 
		   Response response = requestSpec.post("http://coop.apps.symfonycasts.com/api/847/chickens-feed");
		   
		  System.out.println("The response code is  :"+response.getStatusCode());
		  
		  System.out.println("The response body is  :"+response.asPrettyString());
				 
		
		
		
	   }
				
				

		

	

}
