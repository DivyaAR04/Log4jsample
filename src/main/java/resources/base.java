package resources;



import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//import io.github.bonigarcia.wdm.WebDriverManager;


public class base
{
//   private static Logger log=LogManager.getLogger(base.class.getName());
	
//	public WebDriver driver;
	public Properties pro;
	
	public WebDriver initializeTest() throws IOException
	{
		pro=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\viprava\\Desktop\\seleniumProg\\E2EProject1\\src\\main\\java\\resources\\test.properties");
			
		pro.load(fis);
		
		String browserName=pro.getProperty("browser");
		System.out.println(browserName);
		
		
//	if(browserName.equals("Firefox"))
//	     {
			
			WebDriverManager.firefoxdriver().setup();
		 	WebDriver driver=new FirefoxDriver();
			
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	/*		
	    }
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			//Some code related to chrome
		}
*/
			return driver;
	
	}

}
