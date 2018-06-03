package blazedemo;

import org.testng.annotations.Test;

import static blazedemo.BlazeDemoSite.mainPage;
import static blazedemo.BlazeDemoSite.reservePage;

public class PurchaseTest extends BaseTest {

    private final static String from = "Boston";

    private final static String to = "Dublin";

    @Test
    public void test(){
        mainPage.open();
        mainPage.chooseFrom(from)
                .chooseTo(to)
                .submitFlight();

        reservePage.checkOpened();
        reservePage.chooseRandomRaw();
    }
}
