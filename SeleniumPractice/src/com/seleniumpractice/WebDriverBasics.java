package com.seleniumpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","E:\\Automation\\practice\\SeleniumPractice\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("http://www.google.com");

		String title = driver.getTitle();
		System.out.println(title);

		if (title.equals("Google")) {
			System.out.println("correct title");
		} else {
			System.out.println("in-correct title");
		}

		System.out.println(driver.getCurrentUrl());

		driver.quit(); 

	}

}
