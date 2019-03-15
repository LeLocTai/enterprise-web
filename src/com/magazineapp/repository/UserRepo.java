package com.magazineapp.repository;

import com.magazineapp.model.Faculty;
import com.magazineapp.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepo implements Repository<User>
{

    @Override
    public User get(int id)
    {
        //language=MariaDB
        String sql = "SELECT * from User WHERE Id = ?";
        try
        {
            ResultSet resultSet = DatabaseHelper.executeQuery(sql, stm -> stm.setInt(1, id));

            return User.fromResultSet(resultSet);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<User> getAll()
    {
        ArrayList<User> user = new ArrayList<>();
        String          sql  = "SELECT * from User";
        try
        {
            ResultSet resultSet = DatabaseHelper.executeQuery(sql, stm -> {
            });
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(User item)
    {
        String sql = "INSERT INTO User (Role, Faculty_Id, Has_Accepted_TOC, Email) VALUES (?,?,?,?)";
        try
        {
            return DatabaseHelper.executeUpdate(sql, item::fillStatement);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(User item)
    {
        //language=MariaDB
        String sql = "UPDATE User SET Role = ?, Faculty_Id = ?, Has_Accepted_TOC = ?, Email = ? WHERE Id = ?";
        try
        {
            return DatabaseHelper.executeUpdate(sql, stm -> {
                item.fillStatement(stm);

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

    public User getCoordinatorOf(Faculty faculty)
    {
        //language=MariaDB
        String sql = "SELECT * from User WHERE Role = 'Coordinator' AND Faculty_Id = ?";
        try
        {
            ResultSet resultSet = DatabaseHelper.executeQuery(sql, stm ->
                    stm.setInt(1, faculty.get_id())
            );

            return User.fromResultSet(resultSet);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
