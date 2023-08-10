package org.iitwforce.mmp.pages;

import java.time.Duration;
import java.util.HashMap;

import org.iitwforce.lib.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScheduleAppointmentPage {

	private By appointmentButtonCss = By.cssSelector("input[value='Create new appointment']");
	private By datePickerID = By.id("datepicker");
	private By datePickerYearClassName = By.className("ui-datepicker-year");
	private By datePickerYearMonthName = By.className("ui-datepicker-month");
	private By timeID = By.id("time");
	private By continueButttonID = By.id("ChangeHeatName");
	private By symID = By.id("sym");
	private By nextButtonXPath = By.xpath("//span[text()='Next']");
	WebDriver driver;
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver= driver;
	}
	public HashMap<String, String> bookAppointment(String doctorName)
	{
		HashMap<String,String> expectedHMap = new HashMap<String,String>();
	 
		expectedHMap.put("doctor", doctorName);
		driver.findElement(appointmentButtonCss).click();
		//(//button[@id='opener'])[4]
		driver.findElement(By.xpath("//h4[contains(.,'"+doctorName+"')]/ancestor::ul/following-sibling::button")).click();

		driver.switchTo().frame("myframe");


		//Date Picker Logic 
		driver.findElement(datePickerID).click();

		String expectedDate =  AppLibrary.getfutureDate(300);//30/03/2024
		String actualYear= driver.findElement(datePickerYearClassName).getText();//2023
		while(!(actualYear.equals(expectedDate.split("/")[2])))
		{
			driver.findElement(nextButtonXPath).click();
			actualYear= driver.findElement(datePickerYearClassName).getText();
		}


		String actualMonth= driver.findElement(datePickerYearMonthName).getText();
		while(!(actualMonth.equals(expectedDate.split("/")[1])))
		{
			driver.findElement(nextButtonXPath).click();
			actualMonth= driver.findElement(datePickerYearMonthName).getText();
		}
		driver.findElement(By.linkText(expectedDate.split("/")[0])).click();

		expectedDate = AppLibrary.getfutureDate(300,"MM/dd/YYYY");
		expectedHMap.put("date", expectedDate);

		WebElement timeWE = driver.findElement(timeID);
		Select timeSelect = new Select(timeWE);
		expectedHMap.put("time", "12Pm");
		timeSelect.selectByValue("12Pm");
		driver.findElement(continueButttonID).click();
		driver.switchTo().defaultContent();

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement symWE = wait.until(ExpectedConditions.visibilityOfElementLocated(symID));
		symWE.sendKeys("Fever and Cold");
		expectedHMap.put("sym","Fever and Cold");

		driver.findElement(By.cssSelector("input[value='Submit']")).click();

		return expectedHMap;
	}
}
