package POJO_MultipleJSON_Objects;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class JSON_Array_POJOClass {
	
	
	@Test
	public void createEmployeeJSON_Array() throws JsonProcessingException 
	{   
        ///////////// ************************  Create First Employee Object  ********************************************/////////
		Employes_Info OBJ_Employes_Info1 = new Employes_Info ();
		
		OBJ_Employes_Info1.setFirstname("Mark");
		OBJ_Employes_Info1.setLastname("Flower");
		OBJ_Employes_Info1.setGender("Male");
		OBJ_Employes_Info1.setAge(40);
		OBJ_Employes_Info1.setSalary(50000);
		
        ///////////// ************************  Create Second Employee Object  ********************************************/////////
		Employes_Info OBJ_Employes_Info2 = new Employes_Info ();
		
		OBJ_Employes_Info2.setFirstname("Ana");
		OBJ_Employes_Info2.setLastname("Srya");
		OBJ_Employes_Info2.setGender("Female");
		OBJ_Employes_Info2.setAge(30);
		OBJ_Employes_Info2.setSalary(50000);
		
        ///////////// ************************  Create Third Employee Object  ********************************************/////////
		Employes_Info OBJ_Employes_Info3 = new Employes_Info ();
		
		OBJ_Employes_Info3.setFirstname("EVA");
		OBJ_Employes_Info3.setLastname("Jakson");
		OBJ_Employes_Info3.setGender("Female");
		OBJ_Employes_Info3.setAge(35);
		OBJ_Employes_Info3.setSalary(60000);
		
        ///////////// ************************  Create List Of Employee  ********************************************////////////
		
		List <Employes_Info> ListOFEmployee = new ArrayList <Employes_Info> () ;
		
		ListOFEmployee.add(OBJ_Employes_Info1);
		ListOFEmployee.add(OBJ_Employes_Info2);
		ListOFEmployee.add(OBJ_Employes_Info3);
		
		
		///////////// ************************ Convert Employee Class Object to JSON Array Payload as String  ********************************************////////////
		
		ObjectMapper OBJ_ObjectMapper = new ObjectMapper ();
		
		String JSONArray = OBJ_ObjectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ListOFEmployee);
		
		System.out.println(JSONArray);

		
        ///////////// ************************ Create the HTTP POST Request  ********************************************////////////
		
		RequestSpecification requestSpec  = RestAssured.given();
	     
	     requestSpec.baseUri("http://httpbin.org/post");
	     requestSpec.contentType(ContentType.JSON);
	     requestSpec.body(JSONArray);
	     
	     Response resp  = requestSpec.post();
	     
	     resp.prettyPrint();
	     
	     Assert.assertEquals(resp.statusCode(), 200,"Check for status code");
	     
	     ResponseBody responseBody =  resp.getBody();
	     
	     JsonPath JsonPATH_View =  responseBody.jsonPath();
	    
	    List<Employes_Info> allEmployees = JsonPATH_View.getList("json", Employes_Info.class);

		
		System.out.println("----------Emoployee objects in ResponseBody----------------");

		for(Employes_Info emp:allEmployees)
		{
			System.out.println(emp.getFirstname()+ " " + emp.getLastname());
		}
		
	     
	}
	

}





