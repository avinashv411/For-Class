package com.mycompany.studentapps;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.jdbc.PreparedStatement;

public class ChangePassword extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String regnoval=req.getParameter("Regno");
		String curpassval=req.getParameter("currentpass");
		String newpassval=req.getParameter("newpass");
		String retrypassval=req.getParameter("retry");
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		if(newpassval.equals(retrypassval))
		{
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
				
				//issue sql query
				String query="update students_otherinfo set "
						+ " password=? where Regno=? and password=?; ";
				pstmt=con.prepareStatement(query);
				pstmt.setString(1, newpassval);
				pstmt.setInt(2, Integer.parseInt(regnoval));
				pstmt.setString(3, curpassval);
				int count =pstmt.executeUpdate();
				if(count>0)
				{
					out.println("updated successfully ...");
				}
				else
				{
					out.println("unsuccessful!!!!!!");
				}
			}catch(Exception e)
			{
				
			}finally
			{
				try {
					if(con!=null)
					{
						con.close();
					}
					if(pstmt!=null)
					{
						pstmt.close();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		else
		{
			out.println("password dosen't match... ");
		}
		
		
	}

}
