package TicketsUA;

import org.testng.annotations.Test;

public class Test2 extends TestBase {

    @Test
    public void secondTest() throws Exception {

        String locationFrom = "Moscow";
        String locationTo = "Los Angeles";
        String dateFrom = "25.04.16";
        String dateTo = "28.04.16";

        homePage
                .clickOnAviaTickets()
                .selectFromLocation(locationFrom)
                .selectToLocation(locationTo)
                .selectDateOfDeparture(dateFrom)
                .selectDateOfArrival(dateTo)
                .clickSearchButton();
        resultPage
                .waitUntilRouteIsCalculated()
                .changeСurrencyToUSD();
        dataBase
                .insertInfoIntoTable(locationFrom, locationTo, dateFrom, dateTo, resultPage.getMinPrice())
                .getResult();


    }

}
