import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Tests {

    @AfterTest
    public static void tearDawn() {
        WebDriverManager.close();
    }

    @Test
    public void firstTest() throws Exception {

        new HomePage().clickOnAviaTickets().selectDateOfDeparture("12.02.2016");

    }

}
