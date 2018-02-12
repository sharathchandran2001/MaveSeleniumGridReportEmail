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
import java.util.List;
import java.util.NoSuchElementException;


import org.testng.annotations.Test;


public class comAppIn2Page{
	
	WebDriver driver;
	
	@FindBy(linkText="Define/Search")
	//@CacheLookup
	WebElement search;
	
    @FindBy(linkText="AppCode")
    //@CacheLookup
    WebElement AppCode;
    
    @FindBy(id="srchAppCodeVal")
    WebElement appeleOne;
    
    @FindBy(name="appeleOne")
    WebElement searchclick;
    
   // @FindBy(xpath="html/body/form/h4")
   // WebElement result;
    
    @FindBy(xpath=".//*[@id='div2']/table/tbody/tr[2]/td[1]")
    WebElement result;
    
    
public comAppIn2Page(WebDriver driver)
{
	this.driver = driver;
	
	PageFactory.initElements(driver, this);
}

public void search()
{
	search.click();
}

public void AppCode()
{
	AppCode.click();
}

public void AppCodeVal(String AppCodeVal)
{
	appeleOne.sendKeys(AppCodeVal);
}

public void searchclick()
{
	searchclick.click();
}

public String result()
{
	try
	{
		if(result.isDisplayed())
		{
			return result.getText();
		
		//return result.isDisplayed();
		}

	}catch(NoSuchElementException e)
	{
		System.out.println("Data is not displayed");
		
	}
	return "mismatch  FROM  result ";
	
}

public void appeleOne(String AppCodeVal)
{
	this.AppCodeVal(AppCodeVal);
	this.searchclick();
}
}
	
