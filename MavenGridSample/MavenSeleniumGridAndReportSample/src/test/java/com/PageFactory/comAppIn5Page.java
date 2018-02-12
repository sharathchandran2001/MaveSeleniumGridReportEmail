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
import java.util.concurrent.TimeUnit;


import org.testng.annotations.Test;


public class comAppIn5Page{
	
	WebDriver driver;
	String cHandle,pHandle;
	
	//@FindBy(xpath=".//*[@id='defineMenu']/a[1]")
	
	//@FindBy(linkText="Cross Reference")
	//@CacheLookup
	@FindBy(xpath=".//*[@id='_navbar']/a[4]")
	@CacheLookup
	WebElement XrefMenu;
	
    @FindBy(xpath=".//*[@id='uploadMenu']/a[3]")
    //@CacheLookup
    WebElement AppVendMappingMenu;
    
    @FindBy(xpath="html/body/form/div[9]/table/tbody/tr/td[7]/input")
    //@CacheLookup
    WebElement AddNewAppVendMapping;
    
   // @FindBy(xpath=".//*[@id='newHostAppVendCode']")
    @FindBy(id="newHostAppVendCode")
    WebElement PopUpHostAppVendCode;
    @FindBy(xpath=".//*[@id='newAppGDAppVendCode']")
    WebElement PopUpAppGDAppVendCode;
    @FindBy(xpath=".//*[@id='newSEAppVendCode']")
    WebElement PopUpSEAppVendCode;
    @FindBy(xpath=".//*[@id='newGCIDAppVendCode']")
    WebElement PopUpGCIDAppVendCode;
    
    @FindBy(xpath="html/body/form/div[2]/table[1]/tbody/tr[5]/td[2]/input[1]")
    WebElement submit;
    @FindBy(xpath="html/body/form/div[2]/table[1]/tbody/tr[5]/td[2]/input[2]")
    WebElement close;
    
public comAppIn5Page(WebDriver driver)
{
	this.driver = driver;
	
	PageFactory.initElements(driver, this);
}

public void XrefMenu()
{
	XrefMenu.click();
}

public void AppVendMappingMenu()
{
	AppVendMappingMenu.click();
}

public void AddNewAppVendMapping()
{
	AddNewAppVendMapping.click();   // to open new pop up window - where XLS data will be input. 
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  driver.switchTo().window(driver.getWindowHandle());
	
	// either please add a seperate page popup fatory for the new pop up window or use pop up as part of AppVend mapping page FActory - I have captured the xpath values 
}

public void childHandle()
{
	cHandle = driver.getWindowHandles().toArray()[1].toString();
	driver.switchTo().window(cHandle);
}

public void parentHandle()
{	
	close.click();
	pHandle = driver.getWindowHandles().toArray()[0].toString();
	driver.switchTo().window(pHandle);
}

/*public void newHostAppVendCode(String newHostAppVendCodeVal)
{
  //driver.switchTo().window(driver.getWindowHandle());
	
// driver.findElement(By.id("newHostAppVendCode")).sendKeys(newHostAppVendCodeVal);
PopUpHostAppVendCode.sendKeys(newHostAppVendCodeVal);


}*/

public void AppVendMapping(String newHostAppVendCodeVal,String newAppGDAppVendCodeVal,String newSeAppVendCodeVal,String newGcidAppVendCodeVal)   // searchEccn(String newHostAppVendCode)   
{
	PopUpHostAppVendCode.sendKeys(newHostAppVendCodeVal);
	PopUpAppGDAppVendCode.sendKeys(newAppGDAppVendCodeVal);
	PopUpSEAppVendCode.sendKeys(newSeAppVendCodeVal);
	PopUpGCIDAppVendCode.sendKeys(newGcidAppVendCodeVal);
	submit.click();
}

}
	
