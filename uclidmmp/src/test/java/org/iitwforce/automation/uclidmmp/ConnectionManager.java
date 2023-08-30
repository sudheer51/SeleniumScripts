package org.iitwforce.automation.uclidmmp;

import java.sql.SQLException;

import org.iitwforce.lib.AppLibrary;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 

public class ConnectionManager
{
	/*
	 * Load the Driver Instance->class.forName("pass the driver class")
		Create a connection- username,password,hostip,database
		Create a statement
		Execute Queries: select * from mmp.patient_data=> result set
		Fetch the data store in Array
		Pass the Array to the DP
		Use the DP for executing the testcases
		https://www.w3schools.com/sql/sql_where.asp
		https://total-qa.com/mysql-database-testing-using-selenium-webdriver-step-step-guide/
	 */

	@Test(dataProvider="DP")
	public void validateLogin(String patientID,String patientName,String dateOfAppointment)
	{
		
		System.out.println("DB Values: " + patientID);
		System.out.println("DB Values:"  + patientName);
		System.out.println("DB Values:"  + dateOfAppointment);
		
//		WebDriverManager.chromeDriver.setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get(url);
//		driver.findElement(By.id("")).sendKeys(uname);
//		driver.findElement(By.id("")).sendKeys(pword);
//		driver.findElement(By.id("")).click();
		
	}
	
	@DataProvider(name="DP")
	public String[][] feedDP() throws ClassNotFoundException, SQLException
	{
		String data[][] =AppLibrary.getDBValues("root","root","testdb","localhost");
		return data;
	}
	 
}