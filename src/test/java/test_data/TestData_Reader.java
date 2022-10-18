package test_data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestData_Reader {
	
	public List<HashMap<String,String>> getjsonDataToMap() throws IOException {
		//converting json to string

		
		  String jsonContent= FileUtils.readFileToString(new File( "D:\\WORKSPACE\\orion_automation\\src\\test\\java\\test_data\\testData.json"
		  ),StandardCharsets.UTF_8);
		  //converting json to hashmap
		  ObjectMapper mapper= new ObjectMapper(); 
		  List<HashMap<String,String>> data=mapper.readValue(jsonContent, new  TypeReference<List<HashMap<String,String>>>(){ }); 
		  //here data stores hashmap arrays {map1,map2} 
		  return data;
		 
	

}
}
