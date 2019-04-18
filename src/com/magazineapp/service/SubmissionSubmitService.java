package com.magazineapp.service;

import com.magazineapp.model.Submission;
import com.magazineapp.model.User;
import com.magazineapp.model.Year;
import com.magazineapp.repository.SubmissionRepo;
import com.magazineapp.repository.YearRepo;

import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.util.Date;

public class SubmissionSubmitService
{
    private Part filePart;
    private User author;

    private SubmissionRepo repo;
    private Submission     submission;
    private boolean        isUpdate;
    private int            submissionId;

    public static boolean canSubmit(int id)
    {
        if (id > 0) //is update
            return true; //can update after closure date

        Year currentYear = new YearRepo().getCurrentYear();
        if (currentYear == null) return true;//temp fix until implemented

        Date now = new Date();

        return !now.after(currentYear.get_entry_ClosureDate());
    }

    public static Submission Save(int submissionId, Part filePart, User author) throws IOException
    {
        SubmissionSubmitService instance = new SubmissionSubmitService();

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
                FileSystemService.getUploadFolderPath().toString(),
                getUniqueName(submittedFileName)
        );

        Files.copy(filePart.getInputStream(), fullFilePath, StandardCopyOption.REPLACE_EXISTING);
        return fullFilePath.toString();
    }

    private String getUniqueName(String baseName)
    {
        return String.join(
                ".",
                String.valueOf(author.get_id()),
                Long.toString(Instant.now().toEpochMilli(), Character.MAX_RADIX),
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
