package Tests;

import Pages.HomePage;
import Pages.ResultPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import Driver.WebDriverManager;
import Driver.DataBaseConnection;


public class Tests {

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

    @Test
    public void firstTest() throws Exception {

        String locationFrom = "Kiev";
        String locationTo = "New York";
        String dateFrom = "12.02.2016";
        String dateTo = "27.02.2016";

        homePage
                .clickOnAviaTickets()
                .selectFromLocation(locationFrom)
                .selectToLocation(locationTo)
                .selectDateOfDeparture(dateFrom)
                .selectDateOfArrival(dateTo)
                .clickSearchButton();
        resultPage
                .waitUntilRouteIsCalculated()
                .changeСurrencyToUSD()
                .getMinPrice();
        dataBase
                .insertInfoIntoTable(locationFrom, locationTo, dateFrom, dateTo, resultPage.getMinPrice())
                .getResult();


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
