package jaxb;

import javax.xml.bind.JAXBContext;

import data.Company;

public class SchemaGenerator 
{
	public static void main(String[] args) throws Exception
	{
		JAXBContext context = JAXBContext.newInstance(Company.class);
		context.generateSchema(new CreateSchema());
		
	}
}
