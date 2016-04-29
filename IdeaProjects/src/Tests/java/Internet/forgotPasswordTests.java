package Internet;

import Driver.WebDriverManager;
import PagesInternet.ForgotPasswordPage;
import PagesInternet.InternetAbstractPage;
import PagesInternet.MainHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by EugeneBerezan on 4/6/16.
 */
public class ForgotPasswordTests extends InternetBaseTest {

    @Test
    public void getForgotPasswordText() {

        new MainHomePage()
                .clickOnForgotPasswordLink();

        Assert.assertTrue(new ForgotPasswordPage().getForgotPasswordText().equals("Forgot Password"));
    }

    @Test
    public void verifyURL() {

        new MainHomePage()
                .clickOnForgotPasswordLink();

        Assert.assertTrue(WebDriverManager.getCurrentURL().contains("forgot_password"));

    }

    @Test
    public void inputCorrectEmail() {

        new MainHomePage()
                .clickOnForgotPasswordLink();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage()
                .inputEmail("testEmail@test.com")
                .clickOnRetrievePasswordButton();

        Assert.assertTrue(forgotPasswordPage.getYourEmailHasBeenSendText().equals("Your e-mail's been sent!"));

    }


    @Test
    public void inputIncorrectEmail(){

        new MainHomePage()
                .clickOnForgotPasswordLink();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage()
                .inputEmail("")
                .clickOnRetrievePasswordButton();

        Assert.assertTrue(forgotPasswordPage.getInternalErrorTextLocator().equals("Internal Server Error"));

    }

}


