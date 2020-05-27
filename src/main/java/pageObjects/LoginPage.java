package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage 
{
	public WebDriver driver;
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath=".//*[@value='Login']")
	private WebElement login;
	
	public void getUsername(String un)
	{
		username.sendKeys(un);
	}
	
	public void getPassword(String ps)
	{
		password.sendKeys(ps);
		
	}
	public void getLogin()
	{
		login.click();
	}
	
	public LoginPage(WebDriver driver)
	{
	
		PageFactory.initElements(driver,this);
	}

}
