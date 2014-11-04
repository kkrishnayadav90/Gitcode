package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginGmail {
	private WebDriver driver;
	
	
	@BeforeMethod
	public void browserLaunch()
	{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	@Test
	public void LoginGmail() throws Exception
	{
	driver.manage().window().maximize();
	driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1");
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("yyadavkrishna90");
	driver.findElement(By.id("Passwd")).clear();
	driver.findElement(By.id("Passwd")).sendKeys("Gspann@123");
	driver.findElement(By.id("signIn")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//div[@id=':3o']")).click();
	driver.findElement(By.xpath("//div[@id=':5']//div[@class='ar9 T-I-J3 J-J5-Ji']")).click();
	String a= driver.findElement(By.xpath("//div[@class='vh']")).getText();
	Assert.assertEquals(a, "The conversation has been moved to the Trash and will be permanently deleted in 30 days.  Learn more  Undo");
	driver.findElement(By.id("link_undo")).click();
	
		}
	

@AfterTest
public void Quit(){
driver.quit();
}

}
