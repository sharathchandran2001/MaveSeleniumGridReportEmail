package com.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class comAppIn6Page {
	
	WebDriver driver;
	
	@FindBy(xpath=".//*[@id='_navbar']/a[2]")
	WebElement define;
	
	@FindBy(xpath=".//*[@id='defineMenu']/a[3]")
	WebElement countryAppRu;
	
	@FindBy(xpath=".//*[@id='div2']/table/tbody/tr[2]/td[1]")
	WebElement AppRudisplay;
	
	public comAppIn6Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void define()
	{
		define.click();
	}
	
	public void countryAppRu()
	{
		countryAppRu.click();
	}
	
	public boolean display()
	{
		if(AppRudisplay.isDisplayed())
		{
			return true;
		}
		return false;
	}

	public void countryAppRuSrch()
	{
		this.define();
		this.countryAppRu();
		
	}
}
