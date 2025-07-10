package New;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON_Comparision_StrictMode {
	
	////////////////////   Read this description //////////////////////////////////////////////////
	
	/*  JSONCompareMode.STRICT will    = What STRICT Actually Means in JSONAssert
	For arrays, it checks order and content strictly.

	For objects, it checks:

	All keys must exist

	All values must match

	But key order is ignored — even in STRICT.
	
	Add below dependency in the pom 
<dependency>
    <groupId>org.skyscreamer</groupId>
    <artifactId>jsonassert</artifactId>
    <version>1.5.1</version>
 </dependency>
	
  */
	
	
	@Test
	 public void Demo_() throws JsonMappingException, JsonProcessingException, JSONException {
		// TODO Auto-generated method stub


    
		String s1 = "{\r\n"
				+ "\r\n"
				+ "\"Name\" : \"ANKit\",\r\n"
				+ "\"AGE\"  : 33,\r\n"
				+ "\"City\" : [\"Noida\", \"Delhi\", \"Gurugram\"]\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "}";
		
		String s2 = "{\r\n"
				+ "\r\n"
				+ "\"Name\" : \"ANKit\",\r\n"
				+ "\"AGE\"  : 33,\r\n"
				+ "\"City\" : [\"Delhi\", \"Gurugram\", \"Noida\"]\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "}" ;
		
		  JSONAssert.assertEquals(s1, s2, JSONCompareMode.STRICT);
		
		
		
		
		  
	}

}
