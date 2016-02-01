package TicketsUA;

import Driver.DataBaseConnection;
import Driver.WebDriverManager;
import PagesTicketsUA.TicketsHomePage;
import PagesTicketsUA.TicketsResultPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.SQLException;


public class BaseTest {

    TicketsResultPage resultPage = new TicketsResultPage();
    TicketsHomePage homePage = new TicketsHomePage();
    DataBaseConnection dataBase = new DataBaseConnection();

    @BeforeTest
    public static void driver() {

        WebDriverManager.getInstance().get("http://tickets.ua");

    }

    @AfterTest
    public static void closeDriver() throws SQLException {

        WebDriverManager.close();

    }

    @AfterSuite
    public static void close() throws SQLException {

        WebDriverManager.close();
        new DataBaseConnection().closeConnection();

    }

}
