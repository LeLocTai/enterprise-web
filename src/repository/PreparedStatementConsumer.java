package repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PreparedStatementConsumer
{
    void acceptThrow(PreparedStatement preparedStatement) throws SQLException;
}
