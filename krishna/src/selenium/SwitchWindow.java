package selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwitchWindow {
	private WebDriver driver;


@BeforeTest
public void browserLaunch()
{
	driver= new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}

@Test
public void SwitchWindow()throws Exception
{
	driver.get("D:\\practical\\alert.html");
	driver.findElement(By.xpath("//input[@value='Show alert box']")).click();
	Alert alert = driver.switchTo().alert();
	System.out.println(alert.getText());
	Thread.sleep(3000);
	alert.accept();
	driver.quit();
	
}
}