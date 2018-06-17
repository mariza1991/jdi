package blazedemo.pages;

import blazedemo.data.FlightDetails;
import blazedemo.data.UserDetails;
import blazedemo.helpers.ExpectedResultHelper;
import com.codeborne.selenide.Condition;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@JPage(url = "/confirmation.php")
public class ConfirmationPage extends WebPage {

    @FindBy(xpath = "//h1")
    public IText header;

    @FindBy(xpath = "//table//tr[1]/td[2]")
    public IText id;

    @FindBy(xpath = "//table//tr[2]/td[2]")
    public IText status;

    @FindBy(xpath = "//table//tr[3]/td[2]")
    public IText amount;

    @FindBy(xpath = "//table//tr[4]/td[2]")
    public IText actualCardNumber;

    @FindBy(xpath = "//table//tr[5]/td[2]")
    public IText actualExpDate;

    public ConfirmationPage checkOpenedPage()
    {
        this.checkOpened();
        return this;
    }

    public ConfirmationPage checkHeader()
    {
        assertEquals("Thank you for your purchase today!", header.getText());
        return this;
    }

    public void checkConfirmationDetails()
    {
        assertTrue(id.isDisplayed());
        assertTrue(status.isDisplayed());
        assertEquals("USD", amount.getText());
        assertEquals(this.expectedCardNumber(), actualCardNumber.getText());
        assertEquals(this.expectedExpDate(), actualExpDate.getText());
    }

    private String expectedCardNumber()
    {
        UserDetails userInfo = new UserDetails();
        return ExpectedResultHelper.getCardNumber(userInfo.cardNumber);
    }

    private String expectedExpDate()
    {
        UserDetails userInfo = new UserDetails();
        return userInfo.month + " /" + userInfo.year;
    }
}
