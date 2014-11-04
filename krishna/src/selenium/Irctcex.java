package selenium;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Irctcex {
	private WebDriver driver;
	Excel excel=new Excel();
	
@BeforeMethod

	 public void launchBrowser(){
	driver=new FirefoxDriver(); 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

}

@Test
public void Irctc()throws Exception{
	excel.SheetExcel("ExcelFiles\\datadriven.xlsx","Sheet3");
	
	 
	 for(int i=2;i<=3;i++){
		 driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		 driver.findElement(By.xpath("//div[@id='bluemenu']/ul/li[2]/a")).click();
		 Thread.sleep(2000);
		 String win=driver.getWindowHandle();
		 System.out.println(win);
		 Set<String> w=driver.getWindowHandles();
		 for(String excelw: w){
		 driver.switchTo().window(excelw);
		 }
		 Thread.sleep(1000);
		 String to=excel.getCellValue(i,1);
		 String from=excel.getCellValue(i,2);
		 String date=excel.getCellValue(i,3);
		 String cl=excel.getCellValue(i,4);
		 String screenshot=excel.getCellValue(i,5);
		 driver.findElement(By.xpath("//input[@id='origin']")).sendKeys(to);
		 driver.findElement(By.xpath("//a[@id='ui-active-menuitem']")).click();
		 driver.findElement(By.xpath("//input[@id='destination']")).sendKeys(from);
		 driver.findElement(By.xpath("//a[@id='ui-active-menuitem']")).click();
		 String[] parts = date.split("\\/");
		 String part1 = parts[0];
		 String part2 = parts[1];
		 String part3 = parts[2];
		 System.out.println(part1);
		 System.out.println(part2);
		 System.out.println(part3);
		 
		 
	     int yes = Integer.parseInt(part2);
	     int p2=yes-1;
		 System.out.println(p2);
		 
		 driver.findElement(By.xpath("//input[@id='departDate']/following::img[@class='ui-datepicker-trigger'][1]")).click();
         driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
	 
         driver.findElement(By.xpath("//td[@data-year='"+part3+"' and @data-month='"+p2+"']/a[text()='"+part1+"']")).click();
		 driver.findElement(By.xpath("//div[@id='passgrinfo']/div[2]/div[4]/select[@name='classType']")).sendKeys(cl);
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//select[@name='classType']/option[@value='B']")).click();
	 driver.findElement(By.xpath("//div[@id='showdometic']/div[7]")).click();	
	 Thread.sleep(1000);
	 if(screenshot.contains("yes")){
		 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(srcFile,new File("Screenshot//"+i+".jpg")); 
		 }
		 driver.switchTo().window(win);
		 driver.findElement(By.xpath("//div[@id='bluemenu']/ul/li[2]/a")).click();
		 Thread.sleep(2000);
		 String Win=driver.getWindowHandle();
		 System.out.println(Win);
	 Set<String> sw=driver.getWindowHandles();
	 for(String excelw: sw){
		 driver.switchTo().window(excelw);
	
}

}
}

}
