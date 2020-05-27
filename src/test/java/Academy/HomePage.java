package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base
{
	private static Logger log1=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeTest();
	}
	
	@Test(dataProvider="getData")
	public void basePageNav(String username,String password)
	{
		String url=pro.getProperty("URL");
		log1.info("having navigated to url");
		System.out.println(url);
		
		driver.get(url);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		LoginPage l=new LoginPage(driver);
		//l.getUsername(pro.getProperty("username"));
	    //l.getPassword(pro.getProperty("password"));
		
		l.getUsername(username);
		l.getPassword(password);
		
		System.out.println(driver.getTitle());
		
		l.getLogin();	
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//rows stands from number of values passed to one test case
		Object[][] data=new Object[2][2];
		data[0][0]="batchautomation";
		data[0][1]="Test@12345";
		
	//	data[1][0]="abcdef";
	//	data[1][1]="xyz";
		
		return data;
	}
	
}
