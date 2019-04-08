package com.magazineapp.service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipService
{
    public static File createFromPaths(List<Path> inPathStrings) throws IOException
    {
        File outFile = FileSystemService.getZipFilePath().toFile();

        FileOutputStream     fileOutStream     = new FileOutputStream(outFile);
        BufferedOutputStream bufferedOutStream = new BufferedOutputStream(fileOutStream);

        //close is propagated
        try (ZipOutputStream zipOutStream = new ZipOutputStream(bufferedOutStream, StandardCharsets.UTF_8))
        {
            for (Path curPath : inPathStrings)
            {
                File curFile = curPath.toFile();
                try (FileInputStream curFileInStream = new FileInputStream(curFile))
                {
                    ZipEntry zipEntry = new ZipEntry(curFile.getName());
                    zipOutStream.putNextEntry(zipEntry);

                    FileSystemService.transferStreamsBuffered(curFileInStream, zipOutStream);

                    zipOutStream.closeEntry();
                }
            }
        }

        return outFile;
    }
}
