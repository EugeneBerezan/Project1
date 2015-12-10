package Driver;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriver driver;

    public WebDriverManager(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver getInstance() {
        if (driver == null) {

            driver = new FirefoxDriver();
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
