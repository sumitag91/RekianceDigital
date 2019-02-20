package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.reliancedigital.qa.util.TestUtil;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws Exception 
	{
		prop=new Properties();		
		FileInputStream ip;
			ip = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\Sumit Workspace\\RelianceDigitalTest\\src\\main\\java\\com\\reliancedigital\\qa\\config\\config.properties");
		prop.load(ip);	
		
		
	}
	
	public static void initialization()
	{
		String browserName= prop.getProperty("browser");
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			driver =new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}  
}
