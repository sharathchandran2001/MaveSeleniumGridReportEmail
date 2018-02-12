package com.Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PageFactory.comAppInPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class comAppInTCs extends driverStart
{
	
	//WebDriver driver;
	comAppInPage objAppinq;
	SoftAssert assertordinq = new SoftAssert();
	//Creating ExtentReport and ExtentTest  reference values
			ExtentReports report;
			ExtentTest logger;

	@Test(priority = 2)
	public void csvFile() throws Exception
	{
		
		report = new ExtentReports("./Reports/AppOIReport.html");
		logger = report.startTest("csvFile");
		logger.log(LogStatus.INFO, "AppOIPage test case started");
		
		objAppinq = new comAppInPage(driver);
		objAppinq.ordinqclick();
		
		System.out.println("Started App In Test Case");
		
	//  load excel file 
			File filepath = new File("C:\\Selenium\\Eclipse_WebDriver\\Data1.xls");
			
			FileInputStream fs = new FileInputStream(filepath);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			
			int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			int colcount = sheet.getRow(0).getLastCellNum();
			int j =0 ;
			
			System.out.println("Number of rows" + rowcount);
			System.out.println("Number of columns" +colcount);
	    
			for(int i=1;i<rowcount;i++)
			{
				HSSFRow row = sheet.getRow(i);
				//for(int j=0;j<colcount;j++)
				//{
					//HSSFCell cell = row.getCell(j);
					String exporterVal = row.getCell(j).getStringCellValue();
					String shipFromVal = row.getCell(j+1).getStringCellValue();
					String consigneeVal = row.getCell(j+2).getStringCellValue();
					String AppCodeVal = row.getCell(j+3).getStringCellValue();
					
					System.out.println("Values are " + exporterVal + " " + shipFromVal + " " + consigneeVal +" " + AppCodeVal);
				//}
				
				objAppinq.comAppIn(exporterVal,shipFromVal,consigneeVal,AppCodeVal);
				
			/*	String AppCodecodeVal = objAppinq.AppCodecode();
				System.out.println("Result:");
				System.out.println("AppCode Code is - " + AppCodecodeVal);
				
				
				String subAppCodecodeVal = objAppinq.subAppCodecode();
				System.out.println("SUB AppCode Code is - " + subAppCodecodeVal);
				
				String decisionVal = objAppinq.decision();
				System.out.println("DECISION is - " + decisionVal);*/
				
				String assertVal = objAppinq.decision();
				//String assertexp = "NLR";
				System.out.println(assertVal);
				//assertordinq.assertEquals(assertVal, assertexp, "Data does not exists");
				assertordinq.assertNotNull(assertVal, "Data does not exists");
				//assertordinq.assertAll();
				//assertordinq.assertTrue(assertVal, "Data does not exists");
				
				//Pass the test in report
				logger.log(LogStatus.PASS,"Test verified Pass in AppOI screen");
				
				//End the test
				report.endTest(logger);
						
				//Flush the data to report
				report.flush();
				
			}	
	        
		}
	
	 
	}