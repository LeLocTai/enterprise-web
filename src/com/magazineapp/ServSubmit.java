package com.magazineapp;

import java.io.File;
import java.nio.file.*;
import java.time.Instant;
import java.util.Date;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.magazineapp.model.Submission;
import com.magazineapp.model.User;
import com.magazineapp.repository.DatabaseHelper;
import com.magazineapp.repository.SubmissionRepo;
import com.magazineapp.service.NotificationService;

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
        Part   filePart     = request.getPart("myfile");
        String userFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

        User author = DatabaseHelper.getTestStudent();

        Path fullFilePath = getOrCreateFullPath(
                System.getenv("UPLOAD_ROOT"),
                getUniqueName(userFileName, author)
        );

        Files.copy(filePart.getInputStream(), fullFilePath);

        Submission submission = new Submission(
                fullFilePath.toString(),
                new Date(),
                false,
                "",
                false,
                author,
                DatabaseHelper.getTestYear()
        );

        new SubmissionRepo().add(submission);

        new NotificationService(submission, request).scheduleEmail();

        response.sendRedirect("viewSubmission.jsp");
    }

    private Path getOrCreateFullPath(String uri, String fileName)
    {
        if (uri == null) uri = "C:/files";

        File uploadRoot = new File(uri);
        if (!uploadRoot.exists()) uploadRoot.mkdirs();

        return Paths.get(uri, fileName);
    }

    private String getUniqueName(String baseName, User author)
    {
        return String.join(".",
                           String.valueOf(author.get_id()),
                           String.valueOf(Instant.now().toEpochMilli()),
                           baseName);
    }
}
