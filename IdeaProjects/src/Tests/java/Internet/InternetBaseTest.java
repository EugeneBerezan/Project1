package Internet;

import Driver.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 * Created by EugeneBerezan on 3/30/16.
 */
public class InternetBaseTest {

    @BeforeMethod
    public static void setUp(){

        WebDriverManager.getInstance().get("http://the-internet.herokuapp.com/");

    }

    @AfterMethod
    public void tearDown(){

        WebDriverManager.close();

    }

}
