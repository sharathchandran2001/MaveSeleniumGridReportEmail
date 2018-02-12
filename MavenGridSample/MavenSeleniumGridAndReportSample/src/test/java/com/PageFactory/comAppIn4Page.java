package com.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class comAppIn4Page {
	
	WebDriver driver;
	
	@FindBy(xpath=".//*[@id='_navbar']/a[3]")
	WebElement appLiCodematrix;
	
	@FindBy(xpath=".//*[@id='editMenu']/a[1]")
	WebElement viewappLiCodematrix;
	
	@FindBy(xpath=".//*[@id='srchappCodeECVal']")
	WebElement appCodeEC;
	
	@FindBy(xpath="html/body/form/div[7]/table[1]/tbody/tr[5]/td[2]/input")
	WebElement search;
	
	public comAppIn4Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void appLiCodeense()
	{
		appLiCodematrix.click();
	}
	
	public void viewTse()
	{
		viewappLiCodematrix.click();
	}
	
	public void search()
	{
		search.click();
	}
	
	public void appCodeECCode(String appCodeECVal)
	{
		appCodeEC.sendKeys(appCodeECVal);
	}
}
