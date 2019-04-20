package com.magazineapp.servlet;

import com.magazineapp.model.Submission;
import com.magazineapp.repository.SubmissionRepo;
import com.magazineapp.service.HttpResponseService;
import com.magazineapp.service.ZipService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/download-selected-as-zip")
public class SelectedSubmissionsZipDownloadServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Submission> selectedSubmission      = new SubmissionRepo().getSelected();
        List<Path>       selectedSubmissionPaths = new ArrayList<>();

        for (Submission curSubmission : selectedSubmission)
        {
            selectedSubmissionPaths.add(Paths.get(curSubmission.get_path()));
        }

        File zipFile = ZipService.createFromPaths(selectedSubmissionPaths);

        HttpResponseService.ForceDownload(response, zipFile);
    }
}
