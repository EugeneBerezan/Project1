package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/28/16.
 */
public class JavaScriptAlertPage extends MainHomePage {

    private final static By JAVASCRIPT_ALERTS_TEXT_LOCATOR = By.linkText("JavaScript Alerts");
    private final static By CLICK_FOR_JS_ALERT_BUTTON_LOCATOR = By.xpath("//button[text()='Click for JS Alert']");
    private final static By CLICK_FOR_JS_CONFIRM_BUTTON_LOCATOR = By.xpath("//button[text()='Click for JS Confirm']");
    private final static By CLICK_FOR_JS_PROMPT_BUTTON_LOCATOR = By.xpath("//button[text()='Click for JS Prompt']");
    private final static By RESULT_TEXT_LOCATOR = By.id("result");

    public String getResult() {
        log.info("Getting assert text");
        return driver.findElement(RESULT_TEXT_LOCATOR).getText();
    }

    public String getJavaScriptAlertText() {
        log.info("Getting JavaScript alert");
        return driver.findElement(JAVASCRIPT_ALERTS_TEXT_LOCATOR).getText();
    }

    public JavaScriptAlertPage acceptJSAlert() {
        log.info("Clicking on \"Click for JS alert\"");
        driver.findElement(CLICK_FOR_JS_ALERT_BUTTON_LOCATOR).click();
        acceptAlert();
        return new JavaScriptAlertPage();
    }

    public JavaScriptAlertPage dismissJSAlert() {
        log.info("Clicking and dismissing \"Click for JS alert\"");
        driver.findElement(CLICK_FOR_JS_ALERT_BUTTON_LOCATOR).click();
        dismissAlert();
        return new JavaScriptAlertPage();
    }

    public JavaScriptAlertPage acceptJSConfirm() {
        log.info("Accepting \"JS Confirm\"");
        driver.findElement(CLICK_FOR_JS_CONFIRM_BUTTON_LOCATOR).click();
        acceptAlert();
        return new JavaScriptAlertPage();
    }

    public JavaScriptAlertPage dismissJSConfirm() {
        log.info("Dismissing \"JS Confirm\"");
        driver.findElement(CLICK_FOR_JS_CONFIRM_BUTTON_LOCATOR).click();
        dismissAlert();
        return new JavaScriptAlertPage();
    }

    public JavaScriptAlertPage acceprJSPrompt() {
        log.info("Accepting \"JS Prompt\"");
        driver.findElement(CLICK_FOR_JS_PROMPT_BUTTON_LOCATOR).click();
        acceptAlert();
        return new JavaScriptAlertPage();
    }

    public JavaScriptAlertPage dismissJSPrompt() {
        log.info("Dismissing \"JS Prompt\"");
        driver.findElement(CLICK_FOR_JS_PROMPT_BUTTON_LOCATOR).click();
        dismissAlert();
        return new JavaScriptAlertPage();
    }

    public JavaScriptAlertPage sendKeysJSPrompt(String keys) {
        log.info("Sending keys to \"JS Prompt\"");
        driver.findElement(CLICK_FOR_JS_PROMPT_BUTTON_LOCATOR).click();
        alertSendKeys(keys);
        return new JavaScriptAlertPage();
    }


}
