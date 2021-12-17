package com.envision.learning.demos;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DatePicker extends Hooks {

	
	@Test
	public void verifyDateSelectionUsingKeys() throws Exception{
		//Create a date string mm-dd-yyyy
		//Identify the textbox for date picker
		//clear the textbox(Left shift+Home key+Backspace)
		//Send keys as user defined date and hit enter 
		
			driver.get(URL + "/date-picker");
			Thread.sleep(3000); 
			
			LocalDate localDate=LocalDate.now();
			int month=localDate.getMonthValue();
			int day=localDate.getDayOfMonth();
			int year=localDate.getYear();
			String currentDate=month+ "/" + day + "/" + year;
			System.out.println(currentDate);
			
			WebElement dp=driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
			dp.click();
			Actions act=new Actions(driver);
			act.keyDown(Keys.LEFT_SHIFT).sendKeys(Keys.HOME).keyUp(Keys.LEFT_SHIFT).keyDown(Keys.BACK_SPACE).build().perform();
			Thread.sleep(3000); 
			dp.sendKeys(currentDate);
			Thread.sleep(3000); 	
			dp.sendKeys(Keys.ENTER);
			Thread.sleep(3000); 
			
			
	}
	
	@Test
	
    public void verifyDateSelectionUsingKey() throws Exception {
    	
    	//Create a date string mm-dd-yyyy
		//Identify the textbox for date picker
		//click on textbox for calender popup to appear
		//Identify webelement for month,year and day
    	//select the values and click on day
		
		driver.get(URL + "/date-picker");
		Thread.sleep(3000); 

    	LocalDate localdate1=LocalDate.now();
		String month=String.valueOf(localdate1.getMonth());
		month=month.substring(0,1)+month.substring(1).toLowerCase();
		String year=String.valueOf(localdate1.getYear());
    	String day=String.valueOf(localdate1.getDayOfMonth());
    	//int day=6;
    	System.out.println("Month: "+month+" , Year: "+year+" , Day: "+day);
    	
    	WebElement dp=driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
		dp.click();
		Thread.sleep(3000); 
    	WebElement mm=driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
    	WebElement yyyy=driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
//    	WebElement dd=driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--') and not(contains(@class, 'outside-month')) and text() = '"+day+"']"));
    	
    	Select selectyear=new Select(yyyy);
    	Select selectmonth=new Select(mm);
    	
    	selectyear.selectByVisibleText("2023");
    	Thread.sleep(3000); 
    	selectmonth.selectByVisibleText("January");
    	Thread.sleep(3000); 
    	WebElement dd=driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--') and not(contains(@class, 'outside-month')) and text() = '"+day+"']"));
    	dd.click();
    	Thread.sleep(3000); 
    	String val=dp.getAttribute("value");
    	System.out.println(val);
    	
    	
    	//div[contains(@class,'react-datepicker__day react-datepicker__day--')]
    	//div[contains(@class,'react-datepicker__day react-datepicker__day--') and text() = '7']
    	
    	
	}
		
}
