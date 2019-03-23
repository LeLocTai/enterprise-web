package com.magazineapp.repository;

import com.magazineapp.model.Year;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class YearRepo implements Repository<Year> {

    @Override
    public Year get(int id) {
        //language=MariaDB
        String sql = "SELECT * FROM Year WHERE Id = ?";
        try {
            ResultSet resultSet = DatabaseHelper.executeQuery(sql, stm -> stm.setInt(1, id));

            Year year = new Year();

            if (resultSet.first()) {
                year.set_id(id);
                year.set_startDate(resultSet.getDate("StartDate"));
                year.set_endDate(resultSet.getDate("EndDate"));
                year.set_entry_ClosureDate(resultSet.getDate("Entry_ClosureDate"));

                return year;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Year> getAll() {
        return null;
    }

    public Year getCurrentYear() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        String sql = "SELECT * FROM Year WHERE ?>StartDate AND ?<EndDate ";
        try {
            ResultSet resultSet = DatabaseHelper.executeQuery(sql, stm -> {
                        stm.setString(1, dateFormat.format(date));
                        stm.setString(2, dateFormat.format(date));
                    }
            );

            return Year.fromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(Year item) {
        return 0;
    }

    @Override
    public int update(Year item) {
        return 0;
    }

    @Override
    public int remove(int id) {
        return 0;
    }
}
