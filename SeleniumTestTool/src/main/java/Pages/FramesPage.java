package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/25/16.
 */
public class FramesPage extends MainHomePage {

    private static final By NESTED_FRAMES_LINK_BUTTON = By.linkText("Nested Frames");
    private static final By IFRAME_LINK_BUTTON = By.linkText("iFrame");

    public FramesPageChecker clickOnNestedFramesLink() {
        driver.findElement(NESTED_FRAMES_LINK_BUTTON).click();
        return new FramesPageChecker();
    }

    public FramesPageChecker clickOnIFrameLink() {
        driver.findElement(IFRAME_LINK_BUTTON).click();
        return new IFramePage();
    }


}
