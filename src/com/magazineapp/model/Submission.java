package com.magazineapp.model;

import com.magazineapp.repository.UserRepo;
import com.magazineapp.repository.YearRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Submission
{

    private int     _id;
    private String  _path;
    private Date    _date;
    private boolean _has_Sent_Notice;
    private String  _comment;
    private boolean _is_Selected;
    private User    _author;
    private Year    _year;

    public Submission()
    {
    }

    public int get_id()
    {
        return _id;
    }

    public void set_id(int _id)
    {
        this._id = _id;
    }

    public String get_path()
    {
        return _path;
    }

    public void set_path(String _path)
    {
        this._path = _path;
    }

    public Date get_date()
    {
        return _date;
    }

    public void set_date(Date _date)
    {
        this._date = _date;
    }

    public boolean get_has_Sent_Notice()
    {
        return _has_Sent_Notice;
    }

    public void set_has_Sent_Notice(boolean _has_Sent_Notice)
    {
        this._has_Sent_Notice = _has_Sent_Notice;
    }

    public String get_comment()
    {
        return _comment;
    }

    public void set_comment(String _comment)
    {
        this._comment = _comment;
    }

    public boolean get_is_Selected()
    {
        return _is_Selected;
    }

    public void set_is_Selected(boolean _is_Selected)
    {
        this._is_Selected = _is_Selected;
    }

    public User get_author()
    {
        return _author;
    }

    public void set_author(User _author)
    {
        this._author = _author;
    }

    public Year get_year()
    {
        return _year;
    }

    public void set_year(Year _year)
    {
        this._year = _year;
    }

    public boolean isOverCommentingDeadline()
    {
        LocalDate commentDeadline = ((java.sql.Date) get_date()).toLocalDate().plusDays(14);
        return LocalDate.now().isAfter(commentDeadline);
    }

    public Submission(String _path,
                      Date _date,
                      boolean _has_Sent_Notice,
                      String _comment,
                      boolean _is_Selected,
                      User _author,
                      Year _year)
    {
        this._path = _path;
        this._date = _date;
        this._has_Sent_Notice = _has_Sent_Notice;
        this._comment = _comment;
        this._is_Selected = _is_Selected;
        this._author = _author;
        this._year = _year;
    }

    public void fillStatement(PreparedStatement stm) throws SQLException
    {
        stm.setString(1, get_path());
        stm.setDate(2, (java.sql.Date) get_date());
        stm.setBoolean(3, get_has_Sent_Notice());
        stm.setString(4, get_comment());
        stm.setBoolean(5, get_is_Selected());
        stm.setInt(6, get_author().get_id());
        stm.setInt(7, get_year().get_id());
    }

    public static Submission fromResultSet(ResultSet resultSet) throws SQLException
    {
        Submission submission = null;

        submission = new Submission();
        submission.set_id(resultSet.getInt("Id"));
        submission.set_path(resultSet.getString("Path"));
        submission.set_author(new UserRepo().get(resultSet.getInt("Author_Id")));
        submission.set_date(resultSet.getDate("Date"));
        submission.set_year(new YearRepo().get(resultSet.getInt("Year_Id")));
        submission.set_has_Sent_Notice(resultSet.getBoolean("Has_Sent_Notice"));
        submission.set_comment(resultSet.getString("Comment"));
        submission.set_is_Selected(resultSet.getBoolean("Is_Selected"));

        return submission;
    }
}
