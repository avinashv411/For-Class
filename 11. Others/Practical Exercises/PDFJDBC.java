package com.japiders;

import java.io.*;
import java.util.*;
import java.util.Date;
import java.sql.*; 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
public class PDFJDBC {  
        public static void main(String[] args) throws Exception{
                
                /* Create Connection objects */
                Class.forName ("com.mysql.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/becm3?user=root&password=root");
                Statement stmt = conn.createStatement();
                /* Define the SQL query */
                ResultSet rs = stmt.executeQuery("SELECT * from student_info");
                /* Step-2: Initialize PDF documents - logical objects */
                Document my_pdf_report = new Document();
                PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report_from_sql_using_java.pdf"));
                my_pdf_report.open();            
                //we have four columns in our table
                PdfPTable my_report_table = new PdfPTable(4);
                //create a cell object
                PdfPCell table_cell;
               
    			my_pdf_report.add(new Paragraph(new Date().toString()));

                while (rs.next()) {                
                                String regno = rs.getString("regno");
                                table_cell=new PdfPCell(new Phrase(regno));
                                my_report_table.addCell(table_cell);
                                String firstname=rs.getString("firstname");
                                table_cell=new PdfPCell(new Phrase(firstname));
                                my_report_table.addCell(table_cell);
                                String middlename=rs.getString("middlename");
                                table_cell=new PdfPCell(new Phrase(middlename));
                                my_report_table.addCell(table_cell);
                                String lastname=rs.getString("lastname");
                                table_cell=new PdfPCell(new Phrase(lastname));
                                my_report_table.addCell(table_cell);
                                
                                System.out.println("successfully created pdf file");
                                }
                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);                       
                my_pdf_report.close();
                
                /* Close all DB related objects */
                rs.close();
                stmt.close(); 
                conn.close();               
                
        }
}
