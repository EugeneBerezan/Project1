package TicketsUA;

import Driver.DataBaseConnection;
import Driver.WebDriverManager;
import PagesTicketsUA.TicketsAbstractPage;
import PagesTicketsUA.TicketsHomePage;
import PagesTicketsUA.TicketsResultPage;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.*;

import java.sql.SQLException;

public class BaseTest extends TicketsAbstractPage{

    org.apache.logging.log4j.Logger log = LogManager.getLogger(getClass());

    @BeforeClass
    public void setMethod() throws InterruptedException {

        log.info("BEFORE CLASS WAS CALLED");
        driver.get("http://tickets.ua");

    }

    @AfterClass
    public void tearDownMethod() throws SQLException, InterruptedException {

        log.info("AFTER CLASS WAS CALLED");
        driver.close();
        new DataBaseConnection().closeConnection();
    }

//    @AfterClass
//    public void closeConnection() throws SQLException {
//
//        new DataBaseConnection().closeConnection();
//
//    }
}
