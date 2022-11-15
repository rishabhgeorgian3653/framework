package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelData {

	 public FileInputStream fis = null;
	   public XSSFWorkbook workbook = null;
	   public XSSFSheet sheet = null;
	   public XSSFRow row = null;
	   public XSSFCell cell = null;
	   public  int rowcount = 0;
	   public  int colcount = 0;
	   
	   String xlfilepath;
	   
	   public excelData(String xlfilepath) throws IOException {
		   this.xlfilepath = xlfilepath;
		   fis = new FileInputStream(xlfilepath);
		   workbook = new XSSFWorkbook(fis);
	}
	   
	   public int getRowCount()
	   {
		   sheet = workbook.getSheetAt(0);
		   rowcount = sheet.getLastRowNum()+1;
		   return rowcount;
	   }
	   
	   public int getColumnCount()
	   {
		   sheet = workbook.getSheetAt(0);
		   row = sheet.getRow(0);
		   colcount = row.getLastCellNum();
		   return colcount;
	   }
	   
	   
	   public Object [][] getData()
	   {
		  Object Data1[][] = new Object[rowcount][colcount];
		   for(int i=0;i<rowcount;i++)
		   {
			   for(int j=0;j<colcount;j++)
			   {
				   Data1[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			   }
		   }
			   
		   
		  return Data1;
		   
	   }

	   

}
