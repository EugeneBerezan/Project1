package TicketsUA;

import Driver.DataBaseConnection;
import PagesTicketsUA.TicketsHomePage;
import PagesTicketsUA.TicketsResultPage;
import org.testng.annotations.Test;

public class TicketsTests extends BaseTest {

    @Test
    public void kievNewYorkFebruary() throws Exception {

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
//
//    @Test
//    public void kievNewYorkMay() throws Exception {
//
//        String locationFrom = "Kiev";
//        String locationTo = "New York";
//        String dateFrom = "08.05.2016";
//        String dateTo = "23.05.2016";
//
//        homePage
//                .clickOnAviaTickets()
//                .selectFromLocation(locationFrom)
//                .selectToLocation(locationTo)
//                .selectDateOfDeparture(dateFrom)
//                .selectDateOfArrival(dateTo)
//                .clickSearchButton();
//        resultPage
//                .waitUntilRouteIsCalculated()
//                .changeСurrencyToUSD()
//                .getMinPrice();
//        dataBase
//                .insertTicketsInfoIntoTable(locationFrom, locationTo, dateFrom, dateTo, resultPage.getMinPrice())
//                .getSelectFromTickets();
//
//    }
//
//    @Test
//    public void kievLosAngelesMay() throws Exception {
//
//        String locationFrom = "Kiev";
//        String locationTo = "New York";
//        String dateFrom = "08.05.2016";
//        String dateTo = "23.05.2016";
//
//        homePage
//                .clickOnAviaTickets()
//                .selectFromLocation(locationFrom)
//                .selectToLocation(locationTo)
//                .selectDateOfDeparture(dateFrom)
//                .selectDateOfArrival(dateTo)
//                .clickSearchButton();
//        resultPage
//                .waitUntilRouteIsCalculated()
//                .changeСurrencyToUSD()
//                .getMinPrice();
//        dataBase
//                .insertTicketsInfoIntoTable(locationFrom, locationTo, dateFrom, dateTo, resultPage.getMinPrice())
//                .getSelectFromTickets();
//
//    }
//

}
