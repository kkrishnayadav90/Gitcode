package selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MacysScreenshot {
	private WebDriver driver;

	
	
	
	@BeforeMethod
		public void browserLaunch()
		{
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
		}
		
	@Test
	public void MacysScreenshot() throws Exception
	{
		driver.manage().window().maximize();
		driver.get("https://www.macys.com/account/profile");
		driver.findElement(By.xpath("//button[@id='createProfileBtn']")).click();
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File("Screenshot//a.jpg"));
		Thread.sleep(3000);
		driver.findElement(By.id("firstName")).sendKeys("Krishna");
	    driver.findElement(By.id("lastName")).sendKeys("yadav");
	    driver.findElement(By.id("addressLine1")).sendKeys("kkrishnayadav90@gmail.com");
	    driver.findElement(By.id("city")).sendKeys("Gurgaon");
	    driver.findElement(By.id("state")).sendKeys("Alabama");
	    driver.findElement(By.id("zipcode")).sendKeys("122015");
	    driver.findElement(By.id("month")).sendKeys("December");
	    driver.findElement(By.id("date")).sendKeys("4");
	    driver.findElement(By.id("year")).sendKeys("1990");
	    driver.findElement(By.id("gender")).sendKeys("Female");
	    driver.findElement(By.id("email")).sendKeys("yyadavkrishna90@gmail.com");
	    driver.findElement(By.id("createConfirmEmail")).sendKeys("yyadavkrishna90@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("Gspann@123");
	    driver.findElement(By.id("confirmPassword")).sendKeys("Gspann@123");
	    driver.findElement(By.id("SecurityQna")).sendKeys("9");
	    driver.findElement(By.id("securityAns")).sendKeys("poonam");
	    Thread.sleep(3000);

}

@AfterTest
public void Quit(){
driver.quit();
}
}
