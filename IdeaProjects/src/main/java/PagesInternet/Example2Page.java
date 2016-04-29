package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/24/16.
 */
public class Example2Page extends DynamicLoadingPage {

    private final static By START_BUTTON_LOCATOR = By.xpath("//button[text()='Start']");
    private final static By HELLO_WORLD_TEXT_LOCATOR = By.xpath("//*[text()='Hello World!']");

    public Example1Page clickOnStartButton() {
        log.info("Clicking on Start button");
        driver.findElement(START_BUTTON_LOCATOR).click();

        return new Example1Page();
    }

    public String getHelloWorldText() {
        log.info("Getting assert text");
        return driver.findElement(HELLO_WORLD_TEXT_LOCATOR).getText();

    }

}
