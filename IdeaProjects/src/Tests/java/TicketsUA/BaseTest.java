package TicketsUA;

import Driver.DataBaseConnection;
import Driver.WebDriverManager;
import PagesTicketsUA.TicketsHomePage;
import PagesTicketsUA.TicketsResultPage;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.*;

import java.sql.SQLException;


public class BaseTest {

     org.apache.logging.log4j.Logger log = LogManager.getLogger(getClass());

    TicketsResultPage resultPage = new TicketsResultPage();
    TicketsHomePage homePage = new TicketsHomePage();
    DataBaseConnection dataBase = new DataBaseConnection();

    @BeforeMethod
    public void setUp() {

    log.info("BEFORE METHOD WAS CALLED");
        WebDriverManager.getInstance().get("http://tickets.ua");

    }

    @AfterMethod
    public void tearDown() throws SQLException {

        log.info("AFTER METHOD WAS CALLED");
        WebDriverManager.close();

    }

    @AfterClass
    public void closeConnection() throws SQLException {

        log.info("AFTER CLASS WAS CALLED");
        WebDriverManager.close();
        new DataBaseConnection().closeConnection();

    }

}
