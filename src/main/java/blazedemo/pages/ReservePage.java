package blazedemo.pages;

import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/reserve.php")
public class ReservePage extends WebPage {

    @JTable(
            root = @FindBy(className = "table"),
            row = @FindBy(xpath = ".//tr[%s]"),
            cell = @FindBy(xpath = ".//tr[%s]/td[1]")
    )
    public Table optionsTable;

    public void chooseRandomRaw(){
        int randomOption = 1 + (int) (Math.random()*5);
        optionsTable.row(randomOption);
    //    optionsTable.cell()
    }
}
