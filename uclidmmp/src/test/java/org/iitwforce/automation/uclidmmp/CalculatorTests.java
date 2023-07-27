package org.iitwforce.automation.uclidmmp;

import org.junit.Test;

import junit.framework.Assert;

public class CalculatorTests {
	
	@Test
	public void validateAdd()
	{
		Calculator cal = new Calculator();
		int actual = cal.add(2,3);
		int expected = 5;
		Assert.assertEquals(actual, expected);
	}

}
