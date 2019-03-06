package com.seleniumpractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws IOException {
		
//		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\practice\\SeleniumPractice\\Drivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
//		driver.get("http://www.facebook.com);
		
		String path = "E:\\Automation\\practice\\SeleniumPractice\\InputData\\loginfacebook.xlsx";

		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);

	
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Printing the values in the cell
		// 1.
		// Row row = sheet.getRow(0);
		// Cell cell = row.getCell(0);
		// System.out.println(cell);
		// 2.
		// System.out.println(sheet.getRow(0).getCell(0));

		// String cellval = cell.getStringCellValue();
		// System.out.println(cellval);

		for (int row = 0; row <= sheet.getLastRowNum(); row++)
		{
			for (int col = 0; col <= sheet.getRow(0).getLastCellNum(); col++) 
			{				
				System.out.println(sheet.getRow(row).getCell(col));
			}
		}

	}

}
