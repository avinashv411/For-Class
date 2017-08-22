package org.jspiders.mywebapp.servlet;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.assingment.test.dto.GeocodeResponse;
import com.assingment.test.dto.ObjectFactory;
import com.assingment.test.dto.GeocodeResponse.Result;

public class UnmarshalXML {
	public GeocodeResponse instantiate(InputStream in) throws JAXBException{
		JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		GeocodeResponse geocodeResponse = (GeocodeResponse) unmarshaller.unmarshal(in);
		
		Result result = geocodeResponse.getResult();
		
		System.out.println("Printing the Object Representation: ");
		System.err.println(result);
		return geocodeResponse;
	}
}
