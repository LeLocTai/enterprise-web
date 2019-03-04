import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    static final String DB_URL = "jdbc:mariadb://ewd.c6d1svw4itgu.ap-southeast-1.rds.amazonaws.com/magazinedb";
    static final String DB_URL_LOCAL = "jdbc:mariadb://localhost/magazinedb";

    //  Database credentials
    static final String USER = "ewd";
    static final String PASS = "ewd12345";

    public DatabaseManager() {
        try {
            DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
            Connection connection = DriverManager.getConnection(DB_URL_LOCAL, "root", "");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
