package com.project.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Data {

	public String read() throws IOException{
		File source=new File(System.getProperty("user.dir")+"//Excel//Info.xlsx");	 
		FileInputStream input=new FileInputStream(source);	                              
		XSSFWorkbook workbook=new XSSFWorkbook(input);                                 
	    XSSFSheet sheet= workbook.getSheetAt(0);
	    String url=sheet.getRow(0).getCell(1).getStringCellValue();
		return url;	
	}
	public void write(String[]month,String[]amount) throws IOException {
		
	File source=new File(System.getProperty("user.dir")+"//Excel//Info.xlsx");	 
	FileInputStream input=new FileInputStream(source);	                              
	XSSFWorkbook workbook=new XSSFWorkbook(input);                                 
    XSSFSheet sheet= workbook.getSheetAt(1);
      Row row = sheet.createRow(1);
	    row.createCell(0).setCellValue(month[0]);
	    row.createCell(1).setCellValue(amount[2]);
	    row.createCell(2).setCellValue(amount[3]);
     FileOutputStream fos = new FileOutputStream(source);
	 workbook.write(fos);
	 fos.close();
}
	
}