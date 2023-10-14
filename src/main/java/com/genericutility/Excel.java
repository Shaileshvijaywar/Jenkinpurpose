package com.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public String excelRead(String SheetName, int RowNo, int CellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream Fis = new FileInputStream(ContantUtility.excelFilePath);
	    Workbook wb = WorkbookFactory.create(Fis);
	    Sheet sh = wb.getSheet(SheetName);
	    Row r = sh.getRow(RowNo);
	    Cell c = r.getCell(CellNo);
	    return c.getStringCellValue();
	}
	
	public void excelWrite(String SheetName1, int RowNo, int CellNo, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream Fis=new FileInputStream(ContantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(Fis);
		Sheet sh = wb.createSheet(SheetName1);
		Row r = sh.createRow(RowNo);
		Cell c = r.createCell(CellNo);
		c.setCellValue(value);
		FileOutputStream Fio=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(Fio);
		wb.close();
	}
/**
 * This method will load the data from excel sheet to data provider
 * @param Sheetname
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public Object[][] dataProvider1(String Sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(ContantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int LastRow = sh.getLastRowNum();
		 int LostCell = sh.getRow(0).getLastCellNum();
		Object[][] data=new Object[LastRow][LostCell];
		for(int i=0;i<LastRow;i++)
		{
			for(int j=0;j<LostCell;j++)
			{
			data[i][j]=	sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
			
	}
	
   }
