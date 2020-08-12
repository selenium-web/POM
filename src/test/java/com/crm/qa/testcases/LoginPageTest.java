package com.crm.qa.testcases;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;




public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
 	Logger log = Logger.getLogger(LoginPageTest.class);
	
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void DemoTest(){
	driver.navigate().to("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
	driver.manage().window().maximize();
	List<WebElement> radio = driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));
	
	for(int i=0;i<radio.size();i++)
	{
		if (radio.get(i).getAttribute("value").equalsIgnoreCase("Ruby"))
		{
			radio.get(i).click();
		}
	}
	}
	
//	@Test(priority=1)
//	public void loginPageTitleTest(){
//		log.info("****************************** Starting test cases execution  *****************************************");
//		String title = loginPage.validateLoginPageTitle();
//		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
//	}
//	
//	@Test(priority=2)
//	public void crmLogoImageTest(){
//		boolean flag = loginPage.validateCRMImage();
//		Assert.assertTrue(flag);
//	}
	
	@Test(priority=3)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
