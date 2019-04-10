package com.magazineapp.service;

import com.magazineapp.repository.DatabaseHelper;
import org.json.*;

import java.sql.*;
import java.util.Hashtable;

public class ReportDataService
{
    private JSONObject json = new JSONObject();

    private Hashtable<Integer, JSONObject> yearIdObjectDict = new Hashtable<>();

    public static String GetDataInRange(Date from, Date to)
    {
        ReportDataService instance = new ReportDataService();
        instance.ExecuteProcedure(from, to);
        return instance.json.toString();
    }

    private void ExecuteProcedure(Date from, Date to)
    {
        final String sql = "CALL Get_report_data(?,?)";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setDate(1, from);
            statement.setDate(2, to);

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
        facultyBuilder.put("nstudent", resultSet.getInt("N_STUDENT"));
        facultyBuilder.put("ncontributor", resultSet.getInt("N_CONTRIBUTOR"));
        facultyBuilder.put("nsubmission", resultSet.getInt("N_SUBMISSION"));
        facultyBuilder.put("nsubmissionselected", resultSet.getInt("N_SUBMISSION_SELECTED"));
        facultyBuilder.put("nsubmissionwocomment", resultSet.getInt("N_SUBMISSION_WO_COMMENT"));

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
            year.put("startdate", resultSet.getString("YEAR_START"));
            year.put("enddate", resultSet.getString("YEAR_END"));
            year.put("faculties", new JSONArray());

            yearIdObjectDict.put(yearId, year);
        }

        return year;
    }

    private void processTopContributorsData(ResultSet resultSet)
    {

    }
}
