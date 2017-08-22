package data;

import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement//(namespace = "de.vogella.xml.jaxb.model")
//@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder={"companyNM", "info", "employeeList"})
public class Company 
{
	private String companyNM;
	private List<Employee> employeeList;
	private HashMap<String, String> info;
	
	@XmlElement(name = "employee")
	@XmlElementWrapper(name = "employee-list")
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@XmlElement(name = "company-name")
	public String getCompanyNM() {
		return companyNM;
	}

	public void setCompanyNM(String companyNM) {
		this.companyNM = companyNM;
	}

	@XmlElement(name = "company-info")
	public HashMap<String, String> getInfo() {
		return info;
	}

	public void setInfo(HashMap<String, String> info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Company [companyNM=" + companyNM + ", employeeList=" + employeeList + ", info=" + info + "]";
	}
}
