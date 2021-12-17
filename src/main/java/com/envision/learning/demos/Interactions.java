package com.envision.learning.demos;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Interactions extends Hooks{
	
	public void waitabit() throws Exception{
		Thread.sleep(3000);
	}
	
	
	@Test
	public void verifyDragAndDropUsingDragMethod() throws Exception{
		
			driver.get(URL + "/dragabble");
			waitabit(); 
			driver.findElement(By.xpath("//a[text()='Axis Restricted']")).click();
			waitabit();
			WebElement x=driver.findElement(By.id("restrictedX"));
		    WebElement y=driver.findElement(By.id("restrictedY"));
		
		   Actions act=new Actions(driver);
		   act.dragAndDrop(x, y).build().perform();
		   waitabit();
		   waitabit();
	}
	
	@Test
	public void verifyDragAndDropUsingClickHoldMethods() throws Exception{
		
			driver.get(URL + "/dragabble");
			waitabit(); 
			driver.findElement(By.xpath("//a[text()='Axis Restricted']")).click();
			waitabit();
			WebElement x=driver.findElement(By.id("restrictedX"));
		    WebElement y=driver.findElement(By.id("restrictedY"));
		
		   Actions act=new Actions(driver);
		   act.clickAndHold(x).moveToElement(y).release(x).build().perform();
		   waitabit();
		   waitabit(); 
		   
	}
	
	
	@Test
	public void verifyDragAndDropUsingOffsets() throws Exception{
		
			driver.get(URL + "/dragabble");
			waitabit(); 
			WebElement dragme=driver.findElement(By.xpath("//div[text()='Drag me']"));
			
			/*
			 * Point cordinates=dragme.getLocation(); int x=cordinates.getX(); iny
			 * y=cordinates.getY();
			 */
		
		   Actions act=new Actions(driver);
		   act.clickAndHold(dragme).moveByOffset(567, 27).build().perform();
		   waitabit();
		   waitabit(); 
		   
	}
	
	@Test
	public void testSliders() throws Exception {

		driver.get("https://demoqa.com/slider");

		WebElement slider = driver.findElement(By.xpath("//input[@type= 'range']"));
		Rectangle rec = slider.getRect();
		int x = rec.getX();
		int y = rec.getY();
		int height = rec.getHeight();
		int width = rec.getWidth();
		System.out.println(x + " " + y + " " + height + " " + width);
		Thread.sleep(3000);

		for (int i = 0; i < 52; i++) {
			Actions act = new Actions(driver);
			act.clickAndHold(slider);
			act.moveByOffset(i, i + 2).release().build().perform();
			String value = driver.findElement(By.xpath("//input[@id='sliderValue']"))
					.getAttribute("value");
			System.out.print(value + " ");
		}

	}
	
	@Test
	public void testingMovementInGoogleMaps() throws Exception {

		driver.get("https://www.google.ca/maps/@43.6238405,-79.3843833,559m/data=!3m1!1e3");
		WebElement canvas = driver.findElement(By.xpath("//canvas"));
		canvas.click();
		Thread.sleep(4000);
		Rectangle rect = canvas.getRect();
		int x = rect.getX();
		int y = rect.getY();
		int height = rect.getHeight();
		int width = rect.getWidth();
		System.out.println(x + " " + y + " " + height + " " + width);
		for (int i = 0; i < 5; i++) {
			new Actions(driver).doubleClick().build().perform();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_LEFT);
			Thread.sleep(4000);
			r.keyRelease(KeyEvent.VK_LEFT);

			/*
			 * Actions act =new Actions(driver); act.(Keys.ARROW_RIGHT); Thread.sleep(4000);
			 * act.keyUp(Keys.ARROW_RIGHT).build().perform();
			 * 
			 * 
			 * 
			 */ }
		new Actions(driver).keyDown(Keys.LEFT_ALT).sendKeys(Keys.ARROW_LEFT).keyUp(Keys.LEFT_ALT)
				.release().build().perform();
		Thread.sleep(10000);
	}

	@Test
	public void testBasicAuth() throws Exception {

		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		waitabit();
		// String heading = driver.findElement(By.tagName("h3")).getText();
		System.out.println(driver.findElement(By.tagName("h3")).getText());

	}

	@Test
	public void VerifyFileUpload() throws Exception {
		driver.get(URL + "/upload-download");
		String path = System.getProperty("user.dir") + File.separator
				+ "google.jpg"; /// Step 1 we navigated to the path of
															/// file and we gave complete path
		// "C:\\Users\\Tarun\\eclipse-workspace\\SeleniumBatch3rdOctober\\kajama ticket
		// booking confirmation.JPG"

		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		waitabit();
		WebElement chooseAButton = driver
				.findElement(By.xpath("//input[@id='uploadFile' and @class='form-control-file']"));
		Actions act = new Actions(driver);
		act.moveToElement(chooseAButton).click().build().perform();
		waitabit();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);// Enter to get the focus on textbox (file Name)
		waitabit();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);// Using shortcut keys CTRL + V, for windows to paste the file
										// Name with path

		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		waitabit();

		robot.keyPress(KeyEvent.VK_ENTER); // finally hitting enter
		robot.keyRelease(KeyEvent.VK_ENTER);

		waitabit();
		String completePath = driver.findElement(By.id("uploadedFilePath")).getText();
		System.out.println(completePath);
		waitabit();

		
		  TakesScreenshot screenshot = (TakesScreenshot) driver; // cast webdriver to be a type of Takescreenshot 
		  File screenshotFile =screenshot.getScreenshotAs(OutputType.FILE); // store screenshot in a file
		  FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir") + File.separator +"AutomationScreenshot.jpg"));
	}

	@Test
	public void verifyFileDownload() throws Exception {
		driver.get(URL + "/upload-download");
		waitabit();

		driver.findElement(By.xpath("//a[contains(text(),'Download')]")).click();
		waitabit();
		waitabit();
		File sampleFile = new File("C:\\\\Users\\\\sppat\\\\Downloads\\\\sampleFile.jpeg");
		

		if (sampleFile.isFile()) {
			System.out.println("File Downloaded");
		} else {
			System.out.println("File not downloaded");
		}

	}

	
	

}
