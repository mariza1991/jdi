package utils;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class WebDriverHelper {

    private static WebDriver driver;

    private static final String PROXY = "37.17.38.196:53281";

    public static WebDriver createChromeWithProxy(){
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(PROXY);

        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PROXY, proxy);
        driver = new ChromeDriver(options);
        return driver;
    }
}
