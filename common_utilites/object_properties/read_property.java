package object_properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class read_property
{
  public static String readtext(String path, String t)
  {

	Properties prop = new Properties();
	InputStream input = null;

	try {

		input = new FileInputStream(path);

		// load a properties file
		prop.load(input);

		// get the property value and print it out
		 String g = prop.getProperty(t);
		
		 return g;
		
		
	}
	
	catch (IOException ex) {
		ex.printStackTrace();
		return null;
	} 
	finally 
	{
		if (input != null) {
			try {
				input.close();
				} 
				catch (IOException e) 
				{
				e.printStackTrace();
				}
		}
		
	}
	
  }
  
}