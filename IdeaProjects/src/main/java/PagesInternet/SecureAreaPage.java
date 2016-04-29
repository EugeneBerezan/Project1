package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/25/16.
 */
public class SecureAreaPage extends FormAuthenticationPage {

    private final static By SECURE_AREA_TEXT_LCOATOR = By.xpath("//h2");
    private final static By LOGOUT_BUTTON_LCOATOR = By.xpath("//*[@id='content']//a");

    public String secureAreaText(){
        return driver.findElement(SECURE_AREA_TEXT_LCOATOR).getText();
    }

    public FormAuthenticationPage clickOnLogoutButton(){

        driver.findElement(LOGOUT_BUTTON_LCOATOR).click();

        return new FormAuthenticationPage();
    }

}
