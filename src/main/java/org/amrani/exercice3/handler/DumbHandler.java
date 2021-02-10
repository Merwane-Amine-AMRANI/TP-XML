package org.amrani.exercice3.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DumbHandler extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Début du document");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Fin du document");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		System.out.printf("Ouverture de l'élément : %s %s %s\n", uri, localName, qName);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		System.out.printf("Fermeture de l'élément : %s %s %s\n", uri, localName, qName);
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		
		String text = new String(ch, start, length);
		System.out.println("Contenu textuel = " + text);
	}
}












