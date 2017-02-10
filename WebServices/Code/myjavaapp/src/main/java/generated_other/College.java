package generated_other;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import jaxb2.StudentInfo;

@XmlRootElement
public class College 
{
	private StudentInfo[] students;

	@XmlElement(name="studnet")
	@XmlElementWrapper(name="students-list")
	public StudentInfo[] getStudents() {
		return students;
	}

	public void setStudents(StudentInfo[] students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "College [students=" + Arrays.toString(students) + "]";
	}
}
