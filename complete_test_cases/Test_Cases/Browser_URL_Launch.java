package Test_Cases;

import java.util.Properties;

import object_properties.obj_properties_variable_declarations;
import object_properties.read_property;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page_objects.Login_page_objects;
import read_write_excel_packages.read_excel;
import driver_common_utilities.*;



public class Browser_URL_Launch extends obj_properties_variable_declarations
{
		read_excel re = new read_excel();
		Url_Launch url;
		Login_page_objects lg = new Login_page_objects();
	
		@Test
	    public void Browser_Launch() throws InterruptedException
		{
			//Open the Browser
			Web_driver.browser(read_property.readtext(url_file_name, "browser"));
			
			//Maximize Window
			Web_driver.driver.manage().window().maximize();
			System.out.println("firefox");

			
		}
		
		
		@Test (dependsOnMethods="Browser_Launch")
		public void urllaunch() throws InterruptedException
		{
			boolean expected = true;
			System.out.println("for t :" +url_file_name);
			
			//Pass the url through this following function
			boolean actual = (url.URL_NAVIGATION(read_property.readtext(url_file_name, "main_url")));
			
		// -- Just console printing purpose - in future use for printing output in excel file -- 
			if (actual = true)
			{
				System.out.println("Url Navigated successfully");
			}
			else
			{
				System.out.println("Url failed");
			}
			//-- Just console printing purpose - in future use for printing output in excel file --
			
		}
		
	
	
		
		
		/*@DataProvider(name = "url_launch")
	    public Object[][] createData5() throws Exception
		{
	        Object[][] retObjArr=re.getTableArray("C:/Users/mkali510/workspace/NGIC_ADVISOR_Updated_v3/Read_Write_Excel_Files/read_inputs.xls", "Sheet1", "URL_launch");
	        return(retObjArr);
	       
		}*/
		
		
	}
		
		
		
		
		
		
	
	
	
	
	

