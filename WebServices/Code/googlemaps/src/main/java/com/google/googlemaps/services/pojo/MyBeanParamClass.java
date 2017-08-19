package com.google.googlemaps.services.pojo;

import java.util.Set;

import javax.ws.rs.CookieParam;
import javax.ws.rs.Encoded;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class MyBeanParamClass 
{
	@Encoded @CookieParam("college")
	private long college;
	
	@Encoded @QueryParam("regnum")
	private long regno;
	
	@PathParam("location")
	private String location;
	
	@QueryParam("fname")
	private String fname;
	
	@FormParam("lname")
	private String lnm;
	
	@HeaderParam("mname")
	private String mname;
	
	@QueryParam("marks")
	private Set<String> marks;
	
	@PathParam("id")
	private ParamClass myTestId;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLnm() {
		return lnm;
	}

	public void setLnm(String lnm) {
		this.lnm = lnm;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Set<String> getMarks() {
		return marks;
	}

	public void setMarks(Set<String> marks) {
		this.marks = marks;
	}

	public ParamClass getMyTestId() {
		return myTestId;
	}

	public void setMyTestId(ParamClass myTestId) {
		this.myTestId = myTestId;
	}

	@Override
	public String toString() {
		return "MyBeanParamClass [regno=" + regno + ", location=" + location + ", fname=" + fname + ", lnm=" + lnm
				+ ", mname=" + mname + ", marks=" + marks + ", myTestId=" + myTestId + "]";
	}

	public long getRegno() {
		return regno;
	}

	public void setRegno(long regno) {
		this.regno = regno;
	}

	public long getCollege() {
		return college;
	}

	public void setCollege(long college) {
		this.college = college;
	}
}
