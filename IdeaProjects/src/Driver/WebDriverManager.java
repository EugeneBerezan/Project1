package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;


public class WebDriverManager {

    private static WebDriver driver;

    private WebDriverManager() {
    }

    public static WebDriver getInstance() {
        if (driver == null) {

            driver = new FirefoxDriver();
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("http://tickets.ua");
        } else {

            return driver;
        }

        return driver;
    }

    public static void close() {

        if (driver != null) {

            driver.quit();
            driver = null;

        }

    }

}
