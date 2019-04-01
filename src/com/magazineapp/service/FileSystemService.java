package com.magazineapp.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService
{

    private static final String APP_ROOT           = "magazineApp";
    private static final String UPLOAD_FOLDER_NAME = "upload-root";
    private static final String ZIP_FILE_NAME      = "selected-submission.zip";

    public static Path getUploadFolderPath()
    {
        Path path = Paths.get(getAppDataPath().toString(), UPLOAD_FOLDER_NAME);
        makeSurePathExists(path);
        return path;
    }

    public static Path getZipFilePath()
    {
        Path root = getAppDataPath();
        makeSurePathExists(root);
        return Paths.get(root.toString(), ZIP_FILE_NAME);
    }

    public static Path getAppDataPath()
    {
        return Paths.get(getUserHomePathString(), APP_ROOT);
    }

    public static String getUserHomePathString()
    {
        return System.getProperty("user.home");
    }

    public static void makeSurePathExists(Path path)
    {
        File uploadRootDir = path.toFile();
        if (!uploadRootDir.exists()) uploadRootDir.mkdirs();
    }

    public static void transferStreamsBuffered(InputStream from, OutputStream to, int bufferSize) throws IOException
    {
        byte[] buffer = new byte[bufferSize];
        int    nextLength;
        while ((nextLength = from.read(buffer)) > 0)
        {
            to.write(buffer, 0, nextLength);
        }
    }
}
