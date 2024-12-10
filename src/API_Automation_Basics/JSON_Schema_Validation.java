package API_Automation_Basics;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSON_Schema_Validation 
{
	  @Test
	  public void Verify_JSON_Schema() 
	  {

		    File objfile = new File (".//src//JSON_Files//Response.JSON");
			
		            RestAssured.given()
		            .get("http://postalpincode.in/api/pincode/110016")
		            .then()
		            .assertThat()
		            .body(JsonSchemaValidator.matchesJsonSchema(objfile))
		            .statusCode(200);
		            			
	  }
	

}
