package generated_other;

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
		
		EmployeeAddress eAddress = fac.createEmployeeEmployeeAddress();
		List<Address> eAdds = eAddress.getAddress();
		short no = 10;
		Address add1 = fac.createAddress();
		add1.setAddress1("Addresss 1");
		add1.setAddress2("Address 2");
		add1.setHouseNumber(no);
		add1.setLandmark("Near Land Mark");
		add1.setPincode(1234567);
		add1.setType("present");
		
		Address add2 = fac.createAddress();
		add2.setAddress1("Addresss 1");
		add2.setAddress2("Address 2");
		add2.setHouseNumber(no);
		add2.setLandmark("Near Land Mark");
		add2.setPincode(1234567);
		add2.setType("permanent");
		
		eAdds.add(add1);
		eAdds.add(add2);
		
		PhoneNumbers phoneNums = fac.createEmployeePhoneNumbers();
		List<Long> empNums = phoneNums.getNumber();
		empNums.add(1234567890L);
		empNums.add(7654321L);
		
		EmployeeList eList = fac.createCompanyEmployeeList();
		List<Employee> emps = eList.getEmployee();
		
		Employee emp1 = fac.createEmployee();
		emp1.setId(1);
		emp1.setName("AAA");
		emp1.setSalary(100.100f);
		emp1.setEmployeeAddress(eAddress);
		emp1.setPhoneNumbers(phoneNums);
		
		Employee emp2 = fac.createEmployee();
		emp2.setId(2);
		emp2.setName("BBB");
		emp2.setSalary(200.200f);
		emp2.setEmployeeAddress(eAddress);
		emp2.setPhoneNumbers(phoneNums);
		
		emps.add(emp1);
		emps.add(emp2);
		
		Company cmp = fac.createCompany();
		Info info = fac.createCompanyInfo();
		List<Entry> ents = info.getEntry();
		Entry ent1 = fac.createCompanyInfoEntry();
		ent1.setKey("key1");
		ent1.setValue("Value1");
		
		Entry ent2 = fac.createCompanyInfoEntry();
		ent2.setKey("key2");
		ent2.setValue("Value2");
		
		ents.add(ent1);
		ents.add(ent2);
		
		cmp.setCompanyName("JSpiders");
		cmp.setInfo(info);
		cmp.setEmployeeList(eList);
		
		//1. Create JAXBContext
		JAXBContext contextObj = JAXBContext.newInstance("generated");
//		System.out.println(contextObj.getClass().getName());
		//2. Create Marshaller
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		//3. Generate XML with the help of Marshaller
		marshallerObj.marshal(fac, new FileOutputStream("jaxbObjects2XML.xml"));
		marshallerObj.marshal(fac, System.out);

	}
}