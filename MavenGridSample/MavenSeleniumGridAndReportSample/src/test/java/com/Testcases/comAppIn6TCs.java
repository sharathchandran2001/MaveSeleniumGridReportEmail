package com.Testcases;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.PageFactory.comAppIn6Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class comAppIn6TCs extends driverStart {
	
	comAppIn6Page AppRusobj;
	
	//Creating ExtentReport and ExtentTest  reference values
	ExtentReports report;
	ExtentTest logger;
	
	@Test(priority = 2)
	public void AppRusSearch() throws Exception
	{
		report = new ExtentReports("./Reports/appCouyAppRusReport.html");
		logger = report.startTest("AppRusSearch");
		logger.log(LogStatus.INFO, "appCouyAppRus test case started");
				
		AppRusobj = new comAppIn6Page(driver);
		AppRusobj.countryAppRuSrch();
		
		Boolean actual = true;
		Boolean dis = AppRusobj.display();
		
		
		/*if(dis == true)
		{
			System.out.println("Search values are displayed");
		}
		else
		{
			System.out.println("Search values does not exist");
		}*/
		
		Assert.assertEquals(dis, actual);
		//Pass the test in report
		logger.log(LogStatus.PASS,"Test verified Pass in AppRusSearch screen");
		
		//End the test
		report.endTest(logger);
				
		//Flush the data to report
		report.flush();
		
	}

}
