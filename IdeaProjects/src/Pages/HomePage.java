package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;


public class HomePage extends AbstractPage {

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


    public HomePage() {


    }


    public HomePage clickOnTickets() throws InterruptedException {

        driver.findElement(TICKETS_UA_HOME_LINK_LOCATOR).click();

        return this;
    }

    public HomePage clickOnAviaTickets() throws Exception {

        driver.findElement(AVIA_TICKETS_LINK_LOCATOR).click();

        return this;
    }

    public HomePage selectFromLocation(String travelingFrom) throws InterruptedException {

        driver.findElement(FROM_INPUT_LOCATOR).sendKeys(travelingFrom);
        sleep(500);
        AbstractPage.waitForElementVisible(10, FROM_INPUT_FIRST_RESULT_LOCATOR);
        driver.findElement(FROM_INPUT_FIRST_RESULT_LOCATOR).click();

        return this;
    }

    public HomePage selectToLocation(String travelingTo) throws InterruptedException {

        driver.findElement(TO_INPUT_LOCATOR).sendKeys(travelingTo);

        try {

            AbstractPage.waitForElementVisible(10, TO_INPUT_FIRST_RESULT_LOCATOR);
            driver.findElement(TO_INPUT_FIRST_RESULT_LOCATOR).click();

        } catch (TimeoutException e) {

            log.error("\"To\" location was not selected");

        }

        return this;
    }


    /**
     * @param dateOfDeparture = format "30.12.2015"
     */
    public HomePage selectDateOfDeparture(String dateOfDeparture) throws InterruptedException {

        driver.findElement(DEPARTURE_FROM_DATE_SELECT_LOCATOR).click();

        selectDate(dateOfDeparture);

        return this;
    }


    /**
     * @param dateOfArrival = format "30.12.2015"
     */
    public HomePage selectDateOfArrival(String dateOfArrival) throws InterruptedException {

        selectDate(dateOfArrival);

        return this;
    }

    public HomePage clickSearchButton() {

        driver.findElement(SEARCH_BUTON_LOCATOR).click();

        return this;

    }


}
