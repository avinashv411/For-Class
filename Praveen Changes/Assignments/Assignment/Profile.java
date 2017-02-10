package com.mycompany.studentapps;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.jdbc.Connection;  
// Type mismatch: cannot convert from java.sql.Connection to com.mysql.jdbc.Connection

public class Profile extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String Regnoval=req.getParameter("Regno");
		String Fnmval=req.getParameter("FristName");
		String Mnmval=req.getParameter("MiddleName");
		String Lnmval=req.getParameter("LastName");
		String GFnmval=req.getParameter("GuardianFNM");
		String GMnmval=req.getParameter("GuardianMNM");
		String GLnmval=req.getParameter("GuardianLNM");
		String isadminval=req.getParameter("isAdmin");
		String passval=req.getParameter("pass");
		
		
		Connection con=null;
		CallableStatement cstmt=null;
		try
		{
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			// load the driver
			out.println("loading Driver");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			// get the connection 
		
			out.println("getting connection");
			String dburl="jdbc:mysql://localhost:3306/mydb";
			String filePath="C:\\Users\\Mahesh\\Desktop\\db.properties";
			FileReader reader=new FileReader(filePath);
			Properties prop=new Properties();
			prop.load(reader);
			con=DriverManager.getConnection(dburl, prop);
			
			// issue sql query
			out.println("issuing sql query ");
			String query="call studentupsert2(?,?,?,?,?,?,?,?,?);";
			cstmt=con.prepareCall(query);
			out.println("setting values");
			cstmt.setInt(1, Integer.parseInt(Regnoval));
			cstmt.setString(2, Fnmval);
			cstmt.setString(3, Mnmval);
			cstmt.setString(4, Lnmval);
			cstmt.setString(5, GFnmval);
			cstmt.setString(6, GMnmval);
			cstmt.setString(7, GLnmval);
			cstmt.setString(8, isadminval);
			cstmt.setString(9, passval);
			int count=cstmt.executeUpdate();
			out.println("success");
			
			
			out.println(count);
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}finally
		{
			try {
				if(con!=null)
				{
					con.close();
				}
				if(cstmt!=null)
				{
					cstmt.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
