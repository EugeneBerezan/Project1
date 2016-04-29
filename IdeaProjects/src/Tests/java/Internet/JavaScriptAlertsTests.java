package Internet;

import PagesInternet.InternetAbstractPage;
import PagesInternet.JavaScriptAlertPage;
import PagesInternet.MainHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by EugeneBerezan on 4/9/16.
 */
public class JavaScriptAlertsTests extends InternetBaseTest {

    @Test
    public void checkText() {

        new MainHomePage()
                .clickOnJavaScriptAlertsLink();

        Assert.assertTrue(new JavaScriptAlertPage().getJavaScriptAlertText().equals("JavaScript Alerts"));

    }

    @Test
    public void acceptJSAlert() {

        new MainHomePage()
                .clickOnJavaScriptAlertsLink();
        new JavaScriptAlertPage()
                .acceptJSAlert();

        Assert.assertEquals(new JavaScriptAlertPage().getResult(), "You successfuly clicked an alert");

    }

    @Test
    public void acceptJSConfirm() {

        new MainHomePage()
                .clickOnJavaScriptAlertsLink();
        new JavaScriptAlertPage()
                .acceptJSConfirm();

        Assert.assertEquals(new JavaScriptAlertPage().getResult(), "You clicked: Ok");

    }

    @Test
    public void cancelJSConfirm() {

        new MainHomePage()
                .clickOnJavaScriptAlertsLink();
        new JavaScriptAlertPage()
                .dismissJSConfirm();

        Assert.assertEquals(new JavaScriptAlertPage().getResult(), "You clicked: Cancel");

    }

    @Test
    public void typeIntoJSPrompt() {

        new MainHomePage()
                .clickOnJavaScriptAlertsLink();
        new JavaScriptAlertPage()
                .sendKeysJSPrompt("text");

        Assert.assertEquals(new JavaScriptAlertPage().getResult(), "You entered: text");

    }

    @Test
    public void dismissJSPrompt() {

        new MainHomePage()
                .clickOnJavaScriptAlertsLink();
        new JavaScriptAlertPage()
                .dismissJSPrompt();

        Assert.assertEquals(new JavaScriptAlertPage().getResult(), "You entered: null");

    }


}
