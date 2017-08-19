package com.google.googlemaps.services.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.ws.rs.BeanParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.googlemaps.services.pojo.MyBeanParamClass;
import com.google.googlemaps.services.pojo.ParamClass;

@Path("/mapsapi")
public class GooglrMapRESTservices 
{
//	@GET
	@POST
	@Path("/text/{location}/{id : \\d+}")
	@Produces(MediaType.TEXT_PLAIN)
	/*public String getLocationDetailsInTxt(@PathParam("location") String location, 
											@QueryParam("fname") @DefaultValue("123") String fname,
											@FormParam("lname") String lnm,
											@HeaderParam("mname") String mname,
											@QueryParam("marks") Set<String> marks,
											@PathParam("id") ParamClass myTestId)*/
	public String getLocationDetailsInTxt(@BeanParam MyBeanParamClass params)
	{
		int sum;// = myTestId+10;
		/*if(myTestId){
			sum=10;
		}else{
			sum=20;
		}*/
		/*System.out.println("First Name : "+fname);
		System.out.println("Middle Name : "+mname);
		System.out.println("Last Name : "+lnm);
		System.out.println("Marks : "+marks);
		System.out.println("ID : "+myTestId.getStr());*/
		
		System.out.println("First Name : "+params.getFname());
		System.out.println("Middle Name : "+params.getMname());
		System.out.println("Last Name : "+params.getLnm());
		System.out.println("Marks : "+params.getMarks());
		System.out.println("ID : "+params.getMyTestId());
		System.out.println("Reg No. : "+params.getRegno());
		System.out.println("Cookie : "+params.getCollege());
		LocationData data = new LocationData();
	//	data.setLocation(location);
		data.setLocation(params.getLocation());
		data.setLongitude(new Random().nextDouble());
		data.setLatitude(new Random().nextDouble());
		return data.toString();
	}
	
	//@GET
	@PUT
	@Path("/json/{location}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
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
