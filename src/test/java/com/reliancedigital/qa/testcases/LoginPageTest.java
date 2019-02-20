package com.reliancedigital.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.reliancedidital.qa.pages.HomePage;
import com.reliancedidital.qa.pages.LoginPage;
import com.reliancedigital.qa.util.DataDrivenTesting;

public class LoginPageTest extends TestBase


{
	LoginPage loginPage; 
	HomePage homePage; 
	
	public LoginPageTest() throws Exception
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		 loginPage = new LoginPage();
	}
	
	/*@Test(priority = 1)
	public void loginPageTitle()
	{
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Online Electronic Shopping Store in India - Reliance Digital");
	}
	
	@Test(priority = 2)
	public void relianceDigitalImageTest()
	{
		boolean flag=loginPage.validateCompanyLogo();
		Assert.assertTrue(flag);
	}*/
	
	@Test(dataProvider = "Authentication", priority = 3)
	public void loginTest(String sUername, String sPassword ) throws Exception
	
	{
		//homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.login(sUername, sPassword);
		
	}
	
	@DataProvider(name="Authentication")
	public Object[][] credential() throws Exception
	{
		 DataDrivenTesting drive = new DataDrivenTesting(prop.getProperty("excelpath"));
		 return drive.getCellData(prop.getProperty("Configsheetno"));
		
		
	}
	
	
	@AfterMethod
	
	public void tearDown()
	{
		//driver.quit();
	}
	
	

}
