package jackson;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import data.Company;
import data.GenerateData;
import maps.GeocodeResponse;

public class Jackson_Java2Json {
	public static void main(String[] args) throws IOException {
		
		//Company ref = GenerateData.gererate();
		GeocodeResponse ref = maps.GenerateData.generate();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("Company-jackson.json"), ref);
		
		String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ref);
		System.out.println(jsonInString);
		
	}// End of main
}// End of Class
