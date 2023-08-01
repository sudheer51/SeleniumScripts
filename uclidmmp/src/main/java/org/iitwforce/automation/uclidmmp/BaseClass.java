package org.iitwforce.automation.uclidmmp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	int i ;
	WebDriver driver;
	@BeforeClass
	public void launchApplication()
	{
	 
		WebDriverManager.chromedriver().setup();
		i      =  20;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		 
	}
 
}
