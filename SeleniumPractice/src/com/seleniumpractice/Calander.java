package com.seleniumpractice;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calander {

	public static void main(String[] args) throws InterruptedException {
		
		String date = "21-04-2019";
		String datesplit[] = date.split("-");
				
		System.setProperty("webdriver.chrome.driver","E:\\Automation\\practice\\SeleniumPractice\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.redbus.in/");
	
		driver.findElement(By.xpath("//*[@id='src']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//*[@id='dest']")).sendKeys("Bangalore");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='search']/div/div[3]/div/label")).click();

		int monthDiff = Integer.parseInt(datesplit[1]) - Calendar.getInstance().get(Calendar.MONTH);
		
		if (datesplit[1] != "02")
		{
				for (int i = 1; i < monthDiff; i++) 
				{
					driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[3]")).click();
				}
		}
		
		//         // *[@id="rb-calendar_onward_cal"]/table/tbody/tr[6]/td[2]

		String beforeXpath = "//*[@id='rb-calendar_onward_cal']/table/tbody/tr[";
		String afterXpath = "]/td[";
		
		for (int rowNum = 3; rowNum <= 7; rowNum++) 
		{
			for (int colNum = 1; colNum <= 7; colNum++)
			{		
				
				String val = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText();
				if(val == datesplit[0])
				{
					driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
				}
				
			
			}
		}
		
		driver.findElement(By.xpath("//*[@id='search_btn']")).click();
		
		driver.quit();

	}

}
