package org.iitwforce.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AppLibrary {

	public static String getfutureDate(int noofDays)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,noofDays);
		Date d  = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");
		String expected = sdf.format(d);
//		String dateArr[] = expected.split("/");
//		System.out.println(dateArr[0]);
//		System.out.println(dateArr[1]);
//		System.out.println(dateArr[2]);
		return expected;
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
	public static String[][] readXLSX(String fileName) throws IOException
	//public static void main(String args[]) throws IOException
	{
	
		File f = new File(fileName);
		FileInputStream fis = new FileInputStream(f.getAbsolutePath());
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet=	  wb.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		String data[][] = new String[rows][cols];
		for(int r=0;r<rows;r++)
		{
			XSSFRow row = sheet.getRow(r);

			for(int c = 0; c < cols; c++) {

				XSSFCell cell = row.getCell(c);
				if(cell!=null)
				{
					String cdata = cell.getStringCellValue();
					data[r][c] = cdata;
				}
				else
				{
					data[r][c] = "";
				}
				System.out.println(data[r][c] );
			}

		}
	return data;
	}
}






























