package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// page Fctory / Object Reposatory / page objects 
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@href='https://ui.freecrm.com/')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//font[@color='#0e3655'][contains(.,'crm')]")
	WebElement crmLogo;
	
	// initialise the page objects / page factory
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return crmLogo.isDisplayed();
		}

	public HomePage login(String un, String pass)
	{
		driver.get("https://ui.freecrm.com/");
		email.sendKeys(un);
		password.sendKeys(pass);
		loginBtn.click();
		
		return new HomePage();
	}
}
