package dataDrivenFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Data_From_Properties_File {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException 
	{				
		String path="E://Automation//practice//SeleniumPractice//InputData//config.properties";
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Properties properties=new Properties();
		properties.load(fis);
				
		String browsername = properties.getProperty("browser");
		
		if(browsername.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","E:\\Automation\\practice\\SeleniumPractice\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver","E:\\Automation\\practice\\SeleniumPractice\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","E:\\Automation\\practice\\SeleniumPractice\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();			
		}		
		
//		System.setProperty("webdriver.chrome.driver","E:\\Automation\\practice\\SeleniumPractice\\Drivers\\chromedriver.exe");
//		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
				
		String url = properties.getProperty("url");
		driver.get(url);
		
		driver.findElement(By.xpath(properties.getProperty("username_xpath"))).sendKeys(properties.getProperty("username"));
		driver.findElement(By.xpath(properties.getProperty("password_xpath"))).sendKeys(properties.getProperty("password"));
		driver.findElement(By.xpath(properties.getProperty("loginbtn_xpath"))).click();
		
		driver.close();
		
	}
}
