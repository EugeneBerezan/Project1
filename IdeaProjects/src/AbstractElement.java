import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AbstractElement {

    protected By locator = null;
    protected WebElement locator2 = null;

    public AbstractElement(By locator) {
        this.locator = locator;
    }

    public AbstractElement(WebElement locator) {
        this.locator2 = locator2;
    }

    public WebElement findElement() {
        try {
            if (locator != null)
                return WebDriverManager.getInstance().findElement(locator);
            if (locator2 != null)
                return locator2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isPresent() {
        boolean isPresent = false;

        changeImplicitlyWait(0);
        try {
            isPresent = WebDriverManager.getInstance().findElements(locator).size() != 0;
        } finally {
            restoreDefaultImplicitlyWait();

        }
        return isPresent;
    }

    public boolean isVisible() {
        if (isPresent()) {
            return false;
        }
        for (int i = 0; i < 2; i++) {
            try {
                return findElement().isDisplayed();
            } catch (NullPointerException | StaleElementReferenceException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public void waitForElementVisible(int seconds) throws TimeoutException {

        changeImplicitlyWait(0);

        if (locator != null) {
            try {
                WebDriverWait wait = new WebDriverWait(WebDriverManager.getInstance(), seconds);
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (WebDriverException e) {
                try {
                    WebDriverWait wait = new WebDriverWait(WebDriverManager.getInstance(), seconds);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                } catch (NoSuchElementException e2) {
                    throw e2;
                } finally {
                    restoreDefaultImplicitlyWait();
                }
            } finally {
                restoreDefaultImplicitlyWait();
            }
        }
        if (locator2 != null) {
            try {
                WebDriverWait wait = new WebDriverWait(WebDriverManager.getInstance(), seconds);
                wait.until(ExpectedConditions.visibilityOf(locator2));
            } catch (WebDriverException e) {
                try {
                    WebDriverWait wait = new WebDriverWait(WebDriverManager.getInstance(), seconds);
                    wait.until(ExpectedConditions.visibilityOf(locator2));
                } catch (NoSuchElementException e2) {
                    throw e2;
                } finally {
                    restoreDefaultImplicitlyWait();
                }
            } finally {
                restoreDefaultImplicitlyWait();
            }

        }
    }

    protected void changeImplicitlyWait(int seconds) {
        WebDriverManager.getInstance().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    protected void restoreDefaultImplicitlyWait() {
        WebDriverManager.getInstance().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
}
