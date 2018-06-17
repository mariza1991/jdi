package blazedemo;

import org.testng.annotations.Test;

import static blazedemo.BlazeDemoSite.*;

public class PurchaseTest extends BaseTest {

    private final static String from = "Boston";

    private final static String to = "Dublin";

    @Test
    public void test(){

        mainPage.open();
        mainPage.chooseFrom(from)
                .chooseTo(to)
                .submitFlight();

        reservePage
                .checkOpenedPage()
                .checkHeader(from, to)
                .getRandomNumber()
                .chooseFlight();

        purchasePage
                .checkOpenedPage()
                .checkHeader(from, to)
                .checkTotalPrice()
                .checkReserveDetails()
                .sendForm();

        confirmationPage
                .checkOpenedPage()
                .checkHeader()
                .checkConfirmationDetails();
    }
}
