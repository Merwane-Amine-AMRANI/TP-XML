package org.amrani.exercice3.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AveragingAgesHandler extends DefaultHandler {

	private int countAges = 0;
	private int sumAges = 0;
	private boolean isAge = false;
	private boolean isUser = false;
	private double averageAges = 0d;
	private StringBuilder ageBuider;
	
	@Override
	public void startDocument() throws SAXException {
		countAges = 0;
		sumAges = 0;
		isAge = false;
		isUser = false;
		ageBuider = new StringBuilder();
	}

	@Override
	public void endDocument() throws SAXException {
		averageAges = (double)sumAges / (double)countAges;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (localName.equals("user")) {
			isUser = true;
		}
		
		if (isUser && localName.equals("age")) {
			isAge = true;
			ageBuider.delete(0, ageBuider.length());
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (localName.equals("user")) {
			isUser = false;
		}
		
		if (isUser && localName.equals("age")) {
			int age = Integer.parseInt(ageBuider.toString());
			sumAges += age;
			countAges++;
			isAge = false;
		}
	}

	@Override
	public void characters(char characters[], int start, int length) throws SAXException {
		
		if (isAge) {
			ageBuider.append(characters, start, length);
		}
	}

	public double getAverageAges() {
		return averageAges;
	}

	public int getCount() {
		return countAges;
	}
}












