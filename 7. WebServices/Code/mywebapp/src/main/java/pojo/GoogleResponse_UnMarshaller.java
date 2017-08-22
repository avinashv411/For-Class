package pojo;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class GoogleResponse_UnMarshaller {
	public static void main(String[] args) throws Exception 
	{
		/*
		 * Consuming Google Response
		 */
		File responseXML = new File("GeocodeResponse.xml");
		
		//1. Create JAXBContext
		JAXBContext contextObj = JAXBContext.newInstance(GeocodeResponse.class);
		
		//2. Create Unmarshaller
		Unmarshaller marshallerObj = contextObj.createUnmarshaller();

		//3. Generate Object from XML with the help of Unmarshaller
		GeocodeResponse googleMapResp = (GeocodeResponse) marshallerObj.unmarshal(responseXML);
		System.out.println(googleMapResp);
	
	}//End of Main
}//End of Class