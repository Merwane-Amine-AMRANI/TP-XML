package org.amrani.exercice2;

import org.dom4j.Document;


public interface XMLFileService {

	Document write(Employee employee);

	Employee readXMLFromFile(String string);
}
