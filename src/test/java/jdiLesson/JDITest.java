package jdiLesson;

import org.testng.annotations.Test;

import static jdiLesson.JDIExampleSite.homePage;
import static jdiLesson.JDIExampleSite.login;

public class JDITest extends BaseTest {

    @Test
    public void loginTest(){
        homePage.open();
        login();
        homePage.checkOpened();
    }
}
