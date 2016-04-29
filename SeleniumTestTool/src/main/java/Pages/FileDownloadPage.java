package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/24/16.
 */
public class FileDownloadPage extends MainHomePage {

    private final static By FIX_TXT_LINK_LOCATOR = By.xpath("//a[text()='fix.txt']");
    private final static By ZXX_XML_LINK_LOCATOR = By.xpath("//a[text()='zxx.xml']");
    private final static By TEST_TXT_LINK_LOCATOR = By.xpath("//a[text()='test.txt']");
    private final static By SOME_FILE_TXT_LINK_LOCATOR = By.xpath("//a[text()='some-file.txt']");
    private final static By WEB2_PREFS_BLACKLIST_JSON_LINK_LOCATOR = By.xpath("//a[text()='web2_prefs_blacklist.json']");


}
