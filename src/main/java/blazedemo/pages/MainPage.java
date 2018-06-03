package blazedemo.pages;

import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

@JPage(url = "")
public class MainPage extends WebPage {

    @JDropdown(
            root = @FindBy(name = "fromPort")
    )
    public Dropdown departure;

    @JDropdown(
            root = @FindBy(name = "toPort")
    )
    public Dropdown destination;

    @FindBy(className = "btn btn-primary")
    public Button submit;

    public MainPage chooseFrom(String from){
        departure.select(from);
        return this;
    }

    public MainPage chooseTo(String to) {
        destination.select(to);
        return this;
    }

    public void submitFlight(){
        submit.click();
    }
}
