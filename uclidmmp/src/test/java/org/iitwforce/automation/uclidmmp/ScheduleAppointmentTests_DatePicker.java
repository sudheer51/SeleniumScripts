package org.iitwforce.automation.uclidmmp;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ScheduleAppointmentTests_DatePicker extends BaseClass {

	@Test(description="Validate the schedule appointment for a doctor")
	public void TC_003_validate_book_appointment()
	{
		launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).click();
		driver.findElement(By.cssSelector("input[value='Create new appointment']")).click();
		//(//button[@id='opener'])[4]
		driver.findElement(By.xpath("//h4[contains(.,'Charlie')]/ancestor::ul/following-sibling::button")).click();
		
		driver.switchTo().frame("myframe");
		
		
		//Date Picker Logic 
		driver.findElement(By.id("datepicker")).click();
		
		String expectedDate = getfutureDate(300);//30/03/2024
		String actualYear= driver.findElement(By.className("ui-datepicker-year")).getText();//2023
		while(!(actualYear.equals(expectedDate.split("/")[2])))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualYear= driver.findElement(By.className("ui-datepicker-year")).getText();
		}
		
		
		String actualMonth= driver.findElement(By.className("ui-datepicker-month")).getText();
		while(!(actualMonth.equals(expectedDate.split("/")[1])))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualMonth= driver.findElement(By.className("ui-datepicker-month")).getText();
		}
		driver.findElement(By.linkText(expectedDate.split("/")[0])).click();
		
		expectedDate = getfutureDate(300,"MM/dd/YYYY");
		 
		
		WebElement timeWE = driver.findElement(By.id("time"));
		Select timeSelect = new Select(timeWE);
		timeSelect.selectByValue("12Pm");
		driver.findElement(By.id("ChangeHeatName")).click();
		driver.switchTo().defaultContent();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement symWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sym")));
		symWE.sendKeys("Fever and Cold");
		
		
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		String actualDate = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualDate, expectedDate);
		sa.assertAll();
		
		//time
		//doctor
		//sym
		
		
	}
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
	
}
