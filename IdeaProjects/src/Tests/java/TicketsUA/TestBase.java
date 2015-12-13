package TicketsUA;

import Driver.DataBaseConnection;
import Driver.WebDriverManager;
import PagesTicketsUA.HomePage;
import PagesTicketsUA.ResultPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.sql.SQLException;


public class TestBase {

    ResultPage resultPage = new ResultPage();
    HomePage homePage = new HomePage();
    DataBaseConnection dataBase = new DataBaseConnection();

    @BeforeClass
    public static void driver() {

        WebDriverManager.getInstance().get("http://tickets.ua");

    }

//    @AfterMethod
//    public static void tearDawn() {
//        WebDriverManager.close();
//    }

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
