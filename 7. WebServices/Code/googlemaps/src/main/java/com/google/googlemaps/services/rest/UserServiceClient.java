package com.google.googlemaps.services.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class UserServiceClient {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		try {
			System.out.println("*** Create a new Customer ***");
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
					+"<locationData>"
					+"<location>AAA</location>"
					+"<longitude>0.10759794970827152</longitude>"
					+"<latitude>0.206179224911488</latitude>"
					+"</locationData>";
			Response response = client.target("http://localhost:8080/googlemaps/rest/users/create").request()
					.put(Entity.xml(xml));
			if (response.getStatus() != 201)
				throw new RuntimeException("Failed to create");
			String location = response.getLocation().toString();
			System.out.println("Location: " + location);
			response.close();
			
			
			System.out.println("*** GET Created Customer **");
			String customer = client.target(location).request().get(String.class);
			System.out.println(customer);
			response.close();
			
			System.out.println("*** Update the Customer **");
			response = client.target("http://localhost:8080/googlemaps/rest/users/update/123").request().post(Entity.xml(xml));
			if (response.getStatus() != 200)
				throw new RuntimeException("Failed to update");
			String output = response.readEntity(String.class);
			System.out.println(output);
			response.close();
			
			
			response.close();
		/*	System.out.println("**** After Update ***");
			customer = client.target(location).request().get(String.class);
			System.out.println(customer);*/
		} finally {
			client.close();
		}
	}// End of Main
}// End of Class
