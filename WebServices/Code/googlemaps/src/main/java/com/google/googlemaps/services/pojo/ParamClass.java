package com.google.googlemaps.services.pojo;

public class ParamClass 
{
	private String str;
	public ParamClass(String str){
		this.str = str;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	@Override
	public String toString() {
		return "ParamClass [str=" + str + "]";
	}
}
