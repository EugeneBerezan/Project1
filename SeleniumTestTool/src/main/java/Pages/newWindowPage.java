package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/29/16.
 */
public class newWindowPage extends MultipleWindowsPage {

    private static final By NEW_WINDOW_TEXT_LOCATOR = By.linkText("New Window");

    public String getNewWindowText() {
        return driver.findElement(NEW_WINDOW_TEXT_LOCATOR).getText();
    }

}
