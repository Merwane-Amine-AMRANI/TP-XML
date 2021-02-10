package org.amrani.exercice3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.amrani.exercice3.model.*;

public class XMLFileServiceImpl implements XMLFileService {

	@Override
	public void writeXMLToFile(User user, String fileName) {
		Document document = DocumentHelper.createDocument();
		Element rootElement = document.addElement("user");
		rootElement.addAttribute("id", String.valueOf(user.getId()));
		Element nameElement = rootElement.addElement("name");
		nameElement.addText(user.getName());
		Element ageElement = rootElement.addElement("age");
		ageElement.addText(String.valueOf(user.getAge()));

		try (Writer writer = new FileWriter(fileName);) {

			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter xmlWriter = new XMLWriter(writer, format);
			xmlWriter.write(document);

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Override
	public User readXMLFromFile(String fileName) {
		try (Reader reader = new FileReader(fileName);) {
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(reader);
			
			User user = new User();
			Element rootElement = document.getRootElement();
			
			Attribute attribute = rootElement.attribute("id");
			long id = Long.parseLong(attribute.getValue());
			user.setId(id);
			
			Namespace namespace = new Namespace("t3", "http://paumard.org/t3");
			QName nameQName = new QName("name", namespace);
			Element nameElement = rootElement.element(nameQName);
			String name = nameElement.getText();
			user.setName(name);
			
			QName ageQName = new QName("age", namespace);
			Element ageElement = rootElement.element(ageQName);
			int age = Integer.parseInt(ageElement.getText());
			user.setAge(age);
			
			return user;
			
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
}














