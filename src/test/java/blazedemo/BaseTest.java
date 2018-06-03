package blazedemo;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.WebDriverHelper;

public class BaseTest extends TestNGBase {

    @BeforeSuite
    public static void setUp(){
    //    WebDriver driver = WebDriverHelper.createChromeWithProxy();

        WebSite.init(BlazeDemoSite.class);
    }

}
