package generated;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import generated.Company.EmpList;

public class ObjectToXml {
	public static void main(String[] args) throws Exception 
	{
		Employee emp1 = new Employee(1, "Vimal Jaiswal", 50000);
		Employee emp2 = new Employee(2, "Praveen D", 60000);
		
		Company cmp = new Company();
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(emp1);
		empList.add(emp2);
		EmpList eList = new ObjectFactory().createCompanyEmpList();
		eList.getEmployee().add(emp1);
		eList.getEmployee().add(emp2);
		//cmp.setEmployeeList(eList);
		
		//1. Create JAXBContext
		JAXBContext contextObj = JAXBContext.newInstance(Company.class);
		
		//2. Create Marshaller
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		//3. Generate XML with the help of Marshaller
		marshallerObj.marshal(cmp, new FileOutputStream("employee3.xml"));
		marshallerObj.marshal(cmp, System.out);

	}
}