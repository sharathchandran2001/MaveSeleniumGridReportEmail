package com.Testcases;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.PageFactory.comAppIn5Page;

public class comAppIn5TCs extends driverStart{
	
	comAppIn5Page objsearch;
	
	@Test(priority = 2)
	public void AppVendMappingXLS() throws Exception   // searchEccnCsv
	{
		System.out.println("Started executing AppVend Mapping entry");
		
		objsearch = new comAppIn5Page(driver);
		Thread.sleep(3000);
		objsearch.XrefMenu();
		Thread.sleep(2000);
		objsearch.AppVendMappingMenu();	
		Thread.sleep(2000);
		objsearch.AddNewAppVendMapping(); 
		
	//  load excel file
		File filepath = new File("C:\\Selenium\\Eclipse_WebDriver\\Data-AppVendMapping.xls");
		
		FileInputStream fs = new FileInputStream(filepath);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		
		int rowcount = sheet.getLastRowNum()- sheet.getFirstRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		int j=0;
		
		System.out.println("Row count is : " + rowcount);
		System.out.println("Column count is : " + colcount);
		
		for(int i = 1;i <= rowcount;i++)
		{
			HSSFRow row = sheet.getRow(i);
			String newHostAppVendCodeVal = row.getCell(j).getStringCellValue();
			String newGpdAppVendCodeVal = row.getCell(j+1).getStringCellValue();
			String newSeAppVendCodeVal = row.getCell(j+2).getStringCellValue();
			String newGcidAppVendCodeVal = row.getCell(j+3).getStringCellValue();
				
			System.out.println("newHostAppVendCode , newGpdAppVendCode , newSeAppVendCode , newGcidAppVendCode Value are : " + newHostAppVendCodeVal + newGpdAppVendCodeVal + newSeAppVendCodeVal + newGcidAppVendCodeVal);
			objsearch.childHandle();
			objsearch.AppVendMapping(newHostAppVendCodeVal,newGpdAppVendCodeVal,newSeAppVendCodeVal,newGcidAppVendCodeVal);
			
		}
		
		objsearch.parentHandle();
		
		
    }

	
}
	
	
