package com.google.googlemaps.services.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"southWest", "northeast"})
public class Bounds 
{

	private LatitudeLongitude southWest;
	private LatitudeLongitude northeast;
	
	@XmlElement(name="southwest")
	public LatitudeLongitude getSouthWest() {
		return southWest;
	}
	public void setSouthWest(LatitudeLongitude southWest) {
		this.southWest = southWest;
	}
	
	@XmlElement(name="northeast")
	public LatitudeLongitude getNortheast() {
		return northeast;
	}
	public void setNortheast(LatitudeLongitude northeast) {
		this.northeast = northeast;
	}
	@Override
	public String toString() {
		return "Bounds [southWest=" + southWest + ", northeast=" + northeast + "]";
	}
	
}
