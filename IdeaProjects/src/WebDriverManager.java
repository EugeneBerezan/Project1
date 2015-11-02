import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class WebDriverManager {

    String url = "http://tickets.ua";

    private static WebDriver webDriver;

    WebDriverManager() {
    }

    public static WebDriver getInstance() {
        if (webDriver == null) {

            webDriver = new FirefoxDriver();
            webDriver.manage().window().maximize();

        }

        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        return webDriver;

    }

    public static void close() {

        if (webDriver != null) {

            webDriver.quit();
            webDriver = null;

        }

    }

    public static void checkAlert() {

        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 3);
            wait.until(ExpectedConditions.alertIsPresent());

            webDriver.switchTo().alert().accept();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void getUrl(){
        String url = "http://tickets.ua";

        WebDriverManager.getInstance().get(url);
    }

}
