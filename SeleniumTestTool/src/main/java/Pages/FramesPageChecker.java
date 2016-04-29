package Pages;

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

        switchToFrame(LEFT_FRAME_LOCATOR);

        return new FramesPageChecker();
    }

    public FramesPageChecker switchToRightFrame() {

        switchToFrame(RIGHT_FRAME_LOCATOR);

        return new FramesPageChecker();
    }

    public FramesPageChecker switchToMiddleFrame() {

        switchToFrame(MIDDLE_FRAME_LOCATOR);

        return new FramesPageChecker();
    }

    public FramesPageChecker switchToBottomFrame() {

        switchToFrame(BOTTOM_FRAME_LOCATOR);

        return new FramesPageChecker();
    }

    public String getTextFromLeftFrame() {
        return driver.findElement(LEFT_TEXT_LOCATOR).getText();
    }

    public String getTextFromRightFrame() {
        return driver.findElement(RIGHT_TEXT_LOCATOR).getText();
    }

    public String getTextFromMiddleFrame() {
        return driver.findElement(MIDDLE_TEXT_LOCATOR).getText();
    }

    public String getTextFromBottomFrame() {
        return driver.findElement(BOTTOM_TEXT_LOCATOR).getText();
    }

}
