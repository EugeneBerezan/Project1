package Tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    public static String homePageUrl = "http://the-internet.herokuapp.com";

    private static WebDriver driver;

    private WebDriverManager(){}

    public static WebDriver getInstance() {
        if (driver == null) {
//
//            FirefoxProfile firefoxProfile = new FirefoxProfile();
//
//            String resource = WebDriverManager.class.getName().replace(".", File.separator) + ".class";
//            URL fileURL = ClassLoader.getSystemClassLoader().getResource(resource);
//
//            String path = null;
//            try {
//                path = new File(fileURL.toURI()).getParent();
//            } catch (URISyntaxException e) {
//                e.printStackTrace();
//            }
//
//            String mySubFolder = "subFolder";
//            File newDir = new File(path + File.separator + mySubFolder);
//
////            boolean success = newDir.mkdir();
//            firefoxProfile.setPreference("browser.download.folderList", 2);
//            try {
//                firefoxProfile.setPreference("browser.download.dir", newDir.getCanonicalPath());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            firefoxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
//            firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, text/json, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
//            firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
//            firefoxProfile.setPreference("browser.download.manager.focusWhenStarting", false);
//            firefoxProfile.setPreference("browser.download.useDownloadDir", true);
//            firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
//            firefoxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
//            firefoxProfile.setPreference("browser.download.manager.closeWhenDone", true);
//            firefoxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
//            firefoxProfile.setPreference("browser.download.manager.useWindow", false);
//            firefoxProfile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
//            firefoxProfile.setPreference("pdfjs.disabled", true);

            driver = new FirefoxDriver();//new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } else {
            return driver;
        }
        return driver;
    }

    public static void getUrl(){
        WebDriverManager.getInstance().get(homePageUrl);
    }


    public static void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }

}
