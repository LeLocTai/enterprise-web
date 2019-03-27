package com.magazineapp.service;

import com.magazineapp.model.Submission;
import com.magazineapp.model.User;
import com.magazineapp.repository.SubmissionRepo;
import com.magazineapp.repository.YearRepo;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.util.Date;

public class SubmissionPersistService
{
    private static final String UPLOAD_FOLDER_NAME = "magazineApp/upload-root";

    private Part filePart;
    private User author;

    private SubmissionRepo repo;
    private Submission     submission;
    private boolean        isUpdate;
    private int            submissionId;

    public static Submission Save(int submissionId, Part filePart, User author) throws IOException
    {
        SubmissionPersistService instance = new SubmissionPersistService();

        instance.submissionId = submissionId;
        instance.filePart = filePart;
        instance.author = author;
        instance.repo = new SubmissionRepo();

        instance.initSubmission();
        instance.doSave();

        return instance.submission;
    }

    private void doSave() throws IOException
    {
        if (isUpdate)
            Files.delete(Paths.get(submission.get_path()));

        String savedFilePath  = writeFileToDisk(filePart);
        int    dbRowsAffected = saveSubmissionToDB(savedFilePath);
        if (dbRowsAffected < 1) throw new IOException();
    }

    private void initSubmission()
    {
        isUpdate = submissionId > 0;

        submission = new Submission();

        if (isUpdate)
        {
            submission = repo.get(submissionId);
        } else
        {
            submission.set_author(author);
            submission.set_year(new YearRepo().getCurrentYear());
            submission.set_has_Sent_Notice(false);
            submission.set_comment("");
            submission.set_is_Selected(false);
        }
        submission.set_date(new Date());
    }

    private String writeFileToDisk(Part filePart) throws IOException
    {
        String submittedFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        Path fullFilePath = Paths.get(
                getUploadRoot().toString(),
                getUniqueName(submittedFileName)
        );

        Files.copy(filePart.getInputStream(), fullFilePath, StandardCopyOption.REPLACE_EXISTING);
        return fullFilePath.toString();
    }

    private Path getUploadRoot()
    {
        String userHome       = System.getProperty("user.home");
        Path   uploadRootPath = Paths.get(userHome, UPLOAD_FOLDER_NAME);

        File uploadRootDir = uploadRootPath.toFile();
        if (!uploadRootDir.exists()) uploadRootDir.mkdirs();

        return uploadRootPath;
    }

    private String getUniqueName(String baseName)
    {
        return String.join(
                ".",
                String.valueOf(author.get_id()),
                String.valueOf(Instant.now().toEpochMilli()),
                baseName
        );
    }

    private int saveSubmissionToDB(String savedFilePath)
    {
        submission.set_path(savedFilePath);

        return submission.get_id() > 0 ?
                repo.update(submission) :
                repo.add(submission);
    }
}
