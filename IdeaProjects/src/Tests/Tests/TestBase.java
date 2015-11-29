import Driver.DataBaseConnection;
import Driver.WebDriverManager;
import Pages.HomePage;
import Pages.ResultPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;


public class TestBase {

    ResultPage resultPage = new ResultPage();
    HomePage homePage = new HomePage();
    DataBaseConnection dataBase = new DataBaseConnection();

    @AfterMethod
    public static void tearDawn() {
        WebDriverManager.close();
    }

    @AfterTest
    public static void closeDriver() {
        WebDriverManager.close();
    }

}
