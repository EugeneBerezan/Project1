package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/22/16.
 */
public class DynamicControlPage extends MainHomePage {

    private static final By DYNAMIC_CONTROLS_TEXT_LOCATOR = By.xpath("//*[text()='Dynamic Controls']");
    private static final By REMOVE_BUTTON_LOCATOR = By.xpath("//button[@id='btn']");
    private static final By ADD_BUTTON_LOCATOR = By.xpath("//button[@id='btn']");
    private static final By CHECKBOX_LOCATOR = By.xpath("//input[@id='checkbox']");
    private static final By IT_IS_GONE_MESSAGE_LOCATOR = By.xpath("//*[@id='message']");
    private static final By IT_IS_BACK_MESSAGE_LOCATOR = By.xpath("//*[@id='message']");
    private static final By LOADING_ELEMENT_LOCATOR = By.id("loading");


    public void waitForLoadingDissapears(){
        waitForElementIsNotPresent(LOADING_ELEMENT_LOCATOR);
    }

    public boolean isCheckboxPresent() {
        waitForLoadingDissapears();
        return isElementPresent(CHECKBOX_LOCATOR);
    }

    public boolean isItIsGoneMessagePresent() {
        waitForLoadingDissapears();
        return isElementPresent(IT_IS_GONE_MESSAGE_LOCATOR);
    }

    public boolean isItIsBackMessagePresent() {
        waitForLoadingDissapears();
        return isElementPresent(IT_IS_BACK_MESSAGE_LOCATOR);
    }

    public String getDynamicControlsText() {
        log.info("Getting assert text");
        return driver.findElement(DYNAMIC_CONTROLS_TEXT_LOCATOR).getText();

    }

    public DynamicControlPage clickOnRemoveButton() {
        log.info("Clicking on Remove button");
        driver.findElement(REMOVE_BUTTON_LOCATOR).click();
        waitForLoadingDissapears();

        return new DynamicControlPage();
    }

    public DynamicControlPage clickOnAddButton() {
        log.info("Clicking on Add button");
        driver.findElement(ADD_BUTTON_LOCATOR).click();
        waitForLoadingDissapears();

        return new DynamicControlPage();
    }

    public DynamicControlPage selectCheckBox() {
        log.info("Selecting checkbox");
        driver.findElement(CHECKBOX_LOCATOR).click();

        return new DynamicControlPage();

    }

}
