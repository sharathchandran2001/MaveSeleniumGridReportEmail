package com.Testcases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

import com.PageFactory.comAppIn4Page;


public class comAppIn4TCs extends driverStart {

	comAppIn4Page appObj;
	
	@Test(priority = 2)
	public void licenseMatrix() throws Exception
	{
		appObj = new comAppIn4Page(driver);
		Thread.sleep(3000);
		appObj.appLiCodeense();
		Thread.sleep(3000);
		appObj.viewTse();
		Thread.sleep(3000);
		
		File filepath = new File("C:\\Selenium\\Eclipse_WebDriver\\Data-SearchTse.xls");
		
		FileInputStream fs = new FileInputStream(filepath);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		
		int rowcount = sheet.getLastRowNum()- sheet.getFirstRowNum();
		
		System.out.println("Row count is : " + rowcount);
		
		for(int i=1;i<rowcount;i++)
		{
			HSSFRow row = sheet.getRow(i);
			String appCodeECVal = row.getCell(0).getStringCellValue();
			System.out.println("appCodeEC Search Value is : " + appCodeECVal);
			appObj.appCodeECCode(appCodeECVal);
			appObj.search();
		}
		
		
		
    }
	
}
