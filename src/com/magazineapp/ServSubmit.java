package com.magazineapp;

import java.io.File;
import java.nio.file.*;
import java.util.Date;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.magazineapp.model.Submission;
import com.magazineapp.repository.DatabaseHelper;
import com.magazineapp.repository.SubmissionRepo;

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
public class ServSubmit extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Part        filePart    = request.getPart("myfile");
        String      fileName    = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();


        String uploadRootPath = System.getenv("UPLOAD_ROOT");
        if (uploadRootPath == null) uploadRootPath = "C:/files";

        File uploadRoot = new File(uploadRootPath);
        if (!uploadRoot.exists()) uploadRoot.mkdirs();

        Path filePath = Paths.get(uploadRootPath, fileName);

        Files.copy(fileContent, filePath);

        Submission s = new Submission(
                filePath.toString(),
                new Date(),
                false,
                "",
                false,
                DatabaseHelper.getTestStudent(),
                DatabaseHelper.getTestYear()
        );

        s.set_path(filePath.toString());

        new SubmissionRepo().add(s);
        
        response.sendRedirect("viewSubmission.jsp");
    }

}
