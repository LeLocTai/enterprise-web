package com.magazineapp;

import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Submission;
import repository.DatabaseHelper;
import repository.SubmissionRepo;

//import org.apache.tomcat.jni.File;
//import org.apache.tomcat.util.http.fileupload.FileItem;
//import org.apache.tomcat.util.http.fileupload.RequestContext;
//import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
//import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class ServSubmit
 */
@WebServlet("/ServSubmit") 
@MultipartConfig
public class ServSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//	try {
//		
//	
//	ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
//	List<FileItem> multifiles = sf.parseRequest((RequestContext) request);
//	
//	for (FileItem item: multifiles) {
//		//item.write(new File("C:\\Users\\McSholla Olamide\\Documents\\GitHub"+item.getName()));
//		
//	}
//	}catch(Exception e)
//	{
//		System.out.println(e);
//	}
//	System.out.println("File Uploaded");
		
		//String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
	    Part filePart = request.getPart("myfile"); // Retrieves <input type="file" name="file">
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    InputStream fileContent = filePart.getInputStream();

	    
	    Path path = Paths.get("C:\\files" + fileName);
	    
	    Files.copy(fileContent, path);
	    
	    Submission s = new Submission(
	    			path.toString(),
	    			new Date(),
	    			false,
	    			"",
	    			false,
	    			DatabaseHelper.getTestStudent(),
	    			DatabaseHelper.getTestYear()
	    		);
	    
	    s.set_path(path.toString());
	    
	    new SubmissionRepo().add(s);
	}

}
