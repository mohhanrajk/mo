package other_common_files;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver_common_utilities.Web_driver;

public class element_highligting 
{
	public static void highLightElement(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)Web_driver.driver; 

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try 
		{
			Thread.sleep(500);
		} 
		catch (InterruptedException e) 
		{

			System.out.println(e.getMessage());
		} 

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 

	}
}
