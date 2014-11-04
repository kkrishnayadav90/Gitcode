package selenium;

 import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Macys {
private WebDriver driver = new FirefoxDriver();


@BeforeTest
public void setUp(){
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}


@Test
public void MacysSearch() throws Exception {
	   driver.get("http://www.macys.com/");
       driver.findElement(By.id("closeButton")).click();
       driver.findElement(By.id("href_emailSignup")).click();
       driver.findElement(By.name("firstName")).sendKeys("Krishna");
       driver.findElement(By.name("lastName")).sendKeys("yadav");
       driver.findElement(By.name("EmailAddr")).sendKeys("kkrishnayadav90@gmail.com");
       driver.findElement(By.name("country")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//option[@value='IN']"));   
       Thread.sleep(10000);
}

@AfterTest
public void Quit(){
driver.quit();
}
}
