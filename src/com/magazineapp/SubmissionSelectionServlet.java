package com.magazineapp;

import com.magazineapp.model.Submission;
import com.magazineapp.repository.SubmissionRepo;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.math.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/select-submission")
public class SubmissionSelectionServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException
    {
        int submissionId = NumberUtils.toInt(request.getParameter("id"));
        if (submissionId < 1)
        {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        boolean isBeingSelected = BooleanUtils.toBoolean(request.getParameter("value"));

        SubmissionRepo repo       = new SubmissionRepo();
        Submission     submission = repo.get(submissionId);
        if (submission == null)
        {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        submission.set_is_Selected(isBeingSelected);
        repo.update(submission);

        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(String.format(
                "{\n  \"id\": \"%d\",\n  \"selected\": \"%s\"\n}",
                submissionId,
                BooleanUtils.toStringTrueFalse(isBeingSelected)
        ));
        response.getWriter().flush();
    }
}
