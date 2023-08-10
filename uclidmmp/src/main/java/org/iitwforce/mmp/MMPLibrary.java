package org.iitwforce.mmp;

import java.time.Duration;
import java.util.HashMap;

import org.iitwforce.lib.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMPLibrary {
	WebDriver driver;
	public MMPLibrary(WebDriver driver)
	{
		this.driver = driver;
	}
	public void login(String username,String password)
	{
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
	}
	public void launchBrowser(String url)
	{
		driver.get(url);
	}
	public void navigateToAModule(String moduleName)
	{
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
	}
	 

}
