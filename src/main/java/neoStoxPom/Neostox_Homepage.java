package neoStoxPom;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neostox_Utility.Utility;

public class Neostox_Homepage {
	
	@FindBy(id="lbl_username") private WebElement username;
	@FindBy(id="lbl_curbalancetop")   private WebElement ACBalance;
	@FindBy(xpath="//span[text()='Logout']") private WebElement logout;
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement popUpOkButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement popUpCloseButton;
	@FindBy(id="txt_instruments") private WebElement searchEquitiestextfield;

	public Neostox_Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String getUserName(WebDriver driver) throws IOException
	{
		Utility.waitMethod(driver, 1000);
		String actualusername = username.getText();
		Reporter.log("validating Actual and expected Username",true);
		Utility.Screenshot(driver, actualusername);
		return actualusername;
	}
	public void searchEquities(WebDriver driver,String equities)
	{
		Utility.waitMethod(driver,1000);
		searchEquitiestextfield.sendKeys(equities);
	}
	
	public void handalingPopUp(WebDriver driver) throws InterruptedException
	{
		if(popUpOkButton.isDisplayed() )
		{
		Utility.waitMethod(driver, 5000);
		Reporter.log("Handaling popUp",true);
		popUpOkButton.click();
		Reporter.log("Click on ok Button",true);
		Thread.sleep(2000);
		popUpCloseButton.click();
		Reporter.log("Click on closed button",true);
	
		}
		else 
		{
			Reporter.log("PopUp is not displayed ,skip it",true);
			Utility.waitMethod(driver, 1000);
		}
	   }
	
	public String getBalance(WebDriver driver) throws InterruptedException, IOException
	{ 
		Utility.waitMethod(driver, 1000);
		String actualbalance = ACBalance.getText();
		System.out.println("Account balance is "+actualbalance);
		Reporter.log("Validating actual and expected A/c Balance" ,true);
		
		return actualbalance;
	}
	
	public void logoutFromNeostox(WebDriver driver) throws InterruptedException, IOException
	{
		Utility.waitMethod(driver, 1000);
		ACBalance.click();
		Thread.sleep(500);
		logout.click();
		Reporter.log("Log Out from neostox account ",true);
		
	}
}
