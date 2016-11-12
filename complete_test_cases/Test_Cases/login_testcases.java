package Test_Cases;

import java.sql.SQLException;
import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import db_connectivity.dbtest;
import driver_common_utilities.Web_driver;
import page_objects.Login_page_objects;
import read_write_excel_packages.write_result_in_excel;

public class login_testcases
{
	Login_page_objects lg;
	
	
	@BeforeClass
	public void t()
	{
		lg = PageFactory.initElements(Web_driver.driver, Login_page_objects.class);
	}
	
/*		@Test
	public void test() throws SQLException
	{
		ArrayList<String> t = dbtest.room();
		System.out.println("size :" +t.size());
		System.out.println("values :" +t);
	}
*/
	@Test
	public void email_field() throws InterruptedException
	{
		lg.email_text();
		lg.password_text();
		lg.login_button_click();		
	}


	@Test(dependsOnMethods="email_field")
	public void select_dialogbox() throws InterruptedException
	{
		Thread.sleep(10000);
		lg.select_company_dialogbox_present();
	}	
	
	@Test(dependsOnMethods="select_dialogbox")
	public void web_tab() throws InterruptedException, SQLException
	{
		
		lg.left_side_link();
		lg.ui_db_comparison();
		
		
	}
	
	
	
	
}