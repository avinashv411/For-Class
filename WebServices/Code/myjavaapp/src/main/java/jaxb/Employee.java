package jaxb;

import java.util.Arrays;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"name","salary", "address", "phoneNumber"})
public class Employee {
	
	private int id;
	private String name;
	private float salary;
	private Address[] address;
	private Set<Long> phoneNumber;
	
	public Employee() {
	}

	public Employee(int id, String name, float salary) {
		// super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@XmlElement(name="address")
	@XmlElementWrapper(name="employee-address")
	public Address[] getAddress() {
		return address;
	}

	public void setAddress(Address[] address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", address=" + Arrays.toString(address)
				+ ", phoneNumber=" + phoneNumber + "]";
	}

	@XmlElement(name="number")
	@XmlElementWrapper(name="phone-numbers")
	public Set<Long> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Set<Long> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}