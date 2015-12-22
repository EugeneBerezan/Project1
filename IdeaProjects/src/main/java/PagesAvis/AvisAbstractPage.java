package PagesAvis;

import Driver.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AvisAbstractPage {

    WebDriver driver = WebDriverManager.getInstance();

    public static void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    Logger log = LogManager.getLogger(getClass());

    public static String getMonth(String monthName) {

        Map<String, String> month = new HashMap<String, String>();

        month.put("01", "JANUARY");
        month.put("02", "FEBRUARY");
        month.put("03", "MARCH");
        month.put("04", "APRIL");
        month.put("05", "MAY");
        month.put("06", "JUNE");
        month.put("07", "JULY");
        month.put("08", "AUGUST");
        month.put("09", "SEPTEMBER");
        month.put("10", "OCTOBER");
        month.put("11", "NOVEMBER");
        month.put("12", "DECEMBER");

        return month.get(monthName);
    }


    public AvisAbstractPage selectDate(String date) {

        String[] splitedDate = date.split("\\.");

        By CURRENT_MONTH_LOCATOR = By.xpath("//div[contains(@class,'first')]//span[@class='ui-datepicker-month'][1]");
        By NEXT_MONTH_ARROW_LOCATOR = By.xpath("//div[contains(@class,'last')]//span[contains(@class,'circle-triangle')]");
        By DATE_LOCATOR = By.xpath("//div[contains(@class,'first')]//a[text()='" + splitedDate[0] + "']");

        log.entry("Selecting date");

        try {

            if (driver.findElement(CURRENT_MONTH_LOCATOR).getText().equals(getMonth(splitedDate[0]))) {
                driver.findElement(DATE_LOCATOR).click();
            } else {
                for (;!driver.findElement(CURRENT_MONTH_LOCATOR).getText().equals(getMonth(splitedDate[0])); ) {

                    driver.findElement(NEXT_MONTH_ARROW_LOCATOR).click();
                }
                driver.findElement(DATE_LOCATOR).click();
            }

        } catch (Exception e) {
            log.error("Date was not selected");
        }
        return this;
    }

    public static void selectByVisibleText(By locator, String option){

        new Select(WebDriverManager.getInstance().findElement(locator)).selectByVisibleText(option);

    }


}
