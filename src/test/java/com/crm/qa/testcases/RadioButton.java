package com.crm.qa.testcases;

import org.testng.annotations.Test;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioButton {
	
WebDriver driver;
Logger log = Logger.getLogger(RadioButton.class);
//@
	
	@Test(enabled=true)
	public void handleRadioButton() throws InterruptedException
	{
		log.info("****************************** Starting test cases execution  *****************************************");

		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		log.info("launching chrome broswer");
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
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
	
	@Test(enabled=true)
	public void handleCheckbox() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("sing")).click();
	
	}
@Test(enabled=false)
public void SugarLogin() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://192.168.97.191/swiftqa1/index.php#Accounts/create");
	driver.manage().window().maximize();
	Thread.sleep(19878);
	driver.findElement(By.id("username")).sendKeys("admin");;
	driver.findElement(By.name("password")).sendKeys("Password123");;
	driver.findElement(By.name("login_button")).click();
Thread.sleep(39878);
//
driver.findElement(By.id("s2id_autogen7"));
//	driver.findElement(By.xpath("//div[contains(@id,'select2-drop-mask']")).sendKeys("testing");;

}
}
