package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/29/16.
 */
public class NestedFramesPage extends MainHomePage {

    private static final By LEFT_FRAME_LOCATOR = By.xpath("//frame[@name='frame-left']");
    private static final By MIDDLE_FRAME_LOCATOR = By.xpath("//frame[@name='frame-middle']");
    private static final By RIGHT_FRAME_LOCATOR = By.xpath("//frame[@name='frame-right']");
    private static final By BOTTOM_FRAME_LOCATOR = By.xpath("//frame[@name='frame-bottom']");
    private static final By LEFT_TEXT_LOCATOR = By.linkText("LEFT");
    private static final By RIGHT_TEXT_LOCATOR = By.linkText("RIGHT");
    private static final By MIDDLE_TEXT_LOCATOR = By.linkText("MIDDLE");
    private static final By BOTTOM_TEXT_LOCATOR = By.linkText("BOTTOM");


    public NestedFramesPage switchToLeftFrame() {
        switchToFrame(LEFT_FRAME_LOCATOR);
        return new NestedFramesPage();
    }

    public NestedFramesPage switchToMiddleFrame() {
        switchToFrame(MIDDLE_FRAME_LOCATOR);
        return new NestedFramesPage();
    }

    public NestedFramesPage switchToRightFrame() {
        switchToFrame(RIGHT_FRAME_LOCATOR);
        return new NestedFramesPage();
    }

    public NestedFramesPage switchToBottomFrame() {
        switchToFrame(BOTTOM_FRAME_LOCATOR);
        return new NestedFramesPage();
    }

    public String getLeftFrameText() {
        return driver.findElement(LEFT_TEXT_LOCATOR).getText();
    }

    public String getRightFrameText() {
        return driver.findElement(RIGHT_TEXT_LOCATOR).getText();
    }

    public String getMiddleFrameText() {
        return driver.findElement(MIDDLE_TEXT_LOCATOR).getText();
    }

    public String getBottomFrameText() {
        return driver.findElement(BOTTOM_TEXT_LOCATOR).getText();
    }

}
