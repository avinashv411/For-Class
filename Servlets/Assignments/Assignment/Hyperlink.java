//praveen4students@gmail.com
package com.mycompany.studentapps;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hyperlink extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
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
						String query="select students_info.Regno,FirstName,MiddleName,"
								+ " LastName,GFirstName,GMiddleName,GLastName,isAdmin,"
								+ " password from students_info,guardian_info,"
								+ " students_otherinfo "
								+ " where students_info.Regno=guardian_info.Regno and "
								+ " students_otherinfo.Regno=students_info.Regno ";
						stmt=con.createStatement();
						rs=stmt.executeQuery(query);
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
						while(rs.next())
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
						


			
		}
		catch(Exception e)
		{
			
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
				if(stmt!=null)
				{
					stmt.close();
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
