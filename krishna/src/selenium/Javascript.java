package selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



  public class Javascript 
  {
	private WebDriver driver;
	
	
	@BeforeMethod
	public void browserLaunch()
	{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	@Test(enabled=false)
	 public void Javascript() throws Exception
	  {
		driver.get("http://www.google.com/");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.getElementsByTagName('div').length");
		Thread.sleep(3000);
		
	}
	
	@Test
	public void Javascript1() throws Exception
	{
		driver.manage().window().maximize();
		driver.get("http://www.google.com/");
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File("D://shubham.png"));
	}

	
	@AfterTest
	public void Quit(){
	driver.quit();


	}
  }


