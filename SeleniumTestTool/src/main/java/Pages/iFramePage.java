package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/25/16.
 */
public class IFramePage extends FramesPageChecker {

    private static final By IFRAME_LOCATOR = By.id("mce_0_ifr");
    private static final By INPUT_AREA_LOCATOR = By.id("tinymce");
    private static final By FILE_BUTTON_LOCATOR = By.id("mceu_15-open");
    private static final By EDIT_BUTTON_LOCATOR = By.id("mceu_16-open");
    private static final By UNDO_BUTTON_LOCATOR = By.id("mceu_74-text");
    private static final By REDO_BUTTON_LOCATOR = By.id("mceu_75-text");
    private static final By CUT_BUTTON_LOCATOR = By.id("mceu_77-text");
    private static final By COPY_BUTTON_LOCATOR = By.id("mceu_78-text");
    private static final By PASTE_BUTTON_LOCATOR = By.id("mceu_79-text");
    private static final By SELECT_ALL_BUTTON_LOCATOR = By.id("mceu_81-text");
    private static final By BOLD_BUTTON_LOCATOR = By.id("mceu_32-text");
    private static final By INLINE_BOLD_MENU_LOCATOR = By.id("mceu_55-text");
    private static final By ITALIC_BUTTON_LOCATOR = By.id("mceu_33-text");
    private static final By INLINE_ITALIC_MENU_LOCATOR = By.id("mceu_56-text");
    private static final By FORMAT_BUTTON_LOCATOR = By.id("mceu_18-text");
    private static final By UNDELINE_BUTTON_LOCATOR = By.id("mceu_34-text");
    private static final By INLINE_UNDELINE_MENU_LOCATOR = By.id("mceu_57-text");
    private static final By STRIKETHROUGH_BUTTON_LOCATOR = By.id("mceu_35-text");
    private static final By INLINE_STRIKETHROUGH_MENU_LOCATOR = By.id("mceu_58-text");
    private static final By SUPERSCRIPT_BUTTON_LOCATOR = By.id("mceu_36-text");
    private static final By INLINE_SUPERSCRIPT_MENU_LOCATOR = By.id("mceu_59-text");
    private static final By SUBSKRIPT_BUTTON_LOCATOR = By.id("mceu_37-text");
    private static final By INLINE_SUBSKRIPT_MENU_LOCATOR = By.id("mceu_60-text");
    private static final By INLINE_CODE_MENU_LOCATOR = By.id("mceu_61-text");
    private static final By FORMATS_MENU_LOCATOR = By.id("mceu_39-text");
    private static final By BLOCKS_MENU_LOCATOR = By.id("mceu_45-text");
    private static final By CLEAR_FORMATTING_BUTTON_LOCATOR = By.id("mceu_41-text");
    private static final By FIRST_HEADING_BUTTON_LOCATOR = By.xpath("//span[contains(@id, 'mceu') and contains(text()='Heading')]");
    private static final By FIRST_INLINE_BUTTON_LOCATOR = By.xpath("//div[contains(@id,'mceu' and contains(@class, 'mce-first']");
    private static final By HEADINGS_SUBMENU_LOCATOR = By.id("mceu_43-text");
    private static final By INLINE_SUBMENU_LOCATOR = By.xpath("//span[contains(@id, 'mceu') and contains(text()='Inline')]");
    private static final By NEW_DOCUMENT_BUTTON_LOCATOR = By.id("mceu_33-text");


    public IFramePage switchToInputIfRame() {
        switchToFrame(IFRAME_LOCATOR);
        return this;
    }

    public IFramePage typeSomeSpam(String spam) {

        switchToInputIfRame();
        driver.findElement(INPUT_AREA_LOCATOR).sendKeys(spam);

        return this;
    }

    public IFramePage startNewDocument() {

        switchToDefaultContent();
        mouserOverOnElement(FILE_BUTTON_LOCATOR);
        driver.findElement(FILE_BUTTON_LOCATOR).click();
        mouserOverOnElement(NEW_DOCUMENT_BUTTON_LOCATOR);
        driver.findElement(NEW_DOCUMENT_BUTTON_LOCATOR).click();

        return new IFramePage();
    }

    public void clickEditButton() {

        driver.findElement(EDIT_BUTTON_LOCATOR).click();

    }

    public IFramePage undo() {

        clickEditButton();
        driver.findElement(UNDO_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage redo() {

        clickEditButton();
        driver.findElement(REDO_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage cut() {

        clickEditButton();
        driver.findElement(CUT_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage copy() {

        clickEditButton();
        driver.findElement(COPY_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage paste() {

        clickEditButton();
        driver.findElement(PASTE_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectAll() {

        clickEditButton();
        driver.findElement(SELECT_ALL_BUTTON_LOCATOR).click();

        return this;
    }

    public void clickFormatButton() {
        driver.findElement(FORMAT_BUTTON_LOCATOR).click();
    }

    public IFramePage selectBoldFont() {

        clickFormatButton();
        driver.findElement(BOLD_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectItalicFont() {

        clickFormatButton();
        driver.findElement(ITALIC_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectUnderlineFont() {

        clickFormatButton();
        driver.findElement(UNDELINE_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectStrikethroughtFont() {

        clickFormatButton();
        driver.findElement(STRIKETHROUGH_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectSuperscriptFont() {

        clickFormatButton();
        driver.findElement(SUPERSCRIPT_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectSubscriptFont() {

        clickFormatButton();
        driver.findElement(SUBSKRIPT_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectClearFormattingOption() {

        clickFormatButton();
        driver.findElement(CLEAR_FORMATTING_BUTTON_LOCATOR).click();

        return this;
    }

    public IFramePage selectHeading(int headingNumber){

        String headingScale = "//span[contains(@id, 'mceu') and contains(text()='Heading " + headingNumber + "')]";

        clickFormatButton();
        mouserOverOnElement(FORMATS_MENU_LOCATOR);
        mouserOverOnElement(HEADINGS_SUBMENU_LOCATOR);
        mouserOverOnElement(FIRST_HEADING_BUTTON_LOCATOR);
        driver.findElement(By.xpath(headingScale));

        return this;
    }

    public IFramePage selectInlineBold(){

        clickFormatButton();
        mouserOverOnElement(FORMATS_MENU_LOCATOR);
        mouserOverOnElement(INLINE_SUBMENU_LOCATOR);
        mouserOverOnElement(FIRST_INLINE_BUTTON_LOCATOR);
        driver.findElement(INLINE_BOLD_MENU_LOCATOR);

        return this;
    }

}
