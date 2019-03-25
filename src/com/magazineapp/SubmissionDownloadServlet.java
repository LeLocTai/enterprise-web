package com.magazineapp;

import com.magazineapp.model.Submission;
import com.magazineapp.model.User;
import com.magazineapp.repository.SubmissionRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/download-submission/*")
public class SubmissionDownloadServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException
    {
        String submissionIdString = request.getPathInfo().substring(1);
        int    submissionId;
        try
        {
            submissionId = Integer.parseInt(submissionIdString);
        } catch (NumberFormatException e)
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

        File file = new File(submission.get_path());

        response.setContentType("application/force-download");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

        copyBuffered(
                new FileInputStream(file),
                response.getOutputStream(),
                new byte[1024 * 4]
        );
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

    private void copyBuffered(InputStream from, OutputStream to, byte[] buffer) throws IOException
    {
        int nextLength;
        while ((nextLength = from.read(buffer)) > 0)
        {
            to.write(buffer, 0, nextLength);
        }

        from.close();
        to.flush();
    }
}
