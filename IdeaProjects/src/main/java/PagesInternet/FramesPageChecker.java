package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/25/16.
 */
public class FramesPageChecker extends FramesPage {

    private final static By LEFT_FRAME_LOCATOR = By.xpath("//frame[@name='frame-right']");
    private final static By MIDDLE_FRAME_LOCATOR = By.xpath("//frame[@name='middle-right']");
    private final static By RIGHT_FRAME_LOCATOR = By.xpath("//frame[@name='right-right']");
    private final static By BOTTOM_FRAME_LOCATOR = By.xpath("//frame[@name='bottom-right']");
    private final static By LEFT_TEXT_LOCATOR = By.linkText("LEFT");
    private final static By MIDDLE_TEXT_LOCATOR = By.linkText("MIDDLE");
    private final static By RIGHT_TEXT_LOCATOR = By.linkText("RIGHT");
    private final static By BOTTOM_TEXT_LOCATOR = By.linkText("BOTTOM");

    public FramesPageChecker switchToLeftFrame() {
        log.info("Switching to Left Frame");
        switchToFrame(LEFT_FRAME_LOCATOR);

        return new FramesPageChecker();
    }

    public FramesPageChecker switchToRightFrame() {
        log.info("Switching to Right Frame");
        switchToFrame(RIGHT_FRAME_LOCATOR);

        return new FramesPageChecker();
    }

    public FramesPageChecker switchToMiddleFrame() {
        log.info("Switching to Middle Frame");
        switchToFrame(MIDDLE_FRAME_LOCATOR);

        return new FramesPageChecker();
    }

    public FramesPageChecker switchToBottomFrame() {
        log.info("Switching to Bottom Frame");
        switchToFrame(BOTTOM_FRAME_LOCATOR);

        return new FramesPageChecker();
    }

    public String getTextFromLeftFrame() {
        log.info("Getting text from Left frame");
        return driver.findElement(LEFT_TEXT_LOCATOR).getText();
    }

    public String getTextFromRightFrame() {
        log.info("Getting text from Right frame");
        return driver.findElement(RIGHT_TEXT_LOCATOR).getText();
    }

    public String getTextFromMiddleFrame()
    {
        log.info("Getting text from Middle frame");
        return driver.findElement(MIDDLE_TEXT_LOCATOR).getText();
    }

    public String getTextFromBottomFrame() {
        log.info("Getting text from Bottom frame");
        return driver.findElement(BOTTOM_TEXT_LOCATOR).getText();
    }

}
