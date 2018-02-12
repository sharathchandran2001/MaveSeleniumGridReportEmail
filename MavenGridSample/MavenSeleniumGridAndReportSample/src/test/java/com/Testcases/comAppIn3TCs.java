package com.Testcases;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.PageFactory.comAppIn3Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class comAppIn3TCs extends driverStart {
	
	comAppIn3Page crossobj;
	
	//Creating ExtentReport and ExtentTest  reference values
	ExtentReports report;
	ExtentTest logger;
	
	@Test(priority = 2)
	public void referenceSearch() throws Exception
	{
		
		report = new ExtentReports("./Reports/appCrossReferenceReport.html");
		logger = report.startTest("appCrossReferencePage");
		logger.log(LogStatus.INFO, "appCrossReference test case started");
		
		crossobj = new comAppIn3Page(driver);
		crossobj.srchCrossRef();
				
		Boolean actual = true;
		Boolean dis = crossobj.refDisplay();
		
		Assert.assertEquals(dis, actual);
		//Pass the test in report
		logger.log(LogStatus.PASS, "Test verified Pass in referenceSearch screen");
		
		//End the test
		report.endTest(logger);
					
		//Flush the data to report
		report.flush();
		
		
	}

}
