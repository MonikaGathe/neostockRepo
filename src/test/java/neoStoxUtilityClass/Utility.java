package neoStoxUtilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {

	public static String readDataFromPropertyFile(String key) throws IOException
	{
		
		Properties prop = new Properties();
		
		FileInputStream myfile = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\SeleniumProject\\neoStoxPropertyFile.properties");
		
		prop.load(myfile);
		
		String value = prop.getProperty(key);
		
		Reporter.log("enter "+key+" from property file ",true );
		return value;
	}
	
	public static void waitMethod(WebDriver driver, long time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
		Reporter.log("Wait for "+time+"ms",true);
	}
	
	public static void ScrollIntoView(WebDriver driver, WebElement element)
	{
	   JavascriptExecutor jr = (JavascriptExecutor)driver;
	   jr.executeScript("arguments[0].scrollIntoView",element);
	   Reporter.log("Scrolling "+element,true);
	}
	
	public static void Screenshot(WebDriver driver,String tcid) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\seleniumScreenShot\\screenshoteg"+tcid+".png");
		FileHandler.copy(src, dest);
		Reporter.log("taking screenShot...",true);
	}

	
}
