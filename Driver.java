package driver_Config;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	
	public static String browser="FF";
	public static String wikiURL="https://www.wikipedia.org/";
	public static String imbdURL="https://www.imdb.com/";
    public static WebDriver driver;
	public static void launchBrowser()
	{
		// Launch the browser
		if(browser.equals("FF"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equals("GC"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		driver.manage().deleteAllCookies();
	}
	public static void closeBrowser()
	{
		driver.quit();
	}

}