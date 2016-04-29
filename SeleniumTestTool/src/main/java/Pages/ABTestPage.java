package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/17/16.
 */
public class ABTestPage extends MainHomePage {

    public static final By AB_TEST_VARIATION_1_TEXT_LOCATOR = By.linkText("A/B Test Variation");

    public String getABTestText() {
        return driver.findElement(AB_TEST_VARIATION_1_TEXT_LOCATOR).getText();
    }

    public String getCurrentURL() {

        return driver.getCurrentUrl();
    }


}
