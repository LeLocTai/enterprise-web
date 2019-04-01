package com.magazineapp.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {

    private static final String APP_ROOT = "magazineApp";
    private static final String UPLOAD_FOLDER_NAME = "upload-root";
    private static final String ZIP_FILE_NAME = "selected-submission.zip";

    public static Path getUploadFolderPath() {
        Path path = Paths.get(getUserHomePathString(), APP_ROOT, UPLOAD_FOLDER_NAME);
        makeSurePathExists(path);
        return path;
    }

    public static Path getZipFilePath() {
        Path path = Paths.get(getUserHomePathString(), APP_ROOT, ZIP_FILE_NAME);
        makeSurePathExists(path);
        return path;
    }

    public static String getUserHomePathString() {
        return System.getProperty("user.home");
    }

    public static void makeSurePathExists(Path path) {
        File uploadRootDir = path.toFile();
        if (!uploadRootDir.exists()) uploadRootDir.mkdirs();
    }
}
