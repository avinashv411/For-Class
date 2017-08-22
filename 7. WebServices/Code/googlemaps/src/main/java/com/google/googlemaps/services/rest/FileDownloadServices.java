package com.google.googlemaps.services.rest;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/file/download")
public class FileDownloadServices {

	/*
	 * @Produces("text/plain"): for downloading text file.
	 * 
	 * @Produces("image/png"): for downloading png image file.
	 * 
	 * @Produces("application/pdf"): for downloading PDF file.
	 * 
	 * @Produces("application/vnd.ms-excel"): for downloading excel file.
	 * 
	 * @Produces("application/msword"): for downloading ms word file.
	 */

	@GET
	@Path("/image")
	@Produces("image/png")
	public Response getImageFile() {
		File file = new File("c:\\abc.png");
		ResponseBuilder response = Response.ok((Object) file);
		// response.header("Content-Disposition", "attachment;
		// filename=\"xyz.png\"");
		// response.header("Content-Disposition", "inline");
		return response.build();

	}

	@GET
	@Path("/pdf")
	@Produces("application/pdf")
	public Response getPdfFile() {
		File file = new File("c:\\abc.pdf");
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"javatpoint_pdf.pdf\"");
		return response.build();
	}

	@GET
	@Path("/txt")
	@Produces("text/plain")
	public Response getTxtFile() {
		File file = new File("c:\\abc.txt");

		ResponseBuilder response = Response.ok((Object) file);
		return response.build();

	}

}
