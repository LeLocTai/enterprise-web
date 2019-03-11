package repository;

import model.Faculty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FacultyRepo implements Repository<Faculty> {

    @Override
    public Faculty get(int id) {
        //language=MariaDB
        String sql = "SELECT * FROM Faculty WHERE Id = ?";
        try {
            ResultSet resultSet = DatabaseHelper.executeQuery(sql, stm -> stm.setInt(1, id));

            Faculty faculty = new Faculty();

            if (resultSet.first()) {
                faculty.set_id(id);
                faculty.set_name(resultSet.getString("Name"));

                return faculty;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Faculty> getAll() {
        ArrayList<Faculty> faculty = new ArrayList<>();
        String sql = "SELECT * from Faculty";
        try {
            ResultSet resultSet = DatabaseHelper.executeQuery(sql, stm -> {
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(Faculty item) {
        String sql = "INSERT INTO Faculty (Name) VALUES (?)";
        try {
            return DatabaseHelper.executeUpdate(sql, stm -> {
                stm.setString(1, item.get_name());
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Faculty item) {
        String sql = "UPDATE Faculty SET Name = ? WHERE Id = ?";
        try {
            return DatabaseHelper.executeUpdate(sql, stm -> {
                stm.setString(1, item.get_name());
                stm.setInt(2, item.get_id());
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int remove(int id) {
        return 0;
    }
}
