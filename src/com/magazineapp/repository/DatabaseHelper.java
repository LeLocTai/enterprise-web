package com.magazineapp.repository;

import com.magazineapp.model.*;

import java.sql.*;

public class DatabaseHelper
{

    public static Connection getConnection() throws SQLException
    {
        DriverManager.registerDriver(new org.mariadb.jdbc.Driver());

        String url  = System.getProperty("DB_URL");
        String user = System.getProperty("DB_USER");
        String pass = System.getProperty("DB_PASS");

        if (url == null) url = "ewd.c6d1svw4itgu.ap-southeast-1.rds.amazonaws.com";
        if (user == null) user = "ewd";
        if (pass == null) pass = "ewd12345";

        String cs = "jdbc:mariadb://" + url + "/magazinedb";
        return DriverManager.getConnection(cs, user, pass);
    }

    public static ResultSet executeQuery(String sql, PreparedStatementConsumer statementModifier) throws SQLException
    {
        ResultSet resultSet;

        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql))
        {
            statementModifier.acceptThrow(statement);

            resultSet = statement.executeQuery();
        }

        return resultSet;
    }

    public static int executeUpdate(String sql, PreparedStatementConsumer statementModifier) throws SQLException
    {
        int success;

        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql))
        {
            statementModifier.acceptThrow(statement);

            success = statement.executeUpdate();
        }

        return success;
    }

    public static User getTestStudent()
    {
        return new UserRepo().get(1);
    }

    public static User getTestStudent2()
    {
        return new UserRepo().get(5);
    }

    public static User getTestCoordinator()
    {
        return new UserRepo().get(2);
    }

    public static User getTestCoordinator2()
    {
        return new UserRepo().get(4);
    }

    public static User getTestManager()
    {
        return new UserRepo().get(3);
    }
}
