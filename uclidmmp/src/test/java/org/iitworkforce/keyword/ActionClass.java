package org.iitworkforce.keyword;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ActionClass {

	static WebDriver driver;
	static int row;
	public static void invokeMethod(String className, String methodName,
			Object... inputArgs) {

		Class<String> params[] = new Class[inputArgs.length];
		for (int i = 0; i < inputArgs.length; i++) {
			if (inputArgs[i] instanceof String) {
				params[i] = String.class;
			}
		}
		try {
			Class actionClass = Class.forName(className);
			Object _instance = actionClass.newInstance();
			Method myMethod = actionClass.getDeclaredMethod(methodName, params);
			myMethod.invoke(_instance, inputArgs);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	public  boolean run(WebDriver driver,String fileName,String sheetName) throws Exception{
		boolean result = false;
		this.driver = driver;
		ExcelUtils.setExcelFile(fileName, sheetName);
		int rowCount = ExcelUtils.getNoOfRows();
		System.out.println("Number of rows" +rowCount);
		for (row=1; row <=rowCount; row++) {
			List<Object> myParamList = new ArrayList<Object>();
			String methodName = ExcelUtils.getCellData(row,2);
			for (int col = 3; col < 7; col++) {
				if (!ExcelUtils.getCellData(row, col).isEmpty()
						& !ExcelUtils.getCellData(row, col).equals("null")) {
					myParamList.add(ExcelUtils.getCellData(row,col));
				}
			}

			Object[] paramsArray = new String[myParamList.size()];
			paramsArray = myParamList.toArray(paramsArray);
			invokeMethod("org.iitworkforce.keyword.ActionClass",
					methodName, paramsArray);
		}
		result = true;
		return result;
	}

	public void launchApplication(String url)
	{

		driver.get(url);	             	            
	}	

	public static void dropDownSelect(String elementReference, String element, WebDriver driver,String data)
			throws Exception
	{
		try
		{
			WebElement select = findElement(elementReference, element);
			List<WebElement> dropDownSelection = select.findElements(By.tagName("option"));
			for (WebElement option : dropDownSelection)
			{
				if (data.trim().equals(option.getText().trim()))
				{
					option.click();
					Thread.sleep(1000L);
					break;
				}
				Thread.sleep(1000L);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);

		}
	}
	public void verifyText(String elementReference, String referenceValue,String data)
	{
		try{
			String actual = findElement(elementReference, referenceValue).getText();
			if(actual.contains(data))
			{
				System.out.println("Expected is equal to actual");
				ExcelUtils.writeCellData(row,6,"Pass");
			}
			else
			{
				ExcelUtils.writeCellData(row,6,"Fail");
			}
			Thread.sleep(1000L);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 	              	           

		}

	}
	public static WebElement findElement(String elementReference, String referenceValue,String data)
			throws Exception
	{
		WebElement x = null;
		try
		{
			if (elementReference.equalsIgnoreCase("id"))
			{
				x= driver.findElement(By.id(referenceValue));
			}
			else if (elementReference.equalsIgnoreCase("class"))
			{
				x=driver.findElement(By.className(referenceValue));
			}
			else if (elementReference.equalsIgnoreCase("name"))
			{
				x= driver.findElement(By.name(referenceValue));
			}
			else if (elementReference.equalsIgnoreCase("tagname"))
			{
				x= driver.findElement(By.tagName(referenceValue));
			}
			else if (elementReference.equalsIgnoreCase("linktext"))
			{
				x= driver.findElement(By.linkText(referenceValue));
			}
			else if (elementReference.equalsIgnoreCase("xpath"))
			{
				x= driver.findElement(By.xpath(referenceValue));
			}
			else if (elementReference.equalsIgnoreCase("css"))
			{
				x= driver.findElement(By.cssSelector(referenceValue));
			}


		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		x.sendKeys(data);
		return x;
	}
	public static WebElement findElement(String elementReference, String referenceValue)
			throws Exception
	{
		WebElement x = null;
		try
		{
			if (elementReference.equalsIgnoreCase("id"))
			{
				x = driver.findElement(By.id(referenceValue));

			}
			else if (elementReference.equalsIgnoreCase("class"))
			{
				x = driver.findElement(By.className(referenceValue));
			}
			else if (elementReference.equalsIgnoreCase("name"))
			{
				x = driver.findElement(By.name(referenceValue));
			}
			else if (elementReference.equalsIgnoreCase("tagname"))
			{
				x = driver.findElement(By.tagName(referenceValue));
			}
			else if (elementReference.equalsIgnoreCase("linktext"))
			{
				x = driver.findElement(By.linkText(referenceValue));
			}
			else if (elementReference.equalsIgnoreCase("xpath"))
			{
				x = driver.findElement(By.xpath(referenceValue));
			}
			else if (elementReference.equalsIgnoreCase("css"))
			{
				x = driver.findElement(By.cssSelector(referenceValue));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		x.click();
		return x;
	}
}