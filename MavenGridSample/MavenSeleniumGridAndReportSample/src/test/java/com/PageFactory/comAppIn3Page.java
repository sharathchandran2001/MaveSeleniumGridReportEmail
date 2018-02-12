package com.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class comAppIn3Page {
	
	WebDriver driver;
	
	@FindBy(xpath=".//*[@id='_navbar']/a[4]")
	WebElement appRef;
	
	@FindBy(xpath=".//*[@id='uploadMenu']/a[2]")
	WebElement appCouX;
	
	@FindBy(xpath=".//*[@id='div2']/table/tbody/tr[2]/td[1]")
	WebElement display;
	
	public comAppIn3Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void appRef()
	{
		appRef.click();
	}
	
	public void appCouX()
	{
		appCouX.click();
	}

	public boolean refDisplay()
	{
		if(display.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void srchappRef()
	{
		this.appRef();
		this.appCouX();
	}
}
