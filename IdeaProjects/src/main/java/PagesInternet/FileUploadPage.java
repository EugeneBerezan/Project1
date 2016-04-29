package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/24/16.
 */
public class FileUploadPage extends MainHomePage {

    private static final By FILE_UPLOADER_TEXT_LOCATOR = By.xpath("//*[text()='File Uploader']");
    private static final By UPLOAD_FILE_BUTTON_LOCATOR = By.xpath("//input[@id='file-upload']");
    private static final By UPLOAD_BUTTON_LOCATOR = By.xpath("//input[@id='file-submit']");
    private static final By FILE_UPLOADED_TEXT_LOCATOR = By.xpath("//*[text()='File Uploaded!']");


    public String getFileUploaderText() {

        log.info("Getting assert text");
        return driver.findElement(FILE_UPLOADER_TEXT_LOCATOR).getText();
    }

    public FileUploadPage uploadFile() {
        log.info("Uploading file");
        driver.findElement(UPLOAD_FILE_BUTTON_LOCATOR).sendKeys("/Users/EugeneBerezan/Desktop/security_testing.pdf");

        return new FileUploadPage();
    }

    public FileUploadPage clickOnUploadButton() {
        log.info("Clicking on Upload button");
        driver.findElement(UPLOAD_BUTTON_LOCATOR).click();

        return new FileUploadPage();
    }

    public String getSuccessfullFileUploadingStatus() {
        log.info("Getting successful file upload text");
        return driver.findElement(FILE_UPLOADED_TEXT_LOCATOR).getText();
    }

}
