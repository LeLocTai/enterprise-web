package repository;

import java.sql.ResultSet;

@FunctionalInterface
public interface ResultSetMapper<T>
{
    void map(ResultSet resultSet, T object);
}
