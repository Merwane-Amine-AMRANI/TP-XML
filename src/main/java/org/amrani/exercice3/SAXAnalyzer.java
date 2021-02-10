package org.amrani.exercice3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.amrani.exercice3.handler.AveragingAgesHandler;
import org.xml.sax.SAXException;

public class SAXAnalyzer {

	public static void main(String... args) throws ParserConfigurationException, SAXException {

		SAXParserFactory saxParserFactory = SAXParserFactory.newDefaultInstance();
		saxParserFactory.setValidating(true);
		saxParserFactory.setNamespaceAware(true);
		SAXParser saxParser = saxParserFactory.newSAXParser();

		try (InputStream inputStream = new FileInputStream("files/users.xml");) {

			AveragingAgesHandler handler = new AveragingAgesHandler();
			saxParser.parse(inputStream, handler);
			
			System.out.println("# users = " + handler.getCount());
			System.out.println("# ages = " + handler.getAverageAges());

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done!");
	}
}







