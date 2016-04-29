package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/29/16.
 */
public class NewWindowPage extends MultipleWindowsPage {

    private static final By NEW_WINDOW_TEXT_LOCATOR = By.xpath("//h3[text()='New Window']");

    public String getNewWindowText() {
        switchToTab(2);
        return driver.findElement(NEW_WINDOW_TEXT_LOCATOR).getText();
    }

}
