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
    static Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatemt = null;

    public Connection getDataSource() {

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

    public DataBaseConnection insertInfoIntoTable(String locationFrom, String locationTo, String dateFrom, String dateTo, Integer price) {

        log.info("Creating DataSource for INSERT operation");
        connection = getDataSource();

        String sql = "INSERT INTO `TICKETS`(`LOCATION_FROM`, `LOCATION_TO`, `DATE_FROM`, `DATE_TO`, `PRICE`, `EXECUTION_DATE`) VALUES (\"" + locationFrom + "\", \"" + locationTo + "\",\"" + dateFrom + "\",\"" + dateTo + "\",\"" + price + "\",\"" + AbstractPage.currentDate() + "\")";
        try {
            log.info("Creating statement");
            statement = connection.createStatement();
            log.info("Executing SQL INSERT with parameters | " + locationFrom + " | " + locationTo + " | ");
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;

    }

    public DataBaseConnection getResult() throws SQLException {

        log.info("Retrieving results from table");
        String sql = "SELECT * FROM `TICKETS`";

        ResultSet resultSet = statement.executeQuery(sql);
        String result = "";
        while (resultSet.next()) {

            int id = resultSet.getInt("ID");
            String locationFrom = resultSet.getString("Location_From");
            String locationTo = resultSet.getString("Location_To");
            String dateFrom = resultSet.getString("date_from");
            String dateTo = resultSet.getString("date_to");
            String price = resultSet.getString("price");
            String dateOfExecution = resultSet.getString("execution_date");


            result += id + " : " + locationFrom + " : " + locationTo + " : " + " : " + dateFrom + " : " + dateTo + " : " + price + " : " + dateOfExecution + "\n";
        }
        closeConnection();

        System.out.println(result);
        return this;
    }


}
