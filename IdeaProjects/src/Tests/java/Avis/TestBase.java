package Avis;

import Driver.DataBaseConnection;
import Driver.WebDriverManager;
import PagesAvis.ProtectionAndCoveragePage;
import PagesAvis.SelectACarPage;
import PagesTicketsUA.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


public class TestBase {

    HomePage homePage = new HomePage();
    DataBaseConnection dataBase = new DataBaseConnection();
    ProtectionAndCoveragePage protectionAndCoveragePage = new ProtectionAndCoveragePage();
    SelectACarPage selectACarPage = new SelectACarPage();

    @BeforeClass
    public static void driver(){

        WebDriverManager.getInstance().get("http://tickets.ua");

    }

    @AfterTest
    public static void closeDriver() {
        WebDriverManager.close();
    }

}
