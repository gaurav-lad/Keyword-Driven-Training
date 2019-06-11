package ExcelInteraction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelKeyword {

	public Sheet readExcel(String filePath, String fileName, String sheetName) throws IOException {
		System.out.println("File: "+ filePath + fileName);
		File file = new File(filePath + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;
		workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		return sheet;
	}

}
