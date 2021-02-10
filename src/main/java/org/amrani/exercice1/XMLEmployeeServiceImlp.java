package org.amrani.exercice1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XMLEmployeeServiceImlp implements XMLEmployeeService {

	public Document serialize(Employee employee) {
		Document document = DocumentHelper.createDocument();
		Element rootElement = document.addElement("employee");
		rootElement.addAttribute("id", String.valueOf(employee.getId()));
		Element nameElement = rootElement.addElement("nom");
		nameElement.addText(employee.getName());
		Element ageElement = rootElement.addElement("age");
		ageElement.addText(String.valueOf(employee.getAge()));

		try {
			Writer writer = new FileWriter("files/sarah.xml");
			OutputFormat format = OutputFormat.createPrettyPrint();;
			XMLWriter xlmWriter = new XMLWriter(writer,format);
			xlmWriter.write(document);
			xlmWriter.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return document;
		
	}

	public Employee deserialize(Document document) {
		Employee employee = new Employee();
		
		Element rootElement = document.getRootElement();
		Attribute attribute = rootElement.attribute("id");
		long id = Long.parseLong(attribute.getValue());
		employee.setId(id);
		
		Element nameElement = rootElement.element("name");
		String employeeName = nameElement.getText();
		employee.setName(employeeName);
		
		Element ageElement = rootElement.element("age");
		int employeeAge = Integer.parseInt(ageElement.getText());
		employee.setAge(employeeAge);
		
		return employee;
		
	}

}
