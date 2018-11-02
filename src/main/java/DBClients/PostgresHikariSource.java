package DBClients;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by deepak.jayaprakash on 02/11/18.
 */
public class PostgresHikariSource {
    private static PostgresHikariSource instance;
    private static HikariDataSource datasource = null;

    public static PostgresHikariSource getInstance() {
        if (instance == null) {
            instance = new PostgresHikariSource();
            initializeHikari();
        }
        return instance;
    }

    private static void initializeHikari() {
        HikariConfig config = new HikariConfig("/Users/deepak.jayaprakash/Desktop/tools/src/main/resources/psql.datasource.properties");
        datasource = new HikariDataSource(config);
    }

    public Connection getConnection() {
        if (datasource == null) {
            initializeHikari();
        }
        try {
            return datasource.getConnection();
        } catch (SQLException e) {
            System.out.println("unable to get connection from hikari : " + e);
            return null;
        }
    }
}
