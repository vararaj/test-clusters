package com.clusters.generic.utils;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class DataHandlers 
{
	public static String getDataFromProperties(String fileName,String key)
	{
		String data = null;
		try
		{
			File f = new File("./config-data/"+fileName+".properties");
			FileInputStream  fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			data = (String) prop.get(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	public static void storeDataToProperties(String fileName,String key,String value)
	{
		try
		{
			File f = new File("./config-data/"+fileName+".properties");
			FileInputStream  fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			prop.setProperty(key, value);
			FileOutputStream fos = new FileOutputStream(f);
			prop.store(fos,"Added DOB");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static String getDataFromExcel(String fileName,String sheetName,int rowID,int cellID)
	{
		String data = null;
		try
		{
			File f = new File("./test-data/"+fileName+".xlsx");
			FileInputStream  fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowID);
			Cell c = r.getCell(cellID);
			data = c.toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	public static void storeDataToExcel(String fileName,String sheetName,int rowID,int cellID,String data)
	{
		try
		{
			File f = new File("./test-data/"+fileName+".xlsx");
			FileInputStream  fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowID);
			Cell c = r.getCell(cellID);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
