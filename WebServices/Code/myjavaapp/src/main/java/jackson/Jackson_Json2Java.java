package jackson;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import data.Company;

public class Jackson_Json2Java {
	public static void main(String[] args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Company user = mapper.readValue(new File("Company-jackson.json"), Company.class);
		System.out.println(user);
	}// End of main
}// End of Class
