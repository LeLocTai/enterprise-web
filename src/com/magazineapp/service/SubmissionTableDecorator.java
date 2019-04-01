package com.magazineapp.service;

import com.magazineapp.model.Submission;
import com.magazineapp.model.Year;
import org.displaytag.decorator.TableDecorator;

import java.text.SimpleDateFormat;

public class SubmissionTableDecorator extends TableDecorator {

    public String getShortYear() {
        Year year = getSubmission().get_year();
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        return df.format(year.get_startDate()) + "-" + df.format(year.get_endDate());
    }

    Submission getSubmission() {
        return (Submission) getCurrentRowObject();
    }
}
