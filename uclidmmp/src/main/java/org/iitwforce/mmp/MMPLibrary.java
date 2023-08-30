package org.iitwforce.mmp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MMPLibrary {
	WebDriver driver;
	public MMPLibrary(WebDriver driver)
	{
		this.driver = driver;
	}
	 
	public void launchBrowser(String url)
	{
		driver.get(url);
	}
	public void navigateToAModule(String moduleName)
	{
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
	}
	public void login(String username ,String passowrd)
	{
		
	}
	 

}
