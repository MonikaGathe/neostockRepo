package neoStoxTestClass;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStoxPom.Neostox_Homepage;
import neoStoxPom.PasswordPage;
import neoStoxPom.SignINPage;
import neostox_Base.Base;
import neostox_Utility.Utility;

@Listeners(listenersStudy.Listener.class)

public class NeoStoxValidatingBalance extends Base{
	
	SignINPage signIn;
	PasswordPage password;
	Neostox_Homepage home;
	@BeforeClass
	public void lonchbrowser() throws IOException
	{
		lonchBrowser();
		signIn = new SignINPage(driver);
		password = new PasswordPage(driver);
		home = new Neostox_Homepage(driver);
	}
	
	@BeforeMethod
	public void neoStoxSingIn() throws IOException, InterruptedException
	{
		signIn.ClickOnSignInOption(driver);
		signIn.entermobNo(Utility.readDataFromPropertyFile("mob.no"), driver);
		signIn.ClickonSignUpbutton(driver);
		password.enterpassword(Utility.readDataFromPropertyFile("password"), driver);
		Thread.sleep(1000);
		password .clickOnSubmitButton(driver);
		Thread.sleep(5000);
		home.handalingPopUp(driver);
		
		
	}
  @Test(priority = 1)
  public void validatingAccountBalance() throws IOException, InterruptedException
  {   
	  Thread.sleep(10000);
	 home.getBalance(driver);
	 
  }
  
  @Test
  public void validatingUserName() throws IOException, InterruptedException
  {   
	  Thread.sleep(10000);
	  Assert.assertEquals(home.getUserName(driver), Utility.readDataFromPropertyFile("expun"));
	 
  }
  
  @AfterMethod
  public void logOutneostox() throws InterruptedException, IOException
  {
	 
	 home.logoutFromNeostox(driver);
  }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException
  {
	  Thread.sleep(3000);
	  driver.close();
  }
}
