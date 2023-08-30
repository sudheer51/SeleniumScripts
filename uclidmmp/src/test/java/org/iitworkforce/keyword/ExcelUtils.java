package org.iitworkforce.keyword;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils {
	private static XSSFSheet excelWSheet;//Sheet
	private static XSSFWorkbook excelWBook;//Workbook
	private static XSSFCell cell;//Cell
	private static XSSFRow row;
 
	public static void setExcelFile(String Path,String SheetName) throws Exception {
		FileInputStream ExcelFile = new FileInputStream(Path);
		excelWBook = new XSSFWorkbook(ExcelFile);
		excelWSheet = excelWBook.getSheet(SheetName);
	}
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		//
		//row = excelWSheet.getRow(RowNum);
		//cell =row.getCell(ColNum);
		
		cell = excelWSheet.getRow(RowNum).getCell(ColNum);
		
		String CellData = cell.getStringCellValue();
		return CellData;
	}
	public static void writeCellData(int RowNum, int ColNum,String result) throws Exception{
		cell = excelWSheet.getRow(RowNum).createCell(ColNum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(result);
		FileOutputStream fos=new FileOutputStream("inputData.xlsx");
		excelWBook.write(fos);
		fos.close();
	}
	public static int getNoOfRows()
	{
		return excelWSheet.getLastRowNum();
	}
	 
	  
}