package New;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidatorGETCall {
	
	
	@Test
	public void validateResponseSehema() 
	{	
		File jsonSchema          = new File (".//src//JSON_Files//JSONSchemaResponsePostOfficeAPI.JSON");
		
		RestAssured
		 .given()
		 		
		        .baseUri("http://postalpincode.in")
		        .basePath("/api/pincode/110016")
		        .contentType(ContentType.JSON)
		    
		        
		   .when()
		        
		        .get()
		        
		   .then()
		   
		         .assertThat()
		         .statusCode(200)
		         
		         .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

				

		
	}
	
	

}
