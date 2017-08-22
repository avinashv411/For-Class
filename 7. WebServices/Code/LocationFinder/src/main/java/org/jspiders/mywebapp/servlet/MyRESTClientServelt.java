package org.jspiders.mywebapp.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

import com.assingment.test.dto.GeocodeResponse;



public class MyRESTClientServelt extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, 
						 HttpServletResponse resp) 
	throws ServletException, IOException
	{
		GeocodeResponse geocodeResponse = null;
		//Get the Form Data
		String locationVal = req.getParameter("location");
		String typeVal = req.getParameter("type");
		
		String contentType=null;
		String url=null;
		
		if(typeVal.equals("xml")) {
			contentType = MediaType.APPLICATION_XML;
			url = "https://maps.googleapis.com/maps/api/geocode/xml?address="+locationVal;
		
		} else if(typeVal.equals("json")) {
			contentType = MediaType.APPLICATION_JSON;
			url = "https://maps.googleapis.com/maps/api/geocode/json?address="+locationVal;
		}
		
		/*
		 * Invoke the Google Maps Web Services
		 */
		//1. Build the Client
		Client client = ClientBuilder.newClient();
		
		//2. Set the Target
		WebTarget target = client.target(url);
		
		//3. Get the Response
		Response response = target.request(contentType).get();
		
		//4. Process the Response
		String respData = (String)response.readEntity(String.class);
		
		byte[] bytes = respData.toString().getBytes();
    	InputStream is = new ByteArrayInputStream(bytes);
    	
    	UnmarshalXML unmarshal = new UnmarshalXML();
    	try {
			geocodeResponse = unmarshal.instantiate(is);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		/*resp.setContentType(contentType);
		PrintWriter out = resp.getWriter();
		out.print(respData);*/
		
		RequestDispatcher rd = req.getRequestDispatcher("/GeoCodeResults.jsp");
		req.setAttribute("GeoCodeData", geocodeResponse ); 
		rd.forward(req, resp);		
	}
}
