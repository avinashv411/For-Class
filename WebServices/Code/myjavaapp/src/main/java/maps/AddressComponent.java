package maps;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"longNM", "shortNM", "type"})
public class AddressComponent 
{
	private String[] type;
	private String shortNM;
	private String longNM;
	
	@XmlElement(name="type")
	public String[] getType() {
		return type;
	}
	public void setType(String[] type) {
		this.type = type;
	}
	
	@XmlElement(name="short_name")
	public String getShortNM() {
		return shortNM;
	}
	public void setShortNM(String shortNM) {
		this.shortNM = shortNM;
	}
	
	@XmlElement(name="long_name")
	public String getLongNM() {
		return longNM;
	}
	public void setLongNM(String longNM) {
		this.longNM = longNM;
	}
	
	@Override
	public String toString() {
		return "AddressComponent [type=" + Arrays.toString(type) + ", shortNM=" + shortNM + ", longNM=" + longNM + "]";
	}
}
