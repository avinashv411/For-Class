package jaxb;

import java.io.File;  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;

import data.Company;
import data.Employee;  
  
public class XmlToObject {  
public static void main(String[] args) {  
     try {    
            File file = new File("employee3.xml");    
            JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);    
         
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
            Company e=(Company) jaxbUnmarshaller.unmarshal(file);    
            System.out.println(e);  
              
          } catch (JAXBException e) {e.printStackTrace(); }    
}  

public static void main2(String[] args) {  
    try {    
           File file = new File("employee.xml");    
           JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);    
        
           Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
           Employee e=(Employee) jaxbUnmarshaller.unmarshal(file);    
           System.out.println(e);  
             
         } catch (JAXBException e) {e.printStackTrace(); }    
}  


}  