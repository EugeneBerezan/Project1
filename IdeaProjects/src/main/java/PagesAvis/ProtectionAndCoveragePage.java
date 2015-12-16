package PagesAvis;

import org.openqa.selenium.By;

public class ProtectionAndCoveragePage extends AbstractPage {

    public static By PERSONAL_ACCIDENT_INSURANCE_CHECKBOX = By.xpath("//input[contains(@id,'paiSelected')]");
    public static By PERSONAL_EFFECTS_PROTECTION_CHECKBOX = By.xpath("//input[contains(@id,'pepSelected')]");
    public static By ESTIMATED_TOTAL_TEXT_LOCATOR = By.xpath("//span[@id='estimatedTotal']");

    public ProtectionAndCoveragePage selectPersonalAccidentInsuranceCheckbox(){

        driver.findElement(PERSONAL_ACCIDENT_INSURANCE_CHECKBOX).click();

        return new ProtectionAndCoveragePage();
    }

    public ProtectionAndCoveragePage selectPersonalEffectsProtectionCheckbox(){

        driver.findElement(PERSONAL_EFFECTS_PROTECTION_CHECKBOX).click();

        return new ProtectionAndCoveragePage();
    }

    public String getTotalPrice(){

        return driver.findElement(ESTIMATED_TOTAL_TEXT_LOCATOR).getText();

    }


}
