package blazedemo.components;

import blazedemo.data.UserDetails;
import com.epam.jdi.uitests.web.selenium.elements.common.Input;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import org.openqa.selenium.support.FindBy;

public class PurchaseForm extends Form<UserDetails> {

    @FindBy(id = "inputName")
    Input name;

    @FindBy(id = "address")
    Input address;

    @FindBy(id = "city")
    Input city;

    @FindBy(id = "state")
    Input state;

    @FindBy(id = "zipCode")
    Input zip;

    @FindBy(id = "creditCardNumber")
    Input cardNumber;

    @FindBy(id = "creditCardMonth")
    Input month;

    @FindBy(id = "creditCardYear")
    Input year;

    @JDropdown(root = @FindBy(css = "#cardType"), value = @FindBy(xpath = "./option[%s]"))
    Dropdown cardType;

    @FindBy(id = "nameOnCard")
    Input cardName;
}
