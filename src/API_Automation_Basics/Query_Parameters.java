package API_Automation_Basics;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Query_Parameters 
{
	//@Test
	public void query_ParametersDemo1() 
	{      
		
		   RequestSpecification  request = RestAssured.given();  
		
		   request.baseUri("https://api.github.com");
		   request.basePath("/search/repositories");
		   
           request.queryParam("q", "topic:java");
           request.queryParam("page", "2");
           request.queryParam("per_page", "2");
           
           Response resp =  request.get();
           
           int respCode         =  resp.statusCode();
           
           String statusLine    =  resp.statusLine();
           
           System.out.println("Response Code is _________  "+respCode);
           System.out.println("Status Line   is _________  "+statusLine);
           
           System.out.println(resp.prettyPrint());
	}
	
	@Test
	public void query_ParametersDemo2() 
	{
		  RequestSpecification  request = RestAssured.given();
		  
		  Map<String,String> HM = new HashMap <>();
		  
		  HM.put("q", "topic:java");
		  HM.put("page", "2");
		  HM.put("per_page", "2");
		  
		  request.baseUri("https://api.github.com");
		  request.basePath("/search/repositories");
		  request.queryParams(HM);
		 
		  
		  Response resp =  request.get();
		  
		   int respCode        =  resp.statusCode();
          String statusLine    =  resp.statusLine();
          
          System.out.println("Response Code is _________  "+respCode);
          System.out.println("Status Line   is _________  "+statusLine);
		  
		  
	}
	

}
