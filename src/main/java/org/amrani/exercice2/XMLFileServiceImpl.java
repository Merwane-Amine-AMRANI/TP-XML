package org.amrani.exercice2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class XMLFileServiceImpl implements XMLFileService {

	public Document write(Employee employee) {
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

	public Employee readXMLFromFile(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
