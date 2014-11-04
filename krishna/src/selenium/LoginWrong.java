
package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginWrong {
	private WebDriver driver;
	
	
	@BeforeMethod
	public void browserLaunch()
	{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	}
	
	
@Test
public void LoginWrong() throws Exception
{
	driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1");
	driver.findElement(By.id("Email")).clear();
	driver.findElement(By.id("Email")).sendKeys("yyadavkrishna90");
	driver.findElement(By.id("Passwd")).clear();
	driver.findElement(By.id("Passwd")).sendKeys("12345");
	driver.findElement(By.id("signIn")).click();
	Thread.sleep(2000);
	String a1=driver.findElement(By.xpath("//span[@id='errormsg_0_Passwd']")).getText();
	System.out.println("the text is **"+a1+"**");
	  
}
}
