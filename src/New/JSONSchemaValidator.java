package New;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONSchemaValidator {
     
	
	  @Test
	   public void jsonSchemaValidatoin () {


		
		File objfile_JSONPayload = new File (".//src//JSON_Files//PostCall_Paylpad.JSON");	
		File jsonSchema          = new File (".//src//JSON_Files//ResponseSchema.JSON");	
				
 RestAssured
 .given()
 		
        .baseUri("http://httpbin.org")
        .basePath("/post")
        .contentType(ContentType.JSON)
        
        .body(objfile_JSONPayload)
        
   .when()
        
        .post()
        
   .then()
   
         .assertThat()
         .statusCode(200)
         .body("json.firstname",Matchers.notNullValue(null))
         .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

	     
	     
	     
	}

}
