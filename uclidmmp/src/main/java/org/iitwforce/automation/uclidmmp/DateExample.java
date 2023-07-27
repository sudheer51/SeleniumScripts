package org.iitwforce.automation.uclidmmp;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class DateExample {

	public static void main(String[] args) {

		String futureDate   =getfutureDate(10,"MMMM/dd/YYYY");
		System.out.println(futureDate.split("/")[0]);
		System.out.println(futureDate.split("/")[1]);
		System.out.println(futureDate.split("/")[2]);


	}
	public static String[] getfutureDate(int noofDays)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,noofDays);
		Date d  = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String expected = sdf.format(d);
		String dateArr[] = expected.split("/");
		System.out.println(dateArr[0]);
		System.out.println(dateArr[1]);
		System.out.println(dateArr[2]);
		return dateArr;
	}
	public static String getfutureDate(int count,String format)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,count);
		Date d  = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String expected = sdf.format(d);
//		String dateArr[] = expected.split("/");
//		System.out.println(dateArr[0]);
//		System.out.println(dateArr[1]);
//		System.out.println(dateArr[2]);
		return expected;
	}
}
