package selenium;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flight 
{

	private WebDriver driver;
	
@BeforeTest
	 public void browserLaunch()
	 {
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 
}

@Test
 public void Flight()throws Exception
 {
	driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	String handle= driver.getWindowHandle();
	driver.findElement(By.xpath("//a[text() = 'Flights']")).click();
	Set<String> allWin = driver.getWindowHandles();
	{
		for (String eachWin : allWin)
		{
			driver.switchTo().window(eachWin);
		}
		
	}
	
	driver.findElement(By.xpath("//input[@id='origin']")).sendKeys("delhi");
	driver.findElement(By.xpath("//ul[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']/li/a")).click();
	driver.findElement(By.id("destination")).sendKeys("Jaipur");
	driver.findElement(By.xpath("//a[@id='ui-active-menuitem']")).click();
	driver.findElement(By.xpath(("//input[@id='departDate']/following::img[@class='ui-datepicker-trigger'][1]"))).click();
	driver.findElement(By.xpath("//table/tbody/tr[3]/td[6]/a")).click();
	Select Type = new Select(driver.findElement(By.name("classType")));
	Type.selectByVisibleText("Business");
	driver.findElement(By.xpath("//div[@id='searchopt_dom']/following-sibling::div[@class='srchbtn']")).click();
	List<WebElement> flight = driver.findElements(By.xpath("//table[@class='flightcont']"));
	System.out.println(flight.size());
	driver.findElement(By.xpath("//div[@id='flightListResult']/div[1]/table[@class='flightcont']")).click();
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile,new File("Screenshot//flight.jpg"));
	Thread.sleep(3000);
	driver.close();
	
 }


}
