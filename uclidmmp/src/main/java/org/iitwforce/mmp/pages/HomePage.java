package org.iitwforce.mmp.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	@FindBy(xpath="//table[@class='table']/tbody/tr[1]/td[1]")
	private WebElement dateWE;
	@FindBy(xpath="//table[@class='table']/tbody/tr[1]/td[2]")
	private WebElement timeWE;
	@FindBy(xpath="//table[@class='table']/tbody/tr[1]/td[3]")
	private WebElement symWE;
	@FindBy(xpath="//table[@class='table']/tbody/tr[1]/td[4]")
	private WebElement doctorWE;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public HashMap<String, String> fetchPatientPortalDetails()
	{
		HashMap<String,String> actualHMap = new HashMap<String,String>();
		actualHMap.put("date",dateWE.getText());
		actualHMap.put("time",timeWE.getText() );
		actualHMap.put("sym",symWE.getText());
		actualHMap.put("doctor", doctorWE.getText());
		return actualHMap;
	}
}
