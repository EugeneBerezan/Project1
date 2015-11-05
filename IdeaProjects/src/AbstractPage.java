import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPage {

    WebDriver driver = WebDriverManager.getInstance();

    public static void sleep(int miliseconds) throws InterruptedException {
        Thread.sleep(miliseconds);
    }

    protected final Logger log = LogManager.getLogger(getClass());


    public static String getMonth(String monthName) {

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

        return getMonth(monthName.toLowerCase());
    }

    public void selectDate(String date) throws InterruptedException {

        By NEXT_MONTH_LOCATOR = By.xpath("//span[text()='Next']");
        By CURRENT_MONTH_LOCATOR = By.xpath("//div[@id='ui-datepicker-div']/div[1]//div[@class='ui-datepicker-title']/span[1]");

        String currentMonth = driver.findElement(CURRENT_MONTH_LOCATOR).getText();

        String[] elements = date.split("\\.");

        if (elements[1].equals(getMonth(currentMonth))) {

            driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]//tbody//td/a[text()='" + elements[0] + "']")).click();

        } else if (!(elements[1].equals(getMonth(currentMonth)))) {

            for (int i = 0; i < 12 && !(elements[1].equals(currentMonth)); i++) {

                driver.findElement(NEXT_MONTH_LOCATOR).click();
                sleep(500);
            }

            driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]//tbody//td/a[text()='" + elements[0] + "']"));


        }

    }


}
