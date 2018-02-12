package com.Testcases;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.PageFactory.appeleOne;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class comAppIn2TCs extends driverStart{
	
	comAppIn2Page objsearch;
	//Creating ExtentReport and ExtentTest  reference values
		ExtentReports report;
		ExtentTest logger;
	
	@Test(priority = 2)
	public void appeleOneCsv() throws Exception
	{
		report = new ExtentReports("./Reports/appeleOneReport.html");
		logger = report.startTest("appeleOneCsv");
		logger.log(LogStatus.INFO, "appeleOnePage test case started");
		
		objsearch = new appeleOne(driver);
		objsearch.search();
		objsearch.eccn();		
		
	//  load excel file
		File filepath = new File("C:\\Selenium\\Eclipse_WebDriver\\Data-appeleOne.xls");
		
		FileInputStream fs = new FileInputStream(filepath);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		
		int rowcount = sheet.getLastRowNum()- sheet.getFirstRowNum();
		
		System.out.println("Row count is : " + rowcount);
		
		for(int i=1;i<rowcount;i++)
		{
			HSSFRow row = sheet.getRow(i);
			String eccnVal = row.getCell(0).getStringCellValue();

			objsearch.appeleOne(eccnVal);
			
			String assertVal = objsearch.result();
			
			System.out.println(assertVal);
			
			SoftAssert assertappeleOne = new SoftAssert();
			assertappeleOne.assertEquals(assertVal, "   1 ", "Data does not exists");
			
					
			//Pass the test in report
			logger.log(LogStatus.PASS,"Test verified Pass in appeleSe screen");
			
			//End the test
			report.endTest(logger);
					
			//Flush the data to report
			report.flush();
		}
		
		
		
    }

	
}
	
	
