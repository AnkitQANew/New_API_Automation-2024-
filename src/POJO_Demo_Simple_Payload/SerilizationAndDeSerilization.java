package POJO_Demo_Simple_Payload;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SerilizationAndDeSerilization 
{
	
	@Test
	public void Create_JSONObject_From_Employee_Class_Object() throws JsonProcessingException 
	{
		Employee  ObjEmployee1 = new Employee () ;
		
		ObjEmployee1.setFirstname("Mark");
		ObjEmployee1.setLastname("Flower");
		ObjEmployee1.setGender("Male");
		ObjEmployee1.setAge(40);
		ObjEmployee1.setSalary(50000);
		
	 /// ************************************* Converting Employee Class Objects to JSON as String ****************************///////
		
		 ObjectMapper  Obj_ObjectMapper = new ObjectMapper ();
		
		 String EmployeeData  =  Obj_ObjectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ObjEmployee1);
		
	     System.out.println(EmployeeData);
		
	 /// ************************************* Below code is for sending the POST Request ************************************///////   
	     
	     
	     RequestSpecification requestSpec  = RestAssured.given();
	     
	     requestSpec.baseUri("http://httpbin.org/post");
	     requestSpec.contentType(ContentType.JSON);
	     requestSpec.body(EmployeeData);
	     
	     Response resp  = requestSpec.post();
	     
	     resp.prettyPrint();
	     
	     Assert.assertEquals(resp.statusCode(), 200,"Check for status code");
	     
	     /// ************************************* convert JSON String (employeeJSON) to Class object (Employee)  ************************************///////   
	     
	     
	      Employee emp2 =  Obj_ObjectMapper.readValue(EmployeeData, Employee.class);
	     
	     
			
			System.out.println("-----------Print after JSON Object to Class Object------------");
			
			System.out.println("FirstName:"+ emp2.getFirstname());
			System.out.println("LastName:"+ emp2.getLastname());
			System.out.println("Gender:"+ emp2.getGender());
			System.out.println("Age:"+ emp2.getAge());
			System.out.println("Salary:"+ emp2.getSalary());
	     
	}
	

}
