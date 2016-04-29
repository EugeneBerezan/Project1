package Pages;

import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by EugeneBerezan on 3/28/16.
 */
public class KeyPressPage extends MainHomePage {

    private static final By YOU_ENTERED_TEXT_LOCATOR = By.id("result");
    private static final By KEY_PRESS_TEXT_LOCATOR = By.linkText("Key Press");

    public String getKeyPressText() {
        return driver.findElement(KEY_PRESS_TEXT_LOCATOR).getText();
    }

    public String getResult(){
        return driver.findElement(YOU_ENTERED_TEXT_LOCATOR).getText();
    }

    public KeyPressPage sendKeys() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_Z);
        return new KeyPressPage();

    }


}
