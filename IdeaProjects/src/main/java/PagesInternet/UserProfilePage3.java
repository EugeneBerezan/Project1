package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/28/16.
 */
public class UserProfilePage3 extends HoversPage {

    private final static By NOT_FOUND_TEXT_LOCATOR = By.xpath("//*[text()='Not Found']");

    public String getNotFoundText() {
        return driver.findElement(NOT_FOUND_TEXT_LOCATOR).getText();
    }

}
