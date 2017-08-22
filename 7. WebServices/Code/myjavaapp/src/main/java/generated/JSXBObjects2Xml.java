package generated;

import java.io.FileOutputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import generated_other.Company.EmployeeList;
import generated_other.Company.Info;
import generated_other.Company.Info.Entry;
import generated_other.Employee.EmployeeAddress;
import generated_other.Employee.PhoneNumbers;

public class JSXBObjects2Xml {
	public static void main(String[] args) throws Exception 
	{
		ObjectFactory fac = new ObjectFactory();
		StudentInfo stu = fac.createStudentInfo();
		stu.setRegno(1);
		stu.setFirstName("AAA");
		stu.setLastName("BBB");
		
		fac.createStudentInfo(stu);
		
		//1. Create JAXBContext
		JAXBContext contextObj = JAXBContext.newInstance(ObjectFactory.class);
//		System.out.println(contextObj.getClass().getName());
		//2. Create Marshaller
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		//3. Generate XML with the help of Marshaller
		marshallerObj.marshal(stu, new FileOutputStream("jaxbObjects2XML.xml"));
		marshallerObj.marshal(stu, System.out);

	}
}