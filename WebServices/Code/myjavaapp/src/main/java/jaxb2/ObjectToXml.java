package jaxb2;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import generated_other.College;

public class ObjectToXml {
	public static void main(String[] args) throws Exception 
	{
		StudentInfo student1 = new StudentInfo();
		student1.setRegno(1);
		student1.setFirstName("AAA");
		student1.setLastName("BBB");
		
		
		
		//1. Create JAXBContext
		JAXBContext contextObj = JAXBContext.newInstance(StudentInfo.class);
		System.out.println(contextObj.getClass().getName());
		//2. Create Marshaller
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		//3. Generate XML with the help of Marshaller
		marshallerObj.marshal(student1, new FileOutputStream("College.xml"));
		marshallerObj.marshal(student1, System.out);

	}
}