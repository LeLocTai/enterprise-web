package com.magazineapp.model;

import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.Date; 

public class Year {
    private int _id;
    private Date _startDate;
    private Date _endDate;
    private Date _entry_ClosureDate;
    private ArrayList<Submission> _submissions = new ArrayList<>();

    public Year() {
    }

    public Year(int _id, Date _startDate, Date _endDate, Date _entry_ClosureDate, ArrayList<Submission> _submissions) {
        this._id = _id;
        this._startDate = _startDate;
        this._endDate = _endDate;
        this._entry_ClosureDate = _entry_ClosureDate;
        this._submissions = _submissions;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Date get_startDate() {
        return _startDate;
    }

    public void set_startDate(Date _startDate) {
        this._startDate = _startDate;
    }

    public Date get_endDate() {
        return _endDate;
    }

    public void set_endDate(Date _endDate) {
        this._endDate = _endDate;
    }

    public Date get_entry_ClosureDate() {
        return _entry_ClosureDate;
    }

    public void set_entry_ClosureDate(Date _entry_ClosureDate) {
        this._entry_ClosureDate = _entry_ClosureDate;
    }

    public ArrayList<Submission> get_submissions() {
        return _submissions;
    }

    public void set_submissions(ArrayList<Submission> _submissions) {
        this._submissions = _submissions;
    }
        
    public void fillStatement(PreparedStatement stm) throws SQLException 
    { 
        stm.setDate(1, (java.sql.Date) get_startDate()); 
        stm.setDate(2, (java.sql.Date) get_endDate()); 
        stm.setDate(3, (java.sql.Date) get_entry_ClosureDate()); 
    } 
     
    public static Year fromResultSet(ResultSet resultSet) throws SQLException 
    { 
        Year year = null; 
        if (resultSet.first()) 
        { 
            year = new Year(); 
            year.set_id(resultSet.getInt("Id")); 
            year.set_startDate(resultSet.getDate("StartDate")); 
            year.set_startDate(resultSet.getDate("EndDate")); 
            year.set_startDate(resultSet.getDate("Entry_ClosureDate")); 
        } 
        return year; 
    } 
}