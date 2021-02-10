package org.amrani.exercice3;

import org.amrani.exercice3.model.User;

public class ReadWriteXML {

	public static void main(String[] args) {

		XMLFileService xmlFileService = new XMLFileServiceImpl();

//		User user1 = new User(12, "Paul", 34);
//		User user2 = new User(15, "Sarah", 26);
//		User user3 = new User(17, "James", 32);
//		User user4 = new User(21, "Rebecca", 29);
//
//		xmlFileService.writeXMLToFile(user1, "files/user1.xml");
//		xmlFileService.writeXMLToFile(user2, "files/user2.xml");
//		xmlFileService.writeXMLToFile(user3, "files/user3.xml");
//		xmlFileService.writeXMLToFile(user4, "files/user4.xml");
//
//		System.out.println("User XML written");

		User user = xmlFileService.readXMLFromFile("files/user.xml");
		System.out.println("User = " + user);
	}

}









