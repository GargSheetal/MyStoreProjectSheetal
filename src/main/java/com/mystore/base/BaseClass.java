package com.mystore.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL = readconfig.getApplicationUrl(); 
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	
	// public static WebDriver driver;
	
	// Declare ThreadLocal driver for parallel testing
	// replace driver with getDriver() as getDriver() is getting the driver object
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver()
	{
		// Get driver from threadlocalmap
		return driver.get();
	}
	
	@BeforeSuite(groups = {"sanity", "smoke", "regression"})
	public void beforeSuite()
	{
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) 
	{
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			//Set browser to ThreadLocal
			driver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}
		else if(browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			//driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();
			driver.set(new EdgeDriver());
		}
		
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		getDriver().get(baseURL);
	}
	
	@Parameters("browser")
	@BeforeMethod(groups = {"sanity", "smoke", "regression"})
	public void launchApp(String browser)
	{
		setup(browser);
	}
	
	@AfterMethod(groups = {"sanity", "smoke", "regression"})
	public void tearDown()
	{
		getDriver().quit();
	}
		
	public static void WaitforElement(WebElement element, long timeOutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static String captureScreenshot(WebDriver driver, String testname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)getDriver();
		String datename = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss.SSSS").format(new Date());
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + testname + datename + ".png");
		
		try {
			FileUtils.copyFile(source, target);
		} catch (Exception e) {
			e.getMessage();
		}
		
		String imgPath = System.getProperty("user.dir") + "/Screenshots/" + testname + datename + ".png";
		System.out.println("Screenshot Taken");
		
		return imgPath;
		
	}
	
	

}
