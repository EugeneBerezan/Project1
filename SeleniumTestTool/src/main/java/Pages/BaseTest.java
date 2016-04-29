package Pages;

import Tools.AbstractElement;
import Tools.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by EugeneBerezan on 3/17/16.
 */
public class BaseTest extends AbstractElement {

    @BeforeTest
    public void setUp() {

        WebDriverManager.getInstance().get("http://the-internet.herokuapp.com");

    }

    @AfterTest
    public void tearDown() {

        WebDriverManager.close();

    }

}
