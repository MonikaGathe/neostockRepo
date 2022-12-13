package neoStoxPom;

import java.io.IOException;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neostox_Utility.Utility;


public class SignINPage 
{
	@FindBy(xpath = "(//a[text()='Sign In'])[1]") private WebElement signinoption;
	@FindBy(id = "MainContent_signinsignup_txt_mobilenumber") private WebElement number ;
    @FindBy(id= "lnk_signup1") private WebElement signupbutton;
	  
   
   public SignINPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
	   
   }
   
   public void ClickOnSignInOption(WebDriver driver)
   {
	   signinoption.click();
	   Reporter.log("Click on SingIn Option",true);
	   Utility.waitMethod(driver, 1000);
	   
   }
   
  
   public void entermobNo(String mno, WebDriver driver) throws IOException
   {
	  number.sendKeys(mno);
	  Utility.waitMethod(driver, 1000);
   }
  
   
   public void ClickonSignUpbutton(WebDriver driver)
   {
	  signupbutton.click();
	   
	  Reporter.log("Click on signin button",true);
	  
	  Utility.waitMethod(driver, 1000);
   }

   

}
