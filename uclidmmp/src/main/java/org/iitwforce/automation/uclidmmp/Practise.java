package org.iitwforce.automation.uclidmmp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Practise {
	
	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		File f = new File("config/mmp.properties");
		FileInputStream fis = new FileInputStream(f.getAbsolutePath());
		prop.load(fis);
		System.out.println(prop.getProperty("browserType"));
		
//		String s=null;
//		System.out.println(s.length());
//		
//		double d1= 	575.15;
//		double d2 = 625.25;
//		
//		double change = (d2-d1)/0  * 100.0 ;
//		System.out.println("value " + change);
//		
//		double result = Math.round(change*100.0)/100.0;
//		System.out.println("after applying round::: " + result);
	}

}
