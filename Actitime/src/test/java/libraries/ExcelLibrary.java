package libraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public  class ExcelLibrary
{
	
public String getExcelData(String sheetName,int rowNum,int colNum)
{
	String RetVal = null;
	try {
		FileInputStream fis = new FileInputStream(("D:/Data.xlsx"));
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetName);
		Row r = s.getRow(rowNum);
		Cell c = r.getCell(colNum);
		RetVal = c.getStringCellValue();		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return RetVal;	
}

public void writeExcelData(String sheetName,int rowNum,int colNum,String result)
{
	
	try {
		FileInputStream fis = new FileInputStream(("D:/Data.xlsx"));
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetName);
		Row r = s.getRow(rowNum);		
		Cell c = r.createCell(colNum);
		System.out.println("Set the value in XL");
		c.setCellValue(result);
		System.out.println(c.getStringCellValue());
		FileOutputStream fos = new FileOutputStream("D:/Data.xlsx");
		wb.write(fos);
		fos.close();
		fis.close();		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public int getRowNum(String sheetName)
{
	int rowNum =0;
	try {
		FileInputStream fis = new FileInputStream("D:/Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//Sheet s = wb.createSheet("Sheet2");
		Sheet s = wb.getSheet(sheetName);
		rowNum =s.getLastRowNum();
		
				
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rowNum;
	
}



}

