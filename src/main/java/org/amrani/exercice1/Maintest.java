package org.amrani.exercice1;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Maintest {

	public static void main(String[] args) {

		Employee sarah = new Employee(12, "sarah", 33);
		XMLEmployeeService sarahXml = new XMLEmployeeServiceImlp();
		sarahXml.serialize(sarah);
		
		System.out.println("Document Xml has been created");
		
		Document document = readFileXml();
		
		Employee readXml = sarahXml.deserialize(document); 
		System.out.println("employee "+ readXml);
		

	}

	private static Document readFileXml() {
		File employee = new File("files/employee.xml");
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(employee);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}

}
