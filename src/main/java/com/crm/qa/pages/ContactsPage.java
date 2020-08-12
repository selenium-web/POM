package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black')]")
	@CacheLookup
	WebElement LabelName;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkbox;
	
	@FindBy(xpath="//button[contains(text(),'Show Filters']")
	WebElement showFilter;
	
	@FindBy(xpath="//button[@class='ui linkedin button']//parent::a[@href='/contacts/new']")
	WebElement newContactLink;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="middle_name")
	WebElement middleName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//i[@class='save icon']//parent::button[@class='ui linkedin button']")
	WebElement saveButton;


public ContactsPage()
{
	PageFactory.initElements(driver, this);
}

public boolean verifyContactPageTitle()
{
	return LabelName.isDisplayed();
}

public void checkTheCheckbox()
{
	// checkbox.isSelected();
	checkbox.click();
}

public void clickOnShowFilterButton()
{
	showFilter.click();
}

public void clickOnNewContact()
{
	// driver.findElement(By.xpath("//button[@class='ui linkedin button']//parent::a[@href='/contacts/new']")).click();
//	driver.get("https://ui.freecrm.com/contacts/new");
	 newContactLink.click();
}

public void createNewContact(String firstname, String lastname, String middlename)
{
	firstName.sendKeys(firstname);
	lastName.sendKeys(lastname);
	middleName.sendKeys(middlename);
	saveButton.click();
}


}