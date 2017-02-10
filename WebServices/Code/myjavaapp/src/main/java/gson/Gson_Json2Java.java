package gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;

import data.Company;

public class Gson_Json2Java {
	public static void main(String[] args) {
		Gson gson = new Gson();

		try (Reader reader = new FileReader("Company.json")) {
			// Convert JSON to Java Object
			Company cmp = gson.fromJson(reader, Company.class);
			System.out.println(cmp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// End of main
}// End of Class
