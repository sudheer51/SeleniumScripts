package org.iitwforce.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
	public static String[][] getDBValues(String uname,String pword,String dbname,String hostip) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	//	Driver driver = new Driver();
		/*
		 * url a database url of the form jdbc:subprotocol:subnameuser 
		 * the database user on whose behalf the connection is being madepassword 
		 * the user's password
		 */
		String url="jdbc:mysql://localhost:3306/prime_db";
		String username="root";
		String password="root";
		
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
											 ResultSet.CONCUR_READ_ONLY);
		//int  value = stmt.executeUpdate("INSERT INTO `mmp`.`patient_data` VALUES (11,'James','22/11/2021');");
		//System.out.println("The rows are updated "+ value);
		
		ResultSet rs =  stmt.executeQuery("Select * from prime_db.patient_data");
		rs.last();
		
		int rows = rs.getRow();
		System.out.println("Number of rows " + rows);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int cols = rsmd.getColumnCount();
		System.out.println("Number of cols: "+ cols);
		
		String data[][]= new String[rows][cols];
		
		int i=0;
		rs.beforeFirst();
		while(rs.next())
		{
			for(int j=0;j<cols;j++)
			{
				data[i][j]=rs.getString(j+1);
				System.out.println(data[i][j]);
			}
			i++;
		}	
		return data;
	}

}
































