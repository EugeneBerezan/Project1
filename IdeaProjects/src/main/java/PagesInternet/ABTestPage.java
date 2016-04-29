package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/17/16.
 */
public class ABTestPage extends MainHomePage {

    public static final By AB_TEST_VARIATION_1_TEXT_LOCATOR = By.xpath("//*[@id='content']//h3");

    public String getABTestText() {
        log.info("Getting assert text");

        return driver.findElement(AB_TEST_VARIATION_1_TEXT_LOCATOR).getText();
    }

    public String getCurrentURL() {
        log.info("Getting current URL");

        return driver.getCurrentUrl();
    }


}
