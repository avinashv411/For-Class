package com.google.googlemaps.services.rest;

import java.net.URI;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Variant;

@Path("/users")
@Produces(MediaType.TEXT_PLAIN)
public class UserService 
{
	@PUT
	@Path("/create")
	@Consumes(MediaType.APPLICATION_XML)
//	@Produces(MediaType.APPLICATION_XML)
	public Response addUser(LocationData data)
	{
		System.out.println(data.getLocation());
		System.out.println(data.getLatitude());
		System.out.println(data.getLongitude());
		
//		LocationData data = new LocationData();
//		data.setLocation("AAA");
//		data.setLongitude(new Random().nextDouble());
//		data.setLatitude(new Random().nextDouble());
		
		/*ResponseBuilder res = Response.status(201);
		res.type(MediaType.APPLICATION_XML);
		res.entity(data);
		Response resp = res.build();*/
//		return resp;
//		return Response.status(201).type(MediaType.APPLICATION_XML).entity(data).build();
		return Response.created(URI.create("users/get/123")).build();
	}
	
	
	@POST
//	@PUT
	@Path("/update/{uNM}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("uNM") int uNM, LocationData data)
	{
		/*System.out.println(uNM);
		System.out.println(data.getLatitude());
		System.out.println(data.getLongitude());
		System.out.println(data.getLocation());*/
		
		LocationData data2 = new LocationData();
		data2.setLocation("AAA");
		data2.setLongitude(new Random().nextDouble());
		data2.setLatitude(new Random().nextDouble());
		
		return Response.status(200).entity(data).build();
	}
	
	@DELETE
	@Path("/delete/{uNM}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("uNM") int uNM)
	{
		System.out.println(uNM);
		
		/*LocationData data = new LocationData();
		data.setLocation("AAA");
		data.setLongitude(new Random().nextDouble());
		data.setLatitude(new Random().nextDouble());*/
		
		//return Response.status(204).entity(data).build();
	}
	
	@GET
	@Path("/get/{userNM}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getUser(@PathParam("userNM") int uNM)
	{
//		System.out.println(uNM);
		
		if(uNM==123){
			LocationData data = new LocationData();
			data.setLocation("AAA");
			data.setLongitude(new Random().nextDouble());
			data.setLatitude(new Random().nextDouble());
			return Response.status(200).entity(data).build();
		}else{
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
	
	@POST
	@Path("/test/{userNM}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response test(@PathParam("userNM") int uNM, LocationData data2) throws Exception
	{
		if(uNM==123){
			//throw new Exception("Test");
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		EntityTag tag = new EntityTag("BBBBBBBBB", false);
		Variant vari = new Variant(MediaType.APPLICATION_XHTML_XML_TYPE, Locale.CANADA, null);
		ResponseBuilder builder = Response.ok(data2);
		Response resp = builder.tag(tag).variant(vari).lastModified(new Date()).build();
		return resp;
		/*System.out.println(data2.toString());
		LocationData data = new LocationData();
		data.setLocation("AAA");
		data.setLongitude(new Random().nextDouble());
		data.setLatitude(new Random().nextDouble());
		System.out.println(data.toString());
		NewCookie cookie = new NewCookie("key", "value");
		NewCookie cookie2 = new NewCookie("key2", "value2", null, null, 1, null, 7*24*60*60, true);
		return Response.ok(data).language(Locale.FRANCE).header("Some-Header", data).cookie(cookie,cookie2).build();*/
		/*ResponseBuilder respBuild = Response.temporaryRedirect(new URI("http://www.gmail.com"));
		System.out.println(respBuild.getClass());
		Response resp = respBuild.build();
		System.out.println(resp.getClass());
		return Response.temporaryRedirect(new URI("http://www.gmail.com")).build();*/
	}

	@GET
	@Path("/cache")
	@Produces(MediaType.APPLICATION_XML)
	public Response cache()
	{
		LocationData data = new LocationData();
		data.setLocation("AAA");
		data.setLongitude(new Random().nextDouble());
		data.setLatitude(new Random().nextDouble());
		
		CacheControl cc = new CacheControl();
	    cc.setMaxAge(86400);
	    cc.setPrivate(true);
		
		return Response.status(Response.Status.OK).entity(data).cacheControl(cc).build();
	}
	
	
	@GET
	@Path("/getUsers/{id}")
	public Response getUserById(@PathParam("id") int id, @Context Request req) 
	{
		 CacheControl cc = new CacheControl();
	     cc.setMaxAge(86400);
	        
		Response.ResponseBuilder rb = null;
		/*
		 * Avoid trouble Avoid trouble: The granularity of dates used in HTTP headers is not as
		 *  precise as some dates used in data sources.  For example, the precision for a date in a
		 *   database row might be defined to the millisecond. However, the date in an HTTP header
		 *    field is only precise to seconds. When evaluating HTTP preconditions, if you compare a 
		 *    java.util.Date object to the date in an HTTP header, the difference in precision might 
		 *    produce unexpected results. To avoid this problem, normalize the java.util.Date object
		 *     before comparing to the date value in the HTTP header.
		 * */
		/*LocationData data = new LocationData();
		data.setLocation("XXX YYY ZZZ");
		data.setLongitude(new Random().nextDouble());
		data.setLatitude(new Random().nextDouble());*/
		
		EntityTag etag = new EntityTag(UserDatabase.getLastModifiedById(id).getMinutes()+""); 
        rb = req.evaluatePreconditions(etag);
        
        if (rb != null) 
        {
            return rb.cacheControl(cc).tag(etag).build();
        }
        
        rb = Response.ok(UserDatabase.getUserById(id)).cacheControl(cc).tag(etag).type(MediaType.APPLICATION_XML);
		return rb.build();
	}
	
	@PUT
	@Path("/updateUsers/{id}")
	public Response updateUserById(@PathParam("id") int id) 
	{
		UserDatabase.updateUser(id);
		return Response.status(200).build();
	}

	
}
