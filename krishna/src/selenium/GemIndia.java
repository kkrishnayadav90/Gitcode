package selenium;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GemIndia {
	private WebDriver driver;
	
	@BeforeTest
		 public void browserLaunch()
		 {
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 
	}

	@Test
	 public void Flight()throws Exception{
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		String handle= driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text() = 'Flights']")).click();
		Thread.sleep(3000);
		Set<String> allWin = driver.getWindowHandles();
		{
			for (String eachWin : allWin)
			{
		System.out.println(driver.switchTo().window(eachWin).getTitle());
			
			}
			driver.close();
		}
		driver.switchTo().window(handle);
		driver.findElement(By.xpath("//input[@id='loginbutton']")).click();
		driver.findElement(By.xpath("//div[@id='loginerrorpanel_header_controls']/span")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='banner3']/iframe")));
		driver.findElement(By.xpath("//img")).click();
		Set<String> Win = driver.getWindowHandles();
		{
			for (String eachWindow : Win)
			{
				driver.switchTo().window(eachWindow);
			}
		}
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//ul[@class='menuH']//a[text()='Journeys']"))).build().perform();
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.xpath("//div[@id='nav']//a[text()='Gems of India']"))).build().perform();
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.xpath("//div[@id='nav']/ul/li[3]/ul/li[1]/ul/li[4]/a[text()='Jaipur']"))).build().perform();
		driver.findElement(By.xpath("//div[@id='nav']/ul/li[3]/ul/li[1]/ul/li[4]/a[text()='Jaipur']")).click();
		driver.findElement(By.xpath("//a[text()='Places Of Interest']")).click();
		List<WebElement> gem = driver.findElements(By.xpath("//div[@id='view2']//img//preceding::h3"));
		for(WebElement Places:gem){
		     System.out.println(Places.getText());
		    }
		
		Thread.sleep(3000);
		
		
		}

}
