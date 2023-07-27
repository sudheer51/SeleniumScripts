package org.iitwforce.automation.uclidmmp;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StockTests extends BaseClass{
 
	@Test(description="Verify the title is displayed correctly")
	public void TC_001_validate_Title()
	{
		
		String actual = driver.getTitle();
		String expected="    : BSE, NSE, Stock quotes, share market, stock market, stock tips: Rediff Stocks";
		Assert.assertEquals(actual.trim(),expected.trim());
	
	}
	@Test(description="Verify the search textbox functionality of the real time quote of the company.")
	public void TC_002_validate_SearchBox() throws InterruptedException
	{
		driver.findElement(By.id("srchword")).sendKeys("TCS");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='sugbox']/div[1]")).click();
		String expected="Tata Consultancy Services Ltd.";
		String actual = driver.findElement(By.tagName("h1")).getText();
		System.out.println("Actual String value" + actual);
		Assert.assertTrue(actual.contains(expected));
		
		String stockPrice = driver.findElement(By.id("ltpid")).getText();
		double price = Double.parseDouble(stockPrice);
		Assert.assertTrue(price>0);		
	}

}
