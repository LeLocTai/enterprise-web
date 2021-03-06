package com.magazineapp.repository;

import com.magazineapp.model.Faculty;
import com.magazineapp.model.Submission;
import com.magazineapp.model.User;
import com.magazineapp.model.Year;

import java.sql.*;
import java.util.ArrayList;

public class SubmissionRepo implements Repository<Submission> {
    @Override
    public Submission get(int id) {
        //language=MariaDB
        String sql = "SELECT * from Submission WHERE Id = ?";
        try {
            ResultSet resultSet = DatabaseHelper.executeQuery(sql, stm -> stm.setInt(1, id));

            if (resultSet.first()) {
                return Submission.fromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //    @Override
    public ArrayList<Submission> getAll() {
        //language=MariaDB
        String sql = "SELECT * from Submission";
        ArrayList<Submission> submissions = new ArrayList<>();
        try {
            ResultSet resultSet = DatabaseHelper.executeQuery(sql, stm -> {
            });

            while (resultSet.next()) {
                submissions.add(Submission.fromResultSet(resultSet));
            }
            return submissions;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int add(Submission item) {
        //language=MariaDB
        String sql = "INSERT INTO Submission (Path, Author_Id, Date, Year_Id, Has_Sent_Notice, Comment, Is_Selected) VALUES (?,?,?,?,?,?,?)";
        try {
            return DatabaseHelper.executeUpdate(sql, stm -> {
                stm.setString(1, item.get_path());
                stm.setInt(2, item.get_author().get_id());
                stm.setDate(3, new Date(item.get_date().getTime()));
                stm.setInt(4, item.get_year().get_id());
                stm.setBoolean(5, item.get_has_Sent_Notice());
                stm.setString(6, item.get_comment());
                stm.setBoolean(7, item.get_is_Selected());
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Submission item) {
        //language=MariaDB
        String sql = "UPDATE Submission SET Path = ?, Date = ?, Year_Id = ?, Has_Sent_Notice = ?, Comment = ?, Is_Selected = ? WHERE Id = ?";
        try {
            return DatabaseHelper.executeUpdate(sql, stm -> {
                stm.setString(1, item.get_path());
                stm.setDate(2, new Date(item.get_date().getTime()));
                stm.setInt(3, item.get_year().get_id());
                stm.setBoolean(4, item.get_has_Sent_Notice());
                stm.setString(5, item.get_comment());
                stm.setBoolean(6, item.get_is_Selected());

                stm.setInt(7, item.get_id());
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int remove(int id) {
        String sql = "DELETE FROM Submission WHERE Id = ?";
        try {
            return DatabaseHelper.executeUpdate(sql, stm -> {
                stm.setInt(1, id);
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private ArrayList<Submission> getSubmissionsFromIdBasedQuery(String sql, int id) {
        ArrayList<Submission> submissions = new ArrayList<>();
        try {
            ResultSet resultSet = DatabaseHelper.executeQuery(sql, stm -> stm.setInt(1, id));

            while (resultSet.next()) {
                submissions.add(Submission.fromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return submissions;
    }

    public ArrayList<Submission> getFromAuthor(User author) {
        String sql = "SELECT * FROM Submission WHERE Author_Id = ?";

        return getSubmissionsFromIdBasedQuery(sql, author.get_id());
    }

    public ArrayList<Submission> getFromFaculty(Faculty faculty) {
        String sql = "SELECT * FROM Submission\n"
                     + "JOIN User u ON Submission.Author_Id = u.Id\n"
                     + "JOIN Faculty f ON u.Faculty_Id = f.Id\n"
                     + "WHERE f.Id = ?";

        return getSubmissionsFromIdBasedQuery(sql, faculty.get_id());
    }

    public ArrayList<Submission> getSelected() {
        return getSelected(new YearRepo().getCurrentYear());
    }

    public ArrayList<Submission> getSelected(Year year) {
        String sql = "SELECT * FROM Submission WHERE Is_Selected = true && Year_Id = ?";
        return getSubmissionsFromIdBasedQuery(sql, year.get_id());
    }
}
