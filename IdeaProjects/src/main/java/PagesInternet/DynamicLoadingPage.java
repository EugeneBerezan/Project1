package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/23/16.
 */
public class DynamicLoadingPage extends MainHomePage {

    private static final By DYNAMIC_LOADING_TEXT_LOCATOR = By.xpath("//h3[text()='Dynamically Loaded Page Elements']");
    private static final By EXAMPLE_1_LINK_LOCATOR = By.xpath("//a[contains(text(),'Example 1')]");
    private static final By EXAMPLE_2_LINK_LOCATOR = By.xpath("//a[contains(text(),'Example 2')]");

    public String getDynamicLoadingText() {
        log.info("Getting assert text");
        return driver.findElement(DYNAMIC_LOADING_TEXT_LOCATOR).getText();

    }

    public Example1Page clickOnExample1Link() {
        log.info("Clicking on Example 1 link");
        driver.findElement(EXAMPLE_1_LINK_LOCATOR).click();

        return new Example1Page();

    }

    public Example2Page clickOnExample2Link() {
        log.info("Clicking on Example 2 link");
        driver.findElement(EXAMPLE_2_LINK_LOCATOR).click();

        return new Example2Page();
    }


}
