package neoStoxTestClass;

import org.testng.annotations.Test;

import neoStoxBaseClass.Base;
import neoStoxPom.Neostox_Homepage;
import neoStoxPom.PasswordPage;
import neoStoxPom.SignINPage;
import neostox_Utility.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.annotations.AfterClass;

public class NeoStoxSearchEquities extends Base {
	
  SignINPage signin;
  PasswordPage password;
  Neostox_Homepage home;
 
  @BeforeClass
  public void beforeClass() throws IOException, InterruptedException
  {
		lonchBrowser(); 
		signin=new SignINPage(driver);
		password = new PasswordPage(driver);
		home = new Neostox_Homepage(driver);
  }
  @BeforeMethod
  public void beforeMethod() throws IOException, InterruptedException
  {
	  signin.ClickOnSignInOption(driver);
	  signin.entermobNo(Utility.readDataFromPropertyFile("mob.no"), driver);
	  signin.ClickonSignUpbutton(driver);
	  password.enterpassword(Utility.readDataFromPropertyFile("password"), driver);
	  password.clickOnSubmitButton(driver);
	  home.handalingPopUp(driver);
	 
  }
  @Test
  public void checkEquitiesTextField() throws IOException
  {
	  home.searchEquities(driver,Utility.readDataFromPropertyFile("equity"));
  }
  @AfterMethod
  public void afterMethod() throws InterruptedException, IOException
  {
     home.logoutFromNeostox(driver);
  }

  @AfterClass
  public void afterClass()
  {
	  driver.close();
  }

}
