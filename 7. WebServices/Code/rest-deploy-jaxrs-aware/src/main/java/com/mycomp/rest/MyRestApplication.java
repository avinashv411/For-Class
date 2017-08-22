package com.mycomp.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//@ApplicationPath("/services")
public class MyRestApplication 
extends Application 
{
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public MyRestApplication() throws Exception {
		singletons.add(new FileDownloadService());
		//classes.add(Class.forName("com.mycomp.rest.FileDownloadService"));
		//classes.add(FileDownloadService.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
