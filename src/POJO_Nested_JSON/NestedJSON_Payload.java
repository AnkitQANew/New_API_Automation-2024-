package POJO_Nested_JSON;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NestedJSON_Payload 
{
	
	@Test
	public void Create_User() throws JsonProcessingException 
	{
		//////////// ************************ Creating the Employee Details Class Object *******************************////////////////////
		
		Employes_Details   OBJ_Employes_Details = new Employes_Details ();
				
		OBJ_Employes_Details.setgetFirstName("Mark");
		OBJ_Employes_Details.setLastname("Flower");
		OBJ_Employes_Details.setGender("Male");
		OBJ_Employes_Details.setAge(55);
		OBJ_Employes_Details.setSalary(50000);
		
		Employee_Address OBJ_Employee_Address = new Employee_Address ();
		OBJ_Employee_Address.setStreet("DownTown");
		OBJ_Employee_Address.setCity("Newyork");
		
		OBJ_Employes_Details.setAddress(OBJ_Employee_Address);
		
		//// *************************  Convert class object to JSON object as Sating *************************////////////////////////
		
		ObjectMapper OBJ_ObjectMapper = new ObjectMapper ();
		
		String API_payload =  OBJ_ObjectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(OBJ_Employes_Details);
		
		System.out.println(API_payload);
		
        ///////////// ************************ Create the HTTP POST Request  ********************************************////////////
		
	 RequestSpecification requestSpec  = RestAssured.given();
     
     requestSpec.baseUri("http://httpbin.org/post");
     requestSpec.contentType(ContentType.JSON);
     requestSpec.body(API_payload);
     
     Response resp  = requestSpec.post();
     
     resp.prettyPrint();
     
     Assert.assertEquals(resp.statusCode(), 200,"Check for status code");
		
		
		
	}
	

}
