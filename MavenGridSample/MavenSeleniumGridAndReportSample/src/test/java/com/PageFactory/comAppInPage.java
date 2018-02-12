package com.PageFactory;

import static org.testng.AssertJUnit.assertEquals;
import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


import org.testng.annotations.Test;

//import au.com.bytecode.opencsv.CSVReader;

public class comAppInPage {
	
	WebDriver driver;
		
	@FindBy(linkText="Export Order Inquiry")
	@CacheLookup
	WebElement orderInquiry;
	
	@FindBy(xpath="html/body/form/div[7]/table/tbody/tr[1]/td[2]/select")
	// @CacheLookup - do not use CacheLookup for Dropdown - might fail. 
	WebElement exporter;
	
	@FindBy(xpath="html/body/form/div[7]/table/tbody/tr[2]/td[2]/select")
	WebElement ship;
	
	@FindBy(xpath="html/body/form/div[7]/table/tbody/tr[3]/td[2]/select")
	WebElement consignee;
	
	@FindBy(id="srchEccnCodeVal")
	WebElement eccn;
	
	@FindBy(name="GetOrderResults")
	WebElement search;
	
	@FindBy(xpath="html/body/form/div[8]/table/tbody/tr[2]/td[5]")
	WebElement eccncode;
	
	@FindBy(xpath="html/body/form/div[8]/table/tbody/tr[2]/td[6]")
	WebElement subeccn;
	
	@FindBy(xpath="html/body/form/div[8]/table/tbody/tr[2]/td[8]")
	WebElement decision;
	
	//@FindBy(xpath="html/body/form/table[2]/tbody/tr/td/a[1]")
	//WebElement decision;
	
	public comAppInPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
	
	public void ordinqclick()
	{
		orderInquiry.click();
	}
	
	public void setexporter(String exporterVal)
	{
		Select exp = new Select(exporter);
		exp.selectByVisibleText(exporterVal);
	}
		
	
	public void setship(String shipFromVal)
	{
		Select shp = new Select(ship);
		shp.selectByVisibleText(shipFromVal);
	}
	
	public void setconsignee(String consigneeVal)
	{
		Select cons = new Select(consignee);
		cons.selectByVisibleText(consigneeVal);
	}
	
	public void seteccn(String eccnVal)
	{
		eccn.clear();
		eccn.sendKeys(eccnVal);
	}
		
	public void searchclick()
	{
		search.click();
	}
	
	public String eccncode()
	{
		return eccncode.getText();
		 
	}
	
	public String subeccncode()
	{
		return subeccn.getText();
	}
	
	public String decision()
	{
		return decision.getText();
		
		/*if(decision)
			return true;
		else
			return false;*/
		
		/*try
		{
			if(decision.equals("   NLR   "))
				return true;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Data is not displayed");
		}	
		return false;*/
		
	}
		
	
	public void comAppIn(String exporterVal,String shipFromVal,String consigneeVal,String eccnVal)
	{
        this.setexporter(exporterVal);
        this.setship(shipFromVal);
        this.setconsignee(consigneeVal);
        this.seteccn(eccnVal);
        this.searchclick();
     }

	
}
	
	
