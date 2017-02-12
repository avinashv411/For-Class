package com.google.googlemaps.services.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/mapsapi")
public class GooglrMapRESTservices 
{
//	@GET
	@POST
	@Path("/text/{location}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getLocationDetailsInTxt(@PathParam("location") String location, 
											@QueryParam("fname") @DefaultValue("123") String fname,
											@FormParam("lname") String lnm,
											@HeaderParam("mname") String mname,
											@QueryParam("marks") Set<String> marks)
	{
		System.out.println("First Name : "+fname);
		System.out.println("Middle Name : "+mname);
		System.out.println("Last Name : "+lnm);
		System.out.println("Marks : "+marks);
		LocationData data = new LocationData();
		data.setLocation(location);
		data.setLongitude(new Random().nextDouble());
		data.setLatitude(new Random().nextDouble());
		return data.toString();
	}
	
	@GET
	@Path("/json/{location}")
	@Produces(MediaType.APPLICATION_JSON)
	public LocationData getLocationDetailsInJSON(@PathParam("location") String location){
		LocationData data = new LocationData();
		data.setLocation(location);
		data.setLongitude(new Random().nextDouble());
		data.setLatitude(new Random().nextDouble());
		return data;
	}
	
	@GET
	@Path("/xml/{location}")
	@Produces(MediaType.APPLICATION_XML)
	public LocationData getLocationDetailsInXML(@PathParam("location") String location){
		LocationData data = new LocationData();
		data.setLocation(location);
		data.setLongitude(new Random().nextDouble());
		data.setLatitude(new Random().nextDouble());
		return data;
	}
	
	@Path("xml2")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Employees getAllEmployees() 
	{
		System.out.println("I am Here");
	    Employees list = new Employees();
	    list.setEmployeeList(new ArrayList<Employee>());
	     
	    list.getEmployeeList().add(new Employee(1, "Lokesh Gupta"));
	    list.getEmployeeList().add(new Employee(2, "Alex Kolenchiskey"));
	    list.getEmployeeList().add(new Employee(3, "David Kameron"));
	     
	    return list;
	}
}
