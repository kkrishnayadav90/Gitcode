package selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExcelMacys {
	public class ExcelLogin {
		
		WebDriver driver;
		Excel excel = new Excel();
		String firstname =null;
		String lastname  = null;
		String mailingaddress = null;
		String mailingaddress1= null;
		String city=null;
		String state=null;
		String month=null;
		String date=null;
		String year=null;
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		
	@BeforeMethod
		 public void launchBrowser(){
		driver=new FirefoxDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
	

@Test
public void ExcelMacys () throws Exception{
	driver.get("https://www.macys.com/account/profile");
	excel.SheetExcel("D:\\Excel file\\datadriven.xlsx","Sheet2");
	WebElement firstName = driver.findElement(By.id("firstName"));
	WebElement lastName = driver.findElement(By.id("lastName"));
	WebElement mailingAddress = driver.findElement(By.id("addressLine1"));
	WebElement mailingAddress1 = driver.findElement(By.id("addressLine2"));
	WebElement mainCity = driver.findElement(By.id("city"));
	WebElement mainState = driver.findElement(By.id("state"));
	WebElement currentMonth = driver.findElement(By.id("month"));
	WebElement currentDate = driver.findElement(By.id("date"));
	WebElement currentYear = driver.findElement(By.id("year"));
	
	for(int i=1;i<=3;i++){
		
		firstname=excel.getCellValue(i,1);
		lastname=excel.getCellValue(i,2);
		mailingaddress =excel.getCellValue(i, 3);
		mailingaddress1=excel.getCellValue(i, 4);
		city=excel.getCellValue(i, 5);
		state=excel.getCellValue(i, 6);
		month=excel.getCellValue(i,7);
		date=excel.getCellValue(i,8 );
		year=excel.getCellValue(i,9);
		
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		mailingAddress.sendKeys(mailingaddress);
		mailingAddress1.sendKeys(mailingaddress1);
		Thread.sleep(3000);
		mainCity.sendKeys(city);
		mainState.sendKeys(state);
		Thread.sleep(3000);
		currentMonth.sendKeys(month);
		currentDate.sendKeys(date);
		currentYear.sendKeys(year);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='createProfileBtn']")).click();
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File("Screenshot//Excel.jpg"));
		
	 
	
}
	
	}
	}
}

