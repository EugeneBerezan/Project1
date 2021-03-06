package PagesAvis;


import org.openqa.selenium.By;

public class AvisSelectACarPage extends AvisAbstractPage {

    public AvisProtectionAndCoveragePage selectCarType(String carClass) {
        log.info("Selecting car type");

        By SELECT_CAR_TYPE_BUTTON = By.xpath("//h2[text()='" + carClass + "']/ancestor::li//a[text()='PAY NOW']");
        driver.findElement(SELECT_CAR_TYPE_BUTTON).click();
        return new AvisProtectionAndCoveragePage();

    }
}
