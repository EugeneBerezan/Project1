package PagesInternet;

import Driver.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class InternetAbstractPage {

    Logger log = LogManager.getLogger(getClass());

    WebDriver driver = WebDriverManager.getInstance();

    public void authenticationLogin(String user, String password) {

        log.info("Performing authentication login with credentials: user - " + user + ", " + password + ".");

        WebDriverManager.getInstance().get("http://" + user + ":" + password + "@the-internet.herokuapp.com/basic_auth");

    }

    public void contextMenuClick(WebElement element) {

        log.info("Context click on element - " + element.toString());

        Actions actions = new Actions(driver);
        actions.contextClick(element);

    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public void dragAndDrop(WebElement from, WebElement to) throws InterruptedException, AWTException, FileNotFoundException {

        log.info("Performing drag and drop action");

        File fileText = new File("/Users/EugeneBerezan/IdeaProjects/src/dnd.js");
        String content = new Scanner(fileText).useDelimiter("\\Z").next();

        ((JavascriptExecutor) driver).executeScript(content + "$('" + from + "').simulateDragDrop({ dropTarget: '" + to + "'});");

//        Actions builder = new Actions(driver);
//        Action drag = builder.clickAndHold(from).build();
//        drag.perform();
//
//        Point coordinatesFrom = from.getLocation();
//        Point coordinatesTo = to.getLocation();
//        Robot robot = new Robot(); //Robot for controlling mouse actions
//        robot.mouseMove(coordinatesFrom.getX(), coordinatesFrom.getY());
//        robot.mousePress(1);
//        robot.mouseMove(coordinatesTo.getX(),coordinatesTo.getY()+120);
//        robot.mouseRelease(1);
//        Thread.sleep(1000);


    }

    public void selectFromDropDown(WebElement element, String option) {

        log.info("Selecting " + option + "from dropdown");

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

    public void mouserHoverOnElement(By locator) {

        log.info("Hovering mouse on element " + locator.toString());
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).build().perform();

    }

    public void scrollDown(int times) {
        log.info("scrolling down " + times + "times");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 1; i <= times; i++) {
            jse.executeScript("window.scrollBy(0,250)");
        }

    }

    public void waitForElementIsPresent(By locator) {

        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitForElementIsNotPresent(By locator) {

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void switchToFrame(By locator) {
        log.info("Switching to frame " + locator.toString());
        driver.switchTo().frame(driver.findElement(locator));
    }

    public void switchToDefaultContent() {
        log.info("Switching to default content");

        driver.switchTo().defaultContent();
    }

    public void switchToAlert() {
        log.info("Switching to Alert");
        Alert alert = driver.switchTo().alert();
    }

    public void escapeButtonToDismissAlert() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    public void dismissAlert() {
        log.info("Dismissing Alert");
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void authenticationLoginUsingSelenium(String user, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = driver.switchTo().alert();
        alert.authenticateUsing(new UserAndPassword(user, password));
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void alertSendKeys(String keys) {
        log.info("Sending keys to Alert");
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(keys);
        alert.accept();
    }

    public String getAlertText() {
        log.info("Getting text from Alert");

        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void switchToNextTab() {
        log.info("Switching to next tab");

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void switchToTab(int tabNumber) {
        log.info("Switching to tab with number " + tabNumber);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber-1));
    }

}
