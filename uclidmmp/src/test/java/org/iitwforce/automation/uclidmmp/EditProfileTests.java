package org.iitwforce.automation.uclidmmp;

import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditProfileTests extends BaseClass{

	@Test(description="Validate the Edit functionality in the profile page")
	public void TC_004_validate_book_appointment()
	{
		launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		System.out.println("To check the Textbox is nonEditable" + driver.findElement(By.id("fname")).isEnabled());
		driver.findElement(By.id("Ebtn")).click();

		//set a new value for FirstName textbox
		driver.findElement(By.id("fname")).clear();
		String expected = randomString("IITWFFname");
		driver.findElement(By.id("fname")).sendKeys(expected);
		driver.findElement(By.id("Sbtn")).click();
		Alert alert  = driver.switchTo().alert();
		alert.accept();
		String actual = driver.findElement(By.id("fname")).getAttribute("value");
		Assert.assertEquals(actual, expected);



	}

	@Test(description="Validate the Edit functionality in the profile page for All the fields")
	public void TC_005_validate_book_appointment()
	{
		HashMap<String,String> expectedHMap = new HashMap<String,String>();
		HashMap<String,String> actualHMap = new HashMap<String,String>();

		launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		driver.findElement(By.id("Ebtn")).click();

		//set a new value for FirstName text box
		driver.findElement(By.id("fname")).clear();
		String expectedFName = randomString("IITWFFname");
		expectedHMap.put("FName", expectedFName);

		driver.findElement(By.id("fname")).sendKeys(expectedFName);

		//set a new value for LName text box
		driver.findElement(By.id("lname")).clear();
		String expectedLName = randomString("IITWFLname");
		expectedHMap.put("LName", expectedLName);

		driver.findElement(By.id("lname")).sendKeys(expectedLName);


		//Click on save button
		driver.findElement(By.id("Sbtn")).click();
		Alert alert  = driver.switchTo().alert();
		alert.accept();

		String actualFName = driver.findElement(By.id("fname")).getAttribute("value");
		actualHMap.put("FName", actualFName);
		
		String actualLName = driver.findElement(By.id("lname")).getAttribute("value");
		actualHMap.put("LName", actualLName);


		Assert.assertEquals(actualHMap, expectedHMap);



	}
	public static String randomString(String s)
	{
		Random rand = new Random();
		char uppercaseCh = (char) (65+rand.nextInt(26));
		char lowerCaseCh = (char) (97+rand.nextInt(26));
		return s+uppercaseCh+lowerCaseCh;

	}
}
