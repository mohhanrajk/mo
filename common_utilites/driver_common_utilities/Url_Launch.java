package driver_common_utilities;

import java.util.concurrent.TimeUnit;

import object_properties.obj_properties_variable_declarations;

public class Url_Launch 
{
	 public static boolean implicitwait(long time)
		 {
			try
			{
				Web_driver.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
				//System.out.println("Waited for "+time+" sec implicitly.");
			}
			catch (Exception e)
			{
				return false;
			}	
			return true;
		}


		public static boolean URL_NAVIGATION(String url)
		{
			try
				{
					Web_driver.driver.get(url);
				}
			
			catch (Exception e)
			{	
				System.out.println("");
				return false;
			}
			return true;
			}
		}

		

	
	
