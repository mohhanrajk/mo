package driver_common_utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Web_driver
{
		public static WebDriver driver = null;
		public static WebDriver browser(String browser)
		 {
			try
			  {
				if(browser.equalsIgnoreCase("firefox")) {
					 
						//If browser is Firefox, then do this  
		              System.setProperty("webdriver.gecko.driver","C:\\Users\\MohanrajK\\Desktop\\New folder\\MY_FRAMEWORK\\browserexes\\geckodriver.exe");
					  driver = new FirefoxDriver();
					 System.out.println("firefox is successfully opened");
					 
					  // If browser is IE, then do this   
					  }
					  else if (browser.equalsIgnoreCase("chrome")) 
					  {
					 
					  // Here I am setting up the path for my chrome Driver
						  System.setProperty("webdriver.chrome.driver", "C:\\Users\\MohanrajK\\Desktop\\New folder\\MY_FRAMEWORK\\browserexes\\chromedriver.exe");
					  driver = new ChromeDriver();
					  System.out.println("chrome is successfully opened");
					  } 


			  }

			catch(Exception e)
			{
				System.out.println("problem in driver launching");
				return null;
			}
	return driver;
	 }
		
		
		public static void Browser_close()
		{
			driver.close();
		}
	
}