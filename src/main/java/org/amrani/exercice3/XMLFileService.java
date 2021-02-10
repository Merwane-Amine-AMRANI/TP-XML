package org.amrani.exercice3;

import org.amrani.exercice3.model.User;

public interface XMLFileService {

	void writeXMLToFile(User user, String fileName);

	User readXMLFromFile(String string);
}
