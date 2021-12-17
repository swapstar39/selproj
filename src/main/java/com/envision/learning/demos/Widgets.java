package com.envision.learning.demos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Widgets extends Hooks{

	
	@Test
	public void verifyMenuItemClick() throws Exception {
		driver.get(URL + "/menu");
		WebElement ele=driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		ele.click();
		Thread.sleep(3000);
		WebElement ele1=driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
		Actions actobj=new Actions(driver);
		actobj.moveToElement(ele1).build().perform();
		Thread.sleep(3000);
		WebElement ele2=driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
		ele2.click();
		Thread.sleep(3000);
		
		//setTimeout(()=>{debugger;},5000)
	}
	
	@Test
	public void verifyTooltipMessage() throws Exception {
		driver.get(URL + "/tool-tips");
		WebElement button=driver.findElement(By.xpath("//button[@id='toolTipButton']"));
		button.click();
		Thread.sleep(3000);
		WebElement tttext=driver.findElement(By.xpath("//div[text()='You hovered over the Button']"));
		String text=tttext.getText();
		System.out.println(text);
		Thread.sleep(3000);
		Assert.assertTrue(tttext.isDisplayed());
		Assert.assertEquals(text,"You hovered over the Button");
	}
	
	@Test
	public void verifyProgressbar() throws Exception {
		driver.get(URL + "/progress-bar");
		WebElement button=driver.findElement(By.xpath("//button[@id='startStopButton']"));
		button.click();
		Thread.sleep(3000);
		button.click();
		Thread.sleep(3000);
		WebElement pb=driver.findElement(By.xpath("//div[@class=\"progress-bar bg-info\"]"));
		String val=pb.getAttribute("aria-valuenow");
		System.out.println(val);
		Thread.sleep(3000);
	}
	
	@Test
	public void verifyProgressbar1() throws Exception {
		driver.get(URL + "/progress-bar");
		WebElement button=driver.findElement(By.xpath("//button[@id='startStopButton']"));
		button.click();
		WebElement pb=driver.findElement(By.xpath("//div[@class=\"progress-bar bg-info\"]"));
		Wait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.textToBePresentInElement(pb, "100%"));
		WebElement resetbutton=driver.findElement(By.xpath("//button[@id='resetButton']"));
		Assert.assertTrue(resetbutton.isDisplayed());
		Thread.sleep(3000);
		resetbutton.click();
		Thread.sleep(5000);
	}

	@Test
	public void verifyTabSelection() throws Exception {
		driver.get(URL + "/tabs");
		Thread.sleep(3000);
		WebElement tab=selectNavigationTab("Origin");
		tab.click();
		Thread.sleep(3000);
		String classAttr=tab.getAttribute("class");
		System.out.println(classAttr);
		Assert.assertTrue(classAttr.contains("nav-link active"));
		System.out.println("Tab Origin is selected");
	}	
	
	
	@Test
	public void verifyTabSelection1() throws Exception {
		driver.get(URL + "/tabs");
		Thread.sleep(3000);
		String tabName="Use";
		String classAttr="";
		List<WebElement> allTabs=driver.findElements(By.xpath("//a[contains(@id,'demo-tab')]"));
		for(int i=0;i<allTabs.size();i++) {
			if(allTabs.get(i).getText().equalsIgnoreCase(tabName)) {
				allTabs.get(i).click();
				classAttr=allTabs.get(i).getAttribute("class");
				break;
			}
		}
		
		System.out.println(classAttr);
		Assert.assertTrue(classAttr.contains("nav-link active"));
	}
	
	public WebElement selectNavigationTab(String tabName) {
		return driver.findElement(By.xpath("//nav[@role='tablist']//a[text()='"+tabName + "']"));
	}
}
