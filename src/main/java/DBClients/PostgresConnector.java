package DBClients;

import java.sql.*;

/**
 * Created by deepak.jayaprakash on 31/10/18.
 */
public class PostgresConnector {

//    psql -h localhost -p 5432 -U username -d databasename
    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://hostname:port/dbname", "root", "");
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void executeMethod() {
        Connection connection = getConnection();
        ResultSet rs;
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery("select count(*) from users");
            while (rs.next())
                System.out.println(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        executeMethod();
    }
}
