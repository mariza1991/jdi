package blazedemo;

import blazedemo.pages.MainPage;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;

@JSite(value = "http://blazedemo.com/")
public class BlazeDemoSite extends WebSite {

    public static MainPage mainPage;
}
