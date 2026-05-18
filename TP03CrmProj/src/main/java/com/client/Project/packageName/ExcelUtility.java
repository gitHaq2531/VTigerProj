package com.client.Project.packageName;

import java.io.FileInputStream;

import java.lang.String;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public  String getDataFromExcel(String Sheetname, int rownum, int cellnum) throws Throwable {
		FileInputStream fis=new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 String data = wb.getSheet(Sheetname).getRow(rownum).getCell(cellnum).toString();
		 wb.close();
		 return data;
	}

}
