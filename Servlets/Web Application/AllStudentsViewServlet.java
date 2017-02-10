package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.studentsapp.dao.StudentInfoBean;

public class AllStudentsViewServlet extends HttpServlet 
{
	RequestDispatcher dispatcher = null;
	
	@Override
	protected void doGet(HttpServletRequest req, 
						HttpServletResponse resp)
	throws ServletException, IOException 
	{
		resp.setContentType("text/html");
	    PrintWriter out = resp.getWriter();
	    
		dispatcher = req.getRequestDispatcher("Header.html");
	    dispatcher.include(req, resp);
	    List<StudentInfoBean> dataList 
	    	= (List<StudentInfoBean>)req.getAttribute("data");
	    
	    out.println("<html> ");
		out.println("<body> ");
		out.println("<table>");
		out.println("<tr bgcolor=\"orange\">");
		out.println("<td>Reg. No.</td>     ");
		out.println("<td>First Name</td>   ");
		out.println("<td>Middle Name</td>  ");
		out.println("<td>Last Name</td>    ");
		out.println("<td>G First Name</td> ");
		out.println("<td>G Middle Name</td>");
		out.println("<td>G Last Name</td>  ");
		out.println("</tr>");
		
		for(StudentInfoBean data : dataList)
		{
			out.println("<tr> ");
			out.println("<td>"+data.getRegno()+"</td>  ");
			out.println("<td>"+data.getFirstNM()+"</td>");
			out.println("<td>"+data.getMiddleNM()+"</td> ");
			out.println("<td>"+data.getLastNM()+"</td>");
			out.println("<td>"+data.getgFirstNM()+"</td>");
			out.println("<td>"+data.getgMiddleNM()+"</td> ");
			out.println("<td>"+data.getgLastNM()+"</td>");
			out.println("</tr>       ");
		}
		out.println("</table>    ");
		out.println("</body>     ");
		out.println("</html>     ");
	    
	    dispatcher = req.getRequestDispatcher("Footer.html");
	    dispatcher.include(req, resp);
	}//End of doGet
}//End of Class





