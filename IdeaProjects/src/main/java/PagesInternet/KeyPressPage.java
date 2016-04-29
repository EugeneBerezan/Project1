package PagesInternet;

import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by EugeneBerezan on 3/28/16.
 */
public class KeyPressPage extends MainHomePage {

    private static final By YOU_ENTERED_TEXT_LOCATOR = By.id("result");
    private static final By KEY_PRESS_TEXT_LOCATOR = By.xpath("//*[text()='Key Press']");

    public String getKeyPressText() {
        log.info("Getting assert text");

        return driver.findElement(KEY_PRESS_TEXT_LOCATOR).getText();
    }

    public String getResult() {
        log.info("Getting text you entered");

        return driver.findElement(YOU_ENTERED_TEXT_LOCATOR).getText();
    }

    public KeyPressPage sendKeys() throws AWTException {
        log.info("Typing letter Z using Robot");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_Z);
        robot.keyRelease(KeyEvent.VK_Z);
        return new KeyPressPage();
    }


}
