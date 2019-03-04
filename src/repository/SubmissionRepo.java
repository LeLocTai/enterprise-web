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
                stm.setBoolean(5, item.is_has_Sent_Notice());
                stm.setString(6, item.get_comment());
                stm.setBoolean(7, item.is_is_Selected());
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
}
