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
import com.magazineapp.repository.YearRepo;
import com.magazineapp.service.NotificationService;
import com.magazineapp.service.SubmissionPersistService;
import org.apache.commons.lang.math.NumberUtils;

@WebServlet("/upload-submission")
@MultipartConfig
public class SubmissionUploadServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (!canSubmit())
        {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        int  submissionId = NumberUtils.toInt(request.getParameter("id"));
        Part filePart     = request.getPart("myfile");
        User author       = (User) request.getSession().getAttribute("user");

        try
        {
            Submission submission = SubmissionPersistService.Save(submissionId, filePart, author);

            NotificationService.ScheduleFor(submission, request);
            response.sendRedirect("viewSubmission.jsp");            
        } catch (IOException e)
        {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    private boolean canSubmit()
    {
        Year currentYear = new YearRepo().getCurrentYear();
        if (currentYear == null) return true;//temp fix until implemented

        Date now = new Date();

        return !now.after(currentYear.get_entry_ClosureDate());
    }
}
