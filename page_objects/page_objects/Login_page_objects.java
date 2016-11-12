package page_objects;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import other_common_files.element_highligting;
import db_connectivity.dbtest;
import driver_common_utilities.Web_driver;
import driver_common_utilities.common_driver_methods;

public class Login_page_objects extends common_driver_methods
{
    
	//Username field locator
	@FindBy (xpath=".//*[@id='username']")
	private WebElement E_ID;
	
	//password field locator
	@FindBy (xpath=".//*[@id='password']")
	private WebElement E_PWD;
	
	//Submit button locator
	@FindBy (xpath=".//*[@id='submitted']")
	private WebElement login_button;
	
	//Dialog box
	@FindBy (xpath=".//*[@id='ui-dialog-title-dialog_modal']")
	private WebElement dialog_box;
	
	
	//Dialog box
	@FindBy (xpath=".//*[@class='chzn-results']/li")
	private List<WebElement> dropdown_list;
	
	
	//select company click
	@FindBy(xpath=".//*[@id='select_company_chzn']/a/span")
	private WebElement tm;
	
	
	//GO Button in dialog box
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement gobutton;
	
	
	@FindBy(xpath="//*[text()='Logout']")
	private WebElement logout;
	
	
	@FindBy(xpath="//*[text()='IT SLAB Master']")
	private WebElement left_side_Payroll_Master_Link;
	
	@FindBy(xpath="//*[text()='Company Master']")
	private WebElement submenu_Company_master;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr")
	private List<WebElement> test_one;
	
	
	
	public ArrayList<String> db_db() throws SQLException
	{		
		ArrayList<String> t = dbtest.room();
		System.out.println("my db array list :" +t);
		return t;		
	}
	
	
	public int webtable_count()
	{
	
	int row_count = test_one.size();
	return row_count;
	}
	
	
	
	
	public ArrayList<String> ui()
	{
		int row_count = webtable_count();
		System.out.println("System.out.println :" +row_count);
	    ArrayList<String> al = new ArrayList();
		for(int i =1;i<=row_count; i++)
		{
			List<WebElement> finding_column_size = Web_driver.driver.findElements(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td"));
			int row_colummnsize = finding_column_size.size();
			System.out.println("column size is :" +row_colummnsize);
			
			for(int j=1; j<=row_colummnsize; j++)
			{
				WebElement t = Web_driver.driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td["+j+"]"));
			
				element_highligting.highLightElement(t);
				String mg = t.getText();
				if(!mg.equals("Edit"))
				{
				
					al.add(t.getText());
				}
			}
			
			
		}
		System.out.println("values ui list :" +al);
		return al;
	}
	
	
	public void ui_db_comparison() throws SQLException
	{
		
		ArrayList<String> ui_webtab =  ui();
		ArrayList<String> db_ui = db_db();
		int ui_size = ui_webtab.size();
		int DB_size = db_ui.size();
		if(ui_size==DB_size)
		{
			Assert.assertEquals(ui_size, DB_size);
			for(int i=0; i<ui_size-1; i++)
			{
				System.out.println("UI ():" +ui_webtab.get(i));
				System.out.println("DB () :" +db_ui.get(i));
				if(ui_webtab.get(i).equals(db_ui.get(i)))
				{
					System.out.println("values are matched");
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");

				}
				else
				{

					System.out.println("values are not notmatched");
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");

					
				}
			}
			
			
			
		}
		else
		{
			Assert.assertEquals(ui_size, DB_size);

		}
		
		
		System.out.println("UI comparison :" +ui_size);
		System.out.println("DB Comparison :" +DB_size);

			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void left_side_link() throws InterruptedException
	{	Thread.sleep(3000);
		button_click(left_side_Payroll_Master_Link);
		Thread.sleep(3000);;
		button_click(submenu_Company_master);
		Thread.sleep(3000);
			
		
	}
	
	
	
	public void email_text()
	{
		  enter_value_in_box(E_ID, "payroll");
		  System.out.println("I entered value in email box");
	}
	
	
	public void password_text()
	{
		  enter_value_in_box(E_PWD, "payroll");
		  System.out.println("I entered value in password box");
	}
	
	public void login_button_click()
	{
		button_click(login_button);
	}
	
	
	public void find_element_position()
	{
		int x = 1308;
		int y = 40;
		
		element_position(logout, x, y);
		
	}
	
	
	public void select_company_dialogbox_present() throws InterruptedException
	{
		boolean t  = verify_element_present(dialog_box);
		Assert.assertEquals(true, t);
		System.out.println("dialog box has been checked");
		tm.click();
		Thread.sleep(5000);

		drop_down_select(dropdown_list);
		gobutton.click();
		
		Thread.sleep(5000);
		find_element_position();
		
	}
	
	
	
}
