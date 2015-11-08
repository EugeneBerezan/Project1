package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.StringBuilders;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Driver.WebDriverManager;

import java.util.HashMap;
import java.util.Map;

public class AbstractPage {

    String currentYear = null;
    String currentMonth = null;

    WebDriver driver = WebDriverManager.getInstance();

    public static void sleep(int miliseconds) throws InterruptedException {
        Thread.sleep(miliseconds);
    }

    Logger log = LogManager.getLogger(getClass());


    public static String getMonthNumber(String monthName) {

        Map<String, String> month = new HashMap<>();

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

    public void selectDateFrom(String date) throws InterruptedException {

        String[] splitedDate = date.split("\\.");

        By NEXT_MONTH_LOCATOR = By.xpath("//span[text()='Next']");
        By CURRENT_MONTH_LOCATOR = By.xpath("//div[@id='ui-datepicker-div']/div[1]//div[@class='ui-datepicker-title']/span[1]");
        By SELECT_DATE_LOCATOR = By.xpath("//div[@id='ui-datepicker-div']/div[1]//tbody//td/a[text()='" + splitedDate[0] + "']");
        By CURRENT_YEAR_LOCATOR = By.xpath("//div[@id='ui-datepicker-div']/div[1]//div[@class='ui-datepicker-title']/span[2]");

        try {

            currentMonth = driver.findElement(CURRENT_MONTH_LOCATOR).getText();
            currentYear = driver.findElement(CURRENT_YEAR_LOCATOR).getText();

        } catch (StaleElementReferenceException e) {
            log.error("No Element found...");

            currentMonth = driver.findElement(CURRENT_MONTH_LOCATOR).getText();
            currentYear = driver.findElement(CURRENT_YEAR_LOCATOR).getText();
        }


        if (splitedDate[1].equals(getMonthNumber(currentMonth)) && splitedDate[2].equals(currentYear)) {

            waitForElementVisible(20, SELECT_DATE_LOCATOR);
            try {

                driver.findElement(SELECT_DATE_LOCATOR).click();
            } catch (NoSuchElementException e) {

                log.error(e.getMessage());

                driver.findElement(SELECT_DATE_LOCATOR).click();
            }


        } else {

            for (int i = 0; i < 24; i++) {

                try {

                    currentMonth = driver.findElement(CURRENT_MONTH_LOCATOR).getText();
                    currentYear = driver.findElement(CURRENT_YEAR_LOCATOR).getText();

                } catch (NoSuchElementException e) {

                    log.error("No Element found...");

                    currentMonth = driver.findElement(CURRENT_MONTH_LOCATOR).getText();
                    currentYear = driver.findElement(CURRENT_YEAR_LOCATOR).getText();
                }

                if (!splitedDate[1].equals(getMonthNumber(currentMonth)) || !splitedDate[2].equals(currentYear)) {

                    driver.findElement(NEXT_MONTH_LOCATOR).click();
                    sleep(500);
                }
            }

            sleep(1000);
            for (int i = 0; i < 3; i++) {

                waitForElementVisible(20, SELECT_DATE_LOCATOR);

                try {

                    driver.findElement(SELECT_DATE_LOCATOR).click();

                } catch (NoSuchElementException | StaleElementReferenceException e) {
                    log.error("Date was not clicked. " + e.getMessage());

                    driver.findElement(SELECT_DATE_LOCATOR).click();

                }
            }
        }

    }

    public void selectDateTo(String date) throws InterruptedException {

        String[] splitedDate = date.split("\\.");

        By NEXT_MONTH_LOCATOR = By.xpath("//span[text()='Next']");
        By CURRENT_MONTH_LOCATOR = By.xpath("//div[@id='ui-datepicker-div']/div[2]//div[@class='ui-datepicker-title']/span[1]");
        By SELECT_DATE_LOCATOR = By.xpath("//div[@id='ui-datepicker-div']/div[2]//tbody//td/a[text()='" + splitedDate[0] + "']");
        By CURRENT_YEAR_LOCATOR = By.xpath("//div[@id='ui-datepicker-div']/div[2]//div[@class='ui-datepicker-title']/span[2]");

        try {

            currentMonth = driver.findElement(CURRENT_MONTH_LOCATOR).getText();
            currentYear = driver.findElement(CURRENT_YEAR_LOCATOR).getText();

        } catch (StaleElementReferenceException e) {
            log.error("No Element found...");

            currentMonth = driver.findElement(CURRENT_MONTH_LOCATOR).getText();
            currentYear = driver.findElement(CURRENT_YEAR_LOCATOR).getText();
        }


        if (splitedDate[1].equals(getMonthNumber(currentMonth)) && splitedDate[2].equals(currentYear)) {

            waitForElementVisible(20, SELECT_DATE_LOCATOR);
            try {

                driver.findElement(SELECT_DATE_LOCATOR).click();
            } catch (NoSuchElementException e) {

                log.error(e.getMessage());

                driver.findElement(SELECT_DATE_LOCATOR).click();
            }


        } else {

            for (int i = 0; i < 24; i++) {

                try {

                    currentMonth = driver.findElement(CURRENT_MONTH_LOCATOR).getText();
                    currentYear = driver.findElement(CURRENT_YEAR_LOCATOR).getText();

                } catch (NoSuchElementException e) {

                    log.error("No Element found...");

                    currentMonth = driver.findElement(CURRENT_MONTH_LOCATOR).getText();
                    currentYear = driver.findElement(CURRENT_YEAR_LOCATOR).getText();
                }

                if (!splitedDate[1].equals(getMonthNumber(currentMonth)) || !splitedDate[2].equals(currentYear)) {

                    driver.findElement(NEXT_MONTH_LOCATOR).click();
                    sleep(500);
                }
            }

            sleep(1000);
            for (int i = 0; i < 3; i++) {

                try {

                    driver.findElement(SELECT_DATE_LOCATOR).click();

                    if (driver.findElement(NEXT_MONTH_LOCATOR).isDisplayed()) {
                        break;
                    }

                } catch (NoSuchElementException | StaleElementReferenceException e) {
                    log.error("Date was not clicked. " + e.getMessage());

                    driver.findElement(SELECT_DATE_LOCATOR).click();

                }
            }
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
