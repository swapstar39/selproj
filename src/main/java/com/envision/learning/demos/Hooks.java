package com.envision.learning.demos;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
	

	public class Hooks {
		
		static WebDriver driver;
		 static String URL="https://demoqa.com";
		 
		 
		
		@BeforeMethod
			public void launchBrowser() throws InterruptedException {
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\sppat\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sppat\\eclipse-workspace\\SeleniumBatch3rdOctoberr\\binaries\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
			//Thread.sleep(2000);
			//driver.get(URL);
			//driver.navigate().to(URL);

		}
		
		@AfterMethod
		public void closeBrowser() {
			//driver.close(); //close the current browser
			driver.quit(); //close all the browser
			
		}
		
		public void waitUntilVisible(WebElement element,int seconds) {
			WebDriverWait wait=new WebDriverWait(driver,seconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	
}
