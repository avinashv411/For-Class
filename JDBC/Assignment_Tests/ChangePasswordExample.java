package com.jspiders.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangePasswordExample 
{
	public static void main(String[] args) 
	{
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
							+" set password = ?" 
							+" where regno = ? " 
							+" and password = ? ";
			
			System.out.println("Query : "+query);
			
			String regno = args[0];
			String currentPassword = args[1];
			String newPassword = args[2];
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, currentPassword);
			pstmt.setInt(2, Integer.parseInt(regno) );
			pstmt.setString(3, newPassword);
			
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
