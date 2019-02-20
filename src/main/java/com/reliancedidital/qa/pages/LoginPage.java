package com.reliancedidital.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	public LoginPage() throws Exception 
	
	{
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//a[@href='/signin']")
	WebElement signIn;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='blk__lg__12 text__center blk__sm__12 blk__xs__12']/button")
	WebElement submit;
	
	@FindBy(xpath="//a[@href='#registration']")
	WebElement registration;
	
	@FindBy(xpath="//img[@class='pull-left header-logo']")
	WebElement logo;
	
	//Intialization the age Objectt
	
	
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean validateCompanyLogo()
	{
		return logo.isDisplayed();
	}
	
	public HomePage login(String un, String pass) throws Exception{
		signIn.click();
		username.sendKeys(un);
		password.sendKeys(pass);
		Thread.sleep(2000);
		submit.click();
		
		return new HomePage();
	}
	
	
	

}
