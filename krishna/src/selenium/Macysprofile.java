package selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Macysprofile {
	
  private WebDriver driver;
  Excel excel=new Excel();
	
 @BeforeTest
	public void browser(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
 }
	
	@Test
	public void main() throws Exception{
	excel.SheetExcel("ExcelFiles\\datadriven.xlsx","Sheet3");
	System.out.println(excel.getCellValue(3,2));
	driver.get("https://www.macys.com/account/profile");
	for(int i=1;i<=3;i++){
		
	String firstname=excel.getCellValue(i,1);
	String lastname=excel.getCellValue(i,2);
	String mail1=excel.getCellValue(i,3);
	String mail2=excel.getCellValue(i,4);
	String city=excel.getCellValue(i,5);
	String state=excel.getCellValue(i,6);
	String zipcode=excel.getCellValue(i,7);
	String birthdate=excel.getCellValue(i,8);
	String gender=excel.getCellValue(i,9);
	String email=excel.getCellValue(i,10);
	String vemail=excel.getCellValue(i,11);
	String pwd=excel.getCellValue(i,12);
	String vpwd=excel.getCellValue(i,13);
	String sques=excel.getCellValue(i,14);
	String ans=excel.getCellValue(i,15);
	String ss=excel.getCellValue(i,16);
	

}
	}
}
