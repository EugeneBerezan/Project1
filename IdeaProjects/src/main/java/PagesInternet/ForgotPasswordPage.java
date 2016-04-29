package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/24/16.
 */
public class ForgotPasswordPage extends MainHomePage {

    private static final By FORGOT_PASSWORD_TEXT_LOCATOR = By.xpath("//*[text()='Forgot Password']");
    private static final By EMAIL_INPUT_LOCATOR = By.id("email");
    private static final By RETRIEVE_PASSWORD_BUTTON_LOCATOR = By.id("form_submit");
    private static final By YOUR_EMAIL_HAS_BEEN_SENT_TEXT_LOCATOR = By.id("content");
    private static final By INTERNAL_SERVER_ERROR_TEXT_LOCATOR = By.xpath("//*[text()='Internal Server Error']");

    public String getInternalErrorTextLocator() {
        log.info("Getting \"Internal server error\"");
        return driver.findElement(INTERNAL_SERVER_ERROR_TEXT_LOCATOR).getText();
    }

    public String getForgotPasswordText() {
        log.info("Getting assert text");
        return driver.findElement(FORGOT_PASSWORD_TEXT_LOCATOR).getText();
    }

    public ForgotPasswordPage inputEmail(String email) {
        log.info("Inputting Email");
        driver.findElement(EMAIL_INPUT_LOCATOR).sendKeys(email);

        return new ForgotPasswordPage();
    }

    public ForgotPasswordPage clickOnRetrievePasswordButton() {
        log.info("Inputting Password");
        driver.findElement(RETRIEVE_PASSWORD_BUTTON_LOCATOR).click();

        return new ForgotPasswordPage();

    }

    public String getYourEmailHasBeenSendText() {
        log.info("Getting assert text");
        return driver.findElement(YOUR_EMAIL_HAS_BEEN_SENT_TEXT_LOCATOR).getText();
    }

}
