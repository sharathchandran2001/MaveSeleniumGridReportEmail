package com.Testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

//import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import jxl.read.biff.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class driverStart {

	public WebDriver driver;
	public String URL, Node;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;

	@Parameters("browser")
	@BeforeTest
	public void launchbrowser(String browser) throws MalformedURLException {
		
			
		String URL = "http:// your application url/";

		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on FireFox");
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			String Node = "http://10.3.80.53:5566/wd/hub";   // to point to node - create session
			
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("FF url"+URL);
			driver.navigate().to(URL);
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(" Executing on CHROME");
			
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			String Node = "http://10.3.80.53:5566/wd/hub"; 
						
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println(URL);	
			driver.navigate().to(URL);
			driver.manage().window().maximize();
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("chrome.switches","--disable-extensions");
			System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
			driver = new ChromeDriver();*/
        } else if (browser.equalsIgnoreCase("internet explorer")) {
			System.out.println(" Executing on IE");
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setBrowserName("internet explorer");
			String Node = "http://10.3.80.53:5566/wd/hub";
			
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to(URL);
			driver.manage().window().maximize();
			cap.setCapability("nativeEvents",false);
			
		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}

	@Test(priority = 1)	
	public void eldtLogin() {

		driver.findElement(By.id("ID1")).sendKeys("userID");
		driver.findElement(By.id("PWD1")).sendKeys("pwd");
		driver.findElement(By.name("Login.Submit")).click();
		
	 try
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}catch(NoAlertPresentException e)
		{
		}
		
		String result = driver.findElement(By.xpath("html/body/table[2]/tbody/tr[1]/td/b")).getText();
		
		System.out.println(" The Result is " + result);
		if (result.equals("APP HOME Page")) {
			System.out.println(" Login test - The Result is Pass");
		} else {
			System.out.println("  Login test - The Result is Fail");
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
