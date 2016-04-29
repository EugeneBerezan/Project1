package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/25/16.
 */
public class FormAuthenticationPage extends MainHomePage {

    private final static By LOGIN_PAGE_TEXT_LOCATOR = By.xpath("//*[text()='Login Page']");
    private final static By USERNAME_INPUT_LOCATOR = By.id("username");
    private final static By PASSWORD_INPUT_LOCATOR = By.id("password");
    private final static By LOGIN_BUTTON_LOCATOR = By.xpath("//button");
    private final static By INVALID_CREDENTIALS_MESSAGE_LOCATOR = By.id("flash");
    private final static By SECURE_AREA_TEXT_LOCATOR = By.xpath("//*[contains(text(),'Welcome to the Secure Area')]");

    String correctUserName = "tomsmith";
    String correctPassword = "SuperSecretPassword!";
    String inCorrectUserName = "UserName";
    String inCorrectPassword = "UserPassword";

    public String getLoginPageText() {
        log.info("Getting assert text");
        return driver.findElement(LOGIN_PAGE_TEXT_LOCATOR).getText();
    }

    public boolean isSeruceAreaDisplayed(){
        return driver.findElement(SECURE_AREA_TEXT_LOCATOR).isDisplayed();
    }

    public FormAuthenticationPage inputInCorrectUserName() {
        log.info("Inputting incorrect User Name");
        driver.findElement(USERNAME_INPUT_LOCATOR).sendKeys(inCorrectUserName);
        return new FormAuthenticationPage();
    }

    public FormAuthenticationPage inputInCorrectUserPassword() {
        log.info("Inputting incorrect User Password");
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(inCorrectPassword);
        return new FormAuthenticationPage();
    }

    public FormAuthenticationPage inputCorrectUserName() {
        log.info("Inputting correct User Name");
        driver.findElement(USERNAME_INPUT_LOCATOR).sendKeys(correctUserName);
        return new FormAuthenticationPage();
    }

    public FormAuthenticationPage inputCorrectUserPassword() {
        log.info("Inputting correct User Password");
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(correctPassword);
        return new FormAuthenticationPage();
    }

    public FormAuthenticationPage clickOnLoginButton() {
        log.info("Clicking on Login button");
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
        return new SecureAreaPage();
    }

    public boolean isInvalidCredentialsMessageAppears() {
        log.info("Getting invalid credentials message");
        return isElementPresent(INVALID_CREDENTIALS_MESSAGE_LOCATOR);
    }

}
