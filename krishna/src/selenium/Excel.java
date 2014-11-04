package selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Excel
{
	private WebDriver driver;
	private FileInputStream file;
	private XSSFWorkbook workbook;
	private XSSFSheet Sheet;
	private XSSFCell cell;
	private DataFormatter formatter;

public void SheetExcel(String path, String sheetname)throws Exception
{
	file = new FileInputStream (path);
	workbook = new XSSFWorkbook(file); 
	Sheet = workbook.getSheet(sheetname);
}

public String getCellValue(int row, int col)
{
	cell= Sheet.getRow(row).getCell(col);
	formatter= new DataFormatter();
	return formatter.formatCellValue(cell);
}

}

