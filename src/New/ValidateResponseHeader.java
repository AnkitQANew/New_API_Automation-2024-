package New;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {
	
	
	public void validateSpecificHeader() 
	{
		  Response response = RestAssured.get("http://postalpincode.in/api/pincode/110016");
		  
		   String respHeader = response.getHeader("Content-Type");
		   
		   System.out.println(respHeader);
		   
		   Assert.assertEquals(respHeader,"application/json; charset=utf-8");
		   
		   Assert.assertTrue(respHeader.contains("json"));
		   
		   //////////////////////////////////////////////////////////////////////////////////
		   String respHeader2 = response.getHeader("Server");
		   
		   System.out.println(respHeader2);
		   
		   Assert.assertEquals(respHeader2,"Microsoft-IIS/10.0");
	}
	
	
	@Test
	public void validateAllheaders() 
	{
		   Response response = RestAssured.get("http://postalpincode.in/api/pincode/110016");
		  
		   Headers  headerList = response.getHeaders();
		   
		   for (Header header :headerList )
		   {
			   System.out.println(header.getName() + "        "+header.getValue());
		   }
		

	}
		   
	
	
	
	
	
	

}


