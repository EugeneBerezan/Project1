package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/28/16.
 */
public class JavaScriptAlertPage extends MainHomePage {

    private final static By JAVASCRIPT_ALERTS_TEXT_LOCATOR = By.linkText("JavaScript Alerts");
    private final static By CLICK_FOR_JS_ALERT_BUTTON_LOCATOR = By.linkText("Click for JS Alert");
    private final static By CLICK_FOR_JS_CONFIRM_BUTTON_LOCATOR = By.linkText("Click for JS Confirm");
    private final static By CLICK_FOR_JS_PROMPT_BUTTON_LOCATOR = By.linkText("Click for JS Prompt");
    private final static By RESULT_TEXT_LOCATOR = By.id("result");

    public String getResult() {
        return driver.findElement(RESULT_TEXT_LOCATOR).getText();
    }

    public String getJavaScriptAlertText() {
        return driver.findElement(JAVASCRIPT_ALERTS_TEXT_LOCATOR).getText();
    }

    public JavaScriptAlertPage acceptJSAlert() {
        driver.findElement(CLICK_FOR_JS_ALERT_BUTTON_LOCATOR).click();
        acceptAlert();
        return new JavaScriptAlertPage();
    }

    public JavaScriptAlertPage dismissJSAlert() {
        driver.findElement(CLICK_FOR_JS_ALERT_BUTTON_LOCATOR).click();
        dismissAlert();
        return new JavaScriptAlertPage();
    }

    public JavaScriptAlertPage acceptJSConfirm() {
        driver.findElement(CLICK_FOR_JS_CONFIRM_BUTTON_LOCATOR).click();
        acceptAlert();
        return new JavaScriptAlertPage();
    }

    public JavaScriptAlertPage dismissJSConfirm() {
        driver.findElement(CLICK_FOR_JS_CONFIRM_BUTTON_LOCATOR).click();
        dismissAlert();
        return new JavaScriptAlertPage();
    }

    public JavaScriptAlertPage acceprJSPrompt() {
        driver.findElement(CLICK_FOR_JS_PROMPT_BUTTON_LOCATOR).click();
        acceptAlert();
        return new JavaScriptAlertPage();
    }

    public JavaScriptAlertPage dismissJSPrompt() {
        driver.findElement(CLICK_FOR_JS_PROMPT_BUTTON_LOCATOR).click();
        dismissAlert();
        return new JavaScriptAlertPage();
    }

    public JavaScriptAlertPage sendKeysJSPrompt(String keys) {
        driver.findElement(CLICK_FOR_JS_PROMPT_BUTTON_LOCATOR).click();
        alertSendKeys(keys);
        return new JavaScriptAlertPage();
    }


}
