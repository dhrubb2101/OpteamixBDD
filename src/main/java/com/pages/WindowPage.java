package com.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPage {
	
	public static WebDriver driver;
	
	// locator

		private By openTab = By.xpath("//a[@id='opentab']");
		private By text = By.xpath("//div[@class='cont']//span[contains(text(),'info@qaclickacademy.com')]");
		
	//constructor
		
		public WindowPage(WebDriver driver) {
			WindowPage.driver = driver;
		}
		
	// 3. page actions: features(behavior) of the page the form of methods:

		public void verifyopentab() throws InterruptedException {
			Thread.sleep(3000);
			driver.findElement(openTab).click();

			// get the parent window handle

			String parentwindow = driver.getWindowHandle();
			System.out.println(parentwindow);

			// get all window handles the parent and child handle

			Set<String> windowhandles = driver.getWindowHandles();
			System.out.println(windowhandles);

			// Iterate among the windows

			Iterator<String> iterator = windowhandles.iterator();

			while (iterator.hasNext()) {

				String childwindow = iterator.next();
				if (!parentwindow.equalsIgnoreCase(childwindow)) {
					Thread.sleep(3000);
					driver.switchTo().window(childwindow);
					Thread.sleep(3000);
					String text1 = driver.findElement(text).getText();
					System.out.println(text1);
					driver.close();

				
			}
		}
}
}




