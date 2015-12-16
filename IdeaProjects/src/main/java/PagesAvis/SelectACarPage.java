package PagesAvis;


import org.openqa.selenium.By;

public class SelectACarPage extends AbstractPage{

    public SelectACarPage selectCarType(String carClass) {

        By SELECT_CAR_TYPE_BUTTON = By.xpath("//h2[text()='" + carClass + "']/ancestor::li//a[text()='PAY NOW']");
        driver.findElement(SELECT_CAR_TYPE_BUTTON).click();
        return this;

    }
}
