package Internet;

import Driver.WebDriverManager;
import PagesInternet.FormAuthenticationPage;
import PagesInternet.MainHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * Created by EugeneBerezan on 4/6/16.
 *
 */

public class FormAuthenticationTest extends InternetBaseTest {

    @Test
    public void checkFormAuthenticationText(){

        new MainHomePage()
                .clickOnFormAuthenticationLink();

        Assert.assertEquals(new FormAuthenticationPage().getLoginPageText(), "Login Page");

    }

    @Test
    public void checkFormAuthenticationURL(){

        new MainHomePage()
                .clickOnFormAuthenticationLink();

        Assert.assertTrue(WebDriverManager.getCurrentURL().contains("login"));

    }

    @Test
    public void loginWithValidCredentials(){

        new MainHomePage()
                .clickOnFormAuthenticationLink();
        new FormAuthenticationPage()
                .inputCorrectUserName()
                .inputCorrectUserPassword()
                .clickOnLoginButton();

        Assert.assertTrue(new FormAuthenticationPage().isSeruceAreaDisplayed());

    }

    @Test
    public void loginWithInvalidCredentials(){

        new MainHomePage()
                .clickOnFormAuthenticationLink();
        new FormAuthenticationPage()
                .inputInCorrectUserName()
                .inputInCorrectUserPassword()
                .clickOnLoginButton();

        Assert.assertTrue(new FormAuthenticationPage().isInvalidCredentialsMessageAppears());

    }

}
