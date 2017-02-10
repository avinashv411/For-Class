package maps;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"location", "location_type", "viewport", "bounds"})
public class Geometry 
{
	private String location_type;
	private LatitudeLongitude location;
	private ViewPort viewport;
	private Bounds bounds;
	
	@XmlElement(name="location_type")
	public String getLocation_type() {
		return location_type;
	}
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}
	
	@XmlElement(name="location")
	public LatitudeLongitude getLocation() {
		return location;
	}
	public void setLocation(LatitudeLongitude location) {
		this.location = location;
	}
	
	@XmlElement(name="viewport")
	public ViewPort getViewport() {
		return viewport;
	}
	public void setViewport(ViewPort viewport) {
		this.viewport = viewport;
	}
	
	@XmlElement(name="bounds")
	public Bounds getBounds() {
		return bounds;
	}
	public void setBounds(Bounds bounds) {
		this.bounds = bounds;
	}
	
	@Override
	public String toString() {
		return "Geometry [location_type=" + location_type + ", location=" + location + ", viewport=" + viewport
				+ ", bounds=" + bounds + "]";
	}
	
}
