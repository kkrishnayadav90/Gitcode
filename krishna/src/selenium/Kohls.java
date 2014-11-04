package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Kohls {
	private WebDriver driver;
	
	
	
@BeforeMethod
	public void browserLaunch()
	{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
@Test
public void Kohls() throws Exception
{
	driver.manage().window().maximize();
	driver.get("http://www.macys.com/");
	try{
		driver.findElement(By.id("closeButton")).click();
	}
	catch(Exception e)
	{
		System.out.println("cross found");
	}
	Actions action = new Actions(driver);
	
	action.moveToElement(driver.findElement(By.xpath("//div[@id='globalMastheadCategoryMenu']//a[text()='MEN']"))).build().perform();
	Actions builder = new Actions(driver);
	builder.doubleClick(driver.findElement(By.xpath("//div[@id='Flyout_1']//li/a[text()='Jeans']"))).build().perform();
	Thread.sleep(5000);

}
}
