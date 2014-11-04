package selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExcelLogin {
	
	WebDriver driver;
	Excel excel = new Excel();
	String username =null;
	String password  = null;
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	
@BeforeMethod
	 public void launchBrowser(){
	driver=new FirefoxDriver(); 
	driver.manage().window().maximize();
	driver.get("https://login.microsoftonline.com/login.srf?wa=wsignin1.0&rpsnv=4&ct=1414578071&rver=6.1.6206.0&wp=MBI_KEY&wreply=https:%2F%2Fwww.outlook.com%2Fowa%2F&id=260563&whr=gspann.com&CBCXT=out");
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 }

@Test
public void login() throws Exception{
	excel.SheetExcel("D:\\Excel file\\datadriven.xlsx","Sheet1");
	WebElement firstName = driver.findElement(By.xpath("//input[@id='cred_userid_inputtext']"));
	 WebElement pass =driver.findElement(By.xpath("//input[@name='passwd']"));
	 WebElement signIn =driver.findElement(By.xpath("//span[@id='cred_sign_in_button']"));
 for(int i=1;i<=3;i++){
     username=excel.getCellValue(i,1);
     password=excel.getCellValue(i,2);
     //driver.findElement(By.xpath("//input[@id='cred_userid_inputtext']")).clear();
     firstName.clear();
     firstName.sendKeys(username);
 //driver.findElement(By.xpath("//input[@id='cred_userid_inputtext']")).sendKeys(username);
 pass.clear();
 //driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(password);
 pass.sendKeys(password);
 Thread.sleep(2000);
 signIn.click();
 Thread.sleep(3000);
 }
 driver.close();
 
}
}