package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculator extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.print("<html>");
		out.print("<body>");

		int fromDate = Integer.parseInt(req.getParameter("fromDate"));
		int fromMonth = Integer.parseInt(req.getParameter("fromMonth"));
		int fromYear = Integer.parseInt(req.getParameter("fromYear"));

		int toDate = Integer.parseInt(req.getParameter("toDate"));
		int toMonth = Integer.parseInt(req.getParameter("toMonth"));
		int toYear = Integer.parseInt(req.getParameter("toYear"));

		int[] ordYear = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] leapYear = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int years = 0, months = 0, days = 0;

		if (fromYear > toYear || (fromYear == toYear && fromMonth > toMonth)
				|| (fromYear == toYear && fromMonth == toMonth && fromDate > toDate)) {
			out.print("<h1 style=\"color:red;\">Date of birth needs to be earlier than the age at date</h1>");
		} else {

			// Get difference between years
			years = toYear - fromYear;

			// Get difference between months
			months = toMonth - fromMonth;

			// if month difference is in negative then reduce years by one and calculate the
			// number of months.
			if (months < 0) {
				years--;
				months = 12 - fromMonth + toMonth;
				if (toDate < fromDate)
					months--;
			} else if (months == 0 && toDate < fromDate) {
				years--;
				months = 11;
			} else if (months > 0 && toDate < fromDate) {
				months--;
			}

			// Calculating days
			if (isPrime(toYear) && toDate != fromDate) {
				if (toDate > fromDate) {
					days = toDate - fromDate;
				} else {
					if (toMonth > 1) {
						days = leapYear[toMonth - 1] - fromDate + toDate;
					} else {
						days = 31 - fromDate + toDate;// December month of previous year
					}

				}
			} else if (toDate != fromDate) {
				if (toDate > fromDate) {
					days = toDate - fromDate;
				} else if (fromMonth == 2 && fromDate == 29 && toMonth == 3) {
					days = toDate;// if from year is leap & fromMonth is feb & fromDate is 29
				} else {
					if (toMonth > 1) {
						days = ordYear[toMonth - 1] - fromDate + toDate;
					} else {
						days = 31 - fromDate + toDate;// December month of previous year
					}

				}

			}

			out.print(years + " YEARS and " + months + " MONTHS and " + days + " DAYS");

			out.print("<br><br>" + " OR ");
			out.print(years * 12 + months + " MONTHS and " + days + " DAYS");

			// Calculating weeks ,days,hours,seconds
			SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");

			try {
				Date from = myFormat.parse(fromDate + "/" + fromMonth + "/" + fromYear);
				Date to = myFormat.parse(toDate + "/" + toMonth + "/" + toYear);

				long timeInMilli = to.getTime() - from.getTime();
				int totalDays = (int) (timeInMilli / (1000 * 60 * 60 * 24));

				out.print("<br><br>" + " OR ");
				out.println(totalDays / 7 + " WEEKS and " + totalDays % 7 + " DAYS");

				out.print("<br><br>" + " OR ");
				out.println(totalDays + " DAYS");

				out.print("<br><br>" + " OR ");
				out.println(totalDays * 24 + " HOURS");

				out.print("<br><br>" + " OR ");
				out.println(totalDays * 24 * 60 + " MINUTESS");

				out.print("<br><br>" + " OR ");
				out.println(timeInMilli / 1000 + " SECONDS");

				out.print("<br><br>");
				out.print("<br><br>");

			} catch (ParseException e) {

				e.printStackTrace();
			}
		} // End of Main-If-Else

		RequestDispatcher dispatcher = req.getRequestDispatcher("AgeCalculator.html");
		dispatcher.include(req, resp);

		out.print("</body>");
		out.print("</html>");

	}// End of doGet

	// Method to check whether year is leap or not
	private boolean isPrime(int year) {
		if (year % 4 != 0) {
			return false;
		} else if (year % 100 == 0 && year % 400 != 0) {
			return false;
		} else {
			return true;
		}
	}// End of isPrime()

}// End of Class
