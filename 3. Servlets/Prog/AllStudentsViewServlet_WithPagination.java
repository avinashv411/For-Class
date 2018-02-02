package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllStudentsViewServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, 
						 HttpServletResponse resp)
	throws ServletException, IOException 
	{
		//Get the Query String Info
		String nextRegNoVal = req.getParameter("nextRegNo");
		int fromRegNo = 0;
		int toRegNo = 0;
		int rows = 4;
		
		if(nextRegNoVal==null){
			fromRegNo=1;
			toRegNo=5;
		}else{
			fromRegNo=Integer.parseInt(nextRegNoVal);
			toRegNo=fromRegNo+rows;
		}
		// Interact with DB to get the data
	    Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer("");
		
		
		try 
		{
			//1. Load the Driver
			//Driver Class : com.mysql.jdbc.Driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//2. Get the DB Connection via Driver 
			String dbUrl = "jdbc:mysql://localhost:3306/studentsapp_db?user=j2ee&password=j2ee";
			con = DriverManager.getConnection(dbUrl);
			
			//3. Issue SQL Queries via Connection 
			String query = " select * from "
					  	  +" students_info si, "
					  	  +" guardian_info gi "
					  	  +" where si.regno = gi.regno "
					  	  +" and si.regno between ? and ? ";
			
			System.out.println("Query : "+query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, fromRegNo);
			pstmt.setInt(2, toRegNo);
			rs = pstmt.executeQuery();
			
			//4. Process the Results returned by SQL Queries
			sb.append("<html> ");
			sb.append("<body> ");
			sb.append("<table>");
			sb.append("<tr bgcolor=\"green\">");
			sb.append("<td>Reg. No.</td>     ");
			sb.append("<td>First Name</td>   ");
			sb.append("<td>Middle Name</td>  ");
			sb.append("<td>Last Name</td>    ");
			sb.append("<td>G First Name</td> ");
			sb.append("<td>G Middle Name</td>");
			sb.append("<td>G Last Name</td>  ");
			sb.append("</tr>");
			
			while(rs.next())
			{
				String url = "http://localhost:8080/studentsApp/studentSearch?regno="+rs.getInt("si.regno");
				
				sb.append("<tr> ");
				sb.append("<td><a href=\""+url+"\">"+rs.getInt("si.regno")+"</a></td>  ");
				sb.append("<td>"+rs.getString("si.firstname")+"</td>");
				sb.append("<td>"+rs.getString("si.middlename")+"</td> ");
				sb.append("<td>"+rs.getString("si.lastname")+"</td>");
				sb.append("<td>"+rs.getString("gi.gfirstname")+"</td>");
				sb.append("<td>"+rs.getString("gi.gmiddlename")+"</td> ");
				sb.append("<td>"+rs.getString("gi.glastname")+"</td>");
				sb.append("</tr>");
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
				if(rs!=null){
					rs.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//End of outer try-catch block
		
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		
		sb.append("<BR><BR>");
		String nextUrl = "http://localhost:8080/studentsApp/allStudentsView?nextRegNo="+(toRegNo+1);
		sb.append("<a href=\""+nextUrl+"\"> Next >> </a>");
		
		//Send the response to Browser
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println(sb.toString());
	    
	}//End of doGet
}//End of Class





