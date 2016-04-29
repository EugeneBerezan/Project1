package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/24/16.
 */
public class FloatingMenuPage extends MainHomePage {

    private final static By FLOATING_MENU_TEXT_LOCATOR = By.xpath("//*[text()='Floating Menu']");
    private final static By HOME_LINK_LOCATOR = By.xpath("//a[text()='Home']");
    private final static By NEWS_LINK_LOCATOR = By.xpath("//a[text()='News']");
    private final static By CONTACT_LINK_LOCATOR = By.xpath("//a[text()='Contact']");
    private final static By ABOUT_LINK_LOCATOR = By.xpath("//a[text()='About']");

    public String getFloatingMenuText() {
        log.info("Getting Assert text");
        return driver.findElement(FLOATING_MENU_TEXT_LOCATOR).getText();
    }

    public FloatingMenuPage clickOnHomeLink() {
        log.info("Clicking on Home link");
        driver.findElement(HOME_LINK_LOCATOR).click();

        return this;
    }

    public FloatingMenuPage clickOnContactLink() {
        log.info("Clicking on Contact link");
        driver.findElement(CONTACT_LINK_LOCATOR).click();

        return this;
    }

    public FloatingMenuPage clickOnAboutLink() {
        log.info("Clicking on About link");
        driver.findElement(ABOUT_LINK_LOCATOR).click();

        return this;
    }

    public FloatingMenuPage clickOnNewsLink() {
        log.info("Clicking on News link");
        driver.findElement(NEWS_LINK_LOCATOR).click();

        return this;
    }



}
