package other_common_files;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver_common_utilities.Web_driver;

public class screenshots {
	
	public static void captureScreenShot()
	{
		// Take screenshot and store as a file format             
		 File src=((TakesScreenshot)Web_driver.driver).getScreenshotAs(OutputType.FILE);           
		try {
		// now copy the  screenshot to desired location using copyFile method

		FileUtils.copyFile(src, new File("C:/Users/MohanrajK/Desktop/screenshot/"+System.currentTimeMillis()+".png"));            
		} catch (IOException e)

		{
		  System.out.println(e.getMessage());
		 }
		  }


}
