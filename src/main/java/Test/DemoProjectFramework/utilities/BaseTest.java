package Test.DemoProjectFramework.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;


import io.github.bonigarcia.wdm.*;


public class BaseTest {
	public static WebDriver driver;
	protected String screenshotpath;
	@BeforeTest
	public static void driverLaunch()
	{
	WebDriverManager.chromedriver().setup();
	driver =new ChromeDriver();
	
	}
	
	
	

}
