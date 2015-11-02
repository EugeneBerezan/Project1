package Pages;

import org.openqa.selenium.By;

public class HomePage {

    //header Panel
    public static final By TACKETS_UA_HOME_LINK_LOCATOR = By.xpath("//a[contains(.,'Tickets')]");
    public static final By AVIA_TICKETS_LINK_LOCATOR = By.xpath("//li[@class='avia active']/a");
    public static final By GD_TICKETS_LINK_LOCATOR = By.xpath("//li[contains(@class,'gd')]/a");
    public static final By BUS_TICKET_LINK_LOCATOR = By.xpath("//li[contains(@class,'bus')]/a");
    public static final By HOTEL_LINK_LOCATOR = By.xpath("//li[contains(@class,'hotels')]/a");
    public static final By INSURANCE_LINK_LOCATOR = By.xpath("//li[contains(@class,'insurance')]/a");
    public static final By TRANSFER_LINK_LOCATOR = By.xpath("//li[contains(@class,'transfer')]/a");
    public static final By VIEW_MORE_LINK_LOCATOR = By.xpath("//a[contains(@title,'View')]");
    public static final By MY_TICKET_LINK_LOCATOR = By.xpath("//a[@class='do_login']");

    //select Travel point
    public static final By ONE_WAY_CHECKBOX_LOCATOR = By.id("oneway");
    public static final By ROUND_TRIP_CHECKBOX_LOCATOR = By.id("round_trip");
    public static final By COMPLEX_FLIGHT_CHECKBOX_LOCATOR = By.id("complex_flight");
    public static final By FROM_INPUT_LOCATOR = By.id("from_name");
    public static final By TO_INPUT_LOCATOR = By.id("to_name");
    public static final By CLASS_SELECTION_DROP_DAWN_LOCATOR = By.id("Class_Select");
    public static final By DEPARTURE_FROM_DATE_SELECT_LOCATOR = By.id("departure_date");
    public static final By DEPARTURE_DATE_FROM_EXACT_TIME_SELEC_LOCATOR = By.id("(//div[contains(.,'time_field')]//a[contains(@id,'Selector')])[1]");
    public static final By DEPARTURE_TO_DATE_SELECT_LOCATOR = By.id("departure_date1");
    public static final By DEPARTURE_DATE_TO_EXACT_TIME_SELEC_LOCATOR = By.id("(//div[contains(.,'time_field')]//a[contains(@id,'Selector')])[2]");
    public static final By PERSON_QUANTITY_SELEC_LOCATOR = By.id("//input[@class='preson_quant']");
    public static final By SEARCH_BUTON_LOCATOR = By.id("//a[@class='search_button']");


    public HomePage clickOnTicketsUAHomeButton(){
        

        return new HomePage();
    }







}
