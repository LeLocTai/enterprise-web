package repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.function.Consumer;

@FunctionalInterface
public interface PreparedStatementConsumer
{
    void acceptThrow(PreparedStatement preparedStatement) throws SQLException;
}
