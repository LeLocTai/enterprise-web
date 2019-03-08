package repository;

import model.User;

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

            if (resultSet.first())
            {
                User user = new User();
                user.set_id(id);
                user.set_role(resultSet.getString("Role"));
                user.set_faculty(new FacultyRepo().get(resultSet.getInt("Faculty_Id")));
                user.set_has_Accepted_TOC(resultSet.getBoolean("Has_Accepted_TOC"));
                user.set_email(resultSet.getString("Email"));

                return user;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<User> getAll()
    {
        return null;
    }

    @Override
    public int add(User item)
    {
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
                stm.setString(1, item.get_role());
                stm.setInt(2, item.get_faculty().get_id());
                stm.setBoolean(3, item.get_has_Accepted_TOC());
                stm.setString(4, item.get_email());
                
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
