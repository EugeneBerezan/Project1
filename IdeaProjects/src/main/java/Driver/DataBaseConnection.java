package Driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.text.SimpleDateFormat;


public class DataBaseConnection {

    Logger log = LogManager.getLogger(getClass());

    private final String username = "user01";
    private final String password = "user01";
    private final String url = "jdbc:mysql://db4free.net:3306/myfirstdatabase";
    private static Connection connection = null;
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

    public DataBaseConnection insertTicketsInfoIntoTable(String dateFrom, String dateTo, String locationFrom, String locationTo, Integer price) {

        log.info("Creating DataSource for INSERT operation");
        connection = getDataSource();

        String sql = "INSERT INTO `TICKETS`(`DATE_FROM`, `DATE_TO`, `LOCATION_FROM`, `LOCATION_TO`, `PRICE`, `EXECUTION_DATE`) VALUES (\"" + dateFrom + "\", \"" + dateTo + "\",\"" + locationFrom + "\",\"" + locationTo + "\",\"" + price + "\",\"" + currentDate() + "\")";
        try {
            log.info("Creating statement");
            statement = connection.createStatement();
            log.info("Executing SQL INSERT");
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;

    }

    public DataBaseConnection insesrtAvisRentalsInforIntoTable(String pickUpDate, String returnDate, String pickUpLocation, String returnLocation, String carClass, String totalPrice) {

        log.info("Creating DataSource for INSERT operation");
        connection = getDataSource();

        String sql = "INSERT INTO `AVIS_RENTALS`(`DATE_FROM`, `DATE_TO`, `PICK_UP_LOCATION`, `RETURN_LOCATION`, `CAR_CLASS`, `TOTAL_PRICE`, `EXECUTION_DATE`) VALUES (\"" + pickUpDate + "\", \"" + returnDate + "\", \"" + pickUpLocation + "\", \"" + returnLocation + "\",\"" + carClass + "\",\"" + totalPrice + "\",\"" + currentDate() + "\")";
        try {
            log.info("Creating statement");
            statement = connection.createStatement();
            log.info("Executing SQL INSERT");
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;

    }


    public DataBaseConnection getSelectFromTickets() throws SQLException {

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

            result += id + " : " + dateFrom + " : " + dateTo + " : " + locationFrom + " : " + locationTo + " : " + price + " : " + dateOfExecution + "\n";
        }

        System.out.println(result);
        return this;
    }

    public DataBaseConnection getSelectFromAvisRentals() throws SQLException {

        log.info("Retrieving results from table");
        String sql = "SELECT * FROM `AVIS_RENTALS`";

        ResultSet resultSet = statement.executeQuery(sql);
        String result = "";
        while (resultSet.next()) {

            int id = resultSet.getInt("ID");
            String dateFrom = resultSet.getString("DATE_FROM");
            String dateTo = resultSet.getString("DATE_TO");
            String pickUpLocation = resultSet.getString("PICK_UP_LOCATION");
            String returnLocation = resultSet.getString("RETURN_LOCATION");
            String totalPrice = resultSet.getString("TOTAL_PRICE");
            String dateOfExecution = resultSet.getString("EXECUTION_DATE");

            result += id + " : " + dateFrom + " : " + dateTo + " : " + pickUpLocation + " : " + returnLocation + " : " + totalPrice + " : " + dateOfExecution + "\n";
        }

        System.out.println(result);
        return this;
    }

    public static String currentDate() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd '|' HH:mm:ss");

        return dateFormat.format(new java.util.Date());

    }

}
