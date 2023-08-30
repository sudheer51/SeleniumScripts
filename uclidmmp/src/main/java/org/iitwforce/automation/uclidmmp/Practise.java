package org.iitwforce.automation.uclidmmp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Practise {
	
	public static void main(String[] args) throws IOException {
		 
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		 TimeZone tz = TimeZone.getTimeZone("America/New_York");
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM/dd/YYYY");
		sdf.setTimeZone(tz);
		System.out.println(sdf.format(cal.getTime()));
		
//		String currentPrice="1,093.50$";
//		double d = Double.parseDouble(currentPrice.replace(",", "").replace("$",""));
//		System.out.println(d);
//		
//		double d1= 12.577;
//		System.out.println(Math.round(d1*100.0)/100.0);
		
//		Properties prop = new Properties();
//		File f = new File("config/mmp.properties");
//		FileInputStream fis = new FileInputStream(f.getAbsolutePath());
//		prop.load(fis);
//		System.out.println(prop.getProperty("browserType"));
//		
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
