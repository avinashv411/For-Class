> Write a Java Program which takes following 
  input arguments via Commond Line in the 
  same order & invoke the “StudentUpsert2” stored
  procedure by passing all these data
	1. Reg No. 
	2. First Name
	3. Middle Name
	4. Last Name
	5. Guardian First Name 
	6. Guardian Middle Name 
	7. Guardian Last Name 
	8. isadmin & 
	9. Password


	
	
	
	
	
	
	
	
package com.jspiders.jdbc.common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentProfileCreationExample 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		CallableStatement cstmt = null;
		
		try 
		{
			//1. Load the Driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//2. Get the DB Connection via Driver 
			String dbUrl = "jdbc:mysql://localhost:3306/BECM4_DB?user=j2ee&password=j2ee";
			con = DriverManager.getConnection(dbUrl);
			
			//3. Issue SQL Queries via Connection 
			String query = "call studentUpSert2(?,?,?,?,?,?,?,?,?)";
			cstmt = con.prepareCall(query);
			cstmt.setInt(1, Integer.parseInt(args[0]) );
			cstmt.setString(2, args[1]);
			cstmt.setString(3, args[2]);
			cstmt.setString(4, args[3]);
			cstmt.setString(5, args[4]);
			cstmt.setString(6, args[5]);
			cstmt.setString(7, args[6]);
			cstmt.setString(8, args[7]);
			cstmt.setString(9, args[8]);
			int count = cstmt.executeUpdate();
			
			//4. Process the Results returned by SQL Queries
			System.out.println("Successfully Created the Profile ...");
			
		} catch (Exception e) {
			System.err.println("Unable to Create the Profile !!!");
			e.printStackTrace();
		} finally{
			//5. Close All JDBC Objects
			try 
			{
				if(con!=null){
					con.close();
				}
				if(cstmt!=null){
					cstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//End of outer try-catch
	}//End of main
}//End of Class
