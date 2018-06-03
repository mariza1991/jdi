package jdiLesson;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import jdiLesson.entities.User;
import jdiLesson.pages.HomePage;
import jdiLesson.pages.LoginForm;
import ru.yandex.qatools.allure.annotations.Step;

@JSite(value = "https://epam.github.io/JDI")
public class JDIExampleSite extends WebSite {

    public static HomePage homePage;

    public static LoginForm loginForm;

    @Css(".profile-photo")
    public static Label profilePhoto;

    @Step
    public static void login() {
        profilePhoto.click();
        loginForm.loginAs(new User());
    }
}
