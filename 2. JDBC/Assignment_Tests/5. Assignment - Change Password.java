> Write a Java Program which accepts following 
  input arguments in the same order 
  1. Reg No. 
  2. Current Password
  3. New Password
  
> This Program first check whether Reg No. & 
  Current Password is matching
  
> If NO, then print the "Error Message" 
  in Console
  
> If YES, then print the "Success Message" in
  Console along with updating the password for 
  that Reg No.


  
  
  



update students_otherinfo
set password = ?
where regno = ?
and password = ?






package com.jspiders.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangePasswordExample 
{
	public static void main(String[] args) 
	{
		String regNum = args[0];
		String currentPass = args[1];
		String newPass = args[2];
			
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try 
		{
			//1. Load the Driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//2. Get the DB Connection via Driver 
			String dbUrl = "jdbc:mysql://localhost:3306/BECM4_DB?user=j2ee&password=j2ee";
			con = DriverManager.getConnection(dbUrl);
			
			//3. Issue SQL Queries via Connection 
			String query = " update students_otherinfo " 
							+" set password = ? " 
							+" where regno = ? " 
							+" and password = ? ";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newPass);
			pstmt.setInt(2, Integer.parseInt(regNum) );
			pstmt.setString(3, currentPass);
			
			int count = pstmt.executeUpdate();
			
			//4. Process the Results returned by SQL Queries
			if(count>0)
			{
				System.out.println("Password Change Successful");
			}else{
				System.err.println("Invalid Reg. No. / Password");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//5. Close All JDBC Objects
			try 
			{
				if(con!=null){
					con.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//End of outer try-catch block
	}//End of Main
}//End of Class
