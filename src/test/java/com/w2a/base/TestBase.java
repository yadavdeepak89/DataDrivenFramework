package com.w2a.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;

public class TestBase {
	
	/*Webderiver
	 * Properties file
	 * Logs, Extent Report,Excel, Mails,DB
	*/
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	
@BeforeSuite
	public void setup() throws IOException
	{
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
	config.load(fis);
	
	fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
	OR.load(fis);
	//Now will call the value from all properties file.
	if(config.getProperty("browser").equals("chrome")){
		
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver=new ChromeDriver();
	
	}else if(config.getProperty("browser").equals("Firefox")){
		driver=new FirefoxDriver();
	}else if(config.getProperty("browser").equals("IE")){
		System.setProperty("webdriver.IE.driver", "E:\\");
	}
	
	driver.get(config.getProperty("testsiteurl"));
	//driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("wait")),TimeUnit.SECONDS);
	wait=new WebDriverWait(driver,5);
	}

public boolean isElementDisplayed(By Fname){
	try{
		
		driver.findElement(Fname);	
		return true;
	}
	catch(Exception ex){
		return false;
	}
	
}
	
	@AfterSuite
	public void tearDown(){
		if(driver!=null){
		
		driver.quit();
		}
	}
}
