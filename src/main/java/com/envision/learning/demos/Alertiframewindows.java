
package com.envision.learning.demos;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alertiframewindows extends Hooks {
	@Test
	public void verifyCheckboxSelected() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		WebElement chbox = driver.findElement(By.xpath("//span[text()='Home']"));
		chbox.click();
		// WebElement textEle=driver.findElement(By.xpath("//span[@class='text-success'
		// and contains(text(),'desktop')]"));
		// Assert.assertTrue(textEle.isDisplayed());

		WebElement chkboxEle = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[1]/svg"));
		String attrClass = chkboxEle.getAttribute("class");
		System.out.println(attrClass);
		Thread.sleep(5000);
		Assert.assertTrue(attrClass.contains("icon-check"));
	}

	@Test
	public void alert() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL + "/alerts");
		WebElement ele = driver.findElement(By.xpath("//button[@id='alertButton']"));
		// Alert alert=new Alert(ele);
		ele.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);

		WebElement ele1 = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
		ele1.click();
		Thread.sleep(6000);
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		Thread.sleep(3000);

		WebElement ele2 = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		ele2.click();
		Thread.sleep(3000);
		Alert alert2 = driver.switchTo().alert();
		// alert2.accept();
		alert2.dismiss();
		Thread.sleep(3000);

		WebElement ele3 = driver.findElement(By.xpath("//button[@id='promtButton']"));
		ele3.click();
		Thread.sleep(3000);
		Alert alert3 = driver.switchTo().alert();
		alert.sendKeys("Swapstar");
		alert3.accept();
		// alert3.dismiss();
		Thread.sleep(3000);

	}

	@Test

	public void windowtab() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL + "/browser-windows");
		WebElement ele = driver.findElement(By.xpath("//button[@id='tabButton']"));
		// Alert alert=new Alert(ele);
		ele.click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();// gives random order
		List<String> windowList = new ArrayList<String>(windows);// preserve an order
		driver.switchTo().window(windowList.get(windowList.size() - 1));
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);

	}

	@Test

	public void newwindow() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL + "/browser-windows");
		driver.findElement(By.xpath("//button[@id='windowButton']")).click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();// gives random order
		List<String> windowList = new ArrayList<String>(windows);// preserve an order
		driver.switchTo().window(windowList.get(windowList.size() - 1));
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);

	}

	@Test

	public void newwindowmessage() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL + "/browser-windows");
		driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();// gives random order
		List<String> windowList = new ArrayList<String>(windows);// preserve an order
		driver.switchTo().window(windowList.get(windowList.size() - 1));
		Thread.sleep(3000);
		// System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
	}

	@Test
	public void verifyOpenTabFunctionality() throws Exception {
		driver.get(URL + "/browser-windows");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('about:blank','_blank');");
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();// gives random order
		List<String> windowList = new ArrayList<String>(windows);// preserve an order
		driver.switchTo().window(windowList.get(windowList.size() - 1));
		driver.get("https://www.google.com");
		Thread.sleep(3000);
	}

	@Test
	public void verifyOpenTabFunctionality1() throws Exception {
		driver.get(URL + "/browser-windows");
		Thread.sleep(3000);
		for (int i = 0; i < 4; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.open('about:blank','_blank');");
			Thread.sleep(3000);
		}

		/*String originalHandle = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				// driver.switchTo().window(handle);
				// driver.close();
				Set<String> windows = driver.getWindowHandles();// gives random order
				List<String> windowList = new ArrayList<String>(windows);// preserve an order
				driver.switchTo().window(windowList.get(windowList.size() - 1));
				driver.close();
				Thread.sleep(1000);
			}
		}
		 driver.switchTo().window(originalHandle);
		 System.out.println(driver.getTitle());*/
		
		  for(int i=0;i<5;i++) { 
		  Set<String> windows=driver.getWindowHandles();//givesrandom order
		  List<String> windowList=new ArrayList<String>(windows);//preserve an order
		  driver.switchTo().window(windowList.get(windowList.size()-1));
		  driver.close(); Thread.sleep(1000);
		  
		  }
		 
	}

	@Test
	public void verifyOpenTabUsingRobot() throws Exception {
		driver.get(URL + "/browser-windows");
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
	}
	
	@Test
	public void scrollingInSelenium() throws Exception{
		driver.get(URL + "/automation-practice-form");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		/*
		 * js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		 * window.scrollTo(0,document.body.scrollRight)
		 * window.scrollTo(0,document.body.scrollLeft)
		 * Thread.sleep(3000);
		 * js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		 * Thread.sleep(3000);
		 */
		 
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.id("submit")));		
		Thread.sleep(3000);
	}
	
	@Test
	public void switchToFrame() throws Exception{
		driver.get(URL + "/frames");
		Thread.sleep(3000);
		driver.switchTo().frame("frame1");
		System.out.println(driver.findElement(By.tagName("h1")).getText());
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		WebElement elementLink=driver.findElement(By.xpath("//*[contains(text(),'Elements')]"));
	}
	
	@Test
	public void closeModalWindow() throws Exception{
		driver.get(URL + "/modal-dialogs");
		Thread.sleep(3000);
		driver.findElement(By.id("showSmallModal")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("closeSmallModal")).click();
		Thread.sleep(3000);
	}
	
	@Test
	public void verifyLinks() throws Exception{
		driver.get(URL + "/links");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Home")).click();
		Thread.sleep(3000);
		
	}
	
	
	
	

}
