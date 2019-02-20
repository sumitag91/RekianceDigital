package com.reliancedigital.qa.util;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTesting
{
	
	public XSSFSheet sheet;
	public XSSFWorkbook book;
	public XSSFCell cell;
	public XSSFRow row;


	
	public  DataDrivenTesting(String path) throws Exception
	
	{
		File src = new File(path);
		FileInputStream f = new FileInputStream(src);
		book = new XSSFWorkbook(f); 
	
	}
	
	
	public Object[][] getCellData(String SheetNumber)
	{
		
		 int SheetNo = Integer.parseInt(SheetNumber);
		 sheet = book.getSheetAt(SheetNo);
		 int lastrownum = sheet.getLastRowNum();
		 int lastcell=sheet.getRow(0).getLastCellNum();
		 //cell.setCellType ( Cell.CELL_TYPE_STRING ) ;
		 System.out.println("Column Count"+"  "+  lastcell);
		 System.out.println("Row Count"+ "   "+  lastrownum);
		 Object[][] CellData= new Object[lastrownum][lastcell];
		 
		for (int i=0; i<lastrownum; i++ )
			//
		{
			for(int j=0; j<lastcell;j++)
				//lastcell
			{
				CellData[i][j] = sheet.getRow(i+1 ).getCell(j).toString();
			    System.out.println(CellData[i][j]);
			
			}
		}
		
		
		return CellData;
	}

}
