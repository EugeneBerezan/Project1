package TicketsUA;

import Driver.DataBaseConnection;
import Driver.WebDriverManager;
import PagesTicketsUA.TicketsAbstractPage;
import PagesTicketsUA.TicketsHomePage;
import PagesTicketsUA.TicketsResultPage;
import org.testng.annotations.*;

import java.sql.SQLException;


public class BaseTest extends TicketsAbstractPage {

    TicketsResultPage resultPage = new TicketsResultPage();
    TicketsHomePage homePage = new TicketsHomePage();
    DataBaseConnection dataBase = new DataBaseConnection();

    @BeforeMethod
    public static void setUp() {

        WebDriverManager.getInstance().get("http://tickets.ua");

    }

    @AfterMethod
    public static void tearDown() throws SQLException {

        WebDriverManager.close();

    }

    @AfterClass
    public static void closeConnection() throws SQLException {

        WebDriverManager.close();
        new DataBaseConnection().closeConnection();

    }

}
