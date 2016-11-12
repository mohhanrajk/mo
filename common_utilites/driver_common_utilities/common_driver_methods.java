package driver_common_utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import other_common_files.element_highligting;
import other_common_files.screenshots;
import read_write_excel_packages.write_result_in_excel;

public class common_driver_methods
{
	
	public static boolean verify_element_present(WebElement element)
	{
		boolean verify_element = true;
		try
		{
			System.out.println("controlled entered into try block");
			element_highligting.highLightElement(element);
			verify_element = element.isDisplayed();
			if(verify_element == true)
			{
				System.out.println("controlled entered into if block");
				System.out.println("element is present :" +verify_element);	
				
				return true;
			}
			else
			{
				System.out.println("controlled entered into else block");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("controlled entered into catch block");
			System.out.println("Exception e:" +e);
			return false;
			
		}
		
}
	
	
	public static void enter_value_in_box(WebElement element, String value)
	{
		try
		{	
				Assert.assertEquals(true, verify_element_present(element));
				element_highligting.highLightElement(element);
				element.sendKeys(value);
				//write_result_in_excel.best("1", "2", "3", "7");
				
		}
		
		catch(Exception e)
		{
			System.out.println("Exception e is :" +e);
		}
		finally
		{
			screenshots.captureScreenShot();
			System.out.println("screenshot is taken");
		}
	}

	
	
	public static void drop_down_select(List<WebElement> elements) throws InterruptedException
	{
		try
		{
			int t  = elements.size();
			System.out.println("array list values :" +t);
			ArrayList<String> list= new ArrayList<String>();
			
			Iterator<WebElement> iter = elements.iterator();

						while(iter.hasNext())
						{
							WebElement we = iter.next();
							element_highligting.highLightElement(we);
							String tg = we.getText();
							if(tg.equals("T02 - TUV Private Ltd"))
							{
								we.click();
								System.out.println("tg is clicked");
							}
						 }			
		}
		catch(Exception e)
		{
			System.out.println("Exception e:" +e);
			screenshots.captureScreenShot();
			System.out.println("screenshot is taken");
		}
	}

public static void element_position(WebElement element, int i, int y)
{
	try
	{
		element_highligting.highLightElement(element);
		Point point = element.getLocation();
	    int xcord = point.getX();
	    System.out.println("Element's Position from left side Is "+xcord +" pixels.");
	    int ycord = point.getY();
	    System.out.println("Element's Position from top side Is "+ycord +" pixels.");
	    Assert.assertEquals(i, xcord);
	    Assert.assertEquals(y, ycord);
	    
	    //Screenshots
	   	screenshots.captureScreenShot();
		System.out.println("screenshot is taken");
	    
	}
	catch (Exception e)
	{
		System.out.println("Exception E :" +e);
		screenshots.captureScreenShot();
		System.out.println("screenshot is taken");
	}
}

	
	
	
public static void button_click(WebElement element)
{
	try
	{
		Assert.assertEquals(true, verify_element_present(element));
		element_highligting.highLightElement(element);
		element.click();
	}
	catch(Exception e)
	{
		System.out.println("Exception e is :" +e);
	}
	finally
	{
		screenshots.captureScreenShot();
		System.out.println("screenshot is taken");
	}
	
}



}
