package jaxb;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import data.Company;
import data.GenerateData;

public class ObjectToXml {
	public static void main(String[] args) throws Exception 
	{
		//1. Create JAXBContext
		JAXBContext contextObj = JAXBContext.newInstance(Company.class);
		System.out.println(contextObj.getClass().getName());
		//2. Create Marshaller
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		//3. Generate XML with the help of Marshaller
		marshallerObj.marshal(GenerateData.gererate(), new FileOutputStream("employee3.xml"));
		marshallerObj.marshal(GenerateData.gererate(), System.out);

	}
}