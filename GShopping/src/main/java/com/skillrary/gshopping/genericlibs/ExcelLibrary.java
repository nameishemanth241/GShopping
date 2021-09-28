package com.skillrary.gshopping.genericlibs;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	public static String getData(String sheetName, int row, int cell) {
		try {
			FileInputStream fin = new FileInputStream(IAutoConstants.XL_PATH);
			Workbook workbook = WorkbookFactory.create(fin);
			return workbook.getSheet(sheetName).getRow(row).getCell(cell).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
