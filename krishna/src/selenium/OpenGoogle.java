package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenGoogle {
	private WebDriver driver;



@BeforeMethod
public void browserLaunch()
{
	driver= new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}

@Test
public void OpenGoogle() throws Exception
{
driver.manage().window().maximize();
driver.get("http://www.google.com/");
driver.findElement(By.xpath("//input[@id='gbqfq']")).sendKeys("Selenium");
//driver.findElement(By.xpath("//input[@id='gbqfq']")).click();
driver.findElement(By.xpath("//button[@id='gbqfba']")).click();
Thread.sleep(5000);
}

@AfterTest
public void Quit()
{
	driver.quit();
}
}
