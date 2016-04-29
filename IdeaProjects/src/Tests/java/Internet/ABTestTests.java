package Internet;

import PagesInternet.ABTestPage;
import PagesInternet.MainHomePage;
import com.google.common.base.Verify;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by EugeneBerezan on 3/30/16.
 */
public class ABTestTests extends InternetBaseTest {

    @Test
    public void checkTheABTestVariationTextOnThePage(){
        new MainHomePage()
                .clickOnABTestLink();

        Assert.assertEquals(new ABTestPage().getABTestText().trim(), "A/B Test Variation 1");

    }

    @Test
    public void checkURLContainsABTest(){

        new MainHomePage()
                .clickOnABTestLink();

        Verify.verify(new ABTestPage().getCurrentURL().contains("the-internet.herokuapp.com/abtest"));

    }

}
