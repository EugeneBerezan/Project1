package Tests;

import Pages.HomePage;
import Pages.ResultPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import Driver.WebDriverManager;

public class Tests {

    @AfterMethod
    public static void tearDawn() {
        WebDriverManager.close();
    }

    @AfterTest
    public static void closeDriver() {
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
        new ResultPage()
                .waitUntilRouteIsCalculated()
                .changeСurrencyToUSD();


    }


    @Test
    public void secondTest() throws Exception {

        new HomePage()
                .clickOnAviaTickets()
                .selectFromLocation("Moscow")
                .selectToLocation("Los Angeles")
                .selectDateOfDeparture("25.04.16")
                .selectDateOfArrival("28.04.16")
                .clickSearchButton();
        new ResultPage()
                .waitUntilRouteIsCalculated()
                .changeСurrencyToUSD();

    }
}
