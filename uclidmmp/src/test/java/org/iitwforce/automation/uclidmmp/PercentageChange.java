package org.iitwforce.automation.uclidmmp;

import java.util.List;

import org.iitwforce.lib.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PercentageChange extends BaseClass{
	 

	@Test
	public void validateChange()
	{
		String stockName = "Inox Wind Ltd.";
		List<WebElement> stockDetailsList = driver.findElements(By.xpath("//a[normalize-space()='"+stockName+"']/parent::td/following-sibling::td"));
		double d1= 	Double.parseDouble(stockDetailsList.get(1).getText());
		double d2 = Double.parseDouble(stockDetailsList.get(2).getText());
		double expected= Double.parseDouble(stockDetailsList.get(3).getText().replace("+",""));
		double change = (d2-d1)/d1  * 100.0 ;
		System.out.println("value " + change);
		double actual = Math.round(change*100.0)/100.0;
		System.out.println("after applying round::: " + actual);
		
		Assert.assertEquals(actual, expected);
	}
	//a[normalize-space()='Inox Wind Ltd.']/parent::td/following-sibling::td
	//a[normalize-space()='MOIL']/parent::td/following-sibling::td
}
