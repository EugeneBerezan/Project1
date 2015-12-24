package Avis;

import PagesAvis.AvisProtectionAndCoveragePage;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class AvisTests extends AvisBaseTest {

    @Test
    public void newJerseyPremium() throws InterruptedException, SQLException {

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

    @Test
    public void newJerseyFullSize() throws InterruptedException, SQLException {

        String pickUpLocation = "30 West Mall Drive, Jersey City, New Jersey, United States-(JC3)";
        String returnLocation = pickUpLocation;
        String pickUpDate = "02.15.2016";
        String returnDate = "02.27.2016";
        String carClass = "Full size";


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


    @Test
    public void losAngelesPremium() throws InterruptedException, SQLException {

        String pickUpLocation = "Los Angeles Intl Airport, Los Angeles, California, United States-(LAX)";
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

    @Test
    public void losAngelesFullSize() throws InterruptedException, SQLException {

        String pickUpLocation = "Los Angeles Intl Airport, Los Angeles, California, United States-(LAX)";
        String returnLocation = pickUpLocation;
        String pickUpDate = "02.15.2016";
        String returnDate = "02.27.2016";
        String carClass = "Full size";


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
