package dataDrivenFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Data_From_Excel_Sheet {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File("E:\\Automation\\practice\\SeleniumPractice\\InputData\\loginfacebook.xlsx");
		FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Sheet1");
	
		for (int rowNumber = 1; rowNumber <= 2; rowNumber++) 
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Automation\\practice\\SeleniumPractice\\Drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			
			driver.get("https://www.facebook.com");

			String username = sh.getRow(rowNumber).getCell(0).getStringCellValue();
			driver.findElement(By.cssSelector("#email")).sendKeys(username);

			String password = sh.getRow(rowNumber).getCell(1).getStringCellValue();
			driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(password);

			driver.findElement(By.xpath("//*[@type='submit']")).click();

			driver.quit();
		}

	}

}
