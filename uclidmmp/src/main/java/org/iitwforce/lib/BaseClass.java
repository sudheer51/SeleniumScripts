package org.iitwforce.lib;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	int i ;
	protected WebDriver driver;
	protected Properties prop;
	@BeforeClass
	public void instantiateDriver() throws IOException
	{
	 
		ProjectConfiguration pConfig = new ProjectConfiguration();
		File f = new File("config/mmp.properties");
		prop = pConfig.loadProperties(f.getAbsolutePath());
		String browserType = prop.getProperty("browser");
		if(browserType.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if (browserType.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
 
}
