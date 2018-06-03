package jdiLesson.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import jdiLesson.entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {

    @FindBy(id = "Name")
    public TextField login;

    @FindBy(id = "Password")
    public TextField password;

    @FindBy(css = "#login-form [type='submit']")
    public Button enter;
}