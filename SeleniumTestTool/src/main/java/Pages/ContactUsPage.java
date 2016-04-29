package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/22/16.
 */
public class ContactUsPage extends DissapearingElementsPage{

    private final static By NOT_FOUND_TEXT_LOCATOR = By.xpath("//*[text()='Not Found']");

    public String getAssertText(){

        return driver.findElement(NOT_FOUND_TEXT_LOCATOR).getText();
    }

}
