package selenium;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Google {
	private WebDriver driver = new FirefoxDriver();


@Test
public void GoogleSearch()throws Exception
{
	driver.manage().window().maximize();
	driver.get("http://www.google.com/");
String Button_Name= driver.findElement(By.xpath("//button[@id ='gbqfba' ]//span")).getText();
Assert.assertEquals(Button_Name, "Google Search");
System.out.println("I am working fine");
String css_value= driver.findElement(By.id("hplogo")).getCssValue("background-size");
System.out.println(css_value);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
}
	






