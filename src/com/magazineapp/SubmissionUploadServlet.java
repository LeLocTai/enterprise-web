package com.magazineapp;

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
import com.magazineapp.service.NotificationService;
import com.magazineapp.service.SubmissionSubmitService;
import org.apache.commons.lang.math.NumberUtils;

@WebServlet("/upload-submission")
@MultipartConfig
public class SubmissionUploadServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int submissionId = NumberUtils.toInt(request.getParameter("id"));
        if (!SubmissionSubmitService.canSubmit(submissionId))
        {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        Part filePart = request.getPart("myfile");
        User author   = (User) request.getSession().getAttribute("user");

        try
        {
            Submission submission = SubmissionSubmitService.Save(submissionId, filePart, author);

            NotificationService.ScheduleFor(submission, request);
            response.sendRedirect("viewSubmission.jsp");
        } catch (IOException e)
        {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
