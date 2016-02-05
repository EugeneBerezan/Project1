package Avis;

import Driver.DataBaseConnection;
import Driver.WebDriverManager;
import PagesAvis.AvisHomePage;
import PagesAvis.AvisProtectionAndCoveragePage;
import PagesAvis.AvisSelectACarPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.sql.SQLException;


public class AvisBaseTest extends AvisHomePage {

    AvisHomePage homePage = new AvisHomePage();
    DataBaseConnection dataBase = new DataBaseConnection();
    AvisProtectionAndCoveragePage protectionAndCoveragePage = new AvisProtectionAndCoveragePage();
    AvisSelectACarPage selectACarPage = new AvisSelectACarPage();


    @BeforeTest
    public static void setUp(){

        WebDriverManager.getInstance().get("http://avis.com");

    }

    @AfterTest
    public static void closeDriver() throws SQLException {
        WebDriverManager.close();
        new DataBaseConnection().closeConnection();
    }

}
