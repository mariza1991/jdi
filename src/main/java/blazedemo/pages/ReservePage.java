package blazedemo.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.XPath;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/reserve.php")
public class ReservePage extends WebPage {

    @JTable(root = @FindBy(xpath = "//table[@class='table']"))
    Table table;

    private int randomRow = 0;

    public ReservePage checkOpenedPage(){
        this.checkOpened();
        return this;
    }

    public String chooseFlight()
    {
        return table.cell(2, randomRow).getText();
    //    System.out.println(fl);
    }

    public ReservePage getRandomNumber()
    {
        int randomOption = 1 + (int) (Math.random()*5);
        this.randomRow = randomOption;
        return this;
    }
}
