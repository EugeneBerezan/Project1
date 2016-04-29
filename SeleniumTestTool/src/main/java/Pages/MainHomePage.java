package Pages;

import Tools.AbstractElement;
import org.openqa.selenium.By;

public class MainHomePage extends AbstractElement {

    private static final By AB_TEST_LINK_LOCATOR = By.xpath("//a[text()='A/B Testing']");
    private static final By BASIC_AUTH_LINK_LOCATOR = By.xpath("//a[text()='Basic Auth']");
    private static final By BROKEN_IMAGES_LINK_LOCATOR = By.xpath("//a[text()='Broken Images']");
    private static final By CHALLENGING_DOM_LINK_LOCATOR = By.xpath("//a[text()='Challenging DOM']");
    private static final By CHECKBOXES_LINK_LOCATOR = By.xpath("//a[text()='Checkboxes']");
    private static final By CONTEX_MENU_LINK_LOCATOR = By.xpath("//a[text()='Context Menu']");
    private static final By DISSAPEARING_ELEMENTS_LINK_LOCATOR = By.xpath("//a[text()='Disappearing Elements']");
    private static final By DRAG_AND_DROP_LINK_LOCATOR = By.xpath("//a[text()='Drag and Drop']");
    private static final By DROPDOWN_LINK_LOCATOR = By.xpath("//a[text()='Dropdown']");
    private static final By DYNAMIC_CONTROLS_LINK_LOCATOR = By.xpath("//a[text()='Dynamic Controls']");
    private static final By DYNAMIC_LOADING_LINK_LOCATOR = By.xpath("//a[text()='Dynamic Loading']");
    private static final By EXIT_INTENT_LINK_LOCATOR = By.xpath("//a[text()='Exit Intent']");
    private static final By FILE_DOWNLOAD_LINK_LOCATOR = By.xpath("//a[text()='File Download']");
    private static final By FILE_UPLOAD_LINK_LOCATOR = By.xpath("//a[text()='File Upload']");
    private static final By FLOATING_MENU_LINK_LOCATOR = By.xpath("//a[text()='Floating Menu']");
    private static final By FORGOT_PASSWORD_LINK_LOCATOR = By.xpath("//a[text()='Forgot Password']");
    private static final By FORM_AUTHENTICATION_LINK_LOCATOR = By.xpath("//a[text()='Form Authentication']");
    private static final By FRANES_LINK_LOCATOR = By.xpath("//a[text()='Frames']");
    private static final By HOVERS_LINK_LOCATOR = By.xpath("//a[text()='Hovers']");
    private static final By JAVASCRIPT_ALERTS_LINK_LOCATOR = By.xpath("//a[text()='JavaScript Alerts']");
    private static final By KEY_PRESS_LINK_LOCATOR = By.xpath("//a[text()='Key Presses']");
    private static final By LARGE_AND_DEEP_DOM_LINK_LOCATOR = By.xpath("//a[text()='Large & Deep DOM']");
    private static final By MULTIPLE_WINDOWS_LINK_LOCATOR = By.xpath("//a[text()='Multiple Windows']");
    private static final By NESTED_FRAMES_LINK_LOCATOR = By.xpath("//a[text()='Nested Frames']");
    private static final By SLOW_RESOURCES_LINK_LOCATOR = By.xpath("//a[text()='Slow Resources']");

    public MainHomePage clickOnABTestLink() {
        driver.findElement(AB_TEST_LINK_LOCATOR).click();
        return new ABTestPage();
    }

    public MainHomePage clickOnBasicAuthLink(String user, String password) {
        driver.findElement(BASIC_AUTH_LINK_LOCATOR).click();
        authenticationLogin(user, password);
        return new BasicAuthPage();
    }

    public MainHomePage clickOnBrokenImagesLink() {
        driver.findElement(BROKEN_IMAGES_LINK_LOCATOR).click();
        return new BrokenImagesPage();
    }

