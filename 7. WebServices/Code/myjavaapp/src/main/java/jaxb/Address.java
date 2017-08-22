package jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"addrType", "doorNo","addr1", "addr2", "landMark", "pincode"})
public class Address 
{
	private String addrType;
	private short doorNo;
	private String addr1;
	private String addr2;
	private String landMark;
	private int pincode;
	
	public Address() {
	}
	
	public Address(String addrType, short doorNo, String addr1, String addr2, String landMark, int pincode) {
		super();
		this.addrType = addrType;
		this.doorNo = doorNo;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.landMark = landMark;
		this.pincode = pincode;
	}
	@XmlElement(name="house-number")
	public short getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(short doorNo) {
		this.doorNo = doorNo;
	}
	
	@XmlElement(name="address-1")
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	
	@XmlElement(name="address-2")
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	
	@XmlElement(name="landmark")
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	
	@XmlElement(name="pincode")
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	@XmlAttribute(name="type")
	public String getAddrType() {
		return addrType;
	}
	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}
	
	@Override
	public String toString() {
		return "Address [addrType=" + addrType + ", doorNo=" + doorNo + ", addr1=" + addr1 + ", addr2=" + addr2
				+ ", landMark=" + landMark + ", pincode=" + pincode + "]";
	}
	
	
	
}
