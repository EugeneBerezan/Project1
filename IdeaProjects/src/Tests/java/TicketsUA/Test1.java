package TicketsUA;

import org.testng.annotations.Test;


public class Test1 extends BaseTest {

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
                .insertTicketsInfoIntoTable(locationFrom, locationTo, dateFrom, dateTo, resultPage.getMinPrice())
                .getSelectFromTickets();

    }
}
