package Pages;

import Driver.DataBaseConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultPage extends AbstractPage {

    DataBaseConnection connection = new DataBaseConnection();


    public ResultPage() {

    }

    private static final By AIRLINES_LABEL_LOCATOR = By.xpath("//a[text()='Авиакомпании']");
    private static final By USD_CURRENCY_LABEL_LOCATOR = By.xpath("//span[text()='USD']");
    private static final By PRICE_IN_USD = By.xpath("//a[@class='price_cell']/span[contains(@class,'new_price') and contains(text(),'USD')]");


    public ResultPage waitUntilRouteIsCalculated() {

        waitForElementVisible(60, AIRLINES_LABEL_LOCATOR);

        return this;
    }

    public ResultPage changeСurrencyToUSD() {

        waitForElementVisible(30, USD_CURRENCY_LABEL_LOCATOR);
        driver.findElement(USD_CURRENCY_LABEL_LOCATOR).click();

        return this;
    }

    public Integer getMinPrice() {

        List<WebElement> elements = driver.findElements(PRICE_IN_USD);
        List<String> banans = new ArrayList<String>();

        for (WebElement element : elements) {
            String text = element.getText();
            String[] dollar = text.trim().split(" ");
            if (!"".equals(dollar[0])) {
                banans.add(dollar[0]);
            }
        }

        Integer min = Integer.parseInt(banans.get(1));

        for (String aBanan : banans) {
            if (Integer.parseInt(aBanan) < min) {
                min = Integer.parseInt(aBanan);
            }
        }
        return min;

    }

    public void insertPriceIntoTableTickets(String locationFrom, String locationTo, String dateFrom, String dateTo, String currentDate) throws SQLException {

        String preparedSQL = "INSERT INTO TICKETS(1, " + locationFrom + ", " + locationTo + ", " + dateFrom + ", " + dateTo + ", " + getMinPrice() + ", " + currentDate + " )";
        connection.getDataSource();

    }

}
