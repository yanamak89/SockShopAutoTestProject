package modals;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class RegisterModal {
    @FindBy(css = "#register-username-modal")
    private SelenideElement usernameField;

    @FindBy(css = "#register-first-modal")
    private SelenideElement firstNameField;

    @FindBy(css = "#register-last-modal")
    private SelenideElement lastNameField;

    @FindBy(css = "#register-email-modal")
    private SelenideElement emailField;

    @FindBy(css = "#register-password-modal")
    private SelenideElement passwordField;

    @FindBy(css = "#register-modal > div > div > div.modal-body > form > p > button")
    private SelenideElement registerButton;

    public void fillAllFieldAndClickRegisterButton(String username, String firstname, String lastname, String email,
                                                   String password){
        usernameField.setValue(username);
        firstNameField.setValue(firstname);
        lastNameField.setValue(lastname);
        emailField.setValue(email);
        passwordField.setValue(password);
        registerButton.click();

    }
}
