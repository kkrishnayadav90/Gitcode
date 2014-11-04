package selenium;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebdriverClass {
	
private WebDriver driver;

@Parameters("browser")
@ BeforeTest
public void setup(String browser) throws Exception{
 
 if (browser.equals("FF")) 
 {
  System.out.println("Firefox Browser is selected");
  driver = new FirefoxDriver();
    driver.manage().window().maximize();
  } 
 
 else if (browser.equals("CH"))
 {
  System.out.println("Google chrome Browser selected");
  System.setProperty("webdriver.chrome.driver","D:\\software\\chromedriver_win32\\chromedriver.exe");
  driver = new ChromeDriver();		
  driver.manage().window().maximize();
 }
  
  else if (browser.equals("IE"))
  {
   System.out.println("Internet Explorer Browser selected");
   System.setProperty("webdriver.ie.driver","D:\\software\\IEDriverServer_x64_2.27.0\\IEDriverServer.exe");
   driver = new InternetExplorerDriver();
	driver.manage().window().maximize();		
  }
  }

//@BeforeMethod(enabled= false)
//public void launchbrowser()
//{
//driver = new FirefoxDriver();
//}

//
//@BeforeTest(enabled=false)
//public void setupchrome() throws Exception{
//	System.setProperty("webdriver.chrome.driver","D:\\software\\chromedriver_win32\\chromedriver.exe");
//	driver = new ChromeDriver();
//	driver.manage().window().maximize();
//}


//@BeforeTest
//public void setupinternet() throws Exception
//{
//	System.setProperty("webdriver.ie.driver","D:\\software\\IEDriverServer_x64_2.27.0\\IEDriverServer.exe");
//	driver = new InternetExplorerDriver();
//	driver.manage().window().maximize();
//}
//

@Parameters("browser")
@Test
public void WebdriverClass(String browser)throws Exception
{
	driver.manage().window().maximize();
	driver.get("https://www.macys.com/account/profile");
	driver.findElement(By.xpath("//button[@id='createProfileBtn']")).click();
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile,new File("Screenshot//"+browser+".jpg"));
	FileUtils.copyFile(srcFile,new File("Screenshot//"+browser+".jpg"));
	FileUtils.copyFile(srcFile,new File("Screenshot//"+browser+".jpg"));
	Thread.sleep(5000);
}
//	@Test
//	public void Webdriverpage()throws Exception
//	{
//	driver.get("http://www.google.com/");
//	  Actions builder = new Actions(driver);
//	builder.clickAndHold(driver.findElement(By.xpath("//input[@name='q']"))).keyDown(Keys.LEFT_SHIFT).moveToElement(driver.findElement(By.xpath("//input[@name='q']"))).sendKeys(driver.findElement(By.xpath("//input[@name='q']")),"selenium").keyUp(Keys.LEFT_SHIFT).build().perform();
//    
//    Thread.sleep(3000);
//	driver.findElement(By.xpath("//button[@id='gbqfba']")).click();
//	
//}
	
//	boolean isElementPresent(By locator)
//	{
//		try
//		driver.findElement(locator);
//		return true;
//	}
//	catch(Exception e)
//	{
//	return false;
//	}
//}
@AfterTest
public void Quit()
{
driver.quit();
}


}

