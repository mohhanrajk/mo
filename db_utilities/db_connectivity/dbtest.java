package db_connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;


public class dbtest 
{
	public static Connection conMios;

	// MIOSDVT1
	public static String connectionMiosUrlStr = "jdbc:mysql://localhost/payroll_demo";
	public static String userNameMios = "root";
	public static String passwordMios = "";
	
		public String queryMiosOTB3;

	//public Object rsMios;

	
	public static void loadjdbc() throws SQLException
	{
		// Load oracle jdbc driver
					try {
						Class.forName("com.mysql.jdbc.Driver"); // For Oracle
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
	}
	
	

		public static ArrayList<String> room() throws SQLException
		{
					
			String queryMiosOTB = "SELECT comp_code, comp_name, comp_email, comp_phone1, comp_status FROM pay_company WHERE comp_status=1 ORDER BY comp_id DESC;";
			System.out.println("query is:" +queryMiosOTB);
			String roomcolltion = null;
		
		
				
			conMios = DriverManager.getConnection(connectionMiosUrlStr, userNameMios, "");
					
			
			// Create Statement Object
			Statement stmtMios = conMios.createStatement();
				
			// Execute the SQL Query. Store results in ResultSet
			ResultSet rsMios = stmtMios.executeQuery(queryMiosOTB);

			//int recSize = rsMios.getFechSize();
			int recSize = rsMios.getFetchSize(); 
			System.out.println("recsize :" +recSize);
			//System.out.println("---------------------------------------------------");
				
			ArrayList<String> list= new ArrayList<String>();
		 	
			
			// While Loop to iterate through all data and print results
			while (rsMios.next())
			{
				
				//String t = rsMios.getString(1)+" ,"+rsMios.getString(2)+" ,"+rsMios.getString(3)+" ,"+rsMios.getString(4)+","+rsMios.getString(5)+","+"\n";
				//list.add(t);
				
			   /* if(rsMios.getString(1)!=null){                                
			        list.add(rsMios.getString(1));
			       }
			    else if(rsMios.getString(2)!=null){
			    	 list.add(rsMios.getString(2));
			    }else if(rsMios.getString(3)!=null){
			    	list.add(rsMios.getString(3));
			    }else if(rsMios.getString(4)!=null){
			    	list.add(rsMios.getString(4));
			   */ 		    
			 

				
				
				
				list.add(rsMios.getString(1));
				 list.add(rsMios.getString(2));
				 list.add(rsMios.getString(3));
				 list.add(rsMios.getString(4));
				 list.add(rsMios.getString(5));
				//System.out.println("Appl_rem_dem_val value in db : " + list);
		}
				
			return list;
				
			}
	
			
}