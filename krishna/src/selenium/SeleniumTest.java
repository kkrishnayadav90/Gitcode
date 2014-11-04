package selenium;

/*import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;*/
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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



	public class SeleniumTest {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	/* @Before
	  //public void setUp() throws Exception {
	    //driver = new FirefoxDriver();//(browser specify ker rehay hai)
	    //baseUrl = "https://www.google.co.in/";//(actual url)
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }*/

	  @BeforeSuite
	    public void beforesuite()
	  {
		  System.out.println("Before suite");	  
	  }
	  
	  
	  @BeforeTest
	    public void beforetest(){
		  System.out.println("Before test");
	  }
	  
	  @BeforeClass
	   public void beforeclass()
	  {
		  System.out.println("Before class");
	  }
	  
	  @BeforeMethod
	  public void beforemethod()
	  {
		  System.out.println("Before method");
	  }
	  
	  
	  @Parameters({"username", "password"})
	 @Test
	  public void testGoogleSearch(String username , String password) throws Exception {
		  System.out.println(username);
		  System.out.println(password);
	    /*driver.get(baseUrl + "/?gfe_rd=cr&ei=B1I_VImkAuzA8geQ5YDoAw&gws_rd=ssl");
	    driver.findElement(By.id("gbqfq")).clear();
	    driver.findElement(By.id("gbqfq")).sendKeys("gspann technologies");
	    driver.findElement(By.linkText("GSPANN Technologies, Inc")).click();*/
	  }
	 
	 @Test
	   public void testYahooSearch() throws Exception{
		 System.out.println("Welcome to Yahoo");
	   }

	  @AfterSuite
	  public void aftersuite(){
		  System.out.println("After suite");
	  }
	  
	  @AfterTest
	  public void aftertest()
	  {
		  System.out.println("After test");
	  }
	  
	  @AfterClass
	  public void afterclass()
	  {
		  System.out.println("After class");
	  }
	  
	  @AfterMethod
	  public void aftermethod()
	  {
		  System.out.println("After method");
	  }
	  
	  
	  //@After
	  //public void tearDown() throws Exception {
	    //driver.quit();//( browser ko close ker dega)
	    //String verificationErrorString = verificationErrors.toString();
	    //if (!"".equals(verificationErrorString)) {
	      //fail(verificationErrorString);
	    
	  } 

	  
	



