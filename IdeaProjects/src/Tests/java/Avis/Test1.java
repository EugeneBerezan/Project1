package Avis;

import org.testng.annotations.Test;

public class Test1 extends AvisBaseTest {

    @Test
    public void test1(){

        String pickUpLocation = "30 West Mall Drive, Jersey City, New Jersey, United States-(JC3)";
        String pickUpDate = "02.15.2016";
        String returnDate = "02.27.2016";


        homePage.selectPickUpLocation(pickUpLocation)
                .selectPickUpDate(pickUpDate)
                .selectReturnDate(returnDate)
                .selectAge("25+")
                .selectResidenceOfCountry("Ukraine")
                .clickOnSelectMyCarButton();


    }
}
