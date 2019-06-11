package TestCases;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ExcelInteraction.ReadExcelKeyword;
import operation.ReadObject;
import operation.UIOperations;

public class TestCasesExecute {

	@Test
	public void inputValidationCheck() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Ready made excel file reader, which return "S"heet
		ReadExcelKeyword file = new ReadExcelKeyword();

		ReadObject object = new ReadObject();
		Properties allObjects = object.getProperties();
		//C:\Users\Gaurav\eclipse-workspace\KeywordDrivenTraining\TestCase.xlsx
		
		UIOperations operation = new UIOperations(driver);
		
		//Passing Excel file details required for this test case specifically
		Sheet sheet = file.readExcel("C:\\Users\\Gaurav\\eclipse-workspace\\KeywordDrivenTraining\\", "TestCase.xlsx", "KeywordFramework");

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			if(row.getCell(0).toString().length() == 0) {
				System.out.println("Operation: " + row.getCell(1).toString() + " Object Name: "+ row.getCell(2).toString() + " Locator Type or Object Type: "+ row.getCell(3).toString() + " Value from cell: "+ row.getCell(4).toString());
				//We got the actions/methods from excel, now perform it on web driver
				operation.execute(allObjects, row.getCell(1).toString(), row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString());
			}
		}
	}
}
