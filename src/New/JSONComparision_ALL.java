package New;

import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;

public class JSONComparision_ALL {
	
	
	////// This will compare all the key and value with there order in the json tree   /////////////////////////
	
	@Test
	public void compareJSON() throws JsonMappingException, JsonProcessingException 
	{
		
		String s1 = "{ \"Name\": \"Ankit\", \"Age\": 22, \"Gender\": \"Male\" }";
	    String s2 = "{ \"Name\": \"Ankit\", \"Gender\": \"Male\", \"Age\": 22 }";

	    ObjectMapper mapper = new ObjectMapper();

	    LinkedHashMap<?, ?> map1 = mapper.readValue(s1, LinkedHashMap.class);
	    LinkedHashMap<?, ?> map2 = mapper.readValue(s2, LinkedHashMap.class);

	    //Assert.assertEquals(map1, map2); // ❌ This will still pass — because LinkedHashMap equals() checks insertion order

	    // Now compare keys order
	    boolean isOrderSame = map1.keySet().toString().equals(map2.keySet().toString());

	    Assert.assertTrue(isOrderSame);  // ✅ This will fail
	}

}
