package com.envision.learning.demos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchBrowserDemo2 {
	
	 WebDriver driver;
	 String URL="https://demoqa.com";
	 
	 
	
	@BeforeMethod
		public void launchBrowser() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\sppat\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sppat\\eclipse-workspace\\SeleniumBatch3rdOctober\\binaries\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		//driver.get(URL);
		//driver.navigate().to(URL);

	}
	
	@Test
	public void verifyCheckboxSelected() throws Exception {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);
		WebElement chbox=driver.findElement(By.xpath("//span[text()='Home']"));
		chbox.click();
		//WebElement textEle=driver.findElement(By.xpath("//span[@class='text-success' and contains(text(),'desktop')]"));
		//Assert.assertTrue(textEle.isDisplayed());
		
		WebElement chkboxEle=driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[1]/svg"));
		String attrClass=chkboxEle.getAttribute("class");
		System.out.println(attrClass);
		Thread.sleep(5000);
		Assert.assertTrue(attrClass.contains("icon-check"));
	}
	
	@Test
	public void verifyRadioButtonSelected() throws Exception{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL + "/radio-button");
		WebElement radbox=driver.findElement(By.xpath("//label[@for='yesRadio']"));
		radbox.click();
		//WebElement textEle=driver.findElement(By.xpath("//span[@class='text-success' and contains(text(),'desktop')]"));
		//Assert.assertTrue(textEle.isDisplayed());
		
		WebElement radboxEle=driver.findElement(By.xpath("//span[@class='text-success'  and contains(text(),'Yes')]"));
		//String attrClass=chkboxEle.getAttribute("class");
		//System.out.println(attrClass);
		Thread.sleep(5000);
		//Assert.assertTrue(attrClass.contains("icon-check"));
		Assert.assertTrue(radboxEle.isDisplayed());
}
	
	@Test
	public void performDDLTests() throws Exception{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL + "/select-menu");
		Thread.sleep(3000);
		WebElement ddl_color=driver.findElement(By.xpath("//select[@id = 'oldSelectMenu']"));
		Select ddl_col=new Select(ddl_color);
		ddl_col.selectByVisibleText("Blue");
		Thread.sleep(2000);
		ddl_col.selectByValue("red");
		Thread.sleep(2000);
		ddl_col.selectByIndex(4);
		Thread.sleep(2000);
}
	
	@Test
	public void performDDLComboboxTests() throws Exception{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL + "/select-menu");
		Thread.sleep(3000);
		WebElement ddl_option=driver.findElement(By.xpath("//div[@id='withOptGroup']"));
		ddl_option.click();
//		WebElement tbx_input=driver.findElement(By.xpath("//div[@id='withOptGroup']//input"));
//		tbx_input.clear();
//		tbx_input.sendKeys("Group 1");
//		Thread.sleep(4000);
//		tbx_input.click();
//	Thread.sleep(4000);
		Thread.sleep(2000);
		WebElement ddl_value=driver.findElement(By.xpath("//div[contains(text(),'Group 1, option 1')]"));
		ddl_value.click();
		Thread.sleep(2000);	
}
	
	@Test
	public void performDDLMultiselectTests() throws Exception{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL + "/select-menu");
		Thread.sleep(3000);
		WebElement ddl_multi=driver.findElement(By.xpath("//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div/div[1]/div[1]"));
		ddl_multi.click();
		WebElement ddl_value=driver.findElement(By.xpath("//div[@id=\"react-select-4-option-0\"]"));
	    ddl_value.click();
	    Thread.sleep(2000);
	    WebElement ddl_value1=driver.findElement(By.xpath("//div[@id=\"react-select-4-option-1\"]"));
	    ddl_value1.click();
	  
	    Thread.sleep(2000);	
}
	
	
	
	 
	
	@AfterMethod
	public void closeBrowser() {
		driver.close(); //close the current browser
		//driver.quit(); //close all the browser
		
	}

}
