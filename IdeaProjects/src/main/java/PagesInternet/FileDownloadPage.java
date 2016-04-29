package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/24/16.
 */
public class FileDownloadPage extends MainHomePage {

    private final static By TEKST_TXT_LINK_LOCATOR = By.linkText("Tekst.txt");
    private final static By TEXT_FILE_TXT_LINK_LOCATOR = By.linkText("textfile.txt");
    private final static By TEST_TXT_LINK_LOCATOR = By.xpath("//a[text()='test.txt']");
    private final static By SOME_FILE_TXT_LINK_LOCATOR = By.linkText("some-file.txt");
    private final static By FILE_DOWNLOADER_TEXT_LOCATOR = By.xpath("//*[text()='File Downloader']");


    public String getAssertText() {
        return driver.findElement(FILE_DOWNLOADER_TEXT_LOCATOR).getText();
    }

    public FileDownloadPage clickOnTekstTxtLink(){
        driver.findElement(TEKST_TXT_LINK_LOCATOR).click();
        return this;
    }

    public FileDownloadPage clickOnTextFileTxtLink(){
        driver.findElement(TEXT_FILE_TXT_LINK_LOCATOR).click();
        return this;
    }

    public FileDownloadPage clickOnTestTxtLink(){
        driver.findElement(TEST_TXT_LINK_LOCATOR).click();
        return this;
    }


}
