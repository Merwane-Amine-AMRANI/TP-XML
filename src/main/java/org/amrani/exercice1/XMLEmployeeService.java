package org.amrani.exercice1;

import org.dom4j.Document;

public interface XMLEmployeeService {
	
	Document serialize(Employee employee) ;
	Employee deserialize(Document document) ;

}
