package PagesTicketsUA;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import Driver.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class TicketsAbstractPage {

    String currentYear = null;
    String currentMonth = null;

    public WebDriver driver = WebDriverManager.getInstance();

    public static void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    Logger log = LogManager.getLogger(getClass());

    public static String getMonthNumber(String monthName) {

        Map<String, String> month = new HashMap<String, String>();

        month.put("Январь", "01");
        month.put("Февраль", "02");
        month.put("Март", "03");
        month.put("Апрель", "04");
        month.put("Май", "05");
        month.put("Июнь", "06");
        month.put("Июль", "07");
        month.put("Август", "08");
        month.put("Сентябрь", "09");
        month.put("Октябрь", "10");
        month.put("Ноябрь", "11");
        month.put("Декабрь", "12");

        return month.get(monthName);
    }

    // TODO: 4/29/16 Needs to be reviewed
    public void selectDate(String date) throws InterruptedException {

        log.entry("Selecting date");

        String[] splitedDate = date.split("\\.");

        By NEXT_MONTH_LOCATOR = By.xpath("//span[text()='Next']");
        By CURRENT_MONTH_LOCATOR = By.xpath("//div[@id='ui-datepicker-div']/div[1]//div[@class='ui-datepicker-title']/span[1]");
        By SELECT_DATE_LOCATOR = By.xpath("//div[@id='ui-datepicker-div']/div[1]//tbody//td/a[text()='" + splitedDate[0] + "']");
        By CURRENT_YEAR_LOCATOR = By.xpath("//div[@id='ui-datepicker-div']/div[1]//div[@class='ui-datepicker-title']/span[2]");

        currentMonth = driver.findElement(CURRENT_MONTH_LOCATOR).getText();
        currentYear = driver.findElement(CURRENT_YEAR_LOCATOR).getText();
        currentMonth = driver.findElement(CURRENT_MONTH_LOCATOR).getText();
        currentYear = driver.findElement(CURRENT_YEAR_LOCATOR).getText();

        if (splitedDate[1].equals(getMonthNumber(currentMonth)) && splitedDate[2].equals(currentYear)) {
            waitForElementVisible(20, SELECT_DATE_LOCATOR);
            for (int i = 0; i < 5; i++) {
                try {
                    driver.findElement(SELECT_DATE_LOCATOR).click();
                } catch (NoSuchElementException e) {
                    log.error(e.getMessage());
                }
            }
        } else {
            waitForElementVisible(20, CURRENT_MONTH_LOCATOR);
            for (int i = 0; i < 24; i++) {
                currentMonth = driver.findElement(CURRENT_MONTH_LOCATOR).getText();
                currentYear = driver.findElement(CURRENT_YEAR_LOCATOR).getText();
            }
            if (!splitedDate[1].equals(getMonthNumber(currentMonth)) || !splitedDate[2].equals(currentYear)) {
                driver.findElement(NEXT_MONTH_LOCATOR).click();
                sleep(500);
            }
        }
        waitForElementVisible(20, SELECT_DATE_LOCATOR);
        for (int i = 0; i < 5; i++) {
            try {
                driver.findElement(SELECT_DATE_LOCATOR).click();
            } catch (NoSuchElementException | StaleElementReferenceException e) {
            }

            driver.findElement(SELECT_DATE_LOCATOR).click();
        }
    }


    public static void waitForElementVisible(int seconds, By locator) {

        WebDriverWait wait = new WebDriverWait(WebDriverManager.getInstance(), seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public static void waitForElementIsNotVisible(int seconds, By locator) {

        WebDriverWait wait = new WebDriverWait(WebDriverManager.getInstance(), seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }

}
