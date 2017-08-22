package com.google.googlemaps.services.rest;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/files")  
public class FileDownloadService 
{
	private static final String TXT_FILE_PATH = "C:\\rest\\textfile.txt";  
	private static final String IMG_FILE_PATH = "c:\\rest\\myimage.png";  
	private static final String PDF_FILE_PATH = "c:\\rest\\mypdf.pdf";  
	
    @GET  
    @Path("/txt")  
    @Produces("text/plain")  
    public Response getTextFile() {  
    	Object obj = new File(TXT_FILE_PATH);  
//    	Object obj = new File(IMG_FILE_PATH); 
//    	Object obj = new File(PDF_FILE_PATH); 
    	
        ResponseBuilder response = Response.ok(obj);  
        response.header("Content-Disposition","attachment; filename=\"text_file_response.txt\"");
//        response.header("Content-Disposition","attachment; filename=\"javatpoint_image.png\"");
//        response.header("Content-Disposition","attachment; filename=\"javatpoint_pdf.pdf\"");  
        return response.build();  
    } 
    
}//End of Class
