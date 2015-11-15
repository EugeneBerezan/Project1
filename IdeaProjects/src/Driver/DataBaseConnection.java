package Driver;

import java.sql.*;


public class DataBaseConnection {

     public static void GetConnection(String sql) throws SQLException {

         Connection getConnection = DriverManager.getConnection("127.0.0.1:3306", "user01", "user01");

         Statement statement = getConnection.createStatement();

         statement.executeQuery(sql);


    }


}
