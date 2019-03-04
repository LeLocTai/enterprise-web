package repository;

import model.Submission;

import java.sql.*;

public class SubmissionRepo implements Repository<Submission>
{

    @Override
    public int add(Submission item)
    {
        //language=MariaDB
        String sql = "INSERT INTO Submission (Path, Author_Id, Date, Year_Id, Has_Sent_Notice, Comment, Is_Selected) VALUES (?,?,?,?,?,?,?)";
        try
        {
            return DatabaseHelper.executeUpdate(sql, stm -> {
                stm.setString(1, item.get_path());
                stm.setInt(2, item.get_author().get_id());
                stm.setDate(3, new Date(item.get_date().getTime()));
                stm.setInt(4, item.get_year().get_id());
                stm.setBoolean(5, item.get_has_Sent_Notice());
                stm.setString(6, item.get_comment());
                stm.setBoolean(7, item.get_is_Selected());
            });
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Submission get(int id)
    {
        return null;
    }

    @Override
    public int update(Submission item)
    {
        //language=MariaDB
        String sql = "UPDATE Submission SET Path = ?, Date = ?, Year_Id = ?, Has_Sent_Notice = ?, Comment = ?, Is_Selected = ? WHERE Id = ?";
        try
        {
            return DatabaseHelper.executeUpdate(sql, stm -> {
                stm.setString(1, item.get_path());
                stm.setDate(1, new Date(item.get_date().getTime()));
                stm.setInt(1, item.get_year().get_id());
                stm.setBoolean(1, item.get_has_Sent_Notice());
                stm.setString(1, item.get_comment());
                stm.setBoolean(1, item.get_is_Selected());

                stm.setInt(5, item.get_id());
            });
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int remove(int id)
    {
        return 0;
    }
}
