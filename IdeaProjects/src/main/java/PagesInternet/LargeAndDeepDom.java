package PagesInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by EugeneBerezan on 3/28/16.
 */
public class LargeAndDeepDom extends MainHomePage {

    private static final By LARGE_AND_DEEP_DOM_TEXT_LOCATOR = By.linkText("Large & Deep DOM");

    public String getLargeAndDeepDomText() {
        log.info("Getting assert text");
        return driver.findElement(LARGE_AND_DEEP_DOM_TEXT_LOCATOR).getText();
    }

    public double sumAllNumbersInColumn(int columnNumber) {
        log.info("Calculating numbers by columnNumber - "+ columnNumber);
        double result = 0;
        List<WebElement> listOfRows = driver.findElements(By.xpath("//tr[contains(@class,'row-')]"));

        for (int i = 0; i < listOfRows.size(); i++) {
            List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@class,'row-2')]/td[@class='column-" + columnNumber + "']"));
            result += Double.parseDouble(rows.get(i).getText());
        }
        return result;
    }

}
