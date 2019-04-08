package com.magazineapp;

import com.magazineapp.service.ReportDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/report-data")
public class ReportDataServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(ReportDataService.GetJsonString());
        response.getWriter().flush();
    }
}
