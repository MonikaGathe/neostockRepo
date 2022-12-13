package neoStoxBaseClass;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import neoStoxUtilityClass.Utility;


public class Base 
{
	protected static WebDriver  driver ;
 
	public void lonchBrowser() throws IOException, InterruptedException
	{
		// new master branch
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get(Utility.readDataFromPropertyFile("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		Utility.waitMethod(driver, 1000);
	
		Thread.sleep(1000);
	
	
	
	
	}
}
