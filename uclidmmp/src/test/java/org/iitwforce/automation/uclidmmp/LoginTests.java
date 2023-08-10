package org.iitwforce.automation.uclidmmp;

import java.io.IOException;

import org.iitwforce.lib.AppLibrary;
import org.iitwforce.lib.BaseClass;
import org.iitwforce.mmp.MMPLibrary;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseClass {


	 
	@Test(description="Login to Patient Module with valid credentails",
		  dataProvider="logindata")
	public void TC_001_Login_with_valid_creds(String username,String password)
	{
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchBrowser("http://162.144.124.67/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		String expected="Patient Portal";
	 
		mmpLib.login(username,password);
		String actual = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().trim();
		Assert.assertEquals(actual, expected); 
	
	}
	@DataProvider(name="logindata")
	public String[][] feedDP() throws IOException
	{
		String data[][] = AppLibrary.readXLSX("logindata.xlsx");
		return data;
		
	}
	
	
//	@Test(description="Login to Patient Module with valid credentails and validate the tabs")
//	public void TC_002_validate_tabs()
//	{
//		launchBrowser("http://162.144.124.67/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
//		String expected="Patient Portal";
//	
//		String actual = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().trim();
//		MMPLibrary mmpLib = new MMPLibrary(driver);
//		mmpLib.login();
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(actual, expected); 
//		sa.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'ABC')]")).isDisplayed());
//		sa.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'DEF')]")).isDisplayed());
//		sa.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).isDisplayed());
//		sa.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Fees')]")).isDisplayed());
//		sa.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Search Symptoms')]")).isDisplayed());
//		sa.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Messages')]")).isDisplayed());
//		sa.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).isDisplayed());
//		sa.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Information')]")).isDisplayed());
//		sa.assertAll();
//	}
}
