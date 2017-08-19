package com.mycompany.studentapps;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.jdbc.Connection;

public class SearchRegno extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String searchval=req.getParameter("Regno");
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		try
		{
			// load the driver 
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//get connecton 
			String dbUrl="jdbc:mysql://localhost:3306/mydb";
			String filePath="C:\\Users\\Mahesh\\Desktop\\db.properties";
			FileReader reader =new FileReader(filePath);
			Properties prop=new Properties();
			prop.load(reader);
			con=DriverManager.getConnection(dbUrl, prop);
			
			// issue query
			String query="select students_info.Regno,"
					+ " FirstName,MiddleName,LastName,GFirstName,"
					+ " GMiddleName,GLastName,isAdmin,password "
					+ " from students_info,guardian_info,students_otherinfo "
					+ "	where students_info.Regno=? and guardian_info.Regno=? "
					+ " and students_otherinfo.Regno=?;";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(searchval));
			pstmt.setInt(2, Integer.parseInt(searchval));
			pstmt.setInt(3, Integer.parseInt(searchval));
			rs=pstmt.executeQuery();
			out.println("<html><body>");
			out.println("<center>");
			out.println("<table BORDER=1 CELLPADDING=1 CELLSPACING=2 WIDTH=50% >");
			out.println("<tr><td>");
			
			out.println("<font color=\"red\"><b>");
			out.println("Regno");
			out.println("</b></td>");
			
			out.println("<td><font color=\"red\"><b>");
			out.println("First Name");
			out.println("</b></td>");
			
			out.println("<td><font color=\"red\"><b>");
			out.println("Middle Name");
			out.println("</b></td>");
			
			out.println("<td><font color=\"red\"><b>");
			out.println("Last Name");
			out.println("</b></td>");
			
			out.println("<td><font color=\"red\"><b>");
			out.println("GFirst Name");
			out.println("</b></td>");
			
			out.println("<td><font color=\"red\"><b>");
			out.println("GMiddlet Name");
			out.println("</b></td>");
			
			out.println("<td><font color=\"red\"><b>");
			out.println("GLast Name");
			out.println("</b></td>");
			
			out.println("<td><font color=\"red\"><b>");
			out.println("is Admin");
			out.println("</b></td>");			

			out.println("<td><font color=\"red\"><b>");
			out.println("Password");
			out.println("</b></td>");
			out.println("</tr>");

			if(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString("Regno")+"</td>");
				out.println("<td>"+rs.getString("FirstName")+"</td>");
				out.println("<td>"+rs.getString("MiddleName")+"</td>");
				out.println("<td>"+rs.getString("LastName")+"</td>");
				out.println("<td>"+rs.getString("GFirstName")+"</td>");
				out.println("<td>"+rs.getString("GMiddleName")+"</td>");
				out.println("<td>"+rs.getString("GLastName")+"</td>");
				out.println("<td>"+rs.getString("isAdmin")+"</td>");
				out.println("<td>"+rs.getString("password")+"</td>");
				out.println("</tr>");
			}
			else
			{
				out.println("something went wrong");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			out.println("</table>");
			out.println("<center>");
			out.println("</body></html>");
			try {
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
