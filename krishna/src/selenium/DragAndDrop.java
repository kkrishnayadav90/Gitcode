package selenium;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DragAndDrop {
private WebDriver driver;

@BeforeMethod
public void browserLaunch()
{
	driver= new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
}


@Test
public void Drag()throws Exception
{
	
	driver.get("http://www.google.com/");
	List<WebElement> mylist = driver.findElements(By.xpath("//div[@id='als']/a"));
	String a=mylist.get(3).getText();
	driver.findElement(By.xpath("//input[@id='gbqfq']")).sendKeys(a);
	driver.findElement(By.xpath("//button[@id='gbqfba']")).click();
	Thread.sleep(5000);
	

}

@AfterTest
public void Quit(){
driver.quit();
}
}
