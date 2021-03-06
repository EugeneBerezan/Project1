package PagesTicketsUA;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;


public class TicketsHomePage extends TicketsAbstractPage {

    //header Panel
    private By TICKETS_UA_HOME_LINK_LOCATOR = By.xpath("//a[contains(.,'Tickets')]");
    private By AVIA_TICKETS_LINK_LOCATOR = By.xpath("//li[@class='avia active']/a");
    private By GD_TICKETS_LINK_LOCATOR = By.xpath("//li[contains(@class,'gd')]/a");
    private By BUS_TICKET_LINK_LOCATOR = By.xpath("//li[contains(@class,'bus')]/a");
    private By HOTEL_LINK_LOCATOR = By.xpath("//li[contains(@class,'hotels')]/a");
    private By INSURANCE_LINK_LOCATOR = By.xpath("//li[contains(@class,'insurance')]/a");
    private By TRANSFER_LINK_LOCATOR = By.xpath("//li[contains(@class,'transfer')]/a");
    private By VIEW_MORE_LINK_LOCATOR = By.xpath("//a[contains(@title,'View')]");
    private By MY_TICKET_LINK_LOCATOR = By.xpath("//a[@class='do_login']");

    //select Travel point
    private By ONE_WAY_CHECKBOX_LOCATOR = By.id("oneway");
    private By ROUND_TRIP_CHECKBOX_LOCATOR = By.id("round_trip");
    private By COMPLEX_FLIGHT_CHECKBOX_LOCATOR = By.id("complex_flight");
    private By FROM_INPUT_LOCATOR = By.id("from_name");
    private By FROM_INPUT_FIRST_RESULT_LOCATOR = By.xpath("(//ul[@id='ui-id-1']//a)[1]");
    private By TO_INPUT_LOCATOR = By.id("to_name");
    private By TO_INPUT_FIRST_RESULT_LOCATOR = By.xpath("(//ul[@id='ui-id-2']//a)[1]");
    private By CLASS_SELECTION_DROP_DAWN_LOCATOR = By.id("Class_Select");
    private By DEPARTURE_FROM_DATE_SELECT_LOCATOR = By.id("departure_date");
    private By DEPARTURE_DATE_FROM_EXACT_TIME_SELEC_LOCATOR = By.id("(//div[contains(.,'time_field')]//a[contains(@id,'Selector')])[1]");
    private By ARRIVAL_TO_DATE_SELECT_LOCATOR = By.id("departure_date1");
    private By DEPARTURE_DATE_TO_EXACT_TIME_SELEC_LOCATOR = By.xpath("//div[contains(.,'time_field')]//a[contains(@id,'Selector')])[2]");
    private By PERSON_QUANTITY_SELEC_LOCATOR = By.xpath("//input[@class='preson_quant']");
    private By SEARCH_BUTON_LOCATOR = By.xpath("//a[@class='search_button']");


    public TicketsHomePage() {

    }

    public TicketsHomePage clickOnTickets() throws InterruptedException {
        log.info("Clicking on Tickets");

        driver.findElement(TICKETS_UA_HOME_LINK_LOCATOR).click();

        return this;
    }

    public TicketsHomePage clickOnAviaTickets() throws Exception {
        log.info("Clicking on AVIATICKETS");

        driver.findElement(AVIA_TICKETS_LINK_LOCATOR).click();

        return this;
    }

    public TicketsHomePage selectFromLocation(String travelingFrom) throws InterruptedException {
        log.info("Selecting location \"FROM\"");

        driver.findElement(FROM_INPUT_LOCATOR).clear();
        driver.findElement(FROM_INPUT_LOCATOR).sendKeys(travelingFrom);
        waitForElementVisible(10, FROM_INPUT_FIRST_RESULT_LOCATOR);
        driver.findElement(FROM_INPUT_FIRST_RESULT_LOCATOR).click();

        return this;
    }

    public TicketsHomePage selectToLocation(String travelingTo) throws InterruptedException {

        driver.findElement(TO_INPUT_LOCATOR).clear();
        driver.findElement(TO_INPUT_LOCATOR).sendKeys(travelingTo);

        try {
            log.info("Selecting location \"TO\"");

            waitForElementVisible(20, TO_INPUT_FIRST_RESULT_LOCATOR);
            driver.findElement(TO_INPUT_FIRST_RESULT_LOCATOR).click();

        } catch (TimeoutException e) {
            log.error("\"To\" location was selected after Timeout...: " + e.getMessage());
        }

        return this;
    }


    /**
     * @param dateOfDeparture = format "30.12.2015"
     */
    public TicketsHomePage selectDateOfDeparture(String dateOfDeparture) throws InterruptedException {
        log.info("Selecting date of depatrute with date: " + dateOfDeparture);

        driver.findElement(DEPARTURE_FROM_DATE_SELECT_LOCATOR).click();

        selectDate(dateOfDeparture);

        return this;
    }


    /**
     * @param dateOfArrival = format "30.12.2015"
     */
    public TicketsHomePage selectDateOfArrival(String dateOfArrival) throws InterruptedException {
        log.info("Selecting date of Arrival with date: " + dateOfArrival);

        selectDate(dateOfArrival);

        return this;
    }

    public TicketsHomePage clickSearchButton() {
        log.info("Clicking on \"Search\" button");

        driver.findElement(SEARCH_BUTON_LOCATOR).click();

        return this;

    }


}
