package selenium;

import org.testng.annotations.Test;

public class ExcelSheet
{

	
@Test

public void DataDriven()throws Exception
{
	 Excel excelSheet = new Excel();
	 excelSheet.SheetExcel("D:\\Excel file\\datadriven.xlsx","Sheet1");
	 System.out.println(excelSheet.getCellValue(1,1)); 
}
}
