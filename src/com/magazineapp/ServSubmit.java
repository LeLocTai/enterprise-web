package com.magazineapp;

import java.io.File;
import java.nio.file.*;
import java.util.Date;
import java.time.Instant;
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
import com.magazineapp.model.Year;
import com.magazineapp.repository.DatabaseHelper;
import com.magazineapp.repository.SubmissionRepo;
import com.magazineapp.repository.YearRepo;
import com.magazineapp.service.NotificationService;

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
        if (!canSubmit()) return;
        
        Part   filePart          = request.getPart("myfile");
        String submittedFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

        User author = DatabaseHelper.getTestStudent();

        Path fullFilePath = getOrCreateFullPath(getUniqueName(submittedFileName, author));

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

        NotificationService.ScheduleFor(submission, request);

        response.sendRedirect("viewSubmission.jsp");
    }

    private boolean canSubmit()
    {
        Year currentYear = new YearRepo().getCurrentYear();
        if(currentYear == null) return true;//temp fix until implemented
        
        Date now         = new Date();
        
        return !now.after(currentYear.get_entry_ClosureDate());
    }

    private Path getOrCreateFullPath(String fileName)
    {
        String uri = System.getenv("UPLOAD_ROOT");
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
