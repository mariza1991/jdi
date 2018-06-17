package blazedemo.pages;

import blazedemo.components.PurchaseForm;
import blazedemo.data.FlightDetails;
import blazedemo.data.UserDetails;
import blazedemo.helpers.ExpectedResultHelper;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

@JPage(url = "/purchase.php")
public class PurchasePage extends WebPage {

    @FindBy(xpath = "//h2")
    public IText header;

    @FindBy( xpath = "//h2/following-sibling::p[1]")
    Label actualAirline;

    @FindBy( xpath = "//h2/following-sibling::p[2]")
    Label actualFlightNumber;

    @FindBy( xpath = "//h2/following-sibling::p[3]")
    Label actualPrice;

    @FindBy( xpath = "//h2/following-sibling::p[4]")
    Label actualFee;

    @FindBy( xpath = "//h2/following-sibling::p[5]")
    Label totalPrice;

    @FindBy()
    public PurchaseForm purchaseForm;

    @FindBy(css = ".btn.btn-primary")
    Button submitButton;

    public PurchasePage checkOpenedPage()
    {
        this.checkOpened();
        return this;
    }

    public PurchasePage checkHeader(String from, String to)
    {
        assertEquals("Your flight from " + from + " to " + to + " has been reserved.", header. getText());
        return this;
    }

    public PurchasePage checkTotalPrice()
    {
        double totalActualPrice = Double.parseDouble(ExpectedResultHelper.getPrice(actualPrice.getText()))
                + Double.parseDouble(ExpectedResultHelper.getPrice(actualFee.getText()));
        double totalExpectedPrice = Double.parseDouble(ExpectedResultHelper.getPrice(totalPrice.getText()));
        assertEquals(totalExpectedPrice, totalActualPrice, 0);
        return this;
    }

    public PurchasePage checkReserveDetails()
    {
        assertEquals("Airline: " + FlightDetails.airline, actualAirline.getText());
        assertEquals("Flight Number: " + FlightDetails.flightNumber, actualFlightNumber.getText());
        assertEquals("Price: " + FlightDetails.price, actualPrice.getText());
        return this;
    }

    public void sendForm()
    {
        UserDetails user = new UserDetails();
        purchaseForm.fill(user);
        submitButton.click();
    }

}
