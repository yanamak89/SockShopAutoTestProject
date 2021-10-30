package registerTests;

import modals.RegisterModal;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RegisterNewUserTest {

    private MainPage mainPage;
    private RegisterModal registerModal;

    @BeforeMethod
    public void beforeMetod() {
        open("http://localhost/");
        mainPage = page(MainPage.class);
        registerModal = page(RegisterModal.class);
    }

    @Test
    public void registerNewUserPositiveTest() {
        mainPage.clickOnRegisterLink();
        registerModal.fillAllFieldAndClickRegisterButton("test", "test", "test",
                "test@test.com", "12345");

    }
}
