package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	
	ContactsPage contactsPage;
	LoginPage loginPage;
	HomePage homePage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.clickOnContactsLink();
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
//	@Test(priority=1)
//	public void checkCheckbox()
//	{
//		contactsPage.checkTheCheckbox();
//	}
//	
//	@Test(priority=2)
//	public void clickOnNewContact()
//	{
//		contactsPage.clickOnNewContact();
//	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void createNewContact(String firstname, String lastname, String middlename)
	{
	contactsPage.clickOnNewContact();
	contactsPage.createNewContact(firstname, lastname, middlename);
	}
	
//	@Test
//	public void verifyContactPageLabel()
//	{
//		boolean b =contactsPage.verifyContactPageTitle();
//		Assert.assertTrue(b, "contact page title not matched");
//	}
	
	
//	@Test
//	public void clickOnShowButton()
//	{
//		contactsPage.clickOnShowFilterButton();
//	}
	
	@AfterMethod
	public void tearDown()
	{
	 	driver.quit();
	}
	

}
