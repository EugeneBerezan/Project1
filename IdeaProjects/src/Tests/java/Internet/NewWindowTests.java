package Internet;

import PagesInternet.MainHomePage;
import PagesInternet.MultipleWindowsPage;
import PagesInternet.NewWindowPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by EugeneBerezan on 4/11/16.
 */
public class NewWindowTests extends InternetBaseTest {

    @Test
    public void assertNewWindowText(){

        new MainHomePage()
                .clickOnMultipleWindowsLink();

        Assert.assertEquals(new MultipleWindowsPage().getWindowText(), "Opening a new window");

    }

    @Test
    public void openNewTab(){

        new MainHomePage()
                .clickOnMultipleWindowsLink();
        new MultipleWindowsPage()
                .clickOnClickHereLink();

        Assert.assertEquals(new NewWindowPage().getNewWindowText(), "New Window");

    }



}
