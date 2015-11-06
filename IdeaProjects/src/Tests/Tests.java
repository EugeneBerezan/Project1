package Tests;

import Pages.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import Driver.WebDriverManager;

public class Tests {

    @AfterTest
    public static void tearDawn() {
        WebDriverManager.close();
    }

    @Test
    public void firstTest() throws Exception {

        new HomePage()
                .clickOnAviaTickets()
                .selectFromLocation("Kiev")
                .selectToLocation("New York")
                .selectDateOfDeparture("12.02.2016")
                .selectDateOfArrival("27.02.2016")
                .clickSearchButton();

    }

}
