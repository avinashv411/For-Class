package com.jspiders.myjdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPoolClient 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Connection con2 = null;
		Statement stmt = null;
		ResultSet rs = null;
		ConnectionPoolManager pool = null;
		ConnectionPoolManager pool2 = null;
		
		try 
		{
			/*
			 * Step 1 & 2 is not Required
			 * Instead get the Connection From ConnectionPoolManager
			 */
			for(int i=0; i<15; i++)
			{
				pool = ConnectionPoolManager.getInstance();
				con = pool.getConnectionFromPool();
			}
			
			// 3. Issue SQL Queries via Connection
			String query = "select * from students_info;";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			// 4. Process the Results returned by SQL Queries
			while(rs.next())
			{
				int regNum = rs.getInt("regno");
				String fNM = rs.getString("firstname");
				String mNM = rs.getString("middlename");
				String lNM = rs.getString("lastname");
				
				System.out.println("Reg. No. : "+regNum);
				System.out.println("First Name : "+fNM);
				System.out.println("Middle Name : "+mNM);
				System.out.println("Last Name : "+lNM);
				System.out.println("------------------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			// 5. Close ALL JDBC Objects
			try 
			{
				/*
				 * Do not Close Connection Object
				 * Instead return it back to ConnectionPoolManager
				 */
				/*if(con!=null){
					con.close();
				}*/
				for(int i=0; i<15; i++)
				{
					pool.returnConnectionToPool(con);
				}
				
				if(stmt!=null){
					stmt.close();
				}
				if(rs!=null){
					rs.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//End of outer try-catch
	}//End of Main
}//End of Class
