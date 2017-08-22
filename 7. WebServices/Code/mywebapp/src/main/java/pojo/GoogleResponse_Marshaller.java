package pojo;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class GoogleResponse_Marshaller {
	public static void main(String[] args) throws Exception 
	{
		/*
		 * Generating Google Response
		 */
		GeocodeResponse googleMapResp = generateData();
		
		//1. Create JAXBContext
		JAXBContext contextObj = JAXBContext.newInstance(GeocodeResponse.class);
		
		//2. Create Marshaller
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		//3. Generate XML with the help of Marshaller
		marshallerObj.marshal(googleMapResp, new FileOutputStream("GeocodeResponse.xml"));
		marshallerObj.marshal(googleMapResp, System.out);
	}
	
	private static GeocodeResponse generateData()
	{
		LatitudeLongitude latLang = new LatitudeLongitude();
		latLang.setLatitude(new Random().nextDouble());
		latLang.setLongitude(new Random().nextDouble());
		
		Bounds bounds = new Bounds();
		bounds.setNortheast(latLang);
		bounds.setSouthWest(latLang);
		
		ViewPort viewport = new ViewPort();
		viewport.setNortheast(latLang);
		viewport.setSouthWest(latLang);
		
		Geometry geometry = new Geometry();
		geometry.setLocation_type("APPROXIMATE");
		geometry.setLocation(latLang);
		geometry.setBounds(bounds);
		geometry.setViewport(viewport);
		
		AddressComponent addressComponent = new AddressComponent();
		addressComponent.setLongNM("Bengaluru");
		addressComponent.setShortNM("Bengaluru");
		addressComponent.setType(new String[]{"locality", "political"});
		
		Result result = new Result();
		result.setPlaceID("ChIJbU60yXAWrjsR4E9-UejD3_g");
		result.setType(new String[]{"locality", "political"}); 
		result.setFormattedAddress("Bengaluru, Karnataka, India");
		result.setGeometry(geometry);
		result.setAddressComponent(new AddressComponent[]{addressComponent, addressComponent, addressComponent});
		
		GeocodeResponse googleMapResp = new GeocodeResponse();
		googleMapResp.setStatus("OK");
		googleMapResp.setResult(result);
		
		return googleMapResp;
		
	}//End of generateData()
}//End of Class