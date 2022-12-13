package listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import neoStoxBaseClass.Base;
import neoStoxUtilityClass.Utility;

public class Listener extends Base implements ITestListener
{
  public void onTestFailure(ITestResult result)
   {
	   Reporter.log("Testcase "+result.getName()+" is failed check it ones" , true );
	  
		try {
			
			Utility.Screenshot(driver, result.getName());
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
   
	public void onTestSuccess(ITestResult result)
  
	{
	   Reporter.log(result.getName()+" method are successfully run" , true );
	}
   
	public void onTestSkipped(ITestResult result)
  
	{
	   Reporter.log(result.getName()+"test method is skipped because of some resonce" , true );
	    
	}
	
}
