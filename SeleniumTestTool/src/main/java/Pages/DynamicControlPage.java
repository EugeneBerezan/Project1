package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/22/16.
 */
public class DynamicControlPage extends MainHomePage {

    private static final By DYNAMIC_CONTROLS_TEXT_LOCATOR = By.xpath("//*[text()='Dynamic Controls']");
    private static final By BUTTON_LOCATOR = By.xpath("//button[@id='btn']");
    private static final By CHECKBOX_LOCATOR = By.xpath("//input[@id='checkbox']");
    private static final By IT_IS_DONE_MESSAGE_LOCATOR = By.xpath("//*[@id='message']");

    public String getDynamicControlsText() {

        return driver.findElement(DYNAMIC_CONTROLS_TEXT_LOCATOR).getText();

    }

    public DynamicControlPage clickOnButton() {

        driver.findElement(BUTTON_LOCATOR).click();

        return new DynamicControlPage();
    }

    public DynamicControlPage selectCheckBox() {

        driver.findElement(CHECKBOX_LOCATOR).click();

        return new DynamicControlPage();

    }

}
