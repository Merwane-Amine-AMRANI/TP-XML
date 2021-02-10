package org.amrani.exercice3.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CountingHandler extends DefaultHandler {

	private long countUsers = 0L;
	
	@Override
	public void startDocument() throws SAXException {
		this.countUsers = 0L;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (localName.equals("user")) {
			countUsers = getCountUsers() + 1;
		}
	}

	public long getCountUsers() {
		return countUsers;
	}
}












