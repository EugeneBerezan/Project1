package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Driver.WebDriverManager;

import java.util.HashMap;
import java.util.Map;

public class AbstractPage {

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

    public void selectDate(String date) throws InterruptedException {

        By NEXT_MONTH_LOCATOR = By.xpath("//span[text()='Next']");
        By CURRENT_MONTH_LOCATOR = By.xpath("//div[@id='ui-datepicker-div']/div[1]//div[@class='ui-datepicker-title']/span[1]");

        String currentMonth = driver.findElement(CURRENT_MONTH_LOCATOR).getText();

        String[] splitedDate = date.split("\\.");

        if (splitedDate[1].equals(getMonthNumber(currentMonth))) {

            driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]//tbody//td/a[text()='" + splitedDate[0] + "']")).click();

        } else {

            for (int i = 0; i < 24; i++) {

                currentMonth = driver.findElement(CURRENT_MONTH_LOCATOR).getText();

                if (!splitedDate[1].equals(getMonthNumber(currentMonth))) {

                    driver.findElement(NEXT_MONTH_LOCATOR).click();
                    sleep(500);
                }
            }

            driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]//tbody//td/a[text()='" + splitedDate[0] + "']")).click();

        }

    }


    public static void waitForElementVisible(int seconds, By locator) {

        WebDriverWait wait = new WebDriverWait(WebDriverManager.getInstance(), seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

}
