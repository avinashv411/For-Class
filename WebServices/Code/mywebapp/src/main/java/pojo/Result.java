package pojo;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="result")
@XmlType(propOrder={"type", "formattedAddress", "addressComponent", "geometry", "placeID"})
public class Result 
{
	private String[] type;
	private String formattedAddress;
	private AddressComponent[] addressComponent;
	private Geometry geometry;
	private String placeID;
	
	@XmlElement
	public String[] getType() {
		return type;
	}
	public void setType(String[] type) {
		this.type = type;
	}
	
	@XmlElement(name="formatted_address")
	public String getFormattedAddress() {
		return formattedAddress;
	}
	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}
	
	@XmlElement
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	
	@XmlElement(name="place_id")
	public String getPlaceID() {
		return placeID;
	}
	public void setPlaceID(String placeID) {
		this.placeID = placeID;
	}
	
	@XmlElement(name="address_component")
	public AddressComponent[] getAddressComponent() {
		return addressComponent;
	}
	public void setAddressComponent(AddressComponent[] addressComponent) {
		this.addressComponent = addressComponent;
	}
	@Override
	public String toString() {
		return "Result [type=" + Arrays.toString(type) + ", formattedAddress=" + formattedAddress
				+ ", addressComponent=" + Arrays.toString(addressComponent) + ", geometry=" + geometry + ", placeID="
				+ placeID + "]";
	}
	
}
