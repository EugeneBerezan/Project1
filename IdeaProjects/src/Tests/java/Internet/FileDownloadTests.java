package Internet;

import PagesInternet.FileDownloadPage;
import PagesInternet.MainHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by EugeneBerezan on 4/5/16.
 */
public class FileDownloadTests extends InternetBaseTest {

    @Test
    public void checkFileDownloadText(){

        new MainHomePage()
                .clickOnFileDownloadLink();

        Assert.assertEquals(new FileDownloadPage().getAssertText(), "File Downloader");

    }



}
