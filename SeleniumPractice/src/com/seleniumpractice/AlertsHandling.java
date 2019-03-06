package com.seleniumpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsHandling {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","E:\\Automation\\practice\\SeleniumPractice\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.name("proceed")).click(); // click on Go btn

		Thread.sleep(5000);

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());

		String text = alert.getText();
		if (text.equals("Please enter a valid user name")) {
			System.out.println("correct alert messg");
		} else {
			System.out.println("in-correct alert messg");
		}

		alert.accept(); // click on OK btn

		// alert.dismiss(); //click on cancel btn
		
		driver.close();		

	}

}
