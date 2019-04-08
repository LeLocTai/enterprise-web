package com.magazineapp;

import com.magazineapp.repository.DatabaseHelper;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "com.magazineapp.ReportDataServlet")
public class ReportDataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        String sql = "CALL Get_report_data()";
        ExecuteProcedure(sql);
    }

    private void ExecuteProcedure(String sql) {
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            boolean isResultSet = statement.execute();
            int count = 1;

            while (true) {
                if (isResultSet) {
                    ResultSet rs = statement.getResultSet();
                    while (rs.next()) {
                        switch (count) {
                            case 1:
                                processEachRow(rs);
                                break;
                            case 2:
                                processEachRow(rs);
                                break;
                        }
                    }
                } else {
                    if (statement.getUpdateCount() == -1) {
                        break;
                    }
                }

                count++;
                isResultSet = statement.getMoreResults(Statement.CLOSE_CURRENT_RESULT);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
