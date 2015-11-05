import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Tools{

    String url = "http://tickets.ua";

    String currectURL = "http://tickets.ua/";

    private WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    //header Panel
    @FindBy(xpath = "//a[contains(.,'Tickets')]")
    private WebElement TICKETS_UA_HOME_LINK_LOCATOR;

    @FindBy(xpath = "//li[@class='avia active']/a")
    private WebElement AVIA_TICKETS_LINK_LOCATOR;

    @FindBy(xpath = "//li[contains(@class,'gd')]/a")
    private WebElement GD_TICKETS_LINK_LOCATOR;

    @FindBy(xpath = "//li[contains(@class,'bus')]/a")
    private WebElement BUS_TICKET_LINK_LOCATOR;

    @FindBy(xpath = "//li[contains(@class,'hotels')]/a")
    private WebElement HOTEL_LINK_LOCATOR;

    @FindBy(xpath = "//li[contains(@class,'insurance')]/a")
    private WebElement INSURANCE_LINK_LOCATOR;

    @FindBy(xpath = "//li[contains(@class,'transfer')]/a")
    private WebElement TRANSFER_LINK_LOCATOR;

    @FindBy(xpath = "//a[contains(@title,'View')]")
    private WebElement VIEW_MORE_LINK_LOCATOR;

    @FindBy(xpath = "//a[@class='do_login']")
    private WebElement MY_TICKET_LINK_LOCATOR;


    //select Travel point
    @FindBy(id = "oneway")
    private WebElement ONE_WAY_CHECKBOX_LOCATOR;

    @FindBy(id = "round_trip")
    private WebElement ROUND_TRIP_CHECKBOX_LOCATOR;

    @FindBy(id = "complex_flight")
    private WebElement COMPLEX_FLIGHT_CHECKBOX_LOCATOR;

    @FindBy(id = "from_name")
    private WebElement FROM_INPUT_LOCATOR;

    @FindBy(id = "to_name")
    private WebElement TO_INPUT_LOCATOR;

    @FindBy(id = "Class_Select")
    private WebElement CLASS_SELECTION_DROP_DAWN_LOCATOR;

    @FindBy(id = "departure_date")
    private WebElement DEPARTURE_FROM_DATE_SELECT_LOCATOR;

    @FindBy(xpath = "(//div[contains(.,'time_field')]//a[contains(@id,'Selector')])[1]")
    private WebElement DEPARTURE_DATE_FROM_EXACT_TIME_SELEC_LOCATOR;

    @FindBy(id = "departure_date1")
    private WebElement DEPARTURE_TO_DATE_SELECT_LOCATOR;

    @FindBy(xpath = "(//div[contains(.,'time_field')]//a[contains(@id,'Selector')])[2]")
    private WebElement DEPARTURE_DATE_TO_EXACT_TIME_SELEC_LOCATOR;

    @FindBy(xpath = "//input[@class='preson_quant']")
    private WebElement PERSON_QUANTITY_SELEC_LOCATOR;

    @FindBy(xpath = "//a[@class='search_button']")
    private By SEARCH_BUTON_LOCATOR;



    public HomePage(WebDriver driver) {

        if (!driver.getCurrentUrl().contains("tickets")) {
            throw new IllegalStateException("This is not the page you wanted");
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public HomePage getURL(){
        driver.get(url);
        return  new HomePage(driver);
    }

    public HomePage clickOnTickets() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_BUTON_LOCATOR));
        driver.findElement(SEARCH_BUTON_LOCATOR).click();

        return new HomePage(driver);
    }

}
