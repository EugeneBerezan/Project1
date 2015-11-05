import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Tests {

    public static WebDriver driver;

    @BeforeClass
    public static void setUP() {

    }

    @AfterTest
    public static void tearDawn() {
        driver.close();
        driver.quit();
    }

    @Test
    public void firstTest() throws InterruptedException {

        new HomePage().clickOnTickets();


    }

}
