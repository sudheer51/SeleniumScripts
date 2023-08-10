package org.iitwforce.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectConfiguration {
	Properties prop = new Properties();
	public Properties loadProperties(String fName) throws IOException
	{
		File f = new File(fName);
		FileInputStream fis = new FileInputStream(f.getAbsolutePath());
		prop.load(fis);
		return prop;
		
	}

}
