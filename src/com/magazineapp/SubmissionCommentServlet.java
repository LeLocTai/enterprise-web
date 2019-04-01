package com.magazineapp;

import com.magazineapp.model.Submission;
import com.magazineapp.repository.SubmissionRepo;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-comment")
public class SubmissionCommentServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException
    {
        int submissionId = NumberUtils.toInt(request.getParameter("id"));
        if (submissionId < 1)
        {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        String comment = request.getParameter("comment");
        if (comment == null)
        {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        SubmissionRepo repo = new SubmissionRepo();

        Submission submission = repo.get(submissionId);
        if (submission == null)
        {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        comment = StringUtils.strip(comment);
        
        submission.set_comment(comment);
        repo.update(submission);

        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(String.format(
                "{\n  \"id\": \"%d\",\n  \"comment\": \"%s\"\n}",
                submissionId,
                comment
        ));
        response.getWriter().flush();
    }
}
