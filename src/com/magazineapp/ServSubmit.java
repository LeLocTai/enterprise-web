package com.magazineapp;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.File;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class ServSubmit
 */
@WebServlet("/ServSubmit") 
public class ServSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try {
		
	
	ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
	List<FileItem> multifiles = sf.parseRequest((RequestContext) request);
	
	for (FileItem item: multifiles) {
		item.write(new File("C:\\Users\\McSholla Olamide\\Documents\\GitHub"+item.getName()));
	}
	}catch(Exception e)
	{
		System.out.println(e);
	}
	System.out.println("File Uploaded");
	}

}
