package com.magazineapp;

import com.magazineapp.service.ReportDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/report-data")
public class ReportDataServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            Date from = Date.valueOf(request.getParameter("from"));
            Date to   = Date.valueOf(request.getParameter("to"));

            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(ReportDataService.GetDataInRange(from, to));
            response.getWriter().flush();
        } catch (IllegalArgumentException e)
        {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
