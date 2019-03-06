package dataDrivenFramework;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Data_From_XML_File {

	public static void main(String[] args) throws DocumentException {
		
		// Creating WebDriver Instance		
	  
		WebDriver driver;			
	    System.setProperty("webdriver.chrome.driver","E:\\Automation\\practice\\SeleniumPractice\\Drivers\\chromedriver.exe");					
	    driver = new ChromeDriver();					
	    driver.get("http://www.facebook.com");					
	    driver.manage().window().maximize();	
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	
	    // Reading XML File    		
	    
	    File f = new File("E:\\Automation\\practice\\SeleniumPractice\\InputData\\or.xml");									
	    SAXReader saxReader = new SAXReader();					
	    Document document = saxReader.read(f);	
	    
	    String username_xpath = document.selectSingleNode("//menu/username_xpath").getText();							
	    String password_xpath = document.selectSingleNode("//menu/password_xpath").getText();							
	    String loginbtn_xpath = document.selectSingleNode("//menu/loginbtn_xpath").getText();							
	    String username = document.selectSingleNode("//menu/username").getText();							
	    String password = document.selectSingleNode("//menu/password").getText();	
	    
	    
	    driver.findElement(By.xpath(username_xpath)).sendKeys(username);					
	    driver.findElement(By.xpath(password_xpath)).sendKeys(password);	
	    driver.findElement(By.xpath(loginbtn_xpath)).click();				
		
	    driver.quit();
	}
}
