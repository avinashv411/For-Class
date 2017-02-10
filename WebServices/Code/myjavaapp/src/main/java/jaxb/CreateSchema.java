package jaxb;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class CreateSchema extends SchemaOutputResolver{

	@Override
	public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
		return new StreamResult(new File("test.xsd"));
	}

}
