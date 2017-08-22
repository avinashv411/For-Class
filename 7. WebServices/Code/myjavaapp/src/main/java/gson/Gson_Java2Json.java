package gson;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import data.Company;
import data.GenerateData;

public class Gson_Java2Json {
	public static void main(String[] args) throws IOException {
		Company cmp = GenerateData.gererate();
		Gson gson = new Gson();
        String json = gson.toJson(cmp);
        System.out.println(json);
        try (FileWriter writer2 = new FileWriter("Company.json")) {
            gson.toJson(cmp, writer2);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}// End of main
}// End of Class
