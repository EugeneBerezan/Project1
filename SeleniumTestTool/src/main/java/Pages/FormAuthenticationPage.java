package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/25/16.
 */
public class FormAuthenticationPage extends MainHomePage {

    private final static By LOGIN_PAGE_TEXT_LOCATOR = By.xpath("//*[text()='Login Page']");
    private final static By USERNAME_INPUT_LOCATOR = By.id("username");
    private final static By PASSWORD_INPUT_LOCATOR = By.id("password");
    private final static By LOGIN_BUTTON_LOCATOR = By.id("login");
    private final static By INVALID_CREDENTIALS_MESSAGE_LOCATOR = By.id("flash");

    String correctUserName = "tomsmith";
    String correctPassword = "SuperSecretPassword!";
    String inCorrectUserName = "UserName";
    String inCorrectPassword = "UserPassword";

    public String getLoginPageText() {
        return driver.findElement(LOGIN_PAGE_TEXT_LOCATOR).getText();
    }

    public FormAuthenticationPage inputInCorrectUserName() {
        driver.findElement(USERNAME_INPUT_LOCATOR).sendKeys(inCorrectUserName);
        return new FormAuthenticationPage();
    }

    public FormAuthenticationPage inputInCorrectUserPassword() {
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(inCorrectPassword);
        return new FormAuthenticationPage();
    }

    public FormAuthenticationPage inputCorrectUserName() {
        driver.findElement(USERNAME_INPUT_LOCATOR).sendKeys(correctUserName);
        return new FormAuthenticationPage();
    }

    public FormAuthenticationPage inputCorrectUserPassword() {
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(correctPassword);
        return new FormAuthenticationPage();
    }

    public FormAuthenticationPage clickOnLoginButton() {
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
        return new SecureAreaPage();
    }

    public boolean isInvalidCredentialsMessageAppeared() {
        return isElementPresent(INVALID_CREDENTIALS_MESSAGE_LOCATOR);
    }

}
