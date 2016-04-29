package Tools;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractElement {

    public WebDriver driver = WebDriverManager.getInstance();

    public void authenticationLogin(String user, String password) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.authenticateUsing(new UserAndPassword(user, password));

    }

    public void contextMenuClick(WebElement element) {

        Actions actions = new Actions(driver);
        actions.contextClick(element);

    }

    public void dragAndDrop(WebElement from, WebElement to) {

        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(from)
                .moveToElement(to)
                .release(to)
                .build();
        dragAndDrop.perform();

    }

    public void selectFromDropDown(WebElement element, String option) {

        Select select = new Select(element);
        select.selectByVisibleText(option);

    }

    public boolean isElementPresent(By locator) {

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        List<WebElement> list = driver.findElements(locator);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (list.size() == 0) return false;
        else return list.get(0).isDisplayed();

    }

    public void mouserOverOnElement(By locator) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator));

    }

    public void scrollDown(int times) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 1; i <= times; i++) {
            jse.executeScript("window.scrollBy(0,250)");
        }

    }

    public void switchToFrame(By locator) {

        driver.switchTo().frame(driver.findElement(locator));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void switchToAlert() {
        Alert alert = driver.switchTo().alert();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void alertSendKeys(String keys) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(keys);
        alert.accept();
    }

    public void getAlertText() {
        Alert alert = driver.switchTo().alert();
        alert.getText();
    }

    public void switchToNextTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void switchToTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }

}
