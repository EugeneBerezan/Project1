package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/25/16.
 */
public class FramesPage extends MainHomePage {

    private static final By NESTED_FRAMES_LINK_BUTTON_LOCATOR = By.linkText("Nested Frames");
    private static final By IFRAME_LINK_BUTTON_LOCATOR = By.linkText("iFrame");
    private static final By FRAMES_TEXT_LOCATOR = By.xpath("Frames");

    public String getFramesText() {
        return driver.findElement(FRAMES_TEXT_LOCATOR).getText();
    }

    public FramesPageChecker clickOnNestedFramesLink() {
        log.info("Clicking on Nested Frames button");
        driver.findElement(NESTED_FRAMES_LINK_BUTTON_LOCATOR).click();
        return new FramesPageChecker();
    }

    public IFramePage clickOnIFrameLink() {
        log.info("Clicking on iFrame link");
        driver.findElement(IFRAME_LINK_BUTTON_LOCATOR).click();
        return new IFramePage();
    }


}
