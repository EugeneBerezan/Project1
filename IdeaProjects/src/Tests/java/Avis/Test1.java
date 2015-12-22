package Avis;

import PagesAvis.AvisProtectionAndCoveragePage;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class Test1 extends AvisBaseTest {

    @Test
    public void test1() throws InterruptedException, SQLException {

        String pickUpLocation = "30 West Mall Drive, Jersey City, New Jersey, United States-(JC3)";
        String returnLocation = pickUpLocation;
        String pickUpDate = "02.15.2016";
        String returnDate = "02.27.2016";
        String carClass = "Premium";


        homePage.selectPickUpLocation(pickUpLocation)
                .selectPickUpDate(pickUpDate)
                .selectReturnDate(returnDate)
                .selectAge("25+")
                .selectResidenceOfCountry("Ukraine")
                .clickOnSelectMyCarButton()
                .selectCarType(carClass)
                .selectPersonalAccidentInsuranceCheckbox()
                .selectPersonalEffectsProtectionCheckbox();

        dataBase.insesrtAvisRentalsInforIntoTable(pickUpDate, returnDate, pickUpLocation, returnLocation, carClass, new AvisProtectionAndCoveragePage().getTotalPrice())
                .getSelectFromAvisRentals();

    }
}
