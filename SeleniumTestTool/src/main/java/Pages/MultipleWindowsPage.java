package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/29/16.
 */
public class MultipleWindowsPage extends MainHomePage {

    private static final By OPENING_A_NEW_WINDOW_TEXT_LOCATOR = By.linkText("Opening a new window");
    private static final By CLICK_HERE_LINK_LOCATOR = By.linkText("Click Here");

    public String getWindowText() {
        return driver.findElement(OPENING_A_NEW_WINDOW_TEXT_LOCATOR).getText();
    }

    public newWindowPage getNewWindowString(){
        driver.findElement(CLICK_HERE_LINK_LOCATOR).click();
        return new newWindowPage();
    }

}