    public MainHomePage clickOnChallengingDomLink() {
        driver.findElement(CHALLENGING_DOM_LINK_LOCATOR).click();
        return new ChallengingDomPage();
    }

    public MainHomePage clickOnCheckboxesLink() {
        driver.findElement(CHECKBOXES_LINK_LOCATOR).click();
        return new CheckboxesPage();
    }

    public MainHomePage clickOnContexMenuLink() {
        driver.findElement(CONTEX_MENU_LINK_LOCATOR).click();
        return new ContexMenuPage();
    }

    public MainHomePage clickOnDissapearingElements() {
        driver.findElement(DISSAPEARING_ELEMENTS_LINK_LOCATOR).click();
        return new DissapearingElementsPage();
    }

    public MainHomePage clickOnDragAndDropElements() {
        driver.findElement(DRAG_AND_DROP_LINK_LOCATOR).click();
        return new DragAndDropPage();
    }

    public MainHomePage clickOnDropDownLink() {
        driver.findElement(DROPDOWN_LINK_LOCATOR).click();
        return new DropDownPage();
    }

    public MainHomePage clickOnDynamicControlsLink() {
        driver.findElement(DYNAMIC_CONTROLS_LINK_LOCATOR).click();
        return new DynamicControlPage();
    }

    public MainHomePage clickOnDynamicLoadingLink() {
        driver.findElement(DYNAMIC_LOADING_LINK_LOCATOR).click();
        return new DynamicLoadingPage();
    }

    public MainHomePage clickOnExitLink() {
        driver.findElement(EXIT_INTENT_LINK_LOCATOR).click();
        return new ExitIntentPage();

    }

    public MainHomePage clickFileDownloadLink() {
        driver.findElement(FILE_DOWNLOAD_LINK_LOCATOR).click();
        return new FileDownloadPage();
    }

    public MainHomePage clickFileUploadLink() {
        driver.findElement(FILE_UPLOAD_LINK_LOCATOR).click();
        return new FileUploadPage();
    }

    public MainHomePage clickOnFloatingMenuLink() {
        driver.findElement(FLOATING_MENU_LINK_LOCATOR).click();
        return new FloatingMenuPage();
    }

    public MainHomePage clickOnForgotPasswordLink() {
        driver.findElement(FORGOT_PASSWORD_LINK_LOCATOR).click();
        return new ForgotPasswordPage();

    }

    public MainHomePage clickOnFormAuthenticationLink() {
        driver.findElement(FORM_AUTHENTICATION_LINK_LOCATOR).click();
        return new FormAuthenticationPage();
    }

    public MainHomePage clickOnFramesLink() {
        driver.findElement(FRANES_LINK_LOCATOR).click();
        return new FramesPage();
    }

    public MainHomePage clickOnHoversLink() {
        driver.findElement(HOVERS_LINK_LOCATOR).click();
        return new HoversPage();
    }

    public MainHomePage clickOnJavaScriptAlertsLink() {
        driver.findElement(JAVASCRIPT_ALERTS_LINK_LOCATOR).click();
        return new JavaScriptAlertPage();
    }

    public MainHomePage clickOnKeyPressLink() {
        driver.findElement(KEY_PRESS_LINK_LOCATOR).click();
        return new KeyPressPage();
    }

    public MainHomePage clickOnLargeAndDeepDOMLink() {
        driver.findElement(LARGE_AND_DEEP_DOM_LINK_LOCATOR).click();
        return new LargeAndDeepDom();
    }

    public MainHomePage clickOnMultipleWindowsLink() {
        driver.findElement(MULTIPLE_WINDOWS_LINK_LOCATOR).click();
        return new MultipleWindowsPage();
    }

    public MainHomePage clickOnNestedFramesLink() {
        driver.findElement(NESTED_FRAMES_LINK_LOCATOR).click();
        return new NestedFramesPage();
    }


}
