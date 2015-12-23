package PagesAvis;

import org.openqa.selenium.By;

public class AvisProtectionAndCoveragePage extends AvisAbstractPage {

    public static By PERSONAL_ACCIDENT_INSURANCE_CHECKBOX = By.xpath("//input[contains(@id,'paiSelected')]");
    public static By PERSONAL_EFFECTS_PROTECTION_CHECKBOX = By.xpath("//input[contains(@id,'pepSelected')]");
    public static By ESTIMATED_TOTAL_TEXT_LOCATOR = By.xpath("//span[@id='estimatedTotal']");

    public AvisProtectionAndCoveragePage selectPersonalAccidentInsuranceCheckbox(){

        log.info("Selecting Personal Accident Insurance checkbox");

        driver.findElement(PERSONAL_ACCIDENT_INSURANCE_CHECKBOX).click();

        return new AvisProtectionAndCoveragePage();
    }

    public AvisProtectionAndCoveragePage selectPersonalEffectsProtectionCheckbox(){

        log.info("Selecting Personal Effects Protection Checkbox");

        driver.findElement(PERSONAL_EFFECTS_PROTECTION_CHECKBOX).click();

        return new AvisProtectionAndCoveragePage();
    }

    public String getTotalPrice(){

        log.info("Saving total price");

        return driver.findElement(ESTIMATED_TOTAL_TEXT_LOCATOR).getText() + "$";

    }


}
