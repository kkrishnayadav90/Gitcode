package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.DefaultSelenium;

public class GoogleSite {
	
	private WebDriver driver;

@Parameters("Browser")
@ BeforeTest
public void setup(String Browser) throws Exception{
 
 if (Browser.equals("FF")) 
 {
  System.out.println("Firefox Browser selected");
  driver = new FirefoxDriver();
  driver.manage().window().maximize();
  } 
 
 else if (Browser.equals("CH")) {
  System.out.println("Google chrome Browser selected");
  System.setProperty("webdriver.chrome.driver","D:\\software\\chromedriver_win32\\chromedriver.exe");

  driver = new ChromeDriver();
  driver.manage().window().maximize();
  }
  }
	
public void browserLaunch()
{
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}


	
@Test
public void ChromeAutomate() throws Exception
{
	driver.manage().window().maximize();
 driver.get("https://www.chrome.com/");
 driver.findElement(By.xpath("//input[@id='gbqfq']")).sendKeys("Selenium");

 driver.findElement(By.xpath("//button[@id='gbqfba']")).click();

//	Actions builder = new Actions(driver);
//driver.findElement(By.xpath("//input[@id='gbqfq']")).sendKeys();
Thread.sleep(5000);
	
}
boolean isElementPresent(By Locator)
{
  try{
	   driver.findElement(Locator);
	   return true;
	  }
	  catch(NoSuchElementException e)
	  {
	   return false;
	  }
}


@AfterTest
public void Quit()
{
	driver.quit();
}
}



	 


