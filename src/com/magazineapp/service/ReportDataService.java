package com.magazineapp.service;

import com.magazineapp.repository.DatabaseHelper;
import org.json.*;

import java.sql.*;
import java.util.Hashtable;

public class ReportDataService
{
    private JSONObject json = new JSONObject();

    private Hashtable<Integer, JSONObject> yearIdObjectDict = new Hashtable<>();

    public static String GetJsonString()
    {
        ReportDataService instance = new ReportDataService();
        instance.ExecuteProcedure();
        return instance.json.toString();
    }

    private void ExecuteProcedure()
    {
        final String sql = "CALL Get_report_data()";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            processOverviewData(resultSet);

            statement.getMoreResults(Statement.CLOSE_CURRENT_RESULT);
            resultSet = statement.getResultSet();
            processTopContributorsData(resultSet);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void processOverviewData(ResultSet resultSet) throws SQLException
    {
        while (resultSet.next())
        {
            JSONObject year = getYearJson(resultSet);

            year.getJSONArray("faculties").put(getFacultyJson(resultSet));
        }

        JSONArray yearArrayJson = new JSONArray(yearIdObjectDict.values());

        json.put("years", yearArrayJson);
    }

    private JSONObject getFacultyJson(ResultSet resultSet) throws SQLException
    {
        JSONObject facultyBuilder = new JSONObject();

        facultyBuilder.put("id", resultSet.getInt("FACULTY_ID"));
        facultyBuilder.put("name", resultSet.getString("FACULTY_NAME"));
        facultyBuilder.put("n-student", resultSet.getInt("N_STUDENT"));
        facultyBuilder.put("n-contributor", resultSet.getInt("N_CONTRIBUTOR"));
        facultyBuilder.put("n-submission", resultSet.getInt("N_SUBMISSION"));
        facultyBuilder.put("n-submission-selected", resultSet.getInt("N_SUBMISSION_SELECTED"));
        facultyBuilder.put("n-submission-wo-comment", resultSet.getInt("N_SUBMISSION_WO_COMMENT"));

        return facultyBuilder;
    }

    private JSONObject getYearJson(ResultSet resultSet) throws SQLException
    {
        int        yearId = resultSet.getInt("YEAR_ID");
        JSONObject year   = yearIdObjectDict.get(yearId);

        if (year == null)
        {
            year = new JSONObject();

            year.put("id", yearId);
            year.put("start-date", resultSet.getString("YEAR_START"));
            year.put("end-date", resultSet.getString("YEAR_END"));
            year.put("faculties", new JSONArray());

            yearIdObjectDict.put(yearId, year);
        }

        return year;
    }

    private void processTopContributorsData(ResultSet resultSet)
    {

    }
}
