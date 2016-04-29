package Internet;

import PagesInternet.DynamicLoadingPage;
import PagesInternet.MainHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by EugeneBerezan on 4/4/16.
 */
public class DynamicLoadingTests extends InternetBaseTest {

    @Test
    public void checkDinamicLoadingText(){

        new MainHomePage()
                .clickOnDynamicLoadingLink();

        Assert.assertEquals(new DynamicLoadingPage().getDynamicLoadingText(), "Dynamically Loaded Page Elements");

    }

    @Test
    public void example1HelloWorld(){

        new MainHomePage()
                .clickOnDynamicLoadingLink();
        String helloWorld = new DynamicLoadingPage()
                .clickOnExample1Link()
                .clickOnStartButton()
                .getHelloWorldText();

        Assert.assertEquals(helloWorld, "Hello World!");

    }

}
