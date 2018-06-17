package blazedemo.pages;

import blazedemo.data.FlightDetails;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.XPath;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

@JPage(url = "/reserve.php")
public class ReservePage extends WebPage {

    @JTable(
            root = @FindBy(css = ".table"),
            row = @FindBy(xpath = ".//tr[%s]//td"),
            column = @FindBy(xpath = ".//tr//td[%s]"),
            header = {"Choose", "FlightNum", "Airline", "Departs", "Arrives", "Price"})
    Table table;

    @FindBy(xpath = "//h3")
    public IText header;

    private int randomRow = 0;

    public ReservePage checkOpenedPage()
    {
        this.checkOpened();
        return this;
    }

    public ReservePage checkHeader(String from, String to)
    {
        assertEquals("Flights from " + from + " to " + to + ":", header. getText());
        return this;
    }

    public void chooseFlight()
    {
        FlightDetails.flightNumber = table.cell(2, randomRow).getText();
        FlightDetails.airline = table.cell(3, randomRow).getText();
        String price = table.cell(6, randomRow).getText();
        FlightDetails.price = price.substring(1, price.length());
        table.cell(1, randomRow).click();
    }

    public ReservePage getRandomNumber()
    {
        int randomOption = 1 + (int) (Math.random()*5);
        this.randomRow = randomOption;
        return this;
    }
}
