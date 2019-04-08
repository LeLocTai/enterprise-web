package com.magazineapp.filter;

import com.magazineapp.model.Submission;
import com.magazineapp.model.User;
import com.magazineapp.repository.SubmissionRepo;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SubmissionFilter")
public class SubmissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        String idString = request.getParameter("id");
        boolean isUpdate = StringUtils.isNotBlank(idString) && !idString.equals("null");
        int submissionId = NumberUtils.toInt(idString);

        if (isUpdate && submissionId == 0) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Submission submission = new SubmissionRepo().get(submissionId);
        if (user.isStudent() && submission != null && user.get_id() != submission.get_author().get_id()) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        if (!user.get_has_Accepted_TOC()) {
            response.sendRedirect(request.getContextPath() + "/tos.jsp");
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
