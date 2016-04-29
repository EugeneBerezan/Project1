package PagesInternet;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/25/16.
 */
public class IFramePage extends InternetAbstractPage {

    private static final By IFRAME_LOCATOR = By.id("mce_0_ifr");
//    private static final By INPUT_AREA_LOCATOR = By.id("tinymce");
    private static final By FILE_BUTTON_LOCATOR = By.id("mceu_15-open");
    private static final By EDIT_BUTTON_LOCATOR = By.id("mceu_16-open");
    private static final By UNDO_BUTTON_LOCATOR = By.id("mceu_74-text");
    private static final By REDO_BUTTON_LOCATOR = By.id("mceu_75-text");
    private static final By CUT_BUTTON_LOCATOR = By.id("mceu_77-text");
    private static final By COPY_BUTTON_LOCATOR = By.id("mceu_78-text");
    private static final By PASTE_BUTTON_LOCATOR = By.id("mceu_79-text");
    private static final By SELECT_ALL_BUTTON_LOCATOR = By.id("mceu_81-text");
    private static final By BOLD_BUTTON_LOCATOR = By.id("mceu_46-shortcut");
    private static final By INLINE_BOLD_MENU_LOCATOR = By.id("mceu_55-text");
    private static final By ITALIC_BUTTON_LOCATOR = By.id("mceu_33-text");
    private static final By INLINE_ITALIC_MENU_LOCATOR = By.id("mceu_56-text");
    private static final By FORMAT_BUTTON_LOCATOR = By.id("mceu_18-open");
    private static final By UNDELINE_BUTTON_LOCATOR = By.id("mceu_34-text");
    private static final By INLINE_UNDELINE_MENU_LOCATOR = By.id("mceu_57-text");
    private static final By STRIKETHROUGH_BUTTON_LOCATOR = By.id("mceu_35-text");
    private static final By INLINE_STRIKETHROUGH_MENU_LOCATOR = By.id("mceu_58-text");
    private static final By SUPERSCRIPT_BUTTON_LOCATOR = By.id("mceu_36-text");
    private static final By INLINE_SUPERSCRIPT_MENU_LOCATOR = By.id("mceu_59-text");
    private static final By SUBSKRIPT_BUTTON_LOCATOR = By.id("mceu_37-text");
    private static final By INLINE_SUBSKRIPT_MENU_LOCATOR = By.id("mceu_60-text");
    private static final By INLINE_CODE_MENU_LOCATOR = By.id("mceu_61-text");
    private static final By FORMATS_MENU_LOCATOR = By.id("mceu_53");
    private static final By BLOCKS_MENU_LOCATOR = By.id("mceu_45-text");
    private static final By CLEAR_FORMATTING_BUTTON_LOCATOR = By.id("mceu_41-text");
    private static final By FIRST_HEADING_BUTTON_LOCATOR = By.xpath("//span[contains(@id, 'mceu') and contains(text()='Heading')]");
    private static final By FIRST_INLINE_BUTTON_LOCATOR = By.xpath("//div[contains(@id,'mceu' and contains(@class, 'mce-first']");
    private static final By HEADINGS_SUBMENU_LOCATOR = By.id("mceu_43-text");
    private static final By INLINE_SUBMENU_LOCATOR = By.xpath("//span[contains(@id, 'mceu') and contains(text()='Inline')]");
    private static final By NEW_DOCUMENT_BUTTON_LOCATOR = By.id("mceu_33-text");
    private static final By INPUT_TEXT_LOCATOR = By.xpath("//*[@id='tinymce']/p");
    private static final By INPUT_BOLD_TEXT_LOCATOR = By.xpath("//*[@id='tinymce']//strong");

    public String getTextFromEditor(){
        switchToInputIfRame();
        return driver.findElement(INPUT_TEXT_LOCATOR).getText();
    }

    public String getBoldTextFromEditor(){
        switchToInputIfRame();
        return driver.findElement(INPUT_BOLD_TEXT_LOCATOR).getText();
    }

