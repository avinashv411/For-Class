package com.japiders;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Driver;

public class PDFWithServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;


 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request, response);
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  //get the output stream for writing binary data in the response.
  ServletOutputStream os = response.getOutputStream();
  //set the response content type to PDF
  response.setContentType("application/pdf"); 
  //create a new document
  Document doc = new Document();

  //create some special styles and font sizes
  Font bfBold18 = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD, new BaseColor(0, 0, 0)); 
  Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC, new BaseColor(0, 0, 0)); 
  Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12); 

  Connection conn = null;             
  PreparedStatement stmt = null;      
  String sql = null;

  try{
   
   //create an instance of the PdfWriter using the output stream
   PdfWriter.getInstance(doc, os); 

   //document header properties
   doc.addAuthor("studentsInfo");
   doc.addCreationDate();
   doc.addProducer();
   doc.addCreator("Students");
   doc.addTitle("StudentsInfo");
   doc.setPageSize(PageSize.LETTER);
   doc.open();

   //add a new paragraph
   
   //1. load the driver
   Driver ref=new Driver();
   DriverManager.registerDriver(ref);
   
   //2. Get the db connection to the MySQL database
   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/becm3?user=root&password=root");

   //3. issue the sql query via connection
   sql = "Select * from student_info"; 
   stmt = conn.prepareStatement(sql);

   ResultSet rs = stmt.executeQuery();  
   //4 process the result returned by the sql query
  
   doc.add( new Paragraph("list of students...", bfBold18));
 
   while(rs.next()){ 
    //start a new page here
    doc.newPage();
    //create a new paragraph for each country
    Paragraph countryParagraph = new Paragraph();
    //create an anchor
    Anchor anchor = new Anchor(rs.getString("firstname"), bfBold18);
    anchor.setName(rs.getString("lastname").trim());
    //add the anchor to the paragraph
    countryParagraph.add(anchor);
    //add the paragraph to the document
    doc.add(countryParagraph);
    
    //add some detail information about the country
    doc.add( new Paragraph("regno is: " + rs.getString("regno").trim(), bf12));
    doc.add( new Paragraph("firstnmae: " + rs.getString("firstname").trim(), bf12));
    doc.add( new Paragraph("middlename: " + rs.getString("middlename").trim(), bf12));
    doc.add( new Paragraph("lastname: " + rs.getString("lastname").trim(), bf12));
   }

   rs.close();                                                                
   stmt.close();                                                              
   stmt = null;                                                               

   conn.close();                                                              
   conn = null;                                                    


   doc.close(); 

  }catch(DocumentException e){
   e.printStackTrace();
  }
  catch(Exception e){
   e.printStackTrace();
  }

 }

}
