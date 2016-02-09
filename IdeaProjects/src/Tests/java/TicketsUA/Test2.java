package TicketsUA;

import Driver.DataBaseConnection;
import PagesTicketsUA.TicketsHomePage;
import PagesTicketsUA.TicketsResultPage;
import org.testng.annotations.Test;

/**
 * Created by EugeneBerezan on 2/9/16.
 */
public class Test2 extends BaseTest {

    @Test
    public void kievLosAngelesFebruary() throws Exception {

        String locationFrom = "Kiev";
        String locationTo = "New York";
        String dateFrom = "12.02.2016";
        String dateTo = "27.02.2016";

        new TicketsHomePage()
                .clickOnAviaTickets()
                .selectFromLocation(locationFrom)
                .selectToLocation(locationTo)
                .selectDateOfDeparture(dateFrom)
                .selectDateOfArrival(dateTo)
                .clickSearchButton();

        TicketsResultPage ticketsResultPage = new TicketsResultPage();
        ticketsResultPage
                .waitUntilRouteIsCalculated()
                .changeСurrencyToUSD()
                .getMinPrice();

        new DataBaseConnection()
                .insertTicketsInfoIntoTable(locationFrom, locationTo, dateFrom, dateTo, ticketsResultPage.getMinPrice())
                .getSelectFromTickets();

    }
}