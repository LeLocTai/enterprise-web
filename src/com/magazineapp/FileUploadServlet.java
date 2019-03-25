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
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (!canSubmit())
        {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "You are not allowed to submit");
            return;
        }

        User   author        = DatabaseHelper.getTestStudent();
        String savedFilePath = saveFile(request.getPart("myfile"), author);
        if (savedFilePath == null)
        {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        Submission submission = saveSubmissionToDB(author, savedFilePath);
        if (submission == null)
        {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        NotificationService.ScheduleFor(submission, request);
        response.sendRedirect("viewSubmission.jsp");
    }

    private boolean canSubmit()
    {
        Year currentYear = new YearRepo().getCurrentYear();
        if (currentYear == null) return true;//temp fix until implemented

        Date now = new Date();

        return !now.after(currentYear.get_entry_ClosureDate());
    }

    private String saveFile(Part filePart, User author) throws IOException
    {
        String submittedFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String fileName          = getUniqueName(submittedFileName, author);
        Path   fullFilePath      = getOrCreateFullPath(fileName);

        Files.copy(filePart.getInputStream(), fullFilePath);

        return fullFilePath.toString();
    }

    private Submission saveSubmissionToDB(User author, String savedFilePath)
    {
        Submission submission = new Submission(
                savedFilePath,
                new Date(),
                false,
                "",
                false,
                author,
                DatabaseHelper.getTestYear()
        );

        int dbRowsAffected = new SubmissionRepo().add(submission);

        return dbRowsAffected < 1 ? null : submission;
    }

    private Path getOrCreateFullPath(String fileName)
    {
        String userHome         = System.getProperty("user.home");
        String uploadFolderName = "magazineApp/upload-root";

        Path uploadRootPath = Paths.get(userHome, uploadFolderName);

        File uploadRoot = new File(uploadRootPath.toUri());
        if (!uploadRoot.exists()) uploadRoot.mkdirs();

        return Paths.get(uploadRootPath.toString(), fileName);
    }

    private String getUniqueName(String baseName, User author)
    {
        return String.join(".",
                           String.valueOf(author.get_id()),
                           String.valueOf(Instant.now().toEpochMilli()),
                           baseName);
    }
}
