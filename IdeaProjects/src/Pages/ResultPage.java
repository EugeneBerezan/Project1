package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 11/6/15.
 */
public class ResultPage extends AbstractPage{

    public ResultPage() {


    }

    private static final By AIRLINES_LABEL_LOCATOR = By.xpath("//a[text()='Авиакомпании']");


    public ResultPage waitUntilRouteIsCalculated(){

        waitForElementVisible(60, AIRLINES_LABEL_LOCATOR);

        return this;
    }


}
