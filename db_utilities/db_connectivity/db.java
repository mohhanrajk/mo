package db_connectivity;

import java.sql.*;  
class MysqlCon
{  
public static void main(String[] args)
{  
	    try
	    	{  
	
		    	Class.forName("com.mysql.jdbc.Driver");  
			    Connection con=DriverManager.getConnection("localhost","root","");  

			    Statement stmt=con.createStatement();  
			    ResultSet rs=stmt.executeQuery("SELECT * FROM payroll_demo.pay_company ORDER BY comp_id ASC");  
			    
			    while(rs.next())  
			    {
			    	System.out.println(rs.getString("comp_code"));  
			    }
			    
	    	}
	  
	    catch(Exception e)
	    	{ 
	    		System.out.println(e);
	    	}  
}  
   
}