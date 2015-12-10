package PagesAvis;


import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 12/8/15.
 */
public class HomePage extends AbstractPage{

    public static final By AVIS_HOME_ICON = By.xpath("//a[@title='AVIS']");
    public static final By MAKE_A_RESERVATION_TAB_LOCATOR = By.xpath("//a[@id='makeResWidget']");
    public static final By PICK_A_LOCATION_INPUT_LOCATOR = By.xpath("//input[@id='location']");
    public static final By RETURN_TO_DIFFERENT_LOCATION_CHECKBOX_LOCATOR = By.xpath("//input[@id='sameLoc']");
    public static final By DATE_FROM_INPUT_LOCATOR = By.xpath("//input[@id='from']");
    public static final By DATE_TO_INPUT_LOCATOR = By.xpath("//input[@id='to']");
    public static final By AGE_SELECT_LOCATOR = By.xpath("//select[@id='age']");
    public static final By RESIDENT_OF_COUNTRY_SELECT_LOCATOR = By.xpath("//select[@id='countrys']");
    public static final By SELECT_MY_CAR_BUTTON_LOCATOR = By.xpath("//a[text()='Select My Car']");


    public HomePage clickOnAvisHome(){

        log.info("Clicking on Home button");
        driver.findElement(AVIS_HOME_ICON).click();

        return this;
    }


    public HomePage makeAReservationTabOpen(){

        log.info("Make a reservation tab opening");
        driver.findElement(MAKE_A_RESERVATION_TAB_LOCATOR).click();

        return this;
    }

    /**
     *
     * @return
     * @param date date Format = '31.12.2015'
     */
    public HomePage selectPickUpDate(String date){

        driver.findElement(DATE_FROM_INPUT_LOCATOR).click();
        selectDate(date);

        return this;
    }

    /**
     *
     * @return
     * @param date date Format = '31.12.2015'
     */
    public HomePage selectDropLocation(String date){

        driver.findElement(DATE_TO_INPUT_LOCATOR).click();
        selectDate(date);

        return this;
    }

    public HomePage selectPickUpLocation(String pickUpLocation){

        driver.findElement(PICK_A_LOCATION_INPUT_LOCATOR).sendKeys(pickUpLocation);

        return this;
    }

    public HomePage selectAge(String age){

        selectByVisibleText(AGE_SELECT_LOCATOR, age);

        return this;
    }



}
