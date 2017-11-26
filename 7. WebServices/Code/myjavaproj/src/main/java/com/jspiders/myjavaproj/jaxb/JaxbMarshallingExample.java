package com.jspiders.myjavaproj.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Hello world!
 *
 */
public class JaxbMarshallingExample {
	
	public static void main(String[] args) throws JAXBException {
		
		StudentInfo info = new StudentInfo();
		info.setRegno(1);
		info.setFirstName("Praveen");
		info.setLastName("D");
		
		JAXBContext ctx = JAXBContext.newInstance(StudentInfo.class);
		Marshaller marshaller = ctx.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(info, System.out);
		marshaller.marshal(info, new File("D:\\StudentData.xml"));
	}
}
