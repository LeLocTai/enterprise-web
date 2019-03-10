package com.magazineapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class ServSubmit
 */
@WebServlet("/ServSubmit")
public class ServSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
	List<FileItem> multifiles = sf.parseRequest(request)st
		
	}

}
