package Fly.Neon_DX.Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelHelper{
	
	HSSFWorkbook workbook;
	HSSFRow Row;
	HSSFCell cell;
	HSSFSheet sheet;

	public void readfile() throws Exception{
	File file= new File("C:\\Users\\abhir\\Desktop\\Book1.xls");
	FileInputStream fis= new FileInputStream(file);
		
	workbook= new HSSFWorkbook(fis);
	sheet=workbook.getSheetAt(0);
	 int countrows=sheet.getLastRowNum()-sheet.getFirstRowNum();
	 System.out.println(countrows);
	 //HSSFRow row=sheet.createRow(0);
//	 HSSFRow newrow=sheet.createRow(countrows+1);
//	 System.out.println(newrow.getLastCellNum());
//	 if(newrow.getLastCellNum()==-1) {
//		 HSSFCell cell=newrow.createCell(3); 
//		// HSSFCell cell1=newrow.createCell(0); 
//	 }
	 
	
		/*
		 * for (int i=0;i<newrow.getLastCellNum();i++) { HSSFCell
		 * cell=newrow.createCell(i); cell.setCellValue("hello excel"); }
		 */
	 ArrayList<String> ar = new ArrayList<String>();
	 ar.add("4");
	 ar.add("5");
	 ar.add("6");
	 
	 
	 int colll = 0;
	 int rowww = 0;
	 HSSFCell cell;
	 HSSFRow newrow;
	 for(int i =0;i<ar.size();i++)
	 {
		 colll =0;
		 cell = sheet.getRow(i).getCell(colll);
		 colll++;
		 if(cell!=null)
		 {
			cell = sheet.getRow(i).createCell(colll);
			cell.setCellValue(ar.get(i));
		 }
//		 newrow = sheet.createRow(i);
//		 cell = sheet.getRow(i).createCell(colll);
//		 cell.setCellValue(ar.get(i));
	 }

	 fis.close();
	 
	 FileOutputStream outputStream = new FileOutputStream("C:\\Users\\abhir\\Desktop\\Book1.xls");
	 workbook.write(outputStream);
	 
	}
	
	public static void main(String[] args) throws Exception {
		ExcelHelper eh=new ExcelHelper();
		eh.readfile();
	}
	
}
