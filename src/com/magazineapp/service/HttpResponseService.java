package com.magazineapp.service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HttpResponseService
{
    public static void ForceDownload(HttpServletResponse response, File file) throws IOException
    {
        response.setContentType("application/force-download");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

        try (FileInputStream submissionFileInStream = new FileInputStream(file))
        {
            FileSystemService.transferStreamsBuffered(submissionFileInStream, response.getOutputStream());
        }
    }
}
