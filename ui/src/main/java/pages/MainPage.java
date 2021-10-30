package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy(css = "#register")
    private SelenideElement registerLink;

    public void clickOnRegisterLink(){
        registerLink.click();
    }
}
