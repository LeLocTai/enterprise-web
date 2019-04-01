package com.magazineapp;

import com.magazineapp.model.Submission;
import com.magazineapp.model.User;
import com.magazineapp.repository.SubmissionRepo;
import com.magazineapp.service.HttpResponseService;
import org.apache.commons.lang.math.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/download-submission")
public class SubmissionDownloadServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException
    {
        String submissionIdString = request.getParameter("id");
        int    submissionId       = NumberUtils.toInt(submissionIdString);
        if (submissionId == 0)
        {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Submission submission = new SubmissionRepo().get(submissionId);
        if (submission == null) return;

        User authUser = (User) request.getSession().getAttribute("user");
        if (!isAuthorized(submission, authUser))
        {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        File submissionFile = new File(submission.get_path());

        HttpResponseService.ForceDownload(response, submissionFile);
    }

    private boolean isAuthorized(Submission submission, User authUser)
    {
        if (authUser == null)
            return false;

        if (authUser.get_role().equalsIgnoreCase("manager") ||
            authUser.get_role().equalsIgnoreCase("coordinator"))
            return true;

        if (submission.get_author().get_id() == authUser.get_id())
            return true;

        return false;
    }
}
