package repository;

import model.*;

import java.sql.*;
import java.util.function.Consumer;

public class DatabaseHelper
{
    private static final String DB_URL = "jdbc:mariadb://ewd.c6d1svw4itgu.ap-southeast-1.rds.amazonaws.com/magazinedb";

    private static final String USER = "ewd";
    private static final String PASS = "ewd12345";

    public static User testStudent = new User();

    public static Connection getConnection() throws SQLException
    {
        DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
        return DriverManager.getConnection(DB_URL, USER, PASS);
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

    public static Year getTestYear()
    {
        return new YearRepo().get(1);
    }
}
