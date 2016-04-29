package Tests;

import Pages.ABTestPage;
import Pages.BaseTest;
import Pages.MainHomePage;
import com.google.common.base.Verify;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by EugeneBerezan on 3/17/16.
 */
public class Testsss extends BaseTest {

    @Test
    public void test1() {

        new MainHomePage()
                .clickOnABTestLink();

        Assert.assertEquals(new ABTestPage().getABTestText(), "A/B Test Variation 1");

    }

    @Test
    public void test2() {

        new MainHomePage()
                .clickOnABTestLink();

        Verify.verify(new ABTestPage().getCurrentURL().contains("the-internet.herokuapp.com/abtest"));

    }


}
