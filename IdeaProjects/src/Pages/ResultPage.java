package Pages;

import org.apache.xpath.operations.String;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EugeneBerezan on 11/6/15.
 */
public class ResultPage extends AbstractPage{

    public ResultPage() {

    }

    private static final By AIRLINES_LABEL_LOCATOR = By.xpath("//a[text()='Авиакомпании']");
    private static final By USD_CURRENCY_LABEL_LOCATOR = By.xpath("//span[text()='USD']");
    private static final By PRICE_IN_USD = By.xpath("//a[@class='price_cell']/span[contains(text(),'USD')]");


    public ResultPage waitUntilRouteIsCalculated(){

        waitForElementVisible(60, AIRLINES_LABEL_LOCATOR);

        return this;
    }

    public ResultPage changeСurrencyToUSD(){

        waitForElementVisible(30, USD_CURRENCY_LABEL_LOCATOR);
        driver.findElement(USD_CURRENCY_LABEL_LOCATOR).click();

        return this;
    }

    public ResultPage saveAllPrices(){

        List<WebElement> elements = new ArrayList<>();

        elements = driver.findElements(PRICE_IN_USD);

        return this;
    }


}
