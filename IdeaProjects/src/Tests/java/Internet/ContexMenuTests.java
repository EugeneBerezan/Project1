package Internet;

import PagesInternet.ContexMenuPage;
import PagesInternet.MainHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by EugeneBerezan on 4/1/16.
 */
public class ContexMenuTests extends InternetBaseTest {

    @Test
    public void checkContextMenuTitle(){

        new MainHomePage()
                .clickOnContexMenuLink();

        Assert.assertTrue(new ContexMenuPage().getAssertText().equals("Context Menu"));

    }

    @Test
    public void getAlertTextAfterContextMenu(){

        new MainHomePage()
                .clickOnContexMenuLink();

        Assert.assertEquals(new ContexMenuPage().contexClickOnArea(),"You selected a context menu");

    }




}
