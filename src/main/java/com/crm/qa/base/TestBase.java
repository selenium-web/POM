package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



//import com.crm.qa.util.WebEventListener;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;  // import org.openqa.selenium.WebDriver;
	public static Properties prop;   // import java.util.Properties;
	public  static EventFiringWebDriver e_driver; // import org.openqa.selenium.support.events.EventFiringWebDriver;
	public static WebEventListener eventListener;
	
	static Logger log = Logger.getLogger(TestBase.class);
	
	// FileInputStream  > import java.io.FileInputStream;
	// FileNotFoundException > import java.io.FileNotFoundException;
	// IOException > import java.io.IOException;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		try 
//		{
//		prop=new Properties();
//		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\crm\\qa\\config\\config.properties");
//		prop.load(file);
//		}
//		catch(FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
		
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			log.info("****************************** Starting test cases execution  *****************************************");
			System.setProperty("webdriver.chrome.driver", "D:/Softwares/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\chromedriver.exe");	
			driver = new FirefoxDriver(); 
	}
		
//		String browserName = prop.getProperty("browser");
//		if(browserName.equals("chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver.exe");
//			driver = new ChromeDriver();
//		}
//		else {
//			System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
//		driver = new FirefoxDriver(); 
//		}
		
		e_driver = new EventFiringWebDriver(driver);
//		 Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
	//	driver.get("https://www.freecrm.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	//	driver.manage().timeouts().pageLoadTimeout(19, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(19, TimeUnit.SECONDS);
		
	//	driver.get(prop.getProperty("url"));
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
	}
	
	
	

}
