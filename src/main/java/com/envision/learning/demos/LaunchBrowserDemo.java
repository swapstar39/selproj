package com.envision.learning.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LaunchBrowserDemo extends Hooks {
 
	
	@Test
	public void launchDemoQaWebpage() throws Exception {
		driver.get(URL);
		String title=driver.getTitle();
		System.out.println(title);
		String CurrentURL=driver.getCurrentUrl();
		System.out.println(CurrentURL);
		String ps=driver.getPageSource();
		System.out.println(ps);
		
		Thread.sleep(5000);
		
		WebElement elementLink=driver.findElement(By.className("card-up"));
		elementLink.click();
		
		Thread.sleep(5000);
		
		WebElement ele1=driver.findElement(By.className("text"));
		ele1.click();
		
		Thread.sleep(5000); 
		
		WebElement ele2=driver.findElement(By.id("userName"));
				ele2.sendKeys("Swapnil");
				
				Thread.sleep(2000);
				
				ele2.clear();
				
				Thread.sleep(4000);
				
				ele2.sendKeys("Star");
						Thread.sleep(4000);
				
		
		//Assert.assertTrue(title.equalsIgnoreCase("ToolsQA"));
	//	Assert.assertTrue(CurrentURL.contains("demoqa"));
		
	}
	

}
