package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {
	
	public WebDriver driver;
	
	//thread local is used in order to parallel execution in feature files 
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	//driver initialization 
	
	public WebDriver intit_driver(String browser) {
		
		System.out.println("The browser value is " + browser);
		
		if(browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
			
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
			
		}else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());
			
		} else {
			System.out.println("Please add the correct browser.");
		}
		
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}
	
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

}
