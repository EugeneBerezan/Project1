package Driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Pages.AbstractPage;

import java.sql.*;


public class DataBaseConnection {

    Logger log = LogManager.getLogger(getClass());

    final String username = "user01";
    final String password = "user01";
    final String url = "jdbc:mysql://db4free.net:3306/myfirstdatabase";
    static java.sql.Connection connection = null;
    private java.sql.Statement statement = null;
    private com.mysql.jdbc.PreparedStatement preparedStatemt = null;
    private ResultSet resultSet;

    public java.sql.Connection getDataSource() {

        try {
            log.info("Trying to get Data Source");
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            log.error("Something wrong with connection" + e.getMessage());
        }
        return connection;

    }

    public void closeConnection() throws SQLException {

        try {
            log.info("Closing connection");
            connection.close();
            statement.close();
            if (preparedStatemt != null) preparedStatemt.close();
            log.info("Connection closed");
        } catch (SQLException e) {
            log.error("Something wrong with closing connection" + e.getMessage());

        }

    }

    public void insertInfoIntoTable(String locationFrom, String locationTo, String dateFrom, String dateTo, Integer price) {

        log.info("Creating DataSource for INSERT operation");
        connection = getDataSource();

        String sql = " INSERT INTO `TICKETS` (" + locationFrom + ", " + locationTo + ", " + dateFrom + ", " + dateTo + ", " + price + ", " + AbstractPage.currentDate() + ")";

        try {
            log.info("Creating statement");
            statement = connection.createStatement();
            log.info("Executing SQL INSERT with parameters | "+locationFrom +" | " + locationTo + " | ");
            statement.executeQuery(sql);
            log.info("Saving result to resultSet");
            resultSet = statement.executeQuery(sql);
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getResult() throws SQLException {

        log.info("Retrieving results from table");
        String result = "";
        while (resultSet.next()) {

            int id = resultSet.getInt("ID");
            String locationFrom = resultSet.getString("Location_From");
            String locationTo = resultSet.getString("Location_To");
            String dateFrom = resultSet.getString("date_from");
            String dateTo = resultSet.getString("date_to");
            String price = resultSet.getString("price_usd");
            String dateOfExecution = resultSet.getString("execution_date");


            result += id + " : " + locationFrom + " : " + locationTo + " : " + " : " + dateFrom + " : " + dateTo + " : " + price + " : " + dateOfExecution + "\n";
        }
        return result.equals("") ? "no data found  " : result;

    }


}
