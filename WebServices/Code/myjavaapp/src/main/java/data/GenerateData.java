package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateData {
	public static Company gererate(){
		Address addr1 = new Address("present", (short)12, "3rd A Cross, 18th Main, ABC Layout", "Bangalore", "Near School", 123456);
		Address addr2 = new Address("permanent", (short)14, "4th B Cross, 20th Main, ABC Layout", "Bangalore", "Near School", 123456);
		
		Address[] addr = {addr1, addr2};
		
		Set<Long> numbers = new HashSet<Long>();
		numbers.add(1234567890L);
		numbers.add(2234567890L);
		numbers.add(3234567890L);
		
		Employee emp1 = new Employee(1, "Vimal Jaiswal", 50000);
		emp1.setAddress(addr);
		emp1.setPhoneNumber(numbers);
		
		Employee emp2 = new Employee(2, "Praveen D", 60000);
		emp2.setAddress(addr);
		emp2.setPhoneNumber(numbers);
		
		HashMap<String, String> compInfo = new HashMap<String, String>();
		compInfo.put("company-type", "Teaching");
		compInfo.put("company-location", "Bangalore");
		
		Company cmp = new Company();
		cmp.setCompanyNM("JSpiders");
		cmp.setInfo(compInfo);
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(emp1);
		empList.add(emp2);
		cmp.setEmployeeList(empList);
		
		return cmp;
	}
}
