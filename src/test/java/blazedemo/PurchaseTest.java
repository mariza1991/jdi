package blazedemo;

import org.testng.annotations.Test;

import static blazedemo.BlazeDemoSite.mainPage;

public class PurchaseTest extends BaseTest {

    @Test
    public void test(){
        mainPage.open();
    }
}