    public IFramePage switchToInputIfRame() {
        log.info("Switching to Input Frame");
        switchToFrame(IFRAME_LOCATOR);
        return this;
    }

    public IFramePage typeSomeSpam(String spam) {
        log.info("Sending keys - " + spam + "into text area");
        switchToInputIfRame();
        driver.findElement(INPUT_TEXT_LOCATOR).sendKeys(spam);

        return this;
    }

    public IFramePage startNewDocument() {
        log.info("Clicking on New Document button");
        switchToDefaultContent();
        mouserHoverOnElement(FILE_BUTTON_LOCATOR);
        driver.findElement(FILE_BUTTON_LOCATOR).click();
        mouserHoverOnElement(NEW_DOCUMENT_BUTTON_LOCATOR);
        driver.findElement(NEW_DOCUMENT_BUTTON_LOCATOR).click();

        return new IFramePage();
    }

    public void clickEditButton() {
        log.info("Clicking on Edit button");
        driver.findElement(EDIT_BUTTON_LOCATOR).click();

    }

    public IFramePage undo() {
        log.info("Clicking on Undo button");
        clickEditButton();
        driver.findElement(UNDO_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage redo() {
        log.info("Clicking on Redo button");
        clickEditButton();
        driver.findElement(REDO_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage cut() {
        log.info("Clicking on Cut button");
        clickEditButton();
        driver.findElement(CUT_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage copy() {
        log.info("Clicking on Copy button");
        clickEditButton();
        driver.findElement(COPY_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage paste() {
        log.info("Clicking on Paste button");
        clickEditButton();
        driver.findElement(PASTE_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectAll() {
        log.info("Clicking on Select All button");
        clickEditButton();
        driver.findElement(SELECT_ALL_BUTTON_LOCATOR).click();

        return this;
    }

    public void clickFormatButton() {
        log.info("Clicking on Format");
        driver.findElement(FORMAT_BUTTON_LOCATOR).click();
    }

    public IFramePage selectBoldFont() {
        log.info("Selecting Bold font");
        clickFormatButton();
        driver.findElement(BOLD_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectItalicFont() {
        log.info("Selecting Italic font");
        clickFormatButton();
        driver.findElement(ITALIC_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectUnderlineFont() {
        log.info("Selecting Underline font");
        clickFormatButton();
        driver.findElement(UNDELINE_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectStrikethroughtFont() {
        log.info("Selecting Strikethrought font");
        clickFormatButton();
        driver.findElement(STRIKETHROUGH_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectSuperscriptFont() {
        log.info("Selecting Superscript font");
        clickFormatButton();
        driver.findElement(SUPERSCRIPT_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectSubscriptFont() {
        log.info("Selecting Subscript font");
        clickFormatButton();
        driver.findElement(SUBSKRIPT_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectClearFormattingOption() {
        log.info("Selecting Clear Formatting option");
        clickFormatButton();
        driver.findElement(CLEAR_FORMATTING_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectHeading(int headingNumber){
        log.info("Selecting heading number "+ headingNumber);
        String headingScale = "//span[contains(@id, 'mceu') and contains(text()='Heading " + headingNumber + "')]";

        clickFormatButton();
        mouserHoverOnElement(FORMATS_MENU_LOCATOR);
        mouserHoverOnElement(HEADINGS_SUBMENU_LOCATOR);
        mouserHoverOnElement(FIRST_HEADING_BUTTON_LOCATOR);
        driver.findElement(By.xpath(headingScale));

        return this;
    }

    public IFramePage selectInlineBold(){
        log.info("Selecting Inline Bold font");
        clickFormatButton();
        mouserHoverOnElement(FORMATS_MENU_LOCATOR);
        mouserHoverOnElement(INLINE_SUBMENU_LOCATOR);
        mouserHoverOnElement(FIRST_INLINE_BUTTON_LOCATOR);
        driver.findElement(INLINE_BOLD_MENU_LOCATOR);

        return this;
    }

}
