package neoStoxPom;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neostox_Utility.Utility;



public class PasswordPage {
	
	@FindBy(id="txt_accesspin") private WebElement password;
	@FindBy(id="lnk_submitaccesspin") private WebElement submitbutton;

	public PasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterpassword(String pw, WebDriver driver) throws IOException
	{
		password.sendKeys(pw);
		
		Utility.waitMethod(driver, 1000);
	}
	
	public void clickOnSubmitButton(WebDriver driver)
	{
		submitbutton.click();
		Reporter.log("Click on Submit button",true);
		Utility.waitMethod(driver, 1000);
	}
}
