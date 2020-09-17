package com.actitime.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This is a generic class for data driven testing
 * @author user
 *
 */
public class FileLib {
	/**
	 * Reading data from property file.
	 * @param key
	 * @return value
	 * @throws IOException
	 */
public String getPropertyValue(String key) throws IOException {
	FileInputStream file = new FileInputStream("./src/test/resources/data/commondata.property");
	Properties p = new Properties();
	p.load(file);
	String value = p.getProperty(key);
	return value;
}
/**
 * Read data from excel
 * @param sheetname
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 * @throws InvalidFormatException 
 */
public String getExcelValue(String sheetname,int row, int cell) throws EncryptedDocumentException, IOException, InvalidFormatException {
	FileInputStream file = new FileInputStream("./src/test/resources/data/TestScript.xlsx");
	Workbook wb = WorkbookFactory.create(file);
	String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	return value;
}
/**
 * Write data in excel
 * @param sheetname
 * @param row
 * @param cell
 * @param value
 * @throws EncryptedDocumentException
 * @throws IOException
 * @throws InvalidFormatException 
 */
public void setExcelValue(String sheetname,int row, int cell, String value) throws EncryptedDocumentException, IOException, InvalidFormatException {
	FileInputStream file = new FileInputStream("./src/test/resources/data/TestScript.xlsx");
	Workbook wb = WorkbookFactory.create(file);
	wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(value);
	FileOutputStream fileout = new FileOutputStream("./data/TestScript.xlsx");
	wb.write(fileout);
	wb.close();
}
}

