package org.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//purpose -->> to load any property file
//output parameter ---> object of properties class

public class PropertiesHandle {
	
	public static Properties LoadProerties(String path) throws IOException {
		
		
		File f = new File(path);
		
		FileInputStream fi = new FileInputStream(f);
		Properties pr = new Properties();
		pr.load(fi);
		
		return pr;
		
	}

}
